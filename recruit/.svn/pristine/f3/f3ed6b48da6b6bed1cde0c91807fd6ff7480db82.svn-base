package com.csot.recruit.model.original.candidate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class CandidateRecommendCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CandidateRecommendCriteria() {
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

        public Criteria andInterviewerIsNull() {
            addCriterion("INTERVIEWER is null");
            return (Criteria) this;
        }

        public Criteria andInterviewerIsNotNull() {
            addCriterion("INTERVIEWER is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewerEqualTo(String value) {
            addCriterion("INTERVIEWER =", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerNotEqualTo(String value) {
            addCriterion("INTERVIEWER <>", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerGreaterThan(String value) {
            addCriterion("INTERVIEWER >", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerGreaterThanOrEqualTo(String value) {
            addCriterion("INTERVIEWER >=", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerLessThan(String value) {
            addCriterion("INTERVIEWER <", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerLessThanOrEqualTo(String value) {
            addCriterion("INTERVIEWER <=", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerLike(String value) {
            addCriterion("INTERVIEWER like", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerNotLike(String value) {
            addCriterion("INTERVIEWER not like", value, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerIn(List<String> values) {
            addCriterion("INTERVIEWER in", values, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerNotIn(List<String> values) {
            addCriterion("INTERVIEWER not in", values, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerBetween(String value1, String value2) {
            addCriterion("INTERVIEWER between", value1, value2, "interviewer");
            return (Criteria) this;
        }

        public Criteria andInterviewerNotBetween(String value1, String value2) {
            addCriterion("INTERVIEWER not between", value1, value2, "interviewer");
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

        public Criteria andCommentsIsNull() {
            addCriterion("COMMENTS is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("COMMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("COMMENTS =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("COMMENTS <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("COMMENTS >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTS >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("COMMENTS <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("COMMENTS <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("COMMENTS like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("COMMENTS not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("COMMENTS in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("COMMENTS not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("COMMENTS between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("COMMENTS not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNull() {
            addCriterion("FEEDBACK is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNotNull() {
            addCriterion("FEEDBACK is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackEqualTo(String value) {
            addCriterion("FEEDBACK =", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotEqualTo(String value) {
            addCriterion("FEEDBACK <>", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThan(String value) {
            addCriterion("FEEDBACK >", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK >=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThan(String value) {
            addCriterion("FEEDBACK <", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK <=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLike(String value) {
            addCriterion("FEEDBACK like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotLike(String value) {
            addCriterion("FEEDBACK not like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackIn(List<String> values) {
            addCriterion("FEEDBACK in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotIn(List<String> values) {
            addCriterion("FEEDBACK not in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackBetween(String value1, String value2) {
            addCriterion("FEEDBACK between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK not between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdIsNull() {
            addCriterion("TURNTO_POST_ID is null");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdIsNotNull() {
            addCriterion("TURNTO_POST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdEqualTo(String value) {
            addCriterion("TURNTO_POST_ID =", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdNotEqualTo(String value) {
            addCriterion("TURNTO_POST_ID <>", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdGreaterThan(String value) {
            addCriterion("TURNTO_POST_ID >", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("TURNTO_POST_ID >=", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdLessThan(String value) {
            addCriterion("TURNTO_POST_ID <", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdLessThanOrEqualTo(String value) {
            addCriterion("TURNTO_POST_ID <=", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdLike(String value) {
            addCriterion("TURNTO_POST_ID like", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdNotLike(String value) {
            addCriterion("TURNTO_POST_ID not like", value, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdIn(List<String> values) {
            addCriterion("TURNTO_POST_ID in", values, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdNotIn(List<String> values) {
            addCriterion("TURNTO_POST_ID not in", values, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdBetween(String value1, String value2) {
            addCriterion("TURNTO_POST_ID between", value1, value2, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdNotBetween(String value1, String value2) {
            addCriterion("TURNTO_POST_ID not between", value1, value2, "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNull() {
            addCriterion("FEEDBACK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNotNull() {
            addCriterion("FEEDBACK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME =", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME <>", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThan(Date value) {
            addCriterion("FEEDBACK_TIME >", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME >=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThan(Date value) {
            addCriterion("FEEDBACK_TIME <", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThanOrEqualTo(Date value) {
            addCriterion("FEEDBACK_TIME <=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIn(List<Date> values) {
            addCriterion("FEEDBACK_TIME in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotIn(List<Date> values) {
            addCriterion("FEEDBACK_TIME not in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeBetween(Date value1, Date value2) {
            addCriterion("FEEDBACK_TIME between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotBetween(Date value1, Date value2) {
            addCriterion("FEEDBACK_TIME not between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andCandidatePostIdLikeInsensitive(String value) {
            addCriterion("upper(CANDIDATE_POST_ID) like", value.toUpperCase(), "candidatePostId");
            return (Criteria) this;
        }

        public Criteria andInterviewerLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEWER) like", value.toUpperCase(), "interviewer");
            return (Criteria) this;
        }

        public Criteria andResumeIdLikeInsensitive(String value) {
            addCriterion("upper(RESUME_ID) like", value.toUpperCase(), "resumeId");
            return (Criteria) this;
        }

        public Criteria andCommentsLikeInsensitive(String value) {
            addCriterion("upper(COMMENTS) like", value.toUpperCase(), "comments");
            return (Criteria) this;
        }

        public Criteria andFeedbackLikeInsensitive(String value) {
            addCriterion("upper(FEEDBACK) like", value.toUpperCase(), "feedback");
            return (Criteria) this;
        }

        public Criteria andTurntoPostIdLikeInsensitive(String value) {
            addCriterion("upper(TURNTO_POST_ID) like", value.toUpperCase(), "turntoPostId");
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeInsensitive(String value) {
            addCriterion("upper(CREATE_USER) like", value.toUpperCase(), "createUser");
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