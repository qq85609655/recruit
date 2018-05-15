package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageExtColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("personCode", "PERSON_CODE");
        columnMap.put("officeFlag", "OFFICE_FLAG");
        columnMap.put("officeSkilledLevel", "OFFICE_SKILLED_LEVEL");
        columnMap.put("officeDiploma", "OFFICE_DIPLOMA");
        columnMap.put("englishFlag", "ENGLISH_FLAG");
        columnMap.put("englishSkilledLevel", "ENGLISH_SKILLED_LEVEL");
        columnMap.put("englishDiploma", "ENGLISH_DIPLOMA");
        columnMap.put("sapFlag", "SAP_FLAG");
        columnMap.put("sapSkilledLevel", "SAP_SKILLED_LEVEL");
        columnMap.put("sapDiploma", "SAP_DIPLOMA");
        columnMap.put("koreanFlag", "KOREAN_FLAG");
        columnMap.put("koreanSkilledLevel", "KOREAN_SKILLED_LEVEL");
        columnMap.put("koreanDiploma", "KOREAN_DIPLOMA");
        columnMap.put("vbaFlag", "VBA_FLAG");
        columnMap.put("vbaSkilledLevel", "VBA_SKILLED_LEVEL");
        columnMap.put("vbaDiploma", "VBA_DIPLOMA");
        columnMap.put("japaneseFlag", "JAPANESE_FLAG");
        columnMap.put("japaneseSkilledLevel", "JAPANESE_SKILLED_LEVEL");
        columnMap.put("japaneseDiploma", "JAPANESE_DIPLOMA");
        columnMap.put("otheritFlag", "OTHERIT_FLAG");
        columnMap.put("otheritSkilledLevel", "OTHERIT_SKILLED_LEVEL");
        columnMap.put("otheritDiploma", "OTHERIT_DIPLOMA");
        columnMap.put("otherFlag", "OTHER_FLAG");
        columnMap.put("otherSkilledLevel", "OTHER_SKILLED_LEVEL");
        columnMap.put("otherDiploma", "OTHER_DIPLOMA");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}