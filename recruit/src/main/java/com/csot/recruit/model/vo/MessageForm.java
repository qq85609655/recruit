package com.csot.recruit.model.vo;

import java.io.Serializable;

public class MessageForm implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8717097288924915720L;
  
  private String candidateId ;
  
  private String isBzjl ;
  
  private String isJlyw ;
  
  private String modelId ;
  
  private String attchmentIds ;
  
  private String emailContent ;
  
  private String interviewer ;

  public String getInterviewer() {
    return interviewer;
  }

  public void setInterviewer(String interviewer) {
    this.interviewer = interviewer;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public String getIsBzjl() {
    return isBzjl;
  }

  public void setIsBzjl(String isBzjl) {
    this.isBzjl = isBzjl;
  }

  public String getIsJlyw() {
    return isJlyw;
  }

  public void setIsJlyw(String isJlyw) {
    this.isJlyw = isJlyw;
  }

  public String getModelId() {
    return modelId;
  }

  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  public String getAttchmentIds() {
    return attchmentIds;
  }

  public void setAttchmentIds(String attchmentIds) {
    this.attchmentIds = attchmentIds;
  }

  public String getEmailContent() {
    return emailContent;
  }

  public void setEmailContent(String emailContent) {
    this.emailContent = emailContent;
  }

}
