package com.csot.recruit.service.interview;

import java.util.List;

import com.csot.recruit.model.original.interview.Recommend;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RecommendService {
    MiniRtn2Grid<Recommend> getGrid(MiniGridPageSort pageSort, String searchKey);

    Recommend getByPrimaryKey(String primaryKey);

    void create(Recommend recommend);

    void updateSelective(Recommend recommend);

    void remove(String primaryKey);

    List<Recommend> queryByPersonCode(String personCode);

    void deleteByPersonCode(String personCode);
}