package com.csot.recruit.model.original.candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateRecommendColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("candidatePostId", "CANDIDATE_POST_ID");
        columnMap.put("interviewer", "INTERVIEWER");
        columnMap.put("resumeId", "RESUME_ID");
        columnMap.put("comments", "COMMENTS");
        columnMap.put("feedback", "FEEDBACK");
        columnMap.put("turntoPostId", "TURNTO_POST_ID");
        columnMap.put("createUser", "CREATE_USER");
        columnMap.put("createTime", "CREATE_TIME");
        columnMap.put("feedbackTime", "FEEDBACK_TIME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}