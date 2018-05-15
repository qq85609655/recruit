package com.csot.recruit.service.impl.resume;

import java.util.List;

import com.csot.recruit.dao.resume.ResumeRuleMapper;
import com.csot.recruit.model.resume.resumeRule.ResumeRule;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleColumns;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleCriteria;
import com.csot.recruit.service.resume.ResumeRuleService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("resumeRuleService")
public class ResumeRuleServiceImpl implements ResumeRuleService {
    private static final Logger logger = LoggerFactory.getLogger(ResumeRuleServiceImpl.class);

    @Resource
    private ResumeRuleMapper resumeRuleMapper;

    @Override
    public MiniRtn2Grid<ResumeRule> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<ResumeRule> grid = new MiniRtn2Grid<ResumeRule>();
        ResumeRuleCriteria criteria = new ResumeRuleCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = ResumeRuleColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(resumeRuleMapper.selectByExample(criteria));
        grid.setTotal(resumeRuleMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public ResumeRule getByPrimaryKey(String primaryKey) {
        return resumeRuleMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(ResumeRule resumeRule) {
        resumeRuleMapper.insert(resumeRule);
    }

    @Override
    public void updateSelective(ResumeRule resumeRule) {
        resumeRuleMapper.updateByPrimaryKeySelective(resumeRule);
    }

    @Override
    public void remove(String primaryKey) {
        resumeRuleMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<ResumeRule> selectAll() {
      List<ResumeRule> rules = resumeRuleMapper.selectAll();
      return rules;
    }

    @Override
    public List<ResumeRule> selectContainField(String fieldId) {
      return resumeRuleMapper.selectContainField(fieldId);
    }
}