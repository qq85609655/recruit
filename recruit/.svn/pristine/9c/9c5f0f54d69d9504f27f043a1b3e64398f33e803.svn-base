package com.csot.recruit.controller.position;

import com.csot.recruit.model.position.DepartmentRequire;
import com.csot.recruit.service.position.DepartmentRequireService;

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
@RequestMapping("departmentRequireController")
public class DepartmentRequireController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentRequireController.class);

    @Resource
    private DepartmentRequireService departmentRequireService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/position/departmentRequireList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<DepartmentRequire> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return departmentRequireService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/position/departmentRequireEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        DepartmentRequire departmentRequire = departmentRequireService.getByPrimaryKey(id);
        request.setAttribute("departmentRequire", departmentRequire);
        return new ModelAndView("com/csot/recruit/controller/position/departmentRequireEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        DepartmentRequire departmentRequire = departmentRequireService.getByPrimaryKey(id);
        request.setAttribute("departmentRequire", departmentRequire);
        return new ModelAndView("com/csot/recruit/controller/position/departmentRequireView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            departmentRequireService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(DepartmentRequire departmentRequire) {
        if (null != departmentRequire.getId()) {
            try {
                departmentRequireService.updateSelective(departmentRequire);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                departmentRequireService.create(departmentRequire);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}