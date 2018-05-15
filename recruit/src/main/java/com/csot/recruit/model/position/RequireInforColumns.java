package com.csot.recruit.model.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequireInforColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("ageMin", "AGE_MIN");
        columnMap.put("ageMax", "AGE_MAX");
        columnMap.put("workExperienceMin", "WORK_EXPERIENCE_MIN");
        columnMap.put("workExperienceMax", "WORK_EXPERIENCE_MAX");
        columnMap.put("englishLevel", "ENGLISH_LEVEL");
        columnMap.put("educationMin", "EDUCATION_MIN");
        columnMap.put("educationMax", "EDUCATION_MAX");
        columnMap.put("recruitPositionId", "RECRUIT_POSITION_ID");
        columnMap.put("gender", "GENDER");
        columnMap.put("ageNot", "AGE_NOT");
        columnMap.put("workExperienceNot", "WORK_EXPERIENCE_NOT");
        columnMap.put("englishLevelNot", "ENGLISH_LEVEL_NOT");
        columnMap.put("educationNot", "EDUCATION_NOT");
        columnMap.put("agenderNot", "AGENDER_NOT");
        columnMap.put("createDate", "CREATE_DATE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}