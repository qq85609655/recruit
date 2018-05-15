package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EducationExperienceColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("eduStartDate", "EDU_START_DATE");
        columnMap.put("eduEndDate", "EDU_END_DATE");
        columnMap.put("schoolName", "SCHOOL_NAME");
        columnMap.put("schoolNameEn", "SCHOOL_NAME_EN");
        columnMap.put("education", "EDUCATION");
        columnMap.put("major", "MAJOR");
        columnMap.put("majorEn", "MAJOR_EN");
        columnMap.put("resumeId", "RESUME_ID");
        columnMap.put("eduType", "EDU_TYPE");
        columnMap.put("certificate", "CERTIFICATE");
        columnMap.put("fkTid", "FK_TID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}