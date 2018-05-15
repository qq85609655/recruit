package com.csot.recruit.model.original.campus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CampusTaskHistoryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CampusTaskHistoryCriteria() {
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

        public Criteria andSiteIdIsNull() {
            addCriterion("SITE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("SITE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(String value) {
            addCriterion("SITE_ID =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(String value) {
            addCriterion("SITE_ID <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(String value) {
            addCriterion("SITE_ID >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(String value) {
            addCriterion("SITE_ID >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(String value) {
            addCriterion("SITE_ID <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(String value) {
            addCriterion("SITE_ID <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLike(String value) {
            addCriterion("SITE_ID like", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotLike(String value) {
            addCriterion("SITE_ID not like", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<String> values) {
            addCriterion("SITE_ID in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<String> values) {
            addCriterion("SITE_ID not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(String value1, String value2) {
            addCriterion("SITE_ID between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(String value1, String value2) {
            addCriterion("SITE_ID not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNull() {
            addCriterion("SITE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("SITE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("SITE_NAME =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("SITE_NAME <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("SITE_NAME >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("SITE_NAME >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("SITE_NAME <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("SITE_NAME <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("SITE_NAME like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("SITE_NAME not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("SITE_NAME in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("SITE_NAME not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("SITE_NAME between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("SITE_NAME not between", value1, value2, "siteName");
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

        public Criteria andTaskNumberBaIsNull() {
            addCriterion("TASK_NUMBER_BA is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaIsNotNull() {
            addCriterion("TASK_NUMBER_BA is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA =", value, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA <>", value, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_BA >", value, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA >=", value, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaLessThan(Integer value) {
            addCriterion("TASK_NUMBER_BA <", value, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA <=", value, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_BA in", values, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_BA not in", values, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_BA between", value1, value2, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_BA not between", value1, value2, "taskNumberBa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaIsNull() {
            addCriterion("TASK_NUMBER_MA is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaIsNotNull() {
            addCriterion("TASK_NUMBER_MA is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA =", value, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA <>", value, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_MA >", value, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA >=", value, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaLessThan(Integer value) {
            addCriterion("TASK_NUMBER_MA <", value, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA <=", value, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MA in", values, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MA not in", values, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MA between", value1, value2, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MA not between", value1, value2, "taskNumberMa");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoIsNull() {
            addCriterion("TASK_NUMBER_DO is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoIsNotNull() {
            addCriterion("TASK_NUMBER_DO is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO =", value, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO <>", value, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_DO >", value, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO >=", value, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoLessThan(Integer value) {
            addCriterion("TASK_NUMBER_DO <", value, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO <=", value, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_DO in", values, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_DO not in", values, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_DO between", value1, value2, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_DO not between", value1, value2, "taskNumberDo");
            return (Criteria) this;
        }

        public Criteria andYearthIsNull() {
            addCriterion("YEARTH is null");
            return (Criteria) this;
        }

        public Criteria andYearthIsNotNull() {
            addCriterion("YEARTH is not null");
            return (Criteria) this;
        }

        public Criteria andYearthEqualTo(String value) {
            addCriterion("YEARTH =", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthNotEqualTo(String value) {
            addCriterion("YEARTH <>", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthGreaterThan(String value) {
            addCriterion("YEARTH >", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthGreaterThanOrEqualTo(String value) {
            addCriterion("YEARTH >=", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthLessThan(String value) {
            addCriterion("YEARTH <", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthLessThanOrEqualTo(String value) {
            addCriterion("YEARTH <=", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthLike(String value) {
            addCriterion("YEARTH like", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthNotLike(String value) {
            addCriterion("YEARTH not like", value, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthIn(List<String> values) {
            addCriterion("YEARTH in", values, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthNotIn(List<String> values) {
            addCriterion("YEARTH not in", values, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthBetween(String value1, String value2) {
            addCriterion("YEARTH between", value1, value2, "yearth");
            return (Criteria) this;
        }

        public Criteria andYearthNotBetween(String value1, String value2) {
            addCriterion("YEARTH not between", value1, value2, "yearth");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumIsNull() {
            addCriterion("TASK_NUMBER_SUM is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumIsNotNull() {
            addCriterion("TASK_NUMBER_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM =", value, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM <>", value, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_SUM >", value, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM >=", value, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumLessThan(Integer value) {
            addCriterion("TASK_NUMBER_SUM <", value, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM <=", value, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_SUM in", values, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_SUM not in", values, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_SUM between", value1, value2, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_SUM not between", value1, value2, "taskNumberSum");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailIsNull() {
            addCriterion("TASK_NUMBER_MAIL is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailIsNotNull() {
            addCriterion("TASK_NUMBER_MAIL is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL =", value, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL <>", value, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_MAIL >", value, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL >=", value, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailLessThan(Integer value) {
            addCriterion("TASK_NUMBER_MAIL <", value, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL <=", value, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MAIL in", values, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MAIL not in", values, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MAIL between", value1, value2, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MAIL not between", value1, value2, "taskNumberMail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailIsNull() {
            addCriterion("TASK_NUMBER_FEMAIL is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailIsNotNull() {
            addCriterion("TASK_NUMBER_FEMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL =", value, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL <>", value, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL >", value, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL >=", value, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailLessThan(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL <", value, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL <=", value, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_FEMAIL in", values, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_FEMAIL not in", values, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_FEMAIL between", value1, value2, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_FEMAIL not between", value1, value2, "taskNumberFemail");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNull() {
            addCriterion("CHANGE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNotNull() {
            addCriterion("CHANGE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDateEqualTo(Date value) {
            addCriterionForJDBCDate("CHANGE_DATE =", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CHANGE_DATE <>", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CHANGE_DATE >", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHANGE_DATE >=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThan(Date value) {
            addCriterionForJDBCDate("CHANGE_DATE <", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHANGE_DATE <=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateIn(List<Date> values) {
            addCriterionForJDBCDate("CHANGE_DATE in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CHANGE_DATE not in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHANGE_DATE between", value1, value2, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHANGE_DATE not between", value1, value2, "changeDate");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNull() {
            addCriterion("ORGANIZATION is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNotNull() {
            addCriterion("ORGANIZATION is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationEqualTo(String value) {
            addCriterion("ORGANIZATION =", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotEqualTo(String value) {
            addCriterion("ORGANIZATION <>", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThan(String value) {
            addCriterion("ORGANIZATION >", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION >=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThan(String value) {
            addCriterion("ORGANIZATION <", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION <=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLike(String value) {
            addCriterion("ORGANIZATION like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotLike(String value) {
            addCriterion("ORGANIZATION not like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationIn(List<String> values) {
            addCriterion("ORGANIZATION in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotIn(List<String> values) {
            addCriterion("ORGANIZATION not in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationBetween(String value1, String value2) {
            addCriterion("ORGANIZATION between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATION not between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewIsNull() {
            addCriterion("TASK_NUMBER_BA_NEW is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewIsNotNull() {
            addCriterion("TASK_NUMBER_BA_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA_NEW =", value, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA_NEW <>", value, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_BA_NEW >", value, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA_NEW >=", value, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewLessThan(Integer value) {
            addCriterion("TASK_NUMBER_BA_NEW <", value, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_BA_NEW <=", value, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_BA_NEW in", values, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_BA_NEW not in", values, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_BA_NEW between", value1, value2, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBaNewNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_BA_NEW not between", value1, value2, "taskNumberBaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewIsNull() {
            addCriterion("TASK_NUMBER_MA_NEW is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewIsNotNull() {
            addCriterion("TASK_NUMBER_MA_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA_NEW =", value, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA_NEW <>", value, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_MA_NEW >", value, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA_NEW >=", value, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewLessThan(Integer value) {
            addCriterion("TASK_NUMBER_MA_NEW <", value, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MA_NEW <=", value, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MA_NEW in", values, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MA_NEW not in", values, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MA_NEW between", value1, value2, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMaNewNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MA_NEW not between", value1, value2, "taskNumberMaNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewIsNull() {
            addCriterion("TASK_NUMBER_DO_NEW is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewIsNotNull() {
            addCriterion("TASK_NUMBER_DO_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO_NEW =", value, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO_NEW <>", value, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_DO_NEW >", value, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO_NEW >=", value, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewLessThan(Integer value) {
            addCriterion("TASK_NUMBER_DO_NEW <", value, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_DO_NEW <=", value, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_DO_NEW in", values, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_DO_NEW not in", values, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_DO_NEW between", value1, value2, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberDoNewNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_DO_NEW not between", value1, value2, "taskNumberDoNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewIsNull() {
            addCriterion("TASK_NUMBER_SUM_NEW is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewIsNotNull() {
            addCriterion("TASK_NUMBER_SUM_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM_NEW =", value, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM_NEW <>", value, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_SUM_NEW >", value, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM_NEW >=", value, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewLessThan(Integer value) {
            addCriterion("TASK_NUMBER_SUM_NEW <", value, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_SUM_NEW <=", value, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_SUM_NEW in", values, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_SUM_NEW not in", values, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_SUM_NEW between", value1, value2, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberSumNewNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_SUM_NEW not between", value1, value2, "taskNumberSumNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewIsNull() {
            addCriterion("TASK_NUMBER_MAIL_NEW is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewIsNotNull() {
            addCriterion("TASK_NUMBER_MAIL_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL_NEW =", value, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL_NEW <>", value, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_MAIL_NEW >", value, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL_NEW >=", value, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewLessThan(Integer value) {
            addCriterion("TASK_NUMBER_MAIL_NEW <", value, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_MAIL_NEW <=", value, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MAIL_NEW in", values, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_MAIL_NEW not in", values, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MAIL_NEW between", value1, value2, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberMailNewNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_MAIL_NEW not between", value1, value2, "taskNumberMailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewIsNull() {
            addCriterion("TASK_NUMBER_FEMAIL_NEW is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewIsNotNull() {
            addCriterion("TASK_NUMBER_FEMAIL_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW =", value, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewNotEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW <>", value, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewGreaterThan(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW >", value, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW >=", value, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewLessThan(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW <", value, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW <=", value, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW in", values, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewNotIn(List<Integer> values) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW not in", values, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW between", value1, value2, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andTaskNumberFemailNewNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_NUMBER_FEMAIL_NEW not between", value1, value2, "taskNumberFemailNew");
            return (Criteria) this;
        }

        public Criteria andBigCenterIsNull() {
            addCriterion("BIG_CENTER is null");
            return (Criteria) this;
        }

        public Criteria andBigCenterIsNotNull() {
            addCriterion("BIG_CENTER is not null");
            return (Criteria) this;
        }

        public Criteria andBigCenterEqualTo(String value) {
            addCriterion("BIG_CENTER =", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterNotEqualTo(String value) {
            addCriterion("BIG_CENTER <>", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterGreaterThan(String value) {
            addCriterion("BIG_CENTER >", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterGreaterThanOrEqualTo(String value) {
            addCriterion("BIG_CENTER >=", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterLessThan(String value) {
            addCriterion("BIG_CENTER <", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterLessThanOrEqualTo(String value) {
            addCriterion("BIG_CENTER <=", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterLike(String value) {
            addCriterion("BIG_CENTER like", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterNotLike(String value) {
            addCriterion("BIG_CENTER not like", value, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterIn(List<String> values) {
            addCriterion("BIG_CENTER in", values, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterNotIn(List<String> values) {
            addCriterion("BIG_CENTER not in", values, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterBetween(String value1, String value2) {
            addCriterion("BIG_CENTER between", value1, value2, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andBigCenterNotBetween(String value1, String value2) {
            addCriterion("BIG_CENTER not between", value1, value2, "bigCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterIsNull() {
            addCriterion("SMALL_CENTER is null");
            return (Criteria) this;
        }

        public Criteria andSmallCenterIsNotNull() {
            addCriterion("SMALL_CENTER is not null");
            return (Criteria) this;
        }

        public Criteria andSmallCenterEqualTo(String value) {
            addCriterion("SMALL_CENTER =", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterNotEqualTo(String value) {
            addCriterion("SMALL_CENTER <>", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterGreaterThan(String value) {
            addCriterion("SMALL_CENTER >", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterGreaterThanOrEqualTo(String value) {
            addCriterion("SMALL_CENTER >=", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterLessThan(String value) {
            addCriterion("SMALL_CENTER <", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterLessThanOrEqualTo(String value) {
            addCriterion("SMALL_CENTER <=", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterLike(String value) {
            addCriterion("SMALL_CENTER like", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterNotLike(String value) {
            addCriterion("SMALL_CENTER not like", value, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterIn(List<String> values) {
            addCriterion("SMALL_CENTER in", values, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterNotIn(List<String> values) {
            addCriterion("SMALL_CENTER not in", values, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterBetween(String value1, String value2) {
            addCriterion("SMALL_CENTER between", value1, value2, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterNotBetween(String value1, String value2) {
            addCriterion("SMALL_CENTER not between", value1, value2, "smallCenter");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("DEPARTMENT is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("DEPARTMENT is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("DEPARTMENT =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("DEPARTMENT <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("DEPARTMENT >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("DEPARTMENT <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("DEPARTMENT like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("DEPARTMENT not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("DEPARTMENT in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("DEPARTMENT not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("DEPARTMENT between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENT not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andBranchIsNull() {
            addCriterion("BRANCH is null");
            return (Criteria) this;
        }

        public Criteria andBranchIsNotNull() {
            addCriterion("BRANCH is not null");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotEqualTo(String value) {
            addCriterion("BRANCH <>", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThan(String value) {
            addCriterion("BRANCH >", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThanOrEqualTo(String value) {
            addCriterion("BRANCH >=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThan(String value) {
            addCriterion("BRANCH <", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThanOrEqualTo(String value) {
            addCriterion("BRANCH <=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLike(String value) {
            addCriterion("BRANCH like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotLike(String value) {
            addCriterion("BRANCH not like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchIn(List<String> values) {
            addCriterion("BRANCH in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotIn(List<String> values) {
            addCriterion("BRANCH not in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchBetween(String value1, String value2) {
            addCriterion("BRANCH between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotBetween(String value1, String value2) {
            addCriterion("BRANCH not between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("EDUCATION =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("EDUCATION <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("EDUCATION >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("EDUCATION <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("EDUCATION <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("EDUCATION like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("EDUCATION not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("EDUCATION in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("EDUCATION not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("EDUCATION between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("EDUCATION not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andSiteIdLikeInsensitive(String value) {
            addCriterion("upper(SITE_ID) like", value.toUpperCase(), "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteNameLikeInsensitive(String value) {
            addCriterion("upper(SITE_NAME) like", value.toUpperCase(), "siteName");
            return (Criteria) this;
        }

        public Criteria andPostIdLikeInsensitive(String value) {
            addCriterion("upper(POST_ID) like", value.toUpperCase(), "postId");
            return (Criteria) this;
        }

        public Criteria andPostNameLikeInsensitive(String value) {
            addCriterion("upper(POST_NAME) like", value.toUpperCase(), "postName");
            return (Criteria) this;
        }

        public Criteria andYearthLikeInsensitive(String value) {
            addCriterion("upper(YEARTH) like", value.toUpperCase(), "yearth");
            return (Criteria) this;
        }

        public Criteria andOrgNameLikeInsensitive(String value) {
            addCriterion("upper(ORG_NAME) like", value.toUpperCase(), "orgName");
            return (Criteria) this;
        }

        public Criteria andOrganizationLikeInsensitive(String value) {
            addCriterion("upper(ORGANIZATION) like", value.toUpperCase(), "organization");
            return (Criteria) this;
        }

        public Criteria andBigCenterLikeInsensitive(String value) {
            addCriterion("upper(BIG_CENTER) like", value.toUpperCase(), "bigCenter");
            return (Criteria) this;
        }

        public Criteria andSmallCenterLikeInsensitive(String value) {
            addCriterion("upper(SMALL_CENTER) like", value.toUpperCase(), "smallCenter");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikeInsensitive(String value) {
            addCriterion("upper(DEPARTMENT) like", value.toUpperCase(), "department");
            return (Criteria) this;
        }

        public Criteria andBranchLikeInsensitive(String value) {
            addCriterion("upper(BRANCH) like", value.toUpperCase(), "branch");
            return (Criteria) this;
        }

        public Criteria andEducationLikeInsensitive(String value) {
            addCriterion("upper(EDUCATION) like", value.toUpperCase(), "education");
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