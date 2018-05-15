package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.Category;
import com.csot.recruit.model.resume.CategoryCriteria;
import com.csot.recruit.model.resume.Label;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper extends MyBatisBaseMapper {
    int countByExample(CategoryCriteria example);

    int deleteByExample(CategoryCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryCriteria example);

    Category selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryCriteria example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryCriteria example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    /***
     * 根据条件查询该分类是否存在
     * @param category
     * @return
     */
    int countCategory(Category category);

    /**
     * 查询所有标签类和标签
     * @return
     */
    List<Category> selectAllLabel();

    List<Label> selectAllLabelByMap(Map<String, Object> searchMap);

    int countAllLabelByMap(Map<String, Object> searchMap);

}