package com.csot.recruit.model.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("type", "TYPE");
        columnMap.put("title", "TITLE");
        columnMap.put("context", "CONTEXT");
        columnMap.put("subject", "SUBJECT");
        columnMap.put("attch", "ATTCH");
        columnMap.put("creator", "CREATOR");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("updateDate", "UPDATE_DATE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}