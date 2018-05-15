package com.csot.gm.rawMaterial.model;

import java.util.Map;

/**
 * 唯一性属性
 * 
 * @author Barret
 *
 */
public class UniqueProperty {
  private String partId;
  private Map<String, String> uniqueProperties; // Map<propertyName, propertyValue>

  public String getPartId() {
    return partId;
  }

  public void setPartId(String partId) {
    this.partId = partId;
  }

  public Map<String, String> getUniqueProperty() {
    return uniqueProperties;
  }

  public void setUniqueProperty(Map<String, String> uniqueProperty) {
    this.uniqueProperties = uniqueProperty;
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (String proHash : uniqueProperties.values()) {
      hashCode += proHash.hashCode();
    }
    return hashCode;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    UniqueProperty other = (UniqueProperty) obj;
    if (partId == null) {
      if (other.partId != null) {
        return false;
      }
    } else if (!partId.equals(other.partId)) {
      return false;
    }
    if (uniqueProperties == null) {
      if (other.uniqueProperties != null) {
        return false;
      }
    } else if (!uniqueProperties.equals(other.uniqueProperties)) {
      return false;
    }
    return true;
  }

}
