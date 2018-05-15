package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class EmployDemandCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EmployDemandCriteria() {
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

        public Criteria andEmployIdIsNull() {
            addCriterion("EMPLOY_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmployIdIsNotNull() {
            addCriterion("EMPLOY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployIdEqualTo(String value) {
            addCriterion("EMPLOY_ID =", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotEqualTo(String value) {
            addCriterion("EMPLOY_ID <>", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThan(String value) {
            addCriterion("EMPLOY_ID >", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ID >=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThan(String value) {
            addCriterion("EMPLOY_ID <", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ID <=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLike(String value) {
            addCriterion("EMPLOY_ID like", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotLike(String value) {
            addCriterion("EMPLOY_ID not like", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdIn(List<String> values) {
            addCriterion("EMPLOY_ID in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotIn(List<String> values) {
            addCriterion("EMPLOY_ID not in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdBetween(String value1, String value2) {
            addCriterion("EMPLOY_ID between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_ID not between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNull() {
            addCriterion("DEMAND_ID is null");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNotNull() {
            addCriterion("DEMAND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDemandIdEqualTo(String value) {
            addCriterion("DEMAND_ID =", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotEqualTo(String value) {
            addCriterion("DEMAND_ID <>", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThan(String value) {
            addCriterion("DEMAND_ID >", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEMAND_ID >=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThan(String value) {
            addCriterion("DEMAND_ID <", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThanOrEqualTo(String value) {
            addCriterion("DEMAND_ID <=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLike(String value) {
            addCriterion("DEMAND_ID like", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotLike(String value) {
            addCriterion("DEMAND_ID not like", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIn(List<String> values) {
            addCriterion("DEMAND_ID in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotIn(List<String> values) {
            addCriterion("DEMAND_ID not in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdBetween(String value1, String value2) {
            addCriterion("DEMAND_ID between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotBetween(String value1, String value2) {
            addCriterion("DEMAND_ID not between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIsNull() {
            addCriterion("EMPLOYEE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIsNotNull() {
            addCriterion("EMPLOYEE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeEqualTo(String value) {
            addCriterion("EMPLOYEE_TYPE =", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotEqualTo(String value) {
            addCriterion("EMPLOYEE_TYPE <>", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeGreaterThan(String value) {
            addCriterion("EMPLOYEE_TYPE >", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOYEE_TYPE >=", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLessThan(String value) {
            addCriterion("EMPLOYEE_TYPE <", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLessThanOrEqualTo(String value) {
            addCriterion("EMPLOYEE_TYPE <=", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLike(String value) {
            addCriterion("EMPLOYEE_TYPE like", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotLike(String value) {
            addCriterion("EMPLOYEE_TYPE not like", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIn(List<String> values) {
            addCriterion("EMPLOYEE_TYPE in", values, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotIn(List<String> values) {
            addCriterion("EMPLOYEE_TYPE not in", values, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeBetween(String value1, String value2) {
            addCriterion("EMPLOYEE_TYPE between", value1, value2, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotBetween(String value1, String value2) {
            addCriterion("EMPLOYEE_TYPE not between", value1, value2, "employeeType");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("DISTRICT is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("DISTRICT is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("DISTRICT =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("DISTRICT <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("DISTRICT >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("DISTRICT >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("DISTRICT <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("DISTRICT <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("DISTRICT like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("DISTRICT not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("DISTRICT in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("DISTRICT not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("DISTRICT between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("DISTRICT not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameIsNull() {
            addCriterion("APPLY_ORGANIZATION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameIsNotNull() {
            addCriterion("APPLY_ORGANIZATION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME =", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameNotEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME <>", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameGreaterThan(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME >", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME >=", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameLessThan(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME <", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameLessThanOrEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME <=", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameLike(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME like", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameNotLike(String value) {
            addCriterion("APPLY_ORGANIZATION_NAME not like", value, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameIn(List<String> values) {
            addCriterion("APPLY_ORGANIZATION_NAME in", values, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameNotIn(List<String> values) {
            addCriterion("APPLY_ORGANIZATION_NAME not in", values, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameBetween(String value1, String value2) {
            addCriterion("APPLY_ORGANIZATION_NAME between", value1, value2, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameNotBetween(String value1, String value2) {
            addCriterion("APPLY_ORGANIZATION_NAME not between", value1, value2, "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdIsNull() {
            addCriterion("APPLY_ORGANIZATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdIsNotNull() {
            addCriterion("APPLY_ORGANIZATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_ID =", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdNotEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_ID <>", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdGreaterThan(String value) {
            addCriterion("APPLY_ORGANIZATION_ID >", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_ID >=", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdLessThan(String value) {
            addCriterion("APPLY_ORGANIZATION_ID <", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdLessThanOrEqualTo(String value) {
            addCriterion("APPLY_ORGANIZATION_ID <=", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdLike(String value) {
            addCriterion("APPLY_ORGANIZATION_ID like", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdNotLike(String value) {
            addCriterion("APPLY_ORGANIZATION_ID not like", value, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdIn(List<String> values) {
            addCriterion("APPLY_ORGANIZATION_ID in", values, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdNotIn(List<String> values) {
            addCriterion("APPLY_ORGANIZATION_ID not in", values, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdBetween(String value1, String value2) {
            addCriterion("APPLY_ORGANIZATION_ID between", value1, value2, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdNotBetween(String value1, String value2) {
            addCriterion("APPLY_ORGANIZATION_ID not between", value1, value2, "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdIsNull() {
            addCriterion("APPLY_POST_ID is null");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdIsNotNull() {
            addCriterion("APPLY_POST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdEqualTo(String value) {
            addCriterion("APPLY_POST_ID =", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdNotEqualTo(String value) {
            addCriterion("APPLY_POST_ID <>", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdGreaterThan(String value) {
            addCriterion("APPLY_POST_ID >", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_POST_ID >=", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdLessThan(String value) {
            addCriterion("APPLY_POST_ID <", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdLessThanOrEqualTo(String value) {
            addCriterion("APPLY_POST_ID <=", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdLike(String value) {
            addCriterion("APPLY_POST_ID like", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdNotLike(String value) {
            addCriterion("APPLY_POST_ID not like", value, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdIn(List<String> values) {
            addCriterion("APPLY_POST_ID in", values, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdNotIn(List<String> values) {
            addCriterion("APPLY_POST_ID not in", values, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdBetween(String value1, String value2) {
            addCriterion("APPLY_POST_ID between", value1, value2, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdNotBetween(String value1, String value2) {
            addCriterion("APPLY_POST_ID not between", value1, value2, "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameIsNull() {
            addCriterion("APPLY_POST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameIsNotNull() {
            addCriterion("APPLY_POST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameEqualTo(String value) {
            addCriterion("APPLY_POST_NAME =", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameNotEqualTo(String value) {
            addCriterion("APPLY_POST_NAME <>", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameGreaterThan(String value) {
            addCriterion("APPLY_POST_NAME >", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_POST_NAME >=", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameLessThan(String value) {
            addCriterion("APPLY_POST_NAME <", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameLessThanOrEqualTo(String value) {
            addCriterion("APPLY_POST_NAME <=", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameLike(String value) {
            addCriterion("APPLY_POST_NAME like", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameNotLike(String value) {
            addCriterion("APPLY_POST_NAME not like", value, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameIn(List<String> values) {
            addCriterion("APPLY_POST_NAME in", values, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameNotIn(List<String> values) {
            addCriterion("APPLY_POST_NAME not in", values, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameBetween(String value1, String value2) {
            addCriterion("APPLY_POST_NAME between", value1, value2, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameNotBetween(String value1, String value2) {
            addCriterion("APPLY_POST_NAME not between", value1, value2, "applyPostName");
            return (Criteria) this;
        }

        public Criteria andRankIdIsNull() {
            addCriterion("RANK_ID is null");
            return (Criteria) this;
        }

        public Criteria andRankIdIsNotNull() {
            addCriterion("RANK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRankIdEqualTo(String value) {
            addCriterion("RANK_ID =", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotEqualTo(String value) {
            addCriterion("RANK_ID <>", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThan(String value) {
            addCriterion("RANK_ID >", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThanOrEqualTo(String value) {
            addCriterion("RANK_ID >=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThan(String value) {
            addCriterion("RANK_ID <", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThanOrEqualTo(String value) {
            addCriterion("RANK_ID <=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLike(String value) {
            addCriterion("RANK_ID like", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotLike(String value) {
            addCriterion("RANK_ID not like", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdIn(List<String> values) {
            addCriterion("RANK_ID in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotIn(List<String> values) {
            addCriterion("RANK_ID not in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdBetween(String value1, String value2) {
            addCriterion("RANK_ID between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotBetween(String value1, String value2) {
            addCriterion("RANK_ID not between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonIsNull() {
            addCriterion("RECRUIT_DEMAND_REASON is null");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonIsNotNull() {
            addCriterion("RECRUIT_DEMAND_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_REASON =", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonNotEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_REASON <>", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonGreaterThan(String value) {
            addCriterion("RECRUIT_DEMAND_REASON >", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_REASON >=", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonLessThan(String value) {
            addCriterion("RECRUIT_DEMAND_REASON <", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonLessThanOrEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_REASON <=", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonLike(String value) {
            addCriterion("RECRUIT_DEMAND_REASON like", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonNotLike(String value) {
            addCriterion("RECRUIT_DEMAND_REASON not like", value, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonIn(List<String> values) {
            addCriterion("RECRUIT_DEMAND_REASON in", values, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonNotIn(List<String> values) {
            addCriterion("RECRUIT_DEMAND_REASON not in", values, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonBetween(String value1, String value2) {
            addCriterion("RECRUIT_DEMAND_REASON between", value1, value2, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonNotBetween(String value1, String value2) {
            addCriterion("RECRUIT_DEMAND_REASON not between", value1, value2, "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("CREATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("CREATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(String value) {
            addCriterion("CREATOR_ID =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(String value) {
            addCriterion("CREATOR_ID <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(String value) {
            addCriterion("CREATOR_ID >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR_ID >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(String value) {
            addCriterion("CREATOR_ID <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("CREATOR_ID <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLike(String value) {
            addCriterion("CREATOR_ID like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotLike(String value) {
            addCriterion("CREATOR_ID not like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<String> values) {
            addCriterion("CREATOR_ID in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<String> values) {
            addCriterion("CREATOR_ID not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(String value1, String value2) {
            addCriterion("CREATOR_ID between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(String value1, String value2) {
            addCriterion("CREATOR_ID not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifiedIdIsNull() {
            addCriterion("MODIFIED_ID is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIdIsNotNull() {
            addCriterion("MODIFIED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedIdEqualTo(String value) {
            addCriterion("MODIFIED_ID =", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotEqualTo(String value) {
            addCriterion("MODIFIED_ID <>", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdGreaterThan(String value) {
            addCriterion("MODIFIED_ID >", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIED_ID >=", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLessThan(String value) {
            addCriterion("MODIFIED_ID <", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLessThanOrEqualTo(String value) {
            addCriterion("MODIFIED_ID <=", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLike(String value) {
            addCriterion("MODIFIED_ID like", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotLike(String value) {
            addCriterion("MODIFIED_ID not like", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdIn(List<String> values) {
            addCriterion("MODIFIED_ID in", values, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotIn(List<String> values) {
            addCriterion("MODIFIED_ID not in", values, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdBetween(String value1, String value2) {
            addCriterion("MODIFIED_ID between", value1, value2, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotBetween(String value1, String value2) {
            addCriterion("MODIFIED_ID not between", value1, value2, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andEmployIdLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_ID) like", value.toUpperCase(), "employId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLikeInsensitive(String value) {
            addCriterion("upper(DEMAND_ID) like", value.toUpperCase(), "demandId");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLikeInsensitive(String value) {
            addCriterion("upper(EMPLOYEE_TYPE) like", value.toUpperCase(), "employeeType");
            return (Criteria) this;
        }

        public Criteria andDistrictLikeInsensitive(String value) {
            addCriterion("upper(DISTRICT) like", value.toUpperCase(), "district");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationNameLikeInsensitive(String value) {
            addCriterion("upper(APPLY_ORGANIZATION_NAME) like", value.toUpperCase(), "applyOrganizationName");
            return (Criteria) this;
        }

        public Criteria andApplyOrganizationIdLikeInsensitive(String value) {
            addCriterion("upper(APPLY_ORGANIZATION_ID) like", value.toUpperCase(), "applyOrganizationId");
            return (Criteria) this;
        }

        public Criteria andApplyPostIdLikeInsensitive(String value) {
            addCriterion("upper(APPLY_POST_ID) like", value.toUpperCase(), "applyPostId");
            return (Criteria) this;
        }

        public Criteria andApplyPostNameLikeInsensitive(String value) {
            addCriterion("upper(APPLY_POST_NAME) like", value.toUpperCase(), "applyPostName");
            return (Criteria) this;
        }

        public Criteria andRankIdLikeInsensitive(String value) {
            addCriterion("upper(RANK_ID) like", value.toUpperCase(), "rankId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandReasonLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_DEMAND_REASON) like", value.toUpperCase(), "recruitDemandReason");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLikeInsensitive(String value) {
            addCriterion("upper(CREATOR_ID) like", value.toUpperCase(), "creatorId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLikeInsensitive(String value) {
            addCriterion("upper(MODIFIED_ID) like", value.toUpperCase(), "modifiedId");
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