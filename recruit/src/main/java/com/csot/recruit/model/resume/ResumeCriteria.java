package com.csot.recruit.model.resume;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class ResumeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public ResumeCriteria() {
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

        public Criteria andNameEnIsNull() {
            addCriterion("NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("NAME_EN =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("NAME_EN <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("NAME_EN >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_EN >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("NAME_EN <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("NAME_EN <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("NAME_EN like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("NAME_EN not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("NAME_EN in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("NAME_EN not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("NAME_EN between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("NAME_EN not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
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

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("BIRTHDAY =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("BIRTHDAY <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("BIRTHDAY >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("BIRTHDAY >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("BIRTHDAY <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("BIRTHDAY <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("BIRTHDAY in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("BIRTHDAY not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("BIRTHDAY between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("BIRTHDAY not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNull() {
            addCriterion("MARITAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("MARITAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(String value) {
            addCriterion("MARITAL_STATUS =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(String value) {
            addCriterion("MARITAL_STATUS <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(String value) {
            addCriterion("MARITAL_STATUS >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MARITAL_STATUS >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(String value) {
            addCriterion("MARITAL_STATUS <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("MARITAL_STATUS <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLike(String value) {
            addCriterion("MARITAL_STATUS like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotLike(String value) {
            addCriterion("MARITAL_STATUS not like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<String> values) {
            addCriterion("MARITAL_STATUS in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<String> values) {
            addCriterion("MARITAL_STATUS not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(String value1, String value2) {
            addCriterion("MARITAL_STATUS between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("MARITAL_STATUS not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredIsNull() {
            addCriterion("ADDRESS_REGISTERED is null");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredIsNotNull() {
            addCriterion("ADDRESS_REGISTERED is not null");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredEqualTo(String value) {
            addCriterion("ADDRESS_REGISTERED =", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredNotEqualTo(String value) {
            addCriterion("ADDRESS_REGISTERED <>", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredGreaterThan(String value) {
            addCriterion("ADDRESS_REGISTERED >", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_REGISTERED >=", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredLessThan(String value) {
            addCriterion("ADDRESS_REGISTERED <", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_REGISTERED <=", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredLike(String value) {
            addCriterion("ADDRESS_REGISTERED like", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredNotLike(String value) {
            addCriterion("ADDRESS_REGISTERED not like", value, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredIn(List<String> values) {
            addCriterion("ADDRESS_REGISTERED in", values, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredNotIn(List<String> values) {
            addCriterion("ADDRESS_REGISTERED not in", values, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredBetween(String value1, String value2) {
            addCriterion("ADDRESS_REGISTERED between", value1, value2, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_REGISTERED not between", value1, value2, "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNull() {
            addCriterion("WORK_EXPERIENCE is null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNotNull() {
            addCriterion("WORK_EXPERIENCE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE =", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE <>", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE >", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE >=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThan(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE <", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_EXPERIENCE <=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotIn(List<BigDecimal> values) {
            addCriterion("WORK_EXPERIENCE not in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE between", value1, value2, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_EXPERIENCE not between", value1, value2, "workExperience");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeIsNull() {
            addCriterion("VOUCHER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeIsNotNull() {
            addCriterion("VOUCHER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeEqualTo(String value) {
            addCriterion("VOUCHER_TYPE =", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeNotEqualTo(String value) {
            addCriterion("VOUCHER_TYPE <>", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeGreaterThan(String value) {
            addCriterion("VOUCHER_TYPE >", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeGreaterThanOrEqualTo(String value) {
            addCriterion("VOUCHER_TYPE >=", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeLessThan(String value) {
            addCriterion("VOUCHER_TYPE <", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeLessThanOrEqualTo(String value) {
            addCriterion("VOUCHER_TYPE <=", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeLike(String value) {
            addCriterion("VOUCHER_TYPE like", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeNotLike(String value) {
            addCriterion("VOUCHER_TYPE not like", value, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeIn(List<String> values) {
            addCriterion("VOUCHER_TYPE in", values, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeNotIn(List<String> values) {
            addCriterion("VOUCHER_TYPE not in", values, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeBetween(String value1, String value2) {
            addCriterion("VOUCHER_TYPE between", value1, value2, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeNotBetween(String value1, String value2) {
            addCriterion("VOUCHER_TYPE not between", value1, value2, "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberIsNull() {
            addCriterion("VOUCHER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberIsNotNull() {
            addCriterion("VOUCHER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberEqualTo(String value) {
            addCriterion("VOUCHER_NUMBER =", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberNotEqualTo(String value) {
            addCriterion("VOUCHER_NUMBER <>", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberGreaterThan(String value) {
            addCriterion("VOUCHER_NUMBER >", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberGreaterThanOrEqualTo(String value) {
            addCriterion("VOUCHER_NUMBER >=", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberLessThan(String value) {
            addCriterion("VOUCHER_NUMBER <", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberLessThanOrEqualTo(String value) {
            addCriterion("VOUCHER_NUMBER <=", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberLike(String value) {
            addCriterion("VOUCHER_NUMBER like", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberNotLike(String value) {
            addCriterion("VOUCHER_NUMBER not like", value, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberIn(List<String> values) {
            addCriterion("VOUCHER_NUMBER in", values, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberNotIn(List<String> values) {
            addCriterion("VOUCHER_NUMBER not in", values, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberBetween(String value1, String value2) {
            addCriterion("VOUCHER_NUMBER between", value1, value2, "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberNotBetween(String value1, String value2) {
            addCriterion("VOUCHER_NUMBER not between", value1, value2, "voucherNumber");
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

        public Criteria andPhoneReserveIsNull() {
            addCriterion("PHONE_RESERVE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveIsNotNull() {
            addCriterion("PHONE_RESERVE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveEqualTo(String value) {
            addCriterion("PHONE_RESERVE =", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveNotEqualTo(String value) {
            addCriterion("PHONE_RESERVE <>", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveGreaterThan(String value) {
            addCriterion("PHONE_RESERVE >", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_RESERVE >=", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveLessThan(String value) {
            addCriterion("PHONE_RESERVE <", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveLessThanOrEqualTo(String value) {
            addCriterion("PHONE_RESERVE <=", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveLike(String value) {
            addCriterion("PHONE_RESERVE like", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveNotLike(String value) {
            addCriterion("PHONE_RESERVE not like", value, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveIn(List<String> values) {
            addCriterion("PHONE_RESERVE in", values, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveNotIn(List<String> values) {
            addCriterion("PHONE_RESERVE not in", values, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveBetween(String value1, String value2) {
            addCriterion("PHONE_RESERVE between", value1, value2, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveNotBetween(String value1, String value2) {
            addCriterion("PHONE_RESERVE not between", value1, value2, "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNull() {
            addCriterion("APPLY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("APPLY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(String value) {
            addCriterion("APPLY_STATUS =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(String value) {
            addCriterion("APPLY_STATUS <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(String value) {
            addCriterion("APPLY_STATUS >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUS >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(String value) {
            addCriterion("APPLY_STATUS <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUS <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLike(String value) {
            addCriterion("APPLY_STATUS like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotLike(String value) {
            addCriterion("APPLY_STATUS not like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<String> values) {
            addCriterion("APPLY_STATUS in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<String> values) {
            addCriterion("APPLY_STATUS not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(String value1, String value2) {
            addCriterion("APPLY_STATUS between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(String value1, String value2) {
            addCriterion("APPLY_STATUS not between", value1, value2, "applyStatus");
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

        public Criteria andResidenceIsNull() {
            addCriterion("RESIDENCE is null");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNotNull() {
            addCriterion("RESIDENCE is not null");
            return (Criteria) this;
        }

        public Criteria andResidenceEqualTo(String value) {
            addCriterion("RESIDENCE =", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotEqualTo(String value) {
            addCriterion("RESIDENCE <>", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThan(String value) {
            addCriterion("RESIDENCE >", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThanOrEqualTo(String value) {
            addCriterion("RESIDENCE >=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThan(String value) {
            addCriterion("RESIDENCE <", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThanOrEqualTo(String value) {
            addCriterion("RESIDENCE <=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLike(String value) {
            addCriterion("RESIDENCE like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotLike(String value) {
            addCriterion("RESIDENCE not like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceIn(List<String> values) {
            addCriterion("RESIDENCE in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotIn(List<String> values) {
            addCriterion("RESIDENCE not in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceBetween(String value1, String value2) {
            addCriterion("RESIDENCE between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotBetween(String value1, String value2) {
            addCriterion("RESIDENCE not between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("POSTCODE =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("POSTCODE <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("POSTCODE >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("POSTCODE >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("POSTCODE <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("POSTCODE <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("POSTCODE like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("POSTCODE not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("POSTCODE in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("POSTCODE not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("POSTCODE between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("POSTCODE not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressEnIsNull() {
            addCriterion("ADDRESS_EN is null");
            return (Criteria) this;
        }

        public Criteria andAddressEnIsNotNull() {
            addCriterion("ADDRESS_EN is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEnEqualTo(String value) {
            addCriterion("ADDRESS_EN =", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotEqualTo(String value) {
            addCriterion("ADDRESS_EN <>", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnGreaterThan(String value) {
            addCriterion("ADDRESS_EN >", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_EN >=", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnLessThan(String value) {
            addCriterion("ADDRESS_EN <", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_EN <=", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnLike(String value) {
            addCriterion("ADDRESS_EN like", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotLike(String value) {
            addCriterion("ADDRESS_EN not like", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnIn(List<String> values) {
            addCriterion("ADDRESS_EN in", values, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotIn(List<String> values) {
            addCriterion("ADDRESS_EN not in", values, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnBetween(String value1, String value2) {
            addCriterion("ADDRESS_EN between", value1, value2, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_EN not between", value1, value2, "addressEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentIsNull() {
            addCriterion("SELF_ASSESSMENT is null");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentIsNotNull() {
            addCriterion("SELF_ASSESSMENT is not null");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT =", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentNotEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT <>", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentGreaterThan(String value) {
            addCriterion("SELF_ASSESSMENT >", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentGreaterThanOrEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT >=", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentLessThan(String value) {
            addCriterion("SELF_ASSESSMENT <", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentLessThanOrEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT <=", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentLike(String value) {
            addCriterion("SELF_ASSESSMENT like", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentNotLike(String value) {
            addCriterion("SELF_ASSESSMENT not like", value, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentIn(List<String> values) {
            addCriterion("SELF_ASSESSMENT in", values, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentNotIn(List<String> values) {
            addCriterion("SELF_ASSESSMENT not in", values, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentBetween(String value1, String value2) {
            addCriterion("SELF_ASSESSMENT between", value1, value2, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentNotBetween(String value1, String value2) {
            addCriterion("SELF_ASSESSMENT not between", value1, value2, "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnIsNull() {
            addCriterion("SELF_ASSESSMENT_EN is null");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnIsNotNull() {
            addCriterion("SELF_ASSESSMENT_EN is not null");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT_EN =", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnNotEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT_EN <>", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnGreaterThan(String value) {
            addCriterion("SELF_ASSESSMENT_EN >", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnGreaterThanOrEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT_EN >=", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnLessThan(String value) {
            addCriterion("SELF_ASSESSMENT_EN <", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnLessThanOrEqualTo(String value) {
            addCriterion("SELF_ASSESSMENT_EN <=", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnLike(String value) {
            addCriterion("SELF_ASSESSMENT_EN like", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnNotLike(String value) {
            addCriterion("SELF_ASSESSMENT_EN not like", value, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnIn(List<String> values) {
            addCriterion("SELF_ASSESSMENT_EN in", values, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnNotIn(List<String> values) {
            addCriterion("SELF_ASSESSMENT_EN not in", values, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnBetween(String value1, String value2) {
            addCriterion("SELF_ASSESSMENT_EN between", value1, value2, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnNotBetween(String value1, String value2) {
            addCriterion("SELF_ASSESSMENT_EN not between", value1, value2, "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(BigDecimal value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(BigDecimal value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(BigDecimal value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(BigDecimal value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<BigDecimal> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<BigDecimal> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andHighestEducationIsNull() {
            addCriterion("HIGHEST_EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andHighestEducationIsNotNull() {
            addCriterion("HIGHEST_EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andHighestEducationEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION =", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION <>", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationGreaterThan(String value) {
            addCriterion("HIGHEST_EDUCATION >", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationGreaterThanOrEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION >=", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLessThan(String value) {
            addCriterion("HIGHEST_EDUCATION <", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLessThanOrEqualTo(String value) {
            addCriterion("HIGHEST_EDUCATION <=", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLike(String value) {
            addCriterion("HIGHEST_EDUCATION like", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotLike(String value) {
            addCriterion("HIGHEST_EDUCATION not like", value, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationIn(List<String> values) {
            addCriterion("HIGHEST_EDUCATION in", values, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotIn(List<String> values) {
            addCriterion("HIGHEST_EDUCATION not in", values, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationBetween(String value1, String value2) {
            addCriterion("HIGHEST_EDUCATION between", value1, value2, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andHighestEducationNotBetween(String value1, String value2) {
            addCriterion("HIGHEST_EDUCATION not between", value1, value2, "highestEducation");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("NATION is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("NATION is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("NATION =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("NATION <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("NATION >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("NATION >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("NATION <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("NATION <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("NATION like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("NATION not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("NATION in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("NATION not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("NATION between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("NATION not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("ID_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("ID_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("ID_NUMBER =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("ID_NUMBER <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("ID_NUMBER >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ID_NUMBER >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("ID_NUMBER <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("ID_NUMBER <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("ID_NUMBER like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("ID_NUMBER not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("ID_NUMBER in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("ID_NUMBER not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("ID_NUMBER between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("ID_NUMBER not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdAddressIsNull() {
            addCriterion("ID_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andIdAddressIsNotNull() {
            addCriterion("ID_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andIdAddressEqualTo(String value) {
            addCriterion("ID_ADDRESS =", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotEqualTo(String value) {
            addCriterion("ID_ADDRESS <>", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressGreaterThan(String value) {
            addCriterion("ID_ADDRESS >", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ID_ADDRESS >=", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLessThan(String value) {
            addCriterion("ID_ADDRESS <", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLessThanOrEqualTo(String value) {
            addCriterion("ID_ADDRESS <=", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLike(String value) {
            addCriterion("ID_ADDRESS like", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotLike(String value) {
            addCriterion("ID_ADDRESS not like", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressIn(List<String> values) {
            addCriterion("ID_ADDRESS in", values, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotIn(List<String> values) {
            addCriterion("ID_ADDRESS not in", values, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressBetween(String value1, String value2) {
            addCriterion("ID_ADDRESS between", value1, value2, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotBetween(String value1, String value2) {
            addCriterion("ID_ADDRESS not between", value1, value2, "idAddress");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNull() {
            addCriterion("REPORT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("REPORT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(String value) {
            addCriterion("REPORT_TIME =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(String value) {
            addCriterion("REPORT_TIME <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(String value) {
            addCriterion("REPORT_TIME >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REPORT_TIME >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(String value) {
            addCriterion("REPORT_TIME <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(String value) {
            addCriterion("REPORT_TIME <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLike(String value) {
            addCriterion("REPORT_TIME like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotLike(String value) {
            addCriterion("REPORT_TIME not like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<String> values) {
            addCriterion("REPORT_TIME in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<String> values) {
            addCriterion("REPORT_TIME not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(String value1, String value2) {
            addCriterion("REPORT_TIME between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(String value1, String value2) {
            addCriterion("REPORT_TIME not between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectIsNull() {
            addCriterion("WORKPLACE_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectIsNotNull() {
            addCriterion("WORKPLACE_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT =", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT <>", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectGreaterThan(String value) {
            addCriterion("WORKPLACE_EXPECT >", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectGreaterThanOrEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT >=", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLessThan(String value) {
            addCriterion("WORKPLACE_EXPECT <", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLessThanOrEqualTo(String value) {
            addCriterion("WORKPLACE_EXPECT <=", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLike(String value) {
            addCriterion("WORKPLACE_EXPECT like", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotLike(String value) {
            addCriterion("WORKPLACE_EXPECT not like", value, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectIn(List<String> values) {
            addCriterion("WORKPLACE_EXPECT in", values, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotIn(List<String> values) {
            addCriterion("WORKPLACE_EXPECT not in", values, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectBetween(String value1, String value2) {
            addCriterion("WORKPLACE_EXPECT between", value1, value2, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectNotBetween(String value1, String value2) {
            addCriterion("WORKPLACE_EXPECT not between", value1, value2, "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectIsNull() {
            addCriterion("POST_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andPostExpectIsNotNull() {
            addCriterion("POST_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andPostExpectEqualTo(String value) {
            addCriterion("POST_EXPECT =", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotEqualTo(String value) {
            addCriterion("POST_EXPECT <>", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectGreaterThan(String value) {
            addCriterion("POST_EXPECT >", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectGreaterThanOrEqualTo(String value) {
            addCriterion("POST_EXPECT >=", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLessThan(String value) {
            addCriterion("POST_EXPECT <", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLessThanOrEqualTo(String value) {
            addCriterion("POST_EXPECT <=", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLike(String value) {
            addCriterion("POST_EXPECT like", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotLike(String value) {
            addCriterion("POST_EXPECT not like", value, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectIn(List<String> values) {
            addCriterion("POST_EXPECT in", values, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotIn(List<String> values) {
            addCriterion("POST_EXPECT not in", values, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectBetween(String value1, String value2) {
            addCriterion("POST_EXPECT between", value1, value2, "postExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectNotBetween(String value1, String value2) {
            addCriterion("POST_EXPECT not between", value1, value2, "postExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectIsNull() {
            addCriterion("INDUSTRY_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectIsNotNull() {
            addCriterion("INDUSTRY_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT =", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT <>", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectGreaterThan(String value) {
            addCriterion("INDUSTRY_EXPECT >", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT >=", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLessThan(String value) {
            addCriterion("INDUSTRY_EXPECT <", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_EXPECT <=", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLike(String value) {
            addCriterion("INDUSTRY_EXPECT like", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotLike(String value) {
            addCriterion("INDUSTRY_EXPECT not like", value, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectIn(List<String> values) {
            addCriterion("INDUSTRY_EXPECT in", values, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotIn(List<String> values) {
            addCriterion("INDUSTRY_EXPECT not in", values, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectBetween(String value1, String value2) {
            addCriterion("INDUSTRY_EXPECT between", value1, value2, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_EXPECT not between", value1, value2, "industryExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectIsNull() {
            addCriterion("JOBTYPE_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectIsNotNull() {
            addCriterion("JOBTYPE_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT =", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT <>", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectGreaterThan(String value) {
            addCriterion("JOBTYPE_EXPECT >", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectGreaterThanOrEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT >=", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLessThan(String value) {
            addCriterion("JOBTYPE_EXPECT <", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLessThanOrEqualTo(String value) {
            addCriterion("JOBTYPE_EXPECT <=", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLike(String value) {
            addCriterion("JOBTYPE_EXPECT like", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotLike(String value) {
            addCriterion("JOBTYPE_EXPECT not like", value, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectIn(List<String> values) {
            addCriterion("JOBTYPE_EXPECT in", values, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotIn(List<String> values) {
            addCriterion("JOBTYPE_EXPECT not in", values, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectBetween(String value1, String value2) {
            addCriterion("JOBTYPE_EXPECT between", value1, value2, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectNotBetween(String value1, String value2) {
            addCriterion("JOBTYPE_EXPECT not between", value1, value2, "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectIsNull() {
            addCriterion("SALARY_EXPECT is null");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectIsNotNull() {
            addCriterion("SALARY_EXPECT is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectEqualTo(String value) {
            addCriterion("SALARY_EXPECT =", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotEqualTo(String value) {
            addCriterion("SALARY_EXPECT <>", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectGreaterThan(String value) {
            addCriterion("SALARY_EXPECT >", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectGreaterThanOrEqualTo(String value) {
            addCriterion("SALARY_EXPECT >=", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLessThan(String value) {
            addCriterion("SALARY_EXPECT <", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLessThanOrEqualTo(String value) {
            addCriterion("SALARY_EXPECT <=", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLike(String value) {
            addCriterion("SALARY_EXPECT like", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotLike(String value) {
            addCriterion("SALARY_EXPECT not like", value, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectIn(List<String> values) {
            addCriterion("SALARY_EXPECT in", values, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotIn(List<String> values) {
            addCriterion("SALARY_EXPECT not in", values, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectBetween(String value1, String value2) {
            addCriterion("SALARY_EXPECT between", value1, value2, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectNotBetween(String value1, String value2) {
            addCriterion("SALARY_EXPECT not between", value1, value2, "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("CURRENCY =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("CURRENCY <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("CURRENCY >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("CURRENCY <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("CURRENCY like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("CURRENCY not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("CURRENCY in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("CURRENCY not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("CURRENCY between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("CURRENCY not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIsNull() {
            addCriterion("HEAD_PORTRAIT is null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIsNotNull() {
            addCriterion("HEAD_PORTRAIT is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitEqualTo(String value) {
            addCriterion("HEAD_PORTRAIT =", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotEqualTo(String value) {
            addCriterion("HEAD_PORTRAIT <>", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitGreaterThan(String value) {
            addCriterion("HEAD_PORTRAIT >", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD_PORTRAIT >=", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLessThan(String value) {
            addCriterion("HEAD_PORTRAIT <", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLessThanOrEqualTo(String value) {
            addCriterion("HEAD_PORTRAIT <=", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLike(String value) {
            addCriterion("HEAD_PORTRAIT like", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotLike(String value) {
            addCriterion("HEAD_PORTRAIT not like", value, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitIn(List<String> values) {
            addCriterion("HEAD_PORTRAIT in", values, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotIn(List<String> values) {
            addCriterion("HEAD_PORTRAIT not in", values, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitBetween(String value1, String value2) {
            addCriterion("HEAD_PORTRAIT between", value1, value2, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitNotBetween(String value1, String value2) {
            addCriterion("HEAD_PORTRAIT not between", value1, value2, "headPortrait");
            return (Criteria) this;
        }

        public Criteria andTrainInforIsNull() {
            addCriterion("TRAIN_INFOR is null");
            return (Criteria) this;
        }

        public Criteria andTrainInforIsNotNull() {
            addCriterion("TRAIN_INFOR is not null");
            return (Criteria) this;
        }

        public Criteria andTrainInforEqualTo(String value) {
            addCriterion("TRAIN_INFOR =", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforNotEqualTo(String value) {
            addCriterion("TRAIN_INFOR <>", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforGreaterThan(String value) {
            addCriterion("TRAIN_INFOR >", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforGreaterThanOrEqualTo(String value) {
            addCriterion("TRAIN_INFOR >=", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforLessThan(String value) {
            addCriterion("TRAIN_INFOR <", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforLessThanOrEqualTo(String value) {
            addCriterion("TRAIN_INFOR <=", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforLike(String value) {
            addCriterion("TRAIN_INFOR like", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforNotLike(String value) {
            addCriterion("TRAIN_INFOR not like", value, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforIn(List<String> values) {
            addCriterion("TRAIN_INFOR in", values, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforNotIn(List<String> values) {
            addCriterion("TRAIN_INFOR not in", values, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforBetween(String value1, String value2) {
            addCriterion("TRAIN_INFOR between", value1, value2, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andTrainInforNotBetween(String value1, String value2) {
            addCriterion("TRAIN_INFOR not between", value1, value2, "trainInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforIsNull() {
            addCriterion("SKILL_INFOR is null");
            return (Criteria) this;
        }

        public Criteria andSkillInforIsNotNull() {
            addCriterion("SKILL_INFOR is not null");
            return (Criteria) this;
        }

        public Criteria andSkillInforEqualTo(String value) {
            addCriterion("SKILL_INFOR =", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforNotEqualTo(String value) {
            addCriterion("SKILL_INFOR <>", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforGreaterThan(String value) {
            addCriterion("SKILL_INFOR >", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforGreaterThanOrEqualTo(String value) {
            addCriterion("SKILL_INFOR >=", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforLessThan(String value) {
            addCriterion("SKILL_INFOR <", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforLessThanOrEqualTo(String value) {
            addCriterion("SKILL_INFOR <=", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforLike(String value) {
            addCriterion("SKILL_INFOR like", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforNotLike(String value) {
            addCriterion("SKILL_INFOR not like", value, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforIn(List<String> values) {
            addCriterion("SKILL_INFOR in", values, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforNotIn(List<String> values) {
            addCriterion("SKILL_INFOR not in", values, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforBetween(String value1, String value2) {
            addCriterion("SKILL_INFOR between", value1, value2, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforNotBetween(String value1, String value2) {
            addCriterion("SKILL_INFOR not between", value1, value2, "skillInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforIsNull() {
            addCriterion("LANGUAGE_INFOR is null");
            return (Criteria) this;
        }

        public Criteria andLanguageInforIsNotNull() {
            addCriterion("LANGUAGE_INFOR is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageInforEqualTo(String value) {
            addCriterion("LANGUAGE_INFOR =", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforNotEqualTo(String value) {
            addCriterion("LANGUAGE_INFOR <>", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforGreaterThan(String value) {
            addCriterion("LANGUAGE_INFOR >", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUAGE_INFOR >=", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforLessThan(String value) {
            addCriterion("LANGUAGE_INFOR <", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforLessThanOrEqualTo(String value) {
            addCriterion("LANGUAGE_INFOR <=", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforLike(String value) {
            addCriterion("LANGUAGE_INFOR like", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforNotLike(String value) {
            addCriterion("LANGUAGE_INFOR not like", value, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforIn(List<String> values) {
            addCriterion("LANGUAGE_INFOR in", values, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforNotIn(List<String> values) {
            addCriterion("LANGUAGE_INFOR not in", values, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforBetween(String value1, String value2) {
            addCriterion("LANGUAGE_INFOR between", value1, value2, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforNotBetween(String value1, String value2) {
            addCriterion("LANGUAGE_INFOR not between", value1, value2, "languageInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforIsNull() {
            addCriterion("CERTIFICATE_INFOR is null");
            return (Criteria) this;
        }

        public Criteria andCertificateInforIsNotNull() {
            addCriterion("CERTIFICATE_INFOR is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateInforEqualTo(String value) {
            addCriterion("CERTIFICATE_INFOR =", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforNotEqualTo(String value) {
            addCriterion("CERTIFICATE_INFOR <>", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforGreaterThan(String value) {
            addCriterion("CERTIFICATE_INFOR >", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_INFOR >=", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforLessThan(String value) {
            addCriterion("CERTIFICATE_INFOR <", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATE_INFOR <=", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforLike(String value) {
            addCriterion("CERTIFICATE_INFOR like", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforNotLike(String value) {
            addCriterion("CERTIFICATE_INFOR not like", value, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforIn(List<String> values) {
            addCriterion("CERTIFICATE_INFOR in", values, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforNotIn(List<String> values) {
            addCriterion("CERTIFICATE_INFOR not in", values, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_INFOR between", value1, value2, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATE_INFOR not between", value1, value2, "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforIsNull() {
            addCriterion("AWARD_INFOR is null");
            return (Criteria) this;
        }

        public Criteria andAwardInforIsNotNull() {
            addCriterion("AWARD_INFOR is not null");
            return (Criteria) this;
        }

        public Criteria andAwardInforEqualTo(String value) {
            addCriterion("AWARD_INFOR =", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforNotEqualTo(String value) {
            addCriterion("AWARD_INFOR <>", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforGreaterThan(String value) {
            addCriterion("AWARD_INFOR >", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforGreaterThanOrEqualTo(String value) {
            addCriterion("AWARD_INFOR >=", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforLessThan(String value) {
            addCriterion("AWARD_INFOR <", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforLessThanOrEqualTo(String value) {
            addCriterion("AWARD_INFOR <=", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforLike(String value) {
            addCriterion("AWARD_INFOR like", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforNotLike(String value) {
            addCriterion("AWARD_INFOR not like", value, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforIn(List<String> values) {
            addCriterion("AWARD_INFOR in", values, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforNotIn(List<String> values) {
            addCriterion("AWARD_INFOR not in", values, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforBetween(String value1, String value2) {
            addCriterion("AWARD_INFOR between", value1, value2, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforNotBetween(String value1, String value2) {
            addCriterion("AWARD_INFOR not between", value1, value2, "awardInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforIsNull() {
            addCriterion("HOBBY_INFOR is null");
            return (Criteria) this;
        }

        public Criteria andHobbyInforIsNotNull() {
            addCriterion("HOBBY_INFOR is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyInforEqualTo(String value) {
            addCriterion("HOBBY_INFOR =", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforNotEqualTo(String value) {
            addCriterion("HOBBY_INFOR <>", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforGreaterThan(String value) {
            addCriterion("HOBBY_INFOR >", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforGreaterThanOrEqualTo(String value) {
            addCriterion("HOBBY_INFOR >=", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforLessThan(String value) {
            addCriterion("HOBBY_INFOR <", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforLessThanOrEqualTo(String value) {
            addCriterion("HOBBY_INFOR <=", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforLike(String value) {
            addCriterion("HOBBY_INFOR like", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforNotLike(String value) {
            addCriterion("HOBBY_INFOR not like", value, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforIn(List<String> values) {
            addCriterion("HOBBY_INFOR in", values, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforNotIn(List<String> values) {
            addCriterion("HOBBY_INFOR not in", values, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforBetween(String value1, String value2) {
            addCriterion("HOBBY_INFOR between", value1, value2, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforNotBetween(String value1, String value2) {
            addCriterion("HOBBY_INFOR not between", value1, value2, "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusIsNull() {
            addCriterion("SELECTION_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusIsNotNull() {
            addCriterion("SELECTION_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusEqualTo(BigDecimal value) {
            addCriterion("SELECTION_STATUS =", value, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusNotEqualTo(BigDecimal value) {
            addCriterion("SELECTION_STATUS <>", value, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusGreaterThan(BigDecimal value) {
            addCriterion("SELECTION_STATUS >", value, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SELECTION_STATUS >=", value, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusLessThan(BigDecimal value) {
            addCriterion("SELECTION_STATUS <", value, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SELECTION_STATUS <=", value, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusIn(List<BigDecimal> values) {
            addCriterion("SELECTION_STATUS in", values, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusNotIn(List<BigDecimal> values) {
            addCriterion("SELECTION_STATUS not in", values, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELECTION_STATUS between", value1, value2, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andSelectionStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELECTION_STATUS not between", value1, value2, "selectionStatus");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("LABEL is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("LABEL is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("LABEL =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("LABEL <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("LABEL >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("LABEL >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("LABEL <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("LABEL <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("LABEL like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("LABEL not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("LABEL in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("LABEL not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("LABEL between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("LABEL not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryIsNull() {
            addCriterion("CURRENT_INDUSTRY is null");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryIsNotNull() {
            addCriterion("CURRENT_INDUSTRY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryEqualTo(String value) {
            addCriterion("CURRENT_INDUSTRY =", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryNotEqualTo(String value) {
            addCriterion("CURRENT_INDUSTRY <>", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryGreaterThan(String value) {
            addCriterion("CURRENT_INDUSTRY >", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_INDUSTRY >=", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryLessThan(String value) {
            addCriterion("CURRENT_INDUSTRY <", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_INDUSTRY <=", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryLike(String value) {
            addCriterion("CURRENT_INDUSTRY like", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryNotLike(String value) {
            addCriterion("CURRENT_INDUSTRY not like", value, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryIn(List<String> values) {
            addCriterion("CURRENT_INDUSTRY in", values, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryNotIn(List<String> values) {
            addCriterion("CURRENT_INDUSTRY not in", values, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryBetween(String value1, String value2) {
            addCriterion("CURRENT_INDUSTRY between", value1, value2, "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryNotBetween(String value1, String value2) {
            addCriterion("CURRENT_INDUSTRY not between", value1, value2, "currentIndustry");
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
            addCriterionForJDBCDate("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNull() {
            addCriterion("POSITIONID is null");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNotNull() {
            addCriterion("POSITIONID is not null");
            return (Criteria) this;
        }

        public Criteria andPositionidEqualTo(String value) {
            addCriterion("POSITIONID =", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotEqualTo(String value) {
            addCriterion("POSITIONID <>", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThan(String value) {
            addCriterion("POSITIONID >", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThanOrEqualTo(String value) {
            addCriterion("POSITIONID >=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThan(String value) {
            addCriterion("POSITIONID <", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThanOrEqualTo(String value) {
            addCriterion("POSITIONID <=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLike(String value) {
            addCriterion("POSITIONID like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotLike(String value) {
            addCriterion("POSITIONID not like", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidIn(List<String> values) {
            addCriterion("POSITIONID in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotIn(List<String> values) {
            addCriterion("POSITIONID not in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidBetween(String value1, String value2) {
            addCriterion("POSITIONID between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotBetween(String value1, String value2) {
            addCriterion("POSITIONID not between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIsNull() {
            addCriterion("CURRENT_COMPANY is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIsNotNull() {
            addCriterion("CURRENT_COMPANY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyEqualTo(String value) {
            addCriterion("CURRENT_COMPANY =", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotEqualTo(String value) {
            addCriterion("CURRENT_COMPANY <>", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyGreaterThan(String value) {
            addCriterion("CURRENT_COMPANY >", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_COMPANY >=", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLessThan(String value) {
            addCriterion("CURRENT_COMPANY <", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_COMPANY <=", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLike(String value) {
            addCriterion("CURRENT_COMPANY like", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotLike(String value) {
            addCriterion("CURRENT_COMPANY not like", value, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyIn(List<String> values) {
            addCriterion("CURRENT_COMPANY in", values, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotIn(List<String> values) {
            addCriterion("CURRENT_COMPANY not in", values, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyBetween(String value1, String value2) {
            addCriterion("CURRENT_COMPANY between", value1, value2, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyNotBetween(String value1, String value2) {
            addCriterion("CURRENT_COMPANY not between", value1, value2, "currentCompany");
            return (Criteria) this;
        }

        public Criteria andResumeoriginIsNull() {
            addCriterion("RESUMEORIGIN is null");
            return (Criteria) this;
        }

        public Criteria andResumeoriginIsNotNull() {
            addCriterion("RESUMEORIGIN is not null");
            return (Criteria) this;
        }

        public Criteria andResumeoriginEqualTo(String value) {
            addCriterion("RESUMEORIGIN =", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotEqualTo(String value) {
            addCriterion("RESUMEORIGIN <>", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginGreaterThan(String value) {
            addCriterion("RESUMEORIGIN >", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginGreaterThanOrEqualTo(String value) {
            addCriterion("RESUMEORIGIN >=", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLessThan(String value) {
            addCriterion("RESUMEORIGIN <", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLessThanOrEqualTo(String value) {
            addCriterion("RESUMEORIGIN <=", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLike(String value) {
            addCriterion("RESUMEORIGIN like", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotLike(String value) {
            addCriterion("RESUMEORIGIN not like", value, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginIn(List<String> values) {
            addCriterion("RESUMEORIGIN in", values, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotIn(List<String> values) {
            addCriterion("RESUMEORIGIN not in", values, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginBetween(String value1, String value2) {
            addCriterion("RESUMEORIGIN between", value1, value2, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andResumeoriginNotBetween(String value1, String value2) {
            addCriterion("RESUMEORIGIN not between", value1, value2, "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("CHANNEL <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("CHANNEL >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("CHANNEL <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("CHANNEL like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("CHANNEL not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("CHANNEL in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("CHANNEL not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("CHANNEL between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("CHANNEL not between", value1, value2, "channel");
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

        public Criteria andNameEnLikeInsensitive(String value) {
            addCriterion("upper(NAME_EN) like", value.toUpperCase(), "nameEn");
            return (Criteria) this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(SEX) like", value.toUpperCase(), "sex");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLikeInsensitive(String value) {
            addCriterion("upper(MARITAL_STATUS) like", value.toUpperCase(), "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andAddressRegisteredLikeInsensitive(String value) {
            addCriterion("upper(ADDRESS_REGISTERED) like", value.toUpperCase(), "addressRegistered");
            return (Criteria) this;
        }

        public Criteria andVoucherTypeLikeInsensitive(String value) {
            addCriterion("upper(VOUCHER_TYPE) like", value.toUpperCase(), "voucherType");
            return (Criteria) this;
        }

        public Criteria andVoucherNumberLikeInsensitive(String value) {
            addCriterion("upper(VOUCHER_NUMBER) like", value.toUpperCase(), "voucherNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(PHONE) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneReserveLikeInsensitive(String value) {
            addCriterion("upper(PHONE_RESERVE) like", value.toUpperCase(), "phoneReserve");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLikeInsensitive(String value) {
            addCriterion("upper(APPLY_STATUS) like", value.toUpperCase(), "applyStatus");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andResidenceLikeInsensitive(String value) {
            addCriterion("upper(RESIDENCE) like", value.toUpperCase(), "residence");
            return (Criteria) this;
        }

        public Criteria andPostcodeLikeInsensitive(String value) {
            addCriterion("upper(POSTCODE) like", value.toUpperCase(), "postcode");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(ADDRESS) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andAddressEnLikeInsensitive(String value) {
            addCriterion("upper(ADDRESS_EN) like", value.toUpperCase(), "addressEn");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentLikeInsensitive(String value) {
            addCriterion("upper(SELF_ASSESSMENT) like", value.toUpperCase(), "selfAssessment");
            return (Criteria) this;
        }

        public Criteria andSelfAssessmentEnLikeInsensitive(String value) {
            addCriterion("upper(SELF_ASSESSMENT_EN) like", value.toUpperCase(), "selfAssessmentEn");
            return (Criteria) this;
        }

        public Criteria andHighestEducationLikeInsensitive(String value) {
            addCriterion("upper(HIGHEST_EDUCATION) like", value.toUpperCase(), "highestEducation");
            return (Criteria) this;
        }

        public Criteria andNationLikeInsensitive(String value) {
            addCriterion("upper(NATION) like", value.toUpperCase(), "nation");
            return (Criteria) this;
        }

        public Criteria andIdNumberLikeInsensitive(String value) {
            addCriterion("upper(ID_NUMBER) like", value.toUpperCase(), "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdAddressLikeInsensitive(String value) {
            addCriterion("upper(ID_ADDRESS) like", value.toUpperCase(), "idAddress");
            return (Criteria) this;
        }

        public Criteria andReportTimeLikeInsensitive(String value) {
            addCriterion("upper(REPORT_TIME) like", value.toUpperCase(), "reportTime");
            return (Criteria) this;
        }

        public Criteria andWorkplaceExpectLikeInsensitive(String value) {
            addCriterion("upper(WORKPLACE_EXPECT) like", value.toUpperCase(), "workplaceExpect");
            return (Criteria) this;
        }

        public Criteria andPostExpectLikeInsensitive(String value) {
            addCriterion("upper(POST_EXPECT) like", value.toUpperCase(), "postExpect");
            return (Criteria) this;
        }

        public Criteria andIndustryExpectLikeInsensitive(String value) {
            addCriterion("upper(INDUSTRY_EXPECT) like", value.toUpperCase(), "industryExpect");
            return (Criteria) this;
        }

        public Criteria andJobtypeExpectLikeInsensitive(String value) {
            addCriterion("upper(JOBTYPE_EXPECT) like", value.toUpperCase(), "jobtypeExpect");
            return (Criteria) this;
        }

        public Criteria andSalaryExpectLikeInsensitive(String value) {
            addCriterion("upper(SALARY_EXPECT) like", value.toUpperCase(), "salaryExpect");
            return (Criteria) this;
        }

        public Criteria andCurrencyLikeInsensitive(String value) {
            addCriterion("upper(CURRENCY) like", value.toUpperCase(), "currency");
            return (Criteria) this;
        }

        public Criteria andHeadPortraitLikeInsensitive(String value) {
            addCriterion("upper(HEAD_PORTRAIT) like", value.toUpperCase(), "headPortrait");
            return (Criteria) this;
        }

        public Criteria andTrainInforLikeInsensitive(String value) {
            addCriterion("upper(TRAIN_INFOR) like", value.toUpperCase(), "trainInfor");
            return (Criteria) this;
        }

        public Criteria andSkillInforLikeInsensitive(String value) {
            addCriterion("upper(SKILL_INFOR) like", value.toUpperCase(), "skillInfor");
            return (Criteria) this;
        }

        public Criteria andLanguageInforLikeInsensitive(String value) {
            addCriterion("upper(LANGUAGE_INFOR) like", value.toUpperCase(), "languageInfor");
            return (Criteria) this;
        }

        public Criteria andCertificateInforLikeInsensitive(String value) {
            addCriterion("upper(CERTIFICATE_INFOR) like", value.toUpperCase(), "certificateInfor");
            return (Criteria) this;
        }

        public Criteria andAwardInforLikeInsensitive(String value) {
            addCriterion("upper(AWARD_INFOR) like", value.toUpperCase(), "awardInfor");
            return (Criteria) this;
        }

        public Criteria andHobbyInforLikeInsensitive(String value) {
            addCriterion("upper(HOBBY_INFOR) like", value.toUpperCase(), "hobbyInfor");
            return (Criteria) this;
        }

        public Criteria andLabelLikeInsensitive(String value) {
            addCriterion("upper(LABEL) like", value.toUpperCase(), "label");
            return (Criteria) this;
        }

        public Criteria andCurrentIndustryLikeInsensitive(String value) {
            addCriterion("upper(CURRENT_INDUSTRY) like", value.toUpperCase(), "currentIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionidLikeInsensitive(String value) {
            addCriterion("upper(POSITIONID) like", value.toUpperCase(), "positionid");
            return (Criteria) this;
        }

        public Criteria andCurrentCompanyLikeInsensitive(String value) {
            addCriterion("upper(CURRENT_COMPANY) like", value.toUpperCase(), "currentCompany");
            return (Criteria) this;
        }

        public Criteria andResumeoriginLikeInsensitive(String value) {
            addCriterion("upper(RESUMEORIGIN) like", value.toUpperCase(), "resumeorigin");
            return (Criteria) this;
        }

        public Criteria andChannelLikeInsensitive(String value) {
            addCriterion("upper(CHANNEL) like", value.toUpperCase(), "channel");
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