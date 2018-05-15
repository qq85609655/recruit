package org.amberframework.web.system.auth.controller.resource;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.util.AmberBeanUtils;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.service.resource.SysResourceService;
import org.amberframework.web.system.auth.vo.resource.SysResourceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

@Controller
@RequestMapping("auth/resource/sysResource")
public class SysResourceController {
  private static final Logger logger = LoggerFactory.getLogger(SysResourceController.class);

  @Resource
  private SysResourceService sysResourceService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("org/amber/system/auth/resource/sysResourceList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public List<SysResource> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return sysResourceService.getGrid(pageSort, searchKey);
  }

  /**
   * 转到创建页面.
   */
  @RequestMapping("create/{parentId}")
  public ModelAndView create(@PathVariable String parentId) {
    ModelAndView mav = new ModelAndView("org/amber/system/auth/resource/sysResourceEdit");
    if ("0".equals(parentId)) {
      return mav;
    }

    SysResource parentResource = this.sysResourceService.getByPrimaryKey(parentId);
    if (parentResource != null) {
      SysResourceVo sysResourceVo = new SysResourceVo();
      sysResourceVo.setParentId(parentResource.getId());
      sysResourceVo.setParentName(parentResource.getName());
      mav.addObject("sysResourceVo", sysResourceVo);
    }
    return mav;
  }

  /**
   * 转到哦编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id) {
    ModelAndView mav = new ModelAndView("org/amber/system/auth/resource/sysResourceEdit");
    SysResource sysResource = sysResourceService.getByPrimaryKey(id);
    SysResourceVo sysResourceVo = new SysResourceVo();
    try {
      AmberBeanUtils.copyBeanPropertiesDeeply(sysResourceVo, sysResource);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
        | NoSuchMethodException e) {
      logger.error("copyBeanPropertiesDeeplyFailure", e);
      throw Throwables.propagate(e);
    }
    if (null != sysResource.getParentId()) {
      SysResource parentSysResource =
          sysResourceService.getByPrimaryKey(sysResource.getParentId().toString());
      if (null != parentSysResource) {
        sysResourceVo.setParentName(parentSysResource.getName());
      }
    }
    mav.addObject("sysResourceVo", sysResourceVo);
    return mav;
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysResource sysResource = sysResourceService.getByPrimaryKey(id);
    request.setAttribute("sysResource", sysResource);
    return new ModelAndView("org/amberframework/web/system/auth/controller/resource/sysResourceView");
  }

  /**
   * 删除资源.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      if (sysResourceService.hasRoleDependOnResource(id)) {
        return new AjaxRtnJson(false, "删除失败: 还有与此资源关联的角色关系！");
      } else if (sysResourceService.hasPermissionDependOnResource(id)) {
        return new AjaxRtnJson(false, "删除失败: 还有与此资源关联的权限关系！");
      }

      sysResourceService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存资源.
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(SysResource sysResource) {
    if (null != sysResource.getId()) {
      try {
        sysResourceService.updateSelective(sysResource);
        return new AjaxRtnJson(true, "修改成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        sysResourceService.create(sysResource);
        return new AjaxRtnJson(true, "新建成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("singleSelectResourceTreeWindow")
  public ModelAndView singleSelectGroupTreeWindow() {
    return new ModelAndView("org/amber/system/auth/resource/singleSelectResourceTreeWindow");
  }
}
