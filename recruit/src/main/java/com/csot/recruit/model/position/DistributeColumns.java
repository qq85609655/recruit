package com.csot.recruit.model.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistributeColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("distributeDate", "DISTRIBUTE_DATE");
        columnMap.put("publisher", "PUBLISHER");
        columnMap.put("result", "RESULT");
        columnMap.put("publishSite", "PUBLISH_SITE");
        columnMap.put("publishUrl", "PUBLISH_URL");
        columnMap.put("recruitPositionId", "RECRUIT_POSITION_ID");
        columnMap.put("errorMessage", "ERROR_MESSAGE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}