package com.csot.recruit.service.impl.interview;

import com.csot.recruit.dao.original.interview.IllustrateMapper;
import com.csot.recruit.model.original.interview.Illustrate;
import com.csot.recruit.model.original.interview.IllustrateColumns;
import com.csot.recruit.model.original.interview.IllustrateCriteria;
import com.csot.recruit.service.interview.IllustrateService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("illustrateService")
public class IllustrateServiceImpl implements IllustrateService {
    private static final Logger logger = LoggerFactory.getLogger(IllustrateServiceImpl.class);

    @Resource
    private IllustrateMapper illustrateMapper;

    @Override
    public MiniRtn2Grid<Illustrate> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Illustrate> grid = new MiniRtn2Grid<Illustrate>();
        IllustrateCriteria criteria = new IllustrateCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = IllustrateColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(illustrateMapper.selectByExample(criteria));
        grid.setTotal(illustrateMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Illustrate getByPrimaryKey(String primaryKey) {
        return illustrateMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Illustrate illustrate) {
        illustrateMapper.insert(illustrate);
    }

    @Override
    public void updateSelective(Illustrate illustrate) {
        illustrateMapper.updateByPrimaryKeySelective(illustrate);
    }

    @Override
    public void remove(String primaryKey) {
        illustrateMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public Illustrate queryByPersonCode(String personCode) {
      // TODO Auto-generated method stub
      return illustrateMapper.selectByPersonCode(personCode);
    }
}