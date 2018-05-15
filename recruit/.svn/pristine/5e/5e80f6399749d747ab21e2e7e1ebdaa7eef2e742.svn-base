package com.csot.recruit.model.original.flow.websitePost;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class PostWebsiteInstructCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public PostWebsiteInstructCriteria() {
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

        public Criteria andBeforeStateIsNull() {
            addCriterion("BEFORE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andBeforeStateIsNotNull() {
            addCriterion("BEFORE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeStateEqualTo(String value) {
            addCriterion("BEFORE_STATE =", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateNotEqualTo(String value) {
            addCriterion("BEFORE_STATE <>", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateGreaterThan(String value) {
            addCriterion("BEFORE_STATE >", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateGreaterThanOrEqualTo(String value) {
            addCriterion("BEFORE_STATE >=", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateLessThan(String value) {
            addCriterion("BEFORE_STATE <", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateLessThanOrEqualTo(String value) {
            addCriterion("BEFORE_STATE <=", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateLike(String value) {
            addCriterion("BEFORE_STATE like", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateNotLike(String value) {
            addCriterion("BEFORE_STATE not like", value, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateIn(List<String> values) {
            addCriterion("BEFORE_STATE in", values, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateNotIn(List<String> values) {
            addCriterion("BEFORE_STATE not in", values, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateBetween(String value1, String value2) {
            addCriterion("BEFORE_STATE between", value1, value2, "beforeState");
            return (Criteria) this;
        }

        public Criteria andBeforeStateNotBetween(String value1, String value2) {
            addCriterion("BEFORE_STATE not between", value1, value2, "beforeState");
            return (Criteria) this;
        }

        public Criteria andAfterStateIsNull() {
            addCriterion("AFTER_STATE is null");
            return (Criteria) this;
        }

        public Criteria andAfterStateIsNotNull() {
            addCriterion("AFTER_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStateEqualTo(String value) {
            addCriterion("AFTER_STATE =", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateNotEqualTo(String value) {
            addCriterion("AFTER_STATE <>", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateGreaterThan(String value) {
            addCriterion("AFTER_STATE >", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateGreaterThanOrEqualTo(String value) {
            addCriterion("AFTER_STATE >=", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateLessThan(String value) {
            addCriterion("AFTER_STATE <", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateLessThanOrEqualTo(String value) {
            addCriterion("AFTER_STATE <=", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateLike(String value) {
            addCriterion("AFTER_STATE like", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateNotLike(String value) {
            addCriterion("AFTER_STATE not like", value, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateIn(List<String> values) {
            addCriterion("AFTER_STATE in", values, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateNotIn(List<String> values) {
            addCriterion("AFTER_STATE not in", values, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateBetween(String value1, String value2) {
            addCriterion("AFTER_STATE between", value1, value2, "afterState");
            return (Criteria) this;
        }

        public Criteria andAfterStateNotBetween(String value1, String value2) {
            addCriterion("AFTER_STATE not between", value1, value2, "afterState");
            return (Criteria) this;
        }

        public Criteria andInstructTypeIsNull() {
            addCriterion("INSTRUCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInstructTypeIsNotNull() {
            addCriterion("INSTRUCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInstructTypeEqualTo(String value) {
            addCriterion("INSTRUCT_TYPE =", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeNotEqualTo(String value) {
            addCriterion("INSTRUCT_TYPE <>", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeGreaterThan(String value) {
            addCriterion("INSTRUCT_TYPE >", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INSTRUCT_TYPE >=", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeLessThan(String value) {
            addCriterion("INSTRUCT_TYPE <", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeLessThanOrEqualTo(String value) {
            addCriterion("INSTRUCT_TYPE <=", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeLike(String value) {
            addCriterion("INSTRUCT_TYPE like", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeNotLike(String value) {
            addCriterion("INSTRUCT_TYPE not like", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeIn(List<String> values) {
            addCriterion("INSTRUCT_TYPE in", values, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeNotIn(List<String> values) {
            addCriterion("INSTRUCT_TYPE not in", values, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeBetween(String value1, String value2) {
            addCriterion("INSTRUCT_TYPE between", value1, value2, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeNotBetween(String value1, String value2) {
            addCriterion("INSTRUCT_TYPE not between", value1, value2, "instructType");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdIsNull() {
            addCriterion("POST_WEBSITE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdIsNotNull() {
            addCriterion("POST_WEBSITE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdEqualTo(String value) {
            addCriterion("POST_WEBSITE_ID =", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdNotEqualTo(String value) {
            addCriterion("POST_WEBSITE_ID <>", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdGreaterThan(String value) {
            addCriterion("POST_WEBSITE_ID >", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdGreaterThanOrEqualTo(String value) {
            addCriterion("POST_WEBSITE_ID >=", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdLessThan(String value) {
            addCriterion("POST_WEBSITE_ID <", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdLessThanOrEqualTo(String value) {
            addCriterion("POST_WEBSITE_ID <=", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdLike(String value) {
            addCriterion("POST_WEBSITE_ID like", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdNotLike(String value) {
            addCriterion("POST_WEBSITE_ID not like", value, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdIn(List<String> values) {
            addCriterion("POST_WEBSITE_ID in", values, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdNotIn(List<String> values) {
            addCriterion("POST_WEBSITE_ID not in", values, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdBetween(String value1, String value2) {
            addCriterion("POST_WEBSITE_ID between", value1, value2, "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdNotBetween(String value1, String value2) {
            addCriterion("POST_WEBSITE_ID not between", value1, value2, "postWebsiteId");
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

        public Criteria andIsDealIsNull() {
            addCriterion("IS_DEAL is null");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNotNull() {
            addCriterion("IS_DEAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealEqualTo(String value) {
            addCriterion("IS_DEAL =", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotEqualTo(String value) {
            addCriterion("IS_DEAL <>", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThan(String value) {
            addCriterion("IS_DEAL >", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEAL >=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThan(String value) {
            addCriterion("IS_DEAL <", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThanOrEqualTo(String value) {
            addCriterion("IS_DEAL <=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLike(String value) {
            addCriterion("IS_DEAL like", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotLike(String value) {
            addCriterion("IS_DEAL not like", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealIn(List<String> values) {
            addCriterion("IS_DEAL in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotIn(List<String> values) {
            addCriterion("IS_DEAL not in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealBetween(String value1, String value2) {
            addCriterion("IS_DEAL between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotBetween(String value1, String value2) {
            addCriterion("IS_DEAL not between", value1, value2, "isDeal");
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

        public Criteria andRecruitPositionIdIsNull() {
            addCriterion("RECRUIT_POSITION_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNotNull() {
            addCriterion("RECRUIT_POSITION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID =", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID <>", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThan(String value) {
            addCriterion("RECRUIT_POSITION_ID >", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID >=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThan(String value) {
            addCriterion("RECRUIT_POSITION_ID <", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThanOrEqualTo(String value) {
            addCriterion("RECRUIT_POSITION_ID <=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLike(String value) {
            addCriterion("RECRUIT_POSITION_ID like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotLike(String value) {
            addCriterion("RECRUIT_POSITION_ID not like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIn(List<String> values) {
            addCriterion("RECRUIT_POSITION_ID in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotIn(List<String> values) {
            addCriterion("RECRUIT_POSITION_ID not in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdBetween(String value1, String value2) {
            addCriterion("RECRUIT_POSITION_ID between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotBetween(String value1, String value2) {
            addCriterion("RECRUIT_POSITION_ID not between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNull() {
            addCriterion("POST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPostNameIsNotNull() {
            addCriterion("POST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPostNameEqualTo(String value) {
            addCriterion("POST_NAME =", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotEqualTo(String value) {
            addCriterion("POST_NAME <>", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThan(String value) {
            addCriterion("POST_NAME >", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("POST_NAME >=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThan(String value) {
            addCriterion("POST_NAME <", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLessThanOrEqualTo(String value) {
            addCriterion("POST_NAME <=", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameLike(String value) {
            addCriterion("POST_NAME like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotLike(String value) {
            addCriterion("POST_NAME not like", value, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameIn(List<String> values) {
            addCriterion("POST_NAME in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotIn(List<String> values) {
            addCriterion("POST_NAME not in", values, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameBetween(String value1, String value2) {
            addCriterion("POST_NAME between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andPostNameNotBetween(String value1, String value2) {
            addCriterion("POST_NAME not between", value1, value2, "postName");
            return (Criteria) this;
        }

        public Criteria andDeputyIdIsNull() {
            addCriterion("DEPUTY_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeputyIdIsNotNull() {
            addCriterion("DEPUTY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeputyIdEqualTo(String value) {
            addCriterion("DEPUTY_ID =", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdNotEqualTo(String value) {
            addCriterion("DEPUTY_ID <>", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdGreaterThan(String value) {
            addCriterion("DEPUTY_ID >", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPUTY_ID >=", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdLessThan(String value) {
            addCriterion("DEPUTY_ID <", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdLessThanOrEqualTo(String value) {
            addCriterion("DEPUTY_ID <=", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdLike(String value) {
            addCriterion("DEPUTY_ID like", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdNotLike(String value) {
            addCriterion("DEPUTY_ID not like", value, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdIn(List<String> values) {
            addCriterion("DEPUTY_ID in", values, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdNotIn(List<String> values) {
            addCriterion("DEPUTY_ID not in", values, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdBetween(String value1, String value2) {
            addCriterion("DEPUTY_ID between", value1, value2, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyIdNotBetween(String value1, String value2) {
            addCriterion("DEPUTY_ID not between", value1, value2, "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyNameIsNull() {
            addCriterion("DEPUTY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDeputyNameIsNotNull() {
            addCriterion("DEPUTY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeputyNameEqualTo(String value) {
            addCriterion("DEPUTY_NAME =", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameNotEqualTo(String value) {
            addCriterion("DEPUTY_NAME <>", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameGreaterThan(String value) {
            addCriterion("DEPUTY_NAME >", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPUTY_NAME >=", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameLessThan(String value) {
            addCriterion("DEPUTY_NAME <", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameLessThanOrEqualTo(String value) {
            addCriterion("DEPUTY_NAME <=", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameLike(String value) {
            addCriterion("DEPUTY_NAME like", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameNotLike(String value) {
            addCriterion("DEPUTY_NAME not like", value, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameIn(List<String> values) {
            addCriterion("DEPUTY_NAME in", values, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameNotIn(List<String> values) {
            addCriterion("DEPUTY_NAME not in", values, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameBetween(String value1, String value2) {
            addCriterion("DEPUTY_NAME between", value1, value2, "deputyName");
            return (Criteria) this;
        }

        public Criteria andDeputyNameNotBetween(String value1, String value2) {
            addCriterion("DEPUTY_NAME not between", value1, value2, "deputyName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameIsNull() {
            addCriterion("WEBSITE_POST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameIsNotNull() {
            addCriterion("WEBSITE_POST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameEqualTo(String value) {
            addCriterion("WEBSITE_POST_NAME =", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameNotEqualTo(String value) {
            addCriterion("WEBSITE_POST_NAME <>", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameGreaterThan(String value) {
            addCriterion("WEBSITE_POST_NAME >", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameGreaterThanOrEqualTo(String value) {
            addCriterion("WEBSITE_POST_NAME >=", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameLessThan(String value) {
            addCriterion("WEBSITE_POST_NAME <", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameLessThanOrEqualTo(String value) {
            addCriterion("WEBSITE_POST_NAME <=", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameLike(String value) {
            addCriterion("WEBSITE_POST_NAME like", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameNotLike(String value) {
            addCriterion("WEBSITE_POST_NAME not like", value, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameIn(List<String> values) {
            addCriterion("WEBSITE_POST_NAME in", values, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameNotIn(List<String> values) {
            addCriterion("WEBSITE_POST_NAME not in", values, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameBetween(String value1, String value2) {
            addCriterion("WEBSITE_POST_NAME between", value1, value2, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameNotBetween(String value1, String value2) {
            addCriterion("WEBSITE_POST_NAME not between", value1, value2, "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeIsNull() {
            addCriterion("WEBSITE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeIsNotNull() {
            addCriterion("WEBSITE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeEqualTo(String value) {
            addCriterion("WEBSITE_TYPE =", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeNotEqualTo(String value) {
            addCriterion("WEBSITE_TYPE <>", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeGreaterThan(String value) {
            addCriterion("WEBSITE_TYPE >", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WEBSITE_TYPE >=", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeLessThan(String value) {
            addCriterion("WEBSITE_TYPE <", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeLessThanOrEqualTo(String value) {
            addCriterion("WEBSITE_TYPE <=", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeLike(String value) {
            addCriterion("WEBSITE_TYPE like", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeNotLike(String value) {
            addCriterion("WEBSITE_TYPE not like", value, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeIn(List<String> values) {
            addCriterion("WEBSITE_TYPE in", values, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeNotIn(List<String> values) {
            addCriterion("WEBSITE_TYPE not in", values, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeBetween(String value1, String value2) {
            addCriterion("WEBSITE_TYPE between", value1, value2, "websiteType");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeNotBetween(String value1, String value2) {
            addCriterion("WEBSITE_TYPE not between", value1, value2, "websiteType");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andBeforeStateLikeInsensitive(String value) {
            addCriterion("upper(BEFORE_STATE) like", value.toUpperCase(), "beforeState");
            return (Criteria) this;
        }

        public Criteria andAfterStateLikeInsensitive(String value) {
            addCriterion("upper(AFTER_STATE) like", value.toUpperCase(), "afterState");
            return (Criteria) this;
        }

        public Criteria andInstructTypeLikeInsensitive(String value) {
            addCriterion("upper(INSTRUCT_TYPE) like", value.toUpperCase(), "instructType");
            return (Criteria) this;
        }

        public Criteria andPostWebsiteIdLikeInsensitive(String value) {
            addCriterion("upper(POST_WEBSITE_ID) like", value.toUpperCase(), "postWebsiteId");
            return (Criteria) this;
        }

        public Criteria andIsDealLikeInsensitive(String value) {
            addCriterion("upper(IS_DEAL) like", value.toUpperCase(), "isDeal");
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

        public Criteria andPostIdLikeInsensitive(String value) {
            addCriterion("upper(POST_ID) like", value.toUpperCase(), "postId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_POSITION_ID) like", value.toUpperCase(), "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andPostNameLikeInsensitive(String value) {
            addCriterion("upper(POST_NAME) like", value.toUpperCase(), "postName");
            return (Criteria) this;
        }

        public Criteria andDeputyIdLikeInsensitive(String value) {
            addCriterion("upper(DEPUTY_ID) like", value.toUpperCase(), "deputyId");
            return (Criteria) this;
        }

        public Criteria andDeputyNameLikeInsensitive(String value) {
            addCriterion("upper(DEPUTY_NAME) like", value.toUpperCase(), "deputyName");
            return (Criteria) this;
        }

        public Criteria andWebsitePostNameLikeInsensitive(String value) {
            addCriterion("upper(WEBSITE_POST_NAME) like", value.toUpperCase(), "websitePostName");
            return (Criteria) this;
        }

        public Criteria andWebsiteTypeLikeInsensitive(String value) {
            addCriterion("upper(WEBSITE_TYPE) like", value.toUpperCase(), "websiteType");
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