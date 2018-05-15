package com.csot.recruit.dao.datadict;

import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.datadict.DatadictGroupTypeCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface DatadictGroupTypeMapper extends MyBatisBaseMapper {
    int countByExample(DatadictGroupTypeCriteria example);

    int deleteByExample(DatadictGroupTypeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(DatadictGroupType record);

    int insertSelective(DatadictGroupType record);

    List<DatadictGroupType> selectByExample(DatadictGroupTypeCriteria example);

    DatadictGroupType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") DatadictGroupType record, @Param("example") DatadictGroupTypeCriteria example);

    int updateByExample(@Param("record") DatadictGroupType record, @Param("example") DatadictGroupTypeCriteria example);

    int updateByPrimaryKeySelective(DatadictGroupType record);

    int updateByPrimaryKey(DatadictGroupType record);
    
    /***
     * 根据条件查找该数据字典二级项是否存在
     * @param datadictGroupType
     * @return
     */
    int countDatadictGroupType(DatadictGroupType datadictGroupType);
    
    /***
     * 判断已有多少个一级配置项
     * @return
     */
    int countGroupId();
    
    /***
     *  查询该一级配置项下已有多少个二级配置项
     * @param groupId 
     * @return
     */
    List<DatadictGroupType> queryGroupTypeListByGroupId(String groupId);
    
    /**
     * 根据groupId查询DatadictGroupType
     * @param groupId
     * @return
     */
    List<DatadictGroupType>getDatadictGroupTypeByGroupId(String groupId);
    
    /**
     * 查询该一级配置项已有的二级配置项中最大的type_code
     * @param groupId
     * @return
     */
    DatadictGroupType queryTypeCodeByGroupId(String groupId);
    
    /**根据group_code查询type列表*/
    List<DatadictGroupType> queryTypesByGroupCode(@Param("groupCode") String groupCode, @Param("typeName") String typeName);

    String getNameByCodeValue(@Param("groupCode")String groupCode,@Param("typeCode")String typeCode);
    
    String getNameById(@Param("typeId")String typeId);
    
}