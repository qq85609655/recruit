package com.csot.recruit.controller.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployEducation;
import com.csot.recruit.service.flow.employ.EmployEducationService;
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
@RequestMapping("employEducationController")
public class EmployEducationController {
    private static final Logger logger = LoggerFactory.getLogger(EmployEducationController.class);

    @Resource
    private EmployEducationService employEducationService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/employ/employEducationList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<EmployEducation> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return employEducationService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/employ/employEducationEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        EmployEducation employEducation = employEducationService.getByPrimaryKey(id);
        request.setAttribute("employEducation", employEducation);
        return new ModelAndView("com/csot/recruit/flow/employ/employEducationEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        EmployEducation employEducation = employEducationService.getByPrimaryKey(id);
        request.setAttribute("employEducation", employEducation);
        return new ModelAndView("com/csot/recruit/flow/employ/employEducationView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            employEducationService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(EmployEducation employEducation) {
        if (StringUtils.hasText(employEducation.getId())) {
            try {
                employEducationService.updateSelective(employEducation);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                employEducation.setId(UUID.randomUUID().toString().replace("-", ""));
                employEducationService.create(employEducation);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}