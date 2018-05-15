package com.csot.recruit.model.extension.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampusPostExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("postId", "POST_ID");
        columnMap.put("postName", "POST_NAME");
        columnMap.put("remark", "REMARK");
        columnMap.put("reserved1", "RESERVED_1");
        columnMap.put("reserved2", "RESERVED_2");
        columnMap.put("reserved3", "RESERVED_3");
        columnMap.put("status", "STATUS");
        columnMap.put("organization", "ORGANIZATION");
        columnMap.put("bigCenter", "BIG_CENTER");
        columnMap.put("smallCenter", "SMALL_CENTER");
        columnMap.put("jobFamily", "JOB_FAMILY");
        columnMap.put("jobClass", "JOB_CLASS");
        columnMap.put("jobSubclass", "JOB_SUBCLASS");
        columnMap.put("recruitQuantity", "RECRUIT_QUANTITY");
        columnMap.put("educationAdvise", "EDUCATION_ADVISE");
        columnMap.put("schoolAdvise", "SCHOOL_ADVISE");
        columnMap.put("sexAdvise", "SEX_ADVISE");
        columnMap.put("preferredMajor", "PREFERRED_MAJOR");
        columnMap.put("alternativeMajor", "ALTERNATIVE_MAJOR");
        columnMap.put("otherDemand", "OTHER_DEMAND");
        columnMap.put("postDescribe", "POST_DESCRIBE");
        columnMap.put("specialCondition", "SPECIAL_CONDITION");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}