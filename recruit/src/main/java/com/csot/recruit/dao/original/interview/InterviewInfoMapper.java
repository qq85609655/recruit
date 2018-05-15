package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.InterviewInfo;
import com.csot.recruit.model.original.interview.InterviewInfoCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface InterviewInfoMapper extends MyBatisBaseMapper {
    int countByExample(InterviewInfoCriteria example);

    int deleteByExample(InterviewInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(InterviewInfo record);

    int insertSelective(InterviewInfo record);

    List<InterviewInfo> selectByExample(InterviewInfoCriteria example);

    InterviewInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InterviewInfo record, @Param("example") InterviewInfoCriteria example);

    int updateByExample(@Param("record") InterviewInfo record, @Param("example") InterviewInfoCriteria example);

    int updateByPrimaryKeySelective(InterviewInfo record);

    int updateByPrimaryKey(InterviewInfo record);
    
    List<InterviewInfo> queryInterviewListByPage(Map<String,Object> map);
    
    int countByPage(Map<String,Object> map);
    
    Integer searchPersonCode(Map<String,Object> map);
    
    void updatePersonCode(Map<String,Object> map);
    
    void addPersonCode(Map<String,Object> map);

    InterviewInfo selectByPersonCode(String personCode);
}