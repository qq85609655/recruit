package com.csot.gm.util;

import com.google.common.base.Throwables;

import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by WangYu on 2015/11/4.
 */
public class PartBeanUtil {
  private PartBeanUtil() {}

  /**
   * 对比Object的属性值和Map中的同名key对应的value值是否相同. 如果Object属性和Map中key对不上的话，无论谁多谁少，都抛出运行时异常
   * {@code PropertyInconsistentException}.
   *
   * @param obj 要对比属性的对象
   * @param propertyMap 要对比的属性集合
   * @return 属性值全都相等，则返回true，否则返回false
   */
  public static boolean doIsPartPropertiesSame(Object obj, Map<String, String> propertyMap) {
    if (null == obj) {
      throw new IllegalArgumentException("No object bean specified, is null");
    }
    if (null == propertyMap) {
      throw new IllegalArgumentException("No object bean specified, is null");
    }

    // 获取属性集合，遍历进行copy
    PropertyDescriptor[] origPropertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);
    String propertyName;
    int propertyCount = 0;
    for (PropertyDescriptor propertyDesc : origPropertyDescriptors) {
      // 属性值比较
      propertyName = propertyDesc.getName();
      // getPropertyDescriptors方法会将class本身也作为属性取出，所以要将class属性跳过
      // 判断属性是否可以访问，如果是内部属性不提供get方法，则忽略
      if ("class".equals(propertyName) || !PropertyUtils.isReadable(obj, propertyName)) {
        continue;
      }
      String mapValue = propertyMap.get(propertyName);
      // 如果对象中的属性在map中找不到，则抛出异常
      if (null == mapValue) {
        throw new PropertyInconsistentException(propertyName + "属性，对象有但是map中没有");
      }
      if (!compareProperties(propertyName, obj, mapValue)) {
        return false;
      }
      // 记录比较属性的个数
      propertyCount++;
    }

    if (propertyCount < propertyMap.size()) {
      throw new PropertyInconsistentException("对象中属性数量少于map中属性数量");
    }

    return true;
  }

  private static boolean compareProperties(String propertyName, Object obj, String mapValue) {
    try {
      Object value = PropertyUtils.getSimpleProperty(obj, propertyName);
      return mapValue.equals(String.valueOf(value));
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
      throw Throwables.propagate(ex);
    }
  }
}
