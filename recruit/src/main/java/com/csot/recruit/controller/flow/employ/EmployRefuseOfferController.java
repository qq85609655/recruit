package com.csot.recruit.controller.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployRefuseOffer;
import com.csot.recruit.service.flow.employ.EmployRefuseOfferService;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employRefuseOfferController")
public class EmployRefuseOfferController {
  private static final Logger logger = LoggerFactory.getLogger(EmployRefuseOfferController.class);

  @Resource
  private EmployRefuseOfferService employRefuseOfferService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/recruit/flow/employ/employRefuseOfferList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<EmployRefuseOffer> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return employRefuseOfferService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/flow/employ/employRefuseOfferEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    EmployRefuseOffer employRefuseOffer = employRefuseOfferService.getByPrimaryKey(id);
    request.setAttribute("employRefuseOffer", employRefuseOffer);
    return new ModelAndView("com/csot/recruit/flow/employ/employRefuseOfferEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    EmployRefuseOffer employRefuseOffer = employRefuseOfferService.getByPrimaryKey(id);
    request.setAttribute("employRefuseOffer", employRefuseOffer);
    return new ModelAndView("com/csot/recruit/flow/employ/employRefuseOfferView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      employRefuseOfferService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(EmployRefuseOffer employRefuseOffer) {
    if (StringUtils.hasText(employRefuseOffer.getId())) {
      try {
        employRefuseOfferService.updateSelective(employRefuseOffer);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        employRefuseOffer.setId(UUID.randomUUID().toString().replace("-", ""));
        employRefuseOfferService.create(employRefuseOffer);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 放弃入职
   * @param employRefuseOffer
   * @return
   */
  @RequestMapping("refuseEntry")
  @ResponseBody
  public AjaxRtnJson refuseEntry(@CurrentUser SysUser sysUser,EmployRefuseOffer employRefuseOffer) {
    try {
      employRefuseOffer.setId(UUID.randomUUID().toString().replace("-", ""));
      employRefuseOfferService.refuseOffer(employRefuseOffer);
      employRefuseOfferService.refuseEntry(employRefuseOffer);
      return new AjaxRtnJson(true, "放弃入职成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
    }
  }
  
  /**
   * 拒绝offer
   * @param employRefuseOffer
   * @return
   */
  @RequestMapping("refuseOffer")
  @ResponseBody
  public AjaxRtnJson refuseOffer(@CurrentUser SysUser sysUser,EmployRefuseOffer employRefuseOffer) {
    try {
      employRefuseOffer.setId(UUID.randomUUID().toString().replace("-", ""));
      employRefuseOffer.setCreatorId(sysUser.getId());
      employRefuseOfferService.refuseOffer(employRefuseOffer);
      return new AjaxRtnJson(true, "拒绝offer成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
    }
  }

}
