package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class LanguageExtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public LanguageExtCriteria() {
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

        public Criteria andOfficeFlagIsNull() {
            addCriterion("OFFICE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagIsNotNull() {
            addCriterion("OFFICE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagEqualTo(String value) {
            addCriterion("OFFICE_FLAG =", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagNotEqualTo(String value) {
            addCriterion("OFFICE_FLAG <>", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagGreaterThan(String value) {
            addCriterion("OFFICE_FLAG >", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagGreaterThanOrEqualTo(String value) {
            addCriterion("OFFICE_FLAG >=", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagLessThan(String value) {
            addCriterion("OFFICE_FLAG <", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagLessThanOrEqualTo(String value) {
            addCriterion("OFFICE_FLAG <=", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagLike(String value) {
            addCriterion("OFFICE_FLAG like", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagNotLike(String value) {
            addCriterion("OFFICE_FLAG not like", value, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagIn(List<String> values) {
            addCriterion("OFFICE_FLAG in", values, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagNotIn(List<String> values) {
            addCriterion("OFFICE_FLAG not in", values, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagBetween(String value1, String value2) {
            addCriterion("OFFICE_FLAG between", value1, value2, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeFlagNotBetween(String value1, String value2) {
            addCriterion("OFFICE_FLAG not between", value1, value2, "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelIsNull() {
            addCriterion("OFFICE_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelIsNotNull() {
            addCriterion("OFFICE_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelEqualTo(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL =", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelNotEqualTo(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL <>", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelGreaterThan(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL >", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL >=", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelLessThan(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL <", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL <=", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelLike(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL like", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelNotLike(String value) {
            addCriterion("OFFICE_SKILLED_LEVEL not like", value, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelIn(List<String> values) {
            addCriterion("OFFICE_SKILLED_LEVEL in", values, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelNotIn(List<String> values) {
            addCriterion("OFFICE_SKILLED_LEVEL not in", values, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelBetween(String value1, String value2) {
            addCriterion("OFFICE_SKILLED_LEVEL between", value1, value2, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("OFFICE_SKILLED_LEVEL not between", value1, value2, "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaIsNull() {
            addCriterion("OFFICE_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaIsNotNull() {
            addCriterion("OFFICE_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaEqualTo(String value) {
            addCriterion("OFFICE_DIPLOMA =", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaNotEqualTo(String value) {
            addCriterion("OFFICE_DIPLOMA <>", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaGreaterThan(String value) {
            addCriterion("OFFICE_DIPLOMA >", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("OFFICE_DIPLOMA >=", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaLessThan(String value) {
            addCriterion("OFFICE_DIPLOMA <", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaLessThanOrEqualTo(String value) {
            addCriterion("OFFICE_DIPLOMA <=", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaLike(String value) {
            addCriterion("OFFICE_DIPLOMA like", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaNotLike(String value) {
            addCriterion("OFFICE_DIPLOMA not like", value, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaIn(List<String> values) {
            addCriterion("OFFICE_DIPLOMA in", values, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaNotIn(List<String> values) {
            addCriterion("OFFICE_DIPLOMA not in", values, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaBetween(String value1, String value2) {
            addCriterion("OFFICE_DIPLOMA between", value1, value2, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaNotBetween(String value1, String value2) {
            addCriterion("OFFICE_DIPLOMA not between", value1, value2, "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagIsNull() {
            addCriterion("ENGLISH_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagIsNotNull() {
            addCriterion("ENGLISH_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagEqualTo(String value) {
            addCriterion("ENGLISH_FLAG =", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagNotEqualTo(String value) {
            addCriterion("ENGLISH_FLAG <>", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagGreaterThan(String value) {
            addCriterion("ENGLISH_FLAG >", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_FLAG >=", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagLessThan(String value) {
            addCriterion("ENGLISH_FLAG <", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_FLAG <=", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagLike(String value) {
            addCriterion("ENGLISH_FLAG like", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagNotLike(String value) {
            addCriterion("ENGLISH_FLAG not like", value, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagIn(List<String> values) {
            addCriterion("ENGLISH_FLAG in", values, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagNotIn(List<String> values) {
            addCriterion("ENGLISH_FLAG not in", values, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagBetween(String value1, String value2) {
            addCriterion("ENGLISH_FLAG between", value1, value2, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_FLAG not between", value1, value2, "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelIsNull() {
            addCriterion("ENGLISH_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelIsNotNull() {
            addCriterion("ENGLISH_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelEqualTo(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL =", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelNotEqualTo(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL <>", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelGreaterThan(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL >", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL >=", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelLessThan(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL <", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL <=", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelLike(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL like", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelNotLike(String value) {
            addCriterion("ENGLISH_SKILLED_LEVEL not like", value, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelIn(List<String> values) {
            addCriterion("ENGLISH_SKILLED_LEVEL in", values, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelNotIn(List<String> values) {
            addCriterion("ENGLISH_SKILLED_LEVEL not in", values, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelBetween(String value1, String value2) {
            addCriterion("ENGLISH_SKILLED_LEVEL between", value1, value2, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_SKILLED_LEVEL not between", value1, value2, "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaIsNull() {
            addCriterion("ENGLISH_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaIsNotNull() {
            addCriterion("ENGLISH_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaEqualTo(String value) {
            addCriterion("ENGLISH_DIPLOMA =", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaNotEqualTo(String value) {
            addCriterion("ENGLISH_DIPLOMA <>", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaGreaterThan(String value) {
            addCriterion("ENGLISH_DIPLOMA >", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_DIPLOMA >=", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaLessThan(String value) {
            addCriterion("ENGLISH_DIPLOMA <", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_DIPLOMA <=", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaLike(String value) {
            addCriterion("ENGLISH_DIPLOMA like", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaNotLike(String value) {
            addCriterion("ENGLISH_DIPLOMA not like", value, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaIn(List<String> values) {
            addCriterion("ENGLISH_DIPLOMA in", values, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaNotIn(List<String> values) {
            addCriterion("ENGLISH_DIPLOMA not in", values, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaBetween(String value1, String value2) {
            addCriterion("ENGLISH_DIPLOMA between", value1, value2, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_DIPLOMA not between", value1, value2, "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andSapFlagIsNull() {
            addCriterion("SAP_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSapFlagIsNotNull() {
            addCriterion("SAP_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSapFlagEqualTo(String value) {
            addCriterion("SAP_FLAG =", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagNotEqualTo(String value) {
            addCriterion("SAP_FLAG <>", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagGreaterThan(String value) {
            addCriterion("SAP_FLAG >", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SAP_FLAG >=", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagLessThan(String value) {
            addCriterion("SAP_FLAG <", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagLessThanOrEqualTo(String value) {
            addCriterion("SAP_FLAG <=", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagLike(String value) {
            addCriterion("SAP_FLAG like", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagNotLike(String value) {
            addCriterion("SAP_FLAG not like", value, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagIn(List<String> values) {
            addCriterion("SAP_FLAG in", values, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagNotIn(List<String> values) {
            addCriterion("SAP_FLAG not in", values, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagBetween(String value1, String value2) {
            addCriterion("SAP_FLAG between", value1, value2, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapFlagNotBetween(String value1, String value2) {
            addCriterion("SAP_FLAG not between", value1, value2, "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelIsNull() {
            addCriterion("SAP_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelIsNotNull() {
            addCriterion("SAP_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelEqualTo(String value) {
            addCriterion("SAP_SKILLED_LEVEL =", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelNotEqualTo(String value) {
            addCriterion("SAP_SKILLED_LEVEL <>", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelGreaterThan(String value) {
            addCriterion("SAP_SKILLED_LEVEL >", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("SAP_SKILLED_LEVEL >=", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelLessThan(String value) {
            addCriterion("SAP_SKILLED_LEVEL <", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("SAP_SKILLED_LEVEL <=", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelLike(String value) {
            addCriterion("SAP_SKILLED_LEVEL like", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelNotLike(String value) {
            addCriterion("SAP_SKILLED_LEVEL not like", value, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelIn(List<String> values) {
            addCriterion("SAP_SKILLED_LEVEL in", values, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelNotIn(List<String> values) {
            addCriterion("SAP_SKILLED_LEVEL not in", values, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelBetween(String value1, String value2) {
            addCriterion("SAP_SKILLED_LEVEL between", value1, value2, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("SAP_SKILLED_LEVEL not between", value1, value2, "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaIsNull() {
            addCriterion("SAP_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaIsNotNull() {
            addCriterion("SAP_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaEqualTo(String value) {
            addCriterion("SAP_DIPLOMA =", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaNotEqualTo(String value) {
            addCriterion("SAP_DIPLOMA <>", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaGreaterThan(String value) {
            addCriterion("SAP_DIPLOMA >", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("SAP_DIPLOMA >=", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaLessThan(String value) {
            addCriterion("SAP_DIPLOMA <", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaLessThanOrEqualTo(String value) {
            addCriterion("SAP_DIPLOMA <=", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaLike(String value) {
            addCriterion("SAP_DIPLOMA like", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaNotLike(String value) {
            addCriterion("SAP_DIPLOMA not like", value, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaIn(List<String> values) {
            addCriterion("SAP_DIPLOMA in", values, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaNotIn(List<String> values) {
            addCriterion("SAP_DIPLOMA not in", values, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaBetween(String value1, String value2) {
            addCriterion("SAP_DIPLOMA between", value1, value2, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaNotBetween(String value1, String value2) {
            addCriterion("SAP_DIPLOMA not between", value1, value2, "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagIsNull() {
            addCriterion("KOREAN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagIsNotNull() {
            addCriterion("KOREAN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagEqualTo(String value) {
            addCriterion("KOREAN_FLAG =", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagNotEqualTo(String value) {
            addCriterion("KOREAN_FLAG <>", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagGreaterThan(String value) {
            addCriterion("KOREAN_FLAG >", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagGreaterThanOrEqualTo(String value) {
            addCriterion("KOREAN_FLAG >=", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagLessThan(String value) {
            addCriterion("KOREAN_FLAG <", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagLessThanOrEqualTo(String value) {
            addCriterion("KOREAN_FLAG <=", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagLike(String value) {
            addCriterion("KOREAN_FLAG like", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagNotLike(String value) {
            addCriterion("KOREAN_FLAG not like", value, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagIn(List<String> values) {
            addCriterion("KOREAN_FLAG in", values, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagNotIn(List<String> values) {
            addCriterion("KOREAN_FLAG not in", values, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagBetween(String value1, String value2) {
            addCriterion("KOREAN_FLAG between", value1, value2, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagNotBetween(String value1, String value2) {
            addCriterion("KOREAN_FLAG not between", value1, value2, "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelIsNull() {
            addCriterion("KOREAN_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelIsNotNull() {
            addCriterion("KOREAN_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelEqualTo(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL =", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelNotEqualTo(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL <>", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelGreaterThan(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL >", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL >=", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelLessThan(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL <", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL <=", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelLike(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL like", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelNotLike(String value) {
            addCriterion("KOREAN_SKILLED_LEVEL not like", value, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelIn(List<String> values) {
            addCriterion("KOREAN_SKILLED_LEVEL in", values, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelNotIn(List<String> values) {
            addCriterion("KOREAN_SKILLED_LEVEL not in", values, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelBetween(String value1, String value2) {
            addCriterion("KOREAN_SKILLED_LEVEL between", value1, value2, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("KOREAN_SKILLED_LEVEL not between", value1, value2, "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaIsNull() {
            addCriterion("KOREAN_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaIsNotNull() {
            addCriterion("KOREAN_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaEqualTo(String value) {
            addCriterion("KOREAN_DIPLOMA =", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaNotEqualTo(String value) {
            addCriterion("KOREAN_DIPLOMA <>", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaGreaterThan(String value) {
            addCriterion("KOREAN_DIPLOMA >", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("KOREAN_DIPLOMA >=", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaLessThan(String value) {
            addCriterion("KOREAN_DIPLOMA <", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaLessThanOrEqualTo(String value) {
            addCriterion("KOREAN_DIPLOMA <=", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaLike(String value) {
            addCriterion("KOREAN_DIPLOMA like", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaNotLike(String value) {
            addCriterion("KOREAN_DIPLOMA not like", value, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaIn(List<String> values) {
            addCriterion("KOREAN_DIPLOMA in", values, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaNotIn(List<String> values) {
            addCriterion("KOREAN_DIPLOMA not in", values, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaBetween(String value1, String value2) {
            addCriterion("KOREAN_DIPLOMA between", value1, value2, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaNotBetween(String value1, String value2) {
            addCriterion("KOREAN_DIPLOMA not between", value1, value2, "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaFlagIsNull() {
            addCriterion("VBA_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andVbaFlagIsNotNull() {
            addCriterion("VBA_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andVbaFlagEqualTo(String value) {
            addCriterion("VBA_FLAG =", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagNotEqualTo(String value) {
            addCriterion("VBA_FLAG <>", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagGreaterThan(String value) {
            addCriterion("VBA_FLAG >", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagGreaterThanOrEqualTo(String value) {
            addCriterion("VBA_FLAG >=", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagLessThan(String value) {
            addCriterion("VBA_FLAG <", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagLessThanOrEqualTo(String value) {
            addCriterion("VBA_FLAG <=", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagLike(String value) {
            addCriterion("VBA_FLAG like", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagNotLike(String value) {
            addCriterion("VBA_FLAG not like", value, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagIn(List<String> values) {
            addCriterion("VBA_FLAG in", values, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagNotIn(List<String> values) {
            addCriterion("VBA_FLAG not in", values, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagBetween(String value1, String value2) {
            addCriterion("VBA_FLAG between", value1, value2, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaFlagNotBetween(String value1, String value2) {
            addCriterion("VBA_FLAG not between", value1, value2, "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelIsNull() {
            addCriterion("VBA_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelIsNotNull() {
            addCriterion("VBA_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelEqualTo(String value) {
            addCriterion("VBA_SKILLED_LEVEL =", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelNotEqualTo(String value) {
            addCriterion("VBA_SKILLED_LEVEL <>", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelGreaterThan(String value) {
            addCriterion("VBA_SKILLED_LEVEL >", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("VBA_SKILLED_LEVEL >=", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelLessThan(String value) {
            addCriterion("VBA_SKILLED_LEVEL <", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("VBA_SKILLED_LEVEL <=", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelLike(String value) {
            addCriterion("VBA_SKILLED_LEVEL like", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelNotLike(String value) {
            addCriterion("VBA_SKILLED_LEVEL not like", value, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelIn(List<String> values) {
            addCriterion("VBA_SKILLED_LEVEL in", values, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelNotIn(List<String> values) {
            addCriterion("VBA_SKILLED_LEVEL not in", values, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelBetween(String value1, String value2) {
            addCriterion("VBA_SKILLED_LEVEL between", value1, value2, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("VBA_SKILLED_LEVEL not between", value1, value2, "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaIsNull() {
            addCriterion("VBA_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaIsNotNull() {
            addCriterion("VBA_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaEqualTo(String value) {
            addCriterion("VBA_DIPLOMA =", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaNotEqualTo(String value) {
            addCriterion("VBA_DIPLOMA <>", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaGreaterThan(String value) {
            addCriterion("VBA_DIPLOMA >", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("VBA_DIPLOMA >=", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaLessThan(String value) {
            addCriterion("VBA_DIPLOMA <", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaLessThanOrEqualTo(String value) {
            addCriterion("VBA_DIPLOMA <=", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaLike(String value) {
            addCriterion("VBA_DIPLOMA like", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaNotLike(String value) {
            addCriterion("VBA_DIPLOMA not like", value, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaIn(List<String> values) {
            addCriterion("VBA_DIPLOMA in", values, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaNotIn(List<String> values) {
            addCriterion("VBA_DIPLOMA not in", values, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaBetween(String value1, String value2) {
            addCriterion("VBA_DIPLOMA between", value1, value2, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaNotBetween(String value1, String value2) {
            addCriterion("VBA_DIPLOMA not between", value1, value2, "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagIsNull() {
            addCriterion("JAPANESE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagIsNotNull() {
            addCriterion("JAPANESE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagEqualTo(String value) {
            addCriterion("JAPANESE_FLAG =", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagNotEqualTo(String value) {
            addCriterion("JAPANESE_FLAG <>", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagGreaterThan(String value) {
            addCriterion("JAPANESE_FLAG >", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagGreaterThanOrEqualTo(String value) {
            addCriterion("JAPANESE_FLAG >=", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagLessThan(String value) {
            addCriterion("JAPANESE_FLAG <", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagLessThanOrEqualTo(String value) {
            addCriterion("JAPANESE_FLAG <=", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagLike(String value) {
            addCriterion("JAPANESE_FLAG like", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagNotLike(String value) {
            addCriterion("JAPANESE_FLAG not like", value, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagIn(List<String> values) {
            addCriterion("JAPANESE_FLAG in", values, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagNotIn(List<String> values) {
            addCriterion("JAPANESE_FLAG not in", values, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagBetween(String value1, String value2) {
            addCriterion("JAPANESE_FLAG between", value1, value2, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagNotBetween(String value1, String value2) {
            addCriterion("JAPANESE_FLAG not between", value1, value2, "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelIsNull() {
            addCriterion("JAPANESE_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelIsNotNull() {
            addCriterion("JAPANESE_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelEqualTo(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL =", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelNotEqualTo(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL <>", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelGreaterThan(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL >", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL >=", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelLessThan(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL <", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL <=", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelLike(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL like", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelNotLike(String value) {
            addCriterion("JAPANESE_SKILLED_LEVEL not like", value, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelIn(List<String> values) {
            addCriterion("JAPANESE_SKILLED_LEVEL in", values, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelNotIn(List<String> values) {
            addCriterion("JAPANESE_SKILLED_LEVEL not in", values, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelBetween(String value1, String value2) {
            addCriterion("JAPANESE_SKILLED_LEVEL between", value1, value2, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("JAPANESE_SKILLED_LEVEL not between", value1, value2, "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaIsNull() {
            addCriterion("JAPANESE_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaIsNotNull() {
            addCriterion("JAPANESE_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaEqualTo(String value) {
            addCriterion("JAPANESE_DIPLOMA =", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaNotEqualTo(String value) {
            addCriterion("JAPANESE_DIPLOMA <>", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaGreaterThan(String value) {
            addCriterion("JAPANESE_DIPLOMA >", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("JAPANESE_DIPLOMA >=", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaLessThan(String value) {
            addCriterion("JAPANESE_DIPLOMA <", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaLessThanOrEqualTo(String value) {
            addCriterion("JAPANESE_DIPLOMA <=", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaLike(String value) {
            addCriterion("JAPANESE_DIPLOMA like", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaNotLike(String value) {
            addCriterion("JAPANESE_DIPLOMA not like", value, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaIn(List<String> values) {
            addCriterion("JAPANESE_DIPLOMA in", values, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaNotIn(List<String> values) {
            addCriterion("JAPANESE_DIPLOMA not in", values, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaBetween(String value1, String value2) {
            addCriterion("JAPANESE_DIPLOMA between", value1, value2, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaNotBetween(String value1, String value2) {
            addCriterion("JAPANESE_DIPLOMA not between", value1, value2, "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagIsNull() {
            addCriterion("OTHERIT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagIsNotNull() {
            addCriterion("OTHERIT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagEqualTo(String value) {
            addCriterion("OTHERIT_FLAG =", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagNotEqualTo(String value) {
            addCriterion("OTHERIT_FLAG <>", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagGreaterThan(String value) {
            addCriterion("OTHERIT_FLAG >", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERIT_FLAG >=", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagLessThan(String value) {
            addCriterion("OTHERIT_FLAG <", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagLessThanOrEqualTo(String value) {
            addCriterion("OTHERIT_FLAG <=", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagLike(String value) {
            addCriterion("OTHERIT_FLAG like", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagNotLike(String value) {
            addCriterion("OTHERIT_FLAG not like", value, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagIn(List<String> values) {
            addCriterion("OTHERIT_FLAG in", values, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagNotIn(List<String> values) {
            addCriterion("OTHERIT_FLAG not in", values, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagBetween(String value1, String value2) {
            addCriterion("OTHERIT_FLAG between", value1, value2, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagNotBetween(String value1, String value2) {
            addCriterion("OTHERIT_FLAG not between", value1, value2, "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelIsNull() {
            addCriterion("OTHERIT_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelIsNotNull() {
            addCriterion("OTHERIT_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelEqualTo(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL =", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelNotEqualTo(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL <>", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelGreaterThan(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL >", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL >=", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelLessThan(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL <", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL <=", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelLike(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL like", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelNotLike(String value) {
            addCriterion("OTHERIT_SKILLED_LEVEL not like", value, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelIn(List<String> values) {
            addCriterion("OTHERIT_SKILLED_LEVEL in", values, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelNotIn(List<String> values) {
            addCriterion("OTHERIT_SKILLED_LEVEL not in", values, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelBetween(String value1, String value2) {
            addCriterion("OTHERIT_SKILLED_LEVEL between", value1, value2, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("OTHERIT_SKILLED_LEVEL not between", value1, value2, "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaIsNull() {
            addCriterion("OTHERIT_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaIsNotNull() {
            addCriterion("OTHERIT_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaEqualTo(String value) {
            addCriterion("OTHERIT_DIPLOMA =", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaNotEqualTo(String value) {
            addCriterion("OTHERIT_DIPLOMA <>", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaGreaterThan(String value) {
            addCriterion("OTHERIT_DIPLOMA >", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("OTHERIT_DIPLOMA >=", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaLessThan(String value) {
            addCriterion("OTHERIT_DIPLOMA <", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaLessThanOrEqualTo(String value) {
            addCriterion("OTHERIT_DIPLOMA <=", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaLike(String value) {
            addCriterion("OTHERIT_DIPLOMA like", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaNotLike(String value) {
            addCriterion("OTHERIT_DIPLOMA not like", value, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaIn(List<String> values) {
            addCriterion("OTHERIT_DIPLOMA in", values, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaNotIn(List<String> values) {
            addCriterion("OTHERIT_DIPLOMA not in", values, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaBetween(String value1, String value2) {
            addCriterion("OTHERIT_DIPLOMA between", value1, value2, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaNotBetween(String value1, String value2) {
            addCriterion("OTHERIT_DIPLOMA not between", value1, value2, "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherFlagIsNull() {
            addCriterion("OTHER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOtherFlagIsNotNull() {
            addCriterion("OTHER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFlagEqualTo(String value) {
            addCriterion("OTHER_FLAG =", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagNotEqualTo(String value) {
            addCriterion("OTHER_FLAG <>", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagGreaterThan(String value) {
            addCriterion("OTHER_FLAG >", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_FLAG >=", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagLessThan(String value) {
            addCriterion("OTHER_FLAG <", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagLessThanOrEqualTo(String value) {
            addCriterion("OTHER_FLAG <=", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagLike(String value) {
            addCriterion("OTHER_FLAG like", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagNotLike(String value) {
            addCriterion("OTHER_FLAG not like", value, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagIn(List<String> values) {
            addCriterion("OTHER_FLAG in", values, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagNotIn(List<String> values) {
            addCriterion("OTHER_FLAG not in", values, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagBetween(String value1, String value2) {
            addCriterion("OTHER_FLAG between", value1, value2, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherFlagNotBetween(String value1, String value2) {
            addCriterion("OTHER_FLAG not between", value1, value2, "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelIsNull() {
            addCriterion("OTHER_SKILLED_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelIsNotNull() {
            addCriterion("OTHER_SKILLED_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelEqualTo(String value) {
            addCriterion("OTHER_SKILLED_LEVEL =", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelNotEqualTo(String value) {
            addCriterion("OTHER_SKILLED_LEVEL <>", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelGreaterThan(String value) {
            addCriterion("OTHER_SKILLED_LEVEL >", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_SKILLED_LEVEL >=", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelLessThan(String value) {
            addCriterion("OTHER_SKILLED_LEVEL <", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelLessThanOrEqualTo(String value) {
            addCriterion("OTHER_SKILLED_LEVEL <=", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelLike(String value) {
            addCriterion("OTHER_SKILLED_LEVEL like", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelNotLike(String value) {
            addCriterion("OTHER_SKILLED_LEVEL not like", value, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelIn(List<String> values) {
            addCriterion("OTHER_SKILLED_LEVEL in", values, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelNotIn(List<String> values) {
            addCriterion("OTHER_SKILLED_LEVEL not in", values, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelBetween(String value1, String value2) {
            addCriterion("OTHER_SKILLED_LEVEL between", value1, value2, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelNotBetween(String value1, String value2) {
            addCriterion("OTHER_SKILLED_LEVEL not between", value1, value2, "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaIsNull() {
            addCriterion("OTHER_DIPLOMA is null");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaIsNotNull() {
            addCriterion("OTHER_DIPLOMA is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaEqualTo(String value) {
            addCriterion("OTHER_DIPLOMA =", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaNotEqualTo(String value) {
            addCriterion("OTHER_DIPLOMA <>", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaGreaterThan(String value) {
            addCriterion("OTHER_DIPLOMA >", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_DIPLOMA >=", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaLessThan(String value) {
            addCriterion("OTHER_DIPLOMA <", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaLessThanOrEqualTo(String value) {
            addCriterion("OTHER_DIPLOMA <=", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaLike(String value) {
            addCriterion("OTHER_DIPLOMA like", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaNotLike(String value) {
            addCriterion("OTHER_DIPLOMA not like", value, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaIn(List<String> values) {
            addCriterion("OTHER_DIPLOMA in", values, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaNotIn(List<String> values) {
            addCriterion("OTHER_DIPLOMA not in", values, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaBetween(String value1, String value2) {
            addCriterion("OTHER_DIPLOMA between", value1, value2, "otherDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaNotBetween(String value1, String value2) {
            addCriterion("OTHER_DIPLOMA not between", value1, value2, "otherDiploma");
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

        public Criteria andOfficeFlagLikeInsensitive(String value) {
            addCriterion("upper(OFFICE_FLAG) like", value.toUpperCase(), "officeFlag");
            return (Criteria) this;
        }

        public Criteria andOfficeSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(OFFICE_SKILLED_LEVEL) like", value.toUpperCase(), "officeSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOfficeDiplomaLikeInsensitive(String value) {
            addCriterion("upper(OFFICE_DIPLOMA) like", value.toUpperCase(), "officeDiploma");
            return (Criteria) this;
        }

        public Criteria andEnglishFlagLikeInsensitive(String value) {
            addCriterion("upper(ENGLISH_FLAG) like", value.toUpperCase(), "englishFlag");
            return (Criteria) this;
        }

        public Criteria andEnglishSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(ENGLISH_SKILLED_LEVEL) like", value.toUpperCase(), "englishSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andEnglishDiplomaLikeInsensitive(String value) {
            addCriterion("upper(ENGLISH_DIPLOMA) like", value.toUpperCase(), "englishDiploma");
            return (Criteria) this;
        }

        public Criteria andSapFlagLikeInsensitive(String value) {
            addCriterion("upper(SAP_FLAG) like", value.toUpperCase(), "sapFlag");
            return (Criteria) this;
        }

        public Criteria andSapSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(SAP_SKILLED_LEVEL) like", value.toUpperCase(), "sapSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andSapDiplomaLikeInsensitive(String value) {
            addCriterion("upper(SAP_DIPLOMA) like", value.toUpperCase(), "sapDiploma");
            return (Criteria) this;
        }

        public Criteria andKoreanFlagLikeInsensitive(String value) {
            addCriterion("upper(KOREAN_FLAG) like", value.toUpperCase(), "koreanFlag");
            return (Criteria) this;
        }

        public Criteria andKoreanSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(KOREAN_SKILLED_LEVEL) like", value.toUpperCase(), "koreanSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andKoreanDiplomaLikeInsensitive(String value) {
            addCriterion("upper(KOREAN_DIPLOMA) like", value.toUpperCase(), "koreanDiploma");
            return (Criteria) this;
        }

        public Criteria andVbaFlagLikeInsensitive(String value) {
            addCriterion("upper(VBA_FLAG) like", value.toUpperCase(), "vbaFlag");
            return (Criteria) this;
        }

        public Criteria andVbaSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(VBA_SKILLED_LEVEL) like", value.toUpperCase(), "vbaSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andVbaDiplomaLikeInsensitive(String value) {
            addCriterion("upper(VBA_DIPLOMA) like", value.toUpperCase(), "vbaDiploma");
            return (Criteria) this;
        }

        public Criteria andJapaneseFlagLikeInsensitive(String value) {
            addCriterion("upper(JAPANESE_FLAG) like", value.toUpperCase(), "japaneseFlag");
            return (Criteria) this;
        }

        public Criteria andJapaneseSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(JAPANESE_SKILLED_LEVEL) like", value.toUpperCase(), "japaneseSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andJapaneseDiplomaLikeInsensitive(String value) {
            addCriterion("upper(JAPANESE_DIPLOMA) like", value.toUpperCase(), "japaneseDiploma");
            return (Criteria) this;
        }

        public Criteria andOtheritFlagLikeInsensitive(String value) {
            addCriterion("upper(OTHERIT_FLAG) like", value.toUpperCase(), "otheritFlag");
            return (Criteria) this;
        }

        public Criteria andOtheritSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(OTHERIT_SKILLED_LEVEL) like", value.toUpperCase(), "otheritSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtheritDiplomaLikeInsensitive(String value) {
            addCriterion("upper(OTHERIT_DIPLOMA) like", value.toUpperCase(), "otheritDiploma");
            return (Criteria) this;
        }

        public Criteria andOtherFlagLikeInsensitive(String value) {
            addCriterion("upper(OTHER_FLAG) like", value.toUpperCase(), "otherFlag");
            return (Criteria) this;
        }

        public Criteria andOtherSkilledLevelLikeInsensitive(String value) {
            addCriterion("upper(OTHER_SKILLED_LEVEL) like", value.toUpperCase(), "otherSkilledLevel");
            return (Criteria) this;
        }

        public Criteria andOtherDiplomaLikeInsensitive(String value) {
            addCriterion("upper(OTHER_DIPLOMA) like", value.toUpperCase(), "otherDiploma");
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