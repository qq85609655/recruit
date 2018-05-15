package com.csot.recruit.dao.original.flow.interview;

import com.csot.recruit.model.original.flow.interview.Feedback;
import com.csot.recruit.model.original.flow.interview.FeedbackCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper extends MyBatisBaseMapper {
    int countByExample(FeedbackCriteria example);

    int deleteByExample(FeedbackCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExample(FeedbackCriteria example);

    Feedback selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackCriteria example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackCriteria example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    void deleteByInterviewIds(Map<String, Object> param);

    Feedback selectByInterviewBookId(String interviewBookId);
}