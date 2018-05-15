package com.csot.recruit.service.candidate;

import java.util.Map;

import com.csot.recruit.model.original.candidate.CandidateRecommend;
import com.csot.recruit.model.vo.CandidateRecommendResumeVo;
import com.csot.recruit.model.vo.CandidateRecommendVo;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface CandidateRecommendService {
    MiniRtn2Grid<CandidateRecommend> getGrid(MiniGridPageSort pageSort, String searchKey);
    
    MiniRtn2Grid<CandidateRecommendResumeVo> getGridCandidateRecommendVo(Map<String, Object> map)throws Exception;

    CandidateRecommend getByPrimaryKey(String primaryKey);

    void create(CandidateRecommend candidateRecommend);

    void updateSelective(CandidateRecommend candidateRecommend);

    void remove(String primaryKey);

    int saveOrUpdate(SysUser sysUser, CandidateRecommendVo candidateRecommendVo) throws Exception;

    void batchUpdateRecommend(Map<String, Object> param);

    CandidateRecommend getByMap(Map<String, Object> param);
}