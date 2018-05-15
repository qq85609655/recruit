package com.csot.recruit.service.impl.flow.employ;

import java.util.List;

import com.csot.recruit.dao.original.flow.employ.EmployEducationMapper;
import com.csot.recruit.model.original.flow.employ.EmployEducation;
import com.csot.recruit.model.original.flow.employ.EmployEducationColumns;
import com.csot.recruit.model.original.flow.employ.EmployEducationCriteria;
import com.csot.recruit.service.flow.employ.EmployEducationService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("employEducationService")
public class EmployEducationServiceImpl implements EmployEducationService {
    private static final Logger logger = LoggerFactory.getLogger(EmployEducationServiceImpl.class);

    @Resource
    private EmployEducationMapper employEducationMapper;

    @Override
    public MiniRtn2Grid<EmployEducation> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<EmployEducation> grid = new MiniRtn2Grid<EmployEducation>();
        EmployEducationCriteria criteria = new EmployEducationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EmployEducationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(employEducationMapper.selectByExample(criteria));
        grid.setTotal(employEducationMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public EmployEducation getByPrimaryKey(String primaryKey) {
        return employEducationMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(EmployEducation employEducation) {
        employEducationMapper.insert(employEducation);
    }

    @Override
    public void updateSelective(EmployEducation employEducation) {
        employEducationMapper.updateByPrimaryKeySelective(employEducation);
    }

    @Override
    public void remove(String primaryKey) {
        employEducationMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<EmployEducation> getByEmploy(String employId) {
      EmployEducationCriteria example=new EmployEducationCriteria();
      example.createCriteria().andEmployIdEqualTo(employId);
      return employEducationMapper.selectByExample(example);
    }
}