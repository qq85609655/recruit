package com.csot.recruit.service.interview;

import java.util.List;

import com.csot.recruit.model.original.interview.Reward;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RewardService {
    MiniRtn2Grid<Reward> getGrid(MiniGridPageSort pageSort, String searchKey);

    Reward getByPrimaryKey(String primaryKey);

    void create(Reward reward);

    void updateSelective(Reward reward);

    void remove(String primaryKey);

    List<Reward> queryByPersonCode(String personCode);
}