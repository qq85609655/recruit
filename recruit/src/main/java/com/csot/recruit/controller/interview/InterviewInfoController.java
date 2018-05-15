package com.csot.recruit.controller.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.common.util.Pinyin4jUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.interview.InterviewInfo;
import com.csot.recruit.service.interview.InterviewInfoService;

@Controller
@RequestMapping("interviewInfoController")
public class InterviewInfoController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewInfoController.class);

    @Resource
    private InterviewInfoService interviewInfoService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/interview/interviewInfoList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<InterviewInfo> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return interviewInfoService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/interview/interviewInfoEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        InterviewInfo interviewInfo = interviewInfoService.getByPrimaryKey(id);
        request.setAttribute("interviewInfo", interviewInfo);
        return new ModelAndView("com/csot/recruit/interview/interviewInfoEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        InterviewInfo interviewInfo = interviewInfoService.getByPrimaryKey(id);
        request.setAttribute("interviewInfo", interviewInfo);
        return new ModelAndView("com/csot/recruit/interview/interviewInfoView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            interviewInfoService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(InterviewInfo interviewInfo) {
        if (StringUtils.hasText(interviewInfo.getId())) {
            try {
                interviewInfoService.updateSelective(interviewInfo);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                interviewInfo.setId(UUID.randomUUID().toString().replace("-", ""));
                interviewInfoService.create(interviewInfo);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    /***
     * 面试管理查询
     * @param page 分页对象
     * @param positionMana 查询对象
     * @return
     */
    @RequestMapping("queryInterviewListByPage")
    @ResponseBody
    public MiniRtn2Grid<InterviewInfo> queryInterviewListByPage(MiniGridPageSort page, HttpServletRequest request,@CurrentUser SysUser sysUser) {
        String startDate  = request.getParameter("startDate");
        String endDate  = request.getParameter("endDate");
        String searchKey  = request.getParameter("searchKey");
        String isAdmin  = request.getParameter("isAdmin");
        if(StringUtil.isEmpty(page.getSortField())) {
          page.setSortField("createtime");
          page.setSortOrder("desc");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtil.isNotEmpty(startDate)){
          map.put("startDate", startDate);
        }
        if(StringUtil.isNotEmpty(endDate)){
          map.put("endDate", endDate);
        }
        if(StringUtil.isNotEmpty(searchKey)){
          map.put("searchKey", searchKey);
        }
        Map<String,Object> pageMap = new HashMap<String, Object>();
        pageMap.put("begin", page.getPageSize()*(page.getPageIndex()));
        pageMap.put("end", page.getPageSize()*(page.getPageIndex()+1));
        map.put("page", pageMap);
        map.put("sortField", page.getSortField());
        map.put("sortOrder", page.getSortOrder());
        if(!"1".equals(isAdmin)){
          map.put("workCode", sysUser.getWorkCode());
        }
        MiniRtn2Grid<InterviewInfo> minirtn2Grid = interviewInfoService.queryInterviewListByPage(map);
        logger.info("data:" + minirtn2Grid.getData() + "total:"
                + minirtn2Grid.getTotal());
        return minirtn2Grid;
    }
    
}