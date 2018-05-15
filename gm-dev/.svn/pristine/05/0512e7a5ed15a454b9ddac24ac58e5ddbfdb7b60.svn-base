package com.csot.gm.materialManage.model.original.userInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("type", "TYPE");
    columnMap.put("name", "NAME");
    columnMap.put("code", "CODE");
    columnMap.put("pcode", "PCODE");
    columnMap.put("mobile", "MOBILE");
    columnMap.put("telephone", "TELEPHONE");
    columnMap.put("updateTime", "UPDATE_TIME");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}