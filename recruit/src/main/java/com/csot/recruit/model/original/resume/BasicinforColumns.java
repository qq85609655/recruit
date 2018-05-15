package com.csot.recruit.model.original.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicinforColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("name", "NAME");
        columnMap.put("nameEn", "NAME_EN");
        columnMap.put("sex", "SEX");
        columnMap.put("birthday", "BIRTHDAY");
        columnMap.put("maritalStatus", "MARITAL_STATUS");
        columnMap.put("addressRegistered", "ADDRESS_REGISTERED");
        columnMap.put("workExperience", "WORK_EXPERIENCE");
        columnMap.put("voucherType", "VOUCHER_TYPE");
        columnMap.put("voucherNumber", "VOUCHER_NUMBER");
        columnMap.put("phone", "PHONE");
        columnMap.put("phoneReserve", "PHONE_RESERVE");
        columnMap.put("applyStatus", "APPLY_STATUS");
        columnMap.put("email", "EMAIL");
        columnMap.put("residence", "RESIDENCE");
        columnMap.put("postcode", "POSTCODE");
        columnMap.put("address", "ADDRESS");
        columnMap.put("addressEn", "ADDRESS_EN");
        columnMap.put("selfAssessment", "SELF_ASSESSMENT");
        columnMap.put("selfAssessmentEn", "SELF_ASSESSMENT_EN");
        columnMap.put("age", "AGE");
        columnMap.put("highestEducation", "HIGHEST_EDUCATION");
        columnMap.put("nation", "NATION");
        columnMap.put("idNumber", "ID_NUMBER");
        columnMap.put("idAddress", "ID_ADDRESS");
        columnMap.put("reportTime", "REPORT_TIME");
        columnMap.put("workplaceExpect", "WORKPLACE_EXPECT");
        columnMap.put("postExpect", "POST_EXPECT");
        columnMap.put("industryExpect", "INDUSTRY_EXPECT");
        columnMap.put("jobtypeExpect", "JOBTYPE_EXPECT");
        columnMap.put("salaryExpect", "SALARY_EXPECT");
        columnMap.put("currency", "CURRENCY");
        columnMap.put("headPortrait", "HEAD_PORTRAIT");
        columnMap.put("trainInfor", "TRAIN_INFOR");
        columnMap.put("skillInfor", "SKILL_INFOR");
        columnMap.put("languageInfor", "LANGUAGE_INFOR");
        columnMap.put("certificateInfor", "CERTIFICATE_INFOR");
        columnMap.put("awardInfor", "AWARD_INFOR");
        columnMap.put("hobbyInfor", "HOBBY_INFOR");
        columnMap.put("selectionStatus", "SELECTION_STATUS");
        columnMap.put("label", "LABEL");
        columnMap.put("currentIndustry", "CURRENT_INDUSTRY");
        columnMap.put("updateDate", "UPDATE_DATE");
        columnMap.put("positionid", "POSITIONID");
        columnMap.put("currentCompany", "CURRENT_COMPANY");
        columnMap.put("resumeorigin", "RESUMEORIGIN");
        columnMap.put("channel", "CHANNEL");
        columnMap.put("currentPosition", "CURRENT_POSITION");
        columnMap.put("graduationSchool", "GRADUATION_SCHOOL");
        columnMap.put("professional", "PROFESSIONAL");
        columnMap.put("resumeLanguage", "RESUME_LANGUAGE");
        columnMap.put("recommendEmail", "RECOMMEND_EMAIL");
        columnMap.put("recommend", "RECOMMEND");
        columnMap.put("salaryCurrent", "SALARY_CURRENT");
        columnMap.put("resumeDir", "RESUME_DIR");
        columnMap.put("selfEvaluation", "SELF_EVALUATION");
        columnMap.put("careerObject", "CAREER_OBJECT");
        columnMap.put("experienceDetail", "EXPERIENCE_DETAIL");
        columnMap.put("projectExperience", "PROJECT_EXPERIENCE");
        columnMap.put("languageSkill", "LANGUAGE_SKILL");
        columnMap.put("skillText", "SKILL_TEXT");
        columnMap.put("resumeStatus", "RESUME_STATUS");
        columnMap.put("provideHouse", "PROVIDE_HOUSE");
        columnMap.put("storageDate", "STORAGE_DATE");
        columnMap.put("nationality", "NATIONALITY");
        columnMap.put("candidateId", "CANDIDATE_ID");
        columnMap.put("cleanStatus", "CLEAN_STATUS");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}