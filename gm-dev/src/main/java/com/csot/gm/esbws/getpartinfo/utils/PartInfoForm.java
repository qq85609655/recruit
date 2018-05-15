package com.csot.gm.esbws.getpartinfo.utils;

import java.util.HashMap;
import java.util.Map;

public class PartInfoForm {

  Map<String, PartPropertyBean> properties = null;

  public PartInfoForm() {
    super();
    properties = new HashMap<String, PartPropertyBean>();
  }

  public Map<String, PartPropertyBean> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, PartPropertyBean> properties) {
    this.properties = properties;
  }


}
