package com.csot.recruit.controller.resume;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.spi.Bean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.model.BaseUser;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.common.util.ExportExcelUtil;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.model.original.interview.InterviewInfo;
import com.csot.recruit.model.position.PositionMana;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.resume.Category;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.ITSkill;
import com.csot.recruit.model.resume.Label;
import com.csot.recruit.model.resume.LanguageSkill;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.ResumeTemplate;
import com.csot.recruit.model.resume.ResumesData;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.resume.WorkIntention;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.vo.ResumeDataVo;
import com.csot.recruit.service.position.RecruitPositionService;
import com.csot.recruit.service.resume.CategoryService;
import com.csot.recruit.service.resume.FileService;
import com.csot.recruit.service.resume.LabelRalationService;
import com.csot.recruit.service.resume.LabelService;
import com.csot.recruit.service.resume.MyResumeRepositoryService;
import com.csot.recruit.service.resume.ResumeService;
import com.csot.recruit.service.template.TemplateService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("resume")
public class ResumeRepositoryController {
    private static final Logger logger = LoggerFactory
            .getLogger(ResumeRepositoryController.class);
    
    @Resource
    private CategoryService categoryService;
  
    @Resource
    LabelService labelService;
  
    @Resource
    private MyResumeRepositoryService resumeRepositoryService;
   
    @Resource
    private ResumeService resumeService;
    
    @Resource
    private FileService fileService;
    
    @Resource
    private CommonService commonService;
    
    @Resource 
    private RecruitPositionService recruitPositionService;
    
    @Resource
    private TemplateService templateService;
    
    @Resource
    private LabelRalationService labelRalationService ;
    
    private static final GsonBuilder gsonBuilder = new GsonBuilder();
    private static final Gson gson;

    static {
      gson = gsonBuilder.setDateFormat("yyyy-MM-dd").create();
    }
    
    @RequestMapping("queryRepository") 
    public ModelAndView positionManaPage(HttpServletRequest request) {
    	/*String path = request.getSession().getServletContext().getRealPath("/");
    	path = path+"resources"+File.separator+"ftl";
    	logger.info(path);
    	List<String> list = getFile(path);*/
    	ModelAndView view = new ModelAndView("com/csot/resume/myResumeRepository");
    	List<Template> list = templateService.queryTemplateList();
    	view.addObject("sendResumeTempList", list);
        return view;
    }
    
    /***
     * 获取文件名
     */
    private List<String> getFile(String path){
    	List<String> list = new ArrayList<String>();
    	File file = new File(path); 
    	File[] array = file.listFiles(); 
    	for(int i=0;i<array.length;i++){   
    		if(array[i].isFile()){   
    			String fileName = array[i].getName().substring(0,array[i].getName().lastIndexOf("."));
    			if(!fileName.equals("template")){
    				list.add(fileName);
    			}
    		}
    	}
    	return list;
    }
    
    /**
     * 标准文档管理
     * @return
     */
    @RequestMapping("fileManager")
    public ModelAndView fileManagerPage(HttpServletRequest request){
        List<com.csot.recruit.model.resume.File> allFile = fileService.getAllFile(request);
        return new ModelAndView("com/csot/resume/fileManager").addObject("files",allFile);
    }
    
    /**
     * 招聘支持-文档管理
     * @return
     */
    @RequestMapping("newFileManager")
    public ModelAndView newFileManagerPage(HttpServletRequest request){
        //List<com.csot.recruit.model.resume.File> allFile = fileService.getAllFile(request);
        //return new ModelAndView("com/csot/resume/newFileManager").addObject("files",allFile);
        return new ModelAndView("com/csot/resume/newFileManage");
    }
    
    /**
     * Get FileDatagrid.
     */
    @RequestMapping("fileDatagrid")
    @ResponseBody
    public List<com.csot.recruit.model.resume.File> fileDatagrid(HttpServletRequest request) {
      return fileService.getAllFile(request);
    }
    
    /**
     * remove file by id.
     */
    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id, HttpServletResponse response,HttpServletRequest request) {
      try {
        fileService.deletFile(response, request, id);
        return new AjaxRtnJson(true, "删除成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
      }
    }
    
    /**
     * 上传文件
     * @param request
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addFile", method = RequestMethod.POST)
    public AjaxRtnJson addFileToDb(HttpServletRequest request,com.csot.recruit.model.resume.File file){
      fileService.addFileToDb(file,request);
      return new AjaxRtnJson(true, "上传成功!");
    }
    
    /**
     * 下载文件
     * @param fileKey
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("loadFile")
    public String loadFile(@RequestParam String fileKey,HttpServletResponse response,HttpServletRequest request){
      return fileService.getLoadFile(response,request,fileKey);
    }
    
    /**
     * 删除文件
     * @param fileKey
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("deleteFile")
    public String deleFile(@RequestParam String fileKey,HttpServletRequest request,HttpServletResponse response){
      fileService.deletFile(response, request, fileKey);
      return "redirect:/resume/fileManager";
    }
    
    /**
     * 验证文件名称是否存在
     * @param fileName
     * @return
     */              
    @RequestMapping("validateFileName")
    @ResponseBody
    public AjaxRtnJson validateFileName(@RequestParam String fileName){
      boolean flag = fileService.validateFileName(fileName);
      if(flag){
        return new AjaxRtnJson(true,"success");
      }
      return new AjaxRtnJson(false,"fail");
    }
    
    @RequestMapping("fileList")
    @ResponseBody
    public AjaxRtnJson getFileList(HttpServletRequest request){
      AjaxRtnJson ar ;
      List<com.csot.recruit.model.resume.File> allFile = fileService.getAllFile(request);
      if(allFile !=null && allFile.size()>0){
        ar = new AjaxRtnJson(true,"查询成功");
        ar.setObj(allFile);
      }else{
        ar = new AjaxRtnJson(false,"查询失败");
      }
      return ar;
    }
    
    /***
     * 本地上传页面
     * @return
     */
    @RequestMapping("importResumeLocal")
    public ModelAndView importResumeLocal() {
      ModelAndView view = new ModelAndView("com/csot/resume/importResumeLocal");
      List<PositionMana> list = recruitPositionService.queryPositionMana(new PositionMana());
      view.addObject("positionlist", list);
      return view;
    }
    
    /***
     * 邮件导入页面
     * @return
     */
    @RequestMapping("importResumeEmail")
    public ModelAndView importResumeEmail() {
        ModelAndView view = new ModelAndView("com/csot/resume/importResumeEmail");
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        String userName = propertiesUtil.readProperty("username");
        String password = propertiesUtil.readProperty("password");
        String server = propertiesUtil.readProperty("server");
        view.addObject("userName", userName);
        view.addObject("password", password);
        view.addObject("server", server);
        return view;
    }
    
    /***
     * 多文件上传记录页面
     * @return
     */
    @RequestMapping("importMultipleResumeRecord")
    public ModelAndView importMultipleResume() {

        return new ModelAndView("com/csot/resume/importMultipleResumeRecord");
    }
    
    /***
     * 邮件导入记录页面
     * @return
     */
    @RequestMapping("importResumeEmailRecord")
    public ModelAndView importResumeEmailRecord() {

        return new ModelAndView("com/csot/resume/importResumeEmailRecord");
    }
    
    /***
     * 简历模板下载
     * @param response
     */
    @RequestMapping("exportResumeTemplate")
    public void exportResumeTemplate(HttpServletResponse response) {
        String[] headersName = new String[]{"姓名*","性别","年龄","所在省份","所在城市","联系地址",
                "联系电话","手机","民族","邮箱*","工作经验","期望薪资","最高学历","毕业学校",
                "专业","最近雇主公司","最近职位","当前月薪","简历语言*","招聘渠道*","推荐人姓名","推荐人邮箱","应聘职位","身份证号"};
        String[] headersId = new String[]{"name","sex","age","province","city","address","telphone",
                "mobilePhone","nation","email","experience","expectedSalary","education","graduationSchool","professional",
                "company","currentPosition","currentSalary","resumeLanguage","channel","recommend","recommendEmail","position","cardId"};
        List<ResumeTemplate> list = new ArrayList<ResumeTemplate>();
        ResumeTemplate resumeTemplate = new ResumeTemplate();
        resumeTemplate.setName("刘德华");
        resumeTemplate.setSex("男");
        resumeTemplate.setAge(33);
        resumeTemplate.setProvince("湖北省");
        resumeTemplate.setCity("武汉市");
        resumeTemplate.setAddress("玄武大道1078号");
        resumeTemplate.setTelphone("0755-54454545");
        resumeTemplate.setMobilePhone("13838380438");
        resumeTemplate.setNation("汉");
        resumeTemplate.setEmail("liudehua@126.com");
        resumeTemplate.setExperience(2);
        resumeTemplate.setExpectedSalary("面议");
        resumeTemplate.setEducation("博士");
        resumeTemplate.setGraduationSchool("华中科技大学");
        resumeTemplate.setProfessional("计算机科学与技术");
        resumeTemplate.setCompany("腾讯");
        resumeTemplate.setCurrentSalary("保密");
        resumeTemplate.setCurrentPosition("产品经理");
        resumeTemplate.setChannel("员工推荐");
        resumeTemplate.setResumeLanguage("中文");
        resumeTemplate.setRecommend("");
        resumeTemplate.setRecommendEmail("");
        resumeTemplate.setPosition("PHP开发工程师 ");
        resumeTemplate.setCardId("431103198912099874");
        list.add(resumeTemplate);
        ExportExcelUtil excelUtil = new ExportExcelUtil();
        excelUtil.exportExcel("候选人模板", headersName, headersId, list,response);
    }
    
    /**
     * 标签管理页面
     * @return
     */
    @RequestMapping("commonlyUsedTag")
    public ModelAndView commonlyUsedTag() {
        ModelAndView view = new ModelAndView("com/csot/resume/commonlyUsedTag");
        List<Category> categoryList = categoryService.getCategoryList();
        view.addObject("categoryList", categoryList);
        List<Label> labelList = labelService.getLabelList();
        view.addObject("labelList", labelList);
        return view;
    }
    
    /**
     * 个人简历预览
     * @return
     */
    @RequestMapping("personalResume/{id}")
    public ModelAndView personalResume(@PathVariable String id, HttpServletRequest request) {
      Resume resume = resumeService.getByPrimaryKey(id, request);
      request.setAttribute("resume", resume);
     // request.setAttribute("user", commonService.loginUser());
      return new ModelAndView("com/csot/resume/personalResume");
    }
    
    /**
     * 个人简历查询 
     * @return
     */
    @RequestMapping("queryResume/{id}")
    @ResponseBody
    public AjaxRtnJson queryResume(@PathVariable String id, HttpServletRequest request) {
      Resume resume = resumeService.getByPrimaryKey(id, request);
      AjaxRtnJson re = new AjaxRtnJson(true,"查询成功");
      re.setObj(resume);
      return re;
    }
    
    /**
     * 下载简历原文
     * @param resumeId 简历id
     * @param resumePath 简历存放目录
     * @param resumeName 简历名称
     * @param res
     * @throws IOException
     */
    @RequestMapping("downloadResume")  
    public void downloadResume(@RequestParam String resumePath, @RequestParam String resumeName, HttpServletResponse res, HttpServletRequest req) {  
      try {
        resumeService.downloadResume(resumePath, resumeName, res, req);
      } catch (IOException e) {
        logger.info(e.getMessage());
      }
    }
    
    /**
     * 标签删除
     * @param resumeId 简历id
     * @param resumeTags 简历的标签
     * @param tagId 待删除的标签id
     * @return
     */
    @RequestMapping("deleTag")
    @ResponseBody
    public AjaxRtnJson deleTag(@RequestParam String resumeId, @RequestParam String resumeTags, @RequestParam String tagId) {
      resumeService.deleTag(resumeId, resumeTags, tagId);
      return new AjaxRtnJson(true,"删除成功");
    }
    
    /**
     * 更新简历的标签
     * @param resumeId 简历id
     * @param labels 简历的标签
     * @param deletes 需要删除的标签
     * @param adds 票面添加的标签
     * @return
     */
    @RequestMapping("updateTags")
    @ResponseBody
    public AjaxRtnJson updateTags(@RequestParam String resumeId, @RequestParam String labels, @RequestParam String deletes, @RequestParam String adds) {
      resumeService.updateTags(resumeId, labels, deletes, adds);
      return new AjaxRtnJson(true,"更新成功");
    }
    
    /**
     * 更新候选人的标签
     * @param resumeId 简历id
     * @param labels 简历的标签
     * @return
     */
    @RequestMapping("updateCandidateTags")
    @ResponseBody
    public AjaxRtnJson updateCandidateTags(@RequestParam String resumeId, @RequestParam String labels,@RequestParam String deletes,@RequestParam String adds) {
      if(labels.endsWith(",")){
        labels = labels.substring(0, labels.length()-1);
      }
      labelRalationService.updateTags(resumeId, labels,deletes,adds);
      return new AjaxRtnJson(true,"更新成功");
    }
    
    /**
     * 更新候选人的标签
     * @param resumeId 简历id
     * @param labels 简历的标签
     * @return
     */
    @RequestMapping("addCandidateTags")
    @ResponseBody
    public AjaxRtnJson addCandidateTags(@RequestParam String resumeId, @RequestParam String labels,@RequestParam String deletes,@RequestParam String adds) {
    
      labelRalationService.addTags(resumeId, labels,deletes,adds);
      return new AjaxRtnJson(true,"更新成功");
    }
    
    /**
     * 更新候选人的标签
     * @param candidateId 候选人id
     * @param labels 简历的标签
     * @return
     */
    @RequestMapping("addCandidateTagsBycid")
    @ResponseBody
    public AjaxRtnJson addCandidateTagsBycid(@RequestParam String resumeId, @RequestParam String labels,@RequestParam String deletes,@RequestParam String adds) {
    
      labelRalationService.addCandidateTagsBycid(resumeId, labels,deletes,adds);
      return new AjaxRtnJson(true,"更新成功");
    }
    
    
    /**
     * 添加简历评论
     * @param resumeId
     * @param content
     * @return
     */
    @RequestMapping("addResumeComment")
    @ResponseBody
    public AjaxRtnJson addResumeComment(@RequestParam String resumeId, @RequestParam String content, @RequestParam Integer privacylevel) {
      String msg = resumeService.addResumeComment(resumeId,content,privacylevel);
      if("true".equals(msg)) {
        return new AjaxRtnJson(true,"评论成功！");
      }
      else {
        return new AjaxRtnJson(false,msg);
      }
    }
    
    /***
     * 简历管理查询
     * @param page 分页对象
     * @param positionMana 查询对象
     * @return
     */
       @ResponseBody
       @RequestMapping("queryResumeDataList")
       public  MiniRtn2Grid<ResumesData> queryResumeData(MiniGridPageSort page, ResumesData resumesData){
         MiniRtn2Grid<ResumesData> minirtn2Grid = resumeRepositoryService
             .queryResumeRepositoryListByPage(page, resumesData);
         return minirtn2Grid;
       }
       
       /**
        * 分类统计学历,毕业学校等信息并计数
        * @return
        */
       @RequestMapping("queryClassifyInfo")
       @ResponseBody
       public Map<String,Object> getClassifyByPosition(@RequestBody ResumesData resumeData){
         Map<String,Object> map = resumeRepositoryService.queryClassifyByPosition(resumeData);
         return map;
       } 
       
       /**
        * 录入界面
        * @return
        */
       @RequestMapping("addResume")
       public ModelAndView trunToAddResumePage(){
         return new ModelAndView("com/csot/resume/addResume");
       }
       
       /**
        * 简历录入
        * @return
        */
       
       @RequestMapping("resumeSave")
       @ResponseBody
       public AjaxRtnJson saveResume(@CurrentUser SysUser sysUser, @RequestParam(required = true) String jsonData){
           ResumeDataVo resumeDataVo = gson.fromJson(jsonData, ResumeDataVo.class);
           if(resumeDataVo !=null){
             String id = resumeRepositoryService.saveOrUpdateResume(resumeDataVo,sysUser);
             return new AjaxRtnJson(true,id);
           }else{
             return new AjaxRtnJson(true,null);
           }
       } 
       
      /**
        * @throws IOException 
        * @throws IllegalStateException 
         * 
         */
/*        @RequestMapping(value = "uploadImage", method = RequestMethod.POST,produces = "application/json; charset=utf-8")  
        @ResponseBody
        public String upload( HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
          String url = ConstantsConfigurer.getProperty("imageUploadUrl");
        //上传多文件的总大小
          int totalFileSize = 0;
          //上传多文件的总个数
          int totalCount = 0;
        //创建一个通用的多部分解析器  
          CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
          //判断 request 是否有文件上传,即多部分请求  
          if(multipartResolver.isMultipart(request)){  
              //转换成多部分request    
              MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
              //取得request中的所有文件名  
              Iterator<String> iter = multiRequest.getFileNames();  
              while(iter.hasNext()){   
                //记录上传过程起始时的时间，用来计算上传时间 
//              int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                totalFileSize += file.getSize();
                totalCount += ++totalCount;
                if(file != null){  
                    //截取文件后缀判断文件类型是否匹配
                    String originalFilename = file.getOriginalFilename();
                    String type = file.getOriginalFilename().substring(
                            (originalFilename.lastIndexOf('.')) + 1);
                    
                    if(!(".jpg".equals(type) || ! ".gif".equals(type)|| ".jepg".equals(type))){
                      return "请上传jpg或者jepg格式的gif格式的文件!";
                    }
                    
                    if(!iter.hasNext()){
                      if(file.getSize() >= 1024*1024){
                          return "文件超过1M,请重新选择文件";
                      }
                    }
                    logger.info("文件大小："+file.getSize());
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        logger.info(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = file.getOriginalFilename(); 
                        int isExist = fileName.indexOf("*");
                        if(isExist !=-1){
                          fileName.replaceAll("*","-");
                        }
                        //定义上传路径 
                        String path = url + fileName;  
                        File localFile = new File(path);  
                        //判断该文件是否存在
                        if(!localFile.exists()){
                            //简历不存在重复
                            file.transferTo(localFile);
                            return "文件上传路径*"+ path;
                        }else{
                            return "该图片已存在";
                        }
                    }
                }
          }
          return null;
        }
          return null;
     }*/
       
       /***
        * 企业人才库导出
        * @param response
        * @param resumesData 人才库条件
        */
       @ResponseBody
       @RequestMapping("repositoryExport")
       public void repositoryExport(HttpServletResponse response, ResumesData resumesData) {
           String[] headersName = new String[]{"姓名","甄选状态","关联职位","年龄","职位或岗位","标签",
                   "就职公司","当前所在地","学历","毕业学校","工作经验","简历来源","期望薪资","招聘渠道","更新日期"};
           String[] headersId = new String[]{"name","selectionStatus","position","age","currentPosition","label",
                   "company","residence","highestEducation","graduationSchool","experience","resumeOrigin","salaryExpect","channel","updateDate"};
           MiniRtn2Grid<ResumesData> minirtn2Grid = resumeRepositoryService
                   .queryResumeRepositoryListByPage(null, resumesData);
           ExportExcelUtil excelUtil = new ExportExcelUtil();
           excelUtil.exportExcel("企业人才库", headersName, headersId, minirtn2Grid.getData(),response);
       }
       
       /***
        * 根据简历id删除简历(逻辑删除，改变简历状态)
        * @param response
        * @param resumeId 简历id
        * @throws Exception 
        */
       @ResponseBody
       @RequestMapping(value="deleteResumeById",method= RequestMethod.POST)
       public void deleteResumeById(HttpServletResponse response, @RequestParam(value = "resumeIds", required = true)String resumeIds){
           Resume resume = new Resume();
           resume.setId(resumeIds);
           resume.setResumeStatus(-1);
           try {
               resumeService.updateResumeById(resume);
           } catch (Exception e) {
            logger.error("删除简历异常"+e.getMessage());
           }
       }
       
       /***
        * 添加候选人
        * @param response
        * @param resumeIds 候选人id
        * @param channel 招聘渠道
        */
       @ResponseBody
       @RequestMapping(value="addToCandidate",method= RequestMethod.POST)
       public AjaxRtnJson addCandidates(HttpServletResponse response, 
               @RequestParam(value = "resumeId", required = true)String resumeId,
               @RequestParam(value = "channel", required = false)String channel,
               @RequestParam(value = "relatePositionId", required = false)String positionId){
            //验证该职位是否存在
            if(positionId !=null && !"".equals(positionId)){
              RecruitPosition recruitPosition = recruitPositionService.getByPrimaryKey(positionId);
              if(recruitPosition ==null){
                return new AjaxRtnJson(false,"关联职位已不存在");
              }
            }
            String msg = resumeService.addToCandidate(resumeId,channel,positionId); 
            if("true".equals(msg)) {
              return new AjaxRtnJson(true,"操作成功！");
            }
            else {
              return new AjaxRtnJson(false,msg);
            }
       }
       
       /***
        * 简历的编辑
        * @param id 简历的Id
        * @return
        */
        
          @RequestMapping("editResume/{id}")
          public ModelAndView editResume(@PathVariable String id) {
            return new ModelAndView("com/csot/resume/addResume").addObject("id", id);
          }
          
          /**
           * 填充简历的数据
           * @param id
           * @return
           */
          @RequestMapping("editAddResume/{id}")
          @ResponseBody
          public ResumesData editAddResume(@PathVariable String id) {
            ResumesData resumesData = resumeRepositoryService.queryResumesDataById(id);
            return resumesData;
          }
          
          
       /***
        * 发送简历
        * @param response
        * @param candidateName 候选人
        * @param resumeIds 简历id
        * @param txtSrEmail 收件人邮箱
        * @param sendResumeTemp 邮件模板名称
        * @param postscript 邮件附言
        */
       @ResponseBody
       @RequestMapping(value="transmitResume",method= RequestMethod.POST)
       public AjaxRtnJson transmitResume(HttpServletResponse response, 
               @RequestParam(value = "resumeIds", required = true)String resumeIds,
               @RequestParam(value = "txtSrEmail", required = true)String txtSrEmail,
               @RequestParam(value = "candidateName", required = true)String candidateName,
               @RequestParam(value = "sendResumeTemp", required = true)String sendResumeTemp,
               @RequestParam(value = "postscript", required = false)String postscript, 
               HttpServletRequest request){
    	   String msg = null;
    	   BaseUser user = commonService.loginUser();
		   String url = request.getSession().getServletContext().getRealPath("/");
		   url += "resources"+File.separator+"upload";
    	   try {
             msg = resumeService.transmitResume(candidateName, resumeIds, txtSrEmail, 
            		 sendResumeTemp, postscript, user.getName(), url);
           } catch (Exception e) {
	            logger.error("发送邮件异常"+e);
	            return new AjaxRtnJson(true,e.getMessage());
           }
    	   return new AjaxRtnJson(true,msg);
       }
       
       /***
        * 发送短信
        * @param response
        * @param mobilePhone 手机号码
        * @param template 短信模板
        * @param content 短信内容
        */
       @ResponseBody
       @RequestMapping(value="sendMessage",method= RequestMethod.POST)
       public AjaxRtnJson sendMessage(HttpServletResponse response, 
               @RequestParam(value = "mobilePhone", required = true)String mobilePhone,
               @RequestParam(value = "smsTemplate", required = false)String smsTemplate,
               @RequestParam(value = "smsContent", required = true)String smsContent){
    	   String msg = "操作成功";
           try {
        	   boolean isSuccess = commonService.sendSms(mobilePhone, smsContent);
        	   if(!isSuccess){
        		  msg = "操作失败";
        	   }
               logger.info("ResumeRepositoryController mobilePhone:"+mobilePhone);
           } catch (Exception e) {
               logger.error("发送短信异常"+e);
           }
           return new AjaxRtnJson(true,msg);
       }
       
}
