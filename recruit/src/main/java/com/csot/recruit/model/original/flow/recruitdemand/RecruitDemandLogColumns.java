package com.csot.recruit.model.original.flow.recruitdemand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecruitDemandLogColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("oldStr", "OLD_STR");
        columnMap.put("newStr", "NEW_STR");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("modifiedId", "MODIFIED_ID");
        columnMap.put("demandId", "DEMAND_ID");
        columnMap.put("updateField", "UPDATE_FIELD");
        columnMap.put("modifiedName", "MODIFIED_NAME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}