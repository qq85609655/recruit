package com.csot.recruit.model.original.flow.recruitdemand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecruitDemandChangeColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("type", "TYPE");
        columnMap.put("oldStr", "OLD_STR");
        columnMap.put("newStr", "NEW_STR");
        columnMap.put("demandId", "DEMAND_ID");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("isDeal", "IS_DEAL");
        columnMap.put("isAgerr", "IS_AGERR");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}