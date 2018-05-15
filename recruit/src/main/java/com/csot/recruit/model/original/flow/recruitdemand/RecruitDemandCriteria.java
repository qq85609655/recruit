package com.csot.recruit.model.original.flow.recruitdemand;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RecruitDemandCriteria {
  protected String orderByClause;

  protected boolean distinct;

  protected String userId;

  protected String userCode;

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  protected List<Criteria> oredCriteria;

  public Boolean isOredCriteriaNull() {
    if (oredCriteria.size() == 0) {
      return true;
    }
    for (Criteria criteria : oredCriteria) {
      if (criteria != null) {
        if (criteria.isValid()) {
          return false;
        }
      }
    }
    return true;
  }

  protected Page page;

  public RecruitDemandCriteria() {
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

    public Criteria andDemandIdIsNull() {
      addCriterion("DEMAND_ID is null");
      return (Criteria) this;
    }

    public Criteria andDemandIdIsNotNull() {
      addCriterion("DEMAND_ID is not null");
      return (Criteria) this;
    }

    public Criteria andDemandIdEqualTo(String value) {
      addCriterion("DEMAND_ID =", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdNotEqualTo(String value) {
      addCriterion("DEMAND_ID <>", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdGreaterThan(String value) {
      addCriterion("DEMAND_ID >", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdGreaterThanOrEqualTo(String value) {
      addCriterion("DEMAND_ID >=", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdLessThan(String value) {
      addCriterion("DEMAND_ID <", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdLessThanOrEqualTo(String value) {
      addCriterion("DEMAND_ID <=", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdLike(String value) {
      addCriterion("DEMAND_ID like", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdNotLike(String value) {
      addCriterion("DEMAND_ID not like", value, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdIn(List<String> values) {
      addCriterion("DEMAND_ID in", values, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdNotIn(List<String> values) {
      addCriterion("DEMAND_ID not in", values, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdBetween(String value1, String value2) {
      addCriterion("DEMAND_ID between", value1, value2, "demandId");
      return (Criteria) this;
    }

    public Criteria andDemandIdNotBetween(String value1, String value2) {
      addCriterion("DEMAND_ID not between", value1, value2, "demandId");
      return (Criteria) this;
    }

    public Criteria andThemeIsNull() {
      addCriterion("THEME is null");
      return (Criteria) this;
    }

    public Criteria andThemeIsNotNull() {
      addCriterion("THEME is not null");
      return (Criteria) this;
    }

    public Criteria andThemeEqualTo(String value) {
      addCriterion("THEME =", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeNotEqualTo(String value) {
      addCriterion("THEME <>", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeGreaterThan(String value) {
      addCriterion("THEME >", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeGreaterThanOrEqualTo(String value) {
      addCriterion("THEME >=", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeLessThan(String value) {
      addCriterion("THEME <", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeLessThanOrEqualTo(String value) {
      addCriterion("THEME <=", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeLike(String value) {
      addCriterion("THEME like", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeNotLike(String value) {
      addCriterion("THEME not like", value, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeIn(List<String> values) {
      addCriterion("THEME in", values, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeNotIn(List<String> values) {
      addCriterion("THEME not in", values, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeBetween(String value1, String value2) {
      addCriterion("THEME between", value1, value2, "theme");
      return (Criteria) this;
    }

    public Criteria andThemeNotBetween(String value1, String value2) {
      addCriterion("THEME not between", value1, value2, "theme");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdIsNull() {
      addCriterion("DUTY_PERSON_ID is null");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdIsNotNull() {
      addCriterion("DUTY_PERSON_ID is not null");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdEqualTo(String value) {
      addCriterion("DUTY_PERSON_ID =", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdNotEqualTo(String value) {
      addCriterion("DUTY_PERSON_ID <>", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdGreaterThan(String value) {
      addCriterion("DUTY_PERSON_ID >", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdGreaterThanOrEqualTo(String value) {
      addCriterion("DUTY_PERSON_ID >=", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdLessThan(String value) {
      addCriterion("DUTY_PERSON_ID <", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdLessThanOrEqualTo(String value) {
      addCriterion("DUTY_PERSON_ID <=", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdLike(String value) {
      addCriterion("DUTY_PERSON_ID like", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdNotLike(String value) {
      addCriterion("DUTY_PERSON_ID not like", value, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdIn(List<String> values) {
      addCriterion("DUTY_PERSON_ID in", values, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdNotIn(List<String> values) {
      addCriterion("DUTY_PERSON_ID not in", values, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdBetween(String value1, String value2) {
      addCriterion("DUTY_PERSON_ID between", value1, value2, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdNotBetween(String value1, String value2) {
      addCriterion("DUTY_PERSON_ID not between", value1, value2, "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdIsNull() {
      addCriterion("APPLY_ORGANIZATION_ID is null");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdIsNotNull() {
      addCriterion("APPLY_ORGANIZATION_ID is not null");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_ID =", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdNotEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_ID <>", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdGreaterThan(String value) {
      addCriterion("APPLY_ORGANIZATION_ID >", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdGreaterThanOrEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_ID >=", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdLessThan(String value) {
      addCriterion("APPLY_ORGANIZATION_ID <", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdLessThanOrEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_ID <=", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdLike(String value) {
      addCriterion("APPLY_ORGANIZATION_ID like", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdNotLike(String value) {
      addCriterion("APPLY_ORGANIZATION_ID not like", value, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdIn(List<String> values) {
      addCriterion("APPLY_ORGANIZATION_ID in", values, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdNotIn(List<String> values) {
      addCriterion("APPLY_ORGANIZATION_ID not in", values, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdBetween(String value1, String value2) {
      addCriterion("APPLY_ORGANIZATION_ID between", value1, value2, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdNotBetween(String value1, String value2) {
      addCriterion("APPLY_ORGANIZATION_ID not between", value1, value2, "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdIsNull() {
      addCriterion("APPLY_POST_ID is null");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdIsNotNull() {
      addCriterion("APPLY_POST_ID is not null");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdEqualTo(String value) {
      addCriterion("APPLY_POST_ID =", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andHasShare() {
      addCriterion("exists (select 1 from T_RECRUIT_DEMAND_SHARE ds where ds.RECRUIT_DEMAND_ID=a.id)");
      return (Criteria) this;
    }
    public Criteria andStartDistributeDate(String value) {
      addCriterion("to_date(PREDICT_COME_DATE,'yyyy-mm-dd') >= to_date('"+value+"','yyyy-mm-dd')");
      return (Criteria) this;
    }
    
    public Criteria andEndDistributeDate(String value) {
      addCriterion("to_date(PREDICT_COME_DATE,'yyyy-mm-dd') <= to_date('"+value+"','yyyy-mm-dd')");
      return (Criteria) this;
    }
    
    public Criteria andNotShare() {
      addCriterion("not exists (select 1 from T_RECRUIT_DEMAND_SHARE ds where ds.RECRUIT_DEMAND_ID=a.id)");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdNotEqualTo(String value) {
      addCriterion("APPLY_POST_ID <>", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdGreaterThan(String value) {
      addCriterion("APPLY_POST_ID >", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdGreaterThanOrEqualTo(String value) {
      addCriterion("APPLY_POST_ID >=", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdLessThan(String value) {
      addCriterion("APPLY_POST_ID <", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdLessThanOrEqualTo(String value) {
      addCriterion("APPLY_POST_ID <=", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdLike(String value) {
      addCriterion("APPLY_POST_ID like", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdNotLike(String value) {
      addCriterion("APPLY_POST_ID not like", value, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdIn(List<String> values) {
      addCriterion("APPLY_POST_ID in", values, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdNotIn(List<String> values) {
      addCriterion("APPLY_POST_ID not in", values, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdBetween(String value1, String value2) {
      addCriterion("APPLY_POST_ID between", value1, value2, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdNotBetween(String value1, String value2) {
      addCriterion("APPLY_POST_ID not between", value1, value2, "applyPostId");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeIsNull() {
      addCriterion("EMPLOYEE_TYPE is null");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeIsNotNull() {
      addCriterion("EMPLOYEE_TYPE is not null");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeEqualTo(String value) {
      addCriterion("EMPLOYEE_TYPE =", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeNotEqualTo(String value) {
      addCriterion("EMPLOYEE_TYPE <>", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeGreaterThan(String value) {
      addCriterion("EMPLOYEE_TYPE >", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeGreaterThanOrEqualTo(String value) {
      addCriterion("EMPLOYEE_TYPE >=", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeLessThan(String value) {
      addCriterion("EMPLOYEE_TYPE <", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeLessThanOrEqualTo(String value) {
      addCriterion("EMPLOYEE_TYPE <=", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeLike(String value) {
      addCriterion("EMPLOYEE_TYPE like", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeNotLike(String value) {
      addCriterion("EMPLOYEE_TYPE not like", value, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeIn(List<String> values) {
      addCriterion("EMPLOYEE_TYPE in", values, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeNotIn(List<String> values) {
      addCriterion("EMPLOYEE_TYPE not in", values, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeBetween(String value1, String value2) {
      addCriterion("EMPLOYEE_TYPE between", value1, value2, "employeeType");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeNotBetween(String value1, String value2) {
      addCriterion("EMPLOYEE_TYPE not between", value1, value2, "employeeType");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonIsNull() {
      addCriterion("RECRUIT_DEMAND_REASON is null");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonIsNotNull() {
      addCriterion("RECRUIT_DEMAND_REASON is not null");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonEqualTo(String value) {
      addCriterion("RECRUIT_DEMAND_REASON =", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonNotEqualTo(String value) {
      addCriterion("RECRUIT_DEMAND_REASON <>", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonGreaterThan(String value) {
      addCriterion("RECRUIT_DEMAND_REASON >", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonGreaterThanOrEqualTo(String value) {
      addCriterion("RECRUIT_DEMAND_REASON >=", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonLessThan(String value) {
      addCriterion("RECRUIT_DEMAND_REASON <", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonLessThanOrEqualTo(String value) {
      addCriterion("RECRUIT_DEMAND_REASON <=", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonLike(String value) {
      addCriterion("RECRUIT_DEMAND_REASON like", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonNotLike(String value) {
      addCriterion("RECRUIT_DEMAND_REASON not like", value, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonIn(List<String> values) {
      addCriterion("RECRUIT_DEMAND_REASON in", values, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonNotIn(List<String> values) {
      addCriterion("RECRUIT_DEMAND_REASON not in", values, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonBetween(String value1, String value2) {
      addCriterion("RECRUIT_DEMAND_REASON between", value1, value2, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonNotBetween(String value1, String value2) {
      addCriterion("RECRUIT_DEMAND_REASON not between", value1, value2, "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonIsNull() {
      addCriterion("DIMISSION_CHANGE_PERSON is null");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonIsNotNull() {
      addCriterion("DIMISSION_CHANGE_PERSON is not null");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonEqualTo(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON =", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonNotEqualTo(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON <>", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonGreaterThan(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON >", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonGreaterThanOrEqualTo(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON >=", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonLessThan(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON <", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonLessThanOrEqualTo(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON <=", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonLike(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON like", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonNotLike(String value) {
      addCriterion("DIMISSION_CHANGE_PERSON not like", value, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonIn(List<String> values) {
      addCriterion("DIMISSION_CHANGE_PERSON in", values, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonNotIn(List<String> values) {
      addCriterion("DIMISSION_CHANGE_PERSON not in", values, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonBetween(String value1, String value2) {
      addCriterion("DIMISSION_CHANGE_PERSON between", value1, value2, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonNotBetween(String value1, String value2) {
      addCriterion("DIMISSION_CHANGE_PERSON not between", value1, value2, "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andRankIdIsNull() {
      addCriterion("RANK_ID is null");
      return (Criteria) this;
    }

    public Criteria andRankIdIsNotNull() {
      addCriterion("RANK_ID is not null");
      return (Criteria) this;
    }

    public Criteria andRankIdEqualTo(String value) {
      addCriterion("RANK_ID =", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdNotEqualTo(String value) {
      addCriterion("RANK_ID <>", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdGreaterThan(String value) {
      addCriterion("RANK_ID >", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdGreaterThanOrEqualTo(String value) {
      addCriterion("RANK_ID >=", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdLessThan(String value) {
      addCriterion("RANK_ID <", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdLessThanOrEqualTo(String value) {
      addCriterion("RANK_ID <=", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdLike(String value) {
      addCriterion("RANK_ID like", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdNotLike(String value) {
      addCriterion("RANK_ID not like", value, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdIn(List<String> values) {
      addCriterion("RANK_ID in", values, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdNotIn(List<String> values) {
      addCriterion("RANK_ID not in", values, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdBetween(String value1, String value2) {
      addCriterion("RANK_ID between", value1, value2, "rankId");
      return (Criteria) this;
    }

    public Criteria andRankIdNotBetween(String value1, String value2) {
      addCriterion("RANK_ID not between", value1, value2, "rankId");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberIsNull() {
      addCriterion("APPLY_PERSON_NUMBER is null");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberIsNotNull() {
      addCriterion("APPLY_PERSON_NUMBER is not null");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberEqualTo(BigDecimal value) {
      addCriterion("APPLY_PERSON_NUMBER =", value, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberNotEqualTo(BigDecimal value) {
      addCriterion("APPLY_PERSON_NUMBER <>", value, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberGreaterThan(BigDecimal value) {
      addCriterion("APPLY_PERSON_NUMBER >", value, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberGreaterThanOrEqualTo(BigDecimal value) {
      addCriterion("APPLY_PERSON_NUMBER >=", value, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberLessThan(BigDecimal value) {
      addCriterion("APPLY_PERSON_NUMBER <", value, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberLessThanOrEqualTo(BigDecimal value) {
      addCriterion("APPLY_PERSON_NUMBER <=", value, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberIn(List<BigDecimal> values) {
      addCriterion("APPLY_PERSON_NUMBER in", values, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberNotIn(List<BigDecimal> values) {
      addCriterion("APPLY_PERSON_NUMBER not in", values, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("APPLY_PERSON_NUMBER between", value1, value2, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyPersonNumberNotBetween(BigDecimal value1, BigDecimal value2) {
      addCriterion("APPLY_PERSON_NUMBER not between", value1, value2, "applyPersonNumber");
      return (Criteria) this;
    }

    public Criteria andApplyDateIsNull() {
      addCriterion("APPLY_DATE is null");
      return (Criteria) this;
    }

    public Criteria andApplyDateIsNotNull() {
      addCriterion("APPLY_DATE is not null");
      return (Criteria) this;
    }

    public Criteria andApplyDateEqualTo(String value) {
      addCriterion("APPLY_DATE =", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateNotEqualTo(String value) {
      addCriterion("APPLY_DATE <>", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateGreaterThan(String value) {
      addCriterion("APPLY_DATE >", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateGreaterThanOrEqualTo(String value) {
      addCriterion("APPLY_DATE >=", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateLessThan(String value) {
      addCriterion("APPLY_DATE <", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateLessThanOrEqualTo(String value) {
      addCriterion("APPLY_DATE <=", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateLike(String value) {
      addCriterion("APPLY_DATE like", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateNotLike(String value) {
      addCriterion("APPLY_DATE not like", value, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateIn(List<String> values) {
      addCriterion("APPLY_DATE in", values, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateNotIn(List<String> values) {
      addCriterion("APPLY_DATE not in", values, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateBetween(String value1, String value2) {
      addCriterion("APPLY_DATE between", value1, value2, "applyDate");
      return (Criteria) this;
    }

    public Criteria andApplyDateNotBetween(String value1, String value2) {
      addCriterion("APPLY_DATE not between", value1, value2, "applyDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateIsNull() {
      addCriterion("PREDICT_COME_DATE is null");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateIsNotNull() {
      addCriterion("PREDICT_COME_DATE is not null");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateEqualTo(String value) {
      addCriterion("PREDICT_COME_DATE =", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateNotEqualTo(String value) {
      addCriterion("PREDICT_COME_DATE <>", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateGreaterThan(String value) {
      addCriterion("PREDICT_COME_DATE >", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateGreaterThanOrEqualTo(String value) {
      addCriterion("PREDICT_COME_DATE >=", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateLessThan(String value) {
      addCriterion("PREDICT_COME_DATE <", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateLessThanOrEqualTo(String value) {
      addCriterion("PREDICT_COME_DATE <=", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateLike(String value) {
      addCriterion("PREDICT_COME_DATE like", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateNotLike(String value) {
      addCriterion("PREDICT_COME_DATE not like", value, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateIn(List<String> values) {
      addCriterion("PREDICT_COME_DATE in", values, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateNotIn(List<String> values) {
      addCriterion("PREDICT_COME_DATE not in", values, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateBetween(String value1, String value2) {
      addCriterion("PREDICT_COME_DATE between", value1, value2, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateNotBetween(String value1, String value2) {
      addCriterion("PREDICT_COME_DATE not between", value1, value2, "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateIsNull() {
      addCriterion("WANT_COME_DATE is null");
      return (Criteria) this;
    }

    public Criteria andWantComeDateIsNotNull() {
      addCriterion("WANT_COME_DATE is not null");
      return (Criteria) this;
    }

    public Criteria andWantComeDateEqualTo(String value) {
      addCriterion("WANT_COME_DATE =", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateNotEqualTo(String value) {
      addCriterion("WANT_COME_DATE <>", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateGreaterThan(String value) {
      addCriterion("WANT_COME_DATE >", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateGreaterThanOrEqualTo(String value) {
      addCriterion("WANT_COME_DATE >=", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateLessThan(String value) {
      addCriterion("WANT_COME_DATE <", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateLessThanOrEqualTo(String value) {
      addCriterion("WANT_COME_DATE <=", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateLike(String value) {
      addCriterion("WANT_COME_DATE like", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateNotLike(String value) {
      addCriterion("WANT_COME_DATE not like", value, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateIn(List<String> values) {
      addCriterion("WANT_COME_DATE in", values, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateNotIn(List<String> values) {
      addCriterion("WANT_COME_DATE not in", values, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateBetween(String value1, String value2) {
      addCriterion("WANT_COME_DATE between", value1, value2, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateNotBetween(String value1, String value2) {
      addCriterion("WANT_COME_DATE not between", value1, value2, "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andDistrictIsNull() {
      addCriterion("DISTRICT is null");
      return (Criteria) this;
    }

    public Criteria andDistrictIsNotNull() {
      addCriterion("DISTRICT is not null");
      return (Criteria) this;
    }

    public Criteria andDistrictEqualTo(String value) {
      addCriterion("DISTRICT =", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictNotEqualTo(String value) {
      addCriterion("DISTRICT <>", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictGreaterThan(String value) {
      addCriterion("DISTRICT >", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictGreaterThanOrEqualTo(String value) {
      addCriterion("DISTRICT >=", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictLessThan(String value) {
      addCriterion("DISTRICT <", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictLessThanOrEqualTo(String value) {
      addCriterion("DISTRICT <=", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictLike(String value) {
      addCriterion("DISTRICT like", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictNotLike(String value) {
      addCriterion("DISTRICT not like", value, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictIn(List<String> values) {
      addCriterion("DISTRICT in", values, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictNotIn(List<String> values) {
      addCriterion("DISTRICT not in", values, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictBetween(String value1, String value2) {
      addCriterion("DISTRICT between", value1, value2, "district");
      return (Criteria) this;
    }

    public Criteria andDistrictNotBetween(String value1, String value2) {
      addCriterion("DISTRICT not between", value1, value2, "district");
      return (Criteria) this;
    }

    public Criteria andDeputyIdIsNull() {
      addCriterion("DEPUTY_ID is null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdIsNotNull() {
      addCriterion("DEPUTY_ID is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyIdEqualTo(String value) {
      addCriterion("DEPUTY_ID =", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdNotEqualTo(String value) {
      addCriterion("DEPUTY_ID <>", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdGreaterThan(String value) {
      addCriterion("DEPUTY_ID >", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdGreaterThanOrEqualTo(String value) {
      addCriterion("DEPUTY_ID >=", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdLessThan(String value) {
      addCriterion("DEPUTY_ID <", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdLessThanOrEqualTo(String value) {
      addCriterion("DEPUTY_ID <=", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdLike(String value) {
      addCriterion("DEPUTY_ID like", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdNotLike(String value) {
      addCriterion("DEPUTY_ID not like", value, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdIn(List<String> values) {
      addCriterion("DEPUTY_ID in", values, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdNotIn(List<String> values) {
      addCriterion("DEPUTY_ID not in", values, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdBetween(String value1, String value2) {
      addCriterion("DEPUTY_ID between", value1, value2, "deputyId");
      return (Criteria) this;
    }

    public Criteria andDeputyIdNotBetween(String value1, String value2) {
      addCriterion("DEPUTY_ID not between", value1, value2, "deputyId");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkIsNull() {
      addCriterion("WORK_REMARK is null");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkIsNotNull() {
      addCriterion("WORK_REMARK is not null");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkEqualTo(String value) {
      addCriterion("WORK_REMARK =", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkNotEqualTo(String value) {
      addCriterion("WORK_REMARK <>", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkGreaterThan(String value) {
      addCriterion("WORK_REMARK >", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("WORK_REMARK >=", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkLessThan(String value) {
      addCriterion("WORK_REMARK <", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkLessThanOrEqualTo(String value) {
      addCriterion("WORK_REMARK <=", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkLike(String value) {
      addCriterion("WORK_REMARK like", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkNotLike(String value) {
      addCriterion("WORK_REMARK not like", value, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkIn(List<String> values) {
      addCriterion("WORK_REMARK in", values, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkNotIn(List<String> values) {
      addCriterion("WORK_REMARK not in", values, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkBetween(String value1, String value2) {
      addCriterion("WORK_REMARK between", value1, value2, "workRemark");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkNotBetween(String value1, String value2) {
      addCriterion("WORK_REMARK not between", value1, value2, "workRemark");
      return (Criteria) this;
    }

    public Criteria andInfoStateIsNull() {
      addCriterion("INFO_STATE is null");
      return (Criteria) this;
    }

    public Criteria andInfoStateIsNotNull() {
      addCriterion("INFO_STATE is not null");
      return (Criteria) this;
    }

    public Criteria andInfoStateEqualTo(String value) {
      addCriterion("INFO_STATE =", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateNotEqualTo(String value) {
      addCriterion("INFO_STATE <>", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateGreaterThan(String value) {
      addCriterion("INFO_STATE >", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateGreaterThanOrEqualTo(String value) {
      addCriterion("INFO_STATE >=", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateLessThan(String value) {
      addCriterion("INFO_STATE <", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateLessThanOrEqualTo(String value) {
      addCriterion("INFO_STATE <=", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateLike(String value) {
      addCriterion("INFO_STATE like", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateNotLike(String value) {
      addCriterion("INFO_STATE not like", value, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateIn(List<String> values) {
      addCriterion("INFO_STATE in", values, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateNotIn(List<String> values) {
      addCriterion("INFO_STATE not in", values, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateBetween(String value1, String value2) {
      addCriterion("INFO_STATE between", value1, value2, "infoState");
      return (Criteria) this;
    }

    public Criteria andInfoStateNotBetween(String value1, String value2) {
      addCriterion("INFO_STATE not between", value1, value2, "infoState");
      return (Criteria) this;
    }

    public Criteria andFlowStateIsNull() {
      addCriterion("FLOW_STATE is null");
      return (Criteria) this;
    }

    public Criteria andFlowStateIsNotNull() {
      addCriterion("FLOW_STATE is not null");
      return (Criteria) this;
    }

    public Criteria andFlowStateEqualTo(String value) {
      addCriterion("FLOW_STATE =", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateNotEqualTo(String value) {
      addCriterion("FLOW_STATE <>", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateGreaterThan(String value) {
      addCriterion("FLOW_STATE >", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateGreaterThanOrEqualTo(String value) {
      addCriterion("FLOW_STATE >=", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateLessThan(String value) {
      addCriterion("FLOW_STATE <", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateLessThanOrEqualTo(String value) {
      addCriterion("FLOW_STATE <=", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateLike(String value) {
      addCriterion("FLOW_STATE like", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateNotLike(String value) {
      addCriterion("FLOW_STATE not like", value, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateIn(List<String> values) {
      addCriterion("FLOW_STATE in", values, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateNotIn(List<String> values) {
      addCriterion("FLOW_STATE not in", values, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateBetween(String value1, String value2) {
      addCriterion("FLOW_STATE between", value1, value2, "flowState");
      return (Criteria) this;
    }

    public Criteria andFlowStateNotBetween(String value1, String value2) {
      addCriterion("FLOW_STATE not between", value1, value2, "flowState");
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

    public Criteria andProfessionIsNull() {
      addCriterion("PROFESSION is null");
      return (Criteria) this;
    }

    public Criteria andProfessionIsNotNull() {
      addCriterion("PROFESSION is not null");
      return (Criteria) this;
    }

    public Criteria andProfessionEqualTo(String value) {
      addCriterion("PROFESSION =", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionNotEqualTo(String value) {
      addCriterion("PROFESSION <>", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionGreaterThan(String value) {
      addCriterion("PROFESSION >", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionGreaterThanOrEqualTo(String value) {
      addCriterion("PROFESSION >=", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionLessThan(String value) {
      addCriterion("PROFESSION <", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionLessThanOrEqualTo(String value) {
      addCriterion("PROFESSION <=", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionLike(String value) {
      addCriterion("PROFESSION like", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionNotLike(String value) {
      addCriterion("PROFESSION not like", value, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionIn(List<String> values) {
      addCriterion("PROFESSION in", values, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionNotIn(List<String> values) {
      addCriterion("PROFESSION not in", values, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionBetween(String value1, String value2) {
      addCriterion("PROFESSION between", value1, value2, "profession");
      return (Criteria) this;
    }

    public Criteria andProfessionNotBetween(String value1, String value2) {
      addCriterion("PROFESSION not between", value1, value2, "profession");
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

    public Criteria andWorkExperienceEqualTo(String value) {
      addCriterion("WORK_EXPERIENCE =", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceNotEqualTo(String value) {
      addCriterion("WORK_EXPERIENCE <>", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceGreaterThan(String value) {
      addCriterion("WORK_EXPERIENCE >", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceGreaterThanOrEqualTo(String value) {
      addCriterion("WORK_EXPERIENCE >=", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceLessThan(String value) {
      addCriterion("WORK_EXPERIENCE <", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceLessThanOrEqualTo(String value) {
      addCriterion("WORK_EXPERIENCE <=", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceLike(String value) {
      addCriterion("WORK_EXPERIENCE like", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceNotLike(String value) {
      addCriterion("WORK_EXPERIENCE not like", value, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceIn(List<String> values) {
      addCriterion("WORK_EXPERIENCE in", values, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceNotIn(List<String> values) {
      addCriterion("WORK_EXPERIENCE not in", values, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceBetween(String value1, String value2) {
      addCriterion("WORK_EXPERIENCE between", value1, value2, "workExperience");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceNotBetween(String value1, String value2) {
      addCriterion("WORK_EXPERIENCE not between", value1, value2, "workExperience");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillIsNull() {
      addCriterion("REQUIRED_SKILL is null");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillIsNotNull() {
      addCriterion("REQUIRED_SKILL is not null");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillEqualTo(String value) {
      addCriterion("REQUIRED_SKILL =", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillNotEqualTo(String value) {
      addCriterion("REQUIRED_SKILL <>", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillGreaterThan(String value) {
      addCriterion("REQUIRED_SKILL >", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillGreaterThanOrEqualTo(String value) {
      addCriterion("REQUIRED_SKILL >=", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillLessThan(String value) {
      addCriterion("REQUIRED_SKILL <", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillLessThanOrEqualTo(String value) {
      addCriterion("REQUIRED_SKILL <=", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillLike(String value) {
      addCriterion("REQUIRED_SKILL like", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillNotLike(String value) {
      addCriterion("REQUIRED_SKILL not like", value, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillIn(List<String> values) {
      addCriterion("REQUIRED_SKILL in", values, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillNotIn(List<String> values) {
      addCriterion("REQUIRED_SKILL not in", values, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillBetween(String value1, String value2) {
      addCriterion("REQUIRED_SKILL between", value1, value2, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillNotBetween(String value1, String value2) {
      addCriterion("REQUIRED_SKILL not between", value1, value2, "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedIsNull() {
      addCriterion("ABILITY_DEMANDED is null");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedIsNotNull() {
      addCriterion("ABILITY_DEMANDED is not null");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedEqualTo(String value) {
      addCriterion("ABILITY_DEMANDED =", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedNotEqualTo(String value) {
      addCriterion("ABILITY_DEMANDED <>", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedGreaterThan(String value) {
      addCriterion("ABILITY_DEMANDED >", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedGreaterThanOrEqualTo(String value) {
      addCriterion("ABILITY_DEMANDED >=", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedLessThan(String value) {
      addCriterion("ABILITY_DEMANDED <", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedLessThanOrEqualTo(String value) {
      addCriterion("ABILITY_DEMANDED <=", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedLike(String value) {
      addCriterion("ABILITY_DEMANDED like", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedNotLike(String value) {
      addCriterion("ABILITY_DEMANDED not like", value, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedIn(List<String> values) {
      addCriterion("ABILITY_DEMANDED in", values, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedNotIn(List<String> values) {
      addCriterion("ABILITY_DEMANDED not in", values, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedBetween(String value1, String value2) {
      addCriterion("ABILITY_DEMANDED between", value1, value2, "abilityDemanded");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedNotBetween(String value1, String value2) {
      addCriterion("ABILITY_DEMANDED not between", value1, value2, "abilityDemanded");
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

    public Criteria andApplyOrganizationNameIsNull() {
      addCriterion("APPLY_ORGANIZATION_NAME is null");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameIsNotNull() {
      addCriterion("APPLY_ORGANIZATION_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME =", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameNotEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME <>", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameGreaterThan(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME >", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameGreaterThanOrEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME >=", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameLessThan(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME <", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameLessThanOrEqualTo(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME <=", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameLike(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME like", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameNotLike(String value) {
      addCriterion("APPLY_ORGANIZATION_NAME not like", value, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameIn(List<String> values) {
      addCriterion("APPLY_ORGANIZATION_NAME in", values, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameNotIn(List<String> values) {
      addCriterion("APPLY_ORGANIZATION_NAME not in", values, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameBetween(String value1, String value2) {
      addCriterion("APPLY_ORGANIZATION_NAME between", value1, value2, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationNameNotBetween(String value1, String value2) {
      addCriterion("APPLY_ORGANIZATION_NAME not between", value1, value2, "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameIsNull() {
      addCriterion("APPLY_POST_NAME is null");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameIsNotNull() {
      addCriterion("APPLY_POST_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameEqualTo(String value) {
      addCriterion("APPLY_POST_NAME =", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameNotEqualTo(String value) {
      addCriterion("APPLY_POST_NAME <>", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameGreaterThan(String value) {
      addCriterion("APPLY_POST_NAME >", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameGreaterThanOrEqualTo(String value) {
      addCriterion("APPLY_POST_NAME >=", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameLessThan(String value) {
      addCriterion("APPLY_POST_NAME <", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameLessThanOrEqualTo(String value) {
      addCriterion("APPLY_POST_NAME <=", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameLike(String value) {
      addCriterion("APPLY_POST_NAME like", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameNotLike(String value) {
      addCriterion("APPLY_POST_NAME not like", value, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameIn(List<String> values) {
      addCriterion("APPLY_POST_NAME in", values, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameNotIn(List<String> values) {
      addCriterion("APPLY_POST_NAME not in", values, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameBetween(String value1, String value2) {
      addCriterion("APPLY_POST_NAME between", value1, value2, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameNotBetween(String value1, String value2) {
      addCriterion("APPLY_POST_NAME not between", value1, value2, "applyPostName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameIsNull() {
      addCriterion("DEPUTY_NAME is null");
      return (Criteria) this;
    }

    public Criteria andDeputyNameIsNotNull() {
      addCriterion("DEPUTY_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andDeputyNameEqualTo(String value) {
      addCriterion("DEPUTY_NAME =", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotEqualTo(String value) {
      addCriterion("DEPUTY_NAME <>", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameGreaterThan(String value) {
      addCriterion("DEPUTY_NAME >", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameGreaterThanOrEqualTo(String value) {
      addCriterion("DEPUTY_NAME >=", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameLessThan(String value) {
      addCriterion("DEPUTY_NAME <", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameLessThanOrEqualTo(String value) {
      addCriterion("DEPUTY_NAME <=", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameLike(String value) {
      addCriterion("DEPUTY_NAME like", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotLike(String value) {
      addCriterion("DEPUTY_NAME not like", value, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameIn(List<String> values) {
      addCriterion("DEPUTY_NAME in", values, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotIn(List<String> values) {
      addCriterion("DEPUTY_NAME not in", values, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameBetween(String value1, String value2) {
      addCriterion("DEPUTY_NAME between", value1, value2, "deputyName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameNotBetween(String value1, String value2) {
      addCriterion("DEPUTY_NAME not between", value1, value2, "deputyName");
      return (Criteria) this;
    }

    public Criteria andIsFinishIsNull() {
      addCriterion("IS_FINISH is null");
      return (Criteria) this;
    }

    public Criteria andIsFinishIsNotNull() {
      addCriterion("IS_FINISH is not null");
      return (Criteria) this;
    }

    public Criteria andIsFinishEqualTo(String value) {
      addCriterion("IS_FINISH =", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishNotEqualTo(String value) {
      addCriterion("IS_FINISH <>", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishGreaterThan(String value) {
      addCriterion("IS_FINISH >", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishGreaterThanOrEqualTo(String value) {
      addCriterion("IS_FINISH >=", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishLessThan(String value) {
      addCriterion("IS_FINISH <", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishLessThanOrEqualTo(String value) {
      addCriterion("IS_FINISH <=", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishLike(String value) {
      addCriterion("IS_FINISH like", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishNotLike(String value) {
      addCriterion("IS_FINISH not like", value, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishIn(List<String> values) {
      addCriterion("IS_FINISH in", values, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishNotIn(List<String> values) {
      addCriterion("IS_FINISH not in", values, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishBetween(String value1, String value2) {
      addCriterion("IS_FINISH between", value1, value2, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIsFinishNotBetween(String value1, String value2) {
      addCriterion("IS_FINISH not between", value1, value2, "isFinish");
      return (Criteria) this;
    }

    public Criteria andIdLikeInsensitive(String value) {
      addCriterion("upper(ID) like", value.toUpperCase(), "id");
      return (Criteria) this;
    }

    public Criteria andDemandIdLikeInsensitive(String value) {
      addCriterion("upper(DEMAND_ID) like", value.toUpperCase(), "demandId");
      return (Criteria) this;
    }

    public Criteria andThemeLikeInsensitive(String value) {
      addCriterion("upper(THEME) like", value.toUpperCase(), "theme");
      return (Criteria) this;
    }

    public Criteria andDutyPersonIdLikeInsensitive(String value) {
      addCriterion("upper(DUTY_PERSON_ID) like", value.toUpperCase(), "dutyPersonId");
      return (Criteria) this;
    }

    public Criteria andApplyOrganizationIdLikeInsensitive(String value) {
      addCriterion("upper(APPLY_ORGANIZATION_ID) like", value.toUpperCase(), "applyOrganizationId");
      return (Criteria) this;
    }

    public Criteria andApplyPostIdLikeInsensitive(String value) {
      addCriterion("upper(APPLY_POST_ID) like", value.toUpperCase(), "applyPostId");
      return (Criteria) this;
    }

    public Criteria andEmployeeTypeLikeInsensitive(String value) {
      addCriterion("upper(EMPLOYEE_TYPE) like", value.toUpperCase(), "employeeType");
      return (Criteria) this;
    }

    public Criteria andRecruitDemandReasonLikeInsensitive(String value) {
      addCriterion("upper(RECRUIT_DEMAND_REASON) like", value.toUpperCase(), "recruitDemandReason");
      return (Criteria) this;
    }

    public Criteria andDimissionChangePersonLikeInsensitive(String value) {
      addCriterion("upper(DIMISSION_CHANGE_PERSON) like", value.toUpperCase(),
          "dimissionChangePerson");
      return (Criteria) this;
    }

    public Criteria andRankIdLikeInsensitive(String value) {
      addCriterion("upper(RANK_ID) like", value.toUpperCase(), "rankId");
      return (Criteria) this;
    }

    public Criteria andApplyDateLikeInsensitive(String value) {
      addCriterion("upper(APPLY_DATE) like", value.toUpperCase(), "applyDate");
      return (Criteria) this;
    }

    public Criteria andPredictComeDateLikeInsensitive(String value) {
      addCriterion("upper(PREDICT_COME_DATE) like", value.toUpperCase(), "predictComeDate");
      return (Criteria) this;
    }

    public Criteria andWantComeDateLikeInsensitive(String value) {
      addCriterion("upper(WANT_COME_DATE) like", value.toUpperCase(), "wantComeDate");
      return (Criteria) this;
    }

    public Criteria andDistrictLikeInsensitive(String value) {
      addCriterion("upper(DISTRICT) like", value.toUpperCase(), "district");
      return (Criteria) this;
    }

    public Criteria andDeputyIdLikeInsensitive(String value) {
      addCriterion("upper(DEPUTY_ID) like", value.toUpperCase(), "deputyId");
      return (Criteria) this;
    }

    public Criteria andWorkRemarkLikeInsensitive(String value) {
      addCriterion("upper(WORK_REMARK) like", value.toUpperCase(), "workRemark");
      return (Criteria) this;
    }

    public Criteria andInfoStateLikeInsensitive(String value) {
      addCriterion("upper(INFO_STATE) like", value.toUpperCase(), "infoState");
      return (Criteria) this;
    }

    public Criteria andFlowStateLikeInsensitive(String value) {
      addCriterion("upper(FLOW_STATE) like", value.toUpperCase(), "flowState");
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

    public Criteria andGenderLikeInsensitive(String value) {
      addCriterion("upper(GENDER) like", value.toUpperCase(), "gender");
      return (Criteria) this;
    }

    public Criteria andEducationLikeInsensitive(String value) {
      addCriterion("upper(EDUCATION) like", value.toUpperCase(), "education");
      return (Criteria) this;
    }

    public Criteria andProfessionLikeInsensitive(String value) {
      addCriterion("upper(PROFESSION) like", value.toUpperCase(), "profession");
      return (Criteria) this;
    }

    public Criteria andWorkExperienceLikeInsensitive(String value) {
      addCriterion("upper(WORK_EXPERIENCE) like", value.toUpperCase(), "workExperience");
      return (Criteria) this;
    }

    public Criteria andRequiredSkillLikeInsensitive(String value) {
      addCriterion("upper(REQUIRED_SKILL) like", value.toUpperCase(), "requiredSkill");
      return (Criteria) this;
    }

    public Criteria andAbilityDemandedLikeInsensitive(String value) {
      addCriterion("upper(ABILITY_DEMANDED) like", value.toUpperCase(), "abilityDemanded");
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

    public Criteria andApplyOrganizationNameLikeInsensitive(String value) {
      addCriterion("upper(APPLY_ORGANIZATION_NAME) like", value.toUpperCase(),
          "applyOrganizationName");
      return (Criteria) this;
    }

    public Criteria andApplyPostNameLikeInsensitive(String value) {
      addCriterion("upper(APPLY_POST_NAME) like", value.toUpperCase(), "applyPostName");
      return (Criteria) this;
    }

    public Criteria andDeputyNameLikeInsensitive(String value) {
      addCriterion("upper(DEPUTY_NAME) like", value.toUpperCase(), "deputyName");
      return (Criteria) this;
    }

    public Criteria andIsFinishLikeInsensitive(String value) {
      addCriterion("upper(IS_FINISH) like", value.toUpperCase(), "isFinish");
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
