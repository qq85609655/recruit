package com.csot.recruit.model.nresume;

import java.io.Serializable;

/**
 * 表示简历中的一条语言技能信息
 * @author honglu
 *
 */
public class LanguageSkill implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 语言    */
  private String language;
  
  /** 水平    */
  private String languageLevel;
  
  /** 口语水平    */
  private String oralLevel;

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getLanguageLevel() {
    return languageLevel;
  }

  public void setLanguageLevel(String languageLevel) {
    this.languageLevel = languageLevel;
  }

  public String getOralLevel() {
    return oralLevel;
  }

  public void setOralLevel(String oralLevel) {
    this.oralLevel = oralLevel;
  }
}
