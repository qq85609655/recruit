package com.csot.recruit.service.interview;

import com.csot.recruit.model.original.interview.Education;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EducationService {
    MiniRtn2Grid<Education> getGrid(MiniGridPageSort pageSort, String searchKey);

    Education getByPrimaryKey(String primaryKey);

    void create(Education education);

    void updateSelective(Education education);

    void remove(String primaryKey);
}