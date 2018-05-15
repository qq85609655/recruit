package haha.test.controller.user;

import haha.test.model.original.user.TestBook;
import haha.test.service.user.TestBookService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("testBookController")
public class TestBookController {
  private static final Logger logger = LoggerFactory.getLogger(TestBookController.class);

  @Resource
  private TestBookService testBookService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("haha/test/controller/user/testBookList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<TestBook> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return testBookService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("haha/test/controller/user/testBookEdit");
  }

  /**
   * 转到编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    TestBook testBook = testBookService.getByPrimaryKey(id);
    request.setAttribute("testBook", testBook);
    return new ModelAndView("haha/test/controller/user/testBookEdit");
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    TestBook testBook = testBookService.getByPrimaryKey(id);
    request.setAttribute("testBook", testBook);
    return new ModelAndView("haha/test/controller/user/testBookView");
  }

  /**
   * 删除TestBook.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      testBookService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存TestBook.
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(TestBook testBook) {
    if (null != testBook.getId()) {
      try {
        testBookService.updateSelective(testBook);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        testBookService.create(testBook);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }
}
