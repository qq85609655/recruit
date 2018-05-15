package com.csot.recruit.service.campus;

import com.csot.recruit.model.original.campus.CampusSite;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface CampusSiteService {
    MiniRtn2Grid<CampusSite> getGrid(MiniGridPageSort pageSort, String siteName, String status);

    CampusSite getByPrimaryKey(String primaryKey);

    void create(CampusSite campusSite);

    void updateSelective(CampusSite campusSite);

    void remove(String primaryKey);

    AjaxRtnJson savaData(CampusSite[] campusSiteArr);
    
    CampusSite getBySiteIdOrName(String siteId, String siteName);
}
