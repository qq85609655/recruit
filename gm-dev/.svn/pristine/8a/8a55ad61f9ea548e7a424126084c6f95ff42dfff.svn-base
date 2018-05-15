package org.amberframework.core.spring.service.impl;

import java.lang.reflect.Method;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.core.io.support.PropertiesLoaderSupport;

import com.google.common.base.Throwables;

public class SpringPropertyResourceReader {

  private PropertyPlaceholderConfigurer propertyPlaceholderConfigurer;

  private Properties properties = new Properties();

  /**
   * 获取从PropertyPlaceholderConfigurer中取出的properties属性.
   */
  public SpringPropertyResourceReader(PropertyPlaceholderConfigurer propertyPlaceholderConfigurer) {
    this.propertyPlaceholderConfigurer = propertyPlaceholderConfigurer;
    try {
      PropertyResourceConfigurer propertyResourceConfigurer = this.propertyPlaceholderConfigurer;

      // get the method mergeProperties
      // in class PropertiesLoaderSupport
      Method mergeProperties = PropertiesLoaderSupport.class.getDeclaredMethod("mergeProperties");
      // get the props
      mergeProperties.setAccessible(true);
      Properties props = (Properties) mergeProperties.invoke(propertyResourceConfigurer);

      // get the method convertProperties
      // in class PropertyResourceConfigurer
      Method convertProperties =
          PropertyResourceConfigurer.class.getDeclaredMethod("convertProperties", Properties.class);
      // convert properties
      convertProperties.setAccessible(true);
      convertProperties.invoke(propertyResourceConfigurer, props);

      properties.putAll(props);

    } catch (Exception ex) {
      throw Throwables.propagate(ex);
    }
  }

  /**
   * 根据传入的propertyName获取属性值返回.
   */
  public String getProperty(String propertyName) {
    return properties.getProperty(propertyName);
  }
}
