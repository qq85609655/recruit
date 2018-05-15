package com.csot.recruit.service.flow.interview;

import java.util.Map;

import com.csot.recruit.model.original.flow.interview.Feedback;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface FeedbackService {
    MiniRtn2Grid<Feedback> getGrid(MiniGridPageSort pageSort, String searchKey);

    Feedback getByPrimaryKey(String primaryKey);

    void create(Feedback feedback);

    void updateSelective(Feedback feedback);

    void remove(String primaryKey);

    void removeByInterviewIds(Map<String, Object> param);

    Feedback getByInterviewBookId(String interviewBookId);
}