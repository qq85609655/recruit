package com.csot.recruit.model.original.flow.interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class InterviewBookCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public InterviewBookCriteria() {
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

        public Criteria andIntervieweeIsNull() {
            addCriterion("INTERVIEWEE is null");
            return (Criteria) this;
        }

        public Criteria andIntervieweeIsNotNull() {
            addCriterion("INTERVIEWEE is not null");
            return (Criteria) this;
        }

        public Criteria andIntervieweeEqualTo(String value) {
            addCriterion("INTERVIEWEE =", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeNotEqualTo(String value) {
            addCriterion("INTERVIEWEE <>", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeGreaterThan(String value) {
            addCriterion("INTERVIEWEE >", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEWEE >=", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeLessThan(String value) {
            addCriterion("INTERVIEWEE <", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEWEE <=", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeLike(String value) {
            addCriterion("INTERVIEWEE like", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeNotLike(String value) {
            addCriterion("INTERVIEWEE not like", value, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeIn(List<String> values) {
            addCriterion("INTERVIEWEE in", values, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeNotIn(List<String> values) {
            addCriterion("INTERVIEWEE not in", values, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeBetween(String value1, String value2) {
            addCriterion("INTERVIEWEE between", value1, value2, "interviewee");
            return (Criteria) this;
        }

        public Criteria andIntervieweeNotBetween(String value1, String value2) {
            addCriterion("INTERVIEWEE not between", value1, value2, "interviewee");
            return (Criteria) this;
        }

        public Criteria andInterviewersIsNull() {
            addCriterion("INTERVIEWERS is null");
            return (Criteria) this;
        }

        public Criteria andInterviewersIsNotNull() {
            addCriterion("INTERVIEWERS is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewersEqualTo(String value) {
            addCriterion("INTERVIEWERS =", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersNotEqualTo(String value) {
            addCriterion("INTERVIEWERS <>", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersGreaterThan(String value) {
            addCriterion("INTERVIEWERS >", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEWERS >=", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersLessThan(String value) {
            addCriterion("INTERVIEWERS <", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEWERS <=", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersLike(String value) {
            addCriterion("INTERVIEWERS like", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersNotLike(String value) {
            addCriterion("INTERVIEWERS not like", value, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersIn(List<String> values) {
            addCriterion("INTERVIEWERS in", values, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersNotIn(List<String> values) {
            addCriterion("INTERVIEWERS not in", values, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersBetween(String value1, String value2) {
            addCriterion("INTERVIEWERS between", value1, value2, "interviewers");
            return (Criteria) this;
        }

        public Criteria andInterviewersNotBetween(String value1, String value2) {
            addCriterion("INTERVIEWERS not between", value1, value2, "interviewers");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("LINKMAN =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("LINKMAN <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("LINKMAN >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("LINKMAN >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("LINKMAN <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("LINKMAN <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("LINKMAN like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("LINKMAN not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("LINKMAN in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("LINKMAN not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("LINKMAN between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("LINKMAN not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeIsNull() {
            addCriterion("INTERVIEW_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeIsNotNull() {
            addCriterion("INTERVIEW_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeEqualTo(String value) {
            addCriterion("INTERVIEW_TYPE =", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeNotEqualTo(String value) {
            addCriterion("INTERVIEW_TYPE <>", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeGreaterThan(String value) {
            addCriterion("INTERVIEW_TYPE >", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_TYPE >=", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeLessThan(String value) {
            addCriterion("INTERVIEW_TYPE <", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_TYPE <=", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeLike(String value) {
            addCriterion("INTERVIEW_TYPE like", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeNotLike(String value) {
            addCriterion("INTERVIEW_TYPE not like", value, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeIn(List<String> values) {
            addCriterion("INTERVIEW_TYPE in", values, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeNotIn(List<String> values) {
            addCriterion("INTERVIEW_TYPE not in", values, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeBetween(String value1, String value2) {
            addCriterion("INTERVIEW_TYPE between", value1, value2, "interviewType");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_TYPE not between", value1, value2, "interviewType");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andWaitAddressIsNull() {
            addCriterion("WAIT_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andWaitAddressIsNotNull() {
            addCriterion("WAIT_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andWaitAddressEqualTo(String value) {
            addCriterion("WAIT_ADDRESS =", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressNotEqualTo(String value) {
            addCriterion("WAIT_ADDRESS <>", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressGreaterThan(String value) {
            addCriterion("WAIT_ADDRESS >", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressGreaterThanOrEqualTo(String value) {
            addCriterion("WAIT_ADDRESS >=", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressLessThan(String value) {
            addCriterion("WAIT_ADDRESS <", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressLessThanOrEqualTo(String value) {
            addCriterion("WAIT_ADDRESS <=", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressLike(String value) {
            addCriterion("WAIT_ADDRESS like", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressNotLike(String value) {
            addCriterion("WAIT_ADDRESS not like", value, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressIn(List<String> values) {
            addCriterion("WAIT_ADDRESS in", values, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressNotIn(List<String> values) {
            addCriterion("WAIT_ADDRESS not in", values, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressBetween(String value1, String value2) {
            addCriterion("WAIT_ADDRESS between", value1, value2, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andWaitAddressNotBetween(String value1, String value2) {
            addCriterion("WAIT_ADDRESS not between", value1, value2, "waitAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIsNull() {
            addCriterion("INTERVIEW_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIsNotNull() {
            addCriterion("INTERVIEW_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressEqualTo(String value) {
            addCriterion("INTERVIEW_ADDRESS =", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotEqualTo(String value) {
            addCriterion("INTERVIEW_ADDRESS <>", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressGreaterThan(String value) {
            addCriterion("INTERVIEW_ADDRESS >", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_ADDRESS >=", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLessThan(String value) {
            addCriterion("INTERVIEW_ADDRESS <", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_ADDRESS <=", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLike(String value) {
            addCriterion("INTERVIEW_ADDRESS like", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotLike(String value) {
            addCriterion("INTERVIEW_ADDRESS not like", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIn(List<String> values) {
            addCriterion("INTERVIEW_ADDRESS in", values, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotIn(List<String> values) {
            addCriterion("INTERVIEW_ADDRESS not in", values, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressBetween(String value1, String value2) {
            addCriterion("INTERVIEW_ADDRESS between", value1, value2, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_ADDRESS not between", value1, value2, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andIsMessageIsNull() {
            addCriterion("IS_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andIsMessageIsNotNull() {
            addCriterion("IS_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andIsMessageEqualTo(String value) {
            addCriterion("IS_MESSAGE =", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageNotEqualTo(String value) {
            addCriterion("IS_MESSAGE <>", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageGreaterThan(String value) {
            addCriterion("IS_MESSAGE >", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageGreaterThanOrEqualTo(String value) {
            addCriterion("IS_MESSAGE >=", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageLessThan(String value) {
            addCriterion("IS_MESSAGE <", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageLessThanOrEqualTo(String value) {
            addCriterion("IS_MESSAGE <=", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageLike(String value) {
            addCriterion("IS_MESSAGE like", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageNotLike(String value) {
            addCriterion("IS_MESSAGE not like", value, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageIn(List<String> values) {
            addCriterion("IS_MESSAGE in", values, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageNotIn(List<String> values) {
            addCriterion("IS_MESSAGE not in", values, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageBetween(String value1, String value2) {
            addCriterion("IS_MESSAGE between", value1, value2, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsMessageNotBetween(String value1, String value2) {
            addCriterion("IS_MESSAGE not between", value1, value2, "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsEmailIsNull() {
            addCriterion("IS_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andIsEmailIsNotNull() {
            addCriterion("IS_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andIsEmailEqualTo(String value) {
            addCriterion("IS_EMAIL =", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailNotEqualTo(String value) {
            addCriterion("IS_EMAIL <>", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailGreaterThan(String value) {
            addCriterion("IS_EMAIL >", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailGreaterThanOrEqualTo(String value) {
            addCriterion("IS_EMAIL >=", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailLessThan(String value) {
            addCriterion("IS_EMAIL <", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailLessThanOrEqualTo(String value) {
            addCriterion("IS_EMAIL <=", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailLike(String value) {
            addCriterion("IS_EMAIL like", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailNotLike(String value) {
            addCriterion("IS_EMAIL not like", value, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailIn(List<String> values) {
            addCriterion("IS_EMAIL in", values, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailNotIn(List<String> values) {
            addCriterion("IS_EMAIL not in", values, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailBetween(String value1, String value2) {
            addCriterion("IS_EMAIL between", value1, value2, "isEmail");
            return (Criteria) this;
        }

        public Criteria andIsEmailNotBetween(String value1, String value2) {
            addCriterion("IS_EMAIL not between", value1, value2, "isEmail");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeIsNull() {
            addCriterion("SECOND_R_NOTICE is null");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeIsNotNull() {
            addCriterion("SECOND_R_NOTICE is not null");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeEqualTo(String value) {
            addCriterion("SECOND_R_NOTICE =", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeNotEqualTo(String value) {
            addCriterion("SECOND_R_NOTICE <>", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeGreaterThan(String value) {
            addCriterion("SECOND_R_NOTICE >", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("SECOND_R_NOTICE >=", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeLessThan(String value) {
            addCriterion("SECOND_R_NOTICE <", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeLessThanOrEqualTo(String value) {
            addCriterion("SECOND_R_NOTICE <=", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeLike(String value) {
            addCriterion("SECOND_R_NOTICE like", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeNotLike(String value) {
            addCriterion("SECOND_R_NOTICE not like", value, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeIn(List<String> values) {
            addCriterion("SECOND_R_NOTICE in", values, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeNotIn(List<String> values) {
            addCriterion("SECOND_R_NOTICE not in", values, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeBetween(String value1, String value2) {
            addCriterion("SECOND_R_NOTICE between", value1, value2, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeNotBetween(String value1, String value2) {
            addCriterion("SECOND_R_NOTICE not between", value1, value2, "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeIsNull() {
            addCriterion("SECOND_R_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeIsNotNull() {
            addCriterion("SECOND_R_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeEqualTo(Date value) {
            addCriterion("SECOND_R_TIME =", value, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeNotEqualTo(Date value) {
            addCriterion("SECOND_R_TIME <>", value, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeGreaterThan(Date value) {
            addCriterion("SECOND_R_TIME >", value, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SECOND_R_TIME >=", value, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeLessThan(Date value) {
            addCriterion("SECOND_R_TIME <", value, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeLessThanOrEqualTo(Date value) {
            addCriterion("SECOND_R_TIME <=", value, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeIn(List<Date> values) {
            addCriterion("SECOND_R_TIME in", values, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeNotIn(List<Date> values) {
            addCriterion("SECOND_R_TIME not in", values, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeBetween(Date value1, Date value2) {
            addCriterion("SECOND_R_TIME between", value1, value2, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondRTimeNotBetween(Date value1, Date value2) {
            addCriterion("SECOND_R_TIME not between", value1, value2, "secondRTime");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeIsNull() {
            addCriterion("SECOND_E_NOTICE is null");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeIsNotNull() {
            addCriterion("SECOND_E_NOTICE is not null");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeEqualTo(String value) {
            addCriterion("SECOND_E_NOTICE =", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeNotEqualTo(String value) {
            addCriterion("SECOND_E_NOTICE <>", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeGreaterThan(String value) {
            addCriterion("SECOND_E_NOTICE >", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeGreaterThanOrEqualTo(String value) {
            addCriterion("SECOND_E_NOTICE >=", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeLessThan(String value) {
            addCriterion("SECOND_E_NOTICE <", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeLessThanOrEqualTo(String value) {
            addCriterion("SECOND_E_NOTICE <=", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeLike(String value) {
            addCriterion("SECOND_E_NOTICE like", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeNotLike(String value) {
            addCriterion("SECOND_E_NOTICE not like", value, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeIn(List<String> values) {
            addCriterion("SECOND_E_NOTICE in", values, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeNotIn(List<String> values) {
            addCriterion("SECOND_E_NOTICE not in", values, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeBetween(String value1, String value2) {
            addCriterion("SECOND_E_NOTICE between", value1, value2, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeNotBetween(String value1, String value2) {
            addCriterion("SECOND_E_NOTICE not between", value1, value2, "secondENotice");
            return (Criteria) this;
        }

        public Criteria andSecondETimeIsNull() {
            addCriterion("SECOND_E_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSecondETimeIsNotNull() {
            addCriterion("SECOND_E_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSecondETimeEqualTo(Date value) {
            addCriterion("SECOND_E_TIME =", value, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeNotEqualTo(Date value) {
            addCriterion("SECOND_E_TIME <>", value, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeGreaterThan(Date value) {
            addCriterion("SECOND_E_TIME >", value, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SECOND_E_TIME >=", value, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeLessThan(Date value) {
            addCriterion("SECOND_E_TIME <", value, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeLessThanOrEqualTo(Date value) {
            addCriterion("SECOND_E_TIME <=", value, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeIn(List<Date> values) {
            addCriterion("SECOND_E_TIME in", values, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeNotIn(List<Date> values) {
            addCriterion("SECOND_E_TIME not in", values, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeBetween(Date value1, Date value2) {
            addCriterion("SECOND_E_TIME between", value1, value2, "secondETime");
            return (Criteria) this;
        }

        public Criteria andSecondETimeNotBetween(Date value1, Date value2) {
            addCriterion("SECOND_E_TIME not between", value1, value2, "secondETime");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusIsNull() {
            addCriterion("INTERVIEW_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusIsNotNull() {
            addCriterion("INTERVIEW_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS =", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS <>", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusGreaterThan(String value) {
            addCriterion("INTERVIEW_STATUS >", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS >=", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLessThan(String value) {
            addCriterion("INTERVIEW_STATUS <", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_STATUS <=", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLike(String value) {
            addCriterion("INTERVIEW_STATUS like", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotLike(String value) {
            addCriterion("INTERVIEW_STATUS not like", value, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusIn(List<String> values) {
            addCriterion("INTERVIEW_STATUS in", values, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotIn(List<String> values) {
            addCriterion("INTERVIEW_STATUS not in", values, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusBetween(String value1, String value2) {
            addCriterion("INTERVIEW_STATUS between", value1, value2, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_STATUS not between", value1, value2, "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("POSITION_ID is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("POSITION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("POSITION_ID =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("POSITION_ID <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("POSITION_ID >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION_ID >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("POSITION_ID <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("POSITION_ID <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("POSITION_ID like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("POSITION_ID not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("POSITION_ID in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("POSITION_ID not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("POSITION_ID between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("POSITION_ID not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("MODEL_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("MODEL_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("MODEL_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("MODEL_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("MODEL_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("MODEL_ID like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("MODEL_ID not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("MODEL_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("MODEL_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("MODEL_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("MODEL_ID not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andEmailContentIsNull() {
            addCriterion("EMAIL_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andEmailContentIsNotNull() {
            addCriterion("EMAIL_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andEmailContentEqualTo(String value) {
            addCriterion("EMAIL_CONTENT =", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotEqualTo(String value) {
            addCriterion("EMAIL_CONTENT <>", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentGreaterThan(String value) {
            addCriterion("EMAIL_CONTENT >", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_CONTENT >=", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLessThan(String value) {
            addCriterion("EMAIL_CONTENT <", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_CONTENT <=", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLike(String value) {
            addCriterion("EMAIL_CONTENT like", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotLike(String value) {
            addCriterion("EMAIL_CONTENT not like", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentIn(List<String> values) {
            addCriterion("EMAIL_CONTENT in", values, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotIn(List<String> values) {
            addCriterion("EMAIL_CONTENT not in", values, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentBetween(String value1, String value2) {
            addCriterion("EMAIL_CONTENT between", value1, value2, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotBetween(String value1, String value2) {
            addCriterion("EMAIL_CONTENT not between", value1, value2, "emailContent");
            return (Criteria) this;
        }

        public Criteria andIsLinkIsNull() {
            addCriterion("IS_LINK is null");
            return (Criteria) this;
        }

        public Criteria andIsLinkIsNotNull() {
            addCriterion("IS_LINK is not null");
            return (Criteria) this;
        }

        public Criteria andIsLinkEqualTo(String value) {
            addCriterion("IS_LINK =", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkNotEqualTo(String value) {
            addCriterion("IS_LINK <>", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkGreaterThan(String value) {
            addCriterion("IS_LINK >", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkGreaterThanOrEqualTo(String value) {
            addCriterion("IS_LINK >=", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkLessThan(String value) {
            addCriterion("IS_LINK <", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkLessThanOrEqualTo(String value) {
            addCriterion("IS_LINK <=", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkLike(String value) {
            addCriterion("IS_LINK like", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkNotLike(String value) {
            addCriterion("IS_LINK not like", value, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkIn(List<String> values) {
            addCriterion("IS_LINK in", values, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkNotIn(List<String> values) {
            addCriterion("IS_LINK not in", values, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkBetween(String value1, String value2) {
            addCriterion("IS_LINK between", value1, value2, "isLink");
            return (Criteria) this;
        }

        public Criteria andIsLinkNotBetween(String value1, String value2) {
            addCriterion("IS_LINK not between", value1, value2, "isLink");
            return (Criteria) this;
        }

        public Criteria andInterviewDateIsNull() {
            addCriterion("INTERVIEW_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInterviewDateIsNotNull() {
            addCriterion("INTERVIEW_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewDateEqualTo(Date value) {
            addCriterionForJDBCDate("INTERVIEW_DATE =", value, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("INTERVIEW_DATE <>", value, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateGreaterThan(Date value) {
            addCriterionForJDBCDate("INTERVIEW_DATE >", value, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INTERVIEW_DATE >=", value, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateLessThan(Date value) {
            addCriterionForJDBCDate("INTERVIEW_DATE <", value, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INTERVIEW_DATE <=", value, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateIn(List<Date> values) {
            addCriterionForJDBCDate("INTERVIEW_DATE in", values, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("INTERVIEW_DATE not in", values, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INTERVIEW_DATE between", value1, value2, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INTERVIEW_DATE not between", value1, value2, "interviewDate");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeIsNull() {
            addCriterion("INTERVIEW_B_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeIsNotNull() {
            addCriterion("INTERVIEW_B_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeEqualTo(String value) {
            addCriterion("INTERVIEW_B_TIME =", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeNotEqualTo(String value) {
            addCriterion("INTERVIEW_B_TIME <>", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeGreaterThan(String value) {
            addCriterion("INTERVIEW_B_TIME >", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_B_TIME >=", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeLessThan(String value) {
            addCriterion("INTERVIEW_B_TIME <", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_B_TIME <=", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeLike(String value) {
            addCriterion("INTERVIEW_B_TIME like", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeNotLike(String value) {
            addCriterion("INTERVIEW_B_TIME not like", value, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeIn(List<String> values) {
            addCriterion("INTERVIEW_B_TIME in", values, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeNotIn(List<String> values) {
            addCriterion("INTERVIEW_B_TIME not in", values, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeBetween(String value1, String value2) {
            addCriterion("INTERVIEW_B_TIME between", value1, value2, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_B_TIME not between", value1, value2, "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeIsNull() {
            addCriterion("INTERVIEW_E_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeIsNotNull() {
            addCriterion("INTERVIEW_E_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeEqualTo(String value) {
            addCriterion("INTERVIEW_E_TIME =", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeNotEqualTo(String value) {
            addCriterion("INTERVIEW_E_TIME <>", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeGreaterThan(String value) {
            addCriterion("INTERVIEW_E_TIME >", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_E_TIME >=", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeLessThan(String value) {
            addCriterion("INTERVIEW_E_TIME <", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEW_E_TIME <=", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeLike(String value) {
            addCriterion("INTERVIEW_E_TIME like", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeNotLike(String value) {
            addCriterion("INTERVIEW_E_TIME not like", value, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeIn(List<String> values) {
            addCriterion("INTERVIEW_E_TIME in", values, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeNotIn(List<String> values) {
            addCriterion("INTERVIEW_E_TIME not in", values, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeBetween(String value1, String value2) {
            addCriterion("INTERVIEW_E_TIME between", value1, value2, "interviewETime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeNotBetween(String value1, String value2) {
            addCriterion("INTERVIEW_E_TIME not between", value1, value2, "interviewETime");
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

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andRoundsIsNull() {
            addCriterion("ROUNDS is null");
            return (Criteria) this;
        }

        public Criteria andRoundsIsNotNull() {
            addCriterion("ROUNDS is not null");
            return (Criteria) this;
        }

        public Criteria andRoundsEqualTo(String value) {
            addCriterion("ROUNDS =", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsNotEqualTo(String value) {
            addCriterion("ROUNDS <>", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsGreaterThan(String value) {
            addCriterion("ROUNDS >", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsGreaterThanOrEqualTo(String value) {
            addCriterion("ROUNDS >=", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsLessThan(String value) {
            addCriterion("ROUNDS <", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsLessThanOrEqualTo(String value) {
            addCriterion("ROUNDS <=", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsLike(String value) {
            addCriterion("ROUNDS like", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsNotLike(String value) {
            addCriterion("ROUNDS not like", value, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsIn(List<String> values) {
            addCriterion("ROUNDS in", values, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsNotIn(List<String> values) {
            addCriterion("ROUNDS not in", values, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsBetween(String value1, String value2) {
            addCriterion("ROUNDS between", value1, value2, "rounds");
            return (Criteria) this;
        }

        public Criteria andRoundsNotBetween(String value1, String value2) {
            addCriterion("ROUNDS not between", value1, value2, "rounds");
            return (Criteria) this;
        }

        public Criteria andWorkCodeIsNull() {
            addCriterion("WORK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWorkCodeIsNotNull() {
            addCriterion("WORK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCodeEqualTo(String value) {
            addCriterion("WORK_CODE =", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeNotEqualTo(String value) {
            addCriterion("WORK_CODE <>", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeGreaterThan(String value) {
            addCriterion("WORK_CODE >", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_CODE >=", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeLessThan(String value) {
            addCriterion("WORK_CODE <", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeLessThanOrEqualTo(String value) {
            addCriterion("WORK_CODE <=", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeLike(String value) {
            addCriterion("WORK_CODE like", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeNotLike(String value) {
            addCriterion("WORK_CODE not like", value, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeIn(List<String> values) {
            addCriterion("WORK_CODE in", values, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeNotIn(List<String> values) {
            addCriterion("WORK_CODE not in", values, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeBetween(String value1, String value2) {
            addCriterion("WORK_CODE between", value1, value2, "workCode");
            return (Criteria) this;
        }

        public Criteria andWorkCodeNotBetween(String value1, String value2) {
            addCriterion("WORK_CODE not between", value1, value2, "workCode");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andIntervieweeLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEWEE) like", value.toUpperCase(), "interviewee");
            return (Criteria) this;
        }

        public Criteria andInterviewersLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEWERS) like", value.toUpperCase(), "interviewers");
            return (Criteria) this;
        }

        public Criteria andLinkmanLikeInsensitive(String value) {
            addCriterion("upper(LINKMAN) like", value.toUpperCase(), "linkman");
            return (Criteria) this;
        }

        public Criteria andInterviewTypeLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_TYPE) like", value.toUpperCase(), "interviewType");
            return (Criteria) this;
        }

        public Criteria andTelLikeInsensitive(String value) {
            addCriterion("upper(TEL) like", value.toUpperCase(), "tel");
            return (Criteria) this;
        }

        public Criteria andWaitAddressLikeInsensitive(String value) {
            addCriterion("upper(WAIT_ADDRESS) like", value.toUpperCase(), "waitAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_ADDRESS) like", value.toUpperCase(), "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andIsMessageLikeInsensitive(String value) {
            addCriterion("upper(IS_MESSAGE) like", value.toUpperCase(), "isMessage");
            return (Criteria) this;
        }

        public Criteria andIsEmailLikeInsensitive(String value) {
            addCriterion("upper(IS_EMAIL) like", value.toUpperCase(), "isEmail");
            return (Criteria) this;
        }

        public Criteria andSecondRNoticeLikeInsensitive(String value) {
            addCriterion("upper(SECOND_R_NOTICE) like", value.toUpperCase(), "secondRNotice");
            return (Criteria) this;
        }

        public Criteria andSecondENoticeLikeInsensitive(String value) {
            addCriterion("upper(SECOND_E_NOTICE) like", value.toUpperCase(), "secondENotice");
            return (Criteria) this;
        }

        public Criteria andInterviewStatusLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_STATUS) like", value.toUpperCase(), "interviewStatus");
            return (Criteria) this;
        }

        public Criteria andPositionIdLikeInsensitive(String value) {
            addCriterion("upper(POSITION_ID) like", value.toUpperCase(), "positionId");
            return (Criteria) this;
        }

        public Criteria andModelIdLikeInsensitive(String value) {
            addCriterion("upper(MODEL_ID) like", value.toUpperCase(), "modelId");
            return (Criteria) this;
        }

        public Criteria andEmailContentLikeInsensitive(String value) {
            addCriterion("upper(EMAIL_CONTENT) like", value.toUpperCase(), "emailContent");
            return (Criteria) this;
        }

        public Criteria andIsLinkLikeInsensitive(String value) {
            addCriterion("upper(IS_LINK) like", value.toUpperCase(), "isLink");
            return (Criteria) this;
        }

        public Criteria andInterviewBTimeLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_B_TIME) like", value.toUpperCase(), "interviewBTime");
            return (Criteria) this;
        }

        public Criteria andInterviewETimeLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEW_E_TIME) like", value.toUpperCase(), "interviewETime");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_NAME) like", value.toUpperCase(), "candidateName");
            return (Criteria) this;
        }

        public Criteria andReasonLikeInsensitive(String value) {
            addCriterion("upper(REASON) like", value.toUpperCase(), "reason");
            return (Criteria) this;
        }

        public Criteria andRoundsLikeInsensitive(String value) {
            addCriterion("upper(ROUNDS) like", value.toUpperCase(), "rounds");
            return (Criteria) this;
        }

        public Criteria andWorkCodeLikeInsensitive(String value) {
            addCriterion("upper(WORK_CODE) like", value.toUpperCase(), "workCode");
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