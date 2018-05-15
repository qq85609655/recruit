package com.csot.gm.materialManage.model.extension.systemNotice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemNoticeExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("noticeTitle", "NOTICE_TITLE");
    columnMap.put("noticeLevel", "NOTICE_LEVEL");
    columnMap.put("updateTime", "UPDATE_TIME");
    columnMap.put("isActive", "IS_ACTIVE");
    columnMap.put("noticeContents", "NOTICE_CONTENTS");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}