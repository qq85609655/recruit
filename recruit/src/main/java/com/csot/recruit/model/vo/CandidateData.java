package com.csot.recruit.model.vo;

import java.io.Serializable;
import java.util.Date;

public class CandidateData implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String name ;
  
  private String labels ;
  
  private String resumeOrigin ;
  
  private String positionId ;
  
  private String deptId ;
  
  private String channel ;
  
  private String startTime ;
  
  private String endTime ;
  
  private Date startTimeDate ;
  
  private Date endTimeDate ;
  
  private String highestEducation ;
  
  private String sex ;
  
 private Integer lowerAge ;
  
  private Integer upperAge ;
  
  private Double lowerYear ;
  
  private Double upperYear ;
  
  private String company ;
  
  private Double points ;
  
  private Integer positionStatus ;
  
  private Integer lockStatus ;
  
  private String professional ;
  
  private String currentryWorkplace ;
  
  private String curPosition ;
  
  private String interviewerName ;
  
  public String getInterviewerName() {
    return interviewerName;
  }

  public void setInterviewerName(String interviewerName) {
    this.interviewerName = interviewerName;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  private String school ;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLabels() {
    return labels;
  }

  public void setLabels(String labels) {
    this.labels = labels;
  }

  public String getResumeOrigin() {
    return resumeOrigin;
  }

  public void setResumeOrigin(String resumeOrigin) {
    this.resumeOrigin = resumeOrigin;
  }

  public String getPositionId() {
    return positionId;
  }

  public void setPositionId(String positionId) {
    this.positionId = positionId;
  }

  public String getDeptId() {
    return deptId;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }

  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getHighestEducation() {
    return highestEducation;
  }

  public void setHighestEducation(String highestEducation) {
    this.highestEducation = highestEducation;
  }
  
  public Date getStartTimeDate() {
    return startTimeDate;
  }

  public void setStartTimeDate(Date startTimeDate) {
    this.startTimeDate = startTimeDate;
  }

  public Date getEndTimeDate() {
    return endTimeDate;
  }

  public void setEndTimeDate(Date endTimeDate) {
    this.endTimeDate = endTimeDate;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Integer getLowerAge() {
    return lowerAge;
  }

  public void setLowerAge(Integer lowerAge) {
    this.lowerAge = lowerAge;
  }

  public Integer getUpperAge() {
    return upperAge;
  }

  public void setUpperAge(Integer upperAge) {
    this.upperAge = upperAge;
  }

  public Double getLowerYear() {
    return lowerYear;
  }

  public void setLowerYear(Double lowerYear) {
    this.lowerYear = lowerYear;
  }

  public Double getUpperYear() {
    return upperYear;
  }

  public void setUpperYear(Double upperYear) {
    this.upperYear = upperYear;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Double getPoints() {
    return points;
  }

  public void setPoints(Double points) {
    this.points = points;
  }

  public Integer getPositionStatus() {
    return positionStatus;
  }

  public String getProfessional() {
    return professional;
  }

  public void setProfessional(String professional) {
    this.professional = professional;
  }

  public String getCurrentryWorkplace() {
    return currentryWorkplace;
  }

  public void setCurrentryWorkplace(String currentryWorkplace) {
    this.currentryWorkplace = currentryWorkplace;
  }

  public String getCurPosition() {
    return curPosition;
  }

  public void setCurPosition(String curPosition) {
    this.curPosition = curPosition;
  }

  public void setPositionStatus(Integer positionStatus) {
    this.positionStatus = positionStatus;
  }
  
  public Integer getLockStatus() {
    return lockStatus;
  }

  public void setLockStatus(Integer lockStatus) {
    this.lockStatus = lockStatus;
  }
  
  
  
}
