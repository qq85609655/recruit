package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.WorkIntention;
import com.csot.recruit.model.resume.WorkIntentionCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface WorkIntentionMapper extends MyBatisBaseMapper {
    int countByExample(WorkIntentionCriteria example);

    int deleteByExample(WorkIntentionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(WorkIntention record);

    int insertSelective(WorkIntention record);

    List<WorkIntention> selectByExample(WorkIntentionCriteria example);

    WorkIntention selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WorkIntention record, @Param("example") WorkIntentionCriteria example);

    int updateByExample(@Param("record") WorkIntention record, @Param("example") WorkIntentionCriteria example);

    int updateByPrimaryKeySelective(WorkIntention record);

    int updateByPrimaryKey(WorkIntention record);
}