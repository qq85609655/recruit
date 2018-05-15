package org.amberframework.web.system.dao;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.model.BaseUserResourcePermission;
public interface UserResourcePermissionMapper extends MyBatisBaseMapper {
   /**
    * 删除userId对应的权限和资源
    * @param roleId
    * @return
    */
   int deleteUserResourcePermissions(String userId);
   
   /**
    * 获取该用户的资源和权限
    * @param userId
    * @return
    */
   List<BaseUserResourcePermission> getAllResourcePermissionByUserId(String userId);
   
   /**
    * 插入所有的该用户的资源和权限
    * @param baseUserResourcePermissionList
    * @return
    */
   int insertBaseUserResourcePermission(List<BaseUserResourcePermission> baseUserResourcePermissionList);
   
   /**
    * 根据用户Id获取资源Id
    * @param userId
    * @return
    */
   List<String> getUPPByUserId(String userId);
    
   
     
   
}