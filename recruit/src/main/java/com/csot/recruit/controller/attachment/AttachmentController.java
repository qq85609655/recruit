package com.csot.recruit.controller.attachment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.service.attachment.AttachmentService;
import com.csot.recruit.service.template.TemplateService;
import com.google.common.base.Throwables;

@Controller
@RequestMapping("attachmentController")
public class AttachmentController {
  private static final Logger logger = LoggerFactory.getLogger(AttachmentController.class);

  @Resource
  private AttachmentService attachmentService;

  @Resource
  private CommonsMultipartResolver multipartResolver;

  @Resource
  private SpringPropertyResourceReader springPropertyResourceReader;

  @Resource
  private TemplateService templateService;

  /** 公共附件保存目录 */
  public static final String COMMON_ATTACH_PATH = "commonAttach";

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/recruit/attachment/attachmentList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<Attachment> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return attachmentService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/attachment/attachmentEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    Attachment attachment = attachmentService.getByPrimaryKey(id);
    request.setAttribute("attachment", attachment);
    return new ModelAndView("com/csot/recruit/attachment/attachmentEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    Attachment attachment = attachmentService.getByPrimaryKey(id);
    request.setAttribute("attachment", attachment);
    return new ModelAndView("com/csot/recruit/attachment/attachmentView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      attachmentService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(Attachment attachment) {
    if (StringUtils.hasText(attachment.getId())) {
      try {
        attachmentService.updateSelective(attachment);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        attachment.setId(UUID.randomUUID().toString().replace("-", ""));
        attachmentService.create(attachment);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 上传附件,返回文件id及名称
   * 
   * @param type 附件类型
   * @param request reqeust
   * @return AjaxRtnJson
   */
  @RequestMapping("uploadFiles")
  @ResponseBody
  public AjaxRtnJson uploadSupAttachments(HttpServletRequest request, @CurrentUser SysUser sysUser) {
    try {
      String type = request.getParameter("type");
      String relateId = request.getParameter("relateId");
      String data = getUploadSupAttachs(request, type, relateId);
      String[] datas = data.split("~");
      AjaxRtnJson rtnData = new AjaxRtnJson();
      rtnData.setAttribute("attachId", datas[0]);
      rtnData.setAttribute("attachName", datas[1]);
      rtnData.setMsg("上传成功");
      rtnData.setSuccess(true);
      return rtnData;
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "上传失败: " + e.getMessage());
    }
  }

  /**
   * 上传附件,返回文件id及名称
   * 
   * @param type 附件类型
   * @param request reqeust
   * @return AjaxRtnJson
   */
  @RequestMapping("uploadFilesForStu")
  @ResponseBody
  public AjaxRtnJson uploadSAttachments(HttpServletRequest request, @CurrentUser SysUser sysUser) {
    try {
      String type = request.getParameter("type");
      String id = request.getParameter("id"); // 选中的邮件模板id
      //String relateId = request.getParameter("relateId");
     
      Template template = new Template();
      // id填充，用作页面保存附件关联
      template.setId(UUID.randomUUID().toString().replace("-", ""));
      template.setCreator(sysUser.getAccount());
      template.setCreateDate(new Date());
      String relateId = template.getId();
      String data = "";
      if (StringUtils.hasText(id)) {
        data = getUploadAttachsForStu(request, type, relateId, id);
      } else {
        data = getUploadSupAttachs(request, type, relateId);
      }

      String[] datas = data.split("~");
      AjaxRtnJson rtnData = new AjaxRtnJson();
      rtnData.setAttribute("attachId", datas[0]);
      rtnData.setAttribute("attachName", datas[1]);
      rtnData.setAttribute("relateId", relateId);
      rtnData.setMsg("上传成功");
      rtnData.setSuccess(true);
      if(StringUtils.hasText(datas[0])){
        rtnData.setAttribute("attachId", datas[0]);
        rtnData.setAttribute("attachName", datas[1]);
        rtnData.setAttribute("relateId", relateId);
        rtnData.setMsg("上传成功");
        rtnData.setSuccess(true);
      }else{
        rtnData.setSuccess(false);
        rtnData.setMsg("请选择需上传的附件!");
      }
      return rtnData;
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "上传失败: " + e.getMessage());
    }
  }

  /**
   * 上传附件，文件转存入库
   * 
   * @param request request
   * @param type 附件类型
   * @return 附件ID和名称
   */
  private String getUploadSupAttachs(HttpServletRequest request, String type, String relateId) {

    List<Attachment> attachs = null;

    if (multipartResolver.isMultipart(request)) {
      // 转换成多部分request
      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
      // 取得request中的所有文件
      Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
      attachs = uploadStandAttachments(fileMap, type, relateId);
    }

    StringBuilder bufId = new StringBuilder();
    StringBuilder bufName = new StringBuilder();
    if (null != attachs && !attachs.isEmpty()) {
      for (int i = 0; i < attachs.size(); i++) {
        if (attachs.size() == 1 || i == attachs.size() - 1) {
          bufId.append(attachs.get(i).getId());
          bufName.append(attachs.get(i).getShowName());
        } else {
          bufId.append(attachs.get(i).getId() + ",");
          bufName.append(attachs.get(i).getShowName());
        }
      }
    }
    return bufId + "~" + bufName;
  }

  /**
   * 上传附件，文件转存入库,将原有模板中的附件加入到新的模板
   * 
   * @param request request
   * @param type 附件类型
   * @return 附件ID和名称
   */
  private String getUploadAttachsForStu(HttpServletRequest request, String type, String relateId,
      String id) {

    List<Attachment> attachs = null;

    if (multipartResolver.isMultipart(request)) {
      // 转换成多部分request
      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
      // 取得request中的所有文件
      Map<String, MultipartFile> fileMap = multiRequest.getFileMap();
      attachs = uploadStandAttachments(fileMap, type, relateId);
    }
    // 将模板中的附件添加到附件中。
    attachs.addAll(attachmentService.findAttachsByRelateId(id));
    StringBuilder bufId = new StringBuilder();
    StringBuilder bufName = new StringBuilder();
    bufName.append(attachs.get(0).getShowName());
    bufId.append(attachs.get(0).getId());
    /*if (null != attachs && !attachs.isEmpty()) {
      for (int i = 0; i < attachs.size(); i++) {
        if (attachs.size() == 1 || i == attachs.size() - 1) {
          bufId.append(attachs.get(i).getId());
          bufName.append(attachs.get(i).getShowName());
        } else {
          bufId.append(attachs.get(i).getId() + ",");          
        }
      }
    }*/
    return bufId + "~" + bufName;
  }

  public List<Attachment> uploadStandAttachments(Map<String, MultipartFile> fileMap, String type,
      String relateId) {
    List<Attachment> attachList = new ArrayList<Attachment>();

    for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
      String originalName = entity.getValue().getOriginalFilename();
      // 如果前台input-file标签为空的，则一样会传过来文件对象，名字为空字符串
      if (StringUtils.isEmpty(originalName)) {
        continue;
      }
      String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
      String uuidName = UUID.randomUUID().toString().replace("-", "");
      String filePath = rootPath + File.separator + COMMON_ATTACH_PATH + File.separator + uuidName;

      // 保存附件到服务器指定路径
      File file = new File(filePath);
      if (!file.exists()) {
        file.mkdirs();
      }
      try {
        entity.getValue().transferTo(file);
      } catch (IOException ex) {
        throw Throwables.propagate(ex);
      }

      // 构建附件对象，保存到DB
      Attachment attachment = new Attachment();
      // 设置关联id
      attachment.setRelateId(relateId);
      attachment.setId(UUID.randomUUID().toString().replace("-", ""));
      attachment.setSaveName(uuidName);
      attachment.setSavePath(COMMON_ATTACH_PATH);
      attachment.setShowName(originalName);
      // 附件类别
      attachment.setType(type);
      attachmentService.create(attachment);
      attachList.add(attachment);
    }
    return attachList;
  }

  /**
   * 下载附件
   * 
   * @param attachId 附件对象ID
   * @param response response
   * @return AjaxRtnJson
   */
  @RequestMapping("downloadCommonAttachment/{attachId}")
  @ResponseBody
  public AjaxRtnJson downloadCommonAttachment(HttpServletResponse response,
      @PathVariable String attachId) {
    // String type = request.getParameter("type");
    // String attachId = request.getParameter("attachId");
    Attachment attachment = attachmentService.getByPrimaryKey(attachId);
    if (null == attachment) {
      String errorMsg = "下载附件信息不存在";
      logger.error(errorMsg);
      PrintWriter out;
      try {
        out = response.getWriter();
        out.print(errorMsg);
        out.close();
      } catch (IOException e) {
        throw Throwables.propagate(e);
      }

    } else {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("multipart/form-data");
      try {
        response.setHeader("Content-Disposition", "attachment;fileName="
            + new String(attachment.getShowName().getBytes("gbk"), "iso-8859-1"));
      } catch (UnsupportedEncodingException e1) {
        logger.error("download file UnsupportedEncodingException", e1);
        throw Throwables.propagate(e1);
      }
      try {
        String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
        String dowloadPath =
            rootPath + File.separator + attachment.getSavePath() + File.separator
                + attachment.getSaveName();
        InputStream inputStream = new FileInputStream(new File(dowloadPath));
        OutputStream os = response.getOutputStream();
        byte[] byt = new byte[2048];
        int length;
        while ((length = inputStream.read(byt)) > 0) {
          os.write(byt, 0, length);
        }
        // 关闭流
        os.close();
        inputStream.close();
      } catch (FileNotFoundException e) {
        logger.error("download file FileNotFoundException:", e);
        throw Throwables.propagate(e);
      } catch (IOException e) {
        logger.error("download file IOException:", e);
        throw Throwables.propagate(e);
      }
    }
    return null;
  }


  /**
   * 获取模板附件,返回文件id及名称
   * 
   * @param type 附件类型
   * @param request reqeust
   * @return AjaxRtnJson
   */
  @RequestMapping("getAttachmentList")
  @ResponseBody
  public Map<String, Object> getAttachmentList(HttpServletRequest request) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {

      List<Attachment> attachments = new ArrayList<Attachment>();
      String id = request.getParameter("id");
      Template template = templateService.getByPrimaryKey(id);
      if (template != null) {
        attachments = attachmentService.findAttachsByRelateId(id);
        map.put("status", 200);
        map.put("attachments", attachments);
      } else {
        map.put("status", 200);
        map.put("attachments", attachments);
      }
      return map;
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      map.put("status", 404);
      return map;
    }
  }

  /**
   * 上传附件并将附件存到新的模板中,返回文件id及名称
   * 
   * @param type 附件类型
   * @param request reqeust
   * @return AjaxRtnJson
   */
  @RequestMapping("getStuAttachmentList")
  @ResponseBody
  public Map<String, Object> getStuAttachmentList(HttpServletRequest request) {
    Map<String, Object> map = new HashMap<String, Object>();
    try {

      List<Attachment> attachments = new ArrayList<Attachment>();
      String newRelateId = UUID.randomUUID().toString().replace("-", "");
      String id = request.getParameter("id");
      Template template = templateService.getByPrimaryKey(id);
      if (template != null) {
        attachments = attachmentService.findAttachsByRelateId(id);        
        // 将附件id重新生成，令其指向不同的template(不存在数据库)
        template = new Template();
        template.setId(newRelateId);
        for (int k = 0; k < attachments.size(); k++) {
          attachments.get(k).setRelateId(newRelateId);
          attachments.get(k).setSaveName(UUID.randomUUID().toString().replace("-", ""));
          attachments.get(k).setId(UUID.randomUUID().toString().replace("-", ""));
        }
        map.put("status", 200);
        map.put("attachments", attachments);
      } else {
        map.put("status", 200);
        map.put("attachments", attachments);
      }
      return map;
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      map.put("status", 404);
      return map;
    }
  }
  
  /**
   * 下载通讯录导入模板
   */
  @RequestMapping("download/zipFile")
  public void temple(HttpServletRequest request, HttpServletResponse response,String path) throws IOException {
    File f = new File(path);
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
        "attachment; filename=" + URLEncoder.encode("附件包.zip", "utf-8").replace("+", "%20"));
    OutputStream out = response.getOutputStream();
    while ((len = br.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    br.close();
    out.close();
  }
  


}