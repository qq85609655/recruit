package org.amberframework.core.util;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.amberframework.core.util.testbean.TestAaa;
import org.amberframework.core.util.testbean.TestBbb;
import org.amberframework.core.util.testbean.TestCcc;
import org.amberframework.core.util.testbean.TestDdd;
import org.amberframework.core.util.testbean.TestEee;
import org.amberframework.core.util.testbean.TestFff;
import org.junit.Assert;
import org.junit.Test;


public class AmberBeanUtilsTest {

  @Test
  public void testCopyPropertiesDeeplySameClass() {
    TestAaa testAaaA = new TestAaa();
    testAaaA.setId(1111);
    testAaaA.setName("111");
    testAaaA.setAge(1);
    testAaaA.setSalary(new BigDecimal(11));

    TestAaa testAaaB = new TestAaa();
    testAaaB.setId(2222);
    testAaaB.setName("222");
    testAaaB.setAge(2);
    testAaaB.setSalary(new BigDecimal(22));

    try {
      AmberBeanUtils.copyBeanPropertiesDeeply(testAaaB, testAaaA);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
        | NoSuchMethodException e1) {
      e1.printStackTrace();
    }

    Assert.assertEquals(testAaaA.getId(), testAaaB.getId());
    Assert.assertEquals(testAaaA.getName(), testAaaB.getName());
    Assert.assertEquals(testAaaA.getAge(), testAaaB.getAge());
    Assert.assertEquals(testAaaA.getSalary(), testAaaB.getSalary());
  }

  @Test
  public void testCopyPropertiesDeeplyDiffClass() {
    String addressStr = "Hello London";
    {
      TestBbb testBbb1 = new TestBbb();
      testBbb1.setCid(333);
      testBbb1.setCname("33");
      testBbb1.setSex(true);

      TestCcc testCcc2 = new TestCcc();
      testCcc2.setCid(444);
      testCcc2.setCname("44");
      testCcc2.setSex(false);
      testCcc2.setAddress(addressStr);

      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(testCcc2, testBbb1);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }

      Assert.assertEquals(testCcc2.getCid(), testBbb1.getCid());
      Assert.assertEquals(testCcc2.getCname(), testBbb1.getCname());
      Assert.assertEquals(testCcc2.isSex(), testBbb1.isSex());
      Assert.assertEquals(testCcc2.getAddress(), addressStr);
    }

    {
      TestBbb testBbb1 = new TestBbb();
      testBbb1.setCid(333);
      testBbb1.setCname("33");
      testBbb1.setSex(true);

      TestCcc testCcc2 = new TestCcc();
      testCcc2.setCid(444);
      testCcc2.setCname("44");
      testCcc2.setSex(false);
      testCcc2.setAddress(addressStr);

      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(testBbb1, testCcc2);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }

      Assert.assertEquals(testCcc2.getCid(), testBbb1.getCid());
      Assert.assertEquals(testCcc2.getCname(), testBbb1.getCname());
      Assert.assertEquals(testCcc2.isSex(), testBbb1.isSex());
      Assert.assertEquals(testCcc2.getAddress(), addressStr);
    }
  }

  @Test
  public void testCopyPropertiesDeeplyInheritance() {
    Double length2 = 22.222;
    {
      TestAaa testAaa1 = new TestAaa();
      testAaa1.setId(1111);
      testAaa1.setName("111");
      testAaa1.setAge(1);
      testAaa1.setSalary(new BigDecimal(11));

      TestDdd testDdd2 = new TestDdd();
      testDdd2.setId(2222);
      testDdd2.setName("222");
      testDdd2.setAge(2);
      testDdd2.setSalary(new BigDecimal(22));
      testDdd2.setLength(length2);

      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(testDdd2, testAaa1);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }

      Assert.assertEquals(testAaa1.getId(), testDdd2.getId());
      Assert.assertEquals(testAaa1.getName(), testDdd2.getName());
      Assert.assertEquals(testAaa1.getAge(), testDdd2.getAge());
      Assert.assertEquals(testAaa1.getSalary(), testDdd2.getSalary());
      Assert.assertEquals(testDdd2.getLength(), length2);
    }

    {
      TestAaa testAaa1 = new TestAaa();
      testAaa1.setId(1111);
      testAaa1.setName("111");
      testAaa1.setAge(1);
      testAaa1.setSalary(new BigDecimal(11));

      TestDdd testDdd2 = new TestDdd();
      testDdd2.setId(2222);
      testDdd2.setName("222");
      testDdd2.setAge(2);
      testDdd2.setSalary(new BigDecimal(22));
      testDdd2.setLength(length2);

      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(testAaa1, testDdd2);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }

      Assert.assertEquals(testAaa1.getId(), testDdd2.getId());
      Assert.assertEquals(testAaa1.getName(), testDdd2.getName());
      Assert.assertEquals(testAaa1.getAge(), testDdd2.getAge());
      Assert.assertEquals(testAaa1.getSalary(), testDdd2.getSalary());
      Assert.assertEquals(testDdd2.getLength(), length2);
    }
  }

  @Test
  public void testCopyPropertiesDeeplyComposition() {
    String address1 = "111111";
    String address2 = "222222";
    {
      TestBbb testBbb1 = new TestBbb();
      testBbb1.setCid(1111);
      testBbb1.setCname("111");
      testBbb1.setSex(true);
      TestEee testEee1 = new TestEee();
      testEee1.setTestObj(testBbb1);
      testEee1.setAddress(address1);
      testEee1.setHobby("11111111");

      TestCcc testCcc2 = new TestCcc();
      testCcc2.setCid(2222);
      testCcc2.setCname("222");
      testCcc2.setSex(false);
      testCcc2.setAddress(address2);
      TestFff testFff2 = new TestFff();
      testFff2.setTestObj(testCcc2);
      testFff2.setHobby("22222222");

      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(testEee1, testFff2);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }

      Assert.assertEquals(testEee1.getTestObj().getCid(), testFff2.getTestObj().getCid());
      Assert.assertEquals(testEee1.getTestObj().getCname(), testFff2.getTestObj().getCname());
      Assert.assertEquals(testEee1.getTestObj().isSex(), testFff2.getTestObj().isSex());
      Assert.assertEquals(testEee1.getHobby(), testFff2.getHobby());
      Assert.assertEquals(testEee1.getAddress(), address1);
      Assert.assertEquals(testFff2.getTestObj().getAddress(), address2);
    }

    {
      TestBbb testBbb1 = new TestBbb();
      testBbb1.setCid(1111);
      testBbb1.setCname("111");
      testBbb1.setSex(true);
      TestEee testEee1 = new TestEee();
      testEee1.setTestObj(testBbb1);
      testEee1.setAddress(address1);
      testEee1.setHobby("11111111");

      TestCcc testCcc2 = new TestCcc();
      testCcc2.setCid(2222);
      testCcc2.setCname("222");
      testCcc2.setSex(false);
      testCcc2.setAddress(address2);
      TestFff testFff2 = new TestFff();
      testFff2.setTestObj(testCcc2);
      testFff2.setHobby("22222222");

      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(testFff2, testEee1);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }

      Assert.assertEquals(testEee1.getTestObj().getCid(), testFff2.getTestObj().getCid());
      Assert.assertEquals(testEee1.getTestObj().getCname(), testFff2.getTestObj().getCname());
      Assert.assertEquals(testEee1.getTestObj().isSex(), testFff2.getTestObj().isSex());
      Assert.assertEquals(testEee1.getHobby(), testFff2.getHobby());
      Assert.assertEquals(testEee1.getAddress(), address1);
      Assert.assertEquals(testFff2.getTestObj().getAddress(), address2);
    }
  }

  @Test
  public void testCopyPropertiesDeeplyPrimitive() {
    { // 测试int
      int intA = 1;
      int intB = 3;
      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(intB, intA);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e) {
        e.printStackTrace();
      }
      Assert.assertNotEquals(intA, intB);
    }

    { // 测试Ingeter
      Integer intAA = new Integer(2);
      Integer intBB = new Integer(4);
      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(intBB, intAA);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e) {
        e.printStackTrace();
      }
      Assert.assertNotEquals(intAA, intBB);
    }

    { // 测试double
      double doubleA = 11.11;
      double doubleB = 33.33;
      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(doubleA, doubleB);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e) {
        e.printStackTrace();
      }
      Assert.assertNotEquals(doubleA, doubleB);
    }

    { // 测试String
      String strA = "aaa";
      String strB = "bbb";
      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(strB, strA);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }
      Assert.assertNotEquals(strA, strB);
    }

    { // 测试BigDecimal
      BigDecimal bigA = new BigDecimal(1);
      BigDecimal bigB = new BigDecimal(3);
      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(bigB, bigA);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }
      Assert.assertNotEquals(bigA, bigB);
    }
  }
  
  @Test
  public void testCopyBeanPropDeeplyComposition() {
    String address1 = "111111";
    String address2 = "222222";
    {
      TestBbb testBbb1 = new TestBbb();
      testBbb1.setCid(1111);
      testBbb1.setCname("111");
      testBbb1.setSex(true);
      TestEee testEee1 = new TestEee();
      testEee1.setTestObj(testBbb1);
      testEee1.setAddress(address1);
      testEee1.setHobby("11111111");

      TestCcc testCcc2 = new TestCcc();
      testCcc2.setCid(2222);
      testCcc2.setCname("222");
      testCcc2.setSex(false);
      testCcc2.setAddress(address2);
      TestFff testFff2 = new TestFff();
      testFff2.setTestObj(testCcc2);
      testFff2.setHobby("22222222");

      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(testEee1, testFff2);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e1) {
        e1.printStackTrace();
      }

      Assert.assertEquals(testEee1.getTestObj().getCid(), testFff2.getTestObj().getCid());
      Assert.assertEquals(testEee1.getTestObj().getCname(), testFff2.getTestObj().getCname());
      Assert.assertEquals(testEee1.getTestObj().isSex(), testFff2.getTestObj().isSex());
      Assert.assertEquals(testEee1.getHobby(), testFff2.getHobby());
      Assert.assertEquals(testEee1.getAddress(), address1);
      Assert.assertEquals(testFff2.getTestObj().getAddress(), address2);
    }

    {
      TestBbb testBbb1 = new TestBbb();
      testBbb1.setCid(1111);
      testBbb1.setCname("111");
      testBbb1.setSex(true);
      TestEee testEee1 = new TestEee();
      testEee1.setTestObj(testBbb1);
      testEee1.setAddress(address1);
      testEee1.setHobby("11111111");

      TestCcc testCcc2 = new TestCcc();
      testCcc2.setCid(2222);
      testCcc2.setCname("222");
      testCcc2.setSex(false);
      testCcc2.setAddress(address2);
      TestFff testFff2 = new TestFff();
      testFff2.setTestObj(testCcc2);
      testFff2.setHobby("22222222");

      try {
        AmberBeanUtils.copyBeanPropDeeply(testFff2, testEee1);
      } catch (BeanPropertyCopyException ex) {
        throw ex;
      }

      Assert.assertEquals(testEee1.getTestObj().getCid(), testFff2.getTestObj().getCid());
      Assert.assertEquals(testEee1.getTestObj().getCname(), testFff2.getTestObj().getCname());
      Assert.assertEquals(testEee1.getTestObj().isSex(), testFff2.getTestObj().isSex());
      Assert.assertEquals(testEee1.getHobby(), testFff2.getHobby());
      Assert.assertEquals(testEee1.getAddress(), address1);
      Assert.assertEquals(testFff2.getTestObj().getAddress(), address2);
    }
  }
}
