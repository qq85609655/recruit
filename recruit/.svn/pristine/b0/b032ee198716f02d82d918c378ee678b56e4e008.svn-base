package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkIntentionColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("workplaceExpect", "WORKPLACE_EXPECT");
        columnMap.put("industryExpect", "INDUSTRY_EXPECT");
        columnMap.put("jobtypeExpect", "JOBTYPE_EXPECT");
        columnMap.put("postExpect", "POST_EXPECT");
        columnMap.put("salaryExpect", "SALARY_EXPECT");
        columnMap.put("rpeortTime", "RPEORT_TIME");
        columnMap.put("currency", "CURRENCY");
        columnMap.put("resumeId", "RESUME_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}