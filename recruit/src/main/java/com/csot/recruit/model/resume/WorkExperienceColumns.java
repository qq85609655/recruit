package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkExperienceColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("companyName", "COMPANY_NAME");
        columnMap.put("companyNameEn", "COMPANY_NAME_EN");
        columnMap.put("jobStartDate", "JOB_START_DATE");
        columnMap.put("jobEndDate", "JOB_END_DATE");
        columnMap.put("industry", "INDUSTRY");
        columnMap.put("positionName", "POSITION_NAME");
        columnMap.put("positionNameEn", "POSITION_NAME_EN");
        columnMap.put("workplace", "WORKPLACE");
        columnMap.put("companyNature", "COMPANY_NATURE");
        columnMap.put("debriefer", "DEBRIEFER");
        columnMap.put("debrieferEn", "DEBRIEFER_EN");
        columnMap.put("subordinate", "SUBORDINATE");
        columnMap.put("salary", "SALARY");
        columnMap.put("currency", "CURRENCY");
        columnMap.put("workPerformace", "WORK_PERFORMACE");
        columnMap.put("workPerformaceEn", "WORK_PERFORMACE_EN");
        columnMap.put("resumeId", "RESUME_ID");
        columnMap.put("department", "DEPARTMENT");
        columnMap.put("seniority", "SENIORITY");
        columnMap.put("leaveReason", "LEAVE_REASON");
        columnMap.put("reterence", "RETERENCE");
        columnMap.put("relationship", "RELATIONSHIP");
        columnMap.put("reterencePhone", "RETERENCE_PHONE");
        columnMap.put("jobDutyEn", "JOB_DUTY_EN");
        columnMap.put("jobDuty", "JOB_DUTY");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}