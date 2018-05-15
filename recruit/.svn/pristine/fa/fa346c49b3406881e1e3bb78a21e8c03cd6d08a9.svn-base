package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.LanguageSkill;
import com.csot.recruit.model.resume.LanguageSkillCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LanguageSkillMapper extends MyBatisBaseMapper {
    int countByExample(LanguageSkillCriteria example);

    int deleteByExample(LanguageSkillCriteria example);

    int deleteByPrimaryKey(String id);
    
    int deleteByResumeId(String resumeId);

    int insert(LanguageSkill record);

    int insertSelective(LanguageSkill record);

    List<LanguageSkill> selectByExample(LanguageSkillCriteria example);

    LanguageSkill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LanguageSkill record, @Param("example") LanguageSkillCriteria example);

    int updateByExample(@Param("record") LanguageSkill record, @Param("example") LanguageSkillCriteria example);

    int updateByPrimaryKeySelective(LanguageSkill record);

    int updateByPrimaryKey(LanguageSkill record);
}