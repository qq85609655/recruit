package org.amberframework.core.shiro.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ajax登录，Controller中通过subject.login(token)登录的话不会经过这个对象.
 */
public class AmberFormAuthenticationFilter extends FormAuthenticationFilter {

  private static final Logger logger = LoggerFactory.getLogger(AmberFormAuthenticationFilter.class);

  private String[] successExcludeGotoUrls;

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
      ServletResponse response) throws Exception {
    redirectToSavedRequest(request, response, this.getSuccessUrl());
    return false;
  }

  @Override
  protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
    if (ae != null) {
      logger.error(ae.getMessage(), ae);
      String rtnInfo = getRtnInfoByExceptionType(ae);
      request.setAttribute(getFailureKeyAttribute(), rtnInfo);
    }
  }

  /**
   * 重写登录成功后重定向.
   */
  protected void redirectToSavedRequest(ServletRequest request, ServletResponse response, String fallbackUrl)
      throws IOException {
    GotoInfo gotoInfo = getGotoInfomation(request, fallbackUrl);

    String gotoUrl = gotoInfo.getGotoUrl();
    boolean contextRelative = gotoInfo.isContextRelative();

    if (gotoUrl == null) {
      throw new IllegalStateException("Success URL not available via saved request or via the "
          + "successUrlFallback method parameter. One of these must be non-null for "
          + "issueSuccessRedirect() to work.");
    }

    WebUtils.issueRedirect(request, response, gotoUrl, null, contextRelative);
  }

  /**
   * 获取登录成功后应该返回的URL信息.
   * 
   * <p>
   * 登录前请求的页面URL(最前面会带有'/')或者是传进去的默认页面URL.
   * 
   * @param request request对象
   * @param fallbackUrl 默认返回URL
   * @return 封装好的返回对象，包含返回的URL和是否是相对路径
   */
  public GotoInfo getGotoInfomation(ServletRequest request, String fallbackUrl) {
    String gotoUrl = null;
    boolean contextRelative = true;
    SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
    if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase(AccessControlFilter.GET_METHOD)) {
      gotoUrl = savedRequest.getRequestUrl();
      contextRelative = false;
    }

    if (gotoUrl == null) {
      gotoUrl = fallbackUrl;
    } else {
      String contextPath = ((HttpServletRequest) request).getContextPath();
      if (!StringUtils.isEmpty(contextPath)) {
        gotoUrl = gotoUrl.replaceFirst(contextPath, "");
        contextRelative = true;
      }
      if (isExcludeUrl(gotoUrl)) {
        // 如果是排除的URL，就返回都主页.
        gotoUrl = fallbackUrl;
        contextRelative = true;
      }
    }

    return new GotoInfo(gotoUrl, contextRelative);
  }
  
  /**
   * 判断是否为重定向排除的URL.
   */
  protected boolean isExcludeUrl(String gotoUrl) {
    if (successExcludeGotoUrls != null) {
      for (String excludeUrl : successExcludeGotoUrls) {
        if (excludeUrl.equals(gotoUrl)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 判断是否为Ajax请求.
   */
  protected boolean isAjaxRequest(HttpServletRequest request) {
    return "XMLHttpRequest".equalsIgnoreCase((request).getHeader("X-Requested-With"));
  }

  /**
   * 根据Exception类型返回报错信息.
   * 
   * @param exception exception
   * @return 报错信息
   */
  protected String getRtnInfoByExceptionType(Exception exception) {
    if (exception.getClass() == UnknownAccountException.class
        || exception.getClass() == IncorrectCredentialsException.class) {
      return "用户名或密码错误";
    } else {
      return "登录认证错误，请重试";
    }
  }

  /**
   * 为Ajax请求写response返回信息.
   */
  protected void writeAjaxResponse(HttpServletResponse httpServletResponse, String rtnJson)
      throws IOException {
    httpServletResponse.setCharacterEncoding("UTF-8");
    PrintWriter out = httpServletResponse.getWriter();
    out.println(rtnJson);
    out.flush();
    out.close();
  }

  public String[] getSuccessExcludeGotoUrls() {
    return successExcludeGotoUrls;
  }

  public void setSuccessExcludeGotoUrls(String[] successExcludeGotoUrls) {
    this.successExcludeGotoUrls = successExcludeGotoUrls;
  }

  public class GotoInfo {

    /** 登录成功后跳转到的页面 */
    private String gotoUrl;
    /** 是否为相对路径 */
    private boolean contextRelative;

    public GotoInfo() {

    }

    public GotoInfo(String gotoUrl, boolean contextRelative) {
      this.gotoUrl = gotoUrl;
      this.contextRelative = contextRelative;
    }

    public String getGotoUrl() {
      return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
      this.gotoUrl = gotoUrl;
    }

    public boolean isContextRelative() {
      return contextRelative;
    }

    public void setContextRelative(boolean contextRelative) {
      this.contextRelative = contextRelative;
    }
  }
}
