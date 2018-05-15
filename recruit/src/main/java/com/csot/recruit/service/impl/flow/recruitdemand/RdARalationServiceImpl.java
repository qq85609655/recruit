package com.csot.recruit.service.impl.flow.recruitdemand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csot.recruit.dao.original.attachment.AttachmentMapper;
import com.csot.recruit.dao.original.flow.recruitdemand.RdARalationMapper;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.attachment.AttachmentCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalation;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalationColumns;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalationCriteria;
import com.csot.recruit.service.flow.recruitdemand.RdARalationService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("rdARalationService")
public class RdARalationServiceImpl implements RdARalationService {
  private static final Logger logger = LoggerFactory.getLogger(RdARalationServiceImpl.class);

  @Resource
  private RdARalationMapper rdARalationMapper;
  @Resource
  private AttachmentMapper attachmentMapper;

  @Override
  public MiniRtn2Grid<RdARalation> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<RdARalation> grid = new MiniRtn2Grid<RdARalation>();
    RdARalationCriteria criteria = new RdARalationCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = RdARalationColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(rdARalationMapper.selectByExample(criteria));
    grid.setTotal(rdARalationMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public List<Attachment> getList(RdARalationCriteria criteria) {
    List<RdARalation> selectByExample = rdARalationMapper.selectByExample(criteria);
    AttachmentCriteria example = new AttachmentCriteria();
    List<String> values = new ArrayList<String>();
    for (RdARalation rdARalation : selectByExample) {
      values.add(rdARalation.getAttachmentId());
    }
    if (values != null && values.size() > 0) {
      example.or().andIdIn(values);
      List<Attachment> attachments = attachmentMapper.selectByExample(example);
      return attachments;
    }
    return null;

  }

  @Override
  public RdARalation getByPrimaryKey(String primaryKey) {
    return rdARalationMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(RdARalation rdARalation) {
    rdARalationMapper.insert(rdARalation);
  }

  @Override
  public void updateSelective(RdARalation rdARalation) {
    rdARalationMapper.updateByPrimaryKeySelective(rdARalation);
  }

  @Override
  public void remove(String primaryKey) {
    rdARalationMapper.deleteByPrimaryKey(primaryKey);
  }
}
