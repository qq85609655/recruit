package com.csot.recruit.service.impl.campus;

import java.util.List;
import java.util.UUID;

import com.csot.recruit.dao.original.campus.CampusSiteMapper;
import com.csot.recruit.model.original.campus.CampusSite;
import com.csot.recruit.model.original.campus.CampusSiteColumns;
import com.csot.recruit.model.original.campus.CampusSiteCriteria;
import com.csot.recruit.service.campus.CampusSiteService;

import javax.annotation.Resource;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("campusSiteService")
public class CampusSiteServiceImpl implements CampusSiteService {
  private static final Logger logger = LoggerFactory.getLogger(CampusSiteServiceImpl.class);

  @Resource
  private CampusSiteMapper campusSiteMapper;

  @Override
  public MiniRtn2Grid<CampusSite>
      getGrid(MiniGridPageSort pageSort, String siteName, String status) {
    MiniRtn2Grid<CampusSite> grid = new MiniRtn2Grid<CampusSite>();
    CampusSiteCriteria criteria = new CampusSiteCriteria();
    CampusSiteCriteria.Criteria criter = criteria.or();
    // 查询条件
    if (StringUtils.hasText(siteName)) {
      criter.andSiteNameLikeInsensitive("%" + siteName + "%");
    }
    if (StringUtils.hasText(status)) {
      criter.andStatusEqualTo(status);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = CampusSiteColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(campusSiteMapper.selectByExample(criteria));
    grid.setTotal(campusSiteMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public CampusSite getByPrimaryKey(String primaryKey) {
    return campusSiteMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(CampusSite campusSite) {
    campusSite.setId(UUID.randomUUID().toString().replace("-", ""));
    campusSiteMapper.insert(campusSite);
  }

  @Override
  public void updateSelective(CampusSite campusSite) {
    campusSiteMapper.updateByPrimaryKeySelective(campusSite);
  }

  @Override
  public void remove(String primaryKey) {
    campusSiteMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public AjaxRtnJson savaData(CampusSite[] campusSiteArr) {
    int countUpdate = 0;
    int countInsert = 0;
    String msg = "";
    for (CampusSite site : campusSiteArr) {
      if (StringUtils.hasText(site.getId())) {
        site.setSiteName(null);
        campusSiteMapper.updateByPrimaryKeySelective(site);
        countUpdate++;
      } else {
        CampusSiteCriteria criteria = new CampusSiteCriteria();
        criteria.or().andSiteNameEqualTo(site.getSiteName());
        List<CampusSite> siteList = campusSiteMapper.selectByExample(criteria);
        if (siteList.isEmpty()) {
          create(site);
          countInsert++;
        } else {
          msg = msg + site.getSiteName() + "已存在;";
        }
      }
    }
    AjaxRtnJson ajax = new AjaxRtnJson();
    ajax.setMsg("更新" + countUpdate + "条; 新增" + countInsert + "条数据;" + msg);
    ajax.setSuccess(true);
    return ajax;
  }

  @Override
  public CampusSite getBySiteIdOrName(String siteId, String siteName) {
    if (null == siteId && null == siteName) {
      return null;
    }
    CampusSiteCriteria cri = new CampusSiteCriteria();
    CampusSiteCriteria.Criteria criter = cri.or();
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(siteName)) {
      criter.andSiteNameEqualTo(siteName);
    }
    List<CampusSite> list = campusSiteMapper.selectByExample(cri);
    if (list.isEmpty()) {
      return null;
    } else {
      return list.get(0);
    }
  }

}
