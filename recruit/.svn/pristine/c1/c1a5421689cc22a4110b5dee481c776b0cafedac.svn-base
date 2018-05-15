package com.csot.recruit.model.original.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IllustrateColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("infectionFlag", "INFECTION_FLAG");
        columnMap.put("infectionText", "INFECTION_TEXT");
        columnMap.put("criminalFlag", "CRIMINAL_FLAG");
        columnMap.put("criminalText", "CRIMINAL_TEXT");
        columnMap.put("employFlag", "EMPLOY_FLAG");
        columnMap.put("employText", "EMPLOY_TEXT");
        columnMap.put("investigateFlag", "INVESTIGATE_FLAG");
        columnMap.put("investigateText", "INVESTIGATE_TEXT");
        columnMap.put("banFlag", "BAN_FLAG");
        columnMap.put("banStartdate", "BAN_STARTDATE");
        columnMap.put("banEnddate", "BAN_ENDDATE");
        columnMap.put("payment", "PAYMENT");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}