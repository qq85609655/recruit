package org.amberframework.web.system.auth.controller.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResource;
import org.amberframework.web.system.auth.service.resource.SysRoleResourceService;
import org.amberframework.web.system.auth.vo.resource.SysResourceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("auth/resource/sysRoleResource")
public class SysRoleResourceController {
  private static final Logger logger = LoggerFactory.getLogger(SysRoleResourceController.class);
  private static final GsonBuilder gsonBuilder = new GsonBuilder();
  private static final Gson gson;

  static {
    gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  }

  @Resource
  private SysRoleResourceService sysRoleResourceService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView(
        "org/amberframework/web/system/auth/controller/resource/sysRoleResourceList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SysRoleResource> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return sysRoleResourceService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView(
        "org/amberframework/web/system/auth/controller/resource/sysRoleResourceEdit");
  }

  /**
   * 转到编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    SysRoleResource sysRoleResource = sysRoleResourceService.getByPrimaryKey(id);
    request.setAttribute("sysRoleResource", sysRoleResource);
    return new ModelAndView(
        "org/amberframework/web/system/auth/controller/resource/sysRoleResourceEdit");
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysRoleResource sysRoleResource = sysRoleResourceService.getByPrimaryKey(id);
    request.setAttribute("sysRoleResource", sysRoleResource);
    return new ModelAndView(
        "org/amberframework/web/system/auth/controller/resource/sysRoleResourceView");
  }

  /**
   * 删除角色资源.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      sysRoleResourceService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }
  
  @RequestMapping("resource/checkedTree/{roleId}")
  @ResponseBody
  public List<SysResourceVo> getCheckedResourceTree(@PathVariable Long roleId) {
    return sysRoleResourceService.getCheckedResourceTree(roleId);
  }

  /**
   * 保存菜单（角色资源）.
   */
  @RequestMapping("saveMenu/roleId/{roleId}")
  @ResponseBody
  public AjaxRtnJson saveMenu(@PathVariable Long roleId, String json) {
    if (null == json) {
      return new AjaxRtnJson(false, "修改失败:提交内容为空");
    }
    
    List<SysResource> sysResourceList = gson.fromJson(json, new TypeToken<List<SysResource>>() {}.getType());
    if (null != sysResourceList) {
      try {
        sysRoleResourceService.updateRoleMenu(roleId, sysResourceList);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
    return new AjaxRtnJson(true, "修改成功，<br>没有菜单！");
  }
}
