package com.csot.gm.materialManage.service;

import java.util.List;

import com.csot.gm.rawMaterial.model.PartProperty;
import com.csot.gm.rawMaterial.model.PropertyEnumType;

public interface PropertyEnumService {

  List<PropertyEnumType> getPropertyEnumDatagrid(String partId);
  
  List<PartProperty> getPartPropertyDatagrid(String partId);
}
