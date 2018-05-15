package com.csot.recruit.service.impl.flow.employ;

import java.util.List;

import com.csot.recruit.dao.original.flow.employ.RemindMapper;
import com.csot.recruit.model.original.flow.employ.Remind;
import com.csot.recruit.model.original.flow.employ.RemindColumns;
import com.csot.recruit.model.original.flow.employ.RemindCriteria;
import com.csot.recruit.service.flow.employ.RemindService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("remindService")
public class RemindServiceImpl implements RemindService {
    private static final Logger logger = LoggerFactory.getLogger(RemindServiceImpl.class);

    @Resource
    private RemindMapper remindMapper;

    @Override
    public MiniRtn2Grid<Remind> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Remind> grid = new MiniRtn2Grid<Remind>();
        RemindCriteria criteria = new RemindCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = RemindColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(remindMapper.selectByExample(criteria));
        grid.setTotal(remindMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Remind getByPrimaryKey(String primaryKey) {
        return remindMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Remind remind) {
        remindMapper.insert(remind);
    }

    @Override
    public void updateSelective(Remind remind) {
        remindMapper.updateByPrimaryKeySelective(remind);
    }

    @Override
    public void remove(String primaryKey) {
        remindMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<Remind> getByUserAndDate(String id, String format) {
      RemindCriteria criteria=new RemindCriteria();
      criteria.createCriteria().andRemindUserEqualTo(id).andRemindDateEqualTo(format);
      return  remindMapper.selectByExample(criteria);
    }
}