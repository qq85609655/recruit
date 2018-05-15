package com.csot.recruit.controller.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShare;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandService;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandShareService;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("recruitDemandShareController")
public class RecruitDemandShareController {
  private static final Logger logger = LoggerFactory.getLogger(RecruitDemandShareController.class);

  @Resource
  private RecruitDemandShareService recruitDemandShareService;
  @Resource
  private RecruitDemandService recruitDemandService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/recruit/flow/recruitdemand/recruitDemandShareList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<RecruitDemandShare> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return recruitDemandShareService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/recruitdemand/recruitDemandShareEdit");
  }

  /**
   * 取消共承
   * @param id
   * @return
   */
  @RequestMapping("removeShare/{demandId}")
  @ResponseBody
  public AjaxRtnJson removeShare(@PathVariable String demandId,@CurrentUser SysUser sysUser) {
    try {
      RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(demandId);
      if(recruitDemand.getDeputyId()==null ||recruitDemand.getDeputyId().equals("")||!recruitDemand.getDeputyId().equals(sysUser.getWorkCode())){
        return new AjaxRtnJson(false, "该招聘需求的招聘代表不是您，无法共承！");
      }
      return recruitDemandShareService.removeShare(demandId);
      // new AjaxRtnJson(true, "取消共承成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "取消共承失败: " + e.getMessage());
    }
  }
  
  /**
   * 验证是否是自己的需求
   * @param id
   * @return
   */
  @RequestMapping("checkShare/{demandId}")
  @ResponseBody
  public AjaxRtnJson checkShare(@PathVariable String demandId,@CurrentUser SysUser sysUser) {
    try {
      RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(demandId);
      if(recruitDemand.getDeputyId()==null ||recruitDemand.getDeputyId().equals("")||!recruitDemand.getDeputyId().equals(sysUser.getWorkCode())){
        return new AjaxRtnJson(false, "该招聘需求的招聘代表不是您，无法操作！");
      }
      return new AjaxRtnJson(true, "验证通过");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "取消共承失败: " + e.getMessage());
    }
  }
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    RecruitDemandShare recruitDemandShare = recruitDemandShareService.getByPrimaryKey(id);
    request.setAttribute("recruitDemandShare", recruitDemandShare);
    return new ModelAndView("com/csot/recruit/flow/recruitdemand/recruitDemandShareEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    RecruitDemandShare recruitDemandShare = recruitDemandShareService.getByPrimaryKey(id);
    request.setAttribute("recruitDemandShare", recruitDemandShare);
    return new ModelAndView("com/csot/recruit/flow/recruitdemand/recruitDemandShareView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      recruitDemandShareService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(@CurrentUser SysUser sysUser, RecruitDemandShare recruitDemandShare) {
    if (StringUtils.hasText(recruitDemandShare.getId())) {
      try {
        recruitDemandShareService.updateSelective(recruitDemandShare);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        if(sysUser.getWorkCode().equals(recruitDemandShare.getShaerPersonId())){
          return new AjaxRtnJson(false, "共承岗位失败: 无法共承给您自己！");
        }
        RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(recruitDemandShare.getRecruitDemandId());
        if(recruitDemand.getDeputyId()==null ||recruitDemand.getDeputyId().equals("")||!recruitDemand.getDeputyId().equals(sysUser.getWorkCode())){
          return new AjaxRtnJson(false, "该招聘需求的招聘代表不是您，无法共承！");
        }
        recruitDemandShare.setId(UUID.randomUUID().toString().replace("-", ""));
        recruitDemandShare.setCreatorId(sysUser.getId());
        recruitDemandShare.setCreateDate(new Date());
        recruitDemandShare.setPostId(recruitDemand.getApplyPostId());
        recruitDemandShareService.create(recruitDemandShare,sysUser);
        return new AjaxRtnJson(true, "共承岗位成功！");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "共承岗位失败: " + e.getMessage());
      }
    }
  }
}
