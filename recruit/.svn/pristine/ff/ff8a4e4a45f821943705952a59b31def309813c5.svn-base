package org.amberframework.web.system.auth.model.original.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysUserGroupColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();
  
  static {
    columnMap.put("id", "ID");
    columnMap.put("userId", "USER_ID");
    columnMap.put("groupId", "GROUP_ID");
  }
  
  private SysUserGroupColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
