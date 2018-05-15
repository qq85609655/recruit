package org.amberframework.core.converter.json;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.GsonBuilder;

public class AmberGsonHttpMessageConverter extends GsonHttpMessageConverter {

  /**
   * 执行GsonMessageConverter初始化工作，确定日期时间转化格式.
   */
  public void init() {
    if (logger.isInfoEnabled()) {
      logger.info("AmberGsonHttpMessageConverter类init方法");
    }
    this.setGson(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create());
  }

}
