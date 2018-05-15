package com.csot.gm.rawMaterial.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.extension.enumValue.EnumValueExtMapper;
import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.extension.properties.PartPropertiesExtMapper;
import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExt;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.extension.propertyValue.PropertyValueExt;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.materialManage.model.original.wxmap.WXMap;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;
import com.csot.gm.materialManage.service.wxmap.WXMapService;
import com.csot.gm.rawMaterial.model.CreationProInfo;
import com.csot.gm.rawMaterial.model.CreationRtn;
import com.csot.gm.rawMaterial.model.MassCreateResult;
import com.csot.gm.rawMaterial.model.PageRtn;
import com.csot.gm.rawMaterial.model.PartNoInfo;
import com.csot.gm.rawMaterial.model.UniqueProperty;
import com.csot.gm.rawMaterial.service.CheckProAndCreateService;
import com.csot.gm.rawMaterial.service.ComparePropertyService;
import com.csot.gm.rawMaterial.service.PartNoAddService;
import com.csot.gm.rawMaterial.service.PartNoCreateService;
import com.csot.gm.rawMaterial.service.PartSaveService;
import com.csot.gm.rawMaterial.service.TranslateObjectService;
import com.csot.gm.util.ModelSequence;
import com.csot.gm.util.PropertyName;
import com.csot.gm.util.Status;

@Service("CheckProAndCreateServiceImpl")
public class CheckProAndCreateServiceImpl implements CheckProAndCreateService {

  private static final String MAINTAIN = "C4_WXLH";
  private static final String NA_ALL = "NA不限";
  private static final String NA_X = "NA未知";

  @Resource
  private PartSaveService partSaveService;
  @Resource
  private TranslateObjectService translateObjectService;
  @Resource
  private ComparePropertyService comparePropertyService;
  @Resource
  private PartNoCreateService partNoCreateService;
  @Resource
  private WXMapService wxMapService;
  @Resource
  private PartNoService partNoService;
  @Resource
  private PartPropertiesService partPropertiesService;
  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PartNoMapper partNoMapper;
  @Resource
  private PartPropertiesExtMapper partPropertiesExtMapper;
  @Resource
  private PartNoAddService partNoAddService;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private EnumValueExtMapper enumValueExtMapper;
  @Resource
  private PropertyValueExtMapper propertyValueExtMapper;


  @Override
  public synchronized AjaxRtnJson checkProAndCreate(AjaxRtnJson ajax, PageRtn pageRtn) {

    String partId = pageRtn.getPartId();
    String partType = pageRtn.getPartType();
    String classId = pageRtn.getClassId();
    String preCode = pageRtn.getPreCode();
    // Map<propertyName + "Id",// propertyEnumValueId(下拉)/propertyValue(手key)>
    Map<String, String> properties = pageRtn.getProperties();

    // 拷贝出只做唯一性的属性
    UniqueProperty uniqueProperty =
        translateObjectService.translateRtnProMap2Unique(properties, partId);

    // 算出无序hashCode
    String hashCode = String.valueOf(uniqueProperty.hashCode());
    // 生成料号和物料描述的属性
    CreationProInfo cpi =
        translateObjectService.translateRtnProMap2CreationPro(properties, preCode, partId,
            partType, classId);

    // 如果是备品耗材料，且品牌为“NA不限”or“NA未知”两种值时，唯一性比对做特殊处理
    String brandValue = uniqueProperty.getUniqueProperty().get(PropertyName.SC_BRAND);
    String specValue = uniqueProperty.getUniqueProperty().get(PropertyName.SC_SPEC);
    if ((null != brandValue && null != specValue) && (brandValue.equals(NA_ALL) || brandValue.equals(NA_X))) {
      List<PropertyValueExt> propList =
          propertyValueExtMapper.selectPropertyValueByLikePropertyValue(specValue);
      if (propList.isEmpty()) {
        CreationRtn cr = partNoCreateService.createPartNoAndDesc(cpi);
        if (cr.isSuccess()) {
          // 可生成料号
          // 需要保存的料号信息
          PartNoInfo pni = translateObjectService.translateAll2SaveInfo(pageRtn, cr, hashCode);
          // 保存
          partSaveService.savePartNoAndProperty(pni, cpi);
          ajax.setAttribute("partNoId", pni.getId());
          ajax.setAttribute("success", Status.CAN_CREATE);

        } else {
          String message = cr.getMessage();
          ajax.setAttribute("success", Status.CANNOT_CREATE_TYPE);
          ajax.setAttribute("message", message);
        }
      } else {
        for (PropertyValueExt pv : propList) {
          String partNoId = pv.getPartNoId();
          List<PropertyValueExt> prvList =
              propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(partNoId,
                  PropertyName.SC_BRAND);
          if (!prvList.isEmpty()
              && (NA_ALL.equals(prvList.get(0).getPropertyValue()) || NA_X.equals(prvList.get(0)
                  .getPropertyValue()))) {
            PartNo pn = partNoMapper.selectByPrimaryKey(partNoId);
            ajax.setAttribute("partNoId", partNoId);
            ajax.setAttribute("success", Status.CANNOT_CREATE);
            ajax.setAttribute(
                "message",
                "料号：" + pn.getPartNo() + "已存在<br>" + "请联系：" + pn.getDepartment() + "/"
                    + pn.getCreateName() + "<br>" + "联系方式：" + pn.getTelephone() + "<br>");
            return ajax;
          }
        }
        CreationRtn cr = partNoCreateService.createPartNoAndDesc(cpi);
        if (cr.isSuccess()) {
          // 可生成料号
          // 需要保存的料号信息
          PartNoInfo pni = translateObjectService.translateAll2SaveInfo(pageRtn, cr, hashCode);
          // 保存
          partSaveService.savePartNoAndProperty(pni, cpi);
          ajax.setAttribute("partNoId", pni.getId());
          ajax.setAttribute("success", Status.CAN_CREATE);

        } else {
          String message = cr.getMessage();
          ajax.setAttribute("success", Status.CANNOT_CREATE_TYPE);
          ajax.setAttribute("message", message);
        }
      }

      // 正常唯一性检查
    } else {
      // hashCode检查
      List<PartNoExt> list = comparePropertyService.hashCodeIsExit(hashCode, partId);
      if (!list.isEmpty()) {
        // 继续将属性逐个检查
        PartNoExt pne = comparePropertyService.propertyIsExit(uniqueProperty, list);
        if (pne != null) {
          // 具有相同属性的料号已存在，不可生成料号
          String partNoId1 = pne.getId();
          String message = getCreateFailMsg(pne);
          ajax.setAttribute("partNoId", partNoId1);
          ajax.setAttribute("success", Status.CANNOT_CREATE);
          ajax.setAttribute("message", message);
        } else {
          CreationRtn cr = partNoCreateService.createPartNoAndDesc(cpi);

          if (cr.isSuccess()) {
            // 可生成料号
            // 需要保存的料号信息
            PartNoInfo pni = translateObjectService.translateAll2SaveInfo(pageRtn, cr, hashCode);
            // 保存
            partSaveService.savePartNoAndProperty(pni, cpi);
            ajax.setAttribute("partNoId", pni.getId());
            ajax.setAttribute("success", Status.CAN_CREATE);

          } else {
            String message = cr.getMessage();
            ajax.setAttribute("success", Status.CANNOT_CREATE_TYPE);
            ajax.setAttribute("message", message);
          }
        }
      } else {
        CreationRtn cr = partNoCreateService.createPartNoAndDesc(cpi);
        if (cr.isSuccess()) {
          // 可生成料号
          // 需要保存的料号信息
          PartNoInfo pni = translateObjectService.translateAll2SaveInfo(pageRtn, cr, hashCode);
          // 保存
          partSaveService.savePartNoAndProperty(pni, cpi);
          ajax.setAttribute("partNoId", pni.getId());
          ajax.setAttribute("success", Status.CAN_CREATE);

        } else {
          String message = cr.getMessage();
          ajax.setAttribute("success", Status.CANNOT_CREATE_TYPE);
          ajax.setAttribute("message", message);
        }
      }
    }
    return ajax;
  }

  /**
   * 根据已存在料号的状态获取创建失败信息
   * 
   * @param pne
   * @return
   */
  public String getCreateFailMsg(PartNoExt pne) {
    String message = "";
    String partNo = pne.getPartNo();
    String partNoStatus = pne.getPartNoStatus();
    String createName = pne.getCreateName();
    String tele = pne.getTelephone();
    String department = pne.getDepartment();

    if (Status.IS_CREATING.equals(partNoStatus)) {
      message =
          "料号：" + partNo + "正在生成中。。。<br>" + "请联系：" + department + "/" + createName + "<br>"
              + "联系方式：" + tele + "<br>";
    } else if (Status.IS_CREATED.equals(partNoStatus)) {
      message =
          "料号：" + partNo + "已经生成。<br>" + "请联系：" + department + "/" + createName + "<br>" + "联系方式："
              + tele + "<br>";
    } else if (Status.IS_PART_RELEASE.equals(partNoStatus)) {
      message =
          "料号：" + partNo + "已经生效。<br>" + "请联系：" + department + "/" + createName + "<br>" + "联系方式："
              + tele + "<br>";
    } else if (Status.IS_EOL.equals(partNoStatus)) {
      message = "料号：" + partNo + "已经冻结。<br>" + "请联系管理员处理。";
    } else if (Status.IS_ABANDON.equals(partNoStatus)) {
      message = "料号：" + partNo + "已经废弃。<br>" + "请联系管理员处理。";
    }
    return message;
  }

  /**
   * 检查维修料号是否可以生成
   */
  @Override
  public synchronized AjaxRtnJson checkMaintainAndCreate(AjaxRtnJson ajax, String oldNumberId,
      String wxlh, PageRtn pageRtn) {
    // 检查维修料号是否存在
    List<PartNoExt> partNoList = partNoExtMapper.selectPartNoListByPartNo(wxlh);
    if (partNoList.isEmpty()) {
      PartNo oldPartNo = partNoMapper.selectByPrimaryKey(oldNumberId);
      if (null != oldPartNo) {
        // 存入备品维修表
        WXMap wxMap = new WXMap();
        wxMap.setSpareCode(oldPartNo.getPartNo());
        wxMap.setWxCode(wxlh);
        wxMapService.create(wxMap);
        // 存入料号总表
        PartNo partNo = new PartNo();
        partNo.setPartNo(wxlh);
        partNo.setPartName(oldPartNo.getPartName());
        partNo.setPartType(MAINTAIN);
        partNo.setCnDesc(oldPartNo.getCnDesc());
        partNo.setEnDesc(oldPartNo.getEnDesc());
        partNo.setCreateCode(pageRtn.getUserInfo().getUserCode());
        partNo.setCreateTime(new Date());
        partNo.setPartNoStatus(Status.IS_CREATING);
        partNo.setPartId(pageRtn.getPartId());
        partNo.setHashCode(oldPartNo.getHashCode());
        partNo.setPartNoUid(pageRtn.getUid());
        partNo.setCreateName(pageRtn.getUserInfo().getUserName());
        partNo.setDepartment(pageRtn.getUserInfo().getDepartment());
        partNo.setTelephone(pageRtn.getUserInfo().getTelephone());
        partNoService.create(partNo);
        List<PartNoExt> wxPartNoList = partNoExtMapper.selectPartNoListByPartNo(wxlh);
        if (!wxPartNoList.isEmpty()) {
          ajax.setAttribute("partNoId", wxPartNoList.get(0).getId());
          ajax.setAttribute("success", Status.CAN_CREATE);
        } else {
          ajax.setAttribute("partNoId", "");
          ajax.setAttribute("success", Status.CANNOT_CREATE);
          ajax.setAttribute("message", "创建维修料号失败");
        }

      } else {
        ajax.setAttribute("partNoId", oldNumberId);
        ajax.setAttribute("success", Status.CANNOT_CREATE);
        ajax.setAttribute("message", "没有找到原料号");
      }
    } else {
      PartNoExt pn = partNoList.get(0);
      String partNoStatus = pn.getPartNoStatus();
      String partNo = wxlh;
      String department = pn.getDepartment();
      String createName = pn.getCreateName();
      String tele = pn.getTelephone();
      String partNoId1 = pn.getId();
      String message = "";
      if (Status.IS_CREATING.equals(partNoStatus)) {
        message =
            "料号：" + partNo + "正在生成中。。。<br>" + "请联系：" + department + "/" + createName + "<br>"
                + "联系方式：" + tele + "<br>";
      } else if (Status.IS_CREATED.equals(partNoStatus)) {
        message =
            "料号：" + partNo + "已经生成。<br>" + "请联系：" + department + "/" + createName + "<br>"
                + "联系方式：" + tele + "<br>";
      } else if (Status.IS_PART_RELEASE.equals(partNoStatus)) {
        message =
            "料号：" + partNo + "已经生效。<br>" + "请联系：" + department + "/" + createName + "<br>"
                + "联系方式：" + tele + "<br>";
      } else if (Status.IS_EOL.equals(partNoStatus)) {
        message = "料号：" + partNo + "已经冻结。<br>" + "请联系管理员处理。";
      } else if (Status.IS_ABANDON.equals(partNoStatus)) {
        message = "料号：" + partNo + "已经废弃。<br>" + "请联系管理员处理。";
      }
      ajax.setAttribute("partNoId", partNoId1);
      ajax.setAttribute("success", Status.CANNOT_CREATE);
      ajax.setAttribute("message", message);
    }
    return ajax;
  }


  /**
   * 72耗材类料号创建暂不做唯一性检查，直接生成料号
   */
  @Override
  public AjaxRtnJson createConsumptive72(AjaxRtnJson ajax, PageRtn pageRtn) {
    String partId = pageRtn.getPartId();
    String partType = pageRtn.getPartType();
    String classId = pageRtn.getClassId();
    String preCode = pageRtn.getPreCode();
    // Map<propertyName + "Id",propertyEnumValueId(下拉)/propertyValue(手key)>
    Map<String, String> properties = pageRtn.getProperties();

    // 生成料号和物料描述的属性
    CreationProInfo cpi =
        translateObjectService.translateRtnProMap2CreationPro(properties, preCode, partId,
            partType, classId);

    CreationRtn cr = partNoCreateService.createPartNoAndDesc(cpi);

    if (cr.isSuccess()) {
      // 可生成料号
      // 需要保存的料号信息
      // 因为72耗材暂不做唯一性校验，故hashCode置为"0"
      PartNoInfo pni = translateObjectService.translateAll2SaveInfo(pageRtn, cr, "0");
      // 保存
      if (pni != null) {
        partSaveService.savePartNoAndProperty(pni, cpi);
        ajax.setAttribute("partNoId", pni.getId());
        ajax.setAttribute("success", Status.CAN_CREATE);
      }
    } else {
      String message = cr.getMessage();
      ajax.setAttribute("success", Status.CANNOT_CREATE_TYPE);
      ajax.setAttribute("message", message);
    }

    return ajax;
  }

  /**
   * 批量&单个检查备品耗材唯一性并生成料号
   * 
   * @param mcr
   * @param ajax
   * @param pageRtn
   * @return
   */
  @Override
  public synchronized AjaxRtnJson checkMassAndSingle(MassCreateResult mcr, AjaxRtnJson ajax,
      PageRtn pageRtn) {
    if (null == mcr) {
      return checkProAndCreate(ajax, pageRtn);
    } else {
      // 检查唯一性，如果全部符合，则一起通过，反之都不通过
      if (mcr.isSuccess()) {
        // sheet里面的唯一性属性自比较结果
        Sheet sheet = mcr.getSheet();
        int rowNum = sheet.getLastRowNum();
        // 与历史数据进行对比
        for (int i = 5; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          String partId = partNoAddService.getPartId(row);
          UniqueProperty uniqueProperty = new UniqueProperty();
          uniqueProperty.setPartId(partId);
          Map<String, String> map = new HashMap<String, String>();
          // 通过下拉查出真实值，再做对比
          String brandValue =
              getPropertyValueByText(partId, PropertyName.SC_BRAND,
                  row.getCell(ModelSequence.BRAND).toString()).getEnumValue();
          String specValue =
              getPropertyValueByText(partId, PropertyName.SC_SPEC,
                  row.getCell(ModelSequence.SPEC).toString()).getEnumValue();
          map.put(PropertyName.SC_BRAND, brandValue);
          map.put(PropertyName.SC_SPEC, specValue);
          uniqueProperty.setUniqueProperty(map);
          String hashCode = String.valueOf(uniqueProperty.hashCode());
          // hashCode检查
          List<PartNoExt> list = comparePropertyService.hashCodeIsExit(hashCode, partId);
          if (!list.isEmpty()) {
            // 继续将属性逐个检查
            PartNoExt pne = comparePropertyService.propertyIsExit(uniqueProperty, list);
            if (pne != null) {
              row.getCell(ModelSequence.PART_NO).setCellValue(pne.getPartNo() + "已存在");
              mcr.setSuccess(false);
            }
          }
        }

        // 唯一性检查全部通过，生成料号，存入数据库，写到Excel
        if (mcr.isSuccess()) {
          for (int j = 5; j <= rowNum; j++) {
            Row row = sheet.getRow(j);
            createPartNoAndWriteExcel(row, mcr.getSheet());
          }
        }
      }
      return null;
    }
  }


  /**
   * 通过excel的数据生成料号信息填入excel并存入数据库
   * 
   * @param row
   */
  private void createPartNoAndWriteExcel(Row row, Sheet sheet) {

    String partNoId = UUID.randomUUID().toString().replace("-", "");

    // 调用方法通过3级level获取partId
    String partId = partNoAddService.getPartId(row);


    // 获取固定属性信息
    Map<String, String> propertiesMap = new HashMap<String, String>();
    propertiesMap.put(PropertyName.SC_DEVICE_CLASS, row.getCell(ModelSequence.DEVICE_CLASS)
        .toString());
    propertiesMap.put(PropertyName.SC_DEVICE_PLANT, row.getCell(ModelSequence.DEVICE_PLANT)
        .toString());
    propertiesMap.put(PropertyName.SC_OLD_NUMBER, row.getCell(ModelSequence.OLD_NUMBER).toString());
    propertiesMap.put(PropertyName.SC_SPEC, row.getCell(ModelSequence.SPEC).toString());
    propertiesMap.put(PropertyName.SC_BRAND, row.getCell(ModelSequence.BRAND).toString());
    propertiesMap.put(PropertyName.SC_MAINTAIN_CODE, "0");
    propertiesMap.put(PropertyName.FLOW_NO, "XXXXXX");

    // 唯一性属性Map
    Map<String, String> map = new HashMap<String, String>();
    // 查询真实值算hashCode
    String specValue =
        getPropertyValueByText(partId, PropertyName.SC_SPEC,
            row.getCell(ModelSequence.SPEC).toString()).getEnumValue();
    String brandValue =
        getPropertyValueByText(partId, PropertyName.SC_BRAND,
            row.getCell(ModelSequence.BRAND).toString()).getEnumValue();
    map.put(PropertyName.SC_SPEC, specValue);
    map.put(PropertyName.SC_BRAND, brandValue);
    UniqueProperty uniqueProperty = new UniqueProperty();
    uniqueProperty.setPartId(partId);
    uniqueProperty.setUniqueProperty(map);
    String hashCode = String.valueOf(uniqueProperty.hashCode());
    String partType = (row.getCell(ModelSequence.PART_TYPE).toString()).trim();
    String preCode = row.getCell(ModelSequence.PART_PREFIX).toString().trim();
    // 调用截取编码前缀方法，获取分类码
    Map<String, String> prefixMap = getSubString(preCode, partType);
    propertiesMap.putAll(prefixMap);

    // 批量创建，只生成料号
    CreationProInfo cpi = new CreationProInfo();
    cpi.setMessCreate(true);
    cpi.setClassName("");
    cpi.setPartId("");
    cpi.setPartType("");
    cpi.setPreCode("");
    Map<String, String[]> propertiesM = new HashMap<String, String[]>();
    for (Map.Entry<String, String> entry : prefixMap.entrySet()) {
      String[] propertyV = {entry.getValue(), entry.getValue()};
      propertiesM.put(entry.getKey() + "Id", propertyV);
    }
    String[] maintain = {"0", "0"};
    String[] flowNo = {"XXXXXX", "XXXXXX"};
    propertiesM.put(PropertyName.SC_MAINTAIN_CODE + "Id", maintain);
    propertiesM.put(PropertyName.FLOW_NO + "Id", flowNo);
    cpi.setProperties(propertiesM);
    String partNo = partNoCreateService.createPartNoAndDesc(cpi).getPartNo();
    if (partNo == null) {
      row.getCell(ModelSequence.PART_NO).setCellValue("料号生成失败");
      return;
    }
    row.getCell(ModelSequence.PART_NO).setCellValue(partNo); // 插入Excel料号

    // 获取变量属性
    List<PartPropertiesExt> propList = partPropertiesExtMapper.getPropertiesByPartId(partId);
    for (int j = ModelSequence.PROPERTY_START; j < ModelSequence.PROPERTY_END; j++) {
      // 获取模板表中的真实名
      String propName = sheet.getRow(4).getCell(j).toString();
      for (int k = 0; k < propList.size(); k++) {
        PartPropertiesExt ppExt = propList.get(k);
        if (propName.equals(ppExt.getPropertyName())) {
          String propValue = row.getCell(j).toString();
          propertiesMap.put(propName, propValue);
        }
      }
    }

    // 讲属性map转化成可存属性List
    List<PropertyValue> properties = new ArrayList<PropertyValue>();
    List<PartPropertiesExt> list = partPropertiesService.getByPartId(partId);
    if (!list.isEmpty()) {
      for (PartPropertiesExt pp : list) {
        String propertyName = pp.getPropertyName();
        String propertyValueDis = propertiesMap.get(propertyName);
        PropertyValue pv = new PropertyValue();
        pv.setId(UUID.randomUUID().toString().replace("-", ""));
        pv.setPartNoId(partNoId);
        pv.setPropertyName(propertyName);
        pv.setPropertyType(pp.getIsUnique());

        // 判断属性是否为下拉，如果是下拉，可将下拉的Id存入
        List<PartPropertiesExt> proList =
            partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propertyName);
        if (!proList.isEmpty() && "Y".equals(proList.get(0).getIsEnum())) {
          EnumValueExt ev = getPropertyValueByText(partId, propertyName, propertyValueDis);
          // 如果显示值非下拉中的（主要体现在从料号前缀获取出来的值），还是存获取出来的值作为真实值
          if ("".equals(ev.getId()) || null == ev.getId()) {
            pv.setPropertyValue(propertyValueDis);
          } else {
            pv.setPropertyValue(ev.getEnumValue());
            pv.setEnumValueId(ev.getId());
          }
        } else {
          pv.setPropertyValue(propertiesMap.get(propertyName));
        }
        properties.add(pv);
      }
    }

    // 封装成保存的料号对象
    PartNoInfo pni = new PartNoInfo();
    pni.setCnDesc(row.getCell(ModelSequence.CN_DESC).toString());
    pni.setCreateCode(row.getCell(ModelSequence.USER_CODE).toString());
    pni.setCreateName(row.getCell(ModelSequence.USER_NAME).toString());
    pni.setCreateTime(new Date());
    pni.setDepartment(row.getCell(ModelSequence.PLANT).toString() + "/"
        + row.getCell(ModelSequence.DEPARTMENT).toString());
    pni.setEnDesc(row.getCell(ModelSequence.EN_DESC).toString());
    pni.setHashCode(hashCode);
    pni.setId(partNoId);
    pni.setPartId(partId);
    pni.setPartName(row.getCell(ModelSequence.PART_NO_NAME).toString());
    pni.setPartNo(partNo);
    pni.setPartNoStatus(Status.IS_PART_RELEASE);
    pni.setPartType(partType);
    pni.setProperties(properties);
    pni.setTelephone(row.getCell(ModelSequence.USER_TELE).toString());
    pni.setUid("批量创建");

    // 保存
    partSaveService.savePartNoAndProperty(pni, cpi);

  }

  /**
   * 获取模板中的编码序列前七码，截取为分类码，如:大分类码、大类、中类 、小类、厂别代码等
   * 
   * @param prefixId 序列码
   * @param obgectType 料号类型
   * @return prefixMap 分类码
   */
  private Map<String, String> getSubString(String prefixId, String partType) {
    Map<String, String> prefixMap = new HashMap<String, String>();
    if (("C4_SparePart".equals(partType) || "C4_Consumptive".equals(partType)) && null != prefixId
        && prefixId.length() == 7) {
      prefixMap.put(PropertyName.BIG_CLASS, prefixId.substring(0, 2));
      prefixMap.put(PropertyName.SC_PLANT_CODE, prefixId.substring(2, 3));
      prefixMap.put(PropertyName.SC_LARGE_CLASS, prefixId.substring(3, 4));
      prefixMap.put(PropertyName.SC_MEDIUM_CLASS, prefixId.substring(4, 5));
      prefixMap.put(PropertyName.SC_MINI_CLASS, prefixId.substring(5, 7));
    }
    return prefixMap;
  }

  /**
   * 通过填在表格的显示值获取对应下拉的真实值
   * 
   * @param partId
   * @param propertyName
   * @param propertyValueText
   * @return
   */
  public EnumValueExt getPropertyValueByText(String partId, String propertyName,
      String propertyValueText) {
    EnumValueExt valueV = new EnumValueExt();
    List<PartPropertiesExt> proList =
        partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propertyName);
    if (!proList.isEmpty()) {
      String proId = proList.get(0).getId();
      List<PropertiesMExt> enumList = propertiesMExtMapper.getEnumIdByPropertyId(proId);
      if (!enumList.isEmpty()) {
        String enumTypeId = enumList.get(0).getEnumId();
        List<EnumValueExt> valueList =
            enumValueExtMapper.getByTypeIdAndEnumText(enumTypeId, propertyValueText);
        if (!valueList.isEmpty()) {
          valueV = valueList.get(0);
        }
      }
    }
    return valueV;
  }
}
