package com.csot.recruit.controller.interview;

import com.csot.recruit.model.original.interview.EmergentContacts;
import com.csot.recruit.service.interview.EmergentContactsService;
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
@RequestMapping("emergentContactsController")
public class EmergentContactsController {
    private static final Logger logger = LoggerFactory.getLogger(EmergentContactsController.class);

    @Resource
    private EmergentContactsService emergentContactsService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/interview/emergentContactsList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<EmergentContacts> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return emergentContactsService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/interview/emergentContactsEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        EmergentContacts emergentContacts = emergentContactsService.getByPrimaryKey(id);
        request.setAttribute("emergentContacts", emergentContacts);
        return new ModelAndView("com/csot/recruit/interview/emergentContactsEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        EmergentContacts emergentContacts = emergentContactsService.getByPrimaryKey(id);
        request.setAttribute("emergentContacts", emergentContacts);
        return new ModelAndView("com/csot/recruit/interview/emergentContactsView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            emergentContactsService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(EmergentContacts emergentContacts) {
        if (StringUtils.hasText(emergentContacts.getId())) {
            try {
                emergentContactsService.updateSelective(emergentContacts);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                emergentContacts.setId(UUID.randomUUID().toString().replace("-", ""));
                emergentContactsService.create(emergentContacts);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}