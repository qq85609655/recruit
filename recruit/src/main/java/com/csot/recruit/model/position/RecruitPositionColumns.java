package com.csot.recruit.model.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecruitPositionColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("recruitPositionId", "recruit_position_id");
        columnMap.put("positionName", "position_name");
        columnMap.put("positionCode", "position_code");
        columnMap.put("positionType", "position_type");
        columnMap.put("positionLevel", "position_level");
        columnMap.put("positionSimilar", "position_similar");
        columnMap.put("positionRequire", "position_require");
        columnMap.put("positionIndustry", "position_industry");
        columnMap.put("positionDescription", "position_description");
        columnMap.put("workPlace", "work_place");
        columnMap.put("validaty", "validaty");
        columnMap.put("recruitNumbers", "recruit_numbers");
        columnMap.put("salary", "salary");
        columnMap.put("recruitType", "recruit_type");
        columnMap.put("recruitObject", "recruit_object");
        columnMap.put("secrecy", "secrecy");
        columnMap.put("status", "status");
        columnMap.put("label", "label");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}