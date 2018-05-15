package com.csot.recruit.dao.original.uniform;

import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.original.uniform.JobCriteria;

import java.math.BigDecimal;
import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface JobMapper extends MyBatisBaseMapper {
    int countByExample(JobCriteria example);

    int deleteByExample(JobCriteria example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Job record);

    int insertSelective(Job record);

    List<Job> selectByExample(JobCriteria example);

    Job selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") Job record, @Param("example") JobCriteria example);

    int updateByExample(@Param("record") Job record, @Param("example") JobCriteria example);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);

    Job selectByCode(String cJobcode);
}