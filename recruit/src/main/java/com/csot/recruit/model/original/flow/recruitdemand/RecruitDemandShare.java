package com.csot.recruit.model.original.flow.recruitdemand;

import java.io.Serializable;
import java.util.Date;

public class RecruitDemandShare implements Serializable {
  private String id;

  private String recruitDemandId;

  private String shaerPersonId;
  
  private String shaerPersonName;
  
  private String remark;
  
  private String creatorId;

  private Date createDate;

  private String postId;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRecruitDemandId() {
    return recruitDemandId;
  }

  public void setRecruitDemandId(String recruitDemandId) {
    this.recruitDemandId = recruitDemandId;
  }

  public String getShaerPersonId() {
    return shaerPersonId;
  }

  public void setShaerPersonId(String shaerPersonId) {
    this.shaerPersonId = shaerPersonId;
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

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getShaerPersonName() {
    return shaerPersonName;
  }

  public void setShaerPersonName(String shaerPersonName) {
    this.shaerPersonName = shaerPersonName;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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
    RecruitDemandShare other = (RecruitDemandShare) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getRecruitDemandId() == null ? other.getRecruitDemandId() == null : this
            .getRecruitDemandId().equals(other.getRecruitDemandId()))
        && (this.getShaerPersonId() == null ? other.getShaerPersonId() == null : this
            .getShaerPersonId().equals(other.getShaerPersonId()))
        && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId()
            .equals(other.getCreatorId()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate()
            .equals(other.getCreateDate()))
        && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(
            other.getPostId()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result =
        prime * result + ((getRecruitDemandId() == null) ? 0 : getRecruitDemandId().hashCode());
    result = prime * result + ((getShaerPersonId() == null) ? 0 : getShaerPersonId().hashCode());
    result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
    return result;
  }
}