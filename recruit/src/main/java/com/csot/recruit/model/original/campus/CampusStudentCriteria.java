package com.csot.recruit.model.original.campus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CampusStudentCriteria {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  protected Page page;

  public CampusStudentCriteria() {
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

    protected void addCriterionForJDBCDate(String condition, Date value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value.getTime()), property);
    }

    protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
      if (values == null || values.size() == 0) {
        throw new RuntimeException("Value list for " + property + " cannot be null or empty");
      }
      List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
      Iterator<Date> iter = values.iterator();
      while (iter.hasNext()) {
        dateList.add(new java.sql.Date(iter.next().getTime()));
      }
      addCriterion(condition, dateList, property);
    }

    protected void addCriterionForJDBCDate(String condition, Date value1, Date value2,
        String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      addCriterion(condition, new java.sql.Date(value1.getTime()),
          new java.sql.Date(value2.getTime()), property);
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

    public Criteria andSiteIdIsNull() {
      addCriterion("SITE_ID is null");
      return (Criteria) this;
    }

    public Criteria andSiteIdIsNotNull() {
      addCriterion("SITE_ID is not null");
      return (Criteria) this;
    }

    public Criteria andSiteIdEqualTo(String value) {
      addCriterion("SITE_ID =", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdNotEqualTo(String value) {
      addCriterion("SITE_ID <>", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdGreaterThan(String value) {
      addCriterion("SITE_ID >", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdGreaterThanOrEqualTo(String value) {
      addCriterion("SITE_ID >=", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdLessThan(String value) {
      addCriterion("SITE_ID <", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdLessThanOrEqualTo(String value) {
      addCriterion("SITE_ID <=", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdLike(String value) {
      addCriterion("SITE_ID like", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdNotLike(String value) {
      addCriterion("SITE_ID not like", value, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdIn(List<String> values) {
      addCriterion("SITE_ID in", values, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdNotIn(List<String> values) {
      addCriterion("SITE_ID not in", values, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdBetween(String value1, String value2) {
      addCriterion("SITE_ID between", value1, value2, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteIdNotBetween(String value1, String value2) {
      addCriterion("SITE_ID not between", value1, value2, "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteNameIsNull() {
      addCriterion("SITE_NAME is null");
      return (Criteria) this;
    }

    public Criteria andSiteNameIsNotNull() {
      addCriterion("SITE_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andSiteNameEqualTo(String value) {
      addCriterion("SITE_NAME =", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameNotEqualTo(String value) {
      addCriterion("SITE_NAME <>", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameGreaterThan(String value) {
      addCriterion("SITE_NAME >", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
      addCriterion("SITE_NAME >=", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameLessThan(String value) {
      addCriterion("SITE_NAME <", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameLessThanOrEqualTo(String value) {
      addCriterion("SITE_NAME <=", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameLike(String value) {
      addCriterion("SITE_NAME like", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameNotLike(String value) {
      addCriterion("SITE_NAME not like", value, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameIn(List<String> values) {
      addCriterion("SITE_NAME in", values, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameNotIn(List<String> values) {
      addCriterion("SITE_NAME not in", values, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameBetween(String value1, String value2) {
      addCriterion("SITE_NAME between", value1, value2, "siteName");
      return (Criteria) this;
    }

    public Criteria andSiteNameNotBetween(String value1, String value2) {
      addCriterion("SITE_NAME not between", value1, value2, "siteName");
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

    public Criteria andWorkingPlaceIsNull() {
      addCriterion("WORKING_PLACE is null");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceIsNotNull() {
      addCriterion("WORKING_PLACE is not null");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceEqualTo(String value) {
      addCriterion("WORKING_PLACE =", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceNotEqualTo(String value) {
      addCriterion("WORKING_PLACE <>", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceGreaterThan(String value) {
      addCriterion("WORKING_PLACE >", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceGreaterThanOrEqualTo(String value) {
      addCriterion("WORKING_PLACE >=", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceLessThan(String value) {
      addCriterion("WORKING_PLACE <", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceLessThanOrEqualTo(String value) {
      addCriterion("WORKING_PLACE <=", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceLike(String value) {
      addCriterion("WORKING_PLACE like", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceNotLike(String value) {
      addCriterion("WORKING_PLACE not like", value, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceIn(List<String> values) {
      addCriterion("WORKING_PLACE in", values, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceNotIn(List<String> values) {
      addCriterion("WORKING_PLACE not in", values, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceBetween(String value1, String value2) {
      addCriterion("WORKING_PLACE between", value1, value2, "workingPlace");
      return (Criteria) this;
    }

    public Criteria andWorkingPlaceNotBetween(String value1, String value2) {
      addCriterion("WORKING_PLACE not between", value1, value2, "workingPlace");
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


    public Criteria andOrgIdIsNotNull() {
      addCriterion("ORG_ID is not null");
      return (Criteria) this;
    }

    public Criteria andOrgIdEqualTo(String value) {
      addCriterion("ORG_ID =", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdNotEqualTo(String value) {
      addCriterion("ORG_ID <>", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdGreaterThan(String value) {
      addCriterion("ORG_ID >", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
      addCriterion("ORG_ID >=", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdLessThan(String value) {
      addCriterion("ORG_ID <", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdLessThanOrEqualTo(String value) {
      addCriterion("ORG_ID <=", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdLike(String value) {
      addCriterion("ORG_ID like", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdNotLike(String value) {
      addCriterion("ORG_ID not like", value, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdIn(List<String> values) {
      addCriterion("ORG_ID in", values, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdNotIn(List<String> values) {
      addCriterion("ORG_ID not in", values, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdBetween(String value1, String value2) {
      addCriterion("ORG_ID between", value1, value2, "orgId");
      return (Criteria) this;
    }

    public Criteria andOrgIdNotBetween(String value1, String value2) {
      addCriterion("ORG_ID not between", value1, value2, "orgId");
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

    public Criteria andDepartmentIsNull() {
      addCriterion("DEPARTMENT is null");
      return (Criteria) this;
    }

    public Criteria andDepartmentIsNotNull() {
      addCriterion("DEPARTMENT is not null");
      return (Criteria) this;
    }

    public Criteria andDepartmentEqualTo(String value) {
      addCriterion("DEPARTMENT =", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentNotEqualTo(String value) {
      addCriterion("DEPARTMENT <>", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentGreaterThan(String value) {
      addCriterion("DEPARTMENT >", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
      addCriterion("DEPARTMENT >=", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentLessThan(String value) {
      addCriterion("DEPARTMENT <", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentLessThanOrEqualTo(String value) {
      addCriterion("DEPARTMENT <=", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentLike(String value) {
      addCriterion("DEPARTMENT like", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentNotLike(String value) {
      addCriterion("DEPARTMENT not like", value, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentIn(List<String> values) {
      addCriterion("DEPARTMENT in", values, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentNotIn(List<String> values) {
      addCriterion("DEPARTMENT not in", values, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentBetween(String value1, String value2) {
      addCriterion("DEPARTMENT between", value1, value2, "department");
      return (Criteria) this;
    }

    public Criteria andDepartmentNotBetween(String value1, String value2) {
      addCriterion("DEPARTMENT not between", value1, value2, "department");
      return (Criteria) this;
    }

    public Criteria andOfficesIsNull() {
      addCriterion("OFFICES is null");
      return (Criteria) this;
    }

    public Criteria andOfficesIsNotNull() {
      addCriterion("OFFICES is not null");
      return (Criteria) this;
    }

    public Criteria andOfficesEqualTo(String value) {
      addCriterion("OFFICES =", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesNotEqualTo(String value) {
      addCriterion("OFFICES <>", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesGreaterThan(String value) {
      addCriterion("OFFICES >", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesGreaterThanOrEqualTo(String value) {
      addCriterion("OFFICES >=", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesLessThan(String value) {
      addCriterion("OFFICES <", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesLessThanOrEqualTo(String value) {
      addCriterion("OFFICES <=", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesLike(String value) {
      addCriterion("OFFICES like", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesNotLike(String value) {
      addCriterion("OFFICES not like", value, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesIn(List<String> values) {
      addCriterion("OFFICES in", values, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesNotIn(List<String> values) {
      addCriterion("OFFICES not in", values, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesBetween(String value1, String value2) {
      addCriterion("OFFICES between", value1, value2, "offices");
      return (Criteria) this;
    }

    public Criteria andOfficesNotBetween(String value1, String value2) {
      addCriterion("OFFICES not between", value1, value2, "offices");
      return (Criteria) this;
    }

    public Criteria andRealnameIsNull() {
      addCriterion("REALNAME is null");
      return (Criteria) this;
    }

    public Criteria andRealnameIsNotNull() {
      addCriterion("REALNAME is not null");
      return (Criteria) this;
    }

    public Criteria andRealnameEqualTo(String value) {
      addCriterion("REALNAME =", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameNotEqualTo(String value) {
      addCriterion("REALNAME <>", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameGreaterThan(String value) {
      addCriterion("REALNAME >", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameGreaterThanOrEqualTo(String value) {
      addCriterion("REALNAME >=", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameLessThan(String value) {
      addCriterion("REALNAME <", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameLessThanOrEqualTo(String value) {
      addCriterion("REALNAME <=", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameLike(String value) {
      addCriterion("REALNAME like", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameNotLike(String value) {
      addCriterion("REALNAME not like", value, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameIn(List<String> values) {
      addCriterion("REALNAME in", values, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameNotIn(List<String> values) {
      addCriterion("REALNAME not in", values, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameBetween(String value1, String value2) {
      addCriterion("REALNAME between", value1, value2, "realname");
      return (Criteria) this;
    }

    public Criteria andRealnameNotBetween(String value1, String value2) {
      addCriterion("REALNAME not between", value1, value2, "realname");
      return (Criteria) this;
    }

    public Criteria andSexIsNull() {
      addCriterion("SEX is null");
      return (Criteria) this;
    }

    public Criteria andSexIsNotNull() {
      addCriterion("SEX is not null");
      return (Criteria) this;
    }

    public Criteria andSexEqualTo(String value) {
      addCriterion("SEX =", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexNotEqualTo(String value) {
      addCriterion("SEX <>", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexGreaterThan(String value) {
      addCriterion("SEX >", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexGreaterThanOrEqualTo(String value) {
      addCriterion("SEX >=", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexLessThan(String value) {
      addCriterion("SEX <", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexLessThanOrEqualTo(String value) {
      addCriterion("SEX <=", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexLike(String value) {
      addCriterion("SEX like", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexNotLike(String value) {
      addCriterion("SEX not like", value, "sex");
      return (Criteria) this;
    }

    public Criteria andSexIn(List<String> values) {
      addCriterion("SEX in", values, "sex");
      return (Criteria) this;
    }

    public Criteria andSexNotIn(List<String> values) {
      addCriterion("SEX not in", values, "sex");
      return (Criteria) this;
    }

    public Criteria andSexBetween(String value1, String value2) {
      addCriterion("SEX between", value1, value2, "sex");
      return (Criteria) this;
    }

    public Criteria andSexNotBetween(String value1, String value2) {
      addCriterion("SEX not between", value1, value2, "sex");
      return (Criteria) this;
    }

    public Criteria andEducationIsNull() {
      addCriterion("EDUCATION is null");
      return (Criteria) this;
    }

    public Criteria andEducationIsNotNull() {
      addCriterion("EDUCATION is not null");
      return (Criteria) this;
    }

    public Criteria andEducationEqualTo(String value) {
      addCriterion("EDUCATION =", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationNotEqualTo(String value) {
      addCriterion("EDUCATION <>", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationGreaterThan(String value) {
      addCriterion("EDUCATION >", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationGreaterThanOrEqualTo(String value) {
      addCriterion("EDUCATION >=", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationLessThan(String value) {
      addCriterion("EDUCATION <", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationLessThanOrEqualTo(String value) {
      addCriterion("EDUCATION <=", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationLike(String value) {
      addCriterion("EDUCATION like", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationNotLike(String value) {
      addCriterion("EDUCATION not like", value, "education");
      return (Criteria) this;
    }

    public Criteria andEducationIn(List<String> values) {
      addCriterion("EDUCATION in", values, "education");
      return (Criteria) this;
    }

    public Criteria andEducationNotIn(List<String> values) {
      addCriterion("EDUCATION not in", values, "education");
      return (Criteria) this;
    }

    public Criteria andEducationBetween(String value1, String value2) {
      addCriterion("EDUCATION between", value1, value2, "education");
      return (Criteria) this;
    }

    public Criteria andEducationNotBetween(String value1, String value2) {
      addCriterion("EDUCATION not between", value1, value2, "education");
      return (Criteria) this;
    }

    public Criteria andSchoolIsNull() {
      addCriterion("SCHOOL is null");
      return (Criteria) this;
    }

    public Criteria andSchoolIsNotNull() {
      addCriterion("SCHOOL is not null");
      return (Criteria) this;
    }

    public Criteria andSchoolEqualTo(String value) {
      addCriterion("SCHOOL =", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolNotEqualTo(String value) {
      addCriterion("SCHOOL <>", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolGreaterThan(String value) {
      addCriterion("SCHOOL >", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolGreaterThanOrEqualTo(String value) {
      addCriterion("SCHOOL >=", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolLessThan(String value) {
      addCriterion("SCHOOL <", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolLessThanOrEqualTo(String value) {
      addCriterion("SCHOOL <=", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolLike(String value) {
      addCriterion("SCHOOL like", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolNotLike(String value) {
      addCriterion("SCHOOL not like", value, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolIn(List<String> values) {
      addCriterion("SCHOOL in", values, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolNotIn(List<String> values) {
      addCriterion("SCHOOL not in", values, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolBetween(String value1, String value2) {
      addCriterion("SCHOOL between", value1, value2, "school");
      return (Criteria) this;
    }

    public Criteria andSchoolNotBetween(String value1, String value2) {
      addCriterion("SCHOOL not between", value1, value2, "school");
      return (Criteria) this;
    }

    public Criteria andMajorIsNull() {
      addCriterion("MAJOR is null");
      return (Criteria) this;
    }

    public Criteria andMajorIsNotNull() {
      addCriterion("MAJOR is not null");
      return (Criteria) this;
    }

    public Criteria andMajorEqualTo(String value) {
      addCriterion("MAJOR =", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorNotEqualTo(String value) {
      addCriterion("MAJOR <>", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorGreaterThan(String value) {
      addCriterion("MAJOR >", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorGreaterThanOrEqualTo(String value) {
      addCriterion("MAJOR >=", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorLessThan(String value) {
      addCriterion("MAJOR <", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorLessThanOrEqualTo(String value) {
      addCriterion("MAJOR <=", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorLike(String value) {
      addCriterion("MAJOR like", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorNotLike(String value) {
      addCriterion("MAJOR not like", value, "major");
      return (Criteria) this;
    }

    public Criteria andMajorIn(List<String> values) {
      addCriterion("MAJOR in", values, "major");
      return (Criteria) this;
    }

    public Criteria andMajorNotIn(List<String> values) {
      addCriterion("MAJOR not in", values, "major");
      return (Criteria) this;
    }

    public Criteria andMajorBetween(String value1, String value2) {
      addCriterion("MAJOR between", value1, value2, "major");
      return (Criteria) this;
    }

    public Criteria andMajorNotBetween(String value1, String value2) {
      addCriterion("MAJOR not between", value1, value2, "major");
      return (Criteria) this;
    }

    public Criteria andNativePlaceIsNull() {
      addCriterion("NATIVE_PLACE is null");
      return (Criteria) this;
    }

    public Criteria andNativePlaceIsNotNull() {
      addCriterion("NATIVE_PLACE is not null");
      return (Criteria) this;
    }

    public Criteria andNativePlaceEqualTo(String value) {
      addCriterion("NATIVE_PLACE =", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceNotEqualTo(String value) {
      addCriterion("NATIVE_PLACE <>", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceGreaterThan(String value) {
      addCriterion("NATIVE_PLACE >", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
      addCriterion("NATIVE_PLACE >=", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceLessThan(String value) {
      addCriterion("NATIVE_PLACE <", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceLessThanOrEqualTo(String value) {
      addCriterion("NATIVE_PLACE <=", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceLike(String value) {
      addCriterion("NATIVE_PLACE like", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceNotLike(String value) {
      addCriterion("NATIVE_PLACE not like", value, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceIn(List<String> values) {
      addCriterion("NATIVE_PLACE in", values, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceNotIn(List<String> values) {
      addCriterion("NATIVE_PLACE not in", values, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceBetween(String value1, String value2) {
      addCriterion("NATIVE_PLACE between", value1, value2, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andNativePlaceNotBetween(String value1, String value2) {
      addCriterion("NATIVE_PLACE not between", value1, value2, "nativePlace");
      return (Criteria) this;
    }

    public Criteria andPhoneNoIsNull() {
      addCriterion("PHONE_NO is null");
      return (Criteria) this;
    }

    public Criteria andPhoneNoIsNotNull() {
      addCriterion("PHONE_NO is not null");
      return (Criteria) this;
    }

    public Criteria andPhoneNoEqualTo(String value) {
      addCriterion("PHONE_NO =", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoNotEqualTo(String value) {
      addCriterion("PHONE_NO <>", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoGreaterThan(String value) {
      addCriterion("PHONE_NO >", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoGreaterThanOrEqualTo(String value) {
      addCriterion("PHONE_NO >=", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoLessThan(String value) {
      addCriterion("PHONE_NO <", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoLessThanOrEqualTo(String value) {
      addCriterion("PHONE_NO <=", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoLike(String value) {
      addCriterion("PHONE_NO like", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoNotLike(String value) {
      addCriterion("PHONE_NO not like", value, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoIn(List<String> values) {
      addCriterion("PHONE_NO in", values, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoNotIn(List<String> values) {
      addCriterion("PHONE_NO not in", values, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoBetween(String value1, String value2) {
      addCriterion("PHONE_NO between", value1, value2, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andPhoneNoNotBetween(String value1, String value2) {
      addCriterion("PHONE_NO not between", value1, value2, "phoneNo");
      return (Criteria) this;
    }

    public Criteria andEmailIsNull() {
      addCriterion("EMAIL is null");
      return (Criteria) this;
    }

    public Criteria andEmailIsNotNull() {
      addCriterion("EMAIL is not null");
      return (Criteria) this;
    }

    public Criteria andEmailEqualTo(String value) {
      addCriterion("EMAIL =", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotEqualTo(String value) {
      addCriterion("EMAIL <>", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThan(String value) {
      addCriterion("EMAIL >", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailGreaterThanOrEqualTo(String value) {
      addCriterion("EMAIL >=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThan(String value) {
      addCriterion("EMAIL <", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLessThanOrEqualTo(String value) {
      addCriterion("EMAIL <=", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailLike(String value) {
      addCriterion("EMAIL like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotLike(String value) {
      addCriterion("EMAIL not like", value, "email");
      return (Criteria) this;
    }

    public Criteria andEmailIn(List<String> values) {
      addCriterion("EMAIL in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotIn(List<String> values) {
      addCriterion("EMAIL not in", values, "email");
      return (Criteria) this;
    }

    public Criteria andEmailBetween(String value1, String value2) {
      addCriterion("EMAIL between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andEmailNotBetween(String value1, String value2) {
      addCriterion("EMAIL not between", value1, value2, "email");
      return (Criteria) this;
    }

    public Criteria andEvaluationIsNull() {
      addCriterion("EVALUATION is null");
      return (Criteria) this;
    }

    public Criteria andEvaluationIsNotNull() {
      addCriterion("EVALUATION is not null");
      return (Criteria) this;
    }

    public Criteria andEvaluationEqualTo(String value) {
      addCriterion("EVALUATION =", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationNotEqualTo(String value) {
      addCriterion("EVALUATION <>", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationGreaterThan(String value) {
      addCriterion("EVALUATION >", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationGreaterThanOrEqualTo(String value) {
      addCriterion("EVALUATION >=", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationLessThan(String value) {
      addCriterion("EVALUATION <", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationLessThanOrEqualTo(String value) {
      addCriterion("EVALUATION <=", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationLike(String value) {
      addCriterion("EVALUATION like", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationNotLike(String value) {
      addCriterion("EVALUATION not like", value, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationIn(List<String> values) {
      addCriterion("EVALUATION in", values, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationNotIn(List<String> values) {
      addCriterion("EVALUATION not in", values, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationBetween(String value1, String value2) {
      addCriterion("EVALUATION between", value1, value2, "evaluation");
      return (Criteria) this;
    }

    public Criteria andEvaluationNotBetween(String value1, String value2) {
      addCriterion("EVALUATION not between", value1, value2, "evaluation");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskIsNull() {
      addCriterion("MORALE_RISK is null");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskIsNotNull() {
      addCriterion("MORALE_RISK is not null");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskEqualTo(String value) {
      addCriterion("MORALE_RISK =", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskNotEqualTo(String value) {
      addCriterion("MORALE_RISK <>", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskGreaterThan(String value) {
      addCriterion("MORALE_RISK >", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskGreaterThanOrEqualTo(String value) {
      addCriterion("MORALE_RISK >=", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskLessThan(String value) {
      addCriterion("MORALE_RISK <", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskLessThanOrEqualTo(String value) {
      addCriterion("MORALE_RISK <=", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskLike(String value) {
      addCriterion("MORALE_RISK like", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskNotLike(String value) {
      addCriterion("MORALE_RISK not like", value, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskIn(List<String> values) {
      addCriterion("MORALE_RISK in", values, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskNotIn(List<String> values) {
      addCriterion("MORALE_RISK not in", values, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskBetween(String value1, String value2) {
      addCriterion("MORALE_RISK between", value1, value2, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskNotBetween(String value1, String value2) {
      addCriterion("MORALE_RISK not between", value1, value2, "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andCompetencyIsNull() {
      addCriterion("COMPETENCY is null");
      return (Criteria) this;
    }

    public Criteria andCompetencyIsNotNull() {
      addCriterion("COMPETENCY is not null");
      return (Criteria) this;
    }

    public Criteria andCompetencyEqualTo(String value) {
      addCriterion("COMPETENCY =", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyNotEqualTo(String value) {
      addCriterion("COMPETENCY <>", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyGreaterThan(String value) {
      addCriterion("COMPETENCY >", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyGreaterThanOrEqualTo(String value) {
      addCriterion("COMPETENCY >=", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyLessThan(String value) {
      addCriterion("COMPETENCY <", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyLessThanOrEqualTo(String value) {
      addCriterion("COMPETENCY <=", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyLike(String value) {
      addCriterion("COMPETENCY like", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyNotLike(String value) {
      addCriterion("COMPETENCY not like", value, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyIn(List<String> values) {
      addCriterion("COMPETENCY in", values, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyNotIn(List<String> values) {
      addCriterion("COMPETENCY not in", values, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyBetween(String value1, String value2) {
      addCriterion("COMPETENCY between", value1, value2, "competency");
      return (Criteria) this;
    }

    public Criteria andCompetencyNotBetween(String value1, String value2) {
      addCriterion("COMPETENCY not between", value1, value2, "competency");
      return (Criteria) this;
    }

    public Criteria andResultFirstIsNull() {
      addCriterion("RESULT_FIRST is null");
      return (Criteria) this;
    }

    public Criteria andResultFirstIsNotNull() {
      addCriterion("RESULT_FIRST is not null");
      return (Criteria) this;
    }

    public Criteria andResultFirstEqualTo(String value) {
      addCriterion("RESULT_FIRST =", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstNotEqualTo(String value) {
      addCriterion("RESULT_FIRST <>", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstGreaterThan(String value) {
      addCriterion("RESULT_FIRST >", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstGreaterThanOrEqualTo(String value) {
      addCriterion("RESULT_FIRST >=", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstLessThan(String value) {
      addCriterion("RESULT_FIRST <", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstLessThanOrEqualTo(String value) {
      addCriterion("RESULT_FIRST <=", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstLike(String value) {
      addCriterion("RESULT_FIRST like", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstNotLike(String value) {
      addCriterion("RESULT_FIRST not like", value, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstIn(List<String> values) {
      addCriterion("RESULT_FIRST in", values, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstNotIn(List<String> values) {
      addCriterion("RESULT_FIRST not in", values, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstBetween(String value1, String value2) {
      addCriterion("RESULT_FIRST between", value1, value2, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultFirstNotBetween(String value1, String value2) {
      addCriterion("RESULT_FIRST not between", value1, value2, "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultSecondIsNull() {
      addCriterion("RESULT_SECOND is null");
      return (Criteria) this;
    }

    public Criteria andResultSecondIsNotNull() {
      addCriterion("RESULT_SECOND is not null");
      return (Criteria) this;
    }

    public Criteria andResultSecondEqualTo(String value) {
      addCriterion("RESULT_SECOND =", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondNotEqualTo(String value) {
      addCriterion("RESULT_SECOND <>", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondGreaterThan(String value) {
      addCriterion("RESULT_SECOND >", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondGreaterThanOrEqualTo(String value) {
      addCriterion("RESULT_SECOND >=", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondLessThan(String value) {
      addCriterion("RESULT_SECOND <", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondLessThanOrEqualTo(String value) {
      addCriterion("RESULT_SECOND <=", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondLike(String value) {
      addCriterion("RESULT_SECOND like", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondNotLike(String value) {
      addCriterion("RESULT_SECOND not like", value, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondIn(List<String> values) {
      addCriterion("RESULT_SECOND in", values, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondNotIn(List<String> values) {
      addCriterion("RESULT_SECOND not in", values, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondBetween(String value1, String value2) {
      addCriterion("RESULT_SECOND between", value1, value2, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andResultSecondNotBetween(String value1, String value2) {
      addCriterion("RESULT_SECOND not between", value1, value2, "resultSecond");
      return (Criteria) this;
    }

    public Criteria andOfferIsNull() {
      addCriterion("OFFER is null");
      return (Criteria) this;
    }

    public Criteria andOfferIsNotNull() {
      addCriterion("OFFER is not null");
      return (Criteria) this;
    }

    public Criteria andOfferEqualTo(String value) {
      addCriterion("OFFER =", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferNotEqualTo(String value) {
      addCriterion("OFFER <>", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferGreaterThan(String value) {
      addCriterion("OFFER >", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferGreaterThanOrEqualTo(String value) {
      addCriterion("OFFER >=", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferLessThan(String value) {
      addCriterion("OFFER <", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferLessThanOrEqualTo(String value) {
      addCriterion("OFFER <=", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferLike(String value) {
      addCriterion("OFFER like", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferNotLike(String value) {
      addCriterion("OFFER not like", value, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferIn(List<String> values) {
      addCriterion("OFFER in", values, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferNotIn(List<String> values) {
      addCriterion("OFFER not in", values, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferBetween(String value1, String value2) {
      addCriterion("OFFER between", value1, value2, "offer");
      return (Criteria) this;
    }

    public Criteria andOfferNotBetween(String value1, String value2) {
      addCriterion("OFFER not between", value1, value2, "offer");
      return (Criteria) this;
    }

    public Criteria andTrilateralIsNull() {
      addCriterion("TRILATERAL is null");
      return (Criteria) this;
    }

    public Criteria andTrilateralIsNotNull() {
      addCriterion("TRILATERAL is not null");
      return (Criteria) this;
    }

    public Criteria andTrilateralEqualTo(String value) {
      addCriterion("TRILATERAL =", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralNotEqualTo(String value) {
      addCriterion("TRILATERAL <>", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralGreaterThan(String value) {
      addCriterion("TRILATERAL >", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralGreaterThanOrEqualTo(String value) {
      addCriterion("TRILATERAL >=", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralLessThan(String value) {
      addCriterion("TRILATERAL <", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralLessThanOrEqualTo(String value) {
      addCriterion("TRILATERAL <=", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralLike(String value) {
      addCriterion("TRILATERAL like", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralNotLike(String value) {
      addCriterion("TRILATERAL not like", value, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralIn(List<String> values) {
      addCriterion("TRILATERAL in", values, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralNotIn(List<String> values) {
      addCriterion("TRILATERAL not in", values, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralBetween(String value1, String value2) {
      addCriterion("TRILATERAL between", value1, value2, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTrilateralNotBetween(String value1, String value2) {
      addCriterion("TRILATERAL not between", value1, value2, "trilateral");
      return (Criteria) this;
    }

    public Criteria andTranscriptIsNull() {
      addCriterion("TRANSCRIPT is null");
      return (Criteria) this;
    }

    public Criteria andTranscriptIsNotNull() {
      addCriterion("TRANSCRIPT is not null");
      return (Criteria) this;
    }

    public Criteria andTranscriptEqualTo(String value) {
      addCriterion("TRANSCRIPT =", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptNotEqualTo(String value) {
      addCriterion("TRANSCRIPT <>", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptGreaterThan(String value) {
      addCriterion("TRANSCRIPT >", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptGreaterThanOrEqualTo(String value) {
      addCriterion("TRANSCRIPT >=", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptLessThan(String value) {
      addCriterion("TRANSCRIPT <", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptLessThanOrEqualTo(String value) {
      addCriterion("TRANSCRIPT <=", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptLike(String value) {
      addCriterion("TRANSCRIPT like", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptNotLike(String value) {
      addCriterion("TRANSCRIPT not like", value, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptIn(List<String> values) {
      addCriterion("TRANSCRIPT in", values, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptNotIn(List<String> values) {
      addCriterion("TRANSCRIPT not in", values, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptBetween(String value1, String value2) {
      addCriterion("TRANSCRIPT between", value1, value2, "transcript");
      return (Criteria) this;
    }

    public Criteria andTranscriptNotBetween(String value1, String value2) {
      addCriterion("TRANSCRIPT not between", value1, value2, "transcript");
      return (Criteria) this;
    }

    public Criteria andReferenceFormIsNull() {
      addCriterion("REFERENCE_FORM is null");
      return (Criteria) this;
    }

    public Criteria andReferenceFormIsNotNull() {
      addCriterion("REFERENCE_FORM is not null");
      return (Criteria) this;
    }

    public Criteria andReferenceFormEqualTo(String value) {
      addCriterion("REFERENCE_FORM =", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormNotEqualTo(String value) {
      addCriterion("REFERENCE_FORM <>", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormGreaterThan(String value) {
      addCriterion("REFERENCE_FORM >", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormGreaterThanOrEqualTo(String value) {
      addCriterion("REFERENCE_FORM >=", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormLessThan(String value) {
      addCriterion("REFERENCE_FORM <", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormLessThanOrEqualTo(String value) {
      addCriterion("REFERENCE_FORM <=", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormLike(String value) {
      addCriterion("REFERENCE_FORM like", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormNotLike(String value) {
      addCriterion("REFERENCE_FORM not like", value, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormIn(List<String> values) {
      addCriterion("REFERENCE_FORM in", values, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormNotIn(List<String> values) {
      addCriterion("REFERENCE_FORM not in", values, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormBetween(String value1, String value2) {
      addCriterion("REFERENCE_FORM between", value1, value2, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andReferenceFormNotBetween(String value1, String value2) {
      addCriterion("REFERENCE_FORM not between", value1, value2, "referenceForm");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyIsNull() {
      addCriterion("IDCARD_COPY is null");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyIsNotNull() {
      addCriterion("IDCARD_COPY is not null");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyEqualTo(String value) {
      addCriterion("IDCARD_COPY =", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyNotEqualTo(String value) {
      addCriterion("IDCARD_COPY <>", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyGreaterThan(String value) {
      addCriterion("IDCARD_COPY >", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyGreaterThanOrEqualTo(String value) {
      addCriterion("IDCARD_COPY >=", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyLessThan(String value) {
      addCriterion("IDCARD_COPY <", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyLessThanOrEqualTo(String value) {
      addCriterion("IDCARD_COPY <=", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyLike(String value) {
      addCriterion("IDCARD_COPY like", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyNotLike(String value) {
      addCriterion("IDCARD_COPY not like", value, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyIn(List<String> values) {
      addCriterion("IDCARD_COPY in", values, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyNotIn(List<String> values) {
      addCriterion("IDCARD_COPY not in", values, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyBetween(String value1, String value2) {
      addCriterion("IDCARD_COPY between", value1, value2, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyNotBetween(String value1, String value2) {
      addCriterion("IDCARD_COPY not between", value1, value2, "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptIsNull() {
      addCriterion("CET_TRANSCRIPT is null");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptIsNotNull() {
      addCriterion("CET_TRANSCRIPT is not null");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptEqualTo(String value) {
      addCriterion("CET_TRANSCRIPT =", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptNotEqualTo(String value) {
      addCriterion("CET_TRANSCRIPT <>", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptGreaterThan(String value) {
      addCriterion("CET_TRANSCRIPT >", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptGreaterThanOrEqualTo(String value) {
      addCriterion("CET_TRANSCRIPT >=", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptLessThan(String value) {
      addCriterion("CET_TRANSCRIPT <", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptLessThanOrEqualTo(String value) {
      addCriterion("CET_TRANSCRIPT <=", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptLike(String value) {
      addCriterion("CET_TRANSCRIPT like", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptNotLike(String value) {
      addCriterion("CET_TRANSCRIPT not like", value, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptIn(List<String> values) {
      addCriterion("CET_TRANSCRIPT in", values, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptNotIn(List<String> values) {
      addCriterion("CET_TRANSCRIPT not in", values, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptBetween(String value1, String value2) {
      addCriterion("CET_TRANSCRIPT between", value1, value2, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptNotBetween(String value1, String value2) {
      addCriterion("CET_TRANSCRIPT not between", value1, value2, "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andPhotoIsNull() {
      addCriterion("PHOTO is null");
      return (Criteria) this;
    }

    public Criteria andPhotoIsNotNull() {
      addCriterion("PHOTO is not null");
      return (Criteria) this;
    }

    public Criteria andPhotoEqualTo(String value) {
      addCriterion("PHOTO =", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoNotEqualTo(String value) {
      addCriterion("PHOTO <>", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoGreaterThan(String value) {
      addCriterion("PHOTO >", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoGreaterThanOrEqualTo(String value) {
      addCriterion("PHOTO >=", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoLessThan(String value) {
      addCriterion("PHOTO <", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoLessThanOrEqualTo(String value) {
      addCriterion("PHOTO <=", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoLike(String value) {
      addCriterion("PHOTO like", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoNotLike(String value) {
      addCriterion("PHOTO not like", value, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoIn(List<String> values) {
      addCriterion("PHOTO in", values, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoNotIn(List<String> values) {
      addCriterion("PHOTO not in", values, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoBetween(String value1, String value2) {
      addCriterion("PHOTO between", value1, value2, "photo");
      return (Criteria) this;
    }

    public Criteria andPhotoNotBetween(String value1, String value2) {
      addCriterion("PHOTO not between", value1, value2, "photo");
      return (Criteria) this;
    }

    public Criteria andBreakOffIsNull() {
      addCriterion("BREAK_OFF is null");
      return (Criteria) this;
    }

    public Criteria andBreakOffIsNotNull() {
      addCriterion("BREAK_OFF is not null");
      return (Criteria) this;
    }

    public Criteria andBreakOffEqualTo(String value) {
      addCriterion("BREAK_OFF =", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffNotEqualTo(String value) {
      addCriterion("BREAK_OFF <>", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffGreaterThan(String value) {
      addCriterion("BREAK_OFF >", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffGreaterThanOrEqualTo(String value) {
      addCriterion("BREAK_OFF >=", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffLessThan(String value) {
      addCriterion("BREAK_OFF <", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffLessThanOrEqualTo(String value) {
      addCriterion("BREAK_OFF <=", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffLike(String value) {
      addCriterion("BREAK_OFF like", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffNotLike(String value) {
      addCriterion("BREAK_OFF not like", value, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffIn(List<String> values) {
      addCriterion("BREAK_OFF in", values, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffNotIn(List<String> values) {
      addCriterion("BREAK_OFF not in", values, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffBetween(String value1, String value2) {
      addCriterion("BREAK_OFF between", value1, value2, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffNotBetween(String value1, String value2) {
      addCriterion("BREAK_OFF not between", value1, value2, "breakOff");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonIsNull() {
      addCriterion("BREAK_OFF_REASON is null");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonIsNotNull() {
      addCriterion("BREAK_OFF_REASON is not null");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonEqualTo(String value) {
      addCriterion("BREAK_OFF_REASON =", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonNotEqualTo(String value) {
      addCriterion("BREAK_OFF_REASON <>", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonGreaterThan(String value) {
      addCriterion("BREAK_OFF_REASON >", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonGreaterThanOrEqualTo(String value) {
      addCriterion("BREAK_OFF_REASON >=", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonLessThan(String value) {
      addCriterion("BREAK_OFF_REASON <", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonLessThanOrEqualTo(String value) {
      addCriterion("BREAK_OFF_REASON <=", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonLike(String value) {
      addCriterion("BREAK_OFF_REASON like", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonNotLike(String value) {
      addCriterion("BREAK_OFF_REASON not like", value, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonIn(List<String> values) {
      addCriterion("BREAK_OFF_REASON in", values, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonNotIn(List<String> values) {
      addCriterion("BREAK_OFF_REASON not in", values, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonBetween(String value1, String value2) {
      addCriterion("BREAK_OFF_REASON between", value1, value2, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonNotBetween(String value1, String value2) {
      addCriterion("BREAK_OFF_REASON not between", value1, value2, "breakOffReason");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeIsNull() {
      addCriterion("BREAK_OFF_TIME is null");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeIsNotNull() {
      addCriterion("BREAK_OFF_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeEqualTo(String value) {
      addCriterion("BREAK_OFF_TIME =", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeNotEqualTo(String value) {
      addCriterion("BREAK_OFF_TIME <>", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeGreaterThan(String value) {
      addCriterion("BREAK_OFF_TIME >", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeGreaterThanOrEqualTo(String value) {
      addCriterion("BREAK_OFF_TIME >=", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeLessThan(String value) {
      addCriterion("BREAK_OFF_TIME <", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeLessThanOrEqualTo(String value) {
      addCriterion("BREAK_OFF_TIME <=", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeLike(String value) {
      addCriterion("BREAK_OFF_TIME like", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeNotLike(String value) {
      addCriterion("BREAK_OFF_TIME not like", value, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeIn(List<String> values) {
      addCriterion("BREAK_OFF_TIME in", values, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeNotIn(List<String> values) {
      addCriterion("BREAK_OFF_TIME not in", values, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeBetween(String value1, String value2) {
      addCriterion("BREAK_OFF_TIME between", value1, value2, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andBreakOffTimeNotBetween(String value1, String value2) {
      addCriterion("BREAK_OFF_TIME not between", value1, value2, "breakOffTime");
      return (Criteria) this;
    }

    public Criteria andYearthIsNull() {
      addCriterion("YEARTH is null");
      return (Criteria) this;
    }

    public Criteria andYearthIsNotNull() {
      addCriterion("YEARTH is not null");
      return (Criteria) this;
    }

    public Criteria andYearthEqualTo(String value) {
      addCriterion("YEARTH =", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthNotEqualTo(String value) {
      addCriterion("YEARTH <>", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthGreaterThan(String value) {
      addCriterion("YEARTH >", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthGreaterThanOrEqualTo(String value) {
      addCriterion("YEARTH >=", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthLessThan(String value) {
      addCriterion("YEARTH <", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthLessThanOrEqualTo(String value) {
      addCriterion("YEARTH <=", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthLike(String value) {
      addCriterion("YEARTH like", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthNotLike(String value) {
      addCriterion("YEARTH not like", value, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthIn(List<String> values) {
      addCriterion("YEARTH in", values, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthNotIn(List<String> values) {
      addCriterion("YEARTH not in", values, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthBetween(String value1, String value2) {
      addCriterion("YEARTH between", value1, value2, "yearth");
      return (Criteria) this;
    }

    public Criteria andYearthNotBetween(String value1, String value2) {
      addCriterion("YEARTH not between", value1, value2, "yearth");
      return (Criteria) this;
    }

    public Criteria andChangeTimeIsNull() {
      addCriterion("CHANGE_TIME is null");
      return (Criteria) this;
    }

    public Criteria andChangeTimeIsNotNull() {
      addCriterion("CHANGE_TIME is not null");
      return (Criteria) this;
    }

    public Criteria andChangeTimeEqualTo(Date value) {
      addCriterionForJDBCDate("CHANGE_TIME =", value, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeNotEqualTo(Date value) {
      addCriterionForJDBCDate("CHANGE_TIME <>", value, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeGreaterThan(Date value) {
      addCriterionForJDBCDate("CHANGE_TIME >", value, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
      addCriterionForJDBCDate("CHANGE_TIME >=", value, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeLessThan(Date value) {
      addCriterionForJDBCDate("CHANGE_TIME <", value, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeLessThanOrEqualTo(Date value) {
      addCriterionForJDBCDate("CHANGE_TIME <=", value, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeIn(List<Date> values) {
      addCriterionForJDBCDate("CHANGE_TIME in", values, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeNotIn(List<Date> values) {
      addCriterionForJDBCDate("CHANGE_TIME not in", values, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeBetween(Date value1, Date value2) {
      addCriterionForJDBCDate("CHANGE_TIME between", value1, value2, "changeTime");
      return (Criteria) this;
    }

    public Criteria andChangeTimeNotBetween(Date value1, Date value2) {
      addCriterionForJDBCDate("CHANGE_TIME not between", value1, value2, "changeTime");
      return (Criteria) this;
    }

    public Criteria andCreateUserIsNull() {
      addCriterion("CREATE_USER is null");
      return (Criteria) this;
    }

    public Criteria andCreateUserIsNotNull() {
      addCriterion("CREATE_USER is not null");
      return (Criteria) this;
    }

    public Criteria andCreateUserEqualTo(String value) {
      addCriterion("CREATE_USER =", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserNotEqualTo(String value) {
      addCriterion("CREATE_USER <>", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserGreaterThan(String value) {
      addCriterion("CREATE_USER >", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
      addCriterion("CREATE_USER >=", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserLessThan(String value) {
      addCriterion("CREATE_USER <", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserLessThanOrEqualTo(String value) {
      addCriterion("CREATE_USER <=", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserLike(String value) {
      addCriterion("CREATE_USER like", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserNotLike(String value) {
      addCriterion("CREATE_USER not like", value, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserIn(List<String> values) {
      addCriterion("CREATE_USER in", values, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserNotIn(List<String> values) {
      addCriterion("CREATE_USER not in", values, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserBetween(String value1, String value2) {
      addCriterion("CREATE_USER between", value1, value2, "createUser");
      return (Criteria) this;
    }

    public Criteria andCreateUserNotBetween(String value1, String value2) {
      addCriterion("CREATE_USER not between", value1, value2, "createUser");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andSiteIdLikeInsensitive(String value) {
      addCriterion("upper(SITE_ID) like", value.toUpperCase(), "siteId");
      return (Criteria) this;
    }

    public Criteria andSiteNameLikeInsensitive(String value) {
      addCriterion("upper(SITE_NAME) like", value.toUpperCase(), "siteName");
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

    public Criteria andWorkingPlaceLikeInsensitive(String value) {
      addCriterion("upper(WORKING_PLACE) like", value.toUpperCase(), "workingPlace");
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

    public Criteria andDepartmentLikeInsensitive(String value) {
      addCriterion("upper(DEPARTMENT) like", value.toUpperCase(), "department");
      return (Criteria) this;
    }

    public Criteria andOfficesLikeInsensitive(String value) {
      addCriterion("upper(OFFICES) like", value.toUpperCase(), "offices");
      return (Criteria) this;
    }

    public Criteria andRealnameLikeInsensitive(String value) {
      addCriterion("upper(REALNAME) like", value.toUpperCase(), "realname");
      return (Criteria) this;
    }

    public Criteria andSexLikeInsensitive(String value) {
      addCriterion("upper(SEX) like", value.toUpperCase(), "sex");
      return (Criteria) this;
    }

    public Criteria andEducationLikeInsensitive(String value) {
      addCriterion("upper(EDUCATION) like", value.toUpperCase(), "education");
      return (Criteria) this;
    }

    public Criteria andSchoolLikeInsensitive(String value) {
      addCriterion("upper(SCHOOL) like", value.toUpperCase(), "school");
      return (Criteria) this;
    }

    public Criteria andMajorLikeInsensitive(String value) {
      addCriterion("upper(MAJOR) like", value.toUpperCase(), "major");
      return (Criteria) this;
    }

    public Criteria andNativePlaceLikeInsensitive(String value) {
      addCriterion("upper(NATIVE_PLACE) like", value.toUpperCase(), "nativePlace");
      return (Criteria) this;
    }

    public Criteria andPhoneNoLikeInsensitive(String value) {
      addCriterion("upper(PHONE_NO) like", value.toUpperCase(), "phoneNo");
      return (Criteria) this;
    }

    public Criteria andEmailLikeInsensitive(String value) {
      addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
      return (Criteria) this;
    }

    public Criteria andEvaluationLikeInsensitive(String value) {
      addCriterion("upper(EVALUATION) like", value.toUpperCase(), "evaluation");
      return (Criteria) this;
    }

    public Criteria andMoraleRiskLikeInsensitive(String value) {
      addCriterion("upper(MORALE_RISK) like", value.toUpperCase(), "moraleRisk");
      return (Criteria) this;
    }

    public Criteria andCompetencyLikeInsensitive(String value) {
      addCriterion("upper(COMPETENCY) like", value.toUpperCase(), "competency");
      return (Criteria) this;
    }

    public Criteria andResultFirstLikeInsensitive(String value) {
      addCriterion("upper(RESULT_FIRST) like", value.toUpperCase(), "resultFirst");
      return (Criteria) this;
    }

    public Criteria andResultSecondLikeInsensitive(String value) {
      addCriterion("upper(RESULT_SECOND) like", value.toUpperCase(), "resultSecond");
      return (Criteria) this;
    }

    public Criteria andOfferLikeInsensitive(String value) {
      addCriterion("upper(OFFER) like", value.toUpperCase(), "offer");
      return (Criteria) this;
    }

    public Criteria andTrilateralLikeInsensitive(String value) {
      addCriterion("upper(TRILATERAL) like", value.toUpperCase(), "trilateral");
      return (Criteria) this;
    }

    public Criteria andTranscriptLikeInsensitive(String value) {
      addCriterion("upper(TRANSCRIPT) like", value.toUpperCase(), "transcript");
      return (Criteria) this;
    }

    public Criteria andReferenceFormLikeInsensitive(String value) {
      addCriterion("upper(REFERENCE_FORM) like", value.toUpperCase(), "referenceForm");
      return (Criteria) this;
    }

    public Criteria andIdcardCopyLikeInsensitive(String value) {
      addCriterion("upper(IDCARD_COPY) like", value.toUpperCase(), "idcardCopy");
      return (Criteria) this;
    }

    public Criteria andCetTranscriptLikeInsensitive(String value) {
      addCriterion("upper(CET_TRANSCRIPT) like", value.toUpperCase(), "cetTranscript");
      return (Criteria) this;
    }

    public Criteria andPhotoLikeInsensitive(String value) {
      addCriterion("upper(PHOTO) like", value.toUpperCase(), "photo");
      return (Criteria) this;
    }

    public Criteria andBreakOffReasonLikeInsensitive(String value) {
      addCriterion("upper(BREAK_OFF) like", value.toUpperCase(), "breakOff");
      return (Criteria) this;
    }

    public Criteria andYearthLikeInsensitive(String value) {
      addCriterion("upper(YEARTH) like", value.toUpperCase(), "yearth");
      return (Criteria) this;
    }

    public Criteria andCreateUserLikeInsensitive(String value) {
      addCriterion("upper(CREATE_USER) like", value.toUpperCase(), "createUser");
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
