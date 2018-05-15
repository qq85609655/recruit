package org.amberframework.web.system.auth.model.extension.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysGroupRoleExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();
  
  static {
    columnMap.put("id", "ID");
    columnMap.put("groupId", "GROUP_ID");
    columnMap.put("roleId", "ROLE_ID");
    columnMap.put("extended", "EXTENDED");
  }
  
  private SysGroupRoleExtColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
