package com.csot.recruit.soa;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrvResponse;

public class ImportRecruitDemandSendToOA {

  @Resource
  private SpringPropertyResourceReader springPropertyResourceReader;

  /**
   * OA发布招聘需求
   * 
   * @param recruitDemand 招聘需求
   * @param applyAccount 操作人工号
   */
  public void importEmploySendToOA(RecruitDemand recruitDemand, String applyAccount) {
    SoaObject soaObject = new SoaObject("RST", "华星招聘系统", "inportRecruitDemand", "招聘需求申请");
    String uid = UUID.randomUUID().toString().replace("-", "");
    soaObject.setPrikey(uid);
    soaObject.setDoccontent("RST发起招聘需求申请流程");
    soaObject.setFormvalues(getFlowValuesByDemand(recruitDemand));
    soaObject.setApplyAccount(applyAccount);
    soaObject.setDocsubject("招聘需求：" + recruitDemand.getId());
    soaObject.setFdtemplateid(Constant.FD_TEMPLATE_RECRUIT_DEMAND_ID_TEST);
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
  private Map<String, Object> getFlowValuesByDemand(RecruitDemand recruitDemand) {
    Map<String, Object> flowValues = new HashMap<String, Object>();
    flowValues.put("fd_demand_id", recruitDemand.getId()); // 招聘需求主键id
    flowValues.put("fd_apply_dept_code", recruitDemand.getApplyOrganizationId()); // 申请部门id
    flowValues.put("fd_apply_dept_name", recruitDemand.getApplyOrganizationName()); // 申请部门名称
    flowValues.put("fd_centre", getCentre(recruitDemand.getApplyOrganizationName())); // 申部门所属中心
    flowValues.put("fd_apply_post", recruitDemand.getApplyPostId()); // 申请岗位名称
    flowValues.put("fd_emp_category", recruitDemand.getEmployeeType()); // 员工类别
    flowValues.put("fd_zp_category", recruitDemand.getRecruitDemandReason()); // 招聘需求原因
    flowValues.put("fd_person", recruitDemand.getDimissionChangePerson() == null ? ""
        : recruitDemand.getDimissionChangePerson()); // 离职转调人 (非必填)
    flowValues.put("fd_job_level", recruitDemand.getRankId()); // 职级
    flowValues.put("fd_apply_num", recruitDemand.getApplyPersonNumber()); // 申请人数
    flowValues.put("fd_apply_date", recruitDemand.getApplyDate()); // 申请日期
    flowValues.put("fd_expected_date", recruitDemand.getPredictComeDate()); // 预计到岗日期
    flowValues.put("fd_work_date", recruitDemand.getWantComeDate()); // 期望到岗日期
    flowValues.put("fd_is_abroad", recruitDemand.getDistrict()); // 境内境外
    flowValues.put("fd_work_description", recruitDemand.getWorkRemark()); // 岗位工作描述
    flowValues.put("fd_gender", recruitDemand.getGender()); // 性别
    flowValues.put("fd_education", recruitDemand.getEducation()); // 学历
    flowValues.put("fd_profession", recruitDemand.getProfession()); // 专业
    flowValues.put("fd_work_experience", recruitDemand.getWorkExperience()); // 工作经验
    flowValues.put("fd_necessary_skill", recruitDemand.getRequiredSkill()); // 必备技能
    flowValues.put("fd_necessary_ability", recruitDemand.getAbilityDemanded()); // 素质及能力要求
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
