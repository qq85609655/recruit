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
@RequestMapping("recruitDemandChangeControllerLogin")
public class RecruitDemandChangeControllerLogin {
  private static final Logger logger = LoggerFactory
      .getLogger(RecruitDemandChangeControllerLogin.class);

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

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandChangeList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<RecruitDemandChange> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return recruitDemandChangeService.getGrid(pageSort, searchKey);
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
        // 存在未处理的申请
        if (recruitDemandChanges != null && recruitDemandChanges.size() > 0) {
          return recruitDemandChangeService.urge(recruitDemandChanges.get(0), baseUser.getEmail());
        }
        if (RecruitDemandChange.type.APPLYNUM.valueStr().equals(recruitDemandChange.getType())) {
          // 修改申请人数
          if (recruitDemandChange.getNewStr().equals(
              recruitDemand.getApplyPersonNumber().toString())) {// 判断人数有没有变化
            return new AjaxRtnJson(false, "申请失败: 数据没有修改");
          }
          // 判断修改后的人数是不是比已经入职的人数小
          if (Integer.valueOf(recruitDemandChange.getNewStr()) < recruitDemand.getEntryNumber()) {
            return new AjaxRtnJson(false, "申请失败: 不能小于已经入职的人数");
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

}
