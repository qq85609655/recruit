package com.csot.gm.materialManage.service.partClass;

import com.csot.gm.materialManage.model.original.partClass.PartClass;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PartClassService {
  MiniRtn2Grid<PartClass> getGrid(MiniGridPageSort pageSort, String searchKey);

  PartClass getByPrimaryKey(String primaryKey);

  void create(PartClass partClass);

  void updateSelective(PartClass partClass);

  void remove(String primaryKey);

  void createLevel2(PartClass partClass);
}