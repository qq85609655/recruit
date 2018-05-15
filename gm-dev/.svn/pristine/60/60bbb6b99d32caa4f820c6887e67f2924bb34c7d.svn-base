package com.csot.gm.materialManage.service.typePartM;

import com.csot.gm.materialManage.model.original.typePartM.TypePartM;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface TypePartMService {
  MiniRtn2Grid<TypePartM> getGrid(MiniGridPageSort pageSort, String searchKey);

  TypePartM getByPrimaryKey(String primaryKey);

  void create(TypePartM typePartM);

  void updateSelective(TypePartM typePartM);

  void remove(String primaryKey);
  
  void removeByPartId(String partId);
}