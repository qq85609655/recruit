package com.csot.recruit.model.original.flow.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedbackColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("interviewId", "INTERVIEW_ID");
        columnMap.put("createTime", "CREATE_TIME");
        columnMap.put("content", "CONTENT");
        columnMap.put("userId", "USER_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}