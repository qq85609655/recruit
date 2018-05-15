package com.csot.recruit.service.impl.flow.interview;

import java.util.Map;

import com.csot.recruit.dao.original.flow.interview.FeedbackMapper;
import com.csot.recruit.model.original.flow.interview.Feedback;
import com.csot.recruit.model.original.flow.interview.FeedbackColumns;
import com.csot.recruit.model.original.flow.interview.FeedbackCriteria;
import com.csot.recruit.service.flow.interview.FeedbackService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public MiniRtn2Grid<Feedback> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Feedback> grid = new MiniRtn2Grid<Feedback>();
        FeedbackCriteria criteria = new FeedbackCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = FeedbackColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(feedbackMapper.selectByExample(criteria));
        grid.setTotal(feedbackMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Feedback getByPrimaryKey(String primaryKey) {
        return feedbackMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Feedback feedback) {
        feedbackMapper.insert(feedback);
    }

    @Override
    public void updateSelective(Feedback feedback) {
        feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public void remove(String primaryKey) {
        feedbackMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public void removeByInterviewIds(Map<String, Object> param) {
      feedbackMapper.deleteByInterviewIds(param);
    }

    @Override
    public Feedback getByInterviewBookId(String interviewBookId) {
      // TODO Auto-generated method stub
      return feedbackMapper.selectByInterviewBookId(interviewBookId);
    }
}