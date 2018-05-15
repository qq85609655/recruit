package com.csot.gm.rawMaterial.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.extension.partType.PartTypeExtMapper;
import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.dao.extension.typePartM.TypePartMExtMapper;
import com.csot.gm.materialManage.dao.original.partType.PartTypeMapper;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.partType.PartTypeExt;
import com.csot.gm.materialManage.model.extension.propertyValue.PropertyValueExt;
import com.csot.gm.materialManage.model.extension.typePartM.TypePartMExt;
import com.csot.gm.materialManage.model.original.partType.PartType;
import com.csot.gm.rawMaterial.model.UniqueProperty;
import com.csot.gm.rawMaterial.service.ComparePropertyService;

@Service("ComparePropertyService")
public class ComparePropertyServiceImpl implements ComparePropertyService {

  private static final Logger logger = LoggerFactory.getLogger(ComparePropertyServiceImpl.class);
  private static final String SPARE_PART = "C4_SparePart";
  private static final String CONSUMPTIVE = "C4_Consumptive";
  private static final String OTHER_HIS = "C4_OTHER";

  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PropertyValueExtMapper propertyValueExtMapper;
  @Resource
  private TypePartMExtMapper typePartMExtMapper;
  @Resource
  private PartTypeMapper partTypeMapper;
  @Resource
  private PartTypeExtMapper partTypeExtMapper;

  /**
   * hashCode比较
   */
  @Override
  public List<PartNoExt> hashCodeIsExit(String hashCode, String partId) {
    List<PartNoExt> list = new ArrayList<PartNoExt>();
    // 比较范围根据物料类型决定
    List<TypePartMExt> mapping = typePartMExtMapper.getByPartId(partId);
    if (!mapping.isEmpty()) {
      String partTypeId = mapping.get(0).getPartTypeId();
      PartType partType = partTypeMapper.selectByPrimaryKey(partTypeId);
      if (null != partType) {
        String partTypeRealName = partType.getPartTypeRealName();
        // 如果是备品耗材，则和所有备品耗材一起比较hashCode
        if (SPARE_PART.equals(partTypeRealName) || CONSUMPTIVE.equals(partTypeRealName)
            || OTHER_HIS.equals(partTypeRealName)) {
          list = getSameHashCodeInSpareConsumptive(hashCode);
        } else {
          list = partNoExtMapper.selectPartNoListByHashCodeAndPartId(hashCode, partId);
        }
      }
    }
    return list;
  }

  /**
   * hashCode值一样的料号的属性值对比
   */
  @Override
  public PartNoExt propertyIsExit(UniqueProperty uniqueProperty, List<PartNoExt> list) {
    PartNoExt pne = null;
    if (uniqueProperty != null && null != list && !list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        boolean result = propertyValueIsTheSame(uniqueProperty, list.get(i));
        if (result) {
          pne = new PartNoExt();
          pne = list.get(i);
          return pne;
        }
      }
    } else {
      logger.info("属性检查信息有误");
    }
    return pne;
  }

  /**
   * 逐个比较唯一性属性值
   * 
   * @param uniqueProperty
   * @param pne
   * @return
   * @throws Exception
   */
  public boolean propertyValueIsTheSame(UniqueProperty uniqueProperty, PartNoExt pne) {

    Map<String, String> map = uniqueProperty.getUniqueProperty(); // 待创建唯一性属性map
    String partNoId = pne.getId();
    List<PropertyValueExt> propertyValueList =
        propertyValueExtMapper.selectPropertyValueByPartNo(partNoId);
    HashMap<String, String> hm = new HashMap<String, String>(); // 已创建的料号的所有属性map
    if (!propertyValueList.isEmpty()) {
      for (int i = 0; i < propertyValueList.size(); i++) {
        hm.put(propertyValueList.get(i).getPropertyName(), propertyValueList.get(i)
            .getPropertyValue());
      }
    }
    if (map != null && hm != null) {
      // 属性对比
      for (Map.Entry<String, String> entry : map.entrySet()) {
        logger.info("key= " + entry.getKey() + " and value= " + entry.getValue());
        String propertyValue = hm.get(entry.getKey());
        if (!(entry.getValue().equals(propertyValue))) {
          return false;
        }
      }
      return true;
    } else {
      logger.error("属性对比信息有误");
      return false;
    }
  }

  /**
   * 获取所有备品耗材中HashCode与参数一样的料号
   * 
   * @param hashCode
   * @return
   */
  public List<PartNoExt> getSameHashCodeInSpareConsumptive(String hashCode) {
    List<PartNoExt> list = new ArrayList<PartNoExt>();
    List<PartTypeExt> sparePartTypeList = partTypeExtMapper.getPartTypeByRealName(SPARE_PART);
    List<PartTypeExt> consumptiveTypeList = partTypeExtMapper.getPartTypeByRealName(CONSUMPTIVE);
    List<PartTypeExt> otherHisTypeList = partTypeExtMapper.getPartTypeByRealName(OTHER_HIS);
    // 备品
    if (!sparePartTypeList.isEmpty()) {
      String sparePartId = sparePartTypeList.get(0).getId();
      List<TypePartMExt> sparePartList = typePartMExtMapper.getByPartTypeId(sparePartId);
      if (!sparePartList.isEmpty()) {
        for (TypePartMExt tpm : sparePartList) {
          list.addAll(partNoExtMapper.selectPartNoListByHashCodeAndPartId(hashCode, tpm.getPartId()));
        }
      }
    }
    // 耗材
    if (!consumptiveTypeList.isEmpty()) {
      String consumptiveId = consumptiveTypeList.get(0).getId();
      List<TypePartMExt> consumptiveList = typePartMExtMapper.getByPartTypeId(consumptiveId);
      if (!consumptiveList.isEmpty()) {
        for (TypePartMExt tpm : consumptiveList) {
          list.addAll(partNoExtMapper.selectPartNoListByHashCodeAndPartId(hashCode, tpm.getPartId()));
        }
      }
    }
    // 其他非设备备品耗材
    if (!otherHisTypeList.isEmpty()) {
      String otherHisId = otherHisTypeList.get(0).getId();
      List<TypePartMExt> otherHisList = typePartMExtMapper.getByPartTypeId(otherHisId);
      if (!otherHisList.isEmpty()) {
        for (TypePartMExt tpm : otherHisList) {
          list.addAll(partNoExtMapper.selectPartNoListByHashCodeAndPartId(hashCode, tpm.getPartId()));
        }
      }
    }

    return list;
  }

}
