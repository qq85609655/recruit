package org.amberframework.web.system.model;

import java.io.Serializable;

public class RoleResourcePermission implements Serializable {
  //id
  private String id;
  
  //资源Id
  private String resourceId;
  
  //角色Id
  private String roleId;
  
  //权限Id
  private String permissionId;
  
  //权限标识
  private String flag;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(String permissionId) {
    this.permissionId = permissionId;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }
  
  
  
}