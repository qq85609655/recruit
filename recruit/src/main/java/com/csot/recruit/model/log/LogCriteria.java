package com.csot.recruit.model.log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class LogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public LogCriteria() {
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

        public Criteria andLogidIsNull() {
            addCriterion("logid is null");
            return (Criteria) this;
        }

        public Criteria andLogidIsNotNull() {
            addCriterion("logid is not null");
            return (Criteria) this;
        }

        public Criteria andLogidEqualTo(String value) {
            addCriterion("logid =", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotEqualTo(String value) {
            addCriterion("logid <>", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThan(String value) {
            addCriterion("logid >", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThanOrEqualTo(String value) {
            addCriterion("logid >=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThan(String value) {
            addCriterion("logid <", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThanOrEqualTo(String value) {
            addCriterion("logid <=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLike(String value) {
            addCriterion("logid like", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotLike(String value) {
            addCriterion("logid not like", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidIn(List<String> values) {
            addCriterion("logid in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotIn(List<String> values) {
            addCriterion("logid not in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidBetween(String value1, String value2) {
            addCriterion("logid between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotBetween(String value1, String value2) {
            addCriterion("logid not between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andBroswerIsNull() {
            addCriterion("broswer is null");
            return (Criteria) this;
        }

        public Criteria andBroswerIsNotNull() {
            addCriterion("broswer is not null");
            return (Criteria) this;
        }

        public Criteria andBroswerEqualTo(String value) {
            addCriterion("broswer =", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotEqualTo(String value) {
            addCriterion("broswer <>", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerGreaterThan(String value) {
            addCriterion("broswer >", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerGreaterThanOrEqualTo(String value) {
            addCriterion("broswer >=", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLessThan(String value) {
            addCriterion("broswer <", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLessThanOrEqualTo(String value) {
            addCriterion("broswer <=", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLike(String value) {
            addCriterion("broswer like", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotLike(String value) {
            addCriterion("broswer not like", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerIn(List<String> values) {
            addCriterion("broswer in", values, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotIn(List<String> values) {
            addCriterion("broswer not in", values, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerBetween(String value1, String value2) {
            addCriterion("broswer between", value1, value2, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotBetween(String value1, String value2) {
            addCriterion("broswer not between", value1, value2, "broswer");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNull() {
            addCriterion("logcontent is null");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNotNull() {
            addCriterion("logcontent is not null");
            return (Criteria) this;
        }

        public Criteria andLogcontentEqualTo(String value) {
            addCriterion("logcontent =", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotEqualTo(String value) {
            addCriterion("logcontent <>", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThan(String value) {
            addCriterion("logcontent >", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThanOrEqualTo(String value) {
            addCriterion("logcontent >=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThan(String value) {
            addCriterion("logcontent <", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThanOrEqualTo(String value) {
            addCriterion("logcontent <=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLike(String value) {
            addCriterion("logcontent like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotLike(String value) {
            addCriterion("logcontent not like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentIn(List<String> values) {
            addCriterion("logcontent in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotIn(List<String> values) {
            addCriterion("logcontent not in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentBetween(String value1, String value2) {
            addCriterion("logcontent between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotBetween(String value1, String value2) {
            addCriterion("logcontent not between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLoglevelIsNull() {
            addCriterion("loglevel is null");
            return (Criteria) this;
        }

        public Criteria andLoglevelIsNotNull() {
            addCriterion("loglevel is not null");
            return (Criteria) this;
        }

        public Criteria andLoglevelEqualTo(BigDecimal value) {
            addCriterion("loglevel =", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotEqualTo(BigDecimal value) {
            addCriterion("loglevel <>", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelGreaterThan(BigDecimal value) {
            addCriterion("loglevel >", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loglevel >=", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelLessThan(BigDecimal value) {
            addCriterion("loglevel <", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loglevel <=", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelIn(List<BigDecimal> values) {
            addCriterion("loglevel in", values, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotIn(List<BigDecimal> values) {
            addCriterion("loglevel not in", values, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loglevel between", value1, value2, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loglevel not between", value1, value2, "loglevel");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNull() {
            addCriterion("operatetime is null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNotNull() {
            addCriterion("operatetime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeEqualTo(Date value) {
            addCriterion("operatetime =", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotEqualTo(Date value) {
            addCriterion("operatetime <>", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThan(Date value) {
            addCriterion("operatetime >", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operatetime >=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThan(Date value) {
            addCriterion("operatetime <", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThanOrEqualTo(Date value) {
            addCriterion("operatetime <=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIn(List<Date> values) {
            addCriterion("operatetime in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotIn(List<Date> values) {
            addCriterion("operatetime not in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeBetween(Date value1, Date value2) {
            addCriterion("operatetime between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotBetween(Date value1, Date value2) {
            addCriterion("operatetime not between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIsNull() {
            addCriterion("operatetype is null");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIsNotNull() {
            addCriterion("operatetype is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetypeEqualTo(BigDecimal value) {
            addCriterion("operatetype =", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotEqualTo(BigDecimal value) {
            addCriterion("operatetype <>", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeGreaterThan(BigDecimal value) {
            addCriterion("operatetype >", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operatetype >=", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeLessThan(BigDecimal value) {
            addCriterion("operatetype <", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operatetype <=", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIn(List<BigDecimal> values) {
            addCriterion("operatetype in", values, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotIn(List<BigDecimal> values) {
            addCriterion("operatetype not in", values, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operatetype between", value1, value2, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operatetype not between", value1, value2, "operatetype");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andLogidLikeInsensitive(String value) {
            addCriterion("upper(logid) like", value.toUpperCase(), "logid");
            return (Criteria) this;
        }

        public Criteria andBroswerLikeInsensitive(String value) {
            addCriterion("upper(broswer) like", value.toUpperCase(), "broswer");
            return (Criteria) this;
        }

        public Criteria andLogcontentLikeInsensitive(String value) {
            addCriterion("upper(logcontent) like", value.toUpperCase(), "logcontent");
            return (Criteria) this;
        }

        public Criteria andNoteLikeInsensitive(String value) {
            addCriterion("upper(note) like", value.toUpperCase(), "note");
            return (Criteria) this;
        }

        public Criteria andUseridLikeInsensitive(String value) {
            addCriterion("upper(userid) like", value.toUpperCase(), "userid");
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