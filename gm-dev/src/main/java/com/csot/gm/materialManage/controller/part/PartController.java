package com.csot.gm.materialManage.controller.part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.service.gmlog.LogService;
import com.csot.gm.materialManage.service.part.PartService;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.materialManage.service.typePartM.TypePartMService;
import com.csot.gm.rawMaterial.model.PartClassTree;
import com.csot.gm.rawMaterial.service.DataShowService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("part")
public class PartController {
  private static final Logger logger = LoggerFactory.getLogger(PartController.class);

  @Resource
  private PartService partService;
  @Resource
  private TypePartMService typePartMService;
  @Resource
  private DataShowService dataShowService;
  @Resource
  private PartNoService partNoService;
  @Resource
  private LogService logService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/part/partList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<Part> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return partService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/part/partEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequiresPermissions("partManage:modifyPart")
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    Part part = partService.getByPrimaryKey(id);
    request.setAttribute("part", part);
    return new ModelAndView("com/csot/gm/materialManage/part/partEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    Part part = partService.getByPrimaryKey(id);
    request.setAttribute("part", part);
    return new ModelAndView("com/csot/gm/materialManage/part/partView");
  }

  /**
   * remove object by id.
   */
  @RequiresPermissions("partManage:removePart")
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      typePartMService.removeByPartId(id);
      partService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(Part part) {
    if (StringUtils.isEmpty(part.getId())) {
      try {
        partService.create(part);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        partService.updateSelective(part);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }

  /**
   * 跳转到备品耗材分类树界面
   * 
   */
  @RequestMapping("toSparePartConTree")
  public ModelAndView toSparePartComTree(HttpServletRequest request) {

    String partNoId = request.getParameter("partNoId");
    // 获取前台传过来的partNoId,传到跳转的界面
    request.setAttribute("partNoId", partNoId);
    return new ModelAndView("com/csot/gm/materialManage/sparePartConsumptivetTree");

  }

  /**
   * 获取备品耗材分类树
   * 
   * @param request
   * @param response
   */
  @RequestMapping("sparePartConTree")
  public void sparePartConTree(HttpServletResponse response, String partNoInfo) {

    // 获取备品耗材分类树
    List<PartClassTree> list = dataShowService.getSpareConsumTree();

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String treeJson = gson.toJson(list);
    response.setContentType("application/json");
    response.setHeader("Cache-Control", "no-store");
    PrintWriter pw;
    try {
      pw = response.getWriter();
      pw.write(treeJson);
      pw.flush();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 修改料号所属的level3
   * 
   * @param 料号id
   * @param 分类id
   * @param 当前登录用户
   */
  @RequestMapping("updatePartNoLevel3")
  @ResponseBody
  public AjaxRtnJson
      updatePartNoLevel3(String partNoId, String partId, @CurrentUser SysUser sysUser) {

    // 根据前台选中的料号id获取该料号信息
    PartNo partNo = partNoService.getPartNoByPartNoId(partNoId);
    String partNum = partNo.getPartNo();
    // 根据前台选中的料号id获取没有修改前的料号分类信息
    String oldMsg = partNoService.getLevelByPartNoId(partNoId);
    // 根据料号id和分类id更新料号所属分类
    int updateNum = dataShowService.updatePartNoInfo(partNoId, partId);
    // 通过partNoId获取料号所在分类的信息
    String newMsg = partNoService.getLevelByPartNoId(partNoId);
    AjaxRtnJson ajaxRtn = new AjaxRtnJson();
    if (updateNum > 0) {
      ajaxRtn.setSuccess(true);
      ajaxRtn.setMsg("更新成功");
      ajaxRtn.setAttribute("level", newMsg);
      logService.logUpdateLevel3Name(sysUser, partNum, newMsg, oldMsg, "更新");

    } else {
      ajaxRtn.setSuccess(false);
      ajaxRtn.setMsg("更新失败");
    }
    return ajaxRtn;
  }


}
