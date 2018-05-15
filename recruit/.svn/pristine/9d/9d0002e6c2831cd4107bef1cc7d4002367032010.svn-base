package org.amberframework.core.shiro.realm;

import org.amberframework.core.shiro.filter.MultiAmberCasFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by WangYu on 2016/8/22.
 */
public class MultiCustomCasRealm extends CustomCasRealm {

  private static Logger log = LoggerFactory.getLogger(MultiCustomCasRealm.class);

  private static final String DEFAULT_CAS_SERVICE = "/";
  private static final String SERVICE_BASE_PATH_TOKEN = "{0}";

  private String defaultCasService = DEFAULT_CAS_SERVICE;

  /**
   * 支持多域名CAS验证，在拿到ticket进行validate验证时，通过请求的服务地址不同，获取不同的CAS service地址.
   *
   * @return
   */
  @Override
  public String getCasService() {
    String casService = super.getCasService();
    if (null != MultiAmberCasFilter.getRequestBasePath()) {
      log.debug("Get CAS service path:"
          + casService.replace(SERVICE_BASE_PATH_TOKEN, MultiAmberCasFilter.getRequestBasePath()));
      return casService.replace(SERVICE_BASE_PATH_TOKEN, MultiAmberCasFilter.getRequestBasePath());
    } else {
      log.debug("Get default CAS service path:" + getDefaultCasService());
      return getDefaultCasService();
    }
  }

  public String getDefaultCasService() {
    return defaultCasService;
  }

  public void setDefaultCasService(String defaultCasService) {
    this.defaultCasService = defaultCasService;
  }
}
