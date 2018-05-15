package com.csot.recruit.model.vo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * VO--面试列表
 * @author LXL
 *
 */
public class InterviewBookCandidateVo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String id ;
  
  private String name ;
  
  private String cJobName ;
  
  private String cOrgName ;
  
  private String interviewType ;
  
  private Date  interviewDate ;
  
  private String interviewBTime ;
  
  private String interviewETime ;
  
  private String interviewers ;
  
  private String interviewStatus ;
  
  private String interviewAddress ;
  
  private String positionId ;
  
  private String candidateId ;
  
  private String rounds ;
  
  private String content ;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getRounds() {
    return rounds;
  }

  public void setRounds(String rounds) {
    this.rounds = rounds;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }
  
  public String getPositionId() {
    return positionId;
  }

  public void setPositionId(String positionId) {
    this.positionId = positionId;
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

  public Date getInterviewDate() {
    return interviewDate;
  }

  public void setInterviewDate(Date interviewDate) {
    this.interviewDate = interviewDate;
  }

  public String getInterviewBTime() {
    return interviewBTime;
  }

  public void setInterviewBTime(String interviewBTime) {
    this.interviewBTime = interviewBTime;
  }

  public String getInterviewETime() {
    return interviewETime;
  }

  public void setInterviewETime(String interviewETime) {
    this.interviewETime = interviewETime;
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
  public String getInterviewType() {
    return interviewType;
  }

  public void setInterviewType(String interviewType) {
    this.interviewType = interviewType;
  }

}
