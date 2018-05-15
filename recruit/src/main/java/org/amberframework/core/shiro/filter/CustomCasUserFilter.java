package org.amberframework.core.shiro.filter;

import org.amberframework.web.system.util.WebPageContextUtil;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by WangYu on 2016/8/19. 增加casLoginUrl和casServiceContextPaths属性.
 * 在redirectToLogin时根据casServiceContextPaths判断是否要跳转到casLoginUrl.
 */
public class CustomCasUserFilter extends UserFilter {

  private static final String SERVICE_BASE_PATH_TOKEN = "{0}";

  private String casLoginUrl = DEFAULT_LOGIN_URL;

  private Collection<String> casServiceBasePaths;

  public Collection<String> getCasServiceBasePaths() {
    return casServiceBasePaths;
  }

  public void setCasServiceBasePath(String casServiceBasePath) {
    if (null == casServiceBasePath) {
      throw new IllegalArgumentException("CasServiceBasePath argument cannot be null");
    }
    Collection<String> basePaths = new ArrayList(1);
    basePaths.add(casServiceBasePath);
    this.setCasServiceBasePaths(basePaths);
  }

  public void setCasServiceBasePaths(Collection<String> casServiceBasePaths) {
    if (casServiceBasePaths == null) {
      throw new IllegalArgumentException("CasServiceBasePath collection argument cannot be null.");
    }
    if (casServiceBasePaths.isEmpty()) {
      throw new IllegalArgumentException("CasServiceBasePath collection argument cannot be empty.");
    }
    this.casServiceBasePaths = casServiceBasePaths;
  }

  public String getCasLoginUrl() {
    return casLoginUrl;
  }

  public void setCasLoginUrl(String casLoginUrl) {
    this.casLoginUrl = casLoginUrl;
  }

  /**
   * 如果使用CAS指定的域名前缀则LoginUrl跳转到CAS登录页面，否则跳转到系统自己的登录页面.
   */
  @Override
  protected void redirectToLogin(ServletRequest request, ServletResponse response)
      throws IOException {
    String loginUrl = getLoginUrl();
    String casLoginUrl = getCasLoginUrl();
    String basePath = WebPageContextUtil.getBasePath((HttpServletRequest) request);
    Collection<String> casBasePaths = getCasServiceBasePaths();
    if (null != casBasePaths && !casBasePaths.isEmpty()) {
      for (String casBasePath : casBasePaths) {
        // 进行前缀匹配判断
        if (StringUtils.hasText(casBasePath) && basePath.startsWith(casBasePath)) {
          // CAS 登录地址类似于http://casserver/login?service={0}/cas
          // 需要替换占位符为真实请求的服务地址
          WebUtils.issueRedirect(request, response,
              replaceCasContextPathToken(casLoginUrl, basePath));
          return;
        }
      }
    }
    WebUtils.issueRedirect(request, response, loginUrl);
  }

  /**
   * 替换CAS请求的回调服务地址占位符{0}.
   * <p>
   * For example: <code>http://casserver/login?service={0}/cas</code><br/>
   * After replace: <code>http://casserver/login?service=http://myserver:8080/myApp/cas</code>
   * <br/>
   * <code>http://myserver:8080/myApp</code> is the base path of request serverURI
   * </p>
   *
   * @param casLoginUrl 需要进行替换的重定向地址
   * @param basePath 回调服务的base path
   * @return 替换后的重定向地址
   */
  protected String replaceCasContextPathToken(String casLoginUrl, String basePath) {
    return casLoginUrl.replace(SERVICE_BASE_PATH_TOKEN, basePath);
  }
}
