package com.csot.recruit.service.impl.interview;

import com.csot.recruit.dao.original.interview.WorksMapper;
import com.csot.recruit.model.original.interview.Works;
import com.csot.recruit.model.original.interview.WorksColumns;
import com.csot.recruit.model.original.interview.WorksCriteria;
import com.csot.recruit.service.interview.WorksService;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("worksService")
public class WorksServiceImpl implements WorksService {
    private static final Logger logger = LoggerFactory.getLogger(WorksServiceImpl.class);

    @Resource
    private WorksMapper worksMapper;

    @Override
    public MiniRtn2Grid<Works> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Works> grid = new MiniRtn2Grid<Works>();
        WorksCriteria criteria = new WorksCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = WorksColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(worksMapper.selectByExample(criteria));
        grid.setTotal(worksMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Works getByPrimaryKey(String primaryKey) {
        return worksMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Works works) {
        worksMapper.insert(works);
    }

    @Override
    public void updateSelective(Works works) {
        worksMapper.updateByPrimaryKeySelective(works);
    }

    @Override
    public void remove(String primaryKey) {
        worksMapper.deleteByPrimaryKey(primaryKey);
    }
}