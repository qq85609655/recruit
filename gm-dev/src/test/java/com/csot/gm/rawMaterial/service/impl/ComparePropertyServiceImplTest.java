package com.csot.gm.rawMaterial.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.propertyValue.PropertyValueExt;
import com.csot.gm.rawMaterial.model.UniqueProperty;
import com.csot.gm.rawMaterial.service.ComparePropertyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-spring-context.xml" })
public class ComparePropertyServiceImplTest {
  
  @Resource
  ComparePropertyServiceImpl comparePropertyServiceImpl;
  @Resource
  ComparePropertyService comparePropertyService;
  
  @Resource
  PropertyValueExtMapper propertyValueExtMapper;
  
  @Mock
  private PropertyValueExtMapper mockPropertyValueExtMapper;
  
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    // 测试开始前将所有的@Mock等Mock注解初始化，此方法相当于执行了mockSysUserMapper = mock(SysUserMapper.class);
    MockitoAnnotations.initMocks(this);
    // 根据代理对象，获取实际对象
    Object targetComparePropertyServiceImpl = AopTargetUtils.getTarget(comparePropertyServiceImpl);
    // 给要测试的Service对象的sysUserMapper替换为mock对象
    ReflectionTestUtils.setField(targetComparePropertyServiceImpl, "propertyValueExtMapper", mockPropertyValueExtMapper);
  }

  @After
  public void tearDown() throws Exception {
    // 测试后重置mock对象，将之前设置的when等去掉
    reset(mockPropertyValueExtMapper);
    // 测试后将sysUserMapper还原为真实的sysUserMapper对象，以免影响其他测试
    ReflectionTestUtils.setField(AopTargetUtils.getTarget(comparePropertyServiceImpl), "propertyValueExtMapper", propertyValueExtMapper);
  
  }

  @Test
  public void testPropertyIsExit() {
    UniqueProperty uniqueProperty = new UniqueProperty();
    Map<String, String> map = new HashMap<String, String>(); // 待创建唯一性属性map
    map.put("color", "red");
    uniqueProperty.setUniqueProperty(map);
    
    UniqueProperty uniqueProperty2 = new UniqueProperty();
    Map<String, String> map2 = new HashMap<String, String>(); // 待创建唯一性属性map
    map2.put("color", "gray");
    uniqueProperty2.setUniqueProperty(map2);
    
    List<PartNoExt> list = new ArrayList<PartNoExt>();
    PartNoExt pne = new PartNoExt();
    pne.setId("1");
    list.add(pne);
    String partNoId = pne.getId();
    
    List<PropertyValueExt> propertyValueList = new ArrayList<PropertyValueExt>();
    PropertyValueExt pve = new PropertyValueExt();
    pve.setEnumValueId("12");
    pve.setId("123");
    pve.setPartNoId("1");
    pve.setPropertyName("color");
    pve.setPropertyType("Y");
    pve.setPropertyValue("red");
    propertyValueList.add(pve);
    
    PartNoExt pne2 = new PartNoExt();
    pne2.setId("2");
    
    when(mockPropertyValueExtMapper.selectPropertyValueByPartNo(partNoId)).thenReturn(propertyValueList);

    // Test action & Assert result
    {
      String  rt = comparePropertyService.propertyIsExit(uniqueProperty, list).getId();
      PartNoExt rt2 = comparePropertyService.propertyIsExit(uniqueProperty2, list);
      
      assertEquals("1", rt);
      assertEquals(null, rt2);

    }
    
  }

  @Test
  public void testPropertyValueIsTheSame() {
    
    List<PropertyValueExt> propertyValueList = new ArrayList<PropertyValueExt>();
    PropertyValueExt pve = new PropertyValueExt();
    pve.setEnumValueId("12");
    pve.setId("123");
    pve.setPartNoId("1");
    pve.setPropertyName("color");
    pve.setPropertyType("0");
    pve.setPropertyValue("red");
    propertyValueList.add(pve);
    
    UniqueProperty uniqueProperty = new UniqueProperty();
    Map<String, String> map = new HashMap<String, String>(); // 待创建唯一性属性map
    map.put("color", "red");
    uniqueProperty.setUniqueProperty(map);
    
    UniqueProperty uniqueProperty1 = new UniqueProperty();
    Map<String, String> map1 = new HashMap<String, String>(); // 待创建唯一性属性map
    map.put("color", "gray");
    uniqueProperty.setUniqueProperty(map1);
    
    
    PartNoExt pne = new PartNoExt();
    pne.setId("1");
    String partNoId = pne.getId();
    
    when(mockPropertyValueExtMapper.selectPropertyValueByPartNo(partNoId)).thenReturn(propertyValueList);
    
    
    
    // Test action & Assert result
    {
      boolean rt = comparePropertyServiceImpl.propertyValueIsTheSame(uniqueProperty, pne);
      boolean rt2 = comparePropertyServiceImpl.propertyValueIsTheSame(uniqueProperty1, pne);
      
      assertEquals(true, rt);
      assertEquals(false, rt2);

    }
    
  }

}
