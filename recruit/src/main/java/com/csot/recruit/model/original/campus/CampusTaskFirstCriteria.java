package com.csot.recruit.model.original.campus;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CampusTaskFirstCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CampusTaskFirstCriteria() {
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

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNull() {
            addCriterion("RESERVED_1 is null");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNotNull() {
            addCriterion("RESERVED_1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved1EqualTo(String value) {
            addCriterion("RESERVED_1 =", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotEqualTo(String value) {
            addCriterion("RESERVED_1 <>", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThan(String value) {
            addCriterion("RESERVED_1 >", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_1 >=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThan(String value) {
            addCriterion("RESERVED_1 <", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_1 <=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1Like(String value) {
            addCriterion("RESERVED_1 like", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotLike(String value) {
            addCriterion("RESERVED_1 not like", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1In(List<String> values) {
            addCriterion("RESERVED_1 in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotIn(List<String> values) {
            addCriterion("RESERVED_1 not in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1Between(String value1, String value2) {
            addCriterion("RESERVED_1 between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotBetween(String value1, String value2) {
            addCriterion("RESERVED_1 not between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNull() {
            addCriterion("RESERVED_2 is null");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNotNull() {
            addCriterion("RESERVED_2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved2EqualTo(String value) {
            addCriterion("RESERVED_2 =", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotEqualTo(String value) {
            addCriterion("RESERVED_2 <>", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThan(String value) {
            addCriterion("RESERVED_2 >", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_2 >=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThan(String value) {
            addCriterion("RESERVED_2 <", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_2 <=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2Like(String value) {
            addCriterion("RESERVED_2 like", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotLike(String value) {
            addCriterion("RESERVED_2 not like", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2In(List<String> values) {
            addCriterion("RESERVED_2 in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotIn(List<String> values) {
            addCriterion("RESERVED_2 not in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2Between(String value1, String value2) {
            addCriterion("RESERVED_2 between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotBetween(String value1, String value2) {
            addCriterion("RESERVED_2 not between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved3IsNull() {
            addCriterion("RESERVED_3 is null");
            return (Criteria) this;
        }

        public Criteria andReserved3IsNotNull() {
            addCriterion("RESERVED_3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved3EqualTo(String value) {
            addCriterion("RESERVED_3 =", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotEqualTo(String value) {
            addCriterion("RESERVED_3 <>", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3GreaterThan(String value) {
            addCriterion("RESERVED_3 >", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_3 >=", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3LessThan(String value) {
            addCriterion("RESERVED_3 <", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3LessThanOrEqualTo(String value) {
            addCriterion("RESERVED_3 <=", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3Like(String value) {
            addCriterion("RESERVED_3 like", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotLike(String value) {
            addCriterion("RESERVED_3 not like", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3In(List<String> values) {
            addCriterion("RESERVED_3 in", values, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotIn(List<String> values) {
            addCriterion("RESERVED_3 not in", values, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3Between(String value1, String value2) {
            addCriterion("RESERVED_3 between", value1, value2, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotBetween(String value1, String value2) {
            addCriterion("RESERVED_3 not between", value1, value2, "reserved3");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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

        public Criteria andJobFamilyIsNull() {
            addCriterion("JOB_FAMILY is null");
            return (Criteria) this;
        }

        public Criteria andJobFamilyIsNotNull() {
            addCriterion("JOB_FAMILY is not null");
            return (Criteria) this;
        }

        public Criteria andJobFamilyEqualTo(String value) {
            addCriterion("JOB_FAMILY =", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyNotEqualTo(String value) {
            addCriterion("JOB_FAMILY <>", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyGreaterThan(String value) {
            addCriterion("JOB_FAMILY >", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_FAMILY >=", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyLessThan(String value) {
            addCriterion("JOB_FAMILY <", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyLessThanOrEqualTo(String value) {
            addCriterion("JOB_FAMILY <=", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyLike(String value) {
            addCriterion("JOB_FAMILY like", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyNotLike(String value) {
            addCriterion("JOB_FAMILY not like", value, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyIn(List<String> values) {
            addCriterion("JOB_FAMILY in", values, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyNotIn(List<String> values) {
            addCriterion("JOB_FAMILY not in", values, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyBetween(String value1, String value2) {
            addCriterion("JOB_FAMILY between", value1, value2, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobFamilyNotBetween(String value1, String value2) {
            addCriterion("JOB_FAMILY not between", value1, value2, "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobClassIsNull() {
            addCriterion("JOB_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andJobClassIsNotNull() {
            addCriterion("JOB_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andJobClassEqualTo(String value) {
            addCriterion("JOB_CLASS =", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotEqualTo(String value) {
            addCriterion("JOB_CLASS <>", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassGreaterThan(String value) {
            addCriterion("JOB_CLASS >", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_CLASS >=", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassLessThan(String value) {
            addCriterion("JOB_CLASS <", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassLessThanOrEqualTo(String value) {
            addCriterion("JOB_CLASS <=", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassLike(String value) {
            addCriterion("JOB_CLASS like", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotLike(String value) {
            addCriterion("JOB_CLASS not like", value, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassIn(List<String> values) {
            addCriterion("JOB_CLASS in", values, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotIn(List<String> values) {
            addCriterion("JOB_CLASS not in", values, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassBetween(String value1, String value2) {
            addCriterion("JOB_CLASS between", value1, value2, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobClassNotBetween(String value1, String value2) {
            addCriterion("JOB_CLASS not between", value1, value2, "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassIsNull() {
            addCriterion("JOB_SUBCLASS is null");
            return (Criteria) this;
        }

        public Criteria andJobSubclassIsNotNull() {
            addCriterion("JOB_SUBCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andJobSubclassEqualTo(String value) {
            addCriterion("JOB_SUBCLASS =", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassNotEqualTo(String value) {
            addCriterion("JOB_SUBCLASS <>", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassGreaterThan(String value) {
            addCriterion("JOB_SUBCLASS >", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_SUBCLASS >=", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassLessThan(String value) {
            addCriterion("JOB_SUBCLASS <", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassLessThanOrEqualTo(String value) {
            addCriterion("JOB_SUBCLASS <=", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassLike(String value) {
            addCriterion("JOB_SUBCLASS like", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassNotLike(String value) {
            addCriterion("JOB_SUBCLASS not like", value, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassIn(List<String> values) {
            addCriterion("JOB_SUBCLASS in", values, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassNotIn(List<String> values) {
            addCriterion("JOB_SUBCLASS not in", values, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassBetween(String value1, String value2) {
            addCriterion("JOB_SUBCLASS between", value1, value2, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassNotBetween(String value1, String value2) {
            addCriterion("JOB_SUBCLASS not between", value1, value2, "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobDescribeIsNull() {
            addCriterion("JOB_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andJobDescribeIsNotNull() {
            addCriterion("JOB_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andJobDescribeEqualTo(String value) {
            addCriterion("JOB_DESCRIBE =", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeNotEqualTo(String value) {
            addCriterion("JOB_DESCRIBE <>", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeGreaterThan(String value) {
            addCriterion("JOB_DESCRIBE >", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_DESCRIBE >=", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeLessThan(String value) {
            addCriterion("JOB_DESCRIBE <", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeLessThanOrEqualTo(String value) {
            addCriterion("JOB_DESCRIBE <=", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeLike(String value) {
            addCriterion("JOB_DESCRIBE like", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeNotLike(String value) {
            addCriterion("JOB_DESCRIBE not like", value, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeIn(List<String> values) {
            addCriterion("JOB_DESCRIBE in", values, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeNotIn(List<String> values) {
            addCriterion("JOB_DESCRIBE not in", values, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeBetween(String value1, String value2) {
            addCriterion("JOB_DESCRIBE between", value1, value2, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andJobDescribeNotBetween(String value1, String value2) {
            addCriterion("JOB_DESCRIBE not between", value1, value2, "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andNightShiftIsNull() {
            addCriterion("NIGHT_SHIFT is null");
            return (Criteria) this;
        }

        public Criteria andNightShiftIsNotNull() {
            addCriterion("NIGHT_SHIFT is not null");
            return (Criteria) this;
        }

        public Criteria andNightShiftEqualTo(String value) {
            addCriterion("NIGHT_SHIFT =", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftNotEqualTo(String value) {
            addCriterion("NIGHT_SHIFT <>", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftGreaterThan(String value) {
            addCriterion("NIGHT_SHIFT >", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftGreaterThanOrEqualTo(String value) {
            addCriterion("NIGHT_SHIFT >=", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftLessThan(String value) {
            addCriterion("NIGHT_SHIFT <", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftLessThanOrEqualTo(String value) {
            addCriterion("NIGHT_SHIFT <=", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftLike(String value) {
            addCriterion("NIGHT_SHIFT like", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftNotLike(String value) {
            addCriterion("NIGHT_SHIFT not like", value, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftIn(List<String> values) {
            addCriterion("NIGHT_SHIFT in", values, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftNotIn(List<String> values) {
            addCriterion("NIGHT_SHIFT not in", values, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftBetween(String value1, String value2) {
            addCriterion("NIGHT_SHIFT between", value1, value2, "nightShift");
            return (Criteria) this;
        }

        public Criteria andNightShiftNotBetween(String value1, String value2) {
            addCriterion("NIGHT_SHIFT not between", value1, value2, "nightShift");
            return (Criteria) this;
        }

        public Criteria andDustFreeIsNull() {
            addCriterion("DUST_FREE is null");
            return (Criteria) this;
        }

        public Criteria andDustFreeIsNotNull() {
            addCriterion("DUST_FREE is not null");
            return (Criteria) this;
        }

        public Criteria andDustFreeEqualTo(String value) {
            addCriterion("DUST_FREE =", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeNotEqualTo(String value) {
            addCriterion("DUST_FREE <>", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeGreaterThan(String value) {
            addCriterion("DUST_FREE >", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeGreaterThanOrEqualTo(String value) {
            addCriterion("DUST_FREE >=", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeLessThan(String value) {
            addCriterion("DUST_FREE <", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeLessThanOrEqualTo(String value) {
            addCriterion("DUST_FREE <=", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeLike(String value) {
            addCriterion("DUST_FREE like", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeNotLike(String value) {
            addCriterion("DUST_FREE not like", value, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeIn(List<String> values) {
            addCriterion("DUST_FREE in", values, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeNotIn(List<String> values) {
            addCriterion("DUST_FREE not in", values, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeBetween(String value1, String value2) {
            addCriterion("DUST_FREE between", value1, value2, "dustFree");
            return (Criteria) this;
        }

        public Criteria andDustFreeNotBetween(String value1, String value2) {
            addCriterion("DUST_FREE not between", value1, value2, "dustFree");
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

        public Criteria andSpecialRequireIsNull() {
            addCriterion("SPECIAL_REQUIRE is null");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireIsNotNull() {
            addCriterion("SPECIAL_REQUIRE is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireEqualTo(String value) {
            addCriterion("SPECIAL_REQUIRE =", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotEqualTo(String value) {
            addCriterion("SPECIAL_REQUIRE <>", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireGreaterThan(String value) {
            addCriterion("SPECIAL_REQUIRE >", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIAL_REQUIRE >=", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireLessThan(String value) {
            addCriterion("SPECIAL_REQUIRE <", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireLessThanOrEqualTo(String value) {
            addCriterion("SPECIAL_REQUIRE <=", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireLike(String value) {
            addCriterion("SPECIAL_REQUIRE like", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotLike(String value) {
            addCriterion("SPECIAL_REQUIRE not like", value, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireIn(List<String> values) {
            addCriterion("SPECIAL_REQUIRE in", values, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotIn(List<String> values) {
            addCriterion("SPECIAL_REQUIRE not in", values, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireBetween(String value1, String value2) {
            addCriterion("SPECIAL_REQUIRE between", value1, value2, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireNotBetween(String value1, String value2) {
            addCriterion("SPECIAL_REQUIRE not between", value1, value2, "specialRequire");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorIsNull() {
            addCriterion("PREFERRED_MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorIsNotNull() {
            addCriterion("PREFERRED_MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorEqualTo(String value) {
            addCriterion("PREFERRED_MAJOR =", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorNotEqualTo(String value) {
            addCriterion("PREFERRED_MAJOR <>", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorGreaterThan(String value) {
            addCriterion("PREFERRED_MAJOR >", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorGreaterThanOrEqualTo(String value) {
            addCriterion("PREFERRED_MAJOR >=", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorLessThan(String value) {
            addCriterion("PREFERRED_MAJOR <", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorLessThanOrEqualTo(String value) {
            addCriterion("PREFERRED_MAJOR <=", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorLike(String value) {
            addCriterion("PREFERRED_MAJOR like", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorNotLike(String value) {
            addCriterion("PREFERRED_MAJOR not like", value, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorIn(List<String> values) {
            addCriterion("PREFERRED_MAJOR in", values, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorNotIn(List<String> values) {
            addCriterion("PREFERRED_MAJOR not in", values, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorBetween(String value1, String value2) {
            addCriterion("PREFERRED_MAJOR between", value1, value2, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorNotBetween(String value1, String value2) {
            addCriterion("PREFERRED_MAJOR not between", value1, value2, "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorIsNull() {
            addCriterion("ALTERNATIVE_MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorIsNotNull() {
            addCriterion("ALTERNATIVE_MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorEqualTo(String value) {
            addCriterion("ALTERNATIVE_MAJOR =", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorNotEqualTo(String value) {
            addCriterion("ALTERNATIVE_MAJOR <>", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorGreaterThan(String value) {
            addCriterion("ALTERNATIVE_MAJOR >", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorGreaterThanOrEqualTo(String value) {
            addCriterion("ALTERNATIVE_MAJOR >=", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorLessThan(String value) {
            addCriterion("ALTERNATIVE_MAJOR <", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorLessThanOrEqualTo(String value) {
            addCriterion("ALTERNATIVE_MAJOR <=", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorLike(String value) {
            addCriterion("ALTERNATIVE_MAJOR like", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorNotLike(String value) {
            addCriterion("ALTERNATIVE_MAJOR not like", value, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorIn(List<String> values) {
            addCriterion("ALTERNATIVE_MAJOR in", values, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorNotIn(List<String> values) {
            addCriterion("ALTERNATIVE_MAJOR not in", values, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorBetween(String value1, String value2) {
            addCriterion("ALTERNATIVE_MAJOR between", value1, value2, "alternativeMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorNotBetween(String value1, String value2) {
            addCriterion("ALTERNATIVE_MAJOR not between", value1, value2, "alternativeMajor");
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

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andReserved1LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_1) like", value.toUpperCase(), "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved2LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_2) like", value.toUpperCase(), "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved3LikeInsensitive(String value) {
            addCriterion("upper(RESERVED_3) like", value.toUpperCase(), "reserved3");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(STATUS) like", value.toUpperCase(), "status");
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

        public Criteria andJobFamilyLikeInsensitive(String value) {
            addCriterion("upper(JOB_FAMILY) like", value.toUpperCase(), "jobFamily");
            return (Criteria) this;
        }

        public Criteria andJobClassLikeInsensitive(String value) {
            addCriterion("upper(JOB_CLASS) like", value.toUpperCase(), "jobClass");
            return (Criteria) this;
        }

        public Criteria andJobSubclassLikeInsensitive(String value) {
            addCriterion("upper(JOB_SUBCLASS) like", value.toUpperCase(), "jobSubclass");
            return (Criteria) this;
        }

        public Criteria andJobDescribeLikeInsensitive(String value) {
            addCriterion("upper(JOB_DESCRIBE) like", value.toUpperCase(), "jobDescribe");
            return (Criteria) this;
        }

        public Criteria andNightShiftLikeInsensitive(String value) {
            addCriterion("upper(NIGHT_SHIFT) like", value.toUpperCase(), "nightShift");
            return (Criteria) this;
        }

        public Criteria andDustFreeLikeInsensitive(String value) {
            addCriterion("upper(DUST_FREE) like", value.toUpperCase(), "dustFree");
            return (Criteria) this;
        }

        public Criteria andSpecialRequireLikeInsensitive(String value) {
            addCriterion("upper(SPECIAL_REQUIRE) like", value.toUpperCase(), "specialRequire");
            return (Criteria) this;
        }

        public Criteria andPreferredMajorLikeInsensitive(String value) {
            addCriterion("upper(PREFERRED_MAJOR) like", value.toUpperCase(), "preferredMajor");
            return (Criteria) this;
        }

        public Criteria andAlternativeMajorLikeInsensitive(String value) {
            addCriterion("upper(ALTERNATIVE_MAJOR) like", value.toUpperCase(), "alternativeMajor");
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