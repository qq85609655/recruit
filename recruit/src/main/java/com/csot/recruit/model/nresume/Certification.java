package com.csot.recruit.model.nresume;

import java.io.Serializable;
import java.util.Date;

/**
 * 证书信息
 * @author honglu
 *
 */
public class Certification implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private String id;
  
  /** 证书名称    */
  private String name;
  
  /** 证书获得时间    */
  private Date receivingDate;
  
  /** 分数    */
  private String score;
  
  /** 关联的简历id */
  private String resumeId;

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getReceivingDate() {
    return receivingDate;
  }

  public void setReceivingDate(Date receivingDate) {
    this.receivingDate = receivingDate;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  /**
   * @return the resumeId
   */
  public String getResumeId() {
    return resumeId;
  }

  /**
   * @param resumeId the resumeId to set
   */
  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }
}
