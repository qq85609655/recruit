package com.csot.recruit.service.impl.position;

import com.csot.recruit.dao.position.DepartmentRequireMapper;
import com.csot.recruit.model.position.DepartmentRequire;
import com.csot.recruit.model.position.DepartmentRequireColumns;
import com.csot.recruit.model.position.DepartmentRequireCriteria;
import com.csot.recruit.service.position.DepartmentRequireService;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("departmentRequireService")
@Transactional
public class DepartmentRequireServiceImpl implements DepartmentRequireService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentRequireServiceImpl.class);

    @Resource
    private DepartmentRequireMapper departmentRequireMapper;

    @Override
    public MiniRtn2Grid<DepartmentRequire> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<DepartmentRequire> grid = new MiniRtn2Grid<DepartmentRequire>();
        DepartmentRequireCriteria criteria = new DepartmentRequireCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andDepartmentEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = DepartmentRequireColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(departmentRequireMapper.selectByExample(criteria));
        grid.setTotal(departmentRequireMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public DepartmentRequire getByPrimaryKey(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        return departmentRequireMapper.selectByPrimaryKey(pk);
    }

    @Override
    public void create(DepartmentRequire departmentRequire) {
        departmentRequireMapper.insert(departmentRequire);
    }

    @Override
    public void updateSelective(DepartmentRequire departmentRequire) {
        departmentRequireMapper.updateByPrimaryKeySelective(departmentRequire);
    }

    @Override
    public void remove(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        departmentRequireMapper.deleteByPrimaryKey(pk);
    }

	@Override
	public DepartmentRequire getByRecruitPositionId(String recruitPositionId) {
		DepartmentRequire departmentRequire = new DepartmentRequire();
		DepartmentRequireCriteria criteria = new DepartmentRequireCriteria();
		criteria.createCriteria().andRecruitPositionIdEqualTo(recruitPositionId);
		List <DepartmentRequire> list = departmentRequireMapper.selectByExample(criteria);
		if(list.size() > 0)
			departmentRequire = list.get(0);
		return departmentRequire;
	}

	@Override
	public void removeByExample(DepartmentRequireCriteria example) {
		departmentRequireMapper.deleteByExample(example);
	}
}