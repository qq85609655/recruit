package com.csot.recruit.model.original.flow.websitePost;

import java.io.Serializable;

public class PostWebsiteLogVo extends PostWebsiteLog implements Serializable {
  public PostWebsiteLogVo(PostWebsiteLog postWebsite) {
    this.setId(postWebsite.getId());
    this.setCreateDate(postWebsite.getCreateDate());
    this.setCreatorId(postWebsite.getCreatorId());
    this.setDeputyId(postWebsite.getDeputyId());
    this.setDeputyName(postWebsite.getDeputyName());
    this.setInstructDate(postWebsite.getInstructDate());
    this.setLastInstruct(postWebsite.getLastInstruct());
    this.setModifiedId(postWebsite.getModifiedId());
    this.setPostId(postWebsite.getPostId());
    this.setPostName(postWebsite.getPostName());
    this.setRecruitPositionId(postWebsite.getRecruitPositionId());
    this.setState(postWebsite.getState());
    this.setUpdateDate(postWebsite.getUpdateDate());
    this.setWebsitePostName(postWebsite.getWebsitePostName());
    this.setWebsiteType(postWebsite.getWebsiteType());
    this.setBeforeState(postWebsite.getBeforeState());
  }

  // 扩展属性 star
  private String lastInstructName; // 指令类型名称

  private String stateName; // 操作前状态
  private String websiteTypeName; // 发布渠道名称
  private String instructDateName; // 指令时间
  private String beforeStateName; // 操作后状态

  // 扩展属性 end

  private static final long serialVersionUID = 1L;

  public String getLastInstructName() {
    return lastInstructName;
  }

  public void setLastInstructName(String lastInstructName) {
    this.lastInstructName = lastInstructName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getWebsiteTypeName() {
    return websiteTypeName;
  }

  public void setWebsiteTypeName(String websiteTypeName) {
    this.websiteTypeName = websiteTypeName;
  }

  public String getInstructDateName() {
    return instructDateName;
  }

  public void setInstructDateName(String instructDateName) {
    this.instructDateName = instructDateName;
  }

  public String getBeforeStateName() {
    return beforeStateName;
  }

  public void setBeforeStateName(String beforeStateName) {
    this.beforeStateName = beforeStateName;
  }

}
