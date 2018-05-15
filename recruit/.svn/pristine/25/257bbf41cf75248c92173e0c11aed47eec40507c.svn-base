package com.csot.recruit.model.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganazationColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("orgName", "ORG_NAME");
        columnMap.put("orgParent", "ORG_PARENT");
        columnMap.put("linkman", "LINKMAN");
        columnMap.put("tel", "TEL");
        columnMap.put("email", "EMAIL");
        columnMap.put("creator", "CREATOR");
        columnMap.put("createtime", "CREATETIME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}