package com.csot.recruit.model.datadict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatadictGroupTypeColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("typeId", "TYPE_ID");
        columnMap.put("typeCode", "TYPE_CODE");
        columnMap.put("typeName", "TYPE_NAME");
        columnMap.put("typePid", "TYPE_PID");
        columnMap.put("groupId", "GROUP_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}