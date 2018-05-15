package com.csot.gm.materialManage.model.original.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("partPrefixCode", "PART_PREFIX_CODE");
    columnMap.put("partDesc", "PART_DESC");
    columnMap.put("parentId", "PARENT_ID");
    columnMap.put("partUrl", "PART_URL");
    columnMap.put("sortId", "SORT_ID");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}