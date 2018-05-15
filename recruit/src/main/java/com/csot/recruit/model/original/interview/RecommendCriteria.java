package com.csot.recruit.model.original.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RecommendCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RecommendCriteria() {
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

        public Criteria andRecommendedIsNull() {
            addCriterion("RECOMMENDED is null");
            return (Criteria) this;
        }

        public Criteria andRecommendedIsNotNull() {
            addCriterion("RECOMMENDED is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendedEqualTo(String value) {
            addCriterion("RECOMMENDED =", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotEqualTo(String value) {
            addCriterion("RECOMMENDED <>", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedGreaterThan(String value) {
            addCriterion("RECOMMENDED >", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedGreaterThanOrEqualTo(String value) {
            addCriterion("RECOMMENDED >=", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedLessThan(String value) {
            addCriterion("RECOMMENDED <", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedLessThanOrEqualTo(String value) {
            addCriterion("RECOMMENDED <=", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedLike(String value) {
            addCriterion("RECOMMENDED like", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotLike(String value) {
            addCriterion("RECOMMENDED not like", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedIn(List<String> values) {
            addCriterion("RECOMMENDED in", values, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotIn(List<String> values) {
            addCriterion("RECOMMENDED not in", values, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedBetween(String value1, String value2) {
            addCriterion("RECOMMENDED between", value1, value2, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotBetween(String value1, String value2) {
            addCriterion("RECOMMENDED not between", value1, value2, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationIsNull() {
            addCriterion("RECOMMEND_RELATION is null");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationIsNotNull() {
            addCriterion("RECOMMEND_RELATION is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationEqualTo(String value) {
            addCriterion("RECOMMEND_RELATION =", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationNotEqualTo(String value) {
            addCriterion("RECOMMEND_RELATION <>", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationGreaterThan(String value) {
            addCriterion("RECOMMEND_RELATION >", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationGreaterThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_RELATION >=", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationLessThan(String value) {
            addCriterion("RECOMMEND_RELATION <", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationLessThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_RELATION <=", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationLike(String value) {
            addCriterion("RECOMMEND_RELATION like", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationNotLike(String value) {
            addCriterion("RECOMMEND_RELATION not like", value, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationIn(List<String> values) {
            addCriterion("RECOMMEND_RELATION in", values, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationNotIn(List<String> values) {
            addCriterion("RECOMMEND_RELATION not in", values, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationBetween(String value1, String value2) {
            addCriterion("RECOMMEND_RELATION between", value1, value2, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationNotBetween(String value1, String value2) {
            addCriterion("RECOMMEND_RELATION not between", value1, value2, "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionIsNull() {
            addCriterion("RECOMMEND_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionIsNotNull() {
            addCriterion("RECOMMEND_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionEqualTo(String value) {
            addCriterion("RECOMMEND_POSITION =", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionNotEqualTo(String value) {
            addCriterion("RECOMMEND_POSITION <>", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionGreaterThan(String value) {
            addCriterion("RECOMMEND_POSITION >", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionGreaterThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_POSITION >=", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionLessThan(String value) {
            addCriterion("RECOMMEND_POSITION <", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionLessThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_POSITION <=", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionLike(String value) {
            addCriterion("RECOMMEND_POSITION like", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionNotLike(String value) {
            addCriterion("RECOMMEND_POSITION not like", value, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionIn(List<String> values) {
            addCriterion("RECOMMEND_POSITION in", values, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionNotIn(List<String> values) {
            addCriterion("RECOMMEND_POSITION not in", values, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionBetween(String value1, String value2) {
            addCriterion("RECOMMEND_POSITION between", value1, value2, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionNotBetween(String value1, String value2) {
            addCriterion("RECOMMEND_POSITION not between", value1, value2, "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneIsNull() {
            addCriterion("RECOMMEND_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneIsNotNull() {
            addCriterion("RECOMMEND_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneEqualTo(String value) {
            addCriterion("RECOMMEND_PHONE =", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneNotEqualTo(String value) {
            addCriterion("RECOMMEND_PHONE <>", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneGreaterThan(String value) {
            addCriterion("RECOMMEND_PHONE >", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_PHONE >=", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneLessThan(String value) {
            addCriterion("RECOMMEND_PHONE <", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneLessThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_PHONE <=", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneLike(String value) {
            addCriterion("RECOMMEND_PHONE like", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneNotLike(String value) {
            addCriterion("RECOMMEND_PHONE not like", value, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneIn(List<String> values) {
            addCriterion("RECOMMEND_PHONE in", values, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneNotIn(List<String> values) {
            addCriterion("RECOMMEND_PHONE not in", values, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneBetween(String value1, String value2) {
            addCriterion("RECOMMEND_PHONE between", value1, value2, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneNotBetween(String value1, String value2) {
            addCriterion("RECOMMEND_PHONE not between", value1, value2, "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressIsNull() {
            addCriterion("RECOMMEND_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressIsNotNull() {
            addCriterion("RECOMMEND_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressEqualTo(String value) {
            addCriterion("RECOMMEND_ADDRESS =", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressNotEqualTo(String value) {
            addCriterion("RECOMMEND_ADDRESS <>", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressGreaterThan(String value) {
            addCriterion("RECOMMEND_ADDRESS >", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressGreaterThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_ADDRESS >=", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressLessThan(String value) {
            addCriterion("RECOMMEND_ADDRESS <", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressLessThanOrEqualTo(String value) {
            addCriterion("RECOMMEND_ADDRESS <=", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressLike(String value) {
            addCriterion("RECOMMEND_ADDRESS like", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressNotLike(String value) {
            addCriterion("RECOMMEND_ADDRESS not like", value, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressIn(List<String> values) {
            addCriterion("RECOMMEND_ADDRESS in", values, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressNotIn(List<String> values) {
            addCriterion("RECOMMEND_ADDRESS not in", values, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressBetween(String value1, String value2) {
            addCriterion("RECOMMEND_ADDRESS between", value1, value2, "recommendAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressNotBetween(String value1, String value2) {
            addCriterion("RECOMMEND_ADDRESS not between", value1, value2, "recommendAddress");
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

        public Criteria andRecommendedLikeInsensitive(String value) {
            addCriterion("upper(RECOMMENDED) like", value.toUpperCase(), "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendRelationLikeInsensitive(String value) {
            addCriterion("upper(RECOMMEND_RELATION) like", value.toUpperCase(), "recommendRelation");
            return (Criteria) this;
        }

        public Criteria andRecommendPositionLikeInsensitive(String value) {
            addCriterion("upper(RECOMMEND_POSITION) like", value.toUpperCase(), "recommendPosition");
            return (Criteria) this;
        }

        public Criteria andRecommendPhoneLikeInsensitive(String value) {
            addCriterion("upper(RECOMMEND_PHONE) like", value.toUpperCase(), "recommendPhone");
            return (Criteria) this;
        }

        public Criteria andRecommendAddressLikeInsensitive(String value) {
            addCriterion("upper(RECOMMEND_ADDRESS) like", value.toUpperCase(), "recommendAddress");
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