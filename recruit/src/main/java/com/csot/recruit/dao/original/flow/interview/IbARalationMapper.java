package com.csot.recruit.dao.original.flow.interview;

import com.csot.recruit.model.original.flow.interview.IbARalation;
import com.csot.recruit.model.original.flow.interview.IbARalationCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface IbARalationMapper extends MyBatisBaseMapper {
    int countByExample(IbARalationCriteria example);

    int deleteByExample(IbARalationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(IbARalation record);

    int insertSelective(IbARalation record);

    List<IbARalation> selectByExample(IbARalationCriteria example);

    IbARalation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IbARalation record, @Param("example") IbARalationCriteria example);

    int updateByExample(@Param("record") IbARalation record, @Param("example") IbARalationCriteria example);

    int updateByPrimaryKeySelective(IbARalation record);

    int updateByPrimaryKey(IbARalation record);

    void deleteByInterviewBookId(String id);

    List<IbARalation> getListByInterviewBookId(String interviewBookId);
}