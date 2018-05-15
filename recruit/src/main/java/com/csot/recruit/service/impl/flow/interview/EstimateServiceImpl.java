package com.csot.recruit.service.impl.flow.interview;

import java.util.Map;
import java.util.UUID;

import com.csot.recruit.dao.original.flow.interview.EstimateMapper;
import com.csot.recruit.dao.original.flow.interview.InterviewBookMapper;
import com.csot.recruit.model.original.flow.interview.Estimate;
import com.csot.recruit.model.original.flow.interview.EstimateColumns;
import com.csot.recruit.model.original.flow.interview.EstimateCriteria;
import com.csot.recruit.service.flow.interview.EstimateService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("estimateService")
public class EstimateServiceImpl implements EstimateService {
  private static final Logger logger = LoggerFactory.getLogger(EstimateServiceImpl.class);

  @Resource
  private EstimateMapper estimateMapper;

  @Resource
  private InterviewBookMapper interviewBookMapper;

  @Resource
  private BaseUserMapper baseUserMapper;

  @Override
  public MiniRtn2Grid<Estimate> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<Estimate> grid = new MiniRtn2Grid<Estimate>();
    EstimateCriteria criteria = new EstimateCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = EstimateColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(estimateMapper.selectByExample(criteria));
    grid.setTotal(estimateMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public Estimate getByPrimaryKey(String primaryKey) {
    return estimateMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(Estimate estimate) {
    EstimateCriteria example = new EstimateCriteria();
    example.createCriteria().andCandidateIdEqualTo(estimate.getCandidateId())
        .andPositionIdEqualTo(estimate.getPositionId());
    estimateMapper.deleteByExample(example);
    estimateMapper.insert(estimate);
  }

  @Override
  public void updateSelective(Estimate estimate) {
    estimateMapper.updateByPrimaryKeySelective(estimate);
  }

  @Override
  public void remove(String primaryKey) {
    estimateMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public Estimate selectByCandiateIdAndPositionId(Map<String, Object> param) {
    return estimateMapper.selectByCandiateIdAndPositionId(param);
  }

  @Override
  public int saveOrUpdate(SysUser sysUser, Estimate estimate) {

    if (StringUtils.hasText(estimate.getId())) {
      estimateMapper.updateByPrimaryKeySelective(estimate);
    } else {
      estimate.setId(UUID.randomUUID().toString().replace("-", ""));
      estimate.setHrId(sysUser.getId());
      estimateMapper.insertSelective(estimate);

    }
    return 0;

  }
}
