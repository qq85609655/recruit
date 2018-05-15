package com.csot.gm.materialManage.model.extension.propertyRtn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyRtnExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("createUid", "CREATE_UID");
    columnMap.put("propertyName", "PROPERTY_NAME");
    columnMap.put("propertyText", "PROPERTY_TEXT");
    columnMap.put("propertyValue", "PROPERTY_VALUE");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}