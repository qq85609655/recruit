package com.csot.recruit.service.impl.template;

import java.util.List;

import com.csot.recruit.dao.original.template.TemplateTypeMapper;
import com.csot.recruit.model.original.template.TemplateType;
import com.csot.recruit.model.original.template.TemplateTypeColumns;
import com.csot.recruit.model.original.template.TemplateTypeCriteria;
import com.csot.recruit.service.template.TemplateTypeService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("templateTypeService")
public class TemplateTypeServiceImpl implements TemplateTypeService {
  private static final Logger logger = LoggerFactory.getLogger(TemplateTypeServiceImpl.class);

  @Resource
  private TemplateTypeMapper templateTypeMapper;

  @Override
  public MiniRtn2Grid<TemplateType> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<TemplateType> grid = new MiniRtn2Grid<TemplateType>();
    TemplateTypeCriteria criteria = new TemplateTypeCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andTypeNameLike("%" + searchKey + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = TemplateTypeColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(templateTypeMapper.selectByExample(criteria));
    grid.setTotal(templateTypeMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public TemplateType getByPrimaryKey(String primaryKey) {
    return templateTypeMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(TemplateType templateType) {
    templateTypeMapper.insert(templateType);
  }

  @Override
  public void updateSelective(TemplateType templateType) {
    templateTypeMapper.updateByPrimaryKeySelective(templateType);
  }

  @Override
  public void remove(String primaryKey) {
    templateTypeMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public List<TemplateType> queryTemplateTpeyList(String type) {
    TemplateTypeCriteria criteria = new TemplateTypeCriteria();
    criteria.or().andTyptEqualTo(type);
    List<TemplateType> list = templateTypeMapper.selectByExample(criteria);
    return list;
  }
}
