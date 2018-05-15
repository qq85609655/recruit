package com.csot.gm.materialManage.service.partType;

import com.csot.gm.materialManage.model.original.partType.PartType;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PartTypeService {
  MiniRtn2Grid<PartType> getGrid(MiniGridPageSort pageSort, String searchKey);

  PartType getByPrimaryKey(String primaryKey);

  void create(PartType partType);

  void updateSelective(PartType partType);

  void remove(String primaryKey);
}