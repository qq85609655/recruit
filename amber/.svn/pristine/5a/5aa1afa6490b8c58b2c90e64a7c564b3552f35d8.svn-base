package org.amberframework.web.system.auth.model.extension.role;

import java.io.Serializable;

public class SysRoleExt implements Serializable {
  private Long id;

  private String name;

  private String role;

  private String description;

  private String enabled;

  private static final long serialVersionUID = 1L;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
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
    SysRoleExt other = (SysRoleExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getName() == null ? other.getName() == null : this.getName().equals(
            other.getName()))
        && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(
            other.getRole()))
        && (this.getDescription() == null ? other.getDescription() == null : this.getDescription()
            .equals(other.getDescription()))
        && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(
            other.getEnabled()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
    result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
    result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
    return result;
  }
}
