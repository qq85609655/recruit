package com.csot.gm.materialManage.service.impl.wxmap;

import com.csot.gm.materialManage.dao.original.wxmap.WXMapMapper;
import com.csot.gm.materialManage.model.original.wxmap.WXMap;
import com.csot.gm.materialManage.model.original.wxmap.WXMapColumns;
import com.csot.gm.materialManage.model.original.wxmap.WXMapCriteria;
import com.csot.gm.materialManage.service.wxmap.WXMapService;

import java.util.UUID;
import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("wXMapService")
public class WXMapServiceImpl implements WXMapService {

  @Resource
  private WXMapMapper wxMapMapper;

  @Override
  public MiniRtn2Grid<WXMap> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<WXMap> grid = new MiniRtn2Grid<WXMap>();
    WXMapCriteria criteria = new WXMapCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = WXMapColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(wxMapMapper.selectByExample(criteria));
    grid.setTotal(wxMapMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public WXMap getByPrimaryKey(String primaryKey) {
    return wxMapMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(WXMap wxMap) {
    wxMap.setId(UUID.randomUUID().toString().replace("-", ""));
    wxMapMapper.insert(wxMap);
  }

  @Override
  public void updateSelective(WXMap wxMap) {
    wxMapMapper.updateByPrimaryKeySelective(wxMap);
  }

  @Override
  public void remove(String primaryKey) {
    wxMapMapper.deleteByPrimaryKey(primaryKey);
  }
}
