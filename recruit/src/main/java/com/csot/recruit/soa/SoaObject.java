package com.csot.recruit.soa;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * WEBSERVICE自定义通用对象
 * 
 * @author 李耀东
 *
 */
public class SoaObject {

  Gson gson = new Gson();

  private String appid; // 业务应用ID
  private String appname;// 业务应用名称
  private String modid;// 模块ID
  private String modname;// 模块名称

  /**
   * 初始化WEBSERVICE自定义通用对象
   * 
   * @param appid 务应用ID
   * @param appname 业务应用名称
   * @param modid 模块ID
   * @param modname 模块名称
   */
  public SoaObject(String appid, String appname, String modid, String modname) {
    this.appid = appid;
    this.appname = appname;
    this.modid = modid;
    this.modname = modname;
  }

  private String applyAccount; // 操作人工号
  private String prikey; // 唯一关键字
  private String doccontent; // 文档内容文本
  private String docsubject; // 文档标题
  private String fdtemplateid;// 文档模板ID
  private Object formvalues;// 表单数据参数



  /**
   * 获取流程发起人
   * 
   * @return
   */
  public String getDoccreator() {

    Map<String, String> creatorMap = new HashMap<String, String>();
    creatorMap.put("PersonNo", this.applyAccount);// 放入申请人工号
    return gson.toJson(creatorMap);
  }

  /**
   * 获取转换成json格式的表单对象数据
   * 
   * @return
   */
  public String getFormvalues() {
    return gson.toJson(formvalues);
  }

  /**
   * 设置表单数据
   * 
   * @param formvalues
   */
  public void setFormvalues(Object formvalues) {
    this.formvalues = formvalues;
  }

  public String getApplyAccount() {
    return applyAccount;
  }

  public void setApplyAccount(String applyAccount) {
    this.applyAccount = applyAccount;
  }

  public String getPrikey() {
    return prikey;
  }

  public void setPrikey(String prikey) {
    this.prikey = prikey;
  }

  public String getDoccontent() {
    return doccontent;
  }

  public void setDoccontent(String doccontent) {
    this.doccontent = doccontent;
  }

  public String getDocsubject() {
    return docsubject;
  }

  public void setDocsubject(String docsubject) {
    this.docsubject = docsubject;
  }

  public String getFdtemplateid() {
    return fdtemplateid;
  }

  public void setFdtemplateid(String fdtemplateid) {
    this.fdtemplateid = fdtemplateid;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getAppname() {
    return appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }

  public String getModid() {
    return modid;
  }

  public void setModid(String modid) {
    this.modid = modid;
  }

  public String getModname() {
    return modname;
  }

  public void setModname(String modname) {
    this.modname = modname;
  }



}
