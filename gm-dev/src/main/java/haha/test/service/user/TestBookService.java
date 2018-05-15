package haha.test.service.user;

import haha.test.model.original.user.TestBook;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface TestBookService {
  MiniRtn2Grid<TestBook> getGrid(MiniGridPageSort pageSort, String searchKey);

  TestBook getByPrimaryKey(String primaryKey);

  void create(TestBook testBook);

  void updateSelective(TestBook testBook);

  void remove(String primaryKey);
}
