package com.csot.recruit.service.flow.recruitdemand;

import java.util.Map;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandByHandler;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandVo;

public interface RecruitDemandService {
    MiniRtn2Grid<RecruitDemandVo> getGrid(MiniGridPageSort pageSort, Map<String, String> searchMap);

    RecruitDemand getByPrimaryKey(String primaryKey);

    void create(RecruitDemand recruitDemand, SysUser sysUser);

    void updateSelective(RecruitDemand recruitDemand, SysUser sysUser);
    /**
     * 特殊修改 记录操作日志
     * @param recruitDemand
     * @param recruitDemandOld
     * @param sysUser 
     */
    void updateSelectiveSelf(RecruitDemand recruitDemand,RecruitDemand recruitDemandOld, SysUser sysUser);

    void remove(String primaryKey);

    /**
     * 根据招聘单号获取招聘需求
     * @param demandId
     * @return
     */
    RecruitDemand getByDemandId(String demandId,SysUser sysUser);

    MiniRtn2Grid<RecruitDemandByHandler> getGridByHandler(MiniGridPageSort pageSort,
        Map<String, String> searchMap);

    void updateStatusByOA(RecruitDemand demand);


}