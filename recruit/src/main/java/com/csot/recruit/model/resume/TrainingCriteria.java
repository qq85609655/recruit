package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class TrainingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TrainingCriteria() {
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

        public Criteria andAchievedcertificationIsNull() {
            addCriterion("ACHIEVEDCERTIFICATION is null");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationIsNotNull() {
            addCriterion("ACHIEVEDCERTIFICATION is not null");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationEqualTo(String value) {
            addCriterion("ACHIEVEDCERTIFICATION =", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationNotEqualTo(String value) {
            addCriterion("ACHIEVEDCERTIFICATION <>", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationGreaterThan(String value) {
            addCriterion("ACHIEVEDCERTIFICATION >", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationGreaterThanOrEqualTo(String value) {
            addCriterion("ACHIEVEDCERTIFICATION >=", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationLessThan(String value) {
            addCriterion("ACHIEVEDCERTIFICATION <", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationLessThanOrEqualTo(String value) {
            addCriterion("ACHIEVEDCERTIFICATION <=", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationLike(String value) {
            addCriterion("ACHIEVEDCERTIFICATION like", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationNotLike(String value) {
            addCriterion("ACHIEVEDCERTIFICATION not like", value, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationIn(List<String> values) {
            addCriterion("ACHIEVEDCERTIFICATION in", values, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationNotIn(List<String> values) {
            addCriterion("ACHIEVEDCERTIFICATION not in", values, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationBetween(String value1, String value2) {
            addCriterion("ACHIEVEDCERTIFICATION between", value1, value2, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andAchievedcertificationNotBetween(String value1, String value2) {
            addCriterion("ACHIEVEDCERTIFICATION not between", value1, value2, "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andCourseIsNull() {
            addCriterion("COURSE is null");
            return (Criteria) this;
        }

        public Criteria andCourseIsNotNull() {
            addCriterion("COURSE is not null");
            return (Criteria) this;
        }

        public Criteria andCourseEqualTo(String value) {
            addCriterion("COURSE =", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotEqualTo(String value) {
            addCriterion("COURSE <>", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThan(String value) {
            addCriterion("COURSE >", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE >=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThan(String value) {
            addCriterion("COURSE <", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLessThanOrEqualTo(String value) {
            addCriterion("COURSE <=", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseLike(String value) {
            addCriterion("COURSE like", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotLike(String value) {
            addCriterion("COURSE not like", value, "course");
            return (Criteria) this;
        }

        public Criteria andCourseIn(List<String> values) {
            addCriterion("COURSE in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotIn(List<String> values) {
            addCriterion("COURSE not in", values, "course");
            return (Criteria) this;
        }

        public Criteria andCourseBetween(String value1, String value2) {
            addCriterion("COURSE between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andCourseNotBetween(String value1, String value2) {
            addCriterion("COURSE not between", value1, value2, "course");
            return (Criteria) this;
        }

        public Criteria andStartingdateIsNull() {
            addCriterion("STARTINGDATE is null");
            return (Criteria) this;
        }

        public Criteria andStartingdateIsNotNull() {
            addCriterion("STARTINGDATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartingdateEqualTo(Date value) {
            addCriterion("STARTINGDATE =", value, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateNotEqualTo(Date value) {
            addCriterion("STARTINGDATE <>", value, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateGreaterThan(Date value) {
            addCriterion("STARTINGDATE >", value, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateGreaterThanOrEqualTo(Date value) {
            addCriterion("STARTINGDATE >=", value, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateLessThan(Date value) {
            addCriterion("STARTINGDATE <", value, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateLessThanOrEqualTo(Date value) {
            addCriterion("STARTINGDATE <=", value, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateIn(List<Date> values) {
            addCriterion("STARTINGDATE in", values, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateNotIn(List<Date> values) {
            addCriterion("STARTINGDATE not in", values, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateBetween(Date value1, Date value2) {
            addCriterion("STARTINGDATE between", value1, value2, "startingdate");
            return (Criteria) this;
        }

        public Criteria andStartingdateNotBetween(Date value1, Date value2) {
            addCriterion("STARTINGDATE not between", value1, value2, "startingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateIsNull() {
            addCriterion("ENDINGDATE is null");
            return (Criteria) this;
        }

        public Criteria andEndingdateIsNotNull() {
            addCriterion("ENDINGDATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndingdateEqualTo(Date value) {
            addCriterion("ENDINGDATE =", value, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateNotEqualTo(Date value) {
            addCriterion("ENDINGDATE <>", value, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateGreaterThan(Date value) {
            addCriterion("ENDINGDATE >", value, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateGreaterThanOrEqualTo(Date value) {
            addCriterion("ENDINGDATE >=", value, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateLessThan(Date value) {
            addCriterion("ENDINGDATE <", value, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateLessThanOrEqualTo(Date value) {
            addCriterion("ENDINGDATE <=", value, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateIn(List<Date> values) {
            addCriterion("ENDINGDATE in", values, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateNotIn(List<Date> values) {
            addCriterion("ENDINGDATE not in", values, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateBetween(Date value1, Date value2) {
            addCriterion("ENDINGDATE between", value1, value2, "endingdate");
            return (Criteria) this;
        }

        public Criteria andEndingdateNotBetween(Date value1, Date value2) {
            addCriterion("ENDINGDATE not between", value1, value2, "endingdate");
            return (Criteria) this;
        }

        public Criteria andTraininglocationIsNull() {
            addCriterion("TRAININGLOCATION is null");
            return (Criteria) this;
        }

        public Criteria andTraininglocationIsNotNull() {
            addCriterion("TRAININGLOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andTraininglocationEqualTo(String value) {
            addCriterion("TRAININGLOCATION =", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationNotEqualTo(String value) {
            addCriterion("TRAININGLOCATION <>", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationGreaterThan(String value) {
            addCriterion("TRAININGLOCATION >", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationGreaterThanOrEqualTo(String value) {
            addCriterion("TRAININGLOCATION >=", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationLessThan(String value) {
            addCriterion("TRAININGLOCATION <", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationLessThanOrEqualTo(String value) {
            addCriterion("TRAININGLOCATION <=", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationLike(String value) {
            addCriterion("TRAININGLOCATION like", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationNotLike(String value) {
            addCriterion("TRAININGLOCATION not like", value, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationIn(List<String> values) {
            addCriterion("TRAININGLOCATION in", values, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationNotIn(List<String> values) {
            addCriterion("TRAININGLOCATION not in", values, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationBetween(String value1, String value2) {
            addCriterion("TRAININGLOCATION between", value1, value2, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininglocationNotBetween(String value1, String value2) {
            addCriterion("TRAININGLOCATION not between", value1, value2, "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionIsNull() {
            addCriterion("TRAININGINSTITUTION is null");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionIsNotNull() {
            addCriterion("TRAININGINSTITUTION is not null");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionEqualTo(String value) {
            addCriterion("TRAININGINSTITUTION =", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionNotEqualTo(String value) {
            addCriterion("TRAININGINSTITUTION <>", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionGreaterThan(String value) {
            addCriterion("TRAININGINSTITUTION >", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionGreaterThanOrEqualTo(String value) {
            addCriterion("TRAININGINSTITUTION >=", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionLessThan(String value) {
            addCriterion("TRAININGINSTITUTION <", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionLessThanOrEqualTo(String value) {
            addCriterion("TRAININGINSTITUTION <=", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionLike(String value) {
            addCriterion("TRAININGINSTITUTION like", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionNotLike(String value) {
            addCriterion("TRAININGINSTITUTION not like", value, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionIn(List<String> values) {
            addCriterion("TRAININGINSTITUTION in", values, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionNotIn(List<String> values) {
            addCriterion("TRAININGINSTITUTION not in", values, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionBetween(String value1, String value2) {
            addCriterion("TRAININGINSTITUTION between", value1, value2, "traininginstitution");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionNotBetween(String value1, String value2) {
            addCriterion("TRAININGINSTITUTION not between", value1, value2, "traininginstitution");
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

        public Criteria andAchievedcertificationLikeInsensitive(String value) {
            addCriterion("upper(ACHIEVEDCERTIFICATION) like", value.toUpperCase(), "achievedcertification");
            return (Criteria) this;
        }

        public Criteria andCourseLikeInsensitive(String value) {
            addCriterion("upper(COURSE) like", value.toUpperCase(), "course");
            return (Criteria) this;
        }

        public Criteria andTraininglocationLikeInsensitive(String value) {
            addCriterion("upper(TRAININGLOCATION) like", value.toUpperCase(), "traininglocation");
            return (Criteria) this;
        }

        public Criteria andTraininginstitutionLikeInsensitive(String value) {
            addCriterion("upper(TRAININGINSTITUTION) like", value.toUpperCase(), "traininginstitution");
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