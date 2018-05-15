package com.csot.recruit.dao.log;

import com.csot.recruit.model.log.Log;
import com.csot.recruit.model.log.LogCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LogMapper extends MyBatisBaseMapper {
    int countByExample(LogCriteria example);

    int deleteByExample(LogCriteria example);

    int deleteByPrimaryKey(String logid);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogCriteria example);

    Log selectByPrimaryKey(String logid);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogCriteria example);

    int updateByExample(@Param("record") Log record, @Param("example") LogCriteria example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}