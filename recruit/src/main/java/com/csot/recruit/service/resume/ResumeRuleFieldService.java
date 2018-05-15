package com.csot.recruit.service.resume;

import com.csot.recruit.model.resume.resumeRule.ResumeRuleField;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface ResumeRuleFieldService {
    MiniRtn2Grid<ResumeRuleField> getGrid(MiniGridPageSort pageSort, String searchKey);

    ResumeRuleField getByPrimaryKey(String primaryKey);

    void create(ResumeRuleField resumeRuleField);

    void updateSelective(ResumeRuleField resumeRuleField);

    void remove(String primaryKey);
    
    /**
     * 判重字段是否已被使用
     * @param primaryKey 主键
     * @return 是/否
     */
    boolean isWork(String primaryKey);
}