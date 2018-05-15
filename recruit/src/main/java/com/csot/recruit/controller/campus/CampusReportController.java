package com.csot.recruit.controller.campus;

import com.csot.recruit.model.extension.campus.CampusJobFamilyAchievement;
import com.csot.recruit.model.extension.campus.CampusReportExt;
import com.csot.recruit.service.campus.CampusReportService;
import com.csot.recruit.service.campus.CampusTaskService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.servlet.URLDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("campusReportController") public class CampusReportController {
  private static final Logger logger = LoggerFactory.getLogger(CampusReportController.class);

  @Resource private CampusReportService campusReportService;
  @Resource private CampusTaskService campusTaskService;

  @RequestMapping("campusMain") public ModelAndView campusMain(HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    } else {
      yearth = campusTaskService.getGrid4Yearth().get(0).getYearth();
    }
    CampusReportExt cre =
        campusReportService.getReportByOrganizationSitePostYearth4Type("", "", "", yearth, "firstTask");
    request.setAttribute("cre", cre);
    return new ModelAndView("com/csot/campus/campusMain");
  }

  @RequestMapping("list4Site") public ModelAndView list4Site() {
    return new ModelAndView("com/csot/campus/campusReportSiteList");
  }

  @RequestMapping("list4Post") public ModelAndView list4Post() {
    return new ModelAndView("com/csot/campus/campusReportPostList");
  }

  @RequestMapping("datagrid4Site") @ResponseBody
  public List<CampusReportExt> datagrid4Site(HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    String postId = request.getParameter("postId");
    String organizationId = request.getParameter("organizationId");
    return campusReportService.getGrid4Site(yearth, postId, organizationId);
  }

  @RequestMapping("datagrid4Post") @ResponseBody
  public List<CampusReportExt> datagrid4Post(HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    String siteId = request.getParameter("siteId");
    String organizationId = request.getParameter("organizationId");
    return campusReportService.getGrid4Post(yearth, siteId, organizationId);
  }

  @RequestMapping("export4Site") @ResponseBody
  public void export4Site(HttpServletRequest request, HttpServletResponse response) {
    String postId = request.getParameter("postId");
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    }
    String orgId = request.getParameter("organizationId");
    List<CampusReportExt> list = campusReportService.getGrid4Site(yearth, postId, orgId);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "CampusReportExcel" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/CampusReportExportTemplate.xml";
    String templatePath = "excelTemplate/CampusReportExportTemplate.xls";
    campusTaskService.exportByTemplate(response, fileName, list, xmlPath, templatePath);
  }

  @RequestMapping("export4Post") @ResponseBody
  public void export4Post(HttpServletRequest request, HttpServletResponse response) {
    String siteId = request.getParameter("siteId");
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    }
    String orgId = request.getParameter("organizationId");
    List<CampusReportExt> list = campusReportService.getGrid4Post(yearth, siteId, orgId);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "CampusReportExcel" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/CampusReportExportTemplate.xml";
    String templatePath = "excelTemplate/CampusReportExportTemplate.xls";
    campusTaskService.exportByTemplate(response, fileName, list, xmlPath, templatePath);
  }

  /**
   * 获取站点任务达成数据
   *
   * @param request
   * @param response
   */
  @RequestMapping("getChartData") public void getChartData(HttpServletRequest request,
      HttpServletResponse response) {
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    }
    List<CampusReportExt> list = campusReportService.getGrid4Site(yearth, "", "");
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String treeJson = gson.toJson(list);
    response.setContentType("application/json");
    response.setHeader("Cache-Control", "no-store");
    PrintWriter pw;
    try {
      pw = response.getWriter();
      pw.write(treeJson);
      pw.flush();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 获取职位族达成率
   *
   * @param request
   * @param response
   */
  @RequestMapping("getJobFamilyAchievement") public void getJobFamilyAchievement(
      HttpServletRequest request, HttpServletResponse response) {
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    }
    List<CampusJobFamilyAchievement> list =
        campusReportService.getJobFamilyAchievementByYearth(yearth);
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String treeJson = gson.toJson(list);
    response.setContentType("application/json");
    response.setHeader("Cache-Control", "no-store");
    PrintWriter pw;
    try {
      pw = response.getWriter();
      pw.write(treeJson);
      pw.flush();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }
}
