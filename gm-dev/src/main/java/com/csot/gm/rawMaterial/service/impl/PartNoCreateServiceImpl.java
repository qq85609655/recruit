package com.csot.gm.rawMaterial.service.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.extension.gmMissingFlowNo.GmMissingFlowNoExtMapper;
import com.csot.gm.materialManage.dao.extension.gmPartDescRule.GmPartDescRuleExtMapper;
import com.csot.gm.materialManage.dao.extension.gmPartDescRuleMap.GmPartDescRuleMapExtMapper;
import com.csot.gm.materialManage.dao.extension.gmPartNoPrecode.GmPartNoPrecodeExtMapper;
import com.csot.gm.materialManage.dao.extension.gmPartNoRuleMap.GmPartNoRuleMapExtMapper;
import com.csot.gm.materialManage.dao.extension.partNoRule.PartNoRuleExtMapper;
import com.csot.gm.materialManage.dao.original.flowNo.FlowNoMapper;
import com.csot.gm.materialManage.dao.original.gmMissingFlowNo.GmMissingFlowNoMapper;
import com.csot.gm.materialManage.model.extension.gmPartDescRule.GmPartDescRuleExt;
import com.csot.gm.materialManage.model.extension.gmPartDescRuleMap.GmPartDescRuleMapExt;
import com.csot.gm.materialManage.model.extension.gmPartNoPrecode.GmPartNoPrecodeExt;
import com.csot.gm.materialManage.model.extension.partNoRule.PartNoRuleExt;
import com.csot.gm.materialManage.model.original.flowNo.FlowNo;
import com.csot.gm.materialManage.model.original.gmMissingFlowNo.GmMissingFlowNo;
import com.csot.gm.materialManage.model.original.gmPartNoRuleMap.GmPartNoRuleMap;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;
import com.csot.gm.rawMaterial.model.CreationProInfo;
import com.csot.gm.rawMaterial.model.CreationRtn;
import com.csot.gm.rawMaterial.service.PartNoCreateService;

@Service("PartNoCreateService")
public class PartNoCreateServiceImpl implements PartNoCreateService {

  private static final Logger logger = LoggerFactory.getLogger(PartNoCreateServiceImpl.class);

  @Resource
  private PartNoRuleExtMapper partNoRuleExtMapper;
  @Resource
  private FlowNoMapper flowNoMapper;
  @Resource
  private GmPartNoPrecodeExtMapper gmPartNoPrecodeExtMapper;
  @Resource
  private GmPartNoRuleMapExtMapper gmPartNoRuleMapExtMapper;
  @Resource
  private GmPartDescRuleExtMapper gmPartDescRuleExtMapper;
  @Resource
  private GmPartDescRuleMapExtMapper gmPartDescRuleMapExtMapper;
  @Resource
  private PartPropertiesService partPropertiesService;
  @Resource
  private GmMissingFlowNoExtMapper gmMissingFlowNoExtMapper;
  @Resource
  private GmMissingFlowNoMapper gmMissingFlowNoMapper;

  @Override
  public CreationRtn createPartNoAndDesc(CreationProInfo cpi) {
    CreationRtn rtn = new CreationRtn();
    int flowF = 0;

    Map<String, String[]> properties = cpi.getProperties();
    if (properties == null || properties.size() < 1) {
      rtn.setSuccess(false);
      rtn.setMessage("属性Map为空");
      logger.info("属性Map为空");
      return rtn;
    }

    Iterator<String> itor = properties.keySet().iterator();
    logger.info("ClassName:" + cpi.getClassName());
    while (itor.hasNext()) {
      String key = itor.next();
      String[] values = properties.get(key);
      logger.info("propertyName:" + key);
      for (String value : values) {
        logger.info("value:" + value);

      }
    }

    String[] bigClassCode = properties.get("bigClassId");
    if (bigClassCode == null || bigClassCode.length < 1) {
      rtn.setSuccess(false);
      rtn.setMessage("未找到大分类代码");
      logger.info("未找到大分类代码");
      return rtn;
    } else {
      logger.info("preCode:" + bigClassCode[0]);
    }

    String preCode = getPartNoPreCode(bigClassCode[0], properties);
    // 31602编码规则更新;不再follow31编码原则-update by xyc 2017/7/17
    if ("31602".equals(cpi.getPreCode())) {
      preCode = "31602";
    }
    if (null == preCode || "".equals(preCode.trim())) {
      rtn.setSuccess(false);
      rtn.setMessage("未找到前缀代码规则或属性值检查不通过");
      logger.info("未找到前缀代码规则或属性值检查不通过");
      return rtn;
    }

    List<GmPartNoRuleMap> mapList = gmPartNoRuleMapExtMapper.selectByKeyCode(preCode);
    if (mapList.isEmpty()) {
      rtn.setSuccess(false);
      rtn.setMessage("未找到生成规则");
      logger.info("未找到生成规则");
      return rtn;
    } else if (mapList.size() != 1) {
      rtn.setSuccess(false);
      rtn.setMessage("找到多条生成规则");
      logger.info("找到多条生成规则");
      return rtn;
    }
    String ruleCode = mapList.get(0).getRuleMapCode();
    String flowFlag = mapList.get(0).getRuleMapFlownoFlag();
    if (null != flowFlag && "1".equals(flowFlag.trim())) {
      flowF = 1;
    }
    logger.info("==============全匹配流水标识===========" + flowF);

    List<PartNoRuleExt> list = partNoRuleExtMapper.selectByKeyCode(ruleCode);
    if (list.isEmpty()) {
      rtn.setSuccess(false);
      rtn.setMessage("未找到生成规则");
      logger.info("未找到生成规则");
      return rtn;
    }

    for (int i = 0; i < list.size(); i++) {
      String propertyName = list.get(i).getRulePropertyName();
      BigDecimal startStr = list.get(i).getRuleNumStartIndex();
      BigDecimal endStr = list.get(i).getRuleNumEndIndex();
      if (null == propertyName
          || "".equals(propertyName.trim())
          || properties.get(propertyName) == null
          /* (startStr.intValue() != keyCode.length() + 1 ) || */
          || properties.get(propertyName).length < 1
          || ((endStr.intValue() - startStr.intValue()) + 1 != properties.get(propertyName)[0]
              .length())) {

        logger.info(propertyName + "：属性值与规则不匹配");
        logger.info("属性值:" + properties.get(propertyName)[0]);
        logger.info("startStr:" + startStr.intValue());
        logger.info("endStr:" + endStr.intValue());
        rtn.setSuccess(false);
        rtn.setMessage("属性值与规则不匹配");
        logger.info("属性值与规则不匹配");
        return rtn;
      }
    }
    // flow_Flag :0代表按照顺序组合属性取流水，1代表属性全匹配后，再获取流水
    String keyCode = "";
    String flowNoId = "";
    for (int i = 0; i < list.size(); i++) {
      String propertyName = list.get(i).getRulePropertyName();
      if (propertyName.startsWith("flowNoId") && flowF == 0) {
        if (properties.get(propertyName) != null
            && properties.get(propertyName).length > 0
            && properties.get(propertyName)[0] != null
            && !"".equals(properties.get(propertyName)[0].trim())
            && !(properties.get(propertyName)[0].trim().contains("X") || properties
                .get(propertyName)[0].trim().contains("x"))) {
          keyCode = keyCode + properties.get(propertyName)[0];
        } else {
          String flowNo = "";
          flowNo = searchMissingFlowNo(keyCode);
          if (flowNo == null || "".equals(flowNo)) {
            flowNo = searchFlowNo(keyCode);
            if (flowNo == null || "".equals(flowNo.trim())) {
              int flowInt = 1;
              String format = "%0" + properties.get(propertyName)[0].length() + "d";
              flowNo = String.format(format, flowInt);


              FlowNo flowNoCom = new FlowNo();
              flowNoCom.setPartNum(keyCode);
              flowNoCom.setPartFlowNum(flowNo);
              flowNoMapper.insert(flowNoCom);
            } else {

              if ("".equals(flowNo.trim())) {
                int flowInt = 1;
                String format = "%0" + properties.get(propertyName)[0].length() + "d";
                flowNo = String.format(format, flowInt);
              } else {
                flowNo = updateFlowNo(flowNo);
              }
              FlowNo flowNoCom = flowNoMapper.selectByPrimaryKey(keyCode);
              flowNoCom.setPartFlowNum(flowNo);
              flowNoMapper.updateByPrimaryKey(flowNoCom);

            }
            keyCode = keyCode + flowNo;
          } else {
            keyCode = keyCode + flowNo;
          }

        }

      } else {
        if (propertyName.startsWith("flowNoId")) {
          flowNoId = propertyName;
        }
        keyCode = keyCode + properties.get(propertyName)[0];
      }
    }

    if (!"".equals(flowNoId)) {
      logger.info("==============进入全匹配模式生成流水号===========");
      if (properties.get(flowNoId) != null
          && properties.get(flowNoId).length > 0
          && properties.get(flowNoId)[0] != null
          && !"".equals(properties.get(flowNoId)[0].trim())
          && !(properties.get(flowNoId)[0].trim().contains("X") || properties.get(flowNoId)[0]
              .trim().contains("x"))) {
        logger.info("流水已选择。");
      } else {
        String flowNo = "";
        flowNo = searchMissingFlowNo(keyCode);
        if (flowNo == null || "".equals(flowNo)) {
          flowNo = searchFlowNo(keyCode);
          if (flowNo == null || "".equals(flowNo.trim())) {
            int flowInt = 1;
            String format = "%0" + properties.get(flowNoId)[0].length() + "d";
            flowNo = String.format(format, flowInt);


            FlowNo flowNoCom = new FlowNo();
            flowNoCom.setPartNum(keyCode);
            flowNoCom.setPartFlowNum(flowNo);
            flowNoMapper.insert(flowNoCom);
          } else {

            if ("".equals(flowNo.trim())) {
              int flowInt = 1;
              String format = "%0" + properties.get(flowNoId)[0].length() + "d";
              flowNo = String.format(format, flowInt);
            } else {
              flowNo = updateFlowNo(flowNo);
            }
            FlowNo flowNoCom = flowNoMapper.selectByPrimaryKey(keyCode);
            flowNoCom.setPartFlowNum(flowNo);
            flowNoMapper.updateByPrimaryKey(flowNoCom);

          }
          if (keyCode.contains("x")) {
            keyCode =
                keyCode.substring(0, keyCode.indexOf("x")) + flowNo
                    + keyCode.substring(keyCode.lastIndexOf("x") + 1, keyCode.length());
          } else if (keyCode.contains("X")) {
            keyCode =
                keyCode.substring(0, keyCode.indexOf("X")) + flowNo
                    + keyCode.substring(keyCode.lastIndexOf("X") + 1, keyCode.length());
          }
        } else {
          if (keyCode.contains("x")) {
            keyCode =
                keyCode.substring(0, keyCode.indexOf("x")) + flowNo
                    + keyCode.substring(keyCode.lastIndexOf("x") + 1, keyCode.length());
          } else if (keyCode.contains("X")) {
            keyCode =
                keyCode.substring(0, keyCode.indexOf("X")) + flowNo
                    + keyCode.substring(keyCode.lastIndexOf("X") + 1, keyCode.length());
          }
        }

      }
    }

    if (keyCode.length() != 14) {
      rtn.setSuccess(false);
      rtn.setMessage("生成的料号位数不正确，请检查规则");
      return rtn;
    }

    String[] desc = new String[] {"", ""};
    if (!cpi.isMessCreate()) {
      desc = getPartDesc(cpi.getPreCode(), properties, cpi);
      if (desc[0] == null) {
        rtn.setSuccess(false);
        rtn.setMessage("找到多条描述生成规则");
        logger.info("找到多条描述生成规则");
        return rtn;
      }

      logger.info("生成名称:" + desc[0]);
      logger.info("生成中文描述:" + desc[0]);
      logger.info("生成英文描述:" + desc[1]);
    }

    logger.info("生成成功");
    logger.info("生成料号:" + keyCode);
    rtn.setSuccess(true);
    rtn.setMessage("生成成功");
    rtn.setPartNo(keyCode);
    rtn.setPartName(desc[0]);
    rtn.setCnDesc(desc[0]);
    rtn.setEnDesc(desc[1]);

    return rtn;
  }

  private String[]
      getPartDesc(String preCode, Map<String, String[]> properties, CreationProInfo cpi) {
    logger.info("小分类代码：" + preCode);
    StringBuilder descCn = new StringBuilder();
    StringBuilder descEn = new StringBuilder();
    List<GmPartDescRuleMapExt> listMap = gmPartDescRuleMapExtMapper.selectByKeyCode(preCode);
    if (listMap != null && listMap.size() > 1) {
      return new String[] {null};
    }
    if (listMap == null || listMap.size() != 1) {
      return new String[] {"", ""};
    }

    GmPartDescRuleMapExt gmPartDescRuleMapExt = listMap.get(0);
    String mapCode = gmPartDescRuleMapExt.getRuleMapCode();
    List<GmPartDescRuleExt> listRule = gmPartDescRuleExtMapper.selectByKeyCode(mapCode);
    if (!listRule.isEmpty()) {
      for (int i = 0; i < listRule.size(); i++) {
        GmPartDescRuleExt rule = listRule.get(i);
        String symbol = rule.getConnectSymbol();
        String propertyName = rule.getRulePropertyName();
        if (properties.get(propertyName) != null && properties.get(propertyName).length > 1) {
          String desc = properties.get(propertyName)[1];
          if (desc.contains(":")) {
            desc = desc.substring(desc.indexOf(":") + 1, desc.length());
          } else if (desc.contains("：")) {
            desc = desc.substring(desc.indexOf("：") + 1, desc.length());
          }
          if (desc != null) {
            desc = desc.trim();
          }
          boolean isNum = false;
          try {
            Double.valueOf(desc);
            isNum = true;
          } catch (Exception e) {
            isNum = false;
            logger.error(e.getMessage(), e);
          }
          // 去小数点后零
          if (isNum && desc.contains(".")) {
            desc = new BigDecimal(desc).stripTrailingZeros().toPlainString();
          }
          String queryName = "";
          if (propertyName != null && propertyName.length() > 1) {
            queryName = propertyName.substring(0, propertyName.length() - 2);
          }
          String unit = partPropertiesService.getProUnit(cpi.getPartId(), queryName);
          logger.info(queryName + " 单位: " + unit);
          if (unit != null && !"".equals(unit.trim()) && !"null".equals(unit.trim())
              && !"Null".equals(unit.trim())) {
            desc = desc + unit;
          }

          if (desc != null && !"".equals(desc.trim()) && !"NA".equals(desc.trim())) {
            if (descCn.length() != 0) {
              descCn.append(symbol);
            }
            if (descEn.length() != 0) {
              descEn.append(symbol);
            }
            descCn.append(desc.trim());
            descEn.append(desc.trim());

          }
        }
      }
    }

    return new String[] {descCn.toString(), descEn.toString()};
  }

  /**
   * @param pagePreCode1 大分类代码
   * @param properties 属性Map
   * 
   */
  @Override
  public String getPartNoPreCode(String pagePreCode1, Map<String, String[]> properties) {
    logger.info(pagePreCode1);
    String pagePreCode = pagePreCode1;
    List<GmPartNoPrecodeExt> list = gmPartNoPrecodeExtMapper.selectByKeyCode(pagePreCode);
    if (list.isEmpty()) {
      logger.info("pagePreCode:" + pagePreCode);
      logger.info("没找到规则,使用大分类代码作为前缀");
      return pagePreCode;
    }

    GmPartNoPrecodeExt ext = list.get(list.size() - 1);
    BigDecimal end = ext.getPropertyEnd();
    if (end.intValue() >= 14) {
      return pagePreCode;
    }

    // 检查接受的属性值长度是否符合规则定义的长度
    for (int i = 0; i < list.size(); i++) {
      String propertyName = list.get(i).getPropertyName();
      BigDecimal startStr = list.get(i).getPropertyStart();
      BigDecimal endStr = list.get(i).getPropertyEnd();
      if (propertyName == null
          || "".equals(propertyName.trim())
          || (startStr.intValue() != (pagePreCode.length() + 1))
          || properties.get(propertyName) == null
          || (properties.get(propertyName).length < 1)
          || (((endStr.intValue() - startStr.intValue()) + 1) != properties.get(propertyName)[0]
              .length())) {

        logger.info(propertyName + "：属性长度不对应或Map中未找到");
        logger.info("属性值:" + properties.get(propertyName)[0]);
        logger.info("startStr:" + startStr.intValue());
        logger.info("endStr:" + endStr.intValue());
        return null;
      }
    }

    for (int i = 0; i < list.size(); i++) {
      String propertyName = list.get(i).getPropertyName();
      BigDecimal startStr = list.get(i).getPropertyStart();
      BigDecimal endStr = list.get(i).getPropertyEnd();
      if (propertyName == null
          || "".equals(propertyName.trim())
          || (startStr.intValue() != pagePreCode.length() + 1)
          || properties.get(propertyName) == null
          || properties.get(propertyName).length < 1
          || ((endStr.intValue() - startStr.intValue()) + 1 != properties.get(propertyName)[0]
              .length())) {
        return null;
      }
      pagePreCode = pagePreCode + properties.get(propertyName)[0];
    }
    return pagePreCode;

  }

  private String updateFlowNo(String flowNo) {
    char[] chars = flowNo.toCharArray();
    for (int i = chars.length - 1; i > -1; i--) {
      char cha = chars[i];
      if (cha == '9') {
        chars[i] = 'A';
        return String.valueOf(chars);
      } else if (cha == 'Z') {
        chars[i] = '0';
        continue;
      } else {
        chars[i]++;
        if (chars[i] == 'O' || chars[i] == 'I' || chars[i] == 'X' || chars[i] == 'E') {
          chars[i]++;
        }
        return String.valueOf(chars);
      }
    }
    return null;
  }

  public String searchMissingFlowNo(String keyCode) {
    List<GmMissingFlowNo> flowObjs = gmMissingFlowNoExtMapper.selectByKeyCode(keyCode);
    if (!flowObjs.isEmpty()) {
      GmMissingFlowNo flowObj = flowObjs.get(0);
      String id = flowObj.getId();
      String flowNo = flowObj.getPartFlowNum();
      gmMissingFlowNoMapper.deleteByPrimaryKey(id);
      return flowNo;
    }
    return null;

  }

  /**
   * 查询流水号
   * 
   * @param keyCode
   * @return
   */
  public String searchFlowNo(String keyCode) {
    FlowNo flowNo = flowNoMapper.selectByPrimaryKey(keyCode);
    if (flowNo == null) {
      return null;
    }
    return flowNo.getPartFlowNum();

  }

}