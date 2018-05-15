package com.csot.recruit.model.original.candidate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CandidateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CandidateCriteria() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("NAME_EN =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("NAME_EN <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("NAME_EN >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_EN >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("NAME_EN <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("NAME_EN <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("NAME_EN like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("NAME_EN not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("NAME_EN in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("NAME_EN not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("NAME_EN between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("NAME_EN not between", value1, value2, "nameEn");
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

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(BigDecimal value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(BigDecimal value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(BigDecimal value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(BigDecimal value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<BigDecimal> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<BigDecimal> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNull() {
            addCriterion("POSITIONID is null");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNotNull() {
            addCriterion("POSITIONID is not null");
            return (Criteria) this;
        }

        public Criteria andPositionidEqualTo(String value) {
            addCriterion("POSITIONID =", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotEqualTo(String value) {
            addCriterion("POSITIONID <>", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThan(String value) {
            addCriterion("POSITIONID >", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThanOrEqualTo(String value) {
            addCriterion("POSITIONID >=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThan(String value) {
            addCriterion("POSITIONID <", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThanOrEqualTo(String value) {
            addCriterion("POSITIONID <=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLike(String value) {
            addCriterion("POSITIONID like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotLike(String value) {
            addCriterion("POSITIONID not like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidIn(List<String> values) {
            addCriterion("POSITIONID in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotIn(List<String> values) {
            addCriterion("POSITIONID not in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidBetween(String value1, String value2) {
            addCriterion("POSITIONID between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotBetween(String value1, String value2) {
            addCriterion("POSITIONID not between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIsNull() {
            addCriterion("CURRENT_COMPANY is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIsNotNull() {
            addCriterion("CURRENT_COMPANY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyEqualTo(String value) {
            addCriterion("CURRENT_COMPANY =", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotEqualTo(String value) {
            addCriterion("CURRENT_COMPANY <>", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyGreaterThan(String value) {
            addCriterion("CURRENT_COMPANY >", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_COMPANY >=", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLessThan(String value) {
            addCriterion("CURRENT_COMPANY <", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_COMPANY <=", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLike(String value) {
            addCriterion("CURRENT_COMPANY like", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotLike(String value) {
            addCriterion("CURRENT_COMPANY not like", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIn(List<String> values) {
            addCriterion("CURRENT_COMPANY in", values, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotIn(List<String> values) {
            addCriterion("CURRENT_COMPANY not in", values, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyBetween(String value1, String value2) {
            addCriterion("CURRENT_COMPANY between", value1, value2, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotBetween(String value1, String value2) {
            addCriterion("CURRENT_COMPANY not between", value1, value2, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionIsNull() {
            addCriterion("CURRENT_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionIsNotNull() {
            addCriterion("CURRENT_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionEqualTo(String value) {
            addCriterion("CURRENT_POSITION =", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotEqualTo(String value) {
            addCriterion("CURRENT_POSITION <>", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionGreaterThan(String value) {
            addCriterion("CURRENT_POSITION >", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_POSITION >=", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionLessThan(String value) {
            addCriterion("CURRENT_POSITION <", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_POSITION <=", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionLike(String value) {
            addCriterion("CURRENT_POSITION like", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotLike(String value) {
            addCriterion("CURRENT_POSITION not like", value, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionIn(List<String> values) {
            addCriterion("CURRENT_POSITION in", values, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotIn(List<String> values) {
            addCriterion("CURRENT_POSITION not in", values, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionBetween(String value1, String value2) {
            addCriterion("CURRENT_POSITION between", value1, value2, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionNotBetween(String value1, String value2) {
            addCriterion("CURRENT_POSITION not between", value1, value2, "currentPosition");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNull() {
            addCriterion("WORK_EXPERIENCE is null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNotNull() {
            addCriterion("WORK_EXPERIENCE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE =", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE <>", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE >", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE >=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE <", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE <=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE not in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE between", value1, value2, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE not between", value1, value2, "workExperience");
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

        public Criteria andGraduationSchoolIsNull() {
            addCriterion("GRADUATION_SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolIsNotNull() {
            addCriterion("GRADUATION_SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolEqualTo(String value) {
            addCriterion("GRADUATION_SCHOOL =", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotEqualTo(String value) {
            addCriterion("GRADUATION_SCHOOL <>", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolGreaterThan(String value) {
            addCriterion("GRADUATION_SCHOOL >", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("GRADUATION_SCHOOL >=", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolLessThan(String value) {
            addCriterion("GRADUATION_SCHOOL <", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolLessThanOrEqualTo(String value) {
            addCriterion("GRADUATION_SCHOOL <=", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolLike(String value) {
            addCriterion("GRADUATION_SCHOOL like", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotLike(String value) {
            addCriterion("GRADUATION_SCHOOL not like", value, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolIn(List<String> values) {
            addCriterion("GRADUATION_SCHOOL in", values, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotIn(List<String> values) {
            addCriterion("GRADUATION_SCHOOL not in", values, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolBetween(String value1, String value2) {
            addCriterion("GRADUATION_SCHOOL between", value1, value2, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolNotBetween(String value1, String value2) {
            addCriterion("GRADUATION_SCHOOL not between", value1, value2, "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNull() {
            addCriterion("PROFESSIONAL is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNotNull() {
            addCriterion("PROFESSIONAL is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalEqualTo(String value) {
            addCriterion("PROFESSIONAL =", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotEqualTo(String value) {
            addCriterion("PROFESSIONAL <>", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThan(String value) {
            addCriterion("PROFESSIONAL >", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("PROFESSIONAL >=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThan(String value) {
            addCriterion("PROFESSIONAL <", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThanOrEqualTo(String value) {
            addCriterion("PROFESSIONAL <=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLike(String value) {
            addCriterion("PROFESSIONAL like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotLike(String value) {
            addCriterion("PROFESSIONAL not like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalIn(List<String> values) {
            addCriterion("PROFESSIONAL in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotIn(List<String> values) {
            addCriterion("PROFESSIONAL not in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalBetween(String value1, String value2) {
            addCriterion("PROFESSIONAL between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotBetween(String value1, String value2) {
            addCriterion("PROFESSIONAL not between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
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

        public Criteria andResumeoriginIsNull() {
            addCriterion("RESUMEORIGIN is null");
            return (Criteria) this;
        }

        public Criteria andResumeoriginIsNotNull() {
            addCriterion("RESUMEORIGIN is not null");
            return (Criteria) this;
        }

        public Criteria andResumeoriginEqualTo(String value) {
            addCriterion("RESUMEORIGIN =", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotEqualTo(String value) {
            addCriterion("RESUMEORIGIN <>", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginGreaterThan(String value) {
            addCriterion("RESUMEORIGIN >", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginGreaterThanOrEqualTo(String value) {
            addCriterion("RESUMEORIGIN >=", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLessThan(String value) {
            addCriterion("RESUMEORIGIN <", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLessThanOrEqualTo(String value) {
            addCriterion("RESUMEORIGIN <=", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLike(String value) {
            addCriterion("RESUMEORIGIN like", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotLike(String value) {
            addCriterion("RESUMEORIGIN not like", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginIn(List<String> values) {
            addCriterion("RESUMEORIGIN in", values, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotIn(List<String> values) {
            addCriterion("RESUMEORIGIN not in", values, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginBetween(String value1, String value2) {
            addCriterion("RESUMEORIGIN between", value1, value2, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotBetween(String value1, String value2) {
            addCriterion("RESUMEORIGIN not between", value1, value2, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("CHANNEL <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("CHANNEL >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("CHANNEL <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("CHANNEL like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("CHANNEL not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("CHANNEL in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("CHANNEL not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("CHANNEL between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("CHANNEL not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andStorageDateIsNull() {
            addCriterion("STORAGE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStorageDateIsNotNull() {
            addCriterion("STORAGE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStorageDateEqualTo(Date value) {
            addCriterion("STORAGE_DATE =", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotEqualTo(Date value) {
            addCriterion("STORAGE_DATE <>", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateGreaterThan(Date value) {
            addCriterion("STORAGE_DATE >", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateGreaterThanOrEqualTo(Date value) {
            addCriterion("STORAGE_DATE >=", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateLessThan(Date value) {
            addCriterion("STORAGE_DATE <", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateLessThanOrEqualTo(Date value) {
            addCriterion("STORAGE_DATE <=", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateIn(List<Date> values) {
            addCriterion("STORAGE_DATE in", values, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotIn(List<Date> values) {
            addCriterion("STORAGE_DATE not in", values, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateBetween(Date value1, Date value2) {
            addCriterion("STORAGE_DATE between", value1, value2, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotBetween(Date value1, Date value2) {
            addCriterion("STORAGE_DATE not between", value1, value2, "storageDate");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIsNull() {
            addCriterion("RESUME_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIsNotNull() {
            addCriterion("RESUME_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andResumeStatusEqualTo(BigDecimal value) {
            addCriterion("RESUME_STATUS =", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotEqualTo(BigDecimal value) {
            addCriterion("RESUME_STATUS <>", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusGreaterThan(BigDecimal value) {
            addCriterion("RESUME_STATUS >", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RESUME_STATUS >=", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLessThan(BigDecimal value) {
            addCriterion("RESUME_STATUS <", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RESUME_STATUS <=", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIn(List<BigDecimal> values) {
            addCriterion("RESUME_STATUS in", values, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotIn(List<BigDecimal> values) {
            addCriterion("RESUME_STATUS not in", values, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESUME_STATUS between", value1, value2, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESUME_STATUS not between", value1, value2, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNull() {
            addCriterion("POST_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPostStatusIsNotNull() {
            addCriterion("POST_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPostStatusEqualTo(BigDecimal value) {
            addCriterion("POST_STATUS =", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotEqualTo(BigDecimal value) {
            addCriterion("POST_STATUS <>", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThan(BigDecimal value) {
            addCriterion("POST_STATUS >", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("POST_STATUS >=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThan(BigDecimal value) {
            addCriterion("POST_STATUS <", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("POST_STATUS <=", value, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusIn(List<BigDecimal> values) {
            addCriterion("POST_STATUS in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotIn(List<BigDecimal> values) {
            addCriterion("POST_STATUS not in", values, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POST_STATUS between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andPostStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("POST_STATUS not between", value1, value2, "postStatus");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNull() {
            addCriterion("CHANGE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNotNull() {
            addCriterion("CHANGE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeEqualTo(Date value) {
            addCriterion("CHANGE_TIME =", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotEqualTo(Date value) {
            addCriterion("CHANGE_TIME <>", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThan(Date value) {
            addCriterion("CHANGE_TIME >", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHANGE_TIME >=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThan(Date value) {
            addCriterion("CHANGE_TIME <", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHANGE_TIME <=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIn(List<Date> values) {
            addCriterion("CHANGE_TIME in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotIn(List<Date> values) {
            addCriterion("CHANGE_TIME not in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeBetween(Date value1, Date value2) {
            addCriterion("CHANGE_TIME between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHANGE_TIME not between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(NAME) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andNameEnLikeInsensitive(String value) {
            addCriterion("upper(NAME_EN) like", value.toUpperCase(), "nameEn");
            return (Criteria) this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(SEX) like", value.toUpperCase(), "sex");
            return (Criteria) this;
        }

        public Criteria andPositionidLikeInsensitive(String value) {
            addCriterion("upper(POSITIONID) like", value.toUpperCase(), "positionid");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLikeInsensitive(String value) {
            addCriterion("upper(CURRENT_COMPANY) like", value.toUpperCase(), "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentPositionLikeInsensitive(String value) {
            addCriterion("upper(CURRENT_POSITION) like", value.toUpperCase(), "currentPosition");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLikeInsensitive(String value) {
            addCriterion("upper(HIGHEST_EDUCATION) like", value.toUpperCase(), "highestEducation");
            return (Criteria) this;
        }

        public Criteria andGraduationSchoolLikeInsensitive(String value) {
            addCriterion("upper(GRADUATION_SCHOOL) like", value.toUpperCase(), "graduationSchool");
            return (Criteria) this;
        }

        public Criteria andProfessionalLikeInsensitive(String value) {
            addCriterion("upper(PROFESSIONAL) like", value.toUpperCase(), "professional");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(PHONE) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLikeInsensitive(String value) {
            addCriterion("upper(RESUMEORIGIN) like", value.toUpperCase(), "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andChannelLikeInsensitive(String value) {
            addCriterion("upper(CHANNEL) like", value.toUpperCase(), "channel");
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