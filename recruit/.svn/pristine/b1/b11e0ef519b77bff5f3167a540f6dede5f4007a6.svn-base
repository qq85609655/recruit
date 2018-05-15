package com.csot.recruit.model.original.flow.websitePost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostWebsiteLogColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("postId", "POST_ID");
        columnMap.put("recruitPositionId", "RECRUIT_POSITION_ID");
        columnMap.put("postName", "POST_NAME");
        columnMap.put("deputyId", "DEPUTY_ID");
        columnMap.put("deputyName", "DEPUTY_NAME");
        columnMap.put("instructDate", "INSTRUCT_DATE");
        columnMap.put("websitePostName", "WEBSITE_POST_NAME");
        columnMap.put("state", "STATE");
        columnMap.put("lastInstruct", "LAST_INSTRUCT");
        columnMap.put("creatorId", "CREATOR_ID");
        columnMap.put("createDate", "CREATE_DATE");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("modifiedId", "MODIFIED_ID");
        columnMap.put("websiteType", "WEBSITE_TYPE");
        columnMap.put("beforeState", "BEFORE_STATE");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}