package com.csot.recruit.dao.resume;

import com.csot.recruit.model.nresume.Certification;
import com.csot.recruit.model.resume.CertificationCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CertificationMapper extends MyBatisBaseMapper {
    int countByExample(CertificationCriteria example);

    int deleteByExample(CertificationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Certification record);

    int insertSelective(Certification record);

    List<Certification> selectByExample(CertificationCriteria example);

    Certification selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Certification record, @Param("example") CertificationCriteria example);

    int updateByExample(@Param("record") Certification record, @Param("example") CertificationCriteria example);

    int updateByPrimaryKeySelective(Certification record);

    int updateByPrimaryKey(Certification record);

    int insert2(com.csot.recruit.model.resume.Certification credential);
    int insertSelective2(com.csot.recruit.model.resume.Certification record);
    
    int updateByPrimaryKeySelective2(com.csot.recruit.model.resume.Certification record);
    int updateByPrimaryKey(com.csot.recruit.model.resume.Certification record);
    com.csot.recruit.model.resume.Certification selectByPrimaryKey2(String primaryKey);

    List<com.csot.recruit.model.resume.Certification> selectByResumeId(String resumeId);
    
    void deleteByResumeId(String resumeId);
    
}