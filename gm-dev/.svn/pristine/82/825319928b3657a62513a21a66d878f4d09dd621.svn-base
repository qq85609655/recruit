package com.csot.gm.materialManage.model.original.partType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartTypeColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("partTypeRealName", "PART_TYPE_REAL_NAME");
    columnMap.put("partTypeDisName", "PART_TYPE_DIS_NAME");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}