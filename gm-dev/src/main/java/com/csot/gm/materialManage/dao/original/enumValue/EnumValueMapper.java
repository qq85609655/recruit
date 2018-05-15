package com.csot.gm.materialManage.dao.original.enumValue;

import com.csot.gm.materialManage.model.original.enumValue.EnumValue;
import com.csot.gm.materialManage.model.original.enumValue.EnumValueCriteria;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EnumValueMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int countByExample(EnumValueCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int deleteByExample(EnumValueCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int insert(EnumValue record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int insertSelective(EnumValue record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  List<EnumValue> selectByExample(EnumValueCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  EnumValue selectByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int updateByExampleSelective(@Param("record") EnumValue record,
      @Param("example") EnumValueCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
      int
      updateByExample(@Param("record") EnumValue record, @Param("example") EnumValueCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(EnumValue record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(EnumValue record);
}