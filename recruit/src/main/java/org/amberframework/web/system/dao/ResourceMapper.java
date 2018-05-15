package org.amberframework.web.system.dao;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.UserRole;
public interface ResourceMapper extends MyBatisBaseMapper {
  /**
   * 根据userId获取父菜单
   * @param userId
   * @param parentId
   * @return
   */
   List<PageResource> getResourcesUserId(String userId ,String parentId );
   
   /**
    * 获取父菜单
    * @return
    */
   List<PageResource> getParentResources();
   
   /**
    * 根据父Id和标识符获取资源
    * @param flag
    * @param id
    * @return
    */
   List<PageResource> getResourcesByFlag(String flag,String id);
   
  /**
   * 根据roleId和Flag查询资源Id
   * @param roleId
   * @param flag
   * @return
   */
   List<String> getRRPByRoleIdAndFlag(String roleId,String flag);
   
   
}