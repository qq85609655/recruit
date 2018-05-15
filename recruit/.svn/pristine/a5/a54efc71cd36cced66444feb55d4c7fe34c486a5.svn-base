package com.csot.recruit.service.impl.resume;

import java.util.List;

import com.csot.recruit.dao.resume.WorkExperienceMapper;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.resume.WorkExperienceColumns;
import com.csot.recruit.model.resume.WorkExperienceCriteria;
import com.csot.recruit.service.resume.WorkExperienceService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("workExperienceService")
public class WorkExperienceServiceImpl implements WorkExperienceService {
    private static final Logger logger = LoggerFactory.getLogger(WorkExperienceServiceImpl.class);

    @Resource
    private WorkExperienceMapper workExperienceMapper;

    @Override
    public MiniRtn2Grid<WorkExperience> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<WorkExperience> grid = new MiniRtn2Grid<WorkExperience>();
        WorkExperienceCriteria criteria = new WorkExperienceCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = WorkExperienceColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(workExperienceMapper.selectByExample(criteria));
        grid.setTotal(workExperienceMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public WorkExperience getByPrimaryKey(String primaryKey) {
        return workExperienceMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(WorkExperience workExperience) {
        workExperienceMapper.insert(workExperience);
    }

    @Override
    public void updateSelective(WorkExperience workExperience) {
        workExperienceMapper.updateByPrimaryKeySelective(workExperience);
    }

    @Override
    public void remove(String primaryKey) {
        workExperienceMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<WorkExperience> queryByResumeId(String resumeId) {
      return workExperienceMapper.selectByResumeId(resumeId);
    }
    
    @Override
    public void deleteByResumeId(String resumeId) {
        workExperienceMapper.deleteByResumeId(resumeId);
    }
    
}