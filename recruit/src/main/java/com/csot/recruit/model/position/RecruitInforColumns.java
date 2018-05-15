package com.csot.recruit.model.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecruitInforColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "id");
        columnMap.put("recruiter", "recruiter");
        columnMap.put("recruiterOther", "recruiter_other");
        columnMap.put("departmentManager", "department_manager");
        columnMap.put("receiveEmail", "receive_email");
        columnMap.put("interviewEvaluateTemplate", "interview_evaluate_template");
        columnMap.put("recruitPositionId", "recruit_position_id");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}