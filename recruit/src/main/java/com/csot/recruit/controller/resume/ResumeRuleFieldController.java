package com.csot.recruit.controller.resume;

import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.resume.resumeRule.ResumeRuleField;
import com.csot.recruit.service.resume.ResumeRuleFieldService;

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

@Controller
@RequestMapping("resume/resumeRuleField")
public class ResumeRuleFieldController {
    private static final Logger logger = LoggerFactory.getLogger(ResumeRuleFieldController.class);

    @Resource
    private ResumeRuleFieldService resumeRuleFieldService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/resume/resumeRuleFieldList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<ResumeRuleField> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return resumeRuleFieldService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/resume/resumeRuleFieldEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        ResumeRuleField resumeRuleField = resumeRuleFieldService.getByPrimaryKey(id);
        request.setAttribute("resumeRuleField", resumeRuleField);
        return new ModelAndView("com/csot/recruit/resume/resumeRuleFieldEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        ResumeRuleField resumeRuleField = resumeRuleFieldService.getByPrimaryKey(id);
        request.setAttribute("resumeRuleField", resumeRuleField);
        return new ModelAndView("com/csot/recruit/resume/resumeRuleFieldView");
    }

    /**
     * 删除判重字段
     * @param id
     * @return
     */
    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            if(resumeRuleFieldService.isWork(id)) {
              return new AjaxRtnJson(false, "删除失败: 判重字段已被使用，请先删除规则！");
            }
            else {
              resumeRuleFieldService.remove(id);
              return new AjaxRtnJson(true, "删除成功");
            }
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(ResumeRuleField resumeRuleField, @CurrentUser SysUser sysUser) {
        if (StringUtils.hasText(resumeRuleField.getId())) {
            try {
                resumeRuleField.setModifyDate(DataUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
                if(StringUtil.isNotEmpty(sysUser.getWorkCode())) {
                  resumeRuleField.setModificator(sysUser.getWorkCode());
                }
                else {
                  resumeRuleField.setModificator(sysUser.getAccount());
                }
                resumeRuleFieldService.updateSelective(resumeRuleField);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                resumeRuleField.setId(UUID.randomUUID().toString().replace("-", ""));
                resumeRuleField.setCreateDate(DataUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
                if(StringUtil.isNotEmpty(sysUser.getWorkCode())) {
                  resumeRuleField.setCreator(sysUser.getWorkCode());
                }
                else {
                  resumeRuleField.setCreator(sysUser.getAccount());
                }
                resumeRuleFieldService.create(resumeRuleField);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}