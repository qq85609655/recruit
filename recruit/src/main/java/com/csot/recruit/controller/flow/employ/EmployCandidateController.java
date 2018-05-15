package com.csot.recruit.controller.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployCandidate;
import com.csot.recruit.service.flow.employ.EmployCandidateService;
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
@RequestMapping("employCandidateController")
public class EmployCandidateController {
    private static final Logger logger = LoggerFactory.getLogger(EmployCandidateController.class);

    @Resource
    private EmployCandidateService employCandidateService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/employ/employCandidateList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<EmployCandidate> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return employCandidateService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/employ/employCandidateEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        EmployCandidate employCandidate = employCandidateService.getByPrimaryKey(id);
        request.setAttribute("employCandidate", employCandidate);
        return new ModelAndView("com/csot/recruit/flow/employ/employCandidateEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        EmployCandidate employCandidate = employCandidateService.getByPrimaryKey(id);
        request.setAttribute("employCandidate", employCandidate);
        return new ModelAndView("com/csot/recruit/flow/employ/employCandidateView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            employCandidateService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(EmployCandidate employCandidate) {
        if (StringUtils.hasText(employCandidate.getId())) {
            try {
                employCandidateService.updateSelective(employCandidate);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                employCandidate.setId(UUID.randomUUID().toString().replace("-", ""));
                employCandidateService.create(employCandidate);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}