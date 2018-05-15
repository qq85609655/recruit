package com.csot.recruit.model.original.flow.employ;

import java.io.Serializable;
import java.util.Date;

public class EmployBlacklist implements Serializable {
  private String id;

  private String candidateId;

  private String candidateName;

  private String inReason;

  private String outReason;

  private String state;

  public enum state {
    YES(1, "生效"), NO(2, "未生效");
    private int value;
    private String text;

    private state(int value, String text) {
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

  private String creatorId;

  private Date createDate;

  private String modifiedId;

  private Date updateDate;

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

  public String getCandidateName() {
    return candidateName;
  }

  public void setCandidateName(String candidateName) {
    this.candidateName = candidateName;
  }

  public String getInReason() {
    return inReason;
  }

  public void setInReason(String inReason) {
    this.inReason = inReason;
  }

  public String getOutReason() {
    return outReason;
  }

  public void setOutReason(String outReason) {
    this.outReason = outReason;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(String creatorId) {
    this.creatorId = creatorId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getModifiedId() {
    return modifiedId;
  }

  public void setModifiedId(String modifiedId) {
    this.modifiedId = modifiedId;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
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
    EmployBlacklist other = (EmployBlacklist) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getCandidateId() == null ? other.getCandidateId() == null : this.getCandidateId()
            .equals(other.getCandidateId()))
        && (this.getCandidateName() == null ? other.getCandidateName() == null : this
            .getCandidateName().equals(other.getCandidateName()))
        && (this.getInReason() == null ? other.getInReason() == null : this.getInReason().equals(
            other.getInReason()))
        && (this.getOutReason() == null ? other.getOutReason() == null : this.getOutReason()
            .equals(other.getOutReason()))
        && (this.getState() == null ? other.getState() == null : this.getState().equals(
            other.getState()))
        && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId()
            .equals(other.getCreatorId()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate()
            .equals(other.getCreateDate()))
        && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId()
            .equals(other.getModifiedId()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate()
            .equals(other.getUpdateDate()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getCandidateId() == null) ? 0 : getCandidateId().hashCode());
    result = prime * result + ((getCandidateName() == null) ? 0 : getCandidateName().hashCode());
    result = prime * result + ((getInReason() == null) ? 0 : getInReason().hashCode());
    result = prime * result + ((getOutReason() == null) ? 0 : getOutReason().hashCode());
    result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
    result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    return result;
  }
}
