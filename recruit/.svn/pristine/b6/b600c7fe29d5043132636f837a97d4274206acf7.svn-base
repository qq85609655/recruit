package com.csot.recruit.model.original.flow.recruitdemand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecruitDemandShareColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("recruitDemandId", "RECRUIT_DEMAND_ID");
        columnMap.put("shaerPersonId", "SHAER_PERSON_ID");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("postId", "POST_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}