package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewInfoExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("recruiterNumber", "RECRUITER_NUMBER");
        columnMap.put("nationality", "NATIONALITY");
        columnMap.put("cnname", "CNNAME");
        columnMap.put("enname", "ENNAME");
        columnMap.put("sex", "SEX");
        columnMap.put("maritalStatus", "MARITAL_STATUS");
        columnMap.put("namepy", "NAMEPY");
        columnMap.put("nation", "NATION");
        columnMap.put("politicalStatus", "POLITICAL_STATUS");
        columnMap.put("nativePlace", "NATIVE_PLACE");
        columnMap.put("residenceProperty", "RESIDENCE_PROPERTY");
        columnMap.put("residence", "RESIDENCE");
        columnMap.put("certificateType", "CERTIFICATE_TYPE");
        columnMap.put("certificateNum", "CERTIFICATE_NUM");
        columnMap.put("birthdate", "BIRTHDATE");
        columnMap.put("highestEducation", "HIGHEST_EDUCATION");
        columnMap.put("phonenumber", "PHONENUMBER");
        columnMap.put("email", "EMAIL");
        columnMap.put("address", "ADDRESS");
        columnMap.put("postcodes", "POSTCODES");
        columnMap.put("startworkingdate", "STARTWORKINGDATE");
        columnMap.put("positionName", "POSITION_NAME");
        columnMap.put("arriveDate", "ARRIVE_DATE");
        columnMap.put("expectedSalaryMonth", "EXPECTED_SALARY_MONTH");
        columnMap.put("expectedSalaryYear", "EXPECTED_SALARY_YEAR");
        columnMap.put("expectedSalaryOther", "EXPECTED_SALARY_OTHER");
        columnMap.put("recruitmentApproach", "RECRUITMENT_APPROACH");
        columnMap.put("refereeName", "REFEREE_NAME");
        columnMap.put("otherWay", "OTHER_WAY");
        columnMap.put("relativesFlag", "RELATIVES_FLAG");
        columnMap.put("relativesName", "RELATIVES_NAME");
        columnMap.put("relativesShip", "RELATIVES_SHIP");
        columnMap.put("interviewStatus", "INTERVIEW_STATUS");
        columnMap.put("createtime", "CREATETIME");
        columnMap.put("recruiterName", "RECRUITER_NAME");
        columnMap.put("updateTime", "UPDATE_TIME");
        columnMap.put("editPerson", "EDIT_PERSON");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}