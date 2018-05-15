package com.csot.recruit.model.original.flow.websitePost;

import java.io.Serializable;
import java.util.Date;

public class PostWebsite implements Serializable {
  private String id;
  // 岗位id
  private String postId;
  // 岗位详情id
  private String recruitPositionId;
  // 岗位名称
  private String postName;
  // 招聘代表id
  private String deputyId;
  // 招聘代表名称
  private String deputyName;
  // 最后指令时间
  private Date instructDate;
  // 发布网站岗位名称
  private String websitePostName;
  // 当前发布状态
  private String state;

  // 当前发布状态枚举
  public enum state {
    WFB(3, "未发布"), FBZ(1, "发布中"), ZT(2, "暂停"), SC(4, "删除");
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

  // 最后指令类型
  private String lastInstruct;

  public enum lastInstruct {
    FB(1, "发布"), XG(2, "修改"), ZT(3, "暂停"), CQ(4, "重启"), CXFB(5, "删除并且重新发布"), SC(6, "删除");
    private int value;
    private String text;

    private lastInstruct(int value, String text) {
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
  private Date createDate;
  private Date updateDate;
  private String modifiedId;
  private String modifiedName;
  // 发布渠道类型
  private String websiteType;

  // 发布渠道类型
  public enum websiteType {
    QCWY(1, "前程无忧网"), ZL(2, "智联"), LPW(3, "猎聘网"), RCRX(4, "人才热线"), HXGW(5, "华星官网"), JK(6, "荐客"), WB(
        7, "58"), GJW(8, "赶集网");
    private int value;
    private String text;

    private websiteType(int value, String text) {
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

  public String getModifiedName() {
    return modifiedName;
  }

  public void setModifiedName(String modifiedName) {
    this.modifiedName = modifiedName;
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
    PostWebsite other = (PostWebsite) that;
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
            .equals(other.getWebsiteType()));
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
    return result;
  }
}
