package com.csot.gm.materialManage.model.original.gmPartNoRuleMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GmPartNoRuleMapColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("ruleKeyCode", "RULE_KEY_CODE");
    columnMap.put("ruleMapCode", "RULE_MAP_CODE");
    columnMap.put("ruleMapFlownoFlag", "RULE_MAP_FLOWNO_FLAG");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}