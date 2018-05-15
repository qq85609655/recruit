package com.csot.recruit.service.flow.employ;

import java.util.List;

import com.csot.recruit.model.original.flow.employ.EmployEducation;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmployEducationService {
    MiniRtn2Grid<EmployEducation> getGrid(MiniGridPageSort pageSort, String searchKey);

    EmployEducation getByPrimaryKey(String primaryKey);

    void create(EmployEducation employEducation);

    void updateSelective(EmployEducation employEducation);

    void remove(String primaryKey);

    List<EmployEducation> getByEmploy(String employId);
}