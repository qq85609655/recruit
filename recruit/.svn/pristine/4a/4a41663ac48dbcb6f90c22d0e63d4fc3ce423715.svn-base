package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorksExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("workIndex", "WORK_INDEX");
        columnMap.put("workstartdate", "WORKSTARTDATE");
        columnMap.put("workenddate", "WORKENDDATE");
        columnMap.put("companyName", "COMPANY_NAME");
        columnMap.put("finalSalary", "FINAL_SALARY");
        columnMap.put("department", "DEPARTMENT");
        columnMap.put("finalPosition", "FINAL_POSITION");
        columnMap.put("reportTo", "REPORT_TO");
        columnMap.put("subordinates", "SUBORDINATES");
        columnMap.put("seniority", "SENIORITY");
        columnMap.put("responsibilities", "RESPONSIBILITIES");
        columnMap.put("leaveReason", "LEAVE_REASON");
        columnMap.put("reterence", "RETERENCE");
        columnMap.put("relationship", "RELATIONSHIP");
        columnMap.put("reterencePhone", "RETERENCE_PHONE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}