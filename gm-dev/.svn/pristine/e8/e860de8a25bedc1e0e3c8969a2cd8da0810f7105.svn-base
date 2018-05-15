package com.csot.gm.materialManage.service.impl.gmPartDescRule;

import com.csot.gm.materialManage.dao.original.gmPartDescRule.GmPartDescRuleMapper;
import com.csot.gm.materialManage.model.original.gmPartDescRule.GmPartDescRule;
import com.csot.gm.materialManage.model.original.gmPartDescRule.GmPartDescRuleColumns;
import com.csot.gm.materialManage.model.original.gmPartDescRule.GmPartDescRuleCriteria;
import com.csot.gm.materialManage.service.gmPartDescRule.GmPartDescRuleService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("gmPartDescRuleService")
public class GmPartDescRuleServiceImpl implements GmPartDescRuleService {

  @Resource
  private GmPartDescRuleMapper gmPartDescRuleMapper;

  @Override
  public MiniRtn2Grid<GmPartDescRule> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<GmPartDescRule> grid = new MiniRtn2Grid<GmPartDescRule>();
    GmPartDescRuleCriteria criteria = new GmPartDescRuleCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = GmPartDescRuleColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(gmPartDescRuleMapper.selectByExample(criteria));
    grid.setTotal(gmPartDescRuleMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public GmPartDescRule getByPrimaryKey(String primaryKey) {
    return gmPartDescRuleMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(GmPartDescRule gmPartDescRule) {
    gmPartDescRule.setId(UUID.randomUUID().toString().replace("-", ""));
    gmPartDescRuleMapper.insert(gmPartDescRule);
  }

  @Override
  public void updateSelective(GmPartDescRule gmPartDescRule) {
    gmPartDescRuleMapper.updateByPrimaryKeySelective(gmPartDescRule);
  }

  @Override
  public void remove(String primaryKey) {
    gmPartDescRuleMapper.deleteByPrimaryKey(primaryKey);
  }
}
