package com.csot.recruit.model.resume;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class WorkExperienceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WorkExperienceCriteria() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("COMPANY_NAME =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("COMPANY_NAME <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("COMPANY_NAME >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("COMPANY_NAME <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("COMPANY_NAME like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("COMPANY_NAME not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("COMPANY_NAME in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("COMPANY_NAME not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnIsNull() {
            addCriterion("COMPANY_NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnIsNotNull() {
            addCriterion("COMPANY_NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnEqualTo(String value) {
            addCriterion("COMPANY_NAME_EN =", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnNotEqualTo(String value) {
            addCriterion("COMPANY_NAME_EN <>", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnGreaterThan(String value) {
            addCriterion("COMPANY_NAME_EN >", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME_EN >=", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnLessThan(String value) {
            addCriterion("COMPANY_NAME_EN <", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME_EN <=", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnLike(String value) {
            addCriterion("COMPANY_NAME_EN like", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnNotLike(String value) {
            addCriterion("COMPANY_NAME_EN not like", value, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnIn(List<String> values) {
            addCriterion("COMPANY_NAME_EN in", values, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnNotIn(List<String> values) {
            addCriterion("COMPANY_NAME_EN not in", values, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME_EN between", value1, value2, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME_EN not between", value1, value2, "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andJobStartDateIsNull() {
            addCriterion("JOB_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andJobStartDateIsNotNull() {
            addCriterion("JOB_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andJobStartDateEqualTo(Date value) {
            addCriterion("JOB_START_DATE =", value, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateNotEqualTo(Date value) {
            addCriterion("JOB_START_DATE <>", value, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateGreaterThan(Date value) {
            addCriterion("JOB_START_DATE >", value, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_START_DATE >=", value, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateLessThan(Date value) {
            addCriterion("JOB_START_DATE <", value, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateLessThanOrEqualTo(Date value) {
            addCriterion("JOB_START_DATE <=", value, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateIn(List<Date> values) {
            addCriterion("JOB_START_DATE in", values, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateNotIn(List<Date> values) {
            addCriterion("JOB_START_DATE not in", values, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateBetween(Date value1, Date value2) {
            addCriterion("JOB_START_DATE between", value1, value2, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobStartDateNotBetween(Date value1, Date value2) {
            addCriterion("JOB_START_DATE not between", value1, value2, "jobStartDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateIsNull() {
            addCriterion("JOB_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andJobEndDateIsNotNull() {
            addCriterion("JOB_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andJobEndDateEqualTo(Date value) {
            addCriterion("JOB_END_DATE =", value, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateNotEqualTo(Date value) {
            addCriterion("JOB_END_DATE <>", value, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateGreaterThan(Date value) {
            addCriterion("JOB_END_DATE >", value, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_END_DATE >=", value, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateLessThan(Date value) {
            addCriterion("JOB_END_DATE <", value, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateLessThanOrEqualTo(Date value) {
            addCriterion("JOB_END_DATE <=", value, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateIn(List<Date> values) {
            addCriterion("JOB_END_DATE in", values, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateNotIn(List<Date> values) {
            addCriterion("JOB_END_DATE not in", values, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateBetween(Date value1, Date value2) {
            addCriterion("JOB_END_DATE between", value1, value2, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andJobEndDateNotBetween(Date value1, Date value2) {
            addCriterion("JOB_END_DATE not between", value1, value2, "jobEndDate");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("INDUSTRY is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("INDUSTRY is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("INDUSTRY =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("INDUSTRY <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("INDUSTRY >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("INDUSTRY <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("INDUSTRY like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("INDUSTRY not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("INDUSTRY in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("INDUSTRY not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("INDUSTRY between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("POSITION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("POSITION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("POSITION_NAME =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("POSITION_NAME <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("POSITION_NAME >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION_NAME >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("POSITION_NAME <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("POSITION_NAME <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("POSITION_NAME like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("POSITION_NAME not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("POSITION_NAME in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("POSITION_NAME not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("POSITION_NAME between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("POSITION_NAME not between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnIsNull() {
            addCriterion("POSITION_NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnIsNotNull() {
            addCriterion("POSITION_NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnEqualTo(String value) {
            addCriterion("POSITION_NAME_EN =", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnNotEqualTo(String value) {
            addCriterion("POSITION_NAME_EN <>", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnGreaterThan(String value) {
            addCriterion("POSITION_NAME_EN >", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION_NAME_EN >=", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnLessThan(String value) {
            addCriterion("POSITION_NAME_EN <", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnLessThanOrEqualTo(String value) {
            addCriterion("POSITION_NAME_EN <=", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnLike(String value) {
            addCriterion("POSITION_NAME_EN like", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnNotLike(String value) {
            addCriterion("POSITION_NAME_EN not like", value, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnIn(List<String> values) {
            addCriterion("POSITION_NAME_EN in", values, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnNotIn(List<String> values) {
            addCriterion("POSITION_NAME_EN not in", values, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnBetween(String value1, String value2) {
            addCriterion("POSITION_NAME_EN between", value1, value2, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnNotBetween(String value1, String value2) {
            addCriterion("POSITION_NAME_EN not between", value1, value2, "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIsNull() {
            addCriterion("WORKPLACE is null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIsNotNull() {
            addCriterion("WORKPLACE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkplaceEqualTo(String value) {
            addCriterion("WORKPLACE =", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotEqualTo(String value) {
            addCriterion("WORKPLACE <>", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThan(String value) {
            addCriterion("WORKPLACE >", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("WORKPLACE >=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThan(String value) {
            addCriterion("WORKPLACE <", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLessThanOrEqualTo(String value) {
            addCriterion("WORKPLACE <=", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLike(String value) {
            addCriterion("WORKPLACE like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotLike(String value) {
            addCriterion("WORKPLACE not like", value, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceIn(List<String> values) {
            addCriterion("WORKPLACE in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotIn(List<String> values) {
            addCriterion("WORKPLACE not in", values, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceBetween(String value1, String value2) {
            addCriterion("WORKPLACE between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andWorkplaceNotBetween(String value1, String value2) {
            addCriterion("WORKPLACE not between", value1, value2, "workplace");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNull() {
            addCriterion("COMPANY_NATURE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNotNull() {
            addCriterion("COMPANY_NATURE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureEqualTo(String value) {
            addCriterion("COMPANY_NATURE =", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotEqualTo(String value) {
            addCriterion("COMPANY_NATURE <>", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThan(String value) {
            addCriterion("COMPANY_NATURE >", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NATURE >=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThan(String value) {
            addCriterion("COMPANY_NATURE <", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NATURE <=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLike(String value) {
            addCriterion("COMPANY_NATURE like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotLike(String value) {
            addCriterion("COMPANY_NATURE not like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIn(List<String> values) {
            addCriterion("COMPANY_NATURE in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotIn(List<String> values) {
            addCriterion("COMPANY_NATURE not in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureBetween(String value1, String value2) {
            addCriterion("COMPANY_NATURE between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NATURE not between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andJobDutyIsNull() {
          addCriterion("JOB_DUTY is null");
          return (Criteria) this;
      }

      public Criteria andJobDutyIsNotNull() {
          addCriterion("JOB_DUTY is not null");
          return (Criteria) this;
      }

      public Criteria andJobDutyEqualTo(String value) {
          addCriterion("JOB_DUTY =", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyNotEqualTo(String value) {
          addCriterion("JOB_DUTY <>", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyGreaterThan(String value) {
          addCriterion("JOB_DUTY >", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyGreaterThanOrEqualTo(String value) {
          addCriterion("JOB_DUTY >=", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyLessThan(String value) {
          addCriterion("JOB_DUTY <", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyLessThanOrEqualTo(String value) {
          addCriterion("JOB_DUTY <=", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyLike(String value) {
          addCriterion("JOB_DUTY like", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyNotLike(String value) {
          addCriterion("JOB_DUTY not like", value, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyIn(List<String> values) {
          addCriterion("JOB_DUTY in", values, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyNotIn(List<String> values) {
          addCriterion("JOB_DUTY not in", values, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyBetween(String value1, String value2) {
          addCriterion("JOB_DUTY between", value1, value2, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyNotBetween(String value1, String value2) {
          addCriterion("JOB_DUTY not between", value1, value2, "jobDuty");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnIsNull() {
          addCriterion("JOB_DUTY_EN is null");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnIsNotNull() {
          addCriterion("JOB_DUTY_EN is not null");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnEqualTo(String value) {
          addCriterion("JOB_DUTY_EN =", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnNotEqualTo(String value) {
          addCriterion("JOB_DUTY_EN <>", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnGreaterThan(String value) {
          addCriterion("JOB_DUTY_EN >", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnGreaterThanOrEqualTo(String value) {
          addCriterion("JOB_DUTY_EN >=", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnLessThan(String value) {
          addCriterion("JOB_DUTY_EN <", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnLessThanOrEqualTo(String value) {
          addCriterion("JOB_DUTY_EN <=", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnLike(String value) {
          addCriterion("JOB_DUTY_EN like", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnNotLike(String value) {
          addCriterion("JOB_DUTY_EN not like", value, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnIn(List<String> values) {
          addCriterion("JOB_DUTY_EN in", values, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnNotIn(List<String> values) {
          addCriterion("JOB_DUTY_EN not in", values, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnBetween(String value1, String value2) {
          addCriterion("JOB_DUTY_EN between", value1, value2, "jobDutyEn");
          return (Criteria) this;
      }

      public Criteria andJobDutyEnNotBetween(String value1, String value2) {
          addCriterion("JOB_DUTY_EN not between", value1, value2, "jobDutyEn");
          return (Criteria) this;
      }
        
        public Criteria andDebrieferIsNull() {
            addCriterion("DEBRIEFER is null");
            return (Criteria) this;
        }

        public Criteria andDebrieferIsNotNull() {
            addCriterion("DEBRIEFER is not null");
            return (Criteria) this;
        }

        public Criteria andDebrieferEqualTo(String value) {
            addCriterion("DEBRIEFER =", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferNotEqualTo(String value) {
            addCriterion("DEBRIEFER <>", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferGreaterThan(String value) {
            addCriterion("DEBRIEFER >", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferGreaterThanOrEqualTo(String value) {
            addCriterion("DEBRIEFER >=", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferLessThan(String value) {
            addCriterion("DEBRIEFER <", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferLessThanOrEqualTo(String value) {
            addCriterion("DEBRIEFER <=", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferLike(String value) {
            addCriterion("DEBRIEFER like", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferNotLike(String value) {
            addCriterion("DEBRIEFER not like", value, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferIn(List<String> values) {
            addCriterion("DEBRIEFER in", values, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferNotIn(List<String> values) {
            addCriterion("DEBRIEFER not in", values, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferBetween(String value1, String value2) {
            addCriterion("DEBRIEFER between", value1, value2, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferNotBetween(String value1, String value2) {
            addCriterion("DEBRIEFER not between", value1, value2, "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnIsNull() {
            addCriterion("DEBRIEFER_EN is null");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnIsNotNull() {
            addCriterion("DEBRIEFER_EN is not null");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnEqualTo(String value) {
            addCriterion("DEBRIEFER_EN =", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnNotEqualTo(String value) {
            addCriterion("DEBRIEFER_EN <>", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnGreaterThan(String value) {
            addCriterion("DEBRIEFER_EN >", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnGreaterThanOrEqualTo(String value) {
            addCriterion("DEBRIEFER_EN >=", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnLessThan(String value) {
            addCriterion("DEBRIEFER_EN <", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnLessThanOrEqualTo(String value) {
            addCriterion("DEBRIEFER_EN <=", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnLike(String value) {
            addCriterion("DEBRIEFER_EN like", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnNotLike(String value) {
            addCriterion("DEBRIEFER_EN not like", value, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnIn(List<String> values) {
            addCriterion("DEBRIEFER_EN in", values, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnNotIn(List<String> values) {
            addCriterion("DEBRIEFER_EN not in", values, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnBetween(String value1, String value2) {
            addCriterion("DEBRIEFER_EN between", value1, value2, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnNotBetween(String value1, String value2) {
            addCriterion("DEBRIEFER_EN not between", value1, value2, "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andSubordinateIsNull() {
            addCriterion("SUBORDINATE is null");
            return (Criteria) this;
        }

        public Criteria andSubordinateIsNotNull() {
            addCriterion("SUBORDINATE is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinateEqualTo(BigDecimal value) {
            addCriterion("SUBORDINATE =", value, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateNotEqualTo(BigDecimal value) {
            addCriterion("SUBORDINATE <>", value, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateGreaterThan(BigDecimal value) {
            addCriterion("SUBORDINATE >", value, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUBORDINATE >=", value, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateLessThan(BigDecimal value) {
            addCriterion("SUBORDINATE <", value, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUBORDINATE <=", value, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateIn(List<BigDecimal> values) {
            addCriterion("SUBORDINATE in", values, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateNotIn(List<BigDecimal> values) {
            addCriterion("SUBORDINATE not in", values, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUBORDINATE between", value1, value2, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSubordinateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUBORDINATE not between", value1, value2, "subordinate");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("SALARY is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("SALARY is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("SALARY =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("SALARY <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("SALARY >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("SALARY >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("SALARY <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("SALARY <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("SALARY like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("SALARY not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("SALARY in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("SALARY not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("SALARY between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("SALARY not between", value1, value2, "salary");
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

        public Criteria andWorkPerformaceIsNull() {
            addCriterion("WORK_PERFORMACE is null");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceIsNotNull() {
            addCriterion("WORK_PERFORMACE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEqualTo(String value) {
            addCriterion("WORK_PERFORMACE =", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceNotEqualTo(String value) {
            addCriterion("WORK_PERFORMACE <>", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceGreaterThan(String value) {
            addCriterion("WORK_PERFORMACE >", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_PERFORMACE >=", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceLessThan(String value) {
            addCriterion("WORK_PERFORMACE <", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceLessThanOrEqualTo(String value) {
            addCriterion("WORK_PERFORMACE <=", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceLike(String value) {
            addCriterion("WORK_PERFORMACE like", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceNotLike(String value) {
            addCriterion("WORK_PERFORMACE not like", value, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceIn(List<String> values) {
            addCriterion("WORK_PERFORMACE in", values, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceNotIn(List<String> values) {
            addCriterion("WORK_PERFORMACE not in", values, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceBetween(String value1, String value2) {
            addCriterion("WORK_PERFORMACE between", value1, value2, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceNotBetween(String value1, String value2) {
            addCriterion("WORK_PERFORMACE not between", value1, value2, "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnIsNull() {
            addCriterion("WORK_PERFORMACE_EN is null");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnIsNotNull() {
            addCriterion("WORK_PERFORMACE_EN is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnEqualTo(String value) {
            addCriterion("WORK_PERFORMACE_EN =", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnNotEqualTo(String value) {
            addCriterion("WORK_PERFORMACE_EN <>", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnGreaterThan(String value) {
            addCriterion("WORK_PERFORMACE_EN >", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_PERFORMACE_EN >=", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnLessThan(String value) {
            addCriterion("WORK_PERFORMACE_EN <", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnLessThanOrEqualTo(String value) {
            addCriterion("WORK_PERFORMACE_EN <=", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnLike(String value) {
            addCriterion("WORK_PERFORMACE_EN like", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnNotLike(String value) {
            addCriterion("WORK_PERFORMACE_EN not like", value, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnIn(List<String> values) {
            addCriterion("WORK_PERFORMACE_EN in", values, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnNotIn(List<String> values) {
            addCriterion("WORK_PERFORMACE_EN not in", values, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnBetween(String value1, String value2) {
            addCriterion("WORK_PERFORMACE_EN between", value1, value2, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnNotBetween(String value1, String value2) {
            addCriterion("WORK_PERFORMACE_EN not between", value1, value2, "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNull() {
            addCriterion("RESUME_ID is null");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNotNull() {
            addCriterion("RESUME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResumeIdEqualTo(String value) {
            addCriterion("RESUME_ID =", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotEqualTo(String value) {
            addCriterion("RESUME_ID <>", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThan(String value) {
            addCriterion("RESUME_ID >", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThanOrEqualTo(String value) {
            addCriterion("RESUME_ID >=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThan(String value) {
            addCriterion("RESUME_ID <", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThanOrEqualTo(String value) {
            addCriterion("RESUME_ID <=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLike(String value) {
            addCriterion("RESUME_ID like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotLike(String value) {
            addCriterion("RESUME_ID not like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdIn(List<String> values) {
            addCriterion("RESUME_ID in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotIn(List<String> values) {
            addCriterion("RESUME_ID not in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdBetween(String value1, String value2) {
            addCriterion("RESUME_ID between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotBetween(String value1, String value2) {
            addCriterion("RESUME_ID not between", value1, value2, "resumeId");
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

        public Criteria andSeniorityIsNull() {
            addCriterion("SENIORITY is null");
            return (Criteria) this;
        }

        public Criteria andSeniorityIsNotNull() {
            addCriterion("SENIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andSeniorityEqualTo(String value) {
            addCriterion("SENIORITY =", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotEqualTo(String value) {
            addCriterion("SENIORITY <>", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityGreaterThan(String value) {
            addCriterion("SENIORITY >", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityGreaterThanOrEqualTo(String value) {
            addCriterion("SENIORITY >=", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLessThan(String value) {
            addCriterion("SENIORITY <", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLessThanOrEqualTo(String value) {
            addCriterion("SENIORITY <=", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLike(String value) {
            addCriterion("SENIORITY like", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotLike(String value) {
            addCriterion("SENIORITY not like", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityIn(List<String> values) {
            addCriterion("SENIORITY in", values, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotIn(List<String> values) {
            addCriterion("SENIORITY not in", values, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityBetween(String value1, String value2) {
            addCriterion("SENIORITY between", value1, value2, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotBetween(String value1, String value2) {
            addCriterion("SENIORITY not between", value1, value2, "seniority");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNull() {
            addCriterion("LEAVE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNotNull() {
            addCriterion("LEAVE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonEqualTo(String value) {
            addCriterion("LEAVE_REASON =", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotEqualTo(String value) {
            addCriterion("LEAVE_REASON <>", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThan(String value) {
            addCriterion("LEAVE_REASON >", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThanOrEqualTo(String value) {
            addCriterion("LEAVE_REASON >=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThan(String value) {
            addCriterion("LEAVE_REASON <", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThanOrEqualTo(String value) {
            addCriterion("LEAVE_REASON <=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLike(String value) {
            addCriterion("LEAVE_REASON like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotLike(String value) {
            addCriterion("LEAVE_REASON not like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIn(List<String> values) {
            addCriterion("LEAVE_REASON in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotIn(List<String> values) {
            addCriterion("LEAVE_REASON not in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonBetween(String value1, String value2) {
            addCriterion("LEAVE_REASON between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotBetween(String value1, String value2) {
            addCriterion("LEAVE_REASON not between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andReterenceIsNull() {
            addCriterion("RETERENCE is null");
            return (Criteria) this;
        }

        public Criteria andReterenceIsNotNull() {
            addCriterion("RETERENCE is not null");
            return (Criteria) this;
        }

        public Criteria andReterenceEqualTo(String value) {
            addCriterion("RETERENCE =", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotEqualTo(String value) {
            addCriterion("RETERENCE <>", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceGreaterThan(String value) {
            addCriterion("RETERENCE >", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceGreaterThanOrEqualTo(String value) {
            addCriterion("RETERENCE >=", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceLessThan(String value) {
            addCriterion("RETERENCE <", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceLessThanOrEqualTo(String value) {
            addCriterion("RETERENCE <=", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceLike(String value) {
            addCriterion("RETERENCE like", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotLike(String value) {
            addCriterion("RETERENCE not like", value, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceIn(List<String> values) {
            addCriterion("RETERENCE in", values, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotIn(List<String> values) {
            addCriterion("RETERENCE not in", values, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceBetween(String value1, String value2) {
            addCriterion("RETERENCE between", value1, value2, "reterence");
            return (Criteria) this;
        }

        public Criteria andReterenceNotBetween(String value1, String value2) {
            addCriterion("RETERENCE not between", value1, value2, "reterence");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNull() {
            addCriterion("RELATIONSHIP is null");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNotNull() {
            addCriterion("RELATIONSHIP is not null");
            return (Criteria) this;
        }

        public Criteria andRelationshipEqualTo(String value) {
            addCriterion("RELATIONSHIP =", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotEqualTo(String value) {
            addCriterion("RELATIONSHIP <>", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThan(String value) {
            addCriterion("RELATIONSHIP >", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIONSHIP >=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThan(String value) {
            addCriterion("RELATIONSHIP <", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThanOrEqualTo(String value) {
            addCriterion("RELATIONSHIP <=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLike(String value) {
            addCriterion("RELATIONSHIP like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotLike(String value) {
            addCriterion("RELATIONSHIP not like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipIn(List<String> values) {
            addCriterion("RELATIONSHIP in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotIn(List<String> values) {
            addCriterion("RELATIONSHIP not in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipBetween(String value1, String value2) {
            addCriterion("RELATIONSHIP between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotBetween(String value1, String value2) {
            addCriterion("RELATIONSHIP not between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneIsNull() {
            addCriterion("RETERENCE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneIsNotNull() {
            addCriterion("RETERENCE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneEqualTo(String value) {
            addCriterion("RETERENCE_PHONE =", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotEqualTo(String value) {
            addCriterion("RETERENCE_PHONE <>", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneGreaterThan(String value) {
            addCriterion("RETERENCE_PHONE >", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("RETERENCE_PHONE >=", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLessThan(String value) {
            addCriterion("RETERENCE_PHONE <", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLessThanOrEqualTo(String value) {
            addCriterion("RETERENCE_PHONE <=", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLike(String value) {
            addCriterion("RETERENCE_PHONE like", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotLike(String value) {
            addCriterion("RETERENCE_PHONE not like", value, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneIn(List<String> values) {
            addCriterion("RETERENCE_PHONE in", values, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotIn(List<String> values) {
            addCriterion("RETERENCE_PHONE not in", values, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneBetween(String value1, String value2) {
            addCriterion("RETERENCE_PHONE between", value1, value2, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneNotBetween(String value1, String value2) {
            addCriterion("RETERENCE_PHONE not between", value1, value2, "reterencePhone");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLikeInsensitive(String value) {
            addCriterion("upper(COMPANY_NAME) like", value.toUpperCase(), "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEnLikeInsensitive(String value) {
            addCriterion("upper(COMPANY_NAME_EN) like", value.toUpperCase(), "companyNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryLikeInsensitive(String value) {
            addCriterion("upper(INDUSTRY) like", value.toUpperCase(), "industry");
            return (Criteria) this;
        }

        public Criteria andPositionNameLikeInsensitive(String value) {
            addCriterion("upper(POSITION_NAME) like", value.toUpperCase(), "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameEnLikeInsensitive(String value) {
            addCriterion("upper(POSITION_NAME_EN) like", value.toUpperCase(), "positionNameEn");
            return (Criteria) this;
        }

        public Criteria andWorkplaceLikeInsensitive(String value) {
            addCriterion("upper(WORKPLACE) like", value.toUpperCase(), "workplace");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLikeInsensitive(String value) {
            addCriterion("upper(COMPANY_NATURE) like", value.toUpperCase(), "companyNature");
            return (Criteria) this;
        }

        public Criteria andDebrieferLikeInsensitive(String value) {
            addCriterion("upper(DEBRIEFER) like", value.toUpperCase(), "debriefer");
            return (Criteria) this;
        }

        public Criteria andDebrieferEnLikeInsensitive(String value) {
            addCriterion("upper(DEBRIEFER_EN) like", value.toUpperCase(), "debrieferEn");
            return (Criteria) this;
        }

        public Criteria andSalaryLikeInsensitive(String value) {
            addCriterion("upper(SALARY) like", value.toUpperCase(), "salary");
            return (Criteria) this;
        }

        public Criteria andCurrencyLikeInsensitive(String value) {
            addCriterion("upper(CURRENCY) like", value.toUpperCase(), "currency");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceLikeInsensitive(String value) {
            addCriterion("upper(WORK_PERFORMACE) like", value.toUpperCase(), "workPerformace");
            return (Criteria) this;
        }

        public Criteria andWorkPerformaceEnLikeInsensitive(String value) {
            addCriterion("upper(WORK_PERFORMACE_EN) like", value.toUpperCase(), "workPerformaceEn");
            return (Criteria) this;
        }

        public Criteria andResumeIdLikeInsensitive(String value) {
            addCriterion("upper(RESUME_ID) like", value.toUpperCase(), "resumeId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikeInsensitive(String value) {
            addCriterion("upper(DEPARTMENT) like", value.toUpperCase(), "department");
            return (Criteria) this;
        }

        public Criteria andSeniorityLikeInsensitive(String value) {
            addCriterion("upper(SENIORITY) like", value.toUpperCase(), "seniority");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLikeInsensitive(String value) {
            addCriterion("upper(LEAVE_REASON) like", value.toUpperCase(), "leaveReason");
            return (Criteria) this;
        }

        public Criteria andReterenceLikeInsensitive(String value) {
            addCriterion("upper(RETERENCE) like", value.toUpperCase(), "reterence");
            return (Criteria) this;
        }

        public Criteria andRelationshipLikeInsensitive(String value) {
            addCriterion("upper(RELATIONSHIP) like", value.toUpperCase(), "relationship");
            return (Criteria) this;
        }

        public Criteria andReterencePhoneLikeInsensitive(String value) {
            addCriterion("upper(RETERENCE_PHONE) like", value.toUpperCase(), "reterencePhone");
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