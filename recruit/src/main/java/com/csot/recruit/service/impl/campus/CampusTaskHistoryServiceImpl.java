package com.csot.recruit.service.impl.campus;

import com.csot.recruit.dao.original.campus.CampusTaskHistoryMapper;
import com.csot.recruit.model.original.campus.CampusTaskHistory;
import com.csot.recruit.model.original.campus.CampusTaskHistoryColumns;
import com.csot.recruit.model.original.campus.CampusTaskHistoryCriteria;
import com.csot.recruit.service.campus.CampusTaskHistoryService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("campusTaskHistoryService")
public class CampusTaskHistoryServiceImpl implements CampusTaskHistoryService {
  private static final Logger logger = LoggerFactory.getLogger(CampusTaskHistoryServiceImpl.class);

  @Resource
  private CampusTaskHistoryMapper campusTaskHistoryMapper;

  @Override
  public MiniRtn2Grid<CampusTaskHistory> getGrid(MiniGridPageSort pageSort, String yearth, String organizationId,
                                                 String siteId, String postId) {
    MiniRtn2Grid<CampusTaskHistory> grid = new MiniRtn2Grid<CampusTaskHistory>();
    CampusTaskHistoryCriteria criteria = new CampusTaskHistoryCriteria();
    CampusTaskHistoryCriteria.Criteria criter = criteria.or();
    // 查询条件
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    if (StringUtils.hasText(organizationId)) {
      criter.andOrganizationEqualTo(organizationId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
//    String sortColumn = CampusTaskHistoryColumns.getColumn(pageSort.getSortField());
//    if (StringUtils.hasText(sortColumn)) {
//      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
//      criteria.setOrderByClause(sortStrBldr.toString());
//    }
    criteria.setOrderByClause("CHANGE_DATE DESC");
    grid.setData(campusTaskHistoryMapper.selectByExample(criteria));
    grid.setTotal(campusTaskHistoryMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public CampusTaskHistory getByPrimaryKey(String primaryKey) {
    return campusTaskHistoryMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(CampusTaskHistory campusTaskHistory) {
    campusTaskHistoryMapper.insert(campusTaskHistory);
  }

  @Override
  public void updateSelective(CampusTaskHistory campusTaskHistory) {
    campusTaskHistoryMapper.updateByPrimaryKeySelective(campusTaskHistory);
  }

  @Override
  public void remove(String primaryKey) {
    campusTaskHistoryMapper.deleteByPrimaryKey(primaryKey);
  }
}