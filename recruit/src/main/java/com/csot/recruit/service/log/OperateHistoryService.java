package com.csot.recruit.service.log;

import java.util.List;

import com.csot.recruit.model.original.log.OperateHistory;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface OperateHistoryService {
    MiniRtn2Grid<OperateHistory> getGrid(MiniGridPageSort pageSort, String searchKey);

    OperateHistory getByPrimaryKey(String primaryKey);

    void create(OperateHistory operateHistory);

    void updateSelective(OperateHistory operateHistory);

    void remove(String primaryKey);

    List<OperateHistory> getOperateHistoryListByCandidateId(String id);
}