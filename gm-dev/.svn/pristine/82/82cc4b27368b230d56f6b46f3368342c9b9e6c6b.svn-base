package com.csot.gm.materialManage.service.impl.propertyRtn;

import com.csot.gm.materialManage.dao.extension.propertyRtn.PropertyRtnExtMapper;
import com.csot.gm.materialManage.dao.original.propertyRtn.PropertyRtnMapper;
import com.csot.gm.materialManage.model.original.propertyRtn.PropertyRtn;
import com.csot.gm.materialManage.model.original.propertyRtn.PropertyRtnColumns;
import com.csot.gm.materialManage.model.original.propertyRtn.PropertyRtnCriteria;
import com.csot.gm.materialManage.service.propertyRtn.PropertyRtnService;

import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("propertyRtnService")
public class PropertyRtnServiceImpl implements PropertyRtnService {

  @Resource
  private PropertyRtnMapper propertyRtnMapper;
  @Resource
  private PropertyRtnExtMapper propertyRtnExtMapper;

  @Override
  public MiniRtn2Grid<PropertyRtn> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<PropertyRtn> grid = new MiniRtn2Grid<PropertyRtn>();
    PropertyRtnCriteria criteria = new PropertyRtnCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PropertyRtnColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(propertyRtnMapper.selectByExample(criteria));
    grid.setTotal(propertyRtnMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PropertyRtn getByPrimaryKey(String primaryKey) {
    return propertyRtnMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PropertyRtn propertyRtn) {
    propertyRtn.setId(UUID.randomUUID().toString().replace("-", ""));
    propertyRtnMapper.insert(propertyRtn);
  }

  @Override
  public void updateSelective(PropertyRtn propertyRtn) {
    propertyRtnMapper.updateByPrimaryKeySelective(propertyRtn);
  }

  @Override
  public void remove(String primaryKey) {
    propertyRtnMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public void removeAll() {
    propertyRtnExtMapper.deleteAll();   
  }
}
