package org.amberframework.web.system.auth.service;

import java.util.List;
import java.util.Set;

import org.amberframework.web.system.auth.model.extension.resource.SysResourceTree;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface SysAuthService {
  
  /**
   * 根据用户主键获取此用户拥有的角色集合.参数对象中主键不能为空.
   */
  Set<String> findStringRoles(SysUser sysUser);
  
  /**
   * 根据用户主键获取此用户拥有的权限集合.参数对象中主键不能为空.
   * <p>权限集合包括从角色资源权限表中取出的权限配置和从角色资源表中取出的菜单配置的identifer属性，两部分组成.
   * <p>权限字符串是由: 
   * <ul>
   * <li>1. 权限配置: resource中的identifer + “:” + permission中的permission拼接而成.
   * <li>2. 菜单配置: resource中的identifer + “:” + “-”.
   * </ul>
   * <p>这样如果懒得配置具体权限，只要在菜单入口的Controller方法上配置resource的identifer + “:-”即可控制菜单访问权限(以防有人绕过菜单直接访问).
   */
  Set<String> findStringPermissions(SysUser sysUser);
  
  /**
   * 根据用户主键获取菜单（by weight 升序排列），参数对象中主键不能为空.
   */
  List<SysResource> findMenuByUserId(SysUser sysUser);
  
  /**
   * 根据账号名查找系统用户(包含密码信息)，理论上一个账号名只会有一个，所以返回查找结果的第一个，如果没找到，则返回null.
   * <p>此方法未使用sys-user的缓存，直接从数据源获取.
   */
  SysUser getUserByAccountWithPwd(String account);
  
  /**
   * 清理所有realm中的Authorization缓存.目前只能清理UserRealm类型的Realm的缓存.
   */
  void clearRealmCachedAuthorizationInfo();
  
  /**
   * 根据用户主键获取菜单,以树状存储（by weight 升序排列），参数对象中主键不能为空.
   */
  List<SysResourceTree> findMenuTreeByUserId(SysUser sysUser);
}
