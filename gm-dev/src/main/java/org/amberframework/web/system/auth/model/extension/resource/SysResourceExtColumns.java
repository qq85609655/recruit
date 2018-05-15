package org.amberframework.web.system.auth.model.extension.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysResourceExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();
  
  static {
    columnMap.put("id", "ID");
    columnMap.put("name", "NAME");
    columnMap.put("menuName", "MENU_NAME");
    columnMap.put("url", "URL");
    columnMap.put("parentId", "PARENT_ID");
    columnMap.put("parentIds", "PARENT_IDS");
    columnMap.put("icon", "ICON");
    columnMap.put("showAsMenu", "SHOW_AS_MENU");
  }
  
  private SysResourceExtColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
