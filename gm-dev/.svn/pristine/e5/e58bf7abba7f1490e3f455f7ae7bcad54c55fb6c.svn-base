package org.amberframework.web.system.auth.service.impl.group;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.amberframework.core.util.AopTargetUtils;
import org.amberframework.web.system.auth.dao.original.group.SysGroupMapper;
import org.amberframework.web.system.auth.model.original.group.SysGroup;
import org.amberframework.web.system.auth.service.group.SysGroupService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-spring-context.xml" })
public class SysGroupServiceImplTest {

  @Resource
  private SysGroupService sysGroupService;
  
  @Resource
  private SysGroupMapper sysGroupMapper;
  
  @Mock
  private SysGroupMapper mockSysGroupMapper;
  
  /**
   * 测试前准备方法，每个测试方法前执行一次.
   */
  @Before
  public void setUp() throws Exception {
    // 测试开始前将所有的@Mock等Mock注解初始化，此方法相当于执行了mockSysUserMapper = mock(SysUserMapper.class);
    MockitoAnnotations.initMocks(this);
    // 根据代理对象，获取实际对象
    Object targetSysGroupService = AopTargetUtils.getTarget(sysGroupService);
    // 给要测试的Service对象的sysUserMapper替换为mock对象
    ReflectionTestUtils.setField(targetSysGroupService, "sysGroupMapper", mockSysGroupMapper);
  }

  /**
   * 测试后清理方法，每个测试方法后执行一次.
   */
  @After
  public void tearDown() throws Exception {
    reset(mockSysGroupMapper);
    ReflectionTestUtils.setField(AopTargetUtils.getTarget(sysGroupService), "sysGroupMapper", sysGroupMapper);
  }

  @Test
  public void testGetGrid() {
    // fail("Not yet implemented");
  }

  @Test
  public void testGetByPrimaryKey() {
    // fail("Not yet implemented");
  }

  @Test
  public void testCreate() {
    SysGroup parentGroup = new SysGroup();
    parentGroup.setId(24L);
    parentGroup.setName("parentGroup");
    parentGroup.setEnabled("1");
    parentGroup.setParentId(15L);
    parentGroup.setParentIds("0/5/10/15/");
    when(mockSysGroupMapper.insert(any(SysGroup.class))).thenReturn(1, 1);
    when(mockSysGroupMapper.selectByPrimaryKey(anyLong())).thenReturn(parentGroup).thenReturn(null);
    
    SysGroup group01 = new SysGroup();
    group01.setId(null);
    group01.setName("testGroup");
    group01.setEnabled("1");
    group01.setParentId(24L);
    
    sysGroupService.create(group01);
    
    SysGroup group02 = new SysGroup();
    group02.setId(null);
    group02.setName("testGroup2");
    group02.setEnabled("1");
    group02.setParentId(null);
    
    sysGroupService.create(group02);
    
    ArgumentCaptor<Long> argLong = ArgumentCaptor.forClass(Long.class);
    ArgumentCaptor<SysGroup> argGroup = ArgumentCaptor.forClass(SysGroup.class);
    
    verify(mockSysGroupMapper, times(2)).selectByPrimaryKey(argLong.capture());
    assertEquals(Long.valueOf(24L), argLong.getAllValues().get(0));
    assertEquals(Long.valueOf(0L), argLong.getAllValues().get(1));
    
    verify(mockSysGroupMapper, times(2)).insert(argGroup.capture());
    assertEquals("0/5/10/15/24/", argGroup.getAllValues().get(0).getParentIds());
    assertEquals("0/", argGroup.getAllValues().get(1).getParentIds());
    assertEquals(Long.valueOf(0L), argGroup.getAllValues().get(1).getParentId());
    
  }

  @Test
  public void testUpdateSelective() {
    // fail("Not yet implemented");
  }

  @Test
  public void testRemove() {
    // fail("Not yet implemented");
  }

  @Test
  public void testCreateParentIdsPathStr() {
    // fail("Not yet implemented");
  }

}
