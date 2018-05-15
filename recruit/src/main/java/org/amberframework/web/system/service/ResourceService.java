package org.amberframework.web.system.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.Permission;

public interface ResourceService {
 
  /**
   * 根据用户获得菜单权限
   * @param userId
   * @return
   */
 List<PageResource> getResourcesByUserId(String userId);  
 
 /**
  * 根据标识符获得权限
  * @param flag
  * @return
  */
 List<PageResource> getResourceByFlag(String flag);
 
 /**
  * 根据标识符和userId获取RoleId
  * @param userId
  * @param flag
  * @return
  */
  String getRoleIdByUserId(String userId);
 
 /**
  * 获取角色相应的权限和资源
  * @param roleId
  * @param flag
  * @return
  */
 List<String> getRRPByRoleIdAndFlag(String roleId,String flag);
 
}
