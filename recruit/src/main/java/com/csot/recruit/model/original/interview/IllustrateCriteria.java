package com.csot.recruit.model.original.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class IllustrateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IllustrateCriteria() {
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

        public Criteria andInfectionFlagIsNull() {
            addCriterion("INFECTION_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagIsNotNull() {
            addCriterion("INFECTION_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagEqualTo(String value) {
            addCriterion("INFECTION_FLAG =", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagNotEqualTo(String value) {
            addCriterion("INFECTION_FLAG <>", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagGreaterThan(String value) {
            addCriterion("INFECTION_FLAG >", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagGreaterThanOrEqualTo(String value) {
            addCriterion("INFECTION_FLAG >=", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagLessThan(String value) {
            addCriterion("INFECTION_FLAG <", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagLessThanOrEqualTo(String value) {
            addCriterion("INFECTION_FLAG <=", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagLike(String value) {
            addCriterion("INFECTION_FLAG like", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagNotLike(String value) {
            addCriterion("INFECTION_FLAG not like", value, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagIn(List<String> values) {
            addCriterion("INFECTION_FLAG in", values, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagNotIn(List<String> values) {
            addCriterion("INFECTION_FLAG not in", values, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagBetween(String value1, String value2) {
            addCriterion("INFECTION_FLAG between", value1, value2, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionFlagNotBetween(String value1, String value2) {
            addCriterion("INFECTION_FLAG not between", value1, value2, "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionTextIsNull() {
            addCriterion("INFECTION_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andInfectionTextIsNotNull() {
            addCriterion("INFECTION_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andInfectionTextEqualTo(String value) {
            addCriterion("INFECTION_TEXT =", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextNotEqualTo(String value) {
            addCriterion("INFECTION_TEXT <>", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextGreaterThan(String value) {
            addCriterion("INFECTION_TEXT >", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextGreaterThanOrEqualTo(String value) {
            addCriterion("INFECTION_TEXT >=", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextLessThan(String value) {
            addCriterion("INFECTION_TEXT <", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextLessThanOrEqualTo(String value) {
            addCriterion("INFECTION_TEXT <=", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextLike(String value) {
            addCriterion("INFECTION_TEXT like", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextNotLike(String value) {
            addCriterion("INFECTION_TEXT not like", value, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextIn(List<String> values) {
            addCriterion("INFECTION_TEXT in", values, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextNotIn(List<String> values) {
            addCriterion("INFECTION_TEXT not in", values, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextBetween(String value1, String value2) {
            addCriterion("INFECTION_TEXT between", value1, value2, "infectionText");
            return (Criteria) this;
        }

        public Criteria andInfectionTextNotBetween(String value1, String value2) {
            addCriterion("INFECTION_TEXT not between", value1, value2, "infectionText");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagIsNull() {
            addCriterion("CRIMINAL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagIsNotNull() {
            addCriterion("CRIMINAL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagEqualTo(String value) {
            addCriterion("CRIMINAL_FLAG =", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagNotEqualTo(String value) {
            addCriterion("CRIMINAL_FLAG <>", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagGreaterThan(String value) {
            addCriterion("CRIMINAL_FLAG >", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CRIMINAL_FLAG >=", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagLessThan(String value) {
            addCriterion("CRIMINAL_FLAG <", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagLessThanOrEqualTo(String value) {
            addCriterion("CRIMINAL_FLAG <=", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagLike(String value) {
            addCriterion("CRIMINAL_FLAG like", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagNotLike(String value) {
            addCriterion("CRIMINAL_FLAG not like", value, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagIn(List<String> values) {
            addCriterion("CRIMINAL_FLAG in", values, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagNotIn(List<String> values) {
            addCriterion("CRIMINAL_FLAG not in", values, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagBetween(String value1, String value2) {
            addCriterion("CRIMINAL_FLAG between", value1, value2, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagNotBetween(String value1, String value2) {
            addCriterion("CRIMINAL_FLAG not between", value1, value2, "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalTextIsNull() {
            addCriterion("CRIMINAL_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andCriminalTextIsNotNull() {
            addCriterion("CRIMINAL_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andCriminalTextEqualTo(String value) {
            addCriterion("CRIMINAL_TEXT =", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextNotEqualTo(String value) {
            addCriterion("CRIMINAL_TEXT <>", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextGreaterThan(String value) {
            addCriterion("CRIMINAL_TEXT >", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextGreaterThanOrEqualTo(String value) {
            addCriterion("CRIMINAL_TEXT >=", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextLessThan(String value) {
            addCriterion("CRIMINAL_TEXT <", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextLessThanOrEqualTo(String value) {
            addCriterion("CRIMINAL_TEXT <=", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextLike(String value) {
            addCriterion("CRIMINAL_TEXT like", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextNotLike(String value) {
            addCriterion("CRIMINAL_TEXT not like", value, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextIn(List<String> values) {
            addCriterion("CRIMINAL_TEXT in", values, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextNotIn(List<String> values) {
            addCriterion("CRIMINAL_TEXT not in", values, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextBetween(String value1, String value2) {
            addCriterion("CRIMINAL_TEXT between", value1, value2, "criminalText");
            return (Criteria) this;
        }

        public Criteria andCriminalTextNotBetween(String value1, String value2) {
            addCriterion("CRIMINAL_TEXT not between", value1, value2, "criminalText");
            return (Criteria) this;
        }

        public Criteria andEmployFlagIsNull() {
            addCriterion("EMPLOY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEmployFlagIsNotNull() {
            addCriterion("EMPLOY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEmployFlagEqualTo(String value) {
            addCriterion("EMPLOY_FLAG =", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagNotEqualTo(String value) {
            addCriterion("EMPLOY_FLAG <>", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagGreaterThan(String value) {
            addCriterion("EMPLOY_FLAG >", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_FLAG >=", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagLessThan(String value) {
            addCriterion("EMPLOY_FLAG <", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_FLAG <=", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagLike(String value) {
            addCriterion("EMPLOY_FLAG like", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagNotLike(String value) {
            addCriterion("EMPLOY_FLAG not like", value, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagIn(List<String> values) {
            addCriterion("EMPLOY_FLAG in", values, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagNotIn(List<String> values) {
            addCriterion("EMPLOY_FLAG not in", values, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagBetween(String value1, String value2) {
            addCriterion("EMPLOY_FLAG between", value1, value2, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployFlagNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_FLAG not between", value1, value2, "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployTextIsNull() {
            addCriterion("EMPLOY_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andEmployTextIsNotNull() {
            addCriterion("EMPLOY_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andEmployTextEqualTo(String value) {
            addCriterion("EMPLOY_TEXT =", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextNotEqualTo(String value) {
            addCriterion("EMPLOY_TEXT <>", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextGreaterThan(String value) {
            addCriterion("EMPLOY_TEXT >", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_TEXT >=", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextLessThan(String value) {
            addCriterion("EMPLOY_TEXT <", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_TEXT <=", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextLike(String value) {
            addCriterion("EMPLOY_TEXT like", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextNotLike(String value) {
            addCriterion("EMPLOY_TEXT not like", value, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextIn(List<String> values) {
            addCriterion("EMPLOY_TEXT in", values, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextNotIn(List<String> values) {
            addCriterion("EMPLOY_TEXT not in", values, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextBetween(String value1, String value2) {
            addCriterion("EMPLOY_TEXT between", value1, value2, "employText");
            return (Criteria) this;
        }

        public Criteria andEmployTextNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_TEXT not between", value1, value2, "employText");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagIsNull() {
            addCriterion("INVESTIGATE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagIsNotNull() {
            addCriterion("INVESTIGATE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagEqualTo(String value) {
            addCriterion("INVESTIGATE_FLAG =", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagNotEqualTo(String value) {
            addCriterion("INVESTIGATE_FLAG <>", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagGreaterThan(String value) {
            addCriterion("INVESTIGATE_FLAG >", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagGreaterThanOrEqualTo(String value) {
            addCriterion("INVESTIGATE_FLAG >=", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagLessThan(String value) {
            addCriterion("INVESTIGATE_FLAG <", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagLessThanOrEqualTo(String value) {
            addCriterion("INVESTIGATE_FLAG <=", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagLike(String value) {
            addCriterion("INVESTIGATE_FLAG like", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagNotLike(String value) {
            addCriterion("INVESTIGATE_FLAG not like", value, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagIn(List<String> values) {
            addCriterion("INVESTIGATE_FLAG in", values, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagNotIn(List<String> values) {
            addCriterion("INVESTIGATE_FLAG not in", values, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagBetween(String value1, String value2) {
            addCriterion("INVESTIGATE_FLAG between", value1, value2, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagNotBetween(String value1, String value2) {
            addCriterion("INVESTIGATE_FLAG not between", value1, value2, "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextIsNull() {
            addCriterion("INVESTIGATE_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextIsNotNull() {
            addCriterion("INVESTIGATE_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextEqualTo(String value) {
            addCriterion("INVESTIGATE_TEXT =", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextNotEqualTo(String value) {
            addCriterion("INVESTIGATE_TEXT <>", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextGreaterThan(String value) {
            addCriterion("INVESTIGATE_TEXT >", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextGreaterThanOrEqualTo(String value) {
            addCriterion("INVESTIGATE_TEXT >=", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextLessThan(String value) {
            addCriterion("INVESTIGATE_TEXT <", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextLessThanOrEqualTo(String value) {
            addCriterion("INVESTIGATE_TEXT <=", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextLike(String value) {
            addCriterion("INVESTIGATE_TEXT like", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextNotLike(String value) {
            addCriterion("INVESTIGATE_TEXT not like", value, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextIn(List<String> values) {
            addCriterion("INVESTIGATE_TEXT in", values, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextNotIn(List<String> values) {
            addCriterion("INVESTIGATE_TEXT not in", values, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextBetween(String value1, String value2) {
            addCriterion("INVESTIGATE_TEXT between", value1, value2, "investigateText");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextNotBetween(String value1, String value2) {
            addCriterion("INVESTIGATE_TEXT not between", value1, value2, "investigateText");
            return (Criteria) this;
        }

        public Criteria andBanFlagIsNull() {
            addCriterion("BAN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBanFlagIsNotNull() {
            addCriterion("BAN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBanFlagEqualTo(String value) {
            addCriterion("BAN_FLAG =", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagNotEqualTo(String value) {
            addCriterion("BAN_FLAG <>", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagGreaterThan(String value) {
            addCriterion("BAN_FLAG >", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagGreaterThanOrEqualTo(String value) {
            addCriterion("BAN_FLAG >=", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagLessThan(String value) {
            addCriterion("BAN_FLAG <", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagLessThanOrEqualTo(String value) {
            addCriterion("BAN_FLAG <=", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagLike(String value) {
            addCriterion("BAN_FLAG like", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagNotLike(String value) {
            addCriterion("BAN_FLAG not like", value, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagIn(List<String> values) {
            addCriterion("BAN_FLAG in", values, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagNotIn(List<String> values) {
            addCriterion("BAN_FLAG not in", values, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagBetween(String value1, String value2) {
            addCriterion("BAN_FLAG between", value1, value2, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanFlagNotBetween(String value1, String value2) {
            addCriterion("BAN_FLAG not between", value1, value2, "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanStartdateIsNull() {
            addCriterion("BAN_STARTDATE is null");
            return (Criteria) this;
        }

        public Criteria andBanStartdateIsNotNull() {
            addCriterion("BAN_STARTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBanStartdateEqualTo(String value) {
            addCriterion("BAN_STARTDATE =", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateNotEqualTo(String value) {
            addCriterion("BAN_STARTDATE <>", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateGreaterThan(String value) {
            addCriterion("BAN_STARTDATE >", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateGreaterThanOrEqualTo(String value) {
            addCriterion("BAN_STARTDATE >=", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateLessThan(String value) {
            addCriterion("BAN_STARTDATE <", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateLessThanOrEqualTo(String value) {
            addCriterion("BAN_STARTDATE <=", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateLike(String value) {
            addCriterion("BAN_STARTDATE like", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateNotLike(String value) {
            addCriterion("BAN_STARTDATE not like", value, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateIn(List<String> values) {
            addCriterion("BAN_STARTDATE in", values, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateNotIn(List<String> values) {
            addCriterion("BAN_STARTDATE not in", values, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateBetween(String value1, String value2) {
            addCriterion("BAN_STARTDATE between", value1, value2, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanStartdateNotBetween(String value1, String value2) {
            addCriterion("BAN_STARTDATE not between", value1, value2, "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateIsNull() {
            addCriterion("BAN_ENDDATE is null");
            return (Criteria) this;
        }

        public Criteria andBanEnddateIsNotNull() {
            addCriterion("BAN_ENDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBanEnddateEqualTo(String value) {
            addCriterion("BAN_ENDDATE =", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateNotEqualTo(String value) {
            addCriterion("BAN_ENDDATE <>", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateGreaterThan(String value) {
            addCriterion("BAN_ENDDATE >", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateGreaterThanOrEqualTo(String value) {
            addCriterion("BAN_ENDDATE >=", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateLessThan(String value) {
            addCriterion("BAN_ENDDATE <", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateLessThanOrEqualTo(String value) {
            addCriterion("BAN_ENDDATE <=", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateLike(String value) {
            addCriterion("BAN_ENDDATE like", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateNotLike(String value) {
            addCriterion("BAN_ENDDATE not like", value, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateIn(List<String> values) {
            addCriterion("BAN_ENDDATE in", values, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateNotIn(List<String> values) {
            addCriterion("BAN_ENDDATE not in", values, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateBetween(String value1, String value2) {
            addCriterion("BAN_ENDDATE between", value1, value2, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateNotBetween(String value1, String value2) {
            addCriterion("BAN_ENDDATE not between", value1, value2, "banEnddate");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(String value) {
            addCriterion("PAYMENT =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(String value) {
            addCriterion("PAYMENT <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(String value) {
            addCriterion("PAYMENT >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(String value) {
            addCriterion("PAYMENT <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLike(String value) {
            addCriterion("PAYMENT like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotLike(String value) {
            addCriterion("PAYMENT not like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<String> values) {
            addCriterion("PAYMENT in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<String> values) {
            addCriterion("PAYMENT not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(String value1, String value2) {
            addCriterion("PAYMENT between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(String value1, String value2) {
            addCriterion("PAYMENT not between", value1, value2, "payment");
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

        public Criteria andInfectionFlagLikeInsensitive(String value) {
            addCriterion("upper(INFECTION_FLAG) like", value.toUpperCase(), "infectionFlag");
            return (Criteria) this;
        }

        public Criteria andInfectionTextLikeInsensitive(String value) {
            addCriterion("upper(INFECTION_TEXT) like", value.toUpperCase(), "infectionText");
            return (Criteria) this;
        }

        public Criteria andCriminalFlagLikeInsensitive(String value) {
            addCriterion("upper(CRIMINAL_FLAG) like", value.toUpperCase(), "criminalFlag");
            return (Criteria) this;
        }

        public Criteria andCriminalTextLikeInsensitive(String value) {
            addCriterion("upper(CRIMINAL_TEXT) like", value.toUpperCase(), "criminalText");
            return (Criteria) this;
        }

        public Criteria andEmployFlagLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_FLAG) like", value.toUpperCase(), "employFlag");
            return (Criteria) this;
        }

        public Criteria andEmployTextLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_TEXT) like", value.toUpperCase(), "employText");
            return (Criteria) this;
        }

        public Criteria andInvestigateFlagLikeInsensitive(String value) {
            addCriterion("upper(INVESTIGATE_FLAG) like", value.toUpperCase(), "investigateFlag");
            return (Criteria) this;
        }

        public Criteria andInvestigateTextLikeInsensitive(String value) {
            addCriterion("upper(INVESTIGATE_TEXT) like", value.toUpperCase(), "investigateText");
            return (Criteria) this;
        }

        public Criteria andBanFlagLikeInsensitive(String value) {
            addCriterion("upper(BAN_FLAG) like", value.toUpperCase(), "banFlag");
            return (Criteria) this;
        }

        public Criteria andBanStartdateLikeInsensitive(String value) {
            addCriterion("upper(BAN_STARTDATE) like", value.toUpperCase(), "banStartdate");
            return (Criteria) this;
        }

        public Criteria andBanEnddateLikeInsensitive(String value) {
            addCriterion("upper(BAN_ENDDATE) like", value.toUpperCase(), "banEnddate");
            return (Criteria) this;
        }

        public Criteria andPaymentLikeInsensitive(String value) {
            addCriterion("upper(PAYMENT) like", value.toUpperCase(), "payment");
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