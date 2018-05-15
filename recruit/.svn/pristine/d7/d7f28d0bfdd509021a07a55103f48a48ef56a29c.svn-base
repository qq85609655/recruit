package com.csot.recruit.dao.original.flow.interview;

import com.csot.recruit.model.original.flow.interview.Estimate;
import com.csot.recruit.model.original.flow.interview.EstimateCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EstimateMapper extends MyBatisBaseMapper {
    int countByExample(EstimateCriteria example);

    int deleteByExample(EstimateCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Estimate record);

    int insertSelective(Estimate record);

    List<Estimate> selectByExample(EstimateCriteria example);

    Estimate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Estimate record, @Param("example") EstimateCriteria example);

    int updateByExample(@Param("record") Estimate record, @Param("example") EstimateCriteria example);

    int updateByPrimaryKeySelective(Estimate record);

    int updateByPrimaryKey(Estimate record);

    Estimate selectByCandiateIdAndPositionId(Map<String, Object> param);
}