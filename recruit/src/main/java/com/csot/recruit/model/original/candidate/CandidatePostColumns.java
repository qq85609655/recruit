package com.csot.recruit.model.original.candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidatePostColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("candidateId", "CANDIDATE_ID");
        columnMap.put("operatorUser", "OPERATOR_USER");
        columnMap.put("positionId", "POSITION_ID");
        columnMap.put("interviewStatus", "INTERVIEW_STATUS");
        columnMap.put("operatorDate", "OPERATOR_DATE");
        columnMap.put("createTime", "CREATE_TIME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}