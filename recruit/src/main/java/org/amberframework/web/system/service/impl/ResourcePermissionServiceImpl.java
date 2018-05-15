package org.amberframework.web.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.dao.ResourceMapper;
import org.amberframework.web.system.dao.ResourcePermissionMapper;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserColumns;
import org.amberframework.web.system.model.BaseUserCriteria;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.ResourcePermission;
import org.amberframework.web.system.model.UrlPermission;
import org.amberframework.web.system.pojo.LoginClient;
import org.amberframework.web.system.service.BaseUserService;
import org.amberframework.web.system.service.ResourcePermissionService;
import org.amberframework.web.system.service.ResourceService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.util.StringUtil;

@Service("resourcePermissionService")
@Transactional
public class ResourcePermissionServiceImpl implements ResourcePermissionService {

  @Resource
  ResourcePermissionMapper resourcePermissionMapper;

  @Transactional
  @Override
  public Map<String,String> getResourcesPermissionByUserId(String userId) {
    List<UrlPermission> roleUrlPermission = resourcePermissionMapper.getResourcesPermissionByUserId(userId);
    List<UrlPermission> userUrlPermission = resourcePermissionMapper.getAllUPByUserId(userId);
    Map<String,String> roleMap = getMap(roleUrlPermission);
    Map<String,String> userMap = getMap(userUrlPermission);
    Map<String,String> map = new HashMap<String,String>();
    if(roleMap!=null && roleMap.size()>0 ){
      map.putAll(roleMap);
    }
    if(userMap !=null && userMap.size()>0){
      map.putAll(userMap);
    }
    return map;
  }
  
  @Override
  public Map<String,String> getAllResourcesPermission(){
    List<UrlPermission> urlPermission =  resourcePermissionMapper.getAllResourcesPermission();
    return getMap(urlPermission);
  }

  /**
   * 将list数据转换为Map
   * @param urlPermission
   * @return
   */
  private Map<String,String> getMap(List<UrlPermission> urlPermission){
    Map<String,String> map = null;
    if(urlPermission !=null && urlPermission.size()>0){
      map= new HashMap();
      for(int i=0;i<urlPermission.size();i++){
        UrlPermission up = urlPermission.get(i);
        if(up !=null && up.getUrl() !=null){
          map.put(up.getUrl() , up.getPermission() );
        }
      }
    }
    return map;
  }
}
