package com.csot.recruit.controller.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployBlacklist;
import com.csot.recruit.service.flow.employ.EmployBlacklistService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
@RequestMapping("employBlacklistController")
public class EmployBlacklistController {
  private static final Logger logger = LoggerFactory.getLogger(EmployBlacklistController.class);

  @Resource
  private EmployBlacklistService employBlacklistService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/flow/employ/employBlackList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<EmployBlacklist> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String candidateName = request.getParameter("candidateName");
    String state = request.getParameter("state");
    String inReason = request.getParameter("inReason");
    String outReason = request.getParameter("outReason");
    Map<String, String> col = new HashMap<String, String>();
    col.put("candidateName", candidateName);
    col.put("state", state);
    col.put("inReason", inReason);
    col.put("outReason", outReason);
    return employBlacklistService.getGrid(pageSort, col);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/employ/employBlacklistEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    EmployBlacklist employBlacklist = employBlacklistService.getByPrimaryKey(id);
    request.setAttribute("employBlacklist", employBlacklist);
    return new ModelAndView("com/csot/recruit/flow/employ/employBlacklistEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    EmployBlacklist employBlacklist = employBlacklistService.getByPrimaryKey(id);
    request.setAttribute("employBlacklist", employBlacklist);
    return new ModelAndView("com/csot/recruit/flow/employ/employBlacklistView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      employBlacklistService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(EmployBlacklist employBlacklist, @CurrentUser SysUser sysUser) {
    if (StringUtils.hasText(employBlacklist.getId())) {
      try {
        employBlacklist.setState(EmployBlacklist.state.NO.valueStr());
        employBlacklist.setModifiedId(sysUser.getId());
        employBlacklist.setUpdateDate(new Date());
        employBlacklistService.updateSelective(employBlacklist);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        employBlacklist.setId(UUID.randomUUID().toString().replace("-", ""));
        employBlacklist.setCreateDate(new Date());
        employBlacklist.setCreatorId(sysUser.getId());
        employBlacklist.setState(EmployBlacklist.state.YES.valueStr());
        return employBlacklistService.create(employBlacklist);
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }
}
