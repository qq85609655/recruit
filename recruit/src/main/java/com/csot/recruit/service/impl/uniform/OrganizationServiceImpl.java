package com.csot.recruit.service.impl.uniform;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.recruit.dao.original.uniform.OrganizationMapper;
import com.csot.recruit.model.original.uniform.Organization;
import com.csot.recruit.model.original.uniform.OrganizationColumns;
import com.csot.recruit.model.original.uniform.OrganizationCriteria;
import com.csot.recruit.service.uniform.OrganizationService;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public List<Organization> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Organization> grid = new MiniRtn2Grid<Organization>();
        OrganizationCriteria criteria = new OrganizationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andCOrgnameEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = OrganizationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        return organizationMapper.selectByExample(criteria);
    }

    @Override
    public Organization getByPrimaryKey(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        return organizationMapper.selectByPrimaryKey(pk);
    }

    @Override
    public void create(Organization organization) {
        organizationMapper.insert(organization);
    }

    @Override
    public void updateSelective(Organization organization) {
        organizationMapper.updateByPrimaryKeySelective(organization);
    }

    @Override
    public void remove(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        organizationMapper.deleteByPrimaryKey(pk);
    }
}