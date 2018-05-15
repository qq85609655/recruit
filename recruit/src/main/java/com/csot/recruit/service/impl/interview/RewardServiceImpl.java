package com.csot.recruit.service.impl.interview;

import java.util.List;

import com.csot.recruit.dao.original.interview.RewardMapper;
import com.csot.recruit.model.original.interview.Reward;
import com.csot.recruit.model.original.interview.RewardColumns;
import com.csot.recruit.model.original.interview.RewardCriteria;
import com.csot.recruit.service.interview.RewardService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("rewardService")
public class RewardServiceImpl implements RewardService {
    private static final Logger logger = LoggerFactory.getLogger(RewardServiceImpl.class);

    @Resource
    private RewardMapper rewardMapper;

    @Override
    public MiniRtn2Grid<Reward> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Reward> grid = new MiniRtn2Grid<Reward>();
        RewardCriteria criteria = new RewardCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = RewardColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(rewardMapper.selectByExample(criteria));
        grid.setTotal(rewardMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Reward getByPrimaryKey(String primaryKey) {
        return rewardMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Reward reward) {
        rewardMapper.insert(reward);
    }

    @Override
    public void updateSelective(Reward reward) {
        rewardMapper.updateByPrimaryKeySelective(reward);
    }

    @Override
    public void remove(String primaryKey) {
        rewardMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<Reward> queryByPersonCode(String personCode) {
      // TODO Auto-generated method stub
      return rewardMapper.selectByPersonCode(personCode);
    }
}