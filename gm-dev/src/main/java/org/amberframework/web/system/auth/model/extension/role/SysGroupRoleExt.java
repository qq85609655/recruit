package org.amberframework.web.system.auth.model.extension.role;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysGroupRoleExt implements Serializable {
  private BigDecimal id;

  private Long groupId;

  private Long roleId;

  private String extended;

  private static final long serialVersionUID = 1L;

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getExtended() {
    return extended;
  }

  public void setExtended(String extended) {
    this.extended = extended;
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
    SysGroupRoleExt other = (SysGroupRoleExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(
            other.getGroupId()))
        && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(
            other.getRoleId()))
        && (this.getExtended() == null ? other.getExtended() == null : this.getExtended().equals(
            other.getExtended()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
    result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
    result = prime * result + ((getExtended() == null) ? 0 : getExtended().hashCode());
    return result;
  }
}
