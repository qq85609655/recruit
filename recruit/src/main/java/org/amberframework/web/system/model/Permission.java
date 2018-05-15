package org.amberframework.web.system.model;

import java.io.Serializable;

public class Permission implements Serializable {
 private String id;
  
  //权限名称
  private String name;
  
  //描述
  private String description;
  
  //权限字段
  private String permission;
  
  //是否可用(1-->可用 0-->不可用)
  private String enable;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public String getEnable() {
    return enable;
  }

  public void setEnable(String enable) {
    this.enable = enable;
  }
  
  

}