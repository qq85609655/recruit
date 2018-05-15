package com.csot.recruit.model.original.flow.websitePost;

import java.io.Serializable;
import java.util.Date;

public class InstructSimpleDetail implements Serializable {
  /**
   * 发布网站
   */
  private String websiteType;
  /**
   * 发布网站名称
   */
  private String name;
  /**
   * 当前状态
   */
  private String state;
  /**
   * 发布指令类型
   */
  private String instruct;

  public enum instruct {
    FB(1, "发布"), XG(2, "修改"), ZT(3, "暂停"), CQ(4, "重启"), CXFB(5, "删除并且重新发布"), SC(6, "删除");
    private int value;
    private String text;

    private instruct(int value, String text) {
      this.value = value;
      this.text = text;
    }

    public int getValue() {
      return this.value;
    }

    public String getValueStr() {
      return String.valueOf(this.value);
    }

    public String getText() {
      return this.text;
    }
  }

  public String getWebsiteType() {
    return websiteType;
  }

  public void setWebsiteType(String websiteType) {
    this.websiteType = websiteType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getInstruct() {
    return instruct;
  }

  public void setInstruct(String instruct) {
    this.instruct = instruct;
  }

}
