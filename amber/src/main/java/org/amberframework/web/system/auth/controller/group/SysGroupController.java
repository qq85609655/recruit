package org.amberframework.web.system.auth.controller.group;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.util.AmberBeanUtils;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.system.auth.model.original.group.SysGroup;
import org.amberframework.web.system.auth.service.group.SysGroupService;
import org.amberframework.web.system.auth.vo.group.SysGroupVo;
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
@RequestMapping("auth/group/sysGroup")
public class SysGroupController {
  private static final Logger logger = LoggerFactory.getLogger(SysGroupController.class);

  @Resource
  private SysGroupService sysGroupService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("org/amber/system/auth/group/sysGroupList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public List<SysGroup> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return sysGroupService.getGrid(pageSort, searchKey);
  }

  /**
   * 转到创建页面.
   */
  @RequestMapping("create/{parentId}")
  public ModelAndView create(@PathVariable String parentId) {
    ModelAndView mav = new ModelAndView("org/amber/system/auth/group/sysGroupEdit");
    if ("0".equals(parentId)) {
      return mav;
    }

    SysGroup sysGroup = sysGroupService.getByPrimaryKey(parentId);
    if (null != sysGroup) {
      SysGroupVo sysGroupVo = new SysGroupVo();
      sysGroupVo.setParentId(sysGroup.getId());
      sysGroupVo.setParentName(sysGroup.getName());
      mav.addObject("sysGroupVo", sysGroupVo);
    }
    return mav;
  }

  /**
   * 转到编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id) {
    ModelAndView mav = new ModelAndView("org/amber/system/auth/group/sysGroupEdit");
    SysGroup sysGroup = sysGroupService.getByPrimaryKey(id);
    SysGroupVo sysGroupVo = new SysGroupVo();
    try {
      AmberBeanUtils.copyBeanPropertiesDeeply(sysGroupVo, sysGroup);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
        | NoSuchMethodException ex) {
      logger.error("copyBeanPropertiesDeeplyFailure", ex);
      throw Throwables.propagate(ex);
    }
    if (null != sysGroup.getParentId()) {
      SysGroup parentSysGroup = sysGroupService.getByPrimaryKey(sysGroup.getParentId().toString());
      if (null != parentSysGroup) {
        sysGroupVo.setParentName(parentSysGroup.getName());
      }
    }
    mav.addObject("sysGroupVo", sysGroupVo);
    return mav;
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysGroup sysGroup = sysGroupService.getByPrimaryKey(id);
    request.setAttribute("sysGroup", sysGroup);
    return new ModelAndView("org/amberframework/web/system/auth/controller/group/sysGroupView");
  }

  /**
   * 删除组.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      sysGroupService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存组.
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(SysGroup sysGroup) {
    if (null != sysGroup.getId()) {
      try {
        sysGroupService.updateSelective(sysGroup);
        return new AjaxRtnJson(true, "修改成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        sysGroupService.create(sysGroup);
        return new AjaxRtnJson(true, "新建成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("singleSelectGroupTreeWindow")
  public ModelAndView singleSelectGroupTreeWindow() {
    return new ModelAndView("org/amber/system/auth/group/singleSelectGroupTreeWindow");
  }

  @RequestMapping("groupMemberList")
  public ModelAndView groupMemberList() {
    return new ModelAndView("org/amber/system/auth/group/sysGroupMemberList");
  }

  /**
   * 编辑group的成员，跳转到编辑页面，同时传groupId过去.
   */
  @RequestMapping("member/modify/{id}")
  public ModelAndView memberModify(@PathVariable Long id) {
    ModelAndView mav = new ModelAndView("org/amber/system/auth/group/sysGroupMemberEdit");
    mav.addObject("groupId", id);
    return mav;
  }

  @RequestMapping("groupRoleList")
  public ModelAndView groupRoleList() {
    return new ModelAndView("org/amber/system/auth/group/sysGroupRoleList");
  }

  /**
   * 编辑group的角色，跳转到编辑页面，同时传groupId过去.
   */
  @RequestMapping("groupRole/modify/{id}")
  public ModelAndView roleModify(@PathVariable Long id) {
    ModelAndView mav = new ModelAndView("org/amber/system/auth/group/sysGroupRoleEdit");
    mav.addObject("groupId", id);
    return mav;
  }
}
