package com.csot.recruit.service.flow.employ;

import java.util.Map;

import com.csot.recruit.model.original.flow.employ.EmployBlacklist;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmployBlacklistService {
    MiniRtn2Grid<EmployBlacklist> getGrid(MiniGridPageSort pageSort, Map<String, String> col);

    EmployBlacklist getByPrimaryKey(String primaryKey);

    AjaxRtnJson create(EmployBlacklist employBlacklist);

    void updateSelective(EmployBlacklist employBlacklist);

    void remove(String primaryKey);
}