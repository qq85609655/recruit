package com.csot.recruit.model.position;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 职位管理模型类
 * 
 * @author zengrong
 *
 */
public class PositionMana {

  // 职位编号
  private String recruitPositionId;
  // 职位名称
  private String positionName;
  // 职位编码
  private String positionCode;
  // 内部编码
  private String departmentCode;
  // 招聘专员
  private String recruiter;
  // 其他招聘专员
  private String recruitPersonOther;
  // 招聘类别
  private String recruitType;
  // 招聘对象
  private String recruitObject;
  // 招聘专员名字
  private String recruiterName;
  // 薪水
  private String salary;
  // 薪水下限
  private String salaryMin;
  // 薪水上限
  private String salaryMax;
  // 有效期
  private String validaty;
  // 发布者
  private String publisher;
  // 发布者
  private String publisherName;
  // 接收简历邮箱
  private String receiveEmail;
  // 职位标记
  private String label;
  // 部门
  private String department;
  // 部门name
  private String departmentName;
  // 用人部门主管
  private String departmentManager;
  // 匹配设置
  // private String
  // 保密设置
  private String secrecy;
  // 招聘人数
  private BigDecimal recruitNumbers;
  // 地区
  private String workPlace;
  // 状态
  private String status;
  // 职能类别
  private String positionType;
  // 职位类别
  private String positionSimilar;
  // 职位级别
  private String positionLevel;
  // 需求人数
  private BigDecimal demands;
  // 职位生效日期
  private Date effectiveDate;
  // 期望到岗日期
  private Date expectDate;
  // 发布日期
  private Date releaseDate;
  // 分发日期
  private Date distributeDate;
  // 修改日期
  private Date modifyDate;
  // 截止日期
  private Date expireDate;
  // 职位描述 外招
  private String positionDescription;
  // 职位描述 内招
  private String positionDescription2;
  //网站岗位名称
  private String websitePostName;
  //发布渠道
  private String trench;
  

  public String getTrench() {
    return trench;
  }

  public void setTrench(String trench) {
    this.trench = trench;
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

  // 所属行业
  private String positionIndustry;
  // 需求类型
  private String demandType;
  // 年龄下限
  private Integer ageMin;
  // 年龄上限
  private Integer ageMax;
  // 工作年限下限
  private Integer workExperienceMin;
  // 工作年龄上限
  private Integer workExperienceMax;
  // 英语级别
  private String englishLevel;
  // 学历下限
  private String educationMin;
  // 学历上限
  private String educationMax;
  // 性别
  private String gender;
  // 不满足年龄条件
  private String ageNot;
  // 不满足工作经验条件
  private String workExperienceNot;
  // 不满足英语水平条件
  private String englishLevelNot;
  // 不满足教育条件
  private String educationNot;
  // 不满足性别条件
  private String agenderNot;

  // 以下字段为查询发布日期、截止日期专用字段
  // 发布开始日期
  private String startDistributeDate;
  // 发布结束日期
  private String endDistributeDate;
  // 截止开始日期
  private String startExpireDate;
  // 截止结束日期
  private String endExpireDate;
  // 用于携带招聘专员的Id
  private String recruiterId;

  public Integer getAgeMin() {
    return ageMin;
  }

  public void setAgeMin(Integer ageMin) {
    this.ageMin = ageMin;
  }

  public Integer getAgeMax() {
    return ageMax;
  }

  public void setAgeMax(Integer ageMax) {
    this.ageMax = ageMax;
  }

  public Integer getWorkExperienceMin() {
    return workExperienceMin;
  }

  public void setWorkExperienceMin(Integer workExperienceMin) {
    this.workExperienceMin = workExperienceMin;
  }

  public Integer getWorkExperienceMax() {
    return workExperienceMax;
  }

  public void setWorkExperienceMax(Integer workExperienceMax) {
    this.workExperienceMax = workExperienceMax;
  }

  public String getEnglishLevel() {
    return englishLevel;
  }

  public void setEnglishLevel(String englishLevel) {
    this.englishLevel = englishLevel;
  }

  public String getEducationMin() {
    return educationMin;
  }

  public void setEducationMin(String educationMin) {
    this.educationMin = educationMin;
  }

  public String getEducationMax() {
    return educationMax;
  }

  public void setEducationMax(String educationMax) {
    this.educationMax = educationMax;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAgeNot() {
    return ageNot;
  }

  public void setAgeNot(String ageNot) {
    this.ageNot = ageNot;
  }

  public String getWorkExperienceNot() {
    return workExperienceNot;
  }

  public void setWorkExperienceNot(String workExperienceNot) {
    this.workExperienceNot = workExperienceNot;
  }

  public String getEnglishLevelNot() {
    return englishLevelNot;
  }

  public void setEnglishLevelNot(String englishLevelNot) {
    this.englishLevelNot = englishLevelNot;
  }

  public String getEducationNot() {
    return educationNot;
  }

  public void setEducationNot(String educationNot) {
    this.educationNot = educationNot;
  }

  public String getAgenderNot() {
    return agenderNot;
  }

  public void setAgenderNot(String agenderNot) {
    this.agenderNot = agenderNot;
  }

  public String getPositionDescription() {
    return positionDescription;
  }

  public void setPositionDescription(String positionDescription) {
    this.positionDescription = positionDescription;
  }

  public String getRecruitPositionId() {
    return recruitPositionId;
  }

  public void setRecruitPositionId(String recruitPositionId) {
    this.recruitPositionId = recruitPositionId;
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public String getPositionCode() {
    return positionCode;
  }

  public void setPositionCode(String positionCode) {
    this.positionCode = positionCode;
  }

  public String getDepartmentCode() {
    return departmentCode;
  }

  public void setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
  }

  public String getRecruiter() {
    return recruiter;
  }

  public void setRecruiter(String recruiter) {
    this.recruiter = recruiter;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getSalaryMin() {
    return salaryMin;
  }

  public void setSalaryMin(String salaryMin) {
    this.salaryMin = salaryMin;
  }

  public String getSalaryMax() {
    return salaryMax;
  }

  public void setSalaryMax(String salaryMax) {
    this.salaryMax = salaryMax;
  }

  public String getValidaty() {
    return validaty;
  }

  public void setValidaty(String validaty) {
    this.validaty = validaty;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getReceiveEmail() {
    return receiveEmail;
  }

  public void setReceiveEmail(String receiveEmail) {
    this.receiveEmail = receiveEmail;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentManager() {
    return departmentManager;
  }

  public void setDepartmentManager(String departmentManager) {
    this.departmentManager = departmentManager;
  }

  public String getSecrecy() {
    return secrecy;
  }

  public void setSecrecy(String secrecy) {
    this.secrecy = secrecy;
  }

  public BigDecimal getRecruitNumbers() {
    return recruitNumbers;
  }

  public void setRecruitNumbers(BigDecimal recruitNumbers) {
    this.recruitNumbers = recruitNumbers;
  }

  public String getWorkPlace() {
    return workPlace;
  }

  public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPositionType() {
    return positionType;
  }

  public void setPositionType(String positionType) {
    this.positionType = positionType;
  }

  public String getPositionLevel() {
    return positionLevel;
  }

  public void setPositionLevel(String positionLevel) {
    this.positionLevel = positionLevel;
  }

  public BigDecimal getDemands() {
    return demands;
  }

  public void setDemands(BigDecimal demands) {
    this.demands = demands;
  }

  public Date getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public Date getExpectDate() {
    return expectDate;
  }

  public void setExpectDate(Date expectDate) {
    this.expectDate = expectDate;
  }

  public Date getDistributeDate() {
    return distributeDate;
  }

  public void setDistributeDate(Date distributeDate) {
    this.distributeDate = distributeDate;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public Date getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }

  public String getRecruitType() {
    return recruitType;
  }

  public void setRecruitType(String recruitType) {
    this.recruitType = recruitType;
  }

  public String getStartDistributeDate() {
    return startDistributeDate;
  }

  public void setStartDistributeDate(String startDistributeDate) {
    this.startDistributeDate = startDistributeDate;
  }

  public String getEndDistributeDate() {
    return endDistributeDate;
  }

  public void setEndDistributeDate(String endDistributeDate) {
    this.endDistributeDate = endDistributeDate;
  }

  public String getStartExpireDate() {
    return startExpireDate;
  }

  public void setStartExpireDate(String startExpireDate) {
    this.startExpireDate = startExpireDate;
  }

  public String getEndExpireDate() {
    return endExpireDate;
  }

  public void setEndExpireDate(String endExpireDate) {
    this.endExpireDate = endExpireDate;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getRecruitPersonOther() {
    return recruitPersonOther;
  }

  public void setRecruitPersonOther(String recruitPersonOther) {
    this.recruitPersonOther = recruitPersonOther;
  }

  public String getRecruitObject() {
    return recruitObject;
  }

  public void setRecruitObject(String recruitObject) {
    this.recruitObject = recruitObject;
  }

  public String getPositionSimilar() {
    return positionSimilar;
  }

  public void setPositionSimilar(String positionSimilar) {
    this.positionSimilar = positionSimilar;
  }

  public String getPositionIndustry() {
    return positionIndustry;
  }

  public void setPositionIndustry(String positionIndustry) {
    this.positionIndustry = positionIndustry;
  }

  public String getDemandType() {
    return demandType;
  }

  public void setDemandType(String demandType) {
    this.demandType = demandType;
  }

  public String getRecruiterId() {
    return recruiterId;
  }

  public void setRecruiterId(String recruiterId) {
    this.recruiterId = recruiterId;
  }

  public String getRecruiterName() {
    return recruiterName;
  }

  public void setRecruiterName(String recruiterName) {
    this.recruiterName = recruiterName;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

}
