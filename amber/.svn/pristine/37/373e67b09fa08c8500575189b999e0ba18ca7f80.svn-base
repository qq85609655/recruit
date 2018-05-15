package org.amberframework.core.bind.method;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 参数解析器，在Controller中如果有参数使用CurrentUser注解，
 * 会从request获取由shiro的SysUserFiler放入的当前登录用户对象.
 * <p>例如：controllerMethodName(@CurrentUser SysUser user)<br>
 * 不一定是SysUser类型，具体还要看Filter中放入的是什么
 * 
 * @author WangYu
 *
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(CurrentUser.class);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    CurrentUser currentUserAnnotation = parameter.getParameterAnnotation(CurrentUser.class);
    return webRequest.getAttribute(currentUserAnnotation.value(), NativeWebRequest.SCOPE_REQUEST);
  }

}
