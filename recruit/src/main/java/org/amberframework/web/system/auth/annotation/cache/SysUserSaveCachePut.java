package org.amberframework.web.system.auth.annotation.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

/**
 * 输入参数一定是SysUser类型，且名字叫sysUser。id和account属性有值.
 */
@Caching(put = { 
    @CachePut(value = "sys-user", key = "#result.id"),
    @CachePut(value = "sys-user", key = "#result.account") 
})
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SysUserSaveCachePut {

}
