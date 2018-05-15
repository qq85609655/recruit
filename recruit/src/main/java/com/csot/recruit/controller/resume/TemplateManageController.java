package com.csot.recruit.controller.resume;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.controller.template.TemplateController;
import com.csot.recruit.model.template.EmailTemplateParameter;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.service.template.TemplateService;

@Controller
@RequestMapping("template")
public class TemplateManageController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);
	
	@Resource
	private TemplateService templateService;
	/***
	 * 邮件模板管理页面
	 * 
	 * @return
	 */
	@RequestMapping("templateManage")
	public ModelAndView importResumeLocal() {
	  
		ModelAndView view = new ModelAndView("com/csot/templateManage/emailTemplateList");
		return view;
	}
	
	/***
     * 短信模板管理页面
     * 
     * @return
     */
    @RequestMapping("messageManage")
    public ModelAndView messageManage() {
        
        ModelAndView view = new ModelAndView("com/csot/templateManage/messageTemplateList");        
        return view;
    }
    
    /**
     * 模板类型界面
     * @return
     */
    @RequestMapping("templateTypeManage")
    public ModelAndView templateTypeManage() {
        
        ModelAndView view = new ModelAndView("com/csot/templateManage/templateTypeList");       
        return view;
    }
	/***
	 * 保存模板
	 * @param request
	 * @param templateType 模板类型
	 * @param templateTitle 模板标题
	 * @param templateContext 模板内容
	 * @param templateSubject 邮件主题
	 * @param attach 修改的附件
	 */
	@ResponseBody
	@RequestMapping("saveTemplate")
	public AjaxRtnJson saveTemplate(HttpServletRequest request,
			@RequestParam(value = "templateId", required = false) String templateId,
			@RequestParam(value = "templateType", required = false) String templateType,
			@RequestParam(value = "templateTitle", required = true) String templateTitle,
			@RequestParam(value = "templateContext", required = true) String templateContext,
			@RequestParam(value = "templateSubject", required = false) String templateSubject,
			@RequestParam(value = "attach", required = false) String attach) {
		MultipartFile[] resumeFile = null;
		Template template = new Template();
		template.setContext(templateContext);
		template.setId(templateId);
		String projectPath = request.getServletContext().getRealPath("/");
		String filePath = projectPath+"resources"+File.separator+"ftl"+File.separator+templateTitle.trim()+".ftl";
		template.setTitle(templateTitle);
		template.setSubject(templateSubject);
		template.setType(templateType);
		if(null != templateId && !templateId.equals("")){
			Template te = templateService.getByPrimaryKey(templateId);
			if(null != te){
				String oldTitle = te.getTitle();
				filePath = projectPath+"resources"+File.separator+"ftl"+File.separator+oldTitle.trim()+".ftl";
			}
		}
		
		try {
			templateService.saveTemplate(filePath, template, resumeFile, attach);;
		} catch (Exception e) {
			logger.info("创建模板异常"+e);
			return new AjaxRtnJson(false, "操作失败");
		}
		return new AjaxRtnJson(true, "操作成功");
	}
	
	/***
	 * 保存模板(带附件的)
	 * @param resumeFile 附件
	 * @param request
	 * @param templateType 模板类型
	 * @param templateTitle 模板标题
	 * @param templateContext 模板内容
	 * @param templateSubject 邮件主题
	 * @param attach 修改的附件
	 */
	@ResponseBody
	@RequestMapping("saveTemplateAttach")
	public AjaxRtnJson saveTemplateAttach(HttpServletRequest request,
			@RequestParam(value = "resumeFile", required = false) MultipartFile[] resumeFile,
			@RequestParam(value = "templateId", required = false) String templateId,
			@RequestParam(value = "templateType", required = false) String templateType,
			@RequestParam(value = "templateTitle", required = true) String templateTitle,
			@RequestParam(value = "templateContext", required = true) String templateContext,
			@RequestParam(value = "templateSubject", required = false) String templateSubject,
			@RequestParam(value = "attach", required = false) String attach) {
		Template template = new Template();
		template.setContext(templateContext);
		template.setId(templateId);
		String projectPath = request.getServletContext().getRealPath("/");
		String filePath = projectPath+"resources"+File.separator+"ftl"+File.separator+templateTitle.trim()+".ftl";
		template.setTitle(templateTitle);
		template.setSubject(templateSubject);
		template.setType(templateType);
		if(null != templateId && !templateId.equals("")){
			Template te = templateService.getByPrimaryKey(templateId);
			if(null != te){
				String oldTitle = te.getTitle();
				filePath = projectPath+"resources"+File.separator+"ftl"+File.separator+oldTitle.trim()+".ftl";
			}
		}
		String message = "";
		try {
			message = templateService.saveTemplate(filePath, template, resumeFile, attach);
		} catch (Exception e) {
			logger.info("创建模板异常"+e);
			return new AjaxRtnJson(false, "操作失败");
		}
		if(message.equals("") || !message.equals("操作成功")){
			return new AjaxRtnJson(false, message);
		}
		return new AjaxRtnJson(true, message);
	}
	
	/***
	 * 预览模板
	 * @param request
	 * @param templateTitle 模板标题
	 * @param templateContext 模板内容
	 * @return
	 */
	@RequestMapping(value="previewTemplate", method=RequestMethod.POST)
	public ModelAndView previewTemplate(HttpServletRequest request,
			@RequestParam(value = "templateTitle", required = true) String templateTitle, 
			@RequestParam(value = "templateContext", required = true) String templateContext) {
		ModelAndView view = new ModelAndView("template");
		EmailTemplateParameter emailTemplate = new EmailTemplateParameter();
		emailTemplate.setUserName("刘德华");
		emailTemplate.setSendReason("kkk");
		Template template = templateService.previewTemplate(null, templateTitle, templateContext, emailTemplate);
		view.addObject("templateTitle", template.getTitle());
		view.addObject("templateContext", template.getContext());
//		view.addObject("UserName", "刘德华");
		return view;
	}
	
	@RequestMapping(value="previewTemplateById", method=RequestMethod.POST)
	public ModelAndView previewTemplate(HttpServletRequest request,
			@RequestParam(value = "templateId", required = true) String templateId) {
		ModelAndView view = new ModelAndView("template");
		EmailTemplateParameter emailTemplate = new EmailTemplateParameter();
		emailTemplate.setUserName("刘德华");
		emailTemplate.setSendReason("kkk");
		Template template = templateService.previewTemplate(templateId, null, null, emailTemplate);
		view.addObject("templateTitle", template.getTitle());
		view.addObject("templateContext", template.getContext());
//		view.addObject("UserName", "刘德华");
		return view;
	}
	
	/***
	 * 根据模板id查询模板数据以作修改
	 * @param request
	 * @param templateId 模板id
	 */
	@ResponseBody
	@RequestMapping("queryTemplateById")
	public AjaxRtnJson queryTemplateById(HttpServletRequest request,
			@RequestParam(value = "templateId", required = true) String templateId) {
		Template template = templateService.getByPrimaryKey(templateId);
		AjaxRtnJson json = new AjaxRtnJson();
		json.setObj(template);
		return json;
	}

	/***
	 * 删除模板
	 * @param request
	 * @param templateId 模板id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteTemplate")
	public AjaxRtnJson deleteTemplate(HttpServletRequest request,
			@RequestParam(value = "templateId", required = true) String templateId) {
		try {
			String filePath = "";
			String projectPath = request.getServletContext().getRealPath("/");
			Template te = templateService.getByPrimaryKey(templateId);
			if(null != te){
				String oldTitle = te.getTitle();
				filePath = projectPath+"resources"+File.separator+"ftl"+File.separator+oldTitle.trim()+".ftl";
			}
			templateService.deleteTemplate(templateId, filePath);
		} catch (Exception e) {
			logger.error("删除模板数据异常"+e);
			return new AjaxRtnJson(false, "删除失败");
		}
		return new AjaxRtnJson(true, "删除成功");
	}
}
