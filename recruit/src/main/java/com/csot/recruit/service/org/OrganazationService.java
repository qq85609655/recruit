package com.csot.recruit.service.org;

import com.csot.recruit.model.org.Organazation;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface OrganazationService {
    MiniRtn2Grid<Organazation> getGrid(MiniGridPageSort pageSort, String searchKey);

    Organazation getByPrimaryKey(String primaryKey);

    void create(Organazation organazation);

    void updateSelective(Organazation organazation);

    void remove(String primaryKey);
    
    Organazation queryOrgAndUser(String primaryKey);
}