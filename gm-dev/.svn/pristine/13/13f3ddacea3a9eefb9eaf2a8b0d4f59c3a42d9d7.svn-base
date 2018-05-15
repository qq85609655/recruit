package com.csot.gm.materialManage.service.propertyRtn;

import com.csot.gm.materialManage.model.original.propertyRtn.PropertyRtn;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PropertyRtnService {
  MiniRtn2Grid<PropertyRtn> getGrid(MiniGridPageSort pageSort, String searchKey);

  PropertyRtn getByPrimaryKey(String primaryKey);

  void create(PropertyRtn propertyRtn);

  void updateSelective(PropertyRtn propertyRtn);

  void remove(String primaryKey);
  
  void removeAll();
}