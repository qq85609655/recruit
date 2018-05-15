package com.csot.recruit.model.extension.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampusAddressbookExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("workNo", "WORK_NO");
        columnMap.put("realname", "REALNAME");
        columnMap.put("siteName", "SITE_NAME");
        columnMap.put("siteId", "SITE_ID");
        columnMap.put("campusRole", "CAMPUS_ROLE");
        columnMap.put("phoneno", "PHONENO");
        columnMap.put("email", "EMAIL");
        columnMap.put("reserved1", "RESERVED_1");
        columnMap.put("reserved2", "RESERVED_2");
        columnMap.put("reserved3", "RESERVED_3");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}