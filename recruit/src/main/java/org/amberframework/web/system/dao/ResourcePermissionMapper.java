package org.amberframework.web.system.dao;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.ResourcePermission;
import org.amberframework.web.system.model.UrlPermission;
import org.amberframework.web.system.model.UserRole;
public interface ResourcePermissionMapper extends MyBatisBaseMapper {
  /**
   * 根据用户Id获取资源权限
   * @param userId
   * @return
   */
   List<UrlPermission> getResourcesPermissionByUserId(String userId );
   
   /**
    * 获取所有的资源权限
    * @return
    */
   List<UrlPermission> getAllResourcesPermission();
   
   /**
    * 获取用户所对应的所有的资源与权限
    * @param userId
    * @return
    */
   List<UrlPermission> getAllUPByUserId(String userId );
   
   
}