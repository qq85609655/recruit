package com.csot.recruit.model.original.flow.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewBookColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("interviewee", "INTERVIEWEE");
        columnMap.put("interviewers", "INTERVIEWERS");
        columnMap.put("linkman", "LINKMAN");
        columnMap.put("interviewType", "INTERVIEW_TYPE");
        columnMap.put("tel", "TEL");
        columnMap.put("waitAddress", "WAIT_ADDRESS");
        columnMap.put("interviewAddress", "INTERVIEW_ADDRESS");
        columnMap.put("isMessage", "IS_MESSAGE");
        columnMap.put("isEmail", "IS_EMAIL");
        columnMap.put("secondRNotice", "SECOND_R_NOTICE");
        columnMap.put("secondRTime", "SECOND_R_TIME");
        columnMap.put("secondENotice", "SECOND_E_NOTICE");
        columnMap.put("secondETime", "SECOND_E_TIME");
        columnMap.put("interviewStatus", "INTERVIEW_STATUS");
        columnMap.put("positionId", "POSITION_ID");
        columnMap.put("modelId", "MODEL_ID");
        columnMap.put("emailContent", "EMAIL_CONTENT");
        columnMap.put("isLink", "IS_LINK");
        columnMap.put("interviewDate", "INTERVIEW_DATE");
        columnMap.put("interviewBTime", "INTERVIEW_B_TIME");
        columnMap.put("interviewETime", "INTERVIEW_E_TIME");
        columnMap.put("candidateName", "CANDIDATE_NAME");
        columnMap.put("reason", "REASON");
        columnMap.put("rounds", "ROUNDS");
        columnMap.put("workCode", "WORK_CODE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}