package com.csot.recruit.model.nresume;

/**
 * 描述一份简历创建时所使用的语言
 * @author honglu
 *
 */
public enum ResumeLanguage {
 
  /** 语言未知 */
  Unknown(0),
  
  /** 英语 */
  English(1),
  
  /** 简体中文 */
  SimplifiedChinese(2);
  
  private int value;
  
  private ResumeLanguage(int value) {
    this.setValue(value);
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
}
