package com.csot.recruit.model.resume.resumeRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeRuleFieldColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("fieldName", "FIELD_NAME");
        columnMap.put("score", "SCORE");
        columnMap.put("reserve1", "RESERVE1");
        columnMap.put("reserve2", "RESERVE2");
        columnMap.put("creator", "CREATOR");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("modificator", "MODIFICATOR");
        columnMap.put("modifyDate", "MODIFY_DATE");
    }

    public static String getColumn(String propertyName) {
      String[] propertys = propertyName.split(",");  
      String columns = "";
      for(int i = 0; i < propertys.length; i++) {
        columns += "," + columnMap.get(propertys[i]);
      }
      if(columns.length() > 0) {
        columns = columns.substring(1);
      }
      return columns;
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}