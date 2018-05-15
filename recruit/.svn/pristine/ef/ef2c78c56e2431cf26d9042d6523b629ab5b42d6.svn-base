package com.csot.recruit.model.original.flow.recruitdemand;

import java.io.Serializable;
import java.util.Date;

public class RecruitDemandChange implements Serializable {
  private String id;

  private String type;
  
  private String demandChangeUrl;

  public String getDemandChangeUrl() {
    return demandChangeUrl;
  }

  public void setDemandChangeUrl(String demandChangeUrl) {
    this.demandChangeUrl = demandChangeUrl;
  }

  /**
   * 修改字段类型枚举
   */
  public enum type {
    /**
     * 申请人数
     */
    APPLYNUM(1),
    /**
     * 期望到岗时间
     */
    WANTCOMEDATE(2);

    private int value;

    private type(int value) {
      this.value = value;
    }

    public int value() {
      return this.value;
    }

    public String valueStr() {
      return String.valueOf(value);
    }
  }

  private String oldStr;

  private String newStr;

  private String demandId;

  private Date createDate;

  private String creatorId;

  private Date updateDate;
  /**
   * 是否处理
   */
  private String isDeal;

  /**
   * 是否处理枚举
   */
  public enum isDeal {
    /**
     * 否
     */
    NO(1),
    /**
     * 是
     */
    YES(2);

    private int value;

    private isDeal(int value) {
      this.value = value;
    }

    public int value() {
      return this.value;
    }

    public String valueStr() {
      return String.valueOf(value);
    }
  }

  private String isAgerr;

  /**
   * 是否同意枚举
   */
  public enum isAgerr {
    /**
     * 否
     */
    NO(1),
    /**
     * 是
     */
    YES(2);

    private int value;

    private isAgerr(int value) {
      this.value = value;
    }

    public int value() {
      return this.value;
    }

    public String valueStr() {
      return String.valueOf(value);
    }
  }

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getOldStr() {
    return oldStr;
  }

  public void setOldStr(String oldStr) {
    this.oldStr = oldStr;
  }

  public String getNewStr() {
    return newStr;
  }

  public void setNewStr(String newStr) {
    this.newStr = newStr;
  }

  public String getDemandId() {
    return demandId;
  }

  public void setDemandId(String demandId) {
    this.demandId = demandId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
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

  public String getIsDeal() {
    return isDeal;
  }

  public void setIsDeal(String isDeal) {
    this.isDeal = isDeal;
  }

  public String getIsAgerr() {
    return isAgerr;
  }

  public void setIsAgerr(String isAgerr) {
    this.isAgerr = isAgerr;
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
    RecruitDemandChange other = (RecruitDemandChange) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getType() == null ? other.getType() == null : this.getType().equals(
            other.getType()))
        && (this.getOldStr() == null ? other.getOldStr() == null : this.getOldStr().equals(
            other.getOldStr()))
        && (this.getNewStr() == null ? other.getNewStr() == null : this.getNewStr().equals(
            other.getNewStr()))
        && (this.getDemandId() == null ? other.getDemandId() == null : this.getDemandId().equals(
            other.getDemandId()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate()
            .equals(other.getCreateDate()))
        && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId()
            .equals(other.getCreatorId()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate()
            .equals(other.getUpdateDate()))
        && (this.getIsDeal() == null ? other.getIsDeal() == null : this.getIsDeal().equals(
            other.getIsDeal()))
        && (this.getIsAgerr() == null ? other.getIsAgerr() == null : this.getIsAgerr().equals(
            other.getIsAgerr()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
    result = prime * result + ((getOldStr() == null) ? 0 : getOldStr().hashCode());
    result = prime * result + ((getNewStr() == null) ? 0 : getNewStr().hashCode());
    result = prime * result + ((getDemandId() == null) ? 0 : getDemandId().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getIsDeal() == null) ? 0 : getIsDeal().hashCode());
    result = prime * result + ((getIsAgerr() == null) ? 0 : getIsAgerr().hashCode());
    return result;
  }
}
