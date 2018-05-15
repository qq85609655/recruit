package com.csot.recruit.service.impl.flow.employ;

import java.util.List;

import com.csot.recruit.dao.original.flow.employ.EmployDemandMapper;
import com.csot.recruit.model.original.flow.employ.EmployDemand;
import com.csot.recruit.model.original.flow.employ.EmployDemandColumns;
import com.csot.recruit.model.original.flow.employ.EmployDemandCriteria;
import com.csot.recruit.service.flow.employ.EmployDemandService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("employDemandService")
public class EmployDemandServiceImpl implements EmployDemandService {
  private static final Logger logger = LoggerFactory.getLogger(EmployDemandServiceImpl.class);

  @Resource
  private EmployDemandMapper employDemandMapper;

  @Override
  public MiniRtn2Grid<EmployDemand> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<EmployDemand> grid = new MiniRtn2Grid<EmployDemand>();
    EmployDemandCriteria criteria = new EmployDemandCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = EmployDemandColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(employDemandMapper.selectByExample(criteria));
    grid.setTotal(employDemandMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public EmployDemand getByPrimaryKey(String primaryKey) {
    return employDemandMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(EmployDemand employDemand) {
    employDemandMapper.insert(employDemand);
  }

  @Override
  public void updateSelective(EmployDemand employDemand) {
    employDemandMapper.updateByPrimaryKeySelective(employDemand);
  }

  @Override
  public void remove(String primaryKey) {
    employDemandMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 根据employid获取录用招聘需求单信息
   * 
   * @param id
   * @return
   */
  @Override
  public EmployDemand getByEmploy(String id) {
    EmployDemandCriteria example = new EmployDemandCriteria();
    example.createCriteria().andEmployIdEqualTo(id);
    List<EmployDemand> employDemand = employDemandMapper.selectByExample(example);
    if (employDemand != null && employDemand.size() > 0) {
      return employDemand.get(0);
    }
    return null;
  }
}
