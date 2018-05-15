package org.amberframework.core.shiro.filter;

import org.amberframework.web.system.util.WebPageContextUtil;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by WangYu on 2016/8/18.
 */
public class AmberCasFilter extends CasFilter {
  @Override protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
      ServletRequest request, ServletResponse response) throws Exception {
    boolean result = super.onLoginSuccess(token, subject, request, response);
    // set BasePath to session when login succeed
    if (request instanceof HttpServletRequest) {
      WebPageContextUtil.setBasePathToSession((HttpServletRequest)request);
    }
    return result;
  }
}
