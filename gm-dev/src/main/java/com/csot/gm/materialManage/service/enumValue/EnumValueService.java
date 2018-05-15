package com.csot.gm.materialManage.service.enumValue;

import java.util.List;

import com.csot.gm.materialManage.model.original.enumValue.EnumValue;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.ss.usermodel.Workbook;

public interface EnumValueService {

  MiniRtn2Grid<EnumValue> getGrid(MiniGridPageSort pageSort, String searchKey, String enumTypeId);

  EnumValue getByPrimaryKey(String primaryKey);

  void create(EnumValue enumValue);

  void updateSelective(EnumValue enumValue);

  void remove(String primaryKey);

  List<EnumValue> getByEnumTypeId(String enumTypeId);

  boolean isEnumTextExist(EnumValue enumValue);

  List<EnumValue> getByEnumTypeIdAndEnumValueLike(String enumTypeId, String enumValue);

  Workbook exportEnumValueByTemplate(List<EnumValue> list);

}
