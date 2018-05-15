package com.csot.gm.util;

import com.google.common.collect.Maps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by WangYu on 2015/11/4.
 */
public class PartBeanUtilTest {

  @Before public void setUp() throws Exception {

  }

  @After public void tearDown() throws Exception {

  }

  @Test public void testDoIsPartPropertiesSame() throws Exception {
    LiquidCrystalTestBean liquidCrystalTest = new LiquidCrystalTestBean();
    liquidCrystalTest.setBoxSize("50");
    liquidCrystalTest.setRm("abcdefg");
    liquidCrystalTest.setSupplier("LG");
    liquidCrystalTest.setType("CuCa");
    liquidCrystalTest.setVersion("1.0");

    Map<String, String> liquidCrystalPropertyMap = Maps.newHashMap();
    liquidCrystalPropertyMap.put("boxSize", "50");
    liquidCrystalPropertyMap.put("rm", "abcdefg");
    liquidCrystalPropertyMap.put("supplier", "LG");
    liquidCrystalPropertyMap.put("type", "CuCa");
    liquidCrystalPropertyMap.put("version", "1.0");

    assertTrue(PartBeanUtil.doIsPartPropertiesSame(liquidCrystalTest, liquidCrystalPropertyMap));

    liquidCrystalTest.setBoxSize("62");
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(liquidCrystalTest, liquidCrystalPropertyMap));

    PropTypeTestBean propTypeTestBean01 = new PropTypeTestBean();
    propTypeTestBean01.setAge((short) 4);
    propTypeTestBean01.setGender(false);
    propTypeTestBean01.setHeight(178.25f);
    propTypeTestBean01.setId(11111111L);
    propTypeTestBean01.setIdentity(1111);
    propTypeTestBean01.setName("张三");
    propTypeTestBean01.setSalary(22000.5555);
    propTypeTestBean01.setStatus('Y');
    propTypeTestBean01.setSavedMoney(new BigDecimal("12345.6789"));

//    System.out.println(((Short) propTypeTestBean01.getAge()).toString());
//    System.out.println(((Boolean) propTypeTestBean01.isGender()).toString());
//    System.out.println(((Float) propTypeTestBean01.getHeight()).toString());
//    System.out.println(((Long) propTypeTestBean01.getId()).toString());
//    System.out.println(((Integer) propTypeTestBean01.getIdentity()).toString());
//    System.out.println(propTypeTestBean01.getName());
//    System.out.println(((Double) propTypeTestBean01.getSalary()).toString());
//    System.out.println(((Character) propTypeTestBean01.getStatus()).toString());
//    System.out.println(propTypeTestBean01.getSavedMoney().toString());

    Map<String, String> typeTestPropertyMap01 = Maps.newHashMap();
    typeTestPropertyMap01.put("age", "4");
    typeTestPropertyMap01.put("gender", "false");
    typeTestPropertyMap01.put("height", "178.25");
    typeTestPropertyMap01.put("id", "11111111");
    typeTestPropertyMap01.put("identity", "1111");
    typeTestPropertyMap01.put("name", "张三");
    typeTestPropertyMap01.put("salary", "22000.5555");
    typeTestPropertyMap01.put("status", "Y");
    typeTestPropertyMap01.put("savedMoney", "12345.6789");

    assertTrue(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setAge((short)5);
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setAge((short)4);
    propTypeTestBean01.setGender(true);
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setGender(false);
    propTypeTestBean01.setHeight(178.256f);
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setHeight(178.25f);
    propTypeTestBean01.setId(22222222l);
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setId(11111111L);
    propTypeTestBean01.setIdentity(2222);
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setIdentity(1111);
    propTypeTestBean01.setName("李四");
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setName("张三");
    propTypeTestBean01.setSalary(22000.55556666);
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setSalary(22000.5555);
    propTypeTestBean01.setStatus('N');
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setStatus('Y');
    propTypeTestBean01.setSavedMoney(new BigDecimal("12345.67890"));
    assertFalse(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));

    propTypeTestBean01.setSavedMoney(new BigDecimal("12345.6789"));
    assertTrue(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));
  }

  @Test(expected = PropertyInconsistentException.class)
  public void testDoIsPartPropertiesSameBeanMore() throws Exception {
    PropTypeTestBean propTypeTestBean01 = new PropTypeTestBean();
    propTypeTestBean01.setAge((short) 4);
    propTypeTestBean01.setGender(false);
    propTypeTestBean01.setHeight(178.25f);
    propTypeTestBean01.setId(11111111L);
    propTypeTestBean01.setIdentity(1111);
    propTypeTestBean01.setName("张三");
    propTypeTestBean01.setSalary(22000.5555);
    propTypeTestBean01.setStatus('Y');
    propTypeTestBean01.setSavedMoney(new BigDecimal("12345.6789"));

    Map<String, String> typeTestPropertyMap01 = Maps.newHashMap();
    typeTestPropertyMap01.put("age", "4");
    typeTestPropertyMap01.put("gender", "false");
    typeTestPropertyMap01.put("height", "178.25");
    typeTestPropertyMap01.put("id", "11111111");
    typeTestPropertyMap01.put("identity", "1111");
    typeTestPropertyMap01.put("name", "张三");
    typeTestPropertyMap01.put("salary", "22000.5555");
    typeTestPropertyMap01.put("status", "Y");

    assertTrue(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));
  }

  @Test(expected = PropertyInconsistentException.class)
  public void testDoIsPartPropertiesSameMapMore() throws Exception {
    PropTypeTestBean propTypeTestBean01 = new PropTypeTestBean();
    propTypeTestBean01.setAge((short) 4);
    propTypeTestBean01.setGender(false);
    propTypeTestBean01.setHeight(178.25f);
    propTypeTestBean01.setId(11111111L);
    propTypeTestBean01.setIdentity(1111);
    propTypeTestBean01.setName("张三");
    propTypeTestBean01.setSalary(22000.5555);
    propTypeTestBean01.setStatus('Y');
    propTypeTestBean01.setSavedMoney(new BigDecimal("12345.6789"));

    Map<String, String> typeTestPropertyMap01 = Maps.newHashMap();
    typeTestPropertyMap01.put("age", "4");
    typeTestPropertyMap01.put("gender", "false");
    typeTestPropertyMap01.put("height", "178.25");
    typeTestPropertyMap01.put("id", "11111111");
    typeTestPropertyMap01.put("identity", "1111");
    typeTestPropertyMap01.put("name", "张三");
    typeTestPropertyMap01.put("salary", "22000.5555");
    typeTestPropertyMap01.put("status", "Y");
    typeTestPropertyMap01.put("savedMoney", "12345.6789");
    typeTestPropertyMap01.put("extra", "extraValue");

    assertTrue(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, typeTestPropertyMap01));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDoIsPartPropertiesSameBeanNull() throws Exception {

    Map<String, String> typeTestPropertyMap01 = Maps.newHashMap();
    typeTestPropertyMap01.put("age", "4");
    typeTestPropertyMap01.put("gender", "false");
    typeTestPropertyMap01.put("height", "178.25");
    typeTestPropertyMap01.put("id", "11111111");
    typeTestPropertyMap01.put("identity", "1111");
    typeTestPropertyMap01.put("name", "张三");
    typeTestPropertyMap01.put("salary", "22000.5555");
    typeTestPropertyMap01.put("status", "Y");
    typeTestPropertyMap01.put("savedMoney", "12345.6789");
    typeTestPropertyMap01.put("extra", "extraValue");

    assertTrue(PartBeanUtil.doIsPartPropertiesSame(null, typeTestPropertyMap01));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDoIsPartPropertiesSameMapNull() throws Exception {
    PropTypeTestBean propTypeTestBean01 = new PropTypeTestBean();
    propTypeTestBean01.setAge((short) 4);
    propTypeTestBean01.setGender(false);
    propTypeTestBean01.setHeight(178.25f);
    propTypeTestBean01.setId(11111111L);
    propTypeTestBean01.setIdentity(1111);
    propTypeTestBean01.setName("张三");
    propTypeTestBean01.setSalary(22000.5555);
    propTypeTestBean01.setStatus('Y');
    propTypeTestBean01.setSavedMoney(new BigDecimal("12345.6789"));

    assertTrue(PartBeanUtil.doIsPartPropertiesSame(propTypeTestBean01, null));
  }
}
