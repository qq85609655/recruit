package com.csot.recruit.model.original.resumelibrary.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressbookColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personName", "PERSON_NAME");
        columnMap.put("email", "EMAIL");
        columnMap.put("company", "COMPANY");
        columnMap.put("currentPosition", "CURRENT_POSITION");
        columnMap.put("phoneNo", "PHONE_NO");
        columnMap.put("tellphoneNo", "TELLPHONE_NO");
        columnMap.put("organization", "ORGANIZATION");
        columnMap.put("remark", "REMARK");
        columnMap.put("createTime", "CREATE_TIME");
        columnMap.put("changeTime", "CHANGE_TIME");
        columnMap.put("createUserId", "CREATE_USER_ID");
        columnMap.put("changeUserId", "CHANGE_USER_ID");
        columnMap.put("reserved1", "RESERVED_1");
        columnMap.put("reserved2", "RESERVED_2");
        columnMap.put("reserved3", "RESERVED_3");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}