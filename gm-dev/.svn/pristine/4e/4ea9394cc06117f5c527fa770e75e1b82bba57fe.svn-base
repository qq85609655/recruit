package org.amberframework.web.system.auth.model.original.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysGroupColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();
  
  static {
    columnMap.put("id", "ID");
    columnMap.put("name", "NAME");
    columnMap.put("parentId", "PARENT_ID");
    columnMap.put("parentIds", "PARENT_IDS");
    columnMap.put("enabled", "ENABLED");
  }
  
  private SysGroupColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
