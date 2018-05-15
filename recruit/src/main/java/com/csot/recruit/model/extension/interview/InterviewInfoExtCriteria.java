package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class InterviewInfoExtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public InterviewInfoExtCriteria() {
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

        public Criteria andRecruiterNumberIsNull() {
            addCriterion("RECRUITER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberIsNotNull() {
            addCriterion("RECRUITER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberEqualTo(String value) {
            addCriterion("RECRUITER_NUMBER =", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberNotEqualTo(String value) {
            addCriterion("RECRUITER_NUMBER <>", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberGreaterThan(String value) {
            addCriterion("RECRUITER_NUMBER >", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUITER_NUMBER >=", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberLessThan(String value) {
            addCriterion("RECRUITER_NUMBER <", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberLessThanOrEqualTo(String value) {
            addCriterion("RECRUITER_NUMBER <=", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberLike(String value) {
            addCriterion("RECRUITER_NUMBER like", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberNotLike(String value) {
            addCriterion("RECRUITER_NUMBER not like", value, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberIn(List<String> values) {
            addCriterion("RECRUITER_NUMBER in", values, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberNotIn(List<String> values) {
            addCriterion("RECRUITER_NUMBER not in", values, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberBetween(String value1, String value2) {
            addCriterion("RECRUITER_NUMBER between", value1, value2, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberNotBetween(String value1, String value2) {
            addCriterion("RECRUITER_NUMBER not between", value1, value2, "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNull() {
            addCriterion("NATIONALITY is null");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNotNull() {
            addCriterion("NATIONALITY is not null");
            return (Criteria) this;
        }

        public Criteria andNationalityEqualTo(String value) {
            addCriterion("NATIONALITY =", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotEqualTo(String value) {
            addCriterion("NATIONALITY <>", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThan(String value) {
            addCriterion("NATIONALITY >", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("NATIONALITY >=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThan(String value) {
            addCriterion("NATIONALITY <", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThanOrEqualTo(String value) {
            addCriterion("NATIONALITY <=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLike(String value) {
            addCriterion("NATIONALITY like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotLike(String value) {
            addCriterion("NATIONALITY not like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityIn(List<String> values) {
            addCriterion("NATIONALITY in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotIn(List<String> values) {
            addCriterion("NATIONALITY not in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityBetween(String value1, String value2) {
            addCriterion("NATIONALITY between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotBetween(String value1, String value2) {
            addCriterion("NATIONALITY not between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNull() {
            addCriterion("CNNAME is null");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNotNull() {
            addCriterion("CNNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnnameEqualTo(String value) {
            addCriterion("CNNAME =", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotEqualTo(String value) {
            addCriterion("CNNAME <>", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThan(String value) {
            addCriterion("CNNAME >", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThanOrEqualTo(String value) {
            addCriterion("CNNAME >=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThan(String value) {
            addCriterion("CNNAME <", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThanOrEqualTo(String value) {
            addCriterion("CNNAME <=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLike(String value) {
            addCriterion("CNNAME like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotLike(String value) {
            addCriterion("CNNAME not like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameIn(List<String> values) {
            addCriterion("CNNAME in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotIn(List<String> values) {
            addCriterion("CNNAME not in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameBetween(String value1, String value2) {
            addCriterion("CNNAME between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotBetween(String value1, String value2) {
            addCriterion("CNNAME not between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andEnnameIsNull() {
            addCriterion("ENNAME is null");
            return (Criteria) this;
        }

        public Criteria andEnnameIsNotNull() {
            addCriterion("ENNAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnnameEqualTo(String value) {
            addCriterion("ENNAME =", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotEqualTo(String value) {
            addCriterion("ENNAME <>", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThan(String value) {
            addCriterion("ENNAME >", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThanOrEqualTo(String value) {
            addCriterion("ENNAME >=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThan(String value) {
            addCriterion("ENNAME <", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThanOrEqualTo(String value) {
            addCriterion("ENNAME <=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLike(String value) {
            addCriterion("ENNAME like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotLike(String value) {
            addCriterion("ENNAME not like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameIn(List<String> values) {
            addCriterion("ENNAME in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotIn(List<String> values) {
            addCriterion("ENNAME not in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameBetween(String value1, String value2) {
            addCriterion("ENNAME between", value1, value2, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotBetween(String value1, String value2) {
            addCriterion("ENNAME not between", value1, value2, "enname");
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

        public Criteria andMaritalStatusIsNull() {
            addCriterion("MARITAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("MARITAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(String value) {
            addCriterion("MARITAL_STATUS =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(String value) {
            addCriterion("MARITAL_STATUS <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(String value) {
            addCriterion("MARITAL_STATUS >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MARITAL_STATUS >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(String value) {
            addCriterion("MARITAL_STATUS <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("MARITAL_STATUS <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLike(String value) {
            addCriterion("MARITAL_STATUS like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotLike(String value) {
            addCriterion("MARITAL_STATUS not like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<String> values) {
            addCriterion("MARITAL_STATUS in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<String> values) {
            addCriterion("MARITAL_STATUS not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(String value1, String value2) {
            addCriterion("MARITAL_STATUS between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("MARITAL_STATUS not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andNamepyIsNull() {
            addCriterion("NAMEPY is null");
            return (Criteria) this;
        }

        public Criteria andNamepyIsNotNull() {
            addCriterion("NAMEPY is not null");
            return (Criteria) this;
        }

        public Criteria andNamepyEqualTo(String value) {
            addCriterion("NAMEPY =", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyNotEqualTo(String value) {
            addCriterion("NAMEPY <>", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyGreaterThan(String value) {
            addCriterion("NAMEPY >", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyGreaterThanOrEqualTo(String value) {
            addCriterion("NAMEPY >=", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyLessThan(String value) {
            addCriterion("NAMEPY <", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyLessThanOrEqualTo(String value) {
            addCriterion("NAMEPY <=", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyLike(String value) {
            addCriterion("NAMEPY like", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyNotLike(String value) {
            addCriterion("NAMEPY not like", value, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyIn(List<String> values) {
            addCriterion("NAMEPY in", values, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyNotIn(List<String> values) {
            addCriterion("NAMEPY not in", values, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyBetween(String value1, String value2) {
            addCriterion("NAMEPY between", value1, value2, "namepy");
            return (Criteria) this;
        }

        public Criteria andNamepyNotBetween(String value1, String value2) {
            addCriterion("NAMEPY not between", value1, value2, "namepy");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("NATION is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("NATION is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("NATION =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("NATION <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("NATION >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("NATION >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("NATION <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("NATION <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("NATION like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("NATION not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("NATION in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("NATION not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("NATION between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("NATION not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIsNull() {
            addCriterion("POLITICAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIsNotNull() {
            addCriterion("POLITICAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusEqualTo(String value) {
            addCriterion("POLITICAL_STATUS =", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotEqualTo(String value) {
            addCriterion("POLITICAL_STATUS <>", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusGreaterThan(String value) {
            addCriterion("POLITICAL_STATUS >", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("POLITICAL_STATUS >=", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLessThan(String value) {
            addCriterion("POLITICAL_STATUS <", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLessThanOrEqualTo(String value) {
            addCriterion("POLITICAL_STATUS <=", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLike(String value) {
            addCriterion("POLITICAL_STATUS like", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotLike(String value) {
            addCriterion("POLITICAL_STATUS not like", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIn(List<String> values) {
            addCriterion("POLITICAL_STATUS in", values, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotIn(List<String> values) {
            addCriterion("POLITICAL_STATUS not in", values, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusBetween(String value1, String value2) {
            addCriterion("POLITICAL_STATUS between", value1, value2, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotBetween(String value1, String value2) {
            addCriterion("POLITICAL_STATUS not between", value1, value2, "politicalStatus");
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

        public Criteria andResidencePropertyIsNull() {
            addCriterion("RESIDENCE_PROPERTY is null");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyIsNotNull() {
            addCriterion("RESIDENCE_PROPERTY is not null");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyEqualTo(String value) {
            addCriterion("RESIDENCE_PROPERTY =", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyNotEqualTo(String value) {
            addCriterion("RESIDENCE_PROPERTY <>", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyGreaterThan(String value) {
            addCriterion("RESIDENCE_PROPERTY >", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyGreaterThanOrEqualTo(String value) {
            addCriterion("RESIDENCE_PROPERTY >=", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyLessThan(String value) {
            addCriterion("RESIDENCE_PROPERTY <", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyLessThanOrEqualTo(String value) {
            addCriterion("RESIDENCE_PROPERTY <=", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyLike(String value) {
            addCriterion("RESIDENCE_PROPERTY like", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyNotLike(String value) {
            addCriterion("RESIDENCE_PROPERTY not like", value, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyIn(List<String> values) {
            addCriterion("RESIDENCE_PROPERTY in", values, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyNotIn(List<String> values) {
            addCriterion("RESIDENCE_PROPERTY not in", values, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyBetween(String value1, String value2) {
            addCriterion("RESIDENCE_PROPERTY between", value1, value2, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyNotBetween(String value1, String value2) {
            addCriterion("RESIDENCE_PROPERTY not between", value1, value2, "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNull() {
            addCriterion("RESIDENCE is null");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNotNull() {
            addCriterion("RESIDENCE is not null");
            return (Criteria) this;
        }

        public Criteria andResidenceEqualTo(String value) {
            addCriterion("RESIDENCE =", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotEqualTo(String value) {
            addCriterion("RESIDENCE <>", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThan(String value) {
            addCriterion("RESIDENCE >", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThanOrEqualTo(String value) {
            addCriterion("RESIDENCE >=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThan(String value) {
            addCriterion("RESIDENCE <", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThanOrEqualTo(String value) {
            addCriterion("RESIDENCE <=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLike(String value) {
            addCriterion("RESIDENCE like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotLike(String value) {
            addCriterion("RESIDENCE not like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceIn(List<String> values) {
            addCriterion("RESIDENCE in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotIn(List<String> values) {
            addCriterion("RESIDENCE not in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceBetween(String value1, String value2) {
            addCriterion("RESIDENCE between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotBetween(String value1, String value2) {
            addCriterion("RESIDENCE not between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNull() {
            addCriterion("CERTIFICATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNotNull() {
            addCriterion("CERTIFICATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeEqualTo(String value) {
            addCriterion("CERTIFICATE_TYPE =", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotEqualTo(String value) {
            addCriterion("CERTIFICATE_TYPE <>", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThan(String value) {
            addCriterion("CERTIFICATE_TYPE >", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_TYPE >=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThan(String value) {
            addCriterion("CERTIFICATE_TYPE <", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_TYPE <=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLike(String value) {
            addCriterion("CERTIFICATE_TYPE like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotLike(String value) {
            addCriterion("CERTIFICATE_TYPE not like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIn(List<String> values) {
            addCriterion("CERTIFICATE_TYPE in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotIn(List<String> values) {
            addCriterion("CERTIFICATE_TYPE not in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_TYPE between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_TYPE not between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateNumIsNull() {
            addCriterion("CERTIFICATE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumIsNotNull() {
            addCriterion("CERTIFICATE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumEqualTo(String value) {
            addCriterion("CERTIFICATE_NUM =", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumNotEqualTo(String value) {
            addCriterion("CERTIFICATE_NUM <>", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumGreaterThan(String value) {
            addCriterion("CERTIFICATE_NUM >", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_NUM >=", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumLessThan(String value) {
            addCriterion("CERTIFICATE_NUM <", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_NUM <=", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumLike(String value) {
            addCriterion("CERTIFICATE_NUM like", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumNotLike(String value) {
            addCriterion("CERTIFICATE_NUM not like", value, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumIn(List<String> values) {
            addCriterion("CERTIFICATE_NUM in", values, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumNotIn(List<String> values) {
            addCriterion("CERTIFICATE_NUM not in", values, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_NUM between", value1, value2, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andCertificateNumNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_NUM not between", value1, value2, "certificateNum");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNull() {
            addCriterion("BIRTHDATE is null");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNotNull() {
            addCriterion("BIRTHDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdateEqualTo(String value) {
            addCriterion("BIRTHDATE =", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotEqualTo(String value) {
            addCriterion("BIRTHDATE <>", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThan(String value) {
            addCriterion("BIRTHDATE >", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTHDATE >=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThan(String value) {
            addCriterion("BIRTHDATE <", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThanOrEqualTo(String value) {
            addCriterion("BIRTHDATE <=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLike(String value) {
            addCriterion("BIRTHDATE like", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotLike(String value) {
            addCriterion("BIRTHDATE not like", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateIn(List<String> values) {
            addCriterion("BIRTHDATE in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotIn(List<String> values) {
            addCriterion("BIRTHDATE not in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateBetween(String value1, String value2) {
            addCriterion("BIRTHDATE between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotBetween(String value1, String value2) {
            addCriterion("BIRTHDATE not between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andHighestEducationIsNull() {
            addCriterion("HIGHEST_EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andHighestEducationIsNotNull() {
            addCriterion("HIGHEST_EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andHighestEducationEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION =", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION <>", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationGreaterThan(String value) {
            addCriterion("HIGHEST_EDUCATION >", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationGreaterThanOrEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION >=", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLessThan(String value) {
            addCriterion("HIGHEST_EDUCATION <", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLessThanOrEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION <=", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLike(String value) {
            addCriterion("HIGHEST_EDUCATION like", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotLike(String value) {
            addCriterion("HIGHEST_EDUCATION not like", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationIn(List<String> values) {
            addCriterion("HIGHEST_EDUCATION in", values, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotIn(List<String> values) {
            addCriterion("HIGHEST_EDUCATION not in", values, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationBetween(String value1, String value2) {
            addCriterion("HIGHEST_EDUCATION between", value1, value2, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotBetween(String value1, String value2) {
            addCriterion("HIGHEST_EDUCATION not between", value1, value2, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("PHONENUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("PHONENUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("PHONENUMBER =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("PHONENUMBER <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("PHONENUMBER >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("PHONENUMBER >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("PHONENUMBER <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("PHONENUMBER <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("PHONENUMBER like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("PHONENUMBER not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("PHONENUMBER in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("PHONENUMBER not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("PHONENUMBER between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("PHONENUMBER not between", value1, value2, "phonenumber");
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

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostcodesIsNull() {
            addCriterion("POSTCODES is null");
            return (Criteria) this;
        }

        public Criteria andPostcodesIsNotNull() {
            addCriterion("POSTCODES is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodesEqualTo(String value) {
            addCriterion("POSTCODES =", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesNotEqualTo(String value) {
            addCriterion("POSTCODES <>", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesGreaterThan(String value) {
            addCriterion("POSTCODES >", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesGreaterThanOrEqualTo(String value) {
            addCriterion("POSTCODES >=", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesLessThan(String value) {
            addCriterion("POSTCODES <", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesLessThanOrEqualTo(String value) {
            addCriterion("POSTCODES <=", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesLike(String value) {
            addCriterion("POSTCODES like", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesNotLike(String value) {
            addCriterion("POSTCODES not like", value, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesIn(List<String> values) {
            addCriterion("POSTCODES in", values, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesNotIn(List<String> values) {
            addCriterion("POSTCODES not in", values, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesBetween(String value1, String value2) {
            addCriterion("POSTCODES between", value1, value2, "postcodes");
            return (Criteria) this;
        }

        public Criteria andPostcodesNotBetween(String value1, String value2) {
            addCriterion("POSTCODES not between", value1, value2, "postcodes");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateIsNull() {
            addCriterion("STARTWORKINGDATE is null");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateIsNotNull() {
            addCriterion("STARTWORKINGDATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateEqualTo(String value) {
            addCriterion("STARTWORKINGDATE =", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateNotEqualTo(String value) {
            addCriterion("STARTWORKINGDATE <>", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateGreaterThan(String value) {
            addCriterion("STARTWORKINGDATE >", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateGreaterThanOrEqualTo(String value) {
            addCriterion("STARTWORKINGDATE >=", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateLessThan(String value) {
            addCriterion("STARTWORKINGDATE <", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateLessThanOrEqualTo(String value) {
            addCriterion("STARTWORKINGDATE <=", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateLike(String value) {
            addCriterion("STARTWORKINGDATE like", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateNotLike(String value) {
            addCriterion("STARTWORKINGDATE not like", value, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateIn(List<String> values) {
            addCriterion("STARTWORKINGDATE in", values, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateNotIn(List<String> values) {
            addCriterion("STARTWORKINGDATE not in", values, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateBetween(String value1, String value2) {
            addCriterion("STARTWORKINGDATE between", value1, value2, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateNotBetween(String value1, String value2) {
            addCriterion("STARTWORKINGDATE not between", value1, value2, "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("POSITION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("POSITION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("POSITION_NAME =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("POSITION_NAME <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("POSITION_NAME >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION_NAME >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("POSITION_NAME <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("POSITION_NAME <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("POSITION_NAME like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("POSITION_NAME not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("POSITION_NAME in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("POSITION_NAME not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("POSITION_NAME between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("POSITION_NAME not between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andArriveDateIsNull() {
            addCriterion("ARRIVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andArriveDateIsNotNull() {
            addCriterion("ARRIVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andArriveDateEqualTo(String value) {
            addCriterion("ARRIVE_DATE =", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateNotEqualTo(String value) {
            addCriterion("ARRIVE_DATE <>", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateGreaterThan(String value) {
            addCriterion("ARRIVE_DATE >", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateGreaterThanOrEqualTo(String value) {
            addCriterion("ARRIVE_DATE >=", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateLessThan(String value) {
            addCriterion("ARRIVE_DATE <", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateLessThanOrEqualTo(String value) {
            addCriterion("ARRIVE_DATE <=", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateLike(String value) {
            addCriterion("ARRIVE_DATE like", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateNotLike(String value) {
            addCriterion("ARRIVE_DATE not like", value, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateIn(List<String> values) {
            addCriterion("ARRIVE_DATE in", values, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateNotIn(List<String> values) {
            addCriterion("ARRIVE_DATE not in", values, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateBetween(String value1, String value2) {
            addCriterion("ARRIVE_DATE between", value1, value2, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andArriveDateNotBetween(String value1, String value2) {
            addCriterion("ARRIVE_DATE not between", value1, value2, "arriveDate");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthIsNull() {
            addCriterion("EXPECTED_SALARY_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthIsNotNull() {
            addCriterion("EXPECTED_SALARY_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_MONTH =", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthNotEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_MONTH <>", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthGreaterThan(String value) {
            addCriterion("EXPECTED_SALARY_MONTH >", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthGreaterThanOrEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_MONTH >=", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthLessThan(String value) {
            addCriterion("EXPECTED_SALARY_MONTH <", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthLessThanOrEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_MONTH <=", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthLike(String value) {
            addCriterion("EXPECTED_SALARY_MONTH like", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthNotLike(String value) {
            addCriterion("EXPECTED_SALARY_MONTH not like", value, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthIn(List<String> values) {
            addCriterion("EXPECTED_SALARY_MONTH in", values, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthNotIn(List<String> values) {
            addCriterion("EXPECTED_SALARY_MONTH not in", values, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthBetween(String value1, String value2) {
            addCriterion("EXPECTED_SALARY_MONTH between", value1, value2, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthNotBetween(String value1, String value2) {
            addCriterion("EXPECTED_SALARY_MONTH not between", value1, value2, "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearIsNull() {
            addCriterion("EXPECTED_SALARY_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearIsNotNull() {
            addCriterion("EXPECTED_SALARY_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_YEAR =", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearNotEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_YEAR <>", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearGreaterThan(String value) {
            addCriterion("EXPECTED_SALARY_YEAR >", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearGreaterThanOrEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_YEAR >=", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearLessThan(String value) {
            addCriterion("EXPECTED_SALARY_YEAR <", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearLessThanOrEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_YEAR <=", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearLike(String value) {
            addCriterion("EXPECTED_SALARY_YEAR like", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearNotLike(String value) {
            addCriterion("EXPECTED_SALARY_YEAR not like", value, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearIn(List<String> values) {
            addCriterion("EXPECTED_SALARY_YEAR in", values, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearNotIn(List<String> values) {
            addCriterion("EXPECTED_SALARY_YEAR not in", values, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearBetween(String value1, String value2) {
            addCriterion("EXPECTED_SALARY_YEAR between", value1, value2, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearNotBetween(String value1, String value2) {
            addCriterion("EXPECTED_SALARY_YEAR not between", value1, value2, "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherIsNull() {
            addCriterion("EXPECTED_SALARY_OTHER is null");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherIsNotNull() {
            addCriterion("EXPECTED_SALARY_OTHER is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_OTHER =", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherNotEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_OTHER <>", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherGreaterThan(String value) {
            addCriterion("EXPECTED_SALARY_OTHER >", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherGreaterThanOrEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_OTHER >=", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherLessThan(String value) {
            addCriterion("EXPECTED_SALARY_OTHER <", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherLessThanOrEqualTo(String value) {
            addCriterion("EXPECTED_SALARY_OTHER <=", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherLike(String value) {
            addCriterion("EXPECTED_SALARY_OTHER like", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherNotLike(String value) {
            addCriterion("EXPECTED_SALARY_OTHER not like", value, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherIn(List<String> values) {
            addCriterion("EXPECTED_SALARY_OTHER in", values, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherNotIn(List<String> values) {
            addCriterion("EXPECTED_SALARY_OTHER not in", values, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherBetween(String value1, String value2) {
            addCriterion("EXPECTED_SALARY_OTHER between", value1, value2, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherNotBetween(String value1, String value2) {
            addCriterion("EXPECTED_SALARY_OTHER not between", value1, value2, "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachIsNull() {
            addCriterion("RECRUITMENT_APPROACH is null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachIsNotNull() {
            addCriterion("RECRUITMENT_APPROACH is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachEqualTo(String value) {
            addCriterion("RECRUITMENT_APPROACH =", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachNotEqualTo(String value) {
            addCriterion("RECRUITMENT_APPROACH <>", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachGreaterThan(String value) {
            addCriterion("RECRUITMENT_APPROACH >", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUITMENT_APPROACH >=", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachLessThan(String value) {
            addCriterion("RECRUITMENT_APPROACH <", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachLessThanOrEqualTo(String value) {
            addCriterion("RECRUITMENT_APPROACH <=", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachLike(String value) {
            addCriterion("RECRUITMENT_APPROACH like", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachNotLike(String value) {
            addCriterion("RECRUITMENT_APPROACH not like", value, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachIn(List<String> values) {
            addCriterion("RECRUITMENT_APPROACH in", values, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachNotIn(List<String> values) {
            addCriterion("RECRUITMENT_APPROACH not in", values, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachBetween(String value1, String value2) {
            addCriterion("RECRUITMENT_APPROACH between", value1, value2, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachNotBetween(String value1, String value2) {
            addCriterion("RECRUITMENT_APPROACH not between", value1, value2, "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRefereeNameIsNull() {
            addCriterion("REFEREE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRefereeNameIsNotNull() {
            addCriterion("REFEREE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeNameEqualTo(String value) {
            addCriterion("REFEREE_NAME =", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotEqualTo(String value) {
            addCriterion("REFEREE_NAME <>", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameGreaterThan(String value) {
            addCriterion("REFEREE_NAME >", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameGreaterThanOrEqualTo(String value) {
            addCriterion("REFEREE_NAME >=", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameLessThan(String value) {
            addCriterion("REFEREE_NAME <", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameLessThanOrEqualTo(String value) {
            addCriterion("REFEREE_NAME <=", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameLike(String value) {
            addCriterion("REFEREE_NAME like", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotLike(String value) {
            addCriterion("REFEREE_NAME not like", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameIn(List<String> values) {
            addCriterion("REFEREE_NAME in", values, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotIn(List<String> values) {
            addCriterion("REFEREE_NAME not in", values, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameBetween(String value1, String value2) {
            addCriterion("REFEREE_NAME between", value1, value2, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotBetween(String value1, String value2) {
            addCriterion("REFEREE_NAME not between", value1, value2, "refereeName");
            return (Criteria) this;
        }

        public Criteria andOtherWayIsNull() {
            addCriterion("OTHER_WAY is null");
            return (Criteria) this;
        }

        public Criteria andOtherWayIsNotNull() {
            addCriterion("OTHER_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andOtherWayEqualTo(String value) {
            addCriterion("OTHER_WAY =", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayNotEqualTo(String value) {
            addCriterion("OTHER_WAY <>", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayGreaterThan(String value) {
            addCriterion("OTHER_WAY >", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_WAY >=", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayLessThan(String value) {
            addCriterion("OTHER_WAY <", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayLessThanOrEqualTo(String value) {
            addCriterion("OTHER_WAY <=", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayLike(String value) {
            addCriterion("OTHER_WAY like", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayNotLike(String value) {
            addCriterion("OTHER_WAY not like", value, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayIn(List<String> values) {
            addCriterion("OTHER_WAY in", values, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayNotIn(List<String> values) {
            addCriterion("OTHER_WAY not in", values, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayBetween(String value1, String value2) {
            addCriterion("OTHER_WAY between", value1, value2, "otherWay");
            return (Criteria) this;
        }

        public Criteria andOtherWayNotBetween(String value1, String value2) {
            addCriterion("OTHER_WAY not between", value1, value2, "otherWay");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagIsNull() {
            addCriterion("RELATIVES_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagIsNotNull() {
            addCriterion("RELATIVES_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagEqualTo(String value) {
            addCriterion("RELATIVES_FLAG =", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagNotEqualTo(String value) {
            addCriterion("RELATIVES_FLAG <>", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagGreaterThan(String value) {
            addCriterion("RELATIVES_FLAG >", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIVES_FLAG >=", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagLessThan(String value) {
            addCriterion("RELATIVES_FLAG <", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagLessThanOrEqualTo(String value) {
            addCriterion("RELATIVES_FLAG <=", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagLike(String value) {
            addCriterion("RELATIVES_FLAG like", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagNotLike(String value) {
            addCriterion("RELATIVES_FLAG not like", value, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagIn(List<String> values) {
            addCriterion("RELATIVES_FLAG in", values, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagNotIn(List<String> values) {
            addCriterion("RELATIVES_FLAG not in", values, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagBetween(String value1, String value2) {
            addCriterion("RELATIVES_FLAG between", value1, value2, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagNotBetween(String value1, String value2) {
            addCriterion("RELATIVES_FLAG not between", value1, value2, "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesNameIsNull() {
            addCriterion("RELATIVES_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRelativesNameIsNotNull() {
            addCriterion("RELATIVES_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRelativesNameEqualTo(String value) {
            addCriterion("RELATIVES_NAME =", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameNotEqualTo(String value) {
            addCriterion("RELATIVES_NAME <>", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameGreaterThan(String value) {
            addCriterion("RELATIVES_NAME >", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIVES_NAME >=", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameLessThan(String value) {
            addCriterion("RELATIVES_NAME <", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameLessThanOrEqualTo(String value) {
            addCriterion("RELATIVES_NAME <=", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameLike(String value) {
            addCriterion("RELATIVES_NAME like", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameNotLike(String value) {
            addCriterion("RELATIVES_NAME not like", value, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameIn(List<String> values) {
            addCriterion("RELATIVES_NAME in", values, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameNotIn(List<String> values) {
            addCriterion("RELATIVES_NAME not in", values, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameBetween(String value1, String value2) {
            addCriterion("RELATIVES_NAME between", value1, value2, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesNameNotBetween(String value1, String value2) {
            addCriterion("RELATIVES_NAME not between", value1, value2, "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesShipIsNull() {
            addCriterion("RELATIVES_SHIP is null");
            return (Criteria) this;
        }

        public Criteria andRelativesShipIsNotNull() {
            addCriterion("RELATIVES_SHIP is not null");
            return (Criteria) this;
        }

        public Criteria andRelativesShipEqualTo(String value) {
            addCriterion("RELATIVES_SHIP =", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipNotEqualTo(String value) {
            addCriterion("RELATIVES_SHIP <>", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipGreaterThan(String value) {
            addCriterion("RELATIVES_SHIP >", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIVES_SHIP >=", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipLessThan(String value) {
            addCriterion("RELATIVES_SHIP <", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipLessThanOrEqualTo(String value) {
            addCriterion("RELATIVES_SHIP <=", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipLike(String value) {
            addCriterion("RELATIVES_SHIP like", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipNotLike(String value) {
            addCriterion("RELATIVES_SHIP not like", value, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipIn(List<String> values) {
            addCriterion("RELATIVES_SHIP in", values, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipNotIn(List<String> values) {
            addCriterion("RELATIVES_SHIP not in", values, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipBetween(String value1, String value2) {
            addCriterion("RELATIVES_SHIP between", value1, value2, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andRelativesShipNotBetween(String value1, String value2) {
            addCriterion("RELATIVES_SHIP not between", value1, value2, "relativesShip");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusIsNull() {
            addCriterion("INTERVIEW_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusIsNotNull() {
            addCriterion("INTERVIEW_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS =", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS <>", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusGreaterThan(String value) {
            addCriterion("INTERVIEW_STATUS >", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS >=", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLessThan(String value) {
            addCriterion("INTERVIEW_STATUS <", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS <=", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLike(String value) {
            addCriterion("INTERVIEW_STATUS like", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotLike(String value) {
            addCriterion("INTERVIEW_STATUS not like", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusIn(List<String> values) {
            addCriterion("INTERVIEW_STATUS in", values, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotIn(List<String> values) {
            addCriterion("INTERVIEW_STATUS not in", values, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusBetween(String value1, String value2) {
            addCriterion("INTERVIEW_STATUS between", value1, value2, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_STATUS not between", value1, value2, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameIsNull() {
            addCriterion("RECRUITER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameIsNotNull() {
            addCriterion("RECRUITER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameEqualTo(String value) {
            addCriterion("RECRUITER_NAME =", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameNotEqualTo(String value) {
            addCriterion("RECRUITER_NAME <>", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameGreaterThan(String value) {
            addCriterion("RECRUITER_NAME >", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUITER_NAME >=", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameLessThan(String value) {
            addCriterion("RECRUITER_NAME <", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameLessThanOrEqualTo(String value) {
            addCriterion("RECRUITER_NAME <=", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameLike(String value) {
            addCriterion("RECRUITER_NAME like", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameNotLike(String value) {
            addCriterion("RECRUITER_NAME not like", value, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameIn(List<String> values) {
            addCriterion("RECRUITER_NAME in", values, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameNotIn(List<String> values) {
            addCriterion("RECRUITER_NAME not in", values, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameBetween(String value1, String value2) {
            addCriterion("RECRUITER_NAME between", value1, value2, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameNotBetween(String value1, String value2) {
            addCriterion("RECRUITER_NAME not between", value1, value2, "recruiterName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andEditPersonIsNull() {
            addCriterion("EDIT_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andEditPersonIsNotNull() {
            addCriterion("EDIT_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andEditPersonEqualTo(String value) {
            addCriterion("EDIT_PERSON =", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonNotEqualTo(String value) {
            addCriterion("EDIT_PERSON <>", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonGreaterThan(String value) {
            addCriterion("EDIT_PERSON >", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonGreaterThanOrEqualTo(String value) {
            addCriterion("EDIT_PERSON >=", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonLessThan(String value) {
            addCriterion("EDIT_PERSON <", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonLessThanOrEqualTo(String value) {
            addCriterion("EDIT_PERSON <=", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonLike(String value) {
            addCriterion("EDIT_PERSON like", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonNotLike(String value) {
            addCriterion("EDIT_PERSON not like", value, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonIn(List<String> values) {
            addCriterion("EDIT_PERSON in", values, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonNotIn(List<String> values) {
            addCriterion("EDIT_PERSON not in", values, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonBetween(String value1, String value2) {
            addCriterion("EDIT_PERSON between", value1, value2, "editPerson");
            return (Criteria) this;
        }

        public Criteria andEditPersonNotBetween(String value1, String value2) {
            addCriterion("EDIT_PERSON not between", value1, value2, "editPerson");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andPersonCodeLikeInsensitive(String value) {
            addCriterion("upper(PERSON_CODE) like", value.toUpperCase(), "personCode");
            return (Criteria) this;
        }

        public Criteria andRecruiterNumberLikeInsensitive(String value) {
            addCriterion("upper(RECRUITER_NUMBER) like", value.toUpperCase(), "recruiterNumber");
            return (Criteria) this;
        }

        public Criteria andNationalityLikeInsensitive(String value) {
            addCriterion("upper(NATIONALITY) like", value.toUpperCase(), "nationality");
            return (Criteria) this;
        }

        public Criteria andCnnameLikeInsensitive(String value) {
            addCriterion("upper(CNNAME) like", value.toUpperCase(), "cnname");
            return (Criteria) this;
        }

        public Criteria andEnnameLikeInsensitive(String value) {
            addCriterion("upper(ENNAME) like", value.toUpperCase(), "enname");
            return (Criteria) this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(SEX) like", value.toUpperCase(), "sex");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLikeInsensitive(String value) {
            addCriterion("upper(MARITAL_STATUS) like", value.toUpperCase(), "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andNamepyLikeInsensitive(String value) {
            addCriterion("upper(NAMEPY) like", value.toUpperCase(), "namepy");
            return (Criteria) this;
        }

        public Criteria andNationLikeInsensitive(String value) {
            addCriterion("upper(NATION) like", value.toUpperCase(), "nation");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLikeInsensitive(String value) {
            addCriterion("upper(POLITICAL_STATUS) like", value.toUpperCase(), "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLikeInsensitive(String value) {
            addCriterion("upper(NATIVE_PLACE) like", value.toUpperCase(), "nativePlace");
            return (Criteria) this;
        }

        public Criteria andResidencePropertyLikeInsensitive(String value) {
            addCriterion("upper(RESIDENCE_PROPERTY) like", value.toUpperCase(), "residenceProperty");
            return (Criteria) this;
        }

        public Criteria andResidenceLikeInsensitive(String value) {
            addCriterion("upper(RESIDENCE) like", value.toUpperCase(), "residence");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLikeInsensitive(String value) {
            addCriterion("upper(CERTIFICATE_TYPE) like", value.toUpperCase(), "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateNumLikeInsensitive(String value) {
            addCriterion("upper(CERTIFICATE_NUM) like", value.toUpperCase(), "certificateNum");
            return (Criteria) this;
        }

        public Criteria andBirthdateLikeInsensitive(String value) {
            addCriterion("upper(BIRTHDATE) like", value.toUpperCase(), "birthdate");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLikeInsensitive(String value) {
            addCriterion("upper(HIGHEST_EDUCATION) like", value.toUpperCase(), "highestEducation");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLikeInsensitive(String value) {
            addCriterion("upper(PHONENUMBER) like", value.toUpperCase(), "phonenumber");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(ADDRESS) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andPostcodesLikeInsensitive(String value) {
            addCriterion("upper(POSTCODES) like", value.toUpperCase(), "postcodes");
            return (Criteria) this;
        }

        public Criteria andStartworkingdateLikeInsensitive(String value) {
            addCriterion("upper(STARTWORKINGDATE) like", value.toUpperCase(), "startworkingdate");
            return (Criteria) this;
        }

        public Criteria andPositionNameLikeInsensitive(String value) {
            addCriterion("upper(POSITION_NAME) like", value.toUpperCase(), "positionName");
            return (Criteria) this;
        }

        public Criteria andArriveDateLikeInsensitive(String value) {
            addCriterion("upper(ARRIVE_DATE) like", value.toUpperCase(), "arriveDate");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryMonthLikeInsensitive(String value) {
            addCriterion("upper(EXPECTED_SALARY_MONTH) like", value.toUpperCase(), "expectedSalaryMonth");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryYearLikeInsensitive(String value) {
            addCriterion("upper(EXPECTED_SALARY_YEAR) like", value.toUpperCase(), "expectedSalaryYear");
            return (Criteria) this;
        }

        public Criteria andExpectedSalaryOtherLikeInsensitive(String value) {
            addCriterion("upper(EXPECTED_SALARY_OTHER) like", value.toUpperCase(), "expectedSalaryOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentApproachLikeInsensitive(String value) {
            addCriterion("upper(RECRUITMENT_APPROACH) like", value.toUpperCase(), "recruitmentApproach");
            return (Criteria) this;
        }

        public Criteria andRefereeNameLikeInsensitive(String value) {
            addCriterion("upper(REFEREE_NAME) like", value.toUpperCase(), "refereeName");
            return (Criteria) this;
        }

        public Criteria andOtherWayLikeInsensitive(String value) {
            addCriterion("upper(OTHER_WAY) like", value.toUpperCase(), "otherWay");
            return (Criteria) this;
        }

        public Criteria andRelativesFlagLikeInsensitive(String value) {
            addCriterion("upper(RELATIVES_FLAG) like", value.toUpperCase(), "relativesFlag");
            return (Criteria) this;
        }

        public Criteria andRelativesNameLikeInsensitive(String value) {
            addCriterion("upper(RELATIVES_NAME) like", value.toUpperCase(), "relativesName");
            return (Criteria) this;
        }

        public Criteria andRelativesShipLikeInsensitive(String value) {
            addCriterion("upper(RELATIVES_SHIP) like", value.toUpperCase(), "relativesShip");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_STATUS) like", value.toUpperCase(), "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andRecruiterNameLikeInsensitive(String value) {
            addCriterion("upper(RECRUITER_NAME) like", value.toUpperCase(), "recruiterName");
            return (Criteria) this;
        }

        public Criteria andEditPersonLikeInsensitive(String value) {
            addCriterion("upper(EDIT_PERSON) like", value.toUpperCase(), "editPerson");
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