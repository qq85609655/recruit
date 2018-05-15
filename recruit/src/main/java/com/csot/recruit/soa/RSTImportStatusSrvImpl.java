package com.csot.recruit.soa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.interview.Estimate;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandVo;
import com.csot.recruit.service.flow.employ.EmployService;
import com.csot.recruit.service.flow.interview.EstimateService;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandService;
import com.csot.recruit.soa.status.ESBESBESBImportProcessStatusSrv;
import com.csot.recruit.soa.status.ESBESBESBImportProcessStatusSrvInputCollection;
import com.csot.recruit.soa.status.ESBESBESBImportProcessStatusSrvInputItem;
import com.csot.recruit.soa.status.ESBESBESBImportProcessStatusSrvRequest;
import com.csot.recruit.soa.status.ESBESBESBImportProcessStatusSrvResponse;
import com.csot.recruit.soa.status.ErrorCollection;
import com.csot.recruit.soa.status.ErrorItem;
import com.csot.recruit.soa.status.ResponseCollection;
import com.google.common.base.Throwables;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * OA回传统一接口
 */
@javax.jws.WebService(
    serviceName = "ESB_ESB_ESB_ImportProcessStatusSrv.serviceagent",
    portName = "ESB_ESB_ESB_ImportProcessStatusSrv",
    targetNamespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportProcessStatusSrv/1.0",
    wsdlLocation = "/WEB-INF/wsdl/ESB_ESB_ESB_ImportProcessStatusSrv/ESB_ESB_ESB_ImportProcessStatusSrv.wsdl",
    endpointInterface = "com.csot.recruit.soa.status.ESBESBESBImportProcessStatusSrv")
public class RSTImportStatusSrvImpl implements ESBESBESBImportProcessStatusSrv {

  @Resource
  private RecruitDemandService demandService;
  @Resource
  private EmployService employService;
  @Resource
  private EstimateService estimateService;

  private static final Logger logger = LoggerFactory.getLogger(RSTImportStatusSrvImpl.class);
  private SimpleDateFormat flowDate = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public ESBESBESBImportProcessStatusSrvResponse process(
      ESBESBESBImportProcessStatusSrvRequest payload) {
    ESBESBESBImportProcessStatusSrvResponse returnResponse =
        new ESBESBESBImportProcessStatusSrvResponse();
    ResponseCollection responseCollection = new ResponseCollection();
    ErrorCollection errorCollection = new ErrorCollection();
    ESBESBESBImportProcessStatusSrvInputCollection inputCollection =
        payload.getESBESBESBImportProcessStatusSrvInputCollection();
    List<ESBESBESBImportProcessStatusSrvInputItem> inputItems =
        inputCollection.getESBESBESBImportProcessStatusSrvInputItem();
    List<ErrorItem> errorItemList = errorCollection.getErrorItem();

    try {
      if (inputItems.size() != 0) {
        ESBESBESBImportProcessStatusSrvInputItem inputItem = inputItems.get(0);
        String formValues = inputItem.getFORMVALUES();
        JsonObject formValuesJson = new JsonParser().parse(formValues).getAsJsonObject();
        JsonElement fd_template_id_Josn = formValuesJson.get("fd_template_id");
        if (validataCommon(inputItem, errorItemList)) {
          String fd_template_id = fd_template_id_Josn.getAsString();
          if (Constant.OA_BACK_IMPORT_DEMAND.equals(fd_template_id)) {// 招聘需求回传
            if (validataDemand(inputItem, errorItemList)) {
              doDemand(inputItem, formValuesJson, errorItemList);
            }
          } else if (Constant.OA_BACK_IMPORT_EMPLOY.equalsIgnoreCase(fd_template_id)) {// 录用回传
            if (validataEmploy(inputItem, errorItemList)) {
              doEmploy(inputItem, formValuesJson, errorItemList);
            }
          } else {
            ErrorItem e = new ErrorItem();
            e.setENTITYNAME("formvalues.fd_template_id");
            e.setERRORMESSAGE("无法解析接口模板fd_template_id字段");
            errorItemList.add(e);
          }
        }
      }
      returnResponse.setResponseCollection(responseCollection);
      returnResponse.setErrorCollection(errorCollection);
      returnResponse.setSERVICEFLAG(errorItemList.isEmpty() ? "TRUE" : "FALSE");
      returnResponse.setSERVICEMESSAGE(errorItemList.isEmpty() ? "成功" : "失败");
      return returnResponse;
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      throw Throwables.propagate(ex);
    }

  }

  /**
   * 录用回传处理
   * 
   * @param inputItem
   * @param formValuesJson
   * @param errorItemList
   * @throws ParseException
   */
  private void doEmploy(ESBESBESBImportProcessStatusSrvInputItem inputItem,
      JsonObject formValuesJson, List<ErrorItem> errorItemList) throws Exception {
    String oaStatus = inputItem.getSTATUS(); // OA流程状态
    String fd_employ_id = formValuesJson.get("fd_employ_id").getAsString();
    String fd_entry_date = formValuesJson.get("fd_entry_date").getAsString();
    String fd_score = formValuesJson.get("fd_score").getAsString();
    Employ sysEmploy = employService.getByPrimaryKey(fd_employ_id);
    Employ employ = new Employ();
    employ.setId(fd_employ_id);
    employ.setEntryDateHide(fd_entry_date);
    if (oaStatus.equals(Constant.OA_FLOW_STATUS_APPLY)) {
      employ.setFlowState(Employ.flowState.APPROVE.valueStr()); // 审核通过
    } else {
      employ.setFlowState(Employ.flowState.DISCARD.valueStr()); // 废弃
    }
    employService.updateSelective(employ);

    // 面试评估表
    JsonObject fd_score_json = new JsonParser().parse(fd_score).getAsJsonObject();
    Estimate estimate = new Estimate();
    estimate.setId(UUID.randomUUID().toString().replace("-", ""));
    estimate.setCandidateId(sysEmploy.getCandidateId());
    estimate.setPositionId(sysEmploy.getEmployPostId());
    // 系统思考
    estimate.setSysThink(Short.valueOf(fd_score_json.get("fd_bm_1_zy") == null ? "0"
        : fd_score_json.get("fd_bm_1_zy").getAsString()));
    estimate.setHrSysThink(Short.valueOf(fd_score_json.get("fd_hr_1_zy") == null ? "0"
        : fd_score_json.get("fd_hr_1_zy").getAsString()));
    // 沟通协调
    estimate.setCommunicate(Short.valueOf(fd_score_json.get("fd_bm_2_zy") == null ? "0"
        : fd_score_json.get("fd_bm_2_zy").getAsString()));
    estimate.setHrCommunicate(Short.valueOf(fd_score_json.get("fd_hr_2_zy") == null ? "0"
        : fd_score_json.get("fd_hr_2_zy").getAsString()));
    // 学习能力
    estimate.setStudy(Short.valueOf(fd_score_json.get("fd_bm_3_zy") == null ? "0" : fd_score_json
        .get("fd_bm_3_zy").getAsString()));
    estimate.setHrStudy(Short.valueOf(fd_score_json.get("fd_hr_3_zy") == null ? "0" : fd_score_json
        .get("fd_hr_3_zy").getAsString()));
    // 团队合作
    estimate.setTeamWork(Short.valueOf(fd_score_json.get("fd_bm_4_zy") == null ? "0"
        : fd_score_json.get("fd_bm_4_zy").getAsString()));
    estimate.setHrTeamWork(Short.valueOf(fd_score_json.get("fd_hr_4_zy") == null ? "0"
        : fd_score_json.get("fd_hr_4_zy").getAsString()));
    // 创新扩展
    estimate.setInnovate(Short.valueOf(fd_score_json.get("fd_bm_5_zy") == null ? "0"
        : fd_score_json.get("fd_bm_5_zy").getAsString()));
    estimate.setHrInnovate(Short.valueOf(fd_score_json.get("fd_hr_5_zy") == null ? "0"
        : fd_score_json.get("fd_hr_5_zy").getAsString()));
    // 专业知识
    estimate.setMajorKnowledge(Short.valueOf(fd_score_json.get("fd_bm_6_zy") == null ? "0"
        : fd_score_json.get("fd_bm_6_zy").getAsString()));
    estimate.setHrMajorKnowledge(Short.valueOf(fd_score_json.get("fd_hr_6_zy") == null ? "0"
        : fd_score_json.get("fd_hr_6_zy").getAsString()));
    // 专业技能
    estimate.setMajorSkill(Short.valueOf(fd_score_json.get("fd_bm_7_zy") == null ? "0"
        : fd_score_json.get("fd_bm_7_zy").getAsString()));
    estimate.setHrMajorSkill(Short.valueOf(fd_score_json.get("fd_hr_7_zy") == null ? "0"
        : fd_score_json.get("fd_hr_7_zy").getAsString()));
    // 专业经验
    estimate.setMajorExp(Short.valueOf(fd_score_json.get("fd_bm_8_zy") == null ? "0"
        : fd_score_json.get("fd_bm_8_zy").getAsString()));
    estimate.setMajorExp(Short.valueOf(fd_score_json.get("fd_hr_8_zy") == null ? "0"
        : fd_score_json.get("fd_hr_8_zy").getAsString()));
    // 人与岗位匹配度
    estimate.setPositionMatch(Short.valueOf(fd_score_json.get("fd_bm_9_zy") == null ? "0"
        : fd_score_json.get("fd_bm_9_zy").getAsString()));
    estimate.setHrPositionMatch(Short.valueOf(fd_score_json.get("fd_hr_9_zy") == null ? "0"
        : fd_score_json.get("fd_hr_9_zy").getAsString()));
    // 人与组织匹配度
    estimate.setOrgMatch(Short.valueOf(fd_score_json.get("fd_bm_10_zy") == null ? "0"
        : fd_score_json.get("fd_bm_10_zy").getAsString()));
    estimate.setHrOrgMatch(Short.valueOf(fd_score_json.get("fd_hr_10_zy") == null ? "0"
        : fd_score_json.get("fd_hr_10_zy").getAsString()));
    // 合计总分
    estimate.setTotal(Short.valueOf(fd_score_json.get("fd_bm_sum_zy") == null ? "0" : fd_score_json
        .get("fd_bm_sum_zy").getAsString()));
    estimate.setHrTotal(Short.valueOf(fd_score_json.get("fd_hr_sum_zy") == null ? "0"
        : fd_score_json.get("fd_hr_sum_zy").getAsString()));
    // 评价结果
    estimate.setResult(fd_score_json.get("fd_bm_result_zy") == null ? "" : fd_score_json.get(
        "fd_bm_result_zy").getAsString());
    estimate.setHrResult(fd_score_json.get("fd_hr_result_zy") == null ? "" : fd_score_json.get(
        "fd_hr_result_zy").getAsString());
    // 总体评价
    estimate.setOrgComment(fd_score_json.get("fd_bm_judge_zy") == null ? "" : fd_score_json.get(
        "fd_bm_judge_zy").getAsString());
    estimate.setHrComment(fd_score_json.get("fd_hr_judge_zy") == null ? "" : fd_score_json.get(
        "fd_hr_judge_zy").getAsString());

    estimateService.create(estimate);
  }

  /**
   * 验证录用申请所需字段
   * 
   * @param inputItem
   * @param errorItemList
   * @return
   */
  private boolean validataEmploy(ESBESBESBImportProcessStatusSrvInputItem inputItem,
      List<ErrorItem> errorItemList) {
    String formValues = inputItem.getFORMVALUES();
    String oaStatus = inputItem.getSTATUS(); // OA流程状态
    JsonObject formValuesJson = new JsonParser().parse(formValues).getAsJsonObject();
    JsonElement fd_score = formValuesJson.get("fd_score");// 招聘代表工号
    JsonElement fd_entry_date = formValuesJson.get("fd_entry_date");// 入职时间
    JsonElement fd_employ_id = formValuesJson.get("fd_employ_id");// 系统录用id
    if (!Constant.OA_FLOW_STATUS_APPLY.equals(oaStatus)
        && !Constant.OA_FLOW_STATUS_REJECT.equals(oaStatus)) { // 审批中
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("ESBESBESBImportProcessStatusSrvInputItem.STATUS");
      e.setERRORMESSAGE("无法解析的OA流程状态");
      errorItemList.add(e);
      return false;
    }
    if (fd_employ_id == null || "".equals(fd_employ_id.getAsString())) {
      // 招聘需求系统录用id必须传递
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formValues.fd_employ_id");
      e.setERRORMESSAGE("招聘需求系统录用id必须传递");
      errorItemList.add(e);
      return false;
    }
    Employ sysEmploy = employService.getByPrimaryKey(fd_employ_id.getAsString());
    if (sysEmploy == null) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formvalues.fd_employ_id");
      e.setERRORMESSAGE("系统录用id不匹配");
      errorItemList.add(e);
      return false;
    }
    if (Employ.flowState.APPROVE.valueStr().equals(sysEmploy.getFlowState())
        || Employ.flowState.DISCARD.valueStr().equals(sysEmploy.getFlowState())) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formvalues.fd_employ_id");
      e.setERRORMESSAGE("招聘系统该条录用记录已经审批完成");
      errorItemList.add(e);
      return false;
    }
    if (fd_score == null || "".equals(fd_score.getAsString())) {
      // 应聘申请表分数必须传递
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formValues.fd_score");
      e.setERRORMESSAGE("应聘申请表分数必须传递");
      errorItemList.add(e);
      return false;
    } else {
      try {
        new JsonParser().parse(fd_score.getAsString()).getAsJsonObject();
      } catch (JsonSyntaxException e1) {
        ErrorItem e = new ErrorItem();
        e.setENTITYNAME("formvalues.fd_score");
        e.setERRORMESSAGE("fd_score格式错误无法解析");
        errorItemList.add(e);
        return false;
      }
    }
    if (fd_entry_date == null || "".equals(fd_entry_date.getAsString())) {
      // 入职时间必须传递
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formValues.fd_entry_date");
      e.setERRORMESSAGE("入职时间必须传递");
      errorItemList.add(e);
      return false;
    }
    return true;
  }

  /**
   * 招聘需求回传处理
   * 
   * @param inputItem
   * @param formValuesJson
   * @param errorItemList
   * @throws ParseException
   */
  private void doDemand(ESBESBESBImportProcessStatusSrvInputItem inputItem,
      JsonObject formValuesJson, List<ErrorItem> errorItemList) throws ParseException {
    String oaStatus = inputItem.getSTATUS(); // OA流程状态
    String fd_demand_id = formValuesJson.get("fd_demand_id").getAsString();
    RecruitDemand demand = new RecruitDemandVo();
    demand.setId(fd_demand_id);
    if (Constant.OA_FLOW_STATUS_PENDING.equals(oaStatus)) { // 审批中
      String fd_deputy_code = formValuesJson.get("fd_deputy_code").getAsString();
      demand.setDemandId(inputItem.getPROCESSID());
      demand.setDeputyId(fd_deputy_code);
      demandService.updateStatusByOA(demand);
    } else if (Constant.OA_FLOW_STATUS_APPLY.equals(oaStatus)
        || oaStatus.equals(Constant.OA_FLOW_STATUS_REJECT)) { // 30发布,11驳回
      Date fd_flow_release_date =
          flowDate.parse(formValuesJson.get("fd_flow_release_date").getAsString());
      if (oaStatus.equals(Constant.OA_FLOW_STATUS_APPLY)) {
        demand.setFlowDate(fd_flow_release_date);
        demand.setFlowState(RecruitDemand.flowState.APPROVE.valueStr()); // 审核通过
      } else {
        demand.setFlowState(RecruitDemand.flowState.DISCARD.valueStr()); // 废弃
      }
      demandService.updateStatusByOA(demand);
    }
  }

  /**
   * 验证招聘需求所需字段
   * 
   * @param inputItem
   * @param errorItemList
   * @return
   */
  private boolean validataDemand(ESBESBESBImportProcessStatusSrvInputItem inputItem,
      List<ErrorItem> errorItemList) {
    String formValues = inputItem.getFORMVALUES();
    String oaStatus = inputItem.getSTATUS(); // OA流程状态
    JsonObject formValuesJson = new JsonParser().parse(formValues).getAsJsonObject();
    JsonElement fd_deputy_code = formValuesJson.get("fd_deputy_code");// 招聘代表工号
    JsonElement fd_flow_release_date = formValuesJson.get("fd_flow_release_date");// 入职时间
    JsonElement fd_demand_id = formValuesJson.get("fd_demand_id");// 招聘系统需求id
    if (!Constant.OA_FLOW_STATUS_PENDING.equals(oaStatus)
        && !Constant.OA_FLOW_STATUS_APPLY.equals(oaStatus)
        && !Constant.OA_FLOW_STATUS_REJECT.equals(oaStatus)) { // 审批中
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("ESBESBESBImportProcessStatusSrvInputItem.STATUS");
      e.setERRORMESSAGE("无法解析的OA流程状态");
      errorItemList.add(e);
      return false;
    }
    if (fd_demand_id == null || "".equals(fd_demand_id.getAsString())) {
      // 招聘需求系统需求id必须传递
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formValues.fd_demand_id");
      e.setERRORMESSAGE("招聘需求系统需求id必须传递");
      errorItemList.add(e);
      return false;
    }
    RecruitDemand sysRecruitDemand = demandService.getByPrimaryKey(fd_demand_id.getAsString());
    if (sysRecruitDemand == null) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formValues.fd_demand_id");
      e.setERRORMESSAGE("招聘需求id不匹配");
      errorItemList.add(e);
      return false;
    }
    if (RecruitDemand.flowState.APPROVE.valueStr().equals(sysRecruitDemand.getFlowState())
        || RecruitDemand.flowState.DISCARD.valueStr().equals(sysRecruitDemand.getFlowState())) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formvalues.fd_demand_id");
      e.setERRORMESSAGE("招聘系统该条招聘需求已经审批完成");
      errorItemList.add(e);
      return false;
    }
    if (Constant.OA_FLOW_STATUS_PENDING.equals(oaStatus)
        && (fd_deputy_code == null || "".equals(fd_deputy_code.getAsString()))) {
      // 审批中 招聘代表工号必须传递
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formValues.fd_deputy_code");
      e.setERRORMESSAGE("招聘代表工号必须传递");
      errorItemList.add(e);
      return false;
    }
    if ((Constant.OA_FLOW_STATUS_APPLY.equals(oaStatus) || oaStatus
        .equals(Constant.OA_FLOW_STATUS_REJECT))
        && (fd_flow_release_date == null || "".equals(fd_flow_release_date.getAsString()))) {
      // 审批中 招聘代表工号必须传递
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formValues.fd_flow_release_date");
      e.setERRORMESSAGE("招聘代表工号必须传递");
      errorItemList.add(e);
      return false;
    }
    return true;
  }

  /**
   * 通用验证webserice所需字段
   * 
   * @param inputItem
   * @param errorItemList
   * @return
   */
  private boolean validataCommon(ESBESBESBImportProcessStatusSrvInputItem inputItem,
      List<ErrorItem> errorItemList) {
    String formValues = inputItem.getFORMVALUES();
    String oaStatus = inputItem.getSTATUS(); // OA流程状态
    if (StringUtil.isEmpty(formValues)) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("ESBESBESBImportProcessStatusSrvInputItem.formvalues");
      e.setERRORMESSAGE("缺少formvalues字段数据");
      errorItemList.add(e);
      return false;
    }
    if (StringUtil.isEmpty(oaStatus)) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("ESBESBESBImportProcessStatusSrvInputItem.STATUS");
      e.setERRORMESSAGE("OA流程状态不能为空");
      errorItemList.add(e);
      return false;
    }
    JsonObject formValuesJson;
    try {
      formValuesJson = new JsonParser().parse(formValues).getAsJsonObject();
    } catch (JsonSyntaxException e1) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("ESBESBESBImportProcessStatusSrvInputItem.formvalues");
      e.setERRORMESSAGE("formvalues格式错误无法解析");
      errorItemList.add(e);
      return false;
    }
    JsonElement fd_template_id_Josn = formValuesJson.get("fd_template_id");
    if (fd_template_id_Josn == null || "".equals(fd_template_id_Josn.getAsString())) {
      ErrorItem e = new ErrorItem();
      e.setENTITYNAME("formvalues.fd_template_id");
      e.setERRORMESSAGE("缺少模板id字段");
      errorItemList.add(e);
      return false;
    }
    return true;
  }

}
