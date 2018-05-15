package org.amberframework.core.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.system.auth.model.original.group.SysGroupCriteria;
import org.amberframework.web.system.auth.model.original.user.SysUserCriteria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyBatisCriteriaUtilsTest {

  @Before
  public void setUp() throws Exception {
    
  }

  @After
  public void tearDown() throws Exception {
    
  }

  @Test
  public void testCompareCriteriaEquals() {
    SysUserCriteria criteria01 = new SysUserCriteria();
    SysUserCriteria criteria02 = new SysUserCriteria();
    assertTrue(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    
    Page page03 = Page.newInstanceWithPageIndex(3, 10);
    Page page04 = Page.newInstanceWithPageIndex(5, 30);
    criteria01.setPage(page03);
    criteria02.setPage(page04);
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    
    Page page01 = Page.newInstanceWithPageIndex(2, 20);
    Page page02 = Page.newInstanceWithPageIndex(2, 20);
    criteria01.setPage(page01);
    criteria02.setPage(page02);
    assertTrue(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    
    criteria01.setDistinct(false);
    criteria02.setDistinct(true);
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.setDistinct(false);
    criteria02.setDistinct(false);
    
    criteria01.setOrderByClause("account desc");
    criteria02.setOrderByClause("id asc");
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    
    criteria01.setOrderByClause("id desc");
    criteria02.setOrderByClause("id desc");
    assertTrue(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    
    criteria01.or().andIdBetween("1", "2");
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria02.or().andIdBetween("1", "5");
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    criteria01.or().andIdBetween("3", "6");
    criteria02.or().andIdBetween("3", "6");
    assertTrue(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    
    criteria01.or().andSaltGreaterThanOrEqualTo("1").andAccountEqualTo("admin");
    criteria02.or().andSaltGreaterThanOrEqualTo("1");
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    criteria01.or().andIdBetween("3", "6");
    criteria02.or().andIdBetween("3", "6");
    criteria01.or().andSaltGreaterThanOrEqualTo("1").andAccountEqualTo("admin");
    criteria02.or().andSaltGreaterThanOrEqualTo("1").andAccountEqualTo("admin");
    assertTrue(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    
    criteria01.or().andAccountLike("user%");
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    criteria01.or().andIdEqualTo("111").andAccountIsNull();
    criteria02.or().andIdEqualTo("111").andAccountIsNotNull();
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    criteria01.or().andIdEqualTo("111").andAccountIsNull();
    criteria02.or().andIdEqualTo("111").andAccountIsNull();
    assertTrue(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    criteria01.or().andIdBetween("1", "5");
    criteria02.or().andIdNotBetween("1", "5");
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    criteria01.or().andIdBetween("1", "5");
    criteria02.or().andIdNotBetween("1", "5");
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    List<String> accountList01 = new ArrayList<String>();
    accountList01.add("admin");
    accountList01.add("user01");
    List<String> accountList02 = new ArrayList<String>();
    accountList02.add("admin");
    accountList02.add("user01");
    criteria01.or().andAccountIn(accountList01);
    criteria02.or().andAccountNotIn(accountList02);
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    criteria01.or().andAccountIn(accountList01);
    criteria02.or().andAccountIn(accountList02);
    assertTrue(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    List<String> accountList03 = new ArrayList<String>();
    accountList03.add("admin");
    accountList03.add("user01");
    List<String> accountList04 = new ArrayList<String>();
    accountList04.add("admin");
    accountList04.add("user02");
    criteria01.or().andAccountIn(accountList03);
    criteria02.or().andAccountIn(accountList04);
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria01, criteria02));
    criteria01.clear();
    criteria02.clear();
    
    SysUserCriteria criteria03 = new SysUserCriteria();
    SysGroupCriteria criteria04 = new SysGroupCriteria();
    assertFalse(MyBatisCriteriaUtils.compareCriteriaEquals(criteria03, criteria04));
  }

}
