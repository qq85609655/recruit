package com.csot.gm.materialManage.service.properties;

import java.util.List;

import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.original.properties.PartProperties;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PartPropertiesService {
  MiniRtn2Grid<PartProperties> getGrid(MiniGridPageSort pageSort, String searchKey);

  PartProperties getByPrimaryKey(String primaryKey);

  void create(PartProperties partProperties);

  void updateSelective(PartProperties partProperties);

  void remove(String primaryKey);
  
  List<PartPropertiesExt> getByPartId(String partId);
  
  String getProUnit(String partId, String proName);
}