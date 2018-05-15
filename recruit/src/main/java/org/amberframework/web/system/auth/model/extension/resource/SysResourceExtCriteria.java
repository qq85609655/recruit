package org.amberframework.web.system.auth.model.extension.resource;

import java.util.ArrayList;
import java.util.List;
import org.amberframework.core.mybatis.pojo.Page;

public class SysResourceExtCriteria {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  protected Page page;

  public SysResourceExtCriteria() {
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

  /**
   * This one was generated by MyBatis Generator.
   *
   * @mbggenerated
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * This one was generated by MyBatis Generator.
   *
   * @mbggenerated
   */
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

  /**
   * This one was generated by MyBatis Generator.
   *
   * @mbggenerated
   */
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

    public Criteria andIdEqualTo(Long value) {
      addCriterion("ID =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(Long value) {
      addCriterion("ID <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(Long value) {
      addCriterion("ID >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("ID >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(Long value) {
      addCriterion("ID <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("ID <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<Long> values) {
      addCriterion("ID in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<Long> values) {
      addCriterion("ID not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("ID between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(Long value1, Long value2) {
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

    public Criteria andMenuNameIsNull() {
      addCriterion("MENU_NAME is null");
      return (Criteria) this;
    }

    public Criteria andMenuNameIsNotNull() {
      addCriterion("MENU_NAME is not null");
      return (Criteria) this;
    }

    public Criteria andMenuNameEqualTo(String value) {
      addCriterion("MENU_NAME =", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameNotEqualTo(String value) {
      addCriterion("MENU_NAME <>", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameGreaterThan(String value) {
      addCriterion("MENU_NAME >", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
      addCriterion("MENU_NAME >=", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameLessThan(String value) {
      addCriterion("MENU_NAME <", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameLessThanOrEqualTo(String value) {
      addCriterion("MENU_NAME <=", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameLike(String value) {
      addCriterion("MENU_NAME like", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameNotLike(String value) {
      addCriterion("MENU_NAME not like", value, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameIn(List<String> values) {
      addCriterion("MENU_NAME in", values, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameNotIn(List<String> values) {
      addCriterion("MENU_NAME not in", values, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameBetween(String value1, String value2) {
      addCriterion("MENU_NAME between", value1, value2, "menuName");
      return (Criteria) this;
    }

    public Criteria andMenuNameNotBetween(String value1, String value2) {
      addCriterion("MENU_NAME not between", value1, value2, "menuName");
      return (Criteria) this;
    }

    public Criteria andUrlIsNull() {
      addCriterion("URL is null");
      return (Criteria) this;
    }

    public Criteria andUrlIsNotNull() {
      addCriterion("URL is not null");
      return (Criteria) this;
    }

    public Criteria andUrlEqualTo(String value) {
      addCriterion("URL =", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotEqualTo(String value) {
      addCriterion("URL <>", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThan(String value) {
      addCriterion("URL >", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThanOrEqualTo(String value) {
      addCriterion("URL >=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThan(String value) {
      addCriterion("URL <", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThanOrEqualTo(String value) {
      addCriterion("URL <=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLike(String value) {
      addCriterion("URL like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotLike(String value) {
      addCriterion("URL not like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlIn(List<String> values) {
      addCriterion("URL in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotIn(List<String> values) {
      addCriterion("URL not in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlBetween(String value1, String value2) {
      addCriterion("URL between", value1, value2, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotBetween(String value1, String value2) {
      addCriterion("URL not between", value1, value2, "url");
      return (Criteria) this;
    }

    public Criteria andParentIdIsNull() {
      addCriterion("PARENT_ID is null");
      return (Criteria) this;
    }

    public Criteria andParentIdIsNotNull() {
      addCriterion("PARENT_ID is not null");
      return (Criteria) this;
    }

    public Criteria andParentIdEqualTo(Long value) {
      addCriterion("PARENT_ID =", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotEqualTo(Long value) {
      addCriterion("PARENT_ID <>", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThan(Long value) {
      addCriterion("PARENT_ID >", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
      addCriterion("PARENT_ID >=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThan(Long value) {
      addCriterion("PARENT_ID <", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThanOrEqualTo(Long value) {
      addCriterion("PARENT_ID <=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdIn(List<Long> values) {
      addCriterion("PARENT_ID in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotIn(List<Long> values) {
      addCriterion("PARENT_ID not in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdBetween(Long value1, Long value2) {
      addCriterion("PARENT_ID between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotBetween(Long value1, Long value2) {
      addCriterion("PARENT_ID not between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdsIsNull() {
      addCriterion("PARENT_IDS is null");
      return (Criteria) this;
    }

    public Criteria andParentIdsIsNotNull() {
      addCriterion("PARENT_IDS is not null");
      return (Criteria) this;
    }

    public Criteria andParentIdsEqualTo(String value) {
      addCriterion("PARENT_IDS =", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsNotEqualTo(String value) {
      addCriterion("PARENT_IDS <>", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsGreaterThan(String value) {
      addCriterion("PARENT_IDS >", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsGreaterThanOrEqualTo(String value) {
      addCriterion("PARENT_IDS >=", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsLessThan(String value) {
      addCriterion("PARENT_IDS <", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsLessThanOrEqualTo(String value) {
      addCriterion("PARENT_IDS <=", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsLike(String value) {
      addCriterion("PARENT_IDS like", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsNotLike(String value) {
      addCriterion("PARENT_IDS not like", value, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsIn(List<String> values) {
      addCriterion("PARENT_IDS in", values, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsNotIn(List<String> values) {
      addCriterion("PARENT_IDS not in", values, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsBetween(String value1, String value2) {
      addCriterion("PARENT_IDS between", value1, value2, "parentIds");
      return (Criteria) this;
    }

    public Criteria andParentIdsNotBetween(String value1, String value2) {
      addCriterion("PARENT_IDS not between", value1, value2, "parentIds");
      return (Criteria) this;
    }

    public Criteria andIconIsNull() {
      addCriterion("ICON is null");
      return (Criteria) this;
    }

    public Criteria andIconIsNotNull() {
      addCriterion("ICON is not null");
      return (Criteria) this;
    }

    public Criteria andIconEqualTo(String value) {
      addCriterion("ICON =", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotEqualTo(String value) {
      addCriterion("ICON <>", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconGreaterThan(String value) {
      addCriterion("ICON >", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconGreaterThanOrEqualTo(String value) {
      addCriterion("ICON >=", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconLessThan(String value) {
      addCriterion("ICON <", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconLessThanOrEqualTo(String value) {
      addCriterion("ICON <=", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconLike(String value) {
      addCriterion("ICON like", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotLike(String value) {
      addCriterion("ICON not like", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconIn(List<String> values) {
      addCriterion("ICON in", values, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotIn(List<String> values) {
      addCriterion("ICON not in", values, "icon");
      return (Criteria) this;
    }

    public Criteria andIconBetween(String value1, String value2) {
      addCriterion("ICON between", value1, value2, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotBetween(String value1, String value2) {
      addCriterion("ICON not between", value1, value2, "icon");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuIsNull() {
      addCriterion("SHOW_AS_MENU is null");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuIsNotNull() {
      addCriterion("SHOW_AS_MENU is not null");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuEqualTo(String value) {
      addCriterion("SHOW_AS_MENU =", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuNotEqualTo(String value) {
      addCriterion("SHOW_AS_MENU <>", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuGreaterThan(String value) {
      addCriterion("SHOW_AS_MENU >", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuGreaterThanOrEqualTo(String value) {
      addCriterion("SHOW_AS_MENU >=", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuLessThan(String value) {
      addCriterion("SHOW_AS_MENU <", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuLessThanOrEqualTo(String value) {
      addCriterion("SHOW_AS_MENU <=", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuLike(String value) {
      addCriterion("SHOW_AS_MENU like", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuNotLike(String value) {
      addCriterion("SHOW_AS_MENU not like", value, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuIn(List<String> values) {
      addCriterion("SHOW_AS_MENU in", values, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuNotIn(List<String> values) {
      addCriterion("SHOW_AS_MENU not in", values, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuBetween(String value1, String value2) {
      addCriterion("SHOW_AS_MENU between", value1, value2, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuNotBetween(String value1, String value2) {
      addCriterion("SHOW_AS_MENU not between", value1, value2, "showAsMenu");
      return (Criteria) this;
    }

    public Criteria andNameLikeInsensitive(String value) {
      addCriterion("upper(NAME) like", value.toUpperCase(), "name");
      return (Criteria) this;
    }

    public Criteria andMenuNameLikeInsensitive(String value) {
      addCriterion("upper(MENU_NAME) like", value.toUpperCase(), "menuName");
      return (Criteria) this;
    }

    public Criteria andUrlLikeInsensitive(String value) {
      addCriterion("upper(URL) like", value.toUpperCase(), "url");
      return (Criteria) this;
    }

    public Criteria andParentIdsLikeInsensitive(String value) {
      addCriterion("upper(PARENT_IDS) like", value.toUpperCase(), "parentIds");
      return (Criteria) this;
    }

    public Criteria andIconLikeInsensitive(String value) {
      addCriterion("upper(ICON) like", value.toUpperCase(), "icon");
      return (Criteria) this;
    }

    public Criteria andShowAsMenuLikeInsensitive(String value) {
      addCriterion("upper(SHOW_AS_MENU) like", value.toUpperCase(), "showAsMenu");
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