package com.csot.recruit.controller.position;

import com.csot.recruit.model.position.RecruitInfor;
import com.csot.recruit.service.position.RecruitInforService;

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
@RequestMapping("recruitInforController")
public class RecruitInforController {
    private static final Logger logger = LoggerFactory.getLogger(RecruitInforController.class);

    @Resource
    private RecruitInforService recruitInforService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/position/recruitInforList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<RecruitInfor> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return recruitInforService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/position/recruitInforEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        RecruitInfor recruitInfor = recruitInforService.getByPrimaryKey(id);
        request.setAttribute("recruitInfor", recruitInfor);
        return new ModelAndView("com/csot/recruit/controller/position/recruitInforEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        RecruitInfor recruitInfor = recruitInforService.getByPrimaryKey(id);
        request.setAttribute("recruitInfor", recruitInfor);
        return new ModelAndView("com/csot/recruit/controller/position/recruitInforView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            recruitInforService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(RecruitInfor recruitInfor) {
        if (null != recruitInfor.getId()) {
            try {
                recruitInforService.updateSelective(recruitInfor);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                recruitInforService.create(recruitInfor);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}