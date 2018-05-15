package com.csot.gm.materialManage.model.original.gmPartDescRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GmPartDescRuleColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("ruleKeyCode", "RULE_KEY_CODE");
    columnMap.put("rulePropertyName", "RULE_PROPERTY_NAME");
    columnMap.put("rulePropertyIndex", "RULE_PROPERTY_INDEX");
    columnMap.put("connectSymbol", "CONNECT_SYMBOL");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}