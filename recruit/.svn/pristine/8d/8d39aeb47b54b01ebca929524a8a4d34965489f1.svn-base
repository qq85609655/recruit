package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.resumeRule.ResumeRuleField;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleFieldCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ResumeRuleFieldMapper extends MyBatisBaseMapper {
    int countByExample(ResumeRuleFieldCriteria example);

    int deleteByExample(ResumeRuleFieldCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(ResumeRuleField record);

    int insertSelective(ResumeRuleField record);

    List<ResumeRuleField> selectByExample(ResumeRuleFieldCriteria example);

    ResumeRuleField selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResumeRuleField record, @Param("example") ResumeRuleFieldCriteria example);

    int updateByExample(@Param("record") ResumeRuleField record, @Param("example") ResumeRuleFieldCriteria example);

    int updateByPrimaryKeySelective(ResumeRuleField record);

    int updateByPrimaryKey(ResumeRuleField record);
}