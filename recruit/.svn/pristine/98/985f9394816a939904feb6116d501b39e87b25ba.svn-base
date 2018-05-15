package com.csot.recruit.dao.original.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RdARalation;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalationCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RdARalationMapper extends MyBatisBaseMapper {
    int countByExample(RdARalationCriteria example);

    int deleteByExample(RdARalationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RdARalation record);

    int insertSelective(RdARalation record);

    List<RdARalation> selectByExample(RdARalationCriteria example);

    RdARalation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RdARalation record, @Param("example") RdARalationCriteria example);

    int updateByExample(@Param("record") RdARalation record, @Param("example") RdARalationCriteria example);

    int updateByPrimaryKeySelective(RdARalation record);

    int updateByPrimaryKey(RdARalation record);

    void deleteByRecruitDemandId(String id);
}