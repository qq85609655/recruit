package com.csot.recruit.dao.original.flow.interview;

import com.csot.recruit.model.original.flow.interview.InterviewBook;
import com.csot.recruit.model.original.flow.interview.InterviewBookCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface InterviewBookMapper extends MyBatisBaseMapper {
    int countByExample(InterviewBookCriteria example);

    int deleteByExample(InterviewBookCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(InterviewBook record);

    int insertSelective(InterviewBook record);

    List<InterviewBook> selectByExample(InterviewBookCriteria example);

    InterviewBook selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InterviewBook record, @Param("example") InterviewBookCriteria example);

    int updateByExample(@Param("record") InterviewBook record, @Param("example") InterviewBookCriteria example);

    int updateByPrimaryKeySelective(InterviewBook record);

    int updateByPrimaryKey(InterviewBook record);

    List<InterviewBook> selectInterviewBookListByMap(Map<String, Object> param);

    void batchUpdateInterviewBook(Map<String, Object> param);
}