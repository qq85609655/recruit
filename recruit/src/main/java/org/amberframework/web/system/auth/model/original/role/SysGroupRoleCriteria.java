package org.amberframework.web.system.auth.model.original.role;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class SysGroupRoleCriteria {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  protected Page page;

  public SysGroupRoleCriteria() {
    oredCriteria = new ArrayList<Criteria>();
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This one was generated by MyBatis Generator.
   *
   * @mbggenerated
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * This one was generated by MyBatis Generator.
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

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This one was generated by MyBatis Generator.
   *
   * @mbggenerated
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  public void setPage(Page page) {
    this.page = page;
  }

  public Page getPage() {
    return this.page;
  }

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

    public Criteria andIdEqualTo(BigDecimal value) {
      addCriterion("ID =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(BigDecimal value) {
      addCriterion("ID <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(BigDecimal value) {
      addCriterion("ID >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("ID >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(BigDecimal value) {
      addCriterion("ID <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
      addCriterion("ID <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<BigDecimal> values) {
      addCriterion("ID in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<BigDecimal> values) {
      addCriterion("ID not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("ID between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("ID not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andGroupIdIsNull() {
      addCriterion("GROUP_ID is null");
      return (Criteria) this;
    }

    public Criteria andGroupIdIsNotNull() {
      addCriterion("GROUP_ID is not null");
      return (Criteria) this;
    }

    public Criteria andGroupIdEqualTo(Long value) {
      addCriterion("GROUP_ID =", value, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdNotEqualTo(Long value) {
      addCriterion("GROUP_ID <>", value, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdGreaterThan(Long value) {
      addCriterion("GROUP_ID >", value, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
      addCriterion("GROUP_ID >=", value, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdLessThan(Long value) {
      addCriterion("GROUP_ID <", value, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdLessThanOrEqualTo(Long value) {
      addCriterion("GROUP_ID <=", value, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdIn(List<Long> values) {
      addCriterion("GROUP_ID in", values, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdNotIn(List<Long> values) {
      addCriterion("GROUP_ID not in", values, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdBetween(Long value1, Long value2) {
      addCriterion("GROUP_ID between", value1, value2, "groupId");
      return (Criteria) this;
    }

    public Criteria andGroupIdNotBetween(Long value1, Long value2) {
      addCriterion("GROUP_ID not between", value1, value2, "groupId");
      return (Criteria) this;
    }

    public Criteria andRoleIdIsNull() {
      addCriterion("ROLE_ID is null");
      return (Criteria) this;
    }

    public Criteria andRoleIdIsNotNull() {
      addCriterion("ROLE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andRoleIdEqualTo(Long value) {
      addCriterion("ROLE_ID =", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotEqualTo(Long value) {
      addCriterion("ROLE_ID <>", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdGreaterThan(Long value) {
      addCriterion("ROLE_ID >", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
      addCriterion("ROLE_ID >=", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdLessThan(Long value) {
      addCriterion("ROLE_ID <", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdLessThanOrEqualTo(Long value) {
      addCriterion("ROLE_ID <=", value, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdIn(List<Long> values) {
      addCriterion("ROLE_ID in", values, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotIn(List<Long> values) {
      addCriterion("ROLE_ID not in", values, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdBetween(Long value1, Long value2) {
      addCriterion("ROLE_ID between", value1, value2, "roleId");
      return (Criteria) this;
    }

    public Criteria andRoleIdNotBetween(Long value1, Long value2) {
      addCriterion("ROLE_ID not between", value1, value2, "roleId");
      return (Criteria) this;
    }

    public Criteria andExtendedIsNull() {
      addCriterion("EXTENDED is null");
      return (Criteria) this;
    }

    public Criteria andExtendedIsNotNull() {
      addCriterion("EXTENDED is not null");
      return (Criteria) this;
    }

    public Criteria andExtendedEqualTo(String value) {
      addCriterion("EXTENDED =", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedNotEqualTo(String value) {
      addCriterion("EXTENDED <>", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedGreaterThan(String value) {
      addCriterion("EXTENDED >", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedGreaterThanOrEqualTo(String value) {
      addCriterion("EXTENDED >=", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedLessThan(String value) {
      addCriterion("EXTENDED <", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedLessThanOrEqualTo(String value) {
      addCriterion("EXTENDED <=", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedLike(String value) {
      addCriterion("EXTENDED like", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedNotLike(String value) {
      addCriterion("EXTENDED not like", value, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedIn(List<String> values) {
      addCriterion("EXTENDED in", values, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedNotIn(List<String> values) {
      addCriterion("EXTENDED not in", values, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedBetween(String value1, String value2) {
      addCriterion("EXTENDED between", value1, value2, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedNotBetween(String value1, String value2) {
      addCriterion("EXTENDED not between", value1, value2, "extended");
      return (Criteria) this;
    }

    public Criteria andExtendedLikeInsensitive(String value) {
      addCriterion("upper(EXTENDED) like", value.toUpperCase(), "extended");
      return (Criteria) this;
    }
  }

  public static class Criteria extends GeneratedCriteria {

    protected Criteria() {
      super();
    }
  }

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
