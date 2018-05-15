package com.csot.gm.materialManage.service.impl.partType;

import com.csot.gm.materialManage.dao.original.partType.PartTypeMapper;
import com.csot.gm.materialManage.model.original.partType.PartType;
import com.csot.gm.materialManage.model.original.partType.PartTypeColumns;
import com.csot.gm.materialManage.model.original.partType.PartTypeCriteria;
import com.csot.gm.materialManage.service.partType.PartTypeService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("partTypeService")
public class PartTypeServiceImpl implements PartTypeService {

  @Resource
  private PartTypeMapper partTypeMapper;

  @Override
  public MiniRtn2Grid<PartType> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<PartType> grid = new MiniRtn2Grid<PartType>();
    PartTypeCriteria criteria = new PartTypeCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartTypeColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partTypeMapper.selectByExample(criteria));
    grid.setTotal(partTypeMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PartType getByPrimaryKey(String primaryKey) {
    return partTypeMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PartType partType) {
    partType.setId(UUID.randomUUID().toString().replace("-", ""));
    partTypeMapper.insert(partType);
  }

  @Override
  public void updateSelective(PartType partType) {
    partTypeMapper.updateByPrimaryKeySelective(partType);
  }

  @Override
  public void remove(String primaryKey) {
    partTypeMapper.deleteByPrimaryKey(primaryKey);
  }
}
