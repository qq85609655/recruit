package com.csot.recruit.service.impl.resume;

import com.csot.recruit.dao.resume.LanguageSkillMapper;
import com.csot.recruit.model.resume.LanguageSkill;
import com.csot.recruit.model.resume.LanguageSkillColumns;
import com.csot.recruit.model.resume.LanguageSkillCriteria;
import com.csot.recruit.service.resume.LanguageSkillService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("resumeLanguageService")
public class LanguageSkillServiceImpl implements LanguageSkillService {
    private static final Logger logger = LoggerFactory.getLogger(LanguageSkillServiceImpl.class);

    @Resource
    private LanguageSkillMapper resumeLanguageMapper;

    @Override
    public MiniRtn2Grid<LanguageSkill> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<LanguageSkill> grid = new MiniRtn2Grid<LanguageSkill>();
        LanguageSkillCriteria criteria = new LanguageSkillCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = LanguageSkillColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(resumeLanguageMapper.selectByExample(criteria));
        grid.setTotal(resumeLanguageMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public LanguageSkill getByPrimaryKey(String primaryKey) {
        return resumeLanguageMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(LanguageSkill resumeLanguage) {
        resumeLanguageMapper.insert(resumeLanguage);
    }

    @Override
    public void updateSelective(LanguageSkill resumeLanguage) {
        resumeLanguageMapper.updateByPrimaryKeySelective(resumeLanguage);
    }

    @Override
    public void remove(String primaryKey) {
        resumeLanguageMapper.deleteByPrimaryKey(primaryKey);
    }
}