package com.csot.gm.materialManage.service.impl.flowNo;

import com.csot.gm.materialManage.dao.original.flowNo.FlowNoMapper;
import com.csot.gm.materialManage.model.original.flowNo.FlowNo;
import com.csot.gm.materialManage.model.original.flowNo.FlowNoColumns;
import com.csot.gm.materialManage.model.original.flowNo.FlowNoCriteria;
import com.csot.gm.materialManage.service.flowNo.FlowNoService;

import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("flowNoService")
public class FlowNoServiceImpl implements FlowNoService {

  @Resource
  private FlowNoMapper flowNoMapper;

  @Override
  public MiniRtn2Grid<FlowNo> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<FlowNo> grid = new MiniRtn2Grid<FlowNo>();
    FlowNoCriteria criteria = new FlowNoCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andPartNumEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = FlowNoColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(flowNoMapper.selectByExample(criteria));
    grid.setTotal(flowNoMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public FlowNo getByPrimaryKey(String primaryKey) {
    return flowNoMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(FlowNo flowNo) {
    flowNo.setPartNum(UUID.randomUUID().toString().replace("-", ""));
    flowNoMapper.insert(flowNo);
  }

  @Override
  public void updateSelective(FlowNo flowNo) {
    flowNoMapper.updateByPrimaryKeySelective(flowNo);
  }

  @Override
  public void remove(String primaryKey) {
    flowNoMapper.deleteByPrimaryKey(primaryKey);
  }
}
