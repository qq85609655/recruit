package com.csot.gm.rawMaterial.service.impl;

import static org.mockito.Mockito.reset;

import javax.annotation.Resource;

import org.amberframework.core.util.AopTargetUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.csot.gm.materialManage.dao.original.enumValue.EnumValueMapper;
import com.csot.gm.materialManage.service.enumValue.EnumValueService;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class TranslateObjectServiceImplTest {

  
  @Resource
  private EnumValueMapper enumValueMapper;
  @Mock
  private EnumValueMapper mockEnumValueMapper;
  @Resource
  private PartPropertiesService partPropertiesService;
  @Resource
  private EnumValueService enumValueService;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  
  /**
   * 测试前准备方法，每个测试方法前执行一次.
   */
  @Before
  public void setUp() throws Exception {
    // 测试开始前将所有的@Mock等Mock注解初始化，此方法相当于执行了mockSysUserMapper = mock(SysUserMapper.class);
    MockitoAnnotations.initMocks(this);
    // 根据代理对象，获取实际对象
    Object targetEnumValueService = AopTargetUtils.getTarget(enumValueService);
    // 给要测试的Service对象的sysUserMapper替换为mock对象
    ReflectionTestUtils.setField(targetEnumValueService, "enumValueMapper", mockEnumValueMapper);
  }

  /**
   * 测试后清理方法，每个测试方法后执行一次.
   */
  @After
  public void tearDown() throws Exception {
    // 测试后重置mock对象，将之前设置的when等去掉
    reset(mockEnumValueMapper);
    // 测试后将sysUserMapper还原为真实的sysUserMapper对象，以免影响其他测试
    ReflectionTestUtils.setField(AopTargetUtils.getTarget(enumValueService), "enumValueMapper", enumValueMapper);
  }
  
  

  @Test
  public void testTranslateRtnProMap2ProValueList() {
//    fail("Not yet implemented");
  }

  @Test
  public void testTranslateRtnProMap2Unique() {
//    fail("Not yet implemented");
  }

  @Test
  public void testTranslateRtnProMap2CreationPro() {
//    fail("Not yet implemented");
  }

  @Test
  public void testTranslateAll2SaveInfo() {
//    fail("Not yet implemented");
  }

}
