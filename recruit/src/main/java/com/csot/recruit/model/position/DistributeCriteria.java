package com.csot.recruit.model.position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class DistributeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DistributeCriteria() {
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

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDistributeDateIsNull() {
            addCriterion("DISTRIBUTE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDistributeDateIsNotNull() {
            addCriterion("DISTRIBUTE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDistributeDateEqualTo(Date value) {
            addCriterion("DISTRIBUTE_DATE =", value, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateNotEqualTo(Date value) {
            addCriterion("DISTRIBUTE_DATE <>", value, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateGreaterThan(Date value) {
            addCriterion("DISTRIBUTE_DATE >", value, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DISTRIBUTE_DATE >=", value, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateLessThan(Date value) {
            addCriterion("DISTRIBUTE_DATE <", value, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateLessThanOrEqualTo(Date value) {
            addCriterion("DISTRIBUTE_DATE <=", value, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateIn(List<Date> values) {
            addCriterion("DISTRIBUTE_DATE in", values, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateNotIn(List<Date> values) {
            addCriterion("DISTRIBUTE_DATE not in", values, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateBetween(Date value1, Date value2) {
            addCriterion("DISTRIBUTE_DATE between", value1, value2, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andDistributeDateNotBetween(Date value1, Date value2) {
            addCriterion("DISTRIBUTE_DATE not between", value1, value2, "distributeDate");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNull() {
            addCriterion("PUBLISHER is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNotNull() {
            addCriterion("PUBLISHER is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherEqualTo(String value) {
            addCriterion("PUBLISHER =", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotEqualTo(String value) {
            addCriterion("PUBLISHER <>", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThan(String value) {
            addCriterion("PUBLISHER >", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLISHER >=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThan(String value) {
            addCriterion("PUBLISHER <", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThanOrEqualTo(String value) {
            addCriterion("PUBLISHER <=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLike(String value) {
            addCriterion("PUBLISHER like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotLike(String value) {
            addCriterion("PUBLISHER not like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherIn(List<String> values) {
            addCriterion("PUBLISHER in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotIn(List<String> values) {
            addCriterion("PUBLISHER not in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherBetween(String value1, String value2) {
            addCriterion("PUBLISHER between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotBetween(String value1, String value2) {
            addCriterion("PUBLISHER not between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(BigDecimal value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(BigDecimal value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(BigDecimal value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(BigDecimal value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<BigDecimal> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<BigDecimal> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andPublishSiteIsNull() {
            addCriterion("PUBLISH_SITE is null");
            return (Criteria) this;
        }

        public Criteria andPublishSiteIsNotNull() {
            addCriterion("PUBLISH_SITE is not null");
            return (Criteria) this;
        }

        public Criteria andPublishSiteEqualTo(String value) {
            addCriterion("PUBLISH_SITE =", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteNotEqualTo(String value) {
            addCriterion("PUBLISH_SITE <>", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteGreaterThan(String value) {
            addCriterion("PUBLISH_SITE >", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLISH_SITE >=", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteLessThan(String value) {
            addCriterion("PUBLISH_SITE <", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteLessThanOrEqualTo(String value) {
            addCriterion("PUBLISH_SITE <=", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteLike(String value) {
            addCriterion("PUBLISH_SITE like", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteNotLike(String value) {
            addCriterion("PUBLISH_SITE not like", value, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteIn(List<String> values) {
            addCriterion("PUBLISH_SITE in", values, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteNotIn(List<String> values) {
            addCriterion("PUBLISH_SITE not in", values, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteBetween(String value1, String value2) {
            addCriterion("PUBLISH_SITE between", value1, value2, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishSiteNotBetween(String value1, String value2) {
            addCriterion("PUBLISH_SITE not between", value1, value2, "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishUrlIsNull() {
            addCriterion("PUBLISH_URL is null");
            return (Criteria) this;
        }

        public Criteria andPublishUrlIsNotNull() {
            addCriterion("PUBLISH_URL is not null");
            return (Criteria) this;
        }

        public Criteria andPublishUrlEqualTo(String value) {
            addCriterion("PUBLISH_URL =", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlNotEqualTo(String value) {
            addCriterion("PUBLISH_URL <>", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlGreaterThan(String value) {
            addCriterion("PUBLISH_URL >", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLISH_URL >=", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlLessThan(String value) {
            addCriterion("PUBLISH_URL <", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlLessThanOrEqualTo(String value) {
            addCriterion("PUBLISH_URL <=", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlLike(String value) {
            addCriterion("PUBLISH_URL like", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlNotLike(String value) {
            addCriterion("PUBLISH_URL not like", value, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlIn(List<String> values) {
            addCriterion("PUBLISH_URL in", values, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlNotIn(List<String> values) {
            addCriterion("PUBLISH_URL not in", values, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlBetween(String value1, String value2) {
            addCriterion("PUBLISH_URL between", value1, value2, "publishUrl");
            return (Criteria) this;
        }

        public Criteria andPublishUrlNotBetween(String value1, String value2) {
            addCriterion("PUBLISH_URL not between", value1, value2, "publishUrl");
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

        public Criteria andErrorMessageIsNull() {
            addCriterion("ERROR_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNotNull() {
            addCriterion("ERROR_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageEqualTo(String value) {
            addCriterion("ERROR_MESSAGE =", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotEqualTo(String value) {
            addCriterion("ERROR_MESSAGE <>", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThan(String value) {
            addCriterion("ERROR_MESSAGE >", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_MESSAGE >=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThan(String value) {
            addCriterion("ERROR_MESSAGE <", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThanOrEqualTo(String value) {
            addCriterion("ERROR_MESSAGE <=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLike(String value) {
            addCriterion("ERROR_MESSAGE like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotLike(String value) {
            addCriterion("ERROR_MESSAGE not like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIn(List<String> values) {
            addCriterion("ERROR_MESSAGE in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotIn(List<String> values) {
            addCriterion("ERROR_MESSAGE not in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageBetween(String value1, String value2) {
            addCriterion("ERROR_MESSAGE between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotBetween(String value1, String value2) {
            addCriterion("ERROR_MESSAGE not between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andPublisherLikeInsensitive(String value) {
            addCriterion("upper(PUBLISHER) like", value.toUpperCase(), "publisher");
            return (Criteria) this;
        }

        public Criteria andPublishSiteLikeInsensitive(String value) {
            addCriterion("upper(PUBLISH_SITE) like", value.toUpperCase(), "publishSite");
            return (Criteria) this;
        }

        public Criteria andPublishUrlLikeInsensitive(String value) {
            addCriterion("upper(PUBLISH_URL) like", value.toUpperCase(), "publishUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_POSITION_ID) like", value.toUpperCase(), "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLikeInsensitive(String value) {
            addCriterion("upper(ERROR_MESSAGE) like", value.toUpperCase(), "errorMessage");
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