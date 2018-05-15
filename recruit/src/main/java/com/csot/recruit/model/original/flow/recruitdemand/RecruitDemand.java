package com.csot.recruit.model.original.flow.recruitdemand;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 招聘需求对象
 * 
 * @author 李耀东
 *
 */
public class RecruitDemand implements Serializable {

  /**
   * 扩展属性 变更记录数
   */
  private String logNum;
  /**
   * 扩展属性 附件id 用，号隔开
   */
  private String attchmentIds;

  public String getAttchmentIds() {
    return attchmentIds;
  }

  public void setAttchmentIds(String attchmentIds) {
    this.attchmentIds = attchmentIds;
  }

  public String getLogNum() {
    return logNum;
  }

  public void setLogNum(String logNum) {
    this.logNum = logNum;
  }

  private String id;

  /**
   * 流程ID
   */
  private String demandId;
  /**
   * 年龄段开始
   */
  private String ageStart;
  /**
   * 年龄段结束
   */
  private String ageEnd;
  /**
   * 主题
   */
  private String theme;
  /**
   * 负责人工号
   */
  private String dutyPersonId;
  /**
   * 申请部门CODE
   */
  private String applyOrganizationId;
  /**
   * 申请部门名称
   */
  private String applyOrganizationName;
  /**
   * 申请岗位CODE
   */
  private String applyPostId;
  /**
   * 申请岗位名称
   */
  private String applyPostName;
  /**
   * 员工类别
   */
  private String employeeType;
  /**
   * 招聘需求原因
   */
  private String recruitDemandReason;
  /**
   * 离职转调人
   */
  private String dimissionChangePerson;
  /**
   * 职级CODE
   */
  private String rankId;
  /**
   * 职级名称
   */
  private String rankName;
  /**
   * 申请人数
   */
  private Integer applyPersonNumber;
  /**
   * 拟入职人数
   */
  private Integer offerNumber;
  /**
   * 入职人数
   */
  private Integer entryNumber;
  /**
   * 申请日期
   */
  private String applyDate;
  /**
   * 预计到岗时间
   */
  private String predictComeDate;
  /**
   * 期望到岗时间
   */
  private String wantComeDate;
  /**
   * 境内/境外
   */
  private String district;
  /**
   * 招聘代表工号
   */
  private String deputyId;
  /**
   * 招聘代表姓名
   */
  private String deputyName;
  /**
   * 岗位工作描述
   */
  private String workRemark;

  /**
   * 招聘状态
   */
  private String infoState;

  /**
   * 招聘状态枚举
   */
  public enum infoState {
    DRAFT(1, "草稿"),
    /**
     * 待发布
     */
    ANNOUNCED(2, "待发布"),
    /**
     * 已发布
     */
    PUBLISHED(3, "已发布");

    private int value;
    private String text;

    private infoState(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int value() {
      return this.value;
    }

    public String getValueStr() {
      return String.valueOf(this.value);
    }

    public String getText() {
      return this.text;
    }


    public String valueStr() {
      return String.valueOf(value);
    }
  }

  /**
   * 流程状态
   */
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

  public String getAgeStart() {
    return ageStart;
  }

  public void setAgeStart(String ageStart) {
    this.ageStart = ageStart;
  }

  public String getAgeEnd() {
    return ageEnd;
  }

  public void setAgeEnd(String ageEnd) {
    this.ageEnd = ageEnd;
  }

  /**
   * 创建时间
   */
  private Date createDate;
  /**
   * 修改时间
   */
  private Date updateDate;
  /**
   * 创建人
   */
  private String creatorId;
  /**
   * 修改人
   */
  private String modifiedId;
  /**
   * 性别
   */
  private String gender;
  /**
   * 学历
   */
  private String education;
  /**
   * 专业
   */
  private String profession;
  /**
   * 工作经验
   */
  private String workExperience;
  /**
   * 必备技能
   */
  private String requiredSkill;
  /**
   * 素质及能力要求
   */
  private String abilityDemanded;
  /**
   * 是否已完成
   */
  private String isFinish;

  /**
   * 是否已完成状态枚举
   */
  public enum isFinish {
    /**
     * 未完成
     */
    NOTFINISHED(1),
    /**
     * 已完成
     */
    FINISHED(2),
    /**
     * 取消
     */
    CANCEL(3);

    private int value;

    private isFinish(int value) {
      this.value = value;
    }

    public int value() {
      return this.value;
    }

    public String valueStr() {
      return String.valueOf(value);
    }
  }

  /**
   * 流程发布时间
   */
  private Date flowDate;

  private String englishLevel;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDemandId() {
    return demandId;
  }

  public void setDemandId(String demandId) {
    this.demandId = demandId;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public String getDutyPersonId() {
    return dutyPersonId;
  }

  public void setDutyPersonId(String dutyPersonId) {
    this.dutyPersonId = dutyPersonId;
  }

  public String getApplyOrganizationId() {
    return applyOrganizationId;
  }

  public void setApplyOrganizationId(String applyOrganizationId) {
    this.applyOrganizationId = applyOrganizationId;
  }

  public String getApplyPostId() {
    return applyPostId;
  }

  public void setApplyPostId(String applyPostId) {
    this.applyPostId = applyPostId;
  }

  public String getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(String employeeType) {
    this.employeeType = employeeType;
  }

  public String getRecruitDemandReason() {
    return recruitDemandReason;
  }

  public void setRecruitDemandReason(String recruitDemandReason) {
    this.recruitDemandReason = recruitDemandReason;
  }

  public String getDimissionChangePerson() {
    return dimissionChangePerson;
  }

  public void setDimissionChangePerson(String dimissionChangePerson) {
    this.dimissionChangePerson = dimissionChangePerson;
  }

  public String getRankId() {
    return rankId;
  }

  public void setRankId(String rankId) {
    this.rankId = rankId;
  }


  public String getApplyDate() {
    return applyDate;
  }

  public void setApplyDate(String applyDate) {
    this.applyDate = applyDate;
  }

  public String getPredictComeDate() {
    return predictComeDate;
  }

  public void setPredictComeDate(String predictComeDate) {
    this.predictComeDate = predictComeDate;
  }

  public String getWantComeDate() {
    return wantComeDate;
  }

  public void setWantComeDate(String wantComeDate) {
    this.wantComeDate = wantComeDate;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getDeputyId() {
    return deputyId;
  }

  public void setDeputyId(String deputyId) {
    this.deputyId = deputyId;
  }

  public String getWorkRemark() {
    return workRemark;
  }

  public void setWorkRemark(String workRemark) {
    this.workRemark = workRemark;
  }

  public String getInfoState() {
    return infoState;
  }

  public void setInfoState(String infoState) {
    this.infoState = infoState;
  }

  public String getFlowState() {
    return flowState;
  }

  public void setFlowState(String flowState) {
    this.flowState = flowState;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public String getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(String creatorId) {
    this.creatorId = creatorId;
  }

  public String getModifiedId() {
    return modifiedId;
  }

  public void setModifiedId(String modifiedId) {
    this.modifiedId = modifiedId;
  }


  public Integer getApplyPersonNumber() {
    return applyPersonNumber;
  }

  public void setApplyPersonNumber(Integer applyPersonNumber) {
    this.applyPersonNumber = applyPersonNumber;
  }

  public Integer getOfferNumber() {
    return offerNumber;
  }

  public void setOfferNumber(Integer offerNumber) {
    this.offerNumber = offerNumber;
  }

  public Integer getEntryNumber() {
    return entryNumber;
  }

  public void setEntryNumber(Integer entryNumber) {
    this.entryNumber = entryNumber;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public String getWorkExperience() {
    return workExperience;
  }

  public void setWorkExperience(String workExperience) {
    this.workExperience = workExperience;
  }

  public String getRequiredSkill() {
    return requiredSkill;
  }

  public void setRequiredSkill(String requiredSkill) {
    this.requiredSkill = requiredSkill;
  }

  public String getAbilityDemanded() {
    return abilityDemanded;
  }

  public void setAbilityDemanded(String abilityDemanded) {
    this.abilityDemanded = abilityDemanded;
  }

  public Date getFlowDate() {
    return flowDate;
  }

  public void setFlowDate(Date flowDate) {
    this.flowDate = flowDate;
  }


  public String getEnglishLevel() {
    return englishLevel;
  }

  public void setEnglishLevel(String englishLevel) {
    this.englishLevel = englishLevel;
  }

  public String getApplyOrganizationName() {
    return applyOrganizationName;
  }

  public void setApplyOrganizationName(String applyOrganizationName) {
    this.applyOrganizationName = applyOrganizationName;
  }

  public String getApplyPostName() {
    return applyPostName;
  }

  public void setApplyPostName(String applyPostName) {
    this.applyPostName = applyPostName;
  }

  public String getRankName() {
    return rankName;
  }

  public void setRankName(String rankName) {
    this.rankName = rankName;
  }

  public String getDeputyName() {
    return deputyName;
  }

  public void setDeputyName(String deputyName) {
    this.deputyName = deputyName;
  }

  public String getIsFinish() {
    return isFinish;
  }

  public void setIsFinish(String isFinish) {
    this.isFinish = isFinish;
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
    RecruitDemand other = (RecruitDemand) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getDemandId() == null ? other.getDemandId() == null : this.getDemandId().equals(
            other.getDemandId()))
        && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(
            other.getTheme()))
        && (this.getDutyPersonId() == null ? other.getDutyPersonId() == null : this
            .getDutyPersonId().equals(other.getDutyPersonId()))
        && (this.getApplyOrganizationId() == null ? other.getApplyOrganizationId() == null : this
            .getApplyOrganizationId().equals(other.getApplyOrganizationId()))
        && (this.getApplyPostId() == null ? other.getApplyPostId() == null : this.getApplyPostId()
            .equals(other.getApplyPostId()))
        && (this.getEmployeeType() == null ? other.getEmployeeType() == null : this
            .getEmployeeType().equals(other.getEmployeeType()))
        && (this.getRecruitDemandReason() == null ? other.getRecruitDemandReason() == null : this
            .getRecruitDemandReason().equals(other.getRecruitDemandReason()))
        && (this.getDimissionChangePerson() == null ? other.getDimissionChangePerson() == null
            : this.getDimissionChangePerson().equals(other.getDimissionChangePerson()))
        && (this.getRankId() == null ? other.getRankId() == null : this.getRankId().equals(
            other.getRankId()))
        && (this.getApplyPersonNumber() == null ? other.getApplyPersonNumber() == null : this
            .getApplyPersonNumber().equals(other.getApplyPersonNumber()))
        && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate()
            .equals(other.getApplyDate()))
        && (this.getPredictComeDate() == null ? other.getPredictComeDate() == null : this
            .getPredictComeDate().equals(other.getPredictComeDate()))
        && (this.getWantComeDate() == null ? other.getWantComeDate() == null : this
            .getWantComeDate().equals(other.getWantComeDate()))
        && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(
            other.getDistrict()))
        && (this.getDeputyId() == null ? other.getDeputyId() == null : this.getDeputyId().equals(
            other.getDeputyId()))
        && (this.getWorkRemark() == null ? other.getWorkRemark() == null : this.getWorkRemark()
            .equals(other.getWorkRemark()))
        && (this.getInfoState() == null ? other.getInfoState() == null : this.getInfoState()
            .equals(other.getInfoState()))
        && (this.getFlowState() == null ? other.getFlowState() == null : this.getFlowState()
            .equals(other.getFlowState()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate()
            .equals(other.getCreateDate()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate()
            .equals(other.getUpdateDate()))
        && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId()
            .equals(other.getCreatorId()))
        && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId()
            .equals(other.getModifiedId()))
        && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(
            other.getGender()))
        && (this.getEducation() == null ? other.getEducation() == null : this.getEducation()
            .equals(other.getEducation()))
        && (this.getProfession() == null ? other.getProfession() == null : this.getProfession()
            .equals(other.getProfession()))
        && (this.getWorkExperience() == null ? other.getWorkExperience() == null : this
            .getWorkExperience().equals(other.getWorkExperience()))
        && (this.getRequiredSkill() == null ? other.getRequiredSkill() == null : this
            .getRequiredSkill().equals(other.getRequiredSkill()))
        && (this.getAbilityDemanded() == null ? other.getAbilityDemanded() == null : this
            .getAbilityDemanded().equals(other.getAbilityDemanded()))
        && (this.getFlowDate() == null ? other.getFlowDate() == null : this.getFlowDate()
            .equals(other.getFlowDate()))
        && (this.getEnglishLevel() == null ? other.getEnglishLevel() == null : this.getEnglishLevel()
            .equals(other.getEnglishLevel()))
        && (this.getApplyOrganizationName() == null ? other.getApplyOrganizationName() == null
            : this.getApplyOrganizationName().equals(other.getApplyOrganizationName()))
        && (this.getApplyPostName() == null ? other.getApplyPostName() == null : this
            .getApplyPostName().equals(other.getApplyPostName()))
        && (this.getDeputyName() == null ? other.getDeputyName() == null : this.getDeputyName()
            .equals(other.getDeputyName()))
        && (this.getIsFinish() == null ? other.getIsFinish() == null : this.getIsFinish().equals(
            other.getIsFinish()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getDemandId() == null) ? 0 : getDemandId().hashCode());
    result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
    result = prime * result + ((getDutyPersonId() == null) ? 0 : getDutyPersonId().hashCode());
    result =
        prime * result
            + ((getApplyOrganizationId() == null) ? 0 : getApplyOrganizationId().hashCode());
    result = prime * result + ((getApplyPostId() == null) ? 0 : getApplyPostId().hashCode());
    result = prime * result + ((getEmployeeType() == null) ? 0 : getEmployeeType().hashCode());
    result =
        prime * result
            + ((getRecruitDemandReason() == null) ? 0 : getRecruitDemandReason().hashCode());
    result =
        prime * result
            + ((getDimissionChangePerson() == null) ? 0 : getDimissionChangePerson().hashCode());
    result = prime * result + ((getRankId() == null) ? 0 : getRankId().hashCode());
    result =
        prime * result + ((getApplyPersonNumber() == null) ? 0 : getApplyPersonNumber().hashCode());
    result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
    result =
        prime * result + ((getPredictComeDate() == null) ? 0 : getPredictComeDate().hashCode());
    result = prime * result + ((getWantComeDate() == null) ? 0 : getWantComeDate().hashCode());
    result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
    result = prime * result + ((getDeputyId() == null) ? 0 : getDeputyId().hashCode());
    result = prime * result + ((getWorkRemark() == null) ? 0 : getWorkRemark().hashCode());
    result = prime * result + ((getInfoState() == null) ? 0 : getInfoState().hashCode());
    result = prime * result + ((getFlowState() == null) ? 0 : getFlowState().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
    result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
    result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
    result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
    result = prime * result + ((getProfession() == null) ? 0 : getProfession().hashCode());
    result = prime * result + ((getWorkExperience() == null) ? 0 : getWorkExperience().hashCode());
    result = prime * result + ((getRequiredSkill() == null) ? 0 : getRequiredSkill().hashCode());
    result =
        prime * result + ((getAbilityDemanded() == null) ? 0 : getAbilityDemanded().hashCode());
    result = prime * result + ((getFlowDate() == null) ? 0 : getFlowDate().hashCode());
    result = prime * result + ((getEnglishLevel() == null) ? 0 : getEnglishLevel().hashCode());
    result =
        prime * result
            + ((getApplyOrganizationName() == null) ? 0 : getApplyOrganizationName().hashCode());
    result = prime * result + ((getApplyPostName() == null) ? 0 : getApplyPostName().hashCode());
    result = prime * result + ((getDeputyName() == null) ? 0 : getDeputyName().hashCode());
    result = prime * result + ((getIsFinish() == null) ? 0 : getIsFinish().hashCode());
    return result;
  }
}