package com.csot.recruit.controller.interview;

import com.csot.recruit.model.original.interview.Illustrate;
import com.csot.recruit.service.interview.IllustrateService;
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
@RequestMapping("illustrateController")
public class IllustrateController {
    private static final Logger logger = LoggerFactory.getLogger(IllustrateController.class);

    @Resource
    private IllustrateService illustrateService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/interview/illustrateList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Illustrate> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return illustrateService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/interview/illustrateEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Illustrate illustrate = illustrateService.getByPrimaryKey(id);
        request.setAttribute("illustrate", illustrate);
        return new ModelAndView("com/csot/recruit/interview/illustrateEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Illustrate illustrate = illustrateService.getByPrimaryKey(id);
        request.setAttribute("illustrate", illustrate);
        return new ModelAndView("com/csot/recruit/interview/illustrateView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            illustrateService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Illustrate illustrate) {
        if (StringUtils.hasText(illustrate.getId())) {
            try {
                illustrateService.updateSelective(illustrate);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                illustrate.setId(UUID.randomUUID().toString().replace("-", ""));
                illustrateService.create(illustrate);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}