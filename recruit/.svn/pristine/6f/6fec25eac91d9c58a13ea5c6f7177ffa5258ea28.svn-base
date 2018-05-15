package com.csot.recruit.controller.resume;

import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.service.resume.EducationExperienceService;

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
@RequestMapping("educationExperienceController")
public class EducationExperienceController {
    private static final Logger logger = LoggerFactory.getLogger(EducationExperienceController.class);

    @Resource
    private EducationExperienceService educationExperienceService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/resume/educationExperienceList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<EducationExperience> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return educationExperienceService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/resume/educationExperienceEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        EducationExperience educationExperience = educationExperienceService.getByPrimaryKey(id);
        request.setAttribute("educationExperience", educationExperience);
        return new ModelAndView("com/csot/recruit/controller/resume/educationExperienceEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        EducationExperience educationExperience = educationExperienceService.getByPrimaryKey(id);
        request.setAttribute("educationExperience", educationExperience);
        return new ModelAndView("com/csot/recruit/controller/resume/educationExperienceView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            educationExperienceService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(EducationExperience educationExperience) {
        if (StringUtils.hasText(educationExperience.getId())) {
            try {
                educationExperienceService.updateSelective(educationExperience);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                educationExperience.setId(UUID.randomUUID().toString().replace("-", ""));
                educationExperienceService.create(educationExperience);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}