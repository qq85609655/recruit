package com.csot.recruit.model.resume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class EducationExperienceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EducationExperienceCriteria() {
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

        public Criteria andEduStartDateIsNull() {
            addCriterion("EDU_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEduStartDateIsNotNull() {
            addCriterion("EDU_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEduStartDateEqualTo(Date value) {
            addCriterion("EDU_START_DATE =", value, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateNotEqualTo(Date value) {
            addCriterion("EDU_START_DATE <>", value, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateGreaterThan(Date value) {
            addCriterion("EDU_START_DATE >", value, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EDU_START_DATE >=", value, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateLessThan(Date value) {
            addCriterion("EDU_START_DATE <", value, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateLessThanOrEqualTo(Date value) {
            addCriterion("EDU_START_DATE <=", value, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateIn(List<Date> values) {
            addCriterion("EDU_START_DATE in", values, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateNotIn(List<Date> values) {
            addCriterion("EDU_START_DATE not in", values, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateBetween(Date value1, Date value2) {
            addCriterion("EDU_START_DATE between", value1, value2, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduStartDateNotBetween(Date value1, Date value2) {
            addCriterion("EDU_START_DATE not between", value1, value2, "eduStartDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateIsNull() {
            addCriterion("EDU_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEduEndDateIsNotNull() {
            addCriterion("EDU_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEduEndDateEqualTo(Date value) {
            addCriterion("EDU_END_DATE =", value, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateNotEqualTo(Date value) {
            addCriterion("EDU_END_DATE <>", value, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateGreaterThan(Date value) {
            addCriterion("EDU_END_DATE >", value, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EDU_END_DATE >=", value, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateLessThan(Date value) {
            addCriterion("EDU_END_DATE <", value, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateLessThanOrEqualTo(Date value) {
            addCriterion("EDU_END_DATE <=", value, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateIn(List<Date> values) {
            addCriterion("EDU_END_DATE in", values, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateNotIn(List<Date> values) {
            addCriterion("EDU_END_DATE not in", values, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateBetween(Date value1, Date value2) {
            addCriterion("EDU_END_DATE between", value1, value2, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andEduEndDateNotBetween(Date value1, Date value2) {
            addCriterion("EDU_END_DATE not between", value1, value2, "eduEndDate");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("SCHOOL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("SCHOOL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("SCHOOL_NAME =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("SCHOOL_NAME <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("SCHOOL_NAME >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOOL_NAME >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("SCHOOL_NAME <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("SCHOOL_NAME <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("SCHOOL_NAME like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("SCHOOL_NAME not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("SCHOOL_NAME in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("SCHOOL_NAME not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("SCHOOL_NAME between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("SCHOOL_NAME not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIsNull() {
            addCriterion("SCHOOL_NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIsNotNull() {
            addCriterion("SCHOOL_NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnEqualTo(String value) {
            addCriterion("SCHOOL_NAME_EN =", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotEqualTo(String value) {
            addCriterion("SCHOOL_NAME_EN <>", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnGreaterThan(String value) {
            addCriterion("SCHOOL_NAME_EN >", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOOL_NAME_EN >=", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLessThan(String value) {
            addCriterion("SCHOOL_NAME_EN <", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLessThanOrEqualTo(String value) {
            addCriterion("SCHOOL_NAME_EN <=", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLike(String value) {
            addCriterion("SCHOOL_NAME_EN like", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotLike(String value) {
            addCriterion("SCHOOL_NAME_EN not like", value, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnIn(List<String> values) {
            addCriterion("SCHOOL_NAME_EN in", values, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotIn(List<String> values) {
            addCriterion("SCHOOL_NAME_EN not in", values, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnBetween(String value1, String value2) {
            addCriterion("SCHOOL_NAME_EN between", value1, value2, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnNotBetween(String value1, String value2) {
            addCriterion("SCHOOL_NAME_EN not between", value1, value2, "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("EDUCATION =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("EDUCATION <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("EDUCATION >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("EDUCATION <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("EDUCATION <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("EDUCATION like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("EDUCATION not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("EDUCATION in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("EDUCATION not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("EDUCATION between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("EDUCATION not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("MAJOR =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("MAJOR <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("MAJOR >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("MAJOR >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("MAJOR <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("MAJOR <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("MAJOR like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("MAJOR not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("MAJOR in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("MAJOR not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("MAJOR between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("MAJOR not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorEnIsNull() {
            addCriterion("MAJOR_EN is null");
            return (Criteria) this;
        }

        public Criteria andMajorEnIsNotNull() {
            addCriterion("MAJOR_EN is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEnEqualTo(String value) {
            addCriterion("MAJOR_EN =", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnNotEqualTo(String value) {
            addCriterion("MAJOR_EN <>", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnGreaterThan(String value) {
            addCriterion("MAJOR_EN >", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnGreaterThanOrEqualTo(String value) {
            addCriterion("MAJOR_EN >=", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnLessThan(String value) {
            addCriterion("MAJOR_EN <", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnLessThanOrEqualTo(String value) {
            addCriterion("MAJOR_EN <=", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnLike(String value) {
            addCriterion("MAJOR_EN like", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnNotLike(String value) {
            addCriterion("MAJOR_EN not like", value, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnIn(List<String> values) {
            addCriterion("MAJOR_EN in", values, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnNotIn(List<String> values) {
            addCriterion("MAJOR_EN not in", values, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnBetween(String value1, String value2) {
            addCriterion("MAJOR_EN between", value1, value2, "majorEn");
            return (Criteria) this;
        }

        public Criteria andMajorEnNotBetween(String value1, String value2) {
            addCriterion("MAJOR_EN not between", value1, value2, "majorEn");
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

        public Criteria andEduTypeIsNull() {
            addCriterion("EDU_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEduTypeIsNotNull() {
            addCriterion("EDU_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEduTypeEqualTo(String value) {
            addCriterion("EDU_TYPE =", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotEqualTo(String value) {
            addCriterion("EDU_TYPE <>", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeGreaterThan(String value) {
            addCriterion("EDU_TYPE >", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EDU_TYPE >=", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeLessThan(String value) {
            addCriterion("EDU_TYPE <", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeLessThanOrEqualTo(String value) {
            addCriterion("EDU_TYPE <=", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeLike(String value) {
            addCriterion("EDU_TYPE like", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotLike(String value) {
            addCriterion("EDU_TYPE not like", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeIn(List<String> values) {
            addCriterion("EDU_TYPE in", values, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotIn(List<String> values) {
            addCriterion("EDU_TYPE not in", values, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeBetween(String value1, String value2) {
            addCriterion("EDU_TYPE between", value1, value2, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotBetween(String value1, String value2) {
            addCriterion("EDU_TYPE not between", value1, value2, "eduType");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNull() {
            addCriterion("CERTIFICATE is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("CERTIFICATE is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(String value) {
            addCriterion("CERTIFICATE =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(String value) {
            addCriterion("CERTIFICATE <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(String value) {
            addCriterion("CERTIFICATE >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(String value) {
            addCriterion("CERTIFICATE <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLike(String value) {
            addCriterion("CERTIFICATE like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotLike(String value) {
            addCriterion("CERTIFICATE not like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<String> values) {
            addCriterion("CERTIFICATE in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<String> values) {
            addCriterion("CERTIFICATE not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(String value1, String value2) {
            addCriterion("CERTIFICATE between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATE not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andFkTidIsNull() {
            addCriterion("FK_TID is null");
            return (Criteria) this;
        }

        public Criteria andFkTidIsNotNull() {
            addCriterion("FK_TID is not null");
            return (Criteria) this;
        }

        public Criteria andFkTidEqualTo(String value) {
            addCriterion("FK_TID =", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidNotEqualTo(String value) {
            addCriterion("FK_TID <>", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidGreaterThan(String value) {
            addCriterion("FK_TID >", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidGreaterThanOrEqualTo(String value) {
            addCriterion("FK_TID >=", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidLessThan(String value) {
            addCriterion("FK_TID <", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidLessThanOrEqualTo(String value) {
            addCriterion("FK_TID <=", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidLike(String value) {
            addCriterion("FK_TID like", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidNotLike(String value) {
            addCriterion("FK_TID not like", value, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidIn(List<String> values) {
            addCriterion("FK_TID in", values, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidNotIn(List<String> values) {
            addCriterion("FK_TID not in", values, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidBetween(String value1, String value2) {
            addCriterion("FK_TID between", value1, value2, "fkTid");
            return (Criteria) this;
        }

        public Criteria andFkTidNotBetween(String value1, String value2) {
            addCriterion("FK_TID not between", value1, value2, "fkTid");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLikeInsensitive(String value) {
            addCriterion("upper(SCHOOL_NAME) like", value.toUpperCase(), "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEnLikeInsensitive(String value) {
            addCriterion("upper(SCHOOL_NAME_EN) like", value.toUpperCase(), "schoolNameEn");
            return (Criteria) this;
        }

        public Criteria andEducationLikeInsensitive(String value) {
            addCriterion("upper(EDUCATION) like", value.toUpperCase(), "education");
            return (Criteria) this;
        }

        public Criteria andMajorLikeInsensitive(String value) {
            addCriterion("upper(MAJOR) like", value.toUpperCase(), "major");
            return (Criteria) this;
        }

        public Criteria andMajorEnLikeInsensitive(String value) {
            addCriterion("upper(MAJOR_EN) like", value.toUpperCase(), "majorEn");
            return (Criteria) this;
        }

        public Criteria andResumeIdLikeInsensitive(String value) {
            addCriterion("upper(RESUME_ID) like", value.toUpperCase(), "resumeId");
            return (Criteria) this;
        }

        public Criteria andEduTypeLikeInsensitive(String value) {
            addCriterion("upper(EDU_TYPE) like", value.toUpperCase(), "eduType");
            return (Criteria) this;
        }

        public Criteria andCertificateLikeInsensitive(String value) {
            addCriterion("upper(CERTIFICATE) like", value.toUpperCase(), "certificate");
            return (Criteria) this;
        }

        public Criteria andFkTidLikeInsensitive(String value) {
            addCriterion("upper(FK_TID) like", value.toUpperCase(), "fkTid");
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