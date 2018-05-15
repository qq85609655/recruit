package com.csot.recruit.service.impl.flow.employ;

import java.util.ArrayList;
import java.util.List;

import com.csot.recruit.dao.original.attachment.AttachmentMapper;
import com.csot.recruit.dao.original.flow.employ.EmployARalationMapper;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.attachment.AttachmentCriteria;
import com.csot.recruit.model.original.flow.employ.EmployARalation;
import com.csot.recruit.model.original.flow.employ.EmployARalationColumns;
import com.csot.recruit.model.original.flow.employ.EmployARalationCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalation;
import com.csot.recruit.service.flow.employ.EmployARalationService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("employARalationService")
public class EmployARalationServiceImpl implements EmployARalationService {
    private static final Logger logger = LoggerFactory.getLogger(EmployARalationServiceImpl.class);

    @Resource
    private EmployARalationMapper employARalationMapper;
    @Resource
    private AttachmentMapper attachmentMapper;
    @Override
    public MiniRtn2Grid<EmployARalation> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<EmployARalation> grid = new MiniRtn2Grid<EmployARalation>();
        EmployARalationCriteria criteria = new EmployARalationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EmployARalationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(employARalationMapper.selectByExample(criteria));
        grid.setTotal(employARalationMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public EmployARalation getByPrimaryKey(String primaryKey) {
        return employARalationMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(EmployARalation employARalation) {
        employARalationMapper.insert(employARalation);
    }

    @Override
    public void updateSelective(EmployARalation employARalation) {
        employARalationMapper.updateByPrimaryKeySelective(employARalation);
    }

    @Override
    public void remove(String primaryKey) {
        employARalationMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<Attachment> getListByEmployeId(String id) {
      EmployARalationCriteria criteria=new EmployARalationCriteria();
      criteria.createCriteria().andEmployIdEqualTo(id);
      List<EmployARalation> selectByExample = employARalationMapper.selectByExample(criteria);
      AttachmentCriteria example = new AttachmentCriteria();
      List<String> values = new ArrayList<String>();
      for (EmployARalation rmployARalation : selectByExample) {
        values.add(rmployARalation.getAttachmentId());
      }
      if (values != null && values.size() > 0) {
        example.or().andIdIn(values);
        List<Attachment> attachments = attachmentMapper.selectByExample(example);
        return attachments;
      }
      return null;
    }
}