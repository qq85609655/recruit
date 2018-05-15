package com.csot.recruit.model.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("logid", "logid");
        columnMap.put("broswer", "broswer");
        columnMap.put("logcontent", "logcontent");
        columnMap.put("loglevel", "loglevel");
        columnMap.put("note", "note");
        columnMap.put("operatetime", "operatetime");
        columnMap.put("operatetype", "operatetype");
        columnMap.put("userid", "userid");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}