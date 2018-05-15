package com.csot.recruit.model.extension.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampusStudentExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("siteId", "SITE_ID");
        columnMap.put("siteName", "SITE_NAME");
        columnMap.put("postId", "POST_ID");
        columnMap.put("postName", "POST_NAME");
        columnMap.put("workingPlace", "WORKING_PLACE");
        columnMap.put("jobFamily", "JOB_FAMILY");
        columnMap.put("jobClass", "JOB_CLASS");
        columnMap.put("jobSubclass", "JOB_SUBCLASS");
        columnMap.put("organization", "ORGANIZATION");
        columnMap.put("bigCenter", "BIG_CENTER");
        columnMap.put("smallCenter", "SMALL_CENTER");
        columnMap.put("department", "DEPARTMENT");
        columnMap.put("offices", "OFFICES");
        columnMap.put("realname", "REALNAME");
        columnMap.put("sex", "SEX");
        columnMap.put("education", "EDUCATION");
        columnMap.put("school", "SCHOOL");
        columnMap.put("major", "MAJOR");
        columnMap.put("nativePlace", "NATIVE_PLACE");
        columnMap.put("phoneNo", "PHONE_NO");
        columnMap.put("email", "EMAIL");
        columnMap.put("evaluation", "EVALUATION");
        columnMap.put("moraleRisk", "MORALE_RISK");
        columnMap.put("competency", "COMPETENCY");
        columnMap.put("resultFirst", "RESULT_FIRST");
        columnMap.put("resultSecond", "RESULT_SECOND");
        columnMap.put("offer", "OFFER");
        columnMap.put("trilateral", "TRILATERAL");
        columnMap.put("transcript", "TRANSCRIPT");
        columnMap.put("referenceForm", "REFERENCE_FORM");
        columnMap.put("idcardCopy", "IDCARD_COPY");
        columnMap.put("cetTranscript", "CET_TRANSCRIPT");
        columnMap.put("photo", "PHOTO");
        columnMap.put("breakOff", "BREAK_OFF");
        columnMap.put("yearth", "YEARTH");
        columnMap.put("changeTime", "CHANGE_TIME");
        columnMap.put("createUser", "CREATE_USER");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}