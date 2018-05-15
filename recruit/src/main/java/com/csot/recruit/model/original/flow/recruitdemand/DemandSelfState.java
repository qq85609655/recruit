package com.csot.recruit.model.original.flow.recruitdemand;

/**
 * 招聘需求列表状态枚举
 * 
 * @author 李耀东
 *
 */
public enum DemandSelfState {
  /**
   * 全部招聘需求
   */
  ALL("0"),
  /**
   * 草稿招聘需求
   */
  DRAFT("1"),
  /**
   * 审核中招聘需求
   */
  AUDIT("2"),
  /**
   * 审批通过招聘需求
   */
  APPROVE("3"),
  /**
   * 未完成招聘需求
   */
  NOTFINISHED("4"),
  /**
   * 已完成招聘需求
   */
  FINISHED("5"),
  /**
   * 审批通过并且未完成的招聘需求
   */
  PASSANDNOTFINISHED("6"), /**
   * 废弃的需求
   */
  DISCARD("7"), /**
   * 取消的需求
   */
  CANCEL("8");

  private DemandSelfState(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  private String value;

}