package haha.test.service.user;

import haha.test.model.original.user.TestUser;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface TestUserService {

  public MiniRtn2Grid<TestUser> getGrid(MiniGridPageSort pageSort, String searchKey);

  public TestUser getByPrimaryKey(String primaryKey);

  public void create(TestUser testUser);

  public void updateSelective(TestUser testUser);

  public void remove(String primaryKey);
}
