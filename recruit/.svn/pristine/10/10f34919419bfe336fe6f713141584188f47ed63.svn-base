package com.csot.recruit.controller.resume;

import com.csot.recruit.model.nresume.Certification;
import com.csot.recruit.service.resume.CertificationService;

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
@RequestMapping("certificationController")
public class CertificationController {
    private static final Logger logger = LoggerFactory.getLogger(CertificationController.class);

    @Resource
    private CertificationService certificationService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/resume/certification/certificationList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Certification> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return certificationService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/resume/certification/certificationEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Certification certification = certificationService.getByPrimaryKey(id);
        request.setAttribute("certification", certification);
        return new ModelAndView("com/csot/recruit/resume/certification/certificationEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Certification certification = certificationService.getByPrimaryKey(id);
        request.setAttribute("certification", certification);
        return new ModelAndView("com/csot/recruit/resume/certification/certificationView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            certificationService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Certification certification) {
        if (StringUtils.hasText(certification.getId())) {
            try {
                certificationService.updateSelective(certification);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                certification.setId(UUID.randomUUID().toString().replace("-", ""));
                certificationService.create(certification);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}