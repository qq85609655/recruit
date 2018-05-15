package org.amberframework.web.system.dao;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.UserRole;
public interface BaseUserRoleMapper extends MyBatisBaseMapper {
  
   /**
    * 根据用户获取角色
    * @param userId
    * @return
    */
   String getRoleIdByUserId(String userId);

   /**
    * 根据userId获取Role
    * @param userId
    * @return
    */
   List<UserRole> getUserRoleByUserId(String userId);
}