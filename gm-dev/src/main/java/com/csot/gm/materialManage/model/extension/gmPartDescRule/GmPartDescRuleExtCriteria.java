package com.csot.gm.materialManage.model.extension.gmPartDescRule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class GmPartDescRuleExtCriteria {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  protected Page page;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public GmPartDescRuleExtCriteria() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
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
   * This method corresponds to the database table T_GM_PART_DESC_RULE
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
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
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
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  public Page getPage() {
    return this.page;
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_PART_DESC_RULE
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

    public Criteria andRuleKeyCodeIsNull() {
      addCriterion("RULE_KEY_CODE is null");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeIsNotNull() {
      addCriterion("RULE_KEY_CODE is not null");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeEqualTo(String value) {
      addCriterion("RULE_KEY_CODE =", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeNotEqualTo(String value) {
      addCriterion("RULE_KEY_CODE <>", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeGreaterThan(String value) {
      addCriterion("RULE_KEY_CODE >", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeGreaterThanOrEqualTo(String value) {
      addCriterion("RULE_KEY_CODE >=", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeLessThan(String value) {
      addCriterion("RULE_KEY_CODE <", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeLessThanOrEqualTo(String value) {
      addCriterion("RULE_KEY_CODE <=", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeLike(String value) {
      addCriterion("RULE_KEY_CODE like", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeNotLike(String value) {
      addCriterion("RULE_KEY_CODE not like", value, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeIn(List<String> values) {
      addCriterion("RULE_KEY_CODE in", values, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeNotIn(List<String> values) {
      addCriterion("RULE_KEY_CODE not in", values, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeBetween(String value1, String value2) {
      addCriterion("RULE_KEY_CODE between", value1, value2, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeNotBetween(String value1, String value2) {
      addCriterion("RULE_KEY_CODE not between", value1, value2, "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameIsNull() {
      addCriterion("RULE_PROPERTY_NAME is null");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameIsNotNull() {
      addCriterion("RULE_PROPERTY_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameEqualTo(String value) {
      addCriterion("RULE_PROPERTY_NAME =", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameNotEqualTo(String value) {
      addCriterion("RULE_PROPERTY_NAME <>", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameGreaterThan(String value) {
      addCriterion("RULE_PROPERTY_NAME >", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameGreaterThanOrEqualTo(String value) {
      addCriterion("RULE_PROPERTY_NAME >=", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameLessThan(String value) {
      addCriterion("RULE_PROPERTY_NAME <", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameLessThanOrEqualTo(String value) {
      addCriterion("RULE_PROPERTY_NAME <=", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameLike(String value) {
      addCriterion("RULE_PROPERTY_NAME like", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameNotLike(String value) {
      addCriterion("RULE_PROPERTY_NAME not like", value, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameIn(List<String> values) {
      addCriterion("RULE_PROPERTY_NAME in", values, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameNotIn(List<String> values) {
      addCriterion("RULE_PROPERTY_NAME not in", values, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameBetween(String value1, String value2) {
      addCriterion("RULE_PROPERTY_NAME between", value1, value2, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameNotBetween(String value1, String value2) {
      addCriterion("RULE_PROPERTY_NAME not between", value1, value2, "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexIsNull() {
      addCriterion("RULE_PROPERTY_INDEX is null");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexIsNotNull() {
      addCriterion("RULE_PROPERTY_INDEX is not null");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexEqualTo(BigDecimal value) {
      addCriterion("RULE_PROPERTY_INDEX =", value, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexNotEqualTo(BigDecimal value) {
      addCriterion("RULE_PROPERTY_INDEX <>", value, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexGreaterThan(BigDecimal value) {
      addCriterion("RULE_PROPERTY_INDEX >", value, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("RULE_PROPERTY_INDEX >=", value, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexLessThan(BigDecimal value) {
      addCriterion("RULE_PROPERTY_INDEX <", value, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexLessThanOrEqualTo(BigDecimal value) {
      addCriterion("RULE_PROPERTY_INDEX <=", value, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexIn(List<BigDecimal> values) {
      addCriterion("RULE_PROPERTY_INDEX in", values, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexNotIn(List<BigDecimal> values) {
      addCriterion("RULE_PROPERTY_INDEX not in", values, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RULE_PROPERTY_INDEX between", value1, value2, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andRulePropertyIndexNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("RULE_PROPERTY_INDEX not between", value1, value2, "rulePropertyIndex");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolIsNull() {
      addCriterion("CONNECT_SYMBOL is null");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolIsNotNull() {
      addCriterion("CONNECT_SYMBOL is not null");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolEqualTo(String value) {
      addCriterion("CONNECT_SYMBOL =", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolNotEqualTo(String value) {
      addCriterion("CONNECT_SYMBOL <>", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolGreaterThan(String value) {
      addCriterion("CONNECT_SYMBOL >", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolGreaterThanOrEqualTo(String value) {
      addCriterion("CONNECT_SYMBOL >=", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolLessThan(String value) {
      addCriterion("CONNECT_SYMBOL <", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolLessThanOrEqualTo(String value) {
      addCriterion("CONNECT_SYMBOL <=", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolLike(String value) {
      addCriterion("CONNECT_SYMBOL like", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolNotLike(String value) {
      addCriterion("CONNECT_SYMBOL not like", value, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolIn(List<String> values) {
      addCriterion("CONNECT_SYMBOL in", values, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolNotIn(List<String> values) {
      addCriterion("CONNECT_SYMBOL not in", values, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolBetween(String value1, String value2) {
      addCriterion("CONNECT_SYMBOL between", value1, value2, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolNotBetween(String value1, String value2) {
      addCriterion("CONNECT_SYMBOL not between", value1, value2, "connectSymbol");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andRuleKeyCodeLikeInsensitive(String value) {
      addCriterion("upper(RULE_KEY_CODE) like", value.toUpperCase(), "ruleKeyCode");
      return (Criteria) this;
    }

    public Criteria andRulePropertyNameLikeInsensitive(String value) {
      addCriterion("upper(RULE_PROPERTY_NAME) like", value.toUpperCase(), "rulePropertyName");
      return (Criteria) this;
    }

    public Criteria andConnectSymbolLikeInsensitive(String value) {
      addCriterion("upper(CONNECT_SYMBOL) like", value.toUpperCase(), "connectSymbol");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_PART_DESC_RULE
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
   * This class corresponds to the database table T_GM_PART_DESC_RULE
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