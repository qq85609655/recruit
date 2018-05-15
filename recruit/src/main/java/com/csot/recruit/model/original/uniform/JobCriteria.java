package com.csot.recruit.model.original.uniform;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class JobCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public JobCriteria() {
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

        public Criteria andCJobnameIsNull() {
            addCriterion("C_JOBNAME is null");
            return (Criteria) this;
        }

        public Criteria andCJobnameIsNotNull() {
            addCriterion("C_JOBNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCJobnameEqualTo(String value) {
            addCriterion("C_JOBNAME =", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameNotEqualTo(String value) {
            addCriterion("C_JOBNAME <>", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameGreaterThan(String value) {
            addCriterion("C_JOBNAME >", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameGreaterThanOrEqualTo(String value) {
            addCriterion("C_JOBNAME >=", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameLessThan(String value) {
            addCriterion("C_JOBNAME <", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameLessThanOrEqualTo(String value) {
            addCriterion("C_JOBNAME <=", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameLike(String value) {
            addCriterion("C_JOBNAME like", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameNotLike(String value) {
            addCriterion("C_JOBNAME not like", value, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameIn(List<String> values) {
            addCriterion("C_JOBNAME in", values, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameNotIn(List<String> values) {
            addCriterion("C_JOBNAME not in", values, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameBetween(String value1, String value2) {
            addCriterion("C_JOBNAME between", value1, value2, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCJobnameNotBetween(String value1, String value2) {
            addCriterion("C_JOBNAME not between", value1, value2, "cJobname");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeIsNull() {
            addCriterion("C_OLD_ORGCODE is null");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeIsNotNull() {
            addCriterion("C_OLD_ORGCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeEqualTo(String value) {
            addCriterion("C_OLD_ORGCODE =", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeNotEqualTo(String value) {
            addCriterion("C_OLD_ORGCODE <>", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeGreaterThan(String value) {
            addCriterion("C_OLD_ORGCODE >", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_OLD_ORGCODE >=", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeLessThan(String value) {
            addCriterion("C_OLD_ORGCODE <", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("C_OLD_ORGCODE <=", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeLike(String value) {
            addCriterion("C_OLD_ORGCODE like", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeNotLike(String value) {
            addCriterion("C_OLD_ORGCODE not like", value, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeIn(List<String> values) {
            addCriterion("C_OLD_ORGCODE in", values, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeNotIn(List<String> values) {
            addCriterion("C_OLD_ORGCODE not in", values, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeBetween(String value1, String value2) {
            addCriterion("C_OLD_ORGCODE between", value1, value2, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeNotBetween(String value1, String value2) {
            addCriterion("C_OLD_ORGCODE not between", value1, value2, "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeIsNull() {
            addCriterion("C_ORGCODE is null");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeIsNotNull() {
            addCriterion("C_ORGCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeEqualTo(String value) {
            addCriterion("C_ORGCODE =", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeNotEqualTo(String value) {
            addCriterion("C_ORGCODE <>", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeGreaterThan(String value) {
            addCriterion("C_ORGCODE >", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_ORGCODE >=", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeLessThan(String value) {
            addCriterion("C_ORGCODE <", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("C_ORGCODE <=", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeLike(String value) {
            addCriterion("C_ORGCODE like", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeNotLike(String value) {
            addCriterion("C_ORGCODE not like", value, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeIn(List<String> values) {
            addCriterion("C_ORGCODE in", values, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeNotIn(List<String> values) {
            addCriterion("C_ORGCODE not in", values, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeBetween(String value1, String value2) {
            addCriterion("C_ORGCODE between", value1, value2, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeNotBetween(String value1, String value2) {
            addCriterion("C_ORGCODE not between", value1, value2, "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeIsNull() {
            addCriterion("C_OLD_JOBCODE is null");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeIsNotNull() {
            addCriterion("C_OLD_JOBCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeEqualTo(String value) {
            addCriterion("C_OLD_JOBCODE =", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeNotEqualTo(String value) {
            addCriterion("C_OLD_JOBCODE <>", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeGreaterThan(String value) {
            addCriterion("C_OLD_JOBCODE >", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_OLD_JOBCODE >=", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeLessThan(String value) {
            addCriterion("C_OLD_JOBCODE <", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeLessThanOrEqualTo(String value) {
            addCriterion("C_OLD_JOBCODE <=", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeLike(String value) {
            addCriterion("C_OLD_JOBCODE like", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeNotLike(String value) {
            addCriterion("C_OLD_JOBCODE not like", value, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeIn(List<String> values) {
            addCriterion("C_OLD_JOBCODE in", values, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeNotIn(List<String> values) {
            addCriterion("C_OLD_JOBCODE not in", values, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeBetween(String value1, String value2) {
            addCriterion("C_OLD_JOBCODE between", value1, value2, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeNotBetween(String value1, String value2) {
            addCriterion("C_OLD_JOBCODE not between", value1, value2, "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeIsNull() {
            addCriterion("C_JOBCODE is null");
            return (Criteria) this;
        }

        public Criteria andCJobcodeIsNotNull() {
            addCriterion("C_JOBCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCJobcodeEqualTo(String value) {
            addCriterion("C_JOBCODE =", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeNotEqualTo(String value) {
            addCriterion("C_JOBCODE <>", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeGreaterThan(String value) {
            addCriterion("C_JOBCODE >", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_JOBCODE >=", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeLessThan(String value) {
            addCriterion("C_JOBCODE <", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeLessThanOrEqualTo(String value) {
            addCriterion("C_JOBCODE <=", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeLike(String value) {
            addCriterion("C_JOBCODE like", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeNotLike(String value) {
            addCriterion("C_JOBCODE not like", value, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeIn(List<String> values) {
            addCriterion("C_JOBCODE in", values, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeNotIn(List<String> values) {
            addCriterion("C_JOBCODE not in", values, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeBetween(String value1, String value2) {
            addCriterion("C_JOBCODE between", value1, value2, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeNotBetween(String value1, String value2) {
            addCriterion("C_JOBCODE not between", value1, value2, "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleIsNull() {
            addCriterion("C_IS_RESPONSIBLE is null");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleIsNotNull() {
            addCriterion("C_IS_RESPONSIBLE is not null");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleEqualTo(String value) {
            addCriterion("C_IS_RESPONSIBLE =", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleNotEqualTo(String value) {
            addCriterion("C_IS_RESPONSIBLE <>", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleGreaterThan(String value) {
            addCriterion("C_IS_RESPONSIBLE >", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleGreaterThanOrEqualTo(String value) {
            addCriterion("C_IS_RESPONSIBLE >=", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleLessThan(String value) {
            addCriterion("C_IS_RESPONSIBLE <", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleLessThanOrEqualTo(String value) {
            addCriterion("C_IS_RESPONSIBLE <=", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleLike(String value) {
            addCriterion("C_IS_RESPONSIBLE like", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleNotLike(String value) {
            addCriterion("C_IS_RESPONSIBLE not like", value, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleIn(List<String> values) {
            addCriterion("C_IS_RESPONSIBLE in", values, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleNotIn(List<String> values) {
            addCriterion("C_IS_RESPONSIBLE not in", values, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleBetween(String value1, String value2) {
            addCriterion("C_IS_RESPONSIBLE between", value1, value2, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleNotBetween(String value1, String value2) {
            addCriterion("C_IS_RESPONSIBLE not between", value1, value2, "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCAvailableIsNull() {
            addCriterion("C_AVAILABLE is null");
            return (Criteria) this;
        }

        public Criteria andCAvailableIsNotNull() {
            addCriterion("C_AVAILABLE is not null");
            return (Criteria) this;
        }

        public Criteria andCAvailableEqualTo(String value) {
            addCriterion("C_AVAILABLE =", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableNotEqualTo(String value) {
            addCriterion("C_AVAILABLE <>", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableGreaterThan(String value) {
            addCriterion("C_AVAILABLE >", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableGreaterThanOrEqualTo(String value) {
            addCriterion("C_AVAILABLE >=", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableLessThan(String value) {
            addCriterion("C_AVAILABLE <", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableLessThanOrEqualTo(String value) {
            addCriterion("C_AVAILABLE <=", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableLike(String value) {
            addCriterion("C_AVAILABLE like", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableNotLike(String value) {
            addCriterion("C_AVAILABLE not like", value, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableIn(List<String> values) {
            addCriterion("C_AVAILABLE in", values, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableNotIn(List<String> values) {
            addCriterion("C_AVAILABLE not in", values, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableBetween(String value1, String value2) {
            addCriterion("C_AVAILABLE between", value1, value2, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCAvailableNotBetween(String value1, String value2) {
            addCriterion("C_AVAILABLE not between", value1, value2, "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCSortIsNull() {
            addCriterion("C_SORT is null");
            return (Criteria) this;
        }

        public Criteria andCSortIsNotNull() {
            addCriterion("C_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andCSortEqualTo(BigDecimal value) {
            addCriterion("C_SORT =", value, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortNotEqualTo(BigDecimal value) {
            addCriterion("C_SORT <>", value, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortGreaterThan(BigDecimal value) {
            addCriterion("C_SORT >", value, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("C_SORT >=", value, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortLessThan(BigDecimal value) {
            addCriterion("C_SORT <", value, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortLessThanOrEqualTo(BigDecimal value) {
            addCriterion("C_SORT <=", value, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortIn(List<BigDecimal> values) {
            addCriterion("C_SORT in", values, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortNotIn(List<BigDecimal> values) {
            addCriterion("C_SORT not in", values, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("C_SORT between", value1, value2, "cSort");
            return (Criteria) this;
        }

        public Criteria andCSortNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("C_SORT not between", value1, value2, "cSort");
            return (Criteria) this;
        }

        public Criteria andCKeyIsNull() {
            addCriterion("C_KEY is null");
            return (Criteria) this;
        }

        public Criteria andCKeyIsNotNull() {
            addCriterion("C_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andCKeyEqualTo(String value) {
            addCriterion("C_KEY =", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyNotEqualTo(String value) {
            addCriterion("C_KEY <>", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyGreaterThan(String value) {
            addCriterion("C_KEY >", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyGreaterThanOrEqualTo(String value) {
            addCriterion("C_KEY >=", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyLessThan(String value) {
            addCriterion("C_KEY <", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyLessThanOrEqualTo(String value) {
            addCriterion("C_KEY <=", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyLike(String value) {
            addCriterion("C_KEY like", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyNotLike(String value) {
            addCriterion("C_KEY not like", value, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyIn(List<String> values) {
            addCriterion("C_KEY in", values, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyNotIn(List<String> values) {
            addCriterion("C_KEY not in", values, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyBetween(String value1, String value2) {
            addCriterion("C_KEY between", value1, value2, "cKey");
            return (Criteria) this;
        }

        public Criteria andCKeyNotBetween(String value1, String value2) {
            addCriterion("C_KEY not between", value1, value2, "cKey");
            return (Criteria) this;
        }

        public Criteria andCRemarkIsNull() {
            addCriterion("C_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andCRemarkIsNotNull() {
            addCriterion("C_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andCRemarkEqualTo(String value) {
            addCriterion("C_REMARK =", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotEqualTo(String value) {
            addCriterion("C_REMARK <>", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkGreaterThan(String value) {
            addCriterion("C_REMARK >", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("C_REMARK >=", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLessThan(String value) {
            addCriterion("C_REMARK <", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLessThanOrEqualTo(String value) {
            addCriterion("C_REMARK <=", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLike(String value) {
            addCriterion("C_REMARK like", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotLike(String value) {
            addCriterion("C_REMARK not like", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkIn(List<String> values) {
            addCriterion("C_REMARK in", values, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotIn(List<String> values) {
            addCriterion("C_REMARK not in", values, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkBetween(String value1, String value2) {
            addCriterion("C_REMARK between", value1, value2, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotBetween(String value1, String value2) {
            addCriterion("C_REMARK not between", value1, value2, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCStatusIsNull() {
            addCriterion("C_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCStatusIsNotNull() {
            addCriterion("C_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCStatusEqualTo(String value) {
            addCriterion("C_STATUS =", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotEqualTo(String value) {
            addCriterion("C_STATUS <>", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusGreaterThan(String value) {
            addCriterion("C_STATUS >", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusGreaterThanOrEqualTo(String value) {
            addCriterion("C_STATUS >=", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLessThan(String value) {
            addCriterion("C_STATUS <", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLessThanOrEqualTo(String value) {
            addCriterion("C_STATUS <=", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusLike(String value) {
            addCriterion("C_STATUS like", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotLike(String value) {
            addCriterion("C_STATUS not like", value, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusIn(List<String> values) {
            addCriterion("C_STATUS in", values, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotIn(List<String> values) {
            addCriterion("C_STATUS not in", values, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusBetween(String value1, String value2) {
            addCriterion("C_STATUS between", value1, value2, "cStatus");
            return (Criteria) this;
        }

        public Criteria andCStatusNotBetween(String value1, String value2) {
            addCriterion("C_STATUS not between", value1, value2, "cStatus");
            return (Criteria) this;
        }

        public Criteria andJobidIsNull() {
            addCriterion("JOBID is null");
            return (Criteria) this;
        }

        public Criteria andJobidIsNotNull() {
            addCriterion("JOBID is not null");
            return (Criteria) this;
        }

        public Criteria andJobidEqualTo(String value) {
            addCriterion("JOBID =", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotEqualTo(String value) {
            addCriterion("JOBID <>", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThan(String value) {
            addCriterion("JOBID >", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThanOrEqualTo(String value) {
            addCriterion("JOBID >=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThan(String value) {
            addCriterion("JOBID <", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThanOrEqualTo(String value) {
            addCriterion("JOBID <=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLike(String value) {
            addCriterion("JOBID like", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotLike(String value) {
            addCriterion("JOBID not like", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidIn(List<String> values) {
            addCriterion("JOBID in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotIn(List<String> values) {
            addCriterion("JOBID not in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidBetween(String value1, String value2) {
            addCriterion("JOBID between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotBetween(String value1, String value2) {
            addCriterion("JOBID not between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andIsTempJobIsNull() {
            addCriterion("IS_TEMP_JOB is null");
            return (Criteria) this;
        }

        public Criteria andIsTempJobIsNotNull() {
            addCriterion("IS_TEMP_JOB is not null");
            return (Criteria) this;
        }

        public Criteria andIsTempJobEqualTo(String value) {
            addCriterion("IS_TEMP_JOB =", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobNotEqualTo(String value) {
            addCriterion("IS_TEMP_JOB <>", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobGreaterThan(String value) {
            addCriterion("IS_TEMP_JOB >", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TEMP_JOB >=", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobLessThan(String value) {
            addCriterion("IS_TEMP_JOB <", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobLessThanOrEqualTo(String value) {
            addCriterion("IS_TEMP_JOB <=", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobLike(String value) {
            addCriterion("IS_TEMP_JOB like", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobNotLike(String value) {
            addCriterion("IS_TEMP_JOB not like", value, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobIn(List<String> values) {
            addCriterion("IS_TEMP_JOB in", values, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobNotIn(List<String> values) {
            addCriterion("IS_TEMP_JOB not in", values, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobBetween(String value1, String value2) {
            addCriterion("IS_TEMP_JOB between", value1, value2, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andIsTempJobNotBetween(String value1, String value2) {
            addCriterion("IS_TEMP_JOB not between", value1, value2, "isTempJob");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeIsNull() {
            addCriterion("C_OPERATORTIME is null");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeIsNotNull() {
            addCriterion("C_OPERATORTIME is not null");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeEqualTo(Date value) {
            addCriterionForJDBCDate("C_OPERATORTIME =", value, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("C_OPERATORTIME <>", value, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeGreaterThan(Date value) {
            addCriterionForJDBCDate("C_OPERATORTIME >", value, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("C_OPERATORTIME >=", value, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeLessThan(Date value) {
            addCriterionForJDBCDate("C_OPERATORTIME <", value, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("C_OPERATORTIME <=", value, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeIn(List<Date> values) {
            addCriterionForJDBCDate("C_OPERATORTIME in", values, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("C_OPERATORTIME not in", values, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("C_OPERATORTIME between", value1, value2, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andCOperatortimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("C_OPERATORTIME not between", value1, value2, "cOperatortime");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyIsNull() {
            addCriterion("FD_PRIMARY_KEY is null");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyIsNotNull() {
            addCriterion("FD_PRIMARY_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyEqualTo(String value) {
            addCriterion("FD_PRIMARY_KEY =", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyNotEqualTo(String value) {
            addCriterion("FD_PRIMARY_KEY <>", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyGreaterThan(String value) {
            addCriterion("FD_PRIMARY_KEY >", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyGreaterThanOrEqualTo(String value) {
            addCriterion("FD_PRIMARY_KEY >=", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyLessThan(String value) {
            addCriterion("FD_PRIMARY_KEY <", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyLessThanOrEqualTo(String value) {
            addCriterion("FD_PRIMARY_KEY <=", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyLike(String value) {
            addCriterion("FD_PRIMARY_KEY like", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyNotLike(String value) {
            addCriterion("FD_PRIMARY_KEY not like", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyIn(List<String> values) {
            addCriterion("FD_PRIMARY_KEY in", values, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyNotIn(List<String> values) {
            addCriterion("FD_PRIMARY_KEY not in", values, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyBetween(String value1, String value2) {
            addCriterion("FD_PRIMARY_KEY between", value1, value2, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyNotBetween(String value1, String value2) {
            addCriterion("FD_PRIMARY_KEY not between", value1, value2, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdStatusIsNull() {
            addCriterion("FD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFdStatusIsNotNull() {
            addCriterion("FD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFdStatusEqualTo(String value) {
            addCriterion("FD_STATUS =", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusNotEqualTo(String value) {
            addCriterion("FD_STATUS <>", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusGreaterThan(String value) {
            addCriterion("FD_STATUS >", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("FD_STATUS >=", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusLessThan(String value) {
            addCriterion("FD_STATUS <", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusLessThanOrEqualTo(String value) {
            addCriterion("FD_STATUS <=", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusLike(String value) {
            addCriterion("FD_STATUS like", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusNotLike(String value) {
            addCriterion("FD_STATUS not like", value, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusIn(List<String> values) {
            addCriterion("FD_STATUS in", values, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusNotIn(List<String> values) {
            addCriterion("FD_STATUS not in", values, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusBetween(String value1, String value2) {
            addCriterion("FD_STATUS between", value1, value2, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdStatusNotBetween(String value1, String value2) {
            addCriterion("FD_STATUS not between", value1, value2, "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeIsNull() {
            addCriterion("FD_EXCUTE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeIsNotNull() {
            addCriterion("FD_EXCUTE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeEqualTo(Date value) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME =", value, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME <>", value, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME >", value, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME >=", value, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeLessThan(Date value) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME <", value, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME <=", value, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeIn(List<Date> values) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME in", values, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME not in", values, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME between", value1, value2, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdExcuteTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FD_EXCUTE_TIME not between", value1, value2, "fdExcuteTime");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedIsNull() {
            addCriterion("FD_IS_UPDATED is null");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedIsNotNull() {
            addCriterion("FD_IS_UPDATED is not null");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedEqualTo(String value) {
            addCriterion("FD_IS_UPDATED =", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedNotEqualTo(String value) {
            addCriterion("FD_IS_UPDATED <>", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedGreaterThan(String value) {
            addCriterion("FD_IS_UPDATED >", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedGreaterThanOrEqualTo(String value) {
            addCriterion("FD_IS_UPDATED >=", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedLessThan(String value) {
            addCriterion("FD_IS_UPDATED <", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedLessThanOrEqualTo(String value) {
            addCriterion("FD_IS_UPDATED <=", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedLike(String value) {
            addCriterion("FD_IS_UPDATED like", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedNotLike(String value) {
            addCriterion("FD_IS_UPDATED not like", value, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedIn(List<String> values) {
            addCriterion("FD_IS_UPDATED in", values, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedNotIn(List<String> values) {
            addCriterion("FD_IS_UPDATED not in", values, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedBetween(String value1, String value2) {
            addCriterion("FD_IS_UPDATED between", value1, value2, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedNotBetween(String value1, String value2) {
            addCriterion("FD_IS_UPDATED not between", value1, value2, "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoIsNull() {
            addCriterion("FD_UPDATE_EMP_NO is null");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoIsNotNull() {
            addCriterion("FD_UPDATE_EMP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoEqualTo(String value) {
            addCriterion("FD_UPDATE_EMP_NO =", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoNotEqualTo(String value) {
            addCriterion("FD_UPDATE_EMP_NO <>", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoGreaterThan(String value) {
            addCriterion("FD_UPDATE_EMP_NO >", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoGreaterThanOrEqualTo(String value) {
            addCriterion("FD_UPDATE_EMP_NO >=", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoLessThan(String value) {
            addCriterion("FD_UPDATE_EMP_NO <", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoLessThanOrEqualTo(String value) {
            addCriterion("FD_UPDATE_EMP_NO <=", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoLike(String value) {
            addCriterion("FD_UPDATE_EMP_NO like", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoNotLike(String value) {
            addCriterion("FD_UPDATE_EMP_NO not like", value, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoIn(List<String> values) {
            addCriterion("FD_UPDATE_EMP_NO in", values, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoNotIn(List<String> values) {
            addCriterion("FD_UPDATE_EMP_NO not in", values, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoBetween(String value1, String value2) {
            addCriterion("FD_UPDATE_EMP_NO between", value1, value2, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoNotBetween(String value1, String value2) {
            addCriterion("FD_UPDATE_EMP_NO not between", value1, value2, "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeIsNull() {
            addCriterion("FD_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeIsNotNull() {
            addCriterion("FD_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("FD_UPDATE_TIME =", value, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("FD_UPDATE_TIME <>", value, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("FD_UPDATE_TIME >", value, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FD_UPDATE_TIME >=", value, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("FD_UPDATE_TIME <", value, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FD_UPDATE_TIME <=", value, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("FD_UPDATE_TIME in", values, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("FD_UPDATE_TIME not in", values, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FD_UPDATE_TIME between", value1, value2, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFdUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FD_UPDATE_TIME not between", value1, value2, "fdUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNull() {
            addCriterion("RESERVED_1 is null");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNotNull() {
            addCriterion("RESERVED_1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved1EqualTo(String value) {
            addCriterion("RESERVED_1 =", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotEqualTo(String value) {
            addCriterion("RESERVED_1 <>", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThan(String value) {
            addCriterion("RESERVED_1 >", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_1 >=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThan(String value) {
            addCriterion("RESERVED_1 <", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_1 <=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1Like(String value) {
            addCriterion("RESERVED_1 like", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotLike(String value) {
            addCriterion("RESERVED_1 not like", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1In(List<String> values) {
            addCriterion("RESERVED_1 in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotIn(List<String> values) {
            addCriterion("RESERVED_1 not in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1Between(String value1, String value2) {
            addCriterion("RESERVED_1 between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotBetween(String value1, String value2) {
            addCriterion("RESERVED_1 not between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNull() {
            addCriterion("RESERVED_2 is null");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNotNull() {
            addCriterion("RESERVED_2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved2EqualTo(String value) {
            addCriterion("RESERVED_2 =", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotEqualTo(String value) {
            addCriterion("RESERVED_2 <>", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThan(String value) {
            addCriterion("RESERVED_2 >", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_2 >=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThan(String value) {
            addCriterion("RESERVED_2 <", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_2 <=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2Like(String value) {
            addCriterion("RESERVED_2 like", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotLike(String value) {
            addCriterion("RESERVED_2 not like", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2In(List<String> values) {
            addCriterion("RESERVED_2 in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotIn(List<String> values) {
            addCriterion("RESERVED_2 not in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2Between(String value1, String value2) {
            addCriterion("RESERVED_2 between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotBetween(String value1, String value2) {
            addCriterion("RESERVED_2 not between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved3IsNull() {
            addCriterion("RESERVED_3 is null");
            return (Criteria) this;
        }

        public Criteria andReserved3IsNotNull() {
            addCriterion("RESERVED_3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved3EqualTo(String value) {
            addCriterion("RESERVED_3 =", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotEqualTo(String value) {
            addCriterion("RESERVED_3 <>", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3GreaterThan(String value) {
            addCriterion("RESERVED_3 >", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_3 >=", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3LessThan(String value) {
            addCriterion("RESERVED_3 <", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_3 <=", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3Like(String value) {
            addCriterion("RESERVED_3 like", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotLike(String value) {
            addCriterion("RESERVED_3 not like", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3In(List<String> values) {
            addCriterion("RESERVED_3 in", values, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotIn(List<String> values) {
            addCriterion("RESERVED_3 not in", values, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3Between(String value1, String value2) {
            addCriterion("RESERVED_3 between", value1, value2, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotBetween(String value1, String value2) {
            addCriterion("RESERVED_3 not between", value1, value2, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved4IsNull() {
            addCriterion("RESERVED_4 is null");
            return (Criteria) this;
        }

        public Criteria andReserved4IsNotNull() {
            addCriterion("RESERVED_4 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved4EqualTo(String value) {
            addCriterion("RESERVED_4 =", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotEqualTo(String value) {
            addCriterion("RESERVED_4 <>", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4GreaterThan(String value) {
            addCriterion("RESERVED_4 >", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_4 >=", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4LessThan(String value) {
            addCriterion("RESERVED_4 <", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_4 <=", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4Like(String value) {
            addCriterion("RESERVED_4 like", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotLike(String value) {
            addCriterion("RESERVED_4 not like", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4In(List<String> values) {
            addCriterion("RESERVED_4 in", values, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotIn(List<String> values) {
            addCriterion("RESERVED_4 not in", values, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4Between(String value1, String value2) {
            addCriterion("RESERVED_4 between", value1, value2, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotBetween(String value1, String value2) {
            addCriterion("RESERVED_4 not between", value1, value2, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved5IsNull() {
            addCriterion("RESERVED_5 is null");
            return (Criteria) this;
        }

        public Criteria andReserved5IsNotNull() {
            addCriterion("RESERVED_5 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved5EqualTo(String value) {
            addCriterion("RESERVED_5 =", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotEqualTo(String value) {
            addCriterion("RESERVED_5 <>", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5GreaterThan(String value) {
            addCriterion("RESERVED_5 >", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_5 >=", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5LessThan(String value) {
            addCriterion("RESERVED_5 <", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_5 <=", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5Like(String value) {
            addCriterion("RESERVED_5 like", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotLike(String value) {
            addCriterion("RESERVED_5 not like", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5In(List<String> values) {
            addCriterion("RESERVED_5 in", values, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotIn(List<String> values) {
            addCriterion("RESERVED_5 not in", values, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5Between(String value1, String value2) {
            addCriterion("RESERVED_5 between", value1, value2, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotBetween(String value1, String value2) {
            addCriterion("RESERVED_5 not between", value1, value2, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved6IsNull() {
            addCriterion("RESERVED_6 is null");
            return (Criteria) this;
        }

        public Criteria andReserved6IsNotNull() {
            addCriterion("RESERVED_6 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved6EqualTo(String value) {
            addCriterion("RESERVED_6 =", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotEqualTo(String value) {
            addCriterion("RESERVED_6 <>", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6GreaterThan(String value) {
            addCriterion("RESERVED_6 >", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_6 >=", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6LessThan(String value) {
            addCriterion("RESERVED_6 <", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_6 <=", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6Like(String value) {
            addCriterion("RESERVED_6 like", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotLike(String value) {
            addCriterion("RESERVED_6 not like", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6In(List<String> values) {
            addCriterion("RESERVED_6 in", values, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotIn(List<String> values) {
            addCriterion("RESERVED_6 not in", values, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6Between(String value1, String value2) {
            addCriterion("RESERVED_6 between", value1, value2, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotBetween(String value1, String value2) {
            addCriterion("RESERVED_6 not between", value1, value2, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved7IsNull() {
            addCriterion("RESERVED_7 is null");
            return (Criteria) this;
        }

        public Criteria andReserved7IsNotNull() {
            addCriterion("RESERVED_7 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved7EqualTo(String value) {
            addCriterion("RESERVED_7 =", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotEqualTo(String value) {
            addCriterion("RESERVED_7 <>", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7GreaterThan(String value) {
            addCriterion("RESERVED_7 >", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_7 >=", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7LessThan(String value) {
            addCriterion("RESERVED_7 <", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_7 <=", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7Like(String value) {
            addCriterion("RESERVED_7 like", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotLike(String value) {
            addCriterion("RESERVED_7 not like", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7In(List<String> values) {
            addCriterion("RESERVED_7 in", values, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotIn(List<String> values) {
            addCriterion("RESERVED_7 not in", values, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7Between(String value1, String value2) {
            addCriterion("RESERVED_7 between", value1, value2, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotBetween(String value1, String value2) {
            addCriterion("RESERVED_7 not between", value1, value2, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved8IsNull() {
            addCriterion("RESERVED_8 is null");
            return (Criteria) this;
        }

        public Criteria andReserved8IsNotNull() {
            addCriterion("RESERVED_8 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved8EqualTo(String value) {
            addCriterion("RESERVED_8 =", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotEqualTo(String value) {
            addCriterion("RESERVED_8 <>", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8GreaterThan(String value) {
            addCriterion("RESERVED_8 >", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_8 >=", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8LessThan(String value) {
            addCriterion("RESERVED_8 <", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_8 <=", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8Like(String value) {
            addCriterion("RESERVED_8 like", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotLike(String value) {
            addCriterion("RESERVED_8 not like", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8In(List<String> values) {
            addCriterion("RESERVED_8 in", values, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotIn(List<String> values) {
            addCriterion("RESERVED_8 not in", values, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8Between(String value1, String value2) {
            addCriterion("RESERVED_8 between", value1, value2, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotBetween(String value1, String value2) {
            addCriterion("RESERVED_8 not between", value1, value2, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved9IsNull() {
            addCriterion("RESERVED_9 is null");
            return (Criteria) this;
        }

        public Criteria andReserved9IsNotNull() {
            addCriterion("RESERVED_9 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved9EqualTo(String value) {
            addCriterion("RESERVED_9 =", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotEqualTo(String value) {
            addCriterion("RESERVED_9 <>", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9GreaterThan(String value) {
            addCriterion("RESERVED_9 >", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_9 >=", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9LessThan(String value) {
            addCriterion("RESERVED_9 <", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_9 <=", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9Like(String value) {
            addCriterion("RESERVED_9 like", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotLike(String value) {
            addCriterion("RESERVED_9 not like", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9In(List<String> values) {
            addCriterion("RESERVED_9 in", values, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotIn(List<String> values) {
            addCriterion("RESERVED_9 not in", values, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9Between(String value1, String value2) {
            addCriterion("RESERVED_9 between", value1, value2, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotBetween(String value1, String value2) {
            addCriterion("RESERVED_9 not between", value1, value2, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved10IsNull() {
            addCriterion("RESERVED_10 is null");
            return (Criteria) this;
        }

        public Criteria andReserved10IsNotNull() {
            addCriterion("RESERVED_10 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved10EqualTo(String value) {
            addCriterion("RESERVED_10 =", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotEqualTo(String value) {
            addCriterion("RESERVED_10 <>", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10GreaterThan(String value) {
            addCriterion("RESERVED_10 >", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_10 >=", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10LessThan(String value) {
            addCriterion("RESERVED_10 <", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_10 <=", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10Like(String value) {
            addCriterion("RESERVED_10 like", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotLike(String value) {
            addCriterion("RESERVED_10 not like", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10In(List<String> values) {
            addCriterion("RESERVED_10 in", values, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotIn(List<String> values) {
            addCriterion("RESERVED_10 not in", values, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10Between(String value1, String value2) {
            addCriterion("RESERVED_10 between", value1, value2, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotBetween(String value1, String value2) {
            addCriterion("RESERVED_10 not between", value1, value2, "reserved10");
            return (Criteria) this;
        }

        public Criteria andCJobnameLikeInsensitive(String value) {
            addCriterion("upper(C_JOBNAME) like", value.toUpperCase(), "cJobname");
            return (Criteria) this;
        }

        public Criteria andCOldOrgcodeLikeInsensitive(String value) {
            addCriterion("upper(C_OLD_ORGCODE) like", value.toUpperCase(), "cOldOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOrgcodeLikeInsensitive(String value) {
            addCriterion("upper(C_ORGCODE) like", value.toUpperCase(), "cOrgcode");
            return (Criteria) this;
        }

        public Criteria andCOldJobcodeLikeInsensitive(String value) {
            addCriterion("upper(C_OLD_JOBCODE) like", value.toUpperCase(), "cOldJobcode");
            return (Criteria) this;
        }

        public Criteria andCJobcodeLikeInsensitive(String value) {
            addCriterion("upper(C_JOBCODE) like", value.toUpperCase(), "cJobcode");
            return (Criteria) this;
        }

        public Criteria andCIsResponsibleLikeInsensitive(String value) {
            addCriterion("upper(C_IS_RESPONSIBLE) like", value.toUpperCase(), "cIsResponsible");
            return (Criteria) this;
        }

        public Criteria andCAvailableLikeInsensitive(String value) {
            addCriterion("upper(C_AVAILABLE) like", value.toUpperCase(), "cAvailable");
            return (Criteria) this;
        }

        public Criteria andCKeyLikeInsensitive(String value) {
            addCriterion("upper(C_KEY) like", value.toUpperCase(), "cKey");
            return (Criteria) this;
        }

        public Criteria andCRemarkLikeInsensitive(String value) {
            addCriterion("upper(C_REMARK) like", value.toUpperCase(), "cRemark");
            return (Criteria) this;
        }

        public Criteria andCStatusLikeInsensitive(String value) {
            addCriterion("upper(C_STATUS) like", value.toUpperCase(), "cStatus");
            return (Criteria) this;
        }

        public Criteria andJobidLikeInsensitive(String value) {
            addCriterion("upper(JOBID) like", value.toUpperCase(), "jobid");
            return (Criteria) this;
        }

        public Criteria andIsTempJobLikeInsensitive(String value) {
            addCriterion("upper(IS_TEMP_JOB) like", value.toUpperCase(), "isTempJob");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyLikeInsensitive(String value) {
            addCriterion("upper(FD_PRIMARY_KEY) like", value.toUpperCase(), "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdStatusLikeInsensitive(String value) {
            addCriterion("upper(FD_STATUS) like", value.toUpperCase(), "fdStatus");
            return (Criteria) this;
        }

        public Criteria andFdIsUpdatedLikeInsensitive(String value) {
            addCriterion("upper(FD_IS_UPDATED) like", value.toUpperCase(), "fdIsUpdated");
            return (Criteria) this;
        }

        public Criteria andFdUpdateEmpNoLikeInsensitive(String value) {
            addCriterion("upper(FD_UPDATE_EMP_NO) like", value.toUpperCase(), "fdUpdateEmpNo");
            return (Criteria) this;
        }

        public Criteria andReserved1LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_1) like", value.toUpperCase(), "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved2LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_2) like", value.toUpperCase(), "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved3LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_3) like", value.toUpperCase(), "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved4LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_4) like", value.toUpperCase(), "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved5LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_5) like", value.toUpperCase(), "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved6LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_6) like", value.toUpperCase(), "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved7LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_7) like", value.toUpperCase(), "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved8LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_8) like", value.toUpperCase(), "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved9LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_9) like", value.toUpperCase(), "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved10LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_10) like", value.toUpperCase(), "reserved10");
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