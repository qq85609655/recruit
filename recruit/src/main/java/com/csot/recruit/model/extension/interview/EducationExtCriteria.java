package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class EducationExtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EducationExtCriteria() {
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

        public Criteria andEducationStratdate1IsNull() {
            addCriterion("EDUCATION_STRATDATE_1 is null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1IsNotNull() {
            addCriterion("EDUCATION_STRATDATE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1EqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_1 =", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1NotEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_1 <>", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1GreaterThan(String value) {
            addCriterion("EDUCATION_STRATDATE_1 >", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_1 >=", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1LessThan(String value) {
            addCriterion("EDUCATION_STRATDATE_1 <", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_1 <=", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1Like(String value) {
            addCriterion("EDUCATION_STRATDATE_1 like", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1NotLike(String value) {
            addCriterion("EDUCATION_STRATDATE_1 not like", value, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1In(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_1 in", values, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1NotIn(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_1 not in", values, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1Between(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_1 between", value1, value2, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_1 not between", value1, value2, "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1IsNull() {
            addCriterion("EDUCATION_ENDDATE_1 is null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1IsNotNull() {
            addCriterion("EDUCATION_ENDDATE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1EqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_1 =", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1NotEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_1 <>", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1GreaterThan(String value) {
            addCriterion("EDUCATION_ENDDATE_1 >", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_1 >=", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1LessThan(String value) {
            addCriterion("EDUCATION_ENDDATE_1 <", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_1 <=", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1Like(String value) {
            addCriterion("EDUCATION_ENDDATE_1 like", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1NotLike(String value) {
            addCriterion("EDUCATION_ENDDATE_1 not like", value, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1In(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_1 in", values, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1NotIn(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_1 not in", values, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1Between(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_1 between", value1, value2, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_1 not between", value1, value2, "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1IsNull() {
            addCriterion("EDUCATION_SCHOOL_1 is null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1IsNotNull() {
            addCriterion("EDUCATION_SCHOOL_1 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1EqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_1 =", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1NotEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_1 <>", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1GreaterThan(String value) {
            addCriterion("EDUCATION_SCHOOL_1 >", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_1 >=", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1LessThan(String value) {
            addCriterion("EDUCATION_SCHOOL_1 <", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_1 <=", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1Like(String value) {
            addCriterion("EDUCATION_SCHOOL_1 like", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1NotLike(String value) {
            addCriterion("EDUCATION_SCHOOL_1 not like", value, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1In(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_1 in", values, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1NotIn(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_1 not in", values, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1Between(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_1 between", value1, value2, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_1 not between", value1, value2, "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andMajor1IsNull() {
            addCriterion("MAJOR_1 is null");
            return (Criteria) this;
        }

        public Criteria andMajor1IsNotNull() {
            addCriterion("MAJOR_1 is not null");
            return (Criteria) this;
        }

        public Criteria andMajor1EqualTo(String value) {
            addCriterion("MAJOR_1 =", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1NotEqualTo(String value) {
            addCriterion("MAJOR_1 <>", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1GreaterThan(String value) {
            addCriterion("MAJOR_1 >", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1GreaterThanOrEqualTo(String value) {
            addCriterion("MAJOR_1 >=", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1LessThan(String value) {
            addCriterion("MAJOR_1 <", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1LessThanOrEqualTo(String value) {
            addCriterion("MAJOR_1 <=", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1Like(String value) {
            addCriterion("MAJOR_1 like", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1NotLike(String value) {
            addCriterion("MAJOR_1 not like", value, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1In(List<String> values) {
            addCriterion("MAJOR_1 in", values, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1NotIn(List<String> values) {
            addCriterion("MAJOR_1 not in", values, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1Between(String value1, String value2) {
            addCriterion("MAJOR_1 between", value1, value2, "major1");
            return (Criteria) this;
        }

        public Criteria andMajor1NotBetween(String value1, String value2) {
            addCriterion("MAJOR_1 not between", value1, value2, "major1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2IsNull() {
            addCriterion("EDUCATION_STRATDATE_2 is null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2IsNotNull() {
            addCriterion("EDUCATION_STRATDATE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2EqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_2 =", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2NotEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_2 <>", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2GreaterThan(String value) {
            addCriterion("EDUCATION_STRATDATE_2 >", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_2 >=", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2LessThan(String value) {
            addCriterion("EDUCATION_STRATDATE_2 <", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_2 <=", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2Like(String value) {
            addCriterion("EDUCATION_STRATDATE_2 like", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2NotLike(String value) {
            addCriterion("EDUCATION_STRATDATE_2 not like", value, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2In(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_2 in", values, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2NotIn(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_2 not in", values, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2Between(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_2 between", value1, value2, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_2 not between", value1, value2, "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2IsNull() {
            addCriterion("EDUCATION_ENDDATE_2 is null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2IsNotNull() {
            addCriterion("EDUCATION_ENDDATE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2EqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_2 =", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2NotEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_2 <>", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2GreaterThan(String value) {
            addCriterion("EDUCATION_ENDDATE_2 >", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_2 >=", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2LessThan(String value) {
            addCriterion("EDUCATION_ENDDATE_2 <", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_2 <=", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2Like(String value) {
            addCriterion("EDUCATION_ENDDATE_2 like", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2NotLike(String value) {
            addCriterion("EDUCATION_ENDDATE_2 not like", value, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2In(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_2 in", values, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2NotIn(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_2 not in", values, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2Between(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_2 between", value1, value2, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_2 not between", value1, value2, "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2IsNull() {
            addCriterion("EDUCATION_SCHOOL_2 is null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2IsNotNull() {
            addCriterion("EDUCATION_SCHOOL_2 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2EqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_2 =", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2NotEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_2 <>", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2GreaterThan(String value) {
            addCriterion("EDUCATION_SCHOOL_2 >", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_2 >=", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2LessThan(String value) {
            addCriterion("EDUCATION_SCHOOL_2 <", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_2 <=", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2Like(String value) {
            addCriterion("EDUCATION_SCHOOL_2 like", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2NotLike(String value) {
            addCriterion("EDUCATION_SCHOOL_2 not like", value, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2In(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_2 in", values, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2NotIn(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_2 not in", values, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2Between(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_2 between", value1, value2, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_2 not between", value1, value2, "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andMajor2IsNull() {
            addCriterion("MAJOR_2 is null");
            return (Criteria) this;
        }

        public Criteria andMajor2IsNotNull() {
            addCriterion("MAJOR_2 is not null");
            return (Criteria) this;
        }

        public Criteria andMajor2EqualTo(String value) {
            addCriterion("MAJOR_2 =", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2NotEqualTo(String value) {
            addCriterion("MAJOR_2 <>", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2GreaterThan(String value) {
            addCriterion("MAJOR_2 >", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2GreaterThanOrEqualTo(String value) {
            addCriterion("MAJOR_2 >=", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2LessThan(String value) {
            addCriterion("MAJOR_2 <", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2LessThanOrEqualTo(String value) {
            addCriterion("MAJOR_2 <=", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2Like(String value) {
            addCriterion("MAJOR_2 like", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2NotLike(String value) {
            addCriterion("MAJOR_2 not like", value, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2In(List<String> values) {
            addCriterion("MAJOR_2 in", values, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2NotIn(List<String> values) {
            addCriterion("MAJOR_2 not in", values, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2Between(String value1, String value2) {
            addCriterion("MAJOR_2 between", value1, value2, "major2");
            return (Criteria) this;
        }

        public Criteria andMajor2NotBetween(String value1, String value2) {
            addCriterion("MAJOR_2 not between", value1, value2, "major2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3IsNull() {
            addCriterion("EDUCATION_STRATDATE_3 is null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3IsNotNull() {
            addCriterion("EDUCATION_STRATDATE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3EqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_3 =", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3NotEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_3 <>", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3GreaterThan(String value) {
            addCriterion("EDUCATION_STRATDATE_3 >", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_3 >=", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3LessThan(String value) {
            addCriterion("EDUCATION_STRATDATE_3 <", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_3 <=", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3Like(String value) {
            addCriterion("EDUCATION_STRATDATE_3 like", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3NotLike(String value) {
            addCriterion("EDUCATION_STRATDATE_3 not like", value, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3In(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_3 in", values, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3NotIn(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_3 not in", values, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3Between(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_3 between", value1, value2, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_3 not between", value1, value2, "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3IsNull() {
            addCriterion("EDUCATION_ENDDATE_3 is null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3IsNotNull() {
            addCriterion("EDUCATION_ENDDATE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3EqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_3 =", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3NotEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_3 <>", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3GreaterThan(String value) {
            addCriterion("EDUCATION_ENDDATE_3 >", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_3 >=", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3LessThan(String value) {
            addCriterion("EDUCATION_ENDDATE_3 <", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_3 <=", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3Like(String value) {
            addCriterion("EDUCATION_ENDDATE_3 like", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3NotLike(String value) {
            addCriterion("EDUCATION_ENDDATE_3 not like", value, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3In(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_3 in", values, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3NotIn(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_3 not in", values, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3Between(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_3 between", value1, value2, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_3 not between", value1, value2, "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3IsNull() {
            addCriterion("EDUCATION_SCHOOL_3 is null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3IsNotNull() {
            addCriterion("EDUCATION_SCHOOL_3 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3EqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_3 =", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3NotEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_3 <>", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3GreaterThan(String value) {
            addCriterion("EDUCATION_SCHOOL_3 >", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_3 >=", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3LessThan(String value) {
            addCriterion("EDUCATION_SCHOOL_3 <", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_3 <=", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3Like(String value) {
            addCriterion("EDUCATION_SCHOOL_3 like", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3NotLike(String value) {
            addCriterion("EDUCATION_SCHOOL_3 not like", value, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3In(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_3 in", values, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3NotIn(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_3 not in", values, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3Between(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_3 between", value1, value2, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_3 not between", value1, value2, "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andMajor3IsNull() {
            addCriterion("MAJOR_3 is null");
            return (Criteria) this;
        }

        public Criteria andMajor3IsNotNull() {
            addCriterion("MAJOR_3 is not null");
            return (Criteria) this;
        }

        public Criteria andMajor3EqualTo(String value) {
            addCriterion("MAJOR_3 =", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3NotEqualTo(String value) {
            addCriterion("MAJOR_3 <>", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3GreaterThan(String value) {
            addCriterion("MAJOR_3 >", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3GreaterThanOrEqualTo(String value) {
            addCriterion("MAJOR_3 >=", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3LessThan(String value) {
            addCriterion("MAJOR_3 <", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3LessThanOrEqualTo(String value) {
            addCriterion("MAJOR_3 <=", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3Like(String value) {
            addCriterion("MAJOR_3 like", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3NotLike(String value) {
            addCriterion("MAJOR_3 not like", value, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3In(List<String> values) {
            addCriterion("MAJOR_3 in", values, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3NotIn(List<String> values) {
            addCriterion("MAJOR_3 not in", values, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3Between(String value1, String value2) {
            addCriterion("MAJOR_3 between", value1, value2, "major3");
            return (Criteria) this;
        }

        public Criteria andMajor3NotBetween(String value1, String value2) {
            addCriterion("MAJOR_3 not between", value1, value2, "major3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4IsNull() {
            addCriterion("EDUCATION_STRATDATE_4 is null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4IsNotNull() {
            addCriterion("EDUCATION_STRATDATE_4 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4EqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_4 =", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4NotEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_4 <>", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4GreaterThan(String value) {
            addCriterion("EDUCATION_STRATDATE_4 >", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_4 >=", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4LessThan(String value) {
            addCriterion("EDUCATION_STRATDATE_4 <", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_STRATDATE_4 <=", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4Like(String value) {
            addCriterion("EDUCATION_STRATDATE_4 like", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4NotLike(String value) {
            addCriterion("EDUCATION_STRATDATE_4 not like", value, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4In(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_4 in", values, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4NotIn(List<String> values) {
            addCriterion("EDUCATION_STRATDATE_4 not in", values, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4Between(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_4 between", value1, value2, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_STRATDATE_4 not between", value1, value2, "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4IsNull() {
            addCriterion("EDUCATION_ENDDATE_4 is null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4IsNotNull() {
            addCriterion("EDUCATION_ENDDATE_4 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4EqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_4 =", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4NotEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_4 <>", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4GreaterThan(String value) {
            addCriterion("EDUCATION_ENDDATE_4 >", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_4 >=", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4LessThan(String value) {
            addCriterion("EDUCATION_ENDDATE_4 <", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_ENDDATE_4 <=", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4Like(String value) {
            addCriterion("EDUCATION_ENDDATE_4 like", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4NotLike(String value) {
            addCriterion("EDUCATION_ENDDATE_4 not like", value, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4In(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_4 in", values, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4NotIn(List<String> values) {
            addCriterion("EDUCATION_ENDDATE_4 not in", values, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4Between(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_4 between", value1, value2, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_ENDDATE_4 not between", value1, value2, "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4IsNull() {
            addCriterion("EDUCATION_SCHOOL_4 is null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4IsNotNull() {
            addCriterion("EDUCATION_SCHOOL_4 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4EqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_4 =", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4NotEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_4 <>", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4GreaterThan(String value) {
            addCriterion("EDUCATION_SCHOOL_4 >", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_4 >=", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4LessThan(String value) {
            addCriterion("EDUCATION_SCHOOL_4 <", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4LessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_SCHOOL_4 <=", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4Like(String value) {
            addCriterion("EDUCATION_SCHOOL_4 like", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4NotLike(String value) {
            addCriterion("EDUCATION_SCHOOL_4 not like", value, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4In(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_4 in", values, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4NotIn(List<String> values) {
            addCriterion("EDUCATION_SCHOOL_4 not in", values, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4Between(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_4 between", value1, value2, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4NotBetween(String value1, String value2) {
            addCriterion("EDUCATION_SCHOOL_4 not between", value1, value2, "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andMajor4IsNull() {
            addCriterion("MAJOR_4 is null");
            return (Criteria) this;
        }

        public Criteria andMajor4IsNotNull() {
            addCriterion("MAJOR_4 is not null");
            return (Criteria) this;
        }

        public Criteria andMajor4EqualTo(String value) {
            addCriterion("MAJOR_4 =", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4NotEqualTo(String value) {
            addCriterion("MAJOR_4 <>", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4GreaterThan(String value) {
            addCriterion("MAJOR_4 >", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4GreaterThanOrEqualTo(String value) {
            addCriterion("MAJOR_4 >=", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4LessThan(String value) {
            addCriterion("MAJOR_4 <", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4LessThanOrEqualTo(String value) {
            addCriterion("MAJOR_4 <=", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4Like(String value) {
            addCriterion("MAJOR_4 like", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4NotLike(String value) {
            addCriterion("MAJOR_4 not like", value, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4In(List<String> values) {
            addCriterion("MAJOR_4 in", values, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4NotIn(List<String> values) {
            addCriterion("MAJOR_4 not in", values, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4Between(String value1, String value2) {
            addCriterion("MAJOR_4 between", value1, value2, "major4");
            return (Criteria) this;
        }

        public Criteria andMajor4NotBetween(String value1, String value2) {
            addCriterion("MAJOR_4 not between", value1, value2, "major4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1IsNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_1 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1IsNotNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_1 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1EqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 =", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 <>", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1GreaterThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 >", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 >=", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1LessThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 <", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 <=", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1Like(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 like", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1NotLike(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 not like", value, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1In(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 in", values, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 not in", values, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 between", value1, value2, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_1 not between", value1, value2, "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1IsNull() {
            addCriterion("EDUCATIONAL_TYPE_1 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalType1IsNotNull() {
            addCriterion("EDUCATIONAL_TYPE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalType1EqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 =", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 <>", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1GreaterThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 >", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 >=", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1LessThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 <", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 <=", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1Like(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 like", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1NotLike(String value) {
            addCriterion("EDUCATIONAL_TYPE_1 not like", value, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1In(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_1 in", values, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_1 not in", values, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_1 between", value1, value2, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_1 not between", value1, value2, "educationalType1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1IsNull() {
            addCriterion("GET_CERTIFICATE_1 is null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1IsNotNull() {
            addCriterion("GET_CERTIFICATE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1EqualTo(String value) {
            addCriterion("GET_CERTIFICATE_1 =", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1NotEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_1 <>", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1GreaterThan(String value) {
            addCriterion("GET_CERTIFICATE_1 >", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1GreaterThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_1 >=", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1LessThan(String value) {
            addCriterion("GET_CERTIFICATE_1 <", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1LessThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_1 <=", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1Like(String value) {
            addCriterion("GET_CERTIFICATE_1 like", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1NotLike(String value) {
            addCriterion("GET_CERTIFICATE_1 not like", value, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1In(List<String> values) {
            addCriterion("GET_CERTIFICATE_1 in", values, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1NotIn(List<String> values) {
            addCriterion("GET_CERTIFICATE_1 not in", values, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1Between(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_1 between", value1, value2, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1NotBetween(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_1 not between", value1, value2, "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2IsNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_2 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2IsNotNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_2 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2EqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 =", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 <>", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2GreaterThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 >", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 >=", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2LessThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 <", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 <=", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2Like(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 like", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2NotLike(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 not like", value, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2In(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 in", values, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 not in", values, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 between", value1, value2, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_2 not between", value1, value2, "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2IsNull() {
            addCriterion("EDUCATIONAL_TYPE_2 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalType2IsNotNull() {
            addCriterion("EDUCATIONAL_TYPE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalType2EqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 =", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 <>", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2GreaterThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 >", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 >=", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2LessThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 <", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 <=", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2Like(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 like", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2NotLike(String value) {
            addCriterion("EDUCATIONAL_TYPE_2 not like", value, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2In(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_2 in", values, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_2 not in", values, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_2 between", value1, value2, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_2 not between", value1, value2, "educationalType2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2IsNull() {
            addCriterion("GET_CERTIFICATE_2 is null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2IsNotNull() {
            addCriterion("GET_CERTIFICATE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2EqualTo(String value) {
            addCriterion("GET_CERTIFICATE_2 =", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2NotEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_2 <>", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2GreaterThan(String value) {
            addCriterion("GET_CERTIFICATE_2 >", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2GreaterThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_2 >=", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2LessThan(String value) {
            addCriterion("GET_CERTIFICATE_2 <", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2LessThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_2 <=", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2Like(String value) {
            addCriterion("GET_CERTIFICATE_2 like", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2NotLike(String value) {
            addCriterion("GET_CERTIFICATE_2 not like", value, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2In(List<String> values) {
            addCriterion("GET_CERTIFICATE_2 in", values, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2NotIn(List<String> values) {
            addCriterion("GET_CERTIFICATE_2 not in", values, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2Between(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_2 between", value1, value2, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2NotBetween(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_2 not between", value1, value2, "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3IsNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_3 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3IsNotNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_3 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3EqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 =", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 <>", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3GreaterThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 >", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 >=", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3LessThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 <", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 <=", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3Like(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 like", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3NotLike(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 not like", value, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3In(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 in", values, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 not in", values, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 between", value1, value2, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_3 not between", value1, value2, "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3IsNull() {
            addCriterion("EDUCATIONAL_TYPE_3 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalType3IsNotNull() {
            addCriterion("EDUCATIONAL_TYPE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalType3EqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 =", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 <>", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3GreaterThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 >", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 >=", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3LessThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 <", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 <=", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3Like(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 like", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3NotLike(String value) {
            addCriterion("EDUCATIONAL_TYPE_3 not like", value, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3In(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_3 in", values, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_3 not in", values, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_3 between", value1, value2, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_3 not between", value1, value2, "educationalType3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3IsNull() {
            addCriterion("GET_CERTIFICATE_3 is null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3IsNotNull() {
            addCriterion("GET_CERTIFICATE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3EqualTo(String value) {
            addCriterion("GET_CERTIFICATE_3 =", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3NotEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_3 <>", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3GreaterThan(String value) {
            addCriterion("GET_CERTIFICATE_3 >", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3GreaterThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_3 >=", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3LessThan(String value) {
            addCriterion("GET_CERTIFICATE_3 <", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3LessThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_3 <=", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3Like(String value) {
            addCriterion("GET_CERTIFICATE_3 like", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3NotLike(String value) {
            addCriterion("GET_CERTIFICATE_3 not like", value, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3In(List<String> values) {
            addCriterion("GET_CERTIFICATE_3 in", values, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3NotIn(List<String> values) {
            addCriterion("GET_CERTIFICATE_3 not in", values, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3Between(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_3 between", value1, value2, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3NotBetween(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_3 not between", value1, value2, "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4IsNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_4 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4IsNotNull() {
            addCriterion("EDUCATIONAL_BACKGROUND_4 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4EqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 =", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 <>", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4GreaterThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 >", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 >=", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4LessThan(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 <", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 <=", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4Like(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 like", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4NotLike(String value) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 not like", value, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4In(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 in", values, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 not in", values, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 between", value1, value2, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_BACKGROUND_4 not between", value1, value2, "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4IsNull() {
            addCriterion("EDUCATIONAL_TYPE_4 is null");
            return (Criteria) this;
        }

        public Criteria andEducationalType4IsNotNull() {
            addCriterion("EDUCATIONAL_TYPE_4 is not null");
            return (Criteria) this;
        }

        public Criteria andEducationalType4EqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 =", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4NotEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 <>", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4GreaterThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 >", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4GreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 >=", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4LessThan(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 <", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4LessThanOrEqualTo(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 <=", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4Like(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 like", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4NotLike(String value) {
            addCriterion("EDUCATIONAL_TYPE_4 not like", value, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4In(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_4 in", values, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4NotIn(List<String> values) {
            addCriterion("EDUCATIONAL_TYPE_4 not in", values, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4Between(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_4 between", value1, value2, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4NotBetween(String value1, String value2) {
            addCriterion("EDUCATIONAL_TYPE_4 not between", value1, value2, "educationalType4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4IsNull() {
            addCriterion("GET_CERTIFICATE_4 is null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4IsNotNull() {
            addCriterion("GET_CERTIFICATE_4 is not null");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4EqualTo(String value) {
            addCriterion("GET_CERTIFICATE_4 =", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4NotEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_4 <>", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4GreaterThan(String value) {
            addCriterion("GET_CERTIFICATE_4 >", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4GreaterThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_4 >=", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4LessThan(String value) {
            addCriterion("GET_CERTIFICATE_4 <", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4LessThanOrEqualTo(String value) {
            addCriterion("GET_CERTIFICATE_4 <=", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4Like(String value) {
            addCriterion("GET_CERTIFICATE_4 like", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4NotLike(String value) {
            addCriterion("GET_CERTIFICATE_4 not like", value, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4In(List<String> values) {
            addCriterion("GET_CERTIFICATE_4 in", values, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4NotIn(List<String> values) {
            addCriterion("GET_CERTIFICATE_4 not in", values, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4Between(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_4 between", value1, value2, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4NotBetween(String value1, String value2) {
            addCriterion("GET_CERTIFICATE_4 not between", value1, value2, "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1IsNull() {
            addCriterion("DIPLOMA_TYPE_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1IsNotNull() {
            addCriterion("DIPLOMA_TYPE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1EqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_1 =", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1NotEqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_1 <>", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1GreaterThan(String value) {
            addCriterion("DIPLOMA_TYPE_1 >", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_1 >=", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1LessThan(String value) {
            addCriterion("DIPLOMA_TYPE_1 <", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_1 <=", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1Like(String value) {
            addCriterion("DIPLOMA_TYPE_1 like", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1NotLike(String value) {
            addCriterion("DIPLOMA_TYPE_1 not like", value, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1In(List<String> values) {
            addCriterion("DIPLOMA_TYPE_1 in", values, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1NotIn(List<String> values) {
            addCriterion("DIPLOMA_TYPE_1 not in", values, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1Between(String value1, String value2) {
            addCriterion("DIPLOMA_TYPE_1 between", value1, value2, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_TYPE_1 not between", value1, value2, "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1IsNull() {
            addCriterion("DIPLOMA_NAME_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1IsNotNull() {
            addCriterion("DIPLOMA_NAME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1EqualTo(String value) {
            addCriterion("DIPLOMA_NAME_1 =", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1NotEqualTo(String value) {
            addCriterion("DIPLOMA_NAME_1 <>", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1GreaterThan(String value) {
            addCriterion("DIPLOMA_NAME_1 >", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NAME_1 >=", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1LessThan(String value) {
            addCriterion("DIPLOMA_NAME_1 <", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NAME_1 <=", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1Like(String value) {
            addCriterion("DIPLOMA_NAME_1 like", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1NotLike(String value) {
            addCriterion("DIPLOMA_NAME_1 not like", value, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1In(List<String> values) {
            addCriterion("DIPLOMA_NAME_1 in", values, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1NotIn(List<String> values) {
            addCriterion("DIPLOMA_NAME_1 not in", values, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1Between(String value1, String value2) {
            addCriterion("DIPLOMA_NAME_1 between", value1, value2, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_NAME_1 not between", value1, value2, "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1IsNull() {
            addCriterion("DIPLOMA_DATE_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1IsNotNull() {
            addCriterion("DIPLOMA_DATE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1EqualTo(String value) {
            addCriterion("DIPLOMA_DATE_1 =", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1NotEqualTo(String value) {
            addCriterion("DIPLOMA_DATE_1 <>", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1GreaterThan(String value) {
            addCriterion("DIPLOMA_DATE_1 >", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_DATE_1 >=", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1LessThan(String value) {
            addCriterion("DIPLOMA_DATE_1 <", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_DATE_1 <=", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1Like(String value) {
            addCriterion("DIPLOMA_DATE_1 like", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1NotLike(String value) {
            addCriterion("DIPLOMA_DATE_1 not like", value, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1In(List<String> values) {
            addCriterion("DIPLOMA_DATE_1 in", values, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1NotIn(List<String> values) {
            addCriterion("DIPLOMA_DATE_1 not in", values, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1Between(String value1, String value2) {
            addCriterion("DIPLOMA_DATE_1 between", value1, value2, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_DATE_1 not between", value1, value2, "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1IsNull() {
            addCriterion("DIPLOMA_NUM_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1IsNotNull() {
            addCriterion("DIPLOMA_NUM_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1EqualTo(String value) {
            addCriterion("DIPLOMA_NUM_1 =", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1NotEqualTo(String value) {
            addCriterion("DIPLOMA_NUM_1 <>", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1GreaterThan(String value) {
            addCriterion("DIPLOMA_NUM_1 >", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NUM_1 >=", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1LessThan(String value) {
            addCriterion("DIPLOMA_NUM_1 <", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NUM_1 <=", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1Like(String value) {
            addCriterion("DIPLOMA_NUM_1 like", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1NotLike(String value) {
            addCriterion("DIPLOMA_NUM_1 not like", value, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1In(List<String> values) {
            addCriterion("DIPLOMA_NUM_1 in", values, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1NotIn(List<String> values) {
            addCriterion("DIPLOMA_NUM_1 not in", values, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1Between(String value1, String value2) {
            addCriterion("DIPLOMA_NUM_1 between", value1, value2, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_NUM_1 not between", value1, value2, "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1IsNull() {
            addCriterion("DIPLOMA_ORGAN_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1IsNotNull() {
            addCriterion("DIPLOMA_ORGAN_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1EqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_1 =", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1NotEqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_1 <>", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1GreaterThan(String value) {
            addCriterion("DIPLOMA_ORGAN_1 >", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_1 >=", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1LessThan(String value) {
            addCriterion("DIPLOMA_ORGAN_1 <", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_1 <=", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1Like(String value) {
            addCriterion("DIPLOMA_ORGAN_1 like", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1NotLike(String value) {
            addCriterion("DIPLOMA_ORGAN_1 not like", value, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1In(List<String> values) {
            addCriterion("DIPLOMA_ORGAN_1 in", values, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1NotIn(List<String> values) {
            addCriterion("DIPLOMA_ORGAN_1 not in", values, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1Between(String value1, String value2) {
            addCriterion("DIPLOMA_ORGAN_1 between", value1, value2, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_ORGAN_1 not between", value1, value2, "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2IsNull() {
            addCriterion("DIPLOMA_TYPE_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2IsNotNull() {
            addCriterion("DIPLOMA_TYPE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2EqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_2 =", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2NotEqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_2 <>", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2GreaterThan(String value) {
            addCriterion("DIPLOMA_TYPE_2 >", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_2 >=", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2LessThan(String value) {
            addCriterion("DIPLOMA_TYPE_2 <", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_TYPE_2 <=", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2Like(String value) {
            addCriterion("DIPLOMA_TYPE_2 like", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2NotLike(String value) {
            addCriterion("DIPLOMA_TYPE_2 not like", value, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2In(List<String> values) {
            addCriterion("DIPLOMA_TYPE_2 in", values, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2NotIn(List<String> values) {
            addCriterion("DIPLOMA_TYPE_2 not in", values, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2Between(String value1, String value2) {
            addCriterion("DIPLOMA_TYPE_2 between", value1, value2, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_TYPE_2 not between", value1, value2, "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2IsNull() {
            addCriterion("DIPLOMA_NAME_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2IsNotNull() {
            addCriterion("DIPLOMA_NAME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2EqualTo(String value) {
            addCriterion("DIPLOMA_NAME_2 =", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2NotEqualTo(String value) {
            addCriterion("DIPLOMA_NAME_2 <>", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2GreaterThan(String value) {
            addCriterion("DIPLOMA_NAME_2 >", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NAME_2 >=", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2LessThan(String value) {
            addCriterion("DIPLOMA_NAME_2 <", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NAME_2 <=", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2Like(String value) {
            addCriterion("DIPLOMA_NAME_2 like", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2NotLike(String value) {
            addCriterion("DIPLOMA_NAME_2 not like", value, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2In(List<String> values) {
            addCriterion("DIPLOMA_NAME_2 in", values, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2NotIn(List<String> values) {
            addCriterion("DIPLOMA_NAME_2 not in", values, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2Between(String value1, String value2) {
            addCriterion("DIPLOMA_NAME_2 between", value1, value2, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_NAME_2 not between", value1, value2, "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2IsNull() {
            addCriterion("DIPLOMA_DATE_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2IsNotNull() {
            addCriterion("DIPLOMA_DATE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2EqualTo(String value) {
            addCriterion("DIPLOMA_DATE_2 =", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2NotEqualTo(String value) {
            addCriterion("DIPLOMA_DATE_2 <>", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2GreaterThan(String value) {
            addCriterion("DIPLOMA_DATE_2 >", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_DATE_2 >=", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2LessThan(String value) {
            addCriterion("DIPLOMA_DATE_2 <", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_DATE_2 <=", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2Like(String value) {
            addCriterion("DIPLOMA_DATE_2 like", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2NotLike(String value) {
            addCriterion("DIPLOMA_DATE_2 not like", value, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2In(List<String> values) {
            addCriterion("DIPLOMA_DATE_2 in", values, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2NotIn(List<String> values) {
            addCriterion("DIPLOMA_DATE_2 not in", values, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2Between(String value1, String value2) {
            addCriterion("DIPLOMA_DATE_2 between", value1, value2, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_DATE_2 not between", value1, value2, "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2IsNull() {
            addCriterion("DIPLOMA_NUM_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2IsNotNull() {
            addCriterion("DIPLOMA_NUM_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2EqualTo(String value) {
            addCriterion("DIPLOMA_NUM_2 =", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2NotEqualTo(String value) {
            addCriterion("DIPLOMA_NUM_2 <>", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2GreaterThan(String value) {
            addCriterion("DIPLOMA_NUM_2 >", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NUM_2 >=", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2LessThan(String value) {
            addCriterion("DIPLOMA_NUM_2 <", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_NUM_2 <=", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2Like(String value) {
            addCriterion("DIPLOMA_NUM_2 like", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2NotLike(String value) {
            addCriterion("DIPLOMA_NUM_2 not like", value, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2In(List<String> values) {
            addCriterion("DIPLOMA_NUM_2 in", values, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2NotIn(List<String> values) {
            addCriterion("DIPLOMA_NUM_2 not in", values, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2Between(String value1, String value2) {
            addCriterion("DIPLOMA_NUM_2 between", value1, value2, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_NUM_2 not between", value1, value2, "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2IsNull() {
            addCriterion("DIPLOMA_ORGAN_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2IsNotNull() {
            addCriterion("DIPLOMA_ORGAN_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2EqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_2 =", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2NotEqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_2 <>", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2GreaterThan(String value) {
            addCriterion("DIPLOMA_ORGAN_2 >", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2GreaterThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_2 >=", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2LessThan(String value) {
            addCriterion("DIPLOMA_ORGAN_2 <", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2LessThanOrEqualTo(String value) {
            addCriterion("DIPLOMA_ORGAN_2 <=", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2Like(String value) {
            addCriterion("DIPLOMA_ORGAN_2 like", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2NotLike(String value) {
            addCriterion("DIPLOMA_ORGAN_2 not like", value, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2In(List<String> values) {
            addCriterion("DIPLOMA_ORGAN_2 in", values, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2NotIn(List<String> values) {
            addCriterion("DIPLOMA_ORGAN_2 not in", values, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2Between(String value1, String value2) {
            addCriterion("DIPLOMA_ORGAN_2 between", value1, value2, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2NotBetween(String value1, String value2) {
            addCriterion("DIPLOMA_ORGAN_2 not between", value1, value2, "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andPersonCodeIsNull() {
            addCriterion("PERSON_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPersonCodeIsNotNull() {
            addCriterion("PERSON_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPersonCodeEqualTo(String value) {
            addCriterion("PERSON_CODE =", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeNotEqualTo(String value) {
            addCriterion("PERSON_CODE <>", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeGreaterThan(String value) {
            addCriterion("PERSON_CODE >", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PERSON_CODE >=", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeLessThan(String value) {
            addCriterion("PERSON_CODE <", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeLessThanOrEqualTo(String value) {
            addCriterion("PERSON_CODE <=", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeLike(String value) {
            addCriterion("PERSON_CODE like", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeNotLike(String value) {
            addCriterion("PERSON_CODE not like", value, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeIn(List<String> values) {
            addCriterion("PERSON_CODE in", values, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeNotIn(List<String> values) {
            addCriterion("PERSON_CODE not in", values, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeBetween(String value1, String value2) {
            addCriterion("PERSON_CODE between", value1, value2, "personCode");
            return (Criteria) this;
        }

        public Criteria andPersonCodeNotBetween(String value1, String value2) {
            addCriterion("PERSON_CODE not between", value1, value2, "personCode");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate1LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_STRATDATE_1) like", value.toUpperCase(), "educationStratdate1");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate1LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_ENDDATE_1) like", value.toUpperCase(), "educationEnddate1");
            return (Criteria) this;
        }

        public Criteria andEducationSchool1LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_SCHOOL_1) like", value.toUpperCase(), "educationSchool1");
            return (Criteria) this;
        }

        public Criteria andMajor1LikeInsensitive(String value) {
            addCriterion("upper(MAJOR_1) like", value.toUpperCase(), "major1");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate2LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_STRATDATE_2) like", value.toUpperCase(), "educationStratdate2");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate2LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_ENDDATE_2) like", value.toUpperCase(), "educationEnddate2");
            return (Criteria) this;
        }

        public Criteria andEducationSchool2LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_SCHOOL_2) like", value.toUpperCase(), "educationSchool2");
            return (Criteria) this;
        }

        public Criteria andMajor2LikeInsensitive(String value) {
            addCriterion("upper(MAJOR_2) like", value.toUpperCase(), "major2");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate3LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_STRATDATE_3) like", value.toUpperCase(), "educationStratdate3");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate3LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_ENDDATE_3) like", value.toUpperCase(), "educationEnddate3");
            return (Criteria) this;
        }

        public Criteria andEducationSchool3LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_SCHOOL_3) like", value.toUpperCase(), "educationSchool3");
            return (Criteria) this;
        }

        public Criteria andMajor3LikeInsensitive(String value) {
            addCriterion("upper(MAJOR_3) like", value.toUpperCase(), "major3");
            return (Criteria) this;
        }

        public Criteria andEducationStratdate4LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_STRATDATE_4) like", value.toUpperCase(), "educationStratdate4");
            return (Criteria) this;
        }

        public Criteria andEducationEnddate4LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_ENDDATE_4) like", value.toUpperCase(), "educationEnddate4");
            return (Criteria) this;
        }

        public Criteria andEducationSchool4LikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_SCHOOL_4) like", value.toUpperCase(), "educationSchool4");
            return (Criteria) this;
        }

        public Criteria andMajor4LikeInsensitive(String value) {
            addCriterion("upper(MAJOR_4) like", value.toUpperCase(), "major4");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground1LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_BACKGROUND_1) like", value.toUpperCase(), "educationalBackground1");
            return (Criteria) this;
        }

        public Criteria andEducationalType1LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_TYPE_1) like", value.toUpperCase(), "educationalType1");
            return (Criteria) this;
        }

        public Criteria andGetCertificate1LikeInsensitive(String value) {
            addCriterion("upper(GET_CERTIFICATE_1) like", value.toUpperCase(), "getCertificate1");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground2LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_BACKGROUND_2) like", value.toUpperCase(), "educationalBackground2");
            return (Criteria) this;
        }

        public Criteria andEducationalType2LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_TYPE_2) like", value.toUpperCase(), "educationalType2");
            return (Criteria) this;
        }

        public Criteria andGetCertificate2LikeInsensitive(String value) {
            addCriterion("upper(GET_CERTIFICATE_2) like", value.toUpperCase(), "getCertificate2");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground3LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_BACKGROUND_3) like", value.toUpperCase(), "educationalBackground3");
            return (Criteria) this;
        }

        public Criteria andEducationalType3LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_TYPE_3) like", value.toUpperCase(), "educationalType3");
            return (Criteria) this;
        }

        public Criteria andGetCertificate3LikeInsensitive(String value) {
            addCriterion("upper(GET_CERTIFICATE_3) like", value.toUpperCase(), "getCertificate3");
            return (Criteria) this;
        }

        public Criteria andEducationalBackground4LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_BACKGROUND_4) like", value.toUpperCase(), "educationalBackground4");
            return (Criteria) this;
        }

        public Criteria andEducationalType4LikeInsensitive(String value) {
            addCriterion("upper(EDUCATIONAL_TYPE_4) like", value.toUpperCase(), "educationalType4");
            return (Criteria) this;
        }

        public Criteria andGetCertificate4LikeInsensitive(String value) {
            addCriterion("upper(GET_CERTIFICATE_4) like", value.toUpperCase(), "getCertificate4");
            return (Criteria) this;
        }

        public Criteria andDiplomaType1LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_TYPE_1) like", value.toUpperCase(), "diplomaType1");
            return (Criteria) this;
        }

        public Criteria andDiplomaName1LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_NAME_1) like", value.toUpperCase(), "diplomaName1");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate1LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_DATE_1) like", value.toUpperCase(), "diplomaDate1");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum1LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_NUM_1) like", value.toUpperCase(), "diplomaNum1");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan1LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_ORGAN_1) like", value.toUpperCase(), "diplomaOrgan1");
            return (Criteria) this;
        }

        public Criteria andDiplomaType2LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_TYPE_2) like", value.toUpperCase(), "diplomaType2");
            return (Criteria) this;
        }

        public Criteria andDiplomaName2LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_NAME_2) like", value.toUpperCase(), "diplomaName2");
            return (Criteria) this;
        }

        public Criteria andDiplomaDate2LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_DATE_2) like", value.toUpperCase(), "diplomaDate2");
            return (Criteria) this;
        }

        public Criteria andDiplomaNum2LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_NUM_2) like", value.toUpperCase(), "diplomaNum2");
            return (Criteria) this;
        }

        public Criteria andDiplomaOrgan2LikeInsensitive(String value) {
            addCriterion("upper(DIPLOMA_ORGAN_2) like", value.toUpperCase(), "diplomaOrgan2");
            return (Criteria) this;
        }

        public Criteria andPersonCodeLikeInsensitive(String value) {
            addCriterion("upper(PERSON_CODE) like", value.toUpperCase(), "personCode");
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