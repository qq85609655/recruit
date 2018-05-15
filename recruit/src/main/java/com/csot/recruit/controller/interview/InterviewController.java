package com.csot.recruit.controller.interview;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.common.util.Pinyin4jUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.common.util.WriteExcel;
import com.csot.recruit.model.original.campus.CampusStudent;
import com.csot.recruit.model.original.interview.EmergentContacts;
import com.csot.recruit.model.original.interview.FamilyMember;
import com.csot.recruit.model.original.interview.Illustrate;
import com.csot.recruit.model.original.interview.InterviewInfo;
import com.csot.recruit.model.original.interview.Language;
import com.csot.recruit.model.original.interview.Recommend;
import com.csot.recruit.model.original.interview.Reward;
import com.csot.recruit.model.position.PositionMana;
import com.csot.recruit.model.resume.Certification;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.vo.InterviewInfoForm;
import com.csot.recruit.service.campus.CampusStudentService;
import com.csot.recruit.service.datadict.DatadictGroupService;
import com.csot.recruit.service.datadict.DatadictGroupTypeService;
import com.csot.recruit.service.interview.EducationService;
import com.csot.recruit.service.interview.EmergentContactsService;
import com.csot.recruit.service.interview.FamilyMemberService;
import com.csot.recruit.service.interview.IllustrateService;
import com.csot.recruit.service.interview.InterviewInfoService;
import com.csot.recruit.service.interview.InterviewPrintService;
import com.csot.recruit.service.interview.LanguageService;
import com.csot.recruit.service.interview.RecommendService;
import com.csot.recruit.service.interview.RewardService;
import com.csot.recruit.service.interview.WorksService;
import com.csot.recruit.service.resume.CertificationService;
import com.csot.recruit.service.resume.EducationExperienceService;
import com.csot.recruit.service.resume.WorkExperienceService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
@Controller
@RequestMapping("interviewController")
public class InterviewController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewController.class);

    @Resource
    private DatadictGroupService datadictGroupService;
    
    @Resource
    private CommonService commonService;
    
    @Resource
    private InterviewInfoService interviewInfoService;
    
    @Resource
    private FamilyMemberService familyMemberService;
    
    @Resource
    private EmergentContactsService emergentContactsService;
    
    @Resource
    private EducationService educationService;
    
    @Resource
    private EducationExperienceService educationExperienceService;
    
    @Resource
    private CertificationService certificationService;
    
    @Resource
    private LanguageService languageService;
    
    @Resource
    private WorksService worksService;
    @Resource
    private WorkExperienceService workExperienceService;
    
    @Resource
    private RewardService rewardService;
    
    @Resource
    private RecommendService recommendService;
    
    @Resource
    private IllustrateService illustrateService;
    
    @Resource
    private DatadictGroupTypeService datadictGroupTypeService ;
    
    @Resource
    private CampusStudentService campusStudentService ;
    
    @Resource
    private SpringPropertyResourceReader springPropertyResourceReader;
    
    @Resource
    private InterviewPrintService interviewPrintService;
    
    
    private static final GsonBuilder gsonBuilder = new GsonBuilder();
    private static final Gson gson;

    static {
      gson = gsonBuilder.setDateFormat("yyyy-MM-dd").create();
    }

    @RequestMapping("toInterview")
    public ModelAndView toInterview() {
      ModelAndView mav = new ModelAndView("com/csot/interview/toInterview");
      mav.addObject("studentId", "");
      return new ModelAndView("com/csot/interview/toInterview");
    }
    
    @RequestMapping("toInterPage/{id}")
    public ModelAndView toInterPage(@PathVariable("id") String studentId) {
      ModelAndView mav = new ModelAndView("com/csot/interview/toInterview");
      CampusStudent cs = campusStudentService.getByPrimaryKey(studentId);
      if(cs == null || "1".equals(cs.getJobClass())){
        return null;
      }
      mav.addObject("studentId", studentId);
      return mav;
    }
    
    @RequestMapping("toReview")
    public ModelAndView toReview(HttpServletRequest request,InterviewInfoForm interviewInfoForm) {
      //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      String baseInfo = interviewInfoForm.getBaseInfo();
      InterviewInfo interviewInfo = gson.fromJson(baseInfo, InterviewInfo.class);
      if(interviewInfo != null){
        interviewInfo.setNationality(datadictGroupTypeService.getNameByCodeValue("nationality", interviewInfo.getNationality()));
        interviewInfo.setSex(datadictGroupTypeService.getNameByCodeValue("sex-interview", interviewInfo.getSex()));
        interviewInfo.setMaritalStatus(datadictGroupTypeService.getNameByCodeValue("marital-status-interview", interviewInfo.getMaritalStatus()));
        interviewInfo.setNation(datadictGroupTypeService.getNameByCodeValue("nation", interviewInfo.getNation()));
        interviewInfo.setPoliticalStatus(datadictGroupTypeService.getNameByCodeValue("political-status", interviewInfo.getPoliticalStatus()));
        interviewInfo.setResidenceProperty(datadictGroupTypeService.getNameByCodeValue("residence-property", interviewInfo.getResidenceProperty()));
        interviewInfo.setCertificateType(datadictGroupTypeService.getNameByCodeValue("certificate-type", interviewInfo.getCertificateType()));
        interviewInfo.setHighestEducation(datadictGroupTypeService.getNameByCodeValue("highest-education", interviewInfo.getHighestEducation()));
        interviewInfo.setRecruitmentApproach(datadictGroupTypeService.getNameByCodeValue("recruitment-approach", interviewInfo.getRecruitmentApproach()));
        interviewInfo.setRelativesFlag(datadictGroupTypeService.getNameByCodeValue("relatives-flag", interviewInfo.getRelativesFlag()));
        
      }
     
      request.setAttribute("basicInfo", interviewInfo);
      // 家庭成员
      String family = interviewInfoForm.getFamily();
      //List<FamilyMember> fs = gson.fromJson(family, new TypeToken<List<FamilyMember>>() {}.getType());
      request.setAttribute("fs", family);
      // 紧急联系人
      String emergent = interviewInfoForm.getEmergent();
    /*  List<EmergentContacts> egms =
          gson.fromJson(emergent, new TypeToken<List<EmergentContacts>>() {}.getType());*/
      request.setAttribute("egms", emergent);
  
      // 教育经历
      String education = interviewInfoForm.getEducation();
      // EducationExperience edu = gson.fromJson(education, EducationExperience.class);
      List<EducationExperience> edus =
          gson.fromJson(education, new TypeToken<List<EducationExperience>>() {}.getType());
      for(EducationExperience ee : edus){
        ee.setEducation(datadictGroupTypeService.getNameByCodeValue("educational-background", ee.getEducation()));
        ee.setEduType(datadictGroupTypeService.getNameByCodeValue("educational-type", ee.getEduType()));
        ee.setStartDate(DateKit.dateToStr(ee.getEduStartDate()));
        ee.setEndDate(DateKit.dateToStr(ee.getEduEndDate()));
        if(ee.getCertificate() != null){
          StringBuffer sb = new StringBuffer();
          for(String str : ee.getCertificate().split(",")){
            sb.append(datadictGroupTypeService.getNameByCodeValue("get-certificate", str)+ " ");
          }
          ee.setCertificate(sb.toString());
        }
        ee.setCertNationality(datadictGroupTypeService.getNameByCodeValue("nationality", ee.getCertNationality()));
      }
      request.setAttribute("edus", edus);
      // 获得证书
      String certification = interviewInfoForm.getCertification();
      List<Certification> certifications =
          gson.fromJson(certification, new TypeToken<List<Certification>>() {}.getType());
      for(Certification c : certifications){
        c.setType(datadictGroupTypeService.getNameByCodeValue("diploma-type", c.getType()));
        c.setRecivingDateStr(DateKit.dateToStr(c.getReceivingdate()));
      }
      request.setAttribute("certifications", certifications);
      // 计算机与语言
      String language = interviewInfoForm.getLanguage();
      Language lan = gson.fromJson(language, Language.class);
      if(lan != null){
        lan.setOfficeSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getOfficeSkilledLevel()));
        lan.setEnglishSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getEnglishSkilledLevel()));
        lan.setSapSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getSapSkilledLevel()));
        lan.setKoreanSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getKoreanSkilledLevel()));
        lan.setVbaSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getVbaSkilledLevel()));
        lan.setJapaneseSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getJapaneseSkilledLevel()));
        lan.setOtheritSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getOtheritSkilledLevel()));
        lan.setOtherSkilledLevel(datadictGroupTypeService.getNameByCodeValue("skilled-level", lan.getOtherSkilledLevel()));
        
      }
      request.setAttribute("lans", lan);
  
      // 工作经历
      String work = interviewInfoForm.getWork();
      List<WorkExperience> works =
          gson.fromJson(work, new TypeToken<List<WorkExperience>>() {}.getType());
      for(WorkExperience ex : works){
        ex.setStartDate(DateKit.dateToStr(ex.getJobStartDate()));
        ex.setEndDate(DateKit.dateToStr(ex.getJobEndDate()));
      }
      request.setAttribute("works", works);
      // 奖励及特长
      String reward = interviewInfoForm.getReward();
      //List<Reward> rewardList = gson.fromJson(reward, new TypeToken<List<Reward>>() {}.getType());
      Reward rew = gson.fromJson(reward, Reward.class);
      request.setAttribute("rews", rew);
  
      // 推荐人
      String recommended = interviewInfoForm.getRecommended();
      //List<Recommend> rec = gson.fromJson(recommended, new TypeToken<List<Recommend>>() {}.getType());
      request.setAttribute("rec", recommended);
      // 声明
      String illustrate = interviewInfoForm.getIllustrate();
      Illustrate ill = gson.fromJson(illustrate, Illustrate.class);
      request.setAttribute("ill", ill);
      return new ModelAndView("com/csot/interview/toReview");
    }
    
    @RequestMapping("addInfo")
    public ModelAndView addInfo(HttpServletRequest request) {
      ModelAndView vm = new ModelAndView("com/csot/interview/editInterviewInfo");
      String recruiterNumber  = request.getParameter("recruiterNumber");
      String studentId  = request.getParameter("studentId");
      String recruiterName = "";
      try {
        recruiterName = URLDecoder.decode(request.getParameter("recruiterName"), "UTF-8");
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
      if(StringUtil.isNotEmpty(recruiterNumber) && StringUtil.isNotEmpty(recruiterName)){
        InterviewInfo basicInfo=new InterviewInfo();
        basicInfo.setRecruiterNumber(recruiterNumber);
        basicInfo.setRecruiterName(recruiterName);
        basicInfo.setHighestEducation("3");
        initPage(vm);
        vm.addObject("basicInfo", basicInfo);
      }else{
        return null;
      }
      vm.addObject("studentId", studentId);
      return vm;
    }
    
    @RequestMapping("editInfo")
    public ModelAndView editInfo(HttpServletRequest request,String personCode) {
      ModelAndView vm = new ModelAndView("com/csot/interview/editInterviewInfo");
     
        
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        initPage(vm);
        //基本信息
        InterviewInfo basicInfo = interviewInfoService.getByPersonCode(personCode);
        
        //家庭成员
        List<FamilyMember> fs = familyMemberService.queryByPersonCode(personCode);
        
        //紧急联系人
        List<EmergentContacts> egms = emergentContactsService.queryByPersonCode(personCode);
        
        //教育经历
        List<EducationExperience> edus = educationExperienceService.queryByResumeId(personCode);
        
        //获得证书
        List<Certification> certifications = certificationService.queryByResumeId(personCode);
        
        //计算机与语言
        List<Language> lans = languageService.queryByPersonCode(personCode);
        
        //工作经历
        List<WorkExperience> works = workExperienceService.queryByResumeId(personCode);
        
        //奖励及特长
        List<Reward> rews = rewardService.queryByPersonCode(personCode);
        
        //推荐人
        List<Recommend> recs = recommendService.queryByPersonCode(personCode);
        
        //声明
        Illustrate ill = illustrateService.queryByPersonCode(personCode);
        vm.addObject("basicInfo", basicInfo);
        vm.addObject("fs", gson.toJson(fs));
        vm.addObject("egms", gson.toJson(egms));
        if(edus.size()>0){
          vm.addObject("edus", edus);
        }
        if(certifications.size()>0){
          vm.addObject("certifications", certifications);
        }
        if(lans.size()>0){
          vm.addObject("lans", lans.get(0));
        }
        if(works.size()>0){
          vm.addObject("works", works);
        }
        if(rews.size()>0){
          vm.addObject("rews", rews.get(0));
        }
        
        vm.addObject("recs", gson.toJson(recs));
        vm.addObject("ill", ill);
        vm.addObject("operatorType", "edit");
        return vm;
    }
    
    @RequestMapping("toInterviewManage")
    public ModelAndView toInterviewManage() {
      return new ModelAndView("com/csot/interview/interviewManage");
    }
    
    /***
     * 获取家庭成员
     * @param page 分页对象
     * @param positionMana 查询对象
     * @return
     */
    @ResponseBody
    @RequestMapping("queryFamilyContacts")
    public MiniRtn2Grid<PositionMana> queryPositionManaList(
            MiniGridPageSort page) {
        if(StringUtil.isEmpty(page.getSortField())) {
          page.setSortField("releaseDate");
          page.setSortOrder("desc");
        }
        MiniRtn2Grid<PositionMana> minirtn2Grid = new MiniRtn2Grid<PositionMana>();
        List<PositionMana> ls = new ArrayList<PositionMana>();
        PositionMana p = new PositionMana();
        p.setRecruitPositionId("1");
        ls.add(p);ls.add(p);ls.add(p);ls.add(p);
        minirtn2Grid.setData(ls);
        minirtn2Grid.setTotal(4);
        System.out.println(gson.toJson(minirtn2Grid));
        return minirtn2Grid;
    }
    
    @RequestMapping("getUserName")
    @ResponseBody
    public AjaxRtnJson getUserNameByAccount(HttpServletRequest request) {
      String account  = request.getParameter("account");
      if(StringUtil.isNotEmpty(account)){
        String res = interviewInfoService.getUserNameByAccount(account);
        if(StringUtil.isNotEmpty(res)){
          return new AjaxRtnJson(true, res);
        }else{
          return new AjaxRtnJson(false, "输入账号有误:查无此人!");
        }
      }else{
        return new AjaxRtnJson(false, "输入账号有误");
      }
    }
    
    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(HttpServletRequest request) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      String baseInfo = request.getParameter("baseInfo");
      InterviewInfo interviewInfo = gson.fromJson(baseInfo, InterviewInfo.class);
      
      // 家庭成员
      String family = request.getParameter("family");
      List<FamilyMember> fs = gson.fromJson(family, new TypeToken<List<FamilyMember>>() {}.getType());
  
      // 紧急联系人
      String emergent = request.getParameter("emergent");
      List<EmergentContacts> egms =
          gson.fromJson(emergent, new TypeToken<List<EmergentContacts>>() {}.getType());
  
      // 教育经历
      String education = request.getParameter("education");
      // EducationExperience edu = gson.fromJson(education, EducationExperience.class);
      List<EducationExperience> edus =
          gson.fromJson(education, new TypeToken<List<EducationExperience>>() {}.getType());
  
      // 获得证书
      String certification = request.getParameter("certification");
      List<Certification> certifications =
          gson.fromJson(certification, new TypeToken<List<Certification>>() {}.getType());
  
      // 计算机与语言
      String language = request.getParameter("language");
      Language lan = gson.fromJson(language, Language.class);
  
      // 工作经历
      String work = request.getParameter("work");
      List<WorkExperience> works =
          gson.fromJson(work, new TypeToken<List<WorkExperience>>() {}.getType());
  
      // 奖励及特长
      String reward = request.getParameter("reward");
      Reward rew = gson.fromJson(reward, Reward.class);
  
      // 推荐人
      String recommended = request.getParameter("recommended");
      List<Recommend> rec = gson.fromJson(recommended, new TypeToken<List<Recommend>>() {}.getType());
  
      // 声明
      String illustrate = request.getParameter("illustrate");
      Illustrate ill = gson.fromJson(illustrate, Illustrate.class);
  
      if (StringUtils.isEmpty(interviewInfo.getId())) {// 新增
        try {      
          String resumeId = UUID.randomUUID().toString().replace("-", "");
          String personCode = interviewInfoService.getPersonCode();
          interviewInfo.setId(resumeId);
          interviewInfo.setPersonCode(personCode);
          interviewInfo.setCreatetime(new Date());
          interviewInfoService.create(interviewInfo);
  
          // 家庭成员
          for (FamilyMember f : fs) {
            f.setId(UUID.randomUUID().toString().replace("-", ""));
            f.setPersonCode(personCode);
            familyMemberService.create(f);
          }
  
          // 紧急联系人
          for (EmergentContacts e : egms) {
            e.setId(UUID.randomUUID().toString().replace("-", ""));
            e.setPersonCode(personCode);
            emergentContactsService.create(e);
          }
  
          // 教育经历
          for (EducationExperience edu : edus) {
            edu.setId(UUID.randomUUID().toString().replace("-", ""));
            edu.setResumeId(personCode);
            educationExperienceService.create(edu);
          }
  
          // 获得证书
          for (Certification credential : certifications) {
            credential.setId(UUID.randomUUID().toString().replace("-", ""));
            credential.setResumeId(personCode);
            certificationService.create(credential);
          }
  
          // 计算机与语言
          lan.setId(UUID.randomUUID().toString().replace("-", ""));
          lan.setPersonCode(personCode);
          languageService.create(lan);
  
          // 工作履历
          for (WorkExperience w : works) {
            w.setId(UUID.randomUUID().toString().replace("-", ""));
            w.setResumeId(personCode);
            workExperienceService.create(w);
          }
  
          // 奖励及特长
          rew.setId(UUID.randomUUID().toString().replace("-", ""));
          rew.setPersonCode(personCode);
          rewardService.create(rew);
  
          // 推荐人
          for (Recommend r : rec) {
            r.setId(UUID.randomUUID().toString().replace("-", ""));
            r.setPersonCode(personCode);
            recommendService.create(r);
          }
  
          // 声明
          ill.setId(UUID.randomUUID().toString().replace("-", ""));
          ill.setPersonCode(personCode);
          illustrateService.create(ill);
          //如果是校招学生进行录入，变更标示状态
          String studentId = request.getParameter("studentId");
          if(StringUtil.isNotEmpty(studentId)){
            CampusStudent cs = new CampusStudent();
            cs.setId(studentId);
            cs.setJobClass("1");
            campusStudentService.updateSelective(cs);
          }
          return new AjaxRtnJson(true, "录入成功");
        } catch (DataAccessException e) {
          logger.error(e.getMessage(), e);
          return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
        }
      } else {// 更新
        try {
          interviewInfo.setUpdateTime(new Date());
          interviewInfoService.updateSelective(interviewInfo);
          String personCode = interviewInfo.getPersonCode();
          // 家庭成员
          for (FamilyMember f : fs) {
            if(StringUtils.isEmpty(f.getId())){
              f.setId(UUID.randomUUID().toString().replace("-", ""));
              f.setPersonCode(personCode);
              familyMemberService.create(f);
            }else{
              familyMemberService.updateSelective(f);
            }
          }
  
          // 紧急联系人
          emergentContactsService.deleteByPersonCode(personCode);
          for (EmergentContacts e : egms) {
            e.setId(UUID.randomUUID().toString().replace("-", ""));
            e.setPersonCode(personCode);
            emergentContactsService.create(e);
          }
  
          // 教育经历
          // 清空历史教育经历
          educationExperienceService.deleteByResumeId(personCode);
          for (EducationExperience edu : edus) {
            if(StringUtils.isEmpty(edu.getId())){
              edu.setId(UUID.randomUUID().toString().replace("-", ""));
              edu.setResumeId(personCode);
              educationExperienceService.create(edu);
            }else{
              educationExperienceService.updateSelective(edu);
            }
            
          }
  
          // 获得证书
          // 清空证书
          certificationService.deleteByResumeId(personCode);
          for (Certification credential : certifications) {
            if(StringUtils.isEmpty(credential.getId())){
              credential.setId(UUID.randomUUID().toString().replace("-", ""));
              credential.setResumeId(personCode);
              certificationService.create(credential);
            }else{
              certificationService.updateSelective(credential);
            }
          }
  
          // 计算机与语言
          languageService.updateSelective(lan);
  
          // 工作履历
          // 清空历史工作
          workExperienceService.deleteByResumeId(personCode);
          for (WorkExperience w : works) {
            if(StringUtils.isEmpty(w.getId())){
              w.setId(UUID.randomUUID().toString().replace("-", ""));
              w.setResumeId(personCode);
              workExperienceService.create(w);
            }else{
              workExperienceService.updateSelective(w);
            }
            
          }
  
          // 奖励及特长
          rewardService.updateSelective(rew);
  
          // 推荐人
          for (Recommend r : rec) {
            if(StringUtils.isEmpty(r.getId())){
              r.setId(UUID.randomUUID().toString().replace("-", ""));
              r.setPersonCode(personCode);
              recommendService.create(r);
            }else{
              recommendService.updateSelective(r);
            }
            
          }
  
          // 声明
          illustrateService.updateSelective(ill);
          
          return new AjaxRtnJson(true, "编辑成功");
        } catch (DataAccessException e) {
          logger.error(e.getMessage(), e);
          return new AjaxRtnJson(false, "编辑失败: " + e.getMessage());
        }
      }
    }
    
    /**
     * 导出excel
     * 
     * @param model
     * @param request
     */
    @RequestMapping("exportResumeExcel")
    public void exportResumeExcel(HttpServletRequest request,HttpServletResponse response,String resumeId,String name) {
          
      try {
        
        Workbook work = getResumeWorkbook(request,resumeId);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 将工作簿内容写入响应输出流
        work.write(os);
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String((name + ".xlsx").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
            if (os != null)
                // 将输出流对象关闭
                os.close();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    /**
     * 批量导出打印excel文件，zip包
     * 
     * */
    @RequestMapping("exportResumePrint")
    @ResponseBody
    public AjaxRtnJson exportResumePrint(HttpServletRequest request) {
      String templatePath = request.getSession().getServletContext().getRealPath("/resources/excelTemplate/");
      String resumeIds = request.getParameter("resumeIds");
      if(StringUtil.isEmpty(resumeIds)){
        return new AjaxRtnJson(false, "");
      }
      return new AjaxRtnJson(true, interviewPrintService.dualZipPrint(templatePath, resumeIds));
    }
    
    /**
     * 简历批量导出excel
     * 
     * @param model
     * @param request
     */
    @RequestMapping("exportBatchResumeExcel")
    public void exportBatchResumeExcel(HttpServletRequest request,HttpServletResponse response,String resumeIds) {
          
      try {
        
        Workbook work = getBatchResumeWorkbook(request,resumeIds);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 将工作簿内容写入响应输出流
        work.write(os);
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String(("入职批导" + ".xlsx").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
            if (os != null)
                // 将输出流对象关闭
                os.close();
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    /**
     * 打印excel
     * 
     * @param model
     * @param request
     */
    @RequestMapping("printResume")
    @ResponseBody
    public AjaxRtnJson printResume(HttpServletRequest request,HttpServletResponse response,String personCodes) {      
      try {
        String[] personCodeArray=personCodes.split(",");
        String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
        for(String personCode:personCodeArray){
          Workbook work = getResumeWorkbook(request, personCode);
          String file = rootPath + File.separator + CommonConstant.TEMP_DIR + File.separator
                  + System.currentTimeMillis()+".xlsx";
          FileOutputStream os;
          os = new FileOutputStream(file);
          work.write(os);
          os.close();
          WriteExcel.print(file);
        }
        
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        return new AjaxRtnJson(false, "打印失败");
      } catch (IOException e) {
        e.printStackTrace();
        return new AjaxRtnJson(false, "打印失败");
      }     
      return new AjaxRtnJson(true, "打印成功"); 
      
    }

    private Workbook getResumeWorkbook(HttpServletRequest request, String personCode) {
      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
      //基本信息
      InterviewInfo basicInfo = interviewInfoService.getByPersonCode(personCode);
      
      //家庭成员
      List<FamilyMember> fs = familyMemberService.queryByPersonCode(personCode);
      
      //紧急联系人
      List<EmergentContacts> egms = emergentContactsService.queryByPersonCode(personCode);
      
      //教育经历
      List<EducationExperience> edus = educationExperienceService.queryByResumeId(personCode);
      
      //获得证书
      List<Certification> certifications = certificationService.queryByResumeId(personCode);
      
      //计算机与语言
      List<Language> lans = languageService.queryByPersonCode(personCode);
      
      //工作经历
      List<WorkExperience> works = workExperienceService.queryByResumeId(personCode);
      
      //奖励及特长
      List<Reward> rews = rewardService.queryByPersonCode(personCode);
      
      //推荐人
      List<Recommend> recs = recommendService.queryByPersonCode(personCode);
      
      //声明
      Illustrate ill = illustrateService.queryByPersonCode(personCode);
      Workbook work =null;
      try {
        // 取得根目录路径    
        String templatePath =
            request.getSession().getServletContext().getRealPath("/resources/excelTemplate/");//
        InputStream in = new FileInputStream(templatePath + "/interviewPrintTemple.xlsx");
        work = new XSSFWorkbook(in);
        // 得到excel的第0张表
        Sheet sheet = work.getSheetAt(0);
        //基本信息
        Row row = sheet.getRow(6);//
        Cell cell = row.getCell(2);
        cell.setCellValue(basicInfo.getCnname());
        cell = row.getCell(11);
        cell.setCellValue(basicInfo.getNationalityName());//国籍
        cell = row.getCell(17);
        cell.setCellValue(basicInfo.getNamepy());
        cell = row.getCell(33);
        cell.setCellValue(basicInfo.getEnname());
        cell = row.getCell(40);
        cell.setCellValue(basicInfo.getSexName()); // 性别

        // 得到行，并填充数据和表格样式
        row = sheet.getRow(8);//
        cell = row.getCell(2);
        cell.setCellValue(basicInfo.getNativePlace());
        
        XSSFFont font1 = (XSSFFont)work.createFont();  
        font1.setFontName("宋体");  
        font1.setFontHeightInPoints((short) 12);//设置字体大小 
        XSSFFont font2 = (XSSFFont) work.createFont();
        font2.setFontName("宋体");  
        font2.setFontHeightInPoints((short) 8);//设置字体大小 
        XSSFFont font3 = (XSSFFont) work.createFont();
        font3.setFontName("Arial");  
        font3.setFontHeightInPoints((short) 8);//设置字体大小 
        if("1".equals(basicInfo.getMaritalStatus())){
          cell = row.getCell(12);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 单身" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,4,font2);
          cell.setCellValue(richString); // 婚姻状况
        }else if("2".equals(basicInfo.getMaritalStatus())){
          cell = row.getCell(16);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 已婚" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,4,font2);
          cell.setCellValue(richString); // 婚姻状况
        }else if("3".equals(basicInfo.getMaritalStatus())){
          cell = row.getCell(20);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 再婚" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,4,font2);
          cell.setCellValue(richString); // 婚姻状况
        }
        
        cell = row.getCell(25);
        cell.setCellValue(basicInfo.getResidence());
        cell = row.getCell(33);
        cell.setCellValue(basicInfo.getResidencePropertyName());//户口性质
        cell = row.getCell(40);
        cell.setCellValue(basicInfo.getNationName());//民族
     // 得到行，并填充数据和表格样式
        row = sheet.getRow(10);//
        cell = row.getCell(2);
        cell.setCellValue(basicInfo.getPoliticalName());//政治面貌
        cell = row.getCell(11);
        cell.setCellValue(basicInfo.getCertificateTypeName());//证件类型
        cell = row.getCell(17);
        cell.setCellValue(basicInfo.getCertificateNum());
        String birthday=basicInfo.getBirthdate();
        if(birthday!=null&&!"".equals(birthday)){
          cell = row.getCell(34);
          cell.setCellValue(birthday.substring(0, 4));
          cell = row.getCell(38);
          cell.setCellValue(birthday.substring(5, 7));
          cell = row.getCell(41);
          cell.setCellValue(birthday.substring(8, 9));
        }
        
     // 得到行，并填充数据和表格样式
        row = sheet.getRow(12);//
        cell = row.getCell(2);
        cell.setCellValue(basicInfo.getHighestEducationName());//最高学历
        cell = row.getCell(11);
        cell.setCellValue(basicInfo.getPhonenumber());
        cell = row.getCell(25);
        cell.setCellValue(basicInfo.getEmail());
     // 得到行，并填充数据和表格样式
        row = sheet.getRow(14);//
        cell = row.getCell(2);
        cell.setCellValue(basicInfo.getAddress());
        cell = row.getCell(33);
        cell.setCellValue(basicInfo.getPostcodes());
        String startWorkDate=basicInfo.getStartworkingdate();
        if(startWorkDate!=null&&!"".equals(startWorkDate)){
          cell = row.getCell(41);
          cell.setCellValue(startWorkDate.substring(0, 4));
          cell = row.getCell(45);
          cell.setCellValue(startWorkDate.substring(5, 7));
          cell = row.getCell(48);
          cell.setCellValue(startWorkDate.substring(8, 9));
        }
      
     // 得到行，并填充数据和表格样式
        row = sheet.getRow(16);//
        cell = row.getCell(2);
        cell.setCellValue(basicInfo.getPositionName());
        cell = row.getCell(15);
        cell.setCellValue(basicInfo.getArriveDate());
        cell = row.getCell(27);
        cell.setCellValue(basicInfo.getExpectedSalaryMonth());  
        cell = row.getCell(36);
        cell.setCellValue(basicInfo.getExpectedSalaryYear());
        cell = row.getCell(44);
        cell.setCellValue(basicInfo.getExpectedSalaryOther());
     // 得到行，并填充数据和表格样式
        row = sheet.getRow(19);//
        cell = row.getCell(2);
        if("1".equals(basicInfo.getRecruitmentApproach())){//网络
          cell = row.getCell(3);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 网络" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,4,font2);
          cell.setCellValue(richString); // 招聘渠道
        }else if("2".equals(basicInfo.getRecruitmentApproach())){//内部推荐
          cell = row.getCell(7);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 内部推荐（推荐人姓名:"+basicInfo.getRefereeName()+")" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道
        }else if("3".equals(basicInfo.getRecruitmentApproach())){//中介机构
          cell = row.getCell(25);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 中介机构" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,6,font2);
          cell.setCellValue(richString); // 招聘渠道
        }else if("4".equals(basicInfo.getRecruitmentApproach())){//其他
          cell = row.getCell(31);
          XSSFRichTextString richString = new XSSFRichTextString( "□ 其他（"+basicInfo.getOtherWay()+"）" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,4,font2);
          cell.setCellValue(richString); // 招聘渠道
        }

        if("1".equals(basicInfo.getRelativesFlag())){//有亲属
          cell = row.getCell(41);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 有" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,3,font2);
          cell.setCellValue(richString); 
          XSSFCellStyle cellStyle = (XSSFCellStyle)work.createCellStyle();
          cellStyle.setFont(font2);
          cell = row.getCell(48);//亲属姓名
          cell.setCellValue(basicInfo.getRelativesName());
          cell.setCellStyle(cellStyle);
          cell = row.getCell(54);//亲属关系
          cell.setCellValue(basicInfo.getRelativesShip());
          cell.setCellStyle(cellStyle);
        }else if("2".equals(basicInfo.getRelativesFlag())){//无亲属
          row = sheet.getRow(18);//
          cell = row.getCell(41);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 没有" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,4,font2);
          cell.setCellValue(richString);  
        }
         
     // 得到行，家庭成员
        for(int i=0;i<fs.size()&&i<=5;i++){
          FamilyMember member=fs.get(i);
          row = sheet.getRow(24+2*i);//
          cell = row.getCell(2);
          cell.setCellValue(member.getMenberName());
          cell = row.getCell(11);
          cell.setCellValue(member.getRelationName());
          cell = row.getCell(16);
          cell.setCellValue(member.getGenderName()); 
          if(member.getMenberBirthday()!=null&&"".equals(member.getMenberBirthday())){
            cell = row.getCell(20);
            cell.setCellValue(member.getMenberBirthday().substring(0, 4));
          }
          
          cell = row.getCell(26);
          cell.setCellValue(member.getMenberAddress());
          if("1".equals(member.getEmergentFlag())){//是否紧急联系人
            cell = row.getCell(52);
            XSSFRichTextString richString = new XSSFRichTextString( "☑ 是" );
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,3,font2);
            cell.setCellValue(richString); // 招聘渠道
          }
        }
     // 得到行，紧急联系人
        for(int i=0;i<egms.size()&&i<=1;i++){
          EmergentContacts ec=egms.get(i);
          row = sheet.getRow(37+2*i);//
          cell = row.getCell(2);
          cell.setCellValue(ec.getEmergentName());
          cell = row.getCell(11);
          cell.setCellValue(ec.getRelationName());
          cell = row.getCell(16);
          cell.setCellValue(ec.getEmergentPhone());  
          cell = row.getCell(33);
          cell.setCellValue(ec.getEmergentAddress());
        }
     // 得到行，教育及培训
        for(int i=0;i<edus.size();i++){
          EducationExperience edu=edus.get(i);
          row = sheet.getRow(45+2*i);//          
          if(edu.getEduStartDate()!=null&&!"".equals(edu.getEduStartDate())){
            String startDate=format.format(edu.getEduStartDate());
            String endDate=format.format(edu.getEduEndDate());
            cell = row.getCell(2);
            String start=startDate.substring(0, 4)+"年"+startDate.substring(5, 7)+"月"+startDate.substring(8, 10)+"日";
            String end=endDate.substring(0, 4)+"年"+endDate.substring(5, 7)+"月"+endDate.substring(8, 10)+"日";
            cell.setCellValue(start+"~ "+end);
          }

          cell = row.getCell(17);
          cell.setCellValue(edu.getSchoolName()); 
          cell = row.getCell(28);
          cell.setCellValue(edu.getMajor());  
          cell = row.getCell(38);
          cell.setCellValue(edu.getEducationName());
          cell = row.getCell(43);
          if("1".equals(edu.getEduType())){//全日制
            cell.setCellValue("☑全日制；                                   □其它(自考/函授/成教等)");
          }else{//其他
            cell.setCellValue("□全日制；                                   ☑其它(自考/函授/成教等)");
          }
          
          cell = row.getCell(51);
          if("1".equals(edu.getCertificate())){//毕业证
            cell.setCellValue("☑毕业证；                                    □学位证");
          }else if("2".equals(edu.getCertificate())){//学位证
            cell.setCellValue("□毕业证；                                    ☑学位证");
          }else if("1,2".equals(edu.getCertificate())){//毕业证、学位证
            cell.setCellValue("☑毕业证；                                    ☑学位证");
          }
        } 
        //资格证书
        for(int i=0;i<certifications.size();i++){
          Certification cer=certifications.get(i);
          row = sheet.getRow(53+2*i);//
          cell = row.getCell(2);
          cell.setCellValue(cer.getTypeName()); 
          cell = row.getCell(10);
          cell.setCellValue(cer.getName());  
          String receivingdate=format.format(cer.getReceivingdate());
          cell = row.getCell(22);
          cell.setCellValue(receivingdate.substring(0, 4));
          cell = row.getCell(26);
          cell.setCellValue(receivingdate.substring(5, 7));
          cell = row.getCell(29);
          cell.setCellValue(receivingdate.substring(8, 10));
          cell = row.getCell(33);
          cell.setCellValue(cer.getNum());
          cell = row.getCell(43);
          cell.setCellValue(cer.getAuthorityOrg());
        }
        // 语言与计算机
        if(lans.size()>0){
          Language lan=lans.get(0);
          row = sheet.getRow(61);//
          if(lan.getOfficeFlag()!=null&&"1".equals(lan.getOfficeFlag())){
            cell = row.getCell(3);
            XSSFRichTextString richString = new XSSFRichTextString("☑ Office");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getOfficeSkilledLevel())){//精通
              cell = row.getCell(10);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getOfficeSkilledLevel())){//了解
              cell = row.getCell(14);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getOfficeSkilledLevel())){//一般
              cell = row.getCell(18);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(22);
            cell.setCellValue(lan.getOfficeDiploma());
          }                
          if(lan.getEnglishFlag()!=null&&"1".equals(lan.getEnglishFlag())){
            cell = row.getCell(34);
            XSSFRichTextString richString = new XSSFRichTextString("☑ 英语");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getEnglishSkilledLevel())){//精通
              cell = row.getCell(39);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getEnglishSkilledLevel())){//了解
              cell = row.getCell(43);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getEnglishSkilledLevel())){//一般
              cell = row.getCell(47);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(51);
            cell.setCellValue(lan.getEnglishDiploma());
          }        
          
          row = sheet.getRow(62);//
          if(lan.getSapFlag()!=null&&"1".equals(lan.getSapFlag())){
            cell = row.getCell(3);
            XSSFRichTextString richString = new XSSFRichTextString("☑ SAP/ERP");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getSapSkilledLevel())){//精通
              cell = row.getCell(10);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getSapSkilledLevel())){//了解
              cell = row.getCell(14);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getSapSkilledLevel())){//一般
              cell = row.getCell(18);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(22);
            cell.setCellValue(lan.getSapDiploma());
          }                
          if(lan.getKoreanFlag()!=null&&"1".equals(lan.getKoreanFlag())){
            cell = row.getCell(34);
            XSSFRichTextString richString = new XSSFRichTextString("☑ 韩语");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getKoreanSkilledLevel())){//精通
              cell = row.getCell(39);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getKoreanSkilledLevel())){//了解
              cell = row.getCell(43);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getKoreanSkilledLevel())){//一般
              cell = row.getCell(47);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(51);
            cell.setCellValue(lan.getKoreanDiploma());
          }        
          
          row = sheet.getRow(63);//
          if(lan.getVbaFlag()!=null&&"1".equals(lan.getVbaFlag())){
            cell = row.getCell(3);
            XSSFRichTextString richString = new XSSFRichTextString("☑ VBA/SQL");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getVbaSkilledLevel())){//精通
              cell = row.getCell(10);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getVbaSkilledLevel())){//了解
              cell = row.getCell(14);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getVbaSkilledLevel())){//一般
              cell = row.getCell(18);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(22);
            cell.setCellValue(lan.getVbaDiploma());
          }                
          if(lan.getJapaneseFlag()!=null&&"1".equals(lan.getJapaneseFlag())){
            cell = row.getCell(34);
            XSSFRichTextString richString = new XSSFRichTextString("☑ 日语");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getJapaneseSkilledLevel())){//精通
              cell = row.getCell(39);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getJapaneseSkilledLevel())){//了解
              cell = row.getCell(43);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getJapaneseSkilledLevel())){//一般
              cell = row.getCell(47);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(51);
            cell.setCellValue(lan.getJapaneseDiploma());
          }        
          
          row = sheet.getRow(64);//
          if(lan.getOtheritFlag()!=null&&"1".equals(lan.getOtheritFlag())){
            cell = row.getCell(3);
            XSSFRichTextString richString = new XSSFRichTextString("☑ 3D Max/ Pro/E");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getOtheritSkilledLevel())){//精通
              cell = row.getCell(10);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getOtheritSkilledLevel())){//了解
              cell = row.getCell(14);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getOtheritSkilledLevel())){//一般
              cell = row.getCell(18);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(22);
            cell.setCellValue(lan.getOtheritDiploma());
          }                
          if(lan.getOtherFlag()!=null&&"1".equals(lan.getOtherFlag())){
            cell = row.getCell(34);
            XSSFRichTextString richString = new XSSFRichTextString("☑ 普通话");
            richString.applyFont(0,1,font1);
            richString.applyFont(1,2,font3);
            richString.applyFont(2,richString.length(),font2);
            cell.setCellValue(richString); // 招聘渠道       
            if("1".equals(lan.getOtherSkilledLevel())){//精通
              cell = row.getCell(39);
              cell.setCellValue("☑ 精通");
            }else if("2".equals(lan.getOtherSkilledLevel())){//了解
              cell = row.getCell(43);
              cell.setCellValue("☑ 了解");
            }else if("3".equals(lan.getOtherSkilledLevel())){//一般
              cell = row.getCell(47);
              cell.setCellValue("☑ 一般");
            }          
            cell = row.getCell(51);
            cell.setCellValue(lan.getOtherDiploma());
          }        
          
          row = sheet.getRow(65);//暂时注释，表缺字段
//          if(lan.getOtheritFlag()!=null&&"1".equals(lan.getOtheritFlag())){
//            cell = row.getCell(3);
//            XSSFRichTextString richString = new XSSFRichTextString("☑ 3D Max/ Pro/E");
//            richString.applyFont(0,1,font1);
//            richString.applyFont(1,2,font3);
//            richString.applyFont(2,richString.length(),font2);
//            cell.setCellValue(richString); // 招聘渠道       
//            if("1".equals(lan.getOtheritSkilledLevel())){//精通
//              cell = row.getCell(10);
//              cell.setCellValue("☑ 精通");
//            }else if("2".equals(lan.getOtheritSkilledLevel())){//了解
//              cell = row.getCell(14);
//              cell.setCellValue("☑ 了解");
//            }else if("3".equals(lan.getOtheritSkilledLevel())){//一般
//              cell = row.getCell(18);
//              cell.setCellValue("☑ 一般");
//            }          
//            cell = row.getCell(22);
//            cell.setCellValue(lan.getOtheritDiploma());
//          }                
//          if(lan.getOtherFlag()!=null&&"1".equals(lan.getOtherFlag())){
//            cell = row.getCell(34);
//            XSSFRichTextString richString = new XSSFRichTextString("☑ 普通话");
//            richString.applyFont(0,1,font1);
//            richString.applyFont(1,2,font3);
//            richString.applyFont(2,richString.length(),font2);
//            cell.setCellValue(richString); // 招聘渠道       
//            if("1".equals(lan.getOtherSkilledLevel())){//精通
//              cell = row.getCell(39);
//              cell.setCellValue("☑ 精通");
//            }else if("2".equals(lan.getOtherSkilledLevel())){//了解
//              cell = row.getCell(43);
//              cell.setCellValue("☑ 了解");
//            }else if("3".equals(lan.getOtherSkilledLevel())){//一般
//              cell = row.getCell(47);
//              cell.setCellValue("☑ 一般");
//            }          
//            cell = row.getCell(51);
//            cell.setCellValue(lan.getOtherDiploma());
//          }        
        }
      
        // 得到行，工作经历
        for(int i=0;i<works.size()&&i<=2;i++){
          WorkExperience workExperience=works.get(i);
          int x=70;//起止时间行
          int y=74;//工作职责行
          if(i==1){
            x=81;
            y=87;
          }else if(i==2){
            x=96;
            y=100;
          }
          row = sheet.getRow(x);//
          if(workExperience.getJobStartDate()!=null&&!"".equals(workExperience.getJobStartDate())){
            String startDate=format.format(workExperience.getJobStartDate());
            String endDate=format.format(workExperience.getJobEndDate());
            cell = row.getCell(2);
            String start=startDate.substring(0, 4)+"年"+startDate.substring(5, 7)+"月"+startDate.substring(8, 10)+"日";
            String end=endDate.substring(0, 4)+"年"+endDate.substring(5, 7)+"月"+endDate.substring(8, 10)+"日";
            cell.setCellValue(start+"~ "+end);
          }
               
          cell = row.getCell(18);
          cell.setCellValue(workExperience.getCompanyName());
          cell = row.getCell(41);
          cell.setCellValue(workExperience.getSalary());  
          row = sheet.getRow(x+2);//
          cell = row.getCell(2);
          cell.setCellValue(workExperience.getDepartment());
          cell = row.getCell(18);
          cell.setCellValue(workExperience.getPositionName());
          cell = row.getCell(30);
          cell.setCellValue(workExperience.getDebriefer()); 
          cell = row.getCell(41);
          cell.setCellValue(workExperience.getSubordinate()==null?"":workExperience.getSubordinate().toString()); 
          cell = row.getCell(49);
          cell.setCellValue(workExperience.getSeniority());
          
          row = sheet.getRow(y);//
          cell = row.getCell(2);
          cell.setCellValue(workExperience.getJobDuty());
          row = sheet.getRow(y+5);//
          cell = row.getCell(2);
          cell.setCellValue(workExperience.getLeaveReason());
          cell = row.getCell(30);
          cell.setCellValue(workExperience.getReterence());
          cell = row.getCell(41);
          cell.setCellValue(workExperience.getRelationship()); 
          cell = row.getCell(49);
          cell.setCellValue(workExperience.getReterencePhone()); 
        }
        
     // 奖励及特长
        if(rews.size()>0){
          Reward rew=rews.get(0);
          row = sheet.getRow(121);//
          cell = row.getCell(2);
          cell.setCellValue(rew.getRewardName1());
          if(rew.getRewardDate1()!=null){
            cell = row.getCell(30);      
            cell.setCellValue(rew.getRewardDate1().substring(0, 4));
            cell = row.getCell(34);      
            cell.setCellValue(rew.getRewardDate1().substring(5, 7));
            cell = row.getCell(37);      
            cell.setCellValue(rew.getRewardDate1().substring(8, 10));
          }
          
          cell = row.getCell(41);
          cell.setCellValue(rew.getAuthorities1());  
          row = sheet.getRow(123);//
          cell = row.getCell(2);
          cell.setCellValue(rew.getRewardName2());
          if(rew.getRewardDate2()!=null){
            cell = row.getCell(30);      
            cell.setCellValue(rew.getRewardDate2().substring(0, 4));
            cell = row.getCell(34);      
            cell.setCellValue(rew.getRewardDate2().substring(5, 7));
            cell = row.getCell(37);      
            cell.setCellValue(rew.getRewardDate2().substring(8, 10));
          }
          cell = row.getCell(41);
          cell.setCellValue(rew.getAuthorities2());
          row = sheet.getRow(125);//
          cell = row.getCell(2);
          cell.setCellValue(rew.getRewardName3());
          if(rew.getRewardDate3()!=null){
            cell = row.getCell(30);      
            cell.setCellValue(rew.getRewardDate3().substring(0, 4));
            cell = row.getCell(34);      
            cell.setCellValue(rew.getRewardDate3().substring(5, 7));
            cell = row.getCell(37);      
            cell.setCellValue(rew.getRewardDate3().substring(8, 10));
          }
          cell = row.getCell(41);
          cell.setCellValue(rew.getAuthorities3()); 
          row = sheet.getRow(127);//
          cell = row.getCell(2);
          cell.setCellValue(rew.getHobby());
          cell = row.getCell(30);
          cell.setCellValue(rew.getSpeciality());
        }  
        
     // 得到行，推荐人员
        for(int i=0;i<recs.size();i++){
          Recommend rec=recs.get(i);
          row = sheet.getRow(133+2*i);//
          cell = row.getCell(2);
          cell.setCellValue(rec.getRecommended());
          cell = row.getCell(11);
          cell.setCellValue(rec.getRecommendRelation());
          cell = row.getCell(19);
          cell.setCellValue(rec.getRecommendPosition());  
          cell = row.getCell(29);
          cell.setCellValue(rec.getRecommendPhone());
          cell = row.getCell(40);
          cell.setCellValue(rec.getRecommendAddress());
        }
        
        //声明
        row = sheet.getRow(142);//
        if("1".equals(ill.getInfectionFlag())){
          cell = row.getCell(45);
          cell.setCellValue("☑ 没有；  □ 有；");
        }else if("2".equals(ill.getInfectionFlag())){
          cell = row.getCell(45);
          cell.setCellValue("□ 没有；  ☑ 有；");
          row = sheet.getRow(143);//
          cell = row.getCell(2);
          cell.setCellValue(ill.getInfectionText()==null?"":ill.getInfectionText());
        }
        
        row = sheet.getRow(144);//
        if("1".equals(ill.getCriminalFlag())){
          cell = row.getCell(45);
          cell.setCellValue("☑ 没有；  □ 有；");
        }else if("2".equals(ill.getCriminalFlag())){
          cell = row.getCell(45);
          cell.setCellValue("□ 没有；  ☑ 有；");
          row = sheet.getRow(145);//
          cell = row.getCell(2);
          cell.setCellValue(ill.getCriminalText()==null?"":ill.getCriminalText());
        }
        row = sheet.getRow(146);//
        if("1".equals(ill.getEmployFlag())){
          cell = row.getCell(45);
          cell.setCellValue("☑ 没有；  □ 有；");
        }else if("2".equals(ill.getEmployFlag())){
          cell = row.getCell(45);
          cell.setCellValue("□ 没有；  ☑ 有；");
          row = sheet.getRow(147);//
          cell = row.getCell(2);
          cell.setCellValue(ill.getEmployText()==null?"":ill.getEmployText());
        }
        row = sheet.getRow(148);//
        if("1".equals(ill.getInvestigateFlag())){
          cell = row.getCell(45);
          cell.setCellValue("☑ 愿意；  □ 不愿意；");
        }else if("2".equals(ill.getInvestigateFlag())){
          cell = row.getCell(45);
          cell.setCellValue("□ 没有；  ☑ 有；");
          row = sheet.getRow(149);//
          cell = row.getCell(2);
          cell.setCellValue(ill.getInvestigateText()==null?"":ill.getInvestigateText());
        }
        row = sheet.getRow(150);//
        if("1".equals(ill.getBanFlag())){
          cell = row.getCell(45);
          cell.setCellValue("☑ 没有；  □ 有；");
        }else if("2".equals(ill.getInvestigateFlag())){
          cell = row.getCell(45);
          cell.setCellValue("□ 没有；  ☑ 有；");
          row = sheet.getRow(152);//
          String startDate=ill.getBanStartdate();
          String endDate=ill.getBanEnddate();
          if(startDate!=null&&endDate!=null){
            cell=row.getCell(5);
            cell.setCellValue("签订期限："+startDate.substring(0, 4)+"年"+startDate.substring(5, 7)+"月 至"+endDate.substring(0, 4)+"年"+endDate.substring(5, 7)+"月；  且补偿金金额："+ill.getPayment()+"万元。");
          }
        }
        // sheet.addMergedRegion(new CellRangeAddress(41, 41, 0, 9));//合并备注栏
    } catch (FileNotFoundException e) {
        logger.error("excel导出失败：文件路径错误"+e.getCause());
    } catch (IOException e) {
        System.out.println("文件输入流错误");
        logger.error("excel导出失败：文件路径错误"+e.getMessage());

        e.printStackTrace();
    }
      return work;
    }
    
    private Workbook getBatchResumeWorkbook(HttpServletRequest request, String personCodes) {
      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
      String[] personCodeArray=personCodes.split(",");
      
      Workbook work =null;
      try {
        // 取得根目录路径    
        String templatePath =
            request.getSession().getServletContext().getRealPath("/resources/excelTemplate/");//
        InputStream in = new FileInputStream(templatePath + "\\入职批导模板.xlsx");
        work = new XSSFWorkbook(in);
        // 得到excel的第0张表
        Sheet sheet0 = work.getSheetAt(0);
        Sheet sheet1 = work.getSheetAt(1);
        Sheet sheet2 = work.getSheetAt(2);
        Sheet sheet3 = work.getSheetAt(3);
        
        int m=3,n=3,o=3;//家庭成员页初始行
        for( int i=0;i<personCodeArray.length;i++){
          String personCode=personCodeArray[i];
          //基本信息
          InterviewInfo basicInfo = interviewInfoService.getByPersonCode(personCode);
          Row row = sheet0.createRow(i+3);//
          Cell cell = row.createCell(3);
          cell.setCellValue(basicInfo.getCnname());
          cell = row.createCell(4);
          cell.setCellValue(basicInfo.getEnname());
          cell = row.createCell(5);
          cell.setCellValue(basicInfo.getPositionName());
          cell = row.createCell(14);
          if("1".equals(basicInfo.getRecruitmentApproach())){//网络  
            cell.setCellValue("网络"); // 招聘渠道
          }else if("2".equals(basicInfo.getRecruitmentApproach())){//内部推荐
            cell.setCellValue("内部推荐"); // 招聘渠道
          }else if("3".equals(basicInfo.getRecruitmentApproach())){//中介机构
            cell.setCellValue("中介机构"); // 招聘渠道
          }else if("4".equals(basicInfo.getRecruitmentApproach())){//其他
            cell.setCellValue("其他"); // 招聘渠道
          }
          cell = row.createCell(17);
          cell.setCellValue(basicInfo.getRefereeName());
          //cell = row.createCell(20);
          //cell.setCellValue(basicInfo.getResidenceProperty());
          cell = row.createCell(21);
          cell.setCellValue(basicInfo.getSexName());//
          cell = row.createCell(22);
          cell.setCellValue(basicInfo.getBirthdate());
          cell = row.createCell(23);
          cell.setCellValue(basicInfo.getNationalityName());//
          cell = row.createCell(24);
          cell.setCellValue(basicInfo.getNationName());//
          cell = row.createCell(25);
          cell.setCellValue(basicInfo.getMaritalName());//
          cell = row.createCell(27);
          cell.setCellValue(basicInfo.getNativePlace());
          cell = row.createCell(28);
          cell.setCellValue(basicInfo.getResidencePropertyName());
          cell = row.createCell(37);
          cell.setCellValue(basicInfo.getCertificateTypeName());//
          cell = row.createCell(38);
          cell.setCellValue(basicInfo.getCertificateNum());
          cell = row.createCell(49);
          cell.setCellValue(basicInfo.getPhonenumber());
        //紧急联系人
          List<EmergentContacts> egms = emergentContactsService.queryByPersonCode(personCode);
          if(egms.size()>0){
            EmergentContacts egm=egms.get(0);
            cell = row.createCell(50);
            cell.setCellValue(egm.getEmergentName());
            cell = row.createCell(51);
            cell.setCellValue(egm.getEmergentPhone());
            cell = row.createCell(52);
            cell.setCellValue(egm.getRelationName());
          }
          cell = row.createCell(53);
          cell.setCellValue(basicInfo.getPoliticalName());//
                    
          //家庭成员
          List<FamilyMember> fs = familyMemberService.queryByPersonCode(personCode);
          // 得到行，家庭成员
          for(int j=0;j<fs.size();j++){
            FamilyMember member=fs.get(j);
            row = sheet1.createRow(j+m);//
            cell = row.createCell(0);
            cell.setCellValue(member.getPersonCode());
            cell = row.createCell(2);
            cell.setCellValue(member.getRelationName());
            cell = row.createCell(3);
            cell.setCellValue(member.getMenberName());
            cell = row.createCell(4);
            cell.setCellValue(member.getGenderName());  
            cell = row.createCell(5);
            if(member.getMenberBirthday()!=null){
              SimpleDateFormat  format2=new SimpleDateFormat ("yyyy");
              int year=Integer.parseInt(format2.format(new Date()));
              int age=year-Integer.parseInt(member.getMenberBirthday().substring(0, 4));
              cell.setCellValue(age);
            }         
            cell = row.createCell(6);
            cell.setCellValue(member.getMenberAddress());
          }
          m+=fs.size();
          
          //教育经历
          List<EducationExperience> edus = educationExperienceService.queryByResumeId(personCode);
          //得到行，教育及培训
          for(int k=0;k<edus.size();k++){
            EducationExperience edu=edus.get(k);
            row = sheet2.createRow(k+n);//
            cell = row.createCell(1);
            cell.setCellValue(basicInfo.getCnname());
            if(edu.getEduStartDate()!=null&&edu.getEduEndDate()!=null){
              cell = row.createCell(2);
              cell.setCellValue(format.format(edu.getEduStartDate()));
              cell = row.createCell(3);
              cell.setCellValue(format.format(edu.getEduEndDate()));
            }
            
            cell = row.createCell(4);
            cell.setCellValue(edu.getEduTypeName());
            cell = row.createCell(5);
            cell.setCellValue(edu.getSchoolName());
            cell = row.createCell(6);
            cell.setCellValue(edu.getMajor());  
            cell = row.createCell(7);
            cell.setCellValue(edu.getEducationName());
            cell = row.createCell(11);
            if("1".equals(edu.getCertificate())){//毕业证
              cell.setCellValue("毕业证");
            }else if("2".equals(edu.getCertificate())){//学位证
              cell.setCellValue("学位证");
            }else if("1,2".equals(edu.getCertificate())){//毕业证、学位证
              cell.setCellValue("毕业证，学位证");
            }
          }  
          n+=edus.size();
          
          //工作经历
          List<WorkExperience> works = workExperienceService.queryByResumeId(personCode);
       // 得到行，工作经历
          for(int l=0;l<works.size();l++){
            WorkExperience workExperience=works.get(l);
   
            row = sheet3.createRow(l+o);//
            cell = row.createCell(1);
            cell.setCellValue(basicInfo.getCnname());
            if(workExperience.getJobStartDate()!=null&&workExperience.getJobEndDate()!=null){
              cell = row.createCell(2);
              cell.setCellValue(format.format(workExperience.getJobStartDate()));
              cell = row.createCell(3);
              cell.setCellValue(format.format(workExperience.getJobEndDate()));
            }
            cell = row.createCell(4);
            cell.setCellValue(workExperience.getCompanyName());
            cell = row.createCell(5);
            cell.setCellValue(workExperience.getDepartment());
            cell = row.createCell(6);
            cell.setCellValue(workExperience.getPositionName());
            cell = row.createCell(7);
            cell.setCellValue(workExperience.getSalary());  
            cell = row.createCell(8);
            cell.setCellValue(workExperience.getReterence());
            cell = row.createCell(9);
            cell.setCellValue(workExperience.getRelationship()); 
            cell = row.createCell(10);
            cell.setCellValue(workExperience.getReterencePhone()); 
            cell = row.createCell(11);
            cell.setCellValue(workExperience.getLeaveReason());
            
          }
          o+=works.size();
        }
        
    } catch (FileNotFoundException e) {
        logger.error("excel导出失败：文件路径错误"+e.getCause());
    } catch (IOException e) {
        System.out.println("文件输入流错误");
        logger.error("excel导出失败：文件路径错误"+e.getMessage());

        e.printStackTrace();
    }
      return work;
    }
    
    public void initPage(ModelAndView vm){
      List<EducationExperience> edus =new ArrayList<EducationExperience>();
      EducationExperience edu1=new EducationExperience();
      edus.add(edu1);
      List<Certification> certifications =new ArrayList<Certification>();
      Certification certification1=new Certification();
      Certification certification2=new Certification();
      certifications.add(certification1);
      certifications.add(certification2);
      List<WorkExperience> works =new ArrayList<WorkExperience>();
      WorkExperience work1=new WorkExperience();
      WorkExperience work2=new WorkExperience();
      works.add(work1);
      works.add(work2);
      //申明
      Illustrate ill = new Illustrate();
      ill.setInfectionFlag("1");
      ill.setCriminalFlag("1");
      ill.setEmployFlag("1");
      ill.setInvestigateFlag("1");
      ill.setBanFlag("1");
      
      vm.addObject("edus", edus);
      vm.addObject("certifications", certifications);
      vm.addObject("works", works);
      vm.addObject("ill", ill);
    }
    
    @RequestMapping("getPinyin")
    @ResponseBody
    public String getPinyin(String str) {
        return Pinyin4jUtil.converterToSpell(str);
    }
    
}