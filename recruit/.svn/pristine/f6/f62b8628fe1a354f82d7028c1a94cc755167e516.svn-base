package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class EmployCandidateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EmployCandidateCriteria() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNull() {
            addCriterion("PINYIN is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("PINYIN is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("PINYIN =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("PINYIN <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("PINYIN >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("PINYIN >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("PINYIN <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("PINYIN <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("PINYIN like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("PINYIN not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("PINYIN in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("PINYIN not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("PINYIN between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("PINYIN not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("ENGLISH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("ENGLISH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("ENGLISH_NAME =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("ENGLISH_NAME <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("ENGLISH_NAME >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("ENGLISH_NAME <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("ENGLISH_NAME like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("ENGLISH_NAME not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("ENGLISH_NAME in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("ENGLISH_NAME not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEmailNameIsNull() {
            addCriterion("EMAIL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEmailNameIsNotNull() {
            addCriterion("EMAIL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEmailNameEqualTo(String value) {
            addCriterion("EMAIL_NAME =", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameNotEqualTo(String value) {
            addCriterion("EMAIL_NAME <>", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameGreaterThan(String value) {
            addCriterion("EMAIL_NAME >", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_NAME >=", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameLessThan(String value) {
            addCriterion("EMAIL_NAME <", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_NAME <=", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameLike(String value) {
            addCriterion("EMAIL_NAME like", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameNotLike(String value) {
            addCriterion("EMAIL_NAME not like", value, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameIn(List<String> values) {
            addCriterion("EMAIL_NAME in", values, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameNotIn(List<String> values) {
            addCriterion("EMAIL_NAME not in", values, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameBetween(String value1, String value2) {
            addCriterion("EMAIL_NAME between", value1, value2, "emailName");
            return (Criteria) this;
        }

        public Criteria andEmailNameNotBetween(String value1, String value2) {
            addCriterion("EMAIL_NAME not between", value1, value2, "emailName");
            return (Criteria) this;
        }

        public Criteria andIsDevoteIsNull() {
            addCriterion("IS_DEVOTE is null");
            return (Criteria) this;
        }

        public Criteria andIsDevoteIsNotNull() {
            addCriterion("IS_DEVOTE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDevoteEqualTo(String value) {
            addCriterion("IS_DEVOTE =", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteNotEqualTo(String value) {
            addCriterion("IS_DEVOTE <>", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteGreaterThan(String value) {
            addCriterion("IS_DEVOTE >", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEVOTE >=", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteLessThan(String value) {
            addCriterion("IS_DEVOTE <", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteLessThanOrEqualTo(String value) {
            addCriterion("IS_DEVOTE <=", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteLike(String value) {
            addCriterion("IS_DEVOTE like", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteNotLike(String value) {
            addCriterion("IS_DEVOTE not like", value, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteIn(List<String> values) {
            addCriterion("IS_DEVOTE in", values, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteNotIn(List<String> values) {
            addCriterion("IS_DEVOTE not in", values, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteBetween(String value1, String value2) {
            addCriterion("IS_DEVOTE between", value1, value2, "isDevote");
            return (Criteria) this;
        }

        public Criteria andIsDevoteNotBetween(String value1, String value2) {
            addCriterion("IS_DEVOTE not between", value1, value2, "isDevote");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("GENDER is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("GENDER =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("GENDER <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("GENDER >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("GENDER <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("GENDER <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("GENDER like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("GENDER not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("GENDER in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("GENDER not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("GENDER between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("GENDER not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("BIRTHDAY =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("BIRTHDAY <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("BIRTHDAY >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("BIRTHDAY <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("BIRTHDAY like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("BIRTHDAY not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("BIRTHDAY in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("BIRTHDAY not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("BIRTHDAY between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("BIRTHDAY not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdIsNull() {
            addCriterion("CANDIDATE_POST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdIsNotNull() {
            addCriterion("CANDIDATE_POST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdEqualTo(String value) {
            addCriterion("CANDIDATE_POST_ID =", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdNotEqualTo(String value) {
            addCriterion("CANDIDATE_POST_ID <>", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdGreaterThan(String value) {
            addCriterion("CANDIDATE_POST_ID >", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_POST_ID >=", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdLessThan(String value) {
            addCriterion("CANDIDATE_POST_ID <", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_POST_ID <=", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdLike(String value) {
            addCriterion("CANDIDATE_POST_ID like", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdNotLike(String value) {
            addCriterion("CANDIDATE_POST_ID not like", value, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdIn(List<String> values) {
            addCriterion("CANDIDATE_POST_ID in", values, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdNotIn(List<String> values) {
            addCriterion("CANDIDATE_POST_ID not in", values, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdBetween(String value1, String value2) {
            addCriterion("CANDIDATE_POST_ID between", value1, value2, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_POST_ID not between", value1, value2, "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameIsNull() {
            addCriterion("CANDIDATE_POST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameIsNotNull() {
            addCriterion("CANDIDATE_POST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameEqualTo(String value) {
            addCriterion("CANDIDATE_POST_NAME =", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameNotEqualTo(String value) {
            addCriterion("CANDIDATE_POST_NAME <>", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameGreaterThan(String value) {
            addCriterion("CANDIDATE_POST_NAME >", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_POST_NAME >=", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameLessThan(String value) {
            addCriterion("CANDIDATE_POST_NAME <", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_POST_NAME <=", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameLike(String value) {
            addCriterion("CANDIDATE_POST_NAME like", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameNotLike(String value) {
            addCriterion("CANDIDATE_POST_NAME not like", value, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameIn(List<String> values) {
            addCriterion("CANDIDATE_POST_NAME in", values, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameNotIn(List<String> values) {
            addCriterion("CANDIDATE_POST_NAME not in", values, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameBetween(String value1, String value2) {
            addCriterion("CANDIDATE_POST_NAME between", value1, value2, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_POST_NAME not between", value1, value2, "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdIsNull() {
            addCriterion("CANDIDATE_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdIsNotNull() {
            addCriterion("CANDIDATE_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_ID =", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdNotEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_ID <>", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdGreaterThan(String value) {
            addCriterion("CANDIDATE_ORG_ID >", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_ID >=", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdLessThan(String value) {
            addCriterion("CANDIDATE_ORG_ID <", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_ID <=", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdLike(String value) {
            addCriterion("CANDIDATE_ORG_ID like", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdNotLike(String value) {
            addCriterion("CANDIDATE_ORG_ID not like", value, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdIn(List<String> values) {
            addCriterion("CANDIDATE_ORG_ID in", values, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdNotIn(List<String> values) {
            addCriterion("CANDIDATE_ORG_ID not in", values, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ORG_ID between", value1, value2, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ORG_ID not between", value1, value2, "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameIsNull() {
            addCriterion("CANDIDATE_ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameIsNotNull() {
            addCriterion("CANDIDATE_ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_NAME =", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameNotEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_NAME <>", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameGreaterThan(String value) {
            addCriterion("CANDIDATE_ORG_NAME >", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_NAME >=", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameLessThan(String value) {
            addCriterion("CANDIDATE_ORG_NAME <", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ORG_NAME <=", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameLike(String value) {
            addCriterion("CANDIDATE_ORG_NAME like", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameNotLike(String value) {
            addCriterion("CANDIDATE_ORG_NAME not like", value, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameIn(List<String> values) {
            addCriterion("CANDIDATE_ORG_NAME in", values, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameNotIn(List<String> values) {
            addCriterion("CANDIDATE_ORG_NAME not in", values, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ORG_NAME between", value1, value2, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ORG_NAME not between", value1, value2, "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceIsNull() {
            addCriterion("RECRUIT_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceIsNotNull() {
            addCriterion("RECRUIT_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceEqualTo(String value) {
            addCriterion("RECRUIT_SOURCE =", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceNotEqualTo(String value) {
            addCriterion("RECRUIT_SOURCE <>", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceGreaterThan(String value) {
            addCriterion("RECRUIT_SOURCE >", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceGreaterThanOrEqualTo(String value) {
            addCriterion("RECRUIT_SOURCE >=", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceLessThan(String value) {
            addCriterion("RECRUIT_SOURCE <", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceLessThanOrEqualTo(String value) {
            addCriterion("RECRUIT_SOURCE <=", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceLike(String value) {
            addCriterion("RECRUIT_SOURCE like", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceNotLike(String value) {
            addCriterion("RECRUIT_SOURCE not like", value, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceIn(List<String> values) {
            addCriterion("RECRUIT_SOURCE in", values, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceNotIn(List<String> values) {
            addCriterion("RECRUIT_SOURCE not in", values, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceBetween(String value1, String value2) {
            addCriterion("RECRUIT_SOURCE between", value1, value2, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceNotBetween(String value1, String value2) {
            addCriterion("RECRUIT_SOURCE not between", value1, value2, "recruitSource");
            return (Criteria) this;
        }

        public Criteria andReferrerIdIsNull() {
            addCriterion("REFERRER_ID is null");
            return (Criteria) this;
        }

        public Criteria andReferrerIdIsNotNull() {
            addCriterion("REFERRER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerIdEqualTo(String value) {
            addCriterion("REFERRER_ID =", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdNotEqualTo(String value) {
            addCriterion("REFERRER_ID <>", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdGreaterThan(String value) {
            addCriterion("REFERRER_ID >", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdGreaterThanOrEqualTo(String value) {
            addCriterion("REFERRER_ID >=", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdLessThan(String value) {
            addCriterion("REFERRER_ID <", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdLessThanOrEqualTo(String value) {
            addCriterion("REFERRER_ID <=", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdLike(String value) {
            addCriterion("REFERRER_ID like", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdNotLike(String value) {
            addCriterion("REFERRER_ID not like", value, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdIn(List<String> values) {
            addCriterion("REFERRER_ID in", values, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdNotIn(List<String> values) {
            addCriterion("REFERRER_ID not in", values, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdBetween(String value1, String value2) {
            addCriterion("REFERRER_ID between", value1, value2, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerIdNotBetween(String value1, String value2) {
            addCriterion("REFERRER_ID not between", value1, value2, "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIsNull() {
            addCriterion("REFERRER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIsNotNull() {
            addCriterion("REFERRER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerNameEqualTo(String value) {
            addCriterion("REFERRER_NAME =", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotEqualTo(String value) {
            addCriterion("REFERRER_NAME <>", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameGreaterThan(String value) {
            addCriterion("REFERRER_NAME >", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameGreaterThanOrEqualTo(String value) {
            addCriterion("REFERRER_NAME >=", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLessThan(String value) {
            addCriterion("REFERRER_NAME <", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLessThanOrEqualTo(String value) {
            addCriterion("REFERRER_NAME <=", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLike(String value) {
            addCriterion("REFERRER_NAME like", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotLike(String value) {
            addCriterion("REFERRER_NAME not like", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIn(List<String> values) {
            addCriterion("REFERRER_NAME in", values, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotIn(List<String> values) {
            addCriterion("REFERRER_NAME not in", values, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameBetween(String value1, String value2) {
            addCriterion("REFERRER_NAME between", value1, value2, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotBetween(String value1, String value2) {
            addCriterion("REFERRER_NAME not between", value1, value2, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdIsNull() {
            addCriterion("REFERRER_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdIsNotNull() {
            addCriterion("REFERRER_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdEqualTo(String value) {
            addCriterion("REFERRER_ORG_ID =", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdNotEqualTo(String value) {
            addCriterion("REFERRER_ORG_ID <>", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdGreaterThan(String value) {
            addCriterion("REFERRER_ORG_ID >", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("REFERRER_ORG_ID >=", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdLessThan(String value) {
            addCriterion("REFERRER_ORG_ID <", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdLessThanOrEqualTo(String value) {
            addCriterion("REFERRER_ORG_ID <=", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdLike(String value) {
            addCriterion("REFERRER_ORG_ID like", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdNotLike(String value) {
            addCriterion("REFERRER_ORG_ID not like", value, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdIn(List<String> values) {
            addCriterion("REFERRER_ORG_ID in", values, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdNotIn(List<String> values) {
            addCriterion("REFERRER_ORG_ID not in", values, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdBetween(String value1, String value2) {
            addCriterion("REFERRER_ORG_ID between", value1, value2, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdNotBetween(String value1, String value2) {
            addCriterion("REFERRER_ORG_ID not between", value1, value2, "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameIsNull() {
            addCriterion("REFERRER_ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameIsNotNull() {
            addCriterion("REFERRER_ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameEqualTo(String value) {
            addCriterion("REFERRER_ORG_NAME =", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameNotEqualTo(String value) {
            addCriterion("REFERRER_ORG_NAME <>", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameGreaterThan(String value) {
            addCriterion("REFERRER_ORG_NAME >", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("REFERRER_ORG_NAME >=", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameLessThan(String value) {
            addCriterion("REFERRER_ORG_NAME <", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameLessThanOrEqualTo(String value) {
            addCriterion("REFERRER_ORG_NAME <=", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameLike(String value) {
            addCriterion("REFERRER_ORG_NAME like", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameNotLike(String value) {
            addCriterion("REFERRER_ORG_NAME not like", value, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameIn(List<String> values) {
            addCriterion("REFERRER_ORG_NAME in", values, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameNotIn(List<String> values) {
            addCriterion("REFERRER_ORG_NAME not in", values, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameBetween(String value1, String value2) {
            addCriterion("REFERRER_ORG_NAME between", value1, value2, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameNotBetween(String value1, String value2) {
            addCriterion("REFERRER_ORG_NAME not between", value1, value2, "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeIsNull() {
            addCriterion("CANDIDATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeIsNotNull() {
            addCriterion("CANDIDATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeEqualTo(String value) {
            addCriterion("CANDIDATE_TYPE =", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeNotEqualTo(String value) {
            addCriterion("CANDIDATE_TYPE <>", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeGreaterThan(String value) {
            addCriterion("CANDIDATE_TYPE >", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_TYPE >=", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeLessThan(String value) {
            addCriterion("CANDIDATE_TYPE <", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_TYPE <=", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeLike(String value) {
            addCriterion("CANDIDATE_TYPE like", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeNotLike(String value) {
            addCriterion("CANDIDATE_TYPE not like", value, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeIn(List<String> values) {
            addCriterion("CANDIDATE_TYPE in", values, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeNotIn(List<String> values) {
            addCriterion("CANDIDATE_TYPE not in", values, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeBetween(String value1, String value2) {
            addCriterion("CANDIDATE_TYPE between", value1, value2, "candidateType");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_TYPE not between", value1, value2, "candidateType");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoIsNull() {
            addCriterion("IS_BEIDIAO is null");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoIsNotNull() {
            addCriterion("IS_BEIDIAO is not null");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoEqualTo(String value) {
            addCriterion("IS_BEIDIAO =", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoNotEqualTo(String value) {
            addCriterion("IS_BEIDIAO <>", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoGreaterThan(String value) {
            addCriterion("IS_BEIDIAO >", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BEIDIAO >=", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoLessThan(String value) {
            addCriterion("IS_BEIDIAO <", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoLessThanOrEqualTo(String value) {
            addCriterion("IS_BEIDIAO <=", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoLike(String value) {
            addCriterion("IS_BEIDIAO like", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoNotLike(String value) {
            addCriterion("IS_BEIDIAO not like", value, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoIn(List<String> values) {
            addCriterion("IS_BEIDIAO in", values, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoNotIn(List<String> values) {
            addCriterion("IS_BEIDIAO not in", values, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoBetween(String value1, String value2) {
            addCriterion("IS_BEIDIAO between", value1, value2, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoNotBetween(String value1, String value2) {
            addCriterion("IS_BEIDIAO not between", value1, value2, "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingIsNull() {
            addCriterion("IS_EVALUATING is null");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingIsNotNull() {
            addCriterion("IS_EVALUATING is not null");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingEqualTo(String value) {
            addCriterion("IS_EVALUATING =", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingNotEqualTo(String value) {
            addCriterion("IS_EVALUATING <>", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingGreaterThan(String value) {
            addCriterion("IS_EVALUATING >", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingGreaterThanOrEqualTo(String value) {
            addCriterion("IS_EVALUATING >=", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingLessThan(String value) {
            addCriterion("IS_EVALUATING <", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingLessThanOrEqualTo(String value) {
            addCriterion("IS_EVALUATING <=", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingLike(String value) {
            addCriterion("IS_EVALUATING like", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingNotLike(String value) {
            addCriterion("IS_EVALUATING not like", value, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingIn(List<String> values) {
            addCriterion("IS_EVALUATING in", values, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingNotIn(List<String> values) {
            addCriterion("IS_EVALUATING not in", values, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingBetween(String value1, String value2) {
            addCriterion("IS_EVALUATING between", value1, value2, "isEvaluating");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingNotBetween(String value1, String value2) {
            addCriterion("IS_EVALUATING not between", value1, value2, "isEvaluating");
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

        public Criteria andEmployIdIsNull() {
            addCriterion("EMPLOY_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmployIdIsNotNull() {
            addCriterion("EMPLOY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployIdEqualTo(String value) {
            addCriterion("EMPLOY_ID =", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotEqualTo(String value) {
            addCriterion("EMPLOY_ID <>", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThan(String value) {
            addCriterion("EMPLOY_ID >", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ID >=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThan(String value) {
            addCriterion("EMPLOY_ID <", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ID <=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLike(String value) {
            addCriterion("EMPLOY_ID like", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotLike(String value) {
            addCriterion("EMPLOY_ID not like", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdIn(List<String> values) {
            addCriterion("EMPLOY_ID in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotIn(List<String> values) {
            addCriterion("EMPLOY_ID not in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdBetween(String value1, String value2) {
            addCriterion("EMPLOY_ID between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_ID not between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(NAME) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andPinyinLikeInsensitive(String value) {
            addCriterion("upper(PINYIN) like", value.toUpperCase(), "pinyin");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLikeInsensitive(String value) {
            addCriterion("upper(ENGLISH_NAME) like", value.toUpperCase(), "englishName");
            return (Criteria) this;
        }

        public Criteria andEmailNameLikeInsensitive(String value) {
            addCriterion("upper(EMAIL_NAME) like", value.toUpperCase(), "emailName");
            return (Criteria) this;
        }

        public Criteria andIsDevoteLikeInsensitive(String value) {
            addCriterion("upper(IS_DEVOTE) like", value.toUpperCase(), "isDevote");
            return (Criteria) this;
        }

        public Criteria andGenderLikeInsensitive(String value) {
            addCriterion("upper(GENDER) like", value.toUpperCase(), "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayLikeInsensitive(String value) {
            addCriterion("upper(BIRTHDAY) like", value.toUpperCase(), "birthday");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(PHONE) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_POST_ID) like", value.toUpperCase(), "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andCandidatePostNameLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_POST_NAME) like", value.toUpperCase(), "candidatePostName");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgIdLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_ORG_ID) like", value.toUpperCase(), "candidateOrgId");
            return (Criteria) this;
        }

        public Criteria andCandidateOrgNameLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_ORG_NAME) like", value.toUpperCase(), "candidateOrgName");
            return (Criteria) this;
        }

        public Criteria andRecruitSourceLikeInsensitive(String value) {
            addCriterion("upper(RECRUIT_SOURCE) like", value.toUpperCase(), "recruitSource");
            return (Criteria) this;
        }

        public Criteria andReferrerIdLikeInsensitive(String value) {
            addCriterion("upper(REFERRER_ID) like", value.toUpperCase(), "referrerId");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLikeInsensitive(String value) {
            addCriterion("upper(REFERRER_NAME) like", value.toUpperCase(), "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgIdLikeInsensitive(String value) {
            addCriterion("upper(REFERRER_ORG_ID) like", value.toUpperCase(), "referrerOrgId");
            return (Criteria) this;
        }

        public Criteria andReferrerOrgNameLikeInsensitive(String value) {
            addCriterion("upper(REFERRER_ORG_NAME) like", value.toUpperCase(), "referrerOrgName");
            return (Criteria) this;
        }

        public Criteria andCandidateTypeLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_TYPE) like", value.toUpperCase(), "candidateType");
            return (Criteria) this;
        }

        public Criteria andIsBeidiaoLikeInsensitive(String value) {
            addCriterion("upper(IS_BEIDIAO) like", value.toUpperCase(), "isBeidiao");
            return (Criteria) this;
        }

        public Criteria andIsEvaluatingLikeInsensitive(String value) {
            addCriterion("upper(IS_EVALUATING) like", value.toUpperCase(), "isEvaluating");
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

        public Criteria andEmployIdLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_ID) like", value.toUpperCase(), "employId");
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