package com.csot.gm.rawMaterial.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.dao.original.propertyRtn.PropertyRtnMapper;
import com.csot.gm.materialManage.dao.original.propertyValue.PropertyValueMapper;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.model.original.propertyRtn.PropertyRtn;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.rawMaterial.model.CreationProInfo;
import com.csot.gm.rawMaterial.model.PartNoInfo;
import com.csot.gm.rawMaterial.service.PartSaveService;

@Service("PartSaveService")
public class PartSaveServiceImpl implements PartSaveService {
  private static final Logger logger = LoggerFactory.getLogger(PartSaveServiceImpl.class);
  @Resource
  private PartNoMapper partNoMapper;
  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PropertyValueMapper propertyValueMapper;
  @Resource
  private PropertyRtnMapper propertyRtnMapper;

  /**
   * 将生成的料号和相关信息保存到数据库
   * 
   * @throws Exception
   */
  @Override
  @Transactional
  public void savePartNoAndProperty(PartNoInfo partNoInfo, CreationProInfo cpi) {

    // 保存料号
    PartNo partNo = new PartNo();
    partNo.setId(partNoInfo.getId());
    partNo.setPartNo(partNoInfo.getPartNo());
    partNo.setPartName(partNoInfo.getPartName());
    partNo.setPartType(partNoInfo.getPartType());
    partNo.setCnDesc(partNoInfo.getCnDesc());
    partNo.setEnDesc(partNoInfo.getEnDesc());
    partNo.setCreateCode(partNoInfo.getCreateCode());
    partNo.setCreateTime(partNoInfo.getCreateTime());
    partNo.setPartNoStatus(partNoInfo.getPartNoStatus());
    partNo.setPartId(partNoInfo.getPartId());
    partNo.setHashCode(partNoInfo.getHashCode());
    partNo.setPartNoUid(partNoInfo.getUid());
    logger.info("5+uid：" + partNoInfo.getUid());
    partNo.setCreateName(partNoInfo.getCreateName());
    partNo.setPlant(partNoInfo.getPlant());
    partNo.setDepartment(partNoInfo.getDepartment());
    partNo.setTelephone(partNoInfo.getTelephone());
    partNoMapper.insert(partNo);

    // 保存物料属性值
    List<PropertyValue> list = partNoInfo.getProperties();
    if (list != null && !list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        propertyValueMapper.insert(list.get(i));
      }
    } else {
      logger.error("保存的料号的属性值为空");
    }

    // 将属性存入回传给PLM属性的临时表
    Map<String, String[]> propsMap = cpi.getProperties();
    if (!propsMap.isEmpty()) {
      for (Map.Entry<String, String[]> tempM : propsMap.entrySet()) {
        PropertyRtn pr = new PropertyRtn();
        pr.setCreateUid(partNoInfo.getUid());
        pr.setPropertyName(tempM.getKey());
        pr.setPropertyValue(tempM.getValue()[0]);
        pr.setPropertyText(tempM.getValue()[1]);
        pr.setId(UUID.randomUUID().toString().replace("-", ""));
        propertyRtnMapper.insert(pr);
      }
    }
  }

  /**
   * 更新料号状态
   */
  @Override
  public boolean updatePartNoStatus(List<PartNo> list) {
    List<PartNo> updateList = new ArrayList<PartNo>(); // 检查完毕可更新的数据
    if (list != null && !list.isEmpty()) {
      logger.info("PartNos:" + list.size());
      for (int i = 0; i < list.size(); i++) {
        PartNo pn = list.get(i);
        String partNo = pn.getPartNo();
        if (null != partNo && !"".equals(partNo)) {
          // 找出要更新的数据
          List<PartNoExt> list2 = partNoExtMapper.selectPartNoListByPartNo(partNo);
          if (list2.size() != 1) {
            logger.error(partNo + "有相同料号的多条数据：" + list2.size());
            return false;
          } else {
            pn.setId(list2.get(0).getId());
            updateList.add(pn);
          }
        }
      }
      if (list.size() == updateList.size()) {
        for (int i = 0; i < updateList.size(); i++) {
          partNoMapper.updateByPrimaryKeySelective(updateList.get(i));
          logger.info("partNo:" + updateList.get(i).getPartNo() + ",Status:"
              + updateList.get(i).getPartNoStatus());
        }
        logger.info("数据更新完成");
        return true;
      } else {
        logger.error("不是所有数据都可更新");
        return false;
      }
    } else {
      logger.error("无可更新数据");
      return false;
    }
  }
}
