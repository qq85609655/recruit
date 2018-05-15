package com.csot.recruit.service.impl.flow.employ;

import java.util.List;
import java.util.Map;

import com.csot.recruit.dao.original.flow.employ.EmployBlacklistMapper;
import com.csot.recruit.model.original.flow.employ.EmployBlacklist;
import com.csot.recruit.model.original.flow.employ.EmployBlacklistColumns;
import com.csot.recruit.model.original.flow.employ.EmployBlacklistCriteria;
import com.csot.recruit.service.flow.employ.EmployBlacklistService;

import javax.annotation.Resource;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("employBlacklistService")
public class EmployBlacklistServiceImpl implements EmployBlacklistService {
  private static final Logger logger = LoggerFactory.getLogger(EmployBlacklistServiceImpl.class);

  @Resource
  private EmployBlacklistMapper employBlacklistMapper;

  @Override
  public MiniRtn2Grid<EmployBlacklist> getGrid(MiniGridPageSort pageSort, Map<String, String> col) {
    MiniRtn2Grid<EmployBlacklist> grid = new MiniRtn2Grid<EmployBlacklist>();
    EmployBlacklistCriteria criteria = new EmployBlacklistCriteria();
    // 查询条件
    if (StringUtils.hasText(col.get("candidateName"))) {
      criteria.createCriteria().andCandidateNameLike("%"+col.get("candidateName")+"%");
    }
    if (StringUtils.hasText(col.get("state"))) {
      criteria.createCriteria().andStateEqualTo(col.get("state"));
    }
    if (StringUtils.hasText(col.get("inReason"))) {
      criteria.createCriteria().andInReasonLike("%"+col.get("inReason")+"%");
    }
    if (StringUtils.hasText(col.get("outReason"))) {
      criteria.createCriteria().andOutReasonLike("%"+col.get("outReason")+"%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = EmployBlacklistColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(employBlacklistMapper.selectByExample(criteria));
    grid.setTotal(employBlacklistMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public EmployBlacklist getByPrimaryKey(String primaryKey) {
    return employBlacklistMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public AjaxRtnJson create(EmployBlacklist employBlacklist) {
    EmployBlacklistCriteria example = new EmployBlacklistCriteria();
    example.createCriteria().andCandidateIdEqualTo(employBlacklist.getCandidateId()).andStateEqualTo(EmployBlacklist.state.YES.valueStr());
    List<EmployBlacklist> employBlacklists = employBlacklistMapper.selectByExample(example);
    if (employBlacklists != null && employBlacklists.size() > 0) {
      return new AjaxRtnJson(false, "候选人" + employBlacklist.getCandidateName() + "已经列入黑名单！");
    }
    EmployBlacklistCriteria example2 = new EmployBlacklistCriteria();
    example2.createCriteria().andCandidateIdEqualTo(employBlacklist.getCandidateId()).andStateEqualTo(EmployBlacklist.state.NO.valueStr());
    List<EmployBlacklist> employBlacklists2 = employBlacklistMapper.selectByExample(example2);
    if (employBlacklists2 != null && employBlacklists2.size() > 0) {
      employBlacklist=employBlacklists2.get(0);
      employBlacklist.setState(EmployBlacklist.state.YES.valueStr());
      employBlacklistMapper.updateByPrimaryKeySelective(employBlacklist);
    }else{
      employBlacklistMapper.insert(employBlacklist);
    }
    return new AjaxRtnJson(true, "成功将候选人" + employBlacklist.getCandidateName() + "列入黑名单！");
  }

  @Override
  public void updateSelective(EmployBlacklist employBlacklist) {
    employBlacklistMapper.updateByPrimaryKeySelective(employBlacklist);
  }

  @Override
  public void remove(String primaryKey) {
    employBlacklistMapper.deleteByPrimaryKey(primaryKey);
  }
}
