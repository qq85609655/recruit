package com.csot.gm.materialManage.model.extension.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUploadExtColumns {
  private static final Map<String, String> columnMap = new HashMap<String, String>();

  static {
    columnMap.put("id", "ID");
    columnMap.put("fileType", "FILE_TYPE");
    columnMap.put("fileName", "FILE_NAME");
    columnMap.put("createName", "CREATE_NAME");
    columnMap.put("applicantCode", "APPLICANT_CODE");
    columnMap.put("applicantName", "APPLICANT_NAME");
    columnMap.put("createTime", "CREATE_TIME");
    columnMap.put("fileLocation", "FILE_LOCATION");
    columnMap.put("fileSize", "FILE_SIZE");
    columnMap.put("remark", "REMARK");
  }

  public static String getColumn(String propertyName) {
    return columnMap.get(propertyName);
  }

  public static List<String> getAllColumns() {
    return new ArrayList<String>(columnMap.values());
  }
}