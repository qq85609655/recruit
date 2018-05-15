package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class WorksExtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WorksExtCriteria() {
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

        public Criteria andWorkIndexIsNull() {
            addCriterion("WORK_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andWorkIndexIsNotNull() {
            addCriterion("WORK_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIndexEqualTo(String value) {
            addCriterion("WORK_INDEX =", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexNotEqualTo(String value) {
            addCriterion("WORK_INDEX <>", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexGreaterThan(String value) {
            addCriterion("WORK_INDEX >", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_INDEX >=", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexLessThan(String value) {
            addCriterion("WORK_INDEX <", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexLessThanOrEqualTo(String value) {
            addCriterion("WORK_INDEX <=", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexLike(String value) {
            addCriterion("WORK_INDEX like", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexNotLike(String value) {
            addCriterion("WORK_INDEX not like", value, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexIn(List<String> values) {
            addCriterion("WORK_INDEX in", values, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexNotIn(List<String> values) {
            addCriterion("WORK_INDEX not in", values, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexBetween(String value1, String value2) {
            addCriterion("WORK_INDEX between", value1, value2, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkIndexNotBetween(String value1, String value2) {
            addCriterion("WORK_INDEX not between", value1, value2, "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateIsNull() {
            addCriterion("WORKSTARTDATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateIsNotNull() {
            addCriterion("WORKSTARTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateEqualTo(String value) {
            addCriterion("WORKSTARTDATE =", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateNotEqualTo(String value) {
            addCriterion("WORKSTARTDATE <>", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateGreaterThan(String value) {
            addCriterion("WORKSTARTDATE >", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateGreaterThanOrEqualTo(String value) {
            addCriterion("WORKSTARTDATE >=", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateLessThan(String value) {
            addCriterion("WORKSTARTDATE <", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateLessThanOrEqualTo(String value) {
            addCriterion("WORKSTARTDATE <=", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateLike(String value) {
            addCriterion("WORKSTARTDATE like", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateNotLike(String value) {
            addCriterion("WORKSTARTDATE not like", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateIn(List<String> values) {
            addCriterion("WORKSTARTDATE in", values, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateNotIn(List<String> values) {
            addCriterion("WORKSTARTDATE not in", values, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateBetween(String value1, String value2) {
            addCriterion("WORKSTARTDATE between", value1, value2, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateNotBetween(String value1, String value2) {
            addCriterion("WORKSTARTDATE not between", value1, value2, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateIsNull() {
            addCriterion("WORKENDDATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkenddateIsNotNull() {
            addCriterion("WORKENDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkenddateEqualTo(String value) {
            addCriterion("WORKENDDATE =", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateNotEqualTo(String value) {
            addCriterion("WORKENDDATE <>", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateGreaterThan(String value) {
            addCriterion("WORKENDDATE >", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateGreaterThanOrEqualTo(String value) {
            addCriterion("WORKENDDATE >=", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateLessThan(String value) {
            addCriterion("WORKENDDATE <", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateLessThanOrEqualTo(String value) {
            addCriterion("WORKENDDATE <=", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateLike(String value) {
            addCriterion("WORKENDDATE like", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateNotLike(String value) {
            addCriterion("WORKENDDATE not like", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateIn(List<String> values) {
            addCriterion("WORKENDDATE in", values, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateNotIn(List<String> values) {
            addCriterion("WORKENDDATE not in", values, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateBetween(String value1, String value2) {
            addCriterion("WORKENDDATE between", value1, value2, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateNotBetween(String value1, String value2) {
            addCriterion("WORKENDDATE not between", value1, value2, "workenddate");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("COMPANY_NAME =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("COMPANY_NAME <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("COMPANY_NAME >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("COMPANY_NAME <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("COMPANY_NAME like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("COMPANY_NAME not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("COMPANY_NAME in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("COMPANY_NAME not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryIsNull() {
            addCriterion("FINAL_SALARY is null");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryIsNotNull() {
            addCriterion("FINAL_SALARY is not null");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryEqualTo(String value) {
            addCriterion("FINAL_SALARY =", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryNotEqualTo(String value) {
            addCriterion("FINAL_SALARY <>", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryGreaterThan(String value) {
            addCriterion("FINAL_SALARY >", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("FINAL_SALARY >=", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryLessThan(String value) {
            addCriterion("FINAL_SALARY <", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryLessThanOrEqualTo(String value) {
            addCriterion("FINAL_SALARY <=", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryLike(String value) {
            addCriterion("FINAL_SALARY like", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryNotLike(String value) {
            addCriterion("FINAL_SALARY not like", value, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryIn(List<String> values) {
            addCriterion("FINAL_SALARY in", values, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryNotIn(List<String> values) {
            addCriterion("FINAL_SALARY not in", values, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryBetween(String value1, String value2) {
            addCriterion("FINAL_SALARY between", value1, value2, "finalSalary");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryNotBetween(String value1, String value2) {
            addCriterion("FINAL_SALARY not between", value1, value2, "finalSalary");
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

        public Criteria andFinalPositionIsNull() {
            addCriterion("FINAL_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionIsNotNull() {
            addCriterion("FINAL_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionEqualTo(String value) {
            addCriterion("FINAL_POSITION =", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionNotEqualTo(String value) {
            addCriterion("FINAL_POSITION <>", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionGreaterThan(String value) {
            addCriterion("FINAL_POSITION >", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionGreaterThanOrEqualTo(String value) {
            addCriterion("FINAL_POSITION >=", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionLessThan(String value) {
            addCriterion("FINAL_POSITION <", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionLessThanOrEqualTo(String value) {
            addCriterion("FINAL_POSITION <=", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionLike(String value) {
            addCriterion("FINAL_POSITION like", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionNotLike(String value) {
            addCriterion("FINAL_POSITION not like", value, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionIn(List<String> values) {
            addCriterion("FINAL_POSITION in", values, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionNotIn(List<String> values) {
            addCriterion("FINAL_POSITION not in", values, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionBetween(String value1, String value2) {
            addCriterion("FINAL_POSITION between", value1, value2, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andFinalPositionNotBetween(String value1, String value2) {
            addCriterion("FINAL_POSITION not between", value1, value2, "finalPosition");
            return (Criteria) this;
        }

        public Criteria andReportToIsNull() {
            addCriterion("REPORT_TO is null");
            return (Criteria) this;
        }

        public Criteria andReportToIsNotNull() {
            addCriterion("REPORT_TO is not null");
            return (Criteria) this;
        }

        public Criteria andReportToEqualTo(String value) {
            addCriterion("REPORT_TO =", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToNotEqualTo(String value) {
            addCriterion("REPORT_TO <>", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToGreaterThan(String value) {
            addCriterion("REPORT_TO >", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToGreaterThanOrEqualTo(String value) {
            addCriterion("REPORT_TO >=", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToLessThan(String value) {
            addCriterion("REPORT_TO <", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToLessThanOrEqualTo(String value) {
            addCriterion("REPORT_TO <=", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToLike(String value) {
            addCriterion("REPORT_TO like", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToNotLike(String value) {
            addCriterion("REPORT_TO not like", value, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToIn(List<String> values) {
            addCriterion("REPORT_TO in", values, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToNotIn(List<String> values) {
            addCriterion("REPORT_TO not in", values, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToBetween(String value1, String value2) {
            addCriterion("REPORT_TO between", value1, value2, "reportTo");
            return (Criteria) this;
        }

        public Criteria andReportToNotBetween(String value1, String value2) {
            addCriterion("REPORT_TO not between", value1, value2, "reportTo");
            return (Criteria) this;
        }

        public Criteria andSubordinatesIsNull() {
            addCriterion("SUBORDINATES is null");
            return (Criteria) this;
        }

        public Criteria andSubordinatesIsNotNull() {
            addCriterion("SUBORDINATES is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinatesEqualTo(String value) {
            addCriterion("SUBORDINATES =", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesNotEqualTo(String value) {
            addCriterion("SUBORDINATES <>", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesGreaterThan(String value) {
            addCriterion("SUBORDINATES >", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesGreaterThanOrEqualTo(String value) {
            addCriterion("SUBORDINATES >=", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesLessThan(String value) {
            addCriterion("SUBORDINATES <", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesLessThanOrEqualTo(String value) {
            addCriterion("SUBORDINATES <=", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesLike(String value) {
            addCriterion("SUBORDINATES like", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesNotLike(String value) {
            addCriterion("SUBORDINATES not like", value, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesIn(List<String> values) {
            addCriterion("SUBORDINATES in", values, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesNotIn(List<String> values) {
            addCriterion("SUBORDINATES not in", values, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesBetween(String value1, String value2) {
            addCriterion("SUBORDINATES between", value1, value2, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSubordinatesNotBetween(String value1, String value2) {
            addCriterion("SUBORDINATES not between", value1, value2, "subordinates");
            return (Criteria) this;
        }

        public Criteria andSeniorityIsNull() {
            addCriterion("SENIORITY is null");
            return (Criteria) this;
        }

        public Criteria andSeniorityIsNotNull() {
            addCriterion("SENIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andSeniorityEqualTo(String value) {
            addCriterion("SENIORITY =", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotEqualTo(String value) {
            addCriterion("SENIORITY <>", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityGreaterThan(String value) {
            addCriterion("SENIORITY >", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityGreaterThanOrEqualTo(String value) {
            addCriterion("SENIORITY >=", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLessThan(String value) {
            addCriterion("SENIORITY <", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLessThanOrEqualTo(String value) {
            addCriterion("SENIORITY <=", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLike(String value) {
            addCriterion("SENIORITY like", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotLike(String value) {
            addCriterion("SENIORITY not like", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityIn(List<String> values) {
            addCriterion("SENIORITY in", values, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotIn(List<String> values) {
            addCriterion("SENIORITY not in", values, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityBetween(String value1, String value2) {
            addCriterion("SENIORITY between", value1, value2, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotBetween(String value1, String value2) {
            addCriterion("SENIORITY not between", value1, value2, "seniority");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesIsNull() {
            addCriterion("RESPONSIBILITIES is null");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesIsNotNull() {
            addCriterion("RESPONSIBILITIES is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesEqualTo(String value) {
            addCriterion("RESPONSIBILITIES =", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesNotEqualTo(String value) {
            addCriterion("RESPONSIBILITIES <>", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesGreaterThan(String value) {
            addCriterion("RESPONSIBILITIES >", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSIBILITIES >=", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesLessThan(String value) {
            addCriterion("RESPONSIBILITIES <", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesLessThanOrEqualTo(String value) {
            addCriterion("RESPONSIBILITIES <=", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesLike(String value) {
            addCriterion("RESPONSIBILITIES like", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesNotLike(String value) {
            addCriterion("RESPONSIBILITIES not like", value, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesIn(List<String> values) {
            addCriterion("RESPONSIBILITIES in", values, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesNotIn(List<String> values) {
            addCriterion("RESPONSIBILITIES not in", values, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesBetween(String value1, String value2) {
            addCriterion("RESPONSIBILITIES between", value1, value2, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesNotBetween(String value1, String value2) {
            addCriterion("RESPONSIBILITIES not between", value1, value2, "responsibilities");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNull() {
            addCriterion("LEAVE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNotNull() {
            addCriterion("LEAVE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonEqualTo(String value) {
            addCriterion("LEAVE_REASON =", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotEqualTo(String value) {
            addCriterion("LEAVE_REASON <>", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThan(String value) {
            addCriterion("LEAVE_REASON >", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThanOrEqualTo(String value) {
            addCriterion("LEAVE_REASON >=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThan(String value) {
            addCriterion("LEAVE_REASON <", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThanOrEqualTo(String value) {
            addCriterion("LEAVE_REASON <=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLike(String value) {
            addCriterion("LEAVE_REASON like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotLike(String value) {
            addCriterion("LEAVE_REASON not like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIn(List<String> values) {
            addCriterion("LEAVE_REASON in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotIn(List<String> values) {
            addCriterion("LEAVE_REASON not in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonBetween(String value1, String value2) {
            addCriterion("LEAVE_REASON between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotBetween(String value1, String value2) {
            addCriterion("LEAVE_REASON not between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andReterenceIsNull() {
            addCriterion("RETERENCE is null");
            return (Criteria) this;
        }

        public Criteria andReterenceIsNotNull() {
            addCriterion("RETERENCE is not null");
            return (Criteria) this;
        }

        public Criteria andReterenceEqualTo(String value) {
            addCriterion("RETERENCE =", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotEqualTo(String value) {
            addCriterion("RETERENCE <>", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceGreaterThan(String value) {
            addCriterion("RETERENCE >", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceGreaterThanOrEqualTo(String value) {
            addCriterion("RETERENCE >=", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceLessThan(String value) {
            addCriterion("RETERENCE <", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceLessThanOrEqualTo(String value) {
            addCriterion("RETERENCE <=", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceLike(String value) {
            addCriterion("RETERENCE like", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotLike(String value) {
            addCriterion("RETERENCE not like", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceIn(List<String> values) {
            addCriterion("RETERENCE in", values, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotIn(List<String> values) {
            addCriterion("RETERENCE not in", values, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceBetween(String value1, String value2) {
            addCriterion("RETERENCE between", value1, value2, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotBetween(String value1, String value2) {
            addCriterion("RETERENCE not between", value1, value2, "reterence");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNull() {
            addCriterion("RELATIONSHIP is null");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNotNull() {
            addCriterion("RELATIONSHIP is not null");
            return (Criteria) this;
        }

        public Criteria andRelationshipEqualTo(String value) {
            addCriterion("RELATIONSHIP =", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotEqualTo(String value) {
            addCriterion("RELATIONSHIP <>", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThan(String value) {
            addCriterion("RELATIONSHIP >", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIONSHIP >=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThan(String value) {
            addCriterion("RELATIONSHIP <", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThanOrEqualTo(String value) {
            addCriterion("RELATIONSHIP <=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLike(String value) {
            addCriterion("RELATIONSHIP like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotLike(String value) {
            addCriterion("RELATIONSHIP not like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipIn(List<String> values) {
            addCriterion("RELATIONSHIP in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotIn(List<String> values) {
            addCriterion("RELATIONSHIP not in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipBetween(String value1, String value2) {
            addCriterion("RELATIONSHIP between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotBetween(String value1, String value2) {
            addCriterion("RELATIONSHIP not between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneIsNull() {
            addCriterion("RETERENCE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneIsNotNull() {
            addCriterion("RETERENCE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneEqualTo(String value) {
            addCriterion("RETERENCE_PHONE =", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotEqualTo(String value) {
            addCriterion("RETERENCE_PHONE <>", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneGreaterThan(String value) {
            addCriterion("RETERENCE_PHONE >", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("RETERENCE_PHONE >=", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLessThan(String value) {
            addCriterion("RETERENCE_PHONE <", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLessThanOrEqualTo(String value) {
            addCriterion("RETERENCE_PHONE <=", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLike(String value) {
            addCriterion("RETERENCE_PHONE like", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotLike(String value) {
            addCriterion("RETERENCE_PHONE not like", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneIn(List<String> values) {
            addCriterion("RETERENCE_PHONE in", values, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotIn(List<String> values) {
            addCriterion("RETERENCE_PHONE not in", values, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneBetween(String value1, String value2) {
            addCriterion("RETERENCE_PHONE between", value1, value2, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotBetween(String value1, String value2) {
            addCriterion("RETERENCE_PHONE not between", value1, value2, "reterencePhone");
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

        public Criteria andWorkIndexLikeInsensitive(String value) {
            addCriterion("upper(WORK_INDEX) like", value.toUpperCase(), "workIndex");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateLikeInsensitive(String value) {
            addCriterion("upper(WORKSTARTDATE) like", value.toUpperCase(), "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateLikeInsensitive(String value) {
            addCriterion("upper(WORKENDDATE) like", value.toUpperCase(), "workenddate");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLikeInsensitive(String value) {
            addCriterion("upper(COMPANY_NAME) like", value.toUpperCase(), "companyName");
            return (Criteria) this;
        }

        public Criteria andFinalSalaryLikeInsensitive(String value) {
            addCriterion("upper(FINAL_SALARY) like", value.toUpperCase(), "finalSalary");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikeInsensitive(String value) {
            addCriterion("upper(DEPARTMENT) like", value.toUpperCase(), "department");
            return (Criteria) this;
        }

        public Criteria andFinalPositionLikeInsensitive(String value) {
            addCriterion("upper(FINAL_POSITION) like", value.toUpperCase(), "finalPosition");
            return (Criteria) this;
        }

        public Criteria andReportToLikeInsensitive(String value) {
            addCriterion("upper(REPORT_TO) like", value.toUpperCase(), "reportTo");
            return (Criteria) this;
        }

        public Criteria andSubordinatesLikeInsensitive(String value) {
            addCriterion("upper(SUBORDINATES) like", value.toUpperCase(), "subordinates");
            return (Criteria) this;
        }

        public Criteria andSeniorityLikeInsensitive(String value) {
            addCriterion("upper(SENIORITY) like", value.toUpperCase(), "seniority");
            return (Criteria) this;
        }

        public Criteria andResponsibilitiesLikeInsensitive(String value) {
            addCriterion("upper(RESPONSIBILITIES) like", value.toUpperCase(), "responsibilities");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLikeInsensitive(String value) {
            addCriterion("upper(LEAVE_REASON) like", value.toUpperCase(), "leaveReason");
            return (Criteria) this;
        }

        public Criteria andReterenceLikeInsensitive(String value) {
            addCriterion("upper(RETERENCE) like", value.toUpperCase(), "reterence");
            return (Criteria) this;
        }

        public Criteria andRelationshipLikeInsensitive(String value) {
            addCriterion("upper(RELATIONSHIP) like", value.toUpperCase(), "relationship");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLikeInsensitive(String value) {
            addCriterion("upper(RETERENCE_PHONE) like", value.toUpperCase(), "reterencePhone");
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