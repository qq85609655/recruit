package com.csot.gm.materialManage.service.enumType;

import java.util.List;

import com.csot.gm.materialManage.model.original.enumType.EnumType;
import com.csot.gm.rawMaterial.model.EnumTypeMember;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EnumTypeService {
  MiniRtn2Grid<EnumType> getGrid(MiniGridPageSort pageSort, String searchKey);

  EnumType getByPrimaryKey(String primaryKey);

  void create(EnumType enumType);

  void updateSelective(EnumType enumType);

  void remove(String primaryKey);
  
  boolean enumTypeIsUsing(String enumTypeId);
  
  List<EnumTypeMember> getEnumTypeMemberGrid(String enumTypeId);
  
  boolean enumTypeIsExist(String enumTypeName);
}