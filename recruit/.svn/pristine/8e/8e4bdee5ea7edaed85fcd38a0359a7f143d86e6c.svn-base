package com.csot.recruit.service.impl.resume;

import java.util.List;

import com.csot.recruit.dao.resume.ResumeRuleFieldMapper;
import com.csot.recruit.model.resume.resumeRule.ResumeRule;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleField;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleFieldColumns;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleFieldCriteria;
import com.csot.recruit.service.resume.ResumeRuleFieldService;
import com.csot.recruit.service.resume.ResumeRuleService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("resumeRuleFieldService")
public class ResumeRuleFieldServiceImpl implements ResumeRuleFieldService {
    private static final Logger logger = LoggerFactory.getLogger(ResumeRuleFieldServiceImpl.class);

    @Resource
    private ResumeRuleFieldMapper resumeRuleFieldMapper;

    @Resource
    private ResumeRuleService resumeRuleService;
    
    @Override
    public MiniRtn2Grid<ResumeRuleField> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<ResumeRuleField> grid = new MiniRtn2Grid<ResumeRuleField>();
        ResumeRuleFieldCriteria criteria = new ResumeRuleFieldCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = ResumeRuleFieldColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(resumeRuleFieldMapper.selectByExample(criteria));
        grid.setTotal(resumeRuleFieldMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public ResumeRuleField getByPrimaryKey(String primaryKey) {
        return resumeRuleFieldMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(ResumeRuleField resumeRuleField) {
        resumeRuleFieldMapper.insert(resumeRuleField);
    }

    @Override
    public void updateSelective(ResumeRuleField resumeRuleField) {
        resumeRuleFieldMapper.updateByPrimaryKeySelective(resumeRuleField);
    }

    @Override
    public void remove(String primaryKey) {
        resumeRuleFieldMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public boolean isWork(String primaryKey) {
      List<ResumeRule> rules = resumeRuleService.selectContainField(primaryKey);
      if(null != rules && rules.size() > 0) {
        return true;
      }
      else {
        return false;
      }
    }
}