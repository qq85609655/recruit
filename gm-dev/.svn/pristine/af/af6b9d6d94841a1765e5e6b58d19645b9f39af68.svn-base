package com.csot.gm.materialManage.model.original.partNoRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartNoRuleColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("ruleKeyCode", "RULE_KEY_CODE");
    columnMap.put("rulePropertyName", "RULE_PROPERTY_NAME");
    columnMap.put("ruleNumStartIndex", "RULE_NUM_START_INDEX");
    columnMap.put("ruleNumEndIndex", "RULE_NUM_END_INDEX");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}