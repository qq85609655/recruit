package com.csot.recruit.service.impl.flow.employ;

import java.util.List;

import com.csot.recruit.dao.original.flow.employ.EmployWorkMapper;
import com.csot.recruit.model.original.flow.employ.EmployWork;
import com.csot.recruit.model.original.flow.employ.EmployWorkColumns;
import com.csot.recruit.model.original.flow.employ.EmployWorkCriteria;
import com.csot.recruit.service.flow.employ.EmployWorkService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("employWorkService")
public class EmployWorkServiceImpl implements EmployWorkService {
    private static final Logger logger = LoggerFactory.getLogger(EmployWorkServiceImpl.class);

    @Resource
    private EmployWorkMapper employWorkMapper;

    @Override
    public MiniRtn2Grid<EmployWork> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<EmployWork> grid = new MiniRtn2Grid<EmployWork>();
        EmployWorkCriteria criteria = new EmployWorkCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EmployWorkColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(employWorkMapper.selectByExample(criteria));
        grid.setTotal(employWorkMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public EmployWork getByPrimaryKey(String primaryKey) {
        return employWorkMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(EmployWork employWork) {
        employWorkMapper.insert(employWork);
    }

    @Override
    public void updateSelective(EmployWork employWork) {
        employWorkMapper.updateByPrimaryKeySelective(employWork);
    }

    @Override
    public void remove(String primaryKey) {
        employWorkMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<EmployWork> getByEmploy(String employId) {
      EmployWorkCriteria example=new EmployWorkCriteria();
      example.createCriteria().andEmployIdEqualTo(employId);
      return employWorkMapper.selectByExample(example);
    }
}