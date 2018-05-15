package org.amberframework.web.system.auth.model.extension.permission;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysRoleResourcePermissionExt implements Serializable {
  private BigDecimal id;

  private Long roleId;

  private Long resourceId;

  private Long permissionId;

  private static final long serialVersionUID = 1L;

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getResourceId() {
    return resourceId;
  }

  public void setResourceId(Long resourceId) {
    this.resourceId = resourceId;
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
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
    SysRoleResourcePermissionExt other = (SysRoleResourcePermissionExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(
            other.getRoleId()))
        && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId()
            .equals(other.getResourceId()))
        && (this.getPermissionId() == null ? other.getPermissionId() == null : this
            .getPermissionId().equals(other.getPermissionId()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
    result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
    result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
    return result;
  }
}
