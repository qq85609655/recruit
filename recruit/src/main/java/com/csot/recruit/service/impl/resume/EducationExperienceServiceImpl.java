package com.csot.recruit.service.impl.resume;

import java.util.List;

import com.csot.recruit.dao.resume.EducationExperienceMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.EducationExperienceColumns;
import com.csot.recruit.model.resume.EducationExperienceCriteria;
import com.csot.recruit.service.resume.EducationExperienceService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("educationExperienceService")
public class EducationExperienceServiceImpl implements EducationExperienceService {
    private static final Logger logger = LoggerFactory.getLogger(EducationExperienceServiceImpl.class);

    @Resource
    private EducationExperienceMapper educationExperienceMapper;

    @Override
    public MiniRtn2Grid<EducationExperience> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<EducationExperience> grid = new MiniRtn2Grid<EducationExperience>();
        EducationExperienceCriteria criteria = new EducationExperienceCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EducationExperienceColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(educationExperienceMapper.selectByExample(criteria));
        grid.setTotal(educationExperienceMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public EducationExperience getByPrimaryKey(String primaryKey) {
        return educationExperienceMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(EducationExperience educationExperience) {
        educationExperienceMapper.insert(educationExperience);
    }

    @Override
    public void updateSelective(EducationExperience educationExperience) {
        educationExperienceMapper.updateByPrimaryKeySelective(educationExperience);
    }

    @Override
    public void remove(String primaryKey) {
        educationExperienceMapper.deleteByPrimaryKey(primaryKey);
    }
    
    @Override
    public void deleteByResumeId(String resumeId) {
        educationExperienceMapper.deleteByResumeId(resumeId);
    }

    @Override
    public List<EducationExperience> queryByResumeId(String resumeId) {
      List<EducationExperience> edus=educationExperienceMapper.selectByResumeId(resumeId);
      for(EducationExperience edu:edus){
        edu.setEducationName(DatadictGroup.getTypeNameByTypeCode(edu.getEducation(),"educational-background"));
        edu.setEduTypeName(DatadictGroup.getTypeNameByTypeCode(edu.getEduType(),"educational-type"));
      }
      return edus;
    }

}