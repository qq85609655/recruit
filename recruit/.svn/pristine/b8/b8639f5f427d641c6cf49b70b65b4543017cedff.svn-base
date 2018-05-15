package com.csot.recruit.dao.position;

import com.csot.recruit.model.position.RecruitFlowConfig;
import com.csot.recruit.model.position.RecruitFlowConfigCriteria;

import java.math.BigDecimal;
import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecruitFlowConfigMapper extends MyBatisBaseMapper {
    int countByExample(RecruitFlowConfigCriteria example);

    int deleteByExample(RecruitFlowConfigCriteria example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(RecruitFlowConfig record);

    int insertSelective(RecruitFlowConfig record);

    List<RecruitFlowConfig> selectByExample(RecruitFlowConfigCriteria example);

    RecruitFlowConfig selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") RecruitFlowConfig record, @Param("example") RecruitFlowConfigCriteria example);

    int updateByExample(@Param("record") RecruitFlowConfig record, @Param("example") RecruitFlowConfigCriteria example);

    int updateByPrimaryKeySelective(RecruitFlowConfig record);

    int updateByPrimaryKey(RecruitFlowConfig record);
}