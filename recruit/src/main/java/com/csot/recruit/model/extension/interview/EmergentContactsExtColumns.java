package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmergentContactsExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("emergentName", "EMERGENT_NAME");
        columnMap.put("emergentRelation", "EMERGENT_RELATION");
        columnMap.put("emergentPhone", "EMERGENT_PHONE");
        columnMap.put("emergentAddress", "EMERGENT_ADDRESS");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}