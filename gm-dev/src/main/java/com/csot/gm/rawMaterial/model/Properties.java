package com.csot.gm.rawMaterial.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Properties {
  @XStreamImplicit(itemFieldName = "property")
  private List<XmlPropertyRtn> propertyList;

  public List<XmlPropertyRtn> getPropertyList() {
    return propertyList;
  }

  public void setPropertyList(List<XmlPropertyRtn> propertyList) {
    this.propertyList = propertyList;
  }
}
