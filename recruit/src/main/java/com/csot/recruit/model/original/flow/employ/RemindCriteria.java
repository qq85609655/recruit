package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RemindCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RemindCriteria() {
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

        public Criteria andRemindDateIsNull() {
            addCriterion("REMIND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRemindDateIsNotNull() {
            addCriterion("REMIND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRemindDateEqualTo(String value) {
            addCriterion("REMIND_DATE =", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateNotEqualTo(String value) {
            addCriterion("REMIND_DATE <>", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateGreaterThan(String value) {
            addCriterion("REMIND_DATE >", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateGreaterThanOrEqualTo(String value) {
            addCriterion("REMIND_DATE >=", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateLessThan(String value) {
            addCriterion("REMIND_DATE <", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateLessThanOrEqualTo(String value) {
            addCriterion("REMIND_DATE <=", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateLike(String value) {
            addCriterion("REMIND_DATE like", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateNotLike(String value) {
            addCriterion("REMIND_DATE not like", value, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateIn(List<String> values) {
            addCriterion("REMIND_DATE in", values, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateNotIn(List<String> values) {
            addCriterion("REMIND_DATE not in", values, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateBetween(String value1, String value2) {
            addCriterion("REMIND_DATE between", value1, value2, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindDateNotBetween(String value1, String value2) {
            addCriterion("REMIND_DATE not between", value1, value2, "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindContentIsNull() {
            addCriterion("REMIND_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andRemindContentIsNotNull() {
            addCriterion("REMIND_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andRemindContentEqualTo(String value) {
            addCriterion("REMIND_CONTENT =", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotEqualTo(String value) {
            addCriterion("REMIND_CONTENT <>", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentGreaterThan(String value) {
            addCriterion("REMIND_CONTENT >", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentGreaterThanOrEqualTo(String value) {
            addCriterion("REMIND_CONTENT >=", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentLessThan(String value) {
            addCriterion("REMIND_CONTENT <", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentLessThanOrEqualTo(String value) {
            addCriterion("REMIND_CONTENT <=", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentLike(String value) {
            addCriterion("REMIND_CONTENT like", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotLike(String value) {
            addCriterion("REMIND_CONTENT not like", value, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentIn(List<String> values) {
            addCriterion("REMIND_CONTENT in", values, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotIn(List<String> values) {
            addCriterion("REMIND_CONTENT not in", values, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentBetween(String value1, String value2) {
            addCriterion("REMIND_CONTENT between", value1, value2, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindContentNotBetween(String value1, String value2) {
            addCriterion("REMIND_CONTENT not between", value1, value2, "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindUserIsNull() {
            addCriterion("REMIND_USER is null");
            return (Criteria) this;
        }

        public Criteria andRemindUserIsNotNull() {
            addCriterion("REMIND_USER is not null");
            return (Criteria) this;
        }

        public Criteria andRemindUserEqualTo(String value) {
            addCriterion("REMIND_USER =", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserNotEqualTo(String value) {
            addCriterion("REMIND_USER <>", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserGreaterThan(String value) {
            addCriterion("REMIND_USER >", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserGreaterThanOrEqualTo(String value) {
            addCriterion("REMIND_USER >=", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserLessThan(String value) {
            addCriterion("REMIND_USER <", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserLessThanOrEqualTo(String value) {
            addCriterion("REMIND_USER <=", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserLike(String value) {
            addCriterion("REMIND_USER like", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserNotLike(String value) {
            addCriterion("REMIND_USER not like", value, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserIn(List<String> values) {
            addCriterion("REMIND_USER in", values, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserNotIn(List<String> values) {
            addCriterion("REMIND_USER not in", values, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserBetween(String value1, String value2) {
            addCriterion("REMIND_USER between", value1, value2, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserNotBetween(String value1, String value2) {
            addCriterion("REMIND_USER not between", value1, value2, "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameIsNull() {
            addCriterion("REMIND_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameIsNotNull() {
            addCriterion("REMIND_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameEqualTo(String value) {
            addCriterion("REMIND_USER_NAME =", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameNotEqualTo(String value) {
            addCriterion("REMIND_USER_NAME <>", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameGreaterThan(String value) {
            addCriterion("REMIND_USER_NAME >", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("REMIND_USER_NAME >=", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameLessThan(String value) {
            addCriterion("REMIND_USER_NAME <", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameLessThanOrEqualTo(String value) {
            addCriterion("REMIND_USER_NAME <=", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameLike(String value) {
            addCriterion("REMIND_USER_NAME like", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameNotLike(String value) {
            addCriterion("REMIND_USER_NAME not like", value, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameIn(List<String> values) {
            addCriterion("REMIND_USER_NAME in", values, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameNotIn(List<String> values) {
            addCriterion("REMIND_USER_NAME not in", values, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameBetween(String value1, String value2) {
            addCriterion("REMIND_USER_NAME between", value1, value2, "remindUserName");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameNotBetween(String value1, String value2) {
            addCriterion("REMIND_USER_NAME not between", value1, value2, "remindUserName");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andRemindDateLikeInsensitive(String value) {
            addCriterion("upper(REMIND_DATE) like", value.toUpperCase(), "remindDate");
            return (Criteria) this;
        }

        public Criteria andRemindContentLikeInsensitive(String value) {
            addCriterion("upper(REMIND_CONTENT) like", value.toUpperCase(), "remindContent");
            return (Criteria) this;
        }

        public Criteria andRemindUserLikeInsensitive(String value) {
            addCriterion("upper(REMIND_USER) like", value.toUpperCase(), "remindUser");
            return (Criteria) this;
        }

        public Criteria andRemindUserNameLikeInsensitive(String value) {
            addCriterion("upper(REMIND_USER_NAME) like", value.toUpperCase(), "remindUserName");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLikeInsensitive(String value) {
            addCriterion("upper(CREATOR_ID) like", value.toUpperCase(), "creatorId");
            return (Criteria) this;
        }

        public Criteria andModifiedIdLikeInsensitive(String value) {
            addCriterion("upper(MODIFIED_ID) like", value.toUpperCase(), "modifiedId");
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