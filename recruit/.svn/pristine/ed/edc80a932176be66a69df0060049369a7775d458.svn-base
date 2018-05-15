package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageSkillColumns {
    private static final Map<String, String> columnMap = new HashMap<String, String>();

    static {
        columnMap.put("id", "ID");
        columnMap.put("languageName", "LANGUAGE_NAME");
        columnMap.put("languageLevel", "LANGUAGE_LEVEL");
        columnMap.put("oralLevel", "ORAL_LEVEL");
        columnMap.put("resumeId", "RESUME_ID");
    }

    public static String getColumn(String propertyName) {
        return columnMap.get(propertyName);
    }

    public static List<String> getAllColumns() {
        return new ArrayList<String>(columnMap.values());
    }
}