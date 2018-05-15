package com.csot.recruit.service.impl.flow.websitePost;

import java.util.Map;

import com.csot.recruit.dao.original.flow.websitePost.PostWebsiteLogMapper;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLog;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLogColumns;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLogCriteria;
import com.csot.recruit.service.flow.websitePost.PostWebsiteLogService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("postWebsiteLogService")
public class PostWebsiteLogServiceImpl implements PostWebsiteLogService {
  private static final Logger logger = LoggerFactory.getLogger(PostWebsiteLogServiceImpl.class);

  @Resource
  private PostWebsiteLogMapper postWebsiteLogMapper;

  @Override
  public MiniRtn2Grid<PostWebsiteLog> getGrid(MiniGridPageSort pageSort, Map<String, String> col) {
    MiniRtn2Grid<PostWebsiteLog> grid = new MiniRtn2Grid<PostWebsiteLog>();
    PostWebsiteLogCriteria criteria = new PostWebsiteLogCriteria();
    PostWebsiteLogCriteria.Criteria criteriaOr = criteria.or();
    // 查询条件
    if (StringUtils.hasText(col.get("tabState"))) {
      criteria.createCriteria().andWebsiteTypeEqualTo(col.get("tabState"));
    }
    if (StringUtils.hasText(col.get("tabState"))) {
      criteriaOr.andWebsiteTypeEqualTo(col.get("tabState"));
    }
    if (StringUtils.hasText(col.get("bState"))) {
      criteriaOr.andBeforeStateEqualTo(col.get("bState"));
    }
    if (StringUtils.hasText(col.get("aState"))) {
      criteriaOr.andStateEqualTo(col.get("aState"));
    }
    if (StringUtils.hasText(col.get("instructType"))) {
      criteriaOr.andLastInstructEqualTo(col.get("instructType"));
    }
    if (StringUtils.hasText(col.get("postNameStr"))) {
      criteriaOr.andPostNameLike("%" + col.get("postNameStr") + "%");
    }
    if (StringUtils.hasText(col.get("webpostName"))) {
      criteriaOr.andWebsitePostNameLike("%" + col.get("webpostName") + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PostWebsiteLogColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(postWebsiteLogMapper.selectByExample(criteria));
    grid.setTotal(postWebsiteLogMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PostWebsiteLog getByPrimaryKey(String primaryKey) {
    return postWebsiteLogMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PostWebsiteLog postWebsiteLog) {
    postWebsiteLogMapper.insert(postWebsiteLog);
  }

  @Override
  public void updateSelective(PostWebsiteLog postWebsiteLog) {
    postWebsiteLogMapper.updateByPrimaryKeySelective(postWebsiteLog);
  }

  @Override
  public void remove(String primaryKey) {
    postWebsiteLogMapper.deleteByPrimaryKey(primaryKey);
  }
}
