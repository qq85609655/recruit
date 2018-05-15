package org.amberframework.web.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.BaseRoleMapper;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.dao.BaseUserRoleMapper;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserColumns;
import org.amberframework.web.system.model.BaseUserCriteria;
import org.amberframework.web.system.model.UserRole;
import org.amberframework.web.system.pojo.LoginClient;
import org.amberframework.web.system.service.BaseRoleService;
import org.amberframework.web.system.service.BaseUserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.util.StringUtil;

@Service("baseRoleService")
@Transactional
public class BaseRoleServiceImpl implements BaseRoleService {

  @Resource
  BaseUserRoleMapper baseUserRoleMapper;
  
  @Resource 
  BaseRoleMapper baseRoleMapper;
  

  @Override
  public BaseRole getBaseRoleByPrimaryKey(String id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int updateBaseRole(BaseRole baseRole) {
    return baseRoleMapper.updateSelective(baseRole);
  }

  @Override
  public int deleteBaseRoleById(String id) {
    return baseRoleMapper.deleteByPrimaryKey(id);
  }

  @Override
  public List<BaseRole> queryAllBaseRole() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 通过用户获取角色
   */
  @Override
  public List<BaseRole> getRolesByUserId(String userId) {
    List<BaseRole> baseRoleList;
    //查询得到role的ids
    List<UserRole> userRoles = baseUserRoleMapper.getUserRoleByUserId(userId);
    if(userRoles !=null && userRoles.size()>0){
      String ids = "";
      for(int i=0;i<userRoles.size();i++){
        UserRole userRole = userRoles.get(i);
        if(userRole !=null){
          if(i<userRoles.size()-1){
            ids += ",";
          }else{
            ids += userRoles.get(i).getRoleId();
          }
        }
      }
      //通过ids查询得到Role
        List<BaseRole> roles = baseRoleMapper.getRolesByIds(ids);
        if(roles !=null && roles.size()>0){
          baseRoleList = roles;
        }else{
          baseRoleList = null;
        }
        return baseRoleList;
        
    }
    return null;
  }

  @Override
  public MiniRtn2Grid<BaseRole> getBaseRoleList(MiniGridPageSort pageAndSort) {
    Map<String,Object> mapParam = new HashedMap();
    MiniRtn2Grid<BaseRole> data = null;
    if(pageAndSort !=null){
      mapParam.put("pageIndex", pageAndSort.getPageIndex());
      mapParam.put("sortField", pageAndSort.getSortField());
      mapParam.put("pageSize", pageAndSort.getPageSize());
      mapParam.put("sortOrder", pageAndSort.getSortOrder());
    }
    List<BaseRole> baseRoleList = baseRoleMapper.getBaseRoleList(mapParam);
    int total = baseRoleMapper.getBaseRoleCount();
    
    if(baseRoleList !=null && baseRoleList.size()>0){
      data= new MiniRtn2Grid();
      data.setData(baseRoleList);
      data.setTotal(total);
    }
    return data;
  }

  /**
   * 新增或修改role
   */
  @Transactional
  @Override
  public int cerateBaseRole(BaseRole baseRole) {
    int count = 0;
    if(baseRole !=null ){
      String id= baseRole.getId();
      if( id!=null && !"".endsWith(id)){
        count = baseRoleMapper.updateSelective(baseRole);
      }else{
        String u_id = UUID.randomUUID().toString().replace("-", "");
        baseRole.setId(u_id);
        count =  baseRoleMapper.insertSelective(baseRole);
      }
    }
    return count;
  }

  @Override
  public MiniRtn2Grid<BaseRole> getAllRole() {
    MiniRtn2Grid<BaseRole> data =null;
    List<BaseRole> baseRoleList = baseRoleMapper.getAllRole();
    if(baseRoleList !=null && baseRoleList.size()>0){
      data= new MiniRtn2Grid();
      data.setData(baseRoleList);
    }
    return data;
  }


}
