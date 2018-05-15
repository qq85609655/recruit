package com.csot.recruit.service.impl.position;

import com.csot.recruit.dao.position.RecruitFlowConfigMapper;
import com.csot.recruit.model.position.RecruitFlowConfig;
import com.csot.recruit.model.position.RecruitFlowConfigColumns;
import com.csot.recruit.model.position.RecruitFlowConfigCriteria;
import com.csot.recruit.service.position.RecruitFlowConfigService;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("recruitFlowConfigService")
public class RecruitFlowConfigServiceImpl implements RecruitFlowConfigService {
    private static final Logger logger = LoggerFactory.getLogger(RecruitFlowConfigServiceImpl.class);

    @Resource
    private RecruitFlowConfigMapper recruitFlowConfigMapper;

    @Override
    public MiniRtn2Grid<RecruitFlowConfig> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<RecruitFlowConfig> grid = new MiniRtn2Grid<RecruitFlowConfig>();
        RecruitFlowConfigCriteria criteria = new RecruitFlowConfigCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andRecruitPersonEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = RecruitFlowConfigColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(recruitFlowConfigMapper.selectByExample(criteria));
        grid.setTotal(recruitFlowConfigMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public RecruitFlowConfig getByPrimaryKey(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        return recruitFlowConfigMapper.selectByPrimaryKey(pk);
    }

    @Override
    public void create(RecruitFlowConfig recruitFlowConfig) {
        recruitFlowConfigMapper.insert(recruitFlowConfig);
    }

    @Override
    public void updateSelective(RecruitFlowConfig recruitFlowConfig) {
        recruitFlowConfigMapper.updateByPrimaryKeySelective(recruitFlowConfig);
    }

    @Override
    public void remove(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        recruitFlowConfigMapper.deleteByPrimaryKey(pk);
    }
}