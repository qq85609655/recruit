package com.csot.recruit.model.extension.campus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampusTaskExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("siteId", "SITE_ID");
        columnMap.put("siteName", "SITE_NAME");
        columnMap.put("postId", "POST_ID");
        columnMap.put("postName", "POST_NAME");
        columnMap.put("taskNumberBa", "TASK_NUMBER_BA");
        columnMap.put("taskNumberMa", "TASK_NUMBER_MA");
        columnMap.put("taskNumberDo", "TASK_NUMBER_DO");
        columnMap.put("remark", "REMARK");
        columnMap.put("reserved1", "RESERVED_1");
        columnMap.put("reserved2", "RESERVED_2");
        columnMap.put("reserved3", "RESERVED_3");
        columnMap.put("status", "STATUS");
        columnMap.put("yearth", "YEARTH");
        columnMap.put("orgName", "ORG_NAME");
        columnMap.put("organization", "ORGANIZATION");
        columnMap.put("bigCenter", "BIG_CENTER");
        columnMap.put("smallCenter", "SMALL_CENTER");
        columnMap.put("department", "DEPARTMENT");
        columnMap.put("branch", "BRANCH");
        columnMap.put("jobFamily", "JOB_FAMILY");
        columnMap.put("jobClass", "JOB_CLASS");
        columnMap.put("jobSubclass", "JOB_SUBCLASS");
        columnMap.put("jobDescribe", "JOB_DESCRIBE");
        columnMap.put("nightShift", "NIGHT_SHIFT");
        columnMap.put("dustFree", "DUST_FREE");
        columnMap.put("taskNumberSum", "TASK_NUMBER_SUM");
        columnMap.put("taskNumberMail", "TASK_NUMBER_MAIL");
        columnMap.put("taskNumberFemail", "TASK_NUMBER_FEMAIL");
        columnMap.put("specialRequire", "SPECIAL_REQUIRE");
        columnMap.put("preferredMajor", "PREFERRED_MAJOR");
        columnMap.put("alternativeMajor", "ALTERNATIVE_MAJOR");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}