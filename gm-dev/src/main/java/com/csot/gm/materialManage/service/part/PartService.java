package com.csot.gm.materialManage.service.part;

import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.rawMaterial.model.Result4CheckPartType;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PartService {
  MiniRtn2Grid<Part> getGrid(MiniGridPageSort pageSort, String searchKey);

  Part getByPrimaryKey(String primaryKey);

  void create(Part part);

  void updateSelective(Part part);

  void remove(String primaryKey);
  
  Result4CheckPartType checkIsPLMType(String partId, String partType);
}