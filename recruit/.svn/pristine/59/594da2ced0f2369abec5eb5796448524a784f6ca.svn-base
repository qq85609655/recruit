package com.csot.recruit.controller.flow.employ;

import com.csot.recruit.model.original.flow.employ.Remind;
import com.csot.recruit.service.flow.employ.RemindService;

import java.util.Date;
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
@RequestMapping("remind")
public class RemindController {
    private static final Logger logger = LoggerFactory.getLogger(RemindController.class);

    @Resource
    private RemindService remindService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/employ/remindList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Remind> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return remindService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/flow/employ/remindEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Remind remind = remindService.getByPrimaryKey(id);
        request.setAttribute("remind", remind);
        return new ModelAndView("com/csot/recruit/flow/employ/remindEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Remind remind = remindService.getByPrimaryKey(id);
        request.setAttribute("remind", remind);
        return new ModelAndView("com/csot/recruit/flow/employ/remindView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            remindService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Remind remind,@CurrentUser SysUser sysUser) {
        if (StringUtils.hasText(remind.getId())) {
            try {
                remindService.updateSelective(remind);
                return new AjaxRtnJson(true, "修改日程提醒成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改日程提醒失败: " + e.getMessage());
            }
        } else {
            try {
                remind.setId(UUID.randomUUID().toString().replace("-", ""));
                remind.setCreatorId(sysUser.getId());
                remind.setCreateDate(new Date());
                remind.setRemindUser(sysUser.getId());
                remind.setRemindUserName(sysUser.getAccount());
                remindService.create(remind);
                return new AjaxRtnJson(true, "新建日程提醒成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建日程提醒失败: " + e.getMessage());
            }
        }
    }
}