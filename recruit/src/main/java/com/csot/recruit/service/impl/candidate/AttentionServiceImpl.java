package com.csot.recruit.service.impl.candidate;

import java.util.Map;

import com.csot.recruit.dao.original.candidate.AttentionMapper;
import com.csot.recruit.model.original.candidate.Attention;
import com.csot.recruit.model.original.candidate.AttentionColumns;
import com.csot.recruit.model.original.candidate.AttentionCriteria;
import com.csot.recruit.service.candidate.AttentionService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("attentionService")
public class AttentionServiceImpl implements AttentionService {
    private static final Logger logger = LoggerFactory.getLogger(AttentionServiceImpl.class);

    @Resource
    private AttentionMapper attentionMapper;

    @Override
    public MiniRtn2Grid<Attention> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Attention> grid = new MiniRtn2Grid<Attention>();
        AttentionCriteria criteria = new AttentionCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = AttentionColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(attentionMapper.selectByExample(criteria));
        grid.setTotal(attentionMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Attention getByPrimaryKey(String primaryKey) {
        return attentionMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Attention attention) {
        attentionMapper.insert(attention);
    }

    @Override
    public void updateSelective(Attention attention) {
        attentionMapper.updateByPrimaryKeySelective(attention);
    }

    @Override
    public void remove(String primaryKey) {
        attentionMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public Attention getAttentionByMap(Map<String, Object> param) {
      return attentionMapper.selectAttentionByMap(param);
    }

    @Override
    public void batchRemove(Map<String, Object> param) {
      attentionMapper.batchDelete(param);
      
    }
}