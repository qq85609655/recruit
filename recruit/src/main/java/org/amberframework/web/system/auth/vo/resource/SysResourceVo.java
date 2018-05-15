package org.amberframework.web.system.auth.vo.resource;

import java.io.Serializable;

public class SysResourceVo implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private String menuName;

  private String url;

  private Long parentId;

  private String parentIds;

  private String icon;

  private String showAsMenu;

  private String parentName;

  private String identifer;

  private Integer weight;
  
  private boolean checked;
  
  private boolean hasPermissions;

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

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getIdentifer() {
    return identifer;
  }

  public void setIdentifer(String identifer) {
    this.identifer = identifer;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public boolean isHasPermissions() {
    return hasPermissions;
  }

  public void setHasPermissions(boolean hasPermissions) {
    this.hasPermissions = hasPermissions;
  }

}
