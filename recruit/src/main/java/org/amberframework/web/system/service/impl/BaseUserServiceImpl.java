package org.amberframework.web.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserColumns;
import org.amberframework.web.system.model.BaseUserCriteria;
import org.amberframework.web.system.pojo.LoginClient;
import org.amberframework.web.system.service.BaseUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandCriteria;

@Service("baseUserService")
@Transactional
public class BaseUserServiceImpl implements BaseUserService {

  @Resource
  BaseUserMapper baseUserMapper;
  
  @Transactional
  @Override
  public boolean login(String username, String password, HttpSession session) {
    BaseUserCriteria baseUserCriteria = new BaseUserCriteria();
    baseUserCriteria.createCriteria().andAccountEqualTo(username).andPasswordEqualTo(password).andStatusEqualTo("1");
    List<BaseUser> userList = baseUserMapper.selectByExample(baseUserCriteria);
    if (userList != null && userList.size() > 0) {
      BaseUser baseUser = userList.get(0);
      LoginClient loginClient = new LoginClient();
      loginClient.setUser(baseUser);
      loginClient.setIp("");
      loginClient.setLoginTime(new Date());
      loginClient.setSuperAdmin(false);
      session.setAttribute(LoginClient.CLIENT_SESSION_ATTR, loginClient);
      return true;
    } else {
      return false;
    }
  }

  @Transactional
  @Override
  public MiniRtn2Grid<BaseUser> getBaseUserList(MiniGridPageSort pageAndSort,BaseUser baseUser) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("pageSize", pageAndSort.getPageSize());
    map.put("pageIndex", pageAndSort.getPageIndex());
    map.put("sortField", pageAndSort.getSortField());
    map.put("sortOrder", pageAndSort.getSortOrder());
    if(baseUser !=null){
      map.put("account", baseUser.getAccount());
      map.put("name", baseUser.getName());
      map.put("tel", baseUser.getTel());
      map.put("depId", baseUser.getDepId());
      map.put("roleId", baseUser.getRoleId());
    }
    
    List<BaseUser> baseUserList = baseUserMapper.getBaseUserInfoList(map);
    int total = baseUserMapper.countBaseUser(map);
    
  /*  BaseUserCriteria baseUserCriteria = new BaseUserCriteria();
    Page page =
        Page.newInstanceWithPageIndex(pageAndSort.getPageIndex(), pageAndSort.getPageSize());
    baseUserCriteria.setPage(page);
    String sortColumn = BaseUserColumns.getColumn(pageAndSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageAndSort.getSortOrder());
      baseUserCriteria.setOrderByClause(sortStrBldr.toString());
    }
    
    List<BaseUser> baseUserList = baseUserMapper.getUserInfoList(baseUserCriteria);
    
    int total = baseUserMapper.countByExample(baseUserCriteria);*/

    MiniRtn2Grid<BaseUser> grid = new MiniRtn2Grid<BaseUser>();
    grid.setData(baseUserList);
    grid.setTotal(total);
    return grid;
  }

  @Override
  public BaseUser getBaseUserByPrimaryKey(String pkey) {
    return baseUserMapper.selectByPrimaryKey(pkey);
  }

  @Transactional
  @Override
  public int createBaseUser(BaseUser user) {
    int nu = baseUserMapper.insert(user);
    return nu;
  }

  @Override
  public int updateBaseUser(BaseUser user) {
    int nu = baseUserMapper.updateByPrimaryKeySelective(user);
    return nu;
  }

  @Override
  public int findSameAccountUserCount(String account) {
    BaseUserCriteria baseUserCriteria = new BaseUserCriteria();
    baseUserCriteria.createCriteria().andAccountEqualTo(account);
    return baseUserMapper.countByExample(baseUserCriteria);
  }

  @Override
  public List<BaseUser> queryAllUser() {
    return baseUserMapper.getAllUser();
  }

  @Override
  public boolean validatePassowrd(String id, String password) {
    int count =  baseUserMapper.validatePassowrd(id, password);
    if(count>0){
      return true;
    }
    return false;
  }

  @Override
  public boolean validateUserPermission(String resource, String permission) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean setStatus(String id) {
    int count = baseUserMapper.setStatus(id);
    if(count >0){
      return true;
    }
    return false;
  }

  @Transactional
  @Override
  public boolean deleteUser(String id) {
    //删除账号之前删除用户机构表，
    int count1 = baseUserMapper.deleteBaseUserOrg(id);
    
    //删除角色用户表中的数据
    int count2 = baseUserMapper.deleteBaseUserRole(id);

    //删除该用户
    int count3 = baseUserMapper.deleteBaseUserById(id);
    if(count3 >0){
      return true;
    }
    return false;
  }

  @Override
  public List<BaseUser> selectFromAccount() {
    return baseUserMapper.selectFromAccount();
  }

  @Override
  public List<SysUser> getGroupMembers(Long groupId) {
    return baseUserMapper.selectUsersByGroupId(groupId);
  }

  @Transactional
  @Override
  public MiniRtn2Grid<BaseUser> getBaseUserListByGroupId(MiniGridPageSort pageAndSort,Map<String, String> searchMap) {
    MiniRtn2Grid<BaseUser> grid = new MiniRtn2Grid<BaseUser>();
    BaseUserCriteria baseUserCriteria = new BaseUserCriteria();
    BaseUserCriteria.Criteria orCriteria = baseUserCriteria.or();
    if(StringUtil.isNotEmpty(searchMap.get("name"))){
      orCriteria.andNameLikeInsensitive("%"+searchMap.get("name")+"%");
    }
    
    if(StringUtil.isNotEmpty(searchMap.get("workCode"))){
      orCriteria.andWorkCodeLikeInsensitive("%"+searchMap.get("workCode")+"%");
    }
    baseUserCriteria.setGroupId(searchMap.get("groupId"));
    Page page =Page.newInstanceWithPageIndex(pageAndSort.getPageIndex(), pageAndSort.getPageSize());
    baseUserCriteria.setPage(page);
    String sortColumn = BaseUserColumns.getColumn(pageAndSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageAndSort.getSortOrder());
      baseUserCriteria.setOrderByClause(sortStrBldr.toString());
    }
    List<BaseUser> baseUserList = baseUserMapper.selectByExampleByGroupId(baseUserCriteria);
    int total = baseUserMapper.countByExampleByGroupId(baseUserCriteria);
    grid.setData(baseUserList);
    grid.setTotal(total);
    return grid;
  }

  @Override
  public Map<String, String> getInfoByCode(String code) {
    // TODO Auto-generated method stub
    return baseUserMapper.getInfoByCode(code);
  }
}
