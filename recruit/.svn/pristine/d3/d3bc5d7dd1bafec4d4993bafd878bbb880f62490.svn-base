package org.amberframework.web.system.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.model.BaseUser;

public interface BaseUserResourcePermissionService {
  
  /**
   * 添加用户的资源何权限
   * @param roleId
   * @param resourceId
   * @param permissionId
   * @param userId
   * @return
   */
  public int addUserResourcePermission(String roleId, String resourceId, String permissionId,String userId);
  
  /**
   * 根据userId删除用户
   * @param userId
   * @return
   */
  public int deleteUserResourcePermissionByUserid(String userId);
  
  /**
   * 根据userId获取资源Id
   * @param userId
   * @return
   */
  public List<String> getUPPByUserId(String userId);
}
