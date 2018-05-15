package com.csot.recruit.controller.flow.interview;

import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.original.candidate.CandidateMapper;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.flow.interview.IbARalation;
import com.csot.recruit.model.original.flow.interview.InterviewBook;
import com.csot.recruit.model.original.log.OperateHistory;
import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.vo.InterviewBookCandidateVo;
import com.csot.recruit.model.vo.InterviewBookListVo;
import com.csot.recruit.model.vo.InterviewBookVo;
import com.csot.recruit.model.vo.InterviewEmailTemplate;
import com.csot.recruit.service.attachment.AttachmentService;
import com.csot.recruit.service.candidate.CandidateService;
import com.csot.recruit.service.flow.interview.IbARalationService;
import com.csot.recruit.service.flow.interview.InterviewBookService;
import com.csot.recruit.service.log.OperateHistoryService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.template.TemplateService;

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
@RequestMapping("interviewBookController")
public class InterviewBookController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewBookController.class);

    @Resource
    private InterviewBookService interviewBookService;
    @Resource
    private CandidateService candidateService;
    
    @Resource
    private MailSendService mailSendService ; 
    
    @Resource
    private TemplateService templateService ;
    
    @Resource
    private AttachmentService AttachmentService ;
    
    @Resource
    private BaseUserService baseUserService ;
    
    @Resource
    private SpringPropertyResourceReader springPropertyResourceReader;
    
    @Resource
    private IbARalationService ibARalationService ;
    
    @Resource
    private OperateHistoryService operateHistoryService ;
    
    @Resource
    private CandidateMapper candidateMapper;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/interview/interviewBookList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<InterviewBook> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return interviewBookService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/interview/interviewBookEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        InterviewBook interviewBook = interviewBookService.getByPrimaryKey(id);
        request.setAttribute("interviewBook", interviewBook);
        return new ModelAndView("com/csot/recruit/flow/interview/interviewBookEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        InterviewBook interviewBook = interviewBookService.getByPrimaryKey(id);
        request.setAttribute("interviewBook", interviewBook);
        return new ModelAndView("com/csot/recruit/flow/interview/interviewBookView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            interviewBookService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(InterviewBook interviewBook) {
        if (StringUtils.hasText(interviewBook.getId())) {
            try {
                interviewBookService.updateSelective(interviewBook);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                interviewBook.setId(UUID.randomUUID().toString().replace("-", ""));
                interviewBookService.create(interviewBook);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("InterviewBookVoSave")
    @ResponseBody
    public Map<String,Object> InterviewBookVoSave(@CurrentUser SysUser sysUser, InterviewBookVo interviewBookVo) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            
          String flag = interviewBookService.saveOrUpdate(sysUser,interviewBookVo);
          if(StringUtil.isNotEmpty(flag)){
            map.put("id", flag);
            sb.append("保存成功");
          }else{
            sb.append("保存失败,工号不存在");
            map.put("status", 400);
            return map ;
          }
           
          String[] interviewersStrArray = interviewBookVo.getInterviewers().split("_");
          String[] interviewDateStrArray = interviewBookVo.getInterviewDateStr().split("_");
          String[] interviewBTimeArray = interviewBookVo.getInterviewBTime().split("_");
          String[] interviewETimeArray = interviewBookVo.getInterviewETime().split("_");
          String[] interviewAddressArray = interviewBookVo.getInterviewAddress().split("_");
          List<InterviewEmailTemplate> list = new ArrayList<InterviewEmailTemplate>();
          for(int i = 0  ; i < interviewersStrArray.length ; i++){
            InterviewEmailTemplate interviewEmailTemplate = new InterviewEmailTemplate() ;
            interviewEmailTemplate.setAddress(interviewAddressArray[i]);
            interviewEmailTemplate.setInterviewtime(interviewDateStrArray[i]+ " " + interviewBTimeArray[i] + "~" + interviewETimeArray[i]);
            interviewEmailTemplate.setInterviewee(interviewBookVo.getCandidateName());
            String[] strs = interviewersStrArray[i].split(",");
            BaseUser baseUser = null ;
            Template interviewersTemplate = null ;
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer interviewersSb = new StringBuffer();
            for(String str : strs){
              baseUser = new BaseUser();
              baseUser = baseUserService.getBaseUserByPrimaryKey(str);
              stringBuffer.append(baseUser.getEmail()+";");
              interviewersSb.append(baseUser.getName()+" ");
            }
            interviewersTemplate = new Template();
            interviewersTemplate = templateService.getByPrimaryKey(springPropertyResourceReader.getProperty("interviewers.email.templateId"));
           
            interviewEmailTemplate.setName(baseUser.getName());
            mailSendService.sendEmail(stringBuffer.toString(), interviewersTemplate, interviewEmailTemplate);
            interviewEmailTemplate.setInterviewee(interviewersSb.toString());
            list.add(interviewEmailTemplate);
          }
          sb.append(",发送给面试官邮件成功");
            
            /**
             * 发邮件
             */
            if(interviewBookVo.getIsEmail().equals("1")){
              Template eTemplate = new Template();
              eTemplate = templateService.getByPrimaryKey(interviewBookVo.getModelId());
              eTemplate.setContext(interviewBookVo.getEmailContent());
              List<Attachment> attachments = new ArrayList<Attachment>();
              if(interviewBookVo.getAttchmentIds()!= null && 
                  (!interviewBookVo.getAttchmentIds().equals(""))){
                String[] ids = interviewBookVo.getAttchmentIds().split(",");
                Attachment attachment = null ;
                for(String id : ids){
                  attachment = AttachmentService.getByPrimaryKey(id);
                  attachments.add(attachment);
                }
              }
              
              Candidate candidate = new Candidate();
              candidate = candidateService.getCandidateByPrimaryKey(interviewBookVo.getInterviewee());
              for(int i = 0 ; i < list.size() ; i++){
                list.get(i).setName(candidate.getName());
                mailSendService.sendCommonEmail(candidate.getEmail(), eTemplate, list.get(i), attachments);
              }
              sb.append(",发送给候选人邮件成功");
            }else{
              sb.append(",候选人邮件不存在");
            }
            
            candidateService.lockCandidate(interviewBookVo.getInterviewee(), sysUser.getId());
            
            
            
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
    
    @RequestMapping("toInterviewBookManage")
    public ModelAndView toInterviewBookManage(HttpServletRequest request) {
      String isBook = request.getParameter("isBook");
      if(StringUtil.isNotEmpty(isBook)){
        request.setAttribute("isBook", isBook);
      }
      return new ModelAndView("com/csot/flow/interview/interviewBookManage");
    }
    
    @RequestMapping("editInterviewBook")
    public ModelAndView editInterviewBook(HttpServletRequest request,String id) {
      InterviewBook interviewBook = interviewBookService.getByPrimaryKey(id);
      if(interviewBook != null){
        ModelAndView vm = new ModelAndView("com/csot/flow/interview/interviewBookEdit");
        StringBuffer sb = new StringBuffer();
        if(null!=interviewBook.getInterviewers() && (!"".equals(interviewBook.getInterviewers()))){
          String[] interviewersIds = interviewBook.getInterviewers().split(",");
          if(null != interviewersIds && interviewersIds.length > 0){
            BaseUser baseUser = null ;
            for(int i = 0 ; i < interviewersIds.length ; i++){
              baseUser = new BaseUser();
              baseUser = baseUserService.getBaseUserByPrimaryKey(interviewersIds[i]);
              if(i!= interviewersIds.length-1){
                sb.append(baseUser.getName()+",");
              }else{
                sb.append(baseUser.getName());
              }
            }
          }
        }
        
        BaseUser linkman = new BaseUser();
        if(null!=interviewBook.getLinkman() && (!"".equals(interviewBook.getLinkman()))){
          linkman = baseUserService.getBaseUserByPrimaryKey(interviewBook.getLinkman());
        }
        
        String[] bTime ;
        String[] eTime ;
        if(null!=interviewBook.getInterviewBTime() && (!"".equals(interviewBook.getInterviewBTime()))){
          bTime = interviewBook.getInterviewBTime().split(":");
          vm.addObject("bHours", bTime[0]);
          vm.addObject("bMins", bTime[1]);
        }
        if(null!=interviewBook.getInterviewETime() && (!"".equals(interviewBook.getInterviewETime()))){
          eTime = interviewBook.getInterviewETime().split(":");
          vm.addObject("eHours", eTime[0]);
          vm.addObject("eMins", eTime[1]);
        }
        
        Template template = new Template();
        if(null!=interviewBook.getModelId() && (!"".equals(interviewBook.getModelId()))){
          template = templateService.getByPrimaryKey(interviewBook.getModelId());
        }
        
        List<Attachment> list = new ArrayList<Attachment>();
        Attachment attachment = null ;
        List<IbARalation> ibARalationList = ibARalationService.getListByInterviewBookId(interviewBook.getId());
        if(null != ibARalationList && ibARalationList.size() > 0){
          attachment = new Attachment();
          for(IbARalation item : ibARalationList){
            attachment = AttachmentService.getByPrimaryKey(item.getAttachmentId());
            list.add(attachment);
          }
        }
        String secondRTimeStr = "";
        if(null != interviewBook.getSecondRTime()&&(!"".equals(interviewBook.getSecondRTime()))){
          String tempStr = DateKit.timeToStr(interviewBook.getSecondRTime());
          secondRTimeStr += tempStr.substring(0, tempStr.length() - 3);
        }
        String secondETimeStr = "";
        if(null != interviewBook.getSecondETime()&&(!"".equals(interviewBook.getSecondETime()))){
          String tempStr = DateKit.timeToStr(interviewBook.getSecondETime());
          secondETimeStr += tempStr.substring(0, tempStr.length() - 3);
        }
        vm.addObject("linkmanName", linkman.getName());
        vm.addObject("interviewBook", interviewBook);
        vm.addObject("addInterviewers0", sb.toString());
        
        vm.addObject("modelName", template.getTitle());
        vm.addObject("attachmentList", list);
        vm.addObject("secondRTimeStr", secondRTimeStr);
        vm.addObject("secondETimeStr", secondETimeStr);
        return vm ;
      }
      
      return null;
    }
    
    @RequestMapping("addInterviewBook")
    public ModelAndView addInterviewBook(HttpServletRequest request,String id,String positionId) {
      Candidate candidate = candidateService.getCandidateByPrimaryKey(id);
      if(candidate != null){
        ModelAndView vm = new ModelAndView("com/csot/flow/interview/interviewBookForm");
        vm.addObject("candidate", candidate);
        vm.addObject("positionId", positionId);
        return vm ;
      }
      
      return null;
    }
 
    /***
     * 面试流程管理查询
     * @param page 分页对象
     * @param positionMana 查询对象
     * @return
     */
    @ResponseBody
    @RequestMapping("queryInterviewBookListByPage")
    public MiniRtn2Grid<InterviewBookListVo> queryInterviewBookListByPage(@CurrentUser SysUser sysUser, MiniGridPageSort page, HttpServletRequest request) {
        String startDate  = request.getParameter("startDate");
        String endDate  = request.getParameter("endDate");
        String searchKey  = request.getParameter("searchKey");
        String isBook = request.getParameter("isBook");
        String interviewStatus = request.getParameter("interviewStatus");
        if(StringUtil.isEmpty(page.getSortField())) {
          page.setSortField("storageDate");
          page.setSortOrder("desc");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtil.isNotEmpty(startDate)){
          map.put("startDate", startDate);
        }
        if(StringUtil.isNotEmpty(endDate)){
          map.put("endDate", endDate);
        }
        if(StringUtil.isNotEmpty(searchKey)){
          map.put("searchKey", searchKey);
        }
        if(StringUtil.isNotEmpty(isBook)){
          map.put("isBook", isBook);
        }
        if(StringUtil.isNotEmpty(interviewStatus)){
          map.put("interviewStatus", interviewStatus);
        }
        map.put("begin", page.getPageSize()*(page.getPageIndex()));
        map.put("end", page.getPageSize()*(page.getPageIndex()+1));
        map.put("sortField", page.getSortField());
        map.put("sortOrder", page.getSortOrder());
        map.put("workCode", sysUser.getWorkCode());
        map.put("userId", sysUser.getId());
        
        MiniRtn2Grid<InterviewBookListVo> minirtn2Grid = candidateService.queryCandidateListByPage(map);
        logger.info("data:" + minirtn2Grid.getData() + "total:"
                + minirtn2Grid.getTotal());
        return minirtn2Grid;
    }
    
    /**
     * 面试---取消
     * @param request
     * @return
     */
    @RequestMapping("cancelInterviewBook")
    @ResponseBody
    public Map<String,Object> cancelInterviewBook(HttpServletRequest request) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
      try{
        String ids  = request.getParameter("ids");
        String reason = request.getParameter("reason");
        String isSend = request.getParameter("isSend");
        String[] interviewBookIds = ids.split(",");
       
        InterviewBook interviewBook = null ;
        

        
          for(String item : interviewBookIds){
            interviewBook = new InterviewBook();
            interviewBook = interviewBookService.getByPrimaryKey(item);
            interviewBook.setReason(reason);
            interviewBook.setInterviewStatus("1");
            interviewBookService.updateSelective(interviewBook);
            if(isSend.equals("1")){
              sendEmail(interviewBook, "interviewers.cancel.email.templateId");
            }
          }
          sb.append("取消成功");
          if(isSend.equals("1")){
            sb.append("，发送邮件成功");
          }
          
          map.put("code", 200);
        
      }catch(Exception e){
        logger.error(e.getMessage(), e);
        sb.append("网络异常");
        map.put("code", 400);
      }finally{
        map.put("msg", sb.toString());
      }
     
      return map ;
    }
    
    
    /**
     * 面试---验证
     * @param request
     * @return
     */
    @RequestMapping("isDraftInterview")
    @ResponseBody
    public Map<String,Object> isDraftInterview(HttpServletRequest request,@CurrentUser SysUser sysUser) {
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
        param.put("isBook", "2");
        if(sysUser != null){
          param.put("workCode", sysUser.getWorkCode());
        }
        List<InterviewBookCandidateVo> list = candidateMapper.queryCandidateListByPage(param);
        if(list != null && list.size() > 0){
          map.put("code", 200);
        }else{
          map.put("code", 404);
        }
      }catch(Exception e){
        logger.error(e.getMessage(), e);
        sb.append("网络异常");
        map.put("code", 400);
      }finally{
        map.put("msg", sb.toString());
      }
     
      return map ;
    }
    
    
    /**
     * 面试---淘汰
     * @param request
     * @return
     */
    @RequestMapping("outInterviewBook")
    @ResponseBody
    public Map<String,Object> outInterviewBook(@CurrentUser SysUser sysUer, HttpServletRequest request) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
      try{
        String ids  = request.getParameter("ids");
        String positionIds  = request.getParameter("positionIds");
        String reason = request.getParameter("reason"); 
        String isSend = request.getParameter("isSend"); 
        String[] candidateIds = ids.split(",");
        String[] positionIdsStr = positionIds.split(",");
        
        List<InterviewBook> list = null ;
        Map<String,Object> param = null ;
        Map<String,Object> cpparam = null ;
        List<String> cpList = new ArrayList<String>();
        List<String> idList = new ArrayList<String>();
        
        if(candidateIds.length > 0){
          StringBuffer candidateIdSb = new StringBuffer();
          
          for(int i = 0 ; i < candidateIds.length ; i++){
            param = new HashMap<String,Object>();
            if(i != candidateIds.length-1){
              candidateIdSb.append("'"+candidateIds[i]+"',");
            }else{
              candidateIdSb.append("'"+candidateIds[i]+"'");
            }
            
            param.put("candidateId", candidateIds[i]);
            param.put("positionId", positionIdsStr[i]);
            
            param.put("status", 1);
            list = interviewBookService.selectInterviewBookListByMap(param);
            //收集面试安排ID
            if(list != null && list.size() > 0){
              for(InterviewBook ib : list){
                idList.add(ib.getId());
              }
            }
            
            //收集候选人岗位ID
            CandidatePost  candidatePost = candidateService.selectCandidatePostByMap(param);
            if(candidatePost != null){
              cpList.add(candidatePost.getId());
            }
            
            OperateHistory operateHistory = new OperateHistory();
            
            operateHistory.setId(UUID.randomUUID().toString().replace("-", ""));
            operateHistory.setOperatorUser(sysUer.getId());
            operateHistory.setOperatorType("候选人淘汰");
            
            operateHistory.setOperatorContent(candidateIds[i]+"已被淘汰");
            operateHistory.setRelatedId(candidateIds[i]);
            operateHistory.setOperatorTime(DataUtils.gettimestamp());
            operateHistoryService.create(operateHistory);
            /**
             * 发邮件
             */
            if(list != null && list.size() > 0 && isSend.equals("1")){
              for(InterviewBook ib : list){
                sendEmail(ib, "interviewers.out.email.templateId");
              }
            }
          }
        //批量淘汰面试
          if(idList != null && idList.size() > 0){
            param.put("interviewStatus", "2");
            param.put("reason", reason);
            param.put("list", idList);
            interviewBookService.batchUpdateInterviewBook(param);
          }
         
          
          //批量淘汰候选人岗位
          if(cpList !=null && cpList.size()>0){
            cpparam = new HashMap<String,Object>();
            cpparam.put("interviewStatus", "20");
            cpparam.put("operatorDate", DataUtils.gettimestamp());
            cpparam.put("list", cpList);
            candidateService.batchOutCpByMap(cpparam);
          }
          
          //批量解锁候选人
         
          candidateService.unlockCandidate(candidateIdSb.toString(), sysUer.getId());
        }
          sb.append("淘汰成功，发送邮件成功");
          if(isSend.equals("1")){
            sb.append("，发送邮件成功");
          }
          map.put("code", 200);
        
      }catch(Exception e){
        logger.error(e.getMessage(), e);
        sb.append("网络异常");
        map.put("code", 400);
      }finally{
        map.put("msg", sb.toString());
      }
     
      return map ;
    }
    
    private void sendEmail(InterviewBook interviewBook , String modelId){
      
      /**
       * 发邮件给面试官
       */
      String interviewers = interviewBook.getInterviewers();
      if(StringUtil.isEmpty(interviewers)){
        return  ;
      }
      String[] interviewersArray = interviewers.split(",");
      StringBuffer sb = new StringBuffer();
      for(String str : interviewersArray){
        
        BaseUser baseuser = new BaseUser();
        baseuser = baseUserService.getBaseUserByPrimaryKey(str);
        sb.append(baseuser.getEmail()+";");
      }
      InterviewEmailTemplate interviewEmailTemplate = new InterviewEmailTemplate();
      interviewEmailTemplate.setAddress(interviewBook.getInterviewAddress());
      interviewEmailTemplate.setInterviewtime(DateKit.dateToStr(interviewBook.getInterviewDate()) + " " + interviewBook.getInterviewBTime() + "~" + interviewBook.getInterviewETime());
      interviewEmailTemplate.setInterviewee(interviewBook.getCandidateName());
      interviewEmailTemplate.setReason(interviewBook.getReason());
      Template interviewersTemplate = new Template();
      interviewersTemplate = templateService.getByPrimaryKey(springPropertyResourceReader.getProperty(modelId));
    
    mailSendService.sendEmail(sb.toString(), interviewersTemplate, interviewEmailTemplate);
    }
    
    @RequestMapping("InterviewBookVoDraftSave")
    @ResponseBody
    public Map<String,Object> InterviewBookVoDraftSave(@CurrentUser SysUser sysUser, InterviewBookVo interviewBookVo) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            
          String flag = interviewBookService.saveOrUpdate(sysUser,interviewBookVo);
          candidateService.lockCandidate(interviewBookVo.getInterviewee(), sysUser.getId());
          if(StringUtil.isNotEmpty(flag)){
            sb.append("保存成功");
            map.put("id", flag);
            map.put("status", 200);
          }else{
            sb.append("保存失败,工号不存在");
            map.put("status", 400);
            return map ;
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
    
    // 取消面试
    @RequestMapping("outInterview/{ids}")
    public ModelAndView outCandidate(@PathVariable String ids, HttpServletRequest request) {
      
      request.setAttribute("ids", ids);
      return new ModelAndView("com/csot/flow/interview/outInterview");

    }
      
    
    
}