package org.amberframework.web.system.auth.model.extension.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysRoleResourceExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();
  
  static {
    columnMap.put("id", "ID");
    columnMap.put("roleId", "ROLE_ID");
    columnMap.put("resourceId", "RESOURCE_ID");
  }
  
  private SysRoleResourceExtColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
