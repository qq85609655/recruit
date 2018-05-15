package com.csot.gm.materialManage.model.extension.clean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleanExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("partNo", "PART_NO");
    columnMap.put("brand", "BRAND");
    columnMap.put("spec", "SPEC");
    columnMap.put("status", "STATUS");
    columnMap.put("info", "INFO");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}