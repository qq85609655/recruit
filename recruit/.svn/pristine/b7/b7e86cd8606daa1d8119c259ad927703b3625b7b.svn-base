package com.csot.recruit.dao.original.template;

import com.csot.recruit.model.original.template.TemplateType;
import com.csot.recruit.model.original.template.TemplateTypeCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface TemplateTypeMapper extends MyBatisBaseMapper {
    int countByExample(TemplateTypeCriteria example);

    int deleteByExample(TemplateTypeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TemplateType record);

    int insertSelective(TemplateType record);

    List<TemplateType> selectByExample(TemplateTypeCriteria example);

    TemplateType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TemplateType record, @Param("example") TemplateTypeCriteria example);

    int updateByExample(@Param("record") TemplateType record, @Param("example") TemplateTypeCriteria example);

    int updateByPrimaryKeySelective(TemplateType record);

    int updateByPrimaryKey(TemplateType record);
}