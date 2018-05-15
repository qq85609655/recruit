package com.csot.gm.rawMaterial.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * xml里读取的底层物料的类
 * 
 * @author Barret
 *
 */
@XStreamAlias("part")
public class XmlPartRtn {
  @XStreamAsAttribute()
  @XStreamAlias("id")
  private String id;
  
  @XStreamAsAttribute()
  @XStreamAlias("name")
  private String name;
  
  @XStreamAlias("properties")
  private Properties property;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Properties getProperty() {
    return property;
  }

  public void setProperty(Properties property) {
    this.property = property;
  }

}
