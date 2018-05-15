package org.amberframework.core.shiro.filter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.amberframework.core.constant.WebConstants;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.user.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;

/**
 * 将当前用户对象放入request中，以供业务处理使用
 * 
 * @author WangYu
 *
 */
public class SysUserFilter extends PathMatchingFilter {

  @Resource
  private SysUserService sysUserService;

  @Override
  protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
      throws Exception {
    // 获取登录帐号对象，并放到request中
    Subject subject = SecurityUtils.getSubject();
    if (subject == null) {
      return true;
    }
    String username = (String) subject.getPrincipal();
    SysUser sysUser = sysUserService.getUserByAccount(username);
    request.setAttribute(WebConstants.CURRENT_USER, sysUser);
    return true;
  }

}
