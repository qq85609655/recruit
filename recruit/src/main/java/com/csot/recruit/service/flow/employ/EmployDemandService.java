package com.csot.recruit.service.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployDemand;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmployDemandService {
    MiniRtn2Grid<EmployDemand> getGrid(MiniGridPageSort pageSort, String searchKey);

    EmployDemand getByPrimaryKey(String primaryKey);

    void create(EmployDemand employDemand);

    void updateSelective(EmployDemand employDemand);

    void remove(String primaryKey);

    /**
     * 根据employid获取录用招聘需求单信息
     * @param id
     * @return
     */
    EmployDemand getByEmploy(String id);
}