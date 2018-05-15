package com.csot.gm.materialManage.controller.enumValue;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csot.gm.materialManage.model.original.enumType.EnumType;
import com.csot.gm.materialManage.model.original.enumValue.EnumValue;
import com.csot.gm.materialManage.service.enumType.EnumTypeService;
import com.csot.gm.materialManage.service.enumValue.EnumValueService;
import com.csot.gm.materialManage.service.gmlog.LogService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.poi.ss.usermodel.Workbook;
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
@RequestMapping("enumValue")
public class EnumValueController {
  private static final Logger logger = LoggerFactory.getLogger(EnumValueController.class);

  @Resource
  private EnumValueService enumValueService;
  @Resource
  private EnumTypeService enumTypeService;
  @Resource
  private LogService logService;

  /**
   * Forward to list page. 暂不用此方法
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/enumValue/enumValueList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<EnumValue> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    String enumTypeId = request.getParameter("enumTypeId");
    return enumValueService.getGrid(pageSort, searchKey, enumTypeId);
  }

  /**
   * Get datagrid. 获取对应枚举类的枚举值datagrid
   */
  @RequestMapping("enumValuedatagrid")
  @ResponseBody
  public List<EnumValue> enumValuedatagrid(String enumTypeId, String enumValue) {
    if (StringUtils.hasText(enumValue)) {
      return enumValueService.getByEnumTypeIdAndEnumValueLike(enumTypeId, enumValue);
    } else {
      return enumValueService.getByEnumTypeId(enumTypeId);
    }
  }

  /**
   * Forward to create page. 新增某一个下拉类的属性值
   */
  @RequiresPermissions("enumValueManage:createEnumValue")
  @RequestMapping("create/{id}")
  public ModelAndView create(@PathVariable String id, HttpServletRequest request) {
    EnumType enumType = enumTypeService.getByPrimaryKey(id);
    String enumTypeName = enumType.getEnumName();
    EnumValue ev = new EnumValue();
    ev.setEnumTypeId(id);
    request.setAttribute("enumTypeName", enumTypeName);
    request.setAttribute("enumValue", ev);
    return new ModelAndView("com/csot/gm/materialManage/enumValue/enumValueEdit");
  }

  /**
   * Forward to modify page. 跳转到编辑下拉类的属性值得编辑页面
   */
  @RequiresPermissions("enumValueManage:modifyEnumValue")
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    EnumValue enumValue = enumValueService.getByPrimaryKey(id);
    String enumTypeName = enumTypeService.getByPrimaryKey(enumValue.getEnumTypeId()).getEnumName();
    request.setAttribute("enumValue", enumValue);
    request.setAttribute("enumTypeName", enumTypeName);
    return new ModelAndView("com/csot/gm/materialManage/enumValue/enumValueEdit");
  }

  /**
   * Forward to view page. 暂不用此方法
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    EnumValue enumValue = enumValueService.getByPrimaryKey(id);
    request.setAttribute("enumValue", enumValue);
    return new ModelAndView("com/csot/gm/materialManage/enumValue/enumValueView");
  }

  /**
   * remove object by id. 删除某个枚举类的某个属性值
   */
  @RequiresPermissions("enumValueManage:removeEnumValue")
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id, @CurrentUser SysUser sysUser) {
    try {
      logService.logEnumValue(sysUser, enumValueService.getByPrimaryKey(id), "删除");
      enumValueService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update 保存新建或者更新的枚举类下拉值
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(EnumValue enumValue, @CurrentUser SysUser sysUser) {
    // 根据枚举值显示值检查下拉类中是否已存在该下拉值
    boolean isEnumTextExist = enumValueService.isEnumTextExist(enumValue);
    if (isEnumTextExist) {
      return new AjaxRtnJson(false, "保存失败:下拉值已经存在 ");
    } else {
      if (StringUtils.isEmpty(enumValue.getId())) {
        try {
          enumValueService.create(enumValue);
          logService.logEnumValue(sysUser, enumValue, "新建");
          return new AjaxRtnJson(true, "新建成功");
        } catch (DataAccessException e) {
          logger.error(e.getMessage(), e);
          return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
        }
      } else {
        try {
          logService.logEnumValue(sysUser, enumValue, "更新");
          enumValueService.updateSelective(enumValue);
          return new AjaxRtnJson(true, "修改成功");
        } catch (DataAccessException e) {
          logger.error(e.getMessage(), e);
          return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
        }
      }
    }
  }
  
  /**
   * 按照模板导出选中枚举类的枚举值
   * @param enumTypeId
   * @param response
   */
  @RequestMapping("exportEnumValueByTemplate/{enumTypeId}")
  @ResponseBody
  public void exportPartNoByTemplate(@PathVariable String enumTypeId, HttpServletResponse response) {
    List<EnumValue> list = enumValueService.getByEnumTypeId(enumTypeId);
    response.setContentType("application/vnd.ms-excel");
    String fileName;
    OutputStream ops = null;
    Workbook workbook = null;
    try {
      // 新命名excel文件名
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      String fileNameTmp = "EnumValueExport" + sdf.format(new Date()) + ".xls";
      fileName = new String(fileNameTmp.getBytes("UTF-8"), "ISO8859-1");
      // 设置响应头信息
      response.setHeader("content-disposition", "attachment;filename=" + fileName);
      // 利用模板创建workbook
      workbook = enumValueService.exportEnumValueByTemplate(list);
      ops = response.getOutputStream();
      workbook.write(ops);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    } finally {
      try {
        if (null != ops) {
          ops.close();
        }
        if (null != workbook) {
          workbook.close();
        }
      } catch (IOException e) {
        logger.error(e.getMessage(), e);
      }
    }
  }
}
