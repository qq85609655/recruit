package org.amberframework.web.system.auth.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.amberframework.core.shiro.realm.UserRealm;
import org.amberframework.core.util.AmberBeanUtils;
import org.amberframework.web.system.auth.dao.extension.SysAuthMapper;
import org.amberframework.web.system.auth.dao.original.user.SysUserMapper;
import org.amberframework.web.system.auth.model.extension.SysAuthPermission;
import org.amberframework.web.system.auth.model.extension.resource.SysResourceTree;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.role.SysRole;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.model.original.user.SysUserCriteria;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

@Service("SysAuthService")
public class SysAuthServiceImpl implements SysAuthService {

  @Resource
  private SysAuthMapper sysAuthMapper;
  
  @Resource
  private SysUserMapper sysUserMapper;

  @Override
  public Set<String> findStringRoles(SysUser sysUser) {
    List<SysRole> roleList = sysAuthMapper.selectRoleByUserId(sysUser.getId());
    return Sets.newHashSet(Collections2.transform(roleList, new Function<SysRole, String>() {
      @Override
      public String apply(SysRole input) {
        return input.getRole();
      }
    }));
  }

  @Override
  public Set<String> findStringPermissions(SysUser sysUser) {
    List<SysAuthPermission> permList = sysAuthMapper.selectResourcePermByUserId(sysUser.getId());
    Set<String> perms =
        Sets.newHashSet(Collections2.transform(permList, new Function<SysAuthPermission, String>() {
          @Override
          public String apply(SysAuthPermission input) {
            return input.getIdentifer() + ":" + input.getPermission();
          }
        }));
    List<SysResource> resourceList = sysAuthMapper.selectResourceByUserId(sysUser.getId());
    addIdentiferToPermsSet(perms, resourceList);
    // 如果是最高管理员，则拥有所有权限
    if (isAdminUser(sysUser)) {
      perms.add("*");
    }
    return perms;
  }

  @Override
  public List<SysResource> findMenuByUserId(SysUser sysUser) {
    // 如果是最高管理员，则显示全部菜单；否则返回该用户能看到的菜单
    if (isAdminUser(sysUser)) {
      return sysAuthMapper.selectAllMenus();
    } else {
      return sysAuthMapper.selectMenuByUserId(sysUser.getId());
    }
  }
  
  @Override
  public SysUser getUserByAccountWithPwd(String account) {
    SysUserCriteria criteria = new SysUserCriteria();
    criteria.createCriteria().andAccountEqualTo(account);
    List<SysUser> users = sysUserMapper.selectByExample(criteria);
    if (users.isEmpty()) {
      return null;
    } else {
      return users.get(0);
    }
  }

  @Override
  public void clearRealmCachedAuthorizationInfo() {
    RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
    Iterator<Realm> realmIterator = securityManager.getRealms().iterator();
    Realm realm = null;
    while (realmIterator.hasNext()) {
      realm = realmIterator.next();
      if (realm instanceof UserRealm) {
        ((UserRealm) realm).clearAllCachedAuthorizationInfo();
      }
    }

  }

  protected void addIdentiferToPermsSet(Set<String> perms, List<SysResource> resourceList) {
    for (SysResource resource : resourceList) {
      perms.add(resource.getIdentifer() + ":" + "-");
    }
  }

  private boolean isAdminUser(SysUser sysUser) {
    return sysUser != null && "admin".equals(sysUser.getAccount());
  }
  
  @Override
  public List<SysResourceTree> findMenuTreeByUserId(SysUser sysUser) {
    List<SysResource> menuList = null;
    // 如果是最高管理员，则显示全部菜单；否则返回该用户能看到的菜单
    if (isAdminUser(sysUser)) {
      menuList = sysAuthMapper.selectAllMenus();
    } else {
      menuList = sysAuthMapper.selectMenuByUserId(sysUser.getId());
    }
    if (null != menuList) {
      return transMenuListToTreeList(menuList);
    }
    return new ArrayList<SysResourceTree>();
  }
  
  /**
   * 将list存储的菜单转化为基于list的树状存储.
   */
  protected List<SysResourceTree> transMenuListToTreeList(List<SysResource> menuList) {
    List<SysResourceTree> stackList = new LinkedList<SysResourceTree>();
    List<SysResourceTree> treeList = new LinkedList<SysResourceTree>();
    SysResourceTree treeNode = null;
    for (SysResource menuNode : menuList) {
      if (menuNode.getParentId().compareTo(0L) == 0) {
        treeNode = new SysResourceTree();
        AmberBeanUtils.copyBeanPropDeeply(treeNode, menuNode);
        treeList.add(treeNode);
        stackList.add(treeNode);
      }
    }
    createMenuTreeWithIteration(menuList, stackList);
    return treeList;
  }
  
  private static void createMenuTreeWithIteration( 
      List<SysResource> menuList, List<SysResourceTree> stackList) {
    SysResourceTree treeNode = null;
    SysResourceTree stackNode = null;
    while (!stackList.isEmpty()) {
      stackNode = stackList.get(0);
      stackList.remove(0);
      if (null == stackNode.getChildren()) {
        stackNode.setChildren(new LinkedList<SysResourceTree>());
      }
      for (SysResource menuListNode : menuList) {
        if (menuListNode.getParentId().compareTo(stackNode.getId()) == 0) {
          treeNode = new SysResourceTree();
          AmberBeanUtils.copyBeanPropDeeply(treeNode, menuListNode);
          stackNode.getChildren().add(treeNode);
          stackList.add(0, treeNode);
        }
      }
    }
  }
}
