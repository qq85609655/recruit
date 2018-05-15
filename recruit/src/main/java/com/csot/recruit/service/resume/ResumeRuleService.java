package com.csot.recruit.service.resume;

import java.util.List;

import com.csot.recruit.model.resume.resumeRule.ResumeRule;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface ResumeRuleService {
    MiniRtn2Grid<ResumeRule> getGrid(MiniGridPageSort pageSort, String searchKey);

    List<ResumeRule> selectAll();
    
    List<ResumeRule> selectContainField(String fieldId);
    
    ResumeRule getByPrimaryKey(String primaryKey);

    void create(ResumeRule resumeRule);

    void updateSelective(ResumeRule resumeRule);

    void remove(String primaryKey);
    
}