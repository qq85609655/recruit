package com.csot.recruit.service.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployCandidate;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmployCandidateService {
    MiniRtn2Grid<EmployCandidate> getGrid(MiniGridPageSort pageSort, String searchKey);

    EmployCandidate getByPrimaryKey(String primaryKey);

    void create(EmployCandidate employCandidate);

    void updateSelective(EmployCandidate employCandidate);

    void remove(String primaryKey);
    /**
     * 根据employid获取候选人信息
     */
    EmployCandidate getByEmploy(String id);
}