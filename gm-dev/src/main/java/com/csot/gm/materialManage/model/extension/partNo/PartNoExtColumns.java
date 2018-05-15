package com.csot.gm.materialManage.model.extension.partNo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartNoExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("partNo", "PART_NO");
    columnMap.put("partName", "PART_NAME");
    columnMap.put("cnDesc", "CN_DESC");
    columnMap.put("enDesc", "EN_DESC");
    columnMap.put("createCode", "CREATE_CODE");
    columnMap.put("createTime", "CREATE_TIME");
    columnMap.put("partNoStatus", "PART_NO_STATUS");
    columnMap.put("partId", "PART_ID");
    columnMap.put("hashCode", "HASH_CODE");
    columnMap.put("partNoUid", "PART_NO_UID");
    columnMap.put("createName", "CREATE_NAME");
    columnMap.put("plant", "PLANT");
    columnMap.put("department", "DEPARTMENT");
    columnMap.put("telephone", "TELEPHONE");
    columnMap.put("partType", "PART_TYPE");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}