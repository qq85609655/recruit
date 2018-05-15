package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class LanguageSkillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public LanguageSkillCriteria() {
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

        public Criteria andLanguageNameIsNull() {
            addCriterion("LANGUAGE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLanguageNameIsNotNull() {
            addCriterion("LANGUAGE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageNameEqualTo(String value) {
            addCriterion("LANGUAGE_NAME =", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameNotEqualTo(String value) {
            addCriterion("LANGUAGE_NAME <>", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameGreaterThan(String value) {
            addCriterion("LANGUAGE_NAME >", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUAGE_NAME >=", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameLessThan(String value) {
            addCriterion("LANGUAGE_NAME <", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameLessThanOrEqualTo(String value) {
            addCriterion("LANGUAGE_NAME <=", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameLike(String value) {
            addCriterion("LANGUAGE_NAME like", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameNotLike(String value) {
            addCriterion("LANGUAGE_NAME not like", value, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameIn(List<String> values) {
            addCriterion("LANGUAGE_NAME in", values, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameNotIn(List<String> values) {
            addCriterion("LANGUAGE_NAME not in", values, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameBetween(String value1, String value2) {
            addCriterion("LANGUAGE_NAME between", value1, value2, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageNameNotBetween(String value1, String value2) {
            addCriterion("LANGUAGE_NAME not between", value1, value2, "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelIsNull() {
            addCriterion("LANGUAGE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelIsNotNull() {
            addCriterion("LANGUAGE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelEqualTo(String value) {
            addCriterion("LANGUAGE_LEVEL =", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelNotEqualTo(String value) {
            addCriterion("LANGUAGE_LEVEL <>", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelGreaterThan(String value) {
            addCriterion("LANGUAGE_LEVEL >", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUAGE_LEVEL >=", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelLessThan(String value) {
            addCriterion("LANGUAGE_LEVEL <", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelLessThanOrEqualTo(String value) {
            addCriterion("LANGUAGE_LEVEL <=", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelLike(String value) {
            addCriterion("LANGUAGE_LEVEL like", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelNotLike(String value) {
            addCriterion("LANGUAGE_LEVEL not like", value, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelIn(List<String> values) {
            addCriterion("LANGUAGE_LEVEL in", values, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelNotIn(List<String> values) {
            addCriterion("LANGUAGE_LEVEL not in", values, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelBetween(String value1, String value2) {
            addCriterion("LANGUAGE_LEVEL between", value1, value2, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelNotBetween(String value1, String value2) {
            addCriterion("LANGUAGE_LEVEL not between", value1, value2, "languageLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelIsNull() {
            addCriterion("ORAL_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andOralLevelIsNotNull() {
            addCriterion("ORAL_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andOralLevelEqualTo(String value) {
            addCriterion("ORAL_LEVEL =", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelNotEqualTo(String value) {
            addCriterion("ORAL_LEVEL <>", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelGreaterThan(String value) {
            addCriterion("ORAL_LEVEL >", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelGreaterThanOrEqualTo(String value) {
            addCriterion("ORAL_LEVEL >=", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelLessThan(String value) {
            addCriterion("ORAL_LEVEL <", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelLessThanOrEqualTo(String value) {
            addCriterion("ORAL_LEVEL <=", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelLike(String value) {
            addCriterion("ORAL_LEVEL like", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelNotLike(String value) {
            addCriterion("ORAL_LEVEL not like", value, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelIn(List<String> values) {
            addCriterion("ORAL_LEVEL in", values, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelNotIn(List<String> values) {
            addCriterion("ORAL_LEVEL not in", values, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelBetween(String value1, String value2) {
            addCriterion("ORAL_LEVEL between", value1, value2, "oralLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelNotBetween(String value1, String value2) {
            addCriterion("ORAL_LEVEL not between", value1, value2, "oralLevel");
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

        public Criteria andLanguageNameLikeInsensitive(String value) {
            addCriterion("upper(LANGUAGE_NAME) like", value.toUpperCase(), "languageName");
            return (Criteria) this;
        }

        public Criteria andLanguageLevelLikeInsensitive(String value) {
            addCriterion("upper(LANGUAGE_LEVEL) like", value.toUpperCase(), "languageLevel");
            return (Criteria) this;
        }

        public Criteria andOralLevelLikeInsensitive(String value) {
            addCriterion("upper(ORAL_LEVEL) like", value.toUpperCase(), "oralLevel");
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