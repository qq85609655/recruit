package com.csot.recruit.model.original.candidate;

import java.io.Serializable;
import java.util.Date;

public class CandidatePost implements Serializable {
  private String id;

  private String candidateId;

  private String operatorUser;

  private String positionId;

  private String interviewStatus;
  
  private Date createTime ;
  
  private String jobName ;

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public enum interviewStatus {
    WEEDOUT(20, "淘汰"), EMPLOYING(30, "录用申请中"), ENTRY(40, "已入职");
    private int value;
    private String text;

    private interviewStatus(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int value() {
      return this.value;
    }

    public String getText() {
      return this.text;
    }

    public String valueStr() {
      return String.valueOf(value);
    }
  }

  private Date operatorDate;

  private String nowPositionId;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public String getOperatorUser() {
    return operatorUser;
  }

  public void setOperatorUser(String operatorUser) {
    this.operatorUser = operatorUser;
  }

  public String getPositionId() {
    return positionId;
  }

  public void setPositionId(String positionId) {
    this.positionId = positionId;
  }

  public String getInterviewStatus() {
    return interviewStatus;
  }

  public void setInterviewStatus(String interviewStatus) {
    this.interviewStatus = interviewStatus;
  }

  public Date getOperatorDate() {
    return operatorDate;
  }

  public void setOperatorDate(Date operatorDate) {
    this.operatorDate = operatorDate;
  }

  public String getNowPositionId() {
    return nowPositionId;
  }

  public void setNowPositionId(String nowPositionId) {
    this.nowPositionId = nowPositionId;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    CandidatePost other = (CandidatePost) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getCandidateId() == null ? other.getCandidateId() == null : this.getCandidateId()
            .equals(other.getCandidateId()))
        && (this.getOperatorUser() == null ? other.getOperatorUser() == null : this
            .getOperatorUser().equals(other.getOperatorUser()))
        && (this.getPositionId() == null ? other.getPositionId() == null : this.getPositionId()
            .equals(other.getPositionId()))
        && (this.getInterviewStatus() == null ? other.getInterviewStatus() == null : this
            .getInterviewStatus().equals(other.getInterviewStatus()))
        && (this.getOperatorDate() == null ? other.getOperatorDate() == null : this
            .getOperatorDate().equals(other.getOperatorDate()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getCandidateId() == null) ? 0 : getCandidateId().hashCode());
    result = prime * result + ((getOperatorUser() == null) ? 0 : getOperatorUser().hashCode());
    result = prime * result + ((getPositionId() == null) ? 0 : getPositionId().hashCode());
    result =
        prime * result + ((getInterviewStatus() == null) ? 0 : getInterviewStatus().hashCode());
    result = prime * result + ((getOperatorDate() == null) ? 0 : getOperatorDate().hashCode());
    return result;
  }
}
