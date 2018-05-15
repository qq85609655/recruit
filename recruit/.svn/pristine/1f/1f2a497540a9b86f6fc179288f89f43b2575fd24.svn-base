package com.csot.recruit.model.original.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("recommended", "RECOMMENDED");
        columnMap.put("recommendRelation", "RECOMMEND_RELATION");
        columnMap.put("recommendPosition", "RECOMMEND_POSITION");
        columnMap.put("recommendPhone", "RECOMMEND_PHONE");
        columnMap.put("recommendAddress", "RECOMMEND_ADDRESS");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}