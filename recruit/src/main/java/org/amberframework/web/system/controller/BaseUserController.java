package org.amberframework.web.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.controller.BaseController;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.user.SysUserService;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.service.BaseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("baseUserController")
public class BaseUserController extends BaseController {

  private static final Logger logger = LoggerFactory.getLogger(BaseUserController.class.getName());

  @Resource
  private BaseUserService baseUserService;

  @Resource
  private SysUserService sysUserService;

  /**
   * 跳转到用户查看维护页面.
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("baseUserList")
  public ModelAndView baseUserList(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("org/amber/system/baseuser/baseUserList");
  }

  @RequestMapping("chooseBaseUserList")
  public ModelAndView chooseBaseUserList(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("/com/csot/flow/interview/chooseBaseUserList");
  }

  /**
   * 获取用户列表.
   * 
   * @param request
   * @param response
   */
  @RequestMapping("datagrid")
  public void datagrid(MiniGridPageSort pageAndSort, BaseUser baseUser, HttpServletRequest request,
      HttpServletResponse response) {
    MiniRtn2Grid<BaseUser> rtnGird = this.baseUserService.getBaseUserList(pageAndSort, baseUser);
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String dategridJson = gson.toJson(rtnGird);
    response.setContentType("application/json");
    response.setHeader("Cache-Control", "no-store");
    PrintWriter pw;
    try {
      pw = response.getWriter();
      pw.write(dategridJson);
      pw.flush();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 进入创建用户页面.
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("create")
  public ModelAndView createBaseUser(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("org/amber/system/baseuser/baseUserEdit");
  }

  /**
   * 保存用户(新建 or 更新).
   * 
   * @param user
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson saveUser(@RequestBody BaseUser user, HttpServletRequest request,
      HttpServletResponse response) {
    if (user != null) {
      // admin账号不允许修改
      if (user.getAccount() != null && user.getAccount().equals("admin")) {
        return new AjaxRtnJson(false, "Admin用户不允许修改");
      }
      if (StringUtils.isEmpty(user.getId())) {
        // 判断账号名是否已存在
        int existUserCount = baseUserService.findSameAccountUserCount(user.getAccount());
        if (existUserCount > 0) {
          return new AjaxRtnJson(false, "此账号已存在");
        }
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword("123456"); // 默认密码
        user.setCreateTime(new Date());
        baseUserService.createBaseUser(user);
        return new AjaxRtnJson(true, "用户创建成功");
      } else {
        baseUserService.updateBaseUser(user);
        return new AjaxRtnJson(true, "用户更新成功");
      }
    } else {
      /*
       * int existUserCount = baseUserService.findSameAccountUserCount(user.getAccount()); if
       * (existUserCount > 0) { return new AjaxRtnJson(false, "此账号已存在"); }
       */
      return new AjaxRtnJson(false, "操作失败，对象不存在");
    }
  }

  /**
   * 进入修改密码页面.
   * 
   * @param userId
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("modifyPassword/{id}")
  // 如果上面的和下面的两个名字一样，@PathVariable可以不用加参数
      public
      ModelAndView modifyPassword(@PathVariable("id") String userId, HttpServletRequest request,
          HttpServletResponse response) {
    if (!StringUtils.isEmpty(userId)) {
      BaseUser baseUser = baseUserService.getBaseUserByPrimaryKey(userId);
      if (baseUser != null) {
        return new ModelAndView("org/amber/system/baseuser/baseUserPasswordEdit").addObject("user",
            baseUser);
      }
    }
    request.setAttribute("errorMsg", "用户不存在");
    return new ModelAndView("error");
  }

  /**
   * 保存新密码.
   * 
   * @param user
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("savePassword")
  @ResponseBody
  public AjaxRtnJson savePassowrd(@ModelAttribute BaseUser user, @RequestParam String newPassword) {
    if (user != null && newPassword != null && !"".equals(newPassword)) {
      boolean flag = baseUserService.validatePassowrd(user.getId(), user.getPassword());
      if (flag) {
        baseUserService.updateBaseUser(user);
        return new AjaxRtnJson(true, "密码修改成功");
      } else {
        return new AjaxRtnJson(false, "原密码错误");
      }
    } else {
      return new AjaxRtnJson(false, "操作失败，对象不存在");
    }
  }


  @RequestMapping("queryAllUser")
  @ResponseBody
  public AjaxRtnJson queryAllUser() {
    List<BaseUser> recruiters = baseUserService.queryAllUser();
    AjaxRtnJson returnData = new AjaxRtnJson(true, "查询成功");
    returnData.setObj(recruiters);
    return returnData;
  }

  /**
   * 禁用用户
   * 
   * @param id
   * @return
   */
  @RequestMapping("status")
  @ResponseBody
  public AjaxRtnJson setStatus(String id) {
    boolean flag = baseUserService.setStatus(id);
    if (flag) {
      return new AjaxRtnJson(true, "已禁用");
    }
    return new AjaxRtnJson(false, "禁用失败");
  }

  @RequestMapping("delete")
  @ResponseBody
  public AjaxRtnJson deleteUser(String id) {
    boolean flag = baseUserService.deleteUser(id);
    if (flag) {
      return new AjaxRtnJson(true, "删除成功");
    }
    return new AjaxRtnJson(false, "删除失败");
  }

  /**
   * 根据4A数据初始化用户账号
   */
  @RequestMapping("initAccount")
  @ResponseBody
  public AjaxRtnJson initAccount(@CurrentUser SysUser sysUser) {
    if (!"admin".equals(sysUser.getAccount())) {
      return new AjaxRtnJson(false, "非admin不能操作");
    }
    List<BaseUser> ls = baseUserService.selectFromAccount();
    for (BaseUser user : ls) {
      user.setId(UUID.randomUUID().toString().replace("-", ""));
      user.setPassword("123456"); // 默认密码
      user.setCreateTime(new Date());
      baseUserService.createBaseUser(user);
      sysUserService.changePassword(user.getId(), user.getPassword());
    }
    return new AjaxRtnJson(true, "密码修改成功");
  }

  /**
   * 返回组成员信息列表.
   */
  @RequestMapping("groupMembers")
  @ResponseBody
  public List<SysUser> groupMembers(String groupId) {
    if (StringUtils.hasText(groupId)) {
      return baseUserService.getGroupMembers(Long.parseLong(groupId));
    } else {
      return new ArrayList<SysUser>();
    }
  }

  /**
   * 获取用户列表.
   * 
   * @param request
   * @param response
   */
  @RequestMapping("datagridRecruit")
  @ResponseBody
  public MiniRtn2Grid<BaseUser> datagridByGroupId(MiniGridPageSort pageAndSort,
      HttpServletRequest request) {
    Map<String, String> searchMap = new HashMap<String, String>();
    String name = request.getParameter("name"); // 流程状态
    String workCode = request.getParameter("workCode"); // 是否共承
    String groupId = request.getParameter("groupId"); // 预计到到岗时间 开始
    searchMap.put("name", name);
    searchMap.put("workCode", workCode);
    searchMap.put("groupId", groupId);
    return baseUserService.getBaseUserListByGroupId(pageAndSort, searchMap);
  }
  
  /**
   * 获取用户信息
   * 
   * @param request
   * @param response
   */
  @RequestMapping("getInfoByCode")
  @ResponseBody
  public Map<String,String> getInfoByCode(MiniGridPageSort pageAndSort,
      HttpServletRequest request) {
    String code = request.getParameter("code"); // 流程状态
    return baseUserService.getInfoByCode(code);
  }
}
