package com.csot.recruit.controller.resume;

import com.csot.recruit.model.resume.Label;
import com.csot.recruit.service.resume.LabelService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * 标签
 * @author
 *
 */
@Controller
@RequestMapping("label")
public class LabelController {
    private static final Logger logger = LoggerFactory.getLogger(LabelController.class);

    @Resource
    private LabelService labelService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/resume/labelList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Label> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return labelService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/resume/labelEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Label label = labelService.getByPrimaryKey(id);
        request.setAttribute("label", label);
        return new ModelAndView("com/csot/recruit/controller/resume/labelEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Label label = labelService.getByPrimaryKey(id);
        request.setAttribute("label", label);
        return new ModelAndView("com/csot/recruit/controller/resume/labelView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            labelService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Label label) {
        if (StringUtils.hasText(label.getId())) {
            try {
                labelService.updateSelective(label);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                label.setId(UUID.randomUUID().toString().replace("-", ""));
                labelService.create(label);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    /***
     * 根据ID删除标签
     * @param id 
     * @return
     */
    @RequestMapping("removeById")
    @ResponseBody
    public ModelAndView removeById(@RequestParam(value = "id", required = false) String id) {
    	ModelAndView view = new ModelAndView();
        labelService.remove(id);
        view.setViewName("redirect:/resume/commonlyUsedTag");
        return view;   
    }
    
    /***
     * 创建、更新标签
     * @param label
     * @return
     */
    @RequestMapping("addLabel")
    @ResponseBody
    public AjaxRtnJson addLabel(Label label) {
    	if(labelService.getLabelCount(label) != 0){
    		return new AjaxRtnJson(false, "该标签类别已存在同名称的标签" );
    	}
        if (StringUtils.hasText(label.getId())) {
            try {
                labelService.updateSelective(label);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
        	Label la = new Label();
        	if(labelService.getLabelCount(la) >= 150){
        		return new AjaxRtnJson(false, "最多可设置150个标签");
        	}
            try {
                label.setId(UUID.randomUUID().toString().replace("-", ""));
                labelService.create(label);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
}