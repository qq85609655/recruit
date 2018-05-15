package com.csot.recruit.soa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.employ.EmployCandidate;
import com.csot.recruit.model.original.flow.employ.EmployDemand;
import com.csot.recruit.model.original.flow.employ.EmployEducation;
import com.csot.recruit.model.original.flow.employ.EmployVo;
import com.csot.recruit.model.original.flow.employ.EmployWork;
import com.csot.recruit.model.original.resumelibrary.source.ResumeSource;
import com.csot.recruit.service.resumelibrary.source.ResumeSourceService;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrvResponse;
import com.google.gson.Gson;

public class ImportEmploySendToOA {

  @Resource
  private SpringPropertyResourceReader springPropertyResourceReader;
  @Resource private ResumeSourceService resumeSourceService;
  /**
   * OA发布录用单
   * 
   * @param employVo 录用单
   * @param applyAccount 操作人工号
   */
  public void importEmploySendToOA(EmployVo employVo, String applyAccount) {
    SoaObject soaObject = new SoaObject("RST", "华星招聘系统", "inportEmploy", "录用申请");
    String uid = UUID.randomUUID().toString().replace("-", "");
    soaObject.setPrikey(uid);
    soaObject.setDoccontent("RST发起录用申请流程");
    soaObject.setFormvalues(getFlowValuesByDemand(employVo));
    soaObject.setApplyAccount(applyAccount);
    soaObject.setDocsubject("录用：" + employVo.getEmploy().getId());
    soaObject.setFdtemplateid(Constant.FD_TEMPLATE_EMPLOY_ID_TEST);
    ESBOAOAImportStandardProcessSrvResponse res = SendToOAUtil.invokeOpenPoOaSignProcess(soaObject);
    if ("FALSE".equals(res.getSERVICEFLAG())) {
      throw new RuntimeException(res.getSERVICEMESSAGE());
    }
  }


  /**
   * 根据招聘对象封装传递给OA的格式化数据
   * 
   * @param recruitDemand 招聘需求对象
   * @return
   */
  private Map<String, Object> getFlowValuesByDemand(EmployVo employVo) {
   
    Employ employ = employVo.getEmploy(); // 录用主体信息
    EmployDemand demand = employVo.getDemand(); // 招聘需求
    EmployCandidate candidate = employVo.getCandidate(); // 候选人
    Map<String, Object> flowValues = new HashMap<String, Object>();
    ResumeSource resumeSource = resumeSourceService.getByPrimaryKey(candidate.getRecruitSource());
    // 主信息
    flowValues.put("fd_employ_id", employ.getId()); // 招聘系统录用ID
    // 招聘需求申请单信息
    flowValues.put("fd_apply_no", employ.getDemandId()); // 招聘申请单号
    flowValues.put("fd_apply_category", demand.getEmployeeType()); // 员工类别
    flowValues.put("fd_is_abroad", demand.getDistrict()); // 境内境外
    flowValues.put("fd_apply_department", demand.getApplyOrganizationId()); // 部门code
    flowValues.put("fd_apply_department_name", demand.getApplyOrganizationName());// 部门名称
    flowValues.put("fd_centre", getCentre(demand.getApplyOrganizationName())); // 所属中心
    flowValues.put("fd_apply_post", demand.getApplyPostId()); // 申请岗位code
    flowValues.put("fd_job_level", demand.getRankId()); // 职级
    flowValues.put("fd_zp_category", demand.getRecruitDemandReason()); // 招聘需求原因
    // 应聘申请表
    flowValues.put("fd_App_code", employ.getCandidateId()); // 应聘申请单号
    flowValues.put("fd_emp_name", candidate.getName()); // 候选人姓名
    flowValues.put("fd_emp_gender", candidate.getGender()); // 候选人性别
    flowValues.put("fd_emp_birthday", candidate.getBirthday()); // 候选人出生年月
    flowValues.put("fd_emp_telphone", candidate.getPhone()); // 候选人电话
    flowValues.put("fd_emp_email", candidate.getEmail()); // 候选人邮箱
    flowValues.put("fd_emp_category", candidate.getCandidateType()); // 候选人类别
    flowValues.put("fd_emp_department", candidate.getCandidateOrgId()); // 候选人部门
    flowValues.put("fd_emp_post", candidate.getCandidatePostName()); // 候选人岗位名称
    flowValues.put("fd_post_no", candidate.getCandidatePostId()); // 岗位代码
    flowValues.put("fd_emp_level", candidate.getEmployRankId()); // 候选人职级
    flowValues.put("fd_emp_grade", candidate.getGrade()); // 候选人职等
    flowValues.put("fd_emp_abroad", candidate.getAbroad()); // 是否境内
    flowValues.put("fd_hire_from", resumeSource.getSourceName()); // 招聘来源
    flowValues.put("fd_recommended_no", candidate.getReferrerId()); // 推荐人工号
    flowValues.put("fd_recommended_info", candidate.getReferrerName()); // 推荐人姓名&部门
    flowValues.put("fd_is_background", candidate.getIsBeidiao()); // 是否背调
    flowValues.put("fd_is_test", candidate.getIsEvaluating()); // 是否测评
    flowValues.put("fd_possible_entry_date", employ.getSimulationEntryDate()); // 拟入职时间
    // 其他
    List<EmployEducation> employEducations = employVo.getEmployEducations(); // 教育经历
    List<EmployWork> employWorks = employVo.getEmployWorks(); // 工作经历
    List<Attachment> attachments = employVo.getAttachments(); // 附件列表
    List<String> attachmentsVo = new ArrayList<String>();
    for (Attachment attachment : attachments) {
      attachmentsVo.add(attachment.getSaveName() + "@@@" + attachment.getSavePath());
    }
    flowValues.put("fd_emp_attach", (attachmentsVo == null || attachmentsVo.size() <= 0) ? ""
        : StringUtil.joinString(attachmentsVo, "###")); // 候选人附件
    // 教育经历
    List<Map<String, String>> employEducationList = new ArrayList<Map<String, String>>();
    for (EmployEducation item : employEducations) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("fd_edu_starttime", item.getStartDate());
      map.put("fd_edu_endtime", item.getEndDate());
      map.put("fd_graduate_school", item.getSchool());
      map.put("fd_profession", item.getMajor());
      map.put("fd_educaiton", item.getEducation());
      map.put("fd_property", item.getEducationType());
      employEducationList.add(map);
    }
    flowValues.put("fd_emp_education_experience", employEducationList);
    // 工作经历
    List<Map<String, String>> employWorksList = new ArrayList<Map<String, String>>();
    for (EmployWork item : employWorks) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("fd_work_starttime", item.getStartDate());
      map.put("fd_work_endtime", item.getEndDate());
      map.put("fd_work_company", item.getCompany());
      map.put("fd_work_post", item.getPost());
      employWorksList.add(map);
    }
    flowValues.put("fd_emp_work_experience", employWorksList);
    return flowValues;
  }

  /**
   * 获取所属中心标识
   * 
   * @param applyOrganizationName 部门全称
   * @return
   */
  private int getCentre(String applyOrganizationName) {
    if (applyOrganizationName.indexOf("研发中心") > 0) {
      return 1;
    } else if (applyOrganizationName.indexOf("制造中心") > 0) {
      return 2;
    } else {
      return 3;
    }
  }
}
