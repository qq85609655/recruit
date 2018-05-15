package com.csot.recruit.service.resume;

import com.csot.recruit.model.resume.LanguageSkill;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface LanguageSkillService {
    MiniRtn2Grid<LanguageSkill> getGrid(MiniGridPageSort pageSort, String searchKey);

    LanguageSkill getByPrimaryKey(String primaryKey);

    void create(LanguageSkill resumeLanguage);

    void updateSelective(LanguageSkill resumeLanguage);

    void remove(String primaryKey);
}