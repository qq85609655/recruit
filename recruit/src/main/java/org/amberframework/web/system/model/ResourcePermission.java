package org.amberframework.web.system.model;

import java.io.Serializable;

public class ResourcePermission implements Serializable {
  
  //id
  private String id;
  
  //资源Id
  private String resourceId;
  
  //权限Id
  private String permissionId;

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

  public String getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(String permissionId) {
    this.permissionId = permissionId;
  }
  
}