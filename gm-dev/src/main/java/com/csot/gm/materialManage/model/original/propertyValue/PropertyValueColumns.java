package com.csot.gm.materialManage.model.original.propertyValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyValueColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("propertyName", "PROPERTY_NAME");
    columnMap.put("propertyValue", "PROPERTY_VALUE");
    columnMap.put("propertyType", "PROPERTY_TYPE");
    columnMap.put("partNoId", "PART_NO_ID");
    columnMap.put("enumValueId", "ENUM_VALUE_ID");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}