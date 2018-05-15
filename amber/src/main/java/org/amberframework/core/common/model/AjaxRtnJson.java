package org.amberframework.core.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现Serializable.
 */
public class AjaxRtnJson implements Serializable {

  private static final long serialVersionUID = 1L;

  private boolean success = false;
  private String msg = "";
  private HashMap<String, String> attributes;

  public AjaxRtnJson() {
    attributes = new HashMap<String, String>();
  }

  public AjaxRtnJson(boolean success, String message) {
    this.success = success;
    this.msg = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Map<String, String> getAttributes() {
    return attributes;
  }
  
  public String getAttribute(String key) {
    return attributes.get(key);
  }

  public void setAttribute(String key, String value) {
    this.attributes.put(key, value);
  }

}
