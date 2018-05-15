package com.csot.recruit.dao.original.candidate;

import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.candidate.CandidatePostCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CandidatePostMapper extends MyBatisBaseMapper {
    int countByExample(CandidatePostCriteria example);

    int deleteByExample(CandidatePostCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CandidatePost record);

    int insertSelective(CandidatePost record);

    List<CandidatePost> selectByExample(CandidatePostCriteria example);

    CandidatePost selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CandidatePost record, @Param("example") CandidatePostCriteria example);

    int updateByExample(@Param("record") CandidatePost record, @Param("example") CandidatePostCriteria example);

    int updateByPrimaryKeySelective(CandidatePost record);

    int updateByPrimaryKey(CandidatePost record);
    
    int updateByUnion(CandidatePost record);

    List<CandidatePost> selectCandidatePostListByCandidateId(String candidateId);

    CandidatePost selectCandidatePostByMap(Map<String, Object> param);

    void batchUpdateCpbyMap(Map<String, Object> cpparam);
}