package com.csot.gm.materialManage.service.propertiesM;

import java.util.List;

import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.propertiesM.PropertiesM;
import com.csot.gm.rawMaterial.model.PartClassTree;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PropertiesMService {
  MiniRtn2Grid<PropertiesM> getGrid(MiniGridPageSort pageSort, String searchKey);

  PropertiesM getByPrimaryKey(String primaryKey);

  void create(PropertiesM propertiesM);

  void updateSelective(PropertiesM propertiesM);

  void remove(String primaryKey);
  
  List<PartClassTree> getEnumTypeList();
  
  void updateEnumTypeByPropertyId(String enumTypeId, String propertyId);
  
  List<PropertiesMExt> getByPropertyId(String propertyId);
}