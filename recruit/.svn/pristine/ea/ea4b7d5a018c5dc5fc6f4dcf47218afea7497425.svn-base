package com.csot.recruit.service.log;

import com.csot.recruit.model.log.Log;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface LogService {
    MiniRtn2Grid<Log> getGrid(MiniGridPageSort pageSort, String searchKey);

    Log getByPrimaryKey(String primaryKey);

    void create(Log log);

    void updateSelective(Log log);

    void remove(String primaryKey);
}