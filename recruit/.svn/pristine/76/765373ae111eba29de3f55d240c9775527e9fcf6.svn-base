package org.amberframework.web.system.dao;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.ResourcePermission;
import org.amberframework.web.system.model.RoleResourcePermission;
import org.amberframework.web.system.model.UrlPermission;
import org.amberframework.web.system.model.UserRole;
public interface RoleResourcePermissionMapper extends MyBatisBaseMapper {
  /**
   * 根据用户Id获取资源权限
   * @param userId
   * @return
   */
   List<UrlPermission> getResourcesPermissionByUserId(String userId);
   
   /**
    * 获取所有的资源权限
    * @return
    */
   List<UrlPermission> getAllResourcesPermission();
   
   /**
    * 批量新增
    * @param roleResourcePermissionList
    * @return
    */
   int insertRoleResourcePermissions(List<RoleResourcePermission> roleResourcePermissionList);
   
   /**
    * 删除roleId对应的权限和资源
    * @param roleId
    * @return
    */
   int deleteRoleResourcePermissions(String roleId,String flag);
   
   /**
    * 根据roleId获取资源和权限的键值对
    * @param roleId
    * @return
    */
   List<RoleResourcePermission>  getPPIDByRoleId(String roleId);
     
   
}