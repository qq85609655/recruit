package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("rewardName1", "REWARD_NAME_1");
        columnMap.put("rewardDate1", "REWARD_DATE_1");
        columnMap.put("authorities1", "AUTHORITIES_1");
        columnMap.put("rewardName2", "REWARD_NAME_2");
        columnMap.put("rewardDate2", "REWARD_DATE_2");
        columnMap.put("authorities2", "AUTHORITIES_2");
        columnMap.put("rewardName3", "REWARD_NAME_3");
        columnMap.put("rewardDate3", "REWARD_DATE_3");
        columnMap.put("authorities3", "AUTHORITIES_3");
        columnMap.put("hobby", "HOBBY");
        columnMap.put("speciality", "SPECIALITY");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}