package com.csot.recruit.model.original.flow.interview;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class EstimateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EstimateCriteria() {
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

        public Criteria andSysThinkIsNull() {
            addCriterion("SYS_THINK is null");
            return (Criteria) this;
        }

        public Criteria andSysThinkIsNotNull() {
            addCriterion("SYS_THINK is not null");
            return (Criteria) this;
        }

        public Criteria andSysThinkEqualTo(Short value) {
            addCriterion("SYS_THINK =", value, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkNotEqualTo(Short value) {
            addCriterion("SYS_THINK <>", value, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkGreaterThan(Short value) {
            addCriterion("SYS_THINK >", value, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkGreaterThanOrEqualTo(Short value) {
            addCriterion("SYS_THINK >=", value, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkLessThan(Short value) {
            addCriterion("SYS_THINK <", value, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkLessThanOrEqualTo(Short value) {
            addCriterion("SYS_THINK <=", value, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkIn(List<Short> values) {
            addCriterion("SYS_THINK in", values, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkNotIn(List<Short> values) {
            addCriterion("SYS_THINK not in", values, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkBetween(Short value1, Short value2) {
            addCriterion("SYS_THINK between", value1, value2, "sysThink");
            return (Criteria) this;
        }

        public Criteria andSysThinkNotBetween(Short value1, Short value2) {
            addCriterion("SYS_THINK not between", value1, value2, "sysThink");
            return (Criteria) this;
        }

        public Criteria andCommunicateIsNull() {
            addCriterion("COMMUNICATE is null");
            return (Criteria) this;
        }

        public Criteria andCommunicateIsNotNull() {
            addCriterion("COMMUNICATE is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicateEqualTo(Short value) {
            addCriterion("COMMUNICATE =", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateNotEqualTo(Short value) {
            addCriterion("COMMUNICATE <>", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateGreaterThan(Short value) {
            addCriterion("COMMUNICATE >", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateGreaterThanOrEqualTo(Short value) {
            addCriterion("COMMUNICATE >=", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateLessThan(Short value) {
            addCriterion("COMMUNICATE <", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateLessThanOrEqualTo(Short value) {
            addCriterion("COMMUNICATE <=", value, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateIn(List<Short> values) {
            addCriterion("COMMUNICATE in", values, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateNotIn(List<Short> values) {
            addCriterion("COMMUNICATE not in", values, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateBetween(Short value1, Short value2) {
            addCriterion("COMMUNICATE between", value1, value2, "communicate");
            return (Criteria) this;
        }

        public Criteria andCommunicateNotBetween(Short value1, Short value2) {
            addCriterion("COMMUNICATE not between", value1, value2, "communicate");
            return (Criteria) this;
        }

        public Criteria andStudyIsNull() {
            addCriterion("STUDY is null");
            return (Criteria) this;
        }

        public Criteria andStudyIsNotNull() {
            addCriterion("STUDY is not null");
            return (Criteria) this;
        }

        public Criteria andStudyEqualTo(Short value) {
            addCriterion("STUDY =", value, "study");
            return (Criteria) this;
        }

        public Criteria andStudyNotEqualTo(Short value) {
            addCriterion("STUDY <>", value, "study");
            return (Criteria) this;
        }

        public Criteria andStudyGreaterThan(Short value) {
            addCriterion("STUDY >", value, "study");
            return (Criteria) this;
        }

        public Criteria andStudyGreaterThanOrEqualTo(Short value) {
            addCriterion("STUDY >=", value, "study");
            return (Criteria) this;
        }

        public Criteria andStudyLessThan(Short value) {
            addCriterion("STUDY <", value, "study");
            return (Criteria) this;
        }

        public Criteria andStudyLessThanOrEqualTo(Short value) {
            addCriterion("STUDY <=", value, "study");
            return (Criteria) this;
        }

        public Criteria andStudyIn(List<Short> values) {
            addCriterion("STUDY in", values, "study");
            return (Criteria) this;
        }

        public Criteria andStudyNotIn(List<Short> values) {
            addCriterion("STUDY not in", values, "study");
            return (Criteria) this;
        }

        public Criteria andStudyBetween(Short value1, Short value2) {
            addCriterion("STUDY between", value1, value2, "study");
            return (Criteria) this;
        }

        public Criteria andStudyNotBetween(Short value1, Short value2) {
            addCriterion("STUDY not between", value1, value2, "study");
            return (Criteria) this;
        }

        public Criteria andTeamWorkIsNull() {
            addCriterion("TEAM_WORK is null");
            return (Criteria) this;
        }

        public Criteria andTeamWorkIsNotNull() {
            addCriterion("TEAM_WORK is not null");
            return (Criteria) this;
        }

        public Criteria andTeamWorkEqualTo(Short value) {
            addCriterion("TEAM_WORK =", value, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkNotEqualTo(Short value) {
            addCriterion("TEAM_WORK <>", value, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkGreaterThan(Short value) {
            addCriterion("TEAM_WORK >", value, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkGreaterThanOrEqualTo(Short value) {
            addCriterion("TEAM_WORK >=", value, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkLessThan(Short value) {
            addCriterion("TEAM_WORK <", value, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkLessThanOrEqualTo(Short value) {
            addCriterion("TEAM_WORK <=", value, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkIn(List<Short> values) {
            addCriterion("TEAM_WORK in", values, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkNotIn(List<Short> values) {
            addCriterion("TEAM_WORK not in", values, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkBetween(Short value1, Short value2) {
            addCriterion("TEAM_WORK between", value1, value2, "teamWork");
            return (Criteria) this;
        }

        public Criteria andTeamWorkNotBetween(Short value1, Short value2) {
            addCriterion("TEAM_WORK not between", value1, value2, "teamWork");
            return (Criteria) this;
        }

        public Criteria andInnovateIsNull() {
            addCriterion("INNOVATE is null");
            return (Criteria) this;
        }

        public Criteria andInnovateIsNotNull() {
            addCriterion("INNOVATE is not null");
            return (Criteria) this;
        }

        public Criteria andInnovateEqualTo(Short value) {
            addCriterion("INNOVATE =", value, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateNotEqualTo(Short value) {
            addCriterion("INNOVATE <>", value, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateGreaterThan(Short value) {
            addCriterion("INNOVATE >", value, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateGreaterThanOrEqualTo(Short value) {
            addCriterion("INNOVATE >=", value, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateLessThan(Short value) {
            addCriterion("INNOVATE <", value, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateLessThanOrEqualTo(Short value) {
            addCriterion("INNOVATE <=", value, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateIn(List<Short> values) {
            addCriterion("INNOVATE in", values, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateNotIn(List<Short> values) {
            addCriterion("INNOVATE not in", values, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateBetween(Short value1, Short value2) {
            addCriterion("INNOVATE between", value1, value2, "innovate");
            return (Criteria) this;
        }

        public Criteria andInnovateNotBetween(Short value1, Short value2) {
            addCriterion("INNOVATE not between", value1, value2, "innovate");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeIsNull() {
            addCriterion("MAJOR_KNOWLEDGE is null");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeIsNotNull() {
            addCriterion("MAJOR_KNOWLEDGE is not null");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeEqualTo(Short value) {
            addCriterion("MAJOR_KNOWLEDGE =", value, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeNotEqualTo(Short value) {
            addCriterion("MAJOR_KNOWLEDGE <>", value, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeGreaterThan(Short value) {
            addCriterion("MAJOR_KNOWLEDGE >", value, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeGreaterThanOrEqualTo(Short value) {
            addCriterion("MAJOR_KNOWLEDGE >=", value, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeLessThan(Short value) {
            addCriterion("MAJOR_KNOWLEDGE <", value, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeLessThanOrEqualTo(Short value) {
            addCriterion("MAJOR_KNOWLEDGE <=", value, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeIn(List<Short> values) {
            addCriterion("MAJOR_KNOWLEDGE in", values, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeNotIn(List<Short> values) {
            addCriterion("MAJOR_KNOWLEDGE not in", values, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeBetween(Short value1, Short value2) {
            addCriterion("MAJOR_KNOWLEDGE between", value1, value2, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorKnowledgeNotBetween(Short value1, Short value2) {
            addCriterion("MAJOR_KNOWLEDGE not between", value1, value2, "majorKnowledge");
            return (Criteria) this;
        }

        public Criteria andMajorSkillIsNull() {
            addCriterion("MAJOR_SKILL is null");
            return (Criteria) this;
        }

        public Criteria andMajorSkillIsNotNull() {
            addCriterion("MAJOR_SKILL is not null");
            return (Criteria) this;
        }

        public Criteria andMajorSkillEqualTo(Short value) {
            addCriterion("MAJOR_SKILL =", value, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillNotEqualTo(Short value) {
            addCriterion("MAJOR_SKILL <>", value, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillGreaterThan(Short value) {
            addCriterion("MAJOR_SKILL >", value, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillGreaterThanOrEqualTo(Short value) {
            addCriterion("MAJOR_SKILL >=", value, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillLessThan(Short value) {
            addCriterion("MAJOR_SKILL <", value, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillLessThanOrEqualTo(Short value) {
            addCriterion("MAJOR_SKILL <=", value, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillIn(List<Short> values) {
            addCriterion("MAJOR_SKILL in", values, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillNotIn(List<Short> values) {
            addCriterion("MAJOR_SKILL not in", values, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillBetween(Short value1, Short value2) {
            addCriterion("MAJOR_SKILL between", value1, value2, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorSkillNotBetween(Short value1, Short value2) {
            addCriterion("MAJOR_SKILL not between", value1, value2, "majorSkill");
            return (Criteria) this;
        }

        public Criteria andMajorExpIsNull() {
            addCriterion("MAJOR_EXP is null");
            return (Criteria) this;
        }

        public Criteria andMajorExpIsNotNull() {
            addCriterion("MAJOR_EXP is not null");
            return (Criteria) this;
        }

        public Criteria andMajorExpEqualTo(Short value) {
            addCriterion("MAJOR_EXP =", value, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpNotEqualTo(Short value) {
            addCriterion("MAJOR_EXP <>", value, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpGreaterThan(Short value) {
            addCriterion("MAJOR_EXP >", value, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpGreaterThanOrEqualTo(Short value) {
            addCriterion("MAJOR_EXP >=", value, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpLessThan(Short value) {
            addCriterion("MAJOR_EXP <", value, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpLessThanOrEqualTo(Short value) {
            addCriterion("MAJOR_EXP <=", value, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpIn(List<Short> values) {
            addCriterion("MAJOR_EXP in", values, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpNotIn(List<Short> values) {
            addCriterion("MAJOR_EXP not in", values, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpBetween(Short value1, Short value2) {
            addCriterion("MAJOR_EXP between", value1, value2, "majorExp");
            return (Criteria) this;
        }

        public Criteria andMajorExpNotBetween(Short value1, Short value2) {
            addCriterion("MAJOR_EXP not between", value1, value2, "majorExp");
            return (Criteria) this;
        }

        public Criteria andPositionMatchIsNull() {
            addCriterion("POSITION_MATCH is null");
            return (Criteria) this;
        }

        public Criteria andPositionMatchIsNotNull() {
            addCriterion("POSITION_MATCH is not null");
            return (Criteria) this;
        }

        public Criteria andPositionMatchEqualTo(Short value) {
            addCriterion("POSITION_MATCH =", value, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchNotEqualTo(Short value) {
            addCriterion("POSITION_MATCH <>", value, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchGreaterThan(Short value) {
            addCriterion("POSITION_MATCH >", value, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchGreaterThanOrEqualTo(Short value) {
            addCriterion("POSITION_MATCH >=", value, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchLessThan(Short value) {
            addCriterion("POSITION_MATCH <", value, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchLessThanOrEqualTo(Short value) {
            addCriterion("POSITION_MATCH <=", value, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchIn(List<Short> values) {
            addCriterion("POSITION_MATCH in", values, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchNotIn(List<Short> values) {
            addCriterion("POSITION_MATCH not in", values, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchBetween(Short value1, Short value2) {
            addCriterion("POSITION_MATCH between", value1, value2, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andPositionMatchNotBetween(Short value1, Short value2) {
            addCriterion("POSITION_MATCH not between", value1, value2, "positionMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchIsNull() {
            addCriterion("ORG_MATCH is null");
            return (Criteria) this;
        }

        public Criteria andOrgMatchIsNotNull() {
            addCriterion("ORG_MATCH is not null");
            return (Criteria) this;
        }

        public Criteria andOrgMatchEqualTo(Short value) {
            addCriterion("ORG_MATCH =", value, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchNotEqualTo(Short value) {
            addCriterion("ORG_MATCH <>", value, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchGreaterThan(Short value) {
            addCriterion("ORG_MATCH >", value, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchGreaterThanOrEqualTo(Short value) {
            addCriterion("ORG_MATCH >=", value, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchLessThan(Short value) {
            addCriterion("ORG_MATCH <", value, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchLessThanOrEqualTo(Short value) {
            addCriterion("ORG_MATCH <=", value, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchIn(List<Short> values) {
            addCriterion("ORG_MATCH in", values, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchNotIn(List<Short> values) {
            addCriterion("ORG_MATCH not in", values, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchBetween(Short value1, Short value2) {
            addCriterion("ORG_MATCH between", value1, value2, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andOrgMatchNotBetween(Short value1, Short value2) {
            addCriterion("ORG_MATCH not between", value1, value2, "orgMatch");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Short value) {
            addCriterion("TOTAL =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Short value) {
            addCriterion("TOTAL <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Short value) {
            addCriterion("TOTAL >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("TOTAL >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Short value) {
            addCriterion("TOTAL <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Short value) {
            addCriterion("TOTAL <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Short> values) {
            addCriterion("TOTAL in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Short> values) {
            addCriterion("TOTAL not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Short value1, Short value2) {
            addCriterion("TOTAL between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Short value1, Short value2) {
            addCriterion("TOTAL not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andOrgCommentIsNull() {
            addCriterion("ORG_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andOrgCommentIsNotNull() {
            addCriterion("ORG_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCommentEqualTo(String value) {
            addCriterion("ORG_COMMENT =", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentNotEqualTo(String value) {
            addCriterion("ORG_COMMENT <>", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentGreaterThan(String value) {
            addCriterion("ORG_COMMENT >", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_COMMENT >=", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentLessThan(String value) {
            addCriterion("ORG_COMMENT <", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentLessThanOrEqualTo(String value) {
            addCriterion("ORG_COMMENT <=", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentLike(String value) {
            addCriterion("ORG_COMMENT like", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentNotLike(String value) {
            addCriterion("ORG_COMMENT not like", value, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentIn(List<String> values) {
            addCriterion("ORG_COMMENT in", values, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentNotIn(List<String> values) {
            addCriterion("ORG_COMMENT not in", values, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentBetween(String value1, String value2) {
            addCriterion("ORG_COMMENT between", value1, value2, "orgComment");
            return (Criteria) this;
        }

        public Criteria andOrgCommentNotBetween(String value1, String value2) {
            addCriterion("ORG_COMMENT not between", value1, value2, "orgComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentIsNull() {
            addCriterion("HR_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andHrCommentIsNotNull() {
            addCriterion("HR_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andHrCommentEqualTo(String value) {
            addCriterion("HR_COMMENT =", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentNotEqualTo(String value) {
            addCriterion("HR_COMMENT <>", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentGreaterThan(String value) {
            addCriterion("HR_COMMENT >", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentGreaterThanOrEqualTo(String value) {
            addCriterion("HR_COMMENT >=", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentLessThan(String value) {
            addCriterion("HR_COMMENT <", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentLessThanOrEqualTo(String value) {
            addCriterion("HR_COMMENT <=", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentLike(String value) {
            addCriterion("HR_COMMENT like", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentNotLike(String value) {
            addCriterion("HR_COMMENT not like", value, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentIn(List<String> values) {
            addCriterion("HR_COMMENT in", values, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentNotIn(List<String> values) {
            addCriterion("HR_COMMENT not in", values, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentBetween(String value1, String value2) {
            addCriterion("HR_COMMENT between", value1, value2, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentNotBetween(String value1, String value2) {
            addCriterion("HR_COMMENT not between", value1, value2, "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkIsNull() {
            addCriterion("HR_SYS_THINK is null");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkIsNotNull() {
            addCriterion("HR_SYS_THINK is not null");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkEqualTo(Short value) {
            addCriterion("HR_SYS_THINK =", value, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkNotEqualTo(Short value) {
            addCriterion("HR_SYS_THINK <>", value, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkGreaterThan(Short value) {
            addCriterion("HR_SYS_THINK >", value, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_SYS_THINK >=", value, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkLessThan(Short value) {
            addCriterion("HR_SYS_THINK <", value, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkLessThanOrEqualTo(Short value) {
            addCriterion("HR_SYS_THINK <=", value, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkIn(List<Short> values) {
            addCriterion("HR_SYS_THINK in", values, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkNotIn(List<Short> values) {
            addCriterion("HR_SYS_THINK not in", values, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkBetween(Short value1, Short value2) {
            addCriterion("HR_SYS_THINK between", value1, value2, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrSysThinkNotBetween(Short value1, Short value2) {
            addCriterion("HR_SYS_THINK not between", value1, value2, "hrSysThink");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateIsNull() {
            addCriterion("HR_COMMUNICATE is null");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateIsNotNull() {
            addCriterion("HR_COMMUNICATE is not null");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateEqualTo(Short value) {
            addCriterion("HR_COMMUNICATE =", value, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateNotEqualTo(Short value) {
            addCriterion("HR_COMMUNICATE <>", value, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateGreaterThan(Short value) {
            addCriterion("HR_COMMUNICATE >", value, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_COMMUNICATE >=", value, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateLessThan(Short value) {
            addCriterion("HR_COMMUNICATE <", value, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateLessThanOrEqualTo(Short value) {
            addCriterion("HR_COMMUNICATE <=", value, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateIn(List<Short> values) {
            addCriterion("HR_COMMUNICATE in", values, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateNotIn(List<Short> values) {
            addCriterion("HR_COMMUNICATE not in", values, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateBetween(Short value1, Short value2) {
            addCriterion("HR_COMMUNICATE between", value1, value2, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrCommunicateNotBetween(Short value1, Short value2) {
            addCriterion("HR_COMMUNICATE not between", value1, value2, "hrCommunicate");
            return (Criteria) this;
        }

        public Criteria andHrStudyIsNull() {
            addCriterion("HR_STUDY is null");
            return (Criteria) this;
        }

        public Criteria andHrStudyIsNotNull() {
            addCriterion("HR_STUDY is not null");
            return (Criteria) this;
        }

        public Criteria andHrStudyEqualTo(Short value) {
            addCriterion("HR_STUDY =", value, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyNotEqualTo(Short value) {
            addCriterion("HR_STUDY <>", value, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyGreaterThan(Short value) {
            addCriterion("HR_STUDY >", value, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_STUDY >=", value, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyLessThan(Short value) {
            addCriterion("HR_STUDY <", value, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyLessThanOrEqualTo(Short value) {
            addCriterion("HR_STUDY <=", value, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyIn(List<Short> values) {
            addCriterion("HR_STUDY in", values, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyNotIn(List<Short> values) {
            addCriterion("HR_STUDY not in", values, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyBetween(Short value1, Short value2) {
            addCriterion("HR_STUDY between", value1, value2, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrStudyNotBetween(Short value1, Short value2) {
            addCriterion("HR_STUDY not between", value1, value2, "hrStudy");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkIsNull() {
            addCriterion("HR_TEAM_WORK is null");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkIsNotNull() {
            addCriterion("HR_TEAM_WORK is not null");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkEqualTo(Short value) {
            addCriterion("HR_TEAM_WORK =", value, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkNotEqualTo(Short value) {
            addCriterion("HR_TEAM_WORK <>", value, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkGreaterThan(Short value) {
            addCriterion("HR_TEAM_WORK >", value, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_TEAM_WORK >=", value, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkLessThan(Short value) {
            addCriterion("HR_TEAM_WORK <", value, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkLessThanOrEqualTo(Short value) {
            addCriterion("HR_TEAM_WORK <=", value, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkIn(List<Short> values) {
            addCriterion("HR_TEAM_WORK in", values, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkNotIn(List<Short> values) {
            addCriterion("HR_TEAM_WORK not in", values, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkBetween(Short value1, Short value2) {
            addCriterion("HR_TEAM_WORK between", value1, value2, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrTeamWorkNotBetween(Short value1, Short value2) {
            addCriterion("HR_TEAM_WORK not between", value1, value2, "hrTeamWork");
            return (Criteria) this;
        }

        public Criteria andHrInnovateIsNull() {
            addCriterion("HR_INNOVATE is null");
            return (Criteria) this;
        }

        public Criteria andHrInnovateIsNotNull() {
            addCriterion("HR_INNOVATE is not null");
            return (Criteria) this;
        }

        public Criteria andHrInnovateEqualTo(Short value) {
            addCriterion("HR_INNOVATE =", value, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateNotEqualTo(Short value) {
            addCriterion("HR_INNOVATE <>", value, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateGreaterThan(Short value) {
            addCriterion("HR_INNOVATE >", value, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_INNOVATE >=", value, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateLessThan(Short value) {
            addCriterion("HR_INNOVATE <", value, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateLessThanOrEqualTo(Short value) {
            addCriterion("HR_INNOVATE <=", value, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateIn(List<Short> values) {
            addCriterion("HR_INNOVATE in", values, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateNotIn(List<Short> values) {
            addCriterion("HR_INNOVATE not in", values, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateBetween(Short value1, Short value2) {
            addCriterion("HR_INNOVATE between", value1, value2, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrInnovateNotBetween(Short value1, Short value2) {
            addCriterion("HR_INNOVATE not between", value1, value2, "hrInnovate");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeIsNull() {
            addCriterion("HR_MAJOR_KNOWLEDGE is null");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeIsNotNull() {
            addCriterion("HR_MAJOR_KNOWLEDGE is not null");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeEqualTo(Short value) {
            addCriterion("HR_MAJOR_KNOWLEDGE =", value, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeNotEqualTo(Short value) {
            addCriterion("HR_MAJOR_KNOWLEDGE <>", value, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeGreaterThan(Short value) {
            addCriterion("HR_MAJOR_KNOWLEDGE >", value, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_MAJOR_KNOWLEDGE >=", value, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeLessThan(Short value) {
            addCriterion("HR_MAJOR_KNOWLEDGE <", value, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeLessThanOrEqualTo(Short value) {
            addCriterion("HR_MAJOR_KNOWLEDGE <=", value, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeIn(List<Short> values) {
            addCriterion("HR_MAJOR_KNOWLEDGE in", values, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeNotIn(List<Short> values) {
            addCriterion("HR_MAJOR_KNOWLEDGE not in", values, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeBetween(Short value1, Short value2) {
            addCriterion("HR_MAJOR_KNOWLEDGE between", value1, value2, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorKnowledgeNotBetween(Short value1, Short value2) {
            addCriterion("HR_MAJOR_KNOWLEDGE not between", value1, value2, "hrMajorKnowledge");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillIsNull() {
            addCriterion("HR_MAJOR_SKILL is null");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillIsNotNull() {
            addCriterion("HR_MAJOR_SKILL is not null");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillEqualTo(Short value) {
            addCriterion("HR_MAJOR_SKILL =", value, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillNotEqualTo(Short value) {
            addCriterion("HR_MAJOR_SKILL <>", value, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillGreaterThan(Short value) {
            addCriterion("HR_MAJOR_SKILL >", value, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_MAJOR_SKILL >=", value, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillLessThan(Short value) {
            addCriterion("HR_MAJOR_SKILL <", value, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillLessThanOrEqualTo(Short value) {
            addCriterion("HR_MAJOR_SKILL <=", value, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillIn(List<Short> values) {
            addCriterion("HR_MAJOR_SKILL in", values, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillNotIn(List<Short> values) {
            addCriterion("HR_MAJOR_SKILL not in", values, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillBetween(Short value1, Short value2) {
            addCriterion("HR_MAJOR_SKILL between", value1, value2, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorSkillNotBetween(Short value1, Short value2) {
            addCriterion("HR_MAJOR_SKILL not between", value1, value2, "hrMajorSkill");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpIsNull() {
            addCriterion("HR_MAJOR_EXP is null");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpIsNotNull() {
            addCriterion("HR_MAJOR_EXP is not null");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpEqualTo(Short value) {
            addCriterion("HR_MAJOR_EXP =", value, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpNotEqualTo(Short value) {
            addCriterion("HR_MAJOR_EXP <>", value, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpGreaterThan(Short value) {
            addCriterion("HR_MAJOR_EXP >", value, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_MAJOR_EXP >=", value, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpLessThan(Short value) {
            addCriterion("HR_MAJOR_EXP <", value, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpLessThanOrEqualTo(Short value) {
            addCriterion("HR_MAJOR_EXP <=", value, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpIn(List<Short> values) {
            addCriterion("HR_MAJOR_EXP in", values, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpNotIn(List<Short> values) {
            addCriterion("HR_MAJOR_EXP not in", values, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpBetween(Short value1, Short value2) {
            addCriterion("HR_MAJOR_EXP between", value1, value2, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrMajorExpNotBetween(Short value1, Short value2) {
            addCriterion("HR_MAJOR_EXP not between", value1, value2, "hrMajorExp");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchIsNull() {
            addCriterion("HR_POSITION_MATCH is null");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchIsNotNull() {
            addCriterion("HR_POSITION_MATCH is not null");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchEqualTo(Short value) {
            addCriterion("HR_POSITION_MATCH =", value, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchNotEqualTo(Short value) {
            addCriterion("HR_POSITION_MATCH <>", value, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchGreaterThan(Short value) {
            addCriterion("HR_POSITION_MATCH >", value, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_POSITION_MATCH >=", value, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchLessThan(Short value) {
            addCriterion("HR_POSITION_MATCH <", value, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchLessThanOrEqualTo(Short value) {
            addCriterion("HR_POSITION_MATCH <=", value, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchIn(List<Short> values) {
            addCriterion("HR_POSITION_MATCH in", values, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchNotIn(List<Short> values) {
            addCriterion("HR_POSITION_MATCH not in", values, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchBetween(Short value1, Short value2) {
            addCriterion("HR_POSITION_MATCH between", value1, value2, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrPositionMatchNotBetween(Short value1, Short value2) {
            addCriterion("HR_POSITION_MATCH not between", value1, value2, "hrPositionMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchIsNull() {
            addCriterion("HR_ORG_MATCH is null");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchIsNotNull() {
            addCriterion("HR_ORG_MATCH is not null");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchEqualTo(Short value) {
            addCriterion("HR_ORG_MATCH =", value, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchNotEqualTo(Short value) {
            addCriterion("HR_ORG_MATCH <>", value, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchGreaterThan(Short value) {
            addCriterion("HR_ORG_MATCH >", value, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_ORG_MATCH >=", value, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchLessThan(Short value) {
            addCriterion("HR_ORG_MATCH <", value, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchLessThanOrEqualTo(Short value) {
            addCriterion("HR_ORG_MATCH <=", value, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchIn(List<Short> values) {
            addCriterion("HR_ORG_MATCH in", values, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchNotIn(List<Short> values) {
            addCriterion("HR_ORG_MATCH not in", values, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchBetween(Short value1, Short value2) {
            addCriterion("HR_ORG_MATCH between", value1, value2, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrOrgMatchNotBetween(Short value1, Short value2) {
            addCriterion("HR_ORG_MATCH not between", value1, value2, "hrOrgMatch");
            return (Criteria) this;
        }

        public Criteria andHrIdIsNull() {
            addCriterion("HR_ID is null");
            return (Criteria) this;
        }

        public Criteria andHrIdIsNotNull() {
            addCriterion("HR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHrIdEqualTo(String value) {
            addCriterion("HR_ID =", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotEqualTo(String value) {
            addCriterion("HR_ID <>", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdGreaterThan(String value) {
            addCriterion("HR_ID >", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdGreaterThanOrEqualTo(String value) {
            addCriterion("HR_ID >=", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdLessThan(String value) {
            addCriterion("HR_ID <", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdLessThanOrEqualTo(String value) {
            addCriterion("HR_ID <=", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdLike(String value) {
            addCriterion("HR_ID like", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotLike(String value) {
            addCriterion("HR_ID not like", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdIn(List<String> values) {
            addCriterion("HR_ID in", values, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotIn(List<String> values) {
            addCriterion("HR_ID not in", values, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdBetween(String value1, String value2) {
            addCriterion("HR_ID between", value1, value2, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotBetween(String value1, String value2) {
            addCriterion("HR_ID not between", value1, value2, "hrId");
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

        public Criteria andHrTotalIsNull() {
            addCriterion("HR_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andHrTotalIsNotNull() {
            addCriterion("HR_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andHrTotalEqualTo(Short value) {
            addCriterion("HR_TOTAL =", value, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalNotEqualTo(Short value) {
            addCriterion("HR_TOTAL <>", value, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalGreaterThan(Short value) {
            addCriterion("HR_TOTAL >", value, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("HR_TOTAL >=", value, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalLessThan(Short value) {
            addCriterion("HR_TOTAL <", value, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalLessThanOrEqualTo(Short value) {
            addCriterion("HR_TOTAL <=", value, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalIn(List<Short> values) {
            addCriterion("HR_TOTAL in", values, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalNotIn(List<Short> values) {
            addCriterion("HR_TOTAL not in", values, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalBetween(Short value1, Short value2) {
            addCriterion("HR_TOTAL between", value1, value2, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrTotalNotBetween(Short value1, Short value2) {
            addCriterion("HR_TOTAL not between", value1, value2, "hrTotal");
            return (Criteria) this;
        }

        public Criteria andHrResultIsNull() {
            addCriterion("HR_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andHrResultIsNotNull() {
            addCriterion("HR_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andHrResultEqualTo(String value) {
            addCriterion("HR_RESULT =", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultNotEqualTo(String value) {
            addCriterion("HR_RESULT <>", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultGreaterThan(String value) {
            addCriterion("HR_RESULT >", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultGreaterThanOrEqualTo(String value) {
            addCriterion("HR_RESULT >=", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultLessThan(String value) {
            addCriterion("HR_RESULT <", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultLessThanOrEqualTo(String value) {
            addCriterion("HR_RESULT <=", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultLike(String value) {
            addCriterion("HR_RESULT like", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultNotLike(String value) {
            addCriterion("HR_RESULT not like", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultIn(List<String> values) {
            addCriterion("HR_RESULT in", values, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultNotIn(List<String> values) {
            addCriterion("HR_RESULT not in", values, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultBetween(String value1, String value2) {
            addCriterion("HR_RESULT between", value1, value2, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultNotBetween(String value1, String value2) {
            addCriterion("HR_RESULT not between", value1, value2, "hrResult");
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

        public Criteria andPositionIdLikeInsensitive(String value) {
            addCriterion("upper(POSITION_ID) like", value.toUpperCase(), "positionId");
            return (Criteria) this;
        }

        public Criteria andResultLikeInsensitive(String value) {
            addCriterion("upper(RESULT) like", value.toUpperCase(), "result");
            return (Criteria) this;
        }

        public Criteria andOrgCommentLikeInsensitive(String value) {
            addCriterion("upper(ORG_COMMENT) like", value.toUpperCase(), "orgComment");
            return (Criteria) this;
        }

        public Criteria andHrCommentLikeInsensitive(String value) {
            addCriterion("upper(HR_COMMENT) like", value.toUpperCase(), "hrComment");
            return (Criteria) this;
        }

        public Criteria andHrIdLikeInsensitive(String value) {
            addCriterion("upper(HR_ID) like", value.toUpperCase(), "hrId");
            return (Criteria) this;
        }

        public Criteria andInterviewersLikeInsensitive(String value) {
            addCriterion("upper(INTERVIEWERS) like", value.toUpperCase(), "interviewers");
            return (Criteria) this;
        }

        public Criteria andHrResultLikeInsensitive(String value) {
            addCriterion("upper(HR_RESULT) like", value.toUpperCase(), "hrResult");
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