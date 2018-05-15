package com.csot.recruit.service.position;

import com.csot.recruit.model.position.RecruitFlowConfig;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RecruitFlowConfigService {
    MiniRtn2Grid<RecruitFlowConfig> getGrid(MiniGridPageSort pageSort, String searchKey);

    RecruitFlowConfig getByPrimaryKey(String primaryKey);

    void create(RecruitFlowConfig recruitFlowConfig);

    void updateSelective(RecruitFlowConfig recruitFlowConfig);

    void remove(String primaryKey);
}