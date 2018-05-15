package com.csot.recruit.controller.candidate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.service.BaseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.csot.recruit.common.constant.MailConstants;
import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.interview.Estimate;
import com.csot.recruit.model.original.flow.interview.Feedback;
import com.csot.recruit.model.original.flow.interview.InterviewBook;
import com.csot.recruit.model.original.log.OperateHistory;
import com.csot.recruit.model.original.resume.LabelRalation;
import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.resume.Label;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.ResumesData;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.vo.CandidateData;
import com.csot.recruit.model.vo.InterviewBookCandidateVo;
import com.csot.recruit.model.vo.InterviewBookListVo;
import com.csot.recruit.model.vo.InterviewBookVo;
import com.csot.recruit.model.vo.InterviewEmailTemplate;
import com.csot.recruit.model.vo.MessageForm;
import com.csot.recruit.model.vo.ResumeApartVo;
import com.csot.recruit.model.vo.ResumeVo;
import com.csot.recruit.service.candidate.CandidateService;
import com.csot.recruit.service.flow.employ.EmployService;
import com.csot.recruit.service.flow.interview.EstimateService;
import com.csot.recruit.service.flow.interview.FeedbackService;
import com.csot.recruit.service.flow.interview.InterviewBookService;
import com.csot.recruit.service.log.OperateHistoryService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.resume.LabelRalationService;
import com.csot.recruit.service.resume.LabelService;
import com.csot.recruit.service.resume.ResumeService;
import com.csot.recruit.service.resume.WorkExperienceService;
import com.csot.recruit.service.template.TemplateService;
import com.csot.recruit.service.uniform.JobService;
import com.google.common.base.Throwables;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
@RequestMapping("candidateController")
public class CandidateController {
    private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @Resource
    private CandidateService candidateService;
    
    @Resource
    private OperateHistoryService operateHistoryService ;
    
    @Resource
    private ResumeService resumeService ;
    
    @Resource
    private JobService jobService ;
    
    @Resource
    private EstimateService estimateService ;
    
    @Resource
    private BaseUserService baseUserService ;
    
    @Resource
    private InterviewBookService interviewBookService;
    
    @Resource
    private EmployService employService ;
    
    @Resource
    private FeedbackService feedbackService ;
    
    @Resource 
    private LabelRalationService labelRalationService ;
    
    @Resource
    private LabelService labelService ;
    
    @Resource
    private WorkExperienceService workExperienceService;
    
    @Resource
    private FreeMarkerConfigurer freemarkerConfig;
    
    @Resource
    private TemplateService templateService ;
    
    @Resource
    private MailSendService mailSendService ;
    
    @Resource
    private SpringPropertyResourceReader springPropertyResourceReader;
    
    
    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/candidate/candidateList");
    }
    
    @RequestMapping("repository")
    public ModelAndView repository() {
        return new ModelAndView("com/csot/candidate/candidateRepository");
    }
    

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Candidate> datagrid(@CurrentUser SysUser sysuser, MiniGridPageSort page, HttpServletRequest request,CandidateData candidateData) {
      //String searchKey = request.getParameter("searchKey");
      String state = request.getParameter("state");
      if(StringUtil.isEmpty(page.getSortField())) {
        page.setSortField("storageDate");
        page.setSortOrder("desc");
      }
      Map<String, Object> map = new HashMap<String, Object>();
      if(StringUtil.isNotEmpty(state)){
        map.put("state", state);
      }
      map.put("workCode", sysuser.getWorkCode());
      map.put("userId", sysuser.getId());
      map.put("begin", page.getPageSize()*(page.getPageIndex()));
      map.put("end", page.getPageSize()*(page.getPageIndex()+1));
      map.put("sortField", page.getSortField());
      map.put("sortOrder", page.getSortOrder());
      if(null != candidateData.getStartTime()&&(!"".equals(candidateData.getStartTime().trim()))){
        candidateData.setStartTimeDate(DateKit.strToTime(candidateData.getStartTime()));
      }
      if(null != candidateData.getEndTime()&&(!"".equals(candidateData.getEndTime().trim()))){
        candidateData.setEndTimeDate(DateKit.strToTime(candidateData.getEndTime()));
      }
      
      map.put("candidateData" , candidateData);
      List<String> list = null ;
      if(null != candidateData.getLabels() || "".equals(candidateData.getLabels())){
        list = new ArrayList<String>();
        for(String str : candidateData.getLabels().split(",")){
          list.add(str);
        }
        map.put("list", list);
      }
      
      
      
       
      return candidateService.getCandidateListGrid(map);
    }
    
    
    
    @RequestMapping("candidateDatagrid")
    @ResponseBody
    public MiniRtn2Grid<Candidate> candidateDatagrid(@CurrentUser SysUser sysuser, MiniGridPageSort page, HttpServletRequest request) {
      String searchKey = request.getParameter("searchKey");
      if(StringUtil.isEmpty(page.getSortField())) {
        page.setSortField("storageDate");
        page.setSortOrder("desc");
      }
      Map<String, Object> map = new HashMap<String, Object>();
      if(StringUtil.isNotEmpty(searchKey)){
        map.put("searchKey", searchKey);
      }
      map.put("begin", page.getPageSize()*(page.getPageIndex()));
      map.put("end", page.getPageSize()*(page.getPageIndex()+1));
      map.put("sortField", page.getSortField());
      map.put("sortOrder", page.getSortOrder());
      
       
      return candidateService.getCandidateRepositoryGrid(map);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/candidate/candidateEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Candidate candidate = candidateService.getByPrimaryKey(id);
        request.setAttribute("candidate", candidate);
        return new ModelAndView("com/csot/recruit/candidate/candidateEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Candidate candidate = candidateService.getByPrimaryKey(id);
        request.setAttribute("candidate", candidate);
        return new ModelAndView("com/csot/recruit/candidate/candidateView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            candidateService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Candidate candidate) {
        if (StringUtils.hasText(candidate.getId())) {
            try {
                candidateService.updateSelective(candidate);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                candidate.setId(UUID.randomUUID().toString().replace("-", ""));
                candidateService.create(candidate);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("unlockCandidate")
    @ResponseBody
    public Map<String,Object> unlockCandidate(@CurrentUser SysUser sysUser,String ids){
      Map<String,Object> map = new HashMap<String,Object>();
      if(StringUtils.hasText(ids)){
        candidateService.unlockCandidate(ids, sysUser.getId());
        map.put("msg", "解锁成功");
      }else{
        map.put("msg", "候选人不能为空");
      }
      return map ;
    }
    
    @RequestMapping("changePosition")
    @ResponseBody
    public Map<String,Object> changePosition(@CurrentUser SysUser sysUser, HttpServletResponse response,String candidateId,String applyPostId,String oldPositionId){
      Map<String,Object> map = new HashMap<String,Object>();
      Map<String,Object> param = null ;
      if(StringUtils.hasText(candidateId)){
        List<CandidatePost> list = new ArrayList<CandidatePost>();
        list = candidateService.selectCandidatePostListByCandidateId(candidateId);
        for(CandidatePost cp : list){
          if(applyPostId.equals(cp.getPositionId())){
            map.put("msg", "转向失败，该候选人已经在岗位需求内");
            return map ;
          }
        }
        param = new HashMap<String, Object>();
        param.put("candidateId", candidateId);
        param.put("positionId", oldPositionId);
       CandidatePost candidatePost = new CandidatePost();  
       candidatePost = candidateService.selectCandidatePostByMap(param);
       candidatePost.setNowPositionId(applyPostId);
       candidateService.updateCandidatePostSelective(candidatePost);
       OperateHistory operateHistory = new OperateHistory();
       
       operateHistory.setId(UUID.randomUUID().toString().replace("-", ""));
       operateHistory.setOperatorUser(sysUser.getId());
       operateHistory.setOperatorType("候选人转向");
       
       Job job = jobService.selectByCode(oldPositionId);
       Job job1 = jobService.selectByCode(applyPostId);
       operateHistory.setOperatorContent(job.getcJobname()+"转向到"+job1.getcJobname());
       operateHistory.setRelatedId(candidateId);
       operateHistory.setOperatorTime(DataUtils.gettimestamp());
       operateHistoryService.create(operateHistory);
       
       map.put("msg", "转向成功");
       return map ;
      }else{
        map.put("msg", "转向失败，候选人不能为空");
        return map ;
      }
    }
    
    /**
     *  中文简历
     * @return
     */
    @RequestMapping("getCandidateResume/{id}/{candidatePostId}")
    public ModelAndView getCandidateResume(@PathVariable String id,@PathVariable String candidatePostId,HttpServletRequest request) {
      Candidate candidate = candidateService.getByPrimaryKey(candidatePostId);
      CandidatePost candidatePost = candidateService.selectCandidatePostById(candidatePostId);
      if(null != candidate){
        ResumeVo rv = new ResumeVo(); 
        
        rv = resumeService.getResumeVo(candidate.getResumeId());
        
        Job job = jobService.selectByCode(candidatePost.getPositionId());
        rv.setJobName(job.getcJobname());
        rv.setPositionId(candidatePost.getPositionId());
        rv.setResumeId(candidate.getResumeId());
        rv.setCandidateId(id);
        rv.setLockUserAccount(candidate.getLockUserAccount());
        rv.setCandidatePostId(candidatePostId);
        CandidatePost cp = candidateService.selectCandidatePostById(candidatePostId);
        if(cp != null){
          request.setAttribute("interviewStatus", cp.getInterviewStatus());
        }
        request.setAttribute("resumeVo", rv);
        
      }
      List<ResumeApartVo>  list = new ArrayList<ResumeApartVo>();
      list = resumeService.selectResumeListByCandidateId(id);
      for(ResumeApartVo ra : list){
        ra.setJobName(jobService.selectByCode(ra.getPositionId()).getcJobname());
      }
      request.setAttribute("list", list);
      
      List<OperateHistory> ohList = operateHistoryService.getOperateHistoryListByCandidateId(id);
      BaseUser baseUser = null;
      for(OperateHistory op : ohList){
        baseUser = baseUserService.getBaseUserByPrimaryKey(op.getOperatorUser());
        op.setOperatorUser(baseUser.getName());
      }
      request.setAttribute("ohList", ohList);
      request.setAttribute("cp", candidatePost);
      
      return new ModelAndView("com/csot/candidate/candidatePersonalResume");
    }
    
    
    /**
     *  中文简历
     * @return
     */
    @RequestMapping("getResumeList/{id}")
    public ModelAndView getResumeList(@PathVariable String id,HttpServletRequest request) {
      Candidate candidate = candidateService.getCandidateByPrimaryKey(id);
      if(null != candidate){
        ResumeVo rv = new ResumeVo(); 
        
        rv = resumeService.getResumeVo(candidate.getResumeId());
        request.setAttribute("resumeVo", rv);
      
        rv.setResumeId(candidate.getResumeId());
        rv.setCandidateId(id);
        rv.setLockUserAccount(candidate.getLockUserAccount());
        
      }
      
      List<ResumeApartVo> list = resumeService.selectResumeListByCandidateId(id);
      if(list != null &&list.size() > 0){
        for(ResumeApartVo ra : list){
          ra.setJobName(jobService.selectByCode(ra.getPositionId()).getcJobname());
        }
        request.setAttribute("list", list);
      }
      
      List<OperateHistory> ohList = operateHistoryService.getOperateHistoryListByCandidateId(id);
      BaseUser baseUser = null;
      if(ohList != null && ohList.size() > 0){
        for(OperateHistory op : ohList){
          baseUser = baseUserService.getBaseUserByPrimaryKey(op.getOperatorUser());
          op.setOperatorUser(baseUser.getName());
        }
        request.setAttribute("ohList", ohList);
      }
    
      return new ModelAndView("com/csot/candidate/candidateResumeList");
    }
    
    
    @RequestMapping("zh_resume/{id}")
    public ModelAndView zh_resume(@PathVariable String id, HttpServletRequest request) {
        Resume resume = resumeService.getZhResume(id, request);
        if(resume != null){
          if(resume.getBirthday() != null){
            resume.setBirthdayStr(DateKit.dateToStr(resume.getBirthday()));
          }
          
          request.setAttribute("resume", resume);
        }
        
        List<OperateHistory> list = operateHistoryService.getOperateHistoryListByCandidateId(id);
        BaseUser baseUser = null;
        for(OperateHistory op : list){
          baseUser = baseUserService.getBaseUserByPrimaryKey(op.getOperatorUser());
          op.setOperatorUser(baseUser.getName());
        }
        request.setAttribute("list", list);
        return new ModelAndView("com/csot/candidate/zh_resume");
    }
    
    @RequestMapping("estimate/{candidateId}/{positionId}")
    public ModelAndView estimate(@PathVariable String candidateId , @PathVariable String positionId) {
      Map<String,Object> param = new HashMap<String,Object>();
      ModelAndView mv = new ModelAndView("com/csot/candidate/estimateEdit");
      if(StringUtil.isNotEmpty(candidateId)){
        param.put("candidateId", candidateId);
      }
      if(StringUtil.isNotEmpty(positionId)){
        param.put("positionId", positionId);
      }
      
      Estimate estimate = estimateService.selectByCandiateIdAndPositionId(param);
      mv.addObject("estimate", estimate);
      
        return mv;
    }
    
    @RequestMapping("queryLabelList/{candidateId}")
    @ResponseBody
    public  Map<String,Object>  queryLabelList(@PathVariable String candidateId) {
      Map<String,Object> map = new HashMap<String,Object>();
      LabelRalation labelRalation = labelRalationService.getByReservseId(candidateId);
      List<Label> labelList = null ;
      if(null != labelRalation){
        labelList = new ArrayList<Label>();
        String[] strs = labelRalation.getLabelIds().split(",");
        Label label;
        for(String str : strs){
          label = labelService.getByPrimaryKey(str);
          labelList.add(label);
        }
      }
      map.put("labelList", labelList);
     return map;
    }
    
   
    
    @RequestMapping("opRecord/{id}/{positionId}")
    public ModelAndView opRecord(@PathVariable String id,@PathVariable String positionId, HttpServletRequest request) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("candidateId", id);
        param.put("positionId", positionId);
        List<InterviewBook> interviewBookList = interviewBookService.selectInterviewBookListByMap(param);
        List<InterviewBookListVo> list = new ArrayList<InterviewBookListVo>();
        if(interviewBookList != null && interviewBookList.size() > 0){
          InterviewBookListVo interviewBookListVo = null;
          String[] ids ;
          BaseUser baseUser ;
          Feedback feedback ;
          for(InterviewBook item : interviewBookList){
            interviewBookListVo = new InterviewBookListVo();
            feedback = new Feedback();
            //面试地点、面试时间、面试官、面试状态
            interviewBookListVo.setInterviewAddress(item.getInterviewAddress());
            StringBuffer timeSb = new StringBuffer() ;
            if(null!=item.getInterviewDate()&& (!"".equals(item.getInterviewDate()))){
              timeSb.append(DateKit.dateToStr(item.getInterviewDate()));
              timeSb.append(" ");
              timeSb.append(item.getInterviewBTime());
              timeSb.append("~");
              timeSb.append(item.getInterviewETime());
            }
            interviewBookListVo.setInterviewTimes(timeSb.toString());
            StringBuffer sb = new StringBuffer() ;
            if(null!=item.getInterviewers()&& (!"".equals(item.getInterviewers()))){
              ids = item.getInterviewers().split(",");
              
              for(int i = 0 ;i < ids.length; i++ ){
                baseUser = baseUserService.getBaseUserByPrimaryKey(ids[i]);
                if(i!= ids.length-1){
                  sb.append(baseUser.getName()+",");
                }else{
                  sb.append(baseUser.getName());
                }
              }
            }
           
            interviewBookListVo.setInterviewers(sb.toString());
            if("1".equals(item.getInterviewStatus())){
              interviewBookListVo.setInterviewStatus("第"+item.getRounds()+"轮已取消");
            }
            if("0".equals(item.getInterviewStatus())){
              interviewBookListVo.setInterviewStatus("第"+item.getRounds()+"轮已安排");
            }
            if("20".equals(item.getInterviewStatus())){
              interviewBookListVo.setInterviewStatus("淘汰");
            }
            if("9".equals(item.getInterviewStatus())){
              interviewBookListVo.setInterviewStatus("第"+item.getRounds()+"轮未安排");
            }
            feedback = feedbackService.getByInterviewBookId(item.getId());
            interviewBookListVo.setFeedback(feedback);
            
            list.add(interviewBookListVo);
          }
        }
        
        request.setAttribute("interviewBookVoList", list);
      
        List<Employ>  employList = employService.getEmployByCandidatePostId(param);
        request.setAttribute("employList", employList);
        return new ModelAndView("com/csot/candidate/opRecord");
    }
    
    @RequestMapping("exportStandardResume/{resumeId}")
    @ResponseBody
    public AjaxRtnJson exportStandardResume(HttpServletResponse response,@PathVariable String resumeId){
      
      //简历基本信息
      Resume resume = resumeService.getByPrimaryKey(resumeId);
      
      //工作经历
      List<WorkExperience> works = workExperienceService.queryByResumeId(resumeId);
      
      Map<String,Object> dataMap=new HashMap<String,Object>();
      
      dataMap.put("resume", resume);
      dataMap.put("works", works);
      
      Template template = null;
      //获取模板
      try {
        freemarkerConfig.getConfiguration().setDateFormat("yyyy-MM-dd");
        template = freemarkerConfig.getConfiguration().getTemplate(CommonConstant.STANDARD_RESUME_FTL,new Locale("Zh_cn"), "UTF-8");
        //获取往网络输出流
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        String fileName = resume.getName()+".doc";
        try {
          response.setHeader("Content-Disposition", "attachment;fileName="
              + new String(fileName.getBytes("gbk"), "iso-8859-1"));
        } catch (UnsupportedEncodingException e1) {
          logger.error("download file UnsupportedEncodingException", e1);
          throw Throwables.propagate(e1);
        }
        Writer out = null;
        OutputStream os = response.getOutputStream();
        out = new BufferedWriter(new OutputStreamWriter(os)); 
        template.process(dataMap, out);
        
        // 关闭流
        out.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }
    
    @RequestMapping("getCandidatePostStatus")
    @ResponseBody
    public Map<String,Object> getCandidatePostStatus(String id) {
      Map<String,Object> map = new HashMap<String,Object>();
          try{
            List<CandidatePost> cpList = candidateService.selectCandidatePostListByCandidateId(id);
            if(cpList != null && cpList.size() > 0){
              Job job = null;
              for(int i = 0 ; i < cpList.size() ; i++){
                job = new Job();
                job = jobService.selectByCode(cpList.get(i).getPositionId());
                cpList.get(i).setJobName(job.getcJobname());
              }
            }
            map.put("cpList", cpList);
           
            
          }catch(Exception e){
            logger.error(e.getMessage(), e);
          }
          return map ;
 } 
  
    @RequestMapping("addCandidatePost")
    @ResponseBody
    public Map<String,Object> addCandidatePost(@CurrentUser SysUser sysuser, String candidateId,String positionId) {
      Map<String,Object> map = new HashMap<String,Object>();
      Map<String,Object> param = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            param.put("candidateId", candidateId);
            param.put("positionId", positionId);
            if(StringUtil.isNotEmpty(candidateId)||StringUtil.isNotEmpty(positionId)){
               String[] ids = candidateId.split(",");
               for(String id : ids){
                 param.put("candidateId", id);
                 param.put("positionId", positionId);
                 CandidatePost cp = candidateService.selectCandidatePostByMap(param);
                 if(cp == null){
                   cp = new CandidatePost();
                   cp.setCandidateId(id);
                   cp.setInterviewStatus("00");
                   cp.setPositionId(positionId);
                   cp.setOperatorUser(sysuser.getId());
                   cp.setCreateTime(new Date());
                   cp.setId(UUID.randomUUID().toString().replace("-", ""));
                   candidateService.addCandidatePost(cp);
                 }
               }
               sb.append("添加成功");
            }else{
              sb.append("提交数据异常");
              return map ;
            }
            
          
              
          
           
            
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 } 
   
    // 发送邮件
    @RequestMapping("sendMessage")
    public ModelAndView sendMessage(@CurrentUser SysUser sysUser, HttpServletRequest request) {
      String candidateId = request.getParameter("candidateId");
      Candidate candidate = candidateService.getCandidateByPrimaryKey(candidateId); // 获取候选人信息
      
      String realName = candidate.getName();
      request.setAttribute("realName", realName);
      request.setAttribute("candidateId", candidateId);
      return new ModelAndView("com/csot/candidate/sendMessage");

    }
    
    
    /**
     * 人才库--发送简历
     * @param sysUser
     * @param messageForm
     * @return
     */
    @RequestMapping("sendMessageSubmit")
    @ResponseBody
    public Map<String,Object> sendMessageSubmit(@CurrentUser SysUser sysUser, MessageForm messageForm) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            Candidate candidate = candidateService.getCandidateByPrimaryKey(messageForm.getCandidateId());
            if(candidate != null){
              String bzjlurl = "";
              if(messageForm.getIsBzjl().equals("1")){
                bzjlurl += resumeService.outputStandardResume(candidate.getResumeId());
              }
              String jlywurl ="";
              if(messageForm.getIsJlyw().equals("1")){
              jlywurl += candidate.getResumeDir();
              }
              
              com.csot.recruit.model.template.Template template = templateService.getByPrimaryKey(messageForm.getModelId());
              template.setContext(messageForm.getEmailContent());
              
              String[] ids = messageForm.getInterviewer().split(",");
              BaseUser baseUser = null ;
              StringBuffer sbs = new StringBuffer();
              for(String id : ids){
                baseUser = baseUserService.getBaseUserByPrimaryKey(id);
                sbs.append(baseUser.getEmail()+";");
              }
              mailSendService.sendResumeMessage(sbs.toString(),template,bzjlurl,jlywurl,messageForm);
              sb.append("发送成功");
            
              
            }else{
              sb.append("数据异常");
            }
            
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            map.put("status", 404);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 }
    
    /*
     * 下载简历原文
     */
    @RequestMapping("downLoadResume/{candidateId}") 
    @ResponseBody
    public void downLoadResume(@PathVariable String candidateId,HttpServletResponse response,HttpServletRequest request) throws FileNotFoundException{ 
   
          Candidate candidate = candidateService.getCandidateByPrimaryKey(candidateId);
          
          String path=  springPropertyResourceReader.getProperty("recruit.resume.path")+candidate.getResumeDir()+"resume.html";
          
          // 下载本地文件
          String fileName = "resume.html".toString(); // 文件的默认保存名
          
          // 读到流中
          InputStream inStream = new FileInputStream(path);// 文件的存放路径
          // 设置输出的格式
          response.reset();
          response.setContentType("bin");
          response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
          // 循环取出流中的数据
          byte[] b = new byte[100];
          int len;
          try {
              while ((len = inStream.read(b)) > 0)
                  response.getOutputStream().write(b, 0, len);
              inStream.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      
    } 
    
    /**
     * 
     * 候选人列表--批量恢复
     * @param ids 
     * @return
     */
    @RequestMapping("recover")
    @ResponseBody
    public Map<String,Object> recover(String ids) {
      Map<String,Object> map = new HashMap<String,Object>();
      Map<String,Object> param = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            if(StringUtil.isNotEmpty(ids)){
              List<String> list = new ArrayList<String>();
              for(String id : ids.split(",")){
                list.add(id);
              }
              param.put("list", list);
              param.put("interviewStatus", "00");
              candidateService.batchOutCpByMap(param);
              sb.append("恢复成功");
            }else{
              sb.append("提交数据异常");
              return map ;
            }
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 } 
    
    /**
     * 验证--候选人是否已被淘汰
     * @param request
     * @return
     */
    @RequestMapping("valiateCandidate")
    @ResponseBody
    public Map<String,Object> valiateCandidate(HttpServletRequest request) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
      Map<String,Object> param = new HashMap<String,Object>();
      try{
        String candidateId  = request.getParameter("candidateId");
        String positionId = request.getParameter("positionId");
        if(StringUtil.isNotEmpty(candidateId)){
          param.put("candidateId", candidateId);
        }
        if(StringUtil.isNotEmpty(positionId)){
          param.put("positionId", positionId);
        }
        CandidatePost cp = candidateService.selectCandidatePostByMap(param);
        map.put("code", 200);
        if(cp != null){
          map.put("interviewStatus", cp.getInterviewStatus());
          map.put("code", 200);
        }else{
          map.put("interviewStatus", "");
        }
       
      }catch(Exception e){
        logger.error(e.getMessage(), e);
        sb.append("网络异常");
        map.put("code", 404);
      }finally{
        map.put("msg", sb.toString());
      }
     
      return map ;
    }
    
    
    // 淘汰候选人
    @RequestMapping("outCandidate/{ids}/{positionIds}")
    public ModelAndView outCandidate(@PathVariable String ids, @PathVariable String positionIds, HttpServletRequest request) {
      
      request.setAttribute("ids", ids);
      request.setAttribute("positionIds", positionIds);
      return new ModelAndView("com/csot/candidate/outCandidate");

    }
    
  /*  public void downloadLocal(HttpServletResponse response) throws FileNotFoundException {
      // 下载本地文件
      String fileName = "Operator.doc".toString(); // 文件的默认保存名
      // 读到流中
      InputStream inStream = new FileInputStream("c:/Operator.doc");// 文件的存放路径
      // 设置输出的格式
      response.reset();
      response.setContentType("bin");
      response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
      // 循环取出流中的数据
      byte[] b = new byte[100];
      int len;
      try {
          while ((len = inStream.read(b)) > 0)
              response.getOutputStream().write(b, 0, len);
          inStream.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }*/
}