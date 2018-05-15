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
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstruct;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstructVo;
import com.csot.recruit.service.flow.websitePost.PostWebsiteInstructService;

@Controller
@RequestMapping("instruct")
public class PostWebsiteInstructController {
  private static final Logger logger = LoggerFactory.getLogger(PostWebsiteInstructController.class);

  @Resource
  private PostWebsiteInstructService postWebsiteInstructService;
  @Resource
  private CommonService commonService;

  /**
   * 跳转全部日程页面
   * 
   * @return
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/flow/websitePost/websitePostInstructList");
  }

  /**
   * 查询指令列表
   * 
   * @param pageSort
   * @param request
   * @return
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<PostWebsiteInstruct> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
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
    return postWebsiteInstructService.getGrid(pageSort, col);
  }



  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteInstructEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    PostWebsiteInstruct postWebsiteInstruct = postWebsiteInstructService.getByPrimaryKey(id);
    request.setAttribute("postWebsiteInstruct", postWebsiteInstruct);
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteInstructEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    PostWebsiteInstruct postWebsiteInstruct = postWebsiteInstructService.getByPrimaryKey(id);
    request.setAttribute("postWebsiteInstruct", postWebsiteInstruct);
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteInstructView");
  }

  /**
   * 完成指令操作
   * 
   * @param id
   * @return
   */
  @RequestMapping("changeInstructState/{ids}")
  @ResponseBody
  public AjaxRtnJson changeInstructState(@PathVariable String ids, @CurrentUser SysUser sysUser) {
    try {
      postWebsiteInstructService.changeInstructState(ids, sysUser);
      return new AjaxRtnJson(true, "操作成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "操作失败: " + e.getMessage());
    }
  }


  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      postWebsiteInstructService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(PostWebsiteInstruct postWebsiteInstruct) {
    if (StringUtils.hasText(postWebsiteInstruct.getId())) {
      try {
        postWebsiteInstructService.updateSelective(postWebsiteInstruct);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        postWebsiteInstruct.setId(UUID.randomUUID().toString().replace("-", ""));
        postWebsiteInstructService.create(postWebsiteInstruct);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 导出网站岗位一览
   * 
   * @param sysUser
   * @param request
   * @param response
   */
  @RequestMapping("exportInstruct")
  @ResponseBody
  public void exportInstruct(@CurrentUser SysUser sysUser, HttpServletRequest request,
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
    MiniRtn2Grid<PostWebsiteInstruct> grid =
        postWebsiteInstructService.getGrid(new MiniGridPageSort(), col);
    List<PostWebsiteInstructVo> postWebsiteInstructVos = new ArrayList<PostWebsiteInstructVo>();
    SimpleDateFormat yyyyMMddhhmm = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    for (PostWebsiteInstruct postWebsiteInstruct : grid.getData()) {
      PostWebsiteInstructVo postWebsiteInstructVo = new PostWebsiteInstructVo(postWebsiteInstruct);
      postWebsiteInstructVo.setInstructTypeName(EnumUtil
          .getInstructNameByType(postWebsiteInstructVo.getInstructType()));
      postWebsiteInstructVo.setAfterStateName(EnumUtil
          .getStateNameByType(postWebsiteInstructVo.getAfterState()));
      postWebsiteInstructVo.setBeforeStateName(EnumUtil
          .getStateNameByType(postWebsiteInstructVo.getBeforeState()));
      postWebsiteInstructVo.setWebsiteTypeName(EnumUtil
          .getWebsiteNameByType(postWebsiteInstructVo.getWebsiteType()));
      postWebsiteInstructVo.setInstructDateName(yyyyMMddhhmm.format(postWebsiteInstructVo
          .getCreateDate()));
      postWebsiteInstructVo.setIsDealName(EnumUtil.getIsDealNameByType(postWebsiteInstructVo
          .getIsDeal()));
      postWebsiteInstructVos.add(postWebsiteInstructVo);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "exportInstruct" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/instructExportTemplate.xml";
    String templatePath = "excelTemplate/instructExportTemplate.xls";
    commonService.exportByTemplate(response, fileName, postWebsiteInstructVos, xmlPath,
        templatePath);
  }
}
