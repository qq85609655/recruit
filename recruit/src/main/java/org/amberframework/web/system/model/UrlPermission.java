package org.amberframework.web.system.model;

import java.io.Serializable;

public class UrlPermission implements Serializable {
  //地址
  private String url;
  
  //权限
  private String permission;
  
  //名称
  private String name ;
  

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }
  
}