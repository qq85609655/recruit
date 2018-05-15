package com.csot.recruit.model.original.flow.employ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.amberframework.core.mybatis.pojo.Page;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandCriteria.Criteria;

public class EmployCriteria {
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

    
    public Boolean isOredCriteriaNull() {
      if(oredCriteria.size()==0){
        return true;
      }
      for (Criteria criteria : oredCriteria) {
        if(criteria!=null){
          if(criteria.isValid()){
            return false;
          }
        }
      }
      return true;
    }
    protected List<Criteria> oredCriteria;

    protected Page page;

    public EmployCriteria() {
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

        public Criteria andCandidateIdIsNull() {
            addCriterion("CANDIDATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIsNotNull() {
            addCriterion("CANDIDATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdEqualTo(String value) {
            addCriterion("CANDIDATE_ID =", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotEqualTo(String value) {
            addCriterion("CANDIDATE_ID <>", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThan(String value) {
            addCriterion("CANDIDATE_ID >", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ID >=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThan(String value) {
            addCriterion("CANDIDATE_ID <", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThanOrEqualTo(String value) {
            addCriterion("CANDIDATE_ID <=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLike(String value) {
            addCriterion("CANDIDATE_ID like", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotLike(String value) {
            addCriterion("CANDIDATE_ID not like", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIn(List<String> values) {
            addCriterion("CANDIDATE_ID in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotIn(List<String> values) {
            addCriterion("CANDIDATE_ID not in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ID between", value1, value2, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotBetween(String value1, String value2) {
            addCriterion("CANDIDATE_ID not between", value1, value2, "candidateId");
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

        public Criteria andEmployPostIdIsNull() {
            addCriterion("EMPLOY_POST_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdIsNotNull() {
            addCriterion("EMPLOY_POST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdEqualTo(String value) {
            addCriterion("EMPLOY_POST_ID =", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdNotEqualTo(String value) {
            addCriterion("EMPLOY_POST_ID <>", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdGreaterThan(String value) {
            addCriterion("EMPLOY_POST_ID >", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_POST_ID >=", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdLessThan(String value) {
            addCriterion("EMPLOY_POST_ID <", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_POST_ID <=", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdLike(String value) {
            addCriterion("EMPLOY_POST_ID like", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdNotLike(String value) {
            addCriterion("EMPLOY_POST_ID not like", value, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdIn(List<String> values) {
            addCriterion("EMPLOY_POST_ID in", values, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdNotIn(List<String> values) {
            addCriterion("EMPLOY_POST_ID not in", values, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdBetween(String value1, String value2) {
            addCriterion("EMPLOY_POST_ID between", value1, value2, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_POST_ID not between", value1, value2, "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameIsNull() {
            addCriterion("EMPLOY_POST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameIsNotNull() {
            addCriterion("EMPLOY_POST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameEqualTo(String value) {
            addCriterion("EMPLOY_POST_NAME =", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameNotEqualTo(String value) {
            addCriterion("EMPLOY_POST_NAME <>", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameGreaterThan(String value) {
            addCriterion("EMPLOY_POST_NAME >", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_POST_NAME >=", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameLessThan(String value) {
            addCriterion("EMPLOY_POST_NAME <", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_POST_NAME <=", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameLike(String value) {
            addCriterion("EMPLOY_POST_NAME like", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameNotLike(String value) {
            addCriterion("EMPLOY_POST_NAME not like", value, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameIn(List<String> values) {
            addCriterion("EMPLOY_POST_NAME in", values, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameNotIn(List<String> values) {
            addCriterion("EMPLOY_POST_NAME not in", values, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameBetween(String value1, String value2) {
            addCriterion("EMPLOY_POST_NAME between", value1, value2, "employPostName");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_POST_NAME not between", value1, value2, "employPostName");
            return (Criteria) this;
        }

        public Criteria andStageIsNull() {
            addCriterion("STAGE is null");
            return (Criteria) this;
        }

        public Criteria andStageIsNotNull() {
            addCriterion("STAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStageEqualTo(String value) {
            addCriterion("STAGE =", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotEqualTo(String value) {
            addCriterion("STAGE <>", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThan(String value) {
            addCriterion("STAGE >", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThanOrEqualTo(String value) {
            addCriterion("STAGE >=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThan(String value) {
            addCriterion("STAGE <", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThanOrEqualTo(String value) {
            addCriterion("STAGE <=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLike(String value) {
            addCriterion("STAGE like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotLike(String value) {
            addCriterion("STAGE not like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageIn(List<String> values) {
            addCriterion("STAGE in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotIn(List<String> values) {
            addCriterion("STAGE not in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageBetween(String value1, String value2) {
            addCriterion("STAGE between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotBetween(String value1, String value2) {
            addCriterion("STAGE not between", value1, value2, "stage");
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

        public Criteria andEmploymentFormIsNull() {
            addCriterion("EMPLOYMENT_FORM is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormIsNotNull() {
            addCriterion("EMPLOYMENT_FORM is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormEqualTo(String value) {
            addCriterion("EMPLOYMENT_FORM =", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormNotEqualTo(String value) {
            addCriterion("EMPLOYMENT_FORM <>", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormGreaterThan(String value) {
            addCriterion("EMPLOYMENT_FORM >", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOYMENT_FORM >=", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormLessThan(String value) {
            addCriterion("EMPLOYMENT_FORM <", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormLessThanOrEqualTo(String value) {
            addCriterion("EMPLOYMENT_FORM <=", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormLike(String value) {
            addCriterion("EMPLOYMENT_FORM like", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormNotLike(String value) {
            addCriterion("EMPLOYMENT_FORM not like", value, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormIn(List<String> values) {
            addCriterion("EMPLOYMENT_FORM in", values, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormNotIn(List<String> values) {
            addCriterion("EMPLOYMENT_FORM not in", values, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormBetween(String value1, String value2) {
            addCriterion("EMPLOYMENT_FORM between", value1, value2, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormNotBetween(String value1, String value2) {
            addCriterion("EMPLOYMENT_FORM not between", value1, value2, "employmentForm");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrIsNull() {
            addCriterion("APPRAISAL_INTERVIEW_HR is null");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrIsNotNull() {
            addCriterion("APPRAISAL_INTERVIEW_HR is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR =", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrNotEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR <>", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrGreaterThan(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR >", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrGreaterThanOrEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR >=", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrLessThan(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR <", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrLessThanOrEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR <=", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrLike(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR like", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrNotLike(String value) {
            addCriterion("APPRAISAL_INTERVIEW_HR not like", value, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrIn(List<String> values) {
            addCriterion("APPRAISAL_INTERVIEW_HR in", values, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrNotIn(List<String> values) {
            addCriterion("APPRAISAL_INTERVIEW_HR not in", values, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrBetween(String value1, String value2) {
            addCriterion("APPRAISAL_INTERVIEW_HR between", value1, value2, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrNotBetween(String value1, String value2) {
            addCriterion("APPRAISAL_INTERVIEW_HR not between", value1, value2, "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewIsNull() {
            addCriterion("APPRAISAL_INTERVIEW is null");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewIsNotNull() {
            addCriterion("APPRAISAL_INTERVIEW is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW =", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewNotEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW <>", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewGreaterThan(String value) {
            addCriterion("APPRAISAL_INTERVIEW >", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewGreaterThanOrEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW >=", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewLessThan(String value) {
            addCriterion("APPRAISAL_INTERVIEW <", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewLessThanOrEqualTo(String value) {
            addCriterion("APPRAISAL_INTERVIEW <=", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewLike(String value) {
            addCriterion("APPRAISAL_INTERVIEW like", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewNotLike(String value) {
            addCriterion("APPRAISAL_INTERVIEW not like", value, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewIn(List<String> values) {
            addCriterion("APPRAISAL_INTERVIEW in", values, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewNotIn(List<String> values) {
            addCriterion("APPRAISAL_INTERVIEW not in", values, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewBetween(String value1, String value2) {
            addCriterion("APPRAISAL_INTERVIEW between", value1, value2, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewNotBetween(String value1, String value2) {
            addCriterion("APPRAISAL_INTERVIEW not between", value1, value2, "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNull() {
            addCriterion("ENTRY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNotNull() {
            addCriterion("ENTRY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEntryDateEqualTo(String value) {
            addCriterion("ENTRY_DATE =", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotEqualTo(String value) {
            addCriterion("ENTRY_DATE <>", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThan(String value) {
            addCriterion("ENTRY_DATE >", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThanOrEqualTo(String value) {
            addCriterion("ENTRY_DATE >=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThan(String value) {
            addCriterion("ENTRY_DATE <", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThanOrEqualTo(String value) {
            addCriterion("ENTRY_DATE <=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLike(String value) {
            addCriterion("ENTRY_DATE like", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotLike(String value) {
            addCriterion("ENTRY_DATE not like", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateIn(List<String> values) {
            addCriterion("ENTRY_DATE in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotIn(List<String> values) {
            addCriterion("ENTRY_DATE not in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateBetween(String value1, String value2) {
            addCriterion("ENTRY_DATE between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotBetween(String value1, String value2) {
            addCriterion("ENTRY_DATE not between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideIsNull() {
            addCriterion("ENTRY_DATE_HIDE is null");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideIsNotNull() {
            addCriterion("ENTRY_DATE_HIDE is not null");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideEqualTo(String value) {
            addCriterion("ENTRY_DATE_HIDE =", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideNotEqualTo(String value) {
            addCriterion("ENTRY_DATE_HIDE <>", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideGreaterThan(String value) {
            addCriterion("ENTRY_DATE_HIDE >", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideGreaterThanOrEqualTo(String value) {
            addCriterion("ENTRY_DATE_HIDE >=", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideLessThan(String value) {
            addCriterion("ENTRY_DATE_HIDE <", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideLessThanOrEqualTo(String value) {
            addCriterion("ENTRY_DATE_HIDE <=", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideLike(String value) {
            addCriterion("ENTRY_DATE_HIDE like", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideNotLike(String value) {
            addCriterion("ENTRY_DATE_HIDE not like", value, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideIn(List<String> values) {
            addCriterion("ENTRY_DATE_HIDE in", values, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideNotIn(List<String> values) {
            addCriterion("ENTRY_DATE_HIDE not in", values, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideBetween(String value1, String value2) {
            addCriterion("ENTRY_DATE_HIDE between", value1, value2, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideNotBetween(String value1, String value2) {
            addCriterion("ENTRY_DATE_HIDE not between", value1, value2, "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateIsNull() {
            addCriterion("SIMULATION_ENTRY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateIsNotNull() {
            addCriterion("SIMULATION_ENTRY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateEqualTo(String value) {
            addCriterion("SIMULATION_ENTRY_DATE =", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateNotEqualTo(String value) {
            addCriterion("SIMULATION_ENTRY_DATE <>", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateGreaterThan(String value) {
            addCriterion("SIMULATION_ENTRY_DATE >", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateGreaterThanOrEqualTo(String value) {
            addCriterion("SIMULATION_ENTRY_DATE >=", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateLessThan(String value) {
            addCriterion("SIMULATION_ENTRY_DATE <", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateLessThanOrEqualTo(String value) {
            addCriterion("SIMULATION_ENTRY_DATE <=", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateLike(String value) {
            addCriterion("SIMULATION_ENTRY_DATE like", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateNotLike(String value) {
            addCriterion("SIMULATION_ENTRY_DATE not like", value, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateIn(List<String> values) {
            addCriterion("SIMULATION_ENTRY_DATE in", values, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateNotIn(List<String> values) {
            addCriterion("SIMULATION_ENTRY_DATE not in", values, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateBetween(String value1, String value2) {
            addCriterion("SIMULATION_ENTRY_DATE between", value1, value2, "simulationEntryDate");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateNotBetween(String value1, String value2) {
            addCriterion("SIMULATION_ENTRY_DATE not between", value1, value2, "simulationEntryDate");
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

        public Criteria andEmployOrgIdIsNull() {
            addCriterion("EMPLOY_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdIsNotNull() {
            addCriterion("EMPLOY_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdEqualTo(String value) {
            addCriterion("EMPLOY_ORG_ID =", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdNotEqualTo(String value) {
            addCriterion("EMPLOY_ORG_ID <>", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdGreaterThan(String value) {
            addCriterion("EMPLOY_ORG_ID >", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ORG_ID >=", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdLessThan(String value) {
            addCriterion("EMPLOY_ORG_ID <", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ORG_ID <=", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdLike(String value) {
            addCriterion("EMPLOY_ORG_ID like", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdNotLike(String value) {
            addCriterion("EMPLOY_ORG_ID not like", value, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdIn(List<String> values) {
            addCriterion("EMPLOY_ORG_ID in", values, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdNotIn(List<String> values) {
            addCriterion("EMPLOY_ORG_ID not in", values, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdBetween(String value1, String value2) {
            addCriterion("EMPLOY_ORG_ID between", value1, value2, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgIdNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_ORG_ID not between", value1, value2, "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameIsNull() {
            addCriterion("EMPLOY_ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameIsNotNull() {
            addCriterion("EMPLOY_ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameEqualTo(String value) {
            addCriterion("EMPLOY_ORG_NAME =", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameNotEqualTo(String value) {
            addCriterion("EMPLOY_ORG_NAME <>", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameGreaterThan(String value) {
            addCriterion("EMPLOY_ORG_NAME >", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ORG_NAME >=", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameLessThan(String value) {
            addCriterion("EMPLOY_ORG_NAME <", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_ORG_NAME <=", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameLike(String value) {
            addCriterion("EMPLOY_ORG_NAME like", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameNotLike(String value) {
            addCriterion("EMPLOY_ORG_NAME not like", value, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameIn(List<String> values) {
            addCriterion("EMPLOY_ORG_NAME in", values, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameNotIn(List<String> values) {
            addCriterion("EMPLOY_ORG_NAME not in", values, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameBetween(String value1, String value2) {
            addCriterion("EMPLOY_ORG_NAME between", value1, value2, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_ORG_NAME not between", value1, value2, "employOrgName");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_ID) like", value.toUpperCase(), "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_NAME) like", value.toUpperCase(), "candidateName");
            return (Criteria) this;
        }

        public Criteria andEmployPostIdLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_POST_ID) like", value.toUpperCase(), "employPostId");
            return (Criteria) this;
        }

        public Criteria andEmployPostNameLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_POST_NAME) like", value.toUpperCase(), "employPostName");
            return (Criteria) this;
        }

        public Criteria andStageLikeInsensitive(String value) {
            addCriterion("upper(STAGE) like", value.toUpperCase(), "stage");
            return (Criteria) this;
        }

        public Criteria andDemandIdLikeInsensitive(String value) {
            addCriterion("upper(DEMAND_ID) like", value.toUpperCase(), "demandId");
            return (Criteria) this;
        }

        public Criteria andEmploymentFormLikeInsensitive(String value) {
            addCriterion("upper(EMPLOYMENT_FORM) like", value.toUpperCase(), "employmentForm");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewHrLikeInsensitive(String value) {
            addCriterion("upper(APPRAISAL_INTERVIEW_HR) like", value.toUpperCase(), "appraisalInterviewHr");
            return (Criteria) this;
        }

        public Criteria andAppraisalInterviewLikeInsensitive(String value) {
            addCriterion("upper(APPRAISAL_INTERVIEW) like", value.toUpperCase(), "appraisalInterview");
            return (Criteria) this;
        }

        public Criteria andEntryDateLikeInsensitive(String value) {
            addCriterion("upper(ENTRY_DATE) like", value.toUpperCase(), "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateHideLikeInsensitive(String value) {
            addCriterion("upper(ENTRY_DATE_HIDE) like", value.toUpperCase(), "entryDateHide");
            return (Criteria) this;
        }

        public Criteria andSimulationEntryDateLikeInsensitive(String value) {
            addCriterion("upper(SIMULATION_ENTRY_DATE) like", value.toUpperCase(), "simulationEntryDate");
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

        public Criteria andEmployOrgIdLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_ORG_ID) like", value.toUpperCase(), "employOrgId");
            return (Criteria) this;
        }

        public Criteria andEmployOrgNameLikeInsensitive(String value) {
            addCriterion("upper(EMPLOY_ORG_NAME) like", value.toUpperCase(), "employOrgName");
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