package com.csot.gm.materialManage.service.impl.gmPartNoPrecode;

import com.csot.gm.materialManage.dao.original.gmPartNoPrecode.GmPartNoPrecodeMapper;
import com.csot.gm.materialManage.model.original.gmPartNoPrecode.GmPartNoPrecode;
import com.csot.gm.materialManage.model.original.gmPartNoPrecode.GmPartNoPrecodeColumns;
import com.csot.gm.materialManage.model.original.gmPartNoPrecode.GmPartNoPrecodeCriteria;
import com.csot.gm.materialManage.service.gmPartNoPrecode.GmPartNoPrecodeService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("gmPartNoPrecodeService")
public class GmPartNoPrecodeServiceImpl implements GmPartNoPrecodeService {

  @Resource
  private GmPartNoPrecodeMapper gmPartNoPrecodeMapper;

  @Override
  public MiniRtn2Grid<GmPartNoPrecode> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<GmPartNoPrecode> grid = new MiniRtn2Grid<GmPartNoPrecode>();
    GmPartNoPrecodeCriteria criteria = new GmPartNoPrecodeCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = GmPartNoPrecodeColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(gmPartNoPrecodeMapper.selectByExample(criteria));
    grid.setTotal(gmPartNoPrecodeMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public GmPartNoPrecode getByPrimaryKey(String primaryKey) {
    return gmPartNoPrecodeMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(GmPartNoPrecode gmPartNoPrecode) {
    gmPartNoPrecode.setId(UUID.randomUUID().toString().replace("-", ""));
    gmPartNoPrecodeMapper.insert(gmPartNoPrecode);
  }

  @Override
  public void updateSelective(GmPartNoPrecode gmPartNoPrecode) {
    gmPartNoPrecodeMapper.updateByPrimaryKeySelective(gmPartNoPrecode);
  }

  @Override
  public void remove(String primaryKey) {
    gmPartNoPrecodeMapper.deleteByPrimaryKey(primaryKey);
  }
}
