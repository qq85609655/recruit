package com.csot.recruit.dao.template;

import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.template.TemplateCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface TemplateMapper extends MyBatisBaseMapper {
    int countByExample(TemplateCriteria example);

    int deleteByExample(TemplateCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Template record);

    int insertSelective(Template record);

    List<Template> selectByExample(TemplateCriteria example);

    Template selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Template record, @Param("example") TemplateCriteria example);

    int updateByExample(@Param("record") Template record, @Param("example") TemplateCriteria example);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);
    
    List<Template> getTempleteByType(String type);
}