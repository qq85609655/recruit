package com.csot.recruit.model.original.flow.recruitdemand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecruitDemandColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("demandId", "DEMAND_ID");
        columnMap.put("theme", "THEME");
        columnMap.put("dutyPersonId", "DUTY_PERSON_ID");
        columnMap.put("applyOrganizationId", "APPLY_ORGANIZATION_ID");
        columnMap.put("applyPostId", "APPLY_POST_ID");
        columnMap.put("employeeType", "EMPLOYEE_TYPE");
        columnMap.put("recruitDemandReason", "RECRUIT_DEMAND_REASON");
        columnMap.put("dimissionChangePerson", "DIMISSION_CHANGE_PERSON");
        columnMap.put("rankId", "RANK_ID");
        columnMap.put("applyPersonNumber", "APPLY_PERSON_NUMBER");
        columnMap.put("applyDate", "APPLY_DATE");
        columnMap.put("predictComeDate", "PREDICT_COME_DATE");
        columnMap.put("wantComeDate", "WANT_COME_DATE");
        columnMap.put("district", "DISTRICT");
        columnMap.put("deputyId", "DEPUTY_ID");
        columnMap.put("workRemark", "WORK_REMARK");
        columnMap.put("infoState", "INFO_STATE");
        columnMap.put("flowState", "FLOW_STATE");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("modifiedId", "MODIFIED_ID");
        columnMap.put("gender", "GENDER");
        columnMap.put("education", "EDUCATION");
        columnMap.put("profession", "PROFESSION");
        columnMap.put("workExperience", "WORK_EXPERIENCE");
        columnMap.put("requiredSkill", "REQUIRED_SKILL");
        columnMap.put("abilityDemanded", "ABILITY_DEMANDED");
        columnMap.put("reserved1", "RESERVED_1");
        columnMap.put("reserved2", "RESERVED_2");
        columnMap.put("applyOrganizationName", "APPLY_ORGANIZATION_NAME");
        columnMap.put("applyPostName", "APPLY_POST_NAME");
        columnMap.put("deputyName", "DEPUTY_NAME");
        columnMap.put("isFinish", "IS_FINISH");
        columnMap.put("offerNumber", "OFFER_NUMBER");
        columnMap.put("entryNumber", "ENTRY_NUMBER");
        
        
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}