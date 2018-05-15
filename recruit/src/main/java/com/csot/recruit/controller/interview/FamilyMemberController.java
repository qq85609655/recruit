package com.csot.recruit.controller.interview;

import com.csot.recruit.model.original.interview.FamilyMember;
import com.csot.recruit.service.interview.FamilyMemberService;
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
@RequestMapping("familyMemberController")
public class FamilyMemberController {
    private static final Logger logger = LoggerFactory.getLogger(FamilyMemberController.class);

    @Resource
    private FamilyMemberService familyMemberService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/interview/familyMemberList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<FamilyMember> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return familyMemberService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/interview/familyMemberEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        FamilyMember familyMember = familyMemberService.getByPrimaryKey(id);
        request.setAttribute("familyMember", familyMember);
        return new ModelAndView("com/csot/recruit/interview/familyMemberEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        FamilyMember familyMember = familyMemberService.getByPrimaryKey(id);
        request.setAttribute("familyMember", familyMember);
        return new ModelAndView("com/csot/recruit/interview/familyMemberView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            familyMemberService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(FamilyMember familyMember) {
        if (StringUtils.hasText(familyMember.getId())) {
            try {
                familyMemberService.updateSelective(familyMember);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                familyMember.setId(UUID.randomUUID().toString().replace("-", ""));
                familyMemberService.create(familyMember);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}