package org.amberframework.web.system.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.model.BaseUser;

public interface BaseRoleResourcePermissionService {
  /**
   * 添加角色的资源和权限
   * @param roleId
   * @param resourceId
   * @param permissionId
   * @param flag
   * @return
   */
  public int addRoleResourcePermission(String roleId,String resourceId,String permissionId,String flag);
  
  
}
