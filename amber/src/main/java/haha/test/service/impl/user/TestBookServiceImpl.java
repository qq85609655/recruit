package haha.test.service.impl.user;

import haha.test.dao.original.user.TestBookMapper;
import haha.test.model.original.user.TestBook;
import haha.test.model.original.user.TestBookColumns;
import haha.test.model.original.user.TestBookCriteria;
import haha.test.service.user.TestBookService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("testBookService")
public class TestBookServiceImpl implements TestBookService {
  private static final Logger logger = LoggerFactory.getLogger(TestBookServiceImpl.class);

  @Resource
  private TestBookMapper testBookMapper;

  @Override
  public MiniRtn2Grid<TestBook> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<TestBook> grid = new MiniRtn2Grid<TestBook>();
    TestBookCriteria criteria = new TestBookCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andNameEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = TestBookColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(testBookMapper.selectByExample(criteria));
    grid.setTotal(testBookMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public TestBook getByPrimaryKey(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    return testBookMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(TestBook testBook) {
    testBookMapper.insert(testBook);
  }

  @Override
  public void updateSelective(TestBook testBook) {
    testBookMapper.updateByPrimaryKeySelective(testBook);
  }

  @Override
  public void remove(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    testBookMapper.deleteByPrimaryKey(pk);
  }
}
