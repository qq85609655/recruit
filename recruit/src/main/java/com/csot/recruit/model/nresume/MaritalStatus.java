package com.csot.recruit.model.nresume;

/**
 * 婚姻状态
 * @author honglu
 *
 */
public enum MaritalStatus {
  /**
   * 保密
   */
  Private(0),
  
  /**
   * 未婚
   */
  Unmarried(1),
  
  /**
   * 已婚
   */
  Married(2);
  
  private int value;
  
  private MaritalStatus(int value) {
    this.setValue(value);
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
}
