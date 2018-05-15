package com.csot.gm.materialManage.model.extension.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartPropertiesExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("propertyName", "PROPERTY_NAME");
    columnMap.put("partId", "PART_ID");
    columnMap.put("propertyDisName", "PROPERTY_DIS_NAME");
    columnMap.put("propertyUnit", "PROPERTY_UNIT");
    columnMap.put("isUnique", "IS_UNIQUE");
    columnMap.put("isEnum", "IS_ENUM");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}