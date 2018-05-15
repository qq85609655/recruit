package org.amberframework.core.exception.method;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * Controller中抛出的异常，由此异常解析器统一控制.
 * <ul>
 * <li>ajax请求（有@ResponseBody的Controller）发生错误，输出JSON
 * <li>页面请求（无@ResponseBody的Controller）发生错误，输出错误页面
 * </ul>
 * <p>
 * 需要与AnnotationMethodHandlerAdapter(或&lt;mvc:annotation-driven&gt;标签)使用同一个messageConverters<br>
 * DefaultExceptionHandler(@ControllerAdvice)有处理异常的方法
 *
 **/
public class AnnotationHandlerMethodExceptionResolver extends ExceptionHandlerExceptionResolver {

  private String defaultErrorView;

  public String getDefaultErrorView() {
    return defaultErrorView;
  }

  public void setDefaultErrorView(String defaultErrorView) {
    this.defaultErrorView = defaultErrorView;
  }

  @Override
  protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request,
      HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {
    if (null == handlerMethod) {
      return null;
    }

    Method method = handlerMethod.getMethod();
    if (method == null) {
      return null;
    }

    ModelAndView returnValue =
        super.doResolveHandlerMethodException(request, response, handlerMethod, exception);

    ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(method, ResponseBody.class);
    if (responseBodyAnn != null) {
      try {
        return handleResponseBodyWithStatus(method, returnValue, request, response);
      } catch (ServletException | IOException ex) {
        logger.error(ex.getMessage(), ex);
        return null;
      }
    }

    if (returnValue.getViewName() == null) {
      returnValue.setViewName(this.defaultErrorView);
    }

    return returnValue;
  }

  private ModelAndView handleResponseBodyWithStatus(Method method, ModelAndView returnValue,
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ResponseStatus responseStatusAnn = AnnotationUtils.findAnnotation(method, ResponseStatus.class);
    if (responseStatusAnn != null) {
      HttpStatus responseStatus = responseStatusAnn.value();
      String reason = responseStatusAnn.reason();
      if (StringUtils.isEmpty(reason)) {
        response.setStatus(responseStatus.value());
      } else {
        try {
          response.sendError(responseStatus.value(), reason);
        } catch (IOException ex) {
          logger.error(ex.getMessage(), ex);
        }
      }
    }
    return handleResponseBody(returnValue, request, response);
  }

  @SuppressWarnings({ "unchecked", "rawtypes", "resource" })
  private ModelAndView handleResponseBody(ModelAndView returnValue, HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    Map value = returnValue.getModelMap();
    HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
    List<MediaType> acceptedMediaTypes = inputMessage.getHeaders().getAccept();
    if (acceptedMediaTypes.isEmpty()) {
      acceptedMediaTypes = Collections.singletonList(MediaType.ALL);
    }
    MediaType.sortByQualityValue(acceptedMediaTypes);
    HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
    Class<?> returnValueType = value.getClass();
    List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
    if (messageConverters == null) {
      if (logger.isWarnEnabled()) {
        logger.warn("Cannot get any MessageConverters");
      }
      return null;
    }
    for (MediaType acceptedMediaType : acceptedMediaTypes) {
      for (HttpMessageConverter messageConverter : messageConverters) {
        if (messageConverter.canWrite(returnValueType, acceptedMediaType)) {
          messageConverter.write(value, acceptedMediaType, outputMessage);
          return new ModelAndView();
        }
      }
    }
    if (logger.isWarnEnabled()) {
      logger.warn("Could not find HttpMessageConverter that supports return type [" + returnValueType
          + "] and " + acceptedMediaTypes);
    }
    return null;
  }

}
