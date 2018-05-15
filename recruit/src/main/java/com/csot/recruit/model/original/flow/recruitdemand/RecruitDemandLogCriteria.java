package com.csot.recruit.model.original.flow.recruitdemand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RecruitDemandLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RecruitDemandLogCriteria() {
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

        public Criteria andOldStrIsNull() {
            addCriterion("OLD_STR is null");
            return (Criteria) this;
        }

        public Criteria andOldStrIsNotNull() {
            addCriterion("OLD_STR is not null");
            return (Criteria) this;
        }

        public Criteria andOldStrEqualTo(String value) {
            addCriterion("OLD_STR =", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrNotEqualTo(String value) {
            addCriterion("OLD_STR <>", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrGreaterThan(String value) {
            addCriterion("OLD_STR >", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_STR >=", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrLessThan(String value) {
            addCriterion("OLD_STR <", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrLessThanOrEqualTo(String value) {
            addCriterion("OLD_STR <=", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrLike(String value) {
            addCriterion("OLD_STR like", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrNotLike(String value) {
            addCriterion("OLD_STR not like", value, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrIn(List<String> values) {
            addCriterion("OLD_STR in", values, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrNotIn(List<String> values) {
            addCriterion("OLD_STR not in", values, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrBetween(String value1, String value2) {
            addCriterion("OLD_STR between", value1, value2, "oldStr");
            return (Criteria) this;
        }

        public Criteria andOldStrNotBetween(String value1, String value2) {
            addCriterion("OLD_STR not between", value1, value2, "oldStr");
            return (Criteria) this;
        }

        public Criteria andNewStrIsNull() {
            addCriterion("NEW_STR is null");
            return (Criteria) this;
        }

        public Criteria andNewStrIsNotNull() {
            addCriterion("NEW_STR is not null");
            return (Criteria) this;
        }

        public Criteria andNewStrEqualTo(String value) {
            addCriterion("NEW_STR =", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrNotEqualTo(String value) {
            addCriterion("NEW_STR <>", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrGreaterThan(String value) {
            addCriterion("NEW_STR >", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_STR >=", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrLessThan(String value) {
            addCriterion("NEW_STR <", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrLessThanOrEqualTo(String value) {
            addCriterion("NEW_STR <=", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrLike(String value) {
            addCriterion("NEW_STR like", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrNotLike(String value) {
            addCriterion("NEW_STR not like", value, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrIn(List<String> values) {
            addCriterion("NEW_STR in", values, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrNotIn(List<String> values) {
            addCriterion("NEW_STR not in", values, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrBetween(String value1, String value2) {
            addCriterion("NEW_STR between", value1, value2, "newStr");
            return (Criteria) this;
        }

        public Criteria andNewStrNotBetween(String value1, String value2) {
            addCriterion("NEW_STR not between", value1, value2, "newStr");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andModifiedIdIsNull() {
            addCriterion("MODIFIED_ID is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIdIsNotNull() {
            addCriterion("MODIFIED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedIdEqualTo(String value) {
            addCriterion("MODIFIED_ID =", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotEqualTo(String value) {
            addCriterion("MODIFIED_ID <>", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdGreaterThan(String value) {
            addCriterion("MODIFIED_ID >", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIED_ID >=", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLessThan(String value) {
            addCriterion("MODIFIED_ID <", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLessThanOrEqualTo(String value) {
            addCriterion("MODIFIED_ID <=", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLike(String value) {
            addCriterion("MODIFIED_ID like", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotLike(String value) {
            addCriterion("MODIFIED_ID not like", value, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdIn(List<String> values) {
            addCriterion("MODIFIED_ID in", values, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotIn(List<String> values) {
            addCriterion("MODIFIED_ID not in", values, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdBetween(String value1, String value2) {
            addCriterion("MODIFIED_ID between", value1, value2, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdNotBetween(String value1, String value2) {
            addCriterion("MODIFIED_ID not between", value1, value2, "modifiedId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNull() {
            addCriterion("DEMAND_ID is null");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNotNull() {
            addCriterion("DEMAND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDemandIdEqualTo(String value) {
            addCriterion("DEMAND_ID =", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotEqualTo(String value) {
            addCriterion("DEMAND_ID <>", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThan(String value) {
            addCriterion("DEMAND_ID >", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEMAND_ID >=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThan(String value) {
            addCriterion("DEMAND_ID <", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThanOrEqualTo(String value) {
            addCriterion("DEMAND_ID <=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLike(String value) {
            addCriterion("DEMAND_ID like", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotLike(String value) {
            addCriterion("DEMAND_ID not like", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIn(List<String> values) {
            addCriterion("DEMAND_ID in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotIn(List<String> values) {
            addCriterion("DEMAND_ID not in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdBetween(String value1, String value2) {
            addCriterion("DEMAND_ID between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotBetween(String value1, String value2) {
            addCriterion("DEMAND_ID not between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldIsNull() {
            addCriterion("UPDATE_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldIsNotNull() {
            addCriterion("UPDATE_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldEqualTo(String value) {
            addCriterion("UPDATE_FIELD =", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldNotEqualTo(String value) {
            addCriterion("UPDATE_FIELD <>", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldGreaterThan(String value) {
            addCriterion("UPDATE_FIELD >", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_FIELD >=", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldLessThan(String value) {
            addCriterion("UPDATE_FIELD <", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_FIELD <=", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldLike(String value) {
            addCriterion("UPDATE_FIELD like", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldNotLike(String value) {
            addCriterion("UPDATE_FIELD not like", value, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldIn(List<String> values) {
            addCriterion("UPDATE_FIELD in", values, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldNotIn(List<String> values) {
            addCriterion("UPDATE_FIELD not in", values, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldBetween(String value1, String value2) {
            addCriterion("UPDATE_FIELD between", value1, value2, "updateField");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldNotBetween(String value1, String value2) {
            addCriterion("UPDATE_FIELD not between", value1, value2, "updateField");
            return (Criteria) this;
        }

        public Criteria andModifiedNameIsNull() {
            addCriterion("MODIFIED_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModifiedNameIsNotNull() {
            addCriterion("MODIFIED_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedNameEqualTo(String value) {
            addCriterion("MODIFIED_NAME =", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotEqualTo(String value) {
            addCriterion("MODIFIED_NAME <>", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameGreaterThan(String value) {
            addCriterion("MODIFIED_NAME >", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIED_NAME >=", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameLessThan(String value) {
            addCriterion("MODIFIED_NAME <", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameLessThanOrEqualTo(String value) {
            addCriterion("MODIFIED_NAME <=", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameLike(String value) {
            addCriterion("MODIFIED_NAME like", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotLike(String value) {
            addCriterion("MODIFIED_NAME not like", value, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameIn(List<String> values) {
            addCriterion("MODIFIED_NAME in", values, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotIn(List<String> values) {
            addCriterion("MODIFIED_NAME not in", values, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameBetween(String value1, String value2) {
            addCriterion("MODIFIED_NAME between", value1, value2, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andModifiedNameNotBetween(String value1, String value2) {
            addCriterion("MODIFIED_NAME not between", value1, value2, "modifiedName");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andOldStrLikeInsensitive(String value) {
            addCriterion("upper(OLD_STR) like", value.toUpperCase(), "oldStr");
            return (Criteria) this;
        }

        public Criteria andNewStrLikeInsensitive(String value) {
            addCriterion("upper(NEW_STR) like", value.toUpperCase(), "newStr");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLikeInsensitive(String value) {
            addCriterion("upper(MODIFIED_ID) like", value.toUpperCase(), "modifiedId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLikeInsensitive(String value) {
            addCriterion("upper(DEMAND_ID) like", value.toUpperCase(), "demandId");
            return (Criteria) this;
        }

        public Criteria andUpdateFieldLikeInsensitive(String value) {
            addCriterion("upper(UPDATE_FIELD) like", value.toUpperCase(), "updateField");
            return (Criteria) this;
        }

        public Criteria andModifiedNameLikeInsensitive(String value) {
            addCriterion("upper(MODIFIED_NAME) like", value.toUpperCase(), "modifiedName");
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