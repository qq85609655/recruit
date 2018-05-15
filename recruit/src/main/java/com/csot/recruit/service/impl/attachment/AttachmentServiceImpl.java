package com.csot.recruit.service.impl.attachment;

import java.util.List;

import com.csot.recruit.dao.original.attachment.AttachmentMapper;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.attachment.AttachmentColumns;
import com.csot.recruit.model.original.attachment.AttachmentCriteria;
import com.csot.recruit.service.attachment.AttachmentService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {
    private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public MiniRtn2Grid<Attachment> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Attachment> grid = new MiniRtn2Grid<Attachment>();
        AttachmentCriteria criteria = new AttachmentCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = AttachmentColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(attachmentMapper.selectByExample(criteria));
        grid.setTotal(attachmentMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Attachment getByPrimaryKey(String primaryKey) {
        return attachmentMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Attachment attachment) {
        attachmentMapper.insert(attachment);
    }

    @Override
    public void updateSelective(Attachment attachment) {
        attachmentMapper.updateByPrimaryKeySelective(attachment);
    }

    @Override
    public void remove(String primaryKey) {
        attachmentMapper.deleteByPrimaryKey(primaryKey);
    }
    
    @Override
    public List<Attachment> findAttachsByRelateId(String relateId) {
      AttachmentCriteria criteria = new AttachmentCriteria();
      criteria.or().andRelateIdEqualTo(relateId);
      return attachmentMapper.selectByExample(criteria);
    }
    
}