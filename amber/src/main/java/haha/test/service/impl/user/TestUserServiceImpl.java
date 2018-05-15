package haha.test.service.impl.user;

import haha.test.dao.original.user.TestUserMapper;
import haha.test.model.original.user.TestUser;
import haha.test.model.original.user.TestUserColumns;
import haha.test.model.original.user.TestUserCriteria;
import haha.test.service.user.TestUserService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("testUserService")
public class TestUserServiceImpl implements TestUserService {

  private static final Logger logger = LoggerFactory.getLogger(TestUserServiceImpl.class);
  
  @Resource
  private TestUserMapper testUserMapper;

  @Override
  public MiniRtn2Grid<TestUser> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<TestUser> grid = new MiniRtn2Grid<TestUser>();
    TestUserCriteria criteria = new TestUserCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = TestUserColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(testUserMapper.selectByExample(criteria));
    grid.setTotal(testUserMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public TestUser getByPrimaryKey(String primaryKey) {
    return testUserMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(TestUser testUser) {
    testUserMapper.insert(testUser);
  }

  @Override
  public void updateSelective(TestUser testUser) {
    testUserMapper.updateByPrimaryKeySelective(testUser);
  }

  @Override
  public void remove(String primaryKey) {
    testUserMapper.deleteByPrimaryKey(primaryKey);
  }
}
