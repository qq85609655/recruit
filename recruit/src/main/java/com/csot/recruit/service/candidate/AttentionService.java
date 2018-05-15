package com.csot.recruit.service.candidate;

import java.util.Map;

import com.csot.recruit.model.original.candidate.Attention;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface AttentionService {
    MiniRtn2Grid<Attention> getGrid(MiniGridPageSort pageSort, String searchKey);

    Attention getByPrimaryKey(String primaryKey);

    void create(Attention attention);

    void updateSelective(Attention attention);

    void remove(String primaryKey);

    Attention getAttentionByMap(Map<String, Object> param);

    void batchRemove(Map<String, Object> param);
}