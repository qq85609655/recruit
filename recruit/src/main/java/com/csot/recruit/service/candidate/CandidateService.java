package com.csot.recruit.service.candidate;

import java.util.List;
import java.util.Map;

import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.vo.InterviewBookListVo;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface CandidateService {
    MiniRtn2Grid<Candidate> getGrid(MiniGridPageSort pageSort, String searchKey,String state);

    Candidate getByPrimaryKey(String primaryKey);
    
    Candidate getCandidateByPrimaryKey(String primaryKey);

    void create(Candidate candidate);

    void updateSelective(Candidate candidate);

    void remove(String primaryKey);

    MiniRtn2Grid<InterviewBookListVo> queryCandidateListByPage(Map<String, Object> map);
    
    void updateCandidatePostSelective(CandidatePost candidatePost);
    
    /**
     * 锁定某个候选人
     * @candidateId 候选人id
     * @lockUserId 当前操作人Id
     */
    void lockCandidate(String candidateId, String lockUserId);
    
    /**
     * 批量解锁候选人
     * @candidateIds 候选人ids
     * @lockUserId 当前操作人Id
     * */
    void unlockCandidate(String candidateIds, String lockUserId);

    List<CandidatePost> selectCandidatePostListByCandidateId(String candidateId);

    CandidatePost selectCandidatePostByMap(Map<String, Object> param);

    MiniRtn2Grid<Candidate> getCandidateListGrid(Map<String, Object> map);
    
    CandidatePost selectCandidatePostById(String id);

    MiniRtn2Grid<Candidate> getCandidateRepositoryGrid(Map<String, Object> map);

    void addCandidatePost(CandidatePost cp);

    void batchOutCpByMap(Map<String, Object> cpparam);
    
    
    
}