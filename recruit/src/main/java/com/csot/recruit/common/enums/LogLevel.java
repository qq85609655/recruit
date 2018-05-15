package com.csot.recruit.common.enums;

public enum LogLevel {
  INFO(0),
  
  DEBUG(1),
  
  ERROR(2);
  
  private int value;
  
  private LogLevel(int value) {
    this.setValue(value);
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
}
