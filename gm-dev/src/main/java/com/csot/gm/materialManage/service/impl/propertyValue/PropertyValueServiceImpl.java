package com.csot.gm.materialManage.service.impl.propertyValue;

import com.csot.gm.materialManage.dao.extension.clean.CleanExtMapper;
import com.csot.gm.materialManage.dao.extension.enumValue.EnumValueExtMapper;
import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.extension.properties.PartPropertiesExtMapper;
import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.dao.extension.typePartM.TypePartMExtMapper;
import com.csot.gm.materialManage.dao.extension.wxmap.WXMapExtMapper;
import com.csot.gm.materialManage.dao.original.clean.CleanMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.dao.original.partType.PartTypeMapper;
import com.csot.gm.materialManage.dao.original.propertyValue.PropertyValueMapper;
import com.csot.gm.materialManage.model.extension.clean.CleanExt;
import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExt;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.extension.propertyValue.PropertyValueExt;
import com.csot.gm.materialManage.model.extension.typePartM.TypePartMExt;
import com.csot.gm.materialManage.model.extension.wxmap.WXMapExt;
import com.csot.gm.materialManage.model.original.clean.Clean;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValueColumns;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValueCriteria;
import com.csot.gm.materialManage.service.gmlog.LogService;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.materialManage.service.propertyValue.PropertyValueService;
import com.csot.gm.rawMaterial.model.PropertyValueShow;
import com.csot.gm.rawMaterial.model.Result4UpdatePropertyValue;
import com.csot.gm.rawMaterial.model.UniqueProperty;
import com.csot.gm.rawMaterial.service.ComparePropertyService;
import com.csot.gm.util.PropertyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("propertyValueService")
public class PropertyValueServiceImpl implements PropertyValueService {

  private static final Logger logger = LoggerFactory.getLogger(PropertyValueServiceImpl.class);

  @Resource
  private PropertyValueMapper propertyValueMapper;
  @Resource
  private PropertyValueExtMapper propertyValueExtMapper;
  @Resource
  private PartNoMapper partNoMapper;
  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PartPropertiesExtMapper partPropertiesExtMapper;
  @Resource
  private WXMapExtMapper wxMapExtMapper;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private EnumValueExtMapper enumValueExtMapper;
  @Resource
  private TypePartMExtMapper typePartMExtMapper;
  @Resource
  private PartTypeMapper partTypeMapper;
  @Resource
  private CleanMapper cleanMapper;
  @Resource
  private CleanExtMapper cleanExtMapper;
  @Resource
  private ComparePropertyService comparePropertyService;
  @Resource
  private LogService logService;
  @Resource
  private PartNoService partNoService;

  @Override
  public MiniRtn2Grid<PropertyValue> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<PropertyValue> grid = new MiniRtn2Grid<PropertyValue>();
    PropertyValueCriteria criteria = new PropertyValueCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PropertyValueColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(propertyValueMapper.selectByExample(criteria));
    grid.setTotal(propertyValueMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PropertyValue getByPrimaryKey(String primaryKey) {
    return propertyValueMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PropertyValue propertyValue) {
    propertyValue.setId(UUID.randomUUID().toString().replace("-", ""));
    propertyValueMapper.insert(propertyValue);
  }

  @Override
  public void updateSelective(PropertyValue propertyValue) {
    propertyValueMapper.updateByPrimaryKeySelective(propertyValue);
  }

  @Override
  public void remove(String primaryKey) {
    propertyValueMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public List<PropertyValueShow> getByPartNoId(String partNoId) {
    List<PropertyValueShow> pvList = new ArrayList<PropertyValueShow>();
    String partId = "";
    PartNo pn = partNoMapper.selectByPrimaryKey(partNoId);
    if (null != pn) {
      partId = pn.getPartId();
    }
    List<PropertyValueExt> list = propertyValueExtMapper.selectPropertyValueByPartNoId(partNoId);
    if (!list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        PropertyValueShow pv = new PropertyValueShow();
        String propertyName = list.get(i).getPropertyName();
        String propertyValue = list.get(i).getPropertyValue();
        pv.setPropertyName(propertyName);
        pv.setEnumValueId(list.get(i).getEnumValueId());
        pv.setId(list.get(i).getId());
        pv.setPartNoId(list.get(i).getPartNoId());
        pv.setPropertyType(list.get(i).getPropertyType());
        pv.setPropertyValue(propertyValue); // 属性真实值
        String propertyDisName = getPropertyDisName(partId, propertyName);
        pv.setPropertyDisName(propertyDisName);
        String propertyValueText = getPropertyValueDis(partId, propertyName, propertyValue);
        pv.setPropertyValueText(propertyValueText);
        pvList.add(pv);
      }
    } else {
      List<WXMapExt> wxmList = wxMapExtMapper.selectByWXCode(pn.getPartNo());
      // 判断是否是维修料号，如果是维修料号，则获取对应的原料号的属性值进行显示
      if (!wxmList.isEmpty()) {
        List<PartNoExt> pnList =
            partNoExtMapper.selectPartNoListByPartNo(wxmList.get(0).getSpareCode());
        if (!pnList.isEmpty()) {
          List<PropertyValueExt> pvoldlist =
              propertyValueExtMapper.selectPropertyValueByPartNoId(pnList.get(0).getId());
          if (!pvoldlist.isEmpty()) {
            for (int i = 0; i < pvoldlist.size(); i++) {
              PropertyValueShow pv = new PropertyValueShow();
              String propertyName = pvoldlist.get(i).getPropertyName();
              String propertyValue = pvoldlist.get(i).getPropertyValue();
              pv.setPropertyName(propertyName);
              pv.setEnumValueId(pvoldlist.get(i).getEnumValueId());
              pv.setId(pvoldlist.get(i).getId());
              pv.setPartNoId(pvoldlist.get(i).getPartNoId());
              pv.setPropertyType(pvoldlist.get(i).getPropertyType());
              pv.setPropertyValue(propertyValue);
              String propertyDisName = getPropertyDisName(partId, propertyName);
              pv.setPropertyDisName(propertyDisName);
              String propertyValueText = getPropertyValueDis(partId, propertyName, propertyValue);
              pv.setPropertyValueText(propertyValueText);
              pvList.add(pv);
            }
          }
        }
      }
    }

    // 排序
    Collections.sort(pvList, new Comparator<PropertyValueShow>() {
      @Override
      public int compare(PropertyValueShow o1, PropertyValueShow o2) {
        int result = 0;
        if (null != o1.getPropertyDisName() && null != o2.getPropertyDisName()) {
          String a = o1.getPropertyDisName();
          String b = o2.getPropertyDisName();
          result = a.compareTo(b);
        }
        return result;
      }
    });
    return pvList;
  }

  /**
   * 获取属性值显示值（由于 有很多历史数据是没有enumValueId的，所以不能直接根据enumValueId取值）
   * 
   * @param partId
   * @param propertyName
   * @param propertyValue
   * @return
   */
  @Override
  public String getPropertyValueDis(String partId, String propertyName, String propertyValue) {

    String propertyValueText = propertyValue; // 初始化为与真实值一样

    List<PartPropertiesExt> propertyIdList =
        partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propertyName);
    if (!propertyIdList.isEmpty()) {
      List<PropertiesMExt> pmList =
          propertiesMExtMapper.getEnumIdByPropertyId(propertyIdList.get(0).getId());
      if (!pmList.isEmpty()) {
        List<EnumValueExt> enumValueList =
            enumValueExtMapper.getByTypeIdAndEnumValue(pmList.get(0).getEnumId(), propertyValue);
        if (!enumValueList.isEmpty()) {
          propertyValueText = enumValueList.get(0).getEnumText();
        }
      }
    }
    return propertyValueText;
  }

  /**
   * 获取属性显示名
   * 
   * @param partId
   * @param propertyName
   * @return
   */
  @Override
  public String getPropertyDisName(String partId, String propertyName) {
    String propertyDisName = propertyName; // 初始化为属性真实名称
    List<PartPropertiesExt> proList =
        partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propertyName);
    if (!proList.isEmpty()) {
      propertyDisName = proList.get(0).getPropertyDisName();
    }
    return propertyDisName;
  }


  /**
   * 更新已存在料号的唯一性属性值
   */
  @Override
  public Result4UpdatePropertyValue isSuccessUpdatePartNoProValue(
      PropertyValue[] propertyValueList, SysUser sysUser) {

    Result4UpdatePropertyValue result = new Result4UpdatePropertyValue();

    String partNoId = propertyValueList[0].getPartNoId();
    String partId = partNoMapper.selectByPrimaryKey(partNoId).getPartId();
    String partTypeRealName = "";
    TypePartMExt partTypeM = typePartMExtMapper.getByPartId(partId).get(0);
    if (null != partTypeM) {
      String partTypeId = partTypeM.getPartTypeId();
      partTypeRealName = partTypeMapper.selectByPrimaryKey(partTypeId).getPartTypeRealName();
    }
    // 获取原来的唯一性属性值List
    List<PropertyValueExt> oldUniqueProValueList =
        propertyValueExtMapper.selectPropertyValueByPartNo(partNoId);
    Map<String, String> uniqueMap = new HashMap<String, String>();
    // 已存在的唯一性属性Map
    for (int i = 0; i < oldUniqueProValueList.size(); i++) {
      uniqueMap.put(oldUniqueProValueList.get(i).getPropertyName(), oldUniqueProValueList.get(i)
          .getPropertyValue());
    }
    // 更新过后的唯一性属性Map
    for (int j = 0; j < propertyValueList.length; j++) {
      String propertyName = propertyValueList[j].getPropertyName();
      if ("C4_SparePart".equals(partTypeRealName) || "C4_Consumptive".equals(partTypeRealName)) {
        if (null != (propertyValueList[j].getPropertyValue())
            && !"".equals(propertyValueList[j].getPropertyValue())) {
          uniqueMap.put(propertyName, propertyValueList[j].getPropertyValue());
        }
      } else {
        if (uniqueMap.containsKey(propertyName)) {
          if (null != (propertyValueList[j].getPropertyValue())
              && !"".equals(propertyValueList[j].getPropertyValue())) {
            uniqueMap.put(propertyName, propertyValueList[j].getPropertyValue());
          }
        } else {
          String msg = "请不要修改非唯一性属性值";
          logger.error(msg);
          result.setMsg(msg);
          result.setResult(false);
          return result;
        }
      }
    }

    // 检查更新后的属性是否在下拉中
    for (int m = 0; m < propertyValueList.length; m++) {
      String propertyName = propertyValueList[m].getPropertyName();
      String propertyValue = propertyValueList[m].getPropertyValue();
      List<PartPropertiesExt> propertyList =
          partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propertyName);
      if (!propertyList.isEmpty()) {
        String isEnum = propertyList.get(0).getIsEnum();  // 判断是否为下拉属性
        if ("Y".equals(isEnum)) {
          Map<String, EnumValueExt> map =
              getEnumValueMapByPartIdAndPropertyName(partId, propertyName);
          // 判断修改之后的属性值是否在下拉中
          if (map.containsKey(propertyValue)) {
            propertyValueList[m].setEnumValueId(map.get(propertyValue).getId());
            continue;
          } else {
            String msg = "属性值[" + propertyValue + "]不在对应的下拉中，保存失败";
            logger.error(msg);
            result.setMsg(msg);
            result.setResult(false);
            return result;
          }
        }
      }

    }


    // 新的唯一性属性值Map做唯一性检查
    UniqueProperty uniqueProperty = new UniqueProperty();
    uniqueProperty.setPartId(partId);
    uniqueProperty.setUniqueProperty(uniqueMap);
    // 算出无序hashCode
    String hashCode = String.valueOf(uniqueProperty.hashCode());
    PartNo pn = new PartNo();
    pn.setId(partNoId);
    pn.setHashCode(hashCode);
    // hashCode检查
    List<PartNoExt> list = comparePropertyService.hashCodeIsExit(hashCode, partId);
    if (!list.isEmpty()) {
      // 继续将属性逐个检查
      PartNoExt pne = comparePropertyService.propertyIsExit(uniqueProperty, list);
      if (pne != null) {
        // 具有相同属性值的料号已存在，不可更新属性值
        String msg = "料号:" + pne.getPartNo() + "<br>属性值相同,不可更新。";
        logger.info(msg);
        result.setMsg(msg);
        result.setResult(false);
      } else {
        // 可更新属性值
        logService.logUpdateUniqueProValue(sysUser, propertyValueList);
        for (int k = 0; k < propertyValueList.length; k++) {
          propertyValueMapper.updateByPrimaryKeySelective(propertyValueList[k]);
          updateClean(propertyValueList[k]);
        }
        // 更新hashCode
        partNoMapper.updateByPrimaryKeySelective(pn);
        result.setResult(true);
      }

    } else {
      // 可更新属性值
      logService.logUpdateUniqueProValue(sysUser, propertyValueList);
      for (int k = 0; k < propertyValueList.length; k++) {
        propertyValueMapper.updateByPrimaryKeySelective(propertyValueList[k]);
        updateClean(propertyValueList[k]);
      }
      // 更新hashCode
      partNoMapper.updateByPrimaryKeySelective(pn);
      result.setResult(true);
    }
    return result;
  }
  
  /**
   * 在界面更新了料号属性值之后，同步更新清洗表数据
   * 
   * @param pv
   */
  public void updateClean(PropertyValue pv) {
    String partNo = partNoMapper.selectByPrimaryKey(pv.getPartNoId()).getPartNo();
    List<CleanExt> cleanList = cleanExtMapper.selectByPartNo(partNo);
    if (!cleanList.isEmpty()) {
      for (CleanExt clean : cleanList) {
        if (PropertyName.SC_BRAND.equals(pv.getPropertyName())) {
          Clean newClean = new Clean();
          newClean.setId(clean.getId());
          newClean.setBrand(pv.getPropertyValue());
          cleanMapper.updateByPrimaryKeySelective(newClean);
        } else if (PropertyName.SC_SPEC.equals(pv.getPropertyName())) {
          Clean newClean = new Clean();
          newClean.setId(clean.getId());
          newClean.setSpec(pv.getPropertyValue());
          cleanMapper.updateByPrimaryKeySelective(newClean);
        }
      }
    }  
  }

  /**
   * 根据partId和propertyName获取属性对应的下拉属性值map
   * 
   * @param partId
   * @param propertyName
   * @return map
   */
  public Map<String, EnumValueExt> getEnumValueMapByPartIdAndPropertyName(String partId,
      String propertyName) {
    Map<String, EnumValueExt> map = new HashMap<String, EnumValueExt>();
    List<PartPropertiesExt> propIdList =
        partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propertyName);
    if (!propIdList.isEmpty()) {
      String propId = propIdList.get(0).getId();
      List<PropertiesMExt> pmList = propertiesMExtMapper.getEnumIdByPropertyId(propId);
      if (!pmList.isEmpty()) {
        String enumTypeId = pmList.get(0).getEnumId();
        List<EnumValueExt> enumValueList = enumValueExtMapper.getEnumValueByType(enumTypeId);
        if (!enumValueList.isEmpty()) {
          for (EnumValueExt ev : enumValueList) {
            map.put(ev.getEnumValue(), ev);
          }
        }
      }
    }

    return map;
  }

  /**
   * 当level3新增唯一性属性后，对于历史数据的处理
   */
  @Override
  public boolean addPropertyValues(String partId, String propertyName, String propertyValue) {
      // 判断该level3是否存在此属性
      List<PartPropertiesExt> properties =
          partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propertyName);
      // 如果不存在此属性，返回错误
      if (properties.isEmpty()) {
        return false;
      } else {
        // 如果存在，则对该level3下的历史料号进行属性值新增
        List<PartNoExt> partNoList = partNoService.getPartNoListByPartId(partId);
        if (!partNoList.isEmpty()) {
          for (int i = 0; i < partNoList.size(); i++) {
            // 新增属性值
            String partNoId = partNoList.get(i).getId();
            List<PropertyValueExt> pveList =
                propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(partNoId,
                    propertyName);
            if (!pveList.isEmpty()) {
              // 如果该料号已经存在此属性，则只更新属性值
              PropertyValue pv = new PropertyValue();
              pv.setId(pveList.get(0).getId());
              pv.setPropertyValue(propertyValue);
              updateSelective(pv);

            } else {
              // 如果不存在，直接新增属性值
              PropertyValue pv = new PropertyValue();
              pv.setPropertyValue(propertyValue);
              pv.setPartNoId(partNoId);
              pv.setPropertyName(propertyName);
              pv.setPropertyType("Y");
              create(pv);
            }
            // 更新hashCode
            partNoService.updateHashCode(partNoId);
          }
        }
        return true;
      }
  }

}