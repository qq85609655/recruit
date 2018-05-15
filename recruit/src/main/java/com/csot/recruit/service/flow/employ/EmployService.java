package com.csot.recruit.service.flow.employ;

import java.util.List;
import java.util.Map;

import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.employ.EmployCandidate;
import com.csot.recruit.model.original.flow.employ.EmployEducation;
import com.csot.recruit.model.original.flow.employ.EmployWork;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface EmployService {
  MiniRtn2Grid<Employ> getGrid(MiniGridPageSort pageSort, Map<String, String> col);

  Employ getByPrimaryKey(String primaryKey);

  AjaxRtnJson create(Employ employ);

  void updateSelective(Employ employ);

  AjaxRtnJson remove(String primaryKey);

  void saveEmployInfo(EmployCandidate employCandidate, Employ employ, RecruitDemand recruitDemand, List<EmployWork> works, List<EmployEducation> edus, String attchmentIds,SysUser sysUser);

  void
      updateEmployInfo(EmployCandidate employCandidate, Employ employ, RecruitDemand recruitDemand, List<EmployWork> works, List<EmployEducation> edus, String attchmentIds, SysUser sysUser);

  AjaxRtnJson saveOffer(String ids);

  AjaxRtnJson entry(String ids);

  List<Employ> getEmployByCandidatePostId(Map<String,Object> param);
  
  AjaxRtnJson isBlackList(Employ employ);
}
