package com.csot.recruit.service.impl.interview;

import com.csot.recruit.dao.original.interview.EducationMapper;
import com.csot.recruit.model.original.interview.Education;
import com.csot.recruit.model.original.interview.EducationColumns;
import com.csot.recruit.model.original.interview.EducationCriteria;
import com.csot.recruit.service.interview.EducationService;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("educationService")
public class EducationServiceImpl implements EducationService {
    private static final Logger logger = LoggerFactory.getLogger(EducationServiceImpl.class);

    @Resource
    private EducationMapper educationMapper;

    @Override
    public MiniRtn2Grid<Education> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Education> grid = new MiniRtn2Grid<Education>();
        EducationCriteria criteria = new EducationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EducationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(educationMapper.selectByExample(criteria));
        grid.setTotal(educationMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Education getByPrimaryKey(String primaryKey) {
        return educationMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Education education) {
        educationMapper.insert(education);
    }

    @Override
    public void updateSelective(Education education) {
        educationMapper.updateByPrimaryKeySelective(education);
    }

    @Override
    public void remove(String primaryKey) {
        educationMapper.deleteByPrimaryKey(primaryKey);
    }
}