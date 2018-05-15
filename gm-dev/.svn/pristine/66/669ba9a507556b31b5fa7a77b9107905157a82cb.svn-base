package com.csot.gm.materialManage.controller.enumType;

import java.util.List;

import com.csot.gm.materialManage.model.original.enumType.EnumType;
import com.csot.gm.materialManage.service.enumType.EnumTypeService;
import com.csot.gm.materialManage.service.gmlog.LogService;
import com.csot.gm.rawMaterial.model.EnumTypeMember;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("enumType")
public class EnumTypeController {
  private static final Logger logger = LoggerFactory.getLogger(EnumTypeController.class);

  @Resource
  private EnumTypeService enumTypeService;
  @Resource
  private LogService logService;


  /**
   * Forward to list page. 暂不用此方法
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/enumType/enumTypeList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<EnumType> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return enumTypeService.getGrid(pageSort, searchKey);
  }

  /**
   * Get datagrid. 获取枚举类的成员列表
   */
  @RequestMapping("EnumTypeMemberDatagrid")
  @ResponseBody
  public List<EnumTypeMember> enumTypeMemberDatagrid(String enumTypeId) {
    return enumTypeService.getEnumTypeMemberGrid(enumTypeId);
  }

  /**
   * Forward to create page. 跳转到新建枚举类页面
   */
  @RequiresPermissions("enumValueManage:createEnumType")
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/enumType/enumTypeEdit");
  }

  /**
   * Forward to modify page. 跳转到下拉类编辑页面
   */
  @RequiresPermissions("enumValueManage:modifyEnumType")
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    EnumType enumType = enumTypeService.getByPrimaryKey(id);
    request.setAttribute("enumType", enumType);
    return new ModelAndView("com/csot/gm/materialManage/enumType/enumTypeEdit");
  }

  /**
   * Forward to view page. 暂不用此方法
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    EnumType enumType = enumTypeService.getByPrimaryKey(id);
    request.setAttribute("enumType", enumType);
    return new ModelAndView("com/csot/gm/materialManage/enumType/enumTypeView");
  }

  /**
   * remove object by id. 删除枚举类
   */
  @RequiresPermissions("enumValueManage:removeEnumType")
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id, @CurrentUser SysUser sysUser) {
    try {
      // 检查属性类是否正在被使用
      boolean isUsed = enumTypeService.enumTypeIsUsing(id);
      if (!isUsed) {
        logService.logEnumType(sysUser, enumTypeService.getByPrimaryKey(id), "删除");
        enumTypeService.remove(id);
        return new AjaxRtnJson(true, "删除成功");
      } else {
        return new AjaxRtnJson(false, "删除失败:属性类正在被使用！ ");
      }
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update 新建或者更新枚举类
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(EnumType enumType, @CurrentUser SysUser sysUser) {
    if (enumTypeService.enumTypeIsExist(enumType.getEnumName())) {
      logger.error(enumType.getEnumName() + "已经存在！");
      return new AjaxRtnJson(false, "保存失败: </br>" + enumType.getEnumName() + "</br>已存在！");
    } else {
      if (StringUtils.isEmpty(enumType.getId())) {
        try {
          enumTypeService.create(enumType);
          logService.logEnumType(sysUser, enumType, "新建");
          return new AjaxRtnJson(true, "新建成功");
        } catch (DataAccessException e) {
          logger.error(e.getMessage(), e);
          return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
        }
      } else {
        try {
          logService.logEnumType(sysUser, enumType, "更新");
          enumTypeService.updateSelective(enumType);
          return new AjaxRtnJson(true, "修改成功");
        } catch (DataAccessException e) {
          logger.error(e.getMessage(), e);
          return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
        }
      }
    }
  }

}
