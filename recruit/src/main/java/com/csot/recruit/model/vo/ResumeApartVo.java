package com.csot.recruit.model.vo;

import java.io.Serializable;
import java.util.Date;

public class ResumeApartVo implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String id;
  
  private String positionId;
  
  private String storageDate;
  
  private String jobName ;
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  public String getPositionId() {
    return positionId;
  }

  public void setPositionId(String positionId) {
    this.positionId = positionId;
  }

  public String getStorageDate() {
    return storageDate;
  }

  public void setStorageDate(String storageDate) {
    this.storageDate = storageDate;
  }
  
  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

}
