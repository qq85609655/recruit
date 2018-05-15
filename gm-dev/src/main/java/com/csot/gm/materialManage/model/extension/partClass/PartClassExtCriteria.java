package com.csot.gm.materialManage.model.extension.partClass;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class PartClassExtCriteria {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  protected Page page;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public PartClassExtCriteria() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
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
   * This method corresponds to the database table T_GM_CLASS
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
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
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
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLASS
   *
   * @mbggenerated
   */
  public Page getPage() {
    return this.page;
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_CLASS
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

    public Criteria andClassDescIsNull() {
      addCriterion("CLASS_DESC is null");
      return (Criteria) this;
    }

    public Criteria andClassDescIsNotNull() {
      addCriterion("CLASS_DESC is not null");
      return (Criteria) this;
    }

    public Criteria andClassDescEqualTo(String value) {
      addCriterion("CLASS_DESC =", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescNotEqualTo(String value) {
      addCriterion("CLASS_DESC <>", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescGreaterThan(String value) {
      addCriterion("CLASS_DESC >", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescGreaterThanOrEqualTo(String value) {
      addCriterion("CLASS_DESC >=", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescLessThan(String value) {
      addCriterion("CLASS_DESC <", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescLessThanOrEqualTo(String value) {
      addCriterion("CLASS_DESC <=", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescLike(String value) {
      addCriterion("CLASS_DESC like", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescNotLike(String value) {
      addCriterion("CLASS_DESC not like", value, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescIn(List<String> values) {
      addCriterion("CLASS_DESC in", values, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescNotIn(List<String> values) {
      addCriterion("CLASS_DESC not in", values, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescBetween(String value1, String value2) {
      addCriterion("CLASS_DESC between", value1, value2, "classDesc");
      return (Criteria) this;
    }

    public Criteria andClassDescNotBetween(String value1, String value2) {
      addCriterion("CLASS_DESC not between", value1, value2, "classDesc");
      return (Criteria) this;
    }

    public Criteria andParentIdIsNull() {
      addCriterion("PARENT_ID is null");
      return (Criteria) this;
    }

    public Criteria andParentIdIsNotNull() {
      addCriterion("PARENT_ID is not null");
      return (Criteria) this;
    }

    public Criteria andParentIdEqualTo(String value) {
      addCriterion("PARENT_ID =", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotEqualTo(String value) {
      addCriterion("PARENT_ID <>", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThan(String value) {
      addCriterion("PARENT_ID >", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThanOrEqualTo(String value) {
      addCriterion("PARENT_ID >=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThan(String value) {
      addCriterion("PARENT_ID <", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThanOrEqualTo(String value) {
      addCriterion("PARENT_ID <=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLike(String value) {
      addCriterion("PARENT_ID like", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotLike(String value) {
      addCriterion("PARENT_ID not like", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdIn(List<String> values) {
      addCriterion("PARENT_ID in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotIn(List<String> values) {
      addCriterion("PARENT_ID not in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdBetween(String value1, String value2) {
      addCriterion("PARENT_ID between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotBetween(String value1, String value2) {
      addCriterion("PARENT_ID not between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andSortIdIsNull() {
      addCriterion("SORT_ID is null");
      return (Criteria) this;
    }

    public Criteria andSortIdIsNotNull() {
      addCriterion("SORT_ID is not null");
      return (Criteria) this;
    }

    public Criteria andSortIdEqualTo(String value) {
      addCriterion("SORT_ID =", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdNotEqualTo(String value) {
      addCriterion("SORT_ID <>", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdGreaterThan(String value) {
      addCriterion("SORT_ID >", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdGreaterThanOrEqualTo(String value) {
      addCriterion("SORT_ID >=", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdLessThan(String value) {
      addCriterion("SORT_ID <", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdLessThanOrEqualTo(String value) {
      addCriterion("SORT_ID <=", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdLike(String value) {
      addCriterion("SORT_ID like", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdNotLike(String value) {
      addCriterion("SORT_ID not like", value, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdIn(List<String> values) {
      addCriterion("SORT_ID in", values, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdNotIn(List<String> values) {
      addCriterion("SORT_ID not in", values, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdBetween(String value1, String value2) {
      addCriterion("SORT_ID between", value1, value2, "sortId");
      return (Criteria) this;
    }

    public Criteria andSortIdNotBetween(String value1, String value2) {
      addCriterion("SORT_ID not between", value1, value2, "sortId");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andClassDescLikeInsensitive(String value) {
      addCriterion("upper(CLASS_DESC) like", value.toUpperCase(), "classDesc");
      return (Criteria) this;
    }

    public Criteria andParentIdLikeInsensitive(String value) {
      addCriterion("upper(PARENT_ID) like", value.toUpperCase(), "parentId");
      return (Criteria) this;
    }

    public Criteria andSortIdLikeInsensitive(String value) {
      addCriterion("upper(SORT_ID) like", value.toUpperCase(), "sortId");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_CLASS
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
   * This class corresponds to the database table T_GM_CLASS
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