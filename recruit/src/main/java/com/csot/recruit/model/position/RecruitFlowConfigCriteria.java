package com.csot.recruit.model.position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RecruitFlowConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RecruitFlowConfigCriteria() {
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

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonIsNull() {
            addCriterion("RECRUIT_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonIsNotNull() {
            addCriterion("RECRUIT_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonEqualTo(String value) {
            addCriterion("RECRUIT_PERSON =", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonNotEqualTo(String value) {
            addCriterion("RECRUIT_PERSON <>", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonGreaterThan(String value) {
            addCriterion("RECRUIT_PERSON >", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUIT_PERSON >=", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonLessThan(String value) {
            addCriterion("RECRUIT_PERSON <", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonLessThanOrEqualTo(String value) {
            addCriterion("RECRUIT_PERSON <=", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonLike(String value) {
            addCriterion("RECRUIT_PERSON like", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonNotLike(String value) {
            addCriterion("RECRUIT_PERSON not like", value, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonIn(List<String> values) {
            addCriterion("RECRUIT_PERSON in", values, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonNotIn(List<String> values) {
            addCriterion("RECRUIT_PERSON not in", values, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonBetween(String value1, String value2) {
            addCriterion("RECRUIT_PERSON between", value1, value2, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonNotBetween(String value1, String value2) {
            addCriterion("RECRUIT_PERSON not between", value1, value2, "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherIsNull() {
            addCriterion("RECRUIT_PERSON_OTHER is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherIsNotNull() {
            addCriterion("RECRUIT_PERSON_OTHER is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherEqualTo(String value) {
            addCriterion("RECRUIT_PERSON_OTHER =", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherNotEqualTo(String value) {
            addCriterion("RECRUIT_PERSON_OTHER <>", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherGreaterThan(String value) {
            addCriterion("RECRUIT_PERSON_OTHER >", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUIT_PERSON_OTHER >=", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherLessThan(String value) {
            addCriterion("RECRUIT_PERSON_OTHER <", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherLessThanOrEqualTo(String value) {
            addCriterion("RECRUIT_PERSON_OTHER <=", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherLike(String value) {
            addCriterion("RECRUIT_PERSON_OTHER like", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherNotLike(String value) {
            addCriterion("RECRUIT_PERSON_OTHER not like", value, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherIn(List<String> values) {
            addCriterion("RECRUIT_PERSON_OTHER in", values, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherNotIn(List<String> values) {
            addCriterion("RECRUIT_PERSON_OTHER not in", values, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherBetween(String value1, String value2) {
            addCriterion("RECRUIT_PERSON_OTHER between", value1, value2, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherNotBetween(String value1, String value2) {
            addCriterion("RECRUIT_PERSON_OTHER not between", value1, value2, "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerIsNull() {
            addCriterion("DEMAND_DEP_OWNER is null");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerIsNotNull() {
            addCriterion("DEMAND_DEP_OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerEqualTo(String value) {
            addCriterion("DEMAND_DEP_OWNER =", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerNotEqualTo(String value) {
            addCriterion("DEMAND_DEP_OWNER <>", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerGreaterThan(String value) {
            addCriterion("DEMAND_DEP_OWNER >", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("DEMAND_DEP_OWNER >=", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerLessThan(String value) {
            addCriterion("DEMAND_DEP_OWNER <", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerLessThanOrEqualTo(String value) {
            addCriterion("DEMAND_DEP_OWNER <=", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerLike(String value) {
            addCriterion("DEMAND_DEP_OWNER like", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerNotLike(String value) {
            addCriterion("DEMAND_DEP_OWNER not like", value, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerIn(List<String> values) {
            addCriterion("DEMAND_DEP_OWNER in", values, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerNotIn(List<String> values) {
            addCriterion("DEMAND_DEP_OWNER not in", values, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerBetween(String value1, String value2) {
            addCriterion("DEMAND_DEP_OWNER between", value1, value2, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerNotBetween(String value1, String value2) {
            addCriterion("DEMAND_DEP_OWNER not between", value1, value2, "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNull() {
            addCriterion("RECEIVE_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNotNull() {
            addCriterion("RECEIVE_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL =", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL <>", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThan(String value) {
            addCriterion("RECEIVE_EMAIL >", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL >=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThan(String value) {
            addCriterion("RECEIVE_EMAIL <", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL <=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLike(String value) {
            addCriterion("RECEIVE_EMAIL like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotLike(String value) {
            addCriterion("RECEIVE_EMAIL not like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIn(List<String> values) {
            addCriterion("RECEIVE_EMAIL in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotIn(List<String> values) {
            addCriterion("RECEIVE_EMAIL not in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailBetween(String value1, String value2) {
            addCriterion("RECEIVE_EMAIL between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_EMAIL not between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateIsNull() {
            addCriterion("INTERVIEW_TEMPLATE is null");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateIsNotNull() {
            addCriterion("INTERVIEW_TEMPLATE is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateEqualTo(String value) {
            addCriterion("INTERVIEW_TEMPLATE =", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateNotEqualTo(String value) {
            addCriterion("INTERVIEW_TEMPLATE <>", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateGreaterThan(String value) {
            addCriterion("INTERVIEW_TEMPLATE >", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_TEMPLATE >=", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateLessThan(String value) {
            addCriterion("INTERVIEW_TEMPLATE <", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_TEMPLATE <=", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateLike(String value) {
            addCriterion("INTERVIEW_TEMPLATE like", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateNotLike(String value) {
            addCriterion("INTERVIEW_TEMPLATE not like", value, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateIn(List<String> values) {
            addCriterion("INTERVIEW_TEMPLATE in", values, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateNotIn(List<String> values) {
            addCriterion("INTERVIEW_TEMPLATE not in", values, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateBetween(String value1, String value2) {
            addCriterion("INTERVIEW_TEMPLATE between", value1, value2, "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_TEMPLATE not between", value1, value2, "interviewTemplate");
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

        public Criteria andRecruitPositionIdIsNull() {
            addCriterion("RECRUIT_POSITION_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNotNull() {
            addCriterion("RECRUIT_POSITION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID =", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID <>", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThan(String value) {
            addCriterion("RECRUIT_POSITION_ID >", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID >=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThan(String value) {
            addCriterion("RECRUIT_POSITION_ID <", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThanOrEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID <=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLike(String value) {
            addCriterion("RECRUIT_POSITION_ID like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotLike(String value) {
            addCriterion("RECRUIT_POSITION_ID not like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIn(List<String> values) {
            addCriterion("RECRUIT_POSITION_ID in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotIn(List<String> values) {
            addCriterion("RECRUIT_POSITION_ID not in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdBetween(String value1, String value2) {
            addCriterion("RECRUIT_POSITION_ID between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotBetween(String value1, String value2) {
            addCriterion("RECRUIT_POSITION_ID not between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_PERSON) like", value.toUpperCase(), "recruitPerson");
            return (Criteria) this;
        }

        public Criteria andRecruitPersonOtherLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_PERSON_OTHER) like", value.toUpperCase(), "recruitPersonOther");
            return (Criteria) this;
        }

        public Criteria andDemandDepOwnerLikeInsensitive(String value) {
            addCriterion("upper(DEMAND_DEP_OWNER) like", value.toUpperCase(), "demandDepOwner");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLikeInsensitive(String value) {
            addCriterion("upper(RECEIVE_EMAIL) like", value.toUpperCase(), "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andInterviewTemplateLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_TEMPLATE) like", value.toUpperCase(), "interviewTemplate");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_POSITION_ID) like", value.toUpperCase(), "recruitPositionId");
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