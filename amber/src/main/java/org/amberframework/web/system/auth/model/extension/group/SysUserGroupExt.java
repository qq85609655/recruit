package org.amberframework.web.system.auth.model.extension.group;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysUserGroupExt implements Serializable {
  private BigDecimal id;

  private String userId;

  private Long groupId;

  private static final long serialVersionUID = 1L;

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
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
    SysUserGroupExt other = (SysUserGroupExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(
            other.getUserId()))
        && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(
            other.getGroupId()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
    result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
    return result;
  }
}
