package com.csot.recruit.model.original.flow.websitePost;

import java.io.Serializable;

public class PostWebsiteVo extends PostWebsite implements Serializable {
  public PostWebsiteVo(PostWebsite postWebsite) {
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
    this.setModifiedName(postWebsite.getModifiedName());
  }

  // 扩展属性 star
  private String lastInstructName; // 最后指令类型名称
  private String stateName; // 状态名称
  private String websiteTypeName; // 招聘渠道名称
  private String instructDateName; // 招聘渠道名称
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

}
