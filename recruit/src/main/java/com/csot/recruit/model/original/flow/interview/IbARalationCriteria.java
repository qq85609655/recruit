package com.csot.recruit.model.original.flow.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class IbARalationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IbARalationCriteria() {
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

        public Criteria andInterviewBookIdIsNull() {
            addCriterion("INTERVIEW_BOOK_ID is null");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdIsNotNull() {
            addCriterion("INTERVIEW_BOOK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdEqualTo(String value) {
            addCriterion("INTERVIEW_BOOK_ID =", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdNotEqualTo(String value) {
            addCriterion("INTERVIEW_BOOK_ID <>", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdGreaterThan(String value) {
            addCriterion("INTERVIEW_BOOK_ID >", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_BOOK_ID >=", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdLessThan(String value) {
            addCriterion("INTERVIEW_BOOK_ID <", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_BOOK_ID <=", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdLike(String value) {
            addCriterion("INTERVIEW_BOOK_ID like", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdNotLike(String value) {
            addCriterion("INTERVIEW_BOOK_ID not like", value, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdIn(List<String> values) {
            addCriterion("INTERVIEW_BOOK_ID in", values, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdNotIn(List<String> values) {
            addCriterion("INTERVIEW_BOOK_ID not in", values, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdBetween(String value1, String value2) {
            addCriterion("INTERVIEW_BOOK_ID between", value1, value2, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_BOOK_ID not between", value1, value2, "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIsNull() {
            addCriterion("ATTACHMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIsNotNull() {
            addCriterion("ATTACHMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdEqualTo(String value) {
            addCriterion("ATTACHMENT_ID =", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotEqualTo(String value) {
            addCriterion("ATTACHMENT_ID <>", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdGreaterThan(String value) {
            addCriterion("ATTACHMENT_ID >", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACHMENT_ID >=", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLessThan(String value) {
            addCriterion("ATTACHMENT_ID <", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLessThanOrEqualTo(String value) {
            addCriterion("ATTACHMENT_ID <=", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLike(String value) {
            addCriterion("ATTACHMENT_ID like", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotLike(String value) {
            addCriterion("ATTACHMENT_ID not like", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIn(List<String> values) {
            addCriterion("ATTACHMENT_ID in", values, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotIn(List<String> values) {
            addCriterion("ATTACHMENT_ID not in", values, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdBetween(String value1, String value2) {
            addCriterion("ATTACHMENT_ID between", value1, value2, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotBetween(String value1, String value2) {
            addCriterion("ATTACHMENT_ID not between", value1, value2, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andInterviewBookIdLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_BOOK_ID) like", value.toUpperCase(), "interviewBookId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLikeInsensitive(String value) {
            addCriterion("upper(ATTACHMENT_ID) like", value.toUpperCase(), "attachmentId");
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