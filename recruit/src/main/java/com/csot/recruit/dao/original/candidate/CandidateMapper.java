package com.csot.recruit.dao.original.candidate;

import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.candidate.CandidateCriteria;
import com.csot.recruit.model.vo.InterviewBookCandidateVo;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CandidateMapper extends MyBatisBaseMapper {
    int countByExample(CandidateCriteria example);

    int deleteByExample(CandidateCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Candidate record);

    int insertSelective(Candidate record);
    
    int insertCandidateSelective(Candidate record);

    List<Candidate> selectByExample(CandidateCriteria example);

    Candidate selectByPrimaryKey(String id);
    
    Candidate selectCandidateByPrimaryKey(String id);
    

    int updateByExampleSelective(@Param("record") Candidate record, @Param("example") CandidateCriteria example);

    int updateByExample(@Param("record") Candidate record, @Param("example") CandidateCriteria example);

    int updateByPrimaryKeySelective(Candidate record);

    int updateByPrimaryKey(Candidate record);

    List<InterviewBookCandidateVo> queryCandidateListByPage(Map<String, Object> map);

    int countByPage(Map<String, Object> map);
    
    int lockCandidate(Map<String, Object> map);
    
    int unlockCandidate(Map<String, Object> map);

    List<Candidate> selectListByMap(Map<String, Object> map);

    int countListByMap(Map<String, Object> map);
    
    List<Candidate> selectCandidateRepository (Map<String, Object> map);
    
    int countCandidateRepository(Map<String, Object> map);
    
    
}