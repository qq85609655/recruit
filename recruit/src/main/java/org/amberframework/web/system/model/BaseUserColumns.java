package org.amberframework.web.system.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseUserColumns {

  private BaseUserColumns() {}

  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "id");
    columnMap.put("account", "account");
    columnMap.put("password", "password");
    columnMap.put("status", "status");
    columnMap.put("name", "name");
    columnMap.put("tel", "tel");
    columnMap.put("cellphone", "cellphone");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
