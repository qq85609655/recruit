package com.csot.gm.rawMaterial.service;

import java.util.List;

import com.csot.gm.rawMaterial.model.PartClassTree;
import com.csot.gm.rawMaterial.model.PieChartObj;
import com.csot.gm.rawMaterial.model.PropertyCombo;

public interface DataShowService {
  
  List<PartClassTree> getPartClassData(String partType);
  
  List<PropertyCombo> getComboData(String enumTypeId);

  List<PartClassTree> getSpareConsumTree();

  int updatePartNoInfo(String partNoId, String partId);

  List<PieChartObj> getPieChartsData4PartNo();
   
}
