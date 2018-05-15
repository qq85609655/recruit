package com.csot.recruit.model.position;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RecruitPosition implements Serializable {
  private String recruitPositionId;

  // 职位名称
  private String positionName;

  // 职位编码
  private String positionCode;

  // 职能类别
  private String positionType;

  // 职位级别
  private String positionLevel;

  // 职位类别
  private String positionSimilar;

  // 职位要求
  private String positionRequire;

  // 职位要求详细 信息
  private RequireInfor requireInfor;

  // 招聘流程角色设置
  private RecruitFlowConfig recruitFlowConfig;

  // 职位部们需求
  private DepartmentRequire departmentRequire;

  //
  private RecruitInfor recruitInfor;

  // 所属行业（外招）
  private String positionIndustry;

  // 职位描述（内招）
  private String positionDescription;

  // 发布渠道
  private String trench;

  // 职位描述
  private String positionDescription2;
  // 网站发布岗位名称
  private String websitePostName;
  // 工作地点
  private String workPlace;

  // 有效期
  private String validaty;

  // 招聘人数
  private BigDecimal recruitNumbers;

  // 月薪
  private String salary;

  // 招聘类型
  private String recruitType;

  // 招聘对象
  private String recruitObject;

  // 保密设置
  private String secrecy;

  // 状态
  private String status;

  // 标记
  private String label;

  // 发布时间
  private Date releaseDate;

  // 创建职位者
  private String creater;

  // 到期时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date expireDate;

  private static final long serialVersionUID = 1L;

  public String getRecruitPositionId() {
    return recruitPositionId;
  }

  public void setRecruitPositionId(String recruitPositionId) {
    this.recruitPositionId = recruitPositionId == null ? null : recruitPositionId.trim();
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName == null ? null : positionName.trim();
  }

  public String getPositionCode() {
    return positionCode;
  }

  public void setPositionCode(String positionCode) {
    this.positionCode = positionCode == null ? null : positionCode.trim();
  }

  public String getPositionType() {
    return positionType;
  }

  public void setPositionType(String positionType) {
    this.positionType = positionType == null ? null : positionType.trim();
  }

  public String getPositionLevel() {
    return positionLevel;
  }

  public void setPositionLevel(String positionLevel) {
    this.positionLevel = positionLevel == null ? null : positionLevel.trim();
  }

  public String getPositionSimilar() {
    return positionSimilar;
  }

  public void setPositionSimilar(String positionSimilar) {
    this.positionSimilar = positionSimilar == null ? null : positionSimilar.trim();
  }

  public String getPositionRequire() {
    return positionRequire;
  }

  public void setPositionRequire(String positionRequire) {
    this.positionRequire = positionRequire == null ? null : positionRequire.trim();
  }

  public RequireInfor getRequireInfor() {
    return requireInfor;
  }

  public void setRequireInfor(RequireInfor requireInfor) {
    this.requireInfor = requireInfor;
  }

  public RecruitFlowConfig getRecruitFlowConfig() {
    return recruitFlowConfig;
  }

  public void setRecruitFlowConfig(RecruitFlowConfig recruitFlowConfig) {
    this.recruitFlowConfig = recruitFlowConfig;
  }

  public DepartmentRequire getDepartmentRequire() {
    return departmentRequire;
  }

  public void setDepartmentRequire(DepartmentRequire departmentRequire) {
    this.departmentRequire = departmentRequire;
  }

  public RecruitInfor getRecruitInfor() {
    return recruitInfor;
  }

  public void setRecruitInfor(RecruitInfor recruitInfor) {
    this.recruitInfor = recruitInfor;
  }

  public String getPositionIndustry() {
    return positionIndustry;
  }

  public void setPositionIndustry(String positionIndustry) {
    this.positionIndustry = positionIndustry == null ? null : positionIndustry.trim();
  }

  public String getPositionDescription() {
    return positionDescription;
  }

  public void setPositionDescription(String positionDescription) {
    this.positionDescription = positionDescription == null ? null : positionDescription.trim();
  }

  public String getWorkPlace() {
    return workPlace;
  }

  public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace == null ? null : workPlace.trim();
  }

  public String getValidaty() {
    return validaty;
  }

  public void setValidaty(String validaty) {
    this.validaty = validaty == null ? null : validaty.trim();
  }

  public BigDecimal getRecruitNumbers() {
    return recruitNumbers;
  }

  public void setRecruitNumbers(BigDecimal recruitNumbers) {
    this.recruitNumbers = recruitNumbers;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary == null ? null : salary.trim();
  }

  public String getRecruitType() {
    return recruitType;
  }

  public void setRecruitType(String recruitType) {
    this.recruitType = recruitType == null ? null : recruitType.trim();
  }

  public String getRecruitObject() {
    return recruitObject;
  }

  public void setRecruitObject(String recruitObject) {
    this.recruitObject = recruitObject == null ? null : recruitObject.trim();
  }

  public String getSecrecy() {
    return secrecy;
  }

  public void setSecrecy(String secrecy) {
    this.secrecy = secrecy;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label == null ? null : label.trim();
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Date getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }

  public String getCreater() {
    return creater;
  }

  public void setCreater(String creater) {
    this.creater = creater;
  }

  public String getPositionDescription2() {
    return positionDescription2;
  }

  public void setPositionDescription2(String positionDescription2) {
    this.positionDescription2 = positionDescription2;
  }

  public String getWebsitePostName() {
    return websitePostName;
  }

  public void setWebsitePostName(String websitePostName) {
    this.websitePostName = websitePostName;
  }

  public String getTrench() {
    return trench;
  }

  public void setTrench(String trench) {
    this.trench = trench;
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
    RecruitPosition other = (RecruitPosition) that;
    return (this.getRecruitPositionId() == null ? other.getRecruitPositionId() == null : this
        .getRecruitPositionId().equals(other.getRecruitPositionId()))
        && (this.getPositionName() == null ? other.getPositionName() == null : this
            .getPositionName().equals(other.getPositionName()))
        && (this.getPositionCode() == null ? other.getPositionCode() == null : this
            .getPositionCode().equals(other.getPositionCode()))
        && (this.getPositionType() == null ? other.getPositionType() == null : this
            .getPositionType().equals(other.getPositionType()))
        && (this.getPositionLevel() == null ? other.getPositionLevel() == null : this
            .getPositionLevel().equals(other.getPositionLevel()))
        && (this.getPositionSimilar() == null ? other.getPositionSimilar() == null : this
            .getPositionSimilar().equals(other.getPositionSimilar()))
        && (this.getPositionRequire() == null ? other.getPositionRequire() == null : this
            .getPositionRequire().equals(other.getPositionRequire()))
        && (this.getPositionIndustry() == null ? other.getPositionIndustry() == null : this
            .getPositionIndustry().equals(other.getPositionIndustry()))
        && (this.getPositionDescription() == null ? other.getPositionDescription() == null : this
            .getPositionDescription().equals(other.getPositionDescription()))
        && (this.getWorkPlace() == null ? other.getWorkPlace() == null : this.getWorkPlace()
            .equals(other.getWorkPlace()))
        && (this.getValidaty() == null ? other.getValidaty() == null : this.getValidaty().equals(
            other.getValidaty()))
        && (this.getRecruitNumbers() == null ? other.getRecruitNumbers() == null : this
            .getRecruitNumbers().equals(other.getRecruitNumbers()))
        && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(
            other.getSalary()))
        && (this.getRecruitType() == null ? other.getRecruitType() == null : this.getRecruitType()
            .equals(other.getRecruitType()))
        && (this.getRecruitObject() == null ? other.getRecruitObject() == null : this
            .getRecruitObject().equals(other.getRecruitObject()))
        && (this.getSecrecy() == null ? other.getSecrecy() == null : this.getSecrecy().equals(
            other.getSecrecy()))
        && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(
            other.getStatus()))
        && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(
            other.getLabel()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        prime * result + ((getRecruitPositionId() == null) ? 0 : getRecruitPositionId().hashCode());
    result = prime * result + ((getPositionName() == null) ? 0 : getPositionName().hashCode());
    result = prime * result + ((getPositionCode() == null) ? 0 : getPositionCode().hashCode());
    result = prime * result + ((getPositionType() == null) ? 0 : getPositionType().hashCode());
    result = prime * result + ((getPositionLevel() == null) ? 0 : getPositionLevel().hashCode());
    result =
        prime * result + ((getPositionSimilar() == null) ? 0 : getPositionSimilar().hashCode());
    result =
        prime * result + ((getPositionRequire() == null) ? 0 : getPositionRequire().hashCode());
    result =
        prime * result + ((getPositionIndustry() == null) ? 0 : getPositionIndustry().hashCode());
    result =
        prime * result
            + ((getPositionDescription() == null) ? 0 : getPositionDescription().hashCode());
    result = prime * result + ((getWorkPlace() == null) ? 0 : getWorkPlace().hashCode());
    result = prime * result + ((getValidaty() == null) ? 0 : getValidaty().hashCode());
    result = prime * result + ((getRecruitNumbers() == null) ? 0 : getRecruitNumbers().hashCode());
    result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
    result = prime * result + ((getRecruitType() == null) ? 0 : getRecruitType().hashCode());
    result = prime * result + ((getRecruitObject() == null) ? 0 : getRecruitObject().hashCode());
    result = prime * result + ((getSecrecy() == null) ? 0 : getSecrecy().hashCode());
    result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
    result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
    return result;
  }
}
