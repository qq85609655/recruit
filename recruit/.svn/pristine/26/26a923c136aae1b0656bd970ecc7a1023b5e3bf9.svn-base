package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.resume.WorkExperienceCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface WorkExperienceMapper extends MyBatisBaseMapper {
    int countByExample(WorkExperienceCriteria example);

    int deleteByExample(WorkExperienceCriteria example);

    int deleteByPrimaryKey(String id);
    
    int deleteByResumeId(String resumeId);

    int insert(WorkExperience record);

    int insertSelective(WorkExperience record);

    List<WorkExperience> selectByExample(WorkExperienceCriteria example);

    WorkExperience selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WorkExperience record, @Param("example") WorkExperienceCriteria example);

    int updateByExample(@Param("record") WorkExperience record, @Param("example") WorkExperienceCriteria example);

    int updateByPrimaryKeySelective(WorkExperience record);

    int updateByPrimaryKey(WorkExperience record);

    List<WorkExperience> selectByResumeId(String resumeId);
    
    WorkExperience selectLastWork(String resumeId);
    
}