package org.amberframework.web.system.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebPageContextUtil {

  private WebPageContextUtil() {
    
  }
  
  /**
   * 将basePath放入HttpSession中.basePath路径最后含"/".
   * <p>这样在页面中通过${sessionScope.basePath}获取到项目基础全路径.
   * <p/>
   * For example, for a request to URL
   * <p/>
   * <code>http://www.somehost.com:8080/myapp/my/url.jsp</code>,
   * <p/>
   * this method would set "<code>http://www.somehost.com:8080/myapp/</code>" into session.
   *
   * @param request HttpServletRequest
   */
  public static void setBasePathToSession(HttpServletRequest request) {
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() 
        + path + "/";
    HttpSession session = request.getSession();
    session.setAttribute("basePath", basePath);
  }
  
  /**
   * 从request中获取basePath，最后不包含"/".
   * <p/>
   * For example, for a request to URL
   * <p/>
   * <code>http://www.somehost.com:8080/myapp/my/url.jsp</code>,
   * <p/>
   * this method would return
   * <p/>
   * <code>http://www.somehost.com:8080/myapp</code>
   */
  public static String getBasePath(HttpServletRequest request) {
    String path = request.getContextPath();
    return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
        + path;
  }
}
