package org.amberframework.core.shiro.filter;

import org.amberframework.web.system.util.WebPageContextUtil;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by WangYu on 2016/8/22.
 */
public class MultiAmberCasFilter extends AmberCasFilter {

  private static final ThreadLocal<String> REQUEST_BASE_PATH = new ThreadLocal();

  public static String getRequestBasePath() {
    return REQUEST_BASE_PATH.get();
  }

  public static void setRequestBasePath(String value) {
    REQUEST_BASE_PATH.set(value);
  }

  @Override protected boolean executeLogin(ServletRequest request, ServletResponse response)
      throws Exception {
    String basePath = WebPageContextUtil.getBasePath((HttpServletRequest) request);
    MultiAmberCasFilter.setRequestBasePath(basePath);
    return super.executeLogin(request, response);
  }
}
