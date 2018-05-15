package com.csot.recruit.model.vo;

import java.io.Serializable;

public class CandidateRecommendVo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String id ;
  
  private String candidatePostId;

  private String interviewer;

  private String resumeId;

  private String comments;
  
  private String isEmail ;
  
  private String candidateId ;
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCandidatePostId() {
    return candidatePostId;
  }

  public void setCandidatePostId(String candidatePostId) {
    this.candidatePostId = candidatePostId;
  }

  public String getInterviewer() {
    return interviewer;
  }

  public void setInterviewer(String interviewer) {
    this.interviewer = interviewer;
  }

  public String getResumeId() {
    return resumeId;
  }

  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getIsEmail() {
    return isEmail;
  }

  public void setIsEmail(String isEmail) {
    this.isEmail = isEmail;
  }
  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

}
