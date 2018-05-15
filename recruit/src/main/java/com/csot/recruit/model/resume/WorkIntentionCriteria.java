package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class WorkIntentionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WorkIntentionCriteria() {
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

        public Criteria andWorkplaceExpectIsNull() {
            addCriterion("WORKPLACE_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectIsNotNull() {
            addCriterion("WORKPLACE_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT =", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT <>", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectGreaterThan(String value) {
            addCriterion("WORKPLACE_EXPECT >", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectGreaterThanOrEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT >=", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLessThan(String value) {
            addCriterion("WORKPLACE_EXPECT <", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLessThanOrEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT <=", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLike(String value) {
            addCriterion("WORKPLACE_EXPECT like", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotLike(String value) {
            addCriterion("WORKPLACE_EXPECT not like", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectIn(List<String> values) {
            addCriterion("WORKPLACE_EXPECT in", values, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotIn(List<String> values) {
            addCriterion("WORKPLACE_EXPECT not in", values, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectBetween(String value1, String value2) {
            addCriterion("WORKPLACE_EXPECT between", value1, value2, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotBetween(String value1, String value2) {
            addCriterion("WORKPLACE_EXPECT not between", value1, value2, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectIsNull() {
            addCriterion("INDUSTRY_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectIsNotNull() {
            addCriterion("INDUSTRY_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT =", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT <>", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectGreaterThan(String value) {
            addCriterion("INDUSTRY_EXPECT >", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT >=", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLessThan(String value) {
            addCriterion("INDUSTRY_EXPECT <", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT <=", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLike(String value) {
            addCriterion("INDUSTRY_EXPECT like", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotLike(String value) {
            addCriterion("INDUSTRY_EXPECT not like", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectIn(List<String> values) {
            addCriterion("INDUSTRY_EXPECT in", values, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotIn(List<String> values) {
            addCriterion("INDUSTRY_EXPECT not in", values, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectBetween(String value1, String value2) {
            addCriterion("INDUSTRY_EXPECT between", value1, value2, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_EXPECT not between", value1, value2, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectIsNull() {
            addCriterion("JOBTYPE_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectIsNotNull() {
            addCriterion("JOBTYPE_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT =", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT <>", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectGreaterThan(String value) {
            addCriterion("JOBTYPE_EXPECT >", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectGreaterThanOrEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT >=", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLessThan(String value) {
            addCriterion("JOBTYPE_EXPECT <", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLessThanOrEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT <=", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLike(String value) {
            addCriterion("JOBTYPE_EXPECT like", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotLike(String value) {
            addCriterion("JOBTYPE_EXPECT not like", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectIn(List<String> values) {
            addCriterion("JOBTYPE_EXPECT in", values, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotIn(List<String> values) {
            addCriterion("JOBTYPE_EXPECT not in", values, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectBetween(String value1, String value2) {
            addCriterion("JOBTYPE_EXPECT between", value1, value2, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotBetween(String value1, String value2) {
            addCriterion("JOBTYPE_EXPECT not between", value1, value2, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectIsNull() {
            addCriterion("POST_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andPostExpectIsNotNull() {
            addCriterion("POST_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andPostExpectEqualTo(String value) {
            addCriterion("POST_EXPECT =", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotEqualTo(String value) {
            addCriterion("POST_EXPECT <>", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectGreaterThan(String value) {
            addCriterion("POST_EXPECT >", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectGreaterThanOrEqualTo(String value) {
            addCriterion("POST_EXPECT >=", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLessThan(String value) {
            addCriterion("POST_EXPECT <", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLessThanOrEqualTo(String value) {
            addCriterion("POST_EXPECT <=", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLike(String value) {
            addCriterion("POST_EXPECT like", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotLike(String value) {
            addCriterion("POST_EXPECT not like", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectIn(List<String> values) {
            addCriterion("POST_EXPECT in", values, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotIn(List<String> values) {
            addCriterion("POST_EXPECT not in", values, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectBetween(String value1, String value2) {
            addCriterion("POST_EXPECT between", value1, value2, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotBetween(String value1, String value2) {
            addCriterion("POST_EXPECT not between", value1, value2, "postExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectIsNull() {
            addCriterion("SALARY_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectIsNotNull() {
            addCriterion("SALARY_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectEqualTo(String value) {
            addCriterion("SALARY_EXPECT =", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotEqualTo(String value) {
            addCriterion("SALARY_EXPECT <>", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectGreaterThan(String value) {
            addCriterion("SALARY_EXPECT >", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectGreaterThanOrEqualTo(String value) {
            addCriterion("SALARY_EXPECT >=", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLessThan(String value) {
            addCriterion("SALARY_EXPECT <", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLessThanOrEqualTo(String value) {
            addCriterion("SALARY_EXPECT <=", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLike(String value) {
            addCriterion("SALARY_EXPECT like", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotLike(String value) {
            addCriterion("SALARY_EXPECT not like", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectIn(List<String> values) {
            addCriterion("SALARY_EXPECT in", values, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotIn(List<String> values) {
            addCriterion("SALARY_EXPECT not in", values, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectBetween(String value1, String value2) {
            addCriterion("SALARY_EXPECT between", value1, value2, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotBetween(String value1, String value2) {
            addCriterion("SALARY_EXPECT not between", value1, value2, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeIsNull() {
            addCriterion("RPEORT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeIsNotNull() {
            addCriterion("RPEORT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeEqualTo(String value) {
            addCriterion("RPEORT_TIME =", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeNotEqualTo(String value) {
            addCriterion("RPEORT_TIME <>", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeGreaterThan(String value) {
            addCriterion("RPEORT_TIME >", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeGreaterThanOrEqualTo(String value) {
            addCriterion("RPEORT_TIME >=", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeLessThan(String value) {
            addCriterion("RPEORT_TIME <", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeLessThanOrEqualTo(String value) {
            addCriterion("RPEORT_TIME <=", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeLike(String value) {
            addCriterion("RPEORT_TIME like", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeNotLike(String value) {
            addCriterion("RPEORT_TIME not like", value, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeIn(List<String> values) {
            addCriterion("RPEORT_TIME in", values, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeNotIn(List<String> values) {
            addCriterion("RPEORT_TIME not in", values, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeBetween(String value1, String value2) {
            addCriterion("RPEORT_TIME between", value1, value2, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeNotBetween(String value1, String value2) {
            addCriterion("RPEORT_TIME not between", value1, value2, "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("CURRENCY =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("CURRENCY <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("CURRENCY >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("CURRENCY <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("CURRENCY like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("CURRENCY not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("CURRENCY in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("CURRENCY not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("CURRENCY between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("CURRENCY not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNull() {
            addCriterion("RESUME_ID is null");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNotNull() {
            addCriterion("RESUME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResumeIdEqualTo(String value) {
            addCriterion("RESUME_ID =", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotEqualTo(String value) {
            addCriterion("RESUME_ID <>", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThan(String value) {
            addCriterion("RESUME_ID >", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThanOrEqualTo(String value) {
            addCriterion("RESUME_ID >=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThan(String value) {
            addCriterion("RESUME_ID <", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThanOrEqualTo(String value) {
            addCriterion("RESUME_ID <=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLike(String value) {
            addCriterion("RESUME_ID like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotLike(String value) {
            addCriterion("RESUME_ID not like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdIn(List<String> values) {
            addCriterion("RESUME_ID in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotIn(List<String> values) {
            addCriterion("RESUME_ID not in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdBetween(String value1, String value2) {
            addCriterion("RESUME_ID between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotBetween(String value1, String value2) {
            addCriterion("RESUME_ID not between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLikeInsensitive(String value) {
            addCriterion("upper(WORKPLACE_EXPECT) like", value.toUpperCase(), "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLikeInsensitive(String value) {
            addCriterion("upper(INDUSTRY_EXPECT) like", value.toUpperCase(), "industryExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLikeInsensitive(String value) {
            addCriterion("upper(JOBTYPE_EXPECT) like", value.toUpperCase(), "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLikeInsensitive(String value) {
            addCriterion("upper(POST_EXPECT) like", value.toUpperCase(), "postExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLikeInsensitive(String value) {
            addCriterion("upper(SALARY_EXPECT) like", value.toUpperCase(), "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andRpeortTimeLikeInsensitive(String value) {
            addCriterion("upper(RPEORT_TIME) like", value.toUpperCase(), "rpeortTime");
            return (Criteria) this;
        }

        public Criteria andCurrencyLikeInsensitive(String value) {
            addCriterion("upper(CURRENCY) like", value.toUpperCase(), "currency");
            return (Criteria) this;
        }

        public Criteria andResumeIdLikeInsensitive(String value) {
            addCriterion("upper(RESUME_ID) like", value.toUpperCase(), "resumeId");
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