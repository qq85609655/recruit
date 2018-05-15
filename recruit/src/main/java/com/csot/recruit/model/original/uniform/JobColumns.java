package com.csot.recruit.model.original.uniform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("cJobname", "C_JOBNAME");
        columnMap.put("cOldOrgcode", "C_OLD_ORGCODE");
        columnMap.put("cOrgcode", "C_ORGCODE");
        columnMap.put("cOldJobcode", "C_OLD_JOBCODE");
        columnMap.put("cJobcode", "C_JOBCODE");
        columnMap.put("cIsResponsible", "C_IS_RESPONSIBLE");
        columnMap.put("cAvailable", "C_AVAILABLE");
        columnMap.put("cSort", "C_SORT");
        columnMap.put("cKey", "C_KEY");
        columnMap.put("cRemark", "C_REMARK");
        columnMap.put("cStatus", "C_STATUS");
        columnMap.put("jobid", "JOBID");
        columnMap.put("isTempJob", "IS_TEMP_JOB");
        columnMap.put("cOperatortime", "C_OPERATORTIME");
        columnMap.put("fdPrimaryKey", "FD_PRIMARY_KEY");
        columnMap.put("fdStatus", "FD_STATUS");
        columnMap.put("fdExcuteTime", "FD_EXCUTE_TIME");
        columnMap.put("fdIsUpdated", "FD_IS_UPDATED");
        columnMap.put("fdUpdateEmpNo", "FD_UPDATE_EMP_NO");
        columnMap.put("fdUpdateTime", "FD_UPDATE_TIME");
        columnMap.put("reserved1", "RESERVED_1");
        columnMap.put("reserved2", "RESERVED_2");
        columnMap.put("reserved3", "RESERVED_3");
        columnMap.put("reserved4", "RESERVED_4");
        columnMap.put("reserved5", "RESERVED_5");
        columnMap.put("reserved6", "RESERVED_6");
        columnMap.put("reserved7", "RESERVED_7");
        columnMap.put("reserved8", "RESERVED_8");
        columnMap.put("reserved9", "RESERVED_9");
        columnMap.put("reserved10", "RESERVED_10");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}