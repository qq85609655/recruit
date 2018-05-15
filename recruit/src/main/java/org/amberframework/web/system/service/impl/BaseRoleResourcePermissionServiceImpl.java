package org.amberframework.web.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.ResourceMapper;
import org.amberframework.web.system.dao.RoleResourcePermissionMapper;
import org.amberframework.web.system.dao.UserResourcePermissionMapper;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserResourcePermission;
import org.amberframework.web.system.model.RoleResourcePermission;
import org.amberframework.web.system.service.BaseRoleResourcePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("baseRoleResourcePermissionService")
@Transactional
public class BaseRoleResourcePermissionServiceImpl implements BaseRoleResourcePermissionService{

  @Resource
  RoleResourcePermissionMapper roleResourcePermissionMapper;
  
  @Resource
  ResourceMapper resourceMapper;
  
  @Transactional
  @Override
  public int addRoleResourcePermission(String roleId, String resourceId, String permissionId,String flag) {
    //新增之前将roleId对应的资源权限删除
    roleResourcePermissionMapper.deleteRoleResourcePermissions(roleId,flag);
    int count = 0;
    String [] resourceIds = null; 
    String [] permissionIds = null; 
    List<RoleResourcePermission> roleResourcePermissionList = null;
    if(resourceId !=null && permissionId !=null && roleId !=null){
      resourceIds = resourceId.split(",");
      permissionIds = permissionId.split(",");
      if(resourceIds !=null && permissionIds !=null && permissionIds.length ==resourceIds.length && resourceIds.length>0)
        roleResourcePermissionList = new ArrayList<RoleResourcePermission>();
        for(int i=0;i<resourceIds.length;i++){
          RoleResourcePermission roleResourcePermission = new RoleResourcePermission();
          String u_id = UUID.randomUUID().toString().replace("-", "");
          roleResourcePermission.setId(u_id);
          roleResourcePermission.setRoleId(roleId);
          roleResourcePermission.setResourceId(resourceIds[i]);
          roleResourcePermission.setFlag(flag);
          roleResourcePermission.setPermissionId(permissionIds[i]);
          roleResourcePermissionList.add(roleResourcePermission);
        }
    }
   if( roleResourcePermissionList !=null && roleResourcePermissionList.size()>0){
     count = roleResourcePermissionMapper.insertRoleResourcePermissions(roleResourcePermissionList);
   }
    return count;
  }

}
