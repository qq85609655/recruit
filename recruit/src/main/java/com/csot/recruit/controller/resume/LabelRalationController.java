package com.csot.recruit.controller.resume;

import com.csot.recruit.model.original.resume.LabelRalation;
import com.csot.recruit.service.resume.LabelRalationService;
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
@RequestMapping("labelRalationController")
public class LabelRalationController {
    private static final Logger logger = LoggerFactory.getLogger(LabelRalationController.class);

    @Resource
    private LabelRalationService labelRalationService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/resume/labelRalationList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<LabelRalation> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return labelRalationService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/resume/labelRalationEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        LabelRalation labelRalation = labelRalationService.getByPrimaryKey(id);
        request.setAttribute("labelRalation", labelRalation);
        return new ModelAndView("com/csot/recruit/resume/labelRalationEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        LabelRalation labelRalation = labelRalationService.getByPrimaryKey(id);
        request.setAttribute("labelRalation", labelRalation);
        return new ModelAndView("com/csot/recruit/resume/labelRalationView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            labelRalationService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(LabelRalation labelRalation) {
        if (StringUtils.hasText(labelRalation.getId())) {
            try {
                labelRalationService.updateSelective(labelRalation);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                labelRalation.setId(UUID.randomUUID().toString().replace("-", ""));
                labelRalationService.create(labelRalation);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}