package com.csot.recruit.service.flow.employ;

import java.util.List;

import com.csot.recruit.model.original.flow.employ.EmployWork;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmployWorkService {
    MiniRtn2Grid<EmployWork> getGrid(MiniGridPageSort pageSort, String searchKey);

    EmployWork getByPrimaryKey(String primaryKey);

    void create(EmployWork employWork);

    void updateSelective(EmployWork employWork);

    void remove(String primaryKey);

    List<EmployWork> getByEmploy(String employId);
}