package com.csot.gm.materialManage.controller.file;

import java.io.IOException;
import java.util.List;

import com.csot.gm.materialManage.model.original.file.FileUpload;
import com.csot.gm.materialManage.service.file.FileUploadService;
import com.csot.gm.rawMaterial.model.FileEntity;
import com.csot.gm.util.FileUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("fileUpload")
public class FileUploadController {
  private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

  @Resource
  private FileUploadService fileUploadService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/file/fileUploadList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<FileUpload> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return fileUploadService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/file/fileUploadEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    FileUpload fileUpload = fileUploadService.getByPrimaryKey(id);
    request.setAttribute("fileUpload", fileUpload);
    return new ModelAndView("com/csot/gm/materialManage/file/fileUploadEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    FileUpload fileUpload = fileUploadService.getByPrimaryKey(id);
    request.setAttribute("fileUpload", fileUpload);
    return new ModelAndView("com/csot/gm/materialManage/file/fileUploadView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      fileUploadService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(FileUpload fileUpload) {
    if (StringUtils.isEmpty(fileUpload.getId())) {
      try {
        fileUploadService.create(fileUpload);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        fileUploadService.updateSelective(fileUpload);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }

  /**
   * 上传批量新增料号表
   * @param file
   * @param request
   * @return
   */
  @RequestMapping("upload")
  @ResponseBody
  public AjaxRtnJson upload(FileUpload file, HttpServletRequest request) {
    if (StringUtils.hasText(file.getId())) {
      fileUploadService.remove(file.getId());
    }
    try {
      List<FileEntity> list = FileUtils.getFilesFromRequest(request);
      if (null == list || list.isEmpty()) {
        return new AjaxRtnJson(false, "上传失败！");
      }
      fileUploadService.upload(file, list.get(0));// 只取第一个
      logger.info("项目文件上传成功!");
      return new AjaxRtnJson(true, "上传成功！");
    } catch (Exception e) {
      logger.error("项目文件上传失败", e);
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  @RequestMapping("download")
  public void download(String id, HttpServletResponse response) throws IOException {
    try {
      FileEntity entity = fileUploadService.download(id);
      FileUtils.setDownloadResponse(response, entity);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      response.sendError(404, "File not found!");
    }
  }
  
  /**
   * 删除批量新增文件
   * @param id
   * @return
   */
  @RequestMapping("delete")
  @ResponseBody
  public AjaxRtnJson delete(String id) {
    try {
      fileUploadService.delete(id);
      return new AjaxRtnJson(true, "删除项目文件成功！");
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除项目文件失败: " + e.getMessage());
    }
  }
}
