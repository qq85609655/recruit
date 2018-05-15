package com.csot.recruit.model.position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RequireInforCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RequireInforCriteria() {
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

        public Criteria andAgeMinIsNull() {
            addCriterion("AGE_MIN is null");
            return (Criteria) this;
        }

        public Criteria andAgeMinIsNotNull() {
            addCriterion("AGE_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andAgeMinEqualTo(BigDecimal value) {
            addCriterion("AGE_MIN =", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotEqualTo(BigDecimal value) {
            addCriterion("AGE_MIN <>", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinGreaterThan(BigDecimal value) {
            addCriterion("AGE_MIN >", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE_MIN >=", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinLessThan(BigDecimal value) {
            addCriterion("AGE_MIN <", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE_MIN <=", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinIn(List<BigDecimal> values) {
            addCriterion("AGE_MIN in", values, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotIn(List<BigDecimal> values) {
            addCriterion("AGE_MIN not in", values, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE_MIN between", value1, value2, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE_MIN not between", value1, value2, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIsNull() {
            addCriterion("AGE_MAX is null");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIsNotNull() {
            addCriterion("AGE_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andAgeMaxEqualTo(BigDecimal value) {
            addCriterion("AGE_MAX =", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotEqualTo(BigDecimal value) {
            addCriterion("AGE_MAX <>", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxGreaterThan(BigDecimal value) {
            addCriterion("AGE_MAX >", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE_MAX >=", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxLessThan(BigDecimal value) {
            addCriterion("AGE_MAX <", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE_MAX <=", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIn(List<BigDecimal> values) {
            addCriterion("AGE_MAX in", values, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotIn(List<BigDecimal> values) {
            addCriterion("AGE_MAX not in", values, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE_MAX between", value1, value2, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE_MAX not between", value1, value2, "ageMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinIsNull() {
            addCriterion("WORK_EXPERIENCE_MIN is null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinIsNotNull() {
            addCriterion("WORK_EXPERIENCE_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MIN =", value, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinNotEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MIN <>", value, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinGreaterThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MIN >", value, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MIN >=", value, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinLessThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MIN <", value, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MIN <=", value, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE_MIN in", values, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinNotIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE_MIN not in", values, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE_MIN between", value1, value2, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE_MIN not between", value1, value2, "workExperienceMin");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxIsNull() {
            addCriterion("WORK_EXPERIENCE_MAX is null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxIsNotNull() {
            addCriterion("WORK_EXPERIENCE_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MAX =", value, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxNotEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MAX <>", value, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxGreaterThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MAX >", value, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MAX >=", value, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxLessThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MAX <", value, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE_MAX <=", value, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE_MAX in", values, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxNotIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE_MAX not in", values, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE_MAX between", value1, value2, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE_MAX not between", value1, value2, "workExperienceMax");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelIsNull() {
            addCriterion("ENGLISH_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelIsNotNull() {
            addCriterion("ENGLISH_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelEqualTo(BigDecimal value) {
            addCriterion("ENGLISH_LEVEL =", value, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotEqualTo(BigDecimal value) {
            addCriterion("ENGLISH_LEVEL <>", value, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelGreaterThan(BigDecimal value) {
            addCriterion("ENGLISH_LEVEL >", value, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENGLISH_LEVEL >=", value, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelLessThan(BigDecimal value) {
            addCriterion("ENGLISH_LEVEL <", value, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENGLISH_LEVEL <=", value, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelIn(List<BigDecimal> values) {
            addCriterion("ENGLISH_LEVEL in", values, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotIn(List<BigDecimal> values) {
            addCriterion("ENGLISH_LEVEL not in", values, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENGLISH_LEVEL between", value1, value2, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENGLISH_LEVEL not between", value1, value2, "englishLevel");
            return (Criteria) this;
        }

        public Criteria andEducationMinIsNull() {
            addCriterion("EDUCATION_MIN is null");
            return (Criteria) this;
        }

        public Criteria andEducationMinIsNotNull() {
            addCriterion("EDUCATION_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andEducationMinEqualTo(String value) {
            addCriterion("EDUCATION_MIN =", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinNotEqualTo(String value) {
            addCriterion("EDUCATION_MIN <>", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinGreaterThan(String value) {
            addCriterion("EDUCATION_MIN >", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinGreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_MIN >=", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinLessThan(String value) {
            addCriterion("EDUCATION_MIN <", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinLessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_MIN <=", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinLike(String value) {
            addCriterion("EDUCATION_MIN like", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinNotLike(String value) {
            addCriterion("EDUCATION_MIN not like", value, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinIn(List<String> values) {
            addCriterion("EDUCATION_MIN in", values, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinNotIn(List<String> values) {
            addCriterion("EDUCATION_MIN not in", values, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinBetween(String value1, String value2) {
            addCriterion("EDUCATION_MIN between", value1, value2, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMinNotBetween(String value1, String value2) {
            addCriterion("EDUCATION_MIN not between", value1, value2, "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMaxIsNull() {
            addCriterion("EDUCATION_MAX is null");
            return (Criteria) this;
        }

        public Criteria andEducationMaxIsNotNull() {
            addCriterion("EDUCATION_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andEducationMaxEqualTo(String value) {
            addCriterion("EDUCATION_MAX =", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxNotEqualTo(String value) {
            addCriterion("EDUCATION_MAX <>", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxGreaterThan(String value) {
            addCriterion("EDUCATION_MAX >", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxGreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_MAX >=", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxLessThan(String value) {
            addCriterion("EDUCATION_MAX <", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxLessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_MAX <=", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxLike(String value) {
            addCriterion("EDUCATION_MAX like", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxNotLike(String value) {
            addCriterion("EDUCATION_MAX not like", value, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxIn(List<String> values) {
            addCriterion("EDUCATION_MAX in", values, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxNotIn(List<String> values) {
            addCriterion("EDUCATION_MAX not in", values, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxBetween(String value1, String value2) {
            addCriterion("EDUCATION_MAX between", value1, value2, "educationMax");
            return (Criteria) this;
        }

        public Criteria andEducationMaxNotBetween(String value1, String value2) {
            addCriterion("EDUCATION_MAX not between", value1, value2, "educationMax");
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

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(BigDecimal value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(BigDecimal value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(BigDecimal value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(BigDecimal value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<BigDecimal> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<BigDecimal> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeNotIsNull() {
            addCriterion("AGE_NOT is null");
            return (Criteria) this;
        }

        public Criteria andAgeNotIsNotNull() {
            addCriterion("AGE_NOT is not null");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("AGE_NOT =", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotNotEqualTo(String value) {
            addCriterion("AGE_NOT <>", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotGreaterThan(String value) {
            addCriterion("AGE_NOT >", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotGreaterThanOrEqualTo(String value) {
            addCriterion("AGE_NOT >=", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotLessThan(String value) {
            addCriterion("AGE_NOT <", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotLessThanOrEqualTo(String value) {
            addCriterion("AGE_NOT <=", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("AGE_NOT like", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotNotLike(String value) {
            addCriterion("AGE_NOT not like", value, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("AGE_NOT in", values, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotNotIn(List<String> values) {
            addCriterion("AGE_NOT not in", values, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("AGE_NOT between", value1, value2, "ageNot");
            return (Criteria) this;
        }

        public Criteria andAgeNotNotBetween(String value1, String value2) {
            addCriterion("AGE_NOT not between", value1, value2, "ageNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotIsNull() {
            addCriterion("WORK_EXPERIENCE_NOT is null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotIsNotNull() {
            addCriterion("WORK_EXPERIENCE_NOT is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotEqualTo(String value) {
            addCriterion("WORK_EXPERIENCE_NOT =", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotNotEqualTo(String value) {
            addCriterion("WORK_EXPERIENCE_NOT <>", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotGreaterThan(String value) {
            addCriterion("WORK_EXPERIENCE_NOT >", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_EXPERIENCE_NOT >=", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotLessThan(String value) {
            addCriterion("WORK_EXPERIENCE_NOT <", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotLessThanOrEqualTo(String value) {
            addCriterion("WORK_EXPERIENCE_NOT <=", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotLike(String value) {
            addCriterion("WORK_EXPERIENCE_NOT like", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotNotLike(String value) {
            addCriterion("WORK_EXPERIENCE_NOT not like", value, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotIn(List<String> values) {
            addCriterion("WORK_EXPERIENCE_NOT in", values, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotNotIn(List<String> values) {
            addCriterion("WORK_EXPERIENCE_NOT not in", values, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotBetween(String value1, String value2) {
            addCriterion("WORK_EXPERIENCE_NOT between", value1, value2, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotNotBetween(String value1, String value2) {
            addCriterion("WORK_EXPERIENCE_NOT not between", value1, value2, "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotIsNull() {
            addCriterion("ENGLISH_LEVEL_NOT is null");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotIsNotNull() {
            addCriterion("ENGLISH_LEVEL_NOT is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotEqualTo(String value) {
            addCriterion("ENGLISH_LEVEL_NOT =", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotNotEqualTo(String value) {
            addCriterion("ENGLISH_LEVEL_NOT <>", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotGreaterThan(String value) {
            addCriterion("ENGLISH_LEVEL_NOT >", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_LEVEL_NOT >=", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotLessThan(String value) {
            addCriterion("ENGLISH_LEVEL_NOT <", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_LEVEL_NOT <=", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotLike(String value) {
            addCriterion("ENGLISH_LEVEL_NOT like", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotNotLike(String value) {
            addCriterion("ENGLISH_LEVEL_NOT not like", value, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotNotIn(List<String> values) {
            addCriterion("ENGLISH_LEVEL_NOT not in", values, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_LEVEL_NOT between", value1, value2, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_LEVEL_NOT not between", value1, value2, "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotIsNull() {
            addCriterion("EDUCATION_NOT is null");
            return (Criteria) this;
        }

        public Criteria andEducationNotIsNotNull() {
            addCriterion("EDUCATION_NOT is not null");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("EDUCATION_NOT =", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotNotEqualTo(String value) {
            addCriterion("EDUCATION_NOT <>", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotGreaterThan(String value) {
            addCriterion("EDUCATION_NOT >", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotGreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_NOT >=", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotLessThan(String value) {
            addCriterion("EDUCATION_NOT <", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotLessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_NOT <=", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("EDUCATION_NOT like", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotNotLike(String value) {
            addCriterion("EDUCATION_NOT not like", value, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("EDUCATION_NOT in", values, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotNotIn(List<String> values) {
            addCriterion("EDUCATION_NOT not in", values, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("EDUCATION_NOT between", value1, value2, "educationNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotNotBetween(String value1, String value2) {
            addCriterion("EDUCATION_NOT not between", value1, value2, "educationNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotIsNull() {
            addCriterion("AGENDER_NOT is null");
            return (Criteria) this;
        }

        public Criteria andAgenderNotIsNotNull() {
            addCriterion("AGENDER_NOT is not null");
            return (Criteria) this;
        }

        public Criteria andAgenderNotEqualTo(String value) {
            addCriterion("AGENDER_NOT =", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotNotEqualTo(String value) {
            addCriterion("AGENDER_NOT <>", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotGreaterThan(String value) {
            addCriterion("AGENDER_NOT >", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotGreaterThanOrEqualTo(String value) {
            addCriterion("AGENDER_NOT >=", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotLessThan(String value) {
            addCriterion("AGENDER_NOT <", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotLessThanOrEqualTo(String value) {
            addCriterion("AGENDER_NOT <=", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotLike(String value) {
            addCriterion("AGENDER_NOT like", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotNotLike(String value) {
            addCriterion("AGENDER_NOT not like", value, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotIn(List<String> values) {
            addCriterion("AGENDER_NOT in", values, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotNotIn(List<String> values) {
            addCriterion("AGENDER_NOT not in", values, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotBetween(String value1, String value2) {
            addCriterion("AGENDER_NOT between", value1, value2, "agenderNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotNotBetween(String value1, String value2) {
            addCriterion("AGENDER_NOT not between", value1, value2, "agenderNot");
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

        public Criteria andEducationMinLikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_MIN) like", value.toUpperCase(), "educationMin");
            return (Criteria) this;
        }

        public Criteria andEducationMaxLikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_MAX) like", value.toUpperCase(), "educationMax");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_POSITION_ID) like", value.toUpperCase(), "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andAgeNotLikeInsensitive(String value) {
            addCriterion("upper(AGE_NOT) like", value.toUpperCase(), "ageNot");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotLikeInsensitive(String value) {
            addCriterion("upper(WORK_EXPERIENCE_NOT) like", value.toUpperCase(), "workExperienceNot");
            return (Criteria) this;
        }

        public Criteria andEnglishLevelNotLikeInsensitive(String value) {
            addCriterion("upper(ENGLISH_LEVEL_NOT) like", value.toUpperCase(), "englishLevelNot");
            return (Criteria) this;
        }

        public Criteria andEducationNotLikeInsensitive(String value) {
            addCriterion("upper(EDUCATION_NOT) like", value.toUpperCase(), "educationNot");
            return (Criteria) this;
        }

        public Criteria andAgenderNotLikeInsensitive(String value) {
            addCriterion("upper(AGENDER_NOT) like", value.toUpperCase(), "agenderNot");
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