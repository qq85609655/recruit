package com.csot.recruit.service.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShare;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface RecruitDemandShareService {
    MiniRtn2Grid<RecruitDemandShare> getGrid(MiniGridPageSort pageSort, String searchKey);

    RecruitDemandShare getByPrimaryKey(String primaryKey);

    void create(RecruitDemandShare recruitDemandShare,SysUser sysUser);

    void updateSelective(RecruitDemandShare recruitDemandShare);

    void remove(String primaryKey);

    AjaxRtnJson removeShare(String demandId);
}