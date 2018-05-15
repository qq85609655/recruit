package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployRefuseOfferColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("reason", "REASON");
        columnMap.put("salary", "SALARY");
        columnMap.put("oldcompany", "OLDCOMPANY");
        columnMap.put("traffic", "TRAFFIC");
        columnMap.put("other", "OTHER");
        columnMap.put("otherOffer", "OTHER_OFFER");
        columnMap.put("employId", "EMPLOY_ID");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("modifiedId", "MODIFIED_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}