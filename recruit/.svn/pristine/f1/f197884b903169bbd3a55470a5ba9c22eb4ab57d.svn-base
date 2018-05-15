package org.amberframework.core.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DefaultExceptionHandler {
  
  private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);
  
  /**
   * 没有权限 异常.
   * <p>
   * 后续根据不同的需求定制即可.
   */
  @ExceptionHandler({UnauthorizedException.class})
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ModelAndView processUnauthenticatedException(NativeWebRequest request,
      UnauthorizedException ex) {
    logger.error(ex.getMessage(), ex);
    ModelAndView mv = new ModelAndView();
    mv.addObject("exception", "您没有权限[" + ex.getMessage() + "]");
    mv.setViewName("unauthorized");
    return mv;
  }

  /**
   * 异常控制，可做到异常细节可控，将来也可用于支持异常信息国际化.
   **/
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ModelAndView handleException(Exception ex, HttpServletRequest request) {
    logger.error(ex.getMessage(), ex);
    return new ModelAndView().addObject("exception", "对不起，出现异常：<br>" + ex.getMessage());
  }
}
