package com.csot.recruit.controller.campus;

import com.csot.recruit.common.util.CampusUtils;
import com.csot.recruit.model.original.campus.CampusSite;
import com.csot.recruit.model.original.campus.CampusTask;
import com.csot.recruit.service.campus.CampusSiteService;
import com.csot.recruit.service.campus.CampusTaskService;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.servlet.URLDecoder;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("campusTaskController") public class CampusTaskController {
  private static final Logger logger = LoggerFactory.getLogger(CampusTaskController.class);

  @Resource private CampusTaskService campusTaskService;
  @Resource private CampusSiteService campusSiteService;

  /**
   * 跳转任务统计页面
   *
   * @return
   */
  @RequestMapping("list") public ModelAndView list() {
    return new ModelAndView("com/csot/campus/campusTaskList");
  }

  /**
   * 跳转任务详细信息页面
   *
   * @return
   */
  @RequestMapping("detailList") public ModelAndView detailList() {
    return new ModelAndView("com/csot/campus/campusTaskDetailList");
  }

  @RequestMapping("datagrid") @ResponseBody
  public MiniRtn2Grid<CampusTask> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    String organizationId = request.getParameter("organizationId");
    String siteId = request.getParameter("siteId");
    String postId = request.getParameter("postId");
    return campusTaskService.getGrid(pageSort, yearth, organizationId, siteId, postId);
  }

  @RequestMapping("datagrid4Sum") @ResponseBody
  public List<CampusTask> datagrid4Sum(HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    String organizationId = request.getParameter("organizationId");
    String siteId = request.getParameter("siteId");
    String postId = request.getParameter("postId");
    return campusTaskService.getGrid4Sum(yearth, organizationId, siteId, postId);
  }

  @RequestMapping("create") public ModelAndView create() {
    return new ModelAndView("com/csot/campus/campusTaskAdd");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    CampusTask campusTask = campusTaskService.getByPrimaryKey(id);
    request.setAttribute("campusTask", campusTask);
    return new ModelAndView("com/csot/campus/campusTaskEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    CampusTask campusTask = campusTaskService.getByPrimaryKey(id);
    request.setAttribute("campusTask", campusTask);
    return new ModelAndView("com/csot/recruit/campus/campusTaskView");
  }

  @RequestMapping("remove/{ids}") @ResponseBody public AjaxRtnJson remove(@PathVariable String ids) {
    try {
      String msg = campusTaskService.remove(ids);
      return new AjaxRtnJson(true, msg);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save") @ResponseBody public AjaxRtnJson save(CampusTask campusTask) {
    if (StringUtils.hasText(campusTask.getId())) {
      try {
        // 检查站点是否已停用,停用站点的任务不允许修改
        String siteName = campusTask.getSiteName();
        CampusSite site = campusSiteService.getBySiteIdOrName("", siteName);
        if (!"1".equals(site.getStatus())) {
          return new AjaxRtnJson(false, "修改失败: 站点[" + siteName + "]已停用");
        } else {
          campusTaskService.updateSelective(campusTask);
          return new AjaxRtnJson(true, "修改成功");
        }
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        String yearth = CampusUtils.getCurrentYearth();
        campusTask.setYearth(yearth);
        CampusTask task = campusTaskService.checkTaskIsExsit(campusTask);
        if (null != task) {
          return new AjaxRtnJson(false, "该任务已存在，不可创建");
        }
        campusTask.setId(UUID.randomUUID().toString().replace("-", ""));
        campusTaskService.create(campusTask);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("datagrid4Yearth") @ResponseBody public List<CampusTask> datagrid4Yearth() {
    return campusTaskService.getGrid4Yearth();
  }

  @RequestMapping("importCampusTask") public ModelAndView importAddressbook() {
    return new ModelAndView("com/csot/campus/campusTaskImport");
  }

  /**
   * 导入任务信息
   */
  @RequestMapping("excelImport") @ResponseBody public AjaxRtnJson excelImport(
      HttpServletRequest request) {
    // 转型为MultipartHttpRequest：
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile("myFile");
    String basePath = request.getServletContext().getRealPath("/resources/upload");
    try {
      return campusTaskService.importCampusTask(multipartFile, basePath);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  /**
   * 下载任务导入模板
   */
  @RequestMapping("temple") public void temple(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    String filePath =
        request.getSession().getServletContext().getRealPath("") + "/excelTemplate/campusTask.xlsx";
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
        "attachment; filename=" + URLEncoder.encode("任务导入模板.xlsx", "utf-8").replace("+", "%20"));
    OutputStream out = response.getOutputStream();
    while ((len = br.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    br.close();
    out.close();
  }

  /**
   * exportTask
   * @param request
   * @param response
   */
  @RequestMapping("exportTask")
  public void exportTask(HttpServletRequest request, HttpServletResponse response) {
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    }
    String organizationId = request.getParameter("organizationId");
    String siteId = request.getParameter("siteId");
    String postId = request.getParameter("postId");
    List<CampusTask> taskList = campusTaskService
        .getTaskByOrganizationSitePostYearth(organizationId, siteId, postId, yearth);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "CampusTaskExcel" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/CampusTaskExportTemplate.xml";
    String templatePath = "excelTemplate/CampusTaskExportTemplate.xls";
    campusTaskService.exportByTemplate(response, fileName, taskList, xmlPath, templatePath);
  }
}