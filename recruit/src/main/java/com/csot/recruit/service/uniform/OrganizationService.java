package com.csot.recruit.service.uniform;

import java.util.List;

import com.csot.recruit.model.original.uniform.Organization;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface OrganizationService {
    List<Organization> getGrid(MiniGridPageSort pageSort, String searchKey);

    Organization getByPrimaryKey(String primaryKey);

    void create(Organization organization);

    void updateSelective(Organization organization);

    void remove(String primaryKey);
}