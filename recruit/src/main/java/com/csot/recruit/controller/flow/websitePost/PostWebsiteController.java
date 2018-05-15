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
import com.csot.recruit.model.original.flow.websitePost.InstructSimpleDetail;
import com.csot.recruit.model.original.flow.websitePost.PostWebsite;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteVo;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteWithBLOBs;
import com.csot.recruit.service.flow.websitePost.PostWebsiteService;

@Controller
@RequestMapping("postWebsite")
public class PostWebsiteController {
  private static final Logger logger = LoggerFactory.getLogger(PostWebsiteController.class);

  @Resource
  private PostWebsiteService postWebsiteService;
  @Resource
  private CommonService commonService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/flow/websitePost/websitePostList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<PostWebsite> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String tabState = request.getParameter("tabState");
    String state = request.getParameter("state");
    String instructType = request.getParameter("instructType");
    String postNameStr = request.getParameter("postNameStr");
    String webpostName = request.getParameter("webpostName");
    Map<String, String> col = new HashMap<String, String>();
    col.put("tabState", tabState);
    col.put("state", state);
    col.put("instructType", instructType);
    col.put("postNameStr", postNameStr);
    col.put("webpostName", webpostName);
    return postWebsiteService.getGrid(pageSort, col);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    PostWebsite postWebsite = postWebsiteService.getByPrimaryKey(id);
    request.setAttribute("postWebsite", postWebsite);
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    PostWebsite postWebsite = postWebsiteService.getByPrimaryKey(id);
    request.setAttribute("postWebsite", postWebsite);
    return new ModelAndView("com/csot/recruit/flow/websitePost/postWebsiteView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      postWebsiteService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 进入发布岗位指令预览界面
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("instructPreview/{id}")
  public ModelAndView instructPreview(@PathVariable String id, HttpServletRequest request) {
    request.setAttribute("postId", id);
    return new ModelAndView("com/csot/flow/websitePost/instructPreview");
  }

  /**
   * 发布岗位指令预览界面列表
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("instructPreviewList/{postId}")
  @ResponseBody
  public List<InstructSimpleDetail> instructPreviewList(@PathVariable String postId,
      MiniGridPageSort pageSort, HttpServletRequest request) {
    String websiteTypes = request.getParameter("websiteTypes");
    String content = request.getParameter("content");
    String content2 = request.getParameter("content2");
    String name = request.getParameter("name");
    
    Map<String, String> colMap = new HashMap<String, String>();
    
    colMap.put("name", name); // 岗位编码
    colMap.put("postId", postId); // 岗位编码
    colMap.put("content", content); // 岗位编码
    colMap.put("content2", content2); // 岗位编码
    colMap.put("websiteTypes", websiteTypes); // 勾选岗位id
    return postWebsiteService.getGridByPostId(pageSort, colMap);
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(PostWebsiteWithBLOBs postWebsite) {
    if (StringUtils.hasText(postWebsite.getId())) {
      try {
        postWebsiteService.updateSelective(postWebsite);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        postWebsite.setId(UUID.randomUUID().toString().replace("-", ""));
        postWebsiteService.create(postWebsite);
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
  @RequestMapping("exportWebsiteList")
  @ResponseBody
  public void exportWebsiteList(@CurrentUser SysUser sysUser, HttpServletRequest request,
      HttpServletResponse response) {
    String tabState = request.getParameter("tabState");
    String state = request.getParameter("state");
    String instructType = request.getParameter("instructType");
    String postNameStr = request.getParameter("postNameStr");
    String webpostName = request.getParameter("webpostName");
    Map<String, String> col = new HashMap<String, String>();
    col.put("tabState", tabState);
    col.put("state", state);
    col.put("instructType", instructType);
    col.put("postNameStr", postNameStr);
    col.put("webpostName", webpostName);
    MiniRtn2Grid<PostWebsite> grid = postWebsiteService.getGrid(new MiniGridPageSort(), col);
    List<PostWebsiteVo> postWebsiteVos = new ArrayList<PostWebsiteVo>();
    SimpleDateFormat yyyyMMddhhmm=new SimpleDateFormat("yyyy-MM-dd hh:mm");
    for (PostWebsite postWebsite : grid.getData()) {
      PostWebsiteVo postWebsiteVo = new PostWebsiteVo(postWebsite);
      postWebsiteVo.setLastInstructName(EnumUtil.getInstructNameByType(postWebsiteVo
          .getLastInstruct()));
      postWebsiteVo.setStateName(EnumUtil.getStateNameByType(postWebsiteVo.getState()));
      postWebsiteVo.setWebsiteTypeName(EnumUtil.getWebsiteNameByType(postWebsiteVo
          .getWebsiteType()));
      postWebsiteVo.setInstructDateName(yyyyMMddhhmm.format(postWebsiteVo.getInstructDate()));
      postWebsiteVos.add(postWebsiteVo);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "exportWebsite" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/websiteExportTemplate.xml";
    String templatePath = "excelTemplate/websiteExportTemplate.xls";
    commonService.exportByTemplate(response, fileName, postWebsiteVos, xmlPath, templatePath);
  }
}
