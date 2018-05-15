package com.csot.recruit.service.resume;

import java.util.List;

import com.csot.recruit.model.nresume.Certification;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface CertificationService {
    MiniRtn2Grid<Certification> getGrid(MiniGridPageSort pageSort, String searchKey);

    Certification getByPrimaryKey(String primaryKey);

    void create(Certification certification);

    void updateSelective(Certification certification);

    void remove(String primaryKey);

    com.csot.recruit.model.resume.Certification getByPrimaryKey2(String primaryKey);
    void create(com.csot.recruit.model.resume.Certification credential);
    void updateSelective(com.csot.recruit.model.resume.Certification certification);

    List<com.csot.recruit.model.resume.Certification> queryByResumeId(String resumeId);

    void deleteByResumeId(String resumeId);
}