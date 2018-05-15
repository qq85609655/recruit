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
import javax.validation.Valid;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.ResourceMapper;
import org.amberframework.web.system.dao.RoleResourcePermissionMapper;
import org.amberframework.web.system.dao.UserResourcePermissionMapper;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserResourcePermission;
import org.amberframework.web.system.model.RoleResourcePermission;
import org.amberframework.web.system.service.BaseRoleResourcePermissionService;
import org.amberframework.web.system.service.BaseUserResourcePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("baseUserResourcePermissionService")
@Transactional
public class BaseUserResourcePermissionServiceImpl implements BaseUserResourcePermissionService{

  @Resource
  RoleResourcePermissionMapper roleResourcePermissionMapper;
  
  @Resource
  UserResourcePermissionMapper userResourcePermissionMapper;

  @Transactional
  @Override
  public int addUserResourcePermission(String roleId, String resourceId, String permissionId,
      String userId) {
      //删除用户资源权限表中的该用户的资源和权限
      userResourcePermissionMapper.deleteUserResourcePermissions(userId);
     //去除资源中不含含有角色该资源的资源
      List<String> resourceList = getListByStr(resourceId);
      List<String> permissionList = getListByStr(permissionId);
      if(resourceList !=null && permissionList !=null && resourceList.size()==permissionList.size() && resourceList.size()>0){
        List<RoleResourcePermission> RoleResourcePermissionList = roleResourcePermissionMapper.getPPIDByRoleId(roleId);
        if(RoleResourcePermissionList !=null && RoleResourcePermissionList.size()>0){
          for(int i=0;i<RoleResourcePermissionList.size();i++){
            RoleResourcePermission roleResourcePermission= RoleResourcePermissionList.get(i);
            if(roleResourcePermission !=null){
              resourceList.remove(roleResourcePermission.getResourceId());
              permissionList.remove(roleResourcePermission.getPermissionId());
            }
          }
          if(resourceList.size() == permissionList.size() && resourceList.size()>0 ){
            List<BaseUserResourcePermission> baseUserResourcePermissionList = new ArrayList<BaseUserResourcePermission>();
            for(int j=0;j<resourceList.size();j++){
              BaseUserResourcePermission baseUserResourcePermission = new BaseUserResourcePermission();
              String u_id = UUID.randomUUID().toString().replace("-", "");
              baseUserResourcePermission.setId(u_id);
              baseUserResourcePermission.setUserId(userId);
              baseUserResourcePermission.setResourceId(resourceList.get(j));
              baseUserResourcePermission.setPermissionId(permissionList.get(j));
              baseUserResourcePermissionList.add(baseUserResourcePermission);
            }
           int count =  userResourcePermissionMapper.insertBaseUserResourcePermission(baseUserResourcePermissionList);
           return count;
          }
        }
      }
    return 0;
  }
  
  private List<String> getListByStr(String str){
    if(str !=null && !"".equals(str)){
      String[] strArray= str.split(",");
      if(strArray !=null && strArray.length>0){
        List<String> strList = new ArrayList<String>();
        for(int i=0;i<strArray.length;i++){
          strList.add(strArray[i]);
        }
        return strList;
      }
    }
    return null;
  }

  @Override
  public int deleteUserResourcePermissionByUserid(String userId) {
    return userResourcePermissionMapper.deleteUserResourcePermissions(userId);
  }

  @Override
  public List<String> getUPPByUserId(String userId) {
    List<String> resourceIds = userResourcePermissionMapper.getUPPByUserId(userId);
    if(resourceIds !=null && resourceIds.size()>0){
      return resourceIds;
    }
    return null;
  }
  
}
