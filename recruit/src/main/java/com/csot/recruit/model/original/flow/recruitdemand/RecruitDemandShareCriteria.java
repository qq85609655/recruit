package com.csot.recruit.model.original.flow.recruitdemand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RecruitDemandShareCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RecruitDemandShareCriteria() {
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

        public Criteria andRecruitDemandIdIsNull() {
            addCriterion("RECRUIT_DEMAND_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdIsNotNull() {
            addCriterion("RECRUIT_DEMAND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_ID =", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdNotEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_ID <>", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdGreaterThan(String value) {
            addCriterion("RECRUIT_DEMAND_ID >", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_ID >=", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdLessThan(String value) {
            addCriterion("RECRUIT_DEMAND_ID <", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdLessThanOrEqualTo(String value) {
            addCriterion("RECRUIT_DEMAND_ID <=", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdLike(String value) {
            addCriterion("RECRUIT_DEMAND_ID like", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdNotLike(String value) {
            addCriterion("RECRUIT_DEMAND_ID not like", value, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdIn(List<String> values) {
            addCriterion("RECRUIT_DEMAND_ID in", values, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdNotIn(List<String> values) {
            addCriterion("RECRUIT_DEMAND_ID not in", values, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdBetween(String value1, String value2) {
            addCriterion("RECRUIT_DEMAND_ID between", value1, value2, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdNotBetween(String value1, String value2) {
            addCriterion("RECRUIT_DEMAND_ID not between", value1, value2, "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdIsNull() {
            addCriterion("SHAER_PERSON_ID is null");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdIsNotNull() {
            addCriterion("SHAER_PERSON_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdEqualTo(String value) {
            addCriterion("SHAER_PERSON_ID =", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdNotEqualTo(String value) {
            addCriterion("SHAER_PERSON_ID <>", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdGreaterThan(String value) {
            addCriterion("SHAER_PERSON_ID >", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHAER_PERSON_ID >=", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdLessThan(String value) {
            addCriterion("SHAER_PERSON_ID <", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdLessThanOrEqualTo(String value) {
            addCriterion("SHAER_PERSON_ID <=", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdLike(String value) {
            addCriterion("SHAER_PERSON_ID like", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdNotLike(String value) {
            addCriterion("SHAER_PERSON_ID not like", value, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdIn(List<String> values) {
            addCriterion("SHAER_PERSON_ID in", values, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdNotIn(List<String> values) {
            addCriterion("SHAER_PERSON_ID not in", values, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdBetween(String value1, String value2) {
            addCriterion("SHAER_PERSON_ID between", value1, value2, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdNotBetween(String value1, String value2) {
            addCriterion("SHAER_PERSON_ID not between", value1, value2, "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("CREATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("CREATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(String value) {
            addCriterion("CREATOR_ID =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(String value) {
            addCriterion("CREATOR_ID <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(String value) {
            addCriterion("CREATOR_ID >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR_ID >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(String value) {
            addCriterion("CREATOR_ID <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("CREATOR_ID <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLike(String value) {
            addCriterion("CREATOR_ID like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotLike(String value) {
            addCriterion("CREATOR_ID not like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<String> values) {
            addCriterion("CREATOR_ID in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<String> values) {
            addCriterion("CREATOR_ID not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(String value1, String value2) {
            addCriterion("CREATOR_ID between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(String value1, String value2) {
            addCriterion("CREATOR_ID not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("POST_ID is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("POST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(String value) {
            addCriterion("POST_ID =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(String value) {
            addCriterion("POST_ID <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(String value) {
            addCriterion("POST_ID >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("POST_ID >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(String value) {
            addCriterion("POST_ID <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(String value) {
            addCriterion("POST_ID <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLike(String value) {
            addCriterion("POST_ID like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotLike(String value) {
            addCriterion("POST_ID not like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<String> values) {
            addCriterion("POST_ID in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<String> values) {
            addCriterion("POST_ID not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(String value1, String value2) {
            addCriterion("POST_ID between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(String value1, String value2) {
            addCriterion("POST_ID not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andRecruitDemandIdLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_DEMAND_ID) like", value.toUpperCase(), "recruitDemandId");
            return (Criteria) this;
        }

        public Criteria andShaerPersonIdLikeInsensitive(String value) {
            addCriterion("upper(SHAER_PERSON_ID) like", value.toUpperCase(), "shaerPersonId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLikeInsensitive(String value) {
            addCriterion("upper(CREATOR_ID) like", value.toUpperCase(), "creatorId");
            return (Criteria) this;
        }

        public Criteria andPostIdLikeInsensitive(String value) {
            addCriterion("upper(POST_ID) like", value.toUpperCase(), "postId");
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