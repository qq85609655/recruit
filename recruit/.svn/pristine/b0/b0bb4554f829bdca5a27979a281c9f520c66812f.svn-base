package com.csot.recruit.model.extension.campus;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CampusPostExtCriteria {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  protected Page page;

  public CampusPostExtCriteria() {
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

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

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

    public Criteria andPostIdIsNull() {
      addCriterion("POST_ID is null");
      return (Criteria) this;
    }

    public Criteria andPostIdIsNotNull() {
      addCriterion("POST_ID is not null");
      return (Criteria) this;
    }

    public Criteria andPostIdEqualTo(String value) {
      addCriterion("POST_ID =", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdNotEqualTo(String value) {
      addCriterion("POST_ID <>", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdGreaterThan(String value) {
      addCriterion("POST_ID >", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdGreaterThanOrEqualTo(String value) {
      addCriterion("POST_ID >=", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdLessThan(String value) {
      addCriterion("POST_ID <", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdLessThanOrEqualTo(String value) {
      addCriterion("POST_ID <=", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdLike(String value) {
      addCriterion("POST_ID like", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdNotLike(String value) {
      addCriterion("POST_ID not like", value, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdIn(List<String> values) {
      addCriterion("POST_ID in", values, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdNotIn(List<String> values) {
      addCriterion("POST_ID not in", values, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdBetween(String value1, String value2) {
      addCriterion("POST_ID between", value1, value2, "postId");
      return (Criteria) this;
    }

    public Criteria andPostIdNotBetween(String value1, String value2) {
      addCriterion("POST_ID not between", value1, value2, "postId");
      return (Criteria) this;
    }

    public Criteria andPostNameIsNull() {
      addCriterion("POST_NAME is null");
      return (Criteria) this;
    }

    public Criteria andPostNameIsNotNull() {
      addCriterion("POST_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andPostNameEqualTo(String value) {
      addCriterion("POST_NAME =", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameNotEqualTo(String value) {
      addCriterion("POST_NAME <>", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameGreaterThan(String value) {
      addCriterion("POST_NAME >", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameGreaterThanOrEqualTo(String value) {
      addCriterion("POST_NAME >=", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameLessThan(String value) {
      addCriterion("POST_NAME <", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameLessThanOrEqualTo(String value) {
      addCriterion("POST_NAME <=", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameLike(String value) {
      addCriterion("POST_NAME like", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameNotLike(String value) {
      addCriterion("POST_NAME not like", value, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameIn(List<String> values) {
      addCriterion("POST_NAME in", values, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameNotIn(List<String> values) {
      addCriterion("POST_NAME not in", values, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameBetween(String value1, String value2) {
      addCriterion("POST_NAME between", value1, value2, "postName");
      return (Criteria) this;
    }

    public Criteria andPostNameNotBetween(String value1, String value2) {
      addCriterion("POST_NAME not between", value1, value2, "postName");
      return (Criteria) this;
    }

    public Criteria andRemarkIsNull() {
      addCriterion("REMARK is null");
      return (Criteria) this;
    }

    public Criteria andRemarkIsNotNull() {
      addCriterion("REMARK is not null");
      return (Criteria) this;
    }

    public Criteria andRemarkEqualTo(String value) {
      addCriterion("REMARK =", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotEqualTo(String value) {
      addCriterion("REMARK <>", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkGreaterThan(String value) {
      addCriterion("REMARK >", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("REMARK >=", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLessThan(String value) {
      addCriterion("REMARK <", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("REMARK <=", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkLike(String value) {
      addCriterion("REMARK like", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotLike(String value) {
      addCriterion("REMARK not like", value, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkIn(List<String> values) {
      addCriterion("REMARK in", values, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotIn(List<String> values) {
      addCriterion("REMARK not in", values, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("REMARK between", value1, value2, "remark");
      return (Criteria) this;
    }

    public Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("REMARK not between", value1, value2, "remark");
      return (Criteria) this;
    }

    public Criteria andReserved1IsNull() {
      addCriterion("RESERVED_1 is null");
      return (Criteria) this;
    }

    public Criteria andReserved1IsNotNull() {
      addCriterion("RESERVED_1 is not null");
      return (Criteria) this;
    }

    public Criteria andReserved1EqualTo(String value) {
      addCriterion("RESERVED_1 =", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1NotEqualTo(String value) {
      addCriterion("RESERVED_1 <>", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1GreaterThan(String value) {
      addCriterion("RESERVED_1 >", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1GreaterThanOrEqualTo(String value) {
      addCriterion("RESERVED_1 >=", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1LessThan(String value) {
      addCriterion("RESERVED_1 <", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1LessThanOrEqualTo(String value) {
      addCriterion("RESERVED_1 <=", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1Like(String value) {
      addCriterion("RESERVED_1 like", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1NotLike(String value) {
      addCriterion("RESERVED_1 not like", value, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1In(List<String> values) {
      addCriterion("RESERVED_1 in", values, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1NotIn(List<String> values) {
      addCriterion("RESERVED_1 not in", values, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1Between(String value1, String value2) {
      addCriterion("RESERVED_1 between", value1, value2, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved1NotBetween(String value1, String value2) {
      addCriterion("RESERVED_1 not between", value1, value2, "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved2IsNull() {
      addCriterion("RESERVED_2 is null");
      return (Criteria) this;
    }

    public Criteria andReserved2IsNotNull() {
      addCriterion("RESERVED_2 is not null");
      return (Criteria) this;
    }

    public Criteria andReserved2EqualTo(String value) {
      addCriterion("RESERVED_2 =", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2NotEqualTo(String value) {
      addCriterion("RESERVED_2 <>", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2GreaterThan(String value) {
      addCriterion("RESERVED_2 >", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2GreaterThanOrEqualTo(String value) {
      addCriterion("RESERVED_2 >=", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2LessThan(String value) {
      addCriterion("RESERVED_2 <", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2LessThanOrEqualTo(String value) {
      addCriterion("RESERVED_2 <=", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2Like(String value) {
      addCriterion("RESERVED_2 like", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2NotLike(String value) {
      addCriterion("RESERVED_2 not like", value, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2In(List<String> values) {
      addCriterion("RESERVED_2 in", values, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2NotIn(List<String> values) {
      addCriterion("RESERVED_2 not in", values, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2Between(String value1, String value2) {
      addCriterion("RESERVED_2 between", value1, value2, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved2NotBetween(String value1, String value2) {
      addCriterion("RESERVED_2 not between", value1, value2, "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved3IsNull() {
      addCriterion("RESERVED_3 is null");
      return (Criteria) this;
    }

    public Criteria andReserved3IsNotNull() {
      addCriterion("RESERVED_3 is not null");
      return (Criteria) this;
    }

    public Criteria andReserved3EqualTo(String value) {
      addCriterion("RESERVED_3 =", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3NotEqualTo(String value) {
      addCriterion("RESERVED_3 <>", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3GreaterThan(String value) {
      addCriterion("RESERVED_3 >", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3GreaterThanOrEqualTo(String value) {
      addCriterion("RESERVED_3 >=", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3LessThan(String value) {
      addCriterion("RESERVED_3 <", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3LessThanOrEqualTo(String value) {
      addCriterion("RESERVED_3 <=", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3Like(String value) {
      addCriterion("RESERVED_3 like", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3NotLike(String value) {
      addCriterion("RESERVED_3 not like", value, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3In(List<String> values) {
      addCriterion("RESERVED_3 in", values, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3NotIn(List<String> values) {
      addCriterion("RESERVED_3 not in", values, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3Between(String value1, String value2) {
      addCriterion("RESERVED_3 between", value1, value2, "reserved3");
      return (Criteria) this;
    }

    public Criteria andReserved3NotBetween(String value1, String value2) {
      addCriterion("RESERVED_3 not between", value1, value2, "reserved3");
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

    public Criteria andOrganizationIsNull() {
      addCriterion("ORGANIZATION is null");
      return (Criteria) this;
    }

    public Criteria andOrganizationIsNotNull() {
      addCriterion("ORGANIZATION is not null");
      return (Criteria) this;
    }

    public Criteria andOrganizationEqualTo(String value) {
      addCriterion("ORGANIZATION =", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationNotEqualTo(String value) {
      addCriterion("ORGANIZATION <>", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationGreaterThan(String value) {
      addCriterion("ORGANIZATION >", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationGreaterThanOrEqualTo(String value) {
      addCriterion("ORGANIZATION >=", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationLessThan(String value) {
      addCriterion("ORGANIZATION <", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationLessThanOrEqualTo(String value) {
      addCriterion("ORGANIZATION <=", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationLike(String value) {
      addCriterion("ORGANIZATION like", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationNotLike(String value) {
      addCriterion("ORGANIZATION not like", value, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationIn(List<String> values) {
      addCriterion("ORGANIZATION in", values, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationNotIn(List<String> values) {
      addCriterion("ORGANIZATION not in", values, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationBetween(String value1, String value2) {
      addCriterion("ORGANIZATION between", value1, value2, "organization");
      return (Criteria) this;
    }

    public Criteria andOrganizationNotBetween(String value1, String value2) {
      addCriterion("ORGANIZATION not between", value1, value2, "organization");
      return (Criteria) this;
    }

    public Criteria andBigCenterIsNull() {
      addCriterion("BIG_CENTER is null");
      return (Criteria) this;
    }

    public Criteria andBigCenterIsNotNull() {
      addCriterion("BIG_CENTER is not null");
      return (Criteria) this;
    }

    public Criteria andBigCenterEqualTo(String value) {
      addCriterion("BIG_CENTER =", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterNotEqualTo(String value) {
      addCriterion("BIG_CENTER <>", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterGreaterThan(String value) {
      addCriterion("BIG_CENTER >", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterGreaterThanOrEqualTo(String value) {
      addCriterion("BIG_CENTER >=", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterLessThan(String value) {
      addCriterion("BIG_CENTER <", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterLessThanOrEqualTo(String value) {
      addCriterion("BIG_CENTER <=", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterLike(String value) {
      addCriterion("BIG_CENTER like", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterNotLike(String value) {
      addCriterion("BIG_CENTER not like", value, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterIn(List<String> values) {
      addCriterion("BIG_CENTER in", values, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterNotIn(List<String> values) {
      addCriterion("BIG_CENTER not in", values, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterBetween(String value1, String value2) {
      addCriterion("BIG_CENTER between", value1, value2, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andBigCenterNotBetween(String value1, String value2) {
      addCriterion("BIG_CENTER not between", value1, value2, "bigCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterIsNull() {
      addCriterion("SMALL_CENTER is null");
      return (Criteria) this;
    }

    public Criteria andSmallCenterIsNotNull() {
      addCriterion("SMALL_CENTER is not null");
      return (Criteria) this;
    }

    public Criteria andSmallCenterEqualTo(String value) {
      addCriterion("SMALL_CENTER =", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterNotEqualTo(String value) {
      addCriterion("SMALL_CENTER <>", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterGreaterThan(String value) {
      addCriterion("SMALL_CENTER >", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterGreaterThanOrEqualTo(String value) {
      addCriterion("SMALL_CENTER >=", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterLessThan(String value) {
      addCriterion("SMALL_CENTER <", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterLessThanOrEqualTo(String value) {
      addCriterion("SMALL_CENTER <=", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterLike(String value) {
      addCriterion("SMALL_CENTER like", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterNotLike(String value) {
      addCriterion("SMALL_CENTER not like", value, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterIn(List<String> values) {
      addCriterion("SMALL_CENTER in", values, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterNotIn(List<String> values) {
      addCriterion("SMALL_CENTER not in", values, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterBetween(String value1, String value2) {
      addCriterion("SMALL_CENTER between", value1, value2, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterNotBetween(String value1, String value2) {
      addCriterion("SMALL_CENTER not between", value1, value2, "smallCenter");
      return (Criteria) this;
    }

    public Criteria andJobFamilyIsNull() {
      addCriterion("JOB_FAMILY is null");
      return (Criteria) this;
    }

    public Criteria andJobFamilyIsNotNull() {
      addCriterion("JOB_FAMILY is not null");
      return (Criteria) this;
    }

    public Criteria andJobFamilyEqualTo(String value) {
      addCriterion("JOB_FAMILY =", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyNotEqualTo(String value) {
      addCriterion("JOB_FAMILY <>", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyGreaterThan(String value) {
      addCriterion("JOB_FAMILY >", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyGreaterThanOrEqualTo(String value) {
      addCriterion("JOB_FAMILY >=", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyLessThan(String value) {
      addCriterion("JOB_FAMILY <", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyLessThanOrEqualTo(String value) {
      addCriterion("JOB_FAMILY <=", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyLike(String value) {
      addCriterion("JOB_FAMILY like", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyNotLike(String value) {
      addCriterion("JOB_FAMILY not like", value, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyIn(List<String> values) {
      addCriterion("JOB_FAMILY in", values, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyNotIn(List<String> values) {
      addCriterion("JOB_FAMILY not in", values, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyBetween(String value1, String value2) {
      addCriterion("JOB_FAMILY between", value1, value2, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobFamilyNotBetween(String value1, String value2) {
      addCriterion("JOB_FAMILY not between", value1, value2, "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobClassIsNull() {
      addCriterion("JOB_CLASS is null");
      return (Criteria) this;
    }

    public Criteria andJobClassIsNotNull() {
      addCriterion("JOB_CLASS is not null");
      return (Criteria) this;
    }

    public Criteria andJobClassEqualTo(String value) {
      addCriterion("JOB_CLASS =", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassNotEqualTo(String value) {
      addCriterion("JOB_CLASS <>", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassGreaterThan(String value) {
      addCriterion("JOB_CLASS >", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassGreaterThanOrEqualTo(String value) {
      addCriterion("JOB_CLASS >=", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassLessThan(String value) {
      addCriterion("JOB_CLASS <", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassLessThanOrEqualTo(String value) {
      addCriterion("JOB_CLASS <=", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassLike(String value) {
      addCriterion("JOB_CLASS like", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassNotLike(String value) {
      addCriterion("JOB_CLASS not like", value, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassIn(List<String> values) {
      addCriterion("JOB_CLASS in", values, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassNotIn(List<String> values) {
      addCriterion("JOB_CLASS not in", values, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassBetween(String value1, String value2) {
      addCriterion("JOB_CLASS between", value1, value2, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobClassNotBetween(String value1, String value2) {
      addCriterion("JOB_CLASS not between", value1, value2, "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassIsNull() {
      addCriterion("JOB_SUBCLASS is null");
      return (Criteria) this;
    }

    public Criteria andJobSubclassIsNotNull() {
      addCriterion("JOB_SUBCLASS is not null");
      return (Criteria) this;
    }

    public Criteria andJobSubclassEqualTo(String value) {
      addCriterion("JOB_SUBCLASS =", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassNotEqualTo(String value) {
      addCriterion("JOB_SUBCLASS <>", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassGreaterThan(String value) {
      addCriterion("JOB_SUBCLASS >", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassGreaterThanOrEqualTo(String value) {
      addCriterion("JOB_SUBCLASS >=", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassLessThan(String value) {
      addCriterion("JOB_SUBCLASS <", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassLessThanOrEqualTo(String value) {
      addCriterion("JOB_SUBCLASS <=", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassLike(String value) {
      addCriterion("JOB_SUBCLASS like", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassNotLike(String value) {
      addCriterion("JOB_SUBCLASS not like", value, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassIn(List<String> values) {
      addCriterion("JOB_SUBCLASS in", values, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassNotIn(List<String> values) {
      addCriterion("JOB_SUBCLASS not in", values, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassBetween(String value1, String value2) {
      addCriterion("JOB_SUBCLASS between", value1, value2, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassNotBetween(String value1, String value2) {
      addCriterion("JOB_SUBCLASS not between", value1, value2, "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityIsNull() {
      addCriterion("RECRUIT_QUANTITY is null");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityIsNotNull() {
      addCriterion("RECRUIT_QUANTITY is not null");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityEqualTo(String value) {
      addCriterion("RECRUIT_QUANTITY =", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityNotEqualTo(String value) {
      addCriterion("RECRUIT_QUANTITY <>", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityGreaterThan(String value) {
      addCriterion("RECRUIT_QUANTITY >", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityGreaterThanOrEqualTo(String value) {
      addCriterion("RECRUIT_QUANTITY >=", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityLessThan(String value) {
      addCriterion("RECRUIT_QUANTITY <", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityLessThanOrEqualTo(String value) {
      addCriterion("RECRUIT_QUANTITY <=", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityLike(String value) {
      addCriterion("RECRUIT_QUANTITY like", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityNotLike(String value) {
      addCriterion("RECRUIT_QUANTITY not like", value, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityIn(List<String> values) {
      addCriterion("RECRUIT_QUANTITY in", values, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityNotIn(List<String> values) {
      addCriterion("RECRUIT_QUANTITY not in", values, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityBetween(String value1, String value2) {
      addCriterion("RECRUIT_QUANTITY between", value1, value2, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityNotBetween(String value1, String value2) {
      addCriterion("RECRUIT_QUANTITY not between", value1, value2, "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseIsNull() {
      addCriterion("EDUCATION_ADVISE is null");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseIsNotNull() {
      addCriterion("EDUCATION_ADVISE is not null");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseEqualTo(String value) {
      addCriterion("EDUCATION_ADVISE =", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseNotEqualTo(String value) {
      addCriterion("EDUCATION_ADVISE <>", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseGreaterThan(String value) {
      addCriterion("EDUCATION_ADVISE >", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseGreaterThanOrEqualTo(String value) {
      addCriterion("EDUCATION_ADVISE >=", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseLessThan(String value) {
      addCriterion("EDUCATION_ADVISE <", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseLessThanOrEqualTo(String value) {
      addCriterion("EDUCATION_ADVISE <=", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseLike(String value) {
      addCriterion("EDUCATION_ADVISE like", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseNotLike(String value) {
      addCriterion("EDUCATION_ADVISE not like", value, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseIn(List<String> values) {
      addCriterion("EDUCATION_ADVISE in", values, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseNotIn(List<String> values) {
      addCriterion("EDUCATION_ADVISE not in", values, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseBetween(String value1, String value2) {
      addCriterion("EDUCATION_ADVISE between", value1, value2, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseNotBetween(String value1, String value2) {
      addCriterion("EDUCATION_ADVISE not between", value1, value2, "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseIsNull() {
      addCriterion("SCHOOL_ADVISE is null");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseIsNotNull() {
      addCriterion("SCHOOL_ADVISE is not null");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseEqualTo(String value) {
      addCriterion("SCHOOL_ADVISE =", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseNotEqualTo(String value) {
      addCriterion("SCHOOL_ADVISE <>", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseGreaterThan(String value) {
      addCriterion("SCHOOL_ADVISE >", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseGreaterThanOrEqualTo(String value) {
      addCriterion("SCHOOL_ADVISE >=", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseLessThan(String value) {
      addCriterion("SCHOOL_ADVISE <", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseLessThanOrEqualTo(String value) {
      addCriterion("SCHOOL_ADVISE <=", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseLike(String value) {
      addCriterion("SCHOOL_ADVISE like", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseNotLike(String value) {
      addCriterion("SCHOOL_ADVISE not like", value, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseIn(List<String> values) {
      addCriterion("SCHOOL_ADVISE in", values, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseNotIn(List<String> values) {
      addCriterion("SCHOOL_ADVISE not in", values, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseBetween(String value1, String value2) {
      addCriterion("SCHOOL_ADVISE between", value1, value2, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseNotBetween(String value1, String value2) {
      addCriterion("SCHOOL_ADVISE not between", value1, value2, "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseIsNull() {
      addCriterion("SEX_ADVISE is null");
      return (Criteria) this;
    }

    public Criteria andSexAdviseIsNotNull() {
      addCriterion("SEX_ADVISE is not null");
      return (Criteria) this;
    }

    public Criteria andSexAdviseEqualTo(String value) {
      addCriterion("SEX_ADVISE =", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseNotEqualTo(String value) {
      addCriterion("SEX_ADVISE <>", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseGreaterThan(String value) {
      addCriterion("SEX_ADVISE >", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseGreaterThanOrEqualTo(String value) {
      addCriterion("SEX_ADVISE >=", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseLessThan(String value) {
      addCriterion("SEX_ADVISE <", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseLessThanOrEqualTo(String value) {
      addCriterion("SEX_ADVISE <=", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseLike(String value) {
      addCriterion("SEX_ADVISE like", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseNotLike(String value) {
      addCriterion("SEX_ADVISE not like", value, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseIn(List<String> values) {
      addCriterion("SEX_ADVISE in", values, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseNotIn(List<String> values) {
      addCriterion("SEX_ADVISE not in", values, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseBetween(String value1, String value2) {
      addCriterion("SEX_ADVISE between", value1, value2, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseNotBetween(String value1, String value2) {
      addCriterion("SEX_ADVISE not between", value1, value2, "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorIsNull() {
      addCriterion("PREFERRED_MAJOR is null");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorIsNotNull() {
      addCriterion("PREFERRED_MAJOR is not null");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorEqualTo(String value) {
      addCriterion("PREFERRED_MAJOR =", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorNotEqualTo(String value) {
      addCriterion("PREFERRED_MAJOR <>", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorGreaterThan(String value) {
      addCriterion("PREFERRED_MAJOR >", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorGreaterThanOrEqualTo(String value) {
      addCriterion("PREFERRED_MAJOR >=", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorLessThan(String value) {
      addCriterion("PREFERRED_MAJOR <", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorLessThanOrEqualTo(String value) {
      addCriterion("PREFERRED_MAJOR <=", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorLike(String value) {
      addCriterion("PREFERRED_MAJOR like", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorNotLike(String value) {
      addCriterion("PREFERRED_MAJOR not like", value, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorIn(List<String> values) {
      addCriterion("PREFERRED_MAJOR in", values, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorNotIn(List<String> values) {
      addCriterion("PREFERRED_MAJOR not in", values, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorBetween(String value1, String value2) {
      addCriterion("PREFERRED_MAJOR between", value1, value2, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorNotBetween(String value1, String value2) {
      addCriterion("PREFERRED_MAJOR not between", value1, value2, "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorIsNull() {
      addCriterion("ALTERNATIVE_MAJOR is null");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorIsNotNull() {
      addCriterion("ALTERNATIVE_MAJOR is not null");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorEqualTo(String value) {
      addCriterion("ALTERNATIVE_MAJOR =", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorNotEqualTo(String value) {
      addCriterion("ALTERNATIVE_MAJOR <>", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorGreaterThan(String value) {
      addCriterion("ALTERNATIVE_MAJOR >", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorGreaterThanOrEqualTo(String value) {
      addCriterion("ALTERNATIVE_MAJOR >=", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorLessThan(String value) {
      addCriterion("ALTERNATIVE_MAJOR <", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorLessThanOrEqualTo(String value) {
      addCriterion("ALTERNATIVE_MAJOR <=", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorLike(String value) {
      addCriterion("ALTERNATIVE_MAJOR like", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorNotLike(String value) {
      addCriterion("ALTERNATIVE_MAJOR not like", value, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorIn(List<String> values) {
      addCriterion("ALTERNATIVE_MAJOR in", values, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorNotIn(List<String> values) {
      addCriterion("ALTERNATIVE_MAJOR not in", values, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorBetween(String value1, String value2) {
      addCriterion("ALTERNATIVE_MAJOR between", value1, value2, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorNotBetween(String value1, String value2) {
      addCriterion("ALTERNATIVE_MAJOR not between", value1, value2, "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andOtherDemandIsNull() {
      addCriterion("OTHER_DEMAND is null");
      return (Criteria) this;
    }

    public Criteria andOtherDemandIsNotNull() {
      addCriterion("OTHER_DEMAND is not null");
      return (Criteria) this;
    }

    public Criteria andOtherDemandEqualTo(String value) {
      addCriterion("OTHER_DEMAND =", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandNotEqualTo(String value) {
      addCriterion("OTHER_DEMAND <>", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandGreaterThan(String value) {
      addCriterion("OTHER_DEMAND >", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandGreaterThanOrEqualTo(String value) {
      addCriterion("OTHER_DEMAND >=", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandLessThan(String value) {
      addCriterion("OTHER_DEMAND <", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandLessThanOrEqualTo(String value) {
      addCriterion("OTHER_DEMAND <=", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandLike(String value) {
      addCriterion("OTHER_DEMAND like", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandNotLike(String value) {
      addCriterion("OTHER_DEMAND not like", value, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandIn(List<String> values) {
      addCriterion("OTHER_DEMAND in", values, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandNotIn(List<String> values) {
      addCriterion("OTHER_DEMAND not in", values, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandBetween(String value1, String value2) {
      addCriterion("OTHER_DEMAND between", value1, value2, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andOtherDemandNotBetween(String value1, String value2) {
      addCriterion("OTHER_DEMAND not between", value1, value2, "otherDemand");
      return (Criteria) this;
    }

    public Criteria andPostDescribeIsNull() {
      addCriterion("POST_DESCRIBE is null");
      return (Criteria) this;
    }

    public Criteria andPostDescribeIsNotNull() {
      addCriterion("POST_DESCRIBE is not null");
      return (Criteria) this;
    }

    public Criteria andPostDescribeEqualTo(String value) {
      addCriterion("POST_DESCRIBE =", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeNotEqualTo(String value) {
      addCriterion("POST_DESCRIBE <>", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeGreaterThan(String value) {
      addCriterion("POST_DESCRIBE >", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeGreaterThanOrEqualTo(String value) {
      addCriterion("POST_DESCRIBE >=", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeLessThan(String value) {
      addCriterion("POST_DESCRIBE <", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeLessThanOrEqualTo(String value) {
      addCriterion("POST_DESCRIBE <=", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeLike(String value) {
      addCriterion("POST_DESCRIBE like", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeNotLike(String value) {
      addCriterion("POST_DESCRIBE not like", value, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeIn(List<String> values) {
      addCriterion("POST_DESCRIBE in", values, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeNotIn(List<String> values) {
      addCriterion("POST_DESCRIBE not in", values, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeBetween(String value1, String value2) {
      addCriterion("POST_DESCRIBE between", value1, value2, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andPostDescribeNotBetween(String value1, String value2) {
      addCriterion("POST_DESCRIBE not between", value1, value2, "postDescribe");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionIsNull() {
      addCriterion("SPECIAL_CONDITION is null");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionIsNotNull() {
      addCriterion("SPECIAL_CONDITION is not null");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionEqualTo(String value) {
      addCriterion("SPECIAL_CONDITION =", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionNotEqualTo(String value) {
      addCriterion("SPECIAL_CONDITION <>", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionGreaterThan(String value) {
      addCriterion("SPECIAL_CONDITION >", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionGreaterThanOrEqualTo(String value) {
      addCriterion("SPECIAL_CONDITION >=", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionLessThan(String value) {
      addCriterion("SPECIAL_CONDITION <", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionLessThanOrEqualTo(String value) {
      addCriterion("SPECIAL_CONDITION <=", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionLike(String value) {
      addCriterion("SPECIAL_CONDITION like", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionNotLike(String value) {
      addCriterion("SPECIAL_CONDITION not like", value, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionIn(List<String> values) {
      addCriterion("SPECIAL_CONDITION in", values, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionNotIn(List<String> values) {
      addCriterion("SPECIAL_CONDITION not in", values, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionBetween(String value1, String value2) {
      addCriterion("SPECIAL_CONDITION between", value1, value2, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionNotBetween(String value1, String value2) {
      addCriterion("SPECIAL_CONDITION not between", value1, value2, "specialCondition");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andPostIdLikeInsensitive(String value) {
      addCriterion("upper(POST_ID) like", value.toUpperCase(), "postId");
      return (Criteria) this;
    }

    public Criteria andPostNameLikeInsensitive(String value) {
      addCriterion("upper(POST_NAME) like", value.toUpperCase(), "postName");
      return (Criteria) this;
    }

    public Criteria andRemarkLikeInsensitive(String value) {
      addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
      return (Criteria) this;
    }

    public Criteria andReserved1LikeInsensitive(String value) {
      addCriterion("upper(RESERVED_1) like", value.toUpperCase(), "reserved1");
      return (Criteria) this;
    }

    public Criteria andReserved2LikeInsensitive(String value) {
      addCriterion("upper(RESERVED_2) like", value.toUpperCase(), "reserved2");
      return (Criteria) this;
    }

    public Criteria andReserved3LikeInsensitive(String value) {
      addCriterion("upper(RESERVED_3) like", value.toUpperCase(), "reserved3");
      return (Criteria) this;
    }

    public Criteria andStatusLikeInsensitive(String value) {
      addCriterion("upper(STATUS) like", value.toUpperCase(), "status");
      return (Criteria) this;
    }

    public Criteria andOrganizationLikeInsensitive(String value) {
      addCriterion("upper(ORGANIZATION) like", value.toUpperCase(), "organization");
      return (Criteria) this;
    }

    public Criteria andBigCenterLikeInsensitive(String value) {
      addCriterion("upper(BIG_CENTER) like", value.toUpperCase(), "bigCenter");
      return (Criteria) this;
    }

    public Criteria andSmallCenterLikeInsensitive(String value) {
      addCriterion("upper(SMALL_CENTER) like", value.toUpperCase(), "smallCenter");
      return (Criteria) this;
    }

    public Criteria andJobFamilyLikeInsensitive(String value) {
      addCriterion("upper(JOB_FAMILY) like", value.toUpperCase(), "jobFamily");
      return (Criteria) this;
    }

    public Criteria andJobClassLikeInsensitive(String value) {
      addCriterion("upper(JOB_CLASS) like", value.toUpperCase(), "jobClass");
      return (Criteria) this;
    }

    public Criteria andJobSubclassLikeInsensitive(String value) {
      addCriterion("upper(JOB_SUBCLASS) like", value.toUpperCase(), "jobSubclass");
      return (Criteria) this;
    }

    public Criteria andRecruitQuantityLikeInsensitive(String value) {
      addCriterion("upper(RECRUIT_QUANTITY) like", value.toUpperCase(), "recruitQuantity");
      return (Criteria) this;
    }

    public Criteria andEducationAdviseLikeInsensitive(String value) {
      addCriterion("upper(EDUCATION_ADVISE) like", value.toUpperCase(), "educationAdvise");
      return (Criteria) this;
    }

    public Criteria andSchoolAdviseLikeInsensitive(String value) {
      addCriterion("upper(SCHOOL_ADVISE) like", value.toUpperCase(), "schoolAdvise");
      return (Criteria) this;
    }

    public Criteria andSexAdviseLikeInsensitive(String value) {
      addCriterion("upper(SEX_ADVISE) like", value.toUpperCase(), "sexAdvise");
      return (Criteria) this;
    }

    public Criteria andPreferredMajorLikeInsensitive(String value) {
      addCriterion("upper(PREFERRED_MAJOR) like", value.toUpperCase(), "preferredMajor");
      return (Criteria) this;
    }

    public Criteria andAlternativeMajorLikeInsensitive(String value) {
      addCriterion("upper(ALTERNATIVE_MAJOR) like", value.toUpperCase(), "alternativeMajor");
      return (Criteria) this;
    }

    public Criteria andOtherDemandLikeInsensitive(String value) {
      addCriterion("upper(OTHER_DEMAND) like", value.toUpperCase(), "otherDemand");
      return (Criteria) this;
    }

    public Criteria andPostDescribeLikeInsensitive(String value) {
      addCriterion("upper(POST_DESCRIBE) like", value.toUpperCase(), "postDescribe");
      return (Criteria) this;
    }

    public Criteria andSpecialConditionLikeInsensitive(String value) {
      addCriterion("upper(SPECIAL_CONDITION) like", value.toUpperCase(), "specialCondition");
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
