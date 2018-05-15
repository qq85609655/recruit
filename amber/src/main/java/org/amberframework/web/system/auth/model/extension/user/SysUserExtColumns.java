package org.amberframework.web.system.auth.model.extension.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysUserExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();
  
  static {
    columnMap.put("id", "ID");
    columnMap.put("account", "ACCOUNT");
    columnMap.put("password", "PASSWORD");
    columnMap.put("status", "STATUS");
    columnMap.put("salt", "SALT");
  }
  
  private SysUserExtColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
