package com.csot.recruit.model.extension.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RewardExtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RewardExtCriteria() {
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

        public Criteria andRewardName1IsNull() {
            addCriterion("REWARD_NAME_1 is null");
            return (Criteria) this;
        }

        public Criteria andRewardName1IsNotNull() {
            addCriterion("REWARD_NAME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andRewardName1EqualTo(String value) {
            addCriterion("REWARD_NAME_1 =", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1NotEqualTo(String value) {
            addCriterion("REWARD_NAME_1 <>", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1GreaterThan(String value) {
            addCriterion("REWARD_NAME_1 >", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1GreaterThanOrEqualTo(String value) {
            addCriterion("REWARD_NAME_1 >=", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1LessThan(String value) {
            addCriterion("REWARD_NAME_1 <", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1LessThanOrEqualTo(String value) {
            addCriterion("REWARD_NAME_1 <=", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1Like(String value) {
            addCriterion("REWARD_NAME_1 like", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1NotLike(String value) {
            addCriterion("REWARD_NAME_1 not like", value, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1In(List<String> values) {
            addCriterion("REWARD_NAME_1 in", values, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1NotIn(List<String> values) {
            addCriterion("REWARD_NAME_1 not in", values, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1Between(String value1, String value2) {
            addCriterion("REWARD_NAME_1 between", value1, value2, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardName1NotBetween(String value1, String value2) {
            addCriterion("REWARD_NAME_1 not between", value1, value2, "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1IsNull() {
            addCriterion("REWARD_DATE_1 is null");
            return (Criteria) this;
        }

        public Criteria andRewardDate1IsNotNull() {
            addCriterion("REWARD_DATE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andRewardDate1EqualTo(String value) {
            addCriterion("REWARD_DATE_1 =", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1NotEqualTo(String value) {
            addCriterion("REWARD_DATE_1 <>", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1GreaterThan(String value) {
            addCriterion("REWARD_DATE_1 >", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1GreaterThanOrEqualTo(String value) {
            addCriterion("REWARD_DATE_1 >=", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1LessThan(String value) {
            addCriterion("REWARD_DATE_1 <", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1LessThanOrEqualTo(String value) {
            addCriterion("REWARD_DATE_1 <=", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1Like(String value) {
            addCriterion("REWARD_DATE_1 like", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1NotLike(String value) {
            addCriterion("REWARD_DATE_1 not like", value, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1In(List<String> values) {
            addCriterion("REWARD_DATE_1 in", values, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1NotIn(List<String> values) {
            addCriterion("REWARD_DATE_1 not in", values, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1Between(String value1, String value2) {
            addCriterion("REWARD_DATE_1 between", value1, value2, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1NotBetween(String value1, String value2) {
            addCriterion("REWARD_DATE_1 not between", value1, value2, "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1IsNull() {
            addCriterion("AUTHORITIES_1 is null");
            return (Criteria) this;
        }

        public Criteria andAuthorities1IsNotNull() {
            addCriterion("AUTHORITIES_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorities1EqualTo(String value) {
            addCriterion("AUTHORITIES_1 =", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1NotEqualTo(String value) {
            addCriterion("AUTHORITIES_1 <>", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1GreaterThan(String value) {
            addCriterion("AUTHORITIES_1 >", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1GreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORITIES_1 >=", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1LessThan(String value) {
            addCriterion("AUTHORITIES_1 <", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1LessThanOrEqualTo(String value) {
            addCriterion("AUTHORITIES_1 <=", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1Like(String value) {
            addCriterion("AUTHORITIES_1 like", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1NotLike(String value) {
            addCriterion("AUTHORITIES_1 not like", value, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1In(List<String> values) {
            addCriterion("AUTHORITIES_1 in", values, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1NotIn(List<String> values) {
            addCriterion("AUTHORITIES_1 not in", values, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1Between(String value1, String value2) {
            addCriterion("AUTHORITIES_1 between", value1, value2, "authorities1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1NotBetween(String value1, String value2) {
            addCriterion("AUTHORITIES_1 not between", value1, value2, "authorities1");
            return (Criteria) this;
        }

        public Criteria andRewardName2IsNull() {
            addCriterion("REWARD_NAME_2 is null");
            return (Criteria) this;
        }

        public Criteria andRewardName2IsNotNull() {
            addCriterion("REWARD_NAME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andRewardName2EqualTo(String value) {
            addCriterion("REWARD_NAME_2 =", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2NotEqualTo(String value) {
            addCriterion("REWARD_NAME_2 <>", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2GreaterThan(String value) {
            addCriterion("REWARD_NAME_2 >", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2GreaterThanOrEqualTo(String value) {
            addCriterion("REWARD_NAME_2 >=", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2LessThan(String value) {
            addCriterion("REWARD_NAME_2 <", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2LessThanOrEqualTo(String value) {
            addCriterion("REWARD_NAME_2 <=", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2Like(String value) {
            addCriterion("REWARD_NAME_2 like", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2NotLike(String value) {
            addCriterion("REWARD_NAME_2 not like", value, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2In(List<String> values) {
            addCriterion("REWARD_NAME_2 in", values, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2NotIn(List<String> values) {
            addCriterion("REWARD_NAME_2 not in", values, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2Between(String value1, String value2) {
            addCriterion("REWARD_NAME_2 between", value1, value2, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardName2NotBetween(String value1, String value2) {
            addCriterion("REWARD_NAME_2 not between", value1, value2, "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2IsNull() {
            addCriterion("REWARD_DATE_2 is null");
            return (Criteria) this;
        }

        public Criteria andRewardDate2IsNotNull() {
            addCriterion("REWARD_DATE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andRewardDate2EqualTo(String value) {
            addCriterion("REWARD_DATE_2 =", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2NotEqualTo(String value) {
            addCriterion("REWARD_DATE_2 <>", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2GreaterThan(String value) {
            addCriterion("REWARD_DATE_2 >", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2GreaterThanOrEqualTo(String value) {
            addCriterion("REWARD_DATE_2 >=", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2LessThan(String value) {
            addCriterion("REWARD_DATE_2 <", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2LessThanOrEqualTo(String value) {
            addCriterion("REWARD_DATE_2 <=", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2Like(String value) {
            addCriterion("REWARD_DATE_2 like", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2NotLike(String value) {
            addCriterion("REWARD_DATE_2 not like", value, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2In(List<String> values) {
            addCriterion("REWARD_DATE_2 in", values, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2NotIn(List<String> values) {
            addCriterion("REWARD_DATE_2 not in", values, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2Between(String value1, String value2) {
            addCriterion("REWARD_DATE_2 between", value1, value2, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2NotBetween(String value1, String value2) {
            addCriterion("REWARD_DATE_2 not between", value1, value2, "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2IsNull() {
            addCriterion("AUTHORITIES_2 is null");
            return (Criteria) this;
        }

        public Criteria andAuthorities2IsNotNull() {
            addCriterion("AUTHORITIES_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorities2EqualTo(String value) {
            addCriterion("AUTHORITIES_2 =", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2NotEqualTo(String value) {
            addCriterion("AUTHORITIES_2 <>", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2GreaterThan(String value) {
            addCriterion("AUTHORITIES_2 >", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2GreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORITIES_2 >=", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2LessThan(String value) {
            addCriterion("AUTHORITIES_2 <", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2LessThanOrEqualTo(String value) {
            addCriterion("AUTHORITIES_2 <=", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2Like(String value) {
            addCriterion("AUTHORITIES_2 like", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2NotLike(String value) {
            addCriterion("AUTHORITIES_2 not like", value, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2In(List<String> values) {
            addCriterion("AUTHORITIES_2 in", values, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2NotIn(List<String> values) {
            addCriterion("AUTHORITIES_2 not in", values, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2Between(String value1, String value2) {
            addCriterion("AUTHORITIES_2 between", value1, value2, "authorities2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2NotBetween(String value1, String value2) {
            addCriterion("AUTHORITIES_2 not between", value1, value2, "authorities2");
            return (Criteria) this;
        }

        public Criteria andRewardName3IsNull() {
            addCriterion("REWARD_NAME_3 is null");
            return (Criteria) this;
        }

        public Criteria andRewardName3IsNotNull() {
            addCriterion("REWARD_NAME_3 is not null");
            return (Criteria) this;
        }

        public Criteria andRewardName3EqualTo(String value) {
            addCriterion("REWARD_NAME_3 =", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3NotEqualTo(String value) {
            addCriterion("REWARD_NAME_3 <>", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3GreaterThan(String value) {
            addCriterion("REWARD_NAME_3 >", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3GreaterThanOrEqualTo(String value) {
            addCriterion("REWARD_NAME_3 >=", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3LessThan(String value) {
            addCriterion("REWARD_NAME_3 <", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3LessThanOrEqualTo(String value) {
            addCriterion("REWARD_NAME_3 <=", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3Like(String value) {
            addCriterion("REWARD_NAME_3 like", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3NotLike(String value) {
            addCriterion("REWARD_NAME_3 not like", value, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3In(List<String> values) {
            addCriterion("REWARD_NAME_3 in", values, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3NotIn(List<String> values) {
            addCriterion("REWARD_NAME_3 not in", values, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3Between(String value1, String value2) {
            addCriterion("REWARD_NAME_3 between", value1, value2, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardName3NotBetween(String value1, String value2) {
            addCriterion("REWARD_NAME_3 not between", value1, value2, "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3IsNull() {
            addCriterion("REWARD_DATE_3 is null");
            return (Criteria) this;
        }

        public Criteria andRewardDate3IsNotNull() {
            addCriterion("REWARD_DATE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andRewardDate3EqualTo(String value) {
            addCriterion("REWARD_DATE_3 =", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3NotEqualTo(String value) {
            addCriterion("REWARD_DATE_3 <>", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3GreaterThan(String value) {
            addCriterion("REWARD_DATE_3 >", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3GreaterThanOrEqualTo(String value) {
            addCriterion("REWARD_DATE_3 >=", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3LessThan(String value) {
            addCriterion("REWARD_DATE_3 <", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3LessThanOrEqualTo(String value) {
            addCriterion("REWARD_DATE_3 <=", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3Like(String value) {
            addCriterion("REWARD_DATE_3 like", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3NotLike(String value) {
            addCriterion("REWARD_DATE_3 not like", value, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3In(List<String> values) {
            addCriterion("REWARD_DATE_3 in", values, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3NotIn(List<String> values) {
            addCriterion("REWARD_DATE_3 not in", values, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3Between(String value1, String value2) {
            addCriterion("REWARD_DATE_3 between", value1, value2, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3NotBetween(String value1, String value2) {
            addCriterion("REWARD_DATE_3 not between", value1, value2, "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3IsNull() {
            addCriterion("AUTHORITIES_3 is null");
            return (Criteria) this;
        }

        public Criteria andAuthorities3IsNotNull() {
            addCriterion("AUTHORITIES_3 is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorities3EqualTo(String value) {
            addCriterion("AUTHORITIES_3 =", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3NotEqualTo(String value) {
            addCriterion("AUTHORITIES_3 <>", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3GreaterThan(String value) {
            addCriterion("AUTHORITIES_3 >", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3GreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORITIES_3 >=", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3LessThan(String value) {
            addCriterion("AUTHORITIES_3 <", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3LessThanOrEqualTo(String value) {
            addCriterion("AUTHORITIES_3 <=", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3Like(String value) {
            addCriterion("AUTHORITIES_3 like", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3NotLike(String value) {
            addCriterion("AUTHORITIES_3 not like", value, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3In(List<String> values) {
            addCriterion("AUTHORITIES_3 in", values, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3NotIn(List<String> values) {
            addCriterion("AUTHORITIES_3 not in", values, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3Between(String value1, String value2) {
            addCriterion("AUTHORITIES_3 between", value1, value2, "authorities3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3NotBetween(String value1, String value2) {
            addCriterion("AUTHORITIES_3 not between", value1, value2, "authorities3");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNull() {
            addCriterion("HOBBY is null");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNotNull() {
            addCriterion("HOBBY is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyEqualTo(String value) {
            addCriterion("HOBBY =", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotEqualTo(String value) {
            addCriterion("HOBBY <>", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThan(String value) {
            addCriterion("HOBBY >", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("HOBBY >=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThan(String value) {
            addCriterion("HOBBY <", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThanOrEqualTo(String value) {
            addCriterion("HOBBY <=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLike(String value) {
            addCriterion("HOBBY like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotLike(String value) {
            addCriterion("HOBBY not like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyIn(List<String> values) {
            addCriterion("HOBBY in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotIn(List<String> values) {
            addCriterion("HOBBY not in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyBetween(String value1, String value2) {
            addCriterion("HOBBY between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotBetween(String value1, String value2) {
            addCriterion("HOBBY not between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNull() {
            addCriterion("SPECIALITY is null");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNotNull() {
            addCriterion("SPECIALITY is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialityEqualTo(String value) {
            addCriterion("SPECIALITY =", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotEqualTo(String value) {
            addCriterion("SPECIALITY <>", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThan(String value) {
            addCriterion("SPECIALITY >", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIALITY >=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThan(String value) {
            addCriterion("SPECIALITY <", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThanOrEqualTo(String value) {
            addCriterion("SPECIALITY <=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLike(String value) {
            addCriterion("SPECIALITY like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotLike(String value) {
            addCriterion("SPECIALITY not like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityIn(List<String> values) {
            addCriterion("SPECIALITY in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotIn(List<String> values) {
            addCriterion("SPECIALITY not in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityBetween(String value1, String value2) {
            addCriterion("SPECIALITY between", value1, value2, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotBetween(String value1, String value2) {
            addCriterion("SPECIALITY not between", value1, value2, "speciality");
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

        public Criteria andRewardName1LikeInsensitive(String value) {
            addCriterion("upper(REWARD_NAME_1) like", value.toUpperCase(), "rewardName1");
            return (Criteria) this;
        }

        public Criteria andRewardDate1LikeInsensitive(String value) {
            addCriterion("upper(REWARD_DATE_1) like", value.toUpperCase(), "rewardDate1");
            return (Criteria) this;
        }

        public Criteria andAuthorities1LikeInsensitive(String value) {
            addCriterion("upper(AUTHORITIES_1) like", value.toUpperCase(), "authorities1");
            return (Criteria) this;
        }

        public Criteria andRewardName2LikeInsensitive(String value) {
            addCriterion("upper(REWARD_NAME_2) like", value.toUpperCase(), "rewardName2");
            return (Criteria) this;
        }

        public Criteria andRewardDate2LikeInsensitive(String value) {
            addCriterion("upper(REWARD_DATE_2) like", value.toUpperCase(), "rewardDate2");
            return (Criteria) this;
        }

        public Criteria andAuthorities2LikeInsensitive(String value) {
            addCriterion("upper(AUTHORITIES_2) like", value.toUpperCase(), "authorities2");
            return (Criteria) this;
        }

        public Criteria andRewardName3LikeInsensitive(String value) {
            addCriterion("upper(REWARD_NAME_3) like", value.toUpperCase(), "rewardName3");
            return (Criteria) this;
        }

        public Criteria andRewardDate3LikeInsensitive(String value) {
            addCriterion("upper(REWARD_DATE_3) like", value.toUpperCase(), "rewardDate3");
            return (Criteria) this;
        }

        public Criteria andAuthorities3LikeInsensitive(String value) {
            addCriterion("upper(AUTHORITIES_3) like", value.toUpperCase(), "authorities3");
            return (Criteria) this;
        }

        public Criteria andHobbyLikeInsensitive(String value) {
            addCriterion("upper(HOBBY) like", value.toUpperCase(), "hobby");
            return (Criteria) this;
        }

        public Criteria andSpecialityLikeInsensitive(String value) {
            addCriterion("upper(SPECIALITY) like", value.toUpperCase(), "speciality");
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