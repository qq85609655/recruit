package com.csot.gm.materialManage.service.impl.systemNotice;

import com.csot.gm.materialManage.dao.original.systemNotice.SystemNoticeMapper;
import com.csot.gm.materialManage.model.original.systemNotice.SystemNotice;
import com.csot.gm.materialManage.model.original.systemNotice.SystemNoticeColumns;
import com.csot.gm.materialManage.model.original.systemNotice.SystemNoticeCriteria;
import com.csot.gm.materialManage.service.systemNotice.SystemNoticeService;
import java.util.UUID;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("systemNoticeService")
public class SystemNoticeServiceImpl implements SystemNoticeService {

  @Resource
  private SystemNoticeMapper systemNoticeMapper;

  @Override
  public MiniRtn2Grid<SystemNotice> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<SystemNotice> grid = new MiniRtn2Grid<SystemNotice>();
    SystemNoticeCriteria criteria = new SystemNoticeCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = SystemNoticeColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(systemNoticeMapper.selectByExample(criteria));
    grid.setTotal(systemNoticeMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public SystemNotice getByPrimaryKey(String primaryKey) {
    return systemNoticeMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(SystemNotice systemNotice) {
    systemNotice.setId(UUID.randomUUID().toString().replace("-", ""));
    systemNoticeMapper.insert(systemNotice);
  }

  @Override
  public void updateSelective(SystemNotice systemNotice) {
    systemNoticeMapper.updateByPrimaryKeySelective(systemNotice);
  }

  @Override
  public void remove(String primaryKey) {
    systemNoticeMapper.deleteByPrimaryKey(primaryKey);
  }
}