package org.amberframework.core.util;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;


public class MyBatisCriteriaUtils {

  private static final Logger logger = LoggerFactory.getLogger(MyBatisCriteriaUtils.class);

  private static final String CRITERIA_ATTRIBUTE_ORDER_BY_CLAUSE = "orderByClause";
  private static final String CRITERIA_ATTRIBUTE_DISTINCT = "distinct";
  private static final String CRITERIA_ATTRIBUTE_PAGE = "page";
  private static final String CRITERIA_ATTRIBUTE_ORED_CRETERIA = "oredCriteria";

  private static final String ORED_CRITERIA_ELEMENT_ATTR_CRETERIA = "criteria";

  private static final String CRITERION_ATTRIBUTE_CONDITION = "condition";
  private static final String CRITERION_ATTRIBUTE_VALUE = "value";
  private static final String CRITERION_ATTRIBUTE_SECOND_VALUE = "secondValue";
  private static final String CRITERION_ATTRIBUTE_NO_VALUE = "noValue";
  private static final String CRITERION_ATTRIBUTE_SINGLE_VALUE = "singleValue";
  private static final String CRITERION_ATTRIBUTE_BETWEEN_VALUE = "betweenValue";
  private static final String CRITERION_ATTRIBUTE_LIST_VALUE = "listValue";
  private static final String CRITERION_ATTRIBUTE_TYPE_HANDLER = "typeHandler";

  private MyBatisCriteriaUtils() {

  }

  /**
   * 判断两个Criteria是否相等，会检查所有属性，Criteria对象类型必须一致.
   * 
   * @param first 第一个Criteria对象
   * @param second 第二个Criteria对象
   * @return 是否相等
   */
  @SuppressWarnings("rawtypes")
  public static boolean compareCriteriaEquals(Object first, Object second) {
    Class firstClass = first.getClass();
    Class secondClass = second.getClass();
    if (firstClass != secondClass) {
      return false;
    }

    try {
      if (!compareObjectAttributeEquals(first, second, CRITERIA_ATTRIBUTE_ORDER_BY_CLAUSE)) {
        return false;
      }
      if (!compareObjectAttributeEquals(first, second, CRITERIA_ATTRIBUTE_DISTINCT)) {
        return false;
      }
      if (!compareObjectAttributeEquals(first, second, CRITERIA_ATTRIBUTE_PAGE)) {
        return false;
      }

      // 判断oredCriteria集合是否完全相等
      Object firstOredCriteriaValue =
          PropertyUtils.getSimpleProperty(first, CRITERIA_ATTRIBUTE_ORED_CRETERIA);
      Object secondOredCriteriaValue =
          PropertyUtils.getSimpleProperty(second, CRITERIA_ATTRIBUTE_ORED_CRETERIA);
      List firstOredCriteriaList = (List) firstOredCriteriaValue;
      List secondOredCriteriaList = (List) secondOredCriteriaValue;
      // 因为oredCriteria是ArrayList，所以直接按照顺序比较
      if (firstOredCriteriaList.size() != secondOredCriteriaList.size()) {
        logger.debug("OredCriteriaList size is not equals");
        return false;
      }
      int oredListSize = firstOredCriteriaList.size();
      for (int oredIndex = 0; oredIndex < oredListSize; oredIndex++) {
        Object firstOredElement = firstOredCriteriaList.get(oredIndex);
        Object secondOredElement = secondOredCriteriaList.get(oredIndex);

        if (!compareOredCriteriaElementEquals(firstOredElement, secondOredElement)) {
          return false;
        }
      }
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
      Throwables.propagate(ex);
    }

    return true;
  }

  /**
   * 比较oredCriteria对象是否相等.
   * 
   * @param firstOredElement oredCriteria对象
   * @param secondOredElement oredCriteria对象
   * @return 是否相等
   */
  @SuppressWarnings("rawtypes")
  private static boolean compareOredCriteriaElementEquals(Object firstOredElement, Object secondOredElement)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Object firstCriteriaValue =
        PropertyUtils.getSimpleProperty(firstOredElement, ORED_CRITERIA_ELEMENT_ATTR_CRETERIA);
    Object secondCriteriaValue =
        PropertyUtils.getSimpleProperty(secondOredElement, ORED_CRITERIA_ELEMENT_ATTR_CRETERIA);
    List firstCriteriaList = (List) firstCriteriaValue;
    List secondCriteriaList = (List) secondCriteriaValue;
    if (firstCriteriaList.size() != secondCriteriaList.size()) {
      logger.debug("CriteriaList size is not equals");
      return false;
    }
    int criteriaListSize = firstCriteriaList.size();
    for (int listIndex = 0; listIndex < criteriaListSize; listIndex++) {
      Object firstCriterion = firstCriteriaList.get(listIndex);
      Object secondCriterion = secondCriteriaList.get(listIndex);
      if (!compareCriterionEquals(firstCriterion, secondCriterion)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 判断两个Criterion对象是否相等.
   * 
   * @param firstCriterion 第一个Criterion对象
   * @param secondCriterion 第二个Criterion对象
   * @return 是否相等
   */
  private static boolean compareCriterionEquals(Object firstCriterion, Object secondCriterion)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    if (null == firstCriterion && null == secondCriterion) {
      return true;
    } else if (null == firstCriterion && secondCriterion != null) {
      logger.debug("Criterion is not equals");
      return false;
    } else if (firstCriterion != null && null == secondCriterion) {
      logger.debug("Criterion is not equals");
      return false;
    }

    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_CONDITION)) {
      return false;
    }
    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_VALUE)) {
      return false;
    }
    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_SECOND_VALUE)) {
      return false;
    }
    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_NO_VALUE)) {
      return false;
    }
    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_SINGLE_VALUE)) {
      return false;
    }
    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_BETWEEN_VALUE)) {
      return false;
    }
    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_LIST_VALUE)) {
      return false;
    }
    if (!compareObjectAttributeEquals(firstCriterion, secondCriterion, CRITERION_ATTRIBUTE_TYPE_HANDLER)) {
      return false;
    }

    return true;
  }

  /**
   * 比较两个对象的指定属性是否相等.
   * 
   * @param firstObj 第一个对象
   * @param secondObj 第二个对象
   * @param attributeName 要比较的属性名称
   * @return 属性是否相等
   */
  private static boolean
      compareObjectAttributeEquals(Object firstObj, Object secondObj, String attributeName)
          throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Object firstCondition = PropertyUtils.getSimpleProperty(firstObj, attributeName);
    Object secondCondition = PropertyUtils.getSimpleProperty(secondObj, attributeName);
    if (null == firstCondition && null == secondCondition) {
      return true;
    } else if (null == firstCondition && secondCondition != null) {
      logAttributeIsNotEquals(attributeName);
      return false;
    } else if (null != firstCondition && null == secondCondition) {
      logAttributeIsNotEquals(attributeName);
      return false;
    } else if (firstCondition != null && firstCondition.equals(secondCondition)) {
      return true;
    }
    logAttributeIsNotEquals(attributeName);
    return false;
  }

  private static void logAttributeIsNotEquals(String attributeName) {
    logger.debug("Attribute " + attributeName + " is not equals");
  }
}
