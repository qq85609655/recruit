package com.csot.recruit.service.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLog;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RecruitDemandLogService {
    MiniRtn2Grid<RecruitDemandLog> getGrid(MiniGridPageSort pageSort, String searchKey);

    RecruitDemandLog getByPrimaryKey(String primaryKey);

    void create(RecruitDemandLog recruitDemandLog);

    void updateSelective(RecruitDemandLog recruitDemandLog);

    void remove(String primaryKey);
}