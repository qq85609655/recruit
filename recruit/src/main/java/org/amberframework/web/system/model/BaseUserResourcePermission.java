package org.amberframework.web.system.model;

import java.io.Serializable;
import java.util.Date;

public class BaseUserResourcePermission implements Serializable {
    private String id;
    
    private String resourceId;
    
    private String permissionId;
    
    private String userId;

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

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }
    
    

}