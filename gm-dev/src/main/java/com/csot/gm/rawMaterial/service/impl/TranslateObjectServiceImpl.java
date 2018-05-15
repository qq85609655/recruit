package com.csot.gm.rawMaterial.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.materialManage.model.original.partClass.PartClass;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.materialManage.service.enumValue.EnumValueService;
import com.csot.gm.materialManage.service.partClass.PartClassService;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;
import com.csot.gm.materialManage.service.userInfo.UserInfoService;
import com.csot.gm.rawMaterial.model.CreationProInfo;
import com.csot.gm.rawMaterial.model.CreationRtn;
import com.csot.gm.rawMaterial.model.PageRtn;
import com.csot.gm.rawMaterial.model.PartNoInfo;
import com.csot.gm.rawMaterial.model.UniqueProperty;
import com.csot.gm.rawMaterial.model.UserInfo;
import com.csot.gm.rawMaterial.service.TranslateObjectService;
import com.csot.gm.util.Status;

@Service("TranslateObjectService")
public class TranslateObjectServiceImpl implements TranslateObjectService {

  private static final Logger logger = LoggerFactory.getLogger(TranslateObjectServiceImpl.class);

  @Resource
  private EnumValueService enumValueService;
  @Resource
  private PartPropertiesService partPropertiesService;
  @Resource
  private PartClassService partClassService;
  @Resource
  private PartMapper partMapper;
  @Resource
  private UserInfoService userInfoService;

  /**
   * 从页面填写的属性信息里获取唯一性属性
   */
  @Override
  public UniqueProperty translateRtnProMap2Unique(Map<String, String> proMap, String partId) {
    UniqueProperty up = new UniqueProperty();
    Map<String, String> map = new HashMap<String, String>(); // 唯一性属性map
    List<PartPropertiesExt> list = partPropertiesService.getByPartId(partId);
    // List<XmlPropertyRtn> list = XmlUtil.getXmlPropertyListByPartId(partId); // 通过Xml获取属性信息

    for (Map.Entry<String, String> entry : proMap.entrySet()) {
      logger.info("key= " + entry.getKey() + " and value= " + entry.getValue());
      for (int i = 0; i < list.size(); i++) {
        if ((list.get(i).getPropertyName() + "Id").equals(entry.getKey())
            && "Y".equals(list.get(i).getIsUnique())) {
          String proMapValue = proMap.get(list.get(i).getPropertyName() + "Id");
          // 页面重复属性会带出来两个一样的id用“,”隔开，此处做处理
          if (proMapValue.contains(",")) {
            proMapValue = proMapValue.split(",")[0];
          }
          // 判断是否为下拉
          if ("Y".equals(list.get(i).getIsEnum())) {
            // 如果是下拉proMap里面存的是下拉Id，得先获取属性值,再存进map
            String propertyValue = enumValueService.getByPrimaryKey(proMapValue).getEnumValue();
            if (null != propertyValue && !"".equals(propertyValue)) {
              map.put(list.get(i).getPropertyName(), propertyValue);
            }
          } else {
            if ("".equals(proMapValue) || null == proMapValue) {
              proMapValue = "0";
            }
            map.put(list.get(i).getPropertyName(), proMapValue);
          }
        }
      }
    }

    up.setPartId(partId);
    up.setUniqueProperty(map);

    return up;
  }

  /**
   * 从页面填写的属性信息里获取生成料号和物料描述所需属性
   */
  @Override
  public CreationProInfo translateRtnProMap2CreationPro(Map<String, String> proMap, String preCode,
      String partId, String partType, String classId) {

    String partName = "";
    Part part = partMapper.selectByPrimaryKey(partId);
    if (null != part) {
      partName = part.getPartDesc();
    }

    Map<String, String[]> properties = new HashMap<String, String[]>();
    List<PartPropertiesExt> list = partPropertiesService.getByPartId(partId);
    for (Map.Entry<String, String> entry : proMap.entrySet()) {
      String proValueId = entry.getValue();
      // 页面重复属性会带出来两个一样的id用“,”隔开，此处做处理
      if (proValueId.contains(",")) {
        proValueId = proValueId.split(",")[0];
      }
      logger.info("key= " + entry.getKey() + " and value= " + proValueId);
      for (int i = 0; i < list.size(); i++) {
        if ((list.get(i).getPropertyName() + "Id").equals(entry.getKey())) {
          // 判断是否是下拉
          if ("Y".equals(list.get(i).getIsEnum())) {
            String value = enumValueService.getByPrimaryKey(proValueId).getEnumValue();
            String disValue = enumValueService.getByPrimaryKey(proValueId).getEnumText();
            String[] proValue = {value, disValue};
            properties.put(entry.getKey(), proValue);
          } else {
            if ("".equals(proValueId) || null == proValueId) {
              proValueId = " ";
            }
            String[] proValue = {proValueId, proValueId}; // 非下拉，真实值与显示值一样
            properties.put(entry.getKey(), proValue);
          }
        }
      }
    }

    // 将各分类名称传过去，做物料描述
    String[] classIds = classId.split(",");
    String[] className = new String[2];
    String classNames = ""; // 分类名称有时可作为生成物料描述
    if (classIds != null && classIds.length > 0) {
      for (int i = 0; i < classIds.length; i++) {
        PartClass partClass = partClassService.getByPrimaryKey(classIds[i]);
        if (null != partClass) {
          className[i] = partClass.getClassDesc();
          classNames += className[i] + ",";
        }
      }
    }
    String[] class1Name = {className[0], className[0]};
    String[] class2Name = {className[1], className[1]};
    String[] class3Name = {partName, partName};
    properties.put("class1Name", class1Name);
    properties.put("class2Name", class2Name);
    properties.put("class3Name", class3Name);

    CreationProInfo cp = new CreationProInfo();
    cp.setPreCode(preCode);
    cp.setPartType(partType);
    cp.setClassName(classNames);
    cp.setProperties(properties);
    cp.setPartId(partId);

    return cp;
  }

  /**
   * 将所有料号信息封装为可保存的对象0
   * 
   */
  @Override
  public PartNoInfo translateAll2SaveInfo(PageRtn pr, CreationRtn cr, String hashCode) {
    PartNoInfo pni = new PartNoInfo();
    // 通过用户工号把用户信息查出
    UserInfo user = userInfoService.getByUserCode(pr.getUserInfo().getUserCode());
    pni.setCnDesc(cr.getCnDesc());
    pni.setCreateCode(pr.getUserInfo().getUserCode());
    pni.setCreateName(user.getUserName());
    pni.setCreateTime(new Date());
    pni.setDepartment(user.getDepartment());
    pni.setEnDesc(cr.getEnDesc());
    pni.setHashCode(hashCode);
    String partNoId = UUID.randomUUID().toString().replace("-", "");
    pni.setId(partNoId);
    pni.setPartId(pr.getPartId());
    pni.setPartName(cr.getPartName());
    pni.setPartType(pr.getPartType());
    pni.setPartNo(cr.getPartNo());
    pni.setPartNoStatus(Status.IS_CREATING);
    pni.setPlant(user.getPlant());
    pni.setTelephone(pr.getUserInfo().getTelephone());
    pni.setUid(pr.getUid());
    logger.info("4+uid：" + pr.getUid());

    List<PropertyValue> properties = new ArrayList<PropertyValue>();
    List<PartPropertiesExt> list = partPropertiesService.getByPartId(pr.getPartId());

    Map<String, String> proMap = pr.getProperties();
    for (Map.Entry<String, String> entry : proMap.entrySet()) {
      String proValueId = entry.getValue();
      // 页面重复属性会带出来两个一样的id用“,”隔开，此处做处理
      if (proValueId.contains(",")) {
        proValueId = proValueId.split(",")[0];
      }
      logger.info("key= " + entry.getKey() + " and value= " + proValueId);
      for (int i = 0; i < list.size(); i++) {
        if ((list.get(i).getPropertyName() + "Id").equals(entry.getKey())) {
          PropertyValue pv = new PropertyValue();
          pv.setId(UUID.randomUUID().toString().replace("-", ""));
          pv.setPartNoId(partNoId);
          pv.setPropertyName(list.get(i).getPropertyName());
          if ("Y".equals(list.get(i).getIsUnique())) {
            pv.setPropertyType(Status.IS_UNIQUE);
          } else {
            pv.setPropertyType(Status.NOT_UNIQUE);
          }
          // 判断是否是下拉
          if ("Y".equals(list.get(i).getIsEnum())) {
            String value = enumValueService.getByPrimaryKey(proValueId).getEnumValue();
            pv.setPropertyValue(value);
            pv.setEnumValueId(proValueId);
          } else {
            if ("".equals(proValueId) || null == proValueId) {
              proValueId = " ";
            }
            pv.setPropertyValue(proValueId);
          }
          properties.add(pv);
        }
      }
    }

    pni.setProperties(properties);

    return pni;
  }
}