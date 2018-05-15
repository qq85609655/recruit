/**
 * 
 */
package com.csot.recruit.model.position;

/**
 * @author honglu
 *
 */
public class RecruitSiteItem {
  
  // label名称
  private String displayName;
  
  // input的name,id值
  private String name;
  
  // 是否必填
  private Boolean required;
  
  // 输入框类型
  private String inputType;
  
  // 输入的值
  private String inputValue;
  
  // 类型   0:无关紧要的字段, 1:登录所需, 2:登录额外所需, 3:分发职位额外所需。
  private int type;

  public RecruitSiteItem(){};
  
  public RecruitSiteItem(String displayName, String name, String inputType, Boolean required, int type) {
    this.name = name;
    this.required = required;
    this.inputType = inputType;
    this.displayName = displayName;
    this.type = type;
  }
  
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean reauired) {
    this.required = reauired;
  }

  public String getInputType() {
    return inputType;
  }

  public void setInputType(String inputType) {
    this.inputType = inputType;
  }
  
  public String getInputValue() {
    return inputValue;
  }

  public void setInputValue(String inputValue) {
    this.inputValue = inputValue;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "RecruitSiteItem [displayName=" + displayName + ", name=" + name + ", required="
        + required + ", inputType=" + inputType + "]";
  }
}
