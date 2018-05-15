package com.csot.gm.materialManage.service.impl.partNoRule;

import com.csot.gm.materialManage.dao.original.partNoRule.PartNoRuleMapper;
import com.csot.gm.materialManage.model.original.partNoRule.PartNoRule;
import com.csot.gm.materialManage.model.original.partNoRule.PartNoRuleColumns;
import com.csot.gm.materialManage.model.original.partNoRule.PartNoRuleCriteria;
import com.csot.gm.materialManage.service.partNoRule.PartNoRuleService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("partNoRuleService")
public class PartNoRuleServiceImpl implements PartNoRuleService {

  @Resource
  private PartNoRuleMapper partNoRuleMapper;

  @Override
  public MiniRtn2Grid<PartNoRule> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<PartNoRule> grid = new MiniRtn2Grid<PartNoRule>();
    PartNoRuleCriteria criteria = new PartNoRuleCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartNoRuleColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partNoRuleMapper.selectByExample(criteria));
    grid.setTotal(partNoRuleMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PartNoRule getByPrimaryKey(String primaryKey) {
    return partNoRuleMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PartNoRule partNoRule) {
    partNoRule.setId(UUID.randomUUID().toString().replace("-", ""));
    partNoRuleMapper.insert(partNoRule);
  }

  @Override
  public void updateSelective(PartNoRule partNoRule) {
    partNoRuleMapper.updateByPrimaryKeySelective(partNoRule);
  }

  @Override
  public void remove(String primaryKey) {
    partNoRuleMapper.deleteByPrimaryKey(primaryKey);
  }
}
