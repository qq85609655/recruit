package org.amberframework.web.system.pojo;

import java.io.Serializable;
import java.util.Date;

import org.amberframework.web.system.model.BaseUser;

public class LoginClient implements Serializable {

  private static final long serialVersionUID = -7413007899821007751L;

  /** 保存在Session中的Key */
  public static final String CLIENT_SESSION_ATTR = "w_Login_Client";

  /** 保存在Session中的登录前goto地址 */
  public static final String GOTO_URL_KEY = "w_GOING_TO_URL";

  private BaseUser user;
  private String ip;
  private boolean isSuperAdmin = false;
  private Date loginTime;

  public BaseUser getUser() {
    return user;
  }

  public void setUser(BaseUser user) {
    this.user = user;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public boolean isSuperAdmin() {
    return isSuperAdmin;
  }

  public void setSuperAdmin(boolean isSuperAdmin) {
    this.isSuperAdmin = isSuperAdmin;
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }
}
