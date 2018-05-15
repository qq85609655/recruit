package com.csot.recruit.model.nresume;

import java.io.Serializable;

/**
 * 简历对象
 * @author honglu
 *
 */
public class Resume implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private String id;
  
  /** 应聘职位id */
  private String positionId;
  
  /** 简历的语言  */
  private PropertyData language;
  
  /** 简历来源   */
  private String resumeSource;
  
  /** 招聘渠道   */
  private String channel;
  
  /** 个人信息  */
  private PersonalInformation personalInfomation;
  
  /** 教育经历  */
  private Education[] educations;
  
  /** 工作经历  */
  private WorkExperience[] workExperiences;
  
  /** 求职意向  */
  private CareerObjective careerObjective;

  /** 附加信息  */
  private AdditionalInformation additionalInformation;
  
  /** 头像  */
  private Avatar avatar;
  
  private float completion;
  
  /** 扩展字段  */
  private String extensionData;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the positionId
   */
  public String getPositionId() {
    return positionId;
  }

  /**
   * @param positionId the positionId to set
   */
  public void setPositionId(String positionId) {
    this.positionId = positionId;
  }

  public PropertyData getLanguage() {
    return language;
  }

  public void setLanguage(PropertyData language) {
    this.language = language;
  }

  public String getResumeSource() {
    return resumeSource;
  }

  public void setResumeSource(String resumeSource) {
    this.resumeSource = resumeSource;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public PersonalInformation getPersonalInfomation() {
    return personalInfomation;
  }

  public void setPersonalInfomation(PersonalInformation personalInfomation) {
    this.personalInfomation = personalInfomation;
  }

  public Education[] getEducations() {
    return educations;
  }

  public void setEducations(Education[] educations) {
    this.educations = educations;
  }

  public WorkExperience[] getWorkExperiences() {
    return workExperiences;
  }

  public void setWorkExperiences(WorkExperience[] workExperiences) {
    this.workExperiences = workExperiences;
  }

  public CareerObjective getCareerObjective() {
    return careerObjective;
  }

  public void setCareerObjective(CareerObjective careerObjective) {
    this.careerObjective = careerObjective;
  }

  public AdditionalInformation getAdditionalInformation() {
    return additionalInformation;
  }

  public void setAdditionalInformation(AdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  public Avatar getAvatar() {
    return avatar;
  }

  public void setAvatar(Avatar avatar) {
    this.avatar = avatar;
  }

  public float getCompletion() {
    return completion;
  }

  public void setCompletion(float completion) {
    this.completion = completion;
  }

  public String getExtensionData() {
    return extensionData;
  }

  public void setExtensionData(String extensionData) {
    this.extensionData = extensionData;
  }
}
