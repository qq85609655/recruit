package com.csot.gm.rawMaterial.service;

import java.util.List;

import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.rawMaterial.model.UniqueProperty;

public interface ComparePropertyService {
  
  List<PartNoExt> hashCodeIsExit(String hashCode, String partId);
  
  PartNoExt propertyIsExit(UniqueProperty uniqueProperty, List<PartNoExt> list);
}
