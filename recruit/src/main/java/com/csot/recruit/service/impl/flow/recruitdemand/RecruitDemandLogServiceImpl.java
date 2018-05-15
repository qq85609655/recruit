package com.csot.recruit.service.impl.flow.recruitdemand;

import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandLogMapper;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLog;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLogColumns;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLogCriteria;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandLogService;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("recruitDemandLogService")
public class RecruitDemandLogServiceImpl implements RecruitDemandLogService {
    private static final Logger logger = LoggerFactory.getLogger(RecruitDemandLogServiceImpl.class);

    @Resource
    private RecruitDemandLogMapper recruitDemandLogMapper;

    @Override
    public MiniRtn2Grid<RecruitDemandLog> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<RecruitDemandLog> grid = new MiniRtn2Grid<RecruitDemandLog>();
        RecruitDemandLogCriteria criteria = new RecruitDemandLogCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andDemandIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = RecruitDemandLogColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(recruitDemandLogMapper.selectByExample(criteria));
        grid.setTotal(recruitDemandLogMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public RecruitDemandLog getByPrimaryKey(String primaryKey) {
        return recruitDemandLogMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(RecruitDemandLog recruitDemandLog) {
        recruitDemandLogMapper.insert(recruitDemandLog);
    }

    @Override
    public void updateSelective(RecruitDemandLog recruitDemandLog) {
        recruitDemandLogMapper.updateByPrimaryKeySelective(recruitDemandLog);
    }

    @Override
    public void remove(String primaryKey) {
        recruitDemandLogMapper.deleteByPrimaryKey(primaryKey);
    }
}