package com.csot.recruit.model.original.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperateHistoryColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("operatorType", "OPERATOR_TYPE");
        columnMap.put("operatorUser", "OPERATOR_USER");
        columnMap.put("operatorContent", "OPERATOR_CONTENT");
        columnMap.put("relatedId", "RELATED_ID");
        columnMap.put("operatorTime", "OPERATOR_TIME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}