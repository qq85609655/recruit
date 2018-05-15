package com.csot.recruit.service.datadict;

import java.util.List;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

import com.csot.recruit.model.datadict.DataConfig;
import com.csot.recruit.model.datadict.DatadictGroup;

public interface DatadictGroupService {

  MiniRtn2Grid<DatadictGroup> getGrid(MiniGridPageSort pageSort, String searchKey);

  DatadictGroup getByPrimaryKey(String primaryKey);

  void create(DatadictGroup datadictGroup);

  void updateSelective(DatadictGroup datadictGroup);

  void remove(String primaryKey);
  
  /***
   * 查询数据配置结果集
   * @return
   */
  List<DataConfig> queryDatadictGroupList();
  
  /***
   * 根据条件查找该分类是否存在
   * @param datadictGroup
   * @return
   */
  int getDatadictGroupCount(DatadictGroup datadictGroup);
  
  /***
   * 根据groupId查询该配置项是否存在子配置项
   */
  int getGroupTypeCountByGroupId(String groupId);

}
