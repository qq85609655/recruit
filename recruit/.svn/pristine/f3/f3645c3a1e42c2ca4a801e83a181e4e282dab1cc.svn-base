package com.csot.recruit.controller.flow.websitePost;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.EnumUtil;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLog;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLogVo;
import com.csot.recruit.service.flow.websitePost.PostWebsiteLogService;

@Controller
@RequestMapping("postWebsiteLog")
public class PostWebsiteLogController {
  private static final Logger logger = LoggerFactory.getLogger(PostWebsiteLogController.class);

  @Resource
  private PostWebsiteLogService postWebsiteLogService;
  @Resource
  private CommonService commonService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/flow/websitePost/websitePostLogList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<PostWebsiteLog>
      datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String tabState = request.getParameter("tabState");
    String bState = request.getParameter("bState");
    String aState = request.getParameter("aState");
    String instructType = request.getParameter("instructType");
    String isDeal = request.getParameter("isDeal");
    String postNameStr = request.getParameter("postNameStr");
    String webpostName = request.getParameter("webpostName");
    Map<String, String> col = new HashMap<String, String>();
    col.put("tabState", tabState);
    col.put("bState", bState);
    col.put("aState", aState);
    col.put("instructType", instructType);
    col.put("postNameStr", postNameStr);
    col.put("isDeal", isDeal);
    col.put("webpostName", webpostName);
    return postWebsiteLogService.getGrid(pageSort, col);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteLogEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    PostWebsiteLog postWebsiteLog = postWebsiteLogService.getByPrimaryKey(id);
    request.setAttribute("postWebsiteLog", postWebsiteLog);
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteLogEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    PostWebsiteLog postWebsiteLog = postWebsiteLogService.getByPrimaryKey(id);
    request.setAttribute("postWebsiteLog", postWebsiteLog);
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteLogView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      postWebsiteLogService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(PostWebsiteLog postWebsiteLog) {
    if (StringUtils.hasText(postWebsiteLog.getId())) {
      try {
        postWebsiteLogService.updateSelective(postWebsiteLog);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        postWebsiteLog.setId(UUID.randomUUID().toString().replace("-", ""));
        postWebsiteLogService.create(postWebsiteLog);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 导出全部日程
   * 
   * @param sysUser
   * @param request
   * @param response
   */
  @RequestMapping("exportInstuctLog")
  @ResponseBody
  public void exportInstuctLog(@CurrentUser SysUser sysUser, HttpServletRequest request,
      HttpServletResponse response) {
    String tabState = request.getParameter("tabState");
    String bState = request.getParameter("bState");
    String aState = request.getParameter("aState");
    String instructType = request.getParameter("instructType");
    String isDeal = request.getParameter("isDeal");
    String postNameStr = request.getParameter("postNameStr");
    String webpostName = request.getParameter("webpostName");
    Map<String, String> col = new HashMap<String, String>();
    col.put("tabState", tabState);
    col.put("bState", bState);
    col.put("aState", aState);
    col.put("instructType", instructType);
    col.put("postNameStr", postNameStr);
    col.put("isDeal", isDeal);
    col.put("webpostName", webpostName);
    MiniRtn2Grid<PostWebsiteLog> grid = postWebsiteLogService.getGrid(new MiniGridPageSort(), col);
    List<PostWebsiteLogVo> postWebsiteLogVos = new ArrayList<PostWebsiteLogVo>();
    SimpleDateFormat yyyyMMddhhmm = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    for (PostWebsiteLog postWebsiteLog : grid.getData()) {
      PostWebsiteLogVo postWebsiteLogVo = new PostWebsiteLogVo(postWebsiteLog);
      postWebsiteLogVo.setLastInstructName(EnumUtil.getInstructNameByType(postWebsiteLogVo
          .getLastInstruct()));
      postWebsiteLogVo
          .setStateName(EnumUtil.getStateNameByType(postWebsiteLogVo.getState()));
      postWebsiteLogVo.setWebsiteTypeName(EnumUtil.getWebsiteNameByType(postWebsiteLogVo
          .getWebsiteType()));
      postWebsiteLogVo.setInstructDateName(yyyyMMddhhmm.format(postWebsiteLogVo.getInstructDate()));
      postWebsiteLogVo.setBeforeStateName(EnumUtil.getStateNameByType(postWebsiteLogVo
          .getBeforeState()));
      postWebsiteLogVos.add(postWebsiteLogVo);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "exportInstuctLog" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/instructLogExportTemplate.xml";
    String templatePath = "excelTemplate/instructLogExportTemplate.xls";
    commonService.exportByTemplate(response, fileName, postWebsiteLogVos, xmlPath, templatePath);
  }
}
