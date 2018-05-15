package com.csot.recruit.service.impl.interview;

import java.util.List;

import com.csot.recruit.dao.original.interview.RecommendMapper;
import com.csot.recruit.model.original.interview.Recommend;
import com.csot.recruit.model.original.interview.RecommendColumns;
import com.csot.recruit.model.original.interview.RecommendCriteria;
import com.csot.recruit.service.interview.RecommendService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
    private static final Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);

    @Resource
    private RecommendMapper recommendMapper;

    @Override
    public MiniRtn2Grid<Recommend> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Recommend> grid = new MiniRtn2Grid<Recommend>();
        RecommendCriteria criteria = new RecommendCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = RecommendColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(recommendMapper.selectByExample(criteria));
        grid.setTotal(recommendMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Recommend getByPrimaryKey(String primaryKey) {
        return recommendMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Recommend recommend) {
        recommendMapper.insert(recommend);
    }

    @Override
    public void updateSelective(Recommend recommend) {
        recommendMapper.updateByPrimaryKeySelective(recommend);
    }

    @Override
    public void remove(String primaryKey) {
        recommendMapper.deleteByPrimaryKey(primaryKey);
    }
    
    @Override
    public void deleteByPersonCode(String personCode) {
        recommendMapper.deleteByPersonCode(personCode);
    }

    @Override
    public List<Recommend> queryByPersonCode(String personCode) {
      // TODO Auto-generated method stub
      return recommendMapper.selectByPersonCode(personCode);
    }
    
}