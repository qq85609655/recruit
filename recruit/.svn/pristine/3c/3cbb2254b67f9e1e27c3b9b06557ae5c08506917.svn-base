package com.csot.recruit.dao.original.attachment;

import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.attachment.AttachmentCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AttachmentMapper extends MyBatisBaseMapper {
    int countByExample(AttachmentCriteria example);

    int deleteByExample(AttachmentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    List<Attachment> selectByExample(AttachmentCriteria example);

    Attachment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    int updateByExample(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
}