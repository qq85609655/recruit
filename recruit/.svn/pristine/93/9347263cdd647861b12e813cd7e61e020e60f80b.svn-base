package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.EducationExperienceCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EducationExperienceMapper extends MyBatisBaseMapper {
    int countByExample(EducationExperienceCriteria example);

    int deleteByExample(EducationExperienceCriteria example);

    int deleteByPrimaryKey(String id);
    
    int deleteByResumeId(String resumeId);

    int insert(EducationExperience record);

    int insertSelective(EducationExperience record);

    List<EducationExperience> selectByExample(EducationExperienceCriteria example);

    EducationExperience selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EducationExperience record, @Param("example") EducationExperienceCriteria example);

    int updateByExample(@Param("record") EducationExperience record, @Param("example") EducationExperienceCriteria example);

    int updateByPrimaryKeySelective(EducationExperience record);

    int updateByPrimaryKey(EducationExperience record);

    List<EducationExperience> selectByResumeId(String resumeId);
    
    EducationExperience selectLastEdu(String resumeId);
    
}