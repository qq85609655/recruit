package com.csot.recruit.service.impl.interview;

import java.util.List;

import com.csot.recruit.dao.original.interview.LanguageMapper;
import com.csot.recruit.model.original.interview.Language;
import com.csot.recruit.model.original.interview.LanguageColumns;
import com.csot.recruit.model.original.interview.LanguageCriteria;
import com.csot.recruit.service.interview.LanguageService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {
    private static final Logger logger = LoggerFactory.getLogger(LanguageServiceImpl.class);

    @Resource
    private LanguageMapper languageMapper;

    @Override
    public MiniRtn2Grid<Language> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Language> grid = new MiniRtn2Grid<Language>();
        LanguageCriteria criteria = new LanguageCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = LanguageColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(languageMapper.selectByExample(criteria));
        grid.setTotal(languageMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Language getByPrimaryKey(String primaryKey) {
        return languageMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Language language) {
        languageMapper.insert(language);
    }

    @Override
    public void updateSelective(Language language) {
        languageMapper.updateByPrimaryKeySelective(language);
    }

    @Override
    public void remove(String primaryKey) {
        languageMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<Language> queryByPersonCode(String personCode) {
      // TODO Auto-generated method stub
      return languageMapper.selectByPersonCode(personCode);
    }
}