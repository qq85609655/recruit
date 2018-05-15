package com.csot.recruit.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestSome {

  public static void main(String[] args) throws Exception {
    
    paseTimeToObject();

  }
  
  
  public static void paseTimeToObject() throws Exception{
    String[] timePort = {"8:00","8:30","9:00","9:30","10:00","10:30","11:00",
        "11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00",
        "15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00"};
    Map<String,TimeObject> map = new HashMap<String, TimeObject>();
    for(int i=0;i<timePort.length;i++){
      //开始时间
      String s1 = timePort[i];
      for(int j=i+1;j<timePort.length;j++){
        //为每个时间段新建对应的对象
        TimeObject model = new TimeObject();
        //结束时间
        String s2 = timePort[j];
        //反射调用,循环为属性赋值
        for(int k=i+1;k<=j;k++){
        //获取属性对应Set方法
          Method m = model.getClass().getMethod("setT"+k,String.class);
          m.invoke(model, "1");
        }
        map.put(s1+"-"+s2, model);
      }
    }
    
    System.out.println(map.size());
  }
  
  
  
  

}
