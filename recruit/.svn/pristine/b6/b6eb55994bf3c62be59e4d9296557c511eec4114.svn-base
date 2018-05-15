package com.csot.recruit.dao.datadict;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

import com.csot.recruit.model.datadict.DataConfig;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.datadict.DatadictGroupCriteria;

public interface DatadictGroupMapper extends MyBatisBaseMapper {
    int countByExample(DatadictGroupCriteria example);

    int deleteByExample(DatadictGroupCriteria example);

    int deleteByPrimaryKey(String groupId);

    int insert(DatadictGroup record);

    int insertSelective(DatadictGroup record);

    List<DatadictGroup> selectByExample(DatadictGroupCriteria example);

    DatadictGroup selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") DatadictGroup record, @Param("example") DatadictGroupCriteria example);

    int updateByExample(@Param("record") DatadictGroup record, @Param("example") DatadictGroupCriteria example);

    int updateByPrimaryKeySelective(DatadictGroup record);

    int updateByPrimaryKey(DatadictGroup record);
    
    /***
     * 查询数据数据配置结果集
     * @return
     */
    List<DataConfig> queryDatadictGroupList();
    
    List<DataConfig> queryDatadictGroupTypeList();
    
    /***
     * 根据条件查找该分类是否存在
     * @param datadictGroup
     * @return
     */
    int countDatadictGroup(DatadictGroup datadictGroup);
}