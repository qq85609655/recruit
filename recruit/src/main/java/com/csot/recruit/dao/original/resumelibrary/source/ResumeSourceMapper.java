package com.csot.recruit.dao.original.resumelibrary.source;

import com.csot.recruit.model.original.resumelibrary.source.ResumeSource;
import com.csot.recruit.model.original.resumelibrary.source.ResumeSourceCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ResumeSourceMapper extends MyBatisBaseMapper {
    int countByExample(ResumeSourceCriteria example);

    int deleteByExample(ResumeSourceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(ResumeSource record);

    int insertSelective(ResumeSource record);

    List<ResumeSource> selectByExample(ResumeSourceCriteria example);

    ResumeSource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResumeSource record, @Param("example") ResumeSourceCriteria example);

    int updateByExample(@Param("record") ResumeSource record, @Param("example") ResumeSourceCriteria example);

    int updateByPrimaryKeySelective(ResumeSource record);

    int updateByPrimaryKey(ResumeSource record);
}