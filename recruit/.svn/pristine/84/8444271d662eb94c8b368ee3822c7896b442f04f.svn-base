package com.csot.recruit.service.interview;

import com.csot.recruit.model.original.interview.Works;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface WorksService {
    MiniRtn2Grid<Works> getGrid(MiniGridPageSort pageSort, String searchKey);

    Works getByPrimaryKey(String primaryKey);

    void create(Works works);

    void updateSelective(Works works);

    void remove(String primaryKey);
}