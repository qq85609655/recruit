package haha.test.model.extension.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("name", "NAME");
    columnMap.put("address", "ADDRESS");
    columnMap.put("birthday", "BIRTHDAY");
    columnMap.put("age", "AGE");
    columnMap.put("salary", "SALARY");
    columnMap.put("workPlace", "WORK_PLACE");
  }
  
  private TestUserExtColumns() {
    
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}
