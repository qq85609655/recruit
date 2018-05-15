package com.csot.recruit.service.flow.recruitdemand;

import java.util.List;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandChange;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.model.BaseUser;

public interface RecruitDemandChangeService {
  MiniRtn2Grid<RecruitDemandChange> getGrid(MiniGridPageSort pageSort, String searchKey);

  RecruitDemandChange getByPrimaryKey(String primaryKey);

  AjaxRtnJson create(RecruitDemandChange recruitDemandChange, String email);

  void updateSelective(RecruitDemandChange recruitDemandChange);

  void remove(String primaryKey);

  /**
   * 获取未完成的字段修改申请
   * 
   * @param id 需求id
   * @param type 修改字段类型
   * @return
   */
  List<RecruitDemandChange> getInfoWithNotDeal(String id, String type);

  /**
   * 修改审核记录详情 生成修改记录
   * 
   * @param recruitDemandChange
   * @param baseUser
   */
  void updateSelectiveSelf(RecruitDemandChange recruitDemandChange, BaseUser baseUser,
      RecruitDemand recruitDemand);

  AjaxRtnJson urge(RecruitDemandChange recruitDemandChange, String email);

}
