package com.csot.recruit.controller.flow.interview;

import com.csot.recruit.model.original.flow.interview.IbARalation;
import com.csot.recruit.service.flow.interview.IbARalationService;
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
@RequestMapping("ibARalationController")
public class IbARalationController {
    private static final Logger logger = LoggerFactory.getLogger(IbARalationController.class);

    @Resource
    private IbARalationService ibARalationService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/interview/ibARalationList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<IbARalation> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return ibARalationService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/interview/ibARalationEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        IbARalation ibARalation = ibARalationService.getByPrimaryKey(id);
        request.setAttribute("ibARalation", ibARalation);
        return new ModelAndView("com/csot/recruit/flow/interview/ibARalationEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        IbARalation ibARalation = ibARalationService.getByPrimaryKey(id);
        request.setAttribute("ibARalation", ibARalation);
        return new ModelAndView("com/csot/recruit/flow/interview/ibARalationView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            ibARalationService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(IbARalation ibARalation) {
        if (StringUtils.hasText(ibARalation.getId())) {
            try {
                ibARalationService.updateSelective(ibARalation);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                ibARalation.setId(UUID.randomUUID().toString().replace("-", ""));
                ibARalationService.create(ibARalation);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}