package com.csot.recruit.model.original.flow.recruitdemand;

import java.math.BigDecimal;



/**
 * 招聘需求视图对象
 * 
 * @author 李耀东
 *
 */
public class RecruitDemandVo extends RecruitDemand {

  private static final long serialVersionUID = 1L;
  /**
   * 扩展属性 变更审核记录数
   */
  private String changeNum;
  public String getChangeNum() {
    return changeNum;
  }
  public void setChangeNum(String changeNum) {
    this.changeNum = changeNum;
  }

  /**
   * 编辑状态
   */
  private String infoStateStr;
  /**
   * 共承人
   */
  private String sharePerson;
  /**
   * 共承描述
   */
  private String shareRemark;

  /**
   * 流程状态
   */
  private String flowStateStr;
  /**
   * 接受简历
   */
  private Integer acceptResumeNum;
  /**
   * 匹配简历
   */
  private Integer matchingResumeNum;
  /**
   * 网站发布岗位名称
   */
  private String websitePostName;
  /**
   * 发布的网站
   */
  private String websiteTypes;
  /**
   * 最新发布时间
   */
  private String releaseDate;
  public RecruitDemandVo() {}
  /**
   * 转载RecruitDemand对象
   * 
   * @param item
   */
  public RecruitDemandVo(RecruitDemand item) {
    this.setAbilityDemanded(item.getAbilityDemanded());
    this.setApplyDate(item.getApplyDate());
    this.setApplyOrganizationId(item.getApplyOrganizationId());
    this.setApplyOrganizationName(item.getApplyOrganizationName());
    this.setApplyPersonNumber(item.getApplyPersonNumber());
    this.setApplyPostId(item.getApplyPostId());
    this.setApplyPostName(item.getApplyPostName());
    this.setAttchmentIds(item.getAttchmentIds());
    this.setCreateDate(item.getCreateDate());
    this.setCreatorId(item.getCreatorId());
    this.setDemandId(item.getDemandId());
    this.setDeputyId(item.getDeputyId());
    this.setDeputyName(item.getDeputyName());
    this.setDimissionChangePerson(item.getDimissionChangePerson());
    this.setDistrict(item.getDistrict());
    this.setDutyPersonId(item.getDutyPersonId());
    this.setEducation(item.getEducation());
    this.setEmployeeType(item.getEmployeeType());
    this.setFlowState(item.getFlowState());
    this.setGender(item.getGender());
    this.setId(item.getId());
    this.setInfoState(item.getInfoState());
    this.setIsFinish(item.getIsFinish());
    this.setLogNum(item.getLogNum());
    this.setModifiedId(item.getModifiedId());
    this.setPredictComeDate(item.getPredictComeDate());
    this.setProfession(item.getProfession());
    this.setRankId(item.getRankId());
    this.setRankName(item.getRankName());
    this.setRecruitDemandReason(item.getRecruitDemandReason());
    this.setRequiredSkill(item.getRequiredSkill());
    this.setTheme(item.getTheme());
    this.setUpdateDate(item.getUpdateDate());
    this.setWantComeDate(item.getWantComeDate());
    this.setWorkExperience(item.getWorkExperience());
    this.setWorkRemark(item.getWorkRemark());
    this.setOfferNumber(item.getOfferNumber());
    this.setEntryNumber(item.getEntryNumber());
    this.setFlowDate(item.getFlowDate());
  }

  public Integer getAcceptResumeNum() {
    return acceptResumeNum;
  }

  public void setAcceptResumeNum(Integer acceptResumeNum) {
    this.acceptResumeNum = acceptResumeNum;
  }

  public Integer getMatchingResumeNum() {
    return matchingResumeNum;
  }

  public void setMatchingResumeNum(Integer matchingResumeNum) {
    this.matchingResumeNum = matchingResumeNum;
  }

  public String getWebsitePostName() {
    return websitePostName;
  }

  public void setWebsitePostName(String websitePostName) {
    this.websitePostName = websitePostName;
  }

  public String getWebsiteTypes() {
    return websiteTypes;
  }

  public void setWebsiteTypes(String websiteTypes) {
    this.websiteTypes = websiteTypes;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }


  public String getInfoStateStr() {
    return infoStateStr;
  }

  public void setInfoStateStr(String infoStateStr) {
    this.infoStateStr = infoStateStr;
  }

  public String getFlowStateStr() {
    return flowStateStr;
  }

  public void setFlowStateStr(String flowStateStr) {
    this.flowStateStr = flowStateStr;
  }

  public String getSharePerson() {
    return sharePerson;
  }

  public void setSharePerson(String sharePerson) {
    this.sharePerson = sharePerson;
  }

  public String getShareRemark() {
    return shareRemark;
  }

  public void setShareRemark(String shareRemark) {
    this.shareRemark = shareRemark;
  }

  /**
   * 获取流程状态字典数据
   * 
   * @param value
   * @return
   */
  public static String getFlowStateStr(int value) {
    if (RecruitDemand.flowState.UNCOMMITTED.value() == value) {
      return RecruitDemand.flowState.UNCOMMITTED.getText();
    }
    if (RecruitDemand.flowState.AUDIT.value() == value) {
      return RecruitDemand.flowState.AUDIT.getText();
    }
    if (RecruitDemand.flowState.DISCARD.value() == value) {
      return RecruitDemand.flowState.DISCARD.getText();
    }
    if (RecruitDemand.flowState.APPROVE.value() == value) {
      return RecruitDemand.flowState.APPROVE.getText();
    }
    return "";
  }

  /**
   * 获取发布状态字典
   * 
   * @param value
   * @return
   */
  public static String getInfoStateStr(int value) {
    if (RecruitDemand.infoState.DRAFT.value() == value) {
      return RecruitDemand.infoState.DRAFT.getText();
    }
    if (RecruitDemand.infoState.ANNOUNCED.value() == value) {
      return RecruitDemand.infoState.ANNOUNCED.getText();
    }
    if (RecruitDemand.infoState.PUBLISHED.value() == value) {
      return RecruitDemand.infoState.PUBLISHED.getText();
    }
    return "";
  }

}
