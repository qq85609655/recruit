package com.csot.recruit.model.resume.resumeRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeRuleColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("fields", "FIELDS");
        columnMap.put("passLine", "PASS_LINE");
        columnMap.put("reserve1", "RESERVE1");
        columnMap.put("reserve2", "RESERVE2");
        columnMap.put("creator", "CREATOR");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("modificator", "MODIFICATOR");
        columnMap.put("modifyDate", "MODIFY_DATE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}