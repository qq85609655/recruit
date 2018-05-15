package com.csot.recruit.service.flow.interview;

import java.util.List;
import java.util.Map;

import com.csot.recruit.model.original.flow.interview.InterviewBook;
import com.csot.recruit.model.vo.InterviewBookVo;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface InterviewBookService {
    MiniRtn2Grid<InterviewBook> getGrid(MiniGridPageSort pageSort, String searchKey);

    InterviewBook getByPrimaryKey(String primaryKey);

    void create(InterviewBook interviewBook);

    void updateSelective(InterviewBook interviewBook);

    void remove(String primaryKey);

    String saveOrUpdate(SysUser sysUser,InterviewBookVo interviewBookVo) throws Exception;

    List<InterviewBook> selectInterviewBookListByMap(Map<String, Object> param);

    void batchUpdateInterviewBook(Map<String, Object> param);
}