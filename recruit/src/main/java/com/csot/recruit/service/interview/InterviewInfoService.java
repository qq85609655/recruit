package com.csot.recruit.service.interview;

import java.util.Map;

import com.csot.recruit.model.original.interview.InterviewInfo;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface InterviewInfoService {
    MiniRtn2Grid<InterviewInfo> getGrid(MiniGridPageSort pageSort, String searchKey);

    InterviewInfo getByPrimaryKey(String primaryKey);

    void create(InterviewInfo interviewInfo);

    void updateSelective(InterviewInfo interviewInfo);

    void remove(String primaryKey);
    
    String getUserNameByAccount(String account);
    
    MiniRtn2Grid<InterviewInfo> queryInterviewListByPage(Map<String,Object> map);
    
    String getPersonCode();

    InterviewInfo getByPersonCode(String personCode);
}