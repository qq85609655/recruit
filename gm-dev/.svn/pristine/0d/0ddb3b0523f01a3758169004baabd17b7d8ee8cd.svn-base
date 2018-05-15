package org.amberframework.core.util;

import java.lang.reflect.Field;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;

/**
 * 根据代理对象获取目标实际对象的工具类.
 */
public class AopTargetUtils {

  private AopTargetUtils() {

  }

  /**
   * 获取 目标对象.
   * 
   * @param proxy 代理对象
   * @return 目标对象
   * @throws Exception NoSuchFieldException, SecurityException, IllegalArgumentException,
   *         IllegalAccessException, Exception
   */
  public static Object getTarget(Object proxy) throws Exception {
    if (!AopUtils.isAopProxy(proxy)) {
      return proxy; // 不是代理对象
    }
    if (AopUtils.isJdkDynamicProxy(proxy)) {
      return getJdkDynamicProxyTargetObject(proxy);
    } else { // cglib
      return getCglibProxyTargetObject(proxy);
    }
  }

  private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
    Field hdField = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
    hdField.setAccessible(true);
    Object dynamicAdvisedInterceptor = hdField.get(proxy);
    Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
    advised.setAccessible(true);
    return ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
  }


  private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
    Field hdField = proxy.getClass().getSuperclass().getDeclaredField("h");
    hdField.setAccessible(true);
    AopProxy aopProxy = (AopProxy) hdField.get(proxy);
    Field advised = aopProxy.getClass().getDeclaredField("advised");
    advised.setAccessible(true);
    return ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
  }
}
