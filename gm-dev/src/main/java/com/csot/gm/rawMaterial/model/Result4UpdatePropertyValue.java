package com.csot.gm.rawMaterial.model;

/**
 * 更新某个料号的唯一性属性值返回结果
 * 
 * @author Barret
 *
 */
public class Result4UpdatePropertyValue {
  private boolean result;
  private String msg;

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
