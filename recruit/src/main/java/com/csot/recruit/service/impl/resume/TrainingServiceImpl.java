package com.csot.recruit.service.impl.resume;

import com.csot.recruit.dao.resume.TrainingMapper;
import com.csot.recruit.model.nresume.Training;
import com.csot.recruit.model.resume.TrainingColumns;
import com.csot.recruit.model.resume.TrainingCriteria;
import com.csot.recruit.service.resume.TrainingService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("trainingService")
public class TrainingServiceImpl implements TrainingService {
    private static final Logger logger = LoggerFactory.getLogger(TrainingServiceImpl.class);

    @Resource
    private TrainingMapper trainingMapper;

    @Override
    public MiniRtn2Grid<Training> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Training> grid = new MiniRtn2Grid<Training>();
        TrainingCriteria criteria = new TrainingCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = TrainingColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(trainingMapper.selectByExample(criteria));
        grid.setTotal(trainingMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Training getByPrimaryKey(String primaryKey) {
        return trainingMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Training training) {
        trainingMapper.insert(training);
    }

    @Override
    public void updateSelective(Training training) {
        trainingMapper.updateByPrimaryKeySelective(training);
    }

    @Override
    public void remove(String primaryKey) {
        trainingMapper.deleteByPrimaryKey(primaryKey);
    }
}