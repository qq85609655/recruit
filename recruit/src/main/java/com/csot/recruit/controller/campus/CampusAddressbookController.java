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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.servlet.URLDecoder;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.pojo.LoginClient;
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

import com.csot.recruit.dao.original.campus.CampusSiteMapper;
import com.csot.recruit.model.original.campus.CampusAddressbook;
import com.csot.recruit.model.original.campus.CampusSite;
import com.csot.recruit.model.original.campus.CampusSiteCriteria;
import com.csot.recruit.service.campus.CampusAddressbookService;
import com.csot.recruit.service.campus.CampusSiteService;
import com.csot.recruit.service.campus.CampusTaskService;

@Controller
@RequestMapping("campusAddressbookController")
public class CampusAddressbookController {
  private static final Logger logger = LoggerFactory.getLogger(CampusAddressbookController.class);

  @Resource
  private CampusAddressbookService campusAddressbookService;

  @Resource
  private CampusSiteService campusSiteService;

  @Resource
  private CampusTaskService campusTaskService;

  @Resource
  private CampusSiteMapper campusSiteMapper;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/campus/campusAddressbookList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<CampusAddressbook> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return campusAddressbookService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/campus/campusAddressbookEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    CampusAddressbook campusAddressbook = campusAddressbookService.getByPrimaryKey(id);
    request.setAttribute("campusAddressbook", campusAddressbook);
    return new ModelAndView("com/csot/campus/campusAddressbookEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    CampusAddressbook campusAddressbook = campusAddressbookService.getByPrimaryKey(id);
    request.setAttribute("campusAddressbook", campusAddressbook);
    return new ModelAndView("com/csot/campus/campusAddressbookView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      campusAddressbookService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(CampusAddressbook campusAddressbook) {
    // 通过siteId获取相应的siteName
    CampusSiteCriteria criteria = new CampusSiteCriteria();
    CampusSiteCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(campusAddressbook.getSiteId())) {
      criter.andSiteIdLikeInsensitive(campusAddressbook.getSiteId());
    }
    String siteName = campusSiteMapper.selectByExample(criteria).get(0).getSiteName();
    if (StringUtils.hasText(siteName)) {
      campusAddressbook.setSiteName(siteName);
    }

    if (StringUtils.hasText(campusAddressbook.getId())) {
      try {
        campusAddressbookService.updateSelective(campusAddressbook);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        campusAddressbook.setId(UUID.randomUUID().toString().replace("-", ""));
        campusAddressbookService.create(campusAddressbook);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("importAddressbook")
  public ModelAndView importAddressbook() {

    return new ModelAndView("com/csot/campus/campusAddressbookImport");
  }

  /**
   * 导入校招通讯录信息，即批量新增
   */
  @RequestMapping("importExcel")
  @ResponseBody
  public AjaxRtnJson importExcel(HttpServletRequest request) {
    LoginClient client =
        (LoginClient) request.getSession().getAttribute(LoginClient.CLIENT_SESSION_ATTR);
    BaseUser baseUser = new BaseUser();
    if (client != null) {
      baseUser = client.getUser();
    }
    String importer = baseUser.getName();

    // 转型为MultipartHttpRequest：
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile("myFile");
    String basePath = request.getServletContext().getRealPath("/resources/upload");
    try {
      String message =
          campusAddressbookService.importAddressbook(multipartFile, basePath, importer);

      return new AjaxRtnJson(true, message);

    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  /**
   * 下载校招通讯录导入模板
   */
  @RequestMapping("campusTemplete")
  public void campusTemplete(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    // 模板存放路径
    String filePath =
        request.getSession().getServletContext().getRealPath("")
            + "/excelTemplate/campusAddressbook.xls";
    File f = new File(filePath);
    if (!f.exists()) {
      response.sendError(404, "File not found!");
      return;
    }
    BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
    byte[] buf = new byte[1024];
    int len = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    response.reset();
    response.setContentType("application/x-msdownload");
    response.setHeader(
        "Content-Disposition",
        "attachment; filename="
            + URLEncoder.encode("校招通讯录导入模板" + sdf + ".xls", "utf-8").replace("+", "%20"));
    OutputStream out = response.getOutputStream();
    while ((len = br.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    br.close();
    out.close();
  }

  /**
   * 导出通讯录信息
   * 
   * @throws IOException
   */
  @RequestMapping("exportCampusTemplete")
  @ResponseBody
  public void exportCampusTemplete(HttpServletRequest request, HttpServletResponse response) {

    String realName = request.getParameter("realName");

    // url传参中文字符解码
    realName = URLDecoder.decode(realName, "utf-8");
    List<CampusAddressbook> campusList = campusAddressbookService.exportPartNoRealName(realName);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "CampusAddressbookInfo_" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/CampusAddressbookExportTemplate.xml";
    String templatePath = "excelTemplate/campusAddressbook.xls";
    campusTaskService.exportByTemplate(response, fileName, campusList, xmlPath, templatePath);
    // campusAddressbookService.exportCampusAddbookInfo(response,campusList);
  }

  // 获取站点信息，用于站点下拉框
  @RequestMapping("getSiteName")
  @ResponseBody
  public List<CampusSite> doGetSiteInfo(String siteId, String siteName) {

    return campusAddressbookService.doGetSiteInfo(siteId, siteName);
  }
}
