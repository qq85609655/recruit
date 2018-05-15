package com.csot.recruit.service.resume;

import java.util.List;

import com.csot.recruit.model.resume.EducationExperience;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EducationExperienceService {
    MiniRtn2Grid<EducationExperience> getGrid(MiniGridPageSort pageSort, String searchKey);

    EducationExperience getByPrimaryKey(String primaryKey);

    void create(EducationExperience educationExperience);

    void updateSelective(EducationExperience educationExperience);

    void remove(String primaryKey);

    List<EducationExperience> queryByResumeId(String resumeId);

    void deleteByResumeId(String resumeId);

}