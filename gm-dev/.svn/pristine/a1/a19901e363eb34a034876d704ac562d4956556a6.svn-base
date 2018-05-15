package com.csot.gm.materialManage.controller.userInfo;

import com.csot.gm.materialManage.model.original.userInfo.UserInfo;
import com.csot.gm.materialManage.service.userInfo.UserInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
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
@RequestMapping("userInfo")
public class UserInfoController {
  private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

  @Resource
  private UserInfoService userInfoService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/userInfo/userInfoList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<UserInfo> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return userInfoService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/userInfo/userInfoEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    UserInfo userInfo = userInfoService.getByPrimaryKey(id);
    request.setAttribute("userInfo", userInfo);
    return new ModelAndView("com/csot/gm/materialManage/userInfo/userInfoEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    UserInfo userInfo = userInfoService.getByPrimaryKey(id);
    request.setAttribute("userInfo", userInfo);
    return new ModelAndView("com/csot/gm/materialManage/userInfo/userInfoView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      userInfoService.remove(id);
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
  public AjaxRtnJson save(UserInfo userInfo) {
    if (StringUtils.isEmpty(userInfo.getId())) {
      try {
        userInfoService.create(userInfo);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        userInfoService.updateSelective(userInfo);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }

  /**
   * GetUserInfo by id.
   */
  @RequestMapping("getUserInfo/{code}")
  @ResponseBody
  public AjaxRtnJson getUserInfo(@PathVariable String code) {
    try {
      logger.info("userCode:" + code);
      com.csot.gm.rawMaterial.model.UserInfo user = userInfoService.getByUserCode(code);
      String userName = "";
      String department = "";
      String telephone = "";
      AjaxRtnJson ajax = new AjaxRtnJson();
      if (null != user.getUserName()) {
        userName = user.getUserName();
        department = user.getDepartment();
        telephone = user.getTelephone();
        ajax.setAttribute("userName", userName);
        ajax.setAttribute("department", department);
        ajax.setAttribute("telephone", telephone);
        ajax.setSuccess(true);
      } else {
        ajax.setSuccess(false);
        ajax.setMsg("工号不存在！");
      }
      return ajax;
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "用户工号不存在！" + e.getMessage());
    }
  }


}
