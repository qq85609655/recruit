package com.csot.recruit.controller.log;

import com.csot.recruit.model.original.log.OperateHistory;
import com.csot.recruit.service.log.OperateHistoryService;
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
@RequestMapping("operateHistoryController")
public class OperateHistoryController {
    private static final Logger logger = LoggerFactory.getLogger(OperateHistoryController.class);

    @Resource
    private OperateHistoryService operateHistoryService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/log/operateHistoryList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<OperateHistory> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return operateHistoryService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/log/operateHistoryEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        OperateHistory operateHistory = operateHistoryService.getByPrimaryKey(id);
        request.setAttribute("operateHistory", operateHistory);
        return new ModelAndView("com/csot/recruit/log/operateHistoryEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        OperateHistory operateHistory = operateHistoryService.getByPrimaryKey(id);
        request.setAttribute("operateHistory", operateHistory);
        return new ModelAndView("com/csot/recruit/log/operateHistoryView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            operateHistoryService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(OperateHistory operateHistory) {
        if (StringUtils.hasText(operateHistory.getId())) {
            try {
                operateHistoryService.updateSelective(operateHistory);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                operateHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                operateHistoryService.create(operateHistory);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}