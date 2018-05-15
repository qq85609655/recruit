package com.csot.gm.util;

import java.util.ArrayList;
import java.util.List;

import com.csot.gm.rawMaterial.model.PropertyCombo;

public class PropertyUtil {
  
  private PropertyUtil(){
    
  }
  
  /**获取下拉属性及唯一性属性
   * @return 下拉属性值
   */
  
  public static List<PropertyCombo> getPropertyCombIsEnumOrIsUnique() {
       
    PropertyCombo pc = new PropertyCombo();
    pc.setText(Status.IS_ENUM);
    pc.setId(Status.IS_ENUM);
    PropertyCombo pc2 = new PropertyCombo();
    pc2.setText(Status.NOT_ENUM);
    pc2.setId(Status.NOT_ENUM);
    
    List<PropertyCombo> list = new ArrayList<PropertyCombo>();
    list.add(pc);
    list.add(pc2);
    return list;
  }
  
}
