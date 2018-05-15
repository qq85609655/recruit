package com.csot.recruit.model.original.attachment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttachmentColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("relateId", "RELATE_ID");
        columnMap.put("type", "TYPE");
        columnMap.put("state", "STATE");
        columnMap.put("saveName", "SAVE_NAME");
        columnMap.put("showName", "SHOW_NAME");
        columnMap.put("savePath", "SAVE_PATH");
        columnMap.put("createtime", "CREATETIME");
        columnMap.put("reserved1", "RESERVED1");
        columnMap.put("reserved2", "RESERVED2");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}