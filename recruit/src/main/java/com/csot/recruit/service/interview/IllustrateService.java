package com.csot.recruit.service.interview;

import com.csot.recruit.model.original.interview.Illustrate;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface IllustrateService {
    MiniRtn2Grid<Illustrate> getGrid(MiniGridPageSort pageSort, String searchKey);

    Illustrate getByPrimaryKey(String primaryKey);

    void create(Illustrate illustrate);

    void updateSelective(Illustrate illustrate);

    void remove(String primaryKey);

    Illustrate queryByPersonCode(String personCode);
}