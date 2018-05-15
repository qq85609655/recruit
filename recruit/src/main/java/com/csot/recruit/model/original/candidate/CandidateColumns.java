package com.csot.recruit.model.original.candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("name", "NAME");
        columnMap.put("nameEn", "NAME_EN");
        columnMap.put("sex", "SEX");
        columnMap.put("age", "AGE");
        columnMap.put("positionid", "POSITIONID");
        columnMap.put("currentCompany", "CURRENT_COMPANY");
        columnMap.put("currentPosition", "CURRENT_POSITION");
        columnMap.put("workExperience", "WORK_EXPERIENCE");
        columnMap.put("highestEducation", "HIGHEST_EDUCATION");
        columnMap.put("graduationSchool", "GRADUATION_SCHOOL");
        columnMap.put("professional", "PROFESSIONAL");
        columnMap.put("phone", "PHONE");
        columnMap.put("email", "EMAIL");
        columnMap.put("resumeorigin", "RESUMEORIGIN");
        columnMap.put("channel", "CHANNEL");
        columnMap.put("storageDate", "STORAGE_DATE");
        columnMap.put("resumeStatus", "RESUME_STATUS");
        columnMap.put("postStatus", "POST_STATUS");
        columnMap.put("changeTime", "CHANGE_TIME");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}