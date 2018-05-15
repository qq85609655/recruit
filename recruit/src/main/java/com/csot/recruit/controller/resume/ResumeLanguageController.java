package com.csot.recruit.controller.resume;

import com.csot.recruit.model.resume.LanguageSkill;
import com.csot.recruit.service.resume.LanguageSkillService;

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
@RequestMapping("resumeLanguageController")
public class ResumeLanguageController {
    private static final Logger logger = LoggerFactory.getLogger(ResumeLanguageController.class);

    @Resource
    private LanguageSkillService resumeLanguageService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/resume/resumeLanguageList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<LanguageSkill> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return resumeLanguageService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/resume/resumeLanguageEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        LanguageSkill resumeLanguage = resumeLanguageService.getByPrimaryKey(id);
        request.setAttribute("resumeLanguage", resumeLanguage);
        return new ModelAndView("com/csot/recruit/controller/resume/resumeLanguageEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        LanguageSkill resumeLanguage = resumeLanguageService.getByPrimaryKey(id);
        request.setAttribute("resumeLanguage", resumeLanguage);
        return new ModelAndView("com/csot/recruit/controller/resume/resumeLanguageView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            resumeLanguageService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(LanguageSkill resumeLanguage) {
        if (StringUtils.hasText(resumeLanguage.getId())) {
            try {
                resumeLanguageService.updateSelective(resumeLanguage);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                resumeLanguage.setId(UUID.randomUUID().toString().replace("-", ""));
                resumeLanguageService.create(resumeLanguage);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}