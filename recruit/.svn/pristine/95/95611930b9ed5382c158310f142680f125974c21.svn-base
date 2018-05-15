package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class EmployBlacklistCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EmployBlacklistCriteria() {
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

        public Criteria andCandidateIdIsNull() {
            addCriterion("CANDIDATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIsNotNull() {
            addCriterion("CANDIDATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdEqualTo(String value) {
            addCriterion("CANDIDATE_ID =", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotEqualTo(String value) {
            addCriterion("CANDIDATE_ID <>", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThan(String value) {
            addCriterion("CANDIDATE_ID >", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ID >=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThan(String value) {
            addCriterion("CANDIDATE_ID <", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ID <=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLike(String value) {
            addCriterion("CANDIDATE_ID like", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotLike(String value) {
            addCriterion("CANDIDATE_ID not like", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIn(List<String> values) {
            addCriterion("CANDIDATE_ID in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotIn(List<String> values) {
            addCriterion("CANDIDATE_ID not in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ID between", value1, value2, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ID not between", value1, value2, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateNameIsNull() {
            addCriterion("CANDIDATE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCandidateNameIsNotNull() {
            addCriterion("CANDIDATE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateNameEqualTo(String value) {
            addCriterion("CANDIDATE_NAME =", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotEqualTo(String value) {
            addCriterion("CANDIDATE_NAME <>", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameGreaterThan(String value) {
            addCriterion("CANDIDATE_NAME >", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_NAME >=", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLessThan(String value) {
            addCriterion("CANDIDATE_NAME <", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_NAME <=", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLike(String value) {
            addCriterion("CANDIDATE_NAME like", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotLike(String value) {
            addCriterion("CANDIDATE_NAME not like", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameIn(List<String> values) {
            addCriterion("CANDIDATE_NAME in", values, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotIn(List<String> values) {
            addCriterion("CANDIDATE_NAME not in", values, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameBetween(String value1, String value2) {
            addCriterion("CANDIDATE_NAME between", value1, value2, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_NAME not between", value1, value2, "candidateName");
            return (Criteria) this;
        }

        public Criteria andInReasonIsNull() {
            addCriterion("IN_REASON is null");
            return (Criteria) this;
        }

        public Criteria andInReasonIsNotNull() {
            addCriterion("IN_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andInReasonEqualTo(String value) {
            addCriterion("IN_REASON =", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotEqualTo(String value) {
            addCriterion("IN_REASON <>", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonGreaterThan(String value) {
            addCriterion("IN_REASON >", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonGreaterThanOrEqualTo(String value) {
            addCriterion("IN_REASON >=", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonLessThan(String value) {
            addCriterion("IN_REASON <", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonLessThanOrEqualTo(String value) {
            addCriterion("IN_REASON <=", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonLike(String value) {
            addCriterion("IN_REASON like", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotLike(String value) {
            addCriterion("IN_REASON not like", value, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonIn(List<String> values) {
            addCriterion("IN_REASON in", values, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotIn(List<String> values) {
            addCriterion("IN_REASON not in", values, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonBetween(String value1, String value2) {
            addCriterion("IN_REASON between", value1, value2, "inReason");
            return (Criteria) this;
        }

        public Criteria andInReasonNotBetween(String value1, String value2) {
            addCriterion("IN_REASON not between", value1, value2, "inReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonIsNull() {
            addCriterion("OUT_REASON is null");
            return (Criteria) this;
        }

        public Criteria andOutReasonIsNotNull() {
            addCriterion("OUT_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andOutReasonEqualTo(String value) {
            addCriterion("OUT_REASON =", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotEqualTo(String value) {
            addCriterion("OUT_REASON <>", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonGreaterThan(String value) {
            addCriterion("OUT_REASON >", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_REASON >=", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLessThan(String value) {
            addCriterion("OUT_REASON <", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLessThanOrEqualTo(String value) {
            addCriterion("OUT_REASON <=", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLike(String value) {
            addCriterion("OUT_REASON like", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotLike(String value) {
            addCriterion("OUT_REASON not like", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonIn(List<String> values) {
            addCriterion("OUT_REASON in", values, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotIn(List<String> values) {
            addCriterion("OUT_REASON not in", values, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonBetween(String value1, String value2) {
            addCriterion("OUT_REASON between", value1, value2, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotBetween(String value1, String value2) {
            addCriterion("OUT_REASON not between", value1, value2, "outReason");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
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

        public Criteria andCandidateIdLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_ID) like", value.toUpperCase(), "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_NAME) like", value.toUpperCase(), "candidateName");
            return (Criteria) this;
        }

        public Criteria andInReasonLikeInsensitive(String value) {
            addCriterion("upper(IN_REASON) like", value.toUpperCase(), "inReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLikeInsensitive(String value) {
            addCriterion("upper(OUT_REASON) like", value.toUpperCase(), "outReason");
            return (Criteria) this;
        }

        public Criteria andStateLikeInsensitive(String value) {
            addCriterion("upper(STATE) like", value.toUpperCase(), "state");
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