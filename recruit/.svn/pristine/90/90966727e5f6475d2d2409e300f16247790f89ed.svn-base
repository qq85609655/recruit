package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployBlacklistColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("candidateId", "CANDIDATE_ID");
        columnMap.put("candidateName", "CANDIDATE_NAME");
        columnMap.put("inReason", "IN_REASON");
        columnMap.put("outReason", "OUT_REASON");
        columnMap.put("state", "STATE");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("modifiedId", "MODIFIED_ID");
        columnMap.put("updateDate", "UPDATE_DATE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}