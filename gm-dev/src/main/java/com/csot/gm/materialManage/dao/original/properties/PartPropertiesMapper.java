package com.csot.gm.materialManage.dao.original.properties;

import com.csot.gm.materialManage.model.original.properties.PartProperties;
import com.csot.gm.materialManage.model.original.properties.PartPropertiesCriteria;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface PartPropertiesMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int countByExample(PartPropertiesCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int deleteByExample(PartPropertiesCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int insert(PartProperties record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int insertSelective(PartProperties record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  List<PartProperties> selectByExample(PartPropertiesCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  PartProperties selectByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int updateByExampleSelective(@Param("record") PartProperties record,
      @Param("example") PartPropertiesCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int updateByExample(@Param("record") PartProperties record,
      @Param("example") PartPropertiesCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(PartProperties record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(PartProperties record);
}
