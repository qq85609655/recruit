package com.csot.recruit.service.resume;

import com.csot.recruit.model.nresume.Training;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface TrainingService {
    MiniRtn2Grid<Training> getGrid(MiniGridPageSort pageSort, String searchKey);

    Training getByPrimaryKey(String primaryKey);

    void create(Training training);

    void updateSelective(Training training);

    void remove(String primaryKey);
}