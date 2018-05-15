package org.amberframework.web.system.auth.model.extension.resource;

import java.io.Serializable;

public class SysResourceExt implements Serializable {
  private Long id;

  private String name;

  private String menuName;

  private String url;

  private Long parentId;

  private String parentIds;

  private String icon;

  private String showAsMenu;

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

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getShowAsMenu() {
    return showAsMenu;
  }

  public void setShowAsMenu(String showAsMenu) {
    this.showAsMenu = showAsMenu;
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
    SysResourceExt other = (SysResourceExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getName() == null ? other.getName() == null : this.getName().equals(
            other.getName()))
        && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(
            other.getMenuName()))
        && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
        && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(
            other.getParentId()))
        && (this.getParentIds() == null ? other.getParentIds() == null : this.getParentIds()
            .equals(other.getParentIds()))
        && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(
            other.getIcon()))
        && (this.getShowAsMenu() == null ? other.getShowAsMenu() == null : this.getShowAsMenu()
            .equals(other.getShowAsMenu()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
    result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
    result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
    result = prime * result + ((getParentIds() == null) ? 0 : getParentIds().hashCode());
    result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
    result = prime * result + ((getShowAsMenu() == null) ? 0 : getShowAsMenu().hashCode());
    return result;
  }
}
