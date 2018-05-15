package com.csot.recruit.model.original.resume;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class LabelRalationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public LabelRalationCriteria() {
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

        public Criteria andLabelIdsIsNull() {
            addCriterion("LABEL_IDS is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdsIsNotNull() {
            addCriterion("LABEL_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdsEqualTo(String value) {
            addCriterion("LABEL_IDS =", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsNotEqualTo(String value) {
            addCriterion("LABEL_IDS <>", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsGreaterThan(String value) {
            addCriterion("LABEL_IDS >", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsGreaterThanOrEqualTo(String value) {
            addCriterion("LABEL_IDS >=", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsLessThan(String value) {
            addCriterion("LABEL_IDS <", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsLessThanOrEqualTo(String value) {
            addCriterion("LABEL_IDS <=", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsLike(String value) {
            addCriterion("LABEL_IDS like", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsNotLike(String value) {
            addCriterion("LABEL_IDS not like", value, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsIn(List<String> values) {
            addCriterion("LABEL_IDS in", values, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsNotIn(List<String> values) {
            addCriterion("LABEL_IDS not in", values, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsBetween(String value1, String value2) {
            addCriterion("LABEL_IDS between", value1, value2, "labelIds");
            return (Criteria) this;
        }

        public Criteria andLabelIdsNotBetween(String value1, String value2) {
            addCriterion("LABEL_IDS not between", value1, value2, "labelIds");
            return (Criteria) this;
        }

        public Criteria andReservseIdIsNull() {
            addCriterion("RESERVSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andReservseIdIsNotNull() {
            addCriterion("RESERVSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReservseIdEqualTo(String value) {
            addCriterion("RESERVSE_ID =", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdNotEqualTo(String value) {
            addCriterion("RESERVSE_ID <>", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdGreaterThan(String value) {
            addCriterion("RESERVSE_ID >", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdGreaterThanOrEqualTo(String value) {
            addCriterion("RESERVSE_ID >=", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdLessThan(String value) {
            addCriterion("RESERVSE_ID <", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdLessThanOrEqualTo(String value) {
            addCriterion("RESERVSE_ID <=", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdLike(String value) {
            addCriterion("RESERVSE_ID like", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdNotLike(String value) {
            addCriterion("RESERVSE_ID not like", value, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdIn(List<String> values) {
            addCriterion("RESERVSE_ID in", values, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdNotIn(List<String> values) {
            addCriterion("RESERVSE_ID not in", values, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdBetween(String value1, String value2) {
            addCriterion("RESERVSE_ID between", value1, value2, "reservseId");
            return (Criteria) this;
        }

        public Criteria andReservseIdNotBetween(String value1, String value2) {
            addCriterion("RESERVSE_ID not between", value1, value2, "reservseId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andLabelIdsLikeInsensitive(String value) {
            addCriterion("upper(LABEL_IDS) like", value.toUpperCase(), "labelIds");
            return (Criteria) this;
        }

        public Criteria andReservseIdLikeInsensitive(String value) {
            addCriterion("upper(RESERVSE_ID) like", value.toUpperCase(), "reservseId");
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