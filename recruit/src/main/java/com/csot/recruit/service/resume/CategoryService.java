package com.csot.recruit.service.resume;

import java.util.List;
import java.util.Map;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

import com.csot.recruit.model.resume.Category;
import com.csot.recruit.model.resume.Label;

public interface CategoryService {
    MiniRtn2Grid<Category> getGrid(MiniGridPageSort pageSort, String searchKey);

    Category getByPrimaryKey(String primaryKey);

    void create(Category category);

    void updateSelective(Category category);

    void remove(String primaryKey);
    
    /***
     * 查询分类列表
     * @return
     */
    List<Category> getCategoryList();
    
    /***
     * 根据条件查找该分类是否存在
     * @param category
     * @return
     */
    int getCategoryCount(Category category);
    
    /**
     * 查询标签类以及下面的标签
     * @return
     */
    List<Category> queryAll();

    MiniRtn2Grid<Label> getLabelDatagrid(Map<String, Object> searchMap);
}