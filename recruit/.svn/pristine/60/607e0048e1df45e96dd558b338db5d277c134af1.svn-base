package com.csot.recruit.service.resume;

import com.csot.recruit.model.original.resume.LabelRalation;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface LabelRalationService {
    MiniRtn2Grid<LabelRalation> getGrid(MiniGridPageSort pageSort, String searchKey);

    LabelRalation getByPrimaryKey(String primaryKey);

    void create(LabelRalation labelRalation);

    void updateSelective(LabelRalation labelRalation);

    void remove(String primaryKey);

    LabelRalation getByReservseId(String candidateId);

    void updateTags(String candidateId, String labels,String deletes,String adds);
    
    void addTags(String candidateId, String labels,String deletes,String adds);

    void addCandidateTagsBycid(String resumeId, String labels, String deletes, String adds);
}