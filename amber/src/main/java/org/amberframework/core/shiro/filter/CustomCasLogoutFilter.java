package org.amberframework.core.shiro.filter;

import org.amberframework.web.system.util.WebPageContextUtil;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by WangYu on 2016/8/19.
 */
public class CustomCasLogoutFilter extends LogoutFilter {

  private static final String SERVICE_BASE_PATH_TOKEN = "{0}";

  private String casRedirectUrl = DEFAULT_REDIRECT_URL;

  private Collection<String> casServiceBasePaths;

  public String getCasRedirectUrl() {
    return casRedirectUrl;
  }

  public void setCasRedirectUrl(String casRedirectUrl) {
    this.casRedirectUrl = casRedirectUrl;
  }

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

  /**
   * 获取登出后的重定向地址，如果使用CAS指定的域名前缀则跳转到CAS登出页面，否则跳转到系统自己的登出页面.
   */
  @Override
  protected String getRedirectUrl(ServletRequest request, ServletResponse response,
      Subject subject) {
    String casRedirectUrl = getCasRedirectUrl();
    String basePath = WebPageContextUtil.getBasePath((HttpServletRequest) request);
    Collection<String> casBasePaths = getCasServiceBasePaths();
    if (null != casBasePaths && !casBasePaths.isEmpty()) {
      for (String casBasePath : casBasePaths) {
        // 进行前缀匹配判断
        if (StringUtils.hasText(casBasePath) && basePath.startsWith(casBasePath)) {
          // CAS 登录地址类似于http://casserver/login?service={0}/cas
          // 需要替换占位符为真实请求的服务地址
          return replaceCasContextPathToken(casRedirectUrl, basePath);
        }
      }
    }
    return super.getRedirectUrl(request, response, subject);
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
