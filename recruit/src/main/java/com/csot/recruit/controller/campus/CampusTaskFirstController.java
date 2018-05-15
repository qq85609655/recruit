package com.csot.recruit.controller.campus;

import com.csot.recruit.model.original.campus.CampusTaskFirst;
import com.csot.recruit.service.campus.CampusTaskFirstService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csot.recruit.service.campus.CampusTaskService;
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

@Controller
@RequestMapping("campusTaskFirstController")
public class CampusTaskFirstController {
  private static final Logger logger = LoggerFactory.getLogger(CampusTaskFirstController.class);

  @Resource
  private CampusTaskFirstService campusTaskFirstService;
  @Resource
  private CampusTaskService campusTaskService;

  @RequestMapping("list")
  public ModelAndView list(HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    } else {
      yearth = campusTaskService.getGrid4Yearth().get(0).getYearth();
    }
    request.setAttribute("yearth", yearth);
    return new ModelAndView("com/csot/campus/campusTaskFirstList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<CampusTaskFirst> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    String organizationId = request.getParameter("organizationId");
    String siteId = request.getParameter("siteId");
    String postId = request.getParameter("postId");
    return campusTaskFirstService.getGrid(pageSort, yearth, organizationId, siteId, postId);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/campus/campusTaskFirstEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    CampusTaskFirst campusTaskFirst = campusTaskFirstService.getByPrimaryKey(id);
    request.setAttribute("campusTaskFirst", campusTaskFirst);
    return new ModelAndView("com/csot/recruit/campus/campusTaskFirstEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    CampusTaskFirst campusTaskFirst = campusTaskFirstService.getByPrimaryKey(id);
    request.setAttribute("campusTaskFirst", campusTaskFirst);
    return new ModelAndView("com/csot/recruit/campus/campusTaskFirstView");
  }

  @RequestMapping("remove/{ids}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String ids) {
    try {
      campusTaskFirstService.remove(ids);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(CampusTaskFirst campusTaskFirst) {
    if (StringUtils.hasText(campusTaskFirst.getId())) {
      try {
        campusTaskFirstService.updateSelective(campusTaskFirst);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        campusTaskFirst.setId(UUID.randomUUID().toString().replace("-", ""));
        campusTaskFirstService.create(campusTaskFirst);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("importCampusTaskFirst")
  public ModelAndView importAddressbook() {
    return new ModelAndView("com/csot/campus/campusTaskFirstImport");
  }

  /**
   * 导入初版任务信息
   */
  @RequestMapping("excelImport")
  @ResponseBody
  public AjaxRtnJson excelImport(
          HttpServletRequest request) {
    // 转型为MultipartHttpRequest：
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile("myFile");
    String basePath = request.getServletContext().getRealPath("/resources/upload");
    try {
      return campusTaskFirstService.importCampusTaskFirst(multipartFile, basePath);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }


  /**
   * exportTaskFirst
   *
   * @param request
   * @param response
   */
  @RequestMapping("exportTaskFirst")
  public void exportTaskFirst(HttpServletRequest request, HttpServletResponse response) {
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    }
    String organizationId = request.getParameter("organizationId");
    String siteId = request.getParameter("siteId");
    String postId = request.getParameter("postId");
    List<CampusTaskFirst> taskList = campusTaskFirstService
            .getTaskFirstByOrganizationSitePostYearth(organizationId, siteId, postId, yearth);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "CampusTaskFirstExcel" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/CampusTaskExportTemplate.xml";
    String templatePath = "excelTemplate/CampusTaskExportTemplate.xls";
    campusTaskService.exportByTemplate(response, fileName, taskList, xmlPath, templatePath);
  }
}