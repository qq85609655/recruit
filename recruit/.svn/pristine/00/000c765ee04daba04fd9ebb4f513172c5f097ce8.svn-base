package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class FamilyMemberExtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public FamilyMemberExtCriteria() {
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

        public Criteria andMenberNameIsNull() {
            addCriterion("MENBER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMenberNameIsNotNull() {
            addCriterion("MENBER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMenberNameEqualTo(String value) {
            addCriterion("MENBER_NAME =", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameNotEqualTo(String value) {
            addCriterion("MENBER_NAME <>", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameGreaterThan(String value) {
            addCriterion("MENBER_NAME >", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameGreaterThanOrEqualTo(String value) {
            addCriterion("MENBER_NAME >=", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameLessThan(String value) {
            addCriterion("MENBER_NAME <", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameLessThanOrEqualTo(String value) {
            addCriterion("MENBER_NAME <=", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameLike(String value) {
            addCriterion("MENBER_NAME like", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameNotLike(String value) {
            addCriterion("MENBER_NAME not like", value, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameIn(List<String> values) {
            addCriterion("MENBER_NAME in", values, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameNotIn(List<String> values) {
            addCriterion("MENBER_NAME not in", values, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameBetween(String value1, String value2) {
            addCriterion("MENBER_NAME between", value1, value2, "menberName");
            return (Criteria) this;
        }

        public Criteria andMenberNameNotBetween(String value1, String value2) {
            addCriterion("MENBER_NAME not between", value1, value2, "menberName");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationIsNull() {
            addCriterion("FAMILY_RELATION is null");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationIsNotNull() {
            addCriterion("FAMILY_RELATION is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationEqualTo(String value) {
            addCriterion("FAMILY_RELATION =", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationNotEqualTo(String value) {
            addCriterion("FAMILY_RELATION <>", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationGreaterThan(String value) {
            addCriterion("FAMILY_RELATION >", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationGreaterThanOrEqualTo(String value) {
            addCriterion("FAMILY_RELATION >=", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationLessThan(String value) {
            addCriterion("FAMILY_RELATION <", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationLessThanOrEqualTo(String value) {
            addCriterion("FAMILY_RELATION <=", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationLike(String value) {
            addCriterion("FAMILY_RELATION like", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationNotLike(String value) {
            addCriterion("FAMILY_RELATION not like", value, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationIn(List<String> values) {
            addCriterion("FAMILY_RELATION in", values, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationNotIn(List<String> values) {
            addCriterion("FAMILY_RELATION not in", values, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationBetween(String value1, String value2) {
            addCriterion("FAMILY_RELATION between", value1, value2, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationNotBetween(String value1, String value2) {
            addCriterion("FAMILY_RELATION not between", value1, value2, "familyRelation");
            return (Criteria) this;
        }

        public Criteria andMenberGenderIsNull() {
            addCriterion("MENBER_GENDER is null");
            return (Criteria) this;
        }

        public Criteria andMenberGenderIsNotNull() {
            addCriterion("MENBER_GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andMenberGenderEqualTo(String value) {
            addCriterion("MENBER_GENDER =", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderNotEqualTo(String value) {
            addCriterion("MENBER_GENDER <>", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderGreaterThan(String value) {
            addCriterion("MENBER_GENDER >", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderGreaterThanOrEqualTo(String value) {
            addCriterion("MENBER_GENDER >=", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderLessThan(String value) {
            addCriterion("MENBER_GENDER <", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderLessThanOrEqualTo(String value) {
            addCriterion("MENBER_GENDER <=", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderLike(String value) {
            addCriterion("MENBER_GENDER like", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderNotLike(String value) {
            addCriterion("MENBER_GENDER not like", value, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderIn(List<String> values) {
            addCriterion("MENBER_GENDER in", values, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderNotIn(List<String> values) {
            addCriterion("MENBER_GENDER not in", values, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderBetween(String value1, String value2) {
            addCriterion("MENBER_GENDER between", value1, value2, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberGenderNotBetween(String value1, String value2) {
            addCriterion("MENBER_GENDER not between", value1, value2, "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayIsNull() {
            addCriterion("MENBER_BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayIsNotNull() {
            addCriterion("MENBER_BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayEqualTo(String value) {
            addCriterion("MENBER_BIRTHDAY =", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayNotEqualTo(String value) {
            addCriterion("MENBER_BIRTHDAY <>", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayGreaterThan(String value) {
            addCriterion("MENBER_BIRTHDAY >", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("MENBER_BIRTHDAY >=", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayLessThan(String value) {
            addCriterion("MENBER_BIRTHDAY <", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayLessThanOrEqualTo(String value) {
            addCriterion("MENBER_BIRTHDAY <=", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayLike(String value) {
            addCriterion("MENBER_BIRTHDAY like", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayNotLike(String value) {
            addCriterion("MENBER_BIRTHDAY not like", value, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayIn(List<String> values) {
            addCriterion("MENBER_BIRTHDAY in", values, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayNotIn(List<String> values) {
            addCriterion("MENBER_BIRTHDAY not in", values, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayBetween(String value1, String value2) {
            addCriterion("MENBER_BIRTHDAY between", value1, value2, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayNotBetween(String value1, String value2) {
            addCriterion("MENBER_BIRTHDAY not between", value1, value2, "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberAddressIsNull() {
            addCriterion("MENBER_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMenberAddressIsNotNull() {
            addCriterion("MENBER_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMenberAddressEqualTo(String value) {
            addCriterion("MENBER_ADDRESS =", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressNotEqualTo(String value) {
            addCriterion("MENBER_ADDRESS <>", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressGreaterThan(String value) {
            addCriterion("MENBER_ADDRESS >", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressGreaterThanOrEqualTo(String value) {
            addCriterion("MENBER_ADDRESS >=", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressLessThan(String value) {
            addCriterion("MENBER_ADDRESS <", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressLessThanOrEqualTo(String value) {
            addCriterion("MENBER_ADDRESS <=", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressLike(String value) {
            addCriterion("MENBER_ADDRESS like", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressNotLike(String value) {
            addCriterion("MENBER_ADDRESS not like", value, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressIn(List<String> values) {
            addCriterion("MENBER_ADDRESS in", values, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressNotIn(List<String> values) {
            addCriterion("MENBER_ADDRESS not in", values, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressBetween(String value1, String value2) {
            addCriterion("MENBER_ADDRESS between", value1, value2, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andMenberAddressNotBetween(String value1, String value2) {
            addCriterion("MENBER_ADDRESS not between", value1, value2, "menberAddress");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagIsNull() {
            addCriterion("EMERGENT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagIsNotNull() {
            addCriterion("EMERGENT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagEqualTo(String value) {
            addCriterion("EMERGENT_FLAG =", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagNotEqualTo(String value) {
            addCriterion("EMERGENT_FLAG <>", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagGreaterThan(String value) {
            addCriterion("EMERGENT_FLAG >", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagGreaterThanOrEqualTo(String value) {
            addCriterion("EMERGENT_FLAG >=", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagLessThan(String value) {
            addCriterion("EMERGENT_FLAG <", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagLessThanOrEqualTo(String value) {
            addCriterion("EMERGENT_FLAG <=", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagLike(String value) {
            addCriterion("EMERGENT_FLAG like", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagNotLike(String value) {
            addCriterion("EMERGENT_FLAG not like", value, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagIn(List<String> values) {
            addCriterion("EMERGENT_FLAG in", values, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagNotIn(List<String> values) {
            addCriterion("EMERGENT_FLAG not in", values, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagBetween(String value1, String value2) {
            addCriterion("EMERGENT_FLAG between", value1, value2, "emergentFlag");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagNotBetween(String value1, String value2) {
            addCriterion("EMERGENT_FLAG not between", value1, value2, "emergentFlag");
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

        public Criteria andMenberNameLikeInsensitive(String value) {
            addCriterion("upper(MENBER_NAME) like", value.toUpperCase(), "menberName");
            return (Criteria) this;
        }

        public Criteria andFamilyRelationLikeInsensitive(String value) {
            addCriterion("upper(FAMILY_RELATION) like", value.toUpperCase(), "familyRelation");
            return (Criteria) this;
        }

        public Criteria andMenberGenderLikeInsensitive(String value) {
            addCriterion("upper(MENBER_GENDER) like", value.toUpperCase(), "menberGender");
            return (Criteria) this;
        }

        public Criteria andMenberBirthdayLikeInsensitive(String value) {
            addCriterion("upper(MENBER_BIRTHDAY) like", value.toUpperCase(), "menberBirthday");
            return (Criteria) this;
        }

        public Criteria andMenberAddressLikeInsensitive(String value) {
            addCriterion("upper(MENBER_ADDRESS) like", value.toUpperCase(), "menberAddress");
            return (Criteria) this;
        }

        public Criteria andEmergentFlagLikeInsensitive(String value) {
            addCriterion("upper(EMERGENT_FLAG) like", value.toUpperCase(), "emergentFlag");
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