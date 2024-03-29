package com.csot.recruit.model.original.flow.employ;

import java.io.Serializable;
import java.util.Date;

public class Employ implements Serializable {
  private String id;

  private String candidateId;

  private String candidateName;

  private String employPostId;

  private String employPostName;

  private String stage;
  private Date offerDate;
  public enum stage {
    /**
     * 录用
     */
    EMPLOY(1, "录用"),
    /**
     * 已发offer
     */
    OFFER(2, "已发offer"),
    /**
     * 拒offer
     */
    REFUSEOFFER(3, "拒offer"),
    /**
     * 入职
     */
    ENTRY(4, "入职"),
    /**
     * 入职
     */
    REFUSEENTRY(5, "放弃入职");
    private int value;
    private String text;

    private stage(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int value() {
      return this.value;
    }

    public String getText() {
      return this.text;
    }

    public String valueStr() {
      return String.valueOf(value);
    }
  }

  private String demandId;

  private String employmentForm;

  private String appraisalInterviewHr;

  private String appraisalInterview;

  private String entryDate;

  private String entryDateHide;

  private String simulationEntryDate;

  private String flowState;

  /**
   * 流程状态枚举
   */
  public enum flowState {
    /**
     * 未提交
     */
    UNCOMMITTED(1, "未提交"),
    /**
     * 审核中
     */
    AUDIT(2, "审核中"),
    /**
     * 废弃
     */
    DISCARD(3, "废弃"),
    /**
     * 审批通过
     */
    APPROVE(4, "审批通过");
    private int value;
    private String text;

    private flowState(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int value() {
      return this.value;
    }

    public String getText() {
      return this.text;
    }

    public String valueStr() {
      return String.valueOf(value);
    }
  }

  private String creatorId;

  private Date createDate;

  private String modifiedId;

  private Date updateDate;

  private String employOrgId;

  private String employOrgName;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public String getCandidateName() {
    return candidateName;
  }

  public void setCandidateName(String candidateName) {
    this.candidateName = candidateName;
  }

  public String getEmployPostId() {
    return employPostId;
  }

  public void setEmployPostId(String employPostId) {
    this.employPostId = employPostId;
  }

  public String getEmployPostName() {
    return employPostName;
  }

  public void setEmployPostName(String employPostName) {
    this.employPostName = employPostName;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getDemandId() {
    return demandId;
  }

  public void setDemandId(String demandId) {
    this.demandId = demandId;
  }

  public String getEmploymentForm() {
    return employmentForm;
  }

  public void setEmploymentForm(String employmentForm) {
    this.employmentForm = employmentForm;
  }

  public String getAppraisalInterviewHr() {
    return appraisalInterviewHr;
  }

  public void setAppraisalInterviewHr(String appraisalInterviewHr) {
    this.appraisalInterviewHr = appraisalInterviewHr;
  }

  public String getAppraisalInterview() {
    return appraisalInterview;
  }

  public void setAppraisalInterview(String appraisalInterview) {
    this.appraisalInterview = appraisalInterview;
  }

  public String getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(String entryDate) {
    this.entryDate = entryDate;
  }

  public String getEntryDateHide() {
    return entryDateHide;
  }

  public void setEntryDateHide(String entryDateHide) {
    this.entryDateHide = entryDateHide;
  }

  public Date getOfferDate() {
    return offerDate;
  }

  public void setOfferDate(Date offerDate) {
    this.offerDate = offerDate;
  }

  public String getSimulationEntryDate() {
    return simulationEntryDate;
  }

  public void setSimulationEntryDate(String simulationEntryDate) {
    this.simulationEntryDate = simulationEntryDate;
  }

  public String getFlowState() {
    return flowState;
  }

  public void setFlowState(String flowState) {
    this.flowState = flowState;
  }

  public String getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(String creatorId) {
    this.creatorId = creatorId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getModifiedId() {
    return modifiedId;
  }

  public void setModifiedId(String modifiedId) {
    this.modifiedId = modifiedId;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public String getEmployOrgId() {
    return employOrgId;
  }

  public void setEmployOrgId(String employOrgId) {
    this.employOrgId = employOrgId;
  }

  public String getEmployOrgName() {
    return employOrgName;
  }

  public void setEmployOrgName(String employOrgName) {
    this.employOrgName = employOrgName;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    Employ other = (Employ) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getCandidateId() == null ? other.getCandidateId() == null : this.getCandidateId()
            .equals(other.getCandidateId()))
        && (this.getCandidateName() == null ? other.getCandidateName() == null : this
            .getCandidateName().equals(other.getCandidateName()))
        && (this.getEmployPostId() == null ? other.getEmployPostId() == null : this
            .getEmployPostId().equals(other.getEmployPostId()))
        && (this.getEmployPostName() == null ? other.getEmployPostName() == null : this
            .getEmployPostName().equals(other.getEmployPostName()))
        && (this.getStage() == null ? other.getStage() == null : this.getStage().equals(
            other.getStage()))
        && (this.getDemandId() == null ? other.getDemandId() == null : this.getDemandId().equals(
            other.getDemandId()))
        && (this.getEmploymentForm() == null ? other.getEmploymentForm() == null : this
            .getEmploymentForm().equals(other.getEmploymentForm()))
        && (this.getAppraisalInterviewHr() == null ? other.getAppraisalInterviewHr() == null : this
            .getAppraisalInterviewHr().equals(other.getAppraisalInterviewHr()))
        && (this.getAppraisalInterview() == null ? other.getAppraisalInterview() == null : this
            .getAppraisalInterview().equals(other.getAppraisalInterview()))
        && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate()
            .equals(other.getEntryDate()))
        && (this.getEntryDateHide() == null ? other.getEntryDateHide() == null : this
            .getEntryDateHide().equals(other.getEntryDateHide()))
        && (this.getSimulationEntryDate() == null ? other.getSimulationEntryDate() == null : this
            .getSimulationEntryDate().equals(other.getSimulationEntryDate()))
        && (this.getFlowState() == null ? other.getFlowState() == null : this.getFlowState()
            .equals(other.getFlowState()))
        && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId()
            .equals(other.getCreatorId()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate()
            .equals(other.getCreateDate()))
        && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId()
            .equals(other.getModifiedId()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate()
            .equals(other.getUpdateDate()))
        && (this.getEmployOrgId() == null ? other.getEmployOrgId() == null : this.getEmployOrgId()
            .equals(other.getEmployOrgId()))
        && (this.getEmployOrgName() == null ? other.getEmployOrgName() == null : this
            .getEmployOrgName().equals(other.getEmployOrgName()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getCandidateId() == null) ? 0 : getCandidateId().hashCode());
    result = prime * result + ((getCandidateName() == null) ? 0 : getCandidateName().hashCode());
    result = prime * result + ((getEmployPostId() == null) ? 0 : getEmployPostId().hashCode());
    result = prime * result + ((getEmployPostName() == null) ? 0 : getEmployPostName().hashCode());
    result = prime * result + ((getStage() == null) ? 0 : getStage().hashCode());
    result = prime * result + ((getDemandId() == null) ? 0 : getDemandId().hashCode());
    result = prime * result + ((getEmploymentForm() == null) ? 0 : getEmploymentForm().hashCode());
    result =
        prime * result
            + ((getAppraisalInterviewHr() == null) ? 0 : getAppraisalInterviewHr().hashCode());
    result =
        prime * result
            + ((getAppraisalInterview() == null) ? 0 : getAppraisalInterview().hashCode());
    result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
    result = prime * result + ((getEntryDateHide() == null) ? 0 : getEntryDateHide().hashCode());
    result =
        prime * result
            + ((getSimulationEntryDate() == null) ? 0 : getSimulationEntryDate().hashCode());
    result = prime * result + ((getFlowState() == null) ? 0 : getFlowState().hashCode());
    result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getEmployOrgId() == null) ? 0 : getEmployOrgId().hashCode());
    result = prime * result + ((getEmployOrgName() == null) ? 0 : getEmployOrgName().hashCode());
    return result;
  }
}
