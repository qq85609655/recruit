package com.csot.recruit.service.impl.log;

import com.csot.recruit.dao.log.LogMapper;
import com.csot.recruit.model.log.Log;
import com.csot.recruit.model.log.LogColumns;
import com.csot.recruit.model.log.LogCriteria;
import com.csot.recruit.service.log.LogService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("logService")
public class LogServiceImpl implements LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Resource
    private LogMapper logMapper;

    @Override
    public MiniRtn2Grid<Log> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Log> grid = new MiniRtn2Grid<Log>();
        LogCriteria criteria = new LogCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andLogidEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = LogColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(logMapper.selectByExample(criteria));
        grid.setTotal(logMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Log getByPrimaryKey(String primaryKey) {
        return logMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Log log) {
        logMapper.insert(log);
    }

    @Override
    public void updateSelective(Log log) {
        logMapper.updateByPrimaryKeySelective(log);
    }

    @Override
    public void remove(String primaryKey) {
        logMapper.deleteByPrimaryKey(primaryKey);
    }
}