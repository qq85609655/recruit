package com.csot.recruit.controller.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployARalation;
import com.csot.recruit.service.flow.employ.EmployARalationService;
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
@RequestMapping("employARalationController")
public class EmployARalationController {
    private static final Logger logger = LoggerFactory.getLogger(EmployARalationController.class);

    @Resource
    private EmployARalationService employARalationService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/employ/employARalationList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<EmployARalation> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return employARalationService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/employ/employARalationEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        EmployARalation employARalation = employARalationService.getByPrimaryKey(id);
        request.setAttribute("employARalation", employARalation);
        return new ModelAndView("com/csot/recruit/flow/employ/employARalationEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        EmployARalation employARalation = employARalationService.getByPrimaryKey(id);
        request.setAttribute("employARalation", employARalation);
        return new ModelAndView("com/csot/recruit/flow/employ/employARalationView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            employARalationService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(EmployARalation employARalation) {
        if (StringUtils.hasText(employARalation.getId())) {
            try {
                employARalationService.updateSelective(employARalation);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                employARalation.setId(UUID.randomUUID().toString().replace("-", ""));
                employARalationService.create(employARalation);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}