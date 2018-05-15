package com.csot.recruit.model.nresume;

import java.io.Serializable;

/**
 * 头像
 * @author honglu
 *
 */
public class Avatar implements Serializable{

  private static final long serialVersionUID = 1L;

  /** 头像数据   */
  private String data;
  
  /** 后缀     */
  private String extension;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }
}
