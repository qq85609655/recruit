package org.amberframework.core.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AjaxRtnJson implements Serializable {

  private static final long serialVersionUID = 4728447260175994022L;
  
  private boolean success = false;
  private String msg = "";
  private Object obj = null;
  private Map<String, Object> attributes;
  
  public AjaxRtnJson() {
    attributes = new HashMap<String, Object>();
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

  public Object getObj() {
    return obj;
  }

  public void setObj(Object obj) {
    this.obj = obj;
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  public void setAttribute(String key, String value) {
    this.attributes.put(key, value);
  }
  
}
