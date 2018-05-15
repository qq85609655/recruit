package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.File;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.ResumeCLabel;
import com.csot.recruit.model.resume.ResumeCriteria;
import com.csot.recruit.model.vo.ResumeApartVo;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper extends MyBatisBaseMapper {
    int countByExample(ResumeCriteria example);

    int deleteByExample(ResumeCriteria example);

    int deleteByPrimaryKey(String id);
    
    int deleteByResumeId(String resumeId);

    int insert(Resume record);

    int insertSelective(Resume record);

    List<Resume> selectByExample(ResumeCriteria example);

    Resume selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Resume record, @Param("example") ResumeCriteria example);

    int updateByExample(@Param("record") Resume record, @Param("example") ResumeCriteria example);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);

    /**
     * 更新简历的标签
     * @param resumeId
     * @param resumeTags
     * @return
     */
    int updateResumeLabel(@Param("resumeId") String resumeId, @Param("resumeTags") String resumeTags);
    
    /**
     * 删除简历和标签关联表的一条记录
     * @param resumeId
     * @param tagId
     * @return
     */
    int removeResumeLabel(@Param("resumeId") String resumeId, @Param("tagId") String tagId);
    
    /**
     * 批量删除简历和标签关联表的记录
     * @param resumeId
     * @param tagIds
     * @return
     */
    int removeResumeLabels(@Param("resumeId") String resumeId, @Param("tagIds") List<String> listDele);
    
    /**
     * 批量添加简历和标签关联表的记录
     * @param tagIds
     * @return
     */
    int addResumeLabels(@Param("tags") List<ResumeCLabel> tags);

    /**
     * 获取简历的文件保存目录
     * @param resumeId
     * @return
     */
    String getResumeDir(@Param("resumeId") String resumeId);
    
    /**根据候选人id查询简历列表*/
    List<ResumeApartVo> selectByCandidateId(String candidateId);

}