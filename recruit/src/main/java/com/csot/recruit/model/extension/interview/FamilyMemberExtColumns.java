package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyMemberExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("menberName", "MENBER_NAME");
        columnMap.put("familyRelation", "FAMILY_RELATION");
        columnMap.put("menberGender", "MENBER_GENDER");
        columnMap.put("menberBirthday", "MENBER_BIRTHDAY");
        columnMap.put("menberAddress", "MENBER_ADDRESS");
        columnMap.put("emergentFlag", "EMERGENT_FLAG");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}