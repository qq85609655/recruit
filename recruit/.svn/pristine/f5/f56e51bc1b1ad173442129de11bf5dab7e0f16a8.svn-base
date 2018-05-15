package com.csot.recruit.service.impl.org;

import com.csot.recruit.dao.org.OrganazationMapper;
import com.csot.recruit.model.org.Organazation;
import com.csot.recruit.model.org.OrganazationColumns;
import com.csot.recruit.model.org.OrganazationCriteria;
import com.csot.recruit.service.org.OrganazationService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("organazationService")
public class OrganazationServiceImpl implements OrganazationService {
    private static final Logger logger = LoggerFactory.getLogger(OrganazationServiceImpl.class);

    @Resource
    private OrganazationMapper organazationMapper;

    @Override
    public MiniRtn2Grid<Organazation> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Organazation> grid = new MiniRtn2Grid<Organazation>();
        OrganazationCriteria criteria = new OrganazationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = OrganazationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(organazationMapper.selectByExample(criteria));
        grid.setTotal(organazationMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Organazation getByPrimaryKey(String primaryKey) {
        return organazationMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Organazation organazation) {
        organazationMapper.insert(organazation);
    }

    @Override
    public void updateSelective(Organazation organazation) {
        organazationMapper.updateByPrimaryKeySelective(organazation);
    }

    @Override
    public void remove(String primaryKey) {
        organazationMapper.deleteByPrimaryKey(primaryKey);
    }
    
    @Override
    public Organazation queryOrgAndUser(String primaryKey) {
      return organazationMapper.selectOrgAndUser(primaryKey);
    }
}