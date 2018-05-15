package com.csot.gm.materialManage.service.impl.gmPartNoRuleMap;

import com.csot.gm.materialManage.dao.original.gmPartNoRuleMap.GmPartNoRuleMapMapper;
import com.csot.gm.materialManage.model.original.gmPartNoRuleMap.GmPartNoRuleMap;
import com.csot.gm.materialManage.model.original.gmPartNoRuleMap.GmPartNoRuleMapColumns;
import com.csot.gm.materialManage.model.original.gmPartNoRuleMap.GmPartNoRuleMapCriteria;
import com.csot.gm.materialManage.service.gmPartNoRuleMap.GmPartNoRuleMapService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("gmPartNoRuleMapService")
public class GmPartNoRuleMapServiceImpl implements GmPartNoRuleMapService {

  @Resource
  private GmPartNoRuleMapMapper gmPartNoRuleMapMapper;

  @Override
  public MiniRtn2Grid<GmPartNoRuleMap> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<GmPartNoRuleMap> grid = new MiniRtn2Grid<GmPartNoRuleMap>();
    GmPartNoRuleMapCriteria criteria = new GmPartNoRuleMapCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = GmPartNoRuleMapColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(gmPartNoRuleMapMapper.selectByExample(criteria));
    grid.setTotal(gmPartNoRuleMapMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public GmPartNoRuleMap getByPrimaryKey(String primaryKey) {
    return gmPartNoRuleMapMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(GmPartNoRuleMap gmPartNoRuleMap) {
    gmPartNoRuleMap.setId(UUID.randomUUID().toString().replace("-", ""));
    gmPartNoRuleMapMapper.insert(gmPartNoRuleMap);
  }

  @Override
  public void updateSelective(GmPartNoRuleMap gmPartNoRuleMap) {
    gmPartNoRuleMapMapper.updateByPrimaryKeySelective(gmPartNoRuleMap);
  }

  @Override
  public void remove(String primaryKey) {
    gmPartNoRuleMapMapper.deleteByPrimaryKey(primaryKey);
  }
}
