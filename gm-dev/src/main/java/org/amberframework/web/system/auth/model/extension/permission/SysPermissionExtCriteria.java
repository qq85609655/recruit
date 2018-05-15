package org.amberframework.web.system.auth.model.extension.permission;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class SysPermissionExtCriteria {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  protected Page page;

  public SysPermissionExtCriteria() {
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

    public Criteria andIdEqualTo(Long value) {
      addCriterion("ID =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(Long value) {
      addCriterion("ID <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(Long value) {
      addCriterion("ID >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("ID >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(Long value) {
      addCriterion("ID <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("ID <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<Long> values) {
      addCriterion("ID in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<Long> values) {
      addCriterion("ID not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("ID between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("ID not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andNameIsNull() {
      addCriterion("NAME is null");
      return (Criteria) this;
    }

    public Criteria andNameIsNotNull() {
      addCriterion("NAME is not null");
      return (Criteria) this;
    }

    public Criteria andNameEqualTo(String value) {
      addCriterion("NAME =", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotEqualTo(String value) {
      addCriterion("NAME <>", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThan(String value) {
      addCriterion("NAME >", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("NAME >=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThan(String value) {
      addCriterion("NAME <", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("NAME <=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLike(String value) {
      addCriterion("NAME like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotLike(String value) {
      addCriterion("NAME not like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameIn(List<String> values) {
      addCriterion("NAME in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotIn(List<String> values) {
      addCriterion("NAME not in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameBetween(String value1, String value2) {
      addCriterion("NAME between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("NAME not between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andPermissionIsNull() {
      addCriterion("PERMISSION is null");
      return (Criteria) this;
    }

    public Criteria andPermissionIsNotNull() {
      addCriterion("PERMISSION is not null");
      return (Criteria) this;
    }

    public Criteria andPermissionEqualTo(String value) {
      addCriterion("PERMISSION =", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionNotEqualTo(String value) {
      addCriterion("PERMISSION <>", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionGreaterThan(String value) {
      addCriterion("PERMISSION >", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionGreaterThanOrEqualTo(String value) {
      addCriterion("PERMISSION >=", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionLessThan(String value) {
      addCriterion("PERMISSION <", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionLessThanOrEqualTo(String value) {
      addCriterion("PERMISSION <=", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionLike(String value) {
      addCriterion("PERMISSION like", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionNotLike(String value) {
      addCriterion("PERMISSION not like", value, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionIn(List<String> values) {
      addCriterion("PERMISSION in", values, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionNotIn(List<String> values) {
      addCriterion("PERMISSION not in", values, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionBetween(String value1, String value2) {
      addCriterion("PERMISSION between", value1, value2, "permission");
      return (Criteria) this;
    }

    public Criteria andPermissionNotBetween(String value1, String value2) {
      addCriterion("PERMISSION not between", value1, value2, "permission");
      return (Criteria) this;
    }

    public Criteria andDescriptionIsNull() {
      addCriterion("DESCRIPTION is null");
      return (Criteria) this;
    }

    public Criteria andDescriptionIsNotNull() {
      addCriterion("DESCRIPTION is not null");
      return (Criteria) this;
    }

    public Criteria andDescriptionEqualTo(String value) {
      addCriterion("DESCRIPTION =", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotEqualTo(String value) {
      addCriterion("DESCRIPTION <>", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionGreaterThan(String value) {
      addCriterion("DESCRIPTION >", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
      addCriterion("DESCRIPTION >=", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLessThan(String value) {
      addCriterion("DESCRIPTION <", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLessThanOrEqualTo(String value) {
      addCriterion("DESCRIPTION <=", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLike(String value) {
      addCriterion("DESCRIPTION like", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotLike(String value) {
      addCriterion("DESCRIPTION not like", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionIn(List<String> values) {
      addCriterion("DESCRIPTION in", values, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotIn(List<String> values) {
      addCriterion("DESCRIPTION not in", values, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionBetween(String value1, String value2) {
      addCriterion("DESCRIPTION between", value1, value2, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotBetween(String value1, String value2) {
      addCriterion("DESCRIPTION not between", value1, value2, "description");
      return (Criteria) this;
    }

    public Criteria andEnabledIsNull() {
      addCriterion("ENABLED is null");
      return (Criteria) this;
    }

    public Criteria andEnabledIsNotNull() {
      addCriterion("ENABLED is not null");
      return (Criteria) this;
    }

    public Criteria andEnabledEqualTo(String value) {
      addCriterion("ENABLED =", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledNotEqualTo(String value) {
      addCriterion("ENABLED <>", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledGreaterThan(String value) {
      addCriterion("ENABLED >", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledGreaterThanOrEqualTo(String value) {
      addCriterion("ENABLED >=", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledLessThan(String value) {
      addCriterion("ENABLED <", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledLessThanOrEqualTo(String value) {
      addCriterion("ENABLED <=", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledLike(String value) {
      addCriterion("ENABLED like", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledNotLike(String value) {
      addCriterion("ENABLED not like", value, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledIn(List<String> values) {
      addCriterion("ENABLED in", values, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledNotIn(List<String> values) {
      addCriterion("ENABLED not in", values, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledBetween(String value1, String value2) {
      addCriterion("ENABLED between", value1, value2, "enabled");
      return (Criteria) this;
    }

    public Criteria andEnabledNotBetween(String value1, String value2) {
      addCriterion("ENABLED not between", value1, value2, "enabled");
      return (Criteria) this;
    }

    public Criteria andNameLikeInsensitive(String value) {
      addCriterion("upper(NAME) like", value.toUpperCase(), "name");
      return (Criteria) this;
    }

    public Criteria andPermissionLikeInsensitive(String value) {
      addCriterion("upper(PERMISSION) like", value.toUpperCase(), "permission");
      return (Criteria) this;
    }

    public Criteria andDescriptionLikeInsensitive(String value) {
      addCriterion("upper(DESCRIPTION) like", value.toUpperCase(), "description");
      return (Criteria) this;
    }

    public Criteria andEnabledLikeInsensitive(String value) {
      addCriterion("upper(ENABLED) like", value.toUpperCase(), "enabled");
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