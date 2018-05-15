package com.csot.recruit.model.vo;

import java.io.Serializable;

import com.csot.recruit.model.original.candidate.RecommendUnionIds;

public class CandidateRecommendResumeVo extends RecommendUnionIds implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7698943472070126750L;
  
  
  private String name ;
  
  private String sex ;
  
  private Integer age ;
  
  private String interviewPositionName ;
  
  private String commpany ;
  
  private String curPositionName ;
  
  private Integer years ;
  
  private String qualifications ;
  
  private String school ;
  
  private String comment ;
  
  private String status ;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getInterviewPositionName() {
    return interviewPositionName;
  }

  public void setInterviewPositionName(String interviewPositionName) {
    this.interviewPositionName = interviewPositionName;
  }

  public String getCommpany() {
    return commpany;
  }

  public void setCommpany(String commpany) {
    this.commpany = commpany;
  }

  public String getCurPositionName() {
    return curPositionName;
  }

  public void setCurPositionName(String curPositionName) {
    this.curPositionName = curPositionName;
  }

  public Integer getYears() {
    return years;
  }

  public void setYears(Integer years) {
    this.years = years;
  }

  public String getQualifications() {
    return qualifications;
  }

  public void setQualifications(String qualifications) {
    this.qualifications = qualifications;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
  
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
