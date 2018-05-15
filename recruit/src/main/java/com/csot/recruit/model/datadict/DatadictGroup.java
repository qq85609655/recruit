package com.csot.recruit.model.datadict;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jodd.util.StringUtil;

import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.datadict.DatadictGroupType;

public class DatadictGroup implements Serializable {
    public static Map<String, DatadictGroup> allTypeGroups = new HashMap<String,DatadictGroup>();
    
    public static Map<String, List<DatadictGroupType>> allTypes = new HashMap<String,List<DatadictGroupType>>();
  
    private String groupId;

    private String groupCode;

    private String groupName;
    
    private String groupPid;

    private static final long serialVersionUID = 1L;
    
    private List<DatadictGroupType> TSTypes = new ArrayList<DatadictGroupType>();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<DatadictGroupType> getTSTypes() {
      return TSTypes;
    }

    public void setTSTypes(List<DatadictGroupType> tSTypes) {
      TSTypes = tSTypes;
    }

    public String getGroupPid() {
		return groupPid;
	}

	public void setGroupPid(String groupPid) {
		this.groupPid = groupPid;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DatadictGroup other = (DatadictGroup) that;
        return (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        return result;
    }
    
    /***
     * 根据数据字典项获取名称
     * @param typeId 数据字典项ID
     * @return
     */
    public static String getTypeNameByTypeId(String typeId){
    	String typeName = typeId;
    	if(null != typeId && !typeId.equals("")){  
    		typeId = typeId.trim(); 
        	for(Map.Entry<String, DatadictGroup> entry : DatadictGroup.allTypeGroups.entrySet()){
        		List<DatadictGroupType> list = DatadictGroup.allTypes.get(entry.getValue().getGroupCode());
        		if(list==null||list.size()<=0){
        		  continue;
        		}
    	    	for (int i = 0; i < list.size(); i++) {
    				if(list.get(i).getTypeId().equals(typeId)){
    				  if(StringUtil.isEmpty(list.get(i).getTypeName())) {
    				    typeName = null;
    	              }
    	              else {
    					typeName = list.get(i).getTypeName().trim();
    	              }
    					break;
    				}
    			}
        	}
    	}
    	return typeName;
    }
    
    /**
     * 根据数据字典id获取code
     * @param typeId 数据字典项ID
     * @return
     */
    public static String getTypeCodeByTypeId(String typeId) {
      String typeCode = typeId;
      if(null != typeId && !typeId.equals("")){
        typeId = typeId.trim(); 
        for(Map.Entry<String, DatadictGroup> entry : DatadictGroup.allTypeGroups.entrySet()){
          List<DatadictGroupType> list = DatadictGroup.allTypes.get(entry.getValue().getGroupCode());
          for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTypeId().equals(typeId)) {
              if(StringUtil.isEmpty(list.get(i).getTypeCode())) {
                typeCode = null;
              }
              else {
                typeCode = list.get(i).getTypeCode().trim();
              }
              break;
            }
          }
        }
      }
      return typeCode;
    }
    
    /***
     * 根据数据字典名称获取Id
     * @param typeName 数据字典项名称
     * @return
     */
    public static String getTypeIdByTypeName(String typeName, String groupCode){
        String typeId = null;
        if(null != typeName && !"".equals(typeName)){
          typeName = typeName.trim(); 
          if(groupCode !=null){
            groupCode = groupCode.trim();
          }
          if(null == groupCode || "".equals(groupCode)){
              for(Map.Entry<String, DatadictGroup> entry : DatadictGroup.allTypeGroups.entrySet()){
                  List<DatadictGroupType> list = DatadictGroup.allTypes.get(entry.getValue().getGroupCode());
                  if(list !=null && list.size()>0){
                    for (int i = 0; i < list.size(); i++) {
                       if(list.get(i).getTypeName().equals(typeName)){
                          typeId = list.get(i).getTypeId().trim();
                          break;
                        }
                      }
                  }
              }
          }else{
        	  List<DatadictGroupType> list = DatadictGroup.allTypes.get(groupCode);
              if(list !=null && list.size()>0){
                for (int i = 0; i < list.size(); i++) {
                   if(list.get(i).getTypeName().equals(typeName)){
                      typeId = list.get(i).getTypeId().trim();
                      break;
                    }
                  }
              }
          }

        }
        return typeId;
    }
    
    /***
     * 根据数据字典code获取Id
     * @param typeCode 数据字典项名称
     * @return
     */
    public static String getTypeIdByTypeCode(String typeCode, String groupCode){
        String typeId = null;
        if(null != typeCode && !"".equals(typeCode)){
          typeCode = typeCode.trim(); 
          if(groupCode !=null){
            groupCode = groupCode.trim();
          }
          List<DatadictGroupType> list = DatadictGroup.allTypes.get(groupCode);
            if(list !=null && list.size()>0){
              for (int i = 0; i < list.size(); i++) {
               if(list.get(i).getTypeCode().equals(typeCode)){
                typeId = list.get(i).getTypeId().trim();
                break;
              }
            }
          }
        }
        return typeId;
    }
    
    /***
     * 根据数据字典code获取名称
     * @param typeCode 数据字典项名称
     * @return
     */
    public static String getTypeNameByTypeCode(String typeCode, String groupCode){
        String typeName = null;
        if(null != typeCode && !"".equals(typeCode)){
          typeCode = typeCode.trim(); 
          if(groupCode !=null){
            groupCode = groupCode.trim();
          }
          List<DatadictGroupType> list = DatadictGroup.allTypes.get(groupCode);
            if(list !=null && list.size()>0){
              for (int i = 0; i < list.size(); i++) {
               if(list.get(i).getTypeCode().equals(typeCode)){
                typeName = list.get(i).getTypeName().trim();
                break;
              }
            }
          }
        }
        return typeName;
    }
    
/*    *//***
     * 更新数据字典group
     * @param type 根据传入类型进行相应操作(1:新增,2:修改,3:删除)
     *//*
    public static void updateDatadictGroup(int type){
    	for (int i = 0; i < array.length; i++) {
			
		}
    }*/
}