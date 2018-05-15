package com.csot.gm.materialManage.controller.partNo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.util.FileUtils;
import com.csot.gm.util.SpareExcelVbo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
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

@Controller @RequestMapping("partNo") public class PartNoController {
  private static final Logger logger = LoggerFactory.getLogger(PartNoController.class);

  @Resource private PartNoService partNoService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list") public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/partNoManage");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid") @ResponseBody public MiniRtn2Grid<PartNo> datagrid(
      MiniGridPageSort pageSort, HttpServletRequest request) {
    String partNo = request.getParameter("searchKey");
    String ownerName = request.getParameter("ownerName");
    String partName = request.getParameter("partName");
    String brandValue = request.getParameter("searchKeyBrand");
    String specValue = request.getParameter("searchKeySpec");
    String partId = request.getParameter("partId");
    String partClassId = request.getParameter("partClassId");
    String partType = request.getParameter("partType");
    String beginDate = request.getParameter("beginDate");
    String endDate = request.getParameter("endDate");
    String partNos = request.getParameter("partNos");
    String department = request.getParameter("department");
    return partNoService
        .getGrid(pageSort, partNo, partId, partClassId, brandValue, specValue, ownerName, partType,
            partName, beginDate, endDate, partNos, department);
  }

  /**
   * update all partNo's HashCode.
   */
  @RequiresPermissions("partNoInfo:updateHashCode") @RequestMapping("updateHashCode") @ResponseBody
  public AjaxRtnJson updateHashCode() {
    try {
      partNoService.updateAllHashCode();
      return new AjaxRtnJson(true, "更新成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "更新失败: " + e.getMessage());
    }
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create") public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/partNo/partNoEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}") public ModelAndView modify(@PathVariable String id,
      HttpServletRequest request) {
    PartNo partNo = partNoService.getByPrimaryKey(id);
    request.setAttribute("partNo", partNo);
    return new ModelAndView("com/csot/gm/materialManage/partNo/partNoEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}") public ModelAndView view(@PathVariable String id,
      HttpServletRequest request) {
    PartNo partNo = partNoService.getByPrimaryKey(id);
    request.setAttribute("partNo", partNo);
    return new ModelAndView("com/csot/gm/materialManage/partNo/partNoView");
  }

  /**
   * remove object by id.
   */
  @RequiresPermissions("partNoInfo:removePartNo") @RequestMapping("remove/{id}") @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      partNoService.remove(id, "admin");
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update
   */
  @RequestMapping("save") @ResponseBody public AjaxRtnJson save(PartNo partNo) {
    if (StringUtils.isEmpty(partNo.getId())) {
      try {
        partNoService.create(partNo);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        partNoService.updateSelective(partNo);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }

  /**
   * exportPartNo
   */
  // @RequiresPermissions("partManage:exportPartNo")
  @RequestMapping("exportPartNoById") @ResponseBody
  public AjaxRtnJson exportPartNoById(HttpServletRequest request) {
    try {
      String partNoIds = request.getParameter("partNoId");
      String path = partNoService.exportPartNoById(request, partNoIds);
      if ("false".equals(path)) {
        return new AjaxRtnJson(false, "导出失败");
      }
      return new AjaxRtnJson(true, path);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "导出失败");
    }
  }

  @RequestMapping("exportPartNoByClass") @ResponseBody
  public AjaxRtnJson exportPartNoByClass(HttpServletRequest request) {
    try {
      String path = partNoService.exportPartNoByClass(request);
      if ("false".equals(path)) {
        return new AjaxRtnJson(false, "导出失败");
      }
      return new AjaxRtnJson(true, path);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "导出失败");
    }
  }

  @RequestMapping("exportFile")
  public void exportFile(HttpServletRequest request, HttpServletResponse response) {
    String path = request.getParameter("filePath");
    try {
      Date date = new Date();
      String fileName = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(date) + "_partNoInfo";

      response.setCharacterEncoding("UTF-8");
      response.setContentType("multipart/form-data");

      response.setHeader("Content-Disposition",
          "attachment;fileName=" + new String((fileName + ".xls").getBytes("gbk"), "iso-8859-1"));
      InputStream fis = new BufferedInputStream(new FileInputStream(path));
      byte[] buffer = new byte[fis.available()];
      fis.read(buffer);
      fis.close();
      OutputStream fOut = new BufferedOutputStream(response.getOutputStream());
      fOut.write(buffer);
      fOut.close();
      FileUtils.delete(path);
    } catch (UnsupportedEncodingException e1) {
      logger.error("文件格式不对.", e1);
    } catch (Exception e) {
      logger.error("文件不存在。", e);
    }
  }

  @RequestMapping("exportPartNoByGroup") @ResponseBody
  public AjaxRtnJson exportPartNoByGroup(HttpServletRequest request) {
    try {
      String path = partNoService.exportPartNoByGroup(request);
      if ("false".equals(path)) {
        return new AjaxRtnJson(false, "导出失败");
      }
      return new AjaxRtnJson(true, path);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "导出失败");
    }
  }

  @RequestMapping("exportPartNoByProperty") @ResponseBody
  public AjaxRtnJson exportPartNoByProperty(HttpServletRequest request) {
    try {
      String path = partNoService.exportPartNoByProperty(request);
      if ("false".equals(path)) {
        return new AjaxRtnJson(false, "导出失败");
      }
      return new AjaxRtnJson(true, path);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "导出失败");
    }
  }

  /**
   * exportPartNoByAnySearch
   *
   * @param request
   * @return
   */
  @RequestMapping("exportPartNoByAnySearch") @ResponseBody
  public AjaxRtnJson exportPartNoByAnySearch(HttpServletRequest request) {
    try {
      String path = partNoService.exportPartNoByAnySearch(request);
      if ("false".equals(path)) {
        return new AjaxRtnJson(false, "导出失败");
      }
      return new AjaxRtnJson(true, path);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "导出失败");
    }
  }

  /**
   * exportPartNo
   */
  @RequestMapping("export6171") @ResponseBody public AjaxRtnJson export6171(
      HttpServletRequest request) {
    try {
      String path = partNoService.export6171(request);
      if ("false".equals(path)) {
        return new AjaxRtnJson(false, "导出失败");
      }
      return new AjaxRtnJson(true, path);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "导出失败");
    }
  }

  /**
   * checkweixiuType.
   */
  @RequestMapping("checkWxType/partType/{partType}/partNo/{partNo}") @ResponseBody
  public AjaxRtnJson checkWxType(@PathVariable String partType, @PathVariable String partNo) {
    try {
      // 取消检查维修料号的类型，因为有一部分料号在MDM更改了物料类别，在PLM和SAP没法修改--xyc20170822
      // return partNoService.checkPartNoType(partType, partNo);
      return new AjaxRtnJson(true, "");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "不能创建: " + e.getMessage());
    }
  }

  @RequestMapping("getlevelByPartNoId/{partNoId}") @ResponseBody
  public AjaxRtnJson getlevelByPartNoId(@PathVariable String partNoId) {
    try {
      String msg = partNoService.getLevelByPartNoId(partNoId);
      return new AjaxRtnJson(true, msg);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "获取数据失败: " + e.getMessage());
    }
  }

  /**
   * 用户查询界面 数据加载，只能加载非BOM材信息
   *
   * @param pageSort
   * @param request
   * @return
   */
  @RequestMapping("userDatagrid") @ResponseBody public MiniRtn2Grid<PartNo> userDatagrid(
      MiniGridPageSort pageSort, HttpServletRequest request) {
    String partNo = request.getParameter("searchKey");
    String ownerName = request.getParameter("ownerName");
    String partName = request.getParameter("partName");
    String brandValue = request.getParameter("searchKeyBrand");
    String specValue = request.getParameter("searchKeySpec");
    String partId = request.getParameter("partId");
    String partClassId = request.getParameter("partClassId");
    String partType = request.getParameter("partType");
    String beginDate = request.getParameter("beginDate");
    String endDate = request.getParameter("endDate");
    String partNos = request.getParameter("partNos");
    String department = request.getParameter("department");
    return partNoService
        .getUserDataGrid(pageSort, partNo, partId, partClassId, brandValue, specValue, ownerName,
            partType, partName, beginDate, endDate, partNos, department);
  }

  @RequestMapping("exportPartNoByTemplate") @ResponseBody
  public void exportPartNoByTemplate(HttpServletRequest request, HttpServletResponse response) {
    String brand = request.getParameter("brand");
    String spec = request.getParameter("spec");
    try {
      brand = URLDecoder.decode(brand, "utf-8");
      spec = URLDecoder.decode(spec, "utf-8");
      List<SpareExcelVbo> list = partNoService.getListByBrandSpec(brand, spec);
      response.setContentType("application/vnd.ms-excel");
      String fileName;
      OutputStream ops = null;
      Workbook workbook = null;
      try {
        // 新命名excel文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileNameTmp = "PartNoExcel" + sdf.format(new Date()) + ".xls";
        fileName = new String(fileNameTmp.getBytes("UTF-8"), "ISO8859-1");
        // 设置响应头信息
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        // 利用模板创建workbook
        workbook = partNoService.exportBrandSpecExcel(list);
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
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
    }
  }

}