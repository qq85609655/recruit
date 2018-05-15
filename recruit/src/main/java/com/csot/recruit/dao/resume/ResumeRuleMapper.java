package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.resumeRule.ResumeRule;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ResumeRuleMapper extends MyBatisBaseMapper {
    int countByExample(ResumeRuleCriteria example);

    int deleteByExample(ResumeRuleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(ResumeRule record);

    int insertSelective(ResumeRule record);

    List<ResumeRule> selectByExample(ResumeRuleCriteria example);
    
    List<ResumeRule> selectAll();
    
    List<ResumeRule> selectContainField(String fieldId);

    ResumeRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResumeRule record, @Param("example") ResumeRuleCriteria example);

    int updateByExample(@Param("record") ResumeRule record, @Param("example") ResumeRuleCriteria example);

    int updateByPrimaryKeySelective(ResumeRule record);

    int updateByPrimaryKey(ResumeRule record);
    
}