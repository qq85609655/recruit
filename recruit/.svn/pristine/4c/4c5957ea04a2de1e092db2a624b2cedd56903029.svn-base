package com.csot.recruit.service.impl.datadict;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csot.recruit.dao.datadict.DatadictGroupTypeMapper;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.datadict.DatadictGroupTypeColumns;
import com.csot.recruit.model.datadict.DatadictGroupTypeCriteria;
import com.csot.recruit.service.datadict.DatadictGroupTypeService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("datadictGroupTypeService")
public class DatadictGroupTypeServiceImpl implements DatadictGroupTypeService {
    private static final Logger logger = LoggerFactory.getLogger(DatadictGroupTypeServiceImpl.class);

    @Resource
    private DatadictGroupTypeMapper datadictGroupTypeMapper;

    @Override
    public MiniRtn2Grid<DatadictGroupType> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<DatadictGroupType> grid = new MiniRtn2Grid<DatadictGroupType>();
        DatadictGroupTypeCriteria criteria = new DatadictGroupTypeCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andTypeIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = DatadictGroupTypeColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(datadictGroupTypeMapper.selectByExample(criteria));
        grid.setTotal(datadictGroupTypeMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public DatadictGroupType getByPrimaryKey(String primaryKey) {
        return datadictGroupTypeMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(DatadictGroupType datadictGroupType) {
    	int countGroup = datadictGroupTypeMapper.countGroupId();
    	DatadictGroupType datadictType= datadictGroupTypeMapper.queryTypeCodeByGroupId(datadictGroupType.getGroupId());
    	String str = "";
    	String str1 = "";
    	if(datadictType == null){
    		str = String.valueOf(countGroup);
    		StringBuffer stringBuffer = new StringBuffer();
    		for (int i = 0; i < 3 - str.length(); i++) {
    			stringBuffer.append("0");
    		}
    		stringBuffer.append(str);
    		str = stringBuffer.toString();
    		str1="0";
    	}else{
    		str = datadictType.getTypeId().substring(0,3);
    		if(datadictType.getTypeCode() !=null && !"".equals(datadictType.getTypeCode())){
    		    str1 = String.valueOf(Integer.parseInt(datadictType.getTypeCode())+1);
    		}
    	
    	}
    	datadictGroupType.setTypeCode(String.valueOf(Integer.parseInt(str1)));
		StringBuffer stringBuffer1 = new StringBuffer();
		for (int i = 0; i < 3 - str1.length(); i++) {
			stringBuffer1.append("0");
		}
		stringBuffer1.append(str1);
		str1 = stringBuffer1.toString();
		String typeId = str.concat("-").concat(str1);
    	datadictGroupType.setTypeId(typeId);
        datadictGroupTypeMapper.insert(datadictGroupType);
    }

    @Override
    public void updateSelective(DatadictGroupType datadictGroupType) {
        datadictGroupTypeMapper.updateByPrimaryKeySelective(datadictGroupType);
    }

    @Override
    public void remove(String primaryKey) {
        datadictGroupTypeMapper.deleteByPrimaryKey(primaryKey);
    }

	@Override
	public int getDatadictGroupType(DatadictGroupType datadictGroupType) {
		return datadictGroupTypeMapper.countDatadictGroupType(datadictGroupType);
	}
	
	@Override
	public MiniRtn2Grid<DatadictGroupType> getGridByGorupCode(String groupCode){
	  MiniRtn2Grid<DatadictGroupType> grid = new MiniRtn2Grid<DatadictGroupType>();
	  List<DatadictGroupType> dts = datadictGroupTypeMapper.queryTypesByGroupCode(groupCode, null);
	  if(dts != null){
	    grid.setData(dts);
	    grid.setTotal(dts.size());
	  }
	  return grid;
	}
	
	@Override
	public DatadictGroupType getTypeByGorupCodeAndName(String groupCode,String typeName){
	  if(StringUtils.isEmpty(groupCode) || StringUtils.isEmpty(typeName)){
	    return null;
	  }else{
	    List<DatadictGroupType> dts = datadictGroupTypeMapper.queryTypesByGroupCode(groupCode, typeName);
	    if(dts != null && dts.size()>0){
	      return dts.get(0);
	    }else{
	      return null;
	    }
	    
	  }
	}
	
	@Override
	public Map<String,String> getTypeId2NameMapByGroupCode(String groupCode){
	  Map<String,String> res = new HashMap<String,String>();
	  List<DatadictGroupType> dts = datadictGroupTypeMapper.queryTypesByGroupCode(groupCode, null);
	  for(DatadictGroupType d : dts){
	    res.put(d.getTypeId(), d.getTypeName());
	  }
	  return res;
	}
	
	@Override
	public Map<String,String> getName2TypeIdMapByGroupCode(String groupCode){
      Map<String,String> res = new HashMap<String,String>();
      List<DatadictGroupType> dts = datadictGroupTypeMapper.queryTypesByGroupCode(groupCode, null);
      for(DatadictGroupType d : dts){
        res.put(d.getTypeName(), d.getTypeId());
      }
      return res;
    }
	
	@Override
	public String getNameByCodeValue(String groupCode,String typeCode){
	  return datadictGroupTypeMapper.getNameByCodeValue(groupCode,typeCode);
	}
	
	@Override
	public String getNameById(String typeId){
      return datadictGroupTypeMapper.getNameById(typeId);
    }
}