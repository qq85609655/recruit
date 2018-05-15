package com.csot.gm.materialManage.service.impl.gmPartDescRuleMap;

import com.csot.gm.materialManage.dao.original.gmPartDescRuleMap.GmPartDescRuleMapMapper;
import com.csot.gm.materialManage.model.original.gmPartDescRuleMap.GmPartDescRuleMap;
import com.csot.gm.materialManage.model.original.gmPartDescRuleMap.GmPartDescRuleMapColumns;
import com.csot.gm.materialManage.model.original.gmPartDescRuleMap.GmPartDescRuleMapCriteria;
import com.csot.gm.materialManage.service.gmPartDescRuleMap.GmPartDescRuleMapService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("gmPartDescRuleMapService")
public class GmPartDescRuleMapServiceImpl implements GmPartDescRuleMapService {

  @Resource
  private GmPartDescRuleMapMapper gmPartDescRuleMapMapper;

  @Override
  public MiniRtn2Grid<GmPartDescRuleMap> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<GmPartDescRuleMap> grid = new MiniRtn2Grid<GmPartDescRuleMap>();
    GmPartDescRuleMapCriteria criteria = new GmPartDescRuleMapCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = GmPartDescRuleMapColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(gmPartDescRuleMapMapper.selectByExample(criteria));
    grid.setTotal(gmPartDescRuleMapMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public GmPartDescRuleMap getByPrimaryKey(String primaryKey) {
    return gmPartDescRuleMapMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(GmPartDescRuleMap gmPartDescRuleMap) {
    gmPartDescRuleMap.setId(UUID.randomUUID().toString().replace("-", ""));
    gmPartDescRuleMapMapper.insert(gmPartDescRuleMap);
  }

  @Override
  public void updateSelective(GmPartDescRuleMap gmPartDescRuleMap) {
    gmPartDescRuleMapMapper.updateByPrimaryKeySelective(gmPartDescRuleMap);
  }

  @Override
  public void remove(String primaryKey) {
    gmPartDescRuleMapMapper.deleteByPrimaryKey(primaryKey);
  }
}
