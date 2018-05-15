package com.csot.recruit.service.datadict;

import java.util.Map;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

import com.csot.recruit.model.datadict.DatadictGroupType;

public interface DatadictGroupTypeService {

  MiniRtn2Grid<DatadictGroupType> getGrid(MiniGridPageSort pageSort, String searchKey);

  DatadictGroupType getByPrimaryKey(String primaryKey);

  void create(DatadictGroupType datadictGroupType);

  void updateSelective(DatadictGroupType datadictGroupType);

  void remove(String primaryKey);
  
  /***
   * 根据条件查找该数据字典二级项是否存在
   * @param datadictGroupType
   * @return
   */
  int getDatadictGroupType(DatadictGroupType datadictGroupType);

  /**
   * 根据字典类型编码,获取该类型的字典集合,适用于页面下拉列表
   * */
  MiniRtn2Grid<DatadictGroupType> getGridByGorupCode(String groupCode);

  /**
   * 根据字典值类型编码和字典text获取对应字典对象,适用于根据text校验是否存在并获取对象信息
   * */
  DatadictGroupType getTypeByGorupCodeAndName(String groupCode, String typeName);

  /**
   * 根据字典类型编码,获取type_id与type_name的Map集合,适用用于大量的id转化为name
   * */
  Map<String, String> getTypeId2NameMapByGroupCode(String groupCode);

  /**
   * 根据字典类型编码,获取type_name与type_id的Map集合,适用用于大量的name转化为id
   * */
  Map<String, String> getName2TypeIdMapByGroupCode(String groupCode);

  /**
   * 根据类型和code值获取名称
   * */
  String getNameByCodeValue(String groupCode, String typeCode);

  /**
   * 根据id值获取名称
   * */
  String getNameById(String typeId);

}
