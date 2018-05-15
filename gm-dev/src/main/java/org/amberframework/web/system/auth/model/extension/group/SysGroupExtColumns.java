package org.amberframework.web.system.auth.model.extension.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysGroupExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("name", "NAME");
    columnMap.put("parentId", "PARENT_ID");
    columnMap.put("parentIds", "PARENT_IDS");
    columnMap.put("enabled", "ENABLED");
  }
  
  private SysGroupExtColumns() {

  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
