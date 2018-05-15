package com.csot.gm.materialManage.service.impl.partClass;

import com.csot.gm.materialManage.dao.original.partClass.PartClassMapper;
import com.csot.gm.materialManage.model.original.partClass.PartClass;
import com.csot.gm.materialManage.model.original.partClass.PartClassColumns;
import com.csot.gm.materialManage.model.original.partClass.PartClassCriteria;
import com.csot.gm.materialManage.service.partClass.PartClassService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("partClassService")
public class PartClassServiceImpl implements PartClassService {

  @Resource
  private PartClassMapper partClassMapper;

  @Override
  public MiniRtn2Grid<PartClass> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<PartClass> grid = new MiniRtn2Grid<PartClass>();
    PartClassCriteria criteria = new PartClassCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartClassColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partClassMapper.selectByExample(criteria));
    grid.setTotal(partClassMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PartClass getByPrimaryKey(String primaryKey) {
    return partClassMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PartClass partClass) {
    partClass.setId(UUID.randomUUID().toString().replace("-", ""));
    partClass.setParentId(UUID.randomUUID().toString().replace("-", ""));
    partClassMapper.insert(partClass);
  }

  @Override
  public void updateSelective(PartClass partClass) {
    partClassMapper.updateByPrimaryKeySelective(partClass);
  }

  @Override
  public void remove(String primaryKey) {
    partClassMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 新增Level2
   */
  @Override
  public void createLevel2(PartClass partClass) {
    
    partClass.setId(UUID.randomUUID().toString().replace("-", ""));    
    partClassMapper.insert(partClass);
  }
}
