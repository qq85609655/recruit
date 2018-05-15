package com.csot.gm.materialManage.model.original.properties;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class PartPropertiesCriteria {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  protected Page page;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public PartPropertiesCriteria() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0) {
      oredCriteria.add(criteria);
    }
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public Page getPage() {
    return this.page;
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  protected abstract static class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
      super();
      criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
      return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
      return criteria;
    }

    public List<Criterion> getCriteria() {
      return criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andIdIsNull() {
      addCriterion("ID is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(String value) {
      addCriterion("ID =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(String value) {
      addCriterion("ID <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(String value) {
      addCriterion("ID >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(String value) {
      addCriterion("ID >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(String value) {
      addCriterion("ID <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(String value) {
      addCriterion("ID <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLike(String value) {
      addCriterion("ID like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotLike(String value) {
      addCriterion("ID not like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<String> values) {
      addCriterion("ID in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<String> values) {
      addCriterion("ID not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(String value1, String value2) {
      addCriterion("ID between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(String value1, String value2) {
      addCriterion("ID not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andPropertyNameIsNull() {
      addCriterion("PROPERTY_NAME is null");
      return (Criteria) this;
    }

    public Criteria andPropertyNameIsNotNull() {
      addCriterion("PROPERTY_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andPropertyNameEqualTo(String value) {
      addCriterion("PROPERTY_NAME =", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameNotEqualTo(String value) {
      addCriterion("PROPERTY_NAME <>", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameGreaterThan(String value) {
      addCriterion("PROPERTY_NAME >", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameGreaterThanOrEqualTo(String value) {
      addCriterion("PROPERTY_NAME >=", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameLessThan(String value) {
      addCriterion("PROPERTY_NAME <", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameLessThanOrEqualTo(String value) {
      addCriterion("PROPERTY_NAME <=", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameLike(String value) {
      addCriterion("PROPERTY_NAME like", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameNotLike(String value) {
      addCriterion("PROPERTY_NAME not like", value, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameIn(List<String> values) {
      addCriterion("PROPERTY_NAME in", values, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameNotIn(List<String> values) {
      addCriterion("PROPERTY_NAME not in", values, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameBetween(String value1, String value2) {
      addCriterion("PROPERTY_NAME between", value1, value2, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPropertyNameNotBetween(String value1, String value2) {
      addCriterion("PROPERTY_NAME not between", value1, value2, "propertyName");
      return (Criteria) this;
    }

    public Criteria andPartIdIsNull() {
      addCriterion("PART_ID is null");
      return (Criteria) this;
    }

    public Criteria andPartIdIsNotNull() {
      addCriterion("PART_ID is not null");
      return (Criteria) this;
    }

    public Criteria andPartIdEqualTo(String value) {
      addCriterion("PART_ID =", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdNotEqualTo(String value) {
      addCriterion("PART_ID <>", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdGreaterThan(String value) {
      addCriterion("PART_ID >", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdGreaterThanOrEqualTo(String value) {
      addCriterion("PART_ID >=", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdLessThan(String value) {
      addCriterion("PART_ID <", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdLessThanOrEqualTo(String value) {
      addCriterion("PART_ID <=", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdLike(String value) {
      addCriterion("PART_ID like", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdNotLike(String value) {
      addCriterion("PART_ID not like", value, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdIn(List<String> values) {
      addCriterion("PART_ID in", values, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdNotIn(List<String> values) {
      addCriterion("PART_ID not in", values, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdBetween(String value1, String value2) {
      addCriterion("PART_ID between", value1, value2, "partId");
      return (Criteria) this;
    }

    public Criteria andPartIdNotBetween(String value1, String value2) {
      addCriterion("PART_ID not between", value1, value2, "partId");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameIsNull() {
      addCriterion("PROPERTY_DIS_NAME is null");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameIsNotNull() {
      addCriterion("PROPERTY_DIS_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameEqualTo(String value) {
      addCriterion("PROPERTY_DIS_NAME =", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameNotEqualTo(String value) {
      addCriterion("PROPERTY_DIS_NAME <>", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameGreaterThan(String value) {
      addCriterion("PROPERTY_DIS_NAME >", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameGreaterThanOrEqualTo(String value) {
      addCriterion("PROPERTY_DIS_NAME >=", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameLessThan(String value) {
      addCriterion("PROPERTY_DIS_NAME <", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameLessThanOrEqualTo(String value) {
      addCriterion("PROPERTY_DIS_NAME <=", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameLike(String value) {
      addCriterion("PROPERTY_DIS_NAME like", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameNotLike(String value) {
      addCriterion("PROPERTY_DIS_NAME not like", value, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameIn(List<String> values) {
      addCriterion("PROPERTY_DIS_NAME in", values, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameNotIn(List<String> values) {
      addCriterion("PROPERTY_DIS_NAME not in", values, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameBetween(String value1, String value2) {
      addCriterion("PROPERTY_DIS_NAME between", value1, value2, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameNotBetween(String value1, String value2) {
      addCriterion("PROPERTY_DIS_NAME not between", value1, value2, "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitIsNull() {
      addCriterion("PROPERTY_UNIT is null");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitIsNotNull() {
      addCriterion("PROPERTY_UNIT is not null");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitEqualTo(String value) {
      addCriterion("PROPERTY_UNIT =", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitNotEqualTo(String value) {
      addCriterion("PROPERTY_UNIT <>", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitGreaterThan(String value) {
      addCriterion("PROPERTY_UNIT >", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitGreaterThanOrEqualTo(String value) {
      addCriterion("PROPERTY_UNIT >=", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitLessThan(String value) {
      addCriterion("PROPERTY_UNIT <", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitLessThanOrEqualTo(String value) {
      addCriterion("PROPERTY_UNIT <=", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitLike(String value) {
      addCriterion("PROPERTY_UNIT like", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitNotLike(String value) {
      addCriterion("PROPERTY_UNIT not like", value, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitIn(List<String> values) {
      addCriterion("PROPERTY_UNIT in", values, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitNotIn(List<String> values) {
      addCriterion("PROPERTY_UNIT not in", values, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitBetween(String value1, String value2) {
      addCriterion("PROPERTY_UNIT between", value1, value2, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitNotBetween(String value1, String value2) {
      addCriterion("PROPERTY_UNIT not between", value1, value2, "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andIsUniqueIsNull() {
      addCriterion("IS_UNIQUE is null");
      return (Criteria) this;
    }

    public Criteria andIsUniqueIsNotNull() {
      addCriterion("IS_UNIQUE is not null");
      return (Criteria) this;
    }

    public Criteria andIsUniqueEqualTo(String value) {
      addCriterion("IS_UNIQUE =", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueNotEqualTo(String value) {
      addCriterion("IS_UNIQUE <>", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueGreaterThan(String value) {
      addCriterion("IS_UNIQUE >", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueGreaterThanOrEqualTo(String value) {
      addCriterion("IS_UNIQUE >=", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueLessThan(String value) {
      addCriterion("IS_UNIQUE <", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueLessThanOrEqualTo(String value) {
      addCriterion("IS_UNIQUE <=", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueLike(String value) {
      addCriterion("IS_UNIQUE like", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueNotLike(String value) {
      addCriterion("IS_UNIQUE not like", value, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueIn(List<String> values) {
      addCriterion("IS_UNIQUE in", values, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueNotIn(List<String> values) {
      addCriterion("IS_UNIQUE not in", values, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueBetween(String value1, String value2) {
      addCriterion("IS_UNIQUE between", value1, value2, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsUniqueNotBetween(String value1, String value2) {
      addCriterion("IS_UNIQUE not between", value1, value2, "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsEnumIsNull() {
      addCriterion("IS_ENUM is null");
      return (Criteria) this;
    }

    public Criteria andIsEnumIsNotNull() {
      addCriterion("IS_ENUM is not null");
      return (Criteria) this;
    }

    public Criteria andIsEnumEqualTo(String value) {
      addCriterion("IS_ENUM =", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumNotEqualTo(String value) {
      addCriterion("IS_ENUM <>", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumGreaterThan(String value) {
      addCriterion("IS_ENUM >", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumGreaterThanOrEqualTo(String value) {
      addCriterion("IS_ENUM >=", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumLessThan(String value) {
      addCriterion("IS_ENUM <", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumLessThanOrEqualTo(String value) {
      addCriterion("IS_ENUM <=", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumLike(String value) {
      addCriterion("IS_ENUM like", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumNotLike(String value) {
      addCriterion("IS_ENUM not like", value, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumIn(List<String> values) {
      addCriterion("IS_ENUM in", values, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumNotIn(List<String> values) {
      addCriterion("IS_ENUM not in", values, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumBetween(String value1, String value2) {
      addCriterion("IS_ENUM between", value1, value2, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIsEnumNotBetween(String value1, String value2) {
      addCriterion("IS_ENUM not between", value1, value2, "isEnum");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andPropertyNameLikeInsensitive(String value) {
      addCriterion("upper(PROPERTY_NAME) like", value.toUpperCase(), "propertyName");
      return (Criteria) this;
    }

    public Criteria andPartIdLikeInsensitive(String value) {
      addCriterion("upper(PART_ID) like", value.toUpperCase(), "partId");
      return (Criteria) this;
    }

    public Criteria andPropertyDisNameLikeInsensitive(String value) {
      addCriterion("upper(PROPERTY_DIS_NAME) like", value.toUpperCase(), "propertyDisName");
      return (Criteria) this;
    }

    public Criteria andPropertyUnitLikeInsensitive(String value) {
      addCriterion("upper(PROPERTY_UNIT) like", value.toUpperCase(), "propertyUnit");
      return (Criteria) this;
    }

    public Criteria andIsUniqueLikeInsensitive(String value) {
      addCriterion("upper(IS_UNIQUE) like", value.toUpperCase(), "isUnique");
      return (Criteria) this;
    }

    public Criteria andIsEnumLikeInsensitive(String value) {
      addCriterion("upper(IS_ENUM) like", value.toUpperCase(), "isEnum");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated do_not_delete_during_merge
   */
  public static class Criteria extends GeneratedCriteria {

    protected Criteria() {
      super();
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_PROPERTIES
   *
   * @mbggenerated
   */
  public static class Criterion {
    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private String typeHandler;

    public String getCondition() {
      return condition;
    }

    public Object getValue() {
      return value;
    }

    public Object getSecondValue() {
      return secondValue;
    }

    public boolean isNoValue() {
      return noValue;
    }

    public boolean isSingleValue() {
      return singleValue;
    }

    public boolean isBetweenValue() {
      return betweenValue;
    }

    public boolean isListValue() {
      return listValue;
    }

    public String getTypeHandler() {
      return typeHandler;
    }

    protected Criterion(String condition) {
      super();
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List<?>) {
        this.listValue = true;
      } else {
        this.singleValue = true;
      }
    }

    protected Criterion(String condition, Object value) {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }
  }
}