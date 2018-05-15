package com.csot.gm.rawMaterial.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("parts")
public class Parts {
  @XStreamImplicit(itemFieldName = "part")
  private List<XmlPartRtn> partList;

  public List<XmlPartRtn> getPartList() {
    return partList;
  }

  public void setPartList(List<XmlPartRtn> partList) {
    this.partList = partList;
  }
}
