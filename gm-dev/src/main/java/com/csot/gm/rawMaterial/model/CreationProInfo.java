package com.csot.gm.rawMaterial.model;

import java.util.Map;

/**
 * 生成料号和物料描述所需的属性类
 * Map里面除了属性,还有各层分类描述键值对
 * 
 * @author Barret
 *
 */
public class CreationProInfo {
  private String preCode;
  private String partId;
  private String partType;
  private String className;
  private Map<String, String[]> properties;
  private boolean isMessCreate;

  public String getPreCode() {
    return preCode;
  }

  public void setPreCode(String preCode) {
    this.preCode = preCode;
  }

  public String getPartId() {
    return partId;
  }

  public void setPartId(String partId) {
    this.partId = partId;
  }

  public String getPartType() {
    return partType;
  }

  public void setPartType(String partType) {
    this.partType = partType;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public Map<String, String[]> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String[]> properties) {
    this.properties = properties;
  }

  public boolean isMessCreate() {
    return isMessCreate;
  }

  public void setMessCreate(boolean isMessCreate) {
    this.isMessCreate = isMessCreate;
  }

}
