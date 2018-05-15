package com.csot.recruit.controller.candidate;


import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.candidate.CandidateRecommend;
import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.vo.CandidateRecommendResumeVo;
import com.csot.recruit.model.vo.CandidateRecommendVo;
import com.csot.recruit.model.vo.ResumeApartVo;
import com.csot.recruit.service.candidate.CandidateRecommendService;
import com.csot.recruit.service.candidate.CandidateService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.resume.ResumeService;
import com.csot.recruit.service.template.TemplateService;
import com.csot.recruit.service.uniform.JobService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("candidateRecommendController")
public class CandidateRecommendController {
    private static final Logger logger = LoggerFactory.getLogger(CandidateRecommendController.class);

    @Resource
    private CandidateRecommendService candidateRecommendService;

    @Resource 
    private CandidateService candidateService;
    
    @Resource
    private ResumeService resumeService;
    
    @Resource
    private TemplateService templateService ;
    
    @Resource
    private SpringPropertyResourceReader springPropertyResourceReader;
    
    @Resource
    private MailSendService mailSendService ;
    
    @Resource
    private BaseUserService baseUserService ;
    
    @Resource
    private JobService jobService ;
    
    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/candidate/candidateRecommendList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<CandidateRecommend> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return candidateRecommendService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/candidate/candidateRecommendEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        CandidateRecommend candidateRecommend = candidateRecommendService.getByPrimaryKey(id);
        request.setAttribute("candidateRecommend", candidateRecommend);
        return new ModelAndView("com/csot/recruit/candidate/candidateRecommendEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        CandidateRecommend candidateRecommend = candidateRecommendService.getByPrimaryKey(id);
        request.setAttribute("candidateRecommend", candidateRecommend);
        return new ModelAndView("com/csot/recruit/candidate/candidateRecommendView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            candidateRecommendService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(CandidateRecommend candidateRecommend) {
        if (StringUtils.hasText(candidateRecommend.getId())) {
            try {
                candidateRecommendService.updateSelective(candidateRecommend);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                candidateRecommend.setId(UUID.randomUUID().toString().replace("-", ""));
                candidateRecommendService.create(candidateRecommend);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("addRecommend")
    public ModelAndView addRecommend(HttpServletRequest request,String candidateId,
        String candidatePostId) {
      
   ModelAndView vm = new ModelAndView("com/csot/candidate/candidateRecommendForm");
   List<ResumeApartVo>  list = new ArrayList<ResumeApartVo>();
         list = resumeService.selectResumeListByCandidateId(candidateId);
        vm.addObject("candidateId", candidateId);
        vm.addObject("candidatePostId", candidatePostId);
        vm.addObject("list", list);
        return vm ;
      
    }
    
    @RequestMapping("candidateRecommendVoSave")
    @ResponseBody
    public Map<String,Object> candidateRecommendVoSave(@CurrentUser SysUser sysUser, CandidateRecommendVo candidateRecommendVo) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
          CandidatePost cp = candidateService.selectCandidatePostById(candidateRecommendVo.getCandidatePostId());
          if(cp != null){
            int flag = candidateRecommendService.saveOrUpdate(sysUser,candidateRecommendVo);
            candidateService.lockCandidate(cp.getCandidateId(), sysUser.getId());
            if(flag == 1){
              sb.append("推荐成功");
            }else{
              sb.append("推荐失败,工号不存在");
              map.put("status", 400);
              return map ;
            }
          }else{
            sb.append("该候选人岗位不存在");
            map.put("status", 400);
            return map ;
          }
         
            /**
             * 发邮件
             */
            if(candidateRecommendVo.getIsEmail().equals("1")){
              Template eTemplate = new Template();
              eTemplate = templateService.getByPrimaryKey(springPropertyResourceReader.getProperty("interviewers.recommend.email.templateId"));
              BaseUser baseUser = new BaseUser();
              baseUser = baseUserService.getBaseUserByPrimaryKey(candidateRecommendVo.getInterviewer());
              Candidate candidate = new Candidate();
              candidate = candidateService.getByPrimaryKey(candidateRecommendVo.getCandidateId());
              mailSendService.sendEmail(baseUser.getEmail(), eTemplate, candidate);
              sb.append(",发送给面试官邮件成功");
            }
            
            candidateService.lockCandidate(candidateRecommendVo.getCandidateId(), sysUser.getId());
            
            
            
              map.put("status", 200);
            
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            map.put("status", 404);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 }
    
    
    /***
     * 推荐简历列表
     * @param page 分页对象
     * @param positionMana 查询对象
     * @return
     */
    @ResponseBody
    @RequestMapping("queryCandidateRecommendListByPage")
    public MiniRtn2Grid<CandidateRecommendResumeVo> queryInterviewBookListByPage(@CurrentUser SysUser sysuser, MiniGridPageSort page, HttpServletRequest request)throws Exception {
        String positionId  = request.getParameter("positionId");
        String qualifications  = request.getParameter(" qualifications");
        String searchKey  = request.getParameter("searchKey");
        String isFeedBack = request.getParameter("isFeedBack");
        if(StringUtil.isEmpty(page.getSortField())) {
          page.setSortField("storageDate");
          page.setSortOrder("desc");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtil.isNotEmpty(positionId)){
          map.put("positionId", positionId);
        }
        if(StringUtil.isNotEmpty(qualifications)){
          map.put("qualifications", qualifications);
        }
        if(StringUtil.isNotEmpty(searchKey)){
          map.put("searchKey", searchKey);
        }
        if(StringUtil.isNotEmpty(isFeedBack)){
          map.put("isFeedBack", isFeedBack);
        }
        map.put("begin", page.getPageSize()*(page.getPageIndex()));
        map.put("end", page.getPageSize()*(page.getPageIndex()+1));
        map.put("sortField", page.getSortField());
        map.put("sortOrder", page.getSortOrder());
        map.put("interviewer", sysuser.getId());
      
        
        MiniRtn2Grid<CandidateRecommendResumeVo> minirtn2Grid = candidateRecommendService.getGridCandidateRecommendVo(map);
        logger.info("data:" + minirtn2Grid.getData() + "total:"
                + minirtn2Grid.getTotal());
        return minirtn2Grid;
    }
    
    
    @RequestMapping("updateRecommend")
    @ResponseBody
    public Map<String,Object> updateRecommend(String status,String ids) {
      Map<String,Object> map = new HashMap<String,Object>();
      Map<String,Object> param = new HashMap<String,Object>();
      List<String> list = new ArrayList<String>();
      StringBuffer sb = new StringBuffer();
          try{
            if(StringUtil.isNotEmpty(status)){
              param.put("status", status);
            }
            if(StringUtil.isNotEmpty(ids)){
              for(String str : ids.split(",")){
                list.add(str);
              }
              param.put("list", list);
            }
            candidateRecommendService.batchUpdateRecommend(param);
            sb.append("操作成功");
            map.put("msg", 200);
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            map.put("status", 404);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 }
    @RequestMapping("changePostionRecommend")
    @ResponseBody
    public Map<String,Object> changePostionRecommend(String positionId,String id) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            CandidateRecommend cr = new CandidateRecommend();
            cr = candidateRecommendService.getByPrimaryKey(id);
            cr.setTurntoPostId(positionId);
            cr.setFeedbackTime(new Date());
            cr.setFeedback("2");
            candidateRecommendService.updateSelective(cr);
            sb.append("操作成功");
            map.put("msg", 200);
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            map.put("status", 404);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 }
    
    @RequestMapping("validateCandidateRecommend")
    @ResponseBody
    public Map<String,Object> validateCandidateRecommend(@CurrentUser SysUser sysUser, String candidatePostId) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
      Map<String,Object> param = new HashMap<String,Object>();
          try{
            param.put("candidatePostId", candidatePostId);
            CandidateRecommend cr = candidateRecommendService.getByMap(param);
            if(cr == null){
              sb.append("验证成功");
              map.put("status", 200);
            }else{
             if(!cr.getFeedback().equals("0")){
               sb.append("验证成功");
               map.put("status", 200);
             }else{
               sb.append("已推荐未反馈的候选人耐心等待面试官反馈");
               map.put("status", 404);
             }
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
    
    @RequestMapping("getCandidateRecommend")
    @ResponseBody
    public Map<String,Object> getCandidateRecommend(@CurrentUser SysUser sysUser, String id) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
      Map<String,Object> param = new HashMap<String,Object>();
          try{
            param.put("candidatePostId", id);
            CandidateRecommend cr = candidateRecommendService.getByMap(param);
            if(cr != null){
              map.put("comments", cr.getComments());
              BaseUser interviewer = baseUserService.getBaseUserByPrimaryKey(cr.getInterviewer());
              if(interviewer != null){
                map.put("interviewerName", interviewer.getName());
              }
            
                map.put("status", cr.getFeedback());
              
              Job job = jobService.selectByCode(cr.getTurntoPostId());
              if(job != null){
                map.put("jobName", job.getcJobname());
              }
              BaseUser user = baseUserService.getBaseUserByPrimaryKey(cr.getCreateUser());
              if(user != null){
                map.put("userName", user.getName());
              }
              map.put("createTime", DateKit.timeToStr(cr.getCreateTime()));
              map.put("feedbackTime", DateKit.timeToStr(cr.getFeedbackTime()));
              
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
    
    
    
    
}