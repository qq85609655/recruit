package com.csot.recruit.controller.resume;

import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandVo;
import com.csot.recruit.model.resume.Category;
import com.csot.recruit.model.resume.Label;
import com.csot.recruit.service.resume.CategoryService;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * 标签类别
 * @author 
 *
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryService categoryService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/resume/categoryList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Category> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return categoryService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/resume/categoryEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Category category = categoryService.getByPrimaryKey(id);
        request.setAttribute("category", category);
        return new ModelAndView("com/csot/recruit/controller/resume/categoryEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Category category = categoryService.getByPrimaryKey(id);
        request.setAttribute("category", category);
        return new ModelAndView("com/csot/recruit/controller/resume/categoryView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            categoryService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Category category) {
        if (StringUtils.hasText(category.getId())) {
            try {
                categoryService.updateSelective(category);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                category.setId(UUID.randomUUID().toString().replace("-", ""));
                categoryService.create(category);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    /***
     * 根据ID删除分类
     * @param id 
     * @return
     */
    @RequestMapping("removeById")
    @ResponseBody
    public ModelAndView removeById(@RequestParam(value = "id", required = false) String id) {
    	ModelAndView view = new ModelAndView();
    	categoryService.remove(id);
        view.setViewName("redirect:/resume/commonlyUsedTag");
        return view;   
    }
    
    /***
     * 创建、更新类别
     * @param category 
     * @return
     */
    @RequestMapping("addCategory")
    @ResponseBody
    public AjaxRtnJson addCategory(Category category) {
    	if(categoryService.getCategoryCount(category) != 0){
    		return new AjaxRtnJson(false, "已存在同名称的类别" );
    	}
        if (StringUtils.hasText(category.getId())) {
            try {
                categoryService.updateSelective(category);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
        	Category ca = new Category();
        	if(categoryService.getCategoryCount(ca) >= 50){
        		return new AjaxRtnJson(false, "最多可设置50个类别" );
        	}
            try {
                category.setId(UUID.randomUUID().toString().replace("-", ""));
                categoryService.create(category);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("queryAll")
    @ResponseBody
    public AjaxRtnJson queryAll() {
      AjaxRtnJson re = new AjaxRtnJson(true, "查询成功" );
      re.setObj(categoryService.queryAll());
      return re;
    }
    
    
    @RequestMapping("chooseLabelList")
    public ModelAndView chooseLabelList() {
        return new ModelAndView("com/csot/candidate/chooseLabelList");
    }
    
    /**
     * 标签列表
     * 
     * @param pageSort
     * @param request
     * @return
     */
    @RequestMapping("labelDatagrid")
    @ResponseBody
    public MiniRtn2Grid<Label> labelDatagrid(MiniGridPageSort page, HttpServletRequest request) {
      String searchKey = request.getParameter("searchKey");
      if(StringUtil.isEmpty(page.getSortField())) {
        page.setSortField("storageDate");
        page.setSortOrder("desc");
      }
      Map<String, Object> map = new HashMap<String, Object>();
      if(StringUtil.isNotEmpty(searchKey)){
        map.put("searchKey", searchKey);
      }
      map.put("begin", page.getPageSize()*(page.getPageIndex()));
      map.put("end", page.getPageSize()*(page.getPageIndex()+1));
      map.put("sortField", page.getSortField());
      map.put("sortOrder", page.getSortOrder());
      return categoryService.getLabelDatagrid(map);
    }
}