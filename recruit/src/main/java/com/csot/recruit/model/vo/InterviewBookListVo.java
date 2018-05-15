package com.csot.recruit.model.vo;

import java.io.Serializable;

import com.csot.recruit.model.original.flow.interview.Feedback;

public class InterviewBookListVo implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = -2404619157809365049L;
  
  private String id ;
  
  private String name ;
  
  private String cJobName ;
  
  private String positonId ;
  
  private String cOrgName ;
  
  private String  interviewTimes ;
  
  private String interviewers ;
  
  private String interviewStatus ;
  
  private String interviewAddress ;
  
  private String candidateId ;
  
  private String content ;
  
  private Feedback feedback ;
  
  private String cpStatus ;
  
  private String lockStatus ;

  public String getLockStatus() {
    return lockStatus;
  }

  public void setLockStatus(String lockStatus) {
    this.lockStatus = lockStatus;
  }

  public String getCpStatus() {
    return cpStatus;
  }

  public void setCpStatus(String cpStatus) {
    this.cpStatus = cpStatus;
  }

  public Feedback getFeedback() {
    return feedback;
  }

  public void setFeedback(Feedback feedback) {
    this.feedback = feedback;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getcJobName() {
    return cJobName;
  }

  public void setcJobName(String cJobName) {
    this.cJobName = cJobName;
  }

  public String getcOrgName() {
    return cOrgName;
  }

  public void setcOrgName(String cOrgName) {
    this.cOrgName = cOrgName;
  }
  public String getPositonId() {
    return positonId;
  }

  public void setPositonId(String positonId) {
    this.positonId = positonId;
  }

  public String getInterviewTimes() {
    return interviewTimes;
  }

  public void setInterviewTimes(String interviewTimes) {
    this.interviewTimes = interviewTimes;
  }

  public String getInterviewers() {
    return interviewers;
  }

  public void setInterviewers(String interviewers) {
    this.interviewers = interviewers;
  }

  public String getInterviewStatus() {
    return interviewStatus;
  }

  public void setInterviewStatus(String interviewStatus) {
    this.interviewStatus = interviewStatus;
  }

  public String getInterviewAddress() {
    return interviewAddress;
  }

  public void setInterviewAddress(String interviewAddress) {
    this.interviewAddress = interviewAddress;
  }

  

}
