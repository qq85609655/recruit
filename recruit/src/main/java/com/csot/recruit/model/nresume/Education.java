package com.csot.recruit.model.nresume;

import java.io.Serializable;
import java.util.Date;

/**
 * 教育经历
 * @author honglu
 *
 */
public class Education implements Serializable {
  
  private static final long serialVersionUID = 1L;

  /** 学位    */
  private PropertyData degree;
  
  /** 起始时间    */
  private Date startingDate;
  
  /** 截止时间    */
  private Date endingDate;
  
  /** 就读专业名称    */
  private String major;
  
  /** 就读学校名称    */
  private String school;

  /**
   * @return the degree
   */
  public PropertyData getDegree() {
    return degree;
  }

  /**
   * @param degree the degree to set
   */
  public void setDegree(PropertyData degree) {
    this.degree = degree;
  }

  public Date getStartingDate() {
    return startingDate;
  }

  public void setStartingDate(Date startingDate) {
    this.startingDate = startingDate;
  }

  public Date getEndingDate() {
    return endingDate;
  }

  public void setEndingDate(Date endingDate) {
    this.endingDate = endingDate;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }
}
