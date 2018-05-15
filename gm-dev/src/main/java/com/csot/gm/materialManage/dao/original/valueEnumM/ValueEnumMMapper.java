package com.csot.gm.materialManage.dao.original.valueEnumM;

import com.csot.gm.materialManage.model.original.valueEnumM.ValueEnumM;
import com.csot.gm.materialManage.model.original.valueEnumM.ValueEnumMCriteria;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ValueEnumMMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int countByExample(ValueEnumMCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int deleteByExample(ValueEnumMCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int insert(ValueEnumM record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int insertSelective(ValueEnumM record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  List<ValueEnumM> selectByExample(ValueEnumMCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  ValueEnumM selectByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int updateByExampleSelective(@Param("record") ValueEnumM record,
      @Param("example") ValueEnumMCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int updateByExample(@Param("record") ValueEnumM record,
      @Param("example") ValueEnumMCriteria example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(ValueEnumM record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_VALUE_ENUM_MAPPING
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(ValueEnumM record);
}
