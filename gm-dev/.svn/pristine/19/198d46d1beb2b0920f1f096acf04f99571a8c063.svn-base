package com.csot.gm.materialManage.service.valueEnumM;

import com.csot.gm.materialManage.model.original.valueEnumM.ValueEnumM;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface ValueEnumMService {
  MiniRtn2Grid<ValueEnumM> getGrid(MiniGridPageSort pageSort, String searchKey);

  ValueEnumM getByPrimaryKey(String primaryKey);

  void create(ValueEnumM valueEnumM);

  void updateSelective(ValueEnumM valueEnumM);

  void remove(String primaryKey);
  
  ValueEnumM getByValueId(String valueId);
  
  void updateValueEnumMByValueId(String enumTypeId, String valueId);
}