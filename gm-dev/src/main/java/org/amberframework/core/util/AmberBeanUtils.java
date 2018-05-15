package org.amberframework.core.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmberBeanUtils {

  private static final Logger logger = LoggerFactory.getLogger(AmberBeanUtils.class);

  private AmberBeanUtils() {

  }

  /**
   * 兼容性深copy名字相同的属性，如果出错抛出统一异常，基础类型（还有String和BigDecimal等）不支持。会copy属性对象的属性，逐级递归，需要dest的属性可写和orig的对应属性可读.
   * <ul>
   * <li>支持不同类型的对象copy，只会copy名字相同的属性，同名但类型不同的属性对象继续递归本方法，尽量兼容copy所有可以copy的属性及属性对象的属性.
   * <li>支持数组的copy，目标数组长度不能小于原始数组长度.
   * <li>不支持九种基本类型，其对应对象类型和其数组的copy（String和BigDecimal这样的内部属性不可见对象也不支持，其实不是不支持，是属性不可见导致无法copy）.
   * </ul>
   * 
   * @param dest 目标对象
   * @param orig 原始对象
   * @throws BeanPropertyCopyException Bean deeply copy 统一抛出的异常
   */
  public static void copyBeanPropDeeply(Object dest, Object orig) {
    try {
      copyBeanPropertiesDeeply(dest, orig);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException
        | NoSuchMethodException ex) {
      throw new BeanPropertyCopyException("Copy bean prop fail", ex);
    }
  }

  /**
   * 兼容性深copy名字相同的属性，基础类型（还有String和BigDecimal等）不支持。会copy属性对象的属性，逐级递归，需要dest的属性可写和orig的对应属性可读.
   * <ul>
   * <li>支持不同类型的对象copy，只会copy名字相同的属性，同名但类型不同的属性对象继续递归本方法，尽量兼容copy所有可以copy的属性及属性对象的属性.
   * <li>支持数组的copy，目标数组长度不能小于原始数组长度.
   * <li>不支持九种基本类型，其对应对象类型和其数组的copy（String和BigDecimal这样的内部属性不可见对象也不支持，其实不是不支持，是属性不可见导致无法copy）.
   * </ul>
   * 
   * @param dest 目标对象
   * @param orig 原始对象
   * @throws IllegalAccessException IllegalAccessException
   * @throws InstantiationException InstantiationException
   * @throws InvocationTargetException InvocationTargetException
   * @throws NoSuchMethodException NoSuchMethodException
   */
  @SuppressWarnings("rawtypes")
  public static void copyBeanPropertiesDeeply(Object dest, Object orig) throws InstantiationException,
      IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    if (null == dest) {
      throw new IllegalArgumentException("No destination bean specified, is null");
    }
    if (null == orig) {
      throw new IllegalArgumentException("No destination bean specified, is null");
    }

    Class origClass = orig.getClass();
    Class destClass = dest.getClass();

    // 判断是否为基本类型或String, 如果是则直接赋值
    if (String.class == origClass || String.class == destClass) {
      logger.warn("java.lang.String cannot use this function to copy properties");
      return;
    } else if (origClass.isPrimitive() || destClass.isPrimitive() || isPrimitiveClass(origClass)
        || isPrimitiveClass(destClass)) {
      logger.warn("Primitive type cannot use this function to copy properties");
      return;
    }

    // 判断是否都是数组，如果都是数组，进行数组元素的兼容性deep copy
    if (origClass.isArray() && destClass.isArray()) {
      Object[] origArray = (Object[]) orig;
      Object[] destArray = (Object[]) dest;
      Class origElementClass = origArray.getClass().getComponentType();
      Class destElementClass = destArray.getClass().getComponentType();
      if (origElementClass.isPrimitive() || destElementClass.isPrimitive()
          || isPrimitiveClass(origElementClass) || isPrimitiveClass(destElementClass)) {
        logger.warn("Primitive type array cannot use this function to copy properties");
        return;
      }
      for (int i = 0; i < origArray.length; i++) {
        if (null == destArray[i]) {
          destArray[i] = destElementClass.newInstance();
        }
        copyBeanPropertiesDeeply(destArray[i], origArray[i]);
      }
      return;
    } else if (origClass.isArray() && !destClass.isArray()) {
      throw new IllegalArgumentException("orig is array but dest is not array");
    } else if (!origClass.isArray() && destClass.isArray()) {
      throw new IllegalArgumentException("dest is array but orig is not array");
    }

    // 获取属性集合，遍历进行copy
    PropertyDescriptor[] origPropertyDescriptors = PropertyUtils.getPropertyDescriptors(orig);
    for (PropertyDescriptor propertyDesc : origPropertyDescriptors) {
      // 赋值属性
      copyProperty(dest, orig, propertyDesc);
    }
  }

  /**
   * 判断对象是否是8种基本类型对应的Bean类型.
   * <p>
   * boolean, byte, char, short, int, long, float, double对应的 Boolean, Byte, Character, Short, Integer, Long,
   * Float, Double.
   */
  @SuppressWarnings("rawtypes")
  public static boolean isPrimitiveClass(Class clazz) {
    Class objClass = clazz.getClass();
    if (Boolean.class == objClass) {
      return true;
    } else if (Byte.class == objClass) {
      return true;
    } else if (Character.class == objClass) {
      return true;
    } else if (Short.class == objClass) {
      return true;
    } else if (Integer.class == objClass) {
      return true;
    } else if (Long.class == objClass) {
      return true;
    } else if (Float.class == objClass) {
      return true;
    } else {
      // 最后判断Double，再不是就返回false
      return Double.class == objClass;
    }
  }

  /**
   * 将orig中的propertyDesc属性，赋值(copy)给dest，如果属性是对象且类型不一致，还会进行兼容性深copy.
   * 
   * @param dest 目标对象
   * @param orig 原始对象
   * @param propertyDesc 属性描述
   * @throws InstantiationException InstantiationException
   * @throws IllegalAccessException IllegalAccessException
   * @throws InvocationTargetException InvocationTargetException
   * @throws NoSuchMethodException NoSuchMethodException
   */
  private static void copyProperty(Object dest, Object orig, PropertyDescriptor propertyDesc)
      throws InstantiationException, IllegalAccessException, 
          InvocationTargetException, NoSuchMethodException {
    String propertyName = propertyDesc.getName();
    // getPropertyDescriptors方法会将class本身也作为属性取出，所以要将class属性跳过
    if ("class".equals(propertyName)) {
      return;
    }

    Object value = null;
    // 先判断属性的读写权限，同时也能检查目标中是否有此属性
    if (PropertyUtils.isReadable(orig, propertyName) && PropertyUtils.isWriteable(dest, propertyName)) {
      try {
        value = PropertyUtils.getSimpleProperty(orig, propertyName);
        PropertyUtils.setSimpleProperty(dest, propertyName, value);
      } catch (IllegalArgumentException iae) {
        logger.error(iae.toString());
        // 出现此异常说明说明此属性对象不能直接copy，类型不兼容，需要递归进行兼容性copy
        copyDifferentTypeProperty(dest, propertyName, value);
      } catch (IllegalAccessException iae) {
        throw iae;
      } catch (InvocationTargetException ite) {
        throw ite;
      } catch (NoSuchMethodException nme) {
        throw nme;
      }
    }
  }

  /**
   * 属性是一个对象，而且类型不兼容导致不能直接copy，需要递归对这个属性对象中的属性进行兼容性copy.
   * 
   * @param dest 需要被赋值的目标对象
   * @param propertyName 目标对象中要被赋值的属性
   * @param value 准备复制到目标对象的属性值，是一个对象
   * @throws InstantiationException InstantiationException
   * @throws IllegalAccessException IllegalAccessException
   * @throws InvocationTargetException InvocationTargetException
   * @throws NoSuchMethodException NoSuchMethodException
   */
  private static void copyDifferentTypeProperty(Object dest, String propertyName, Object value)
      throws InstantiationException, IllegalAccessException, 
          InvocationTargetException, NoSuchMethodException {
    try {
      if (null != dest) {
        // 先获取dest属性对象中的值，如果取不到，则创建一个该属性对象的实例
        Object newValue = PropertyUtils.getSimpleProperty(dest, propertyName);
        if (null == newValue) {
          PropertyDescriptor destPropertyDesc = PropertyUtils.getPropertyDescriptor(dest, propertyName);
          newValue = destPropertyDesc.getPropertyType().newInstance();
        }
        copyBeanPropertiesDeeply(newValue, value); // 递归调用（deep copy）
        PropertyUtils.setSimpleProperty(dest, propertyName, newValue);
      }
    } catch (IllegalArgumentException e1) {
      // 此异常说明要copy的属性无法匹配，无法进行兼容性copy，忽略即可
      logger.debug(propertyName, e1);
    } catch (IllegalAccessException e1) {
      throw e1;
    } catch (InvocationTargetException e1) {
      throw e1;
    } catch (NoSuchMethodException e1) {
      throw e1;
    }
  }
}
