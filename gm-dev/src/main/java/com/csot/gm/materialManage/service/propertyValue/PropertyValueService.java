package com.csot.gm.materialManage.service.propertyValue;

import java.util.List;

import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.rawMaterial.model.PropertyValueShow;
import com.csot.gm.rawMaterial.model.Result4UpdatePropertyValue;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface PropertyValueService {
  MiniRtn2Grid<PropertyValue> getGrid(MiniGridPageSort pageSort, String searchKey);

  PropertyValue getByPrimaryKey(String primaryKey);

  void create(PropertyValue propertyValue);

  void updateSelective(PropertyValue propertyValue);

  void remove(String primaryKey);

  List<PropertyValueShow> getByPartNoId(String partNoId);

  Result4UpdatePropertyValue isSuccessUpdatePartNoProValue(PropertyValue[] propertyValueList,
      SysUser sysUser);

  boolean addPropertyValues(String partId, String propertyName, String propertyValue);

  String getPropertyDisName(String partId, String propertyName);

  String getPropertyValueDis(String partId, String propertyName, String propertyValue);

}
