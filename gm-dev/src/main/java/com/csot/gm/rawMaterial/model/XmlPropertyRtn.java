package com.csot.gm.rawMaterial.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * xml读取的属性的类，记录属性是否属于唯一性属性，是否是下拉形式
 * 
 * @author Barret
 *
 */
public class XmlPropertyRtn {
  @XStreamAsAttribute()
  @XStreamAlias("propertyName")
  private String propertyName;
  
  @XStreamAsAttribute()
  @XStreamAlias("isEnum")
  private String isEnum;
  
  @XStreamAsAttribute()
  @XStreamAlias("isUnique")
  private String isUnique;

  public String getPropertyName() {
    return propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  public String getIsEnum() {
    return isEnum;
  }

  public void setIsEnum(String isEnum) {
    this.isEnum = isEnum;
  }

  public String getIsUnique() {
    return isUnique;
  }

  public void setIsUnique(String isUnique) {
    this.isUnique = isUnique;
  }

}
