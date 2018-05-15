package com.csot.recruit.controller.resume;

import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.resume.resumeRule.ResumeRule;
import com.csot.recruit.service.resume.ResumeRuleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("resume/resumeRule")
public class ResumeRuleController {
    private static final Logger logger = LoggerFactory.getLogger(ResumeRuleController.class);

    @Resource
    private ResumeRuleService resumeRuleService;

    @RequestMapping("main")
    public ModelAndView list(HttpServletRequest request) {
        PropertiesUtil p = new PropertiesUtil();
        int line = Integer.parseInt(p.readProperty("passLine"));
        request.setAttribute("passLine", line);
        return new ModelAndView("com/csot/resume/resumeRule");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<ResumeRule> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return resumeRuleService.getGrid(pageSort, searchKey);
    }
    
    @RequestMapping("queryAll")
    @ResponseBody
    public MiniRtn2Grid<Map<String,Object>> queryAll(HttpServletRequest request) {
        MiniRtn2Grid<Map<String,Object>> grid = new MiniRtn2Grid<Map<String,Object>>();
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        List<ResumeRule> list = resumeRuleService.selectAll();
        PropertiesUtil p = new PropertiesUtil();
        int fieldNum = Integer.parseInt(p.readProperty("ruleFieldNum"));
        int totalScore = 0;
        for(ResumeRule rule : list) {
          totalScore = 0;
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("id", rule.getId());
          for(int i = 1; i <= fieldNum; i++) {
            if(null != rule.getResumeRuleFields() && rule.getResumeRuleFields().size() >= i) {
              map.put("field" + i + "_name", rule.getResumeRuleFields().get(i-1).getFieldName());
              map.put("field" + i + "_score", rule.getResumeRuleFields().get(i-1).getScore());
              if(null != rule.getResumeRuleFields().get(i-1).getScore()) {
                totalScore += Integer.parseInt(rule.getResumeRuleFields().get(i-1).getScore());
              }
            }
            else {
              map.put("field" + i + "_name", "");
              map.put("field" + i + "_score", "");
            }
            map.put("total_score", totalScore);
          }
          data.add(map);
        }
        grid.setData(data);
        grid.setTotal(data.size());
        return grid;
  }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/resume/resumeRuleEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        ResumeRule resumeRule = resumeRuleService.getByPrimaryKey(id);
        request.setAttribute("resumeRule", resumeRule);
        return new ModelAndView("com/csot/recruit/resume/resumeRuleEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        ResumeRule resumeRule = resumeRuleService.getByPrimaryKey(id);
        request.setAttribute("resumeRule", resumeRule);
        return new ModelAndView("com/csot/recruit/resume/resumeRuleView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            resumeRuleService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }
    
    @RequestMapping("lineSave/{line}")
    @ResponseBody
    public AjaxRtnJson lineSave(@PathVariable String line, HttpServletRequest request) {
     if(PropertiesUtil.writeProperty("passLine", line)) {
       return new AjaxRtnJson(true, "保存成功");
     }
     else {
       return new AjaxRtnJson(false, "保存失败");
     }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(ResumeRule resumeRule, @CurrentUser SysUser sysUser) {
        if (StringUtils.hasText(resumeRule.getId())) {
            try {
                if(StringUtil.isNotEmpty(sysUser.getWorkCode())) {
                  resumeRule.setModificator(sysUser.getWorkCode());
                }
                else {
                  resumeRule.setModificator(sysUser.getAccount());
                }
                resumeRule.setModifyDate(DataUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
                resumeRuleService.updateSelective(resumeRule);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                if(StringUtil.isNotEmpty(sysUser.getWorkCode())) {
                  resumeRule.setCreator(sysUser.getWorkCode());
                }
                else {
                  resumeRule.setCreator(sysUser.getAccount());
                }
                resumeRule.setId(UUID.randomUUID().toString().replace("-", ""));
                resumeRule.setCreateDate(DataUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
                resumeRuleService.create(resumeRule);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}