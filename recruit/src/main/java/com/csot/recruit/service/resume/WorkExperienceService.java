package com.csot.recruit.service.resume;

import java.util.List;

import com.csot.recruit.model.resume.WorkExperience;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface WorkExperienceService {
    MiniRtn2Grid<WorkExperience> getGrid(MiniGridPageSort pageSort, String searchKey);

    WorkExperience getByPrimaryKey(String primaryKey);

    void create(WorkExperience workExperience);

    void updateSelective(WorkExperience workExperience);

    void remove(String primaryKey);

    List<WorkExperience> queryByResumeId(String resumeId);

    void deleteByResumeId(String resumeId);

}