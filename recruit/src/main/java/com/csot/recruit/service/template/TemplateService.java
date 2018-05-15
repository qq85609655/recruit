package com.csot.recruit.service.template;

import java.util.List;

import com.csot.recruit.model.template.EmailTemplateParameter;
import com.csot.recruit.model.template.Template;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.web.multipart.MultipartFile;

public interface TemplateService {

  Template getByPrimaryKey(String primaryKey);

  void create(Template template);

  void updateSelective(Template template) throws Exception;

  void remove(String primaryKey);

  /***
   * 查询所有模板数据
   * 
   * @return
   */
  List<Template> queryTemplateList();

  /***
   * 保存模板
   * 
   * @param filePath 模板文件路径
   * @param template 模板对象
   * @param attchFile 模板附件
   * @param attach 修改的附件
   */
  String saveTemplate(String filePath, Template template, MultipartFile[] attchFile, String attach)
      throws Exception;

  /***
   * 根据id删除模板
   * 
   * @param primaryKey 主键
   * @param filePath ftl文件路径
   * @return
   */
  boolean deleteTemplate(String primaryKey, String filePath) throws Exception;

  /***
   * 预览模板文件
   * 
   * @param id 模板id
   * @param title 模板标题
   * @param content 模板内容
   * @param emailTemplate 模板可选参数对象
   * @return
   */
  Template previewTemplate(String id, String title, String content,
      EmailTemplateParameter emailTemplate);

  /**
   * 分类查询模板
   * 
   * @param type
   * @return
   */
  List<Template> getTempleteByType(String type);

  /**
   * 根据模板类型获取模板数据
   * 
   * @param pageSort
   * @param searchKey
   * @param type
   * @return
   */
  MiniRtn2Grid<Template> getTemplateGrid(MiniGridPageSort pageSort, String searchKey, String type);

}
