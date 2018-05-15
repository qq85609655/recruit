package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("candidateId", "CANDIDATE_ID");
        columnMap.put("candidateName", "CANDIDATE_NAME");
        columnMap.put("employPostId", "EMPLOY_POST_ID");
        columnMap.put("employPostName", "EMPLOY_POST_NAME");
        columnMap.put("stage", "STAGE");
        columnMap.put("demandId", "DEMAND_ID");
        columnMap.put("employmentForm", "EMPLOYMENT_FORM");
        columnMap.put("appraisalInterviewHr", "APPRAISAL_INTERVIEW_HR");
        columnMap.put("appraisalInterview", "APPRAISAL_INTERVIEW");
        columnMap.put("entryDate", "ENTRY_DATE");
        columnMap.put("entryDateHide", "ENTRY_DATE_HIDE");
        columnMap.put("simulationEntryDate", "SIMULATION_ENTRY_DATE");
        columnMap.put("flowState", "FLOW_STATE");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("modifiedId", "MODIFIED_ID");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("employOrgId", "EMPLOY_ORG_ID");
        columnMap.put("employOrgName", "EMPLOY_ORG_NAME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}