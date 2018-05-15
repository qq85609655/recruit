package org.amberframework.web.system.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.dao.BaseUserRoleMapper;
import org.amberframework.web.system.dao.ResourceMapper;
import org.amberframework.web.system.dao.ResourcePermissionMapper;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserColumns;
import org.amberframework.web.system.model.BaseUserCriteria;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.UrlPermission;
import org.amberframework.web.system.pojo.LoginClient;
import org.amberframework.web.system.service.BaseUserService;
import org.amberframework.web.system.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.util.StringUtil;

@Service("resourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService {

  @Resource
  ResourceMapper resourceMapper;
  
  @Resource
  BaseUserRoleMapper baseUserRoleMapper;
  
  @Resource
  ResourcePermissionMapper resourcePermissionMapper;
  
  @Transactional
  @Override
  public List<PageResource> getResourcesByUserId(String userId) {
    List<PageResource> pageResourceList = resourceMapper.getResourcesUserId(userId, "0");
    if(pageResourceList !=null && pageResourceList.size()>0){
      for(int i=0;i<pageResourceList.size();i++){
        PageResource pageResource = pageResourceList.get(i);
        if(pageResource !=null){
          List<PageResource> chPageResource = resourceMapper.getResourcesUserId(userId, pageResource.getId());
          if(chPageResource !=null && chPageResource.size()>0){
            pageResourceList.get(i).setResourceList(chPageResource);
          }else{
            //删除没有子菜单的目录
            pageResourceList.remove(i);
            i=i-1;
          }
          
        }
      }
    }
    return pageResourceList;
  }

  @Override
  public List<PageResource> getResourceByFlag(String flag) {
    List<PageResource> pageParentResourceList =  resourceMapper.getParentResources();
    if(pageParentResourceList !=null && pageParentResourceList.size()>0){
      for(int i=0;i<pageParentResourceList.size();i++){
        PageResource pageResource = pageParentResourceList.get(i);
        if(pageResource !=null){
          List<PageResource> pageResourceList =  resourceMapper.getResourcesByFlag(flag, pageResource.getId());
          if(pageResourceList !=null && pageResourceList.size()>0){
            pageParentResourceList.get(i).setResourceList(pageResourceList);
          }else{
            //删除没有子菜单的目录
            pageParentResourceList.remove(i);
            i=i-1;
          }
        }
      }
    }
    return pageParentResourceList;
  }

  @Override
  public List<String> getRRPByRoleIdAndFlag(String roleId, String flag) {
    return resourceMapper.getRRPByRoleIdAndFlag(roleId,flag);
  }
  
  @Override
  public String getRoleIdByUserId(String userId){
    return baseUserRoleMapper.getRoleIdByUserId(userId);
  }


}
