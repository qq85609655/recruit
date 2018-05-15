package com.csot.recruit.dao.resume;



import com.csot.recruit.model.resume.ITSkill;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface ITSkillMapper extends MyBatisBaseMapper {

  int insertSelective(ITSkill record);
  
  int deleteByResumeId(String resumeId);
  /*  int countByExample(WorkIntentionCriteria example);

    int deleteByExample(WorkIntentionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(WorkIntention record);

    int insertSelective(WorkIntention record);

    List<WorkIntention> selectByExample(WorkIntentionCriteria example);

    WorkIntention selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WorkIntention record, @Param("example") WorkIntentionCriteria example);

    int updateByExample(@Param("record") WorkIntention record, @Param("example") WorkIntentionCriteria example);

    int updateByPrimaryKeySelective(WorkIntention record);

    int updateByPrimaryKey(WorkIntention record);*/
}