package com.csot.recruit.model.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecruitFlowConfigColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("recruitPerson", "RECRUIT_PERSON");
        columnMap.put("recruitPersonOther", "RECRUIT_PERSON_OTHER");
        columnMap.put("demandDepOwner", "DEMAND_DEP_OWNER");
        columnMap.put("receiveEmail", "RECEIVE_EMAIL");
        columnMap.put("interviewTemplate", "INTERVIEW_TEMPLATE");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("recruitPositionId", "RECRUIT_POSITION_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}