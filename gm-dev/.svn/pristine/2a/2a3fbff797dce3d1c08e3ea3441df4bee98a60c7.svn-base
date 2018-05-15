package com.csot.gm.materialManage.controller.document;

import java.util.List;

import com.csot.gm.materialManage.model.extension.document.File;
import com.csot.gm.materialManage.service.document.FileService;
import com.csot.gm.rawMaterial.service.impl.ImportAndExportServiceImpl;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("document")
public class DocumentController {
  private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

  @Resource
  private FileService fileService;


  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/document/documentList");
  }

  /**
   * Get FileDatagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public List<File> datagrid(HttpServletRequest request) {
    String fileName = request.getParameter("fileName");
    return fileService.getFile(fileName);
  }

  /**
   * Forward to import page.
   */
  @RequiresPermissions("documentManage:uploadFile")
  @RequestMapping("uploadFile")
  public ModelAndView uploadFile() {
    return new ModelAndView("com/csot/gm/materialManage/document/documentEdit");
  }

  /**
   * 保存文件
   * 
   * @param request
   * @param file
   * @return
   */
  @ResponseBody
  @RequestMapping("saveFile")
  public AjaxRtnJson uploadFile(File file, @CurrentUser SysUser sysUser) {
    String basePath =
        ImportAndExportServiceImpl.getSysUploadPath(java.io.File.separator + "uploadedExcel");
    file.setUploader(sysUser.getAccount());
    int count = fileService.addFileToDb(file, basePath);
    if (count > 0) {
      return new AjaxRtnJson(true, "上传成功!");
    } else {
      return new AjaxRtnJson(false, "上传失败!");
    }
  }

  /**
   * 下载文件
   * 
   * @param id
   * @param response
   * @param request
   * @return
   */
  @RequestMapping("loadFile/{id}")
  public void loadFile(@PathVariable String id, HttpServletResponse response) {
    fileService.load(response, id);
  }

  /**
   * 获取预览文件
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("browseFile/{id}")
  public ModelAndView browseFile(@PathVariable String id, HttpServletRequest request) {
    try {
      String fileUrl = fileService.getFileSwfUrl(id);
      request.setAttribute("fileUrl", fileUrl);
      return new ModelAndView("com/csot/gm/materialManage/document/browseFile");
    } catch (Exception e) {
      request.setAttribute("title", "预览失败");
      request
          .setAttribute(
              "errorMsg",
              "<h2>"
                  + e.getMessage()
                  + "</h2><p><a href=\"javascript:window.opener=null;window.open('','_self');window.close();\" >关闭</a></p>");
      return new ModelAndView("error");
    }
  }

  /**
   * remove file by id.
   */
  @RequiresPermissions("documentManage:removeFile")
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      boolean isDelete = fileService.deletFile(id);
      if (isDelete) {
        return new AjaxRtnJson(true, "删除成功");
      } else {
        return new AjaxRtnJson(false, "删除失败");
      }
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

}
