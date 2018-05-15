package com.csot.gm.materialManage.model.extension.enumValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnumValueExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("enumValue", "ENUM_VALUE");
    columnMap.put("enumText", "ENUM_TEXT");
    columnMap.put("enumTypeId", "ENUM_TYPE_ID");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}