package com.csot.recruit.model.original.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class OperateHistoryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OperateHistoryCriteria() {
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

        public Criteria andOperatorTypeIsNull() {
            addCriterion("OPERATOR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIsNotNull() {
            addCriterion("OPERATOR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeEqualTo(String value) {
            addCriterion("OPERATOR_TYPE =", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotEqualTo(String value) {
            addCriterion("OPERATOR_TYPE <>", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeGreaterThan(String value) {
            addCriterion("OPERATOR_TYPE >", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_TYPE >=", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLessThan(String value) {
            addCriterion("OPERATOR_TYPE <", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_TYPE <=", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLike(String value) {
            addCriterion("OPERATOR_TYPE like", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotLike(String value) {
            addCriterion("OPERATOR_TYPE not like", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIn(List<String> values) {
            addCriterion("OPERATOR_TYPE in", values, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotIn(List<String> values) {
            addCriterion("OPERATOR_TYPE not in", values, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeBetween(String value1, String value2) {
            addCriterion("OPERATOR_TYPE between", value1, value2, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_TYPE not between", value1, value2, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIsNull() {
            addCriterion("OPERATOR_USER is null");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIsNotNull() {
            addCriterion("OPERATOR_USER is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorUserEqualTo(String value) {
            addCriterion("OPERATOR_USER =", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotEqualTo(String value) {
            addCriterion("OPERATOR_USER <>", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserGreaterThan(String value) {
            addCriterion("OPERATOR_USER >", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_USER >=", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLessThan(String value) {
            addCriterion("OPERATOR_USER <", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_USER <=", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLike(String value) {
            addCriterion("OPERATOR_USER like", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotLike(String value) {
            addCriterion("OPERATOR_USER not like", value, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserIn(List<String> values) {
            addCriterion("OPERATOR_USER in", values, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotIn(List<String> values) {
            addCriterion("OPERATOR_USER not in", values, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserBetween(String value1, String value2) {
            addCriterion("OPERATOR_USER between", value1, value2, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorUserNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_USER not between", value1, value2, "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorContentIsNull() {
            addCriterion("OPERATOR_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andOperatorContentIsNotNull() {
            addCriterion("OPERATOR_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorContentEqualTo(String value) {
            addCriterion("OPERATOR_CONTENT =", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentNotEqualTo(String value) {
            addCriterion("OPERATOR_CONTENT <>", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentGreaterThan(String value) {
            addCriterion("OPERATOR_CONTENT >", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_CONTENT >=", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentLessThan(String value) {
            addCriterion("OPERATOR_CONTENT <", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_CONTENT <=", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentLike(String value) {
            addCriterion("OPERATOR_CONTENT like", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentNotLike(String value) {
            addCriterion("OPERATOR_CONTENT not like", value, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentIn(List<String> values) {
            addCriterion("OPERATOR_CONTENT in", values, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentNotIn(List<String> values) {
            addCriterion("OPERATOR_CONTENT not in", values, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentBetween(String value1, String value2) {
            addCriterion("OPERATOR_CONTENT between", value1, value2, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andOperatorContentNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_CONTENT not between", value1, value2, "operatorContent");
            return (Criteria) this;
        }

        public Criteria andRelatedIdIsNull() {
            addCriterion("RELATED_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelatedIdIsNotNull() {
            addCriterion("RELATED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedIdEqualTo(String value) {
            addCriterion("RELATED_ID =", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotEqualTo(String value) {
            addCriterion("RELATED_ID <>", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdGreaterThan(String value) {
            addCriterion("RELATED_ID >", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdGreaterThanOrEqualTo(String value) {
            addCriterion("RELATED_ID >=", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdLessThan(String value) {
            addCriterion("RELATED_ID <", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdLessThanOrEqualTo(String value) {
            addCriterion("RELATED_ID <=", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdLike(String value) {
            addCriterion("RELATED_ID like", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotLike(String value) {
            addCriterion("RELATED_ID not like", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdIn(List<String> values) {
            addCriterion("RELATED_ID in", values, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotIn(List<String> values) {
            addCriterion("RELATED_ID not in", values, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdBetween(String value1, String value2) {
            addCriterion("RELATED_ID between", value1, value2, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotBetween(String value1, String value2) {
            addCriterion("RELATED_ID not between", value1, value2, "relatedId");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeIsNull() {
            addCriterion("OPERATOR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeIsNotNull() {
            addCriterion("OPERATOR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_TIME =", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_TIME <>", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("OPERATOR_TIME >", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_TIME >=", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeLessThan(Date value) {
            addCriterionForJDBCDate("OPERATOR_TIME <", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATOR_TIME <=", value, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATOR_TIME in", values, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATOR_TIME not in", values, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATOR_TIME between", value1, value2, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andOperatorTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATOR_TIME not between", value1, value2, "operatorTime");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLikeInsensitive(String value) {
            addCriterion("upper(OPERATOR_TYPE) like", value.toUpperCase(), "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorUserLikeInsensitive(String value) {
            addCriterion("upper(OPERATOR_USER) like", value.toUpperCase(), "operatorUser");
            return (Criteria) this;
        }

        public Criteria andOperatorContentLikeInsensitive(String value) {
            addCriterion("upper(OPERATOR_CONTENT) like", value.toUpperCase(), "operatorContent");
            return (Criteria) this;
        }

        public Criteria andRelatedIdLikeInsensitive(String value) {
            addCriterion("upper(RELATED_ID) like", value.toUpperCase(), "relatedId");
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