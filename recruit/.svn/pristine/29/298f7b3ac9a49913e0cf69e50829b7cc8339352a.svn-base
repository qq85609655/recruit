package com.csot.recruit.common.util;

import com.csot.recruit.model.original.flow.websitePost.PostWebsite;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstruct;


public class EnumUtil {
  /**
   * 获取岗位发布指令类型名称
   * 
   * @param type
   * @return
   */
  public static String getInstructNameByType(String type) {
    if (PostWebsite.lastInstruct.FB.getValueStr().equals(type)) {
      return PostWebsite.lastInstruct.FB.getText();
    }
    if (PostWebsite.lastInstruct.XG.getValueStr().equals(type)) {
      return PostWebsite.lastInstruct.XG.getText();
    }
    if (PostWebsite.lastInstruct.ZT.getValueStr().equals(type)) {
      return PostWebsite.lastInstruct.ZT.getText();
    }
    if (PostWebsite.lastInstruct.CQ.getValueStr().equals(type)) {
      return PostWebsite.lastInstruct.CQ.getText();
    }
    return "";
  }
  

  /**
   * 获取岗位发布状态
   * 
   * @param type
   * @return
   */
  public static String getStateNameByType(String type) {
    if (PostWebsite.state.FBZ.getValueStr().equals(type)) {
      return PostWebsite.state.FBZ.getText();
    }
    if (PostWebsite.state.WFB.getValueStr().equals(type)) {
      return PostWebsite.state.WFB.getText();
    }
    if (PostWebsite.state.ZT.getValueStr().equals(type)) {
      return PostWebsite.state.ZT.getText();
    }
    return "";
  }
  
  /**
   * 获取指令是否操作字典
   * @param type
   * @return
   */
  public static String getIsDealNameByType(String type) {
    if (PostWebsiteInstruct.isDeal.YES.getValueStr().equals(type)) {
      return PostWebsiteInstruct.isDeal.YES.getText();
    }
    if (PostWebsiteInstruct.isDeal.NO.getValueStr().equals(type)) {
      return PostWebsiteInstruct.isDeal.NO.getText();
    }
    return "";
  }


  /**
   * 获取发布渠道字典数据
   * 
   * @param value
   * @return
   */
  public static String getWebsiteNameByType(String value) {
    if (PostWebsite.websiteType.QCWY.getValueStr().equals(value)) {
      return PostWebsite.websiteType.QCWY.getText();
    }
    if (PostWebsite.websiteType.ZL.getValueStr().equals(value)) {
      return PostWebsite.websiteType.ZL.getText();
    }
    if (PostWebsite.websiteType.LPW.getValueStr().equals(value)) {
      return PostWebsite.websiteType.LPW.getText();
    }
    if (PostWebsite.websiteType.RCRX.getValueStr().equals(value)) {
      return PostWebsite.websiteType.RCRX.getText();
    }
    if (PostWebsite.websiteType.HXGW.getValueStr().equals(value)) {
      return PostWebsite.websiteType.HXGW.getText();
    }
    if (PostWebsite.websiteType.JK.getValueStr().equals(value)) {
      return PostWebsite.websiteType.JK.getText();
    }
    if (PostWebsite.websiteType.WB.getValueStr().equals(value)) {
      return PostWebsite.websiteType.WB.getText();
    }
    if (PostWebsite.websiteType.GJW.getValueStr().equals(value)) {
      return PostWebsite.websiteType.GJW.getText();
    }
    return "";
  }
}
