package com.csot.recruit.service.flow.interview;

import java.util.Map;

import com.csot.recruit.model.original.flow.interview.Estimate;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface EstimateService {
    MiniRtn2Grid<Estimate> getGrid(MiniGridPageSort pageSort, String searchKey);

    Estimate getByPrimaryKey(String primaryKey);

    void create(Estimate estimate);

    void updateSelective(Estimate estimate);

    void remove(String primaryKey);

    Estimate selectByCandiateIdAndPositionId(Map<String, Object> param);

    int saveOrUpdate(SysUser sysUser, Estimate estimate);
}