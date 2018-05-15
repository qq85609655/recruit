package com.csot.recruit.model.datadict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatadictGroupColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("groupId", "GROUP_ID");
        columnMap.put("groupCode", "GROUP_CODE");
        columnMap.put("groupName", "GROUP_NAME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}