package org.amberframework.web.system.auth.service.impl.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.core.util.AopTargetUtils;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.dao.original.user.SysUserMapper;
import org.amberframework.web.system.auth.exception.UserAccountRepeatException;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.model.original.user.SysUserColumns;
import org.amberframework.web.system.auth.model.original.user.SysUserCriteria;
import org.amberframework.web.system.auth.service.user.SysUserService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-spring-context.xml" })
public class SysUserServiceImplTest {

  @Resource
  private SysUserService sysUserService;

  @Resource
  private SysUserMapper sysUserMapper;

  @Mock
  private SysUserMapper mockSysUserMapper;

  /**
   * 整个测试类执行前，执行一次.
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  /**
   * 整个测试类执行后，执行一次.
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {

  }

  /**
   * 测试前准备方法，每个测试方法前执行一次.
   */
  @Before
  public void setUp() throws Exception {
    // 测试开始前将所有的@Mock等Mock注解初始化，此方法相当于执行了mockSysUserMapper = mock(SysUserMapper.class);
    MockitoAnnotations.initMocks(this);
    // 根据代理对象，获取实际对象
    Object targetSysUserService = AopTargetUtils.getTarget(sysUserService);
    // 给要测试的Service对象的sysUserMapper替换为mock对象
    ReflectionTestUtils.setField(targetSysUserService, "sysUserMapper", mockSysUserMapper);
  }

  /**
   * 测试后清理方法，每个测试方法后执行一次.
   */
  @After
  public void tearDown() throws Exception {
    // 测试后重置mock对象，将之前设置的when等去掉
    reset(mockSysUserMapper);
    // 测试后将sysUserMapper还原为真实的sysUserMapper对象，以免影响其他测试
    ReflectionTestUtils.setField(AopTargetUtils.getTarget(sysUserService), "sysUserMapper", sysUserMapper);
  }

  @Test
  public void testGetGrid() {
    // 设置mockSysUserMapper方法的预期返回值
    List<SysUser> sysUserRtnList = new ArrayList<SysUser>();
    SysUser user01 = new SysUser();
    user01.setId(UUID.randomUUID().toString().replace("-", ""));
    user01.setAccount("admin");
    user01.setStatus("1");
    sysUserRtnList.add(user01);
    SysUser user02 = new SysUser();
    user02.setId(UUID.randomUUID().toString().replace("-", ""));
    user02.setAccount("user01");
    user02.setStatus("1");
    sysUserRtnList.add(user02);
    when(mockSysUserMapper.selectByExample(any(SysUserCriteria.class))).thenReturn(sysUserRtnList);
    when(mockSysUserMapper.countByExample(any(SysUserCriteria.class))).thenReturn(2);

    // 实例化参数捕获器
    ArgumentCaptor<SysUserCriteria> argument = ArgumentCaptor.forClass(SysUserCriteria.class);

    // 准备要测试的方法的输入参数
    MiniGridPageSort pageSort = new MiniGridPageSort();
    pageSort.setPageIndex(0);
    pageSort.setPageSize(3);
    pageSort.setShowPager(true);
    pageSort.setSortField("account");
    pageSort.setSortOrder("asc");
    // Test action & Assert result
    {
      MiniRtn2Grid<SysUser> grid = sysUserService.getGrid(pageSort, "admin", "1");

      assertEquals(2, grid.getTotal());
      assertEquals(2, grid.getData().size());
      assertEquals("admin", grid.getData().get(0).getAccount());
      assertEquals("user01", grid.getData().get(1).getAccount());
    }
    // Test action & Assert result
    {
      MiniRtn2Grid<SysUser> grid = sysUserService.getGrid(pageSort, null, null);

      assertEquals(2, grid.getTotal());
      assertEquals(2, grid.getData().size());
      assertEquals("admin", grid.getData().get(0).getAccount());
      assertEquals("user01", grid.getData().get(1).getAccount());
    }

    // 验证mock对象的方法调用，及调用时传入参数
    verify(mockSysUserMapper, times(2)).selectByExample(argument.capture());
    {
      SysUserCriteria criteria01 = argument.getAllValues().get(0);
      assertEquals(criteria01.getOrderByClause(), SysUserColumns.getColumn(pageSort.getSortField()) + " "
          + pageSort.getSortOrder());
      Page page01 = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      assertEquals(page01.getCurrent(), criteria01.getPage().getCurrent());
      assertEquals(page01.getCount(), criteria01.getPage().getCount());
    }
    {
      SysUserCriteria criteria01 = argument.getAllValues().get(1);
      assertEquals(criteria01.getOrderByClause(), SysUserColumns.getColumn(pageSort.getSortField()) + " "
          + pageSort.getSortOrder());
      Page page01 = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      assertEquals(page01.getCurrent(), criteria01.getPage().getCurrent());
      assertEquals(page01.getCount(), criteria01.getPage().getCount());
    }
    verify(mockSysUserMapper, times(2)).countByExample(argument.capture());
    {
      SysUserCriteria criteria01 = argument.getAllValues().get(0);
      assertEquals(criteria01.getOrderByClause(), SysUserColumns.getColumn(pageSort.getSortField()) + " "
          + pageSort.getSortOrder());
      Page page01 = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      assertEquals(page01.getCurrent(), criteria01.getPage().getCurrent());
      assertEquals(page01.getCount(), criteria01.getPage().getCount());
    }
    {
      SysUserCriteria criteria01 = argument.getAllValues().get(1);
      assertEquals(criteria01.getOrderByClause(), SysUserColumns.getColumn(pageSort.getSortField()) + " "
          + pageSort.getSortOrder());
      Page page01 = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      assertEquals(page01.getCurrent(), criteria01.getPage().getCurrent());
      assertEquals(page01.getCount(), criteria01.getPage().getCount());
    }
  }

  @Test
  public void testGetByPrimaryKey() {
    SysUser user01 = new SysUser();
    String id = UUID.randomUUID().toString().replace("-", "");
    user01.setId(id);
    user01.setAccount("admin");
    user01.setStatus("1");
    user01.setPassword("password");
    user01.setSalt("salt");
    when(mockSysUserMapper.selectByPrimaryKey(id)).thenReturn(user01);

    // 实例化参数捕获器
    ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

    SysUser resultUser = sysUserService.getByPrimaryKey(id);
    assertEquals(id, resultUser.getId());
    assertEquals("admin", resultUser.getAccount());
    assertNull(resultUser.getPassword());
    assertNull(resultUser.getSalt());

    // 这里使用参数捕获器只是为了演示，实际上由于Service的GetByPrimaryKey方法中，没有对传入的参数做处理，所以不用校验selectByPrimaryKey的参数
    verify(mockSysUserMapper).selectByPrimaryKey(argument.capture());
    assertEquals(id, argument.getValue());
  }

  @Test
  public void testCreate() {
    String id = UUID.randomUUID().toString().replace("-", "");
    String userAccount = "admin";
    String userStatus = "1";
    String userPassword = "password";
    String userSalt = "salt";
    SysUser user01 = new SysUser();
    user01.setId(id);
    user01.setAccount(userAccount);
    user01.setStatus(userStatus);
    user01.setPassword(userPassword);
    user01.setSalt(userSalt);
    SysUser user02 = new SysUser();
    user02.setId(id);
    user02.setAccount(userAccount);
    user02.setStatus(userStatus);
    user02.setPassword(userPassword);
    user02.setSalt(userSalt);

    // 第一次调用返回0，第二次返回1
    when(mockSysUserMapper.countByExample(any(SysUserCriteria.class))).thenReturn(0).thenReturn(1);
    // 效果同上 when(mockSysUserMapper.countByExample(any(SysUserCriteria.class))).thenReturn(0, 1);

    // 添加自定义参数匹配器，验证password有加过密，salt也重新生成过
    when(mockSysUserMapper.insert(argThat(new ArgumentMatcher<SysUser>() {

      @Override
      public boolean matches(Object argument) {
        if (!"admin".equals(((SysUser) argument).getAccount())) {
          return false;
        } else if ("password".equals(((SysUser) argument).getPassword())) {
          return false;
        } else if ("salt".equals(((SysUser) argument).getSalt())) {
          return false;
        }
        return true;
      }

    }))).thenReturn(1, 1);

    try {
      SysUser rtnUser01 = sysUserService.create(user01);
      assertEquals(userAccount, rtnUser01.getAccount());
      assertNull(rtnUser01.getPassword());
      assertNull(rtnUser01.getSalt());
      sysUserService.create(user02);
    } catch (RuntimeException ex) {
      if (ex.getClass() != UserAccountRepeatException.class) {
        fail("抛出的异常不是账号重复异常");
      }
    }

    verify(mockSysUserMapper, times(2)).countByExample(any(SysUserCriteria.class));

    // 不能用下面这三行的方法验证密码是否加过密，因为在Service的create方法中，传入Mapper的insert方法的user对象的password属性后来被置为null
    ArgumentCaptor<SysUser> argument = ArgumentCaptor.forClass(SysUser.class);
    verify(mockSysUserMapper, times(1)).insert(argument.capture());
    // assertNotEquals(userPassword, argument.getValue().getPassword());
    assertNull(argument.getValue().getPassword());
  }

  @Test
  public void testUpdateSelective() {
    String id = UUID.randomUUID().toString().replace("-", "");
    String userAccount = "admin";
    String userStatus = "1";
    String userPassword = "password";
    String userSalt = "salt";
    SysUser user01 = new SysUser();
    user01.setId(id);
    user01.setAccount(userAccount);
    user01.setStatus(userStatus);
    user01.setPassword(userPassword);
    user01.setSalt(userSalt);
    SysUser user02 = new SysUser();
    user02.setId(id);
    user02.setAccount(userAccount);
    user02.setStatus(userStatus);
    user02.setPassword(userPassword);
    user02.setSalt(userSalt);

    when(mockSysUserMapper.updateByPrimaryKeySelective(any(SysUser.class))).thenReturn(1);
    // 如果传入的参数值指定的值，则只有在调用时传此参数才会触发mock定义的方法调用
    when(mockSysUserMapper.selectByPrimaryKey(id)).thenReturn(user02);

    SysUser user03 = sysUserService.updateSelective(user01);
    assertEquals(userAccount, user03.getAccount());
    assertNull(user03.getPassword());
    assertNull(user03.getSalt());

    verify(mockSysUserMapper, times(1)).updateByPrimaryKeySelective(any(SysUser.class));
    verify(mockSysUserMapper, times(1)).selectByPrimaryKey(id);
  }

  @Test
  public void testRemove() {
    String id = UUID.randomUUID().toString().replace("-", "");

    when(mockSysUserMapper.deleteByPrimaryKey(id)).thenReturn(1);

    sysUserService.remove(id);

    verify(mockSysUserMapper, times(1)).deleteByPrimaryKey(id);
  }

  @Test
  public void testGetUserByAccount() {
    String id = UUID.randomUUID().toString().replace("-", "");
    String userAccount = "admin";
    String userStatus = "1";
    String userPassword = "password";
    String userSalt = "salt";
    SysUser user01 = new SysUser();
    user01.setId(id);
    user01.setAccount(userAccount);
    user01.setStatus(userStatus);
    user01.setPassword(userPassword);
    user01.setSalt(userSalt);

    List<SysUser> userList = new ArrayList<SysUser>();
    userList.add(user01);

    when(mockSysUserMapper.selectByExample(any(SysUserCriteria.class))).thenReturn(userList).thenReturn(
        new ArrayList<SysUser>());

    SysUser rtnUser01 = sysUserService.getUserByAccount("testGetUserByAccount");
    assertEquals(userAccount, rtnUser01.getAccount());
    assertEquals(userStatus, rtnUser01.getStatus());
    assertNull(rtnUser01.getPassword());
    assertNull(rtnUser01.getSalt());

    SysUser rtnUser02 = sysUserService.getUserByAccount("testGetUserByAccount2");
    assertNull(rtnUser02);

    verify(mockSysUserMapper, times(2)).selectByExample(any(SysUserCriteria.class));
  }

  @Test
  public void testChangePassword() {
    String id = UUID.randomUUID().toString().replace("-", "");
    String userAccount = "admin";
    String userStatus = "1";
    String userPassword = "password";
    String userSalt = "salt";
    SysUser user01 = new SysUser();
    user01.setId(id);
    user01.setAccount(userAccount);
    user01.setStatus(userStatus);
    user01.setPassword(userPassword);
    user01.setSalt(userSalt);

    when(mockSysUserMapper.selectByPrimaryKey("testChangePassword")).thenReturn(user01);
    when(mockSysUserMapper.updateByPrimaryKey(argThat(new ArgumentMatcher<SysUser>() {

      @Override
      public boolean matches(Object argument) {
        SysUser argUser = (SysUser) argument;
        // 判断是否已经加密
        if ("111111".equals(argUser.getPassword())) {
          return false;
        }
        return true;
      }

    }))).thenReturn(1);

    SysUser rtnUser01 = sysUserService.changePassword("testChangePassword", "111111");
    assertEquals(userAccount, rtnUser01.getAccount());
    assertNull(rtnUser01.getPassword());
    assertNull(rtnUser01.getSalt());

    verify(mockSysUserMapper, times(1)).selectByPrimaryKey("testChangePassword");
    verify(mockSysUserMapper, times(1)).updateByPrimaryKey(any(SysUser.class));
  }

  @Test
  public void testChangeStatus() {
    String id = UUID.randomUUID().toString().replace("-", "");
    String userAccount = "admin";
    String userStatus = "1";
    String userPassword = "password";
    String userSalt = "salt";
    SysUser user01 = new SysUser();
    String changedStatus = "0";
    user01.setId(id);
    user01.setAccount(userAccount);
    user01.setStatus(userStatus);
    user01.setPassword(userPassword);
    user01.setSalt(userSalt);

    SysUser user02 = new SysUser();
    user02.setId(id);
    user02.setAccount(userAccount);
    user02.setStatus(changedStatus);
    user02.setPassword(userPassword);
    user02.setSalt(userSalt);

    when(mockSysUserMapper.selectByPrimaryKey("testChangeStatus")).thenReturn(user01).thenReturn(user02);
    when(mockSysUserMapper.updateByPrimaryKeySelective(argThat(new ArgumentMatcher<SysUser>() {

      @Override
      public boolean matches(Object argument) {
        SysUser argUser = (SysUser) argument;
        if (argUser.getPassword() != null || argUser.getSalt() != null || argUser.getAccount() != null) {
          return false;
        } else if (null == argUser.getStatus()) {
          return false;
        }
        return true;
      }

    }))).thenReturn(1);

    SysUser rtnUser01 = sysUserService.changeStatus("testChangeStatus", changedStatus);
    assertEquals(userAccount, rtnUser01.getAccount());
    assertNull(rtnUser01.getPassword());
    assertNull(rtnUser01.getSalt());

    verify(mockSysUserMapper, times(2)).selectByPrimaryKey("testChangeStatus");
    verify(mockSysUserMapper, times(1)).updateByPrimaryKeySelective(any(SysUser.class));
  }

}
