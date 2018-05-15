package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployCandidateColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("name", "NAME");
        columnMap.put("pinyin", "PINYIN");
        columnMap.put("englishName", "ENGLISH_NAME");
        columnMap.put("emailName", "EMAIL_NAME");
        columnMap.put("isDevote", "IS_DEVOTE");
        columnMap.put("gender", "GENDER");
        columnMap.put("birthday", "BIRTHDAY");
        columnMap.put("phone", "PHONE");
        columnMap.put("email", "EMAIL");
        columnMap.put("candidatePostId", "CANDIDATE_POST_ID");
        columnMap.put("candidatePostName", "CANDIDATE_POST_NAME");
        columnMap.put("candidateOrgId", "CANDIDATE_ORG_ID");
        columnMap.put("candidateOrgName", "CANDIDATE_ORG_NAME");
        columnMap.put("recruitSource", "RECRUIT_SOURCE");
        columnMap.put("referrerId", "REFERRER_ID");
        columnMap.put("referrerName", "REFERRER_NAME");
        columnMap.put("referrerOrgId", "REFERRER_ORG_ID");
        columnMap.put("referrerOrgName", "REFERRER_ORG_NAME");
        columnMap.put("candidateType", "CANDIDATE_TYPE");
        columnMap.put("isBeidiao", "IS_BEIDIAO");
        columnMap.put("isEvaluating", "IS_EVALUATING");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("modifiedId", "MODIFIED_ID");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("employId", "EMPLOY_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}