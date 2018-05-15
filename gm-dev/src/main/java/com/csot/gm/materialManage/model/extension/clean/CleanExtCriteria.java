package com.csot.gm.materialManage.model.extension.clean;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CleanExtCriteria {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  protected Page page;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public CleanExtCriteria() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
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
   * This method corresponds to the database table T_GM_CLEAN
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
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
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
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  public Page getPage() {
    return this.page;
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_CLEAN
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

    public Criteria andPartNoIsNull() {
      addCriterion("PART_NO is null");
      return (Criteria) this;
    }

    public Criteria andPartNoIsNotNull() {
      addCriterion("PART_NO is not null");
      return (Criteria) this;
    }

    public Criteria andPartNoEqualTo(String value) {
      addCriterion("PART_NO =", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoNotEqualTo(String value) {
      addCriterion("PART_NO <>", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoGreaterThan(String value) {
      addCriterion("PART_NO >", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoGreaterThanOrEqualTo(String value) {
      addCriterion("PART_NO >=", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoLessThan(String value) {
      addCriterion("PART_NO <", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoLessThanOrEqualTo(String value) {
      addCriterion("PART_NO <=", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoLike(String value) {
      addCriterion("PART_NO like", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoNotLike(String value) {
      addCriterion("PART_NO not like", value, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoIn(List<String> values) {
      addCriterion("PART_NO in", values, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoNotIn(List<String> values) {
      addCriterion("PART_NO not in", values, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoBetween(String value1, String value2) {
      addCriterion("PART_NO between", value1, value2, "partNo");
      return (Criteria) this;
    }

    public Criteria andPartNoNotBetween(String value1, String value2) {
      addCriterion("PART_NO not between", value1, value2, "partNo");
      return (Criteria) this;
    }

    public Criteria andBrandIsNull() {
      addCriterion("BRAND is null");
      return (Criteria) this;
    }

    public Criteria andBrandIsNotNull() {
      addCriterion("BRAND is not null");
      return (Criteria) this;
    }

    public Criteria andBrandEqualTo(String value) {
      addCriterion("BRAND =", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandNotEqualTo(String value) {
      addCriterion("BRAND <>", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandGreaterThan(String value) {
      addCriterion("BRAND >", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandGreaterThanOrEqualTo(String value) {
      addCriterion("BRAND >=", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandLessThan(String value) {
      addCriterion("BRAND <", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandLessThanOrEqualTo(String value) {
      addCriterion("BRAND <=", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandLike(String value) {
      addCriterion("BRAND like", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandNotLike(String value) {
      addCriterion("BRAND not like", value, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandIn(List<String> values) {
      addCriterion("BRAND in", values, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandNotIn(List<String> values) {
      addCriterion("BRAND not in", values, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandBetween(String value1, String value2) {
      addCriterion("BRAND between", value1, value2, "brand");
      return (Criteria) this;
    }

    public Criteria andBrandNotBetween(String value1, String value2) {
      addCriterion("BRAND not between", value1, value2, "brand");
      return (Criteria) this;
    }

    public Criteria andSpecIsNull() {
      addCriterion("SPEC is null");
      return (Criteria) this;
    }

    public Criteria andSpecIsNotNull() {
      addCriterion("SPEC is not null");
      return (Criteria) this;
    }

    public Criteria andSpecEqualTo(String value) {
      addCriterion("SPEC =", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecNotEqualTo(String value) {
      addCriterion("SPEC <>", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecGreaterThan(String value) {
      addCriterion("SPEC >", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecGreaterThanOrEqualTo(String value) {
      addCriterion("SPEC >=", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecLessThan(String value) {
      addCriterion("SPEC <", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecLessThanOrEqualTo(String value) {
      addCriterion("SPEC <=", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecLike(String value) {
      addCriterion("SPEC like", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecNotLike(String value) {
      addCriterion("SPEC not like", value, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecIn(List<String> values) {
      addCriterion("SPEC in", values, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecNotIn(List<String> values) {
      addCriterion("SPEC not in", values, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecBetween(String value1, String value2) {
      addCriterion("SPEC between", value1, value2, "spec");
      return (Criteria) this;
    }

    public Criteria andSpecNotBetween(String value1, String value2) {
      addCriterion("SPEC not between", value1, value2, "spec");
      return (Criteria) this;
    }

    public Criteria andStatusIsNull() {
      addCriterion("STATUS is null");
      return (Criteria) this;
    }

    public Criteria andStatusIsNotNull() {
      addCriterion("STATUS is not null");
      return (Criteria) this;
    }

    public Criteria andStatusEqualTo(String value) {
      addCriterion("STATUS =", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotEqualTo(String value) {
      addCriterion("STATUS <>", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusGreaterThan(String value) {
      addCriterion("STATUS >", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusGreaterThanOrEqualTo(String value) {
      addCriterion("STATUS >=", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLessThan(String value) {
      addCriterion("STATUS <", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLessThanOrEqualTo(String value) {
      addCriterion("STATUS <=", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLike(String value) {
      addCriterion("STATUS like", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotLike(String value) {
      addCriterion("STATUS not like", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusIn(List<String> values) {
      addCriterion("STATUS in", values, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotIn(List<String> values) {
      addCriterion("STATUS not in", values, "status");
      return (Criteria) this;
    }

    public Criteria andStatusBetween(String value1, String value2) {
      addCriterion("STATUS between", value1, value2, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotBetween(String value1, String value2) {
      addCriterion("STATUS not between", value1, value2, "status");
      return (Criteria) this;
    }

    public Criteria andInfoIsNull() {
      addCriterion("INFO is null");
      return (Criteria) this;
    }

    public Criteria andInfoIsNotNull() {
      addCriterion("INFO is not null");
      return (Criteria) this;
    }

    public Criteria andInfoEqualTo(String value) {
      addCriterion("INFO =", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotEqualTo(String value) {
      addCriterion("INFO <>", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoGreaterThan(String value) {
      addCriterion("INFO >", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoGreaterThanOrEqualTo(String value) {
      addCriterion("INFO >=", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoLessThan(String value) {
      addCriterion("INFO <", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoLessThanOrEqualTo(String value) {
      addCriterion("INFO <=", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoLike(String value) {
      addCriterion("INFO like", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotLike(String value) {
      addCriterion("INFO not like", value, "info");
      return (Criteria) this;
    }

    public Criteria andInfoIn(List<String> values) {
      addCriterion("INFO in", values, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotIn(List<String> values) {
      addCriterion("INFO not in", values, "info");
      return (Criteria) this;
    }

    public Criteria andInfoBetween(String value1, String value2) {
      addCriterion("INFO between", value1, value2, "info");
      return (Criteria) this;
    }

    public Criteria andInfoNotBetween(String value1, String value2) {
      addCriterion("INFO not between", value1, value2, "info");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andPartNoLikeInsensitive(String value) {
      addCriterion("upper(PART_NO) like", value.toUpperCase(), "partNo");
      return (Criteria) this;
    }

    public Criteria andBrandLikeInsensitive(String value) {
      addCriterion("upper(BRAND) like", value.toUpperCase(), "brand");
      return (Criteria) this;
    }

    public Criteria andSpecLikeInsensitive(String value) {
      addCriterion("upper(SPEC) like", value.toUpperCase(), "spec");
      return (Criteria) this;
    }

    public Criteria andStatusLikeInsensitive(String value) {
      addCriterion("upper(STATUS) like", value.toUpperCase(), "status");
      return (Criteria) this;
    }

    public Criteria andInfoLikeInsensitive(String value) {
      addCriterion("upper(INFO) like", value.toUpperCase(), "info");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_CLEAN
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
   * This class corresponds to the database table T_GM_CLEAN
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