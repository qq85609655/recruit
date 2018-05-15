package org.amberframework.core.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.amberframework.core.constant.WebConstants;

/**
 * 绑定当前登录的用户.
 * 
 * @author WangYu
 *
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

  /**
   * 当前用户在request中的Parameter key.
   */
  String value() default WebConstants.CURRENT_USER;
}
