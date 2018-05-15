package com.csot.recruit.model.position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class DepartmentRequireCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DepartmentRequireCriteria() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNull() {
            addCriterion("position_code is null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNotNull() {
            addCriterion("position_code is not null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeEqualTo(String value) {
            addCriterion("position_code =", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotEqualTo(String value) {
            addCriterion("position_code <>", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThan(String value) {
            addCriterion("position_code >", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("position_code >=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThan(String value) {
            addCriterion("position_code <", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThanOrEqualTo(String value) {
            addCriterion("position_code <=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLike(String value) {
            addCriterion("position_code like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotLike(String value) {
            addCriterion("position_code not like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIn(List<String> values) {
            addCriterion("position_code in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotIn(List<String> values) {
            addCriterion("position_code not in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeBetween(String value1, String value2) {
            addCriterion("position_code between", value1, value2, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotBetween(String value1, String value2) {
            addCriterion("position_code not between", value1, value2, "positionCode");
            return (Criteria) this;
        }

        public Criteria andDemandsIsNull() {
            addCriterion("demands is null");
            return (Criteria) this;
        }

        public Criteria andDemandsIsNotNull() {
            addCriterion("demands is not null");
            return (Criteria) this;
        }

        public Criteria andDemandsEqualTo(BigDecimal value) {
            addCriterion("demands =", value, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsNotEqualTo(BigDecimal value) {
            addCriterion("demands <>", value, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsGreaterThan(BigDecimal value) {
            addCriterion("demands >", value, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("demands >=", value, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsLessThan(BigDecimal value) {
            addCriterion("demands <", value, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("demands <=", value, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsIn(List<BigDecimal> values) {
            addCriterion("demands in", values, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsNotIn(List<BigDecimal> values) {
            addCriterion("demands not in", values, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("demands between", value1, value2, "demands");
            return (Criteria) this;
        }

        public Criteria andDemandsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("demands not between", value1, value2, "demands");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNull() {
            addCriterion("effective_date is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNotNull() {
            addCriterion("effective_date is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateEqualTo(Date value) {
            addCriterion("effective_date =", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotEqualTo(Date value) {
            addCriterion("effective_date <>", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThan(Date value) {
            addCriterion("effective_date >", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_date >=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThan(Date value) {
            addCriterion("effective_date <", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThanOrEqualTo(Date value) {
            addCriterion("effective_date <=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIn(List<Date> values) {
            addCriterion("effective_date in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotIn(List<Date> values) {
            addCriterion("effective_date not in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateBetween(Date value1, Date value2) {
            addCriterion("effective_date between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotBetween(Date value1, Date value2) {
            addCriterion("effective_date not between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateIsNull() {
            addCriterion("expect_date is null");
            return (Criteria) this;
        }

        public Criteria andExpectDateIsNotNull() {
            addCriterion("expect_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpectDateEqualTo(Date value) {
            addCriterion("expect_date =", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateNotEqualTo(Date value) {
            addCriterion("expect_date <>", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateGreaterThan(Date value) {
            addCriterion("expect_date >", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expect_date >=", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateLessThan(Date value) {
            addCriterion("expect_date <", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateLessThanOrEqualTo(Date value) {
            addCriterion("expect_date <=", value, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateIn(List<Date> values) {
            addCriterion("expect_date in", values, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateNotIn(List<Date> values) {
            addCriterion("expect_date not in", values, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateBetween(Date value1, Date value2) {
            addCriterion("expect_date between", value1, value2, "expectDate");
            return (Criteria) this;
        }

        public Criteria andExpectDateNotBetween(Date value1, Date value2) {
            addCriterion("expect_date not between", value1, value2, "expectDate");
            return (Criteria) this;
        }

        public Criteria andDemandTypeIsNull() {
            addCriterion("demand_type is null");
            return (Criteria) this;
        }

        public Criteria andDemandTypeIsNotNull() {
            addCriterion("demand_type is not null");
            return (Criteria) this;
        }

        public Criteria andDemandTypeEqualTo(BigDecimal value) {
            addCriterion("demand_type =", value, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeNotEqualTo(BigDecimal value) {
            addCriterion("demand_type <>", value, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeGreaterThan(BigDecimal value) {
            addCriterion("demand_type >", value, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("demand_type >=", value, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeLessThan(BigDecimal value) {
            addCriterion("demand_type <", value, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("demand_type <=", value, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeIn(List<BigDecimal> values) {
            addCriterion("demand_type in", values, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeNotIn(List<BigDecimal> values) {
            addCriterion("demand_type not in", values, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("demand_type between", value1, value2, "demandType");
            return (Criteria) this;
        }

        public Criteria andDemandTypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("demand_type not between", value1, value2, "demandType");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNull() {
            addCriterion("recruit_position_id is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNotNull() {
            addCriterion("recruit_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdEqualTo(String value) {
            addCriterion("recruit_position_id =", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotEqualTo(String value) {
            addCriterion("recruit_position_id <>", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThan(String value) {
            addCriterion("recruit_position_id >", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_position_id >=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThan(String value) {
            addCriterion("recruit_position_id <", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThanOrEqualTo(String value) {
            addCriterion("recruit_position_id <=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLike(String value) {
            addCriterion("recruit_position_id like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotLike(String value) {
            addCriterion("recruit_position_id not like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIn(List<String> values) {
            addCriterion("recruit_position_id in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotIn(List<String> values) {
            addCriterion("recruit_position_id not in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdBetween(String value1, String value2) {
            addCriterion("recruit_position_id between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotBetween(String value1, String value2) {
            addCriterion("recruit_position_id not between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikeInsensitive(String value) {
            addCriterion("upper(department) like", value.toUpperCase(), "department");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLikeInsensitive(String value) {
            addCriterion("upper(position_code) like", value.toUpperCase(), "positionCode");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLikeInsensitive(String value) {
            addCriterion("upper(recruit_position_id) like", value.toUpperCase(), "recruitPositionId");
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