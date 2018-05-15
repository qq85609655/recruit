package com.csot.recruit.service.impl.flow.interview;

import java.util.List;

import com.csot.recruit.dao.original.flow.interview.IbARalationMapper;
import com.csot.recruit.model.original.flow.interview.IbARalation;
import com.csot.recruit.model.original.flow.interview.IbARalationColumns;
import com.csot.recruit.model.original.flow.interview.IbARalationCriteria;
import com.csot.recruit.service.flow.interview.IbARalationService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("ibARalationService")
public class IbARalationServiceImpl implements IbARalationService {
    private static final Logger logger = LoggerFactory.getLogger(IbARalationServiceImpl.class);

    @Resource
    private IbARalationMapper ibARalationMapper;

    @Override
    public MiniRtn2Grid<IbARalation> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<IbARalation> grid = new MiniRtn2Grid<IbARalation>();
        IbARalationCriteria criteria = new IbARalationCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = IbARalationColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(ibARalationMapper.selectByExample(criteria));
        grid.setTotal(ibARalationMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public IbARalation getByPrimaryKey(String primaryKey) {
        return ibARalationMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(IbARalation ibARalation) {
        ibARalationMapper.insert(ibARalation);
    }

    @Override
    public void updateSelective(IbARalation ibARalation) {
        ibARalationMapper.updateByPrimaryKeySelective(ibARalation);
    }

    @Override
    public void remove(String primaryKey) {
        ibARalationMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<IbARalation> getListByInterviewBookId(String interviewBookId) {
      // TODO Auto-generated method stub
      return ibARalationMapper.getListByInterviewBookId(interviewBookId);
    }
}