package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployARalationColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("employId", "EMPLOY_ID");
        columnMap.put("attachmentId", "ATTACHMENT_ID");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("createDate", "CREATE_DATE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}