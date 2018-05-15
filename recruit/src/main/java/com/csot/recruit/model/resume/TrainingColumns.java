package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("achievedcertification", "ACHIEVEDCERTIFICATION");
        columnMap.put("course", "COURSE");
        columnMap.put("startingdate", "STARTINGDATE");
        columnMap.put("endingdate", "ENDINGDATE");
        columnMap.put("traininglocation", "TRAININGLOCATION");
        columnMap.put("traininginstitution", "TRAININGINSTITUTION");
        columnMap.put("resumeId", "RESUME_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}