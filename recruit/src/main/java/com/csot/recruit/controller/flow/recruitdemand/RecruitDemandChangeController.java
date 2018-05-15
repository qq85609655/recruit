package com.csot.recruit.controller.flow.recruitdemand;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.service.BaseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandChange;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandChangeService;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.template.TemplateService;

@Controller
@RequestMapping("visitor/recruitDemandChangeController")
public class RecruitDemandChangeController {
  private static final Logger logger = LoggerFactory.getLogger(RecruitDemandChangeController.class);

  @Resource
  private RecruitDemandChangeService recruitDemandChangeService;
  @Resource
  private RecruitDemandService recruitDemandService;
  @Resource
  private MailSendService mailSendService;
  @Resource
  private BaseUserService baseUserService;
  @Resource
  private TemplateService templateService;

  

  

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/recruitdemand/recruitDemandChangeEdit");
  }

  /**
   * 跳转审核招聘需求字段修改页面
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("toCheck/{id}")
  public ModelAndView toCheck(@PathVariable String id, HttpServletRequest request) {
    RecruitDemandChange recruitDemandChange = recruitDemandChangeService.getByPrimaryKey(id);
    if (StringUtil.isNotEmpty(recruitDemandChange.getDemandId())) {
      RecruitDemand recruitDemand =
          recruitDemandService.getByPrimaryKey(recruitDemandChange.getDemandId());
      request.setAttribute("recruitDemand", recruitDemand);
    }
    BaseUser baseUser = baseUserService.getBaseUserByPrimaryKey(recruitDemandChange.getCreatorId());
    request.setAttribute("upUser", baseUser.getName());
    request.setAttribute("recruitDemandChange", recruitDemandChange);
    return new ModelAndView("com/csot/flow/recruitdemand/updateCheck");
  }

  /**
   * 审核修改申请
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("check/{id}/{isAgree}")
  @ResponseBody
  public AjaxRtnJson check(@PathVariable String id, @PathVariable String isAgree,
      HttpServletRequest request) {
    try {

      // 修改申请记录表
      RecruitDemandChange recruitDemandChange = recruitDemandChangeService.getByPrimaryKey(id);
      if (RecruitDemandChange.isDeal.YES.valueStr().equals(recruitDemandChange.getIsDeal())) {
        return new AjaxRtnJson(false, "审批失败: 该请求已被审核");
      }
      recruitDemandChange.setIsAgerr(isAgree);
      RecruitDemand recruitDemand =
          recruitDemandService.getByPrimaryKey(recruitDemandChange.getDemandId());
      BaseUser baseUser = baseUserService.getBaseUserByPrimaryKey(recruitDemand.getCreatorId());
      recruitDemandChangeService.updateSelectiveSelf(recruitDemandChange, baseUser, recruitDemand);
      return new AjaxRtnJson(true, "审批成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "审批失败: " + e.getMessage());
    }
  }

  /**
   * 跳转审核招聘需求字段修改完成页面
   * 
   * @return
   */
  @RequestMapping("checkOk")
  public ModelAndView checkOk(@PathVariable String id) {
    return new ModelAndView("com/csot/flow/recruitdemand/updateCheckOk");
  }


  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    RecruitDemandChange recruitDemandChange = recruitDemandChangeService.getByPrimaryKey(id);
    request.setAttribute("recruitDemandChange", recruitDemandChange);
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandChangeView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      recruitDemandChangeService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(@CurrentUser SysUser sysUser, RecruitDemandChange recruitDemandChange) {
    if (StringUtils.hasText(recruitDemandChange.getId())) {
      try {
        recruitDemandChangeService.updateSelective(recruitDemandChange);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        RecruitDemand recruitDemand =
            recruitDemandService.getByPrimaryKey(recruitDemandChange.getDemandId());
        BaseUser baseUser = baseUserService.getBaseUserByPrimaryKey(recruitDemand.getCreatorId());
        List<RecruitDemandChange> recruitDemandChanges =
            recruitDemandChangeService.getInfoWithNotDeal(recruitDemand.getId(),
                recruitDemandChange.getType());
        if (recruitDemandChanges != null && recruitDemandChanges.size() > 0) {
          return recruitDemandChangeService.urge(recruitDemandChanges.get(0), baseUser.getEmail());
        }
        if (RecruitDemandChange.type.APPLYNUM.valueStr().equals(recruitDemandChange.getType())) {
          // 修改申请人数
          // 判断人数有没有变化
          if (recruitDemandChange.getNewStr().equals(
              recruitDemand.getApplyPersonNumber().toString())) {
            return new AjaxRtnJson(false, "申请失败: 数据没有修改");
          }
          // 设置旧值
          recruitDemandChange.setOldStr(recruitDemand.getApplyPersonNumber().toString());

        }
        if (RecruitDemandChange.type.WANTCOMEDATE.valueStr().equals(recruitDemandChange.getType())) {
          // 修改期望到岗时间
          if (recruitDemandChange.getNewStr().equals(recruitDemand.getWantComeDate())) {
            return new AjaxRtnJson(false, "申请失败: 数据没有修改");
          }
          // 设置旧值
          recruitDemandChange.setOldStr(recruitDemand.getWantComeDate().toString());
        }

        recruitDemandChange.setCreateDate(new Date());
        recruitDemandChange.setCreatorId(sysUser.getId());
        recruitDemandChange.setIsDeal(RecruitDemandChange.isDeal.NO.valueStr());
        String recruitDemandChangeId = UUID.randomUUID().toString().replace("-", "");
        recruitDemandChange.setId(recruitDemandChangeId);

        return recruitDemandChangeService.create(recruitDemandChange, baseUser.getEmail());

      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "申请失败: " + e.getMessage());
      }
    }
  }


  @RequestMapping("sendEmail")
  @ResponseBody
  public AjaxRtnJson
      sendEmail(@CurrentUser SysUser sysUser, RecruitDemandChange recruitDemandChange) {
    try {
      recruitDemandChange = recruitDemandChangeService.getByPrimaryKey(recruitDemandChange.getId());
      // 获取需求创建人邮箱
      RecruitDemand recruitDemand =
          recruitDemandService.getByPrimaryKey(recruitDemandChange.getDemandId());
      BaseUser baseUser = baseUserService.getBaseUserByPrimaryKey(recruitDemand.getCreatorId());
      Template eTemplate = new Template();
      eTemplate = templateService.getByPrimaryKey(Constant.DEMAND_CHANGE_EMAIL_TEMPLATEID);
      PropertiesUtil propertiesUtil = new PropertiesUtil();
      String projectUrl = propertiesUtil.readProperty("projectUrl");
      recruitDemandChange.setDemandChangeUrl(projectUrl
          + "visitor/recruitDemandChangeController/toCheck/" + recruitDemandChange.getId());
      mailSendService.sendEmail(baseUser.getEmail(), eTemplate, recruitDemandChange);
      AjaxRtnJson ajaxRtnJson = new AjaxRtnJson(true, "申请成功");
      ajaxRtnJson.setAttributes(new HashMap<String, Object>());
      return ajaxRtnJson;
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "申请失败: " + e.getMessage());
    }
  }
}
