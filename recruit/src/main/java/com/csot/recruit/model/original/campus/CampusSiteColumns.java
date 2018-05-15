package com.csot.recruit.model.original.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampusSiteColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("siteName", "SITE_NAME");
        columnMap.put("remark", "REMARK");
        columnMap.put("reserved1", "RESERVED_1");
        columnMap.put("reserved2", "RESERVED_2");
        columnMap.put("reserved3", "RESERVED_3");
        columnMap.put("status", "STATUS");
        columnMap.put("siteId", "SITE_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}