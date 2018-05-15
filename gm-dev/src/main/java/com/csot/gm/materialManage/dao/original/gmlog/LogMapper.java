package com.csot.gm.materialManage.dao.original.gmlog;

import com.csot.gm.materialManage.model.original.gmlog.Log;
import com.csot.gm.materialManage.model.original.gmlog.LogCriteria;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LogMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int countByExample(LogCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int deleteByExample(LogCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int insert(Log record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int insertSelective(Log record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  List<Log> selectByExample(LogCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  Log selectByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int updateByExampleSelective(@Param("record") Log record, @Param("example") LogCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int updateByExample(@Param("record") Log record, @Param("example") LogCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(Log record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(Log record);
}