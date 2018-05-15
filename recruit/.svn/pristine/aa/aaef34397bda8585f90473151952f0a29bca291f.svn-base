package com.csot.recruit.service.impl.log;

import java.util.List;

import com.csot.recruit.dao.original.log.OperateHistoryMapper;
import com.csot.recruit.model.original.log.OperateHistory;
import com.csot.recruit.model.original.log.OperateHistoryColumns;
import com.csot.recruit.model.original.log.OperateHistoryCriteria;
import com.csot.recruit.service.log.OperateHistoryService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("operateHistoryService")
public class OperateHistoryServiceImpl implements OperateHistoryService {
    private static final Logger logger = LoggerFactory.getLogger(OperateHistoryServiceImpl.class);

    @Resource
    private OperateHistoryMapper operateHistoryMapper;

    @Override
    public MiniRtn2Grid<OperateHistory> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<OperateHistory> grid = new MiniRtn2Grid<OperateHistory>();
        OperateHistoryCriteria criteria = new OperateHistoryCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = OperateHistoryColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(operateHistoryMapper.selectByExample(criteria));
        grid.setTotal(operateHistoryMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public OperateHistory getByPrimaryKey(String primaryKey) {
        return operateHistoryMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(OperateHistory operateHistory) {
        operateHistoryMapper.insert(operateHistory);
    }

    @Override
    public void updateSelective(OperateHistory operateHistory) {
        operateHistoryMapper.updateByPrimaryKeySelective(operateHistory);
    }

    @Override
    public void remove(String primaryKey) {
        operateHistoryMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<OperateHistory> getOperateHistoryListByCandidateId(String id) {
      // TODO Auto-generated method stub
      return operateHistoryMapper.selectOperateHistoryListBycandidateId(id);
    }
}