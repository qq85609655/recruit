package haha.test.controller.user;

import haha.test.model.original.user.TestUser;
import haha.test.service.user.TestUserService;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
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
@RequestMapping("testUserController")
public class TestUserController {

  private static final Logger logger = LoggerFactory.getLogger(TestUserController.class);

  @Resource
  private TestUserService testUserService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("haha/test/user/testUserList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<TestUser> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return testUserService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("haha/test/user/testUserEdit");
  }

  /**
   * 转到编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    TestUser testUser = testUserService.getByPrimaryKey(id);
    request.setAttribute("testUser", testUser);
    return new ModelAndView("haha/test/user/testUserEdit");
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    TestUser testUser = testUserService.getByPrimaryKey(id);
    request.setAttribute("testUser", testUser);
    return new ModelAndView("haha/test/user/testUserView");
  }

  /**
   * 删除TestUser.
   */
  @RequiresPermissions("testUser:remove")
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      testUserService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存TestUser.
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(TestUser testUser) {
    if (StringUtils.hasText(testUser.getId())) {
      try {
        testUserService.updateSelective(testUser);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        testUser.setId(UUID.randomUUID().toString().replace("-", ""));
        testUserService.create(testUser);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }
}
