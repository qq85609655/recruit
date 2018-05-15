package com.csot.gm.materialManage.model.original.gmlog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("userName", "USER_NAME");
    columnMap.put("createTime", "CREATE_TIME");
    columnMap.put("content", "CONTENT");
    columnMap.put("operation", "OPERATION");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}