package com.csot.recruit.service.impl.template;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.dao.template.TemplateMapper;
import com.csot.recruit.model.template.EmailTemplateParameter;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.template.TemplateColumns;
import com.csot.recruit.model.template.TemplateCriteria;
import com.csot.recruit.service.template.TemplateService;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
  private static final Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);

  @Resource
  private TemplateMapper templateMapper;

  @Override
  public MiniRtn2Grid<Template> getTemplateGrid(MiniGridPageSort pageSort, String searchKey,
      String type) {
    MiniRtn2Grid<Template> grid = new MiniRtn2Grid<Template>();
    TemplateCriteria criteria = new TemplateCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      // criteria.createCriteria().andIdEqualTo(searchKey);
      criteria.createCriteria().andTitleLike("%" + searchKey + "%");
    }
    if (StringUtils.hasText(type)) {
      criteria.createCriteria().andTypeEqualTo(type);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = TemplateColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(templateMapper.selectByExample(criteria));
    grid.setTotal(templateMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public Template getByPrimaryKey(String primaryKey) {
    return templateMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(Template template) {
    templateMapper.insertSelective(template);
  }

  @Override
  public void updateSelective(Template template) throws Exception {
    templateMapper.updateByPrimaryKeySelective(template);
  }

  @Override
  public void remove(String primaryKey) {
    templateMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public List<Template> queryTemplateList() {
    TemplateCriteria criteria = new TemplateCriteria();
    List<Template> list = templateMapper.selectByExample(criteria);
    return list;
  }

  @Override
  public String saveTemplate(String filePath, Template template, MultipartFile[] attchFile,
      String attch) throws Exception {
    String attach = "";
    // 根据主键查询模板数据
    Template te = templateMapper.selectByPrimaryKey(template.getId());
    // 修改邮件模板先删除附件
    if (null != template.getId() && !("").equals(template.getId()) && null != te) {
      String fileName = te.getAttch();
      if (null != te.getAttch() && !("").equals(te.getAttch())) {
        String[] fileNames = fileName.split(",");
        String[] attachs = attch.split(",");
        for (int j = 0; j < fileNames.length; j++) {
          for (int i = 0; i < attachs.length; i++) {
            // 判断修改的附件是否相同，相同则不删除
            if (!attachs[i].equals(fileNames[j])) {
              String attchPath =
                  filePath.substring(0, filePath.lastIndexOf(File.separator + "ftl"));
              attchPath =
                  attchPath + File.separator + "upload" + File.separator + "templateAttach"
                      + File.separator + te.getTitle() + File.separator;
              String path = attchPath + fileNames[j];
              delFile(path);
            }
          }
        }
      }
    }
    // 判断是否是有附件类型的邮件模板，如果是则添加附件到指定目录下
    if (null != attchFile && attchFile.length > 0) {
      for (int i = 0; i < attchFile.length; i++) {
        if (i == attchFile.length - 1) {
          attach = attach + (attchFile[i].getOriginalFilename());
        } else {
          attach = attach + (attchFile[i].getOriginalFilename() + ",");
        }
        MultipartFile file = attchFile[i];
        String fileName = attchFile[i].getOriginalFilename();
        String attchPath = filePath.substring(0, filePath.lastIndexOf(File.separator + "ftl"));
        attchPath =
            attchPath + File.separator + "upload" + File.separator + "templateAttach"
                + File.separator + template.getTitle() + File.separator;
        String path = attchPath + fileName;
        File localFile = new File(path);
        if (!localFile.exists()) {// 判断文件夹是否创建，没有创建则创建新文件夹
          localFile.mkdirs();
        }
        // 上传文件到项目路径下
        file.transferTo(localFile);
      }
    }
    // 把原来的附件也添加到数据库中保存
    if (null != attch && !("").equals(attch)) {
      if (null != attach && !("").equals(attach)) {
        attach = attach + "," + attch;
      } else {
        attach = attach + attch;
      }
    }
    template.setAttch(attach);
    String templateTitle = "";
    // 根据标题查询该标题的模板数据，用来判断该标题的模板是否存在
    TemplateCriteria example = new TemplateCriteria();
    example.createCriteria().andTitleEqualTo(template.getTitle())
        .andTypeEqualTo(template.getType());
    List<Template> list = templateMapper.selectByExample(example);
    if (null == template.getId() || template.getId().equals("")) {
      // template.setCreator(creator);
      template.setCreateDate(new Date());
      template.setId(UUID.randomUUID().toString().replace("-", ""));
      if (list.size() == 0) {
        templateMapper.insertSelective(template);
      } else {
        // 返回标题已存在的字符串
        return "邮件标题已存在";
      }
    } else {
      template.setUpdateDate(new Date());
      if (null != te) {
        templateTitle = te.getTitle();
      }
      if (list.size() == 0) {
        templateMapper.updateByPrimaryKeySelective(template);
      } else {
        if (list.get(0).getId().equals(template.getId())) {
          templateMapper.updateByPrimaryKeySelective(template);
        } else {
          return "邮件标题已存在";
          // 返回标题已存在的字符串
        }
      }

    }
    String templateContext =
        "<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><title>"
            + template.getTitle() + "</title></head><body>" + template.getContext()
            + "</body></html>";
    stringFile(templateContext, filePath);
    if (!templateTitle.equals("")) {
      renameFile(filePath, template.getTitle());
    }
    return "success";
  }

  /**
   * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
   *
   * @param res 原字符串
   * @param filePath 文件路径
   * @return 成功标记
   */
  public static boolean stringFile(String res, String filePath) {
    boolean flag = true;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    try {
      File distFile = new File(filePath);
      if (!distFile.getParentFile().exists())
        distFile.getParentFile().mkdirs();
      bufferedReader = new BufferedReader(new StringReader(res));
      bufferedWriter = new BufferedWriter(new FileWriter(distFile));
      char buf[] = new char[1024]; // 字符缓冲区
      int len;
      while ((len = bufferedReader.read(buf)) != -1) {
        bufferedWriter.write(buf, 0, len);
      }
      bufferedWriter.flush();
      bufferedReader.close();
      bufferedWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
      flag = false;
      return flag;
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return flag;
  }

  @Override
  public boolean deleteTemplate(String primaryKey, String filePath) throws Exception {
    Template template = templateMapper.selectByPrimaryKey(primaryKey);
    if (null != template.getAttch() && !("").equals(template.getAttch())) {
      String fileName = template.getAttch();
      String[] fileNames = fileName.split(",");
      for (int j = 0; j < fileNames.length; j++) {
        String attchPath = filePath.substring(0, filePath.lastIndexOf(File.separator + "ftl"));
        attchPath =
            attchPath + File.separator + "upload" + File.separator + "templateAttach"
                + File.separator + template.getTitle() + File.separator;
        String path = attchPath + fileNames[j];
        delFile(path);
      }
    }
    delFile(filePath);
    int count = templateMapper.deleteByPrimaryKey(primaryKey);
    return count == 1 ? true : false;
  }

  /***
   * 修改文件名
   * 
   * @param filePath 文件路径
   * @param newFileName 新文件名
   */
  public void renameFile(String filePath, String newFileName) {
    File file = new File(filePath); // 指定文件名及路径
    String filename = file.getAbsolutePath();
    if (filename.indexOf(".") >= 0) {
      filename = filename.substring(0, filename.lastIndexOf(File.separator));
    }
    file.renameTo(new File(filename + File.separator + newFileName + ".ftl")); // 改名
  }

  /***
   * 删除文件
   * 
   * @param fileUrl 文件路径
   * @return
   */
  public String delFile(String fileUrl) {
    File file = new File(fileUrl);
    if (!file.exists()) {
      return "文件不存在！";
    } else {
      file.delete();
    }
    // 删除空文件夹
    String url = fileUrl.substring(0, fileUrl.lastIndexOf(File.separator));
    File f = new File(url);
    if (!f.exists()) {
      return "文件夹不存在！";
    } else {
      if (f.isDirectory() && f.listFiles().length <= 0) {
        f.delete();
      }
    }
    return "true";
  }

  @Override
  public Template previewTemplate(String id, String title, String content,
      EmailTemplateParameter emailTemplate) {
    Template template = null;
    PropertiesUtil propertiesUtil = new PropertiesUtil("constant.properties");
    if (null != id && !("").equals(id)) {
      template = templateMapper.selectByPrimaryKey(id);
      String context = template.getContext();
      context =
          context.replace(propertiesUtil.readProperty("UserName"), emailTemplate.getUserName());
      context =
          context.replace(propertiesUtil.readProperty("sendReason"), emailTemplate.getSendReason());
      template.setContext(context);
    } else {
      template = new Template();
      content =
          content.replace(propertiesUtil.readProperty("UserName"), emailTemplate.getUserName());
      content =
          content.replace(propertiesUtil.readProperty("sendReason"), emailTemplate.getSendReason());
      template.setTitle(title);
      template.setContext(content);
    }
    return template;
  }

  @Override
  public List<Template> getTempleteByType(String type) {
    List<Template> templateList = templateMapper.getTempleteByType(type);
    return templateList;
  }



}
