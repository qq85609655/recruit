package org.amberframework.web.system.auth.model.extension.group;

import java.io.Serializable;

public class SysGroupExt implements Serializable {
  private Long id;

  private String name;

  private Long parentId;

  private String parentIds;

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

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getParentIds() {
    return parentIds;
  }

  public void setParentIds(String parentIds) {
    this.parentIds = parentIds;
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
    SysGroupExt other = (SysGroupExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getName() == null ? other.getName() == null : this.getName().equals(
            other.getName()))
        && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(
            other.getParentId()))
        && (this.getParentIds() == null ? other.getParentIds() == null : this.getParentIds()
            .equals(other.getParentIds()))
        && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(
            other.getEnabled()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
    result = prime * result + ((getParentIds() == null) ? 0 : getParentIds().hashCode());
    result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
    return result;
  }
}
