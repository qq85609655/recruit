package com.csot.recruit.service.resume;

import com.csot.recruit.model.resume.WorkIntention;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface WorkIntentionService {
    MiniRtn2Grid<WorkIntention> getGrid(MiniGridPageSort pageSort, String searchKey);

    WorkIntention getByPrimaryKey(String primaryKey);

    void create(WorkIntention workIntention);

    void updateSelective(WorkIntention workIntention);

    void remove(String primaryKey);
}