package com.csot.recruit.model.position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class RecruitPositionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RecruitPositionCriteria() {
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

        public Criteria andRecruitPositionIdIsNull() {
            addCriterion("recruit_position_id is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNotNull() {
            addCriterion("recruit_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdEqualTo(String value) {
            addCriterion("recruit_position_id =", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotEqualTo(String value) {
            addCriterion("recruit_position_id <>", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThan(String value) {
            addCriterion("recruit_position_id >", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_position_id >=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThan(String value) {
            addCriterion("recruit_position_id <", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThanOrEqualTo(String value) {
            addCriterion("recruit_position_id <=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLike(String value) {
            addCriterion("recruit_position_id like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotLike(String value) {
            addCriterion("recruit_position_id not like", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIn(List<String> values) {
            addCriterion("recruit_position_id in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotIn(List<String> values) {
            addCriterion("recruit_position_id not in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdBetween(String value1, String value2) {
            addCriterion("recruit_position_id between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotBetween(String value1, String value2) {
            addCriterion("recruit_position_id not between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("position_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("position_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("trim(position_name) =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("position_name <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("position_name >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_name >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("position_name <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("position_name <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("position_name like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("position_name not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("position_name in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("position_name not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("position_name between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("position_name not between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNull() {
            addCriterion("position_code is null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNotNull() {
            addCriterion("position_code is not null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeEqualTo(String value) {
            addCriterion("position_code =", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotEqualTo(String value) {
            addCriterion("position_code <>", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThan(String value) {
            addCriterion("position_code >", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("position_code >=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThan(String value) {
            addCriterion("position_code <", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThanOrEqualTo(String value) {
            addCriterion("position_code <=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLike(String value) {
            addCriterion("position_code like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotLike(String value) {
            addCriterion("position_code not like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIn(List<String> values) {
            addCriterion("position_code in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotIn(List<String> values) {
            addCriterion("position_code not in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeBetween(String value1, String value2) {
            addCriterion("position_code between", value1, value2, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotBetween(String value1, String value2) {
            addCriterion("position_code not between", value1, value2, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNull() {
            addCriterion("position_type is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNotNull() {
            addCriterion("position_type is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeEqualTo(String value) {
            addCriterion("position_type =", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotEqualTo(String value) {
            addCriterion("position_type <>", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThan(String value) {
            addCriterion("position_type >", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("position_type >=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThan(String value) {
            addCriterion("position_type <", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThanOrEqualTo(String value) {
            addCriterion("position_type <=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLike(String value) {
            addCriterion("position_type like", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotLike(String value) {
            addCriterion("position_type not like", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIn(List<String> values) {
            addCriterion("position_type in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotIn(List<String> values) {
            addCriterion("position_type not in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeBetween(String value1, String value2) {
            addCriterion("position_type between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotBetween(String value1, String value2) {
            addCriterion("position_type not between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionLevelIsNull() {
            addCriterion("position_level is null");
            return (Criteria) this;
        }

        public Criteria andPositionLevelIsNotNull() {
            addCriterion("position_level is not null");
            return (Criteria) this;
        }

        public Criteria andPositionLevelEqualTo(String value) {
            addCriterion("position_level =", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotEqualTo(String value) {
            addCriterion("position_level <>", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelGreaterThan(String value) {
            addCriterion("position_level >", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelGreaterThanOrEqualTo(String value) {
            addCriterion("position_level >=", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelLessThan(String value) {
            addCriterion("position_level <", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelLessThanOrEqualTo(String value) {
            addCriterion("position_level <=", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelLike(String value) {
            addCriterion("position_level like", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotLike(String value) {
            addCriterion("position_level not like", value, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelIn(List<String> values) {
            addCriterion("position_level in", values, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotIn(List<String> values) {
            addCriterion("position_level not in", values, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelBetween(String value1, String value2) {
            addCriterion("position_level between", value1, value2, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionLevelNotBetween(String value1, String value2) {
            addCriterion("position_level not between", value1, value2, "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarIsNull() {
            addCriterion("position_similar is null");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarIsNotNull() {
            addCriterion("position_similar is not null");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarEqualTo(String value) {
            addCriterion("position_similar =", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarNotEqualTo(String value) {
            addCriterion("position_similar <>", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarGreaterThan(String value) {
            addCriterion("position_similar >", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarGreaterThanOrEqualTo(String value) {
            addCriterion("position_similar >=", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarLessThan(String value) {
            addCriterion("position_similar <", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarLessThanOrEqualTo(String value) {
            addCriterion("position_similar <=", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarLike(String value) {
            addCriterion("position_similar like", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarNotLike(String value) {
            addCriterion("position_similar not like", value, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarIn(List<String> values) {
            addCriterion("position_similar in", values, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarNotIn(List<String> values) {
            addCriterion("position_similar not in", values, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarBetween(String value1, String value2) {
            addCriterion("position_similar between", value1, value2, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarNotBetween(String value1, String value2) {
            addCriterion("position_similar not between", value1, value2, "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionRequireIsNull() {
            addCriterion("position_require is null");
            return (Criteria) this;
        }

        public Criteria andPositionRequireIsNotNull() {
            addCriterion("position_require is not null");
            return (Criteria) this;
        }

        public Criteria andPositionRequireEqualTo(String value) {
            addCriterion("position_require =", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotEqualTo(String value) {
            addCriterion("position_require <>", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireGreaterThan(String value) {
            addCriterion("position_require >", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireGreaterThanOrEqualTo(String value) {
            addCriterion("position_require >=", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireLessThan(String value) {
            addCriterion("position_require <", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireLessThanOrEqualTo(String value) {
            addCriterion("position_require <=", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireLike(String value) {
            addCriterion("position_require like", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotLike(String value) {
            addCriterion("position_require not like", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireIn(List<String> values) {
            addCriterion("position_require in", values, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotIn(List<String> values) {
            addCriterion("position_require not in", values, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireBetween(String value1, String value2) {
            addCriterion("position_require between", value1, value2, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotBetween(String value1, String value2) {
            addCriterion("position_require not between", value1, value2, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryIsNull() {
            addCriterion("position_industry is null");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryIsNotNull() {
            addCriterion("position_industry is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryEqualTo(String value) {
            addCriterion("position_industry =", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryNotEqualTo(String value) {
            addCriterion("position_industry <>", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryGreaterThan(String value) {
            addCriterion("position_industry >", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("position_industry >=", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryLessThan(String value) {
            addCriterion("position_industry <", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryLessThanOrEqualTo(String value) {
            addCriterion("position_industry <=", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryLike(String value) {
            addCriterion("position_industry like", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryNotLike(String value) {
            addCriterion("position_industry not like", value, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryIn(List<String> values) {
            addCriterion("position_industry in", values, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryNotIn(List<String> values) {
            addCriterion("position_industry not in", values, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryBetween(String value1, String value2) {
            addCriterion("position_industry between", value1, value2, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryNotBetween(String value1, String value2) {
            addCriterion("position_industry not between", value1, value2, "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionIsNull() {
            addCriterion("position_description is null");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionIsNotNull() {
            addCriterion("position_description is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionEqualTo(String value) {
            addCriterion("position_description =", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotEqualTo(String value) {
            addCriterion("position_description <>", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionGreaterThan(String value) {
            addCriterion("position_description >", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("position_description >=", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionLessThan(String value) {
            addCriterion("position_description <", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("position_description <=", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionLike(String value) {
            addCriterion("position_description like", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotLike(String value) {
            addCriterion("position_description not like", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionIn(List<String> values) {
            addCriterion("position_description in", values, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotIn(List<String> values) {
            addCriterion("position_description not in", values, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionBetween(String value1, String value2) {
            addCriterion("position_description between", value1, value2, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotBetween(String value1, String value2) {
            addCriterion("position_description not between", value1, value2, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andValidatyIsNull() {
            addCriterion("validaty is null");
            return (Criteria) this;
        }

        public Criteria andValidatyIsNotNull() {
            addCriterion("validaty is not null");
            return (Criteria) this;
        }

        public Criteria andValidatyEqualTo(String value) {
            addCriterion("validaty =", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyNotEqualTo(String value) {
            addCriterion("validaty <>", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyGreaterThan(String value) {
            addCriterion("validaty >", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyGreaterThanOrEqualTo(String value) {
            addCriterion("validaty >=", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyLessThan(String value) {
            addCriterion("validaty <", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyLessThanOrEqualTo(String value) {
            addCriterion("validaty <=", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyLike(String value) {
            addCriterion("validaty like", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyNotLike(String value) {
            addCriterion("validaty not like", value, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyIn(List<String> values) {
            addCriterion("validaty in", values, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyNotIn(List<String> values) {
            addCriterion("validaty not in", values, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyBetween(String value1, String value2) {
            addCriterion("validaty between", value1, value2, "validaty");
            return (Criteria) this;
        }

        public Criteria andValidatyNotBetween(String value1, String value2) {
            addCriterion("validaty not between", value1, value2, "validaty");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersIsNull() {
            addCriterion("recruit_numbers is null");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersIsNotNull() {
            addCriterion("recruit_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersEqualTo(BigDecimal value) {
            addCriterion("recruit_numbers =", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersNotEqualTo(BigDecimal value) {
            addCriterion("recruit_numbers <>", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersGreaterThan(BigDecimal value) {
            addCriterion("recruit_numbers >", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recruit_numbers >=", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersLessThan(BigDecimal value) {
            addCriterion("recruit_numbers <", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recruit_numbers <=", value, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersIn(List<BigDecimal> values) {
            addCriterion("recruit_numbers in", values, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersNotIn(List<BigDecimal> values) {
            addCriterion("recruit_numbers not in", values, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recruit_numbers between", value1, value2, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andRecruitNumbersNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recruit_numbers not between", value1, value2, "recruitNumbers");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("salary like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("salary not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIsNull() {
            addCriterion("recruit_type is null");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIsNotNull() {
            addCriterion("recruit_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeEqualTo(String value) {
            addCriterion("recruit_type =", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotEqualTo(String value) {
            addCriterion("recruit_type <>", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeGreaterThan(String value) {
            addCriterion("recruit_type >", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_type >=", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLessThan(String value) {
            addCriterion("recruit_type <", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLessThanOrEqualTo(String value) {
            addCriterion("recruit_type <=", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLike(String value) {
            addCriterion("recruit_type like", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotLike(String value) {
            addCriterion("recruit_type not like", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIn(List<String> values) {
            addCriterion("recruit_type in", values, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotIn(List<String> values) {
            addCriterion("recruit_type not in", values, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeBetween(String value1, String value2) {
            addCriterion("recruit_type between", value1, value2, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotBetween(String value1, String value2) {
            addCriterion("recruit_type not between", value1, value2, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectIsNull() {
            addCriterion("recruit_object is null");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectIsNotNull() {
            addCriterion("recruit_object is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectEqualTo(String value) {
            addCriterion("recruit_object =", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectNotEqualTo(String value) {
            addCriterion("recruit_object <>", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectGreaterThan(String value) {
            addCriterion("recruit_object >", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_object >=", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectLessThan(String value) {
            addCriterion("recruit_object <", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectLessThanOrEqualTo(String value) {
            addCriterion("recruit_object <=", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectLike(String value) {
            addCriterion("recruit_object like", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectNotLike(String value) {
            addCriterion("recruit_object not like", value, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectIn(List<String> values) {
            addCriterion("recruit_object in", values, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectNotIn(List<String> values) {
            addCriterion("recruit_object not in", values, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectBetween(String value1, String value2) {
            addCriterion("recruit_object between", value1, value2, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectNotBetween(String value1, String value2) {
            addCriterion("recruit_object not between", value1, value2, "recruitObject");
            return (Criteria) this;
        }

        public Criteria andSecrecyIsNull() {
            addCriterion("secrecy is null");
            return (Criteria) this;
        }

        public Criteria andSecrecyIsNotNull() {
            addCriterion("secrecy is not null");
            return (Criteria) this;
        }

        public Criteria andSecrecyEqualTo(BigDecimal value) {
            addCriterion("secrecy =", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyNotEqualTo(BigDecimal value) {
            addCriterion("secrecy <>", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyGreaterThan(BigDecimal value) {
            addCriterion("secrecy >", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("secrecy >=", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyLessThan(BigDecimal value) {
            addCriterion("secrecy <", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("secrecy <=", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyIn(List<BigDecimal> values) {
            addCriterion("secrecy in", values, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyNotIn(List<BigDecimal> values) {
            addCriterion("secrecy not in", values, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("secrecy between", value1, value2, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("secrecy not between", value1, value2, "secrecy");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(BigDecimal value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(BigDecimal value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(BigDecimal value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(BigDecimal value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<BigDecimal> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<BigDecimal> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLikeInsensitive(String value) {
            addCriterion("upper(recruit_position_id) like", value.toUpperCase(), "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andPositionNameLikeInsensitive(String value) {
            addCriterion("upper(position_name) like", value.toUpperCase(), "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLikeInsensitive(String value) {
            addCriterion("upper(position_code) like", value.toUpperCase(), "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLikeInsensitive(String value) {
            addCriterion("upper(position_type) like", value.toUpperCase(), "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionLevelLikeInsensitive(String value) {
            addCriterion("upper(position_level) like", value.toUpperCase(), "positionLevel");
            return (Criteria) this;
        }

        public Criteria andPositionSimilarLikeInsensitive(String value) {
            addCriterion("upper(position_similar) like", value.toUpperCase(), "positionSimilar");
            return (Criteria) this;
        }

        public Criteria andPositionRequireLikeInsensitive(String value) {
            addCriterion("upper(position_require) like", value.toUpperCase(), "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionIndustryLikeInsensitive(String value) {
            addCriterion("upper(position_industry) like", value.toUpperCase(), "positionIndustry");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionLikeInsensitive(String value) {
            addCriterion("upper(position_description) like", value.toUpperCase(), "positionDescription");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLikeInsensitive(String value) {
            addCriterion("upper(work_place) like", value.toUpperCase(), "workPlace");
            return (Criteria) this;
        }

        public Criteria andValidatyLikeInsensitive(String value) {
            addCriterion("upper(validaty) like", value.toUpperCase(), "validaty");
            return (Criteria) this;
        }

        public Criteria andSalaryLikeInsensitive(String value) {
            addCriterion("upper(salary) like", value.toUpperCase(), "salary");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLikeInsensitive(String value) {
            addCriterion("upper(recruit_type) like", value.toUpperCase(), "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitObjectLikeInsensitive(String value) {
            addCriterion("upper(recruit_object) like", value.toUpperCase(), "recruitObject");
            return (Criteria) this;
        }

        public Criteria andLabelLikeInsensitive(String value) {
            addCriterion("upper(label) like", value.toUpperCase(), "label");
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