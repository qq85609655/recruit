package com.csot.recruit.model.original.uniform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("cOrgname", "C_ORGNAME");
        columnMap.put("cOldOrgcode", "C_OLD_ORGCODE");
        columnMap.put("cOrgcode", "C_ORGCODE");
        columnMap.put("cOrgtype", "C_ORGTYPE");
        columnMap.put("cOldChargecode", "C_OLD_CHARGECODE");
        columnMap.put("cChargecode", "C_CHARGECODE");
        columnMap.put("cOldOrgparentcode", "C_OLD_ORGPARENTCODE");
        columnMap.put("cOrgparentcode", "C_ORGPARENTCODE");
        columnMap.put("cOldOrgparentlead", "C_OLD_ORGPARENTLEAD");
        columnMap.put("cOrgparentlead", "C_ORGPARENTLEAD");
        columnMap.put("cAvailable", "C_AVAILABLE");
        columnMap.put("cSort", "C_SORT");
        columnMap.put("cKey", "C_KEY");
        columnMap.put("cRemark", "C_REMARK");
        columnMap.put("cStatus", "C_STATUS");
        columnMap.put("orgid", "ORGID");
        columnMap.put("kostl", "KOSTL");
        columnMap.put("kostlt", "KOSTLT");
        columnMap.put("cOneunit", "C_ONEUNIT");
        columnMap.put("cTwounit", "C_TWOUNIT");
        columnMap.put("cThreeunit", "C_THREEUNIT");
        columnMap.put("cFourunit", "C_FOURUNIT");
        columnMap.put("cFiveunit", "C_FIVEUNIT");
        columnMap.put("isTempOrg", "IS_TEMP_ORG");
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
        columnMap.put("isReportrelationDeal", "IS_REPORTRELATION_DEAL");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}