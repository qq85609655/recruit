package com.csot.recruit.service.impl.position;

import com.csot.recruit.dao.position.DistributeMapper;
import com.csot.recruit.model.position.Distribute;
import com.csot.recruit.model.position.DistributeColumns;
import com.csot.recruit.model.position.DistributeCriteria;
import com.csot.recruit.service.position.DistributeService;

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

@Service("distributeService")
@Transactional
public class DistributeServiceImpl implements DistributeService {
    private static final Logger logger = LoggerFactory.getLogger(DistributeServiceImpl.class);

    @Resource
    private DistributeMapper distributeMapper;

    @Override
    public MiniRtn2Grid<Distribute> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Distribute> grid = new MiniRtn2Grid<Distribute>();
        DistributeCriteria criteria = new DistributeCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andPublisherEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = DistributeColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(distributeMapper.selectByExample(criteria));
        grid.setTotal(distributeMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Distribute getByPrimaryKey(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        return distributeMapper.selectByPrimaryKey(pk);
    }

    @Override
    public void create(Distribute distribute) {
        distributeMapper.insert(distribute);
    }

    @Override
    public void updateSelective(Distribute distribute) {
        distributeMapper.updateByPrimaryKeySelective(distribute);
    }

    @Override
    public void remove(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        distributeMapper.deleteByPrimaryKey(pk);
    }
    
	@Override
	public void removeByExample(DistributeCriteria criteria) {
		distributeMapper.deleteByExample(criteria);
	}

	@Override
	public List<Distribute> getByExample(DistributeCriteria criteria) {
		return distributeMapper.selectByExample(criteria);
	}
}