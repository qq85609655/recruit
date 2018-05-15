package com.csot.gm.esbws.entity;

import java.io.Serializable;

public class AccountInfoEntity implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4182054581780591749L;

  private String id;
  private String type;
  private String name;
  private String code;
  private String pcode;
  private String mobile;
  private String telephone;
  private String updateTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPcode() {
    return pcode;
  }

  public void setPcode(String pcode) {
    this.pcode = pcode;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}
