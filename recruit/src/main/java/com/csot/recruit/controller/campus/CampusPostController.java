package com.csot.recruit.controller.campus;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.csot.recruit.model.original.campus.CampusPost;
import com.csot.recruit.model.original.campus.CampusTask;
import com.csot.recruit.service.campus.CampusPostService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csot.recruit.service.campus.CampusTaskService;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("campusPostController")
public class CampusPostController {
  private static final Logger logger = LoggerFactory.getLogger(CampusPostController.class);

  @Resource
  private CampusPostService campusPostService;
  @Resource
  private CampusTaskService campusTaskService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/campus/campusPostList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<CampusPost> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String postId = request.getParameter("postId");
    String jobFamily = request.getParameter("jobFamily");
    String organization = request.getParameter("organization");
    return campusPostService.getGrid(pageSort, postId, jobFamily, organization);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/campus/campusPostAdd");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    CampusPost campusPost = campusPostService.getByPrimaryKey(id);
    request.setAttribute("campusPost", campusPost);
    return new ModelAndView("com/csot/campus/campusPostEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    CampusPost campusPost = campusPostService.getByPrimaryKey(id);
    request.setAttribute("campusPost", campusPost);
    return new ModelAndView("com/csot/campus/campusPostView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      String postId = campusPostService.getByPrimaryKey(id).getPostId();
      List<CampusTask> taskList = campusTaskService.getCampusTaskByPostId(postId);
      if (taskList.isEmpty()) {
        campusPostService.remove(id);
        return new AjaxRtnJson(true, "删除成功！");
      } else {
        return new AjaxRtnJson(false, "该岗位已在任务中，无法删除！");
      }
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(CampusPost campusPost) {
    if (StringUtils.hasText(campusPost.getId())) {
      try {
        campusPostService.updateSelective(campusPost);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      // 检查是否可创建
      CampusPost cp = campusPostService.getByPostIdAndJobFamily(campusPost.getPostId(), campusPost.getJobFamily());
      if (null != cp) {
        return new AjaxRtnJson(false, "操作失败: 该职位族下岗位已存在");
      }
      try {
        campusPost.setId(UUID.randomUUID().toString().replace("-", ""));
        campusPostService.create(campusPost);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("importCampusPost")
  public ModelAndView importAddressbook() {
    return new ModelAndView("com/csot/campus/campusPostImport");
  }

  /**
   * 导入岗位信息
   * @param request
   * @return
   */
  @RequestMapping("excelImport")
  @ResponseBody
  public AjaxRtnJson excelImport(HttpServletRequest request) {
    // 转型为MultipartHttpRequest：
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile("myFile");
    String basePath = request.getServletContext().getRealPath("/resources/upload");
    try {
      return campusPostService.importCampusPost(multipartFile, basePath);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  /**
   * 下载岗位导入模板
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping("temple")
  public void temple(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String filePath =
            request.getSession().getServletContext().getRealPath("")
                    + "/excelTemplate/campusPost.xlsx";
    File f = new File(filePath);
    if (!f.exists()) {
      response.sendError(404, "File not found!");
      return;
    }
    BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
    byte[] buf = new byte[1024];
    int len = 0;
    response.reset();
    response.setContentType("application/x-msdownload");
    response.setHeader("Content-Disposition",
            "attachment; filename=" + URLEncoder.encode("岗位导入模板.xlsx", "utf-8").replace("+", "%20"));
    OutputStream out = response.getOutputStream();
    while ((len = br.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    br.close();
    out.close();
  }

  @RequestMapping("getPostByFamily/{jobFamilyId}")
  @ResponseBody public List<CampusPost> getPostByFamily(@PathVariable String jobFamilyId) {
    return campusPostService.getPostByJobFamily(jobFamilyId);
  }

  @RequestMapping("exportPost")
  @ResponseBody public void exportPost(HttpServletRequest request, HttpServletResponse response) {
    String postId = request.getParameter("postId");
    String jobFamilyId = request.getParameter("jobFamilyId");
    String organizationId = request.getParameter("organizationId");
    List<CampusPost> list = campusPostService.getByPostJobFamilyOrganiztion(postId, jobFamilyId, organizationId);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "CampusPostExcel" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/CampusPostExportTemplate.xml";
    String templatePath = "excelTemplate/CampusPostExportTemplate.xls";
    campusTaskService.exportByTemplate(response, fileName, list, xmlPath, templatePath);
  }
}