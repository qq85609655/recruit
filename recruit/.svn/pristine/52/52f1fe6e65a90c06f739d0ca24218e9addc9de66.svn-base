package com.csot.recruit.controller.flow.interview;

import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.flow.interview.Estimate;
import com.csot.recruit.model.original.flow.interview.InterviewBook;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.vo.EstimateEmailTemplate;
import com.csot.recruit.model.vo.InterviewBookVo;
import com.csot.recruit.model.vo.InterviewEmailTemplate;
import com.csot.recruit.service.flow.interview.EstimateService;
import com.csot.recruit.service.flow.interview.InterviewBookService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.template.TemplateService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.amberframework.web.system.service.impl.BaseUserServiceImpl;
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
@RequestMapping("estimateController")
public class EstimateController {
    private static final Logger logger = LoggerFactory.getLogger(EstimateController.class);

    @Resource
    private EstimateService estimateService;
    
    @Resource
    private InterviewBookService interviewBookService ;
    
    @Resource
    private BaseUserService baseUserService;
    
    @Resource
    private MailSendService mailSendService ;
    
    @Resource
    private TemplateService templateService ;
    
    
    @Resource
    private SpringPropertyResourceReader springPropertyResourceReader;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/interview/estimateList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Estimate> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return estimateService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/interview/estimateEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Estimate estimate = estimateService.getByPrimaryKey(id);
        request.setAttribute("estimate", estimate);
        return new ModelAndView("com/csot/recruit/flow/interview/estimateEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Estimate estimate = estimateService.getByPrimaryKey(id);
        request.setAttribute("estimate", estimate);
        return new ModelAndView("com/csot/recruit/flow/interview/estimateView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            estimateService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Estimate estimate) {
        if (StringUtils.hasText(estimate.getId())) {
            try {
                estimateService.updateSelective(estimate);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                estimate.setId(UUID.randomUUID().toString().replace("-", ""));
                estimateService.create(estimate);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("estimateEdit")
    public ModelAndView estimateEdit(String candidateId , String positionId,String type) {
      Map<String,Object> param = new HashMap<String,Object>();
      String url;
      if("HR".equals(type)){
        url = "com/csot/flow/interview/estimateEdit";
      }else{
        url = "com/csot/flow/interview/visitor/estimateEdit";
      }
      ModelAndView mv = new ModelAndView(url);
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
    
    
    @RequestMapping("estimateSave")
    @ResponseBody
    public Map<String,Object> estimateSave(@CurrentUser SysUser sysUser, Estimate estimate) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            
              estimateService.saveOrUpdate(sysUser,estimate);
              if(!(StringUtils.hasText(estimate.getId()))){
                //发邮件
                Map<String,Object> param = new HashMap<String,Object>();
                param.put("candidateId", estimate.getCandidateId());
                param.put("positionId", estimate.getPositionId());
               List<InterviewBook> list = interviewBookService.selectInterviewBookListByMap(param);
               if(list != null && list.size() > 0){
                 Set<String> strList = new HashSet<String>();
              
                 for(InterviewBook item : list){
                   String[] strArray = item.getInterviewers().split(",");
                   for(String str : strArray){
                     strList.add(str);
                     }
                   }
                 
                 BaseUser baseUser = null ;
                 StringBuffer stringBuffer = new StringBuffer();
                 for(String str : strList){
                   baseUser = baseUserService.getBaseUserByPrimaryKey(str);
                   stringBuffer.append(baseUser.getEmail()+";");
                 }
                 Template template = new Template();
                 EstimateEmailTemplate estimateEmailTemplate = new EstimateEmailTemplate();
                 estimateEmailTemplate.setCandidateId(estimate.getCandidateId());
                 estimateEmailTemplate.setPositionId(estimate.getPositionId());
                 template = templateService.getByPrimaryKey(springPropertyResourceReader.getProperty("interviewers.email.templateId"));
                 mailSendService.sendEmail(stringBuffer.toString(), template, estimateEmailTemplate);
              }
               
             }
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
    
}