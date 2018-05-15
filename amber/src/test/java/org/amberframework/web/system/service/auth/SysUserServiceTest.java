package org.amberframework.web.system.service.auth;

import javax.annotation.Resource;

import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.user.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class SysUserServiceTest {

  @Resource
  SysUserService sysUserService;
  
  @Test
  public void testChangPassword() {
    // 查询用户
    SysUser user = sysUserService.getByPrimaryKey("a9fa43ea002a441d948d7e495d2faf43");
    Assert.notNull(user);
  }
}
