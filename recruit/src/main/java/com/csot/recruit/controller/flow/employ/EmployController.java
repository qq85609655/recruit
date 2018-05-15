package com.csot.recruit.controller.flow.employ;

import java.text.SimpleDateFormat;
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
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.employ.EmployCandidate;
import com.csot.recruit.model.original.flow.employ.EmployDemand;
import com.csot.recruit.model.original.flow.employ.EmployEducation;
import com.csot.recruit.model.original.flow.employ.EmployRefuseOffer;
import com.csot.recruit.model.original.flow.employ.EmployWork;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.service.attachment.AttachmentService;
import com.csot.recruit.service.candidate.CandidateService;
import com.csot.recruit.service.flow.employ.EmployARalationService;
import com.csot.recruit.service.flow.employ.EmployCandidateService;
import com.csot.recruit.service.flow.employ.EmployDemandService;
import com.csot.recruit.service.flow.employ.EmployEducationService;
import com.csot.recruit.service.flow.employ.EmployRefuseOfferService;
import com.csot.recruit.service.flow.employ.EmployService;
import com.csot.recruit.service.flow.employ.EmployWorkService;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.resume.EducationExperienceService;
import com.csot.recruit.service.resume.WorkExperienceService;
import com.csot.recruit.service.template.TemplateService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("employ")
public class EmployController {
  private static final Logger logger = LoggerFactory.getLogger(EmployController.class);
  @Resource
  private WorkExperienceService workExperienceService;
  @Resource
  private EducationExperienceService educationExperienceService;
  @Resource
  private EmployService employService;
  @Resource
  private EmployCandidateService employCandidateService;
  @Resource
  private EmployDemandService employDemandService;
  @Resource
  private RecruitDemandService recruitDemandService;
  @Resource
  private EmployEducationService employEducationService;
  @Resource
  private EmployARalationService employARalationService;
  @Resource
  private EmployWorkService employWorkService;
  @Resource
  private EmployRefuseOfferService employRefuseOfferService;
  @Resource
  private TemplateService templateService;
  @Resource
  private MailSendService mailSendService;
  @Resource
  private AttachmentService AttachmentService;
  @Resource
  private CandidateService candidateService;

  private static final GsonBuilder gsonBuilder = new GsonBuilder();
  private static final Gson gson;
  static {
    gson = gsonBuilder.setDateFormat("yyyy-MM-dd").create();
  }

  // 自定义发送邮件
  @RequestMapping("sendEmailToStuByDef")
  @ResponseBody
  public AjaxRtnJson sendEmailToStuByDef(Template template, HttpServletRequest request) {

    // 获取前端传过来的参数
    String candidateId = request.getParameter("candidateId");
    Candidate candidate = candidateService.getByPrimaryKey(candidateId); // 获取候选人信息
    try {
      mailSendService.sendEmail(candidate.getEmail(), template, candidate);
      return new AjaxRtnJson(true, "发送成功");
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  // 自定义发送邮件
  @RequestMapping("sendByDefinition")
  public ModelAndView sendByDefinition(@CurrentUser SysUser sysUser, HttpServletRequest request) {
    String candidateId = request.getParameter("candidateId");
    List<Attachment> attachments = new ArrayList<Attachment>();
    String templateId = "098865eee9ed42afa11452116e129b15"; // 默认邮件模板
    Template template = null;
    template = templateService.getByPrimaryKey(templateId);
    // 查询出关联的附件
    attachments = AttachmentService.findAttachsByRelateId(templateId);
    Candidate candidate = candidateService.getCandidateByPrimaryKey(candidateId); // 获取候选人信息
    String realName = candidate.getName();
    request.setAttribute("realName", realName);
    request.setAttribute("candidateId", candidateId);
    request.setAttribute("template", template);
    request.setAttribute("attachments", attachments);
    return new ModelAndView("com/csot/flow/employ/emailSend");

  }

  /**
   * 进入拒绝offer页面
   * 
   * @return
   */
  @RequestMapping("refuseOffer/{id}")
  public ModelAndView refuseOffer(@PathVariable String id, HttpServletRequest request) {
    Employ employ = employService.getByPrimaryKey(id);
    EmployRefuseOffer employRefuseOffer = employRefuseOfferService.getByEmployeId(employ.getId());
    request.setAttribute("employ", employ);
    request.setAttribute("employRefuseOffer", employRefuseOffer);
    return new ModelAndView("com/csot/flow/employ/doRefuseOffer");
  }

  /**
   * 进入放弃入职页面
   * 
   * @return
   */
  @RequestMapping("refuseEntry/{id}")
  public ModelAndView refuseEntry(@PathVariable String id, HttpServletRequest request) {
    Employ employ = employService.getByPrimaryKey(id);
    EmployRefuseOffer employRefuseOffer = employRefuseOfferService.getByEmployeId(employ.getId());
    request.setAttribute("employ", employ);
    request.setAttribute("employRefuseOffer", employRefuseOffer);
    return new ModelAndView("com/csot/flow/employ/doRefuseEntry");
  }



  /**
   * 编辑录用信息
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    Employ employ = employService.getByPrimaryKey(id);
    EmployCandidate employCandidate = employCandidateService.getByEmploy(employ.getId());
    EmployDemand employDemand = employDemandService.getByEmploy(employ.getId());
    // 工作经历和教育经历
    List<EmployEducation> employEducations = employEducationService.getByEmploy(employ.getId());
    List<EmployWork> employWorks = employWorkService.getByEmploy(employ.getId());
    request.setAttribute("employ", employ);
    request.setAttribute("employCandidate", employCandidate);
    request.setAttribute("employDemand", employDemand);
    request.setAttribute("employEducations", employEducations);
    request.setAttribute("employWorks", employWorks);
    request.setAttribute("employEducationsSize",
        employEducations == null ? 0 : employEducations.size());
    request.setAttribute("employWorksSize", employWorks == null ? 0 : employWorks.size());
    // 附件
    List<Attachment> attachments = employARalationService.getListByEmployeId(employ.getId());
    request.setAttribute("attachments", attachments);
    if (Employ.flowState.UNCOMMITTED.valueStr().equals(employ.getFlowState())) {
      return new ModelAndView("com/csot/flow/employ/employEdit");
    }
    return new ModelAndView("com/csot/flow/employ/employView");
  }

  /**
   * 已经提交只能查看数据
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    Employ employ = employService.getByPrimaryKey(id);
    request.setAttribute("employ", employ);
    return new ModelAndView("com/csot/recruit/flow/employ/employView");
  }

  /**
   * 删除录用信息（只能删除草稿状态）
   * 
   * @param ids
   * @return
   */
  @RequestMapping("remove/{ids}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String ids) {
    try {
      return employService.remove(ids);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 发offer操作
   * 
   * @param ids
   * @return
   */
  @RequestMapping("sentOffer/{ids}")
  @ResponseBody
  public AjaxRtnJson sentOffer(@PathVariable String ids) {
    try {
      return employService.saveOffer(ids);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 入职操作
   * 
   * @param ids
   * @return
   */
  @RequestMapping("doentry/{ids}")
  @ResponseBody
  public AjaxRtnJson doentry(@PathVariable String ids) {
    try {
      return employService.entry(ids);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }


  // 保存录用详细信息
  @RequestMapping("saveEmployInfo")
  @ResponseBody
  public AjaxRtnJson saveEmployInfo(EmployCandidate employCandidate, HttpServletRequest request,
      @CurrentUser SysUser sysUser) {
    String demandId = request.getParameter("demandId"); // 招聘需求id
    String employId = request.getParameter("employId"); // 录用id
    String employmentForm = request.getParameter("employmentForm"); // 录用申请表单号
    String simulationEntryDate = request.getParameter("simulationEntryDate"); // 拟入职时间
    String attchmentIds = request.getParameter("attchmentIds"); // 拟入职时间
    Employ employ = employService.getByPrimaryKey(employId);// 录用主体信息
    RecruitDemand recruitDemand = recruitDemandService.getByDemandId(demandId, sysUser);
    // 教育经历
    String jiaoyu = request.getParameter("jiaoyu");
    List<EmployEducation> edus =
        gson.fromJson(jiaoyu, new TypeToken<List<EmployEducation>>() {}.getType());
    // 工作经历
    String work = request.getParameter("work");
    List<EmployWork> works = gson.fromJson(work, new TypeToken<List<EmployWork>>() {}.getType());
    String typeStr = request.getParameter("typeStr"); // 获取提交类型（暂存/提交/提交之后的修改）
    if (typeStr.equals("ZC")) {
      employ.setFlowState(Employ.flowState.UNCOMMITTED.valueStr()); // 暂存操作 未提交状态
    } else if (typeStr.equals("TJ")) {
      employ.setFlowState(Employ.flowState.AUDIT.valueStr()); // 提交操作 审核中状态
    }
    if (StringUtils.hasText(employCandidate.getId())) {
      try {
        // 设置录用主体信息
        employ.setEmploymentForm(employmentForm);
        employ.setSimulationEntryDate(simulationEntryDate);
        employ.setUpdateDate(new Date());
        employ.setModifiedId(sysUser.getId());
        employService.updateEmployInfo(employCandidate, employ, recruitDemand, works, edus,
            attchmentIds, sysUser);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        // 设置录用主体信息
        employ.setEmploymentForm(employmentForm);
        employ.setDemandId(recruitDemand.getDemandId());
        employ.setSimulationEntryDate(simulationEntryDate);
        employ.setUpdateDate(new Date());
        employService.saveEmployInfo(employCandidate, employ, recruitDemand, works, edus,
            attchmentIds, sysUser);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 新增录用记录
   * 
   * @param employ
   * @return
   */
  @RequestMapping("saveEmploy")
  @ResponseBody
  public AjaxRtnJson addEmploy(Employ employ, @CurrentUser SysUser sysUser) {
    if (StringUtils.hasText(employ.getId())) {
      try {
        employService.updateSelective(employ);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        String employId = UUID.randomUUID().toString().replace("-", "");
        employ.setId(employId);
        employ.setCreateDate(new Date());
        employ.setCreatorId(sysUser.getId());
        return employService.create(employ);
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 列入黑名单
   * 
   * @param employ
   * @return
   */
  @RequestMapping("isBlackList")
  @ResponseBody
  public AjaxRtnJson isBlackList(Employ employ, @CurrentUser SysUser sysUser) {
    try {
      return employService.isBlackList(employ);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
    }
  }

  /**
   * 新增录用记录
   * 
   * @param employ
   * @return
   */
  @RequestMapping("getEduAndWorkBy")
  @ResponseBody
  public Map<String, Object> getEduAndWorkBy(HttpServletRequest request) {
    String personCode = request.getParameter("personCode");
    Map<String, Object> map = new HashMap<String, Object>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // 教育经历
    List<EducationExperience> edus = educationExperienceService.queryByResumeId(personCode);
    List<EmployEducation> educations = new ArrayList<EmployEducation>();
    for (EducationExperience educationExperience : edus) {
      EmployEducation education = new EmployEducation();
      education.setStartDate(dateFormat.format(educationExperience.getEduStartDate()));
      education.setEndDate(dateFormat.format(educationExperience.getEduEndDate()));
      education.setSchool(educationExperience.getSchoolName());
      education.setMajor(educationExperience.getMajor());
      education.setEducationType(educationExperience.getEduType());
      education.setEducation(educationExperience.getEducation());
      educations.add(education);
    }
    map.put("edus", educations);
    // 工作经历
    List<WorkExperience> works = workExperienceService.queryByResumeId(personCode);
    List<EmployWork> employWorks = new ArrayList<EmployWork>();
    for (WorkExperience workExperience : works) {
      EmployWork employWork = new EmployWork();
      employWork.setStartDate(dateFormat.format(workExperience.getJobStartDate()));
      employWork.setEndDate(dateFormat.format(workExperience.getJobEndDate()));
      employWork.setCompany(workExperience.getCompanyName());
      employWork.setPost(workExperience.getPositionName());
      employWorks.add(employWork);
    }
    map.put("works", employWorks);
    return map;

  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(Employ employ) {
    if (StringUtils.hasText(employ.getId())) {
      try {
        employService.updateSelective(employ);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        employ.setId(UUID.randomUUID().toString().replace("-", ""));
        employService.create(employ);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 选择招聘需求
   * 
   * @return
   */
  @RequestMapping("choseDemand")
  public ModelAndView share() {
    return new ModelAndView("com/csot/flow/employ/demandChose");
  }

  /**
   * 选择应聘申请单
   * 
   * @return
   */
  @RequestMapping("choseInterview")
  public ModelAndView choseInterview() {
    return new ModelAndView("com/csot/flow/employ/interviewChose");
  }


  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/flow/employ/employList");
  }

  @RequestMapping("offerList")
  public ModelAndView offerList() {
    return new ModelAndView("com/csot/flow/employ/employOfferList");
  }

  @RequestMapping("refuseOfferList")
  public ModelAndView refuseOfferList() {
    return new ModelAndView("com/csot/flow/employ/employRefuseOfferList");
  }

  @RequestMapping("entryList")
  public ModelAndView entryList() {
    return new ModelAndView("com/csot/flow/employ/employEntryList");
  }

  @RequestMapping("refuseEntryList")
  public ModelAndView refuseEntryList() {
    return new ModelAndView("com/csot/flow/employ/refuseEntryList");
  }


  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<Employ> datagrid(MiniGridPageSort pageSort, HttpServletRequest request,@CurrentUser SysUser sysUser) {
    String candidateName = request.getParameter("candidateName");
    String stage = request.getParameter("stage");
    String postName = request.getParameter("postName");
    Map<String, String> col = new HashMap<String, String>();
    col.put("candidateName", candidateName);
    col.put("postName", postName);
    col.put("stage", stage);
    col.put("userId", sysUser.getId());
    return employService.getGrid(pageSort, col);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/employ/employEdit");
  }
}