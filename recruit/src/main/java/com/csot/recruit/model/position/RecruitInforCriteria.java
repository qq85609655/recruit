package com.csot.recruit.model.position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RecruitInforCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RecruitInforCriteria() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecruiterIsNull() {
            addCriterion("recruiter is null");
            return (Criteria) this;
        }

        public Criteria andRecruiterIsNotNull() {
            addCriterion("recruiter is not null");
            return (Criteria) this;
        }

        public Criteria andRecruiterEqualTo(String value) {
            addCriterion("recruiter =", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterNotEqualTo(String value) {
            addCriterion("recruiter <>", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterGreaterThan(String value) {
            addCriterion("recruiter >", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterGreaterThanOrEqualTo(String value) {
            addCriterion("recruiter >=", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterLessThan(String value) {
            addCriterion("recruiter <", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterLessThanOrEqualTo(String value) {
            addCriterion("recruiter <=", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterLike(String value) {
            addCriterion("recruiter like", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterNotLike(String value) {
            addCriterion("recruiter not like", value, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterIn(List<String> values) {
            addCriterion("recruiter in", values, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterNotIn(List<String> values) {
            addCriterion("recruiter not in", values, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterBetween(String value1, String value2) {
            addCriterion("recruiter between", value1, value2, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterNotBetween(String value1, String value2) {
            addCriterion("recruiter not between", value1, value2, "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherIsNull() {
            addCriterion("recruiter_other is null");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherIsNotNull() {
            addCriterion("recruiter_other is not null");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherEqualTo(String value) {
            addCriterion("recruiter_other =", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherNotEqualTo(String value) {
            addCriterion("recruiter_other <>", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherGreaterThan(String value) {
            addCriterion("recruiter_other >", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherGreaterThanOrEqualTo(String value) {
            addCriterion("recruiter_other >=", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherLessThan(String value) {
            addCriterion("recruiter_other <", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherLessThanOrEqualTo(String value) {
            addCriterion("recruiter_other <=", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherLike(String value) {
            addCriterion("recruiter_other like", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherNotLike(String value) {
            addCriterion("recruiter_other not like", value, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherIn(List<String> values) {
            addCriterion("recruiter_other in", values, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherNotIn(List<String> values) {
            addCriterion("recruiter_other not in", values, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherBetween(String value1, String value2) {
            addCriterion("recruiter_other between", value1, value2, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherNotBetween(String value1, String value2) {
            addCriterion("recruiter_other not between", value1, value2, "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerIsNull() {
            addCriterion("department_manager is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerIsNotNull() {
            addCriterion("department_manager is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerEqualTo(String value) {
            addCriterion("department_manager =", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotEqualTo(String value) {
            addCriterion("department_manager <>", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerGreaterThan(String value) {
            addCriterion("department_manager >", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerGreaterThanOrEqualTo(String value) {
            addCriterion("department_manager >=", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerLessThan(String value) {
            addCriterion("department_manager <", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerLessThanOrEqualTo(String value) {
            addCriterion("department_manager <=", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerLike(String value) {
            addCriterion("department_manager like", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotLike(String value) {
            addCriterion("department_manager not like", value, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerIn(List<String> values) {
            addCriterion("department_manager in", values, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotIn(List<String> values) {
            addCriterion("department_manager not in", values, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerBetween(String value1, String value2) {
            addCriterion("department_manager between", value1, value2, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerNotBetween(String value1, String value2) {
            addCriterion("department_manager not between", value1, value2, "departmentManager");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNull() {
            addCriterion("receive_email is null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNotNull() {
            addCriterion("receive_email is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailEqualTo(String value) {
            addCriterion("receive_email =", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotEqualTo(String value) {
            addCriterion("receive_email <>", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThan(String value) {
            addCriterion("receive_email >", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThanOrEqualTo(String value) {
            addCriterion("receive_email >=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThan(String value) {
            addCriterion("receive_email <", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThanOrEqualTo(String value) {
            addCriterion("receive_email <=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLike(String value) {
            addCriterion("receive_email like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotLike(String value) {
            addCriterion("receive_email not like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIn(List<String> values) {
            addCriterion("receive_email in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotIn(List<String> values) {
            addCriterion("receive_email not in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailBetween(String value1, String value2) {
            addCriterion("receive_email between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotBetween(String value1, String value2) {
            addCriterion("receive_email not between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateIsNull() {
            addCriterion("interview_evaluate_template is null");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateIsNotNull() {
            addCriterion("interview_evaluate_template is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateEqualTo(BigDecimal value) {
            addCriterion("interview_evaluate_template =", value, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateNotEqualTo(BigDecimal value) {
            addCriterion("interview_evaluate_template <>", value, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateGreaterThan(BigDecimal value) {
            addCriterion("interview_evaluate_template >", value, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("interview_evaluate_template >=", value, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateLessThan(BigDecimal value) {
            addCriterion("interview_evaluate_template <", value, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("interview_evaluate_template <=", value, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateIn(List<BigDecimal> values) {
            addCriterion("interview_evaluate_template in", values, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateNotIn(List<BigDecimal> values) {
            addCriterion("interview_evaluate_template not in", values, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("interview_evaluate_template between", value1, value2, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewEvaluateTemplateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("interview_evaluate_template not between", value1, value2, "interviewEvaluateTemplate");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNull() {
            addCriterion("recruit_position_id is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNotNull() {
            addCriterion("recruit_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdEqualTo(String value) {
            addCriterion("recruit_position_id =", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotEqualTo(String value) {
            addCriterion("recruit_position_id <>", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThan(String value) {
            addCriterion("recruit_position_id >", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_position_id >=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThan(String value) {
            addCriterion("recruit_position_id <", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThanOrEqualTo(String value) {
            addCriterion("recruit_position_id <=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLike(String value) {
            addCriterion("recruit_position_id like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotLike(String value) {
            addCriterion("recruit_position_id not like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIn(List<String> values) {
            addCriterion("recruit_position_id in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotIn(List<String> values) {
            addCriterion("recruit_position_id not in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdBetween(String value1, String value2) {
            addCriterion("recruit_position_id between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotBetween(String value1, String value2) {
            addCriterion("recruit_position_id not between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruiterLikeInsensitive(String value) {
            addCriterion("upper(recruiter) like", value.toUpperCase(), "recruiter");
            return (Criteria) this;
        }

        public Criteria andRecruiterOtherLikeInsensitive(String value) {
            addCriterion("upper(recruiter_other) like", value.toUpperCase(), "recruiterOther");
            return (Criteria) this;
        }

        public Criteria andDepartmentManagerLikeInsensitive(String value) {
            addCriterion("upper(department_manager) like", value.toUpperCase(), "departmentManager");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLikeInsensitive(String value) {
            addCriterion("upper(receive_email) like", value.toUpperCase(), "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLikeInsensitive(String value) {
            addCriterion("upper(recruit_position_id) like", value.toUpperCase(), "recruitPositionId");
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