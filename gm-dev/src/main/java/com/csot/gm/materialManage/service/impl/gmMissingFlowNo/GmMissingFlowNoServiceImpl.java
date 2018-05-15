package com.csot.gm.materialManage.service.impl.gmMissingFlowNo;

import com.csot.gm.materialManage.dao.original.gmMissingFlowNo.GmMissingFlowNoMapper;
import com.csot.gm.materialManage.model.original.gmMissingFlowNo.GmMissingFlowNo;
import com.csot.gm.materialManage.model.original.gmMissingFlowNo.GmMissingFlowNoColumns;
import com.csot.gm.materialManage.model.original.gmMissingFlowNo.GmMissingFlowNoCriteria;
import com.csot.gm.materialManage.service.gmMissingFlowNo.GmMissingFlowNoService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("gmMissingFlowNoService")
public class GmMissingFlowNoServiceImpl implements GmMissingFlowNoService {

  @Resource
  private GmMissingFlowNoMapper gmMissingFlowNoMapper;

  @Override
  public MiniRtn2Grid<GmMissingFlowNo> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<GmMissingFlowNo> grid = new MiniRtn2Grid<GmMissingFlowNo>();
    GmMissingFlowNoCriteria criteria = new GmMissingFlowNoCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = GmMissingFlowNoColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(gmMissingFlowNoMapper.selectByExample(criteria));
    grid.setTotal(gmMissingFlowNoMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public GmMissingFlowNo getByPrimaryKey(String primaryKey) {
    return gmMissingFlowNoMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(GmMissingFlowNo gmMissingFlowNo) {
    gmMissingFlowNo.setId(UUID.randomUUID().toString().replace("-", ""));
    gmMissingFlowNoMapper.insert(gmMissingFlowNo);
  }

  @Override
  public void updateSelective(GmMissingFlowNo gmMissingFlowNo) {
    gmMissingFlowNoMapper.updateByPrimaryKeySelective(gmMissingFlowNo);
  }

  @Override
  public void remove(String primaryKey) {
    gmMissingFlowNoMapper.deleteByPrimaryKey(primaryKey);
  }
}
