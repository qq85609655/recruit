package com.csot.recruit.model.vo;

import java.io.Serializable;

public class EstimateEmailTemplate implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String candidateId;

  private String positionId;

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
}
