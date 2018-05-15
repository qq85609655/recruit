package org.amberframework.core.shiro.realm;

import org.apache.shiro.util.CollectionUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;

import java.util.Collection;
import java.util.Map;

/**
 * Created by WangYu on 2016/8/19.
 */
public class AmberPrincipalsAssembler implements PrincipalsAssembler {

  private static final String CAS_LOGIN_NAME_KEY = "smart-csot-loginname";

  private String loginNameKey = CAS_LOGIN_NAME_KEY;

  public String getLoginNameKey() {
    return loginNameKey;
  }

  public void setLoginNameKey(String loginNameKey) {
    this.loginNameKey = loginNameKey;
  }

  @Override
  public Collection createPrincipalCollection(AttributePrincipal principal) {
    Object userId = principal.getName();
    Map attributes = principal.getAttributes();
    if (null != attributes) {
      Object loginName = attributes.get(getLoginNameKey());
      if (null != loginName) {
        userId = loginName;
      }
    }
    return CollectionUtils.asList(new Object[] {userId, attributes});
  }
}
