package com.csot.recruit.model.position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentRequireColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "id");
        columnMap.put("department", "department");
        columnMap.put("positionCode", "position_code");
        columnMap.put("demands", "demands");
        columnMap.put("effectiveDate", "effective_date");
        columnMap.put("expectDate", "expect_date");
        columnMap.put("demandType", "demand_type");
        columnMap.put("recruitPositionId", "recruit_position_id");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}