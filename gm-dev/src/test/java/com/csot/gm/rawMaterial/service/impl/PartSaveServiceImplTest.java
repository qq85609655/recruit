package com.csot.gm.rawMaterial.service.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.util.AopTargetUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.dao.original.propertyValue.PropertyValueMapper;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.rawMaterial.model.PartNoInfo;
import com.csot.gm.rawMaterial.service.PartSaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-spring-context.xml" })
public class PartSaveServiceImplTest {
  
  @Resource
  private PartSaveService partSaveService;
  
  @Resource
  private PartNoMapper partNoMapper;
  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PropertyValueMapper propertyValueMapper;
  
  @Mock
  private PartNoMapper mockPartNoMapper;
  @Mock
  private PartNoExtMapper mockPartNoExtMapper;
  @Mock
  private PropertyValueMapper mockPropertyValueMapper;
  


  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    // 根据代理对象，获取实际对象
    Object targetPartSaveService = AopTargetUtils.getTarget(partSaveService);
    ReflectionTestUtils.setField(targetPartSaveService, "partNoMapper", mockPartNoMapper);
    ReflectionTestUtils.setField(targetPartSaveService, "propertyValueMapper", mockPropertyValueMapper);
    ReflectionTestUtils.setField(targetPartSaveService, "partNoExtMapper", mockPartNoExtMapper);
  }

  @After
  public void tearDown() throws Exception {
    reset(mockPartNoMapper);
    reset(mockPropertyValueMapper);
    ReflectionTestUtils.setField(AopTargetUtils.getTarget(partSaveService), "partNoMapper", partNoMapper);
    ReflectionTestUtils.setField(AopTargetUtils.getTarget(partSaveService), "propertyValueMapper", propertyValueMapper);
    ReflectionTestUtils.setField(AopTargetUtils.getTarget(partSaveService), "partNoExtMapper", partNoExtMapper);
  }

//  @Test
//  public void testSavePartNoAndProperty() {
//    PartNoInfo partNoInfo = new PartNoInfo();
//    partNoInfo.setId("1");
//    partNoInfo.setPartNo("12T56566987896");
//    
//    List<PropertyValue> properties = new ArrayList<PropertyValue>();
//    PropertyValue pv = new PropertyValue();
//    pv.setId("1213");
//    pv.setPropertyName("color");
//    properties.add(pv);
//    PropertyValue pv2 = new PropertyValue();
//    pv2.setId("1214");
//    pv2.setPropertyName("size");
//    properties.add(pv2);
//    
//    partNoInfo.setProperties(properties);
//    PartNo partNo = new PartNo();
//    partNo.setId(partNoInfo.getId());
//    partNo.setPartNo(partNoInfo.getPartNo());
//    
//    when(mockPartNoMapper.insert(any(PartNo.class))).thenReturn(1);
//    when(mockPropertyValueMapper.insert(any(PropertyValue.class))).thenReturn(1);
//    
//
//    // Test action & Assert result
//    {
//      partSaveService.savePartNoAndProperty(partNoInfo);
//
//    }
//    
//    ArgumentCaptor<PartNo> argument = ArgumentCaptor.forClass(PartNo.class);
//    verify(mockPartNoMapper, times(1)).insert(argument.capture());
//    
//    ArgumentCaptor<PropertyValue> argument2 = ArgumentCaptor.forClass(PropertyValue.class);
//    verify(mockPropertyValueMapper, times(2)).insert(argument2.capture());
//    
//  }

  @Test
  public void testUpdatePartNoStatus() {
    List<PartNo> list = new ArrayList<PartNo>();
    PartNo pn = new PartNo();
    pn.setPartNo("partNo1");
    pn.setPartNoStatus("0");
    pn.setCnDesc("adad");
    pn.setEnDesc("adad");
    list.add(pn);
    
    PartNo pn2 = new PartNo();
    pn2.setPartNo("partNo2");
    pn2.setPartNoStatus("1");
    pn2.setCnDesc("sfsf");
    pn2.setEnDesc("sfsf");
    list.add(pn2);
    
    List<PartNoExt> list2 = new ArrayList<PartNoExt>();
    PartNoExt pne = new PartNoExt();
    pne.setId("1");
    pne.setPartNo("partNo1");
    pne.setPartNoStatus("3");
    pne.setCnDesc("adaa");
    pne.setCnDesc("adaa");
    list2.add(pne);
    
    List<PartNoExt> list3 = new ArrayList<PartNoExt>();
    PartNoExt pne3 = new PartNoExt();
    pne3.setId("2");
    pne3.setPartNo("partNo2");
    pne3.setPartNoStatus("0");
    pne3.setCnDesc("sfsf");
    pne3.setCnDesc("sfsf");
    list3.add(pne3);
    
    
    String partNo1 = "partNo1";
    String partNo2 = "partNo2";
    
    
    when(mockPartNoExtMapper.selectPartNoListByPartNo(partNo1)).thenReturn(list2);
    when(mockPartNoExtMapper.selectPartNoListByPartNo(partNo2)).thenReturn(list3);
    when(mockPartNoMapper.updateByPrimaryKeySelective(any(PartNo.class))).thenReturn(1);
    
    // Test action & Assert result
    {
      partSaveService.updatePartNoStatus(list);
    }
    
    verify(mockPartNoExtMapper, times(2)).selectPartNoListByPartNo(any(String.class));
    verify(mockPartNoMapper, times(2)).updateByPrimaryKeySelective(any(PartNo.class));
    
  }
    
}
