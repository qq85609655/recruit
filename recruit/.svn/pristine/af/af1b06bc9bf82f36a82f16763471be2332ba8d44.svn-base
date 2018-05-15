package com.csot.recruit.model.original.uniform;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class OrganizationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OrganizationCriteria() {
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

        public Criteria andCOrgnameIsNull() {
            addCriterion("C_ORGNAME is null");
            return (Criteria) this;
        }

        public Criteria andCOrgnameIsNotNull() {
            addCriterion("C_ORGNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCOrgnameEqualTo(String value) {
            addCriterion("C_ORGNAME =", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameNotEqualTo(String value) {
            addCriterion("C_ORGNAME <>", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameGreaterThan(String value) {
            addCriterion("C_ORGNAME >", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("C_ORGNAME >=", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameLessThan(String value) {
            addCriterion("C_ORGNAME <", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameLessThanOrEqualTo(String value) {
            addCriterion("C_ORGNAME <=", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameLike(String value) {
            addCriterion("C_ORGNAME like", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameNotLike(String value) {
            addCriterion("C_ORGNAME not like", value, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameIn(List<String> values) {
            addCriterion("C_ORGNAME in", values, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameNotIn(List<String> values) {
            addCriterion("C_ORGNAME not in", values, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameBetween(String value1, String value2) {
            addCriterion("C_ORGNAME between", value1, value2, "cOrgname");
            return (Criteria) this;
        }

        public Criteria andCOrgnameNotBetween(String value1, String value2) {
            addCriterion("C_ORGNAME not between", value1, value2, "cOrgname");
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

        public Criteria andCOrgtypeIsNull() {
            addCriterion("C_ORGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeIsNotNull() {
            addCriterion("C_ORGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeEqualTo(BigDecimal value) {
            addCriterion("C_ORGTYPE =", value, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeNotEqualTo(BigDecimal value) {
            addCriterion("C_ORGTYPE <>", value, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeGreaterThan(BigDecimal value) {
            addCriterion("C_ORGTYPE >", value, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("C_ORGTYPE >=", value, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeLessThan(BigDecimal value) {
            addCriterion("C_ORGTYPE <", value, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("C_ORGTYPE <=", value, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeIn(List<BigDecimal> values) {
            addCriterion("C_ORGTYPE in", values, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeNotIn(List<BigDecimal> values) {
            addCriterion("C_ORGTYPE not in", values, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("C_ORGTYPE between", value1, value2, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOrgtypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("C_ORGTYPE not between", value1, value2, "cOrgtype");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeIsNull() {
            addCriterion("C_OLD_CHARGECODE is null");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeIsNotNull() {
            addCriterion("C_OLD_CHARGECODE is not null");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeEqualTo(String value) {
            addCriterion("C_OLD_CHARGECODE =", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeNotEqualTo(String value) {
            addCriterion("C_OLD_CHARGECODE <>", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeGreaterThan(String value) {
            addCriterion("C_OLD_CHARGECODE >", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_OLD_CHARGECODE >=", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeLessThan(String value) {
            addCriterion("C_OLD_CHARGECODE <", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeLessThanOrEqualTo(String value) {
            addCriterion("C_OLD_CHARGECODE <=", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeLike(String value) {
            addCriterion("C_OLD_CHARGECODE like", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeNotLike(String value) {
            addCriterion("C_OLD_CHARGECODE not like", value, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeIn(List<String> values) {
            addCriterion("C_OLD_CHARGECODE in", values, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeNotIn(List<String> values) {
            addCriterion("C_OLD_CHARGECODE not in", values, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeBetween(String value1, String value2) {
            addCriterion("C_OLD_CHARGECODE between", value1, value2, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldChargecodeNotBetween(String value1, String value2) {
            addCriterion("C_OLD_CHARGECODE not between", value1, value2, "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeIsNull() {
            addCriterion("C_CHARGECODE is null");
            return (Criteria) this;
        }

        public Criteria andCChargecodeIsNotNull() {
            addCriterion("C_CHARGECODE is not null");
            return (Criteria) this;
        }

        public Criteria andCChargecodeEqualTo(String value) {
            addCriterion("C_CHARGECODE =", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeNotEqualTo(String value) {
            addCriterion("C_CHARGECODE <>", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeGreaterThan(String value) {
            addCriterion("C_CHARGECODE >", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_CHARGECODE >=", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeLessThan(String value) {
            addCriterion("C_CHARGECODE <", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeLessThanOrEqualTo(String value) {
            addCriterion("C_CHARGECODE <=", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeLike(String value) {
            addCriterion("C_CHARGECODE like", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeNotLike(String value) {
            addCriterion("C_CHARGECODE not like", value, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeIn(List<String> values) {
            addCriterion("C_CHARGECODE in", values, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeNotIn(List<String> values) {
            addCriterion("C_CHARGECODE not in", values, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeBetween(String value1, String value2) {
            addCriterion("C_CHARGECODE between", value1, value2, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeNotBetween(String value1, String value2) {
            addCriterion("C_CHARGECODE not between", value1, value2, "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeIsNull() {
            addCriterion("C_OLD_ORGPARENTCODE is null");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeIsNotNull() {
            addCriterion("C_OLD_ORGPARENTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTCODE =", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeNotEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTCODE <>", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeGreaterThan(String value) {
            addCriterion("C_OLD_ORGPARENTCODE >", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTCODE >=", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeLessThan(String value) {
            addCriterion("C_OLD_ORGPARENTCODE <", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeLessThanOrEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTCODE <=", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeLike(String value) {
            addCriterion("C_OLD_ORGPARENTCODE like", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeNotLike(String value) {
            addCriterion("C_OLD_ORGPARENTCODE not like", value, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeIn(List<String> values) {
            addCriterion("C_OLD_ORGPARENTCODE in", values, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeNotIn(List<String> values) {
            addCriterion("C_OLD_ORGPARENTCODE not in", values, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeBetween(String value1, String value2) {
            addCriterion("C_OLD_ORGPARENTCODE between", value1, value2, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeNotBetween(String value1, String value2) {
            addCriterion("C_OLD_ORGPARENTCODE not between", value1, value2, "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeIsNull() {
            addCriterion("C_ORGPARENTCODE is null");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeIsNotNull() {
            addCriterion("C_ORGPARENTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeEqualTo(String value) {
            addCriterion("C_ORGPARENTCODE =", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeNotEqualTo(String value) {
            addCriterion("C_ORGPARENTCODE <>", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeGreaterThan(String value) {
            addCriterion("C_ORGPARENTCODE >", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_ORGPARENTCODE >=", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeLessThan(String value) {
            addCriterion("C_ORGPARENTCODE <", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeLessThanOrEqualTo(String value) {
            addCriterion("C_ORGPARENTCODE <=", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeLike(String value) {
            addCriterion("C_ORGPARENTCODE like", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeNotLike(String value) {
            addCriterion("C_ORGPARENTCODE not like", value, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeIn(List<String> values) {
            addCriterion("C_ORGPARENTCODE in", values, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeNotIn(List<String> values) {
            addCriterion("C_ORGPARENTCODE not in", values, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeBetween(String value1, String value2) {
            addCriterion("C_ORGPARENTCODE between", value1, value2, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeNotBetween(String value1, String value2) {
            addCriterion("C_ORGPARENTCODE not between", value1, value2, "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadIsNull() {
            addCriterion("C_OLD_ORGPARENTLEAD is null");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadIsNotNull() {
            addCriterion("C_OLD_ORGPARENTLEAD is not null");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD =", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadNotEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD <>", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadGreaterThan(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD >", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadGreaterThanOrEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD >=", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadLessThan(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD <", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadLessThanOrEqualTo(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD <=", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadLike(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD like", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadNotLike(String value) {
            addCriterion("C_OLD_ORGPARENTLEAD not like", value, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadIn(List<String> values) {
            addCriterion("C_OLD_ORGPARENTLEAD in", values, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadNotIn(List<String> values) {
            addCriterion("C_OLD_ORGPARENTLEAD not in", values, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadBetween(String value1, String value2) {
            addCriterion("C_OLD_ORGPARENTLEAD between", value1, value2, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadNotBetween(String value1, String value2) {
            addCriterion("C_OLD_ORGPARENTLEAD not between", value1, value2, "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadIsNull() {
            addCriterion("C_ORGPARENTLEAD is null");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadIsNotNull() {
            addCriterion("C_ORGPARENTLEAD is not null");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadEqualTo(String value) {
            addCriterion("C_ORGPARENTLEAD =", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadNotEqualTo(String value) {
            addCriterion("C_ORGPARENTLEAD <>", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadGreaterThan(String value) {
            addCriterion("C_ORGPARENTLEAD >", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadGreaterThanOrEqualTo(String value) {
            addCriterion("C_ORGPARENTLEAD >=", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadLessThan(String value) {
            addCriterion("C_ORGPARENTLEAD <", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadLessThanOrEqualTo(String value) {
            addCriterion("C_ORGPARENTLEAD <=", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadLike(String value) {
            addCriterion("C_ORGPARENTLEAD like", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadNotLike(String value) {
            addCriterion("C_ORGPARENTLEAD not like", value, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadIn(List<String> values) {
            addCriterion("C_ORGPARENTLEAD in", values, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadNotIn(List<String> values) {
            addCriterion("C_ORGPARENTLEAD not in", values, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadBetween(String value1, String value2) {
            addCriterion("C_ORGPARENTLEAD between", value1, value2, "cOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadNotBetween(String value1, String value2) {
            addCriterion("C_ORGPARENTLEAD not between", value1, value2, "cOrgparentlead");
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

        public Criteria andOrgidIsNull() {
            addCriterion("ORGID is null");
            return (Criteria) this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("ORGID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgidEqualTo(String value) {
            addCriterion("ORGID =", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotEqualTo(String value) {
            addCriterion("ORGID <>", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThan(String value) {
            addCriterion("ORGID >", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(String value) {
            addCriterion("ORGID >=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThan(String value) {
            addCriterion("ORGID <", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLessThanOrEqualTo(String value) {
            addCriterion("ORGID <=", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidLike(String value) {
            addCriterion("ORGID like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotLike(String value) {
            addCriterion("ORGID not like", value, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidIn(List<String> values) {
            addCriterion("ORGID in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotIn(List<String> values) {
            addCriterion("ORGID not in", values, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidBetween(String value1, String value2) {
            addCriterion("ORGID between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andOrgidNotBetween(String value1, String value2) {
            addCriterion("ORGID not between", value1, value2, "orgid");
            return (Criteria) this;
        }

        public Criteria andKostlIsNull() {
            addCriterion("KOSTL is null");
            return (Criteria) this;
        }

        public Criteria andKostlIsNotNull() {
            addCriterion("KOSTL is not null");
            return (Criteria) this;
        }

        public Criteria andKostlEqualTo(String value) {
            addCriterion("KOSTL =", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlNotEqualTo(String value) {
            addCriterion("KOSTL <>", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlGreaterThan(String value) {
            addCriterion("KOSTL >", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlGreaterThanOrEqualTo(String value) {
            addCriterion("KOSTL >=", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlLessThan(String value) {
            addCriterion("KOSTL <", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlLessThanOrEqualTo(String value) {
            addCriterion("KOSTL <=", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlLike(String value) {
            addCriterion("KOSTL like", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlNotLike(String value) {
            addCriterion("KOSTL not like", value, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlIn(List<String> values) {
            addCriterion("KOSTL in", values, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlNotIn(List<String> values) {
            addCriterion("KOSTL not in", values, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlBetween(String value1, String value2) {
            addCriterion("KOSTL between", value1, value2, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostlNotBetween(String value1, String value2) {
            addCriterion("KOSTL not between", value1, value2, "kostl");
            return (Criteria) this;
        }

        public Criteria andKostltIsNull() {
            addCriterion("KOSTLT is null");
            return (Criteria) this;
        }

        public Criteria andKostltIsNotNull() {
            addCriterion("KOSTLT is not null");
            return (Criteria) this;
        }

        public Criteria andKostltEqualTo(String value) {
            addCriterion("KOSTLT =", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltNotEqualTo(String value) {
            addCriterion("KOSTLT <>", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltGreaterThan(String value) {
            addCriterion("KOSTLT >", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltGreaterThanOrEqualTo(String value) {
            addCriterion("KOSTLT >=", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltLessThan(String value) {
            addCriterion("KOSTLT <", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltLessThanOrEqualTo(String value) {
            addCriterion("KOSTLT <=", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltLike(String value) {
            addCriterion("KOSTLT like", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltNotLike(String value) {
            addCriterion("KOSTLT not like", value, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltIn(List<String> values) {
            addCriterion("KOSTLT in", values, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltNotIn(List<String> values) {
            addCriterion("KOSTLT not in", values, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltBetween(String value1, String value2) {
            addCriterion("KOSTLT between", value1, value2, "kostlt");
            return (Criteria) this;
        }

        public Criteria andKostltNotBetween(String value1, String value2) {
            addCriterion("KOSTLT not between", value1, value2, "kostlt");
            return (Criteria) this;
        }

        public Criteria andCOneunitIsNull() {
            addCriterion("C_ONEUNIT is null");
            return (Criteria) this;
        }

        public Criteria andCOneunitIsNotNull() {
            addCriterion("C_ONEUNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCOneunitEqualTo(String value) {
            addCriterion("C_ONEUNIT =", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitNotEqualTo(String value) {
            addCriterion("C_ONEUNIT <>", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitGreaterThan(String value) {
            addCriterion("C_ONEUNIT >", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitGreaterThanOrEqualTo(String value) {
            addCriterion("C_ONEUNIT >=", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitLessThan(String value) {
            addCriterion("C_ONEUNIT <", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitLessThanOrEqualTo(String value) {
            addCriterion("C_ONEUNIT <=", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitLike(String value) {
            addCriterion("C_ONEUNIT like", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitNotLike(String value) {
            addCriterion("C_ONEUNIT not like", value, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitIn(List<String> values) {
            addCriterion("C_ONEUNIT in", values, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitNotIn(List<String> values) {
            addCriterion("C_ONEUNIT not in", values, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitBetween(String value1, String value2) {
            addCriterion("C_ONEUNIT between", value1, value2, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCOneunitNotBetween(String value1, String value2) {
            addCriterion("C_ONEUNIT not between", value1, value2, "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCTwounitIsNull() {
            addCriterion("C_TWOUNIT is null");
            return (Criteria) this;
        }

        public Criteria andCTwounitIsNotNull() {
            addCriterion("C_TWOUNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCTwounitEqualTo(String value) {
            addCriterion("C_TWOUNIT =", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitNotEqualTo(String value) {
            addCriterion("C_TWOUNIT <>", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitGreaterThan(String value) {
            addCriterion("C_TWOUNIT >", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitGreaterThanOrEqualTo(String value) {
            addCriterion("C_TWOUNIT >=", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitLessThan(String value) {
            addCriterion("C_TWOUNIT <", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitLessThanOrEqualTo(String value) {
            addCriterion("C_TWOUNIT <=", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitLike(String value) {
            addCriterion("C_TWOUNIT like", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitNotLike(String value) {
            addCriterion("C_TWOUNIT not like", value, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitIn(List<String> values) {
            addCriterion("C_TWOUNIT in", values, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitNotIn(List<String> values) {
            addCriterion("C_TWOUNIT not in", values, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitBetween(String value1, String value2) {
            addCriterion("C_TWOUNIT between", value1, value2, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCTwounitNotBetween(String value1, String value2) {
            addCriterion("C_TWOUNIT not between", value1, value2, "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitIsNull() {
            addCriterion("C_THREEUNIT is null");
            return (Criteria) this;
        }

        public Criteria andCThreeunitIsNotNull() {
            addCriterion("C_THREEUNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCThreeunitEqualTo(String value) {
            addCriterion("C_THREEUNIT =", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitNotEqualTo(String value) {
            addCriterion("C_THREEUNIT <>", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitGreaterThan(String value) {
            addCriterion("C_THREEUNIT >", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitGreaterThanOrEqualTo(String value) {
            addCriterion("C_THREEUNIT >=", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitLessThan(String value) {
            addCriterion("C_THREEUNIT <", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitLessThanOrEqualTo(String value) {
            addCriterion("C_THREEUNIT <=", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitLike(String value) {
            addCriterion("C_THREEUNIT like", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitNotLike(String value) {
            addCriterion("C_THREEUNIT not like", value, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitIn(List<String> values) {
            addCriterion("C_THREEUNIT in", values, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitNotIn(List<String> values) {
            addCriterion("C_THREEUNIT not in", values, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitBetween(String value1, String value2) {
            addCriterion("C_THREEUNIT between", value1, value2, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitNotBetween(String value1, String value2) {
            addCriterion("C_THREEUNIT not between", value1, value2, "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitIsNull() {
            addCriterion("C_FOURUNIT is null");
            return (Criteria) this;
        }

        public Criteria andCFourunitIsNotNull() {
            addCriterion("C_FOURUNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCFourunitEqualTo(String value) {
            addCriterion("C_FOURUNIT =", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitNotEqualTo(String value) {
            addCriterion("C_FOURUNIT <>", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitGreaterThan(String value) {
            addCriterion("C_FOURUNIT >", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitGreaterThanOrEqualTo(String value) {
            addCriterion("C_FOURUNIT >=", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitLessThan(String value) {
            addCriterion("C_FOURUNIT <", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitLessThanOrEqualTo(String value) {
            addCriterion("C_FOURUNIT <=", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitLike(String value) {
            addCriterion("C_FOURUNIT like", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitNotLike(String value) {
            addCriterion("C_FOURUNIT not like", value, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitIn(List<String> values) {
            addCriterion("C_FOURUNIT in", values, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitNotIn(List<String> values) {
            addCriterion("C_FOURUNIT not in", values, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitBetween(String value1, String value2) {
            addCriterion("C_FOURUNIT between", value1, value2, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitNotBetween(String value1, String value2) {
            addCriterion("C_FOURUNIT not between", value1, value2, "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitIsNull() {
            addCriterion("C_FIVEUNIT is null");
            return (Criteria) this;
        }

        public Criteria andCFiveunitIsNotNull() {
            addCriterion("C_FIVEUNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCFiveunitEqualTo(String value) {
            addCriterion("C_FIVEUNIT =", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitNotEqualTo(String value) {
            addCriterion("C_FIVEUNIT <>", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitGreaterThan(String value) {
            addCriterion("C_FIVEUNIT >", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitGreaterThanOrEqualTo(String value) {
            addCriterion("C_FIVEUNIT >=", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitLessThan(String value) {
            addCriterion("C_FIVEUNIT <", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitLessThanOrEqualTo(String value) {
            addCriterion("C_FIVEUNIT <=", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitLike(String value) {
            addCriterion("C_FIVEUNIT like", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitNotLike(String value) {
            addCriterion("C_FIVEUNIT not like", value, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitIn(List<String> values) {
            addCriterion("C_FIVEUNIT in", values, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitNotIn(List<String> values) {
            addCriterion("C_FIVEUNIT not in", values, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitBetween(String value1, String value2) {
            addCriterion("C_FIVEUNIT between", value1, value2, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitNotBetween(String value1, String value2) {
            addCriterion("C_FIVEUNIT not between", value1, value2, "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgIsNull() {
            addCriterion("IS_TEMP_ORG is null");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgIsNotNull() {
            addCriterion("IS_TEMP_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgEqualTo(String value) {
            addCriterion("IS_TEMP_ORG =", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgNotEqualTo(String value) {
            addCriterion("IS_TEMP_ORG <>", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgGreaterThan(String value) {
            addCriterion("IS_TEMP_ORG >", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TEMP_ORG >=", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgLessThan(String value) {
            addCriterion("IS_TEMP_ORG <", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgLessThanOrEqualTo(String value) {
            addCriterion("IS_TEMP_ORG <=", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgLike(String value) {
            addCriterion("IS_TEMP_ORG like", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgNotLike(String value) {
            addCriterion("IS_TEMP_ORG not like", value, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgIn(List<String> values) {
            addCriterion("IS_TEMP_ORG in", values, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgNotIn(List<String> values) {
            addCriterion("IS_TEMP_ORG not in", values, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgBetween(String value1, String value2) {
            addCriterion("IS_TEMP_ORG between", value1, value2, "isTempOrg");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgNotBetween(String value1, String value2) {
            addCriterion("IS_TEMP_ORG not between", value1, value2, "isTempOrg");
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

        public Criteria andIsReportrelationDealIsNull() {
            addCriterion("IS_REPORTRELATION_DEAL is null");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealIsNotNull() {
            addCriterion("IS_REPORTRELATION_DEAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealEqualTo(String value) {
            addCriterion("IS_REPORTRELATION_DEAL =", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealNotEqualTo(String value) {
            addCriterion("IS_REPORTRELATION_DEAL <>", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealGreaterThan(String value) {
            addCriterion("IS_REPORTRELATION_DEAL >", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealGreaterThanOrEqualTo(String value) {
            addCriterion("IS_REPORTRELATION_DEAL >=", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealLessThan(String value) {
            addCriterion("IS_REPORTRELATION_DEAL <", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealLessThanOrEqualTo(String value) {
            addCriterion("IS_REPORTRELATION_DEAL <=", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealLike(String value) {
            addCriterion("IS_REPORTRELATION_DEAL like", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealNotLike(String value) {
            addCriterion("IS_REPORTRELATION_DEAL not like", value, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealIn(List<String> values) {
            addCriterion("IS_REPORTRELATION_DEAL in", values, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealNotIn(List<String> values) {
            addCriterion("IS_REPORTRELATION_DEAL not in", values, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealBetween(String value1, String value2) {
            addCriterion("IS_REPORTRELATION_DEAL between", value1, value2, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andIsReportrelationDealNotBetween(String value1, String value2) {
            addCriterion("IS_REPORTRELATION_DEAL not between", value1, value2, "isReportrelationDeal");
            return (Criteria) this;
        }

        public Criteria andCOrgnameLikeInsensitive(String value) {
            addCriterion("upper(C_ORGNAME) like", value.toUpperCase(), "cOrgname");
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

        public Criteria andCOldChargecodeLikeInsensitive(String value) {
            addCriterion("upper(C_OLD_CHARGECODE) like", value.toUpperCase(), "cOldChargecode");
            return (Criteria) this;
        }

        public Criteria andCChargecodeLikeInsensitive(String value) {
            addCriterion("upper(C_CHARGECODE) like", value.toUpperCase(), "cChargecode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentcodeLikeInsensitive(String value) {
            addCriterion("upper(C_OLD_ORGPARENTCODE) like", value.toUpperCase(), "cOldOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOrgparentcodeLikeInsensitive(String value) {
            addCriterion("upper(C_ORGPARENTCODE) like", value.toUpperCase(), "cOrgparentcode");
            return (Criteria) this;
        }

        public Criteria andCOldOrgparentleadLikeInsensitive(String value) {
            addCriterion("upper(C_OLD_ORGPARENTLEAD) like", value.toUpperCase(), "cOldOrgparentlead");
            return (Criteria) this;
        }

        public Criteria andCOrgparentleadLikeInsensitive(String value) {
            addCriterion("upper(C_ORGPARENTLEAD) like", value.toUpperCase(), "cOrgparentlead");
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

        public Criteria andOrgidLikeInsensitive(String value) {
            addCriterion("upper(ORGID) like", value.toUpperCase(), "orgid");
            return (Criteria) this;
        }

        public Criteria andKostlLikeInsensitive(String value) {
            addCriterion("upper(KOSTL) like", value.toUpperCase(), "kostl");
            return (Criteria) this;
        }

        public Criteria andKostltLikeInsensitive(String value) {
            addCriterion("upper(KOSTLT) like", value.toUpperCase(), "kostlt");
            return (Criteria) this;
        }

        public Criteria andCOneunitLikeInsensitive(String value) {
            addCriterion("upper(C_ONEUNIT) like", value.toUpperCase(), "cOneunit");
            return (Criteria) this;
        }

        public Criteria andCTwounitLikeInsensitive(String value) {
            addCriterion("upper(C_TWOUNIT) like", value.toUpperCase(), "cTwounit");
            return (Criteria) this;
        }

        public Criteria andCThreeunitLikeInsensitive(String value) {
            addCriterion("upper(C_THREEUNIT) like", value.toUpperCase(), "cThreeunit");
            return (Criteria) this;
        }

        public Criteria andCFourunitLikeInsensitive(String value) {
            addCriterion("upper(C_FOURUNIT) like", value.toUpperCase(), "cFourunit");
            return (Criteria) this;
        }

        public Criteria andCFiveunitLikeInsensitive(String value) {
            addCriterion("upper(C_FIVEUNIT) like", value.toUpperCase(), "cFiveunit");
            return (Criteria) this;
        }

        public Criteria andIsTempOrgLikeInsensitive(String value) {
            addCriterion("upper(IS_TEMP_ORG) like", value.toUpperCase(), "isTempOrg");
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

        public Criteria andIsReportrelationDealLikeInsensitive(String value) {
            addCriterion("upper(IS_REPORTRELATION_DEAL) like", value.toUpperCase(), "isReportrelationDeal");
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