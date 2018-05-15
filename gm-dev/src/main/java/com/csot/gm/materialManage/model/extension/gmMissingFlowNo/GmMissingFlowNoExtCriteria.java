package com.csot.gm.materialManage.model.extension.gmMissingFlowNo;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class GmMissingFlowNoExtCriteria {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  protected Page page;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public GmMissingFlowNoExtCriteria() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
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
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
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
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
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
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  public Page getPage() {
    return this.page;
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_MISSING_FLOW_NO
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

    public Criteria andPartNumIsNull() {
      addCriterion("PART_NUM is null");
      return (Criteria) this;
    }

    public Criteria andPartNumIsNotNull() {
      addCriterion("PART_NUM is not null");
      return (Criteria) this;
    }

    public Criteria andPartNumEqualTo(String value) {
      addCriterion("PART_NUM =", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumNotEqualTo(String value) {
      addCriterion("PART_NUM <>", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumGreaterThan(String value) {
      addCriterion("PART_NUM >", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumGreaterThanOrEqualTo(String value) {
      addCriterion("PART_NUM >=", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumLessThan(String value) {
      addCriterion("PART_NUM <", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumLessThanOrEqualTo(String value) {
      addCriterion("PART_NUM <=", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumLike(String value) {
      addCriterion("PART_NUM like", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumNotLike(String value) {
      addCriterion("PART_NUM not like", value, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumIn(List<String> values) {
      addCriterion("PART_NUM in", values, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumNotIn(List<String> values) {
      addCriterion("PART_NUM not in", values, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumBetween(String value1, String value2) {
      addCriterion("PART_NUM between", value1, value2, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartNumNotBetween(String value1, String value2) {
      addCriterion("PART_NUM not between", value1, value2, "partNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumIsNull() {
      addCriterion("PART_FLOW_NUM is null");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumIsNotNull() {
      addCriterion("PART_FLOW_NUM is not null");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumEqualTo(String value) {
      addCriterion("PART_FLOW_NUM =", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumNotEqualTo(String value) {
      addCriterion("PART_FLOW_NUM <>", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumGreaterThan(String value) {
      addCriterion("PART_FLOW_NUM >", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumGreaterThanOrEqualTo(String value) {
      addCriterion("PART_FLOW_NUM >=", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumLessThan(String value) {
      addCriterion("PART_FLOW_NUM <", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumLessThanOrEqualTo(String value) {
      addCriterion("PART_FLOW_NUM <=", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumLike(String value) {
      addCriterion("PART_FLOW_NUM like", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumNotLike(String value) {
      addCriterion("PART_FLOW_NUM not like", value, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumIn(List<String> values) {
      addCriterion("PART_FLOW_NUM in", values, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumNotIn(List<String> values) {
      addCriterion("PART_FLOW_NUM not in", values, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumBetween(String value1, String value2) {
      addCriterion("PART_FLOW_NUM between", value1, value2, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumNotBetween(String value1, String value2) {
      addCriterion("PART_FLOW_NUM not between", value1, value2, "partFlowNum");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andPartNumLikeInsensitive(String value) {
      addCriterion("upper(PART_NUM) like", value.toUpperCase(), "partNum");
      return (Criteria) this;
    }

    public Criteria andPartFlowNumLikeInsensitive(String value) {
      addCriterion("upper(PART_FLOW_NUM) like", value.toUpperCase(), "partFlowNum");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_MISSING_FLOW_NO
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
   * This class corresponds to the database table T_GM_MISSING_FLOW_NO
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