package com.csot.recruit.controller.resumelibrary.addressbook;

import com.csot.recruit.model.original.resumelibrary.addressbook.Addressbook;
import com.csot.recruit.service.resumelibrary.addressbook.AddressbookService;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
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

@Controller
@RequestMapping("addressbookController")
public class AddressbookController {
  private static final Logger logger = LoggerFactory.getLogger(AddressbookController.class);

  @Resource
  private AddressbookService addressbookService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/addressbook/addressbookList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<Addressbook> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String personName = request.getParameter("personName");
    String company = request.getParameter("company");
    String remark = request.getParameter("remark");
    return addressbookService.getGrid(pageSort, personName, company, remark);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/addressbook/addressbookEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    Addressbook addressbook = addressbookService.getByPrimaryKey(id);
    request.setAttribute("addressbook", addressbook);
    return new ModelAndView("com/csot/addressbook/addressbookEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    Addressbook addressbook = addressbookService.getByPrimaryKey(id);
    request.setAttribute("addressbook", addressbook);
    return new ModelAndView("com/csot/recruit/resumelibrary/addressbook/addressbookView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      addressbookService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(Addressbook addressbook, @CurrentUser SysUser sysUser) {
    if (StringUtils.hasText(addressbook.getId())) {
      try {
        addressbook.setChangeTime(new Date());
        addressbook.setChangeUserId(sysUser.getAccount());
        addressbookService.updateSelective(addressbook);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        addressbook.setCreateTime(new Date());
        addressbook.setCreateUserId(sysUser.getAccount());
        addressbook.setId(UUID.randomUUID().toString().replace("-", ""));
        addressbookService.create(addressbook);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("importAddressbook")
  public ModelAndView importAddressbook() {
    return new ModelAndView("com/csot/addressbook/addressbookImport");
  }

  /**
   * 导入通讯录
   */
  @RequestMapping("excelImport")
  @ResponseBody
  public AjaxRtnJson excelImport(HttpServletRequest request, @CurrentUser SysUser sysUser) {   
    // 转型为MultipartHttpRequest：
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile("myFile");
    String basePath  = request.getServletContext().getRealPath("/resources/upload");
    try {
      int count = addressbookService.importAddressbook(multipartFile, basePath, sysUser.getAccount());
      return new AjaxRtnJson(true, "成功导入" + count + "条数据");
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  /**
   * 下载通讯录导入模板
   */
  @RequestMapping("temple")
  public void temple(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String filePath =
        request.getSession().getServletContext().getRealPath("")
            + "/excelTemplate/addressbook.xlsx";
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
        "attachment; filename=" + URLEncoder.encode("通讯录导入模板.xlsx", "utf-8").replace("+", "%20"));
    OutputStream out = response.getOutputStream();
    while ((len = br.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    br.close();
    out.close();
  }
}
