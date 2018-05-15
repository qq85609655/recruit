package org.amberframework.web.system.auth.model.original.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysGroupRoleColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();
  
  static {
    columnMap.put("id", "ID");
    columnMap.put("groupId", "GROUP_ID");
    columnMap.put("roleId", "ROLE_ID");
    columnMap.put("extended", "EXTENDED");
  }
  
  private SysGroupRoleColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
