package com.csot.recruit.controller.resume;

import com.csot.recruit.model.resume.WorkIntention;
import com.csot.recruit.service.resume.WorkIntentionService;

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
@RequestMapping("workIntentionController")
public class WorkIntentionController {
    private static final Logger logger = LoggerFactory.getLogger(WorkIntentionController.class);

    @Resource
    private WorkIntentionService workIntentionService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/resume/workIntentionList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<WorkIntention> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return workIntentionService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/resume/workIntentionEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        WorkIntention workIntention = workIntentionService.getByPrimaryKey(id);
        request.setAttribute("workIntention", workIntention);
        return new ModelAndView("com/csot/recruit/controller/resume/workIntentionEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        WorkIntention workIntention = workIntentionService.getByPrimaryKey(id);
        request.setAttribute("workIntention", workIntention);
        return new ModelAndView("com/csot/recruit/controller/resume/workIntentionView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            workIntentionService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(WorkIntention workIntention) {
        if (StringUtils.hasText(workIntention.getId())) {
            try {
                workIntentionService.updateSelective(workIntention);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                workIntention.setId(UUID.randomUUID().toString().replace("-", ""));
                workIntentionService.create(workIntention);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}