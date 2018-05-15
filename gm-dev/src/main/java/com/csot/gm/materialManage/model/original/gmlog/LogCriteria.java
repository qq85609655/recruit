package com.csot.gm.materialManage.model.original.gmlog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class LogCriteria {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  protected Page page;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public LogCriteria() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
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
   * This method corresponds to the database table T_GM_LOG
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
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
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
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_LOG
   *
   * @mbggenerated
   */
  public Page getPage() {
    return this.page;
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_LOG
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

    public Criteria andUserNameIsNull() {
      addCriterion("USER_NAME is null");
      return (Criteria) this;
    }

    public Criteria andUserNameIsNotNull() {
      addCriterion("USER_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andUserNameEqualTo(String value) {
      addCriterion("USER_NAME =", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotEqualTo(String value) {
      addCriterion("USER_NAME <>", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameGreaterThan(String value) {
      addCriterion("USER_NAME >", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameGreaterThanOrEqualTo(String value) {
      addCriterion("USER_NAME >=", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameLessThan(String value) {
      addCriterion("USER_NAME <", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameLessThanOrEqualTo(String value) {
      addCriterion("USER_NAME <=", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameLike(String value) {
      addCriterion("USER_NAME like", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotLike(String value) {
      addCriterion("USER_NAME not like", value, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameIn(List<String> values) {
      addCriterion("USER_NAME in", values, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotIn(List<String> values) {
      addCriterion("USER_NAME not in", values, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameBetween(String value1, String value2) {
      addCriterion("USER_NAME between", value1, value2, "userName");
      return (Criteria) this;
    }

    public Criteria andUserNameNotBetween(String value1, String value2) {
      addCriterion("USER_NAME not between", value1, value2, "userName");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIsNull() {
      addCriterion("CREATE_TIME is null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIsNotNull() {
      addCriterion("CREATE_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeEqualTo(Date value) {
      addCriterion("CREATE_TIME =", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotEqualTo(Date value) {
      addCriterion("CREATE_TIME <>", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThan(Date value) {
      addCriterion("CREATE_TIME >", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("CREATE_TIME >=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThan(Date value) {
      addCriterion("CREATE_TIME <", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
      addCriterion("CREATE_TIME <=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIn(List<Date> values) {
      addCriterion("CREATE_TIME in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotIn(List<Date> values) {
      addCriterion("CREATE_TIME not in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeBetween(Date value1, Date value2) {
      addCriterion("CREATE_TIME between", value1, value2, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
      addCriterion("CREATE_TIME not between", value1, value2, "createTime");
      return (Criteria) this;
    }

    public Criteria andContentIsNull() {
      addCriterion("CONTENT is null");
      return (Criteria) this;
    }

    public Criteria andContentIsNotNull() {
      addCriterion("CONTENT is not null");
      return (Criteria) this;
    }

    public Criteria andContentEqualTo(String value) {
      addCriterion("CONTENT =", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotEqualTo(String value) {
      addCriterion("CONTENT <>", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentGreaterThan(String value) {
      addCriterion("CONTENT >", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentGreaterThanOrEqualTo(String value) {
      addCriterion("CONTENT >=", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentLessThan(String value) {
      addCriterion("CONTENT <", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentLessThanOrEqualTo(String value) {
      addCriterion("CONTENT <=", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentLike(String value) {
      addCriterion("CONTENT like", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotLike(String value) {
      addCriterion("CONTENT not like", value, "content");
      return (Criteria) this;
    }

    public Criteria andContentIn(List<String> values) {
      addCriterion("CONTENT in", values, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotIn(List<String> values) {
      addCriterion("CONTENT not in", values, "content");
      return (Criteria) this;
    }

    public Criteria andContentBetween(String value1, String value2) {
      addCriterion("CONTENT between", value1, value2, "content");
      return (Criteria) this;
    }

    public Criteria andContentNotBetween(String value1, String value2) {
      addCriterion("CONTENT not between", value1, value2, "content");
      return (Criteria) this;
    }

    public Criteria andOperationIsNull() {
      addCriterion("OPERATION is null");
      return (Criteria) this;
    }

    public Criteria andOperationIsNotNull() {
      addCriterion("OPERATION is not null");
      return (Criteria) this;
    }

    public Criteria andOperationEqualTo(String value) {
      addCriterion("OPERATION =", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationNotEqualTo(String value) {
      addCriterion("OPERATION <>", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationGreaterThan(String value) {
      addCriterion("OPERATION >", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationGreaterThanOrEqualTo(String value) {
      addCriterion("OPERATION >=", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationLessThan(String value) {
      addCriterion("OPERATION <", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationLessThanOrEqualTo(String value) {
      addCriterion("OPERATION <=", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationLike(String value) {
      addCriterion("OPERATION like", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationNotLike(String value) {
      addCriterion("OPERATION not like", value, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationIn(List<String> values) {
      addCriterion("OPERATION in", values, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationNotIn(List<String> values) {
      addCriterion("OPERATION not in", values, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationBetween(String value1, String value2) {
      addCriterion("OPERATION between", value1, value2, "operation");
      return (Criteria) this;
    }

    public Criteria andOperationNotBetween(String value1, String value2) {
      addCriterion("OPERATION not between", value1, value2, "operation");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andUserNameLikeInsensitive(String value) {
      addCriterion("upper(USER_NAME) like", value.toUpperCase(), "userName");
      return (Criteria) this;
    }

    public Criteria andContentLikeInsensitive(String value) {
      addCriterion("upper(CONTENT) like", value.toUpperCase(), "content");
      return (Criteria) this;
    }

    public Criteria andOperationLikeInsensitive(String value) {
      addCriterion("upper(OPERATION) like", value.toUpperCase(), "operation");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table T_GM_LOG
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
   * This class corresponds to the database table T_GM_LOG
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