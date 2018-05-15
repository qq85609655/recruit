package com.csot.recruit.service.impl.uniform;

import com.csot.recruit.dao.original.uniform.JobMapper;
import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.original.uniform.JobColumns;
import com.csot.recruit.model.original.uniform.JobCriteria;
import com.csot.recruit.service.uniform.JobService;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("jobService")
public class JobServiceImpl implements JobService {
    private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    @Resource
    private JobMapper jobMapper;

    @Override
    public MiniRtn2Grid<Job> getGrid(MiniGridPageSort pageSort, String searchKey ,String orgCode) {
        MiniRtn2Grid<Job> grid = new MiniRtn2Grid<Job>();
        JobCriteria criteria = new JobCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andCJobnameLike("%"+searchKey+"%");
        }
        if (StringUtils.hasText(orgCode)) {
          criteria.createCriteria().andCOrgcodeEqualTo(orgCode);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = JobColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(jobMapper.selectByExample(criteria));
        grid.setTotal(jobMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Job getByPrimaryKey(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        return jobMapper.selectByPrimaryKey(pk);
    }

    @Override
    public void create(Job job) {
        jobMapper.insert(job);
    }

    @Override
    public void updateSelective(Job job) {
        jobMapper.updateByPrimaryKeySelective(job);
    }

    @Override
    public void remove(String primaryKey) {
        BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
        jobMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public Job selectByCode(String cJobcode) {
      // TODO Auto-generated method stub
      return jobMapper.selectByCode(cJobcode);
    }
}