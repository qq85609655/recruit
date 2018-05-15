package org.amberframework.web.system.model;

import java.io.Serializable;
import java.util.List;

public class PageResource implements Serializable {
  
  //id
  private String id;
  
  //名称
  private String name;
  
  //菜单名称
  private String menuName;
  
  //资源Url
  private String url;
  
  //上级资源
  private String parentId;
  
  //上级资源全路径
  private String parentIds;
  
  //菜单图标
  private String icon;
  
  //是否在菜单中显示
  private String showAsMenu;
  
  //资源的权限表示符
  private String identifer;
  
  //资源权限标识符
  private String weight;
  
  //资源
  private List<PageResource> resourceList;

  //权限
  private String permission;
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
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

  public String getIdentifer() {
    return identifer;
  }

  public void setIdentifer(String identifer) {
    this.identifer = identifer;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public List<PageResource> getResourceList() {
    return resourceList;
  }

  public void setResourceList(List<PageResource> resourceList) {
    this.resourceList = resourceList;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }
}