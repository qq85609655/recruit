package com.csot.recruit.model.original.candidate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CandidatePostCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CandidatePostCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCandidateIdIsNull() {
            addCriterion("CANDIDATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIsNotNull() {
            addCriterion("CANDIDATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdEqualTo(String value) {
            addCriterion("CANDIDATE_ID =", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotEqualTo(String value) {
            addCriterion("CANDIDATE_ID <>", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThan(String value) {
            addCriterion("CANDIDATE_ID >", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ID >=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThan(String value) {
            addCriterion("CANDIDATE_ID <", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ID <=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLike(String value) {
            addCriterion("CANDIDATE_ID like", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotLike(String value) {
            addCriterion("CANDIDATE_ID not like", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIn(List<String> values) {
            addCriterion("CANDIDATE_ID in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotIn(List<String> values) {
            addCriterion("CANDIDATE_ID not in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ID between", value1, value2, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ID not between", value1, value2, "candidateId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIsNull() {
            addCriterion("OPERATOR_USER is null");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIsNotNull() {
            addCriterion("OPERATOR_USER is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorUserEqualTo(String value) {
            addCriterion("OPERATOR_USER =", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotEqualTo(String value) {
            addCriterion("OPERATOR_USER <>", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserGreaterThan(String value) {
            addCriterion("OPERATOR_USER >", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_USER >=", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLessThan(String value) {
            addCriterion("OPERATOR_USER <", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_USER <=", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLike(String value) {
            addCriterion("OPERATOR_USER like", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotLike(String value) {
            addCriterion("OPERATOR_USER not like", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIn(List<String> values) {
            addCriterion("OPERATOR_USER in", values, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotIn(List<String> values) {
            addCriterion("OPERATOR_USER not in", values, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserBetween(String value1, String value2) {
            addCriterion("OPERATOR_USER between", value1, value2, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_USER not between", value1, value2, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("POSITION_ID is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("POSITION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("POSITION_ID =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("POSITION_ID <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("POSITION_ID >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION_ID >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("POSITION_ID <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("POSITION_ID <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("POSITION_ID like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("POSITION_ID not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("POSITION_ID in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("POSITION_ID not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("POSITION_ID between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("POSITION_ID not between", value1, value2, "positionId");
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

        public Criteria andOperatorDateIsNull() {
            addCriterion("OPERATOR_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOperatorDateIsNotNull() {
            addCriterion("OPERATOR_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorDateEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_DATE =", value, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_DATE <>", value, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateGreaterThan(Date value) {
            addCriterionForJDBCDate("OPERATOR_DATE >", value, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_DATE >=", value, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateLessThan(Date value) {
            addCriterionForJDBCDate("OPERATOR_DATE <", value, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_DATE <=", value, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATOR_DATE in", values, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATOR_DATE not in", values, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATOR_DATE between", value1, value2, "operatorDate");
            return (Criteria) this;
        }

        public Criteria andOperatorDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATOR_DATE not between", value1, value2, "operatorDate");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_ID) like", value.toUpperCase(), "candidateId");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLikeInsensitive(String value) {
            addCriterion("upper(OPERATOR_USER) like", value.toUpperCase(), "operatorUser");
            return (Criteria) this;
        }

        public Criteria andPositionIdLikeInsensitive(String value) {
            addCriterion("upper(POSITION_ID) like", value.toUpperCase(), "positionId");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_STATUS) like", value.toUpperCase(), "interviewStatus");
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