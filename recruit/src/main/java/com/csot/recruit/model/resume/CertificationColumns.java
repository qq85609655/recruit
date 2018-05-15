package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CertificationColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("name", "NAME");
        columnMap.put("receivingdate", "RECEIVINGDATE");
        columnMap.put("score", "SCORE");
        columnMap.put("resumeId", "RESUME_ID");
        columnMap.put("type", "TYPE");
        columnMap.put("num", "NUM");
        columnMap.put("authorityOrg", "AUTHORITY_ORG");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}