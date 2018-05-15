package com.csot.recruit.service.resumelibrary.source;

import com.csot.recruit.model.original.resumelibrary.source.ResumeSource;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;

import java.util.List;

public interface ResumeSourceService {
    List<ResumeSource> getGrid(MiniGridPageSort pageSort, String sourceName);

    ResumeSource getByPrimaryKey(String primaryKey);

    void create(ResumeSource resumeSource);

    void updateSelective(ResumeSource resumeSource);

    void remove(String primaryKey);
}
