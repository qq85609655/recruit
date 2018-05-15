package com.csot.recruit.model.nresume;

import java.io.Serializable;

/**
 * 邮件文件
 * @author honglu
 *
 */
public class EmailFile implements Serializable{

  private static final long serialVersionUID = 1L;

  /** 文件名    */
  private String name;
  
  /**  编码     */
  private String encoding;
  
  /**  内容     */
  private String data;
  
  public EmailFile(String fileName, String content) {
    this.name = fileName;
    this.data = content;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEncoding() {
    return encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
