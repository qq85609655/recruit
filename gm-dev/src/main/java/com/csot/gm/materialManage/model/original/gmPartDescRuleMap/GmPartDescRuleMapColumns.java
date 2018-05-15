package com.csot.gm.materialManage.model.original.gmPartDescRuleMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GmPartDescRuleMapColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("ruleKeyCode", "RULE_KEY_CODE");
    columnMap.put("ruleMapCode", "RULE_MAP_CODE");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}