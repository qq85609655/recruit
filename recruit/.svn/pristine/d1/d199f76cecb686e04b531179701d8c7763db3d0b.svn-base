package com.csot.recruit.service.interview;

import java.util.List;

import com.csot.recruit.model.original.interview.Language;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface LanguageService {
    MiniRtn2Grid<Language> getGrid(MiniGridPageSort pageSort, String searchKey);

    Language getByPrimaryKey(String primaryKey);

    void create(Language language);

    void updateSelective(Language language);

    void remove(String primaryKey);

    List<Language> queryByPersonCode(String personCode);
}