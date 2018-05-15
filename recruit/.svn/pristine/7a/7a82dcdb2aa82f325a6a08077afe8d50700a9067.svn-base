package com.csot.recruit.service.impl.position;

import com.csot.recruit.dao.position.RecruitInforMapper;
import com.csot.recruit.model.position.RecruitInfor;
import com.csot.recruit.model.position.RecruitInforColumns;
import com.csot.recruit.model.position.RecruitInforCriteria;
import com.csot.recruit.service.position.RecruitInforService;

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

@Service("recruitInforService")
@Transactional
public class RecruitInforServiceImpl implements RecruitInforService {
    private static final Logger logger = LoggerFactory.getLogger(RecruitInforServiceImpl.class);

    @Resource
    private RecruitInforMapper recruitInforMapper;

    @Override
    public MiniRtn2Grid<RecruitInfor> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<RecruitInfor> grid = new MiniRtn2Grid<RecruitInfor>();
        RecruitInforCriteria criteria = new RecruitInforCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andRecruiterEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = RecruitInforColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(recruitInforMapper.selectByExample(criteria));
        grid.setTotal(recruitInforMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public RecruitInfor getByPrimaryKey(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        return recruitInforMapper.selectByPrimaryKey(pk);
    }

    @Override
    public void create(RecruitInfor recruitInfor) {
        recruitInforMapper.insert(recruitInfor);
    }

    @Override
    public void updateSelective(RecruitInfor recruitInfor) {
        recruitInforMapper.updateByPrimaryKeySelective(recruitInfor);
    }

    @Override
    public void remove(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        recruitInforMapper.deleteByPrimaryKey(pk);
    }

	@Override
	public void removeByExample(RecruitInforCriteria criteria) {
		recruitInforMapper.deleteByExample(criteria);
	}
}