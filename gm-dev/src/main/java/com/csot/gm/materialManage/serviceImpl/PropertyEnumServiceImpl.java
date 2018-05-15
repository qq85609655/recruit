package com.csot.gm.materialManage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.extension.properties.PartPropertiesExtMapper;
import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.dao.original.enumType.EnumTypeMapper;
import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.dao.original.properties.PartPropertiesMapper;
import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.service.PropertyEnumService;
import com.csot.gm.rawMaterial.model.PartProperty;
import com.csot.gm.rawMaterial.model.PropertyEnumType;
import com.csot.gm.util.Status;

@Service("PropertyEnumService")
public class PropertyEnumServiceImpl implements PropertyEnumService {

  @Resource
  private PartPropertiesExtMapper partPropertiesExtMapper;
  @Resource
  private PartPropertiesMapper partPropertiesMapper;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private EnumTypeMapper enumTypeMapper;
  @Resource
  private PartMapper partMapper;

  @Override
  public List<PropertyEnumType> getPropertyEnumDatagrid(String partId) {

    String isEnum = Status.IS_ENUM;
    // 获取partId对应的属性枚举类型总list
    List<PropertyEnumType> listEnumType = new ArrayList<PropertyEnumType>();
    List<PartPropertiesExt> list =
        partPropertiesExtMapper.getEnumPropertiesByPartId(partId, isEnum);
    if (!list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        String propertyId = list.get(i).getId();
        String propertyName =
            partPropertiesMapper.selectByPrimaryKey(propertyId).getPropertyDisName();
        List<PropertiesMExt> pml = propertiesMExtMapper.getEnumIdByPropertyId(propertyId);
        String enumTypeId = null;
        String enumTypeName = null;
        if (!pml.isEmpty()) {
          enumTypeId = pml.get(0).getEnumId();
          enumTypeName = enumTypeMapper.selectByPrimaryKey(enumTypeId).getEnumName();
        }
        PropertyEnumType pet = new PropertyEnumType();
        pet.setPropertyId(propertyId);
        pet.setPropertyName(propertyName);
        pet.setEnumTypeId(enumTypeId);
        pet.setEnumTypeName(enumTypeName);
        listEnumType.add(pet);
      }
    }

    return listEnumType;
  }


  @Override
  public List<PartProperty> getPartPropertyDatagrid(String partId) {
    List<PartProperty> list = new ArrayList<PartProperty>();
    String partName = partMapper.selectByPrimaryKey(partId).getPartDesc();
    List<PartPropertiesExt> ppList = partPropertiesExtMapper.getPropertiesByPartId(partId);
    if (!ppList.isEmpty()) {
      for (int i = 0; i < ppList.size(); i++) {
        PartProperty pp = new PartProperty();
        pp.setPropertyId(ppList.get(i).getId());
        pp.setPropertyName(ppList.get(i).getPropertyName());
        pp.setPropertyDisName(ppList.get(i).getPropertyDisName());
        pp.setPartId(partId);
        pp.setPartName(partName);
        pp.setIsEnum(ppList.get(i).getIsEnum());
        pp.setIsUnique(ppList.get(i).getIsUnique());
        pp.setPropertyUnit(ppList.get(i).getPropertyUnit());
        list.add(pp);
      }
    }
    return list;
  }

}
