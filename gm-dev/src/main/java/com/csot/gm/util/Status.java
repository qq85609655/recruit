package com.csot.gm.util;

public class Status {

  private Status(){
    
  }
  // 料号状态 
  // T_GM_PART_NO.PART_NO_STATUS
  public static final String IS_CREATING = "0"; // 料号生成中
  public static final String IS_CREATED = "1"; // 料号已生成
  public static final String IS_PART_RELEASE = "2"; // 料号已生效
  public static final String IS_EOL = "3"; // 料号已冻结
  public static final String IS_ABANDON = "4"; // 料号已废弃
  
  // 属性是否为做物料唯一性判断的属性
  // T_GM_PROPERTY_VALUE.PROPERTY_TYPE
  // T_GM_PROPERTIES.IS_UNIQUE
  public static final String IS_UNIQUE = "Y";    // 属性作为唯一性判断标志
  public static final String NOT_UNIQUE = "N";   // 属性不作为唯一性判断标志
  
  // 属性为下拉
  // T_GM_PROPERTIES.IS_ENUM
  public static final String IS_ENUM = "Y";    // 是下拉
  public static final String NOT_ENUM = "N";   // 不是下拉

  // 判断是否可生成料号标志
  public static final String CAN_CREATE = "true"; // 可以生成
  public static final String CANNOT_CREATE = "false"; // 不可以生成
  public static final String CANNOT_CREATE_TYPE = "falseType"; // 物料类型创建错误
  

  // 传给PLM的分类的名称的key
  public static final String CLASS_LEVEL_1 = "class_level_1"; // 一级分类名的key
  public static final String CLASS_LEVEL_2 = "class_level_2"; // 二级分类名的key
  public static final String CLASS_LEVEL_3 = "class_level_3"; // 三级分类名的key
  
}
