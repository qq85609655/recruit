package com.csot.recruit.controller.resume;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.csot.recruit.common.exception.BusinessException;
import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.common.util.ExcelReader;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.common.util.UploadUtils;
import com.csot.recruit.model.resume.ImportResume;
import com.csot.recruit.model.resume.ResumeTemplate;
import com.csot.recruit.model.resume.ResumeUploadResult;
import com.csot.recruit.service.resume.MyResumeRepositoryService;
import com.csot.recruit.service.resume.ResumeService;

@Controller  
@RequestMapping("/file")  
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Resource
	private ResumeService resumeService;
	
	@Resource
	private CommonService common;
	
	@Resource
	private MyResumeRepositoryService myResumeRepositoryService;
	
	private PropertiesUtil propertiesUtil = new PropertiesUtil();
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)  
	@ResponseBody
    public AjaxRtnJson upload(ImportResume importResume, @RequestParam MultipartFile[] resumeFile, HttpServletRequest request) {  
		//上传多文件的总大小
		int totalFileSize = 0;
		//上传多文件的总个数
		int totalCount = 0;
		String url = request.getSession().getServletContext().getRealPath("/");
		
//		String url = ConstantsConfigurer.getProperty("fileUploadUrl");
		url += "resources"+File.separator+"upload"+File.separator+ "local"+ File.separator;
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        	for(MultipartFile file : resumeFile){  
	                if(file != null){  
	                	totalFileSize += file.getSize();
		                totalCount += ++totalCount;
	                	//截取文件后缀判断文件类型是否匹配
	                	String originalFilename = file.getOriginalFilename();
	                	String type = file.getOriginalFilename().substring(
	                            (originalFilename.lastIndexOf('.')) + 1);
	                	if(!this.isFileType(type, importResume.getImportType())){
	                		if(importResume.getImportType() == 3){
	                			return new AjaxRtnJson(true, "请上传xls或者xlsx格式的excel文件!");
	                		}else{
	                			return new AjaxRtnJson(true, "请上传DOC|DOCX|TXT|HTML|HTM|PDF|MHT格式的文件!");
	                		}
	                	}
	                	//读取excel内容
	                	if(importResume.getImportType() == 3){
	                		ExcelReader excelReader = new ExcelReader();
	                        List<ResumeTemplate> list = excelReader.readExcelContent(file.getInputStream());
	                        for (int i = 0; i < list.size(); i++) {
	                        	//验证应聘职位是否存在
	                        	if(resumeService.queryPositionByName(list.get(i).getPosition()).equals("")){
	                        		return new AjaxRtnJson(true, "应聘职位不存在,请重新填写应聘职位!");
	                        	}
	                        	list.get(i).setPosition(resumeService.queryPositionByName(list.get(i).getPosition()));
	                        	//验证字段属性
	                        	String msg = this.validateColumn(list.get(i));
	                        	if(!msg.equals("")){
	                        		return new AjaxRtnJson(true, msg);
	                        	}
	                        	//通过excel新增简历
	                        	msg = resumeService.createResumeByExcel(list.get(i));
	                        	if(!msg.equals("")){
	                        		return new AjaxRtnJson(true, msg);
	                        	}
	                        }
	                	}
	                	//判断是否是多文件
	                	if(resumeFile.length > 1){
	                		//判断文件是否超过20个
	                		if(resumeFile.length >20)
	                			return new AjaxRtnJson(true, "文件超过20个");
	                		//如果是多文件时判断单个文件大小是否超过4M
	                		if(file.getSize() >= 1024*1024*4)
	                			return new AjaxRtnJson(true, "文件超过4M,请重新选择文件");
	                		//如果是多文件时判断总文件大小是否超过20M
	                		if(totalFileSize >= 1024*1024*20)
	                			return new AjaxRtnJson(true, "文件超过20M,请重新选择文件");
	                	}else{
	                		//如果是单文件时，判断单文件是否大于500k
	                		if(file.getSize() >= 1024*500){
	                			return new AjaxRtnJson(true, "文件超过500k,请重新选择文件");
	                		}
	                	}
	                	logger.info("文件大小："+file.getSize());
	                    //取得当前上传文件的文件名称  
	                    String myFileName = file.getOriginalFilename();  
	                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
	                    if(myFileName.trim().equals("")){  
	                    	logger.info(myFileName);  
	                        //重命名上传后的文件名  
	                        String fileName = file.getOriginalFilename();  
	                        //定义上传路径 
	                        String path = url + fileName;  
	                        File localFile = new File(path);  
	                        if(!localFile.exists()){//判断文件夹是否创建，没有创建则创建新文件夹
	                        	localFile.mkdirs();
	                        }
                        	//判断该文件是否存在
	                        if(!localFile.exists() || importResume.getImportType() == 1){
	                        	//简历不存在重复的和单文件上传直接导入
	                        	file.transferTo(localFile);
	                        }else{
	                        	//判断该简历重复的时候是覆盖还是不导入(1:自动覆盖,0:不导入)
	                        	if(importResume.getForceReplace() == 1){
		                        	file.transferTo(localFile);  
		                        }
	                        }
	                    }  
	                }
	                //记录上传该文件后的时间  
//	                int finaltime = (int) System.currentTimeMillis();  
//	                logger.info((finaltime - pre)+""); 
	            }  
//	        }  
	        return new AjaxRtnJson(true, "上传成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			//返回错误页面
			return new AjaxRtnJson(true, "上传失败"+e.getMessage());
		}
    }  
	
	/**
	 * 单份或批量简历文档上传
	 * @return
	 */
	@RequestMapping(value = "/uploadLocalByDocument")  
	@ResponseBody
	public AjaxRtnJson uploadLocalSingle(ImportResume importResume, HttpServletRequest request) {
	  //String basePath = request.getSession().getServletContext().getRealPath("/") + "resources" + File.separator + "upload";
      String basePath = propertiesUtil.readProperty("resumeDir");
	  UploadUtils upload = new UploadUtils(basePath,"doc,docx,txt,html,htm,pdf,mht");
      if(1 == importResume.getImportType()) { // 单文件上传最大500kb
        upload.setMaxSize(500*1024);
      }
      ResumeUploadResult info = upload.uploadFileForParse("local",request);
      if(info.getValidateResult().equals("true")) {
        List<File> list = info.getFileList();
        int num = 0;
        for(int i = 0; i < list.size(); i++) {
          com.csot.recruit.model.nresume.Resume resume = common.parseResumeByDocument(list.get(i));
          if(null == resume) { // 将上传的文件删除
            num++;
          }
          else {
            if(StringUtil.isNotEmpty(importResume.getJobId())) {
              resume.setPositionId(importResume.getJobId());
            }
            resumeService.createResume(resume,info.getSaveDir().split(",")[i]);
          }
        }
        if(num == list.size()) {
          return new AjaxRtnJson(false, "上传失败！");
        }
        else {
          return new AjaxRtnJson(true, "上传成功!");
        }
      }
      else {
        return new AjaxRtnJson(false, info.getValidateResult());
      }
      
	}
	
	/**
	 * 单份简历通过复制内容上传
	 * @param importResume
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadLocalByCopyContent")  
    @ResponseBody
    public AjaxRtnJson uploadLocalSingleByCopy(ImportResume importResume, HttpServletRequest request) {
	  //String basePath = request.getSession().getServletContext().getRealPath( File.separator + "resources" + File.separator + "upload" + File.separator);
      String basePath = propertiesUtil.readProperty("resumeDir") + "/";
	  String fileDir = "local/copy/" + new Date().getTime() + "/";
	  UploadUtils upload = new UploadUtils(basePath + File.separator + fileDir);
	  com.csot.recruit.model.nresume.Resume resume = common.parseResumeByContent(importResume.getResumetext());
	  if(null != resume) { // 解析成功，保存文件
	    upload.saveContent(null,importResume.getResumetext());
        if(StringUtil.isNotEmpty(importResume.getJobId())) {
          resume.setPositionId(importResume.getJobId());
        }
	    resumeService.createResume(resume,fileDir);
	  }
	  return new AjaxRtnJson(true, "上传成功!");
	}
	
	/**
	 * 通过Excel导入简历
	 * @param importResume
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadLocalByExcel")  
	@ResponseBody
	public AjaxRtnJson uploadLocalByExcel(ImportResume importResume, HttpServletRequest request) {
	  //String basePath = request.getSession().getServletContext().getRealPath("/") + "resources" + File.separator + "upload";
      String basePath = propertiesUtil.readProperty("resumeDir"); 
	  UploadUtils upload = new UploadUtils(basePath,"xls,xlsx");
	  ResumeUploadResult info = upload.uploadFileForParse("local"+ File.separator + "excel",request);
	  if(info.getValidateResult().equals("true")) {
        List<File> fList = info.getFileList();
        for(int i = 0; i < fList.size(); i++) {
          ExcelReader excelReader = new ExcelReader();
          List<ResumeTemplate> list = new ArrayList<ResumeTemplate>();
          try {
            list = excelReader.readExcelContent(new FileInputStream(fList.get(i)));
            for (int j = 0; j < list.size(); j++) {
              // 验证应聘职位是否存在
              if(resumeService.queryPositionByName(list.get(j).getPosition()).equals("")){
                  return new AjaxRtnJson(false, "应聘职位不存在,请重新填写应聘职位!");
              }
              list.get(j).setPosition(resumeService.queryPositionByName(list.get(j).getPosition()));
              // 验证字段属性
              String msg = this.validateColumn(list.get(j));
              if(!msg.equals("")){
                  return new AjaxRtnJson(false, msg);
              }
              String resumeId = UUID.randomUUID().toString().replace("-", "");
              list.get(j).setResumeId(resumeId);
              // 通过excel新增简历
              msg = resumeService.createResumeByExcel(list.get(j));
              if(!msg.equals("")){
                  return new AjaxRtnJson(false, msg);
              }
              myResumeRepositoryService.createIndexImpl(resumeId,0);
            }
          } catch (Exception e) {
            return new AjaxRtnJson(false, e.getMessage());
          }
        }
        return new AjaxRtnJson(true, "上传成功!");
      }
      else {
        return new AjaxRtnJson(false, info.getValidateResult());
      }
	}
	
	
	/***
	 * 判断文件格式是匹配，匹配返回true
	 * @param fileType 文件类型
	 * @param importType 上传类型
	 * @return
	 */
	public boolean isFileType(String fileType,int importType){
		String[] requiredLocalTypes = new String[]{CommonConstant.DOC,
                CommonConstant.DOCX, CommonConstant.HTM, CommonConstant.HTML,
                CommonConstant.MHT, CommonConstant.PDF, CommonConstant.TXT};
    	String[] requiredExcelTypes = new String[]{CommonConstant.XLS,CommonConstant.XLSX};
		//标识文件格式是否匹配
    	int count = 0;
    	if(importType == 3){
    		for(int i = 0; i < requiredExcelTypes.length; i++){
        		if(fileType.equals(requiredExcelTypes[i])){
            		count = 1;
            	}
        	}
        	if(count == 0){
        		return false;
        	}
    	}else{
    		for(int i = 0; i < requiredLocalTypes.length; i++){
        		if(fileType.equals(requiredLocalTypes[i])){
            		count = 1;
            	}
        	}
    		if(count == 0){
        		return false;
        	}
    	}
    	return true;
	}
	
	/**
	 * 上传简历附件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadAttach")  
	@ResponseBody
	public AjaxRtnJson uploadAttachment(String resumeUrl, HttpServletRequest request) {
      //String fileUploadPath = request.getSession().getServletContext().getRealPath("/");
	  //String dir = resumeUrl.substring(resumeUrl.indexOf("/resources/upload/") + 1, resumeUrl.lastIndexOf("/") + 1);
	  String fileUploadPath = propertiesUtil.readProperty("resumeDir"); 
	  String dir = resumeUrl.substring(resumeUrl.indexOf("/resources/upload/") + "/resources/upload/".length() - 1, resumeUrl.lastIndexOf("/") + 1);
	  UploadUtils upload = new UploadUtils(fileUploadPath + dir);
	  String[] info = upload.uploadFile(request);
	  if(info[0] != "true") {
	    return new AjaxRtnJson(false, info[0]);
	  }
	  else if(info[1] != "true") {
	    return new AjaxRtnJson(false, info[1]);
	  }
	  else {
	    return new AjaxRtnJson(true, "上传成功!");
	  }
	}
	
	/**
	 * 删除附件
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = "/deleAttach")  
	@ResponseBody
	public AjaxRtnJson deleAttachment(String resumeId, String fileName, HttpServletRequest request) {
	  //String basePath = request.getSession().getServletContext().getRealPath("/resources/upload/");
	  String basePath = propertiesUtil.readProperty("resumeDir"); 
	  String msg = resumeService.deleAttachment(resumeId, fileName, basePath);
	  if("true".equals(msg)) {
	    return new AjaxRtnJson(true, "删除成功!");
	  }
	  else {
	    return new AjaxRtnJson(false, msg);
	  }
	}
	
	/**
	 * Excel导入简历 验证
	 * @param resumeTemplate
	 * @return
	 */
	public String validateColumn(ResumeTemplate resumeTemplate){
		//姓名不能为空,长度不能超过50
		if(!resumeTemplate.getName().trim().equals("")){
			if(resumeTemplate.getName().length() > 50){
				return "姓名不能超过50个字符";
			}
		}else{
			return "姓名不能为空";
		}
		//必须填写正确的所在省/市，否则为空;如果所在城市不为空，则所在省也必须填写
		if(!resumeTemplate.getCity().trim().equals("")){
			if(resumeTemplate.getProvince().trim().equals("")){
				return "如果所在城市不为空，则所在省也必须填写";
			}
		}
		//联系电话和手机必须填写一个
		if(resumeTemplate.getTelphone().trim().equals("") && resumeTemplate.getMobilePhone().trim().equals("")){
			return "联系电话和手机必须填写一个";
		}
		//邮箱不能为空,且必须为正确的邮箱格式
		if(!resumeTemplate.getEmail().trim().equals("")){
			Pattern p = Pattern.compile("[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+){1,3}");  
		    Matcher m = p.matcher(resumeTemplate.getEmail().trim());
	        if(!m.matches()){
	    	    return "请填写正确的邮箱格式";
	        }
		}else{
			return "邮箱不能为空";
		}
		//工作经验、期望薪资、当前月薪，如果填写必须为整数,其中期望薪资可填写“面议
		Pattern p = Pattern.compile("^[0-9]*[1-9][0-9]*$");  
		if(resumeTemplate.getExperience() != 0){
			//如果工作经验不为空必须为整数
		    Matcher m = p.matcher(String.valueOf(resumeTemplate.getExperience()));
	        if(!m.matches()){
	    	    return "工作经验必须为整数";
	        }
		}
		//工作经验、期望薪资、当前月薪，如果填写必须为整数,其中期望薪资可填写“面议
		if(!resumeTemplate.getExpectedSalary().trim().equals("")){
			//如果期望薪资不为空和面议则必须为整数
			if(!resumeTemplate.getExpectedSalary().trim().equals("面议")){
				Matcher m = p.matcher(resumeTemplate.getExpectedSalary().trim());
		        if(!m.matches()){
		    	    return "期望薪资不为空时,必须为整数或面议";
		        }
			}
		}
		//工作经验、期望薪资、当前月薪，如果填写必须为整数,其中期望薪资可填写“面议
		if(!resumeTemplate.getExpectedSalary().trim().equals("")){
			//如果当前月薪不为空和保密则必须为整数
			if(!resumeTemplate.getCurrentSalary().trim().equals("保密")){
				Matcher m = p.matcher(resumeTemplate.getCurrentSalary().trim());
		        if(!m.matches()){
		    	    return "当前月薪不为空时,必须为整数或保密";
		        }
			}
		}
		//教育经历：最高学历、毕业学校、专业，三者同时填写或者同时为空
		if(resumeTemplate.getEducation().trim().equals("") && resumeTemplate.getGraduationSchool().trim().equals("") && resumeTemplate.getProfessional().trim().equals("")){
		}else if(!resumeTemplate.getEducation().trim().equals("") && !resumeTemplate.getGraduationSchool().trim().equals("") && !resumeTemplate.getProfessional().trim().equals("")){
		}else{
			return "教育经历：最高学历、毕业学校、专业，三者同时填写或者同时为空";
		}
		//最高学历可选择：高中及以下、大专、本科、硕士、MBA、博士
		if(!resumeTemplate.getEducation().trim().equals("")){
			if(resumeTemplate.getEducation().trim().equals("高中及以下") || resumeTemplate.getEducation().trim().equals("大专") 
					|| resumeTemplate.getEducation().trim().equals("本科") || resumeTemplate.getEducation().trim().equals("硕士")
					|| resumeTemplate.getEducation().trim().equals("MBA") || resumeTemplate.getEducation().trim().equals("博士")){
			}else{
				return "最高学历不为空时可填写：高中及以下、大专、本科、硕士、MBA、博士";
			}
		}
		//简历语言不能为空；且只能输入“中文”或“英文
		if(!resumeTemplate.getResumeLanguage().trim().equals("")){
			//判断简历语言只能为中文或英文
			if(resumeTemplate.getResumeLanguage().equals("英文") || resumeTemplate.getResumeLanguage().equals("中文")){
			}else{
				return "简历语言必须为英文或中文";
			}
		}else{
			return "简历语言不能为空!";
		}
		//所有候选人必须填写招聘渠道才能导入成功。如果招聘渠道为员工推荐的，还必须填写推荐人姓名，推荐人邮箱
		if(!resumeTemplate.getChannel().trim().equals("")){
			if(resumeTemplate.getChannel().equals("员工推荐")){
				if(null == resumeTemplate.getRecommend() || resumeTemplate.getRecommend().trim().equals("")){
					return "招聘渠道为员工推荐的,推荐人姓名不能为空";
				}
				if(null == resumeTemplate.getRecommendEmail() || resumeTemplate.getRecommendEmail().trim().equals("")){
					return "招聘渠道为员工推荐的,推荐人邮箱不能为空";
				}
			}
		}else{
			return "招聘渠道不能为空!";
		}
		return "";
	}
	
	/***
	 * 邮件导入
	 * @param userName 用户名
	 * @param password 密码
	 * @param server 接收邮件服务器
	 * @param port 接收邮件服务器端口
	 * @param useSSL 安全套接层协议
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/uploadMail", method = RequestMethod.POST)  
	@ResponseBody
    public AjaxRtnJson uploadMail(@RequestParam(value = "userName", required = true)String userName, 
    		@RequestParam(value = "password", required = true)String password,
    		@RequestParam(value = "server", required = true)String server,
    		@RequestParam(value = "port", required = true)String port,
    		@RequestParam(value = "useSSL", required = false)String useSSL,
    		HttpServletRequest request,HttpServletResponse response) {  
		try {
			resumeService.parseResumeByEmail(userName, password, server);
		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			return new AjaxRtnJson(false, "解析失败"+ e.getMessage());
		}
		return new AjaxRtnJson(false, "解析成功");
	}
}
