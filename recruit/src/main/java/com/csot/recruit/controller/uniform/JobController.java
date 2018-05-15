package com.csot.recruit.controller.uniform;

import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.service.uniform.JobService;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jobController")
public class JobController {
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @Resource
    private JobService jobService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/uniform/jobList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Job> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        String orgCode = request.getParameter("orgCode");
        return jobService.getGrid(pageSort, searchKey, orgCode);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/uniform/jobEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Job job = jobService.getByPrimaryKey(id);
        request.setAttribute("job", job);
        return new ModelAndView("com/csot/recruit/uniform/jobEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Job job = jobService.getByPrimaryKey(id);
        request.setAttribute("job", job);
        return new ModelAndView("com/csot/recruit/uniform/jobView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            jobService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Job job) {
        if (null != job.getId()) {
            try {
                jobService.updateSelective(job);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                jobService.create(job);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("toSelectPage")
    public ModelAndView toSelectPage() {
        return new ModelAndView("com/csot/uniform/orgAndJob");
    }
    @RequestMapping("toChangePage")
    public ModelAndView toChangePage(String id) {
        return new ModelAndView("com/csot/candidate/changeJob").addObject("id", id);
    }
}