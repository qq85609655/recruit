package com.csot.recruit.service.impl.position;

import com.csot.recruit.dao.position.RequireInforMapper;
import com.csot.recruit.model.position.RequireInfor;
import com.csot.recruit.model.position.RequireInforColumns;
import com.csot.recruit.model.position.RequireInforCriteria;
import com.csot.recruit.service.position.RequireInforService;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("requireInforService")
@Transactional
public class RequireInforServiceImpl implements RequireInforService {
    private static final Logger logger = LoggerFactory.getLogger(RequireInforServiceImpl.class);

    @Resource
    private RequireInforMapper requireInforMapper;

    @Override
    public MiniRtn2Grid<RequireInfor> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<RequireInfor> grid = new MiniRtn2Grid<RequireInfor>();
        RequireInforCriteria criteria = new RequireInforCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andEducationMinEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = RequireInforColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(requireInforMapper.selectByExample(criteria));
        grid.setTotal(requireInforMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public RequireInfor getByPrimaryKey(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        return requireInforMapper.selectByPrimaryKey(pk);
    }

    @Override
    public void create(RequireInfor requireInfor) {
        requireInforMapper.insert(requireInfor);
    }

    @Override
    public void updateSelective(RequireInfor requireInfor) {
        requireInforMapper.updateByPrimaryKeySelective(requireInfor);
    }

    @Override
    public void remove(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        requireInforMapper.deleteByPrimaryKey(pk);
    }

	@Override
	public void removeByExample(RequireInforCriteria example) {
		requireInforMapper.deleteByExample(example);
	}
}