package com.csot.recruit.controller.org;

import com.csot.recruit.model.org.Organazation;
import com.csot.recruit.service.org.OrganazationService;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("org")
public class OrganazationController {
    private static final Logger logger = LoggerFactory.getLogger(OrganazationController.class);

    @Resource
    private OrganazationService organazationService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/org/organazationList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public List<Organazation> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        pageSort.setPageSize(999);
        return organazationService.getGrid(pageSort, searchKey).getData();
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/org/organazationEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Organazation organazation = organazationService.getByPrimaryKey(id);
        request.setAttribute("organazation", organazation);
        return new ModelAndView("com/csot/recruit/controller/org/organazationEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Organazation organazation = organazationService.getByPrimaryKey(id);
        request.setAttribute("organazation", organazation);
        return new ModelAndView("com/csot/recruit/controller/org/organazationView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            organazationService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(@RequestBody Organazation organazation) {
        if (StringUtils.hasText(organazation.getId())) {
            try {
                organazationService.updateSelective(organazation);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                organazation.setId(UUID.randomUUID().toString().replace("-", ""));
                organazationService.create(organazation);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("queryUserByOrg/{id}")
    @ResponseBody
    public AjaxRtnJson queryUserByOrg(@PathVariable String id) {
        try {
          Organazation org = organazationService.queryOrgAndUser(id);
          AjaxRtnJson msg = new AjaxRtnJson(true, "查询成功");
          msg.setObj(org);
          return msg;
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "查询失败: " + e.getMessage());
        }
    }
}