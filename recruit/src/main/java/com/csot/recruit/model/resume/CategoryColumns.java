package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("name", "NAME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}