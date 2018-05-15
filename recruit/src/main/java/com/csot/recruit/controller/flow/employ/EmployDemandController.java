package com.csot.recruit.controller.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployDemand;
import com.csot.recruit.service.flow.employ.EmployDemandService;
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
@RequestMapping("employDemandController")
public class EmployDemandController {
    private static final Logger logger = LoggerFactory.getLogger(EmployDemandController.class);

    @Resource
    private EmployDemandService employDemandService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/employ/employDemandList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<EmployDemand> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return employDemandService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/employ/employDemandEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        EmployDemand employDemand = employDemandService.getByPrimaryKey(id);
        request.setAttribute("employDemand", employDemand);
        return new ModelAndView("com/csot/recruit/flow/employ/employDemandEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        EmployDemand employDemand = employDemandService.getByPrimaryKey(id);
        request.setAttribute("employDemand", employDemand);
        return new ModelAndView("com/csot/recruit/flow/employ/employDemandView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            employDemandService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(EmployDemand employDemand) {
        if (StringUtils.hasText(employDemand.getId())) {
            try {
                employDemandService.updateSelective(employDemand);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                employDemand.setId(UUID.randomUUID().toString().replace("-", ""));
                employDemandService.create(employDemand);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}