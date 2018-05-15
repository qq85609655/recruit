package com.csot.recruit.controller.template;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.template.TemplateType;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.service.attachment.AttachmentService;
import com.csot.recruit.service.template.TemplateService;
import com.csot.recruit.service.template.TemplateTypeService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("templateController")
public class TemplateController {
  private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

  @Resource
  private TemplateService templateService;
  @Resource
  private TemplateTypeService templateTypeService;

  @Resource
  private AttachmentService attachmentService;

  /***
   * 邮件模板管理页面
   * 
   * @return
   */
  @RequestMapping("templateManage")
  public ModelAndView importResumeLocal() {
    List<Template> list = templateService.queryTemplateList();
    ModelAndView view = new ModelAndView("com/csot/templateManage/emailTemplateList");
    view.addObject("templateList", list);
    return view;
  }
  
  /***
   * 邮件模板管理页面
   * 
   * @return
   */
  @RequestMapping("chooseTemplate")
  public ModelAndView chooseTemplate() {
    List<Template> list = templateService.queryTemplateList();
    ModelAndView view = new ModelAndView("com/csot/flow/interview/chooseTemplateList");
    view.addObject("templateList", list);
    return view;
  }

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/recruit/controller/template/templateList");
  }

  /**
   * 根据模板类型及查询条件加载模板数据
   * 
   * @param pageSort
   * @param request
   * @return
   */
  @RequestMapping("templateData")
  @ResponseBody
  public MiniRtn2Grid<Template> templateData(MiniGridPageSort pageSort, HttpServletRequest request) {
    MiniRtn2Grid<Template> miniRtn = new MiniRtn2Grid<Template>();
    String searchKey = request.getParameter("searchKey");
    String type = request.getParameter("type");
    miniRtn = templateService.getTemplateGrid(pageSort, searchKey, type);
    return miniRtn;
  }

  /**
   * 新增邮件模板
   * 
   * @return
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/templateManage/emailTemplateEdit");
  }

  /**
   * 新增短信模板
   * 
   * @return
   */
  @RequestMapping("createMessage")
  public ModelAndView createMessage() {
    return new ModelAndView("com/csot/templateManage/messageTemplateEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    Template template = templateService.getByPrimaryKey(id);
    request.setAttribute("template", template);
    return new ModelAndView("com/csot/templateManage/emailTemplateEdit");
  }

  @RequestMapping("toEditPage")
  public ModelAndView toEditPage(@CurrentUser SysUser sysUser, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("com/csot/templateManage/emailTemplateEdit");
    String type = request.getParameter("type");
    String id = request.getParameter("id");
    List<Attachment> attachments = new ArrayList<Attachment>();
    Template template = null;
    if (!"create".equals(type) && !("0".equals(id))) {
      template = templateService.getByPrimaryKey(id);
      // 查询出关联的附件
      attachments = attachmentService.findAttachsByRelateId(id);
    } else {
      // 通过登录用户，找到供应商名称或编号
      template = new Template();
      // id填充，用作页面保存附件关联
      template.setId(UUID.randomUUID().toString().replace("-", ""));
      template.setCreator(sysUser.getAccount());
      template.setCreateDate(new Date());
    }
    mav.addObject("template", template);
    mav.addObject("attachments", attachments);
    mav.addObject("type", type);
    return mav;
  }


  @RequestMapping("modifyMessage/{id}")
  public ModelAndView modifyMessage(@PathVariable String id, HttpServletRequest request) {
    Template template = templateService.getByPrimaryKey(id);
    request.setAttribute("template", template);

    return new ModelAndView("com/csot/templateManage/messageTemplateEdit");
  }

  @RequestMapping("view")
  public ModelAndView view() {

    return new ModelAndView("com/csot/templateManage/emailTemplateList");
  }

  @RequestMapping("viewMessage")
  public ModelAndView viewMessage() {

    return new ModelAndView("com/csot/templateManage/messageTemplateList");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      templateService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }


  @RequestMapping("queryTempleteByType")
  @ResponseBody
  public AjaxRtnJson getTempleteByType(String type) {
    AjaxRtnJson ar = new AjaxRtnJson();
    List<Template> templateList = templateService.getTempleteByType(type);
    if (templateList != null && templateList.size() > 0) {
      ar.setObj(templateList);
      ar.setMsg("success");
    } else {
      ar.setMsg("fail");
    }
    return ar;
  }

  @RequestMapping("save/{type}")
  @ResponseBody
  public AjaxRtnJson
      save(@PathVariable String type, Template template, @CurrentUser SysUser sysUser) {

    Date date = new Date();
    // 设置当前创建的登录用户
    template.setCreator(sysUser.getAccount());
    template.setCreatorId(sysUser.getId());

    if (!"create".equals(type)) {
      template.setUpdateDate(date);
      try {
        templateService.updateSelective(template);
        return new AjaxRtnJson(true, "修改成功");
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      template.setCreateDate(date);
      try {
        // template.setId(UUID.randomUUID().toString().replace("-", ""));
        templateService.create(template);
        return new AjaxRtnJson(true, "新建成功");
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 获取模板的类型,用于模板下拉框选值
   * 
   * @param type模板类型
   * @return
   */
  @RequestMapping("getTemplateType/{type}")
  @ResponseBody
  public List<TemplateType> getTemplateType(@PathVariable String type, HttpServletRequest request) {

    List<TemplateType> templateTypeList = Lists.newArrayList();
    if (!StringUtils.isEmpty(type)) {
      templateTypeList = templateTypeService.queryTemplateTpeyList(type);
    }
    return templateTypeList;
  }


}
