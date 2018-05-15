package com.csot.recruit.service.flow.employ;

import java.util.List;

import com.csot.recruit.model.original.flow.employ.Remind;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RemindService {
    MiniRtn2Grid<Remind> getGrid(MiniGridPageSort pageSort, String searchKey);

    Remind getByPrimaryKey(String primaryKey);

    void create(Remind remind);

    void updateSelective(Remind remind);

    void remove(String primaryKey);

    List<Remind> getByUserAndDate(String id, String format);
}