package com.csot.gm.materialManage.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.csot.gm.materialManage.service.PropertyEnumService;
import com.csot.gm.rawMaterial.model.PartProperty;
import com.csot.gm.rawMaterial.model.PieChartObj;
import com.csot.gm.rawMaterial.model.PropertyCombo;
import com.csot.gm.rawMaterial.model.PropertyEnumType;
import com.csot.gm.rawMaterial.service.DataShowService;
import com.csot.gm.rawMaterial.service.ImportAndExportService;
import com.csot.gm.rawMaterial.service.PartNoAddService;
import com.csot.gm.util.BrowserUtils;
import com.csot.gm.util.PropertyUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("materialManage")
public class MaterialManageController {

  @Resource
  private PropertyEnumService propertyEnumService;
  @Resource
  private ImportAndExportService importAndExportService;
  @Resource
  private DataShowService dataShowService;

  @Resource
  private PartNoAddService partNoAddService;

  private static final Logger logger = LoggerFactory.getLogger(MaterialManageController.class);

  /**
   * 获取属性是否是下拉或唯一性（"Y","N"）
   * 
   * @return
   */
  @RequestMapping("getIsEnumOrIsUnique")
  @ResponseBody
  public List<PropertyCombo> getIsEnumOrIsUnique() {
    return PropertyUtil.getPropertyCombIsEnumOrIsUnique();
  }

  /**
   * 跳转到属性和枚举值关系管理界面
   * 
   * @return
   */
  @RequestMapping("propertyEnumManage")
  public ModelAndView propertyEnum() {
    return new ModelAndView("com/csot/gm/materialManage/propertyEnumManage");
  }

  /**
   * 跳转到属性维护界面
   * 
   * @return
   */
  @RequestMapping("propertyManage")
  public ModelAndView propertyManage() {
    return new ModelAndView("com/csot/gm/materialManage/propertyManage");
  }

  /**
   * 跳转到属性下拉值维护界面
   * 
   * @return
   */
  @RequestMapping("enumValueManage")
  public ModelAndView enumValueManage() {
    return new ModelAndView("com/csot/gm/materialManage/enumValueManage");
  }

  /**
   * 跳转到属性下拉值维护界面
   * 
   * @return
   */
  @RequestMapping("partManage")
  public ModelAndView partManage() {
    return new ModelAndView("com/csot/gm/materialManage/partManage");
  }

  /**
   * 跳转到用户查看料号信息页面
   * 
   * @return
   */
  @RequestMapping("partNoInfo4User")
  public ModelAndView partNoInfo4User() {
    return new ModelAndView("com/csot/gm/materialManage/partNoInfo4User");
  }

  /**
   * 返回属性和对应的枚举类值datagrid
   * 
   * @param partId
   * @return
   */
  @RequestMapping("propertyEnumDatagrid")
  @ResponseBody
  public List<PropertyEnumType> propertyEnumDatagrid(String partId) {
    return propertyEnumService.getPropertyEnumDatagrid(partId);
  }

  /**
   * 返回物料的属性datagrid
   * 
   * @param partId
   * @return
   */
  @RequestMapping("propertyDatagrid")
  @ResponseBody
  public List<PartProperty> propertyDatagrid(String partId) {
    return propertyEnumService.getPartPropertyDatagrid(partId);
  }


  /**
   * 下载物料录入模板
   * 
   * @param response
   * @return
   */
  @RequestMapping("downloadPartTemplate/{level}")
  public String downloadPartTemplate(HttpServletResponse response, @PathVariable String level) {
    return importAndExportService.getImportPartTemp(response, level);
  }


  /**
   * 上传物料分类
   * 
   * @param request
   * @return
   */
  @RequiresPermissions("enumValueManage:upload")
  @RequestMapping("upload/{level}")
  @ResponseBody
  public AjaxRtnJson uploadPart(HttpServletRequest request, @PathVariable String level,
      @CurrentUser SysUser sysUser) {

    // 转型为MultipartHttpRequest：
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile("excelDoc");
    String info = importAndExportService.uploadExcel(multipartFile, level, sysUser);
    AjaxRtnJson ajax = new AjaxRtnJson();

    if ("1".equals(info)) {
      ajax.setSuccess(true);
      ajax.setMsg("上传成功！");
    } else if ("2".equals(info)) {
      ajax.setSuccess(false);
      ajax.setMsg("上传出错");
    } else {
      ajax.setSuccess(false);
      ajax.setMsg("上传失败！");
    }
    return ajax;
  }

  /**
   * 下载新增模板
   */
  @RequestMapping("downloadExcel")
  @ResponseBody
  public AjaxRtnJson downloadExcel(HttpServletResponse response) {
    AjaxRtnJson ajax = new AjaxRtnJson();
    response.setCharacterEncoding("UTF-8");
    response.setContentType("multipart/form-data");
    try {
      response.setHeader("Content-Disposition",
          "attachment;fileName=" + new String("批量创建料号模板.xls".getBytes("gbk"), "iso-8859-1"));
      partNoAddService.exportTemplate(response);
      ajax.setSuccess(true);
    } catch (Exception ex) {
      logger.info("模板导出失败。", ex);
      ajax.setSuccess(false);
    }
    return ajax;
  }
  
  /**
   * 获取料号分布数据
   * 
   * @param response
   * @return
   */
  @RequestMapping("getPieChartsData4PartNo")
  public void getPieChartsData4PartNo(HttpServletResponse response) {
    List<PieChartObj> list = dataShowService.getPieChartsData4PartNo();;
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
   * 导出操作手册
   * 
   * @param response
   */
  @RequestMapping("exportHelpOp/{type}")
  public void exportHelpOp(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) {
    try {
      String codedFileName = "操作手册";
      if ("bom".equals(type)) {
        codedFileName = "BOM材料号创建操作手册";
      } else if ("spare".equals(type)) {
        codedFileName = "备品耗材料号创建操作手册";
      } 
      response.setContentType("application/pdf");
      if (BrowserUtils.isIE(request)) {
        response.setHeader("content-disposition",
            "attachment;filename=" + java.net.URLEncoder.encode(codedFileName, "UTF-8") + ".pdf");
      } else {
        String newtitle = new String(codedFileName.getBytes("UTF-8"), "ISO8859-1");
        response.setHeader("content-disposition", "attachment;filename=" + newtitle + ".pdf");
      }
      String path =
          Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
      path = path.replace("WEB-INF/classes/", "");
      if ("bom".equals(type)) {
        path = path.replace("file:/", "") + "excelTemplate/bomHelp.pdf";
      } else if ("spare".equals(type)) {
        path = path.replace("file:/", "") + "excelTemplate/spareHelp.pdf";
      }
      InputStream inputStream = new FileInputStream(new File(path));
      OutputStream outputStream = response.getOutputStream();
      try {
        byte[] buffer = new byte[1024];
        int i = -1;
        while ((i = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, i);
        }
        outputStream.flush();
      } finally {
        if (outputStream != null) {
          outputStream.close();
        }
        if (inputStream != null) {
          inputStream.close();
        }
      }
    } catch (Exception e) {
      logger.error(e.toString(), e);
      e.printStackTrace();
    }
  }

}
