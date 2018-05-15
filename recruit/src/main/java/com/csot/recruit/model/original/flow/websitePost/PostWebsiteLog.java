package com.csot.recruit.model.original.flow.websitePost;

import java.io.Serializable;
import java.util.Date;

public class PostWebsiteLog implements Serializable {
  private String id;

  /**
   * 职位编码
   */
  private String postId;
  /**
   * 岗位详情表id
   */
  private String recruitPositionId;
  /**
   * 岗位名称
   */
  private String postName;
  /**
   * 招聘代表工号
   */
  private String deputyId;
  /**
   * 招聘代表姓名
   */
  private String deputyName;
  /**
   * 指令操作时间
   */
  private Date instructDate;
  /**
   * 网站岗位名称
   */
  private String websitePostName;
  /**
   * 操作后状态
   */
  private String state;
  /**
   * 最后的操作类型
   */
  private String lastInstruct;

  private String creatorId;

  private Date createDate;

  private Date updateDate;

  private String modifiedId;
  /**
   * 渠道类型
   */
  private String websiteType;
  /**
   * 操作前状态
   */
  private String beforeState;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getRecruitPositionId() {
    return recruitPositionId;
  }

  public void setRecruitPositionId(String recruitPositionId) {
    this.recruitPositionId = recruitPositionId;
  }

  public String getPostName() {
    return postName;
  }

  public void setPostName(String postName) {
    this.postName = postName;
  }

  public String getDeputyId() {
    return deputyId;
  }

  public void setDeputyId(String deputyId) {
    this.deputyId = deputyId;
  }

  public String getDeputyName() {
    return deputyName;
  }

  public void setDeputyName(String deputyName) {
    this.deputyName = deputyName;
  }

  public Date getInstructDate() {
    return instructDate;
  }

  public void setInstructDate(Date instructDate) {
    this.instructDate = instructDate;
  }

  public String getWebsitePostName() {
    return websitePostName;
  }

  public void setWebsitePostName(String websitePostName) {
    this.websitePostName = websitePostName;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getLastInstruct() {
    return lastInstruct;
  }

  public void setLastInstruct(String lastInstruct) {
    this.lastInstruct = lastInstruct;
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

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public String getModifiedId() {
    return modifiedId;
  }

  public void setModifiedId(String modifiedId) {
    this.modifiedId = modifiedId;
  }

  public String getWebsiteType() {
    return websiteType;
  }

  public void setWebsiteType(String websiteType) {
    this.websiteType = websiteType;
  }

  public String getBeforeState() {
    return beforeState;
  }

  public void setBeforeState(String beforeState) {
    this.beforeState = beforeState;
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
    PostWebsiteLog other = (PostWebsiteLog) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(
            other.getPostId()))
        && (this.getRecruitPositionId() == null ? other.getRecruitPositionId() == null : this
            .getRecruitPositionId().equals(other.getRecruitPositionId()))
        && (this.getPostName() == null ? other.getPostName() == null : this.getPostName().equals(
            other.getPostName()))
        && (this.getDeputyId() == null ? other.getDeputyId() == null : this.getDeputyId().equals(
            other.getDeputyId()))
        && (this.getDeputyName() == null ? other.getDeputyName() == null : this.getDeputyName()
            .equals(other.getDeputyName()))
        && (this.getInstructDate() == null ? other.getInstructDate() == null : this
            .getInstructDate().equals(other.getInstructDate()))
        && (this.getWebsitePostName() == null ? other.getWebsitePostName() == null : this
            .getWebsitePostName().equals(other.getWebsitePostName()))
        && (this.getState() == null ? other.getState() == null : this.getState().equals(
            other.getState()))
        && (this.getLastInstruct() == null ? other.getLastInstruct() == null : this
            .getLastInstruct().equals(other.getLastInstruct()))
        && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId()
            .equals(other.getCreatorId()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate()
            .equals(other.getCreateDate()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate()
            .equals(other.getUpdateDate()))
        && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId()
            .equals(other.getModifiedId()))
        && (this.getWebsiteType() == null ? other.getWebsiteType() == null : this.getWebsiteType()
            .equals(other.getWebsiteType()))
        && (this.getBeforeState() == null ? other.getBeforeState() == null : this.getBeforeState()
            .equals(other.getBeforeState()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
    result =
        prime * result + ((getRecruitPositionId() == null) ? 0 : getRecruitPositionId().hashCode());
    result = prime * result + ((getPostName() == null) ? 0 : getPostName().hashCode());
    result = prime * result + ((getDeputyId() == null) ? 0 : getDeputyId().hashCode());
    result = prime * result + ((getDeputyName() == null) ? 0 : getDeputyName().hashCode());
    result = prime * result + ((getInstructDate() == null) ? 0 : getInstructDate().hashCode());
    result =
        prime * result + ((getWebsitePostName() == null) ? 0 : getWebsitePostName().hashCode());
    result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
    result = prime * result + ((getLastInstruct() == null) ? 0 : getLastInstruct().hashCode());
    result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
    result = prime * result + ((getWebsiteType() == null) ? 0 : getWebsiteType().hashCode());
    result = prime * result + ((getBeforeState() == null) ? 0 : getBeforeState().hashCode());
    return result;
  }
}
