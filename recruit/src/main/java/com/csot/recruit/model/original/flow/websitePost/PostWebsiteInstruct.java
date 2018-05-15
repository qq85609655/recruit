package com.csot.recruit.model.original.flow.websitePost;

import java.io.Serializable;
import java.util.Date;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;

public class PostWebsiteInstruct implements Serializable {
  private String id;

  private String beforeState;

  public PostWebsiteInstruct() {}

  public PostWebsiteInstruct(RecruitDemand recruitDemand, String usrId,String isDeal) {
    this.setIsDeal(isDeal);
    this.setCreateDate(new Date());
    this.setCreatorId(usrId);
    this.setDeputyId(recruitDemand.getDeputyId());
    this.setDeputyName(recruitDemand.getDeputyName());
    this.setPostId(recruitDemand.getApplyPostId());
    this.setPostName(recruitDemand.getApplyPostName());
  }

  public enum state {
    WFB(3, "未发布"), FBZ(1, "发布中"), ZT(2, "暂停"),SC(4, "删除");
    private int value;
    private String text;

    private state(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int getValue() {
      return this.value;
    }

    public String getValueStr() {
      return String.valueOf(this.value);
    }

    public String getText() {
      return this.text;
    }
  }

  private String afterState;

  private String instructType;

  public enum instructType {
    FB(1, "发布"), XG(2, "修改"), ZT(3, "暂停"), CQ(4, "重启"), CXFB(5, "删除并且重新发布"), SC(6, "删除");
    private int value;
    private String text;

    private instructType(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int getValue() {
      return this.value;
    }

    public String getValueStr() {
      return String.valueOf(this.value);
    }

    public String getText() {
      return this.text;
    }
  }

  private String postWebsiteId;

  private Date createDate;

  private String isDeal;

  public enum isDeal {
    YES(1, "已处理"), NO(2, "未处理");
    private int value;
    private String text;

    private isDeal(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int getValue() {
      return this.value;
    }

    public String getValueStr() {
      return String.valueOf(this.value);
    }

    public String getText() {
      return this.text;
    }
  }

  private String creatorId;

  private Date updateDate;

  private String modifiedId;

  private String postId;

  private String recruitPositionId;

  private String postName;

  private String deputyId;

  private String deputyName;

  private String websitePostName;

  private String websiteType;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBeforeState() {
    return beforeState;
  }

  public void setBeforeState(String beforeState) {
    this.beforeState = beforeState;
  }

  public String getAfterState() {
    return afterState;
  }

  public void setAfterState(String afterState) {
    this.afterState = afterState;
  }

  public String getInstructType() {
    return instructType;
  }

  public void setInstructType(String instructType) {
    this.instructType = instructType;
  }

  public String getPostWebsiteId() {
    return postWebsiteId;
  }

  public void setPostWebsiteId(String postWebsiteId) {
    this.postWebsiteId = postWebsiteId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getIsDeal() {
    return isDeal;
  }

  public void setIsDeal(String isDeal) {
    this.isDeal = isDeal;
  }

  public String getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(String creatorId) {
    this.creatorId = creatorId;
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

  public String getWebsitePostName() {
    return websitePostName;
  }

  public void setWebsitePostName(String websitePostName) {
    this.websitePostName = websitePostName;
  }

  public String getWebsiteType() {
    return websiteType;
  }

  public void setWebsiteType(String websiteType) {
    this.websiteType = websiteType;
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
    PostWebsiteInstruct other = (PostWebsiteInstruct) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getBeforeState() == null ? other.getBeforeState() == null : this.getBeforeState()
            .equals(other.getBeforeState()))
        && (this.getAfterState() == null ? other.getAfterState() == null : this.getAfterState()
            .equals(other.getAfterState()))
        && (this.getInstructType() == null ? other.getInstructType() == null : this
            .getInstructType().equals(other.getInstructType()))
        && (this.getPostWebsiteId() == null ? other.getPostWebsiteId() == null : this
            .getPostWebsiteId().equals(other.getPostWebsiteId()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate()
            .equals(other.getCreateDate()))
        && (this.getIsDeal() == null ? other.getIsDeal() == null : this.getIsDeal().equals(
            other.getIsDeal()))
        && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId()
            .equals(other.getCreatorId()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate()
            .equals(other.getUpdateDate()))
        && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId()
            .equals(other.getModifiedId()))
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
        && (this.getWebsitePostName() == null ? other.getWebsitePostName() == null : this
            .getWebsitePostName().equals(other.getWebsitePostName()))
        && (this.getWebsiteType() == null ? other.getWebsiteType() == null : this.getWebsiteType()
            .equals(other.getWebsiteType()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getBeforeState() == null) ? 0 : getBeforeState().hashCode());
    result = prime * result + ((getAfterState() == null) ? 0 : getAfterState().hashCode());
    result = prime * result + ((getInstructType() == null) ? 0 : getInstructType().hashCode());
    result = prime * result + ((getPostWebsiteId() == null) ? 0 : getPostWebsiteId().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getIsDeal() == null) ? 0 : getIsDeal().hashCode());
    result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
    result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
    result =
        prime * result + ((getRecruitPositionId() == null) ? 0 : getRecruitPositionId().hashCode());
    result = prime * result + ((getPostName() == null) ? 0 : getPostName().hashCode());
    result = prime * result + ((getDeputyId() == null) ? 0 : getDeputyId().hashCode());
    result = prime * result + ((getDeputyName() == null) ? 0 : getDeputyName().hashCode());
    result =
        prime * result + ((getWebsitePostName() == null) ? 0 : getWebsitePostName().hashCode());
    result = prime * result + ((getWebsiteType() == null) ? 0 : getWebsiteType().hashCode());
    return result;
  }
}
