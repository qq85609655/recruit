package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployDemandColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("employId", "EMPLOY_ID");
        columnMap.put("demandId", "DEMAND_ID");
        columnMap.put("employeeType", "EMPLOYEE_TYPE");
        columnMap.put("district", "DISTRICT");
        columnMap.put("applyOrganizationName", "APPLY_ORGANIZATION_NAME");
        columnMap.put("applyOrganizationId", "APPLY_ORGANIZATION_ID");
        columnMap.put("applyPostId", "APPLY_POST_ID");
        columnMap.put("applyPostName", "APPLY_POST_NAME");
        columnMap.put("rankId", "RANK_ID");
        columnMap.put("recruitDemandReason", "RECRUIT_DEMAND_REASON");
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