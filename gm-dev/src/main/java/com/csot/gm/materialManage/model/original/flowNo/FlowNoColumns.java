package com.csot.gm.materialManage.model.original.flowNo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowNoColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("partNum", "PART_NUM");
    columnMap.put("partFlowNum", "PART_FLOW_NUM");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}