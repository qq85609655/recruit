package com.csot.recruit.service.uniform;

import com.csot.recruit.model.original.uniform.Job;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface JobService {
    MiniRtn2Grid<Job> getGrid(MiniGridPageSort pageSort, String searchKey, String orgCode);

    Job getByPrimaryKey(String primaryKey);

    void create(Job job);

    void updateSelective(Job job);

    void remove(String primaryKey);
    
    Job selectByCode(String cJobcode);
}