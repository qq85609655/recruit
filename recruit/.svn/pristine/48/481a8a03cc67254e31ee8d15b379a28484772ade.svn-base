package org.amberframework.web.system.auth.model.extension.user;

import java.io.Serializable;

public class SysUserExt implements Serializable {
  private String id;

  private String account;

  private String password;

  private String status;

  private String salt;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    SysUserExt other = (SysUserExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(
            other.getAccount()))
        && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(
            other.getPassword()))
        && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(
            other.getStatus()))
        && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(
            other.getSalt()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
    result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
    result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
    result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
    return result;
  }
}
