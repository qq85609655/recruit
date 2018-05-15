package com.csot.recruit.controller.resumelibrary.source;

import com.csot.recruit.model.original.resumelibrary.source.ResumeSource;
import com.csot.recruit.model.original.resumelibrary.source.ResumeSourceVo;
import com.csot.recruit.service.resumelibrary.source.ResumeSourceService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Throwables;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.util.AmberBeanUtils;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("resumeSourceController") public class ResumeSourceController {
  private static final Logger logger = LoggerFactory.getLogger(ResumeSourceController.class);

  @Resource private ResumeSourceService resumeSourceService;

  @RequestMapping("list") public ModelAndView list() {
    return new ModelAndView("com/csot/resumesource/resumesourceList");
  }

  @RequestMapping("datagrid") @ResponseBody
  public List<ResumeSource> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String sourceName = request.getParameter("searchKey");
    return resumeSourceService.getGrid(pageSort, sourceName);
  }

  @RequestMapping("create") public ModelAndView create() {
    return new ModelAndView("com/csot/resumesource/resumesourceEdit");
  }

  /**
   * 转到创建页面.
   */
  @RequestMapping("create/{parentId}") public ModelAndView create(@PathVariable String parentId) {
    ModelAndView mav = new ModelAndView("com/csot/resumesource/resumesourceEdit");
    if (!"0".equals(parentId)) {
      ResumeSource resumeSource = resumeSourceService.getByPrimaryKey(parentId);
      if (null != resumeSource) {
        ResumeSourceVo resumeSourceVo = new ResumeSourceVo();
        resumeSourceVo.setParentId(resumeSource.getId());
        resumeSourceVo.setParentName(resumeSource.getSourceName());
        mav.addObject("resumeSourceVo", resumeSourceVo);
      }
    }
    return mav;
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id) {
    ModelAndView mav = new ModelAndView("com/csot/resumesource/resumesourceEdit");
    ResumeSource resumeSource = resumeSourceService.getByPrimaryKey(id);
    ResumeSourceVo resumeSourceVo = new ResumeSourceVo();
    try {
      AmberBeanUtils.copyBeanPropertiesDeeply(resumeSourceVo, resumeSource);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
        | NoSuchMethodException ex) {
      logger.error("copyBeanPropertiesDeeplyFailure", ex);
      throw Throwables.propagate(ex);
    }
    if (StringUtils.hasText(resumeSource.getParentId())) {
      ResumeSource parentResumeSource = resumeSourceService.getByPrimaryKey(resumeSource.getParentId());
      if (null != parentResumeSource) {
        resumeSourceVo.setParentName(parentResumeSource.getSourceName());
      }
    }
    mav.addObject("resumeSourceVo", resumeSourceVo);
    return mav;
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    ResumeSource resumeSource = resumeSourceService.getByPrimaryKey(id);
    request.setAttribute("resumeSource", resumeSource);
    return new ModelAndView("com/csot/recruit/resumelibrary/source/resumeSourceView");
  }

  @RequestMapping("remove/{id}") @ResponseBody public AjaxRtnJson remove(@PathVariable String id) {
    try {
      resumeSourceService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save") @ResponseBody public AjaxRtnJson save(ResumeSource resumeSource) {
    if (StringUtils.hasText(resumeSource.getId())) {
      try {
        resumeSourceService.updateSelective(resumeSource);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        resumeSource.setId(UUID.randomUUID().toString().replace("-", ""));
        resumeSourceService.create(resumeSource);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("singleSelectResumeSourceTreeWindow")
  public ModelAndView singleSelectResumeSourceTreeWindow() {
    return new ModelAndView("com/csot/resumesource/singleSelectResumeSourceTreeWindow");
  }

}
