package com.csot.recruit.service.impl.resume;

import com.csot.recruit.dao.resume.WorkIntentionMapper;
import com.csot.recruit.model.resume.WorkIntention;
import com.csot.recruit.model.resume.WorkIntentionColumns;
import com.csot.recruit.model.resume.WorkIntentionCriteria;
import com.csot.recruit.service.resume.WorkIntentionService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("workIntentionService")
public class WorkIntentionServiceImpl implements WorkIntentionService {
    private static final Logger logger = LoggerFactory.getLogger(WorkIntentionServiceImpl.class);

    @Resource
    private WorkIntentionMapper workIntentionMapper;

    @Override
    public MiniRtn2Grid<WorkIntention> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<WorkIntention> grid = new MiniRtn2Grid<WorkIntention>();
        WorkIntentionCriteria criteria = new WorkIntentionCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = WorkIntentionColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(workIntentionMapper.selectByExample(criteria));
        grid.setTotal(workIntentionMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public WorkIntention getByPrimaryKey(String primaryKey) {
        return workIntentionMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(WorkIntention workIntention) {
        workIntentionMapper.insert(workIntention);
    }

    @Override
    public void updateSelective(WorkIntention workIntention) {
        workIntentionMapper.updateByPrimaryKeySelective(workIntention);
    }

    @Override
    public void remove(String primaryKey) {
        workIntentionMapper.deleteByPrimaryKey(primaryKey);
    }
}