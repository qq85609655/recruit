package com.csot.recruit.service.impl.resume;

import java.util.List;
import java.util.Map;

import com.csot.recruit.dao.resume.CategoryMapper;
import com.csot.recruit.model.resume.Category;
import com.csot.recruit.model.resume.CategoryColumns;
import com.csot.recruit.model.resume.CategoryCriteria;
import com.csot.recruit.model.resume.Label;
import com.csot.recruit.model.vo.InterviewBookCandidateVo;
import com.csot.recruit.model.vo.InterviewBookListVo;
import com.csot.recruit.service.resume.CategoryService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public MiniRtn2Grid<Category> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Category> grid = new MiniRtn2Grid<Category>();
        CategoryCriteria criteria = new CategoryCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = CategoryColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(categoryMapper.selectByExample(criteria));
        grid.setTotal(categoryMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Category getByPrimaryKey(String primaryKey) {
        return categoryMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void updateSelective(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void remove(String primaryKey) {
        categoryMapper.deleteByPrimaryKey(primaryKey);
    }

	@Override
	public List<Category> getCategoryList() {
		CategoryCriteria example = new CategoryCriteria();
		example.setOrderByClause("cast(ID as int)");
		return categoryMapper.selectByExample(example);
	}

	@Override
	public int getCategoryCount(Category category) {
		return categoryMapper.countCategory(category);
	}

  @Override
  public List<Category> queryAll() {
    return categoryMapper.selectAllLabel();
  }

  @Override
  public MiniRtn2Grid<Label> getLabelDatagrid(
      Map<String, Object> searchMap) {
    MiniRtn2Grid<Label> miniGrid = new MiniRtn2Grid<Label>();
    List<Label> list = categoryMapper.selectAllLabelByMap(searchMap);
    miniGrid.setData(list);
    miniGrid.setTotal(categoryMapper.countAllLabelByMap(searchMap));
    return miniGrid;
  }
}