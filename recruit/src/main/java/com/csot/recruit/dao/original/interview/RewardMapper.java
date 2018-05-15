package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.Reward;
import com.csot.recruit.model.original.interview.RewardCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RewardMapper extends MyBatisBaseMapper {
    int countByExample(RewardCriteria example);

    int deleteByExample(RewardCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Reward record);

    int insertSelective(Reward record);

    List<Reward> selectByExample(RewardCriteria example);

    Reward selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Reward record, @Param("example") RewardCriteria example);

    int updateByExample(@Param("record") Reward record, @Param("example") RewardCriteria example);

    int updateByPrimaryKeySelective(Reward record);

    int updateByPrimaryKey(Reward record);

    List<Reward> selectByPersonCode(String personCode);
}