package com.csot.recruit.dao.original.candidate;

import com.csot.recruit.model.original.candidate.CandidateRecommend;
import com.csot.recruit.model.original.candidate.CandidateRecommendCriteria;
import com.csot.recruit.model.original.candidate.RecommendUnionIds;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CandidateRecommendMapper extends MyBatisBaseMapper {
    int countByExample(CandidateRecommendCriteria example);

    int deleteByExample(CandidateRecommendCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CandidateRecommend record);

    int insertSelective(CandidateRecommend record);

    List<CandidateRecommend> selectByExample(CandidateRecommendCriteria example);

    CandidateRecommend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CandidateRecommend record, @Param("example") CandidateRecommendCriteria example);

    int updateByExample(@Param("record") CandidateRecommend record, @Param("example") CandidateRecommendCriteria example);

    int updateByPrimaryKeySelective(CandidateRecommend record);

    int updateByPrimaryKey(CandidateRecommend record);
    
    List<RecommendUnionIds> selectListByPage(Map<String,Object> param);
    
    int countByPage(Map<String,Object> param);

    void batchUpdateRecommend(Map<String, Object> param);

    CandidateRecommend selectByMap(Map<String, Object> param);
}