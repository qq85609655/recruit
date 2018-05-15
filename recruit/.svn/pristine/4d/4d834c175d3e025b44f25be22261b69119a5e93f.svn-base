package org.amberframework.core.shiro.realm;

import javax.annotation.Resource;

import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.amberframework.web.system.auth.service.user.SysUserService;
import org.amberframework.web.system.util.AuthUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRealm extends AuthorizingRealm {

  private static final String OR_OPERATOR = " or ";
  private static final String AND_OPERATOR = " and ";
  private static final String NOT_OPERATOR = "not ";

  private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

  @Resource
  private SysUserService sysUserService;

  @Resource
  private SysAuthService sysAuthService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    logger.warn(Integer.toString(principals.hashCode()));
    String username = (String) principals.getPrimaryPrincipal();
    SysUser sysUser = sysUserService.getUserByAccount(username);

    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    authorizationInfo.setRoles(sysAuthService.findStringRoles(sysUser));
    authorizationInfo.setStringPermissions(sysAuthService.findStringPermissions(sysUser));
    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
    String username = (String) token.getPrincipal();

    // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
    SysUser user = sysAuthService.getUserByAccountWithPwd(username);

    if (null == user || ("0".equals(user.getStatus()) && !"admin".equals(user.getAccount()))) {
      throw new UnknownAccountException();// 没找到帐号
    }

    return new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(),
        ByteSource.Util.bytes(AuthUtils.getUserCredentialSalt(user)), getName());
  }

  /**
   * 支持 or not 或 and not 关键词，不支持and or混用.注意用的时候左右加空格.
   * 
   * @author ZhangKaitao
   */
  @Override
  public boolean isPermitted(PrincipalCollection principals, String permission) {
    if (permission.contains(OR_OPERATOR)) {
      String[] permissions = permission.split(OR_OPERATOR);
      for (String orPermission : permissions) {
        if (isPermittedWithNotOperator(principals, orPermission)) {
          return true;
        }
      }
      return false;
    } else if (permission.contains(AND_OPERATOR)) {
      String[] permissions = permission.split(AND_OPERATOR);
      for (String orPermission : permissions) {
        if (!isPermittedWithNotOperator(principals, orPermission)) {
          return false;
        }
      }
      return true;
    } else {
      return isPermittedWithNotOperator(principals, permission);
    }
  }

  /**
   * 检查 not 关键词.
   * 
   * @author ZhangKaitao
   */
  private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {
    if (permission.startsWith(NOT_OPERATOR)) {
      return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));
    } else {
      return super.isPermitted(principals, permission);
    }
  }

  /**
   * 清除所有授权缓存.
   */
  public void clearAllCachedAuthorizationInfo() {
    getAuthorizationCache().clear();
  }

  /**
   * 清除所有登录缓存.
   */
  public void clearAllCachedAuthenticationInfo() {
    getAuthenticationCache().clear();
  }

  /**
   * 清除所有授权和登录缓存.
   */
  public void clearAllCache() {
    clearAllCachedAuthenticationInfo();
    clearAllCachedAuthorizationInfo();
  }
}
