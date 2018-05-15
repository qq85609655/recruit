package com.csot.gm.materialManage.service.impl.partNo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.excel.poi.ExcelExportManager;
import org.amberframework.core.excel.poi.mapping.ClasspathXmlExcelDataMappingResolver;
import org.amberframework.core.excel.poi.mapping.ExcelDataMappingResolver;
import org.amberframework.core.excel.poi.template.ClasspathExcelTemplateProvider;
import org.amberframework.core.excel.poi.template.ExcelTemplateProvider;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.gm.materialManage.dao.extension.enumValue.EnumValueExtMapper;
import com.csot.gm.materialManage.dao.extension.part.PartExtMapper;
import com.csot.gm.materialManage.dao.extension.partClass.PartClassExtMapper;
import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.extension.partType.PartTypeExtMapper;
import com.csot.gm.materialManage.dao.extension.properties.PartPropertiesExtMapper;
import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.dao.extension.typePartM.TypePartMExtMapper;
import com.csot.gm.materialManage.dao.extension.wxmap.WXMapExtMapper;
import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.dao.original.partClass.PartClassMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.dao.original.partType.PartTypeMapper;
import com.csot.gm.materialManage.dao.original.wxmap.WXMapMapper;
import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExt;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.partType.PartTypeExt;
import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.extension.propertyValue.PropertyValueExt;
import com.csot.gm.materialManage.model.extension.typePartM.TypePartMExt;
import com.csot.gm.materialManage.model.extension.wxmap.WXMapExt;
import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.materialManage.model.original.partClass.PartClass;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.model.original.partNo.PartNoColumns;
import com.csot.gm.materialManage.model.original.partNo.PartNoCriteria;
import com.csot.gm.materialManage.model.original.partType.PartType;
import com.csot.gm.materialManage.service.gmlog.LogService;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.materialManage.service.propertyValue.PropertyValueService;
import com.csot.gm.rawMaterial.model.PropertyValueShow;
import com.csot.gm.rawMaterial.model.UniqueProperty;
import com.csot.gm.util.PropertyName;
import com.csot.gm.util.SpareExcelVbo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service("partNoService")
public class PartNoServiceImpl implements PartNoService {
  private static final Logger logger = LoggerFactory.getLogger(PartNoServiceImpl.class);
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static final String SPARE_PART = "C4_SparePart";
  private static final String CONSUMPTIVE = "C4_Consumptive";

  @Resource
  private PartNoMapper partNoMapper;
  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PropertyValueExtMapper propertyValueExtMapper;
  @Resource
  private PartClassExtMapper partClassExtMapper;
  @Resource
  private PartClassMapper partClassMapper;
  @Resource
  private PartExtMapper partExtMapper;
  @Resource
  private PartMapper partMapper;
  @Resource
  private PartPropertiesExtMapper partPropertiesExtMapper;
  @Resource
  private EnumValueExtMapper enumValueExtMapper;
  @Resource
  private PartTypeExtMapper partTypeExtMapper;
  @Resource
  private PartTypeMapper partTypeMapper;
  @Resource
  private TypePartMExtMapper typePartMExtMapper;
  @Resource
  private WXMapMapper wXMapMapper;
  @Resource
  private WXMapExtMapper wXMapExtMapper;
  @Resource
  private PropertyValueService propertyValueService;
  @Resource
  private ExcelExportManager excelExportManager;

  @Resource
  private LogService logService;

  @Override
  public MiniRtn2Grid<PartNo> getGrid(MiniGridPageSort pageSort, String searchKey, String partId,
      String partClassId, String brandValue, String specValue, String ownerName, String partType,
      String partName, String beginDate, String endDate, String partNos, String department) {
    MiniRtn2Grid<PartNo> grid = new MiniRtn2Grid<PartNo>();
    PartNoCriteria criteria = new PartNoCriteria();

    // 根据物料类型查询(C4_SparePart,C4_Consumptive,C4_WXLH)
    criteriaByPartType(criteria, partType);

    // 根据料号,物料名称和创建人姓名组合查询
    criteriaByGroup(criteria, searchKey, ownerName, partName, beginDate, endDate, department);

    // 根据属性值(品牌，规格)查询
    // criteriaByPropertyValue(criteria, brandValue, specValue);

    // 根据物料分类查询
    criteriaByClass(criteria, partId, partClassId);

    // 根据多料号精确查询
    criteriaByAnyPartNo(criteria, partNos);

    // 根据品牌规格组合模糊查询
    searchPartNoByBrandAndSpec(criteria, brandValue, specValue);

    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartNoColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partNoMapper.selectByExample(criteria));
    grid.setTotal(partNoMapper.countByExample(criteria));
    return grid;
  }



  /**
   * 根据物料类型查询
   * 
   * @param criteria
   * @param partType
   */
  public void criteriaByPartType(PartNoCriteria criteria, String partType) {
    if (null != partType && !"".equals(partType)) {
      String[] partTypes = partType.split(",");
      if (partTypes.length > 0) {
        for (String pt : partTypes) {
          criteria.or().andPartTypeEqualTo(pt);
        }
      }
    }
  }

  /**
   * 根据料号和创建人姓名组合查询
   * 
   * @param criteria
   * @param searchKey
   * @param ownerName
   */
  public void criteriaByGroup(PartNoCriteria criteria, String searchKey, String ownerName,
      String partName, String beginDate, String endDate, String department) {
    PartNoCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(ownerName)) {
      criter.andCreateNameLikeInsensitive("%" + ownerName + "%");
    }
    if (StringUtils.hasText(searchKey)) {
      criter.andPartNoLikeInsensitive("%" + searchKey + "%");
    }
    if (StringUtils.hasText(partName)) {
      criter.andPartNameLikeInsensitive("%" + partName + "%");
    }
    if (StringUtils.hasText(beginDate)) {
      try {
        criter.andCreateTimeGreaterThanOrEqualTo(format.parse(beginDate));
      } catch (ParseException e) {
        logger.error(e.getMessage());
      }
    }
    if (StringUtils.hasText(endDate)) {
      try {
        // 因为搜索的是日期，时间默认是00:00：00，所以结束日期+1day
        Date date = format.parse(endDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);// 加1之后的日期
        criter.andCreateTimeLessThanOrEqualTo(calendar.getTime());
      } catch (ParseException e) {
        logger.error(e.getMessage());
      }
    }
    if (StringUtils.hasText(department)) {
      criter.andDepartmentLikeInsensitive("%" + department + "%");
    }
  }

  /**
   * 根据品牌和规格模糊查询,且忽略大小写
   */
  private void searchPartNoByBrandAndSpec(PartNoCriteria criteria, String brandValue,
      String specValue) {

    if (!StringUtils.hasText(brandValue) && !StringUtils.hasText(specValue))
      return;

    // 将输入查询的英文品牌规格转换为大写，实现查询时忽略大小写
    String newBrandValue = "";
    String newSpecValue = "";
    if (StringUtils.hasText(brandValue)) {
      newBrandValue = brandValue.toUpperCase();
    }
    if (StringUtils.hasText(specValue)) {
      newSpecValue = specValue.toUpperCase();
    }

    List<EnumValueExt> brandEnumList = Lists.newArrayList();
    List<EnumValueExt> specEnumList = Lists.newArrayList();
    // 品牌与规格组合查询
    if (StringUtils.hasText(newBrandValue) && (StringUtils.hasText(newSpecValue))) {
      brandEnumList = enumValueExtMapper.getByLikeEnumTextAndValue("%" + newBrandValue + "%");
      specEnumList = enumValueExtMapper.getByLikeEnumTextAndValue("%" + newSpecValue + "%");

      getPartNoByBrandAndSpec(brandEnumList, specEnumList, criteria);
      return;
    }
    if (StringUtils.hasText(newBrandValue)) {
      brandEnumList = enumValueExtMapper.getByLikeEnumTextAndValue("%" + newBrandValue + "%");
    }
    if (StringUtils.hasText(newSpecValue)) {
      specEnumList = enumValueExtMapper.getByLikeEnumTextAndValue("%" + newSpecValue + "%");
    }
    // 通过下拉值列表获取下拉id，以实现查询料号属性值
    List<PropertyValueExt> propertyValueList =
        getPartNoByLikeBrandOrSpec(brandEnumList, specEnumList);

    // 通过料号id封装属性信息到Map，去掉重复料号
    if (!propertyValueList.isEmpty()) {
      Map<String, PropertyValueExt> partNoMap = Maps.newHashMap();
      for (int i = 0; i < propertyValueList.size(); i++) {
        partNoMap.put(propertyValueList.get(i).getPartNoId(), propertyValueList.get(i));
      }
      // 根据料号Id查询料号信息
      for (Entry<String, PropertyValueExt> entry : partNoMap.entrySet()) {
        String partNoId = entry.getKey();
        criteria.or().andIdEqualTo(partNoId);
      }
    } else {
      criteria.or().andIdEqualTo("cannot find the data!");
    }
  }

  /**
   * 品牌规格组合获取料号信息
   * @param brandEnumList
   * @param specEnumList
   * @param criteria
   */
  private void getPartNoByBrandAndSpec(List<EnumValueExt> brandEnumList,
      List<EnumValueExt> specEnumList, PartNoCriteria criteria) {

    List<PropertyValueExt> brandProList = Lists.newArrayList();
    List<PropertyValueExt> specProList = Lists.newArrayList();
    // 根据品牌真实值模糊查询料号属性值
    if (!brandEnumList.isEmpty()) {
      for (EnumValueExt brandEnumValue : brandEnumList) {
        brandProList.addAll(propertyValueExtMapper.selectProValueByPropertyNameAndPropertyValue(
            PropertyName.SC_BRAND, brandEnumValue.getEnumValue()));
      }
    }
    // 根据规格真实值模糊查询料号属性值
    if (!specEnumList.isEmpty()) {
      for (EnumValueExt specEnumValue : specEnumList) {
        specProList.addAll(propertyValueExtMapper.selectProValueByPropertyNameAndPropertyValue(
            PropertyName.SC_SPEC, specEnumValue.getEnumValue()));
      }
    }
    if ((!specProList.isEmpty()) && (!brandProList.isEmpty())) {
      Map<String, PropertyValueExt> specProMap = Maps.newHashMap();
      Map<String, PropertyValueExt> partNoProMap = Maps.newHashMap();
      for (PropertyValueExt specProValue : specProList) {
        specProMap.put(specProValue.getPartNoId(), specProValue);
      }
      for (PropertyValueExt brandProValue : brandProList) {
        if (specProMap.containsKey(brandProValue.getPartNoId())) {
          partNoProMap.put(brandProValue.getPartNoId(), brandProValue);
        }
      }

      // 遍历料号属性map,根据料号id查询料号信息
      for (Entry<String, PropertyValueExt> entry : partNoProMap.entrySet()) {
        String partNoId = entry.getKey();
        criteria.or().andIdEqualTo(partNoId);
      }

    } else {
      criteria.or().andIdEqualTo("cannot find the data!");
    }
  }

  /**
   * 通过品牌或者规格值查询料号属性
   * @param brandEnumList
   * @param specEnumList
   * @return
   */
  private List<PropertyValueExt> getPartNoByLikeBrandOrSpec(List<EnumValueExt> brandEnumList,
      List<EnumValueExt> specEnumList) {

    List<PropertyValueExt> partNoProList = Lists.newArrayList();

    // 根据品牌真实值模糊查询料号属性值
    if (!brandEnumList.isEmpty()) {
      for (EnumValueExt brandEnumValue : brandEnumList) {
        List<PropertyValueExt> brandProList =
            propertyValueExtMapper.selectProValueByPropertyNameAndPropertyValue(
                PropertyName.SC_BRAND, brandEnumValue.getEnumValue());
        partNoProList.addAll(brandProList);
      }
    }
    // 根据规格真实值模糊查询料号属性值
    if (!specEnumList.isEmpty()) {
      for (EnumValueExt specEnumValue : specEnumList) {
        List<PropertyValueExt> specProList =
            propertyValueExtMapper.selectProValueByPropertyNameAndPropertyValue(
                PropertyName.SC_SPEC, specEnumValue.getEnumValue());
        // PropertyValueCriteria c = new PropertyValueCriteria();
        // c.or().andPropertyNameEqualTo(PropertyName.SC_SPEC).andPropertyValueEqualTo(value);
        // List<PropertyValue> list = propertyValueMapper.selectByExample(c);
        partNoProList.addAll(specProList);
      }
    }

    return partNoProList;

  }

  public void criteriaByPropertyValue(PartNoCriteria criteria, String brandValue, String specValue) {
    if (StringUtils.hasText(brandValue) || StringUtils.hasText(specValue)) {
      List<PropertyValueExt> pvListSum = new ArrayList<PropertyValueExt>();
      // 查询品牌，将输入查询的品牌值转换为大写，保证查询时忽略大小写
      String newbrandValue = brandValue.toUpperCase();
      if (StringUtils.hasText(newbrandValue)) {
        List<String> propValueListBrand = new ArrayList<String>();
        propValueListBrand.add(newbrandValue);
        List<EnumValueExt> evListBrand =
            enumValueExtMapper.getByLikeEnumText("%" + newbrandValue + "%");
        if (!evListBrand.isEmpty()) {
          for (EnumValueExt ev : evListBrand) {
            String enumValueValue = ev.getEnumValue();
            if (!propValueListBrand.contains(enumValueValue)) {
              propValueListBrand.add(enumValueValue);
            }
          }
        }
        for (String proValue : propValueListBrand) {
          // 根据真实值去查询
          List<PropertyValueExt> pvList =
              propertyValueExtMapper.selectPropertyValueByPropertyNameLikePropertyValue(
                  PropertyName.SC_BRAND, "%" + proValue + "%");
          pvListSum.addAll(pvList);
        }
      }
      // 查询规格，将输入查询的规格值转换为大写，保证查询时忽略大小写
      String newspecValue = specValue.toUpperCase();
      if (StringUtils.hasText(newspecValue)) {
        List<String> propValueListSpec = new ArrayList<String>();
        propValueListSpec.add(newspecValue);
        List<EnumValueExt> evListSpec =
            enumValueExtMapper.getByLikeEnumText("%" + newspecValue + "%");
        if (!evListSpec.isEmpty()) {
          for (EnumValueExt ev : evListSpec) {
            String enumValueValue = ev.getEnumValue();
            if (!propValueListSpec.contains(enumValueValue)) {
              propValueListSpec.add(enumValueValue);
            }
          }
        }
        for (String proValue : propValueListSpec) {
          // 根据真实值去查询
          List<PropertyValueExt> pvList =
              propertyValueExtMapper.selectPropertyValueByPropertyNameLikePropertyValue(
                  PropertyName.SC_SPEC, "%" + proValue + "%");
          pvListSum.addAll(pvList);
        }
      }

      if (!pvListSum.isEmpty()) {
        // 去重
        Map<String, PropertyValueExt> pnMap = new HashMap<String, PropertyValueExt>();
        for (int i = 0; i < pvListSum.size(); i++) {
          pnMap.put(pvListSum.get(i).getPartNoId(), pvListSum.get(i));
        }

        // 根据料号Id查询
        for (Entry<String, PropertyValueExt> entry : pnMap.entrySet()) {
          String partNoId = entry.getKey();
          criteria.or().andIdEqualTo(partNoId);
        }
      } else {
        criteria.or().andIdEqualTo("cannotfinddata");
      }
    }
  }

  /**
   * 根据物料分类查询
   * 
   * @param criteria
   * @param partId
   * @param partClassId
   */
  public void criteriaByClass(PartNoCriteria criteria, String partId, String partClassId) {

    if (StringUtils.hasText(partId)) {
      criteria.or().andPartIdEqualTo(partId);
    }
    if (StringUtils.hasText(partClassId)) {
      List<PartClass> level2 = partClassExtMapper.getByParentId(partClassId);
      // level 1
      if (!level2.isEmpty()) {
        for (int i = 0; i < level2.size(); i++) {
          List<Part> partList = partExtMapper.getByParentId(level2.get(i).getId());
          for (int j = 0; j < partList.size(); j++) {
            String partId2 = partList.get(j).getId();
            criteria.or().andPartIdEqualTo(partId2);
          }
        }

        // level 2
      } else {
        List<Part> partList = partExtMapper.getByParentId(partClassId);
        for (int i = 0; i < partList.size(); i++) {
          String partId2 = partList.get(i).getId();
          criteria.or().andPartIdEqualTo(partId2);
        }
      }
    }
  }

  /**
   * 根据多料号精确查询
   * 
   * @param criteria
   * @param partNos
   */
  public void criteriaByAnyPartNo(PartNoCriteria criteria, String partNos) {
    if (StringUtils.hasText(partNos)) {
      String[] partNoArr = partNos.split(";");
      if (partNoArr.length > 0) {
        List<String> pnList = Arrays.asList(partNoArr);
        criteria.or().andPartNoIn(pnList);
      }
    }
  }

  @Override
  public PartNo getByPrimaryKey(String primaryKey) {
    return partNoMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PartNo partNo) {
    partNo.setId(UUID.randomUUID().toString().replace("-", ""));
    partNoMapper.insert(partNo);
  }

  @Override
  public void updateSelective(PartNo partNo) {
    partNoMapper.updateByPrimaryKeySelective(partNo);
  }

  @Override
  public void remove(String primaryKey, String userAccount) {
    PartNo pn = partNoMapper.selectByPrimaryKey(primaryKey);
    SysUser sysUser = new SysUser();
    sysUser.setAccount(userAccount);
    if (null != pn) {
      String partNo = pn.getPartNo();
      // 判断是不是维修料号
      List<WXMapExt> wxList = wXMapExtMapper.selectByWXCode(partNo);
      if (!wxList.isEmpty()) {
        // 删除维修料号
        wXMapMapper.deleteByPrimaryKey(wxList.get(0).getId());
        partNoMapper.deleteByPrimaryKey(primaryKey);
        // 删除料号日志管理
        logService.logDeletePartNo(partNo, sysUser);

      } else {
        // 删除非维修料号
        // 判断是否有对应的维修料号(如果有，就将对应的维修料号一同删除)
        List<WXMapExt> wxList2 = wXMapExtMapper.selectBySpareCode(partNo);

        if (!wxList2.isEmpty()) {
          wXMapMapper.deleteByPrimaryKey(wxList2.get(0).getId());
          List<PartNoExt> wxL =
              partNoExtMapper.selectPartNoListByPartNo(wxList2.get(0).getWxCode());
          if (!wxL.isEmpty()) {
            partNoMapper.deleteByPrimaryKey(wxL.get(0).getId());
          }
          // 删除料号日志管理
          logService.logDeletePartNo(partNo, sysUser);
        }
        propertyValueExtMapper.deleteByPartNoId(primaryKey);
        partNoMapper.deleteByPrimaryKey(primaryKey);
        // 删除料号日志管理
        logService.logDeletePartNo(partNo, sysUser);
      }
    }
  }

  /**
   * 根据partId获取已生成的料号list
   */
  @Override
  public List<PartNoExt> getPartNoListByPartId(String partId) {
    return partNoExtMapper.selectPartNoListByPartId(partId);
  }

  /**
   * 根据创建uid获取料号信息
   */
  @Override
  public PartNoExt getPartNoByUid(String uid) {
    List<PartNoExt> list = partNoExtMapper.selectPartNoListByUid(uid);
    logger.info("PartNoListSize:" + list.size());
    if (!list.isEmpty()) {
      return list.get(0);
    } else {
      return null;
    }

  }

  /**
   * 更新所有料号的hashCode
   */
  @Override
  public void updateAllHashCode() {
    List<PartNoExt> list = partNoExtMapper.selectAllPartNo();
    for (int i = 0; i < list.size(); i++) {
      PartNoExt pn = list.get(i);
      String partNoId = pn.getId();
      String partId = pn.getPartId();
      List<PropertyValueExt> upList = propertyValueExtMapper.selectPropertyValueByPartNo(partNoId);
      UniqueProperty up = new UniqueProperty();
      up.setPartId(partId);
      Map<String, String> map = new HashMap<String, String>();
      for (int j = 0; j < upList.size(); j++) {
        if (null != (upList.get(j).getPropertyValue())
            && !"".equals(upList.get(j).getPropertyValue())) {
          map.put(upList.get(j).getPropertyName(), upList.get(j).getPropertyValue());
        }
      }
      up.setUniqueProperty(map);
      String hashCode = String.valueOf(up.hashCode());
      PartNo partNo = new PartNo();
      partNo.setId(partNoId);
      partNo.setHashCode(hashCode);
      partNoMapper.updateByPrimaryKeySelective(partNo);

    }

  }

  /**
   * 导出料号信息
   */
  @Override
  public String exportPartNoById(HttpServletRequest request, String partNoIds) {
    String exportType = request.getParameter("type");
    String[] partNoIdArr = partNoIds.split(",");
    List<PartNo> partNoList = getPartNoListByIdArray(partNoIdArr);
    if (partNoList.isEmpty()) {
      return "false";
    }
    Workbook wb;
    if ("template".equals(exportType)) {
      List<String> partNoIdList = Arrays.asList(partNoIdArr);
      List<SpareExcelVbo> list = partNoExtMapper.selectExportByPartNoIdList(partNoIdList);
      wb = exportBrandSpecExcel(list);
    } else {
      // key:partId; value:partNoIdList
      Map<String, List<String>> map = new HashMap<>();
      for (int i = 0; i < partNoList.size(); i++) {
        String partNoId = partNoList.get(i).getId();
        String partId = partNoList.get(i).getPartId();
        if (map.containsKey(partId)) {
          map.get(partId).add(partNoId);
        } else {
          List<String> partNoIdList = new ArrayList<>();
          partNoIdList.add(partNoId);
          map.put(partId, partNoIdList);
        }
      }
      wb = exportPartNoInfo(map);
    }

    return generateTempExcel(wb, request);
  }

  /**
   * 根据level2Id 获取分类下所有料号id
   * 
   * @param level2Id
   * @return map
   */
  public Map<String, List<String>> getPartNoMapByLevel2(String level2Id) {
    Map<String, List<String>> map = new HashMap<>();
    List<Part> partList = partExtMapper.getByParentId(level2Id);
    for (int j = 0; j < partList.size(); j++) {
      String partId2 = partList.get(j).getId();
      List<String> pnIds = new ArrayList<String>();
      List<PartNoExt> pnList2 = partNoExtMapper.selectPartNoListByPartId(partId2);
      for (int k = 0; k < pnList2.size(); k++) {
        pnIds.add(pnList2.get(k).getId());
      }
      if (!pnIds.isEmpty()) {
        map.put(partId2, pnIds);
      }
    }
    return map;
  }

  /**
   * 导出料号
   * 
   * @param map
   */
  public HSSFWorkbook exportPartNoInfo(Map<String, List<String>> map) {

    // 创建一个webbook，对应一个Excel文件
    HSSFWorkbook wb = new HSSFWorkbook();

    for (Entry<String, List<String>> entry : map.entrySet()) {
      String partId = entry.getKey();
      List<String> partNoIds = entry.getValue();
      createSheet4Part(wb, partId, partNoIds);
    }
    return wb;
  }

  private void createSheet4Part(HSSFWorkbook wb, String partId, List<String> partNoIds) {

    String level3Desc = partMapper.selectByPrimaryKey(partId).getPartDesc();
    String sheetName = level3Desc;
    String level2Id = partMapper.selectByPrimaryKey(partId).getParentId();
    PartClass level2 = partClassMapper.selectByPrimaryKey(level2Id);
    if (null != level2) {
      sheetName = level2.getClassDesc() + sheetName;
      // sheetName长度限制
      if (sheetName.length() > 30) {
        sheetName = level2.getClassDesc().substring(0, 3) + "-" + level3Desc;
      }
    }
    sheetName = sheetName.replace("/", "_");

    HSSFCellStyle titleStyle = wb.createCellStyle();
    titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置居中
    titleStyle.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
    titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
    headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
    titleStyle.setFont(headerFont); // 为标题样式设置字体样式

    HSSFCellStyle valueStyle = wb.createCellStyle();
    valueStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
    valueStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

    // 在webbook中添加一个sheet,对应Excel文件中的sheet
    HSSFSheet sheet = wb.createSheet(sheetName);
    HSSFRow rowTitle = sheet.createRow((int) 0);
    HSSFCell cell1 = rowTitle.createCell(0);
    cell1.setCellValue("料号");
    cell1.setCellStyle(titleStyle);
    HSSFCell cell2 = rowTitle.createCell(1);
    cell2.setCellValue("创建人姓名");
    cell2.setCellStyle(titleStyle);
    // 优化新增属性
    HSSFCell cell3 = rowTitle.createCell(2);
    cell3.setCellValue("创建人工号");
    cell3.setCellStyle(titleStyle);
    HSSFCell cell4 = rowTitle.createCell(3);
    cell4.setCellValue("创建人部门");
    cell4.setCellStyle(titleStyle);
    HSSFCell cell5 = rowTitle.createCell(4);
    cell5.setCellValue("创建时间");
    cell5.setCellStyle(titleStyle);
    HSSFCell cell6 = rowTitle.createCell(5);
    cell6.setCellValue("物料分类");
    cell6.setCellStyle(titleStyle);
    HSSFCell cell7 = rowTitle.createCell(6);
    cell7.setCellValue("物料名称");
    cell7.setCellStyle(titleStyle);
    HSSFCell cell8 = rowTitle.createCell(7);
    cell8.setCellValue("设备类别");
    cell8.setCellStyle(titleStyle);
    HSSFCell cell9 = rowTitle.createCell(8);
    cell9.setCellValue("设备厂商");
    cell9.setCellStyle(titleStyle);
    for (int k = 0; k < 9; k++) {
      sheet.setColumnWidth((short) k, (short) 4500);
    }

    List<PartPropertiesExt> uniquePros = new ArrayList<PartPropertiesExt>();
    // 维修料号特殊处理
    if ("维修料号".equals(level3Desc)) {
      HSSFCell cellbrand = rowTitle.createCell(9);
      cellbrand.setCellValue("品牌");
      cellbrand.setCellStyle(titleStyle);
      HSSFCell cellspec = rowTitle.createCell(10);
      cellspec.setCellValue("规格");
      cellspec.setCellStyle(titleStyle);
    } else {
      // 找出level3的惟一性属性
      // uniquePros = partPropertiesExtMapper.getPropertiesByPartIdAndUnique(partId, "Y");
      // 更新，新MDM需求导出所有属性的显示值by-xyc20170927
      uniquePros = partPropertiesExtMapper.getPropertiesByPartId(partId);
      int line = 9;
      for (int i = 0; i < uniquePros.size(); i++) {
        sheet.setColumnWidth((short) line, (short) 4500);
        HSSFCell cell = rowTitle.createCell(line++);
        String propertyDisName =
            propertyValueService.getPropertyDisName(partId, uniquePros.get(i).getPropertyName());
        cell.setCellValue(propertyDisName);
        cell.setCellStyle(titleStyle);
      }
    }

    for (int i = 0; i < partNoIds.size(); i++) {
      PartNo pn = partNoMapper.selectByPrimaryKey(partNoIds.get(i));
      String partNo = pn.getPartNo();
      String owner = pn.getCreateName();
      // 优化新增导出字段
      String userCode = pn.getCreateCode();
      String department = pn.getDepartment();
      Date createTime = pn.getCreateTime();
      String createTimeStr = "";
      if (null != createTime) {
        createTimeStr = format.format(createTime);
      }
      String level3 = getLevelByPartNoId(pn.getId());
      String partNoName = pn.getPartName();
      String plant = pn.getPlant();
      // ID, PART_NO, PART_NAME, CN_DESC, EN_DESC, CREATE_CODE, CREATE_TIME, PART_NO_STATUS,
      // PART_ID, HASH_CODE, PART_NO_UID, CREATE_NAME, PLANT, DEPARTMENT, TELEPHONE, PART_TYPE
      HSSFRow row = sheet.createRow((int) i + 1);

      HSSFCell cellPartNo = row.createCell(0);
      if (null == partNo || "".equals(partNo)) {
        cellPartNo.setCellValue("");
        cellPartNo.setCellStyle(valueStyle);
      } else {
        cellPartNo.setCellValue(partNo);
        cellPartNo.setCellStyle(valueStyle);
      }

      HSSFCell cellOwner = row.createCell(1);
      if (null == owner || "".equals(owner)) {
        cellOwner.setCellValue("");
        cellOwner.setCellStyle(valueStyle);
      } else {
        cellOwner.setCellValue(owner);
        cellOwner.setCellStyle(valueStyle);
      }

      HSSFCell cellCode = row.createCell(2);
      if (null == userCode || "".equals(userCode)) {
        cellCode.setCellValue("");
        cellCode.setCellStyle(valueStyle);
      } else {
        cellCode.setCellValue(userCode);
        cellCode.setCellStyle(valueStyle);
      }

      HSSFCell cellDep = row.createCell(3);
      if (null == department || "".equals(department)) {
        cellDep.setCellValue("");
        cellDep.setCellStyle(valueStyle);
      } else {
        cellDep.setCellValue(department);
        cellDep.setCellStyle(valueStyle);
      }

      HSSFCell cellTime = row.createCell(4);
      if (null == createTime || "".equals(createTime)) {
        cellTime.setCellValue("");
        cellTime.setCellStyle(valueStyle);
      } else {
        cellTime.setCellValue(createTimeStr);
        cellTime.setCellStyle(valueStyle);
      }

      HSSFCell cellLevel3 = row.createCell(5);
      if (null == level3 || "".equals(level3)) {
        cellLevel3.setCellValue("");
        cellLevel3.setCellStyle(valueStyle);
      } else {
        cellLevel3.setCellValue(level3);
        cellLevel3.setCellStyle(valueStyle);
      }

      HSSFCell cellPNoName = row.createCell(6);
      if (null == partNoName || "".equals(partNoName)) {
        cellPNoName.setCellValue("");
        cellPNoName.setCellStyle(valueStyle);
      } else {
        cellPNoName.setCellValue(partNoName);
        cellPNoName.setCellStyle(valueStyle);
      }

      HSSFCell cellPlant = row.createCell(8);
      if (null == plant || "".equals(plant)) {
        cellPlant.setCellValue("");
        cellPlant.setCellStyle(valueStyle);
      } else {
        cellPlant.setCellValue(plant);
        cellPlant.setCellStyle(valueStyle);
      }

      if ("维修料号".equals(level3Desc)) {
        List<PropertyValueShow> pvList = propertyValueService.getByPartNoId(pn.getId());
        HSSFCell cellbrand = row.createCell(9);
        HSSFCell cellspec = row.createCell(10);
        cellbrand.setCellStyle(valueStyle);
        cellspec.setCellStyle(valueStyle);
        if (!pvList.isEmpty()) {
          for (PropertyValueShow pv : pvList) {
            if (pv.getPropertyName().equals(PropertyName.SC_BRAND)) {
              cellbrand.setCellValue(pv.getPropertyValue());
            } else if (pv.getPropertyName().equals(PropertyName.SC_SPEC)) {
              cellspec.setCellValue(pv.getPropertyValue());
            }
          }
        }
      } else {
        int col = 9;
        for (int h = 0; h < uniquePros.size(); h++) {
          HSSFCell cell = row.createCell(col++);
          logger.info("&&" + partNoIds.get(i) + uniquePros.get(h).getPropertyName());
          List<PropertyValueExt> propertyValueList =
              propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(partNoIds.get(i),
                      uniquePros.get(h).getPropertyName());
          String propertyValue = "";
          if (!propertyValueList.isEmpty()) {
            propertyValue = propertyValueList.get(0).getPropertyValue();
          }
          String finalValue = "";
          for (int a = 0; a < uniquePros.size(); a++) {
            // 判断物料是否是备品耗材
            if ("spec".equals(uniquePros.get(a).getPropertyName())) {
              finalValue = propertyValue;
              break;
            } else {
              continue;
            }
          }
          if ("".equals(finalValue)) {
            String propertyValueText = propertyValueService.getPropertyValueDis(partId, uniquePros.get(h).getPropertyName(), propertyValue);
            finalValue = propertyValueText;
          }

          // cell.setCellValue(propertyValue); 导出显示值,by-xyc20170927
          cell.setCellValue(finalValue);
          cell.setCellStyle(valueStyle);
        }
      }

    }
  }

  /**
   * 根据partNoId更新料号的HashCode
   * 
   * @param partNoId
   */
  @Override
  public void updateHashCode(String partNoId) {
    List<PropertyValueExt> uniqueProValueList =
        propertyValueExtMapper.selectPropertyValueByPartNo(partNoId);
    Map<String, String> uniqueMap = new HashMap<String, String>();
    for (int j = 0; j < uniqueProValueList.size(); j++) {
      uniqueMap.put(uniqueProValueList.get(j).getPropertyName(), uniqueProValueList.get(j)
          .getPropertyValue());
    }
    UniqueProperty uniqueProperty = new UniqueProperty();
    uniqueProperty.setUniqueProperty(uniqueMap);
    // 算出无序hashCode
    String hashCode = String.valueOf(uniqueProperty.hashCode());
    PartNo pn = new PartNo();
    pn.setId(partNoId);
    pn.setHashCode(hashCode);
    partNoMapper.updateByPrimaryKeySelective(pn);
  }

  /**
   * 获取所有备品耗材料号
   */
  @Override
  public MiniRtn2Grid<PartNo> getAllSpareConsumptive(MiniGridPageSort pageSort, String partType) {

    List<TypePartMExt> partIdList = new ArrayList<>();

    if ("C4".equals(partType)) {
      List<PartTypeExt> spareList = partTypeExtMapper.getPartTypeByRealName(SPARE_PART);
      List<PartTypeExt> consumptiveList = partTypeExtMapper.getPartTypeByRealName(CONSUMPTIVE);
      partIdList.addAll(typePartMExtMapper.getByPartTypeId(spareList.get(0).getId()));
      partIdList.addAll(typePartMExtMapper.getByPartTypeId(consumptiveList.get(0).getId()));
    } else {
      List<PartTypeExt> partTypeList = partTypeExtMapper.getPartTypeByRealName(partType);
      if (!partTypeList.isEmpty()) {
        partIdList.addAll(typePartMExtMapper.getByPartTypeId(partTypeList.get(0).getId()));
      }
    }

    // 根据partId查询并分页排序
    MiniRtn2Grid<PartNo> grid = new MiniRtn2Grid<>();
    PartNoCriteria criteria = new PartNoCriteria();
    if (!partIdList.isEmpty()) {
      for (TypePartMExt tpm : partIdList) {
        criteria.or().andPartIdEqualTo(tpm.getPartId());
      }
    }
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartNoColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partNoMapper.selectByExample(criteria));
    grid.setTotal(partNoMapper.countByExample(criteria));

    return grid;
  }

  /**
   * 获取PartNoId
   */
  @Override
  public String getIdByPartNo(String partNo) {
    List<PartNoExt> pnList = partNoExtMapper.selectPartNoListByPartNo(partNo);
    if (!pnList.isEmpty()) {
      return pnList.get(0).getId();
    }
    return "";
  }

  @Override
  public AjaxRtnJson checkPartNoType(String partType, String partNo) {
    AjaxRtnJson ajax = new AjaxRtnJson();
    ajax.setSuccess(false);
    if ("C4".equals(partType)) {
      ajax.setSuccess(true);
      return ajax;
    }

    List<PartNoExt> partNoList = partNoExtMapper.selectPartNoListByPartNo(partNo);
    if (!partNoList.isEmpty()) {
      String partId = partNoList.get(0).getPartId();
      List<TypePartMExt> mapp = typePartMExtMapper.getByPartId(partId);
      if (!mapp.isEmpty()) {
        String partTypeId = mapp.get(0).getPartTypeId();
        PartType partNoType = partTypeMapper.selectByPrimaryKey(partTypeId);
        if (partNoType == null) {
          ajax.setMsg("检查类型失败");
        } else if (!partNoType.getPartTypeRealName().equals(partType)
            && partNoType.getPartTypeRealName().equals(SPARE_PART)) {
          ajax.setMsg("请至PLM系统零件创建页面选择[备品备件]");
        } else if (!partNoType.getPartTypeRealName().equals(partType)
            && partNoType.getPartTypeRealName().equals(CONSUMPTIVE)) {
          ajax.setMsg("请至PLM系统零件创建页面选择[耗材]");
        } else if (partNoType.getPartTypeRealName().equals(partType)) {
          ajax.setSuccess(true);
        }
      } else {
        ajax.setMsg("检查类型失败");
      }
    } else {
      ajax.setMsg("检查类型失败");
    }
    return ajax;
  }

  /**
   * 根据料号Id获取料号所在分类
   */
  @Override
  public String getLevelByPartNoId(String partNoId) {
    String levelMsg = "";
    String partId = partNoMapper.selectByPrimaryKey(partNoId).getPartId();
    if (null != partId) {
      Part part = partMapper.selectByPrimaryKey(partId);
      String level3Name = part.getPartDesc();
      if ("维修料号".equals(level3Name)) {
        return level3Name;
      }
      String level2Id = part.getParentId();
      String preCode = part.getPartPrefixCode();
      if (null != level2Id) {
        PartClass level2 = partClassMapper.selectByPrimaryKey(level2Id);
        String level2Name = level2.getClassDesc();
        String level1Id = level2.getParentId();
        if (null != level1Id) {
          PartClass level1 = partClassMapper.selectByPrimaryKey(level1Id);
          String level1Name = level1.getClassDesc();
          if (null != level3Name && null != level2Name && null != level1Name && null != preCode) {
            levelMsg = level1Name + "-" + level2Name + "-" + level3Name + "[" + preCode + "]";
          }
        }
      }
    }
    return levelMsg;
  }

  /**
   * 
   */
  @Override
  public PartNo getPartNoByPartNoId(String partNoId) {
    PartNo partNo = partNoMapper.selectByPrimaryKey(partNoId);
    return partNo;
  }


  @Override
  public String export6171(HttpServletRequest request) {
    //List<PartNo> partNoList = getAll6171PartNo();
    //List<SpareExcelVbo> list = translate2SpareExcelVboList(partNoList);

    List<String> partIdlist = new ArrayList<>();
    List<TypePartMExt> tpmList = new ArrayList<>();
    tpmList.addAll(typePartMExtMapper.getByPartTypeId("2345"));
    tpmList.addAll(typePartMExtMapper.getByPartTypeId("6789"));
    for (int i=0; i < tpmList.size(); i++) {
     partIdlist.add(tpmList.get(i).getPartId());
    }
    List<SpareExcelVbo> list = partNoExtMapper.selectExportByPartIdList(partIdlist);
//    partIds = "'6b6a20f4af3c48c88e37d35017648f9a'";
//    map.put("part_ids", partIds);
//    map.put("p_result", null);
//    partNoExtMapper.getExportSearch(map);
//    List<SpareExcelVbo> list = (List<SpareExcelVbo>)map.get("p_result");

    Workbook wb = exportBrandSpecExcel(list);
    return generateTempExcel(wb, request);
  }

  @Override
  public List<PartNo> getAll6171PartNo() {
    List<TypePartMExt> tpmList = new ArrayList<>();
    tpmList.addAll(typePartMExtMapper.getByPartTypeId("2345"));
    tpmList.addAll(typePartMExtMapper.getByPartTypeId("6789"));
    List<String> partIdList = new ArrayList<>();
    PartNoCriteria criteria = new PartNoCriteria();
    for (TypePartMExt tpm : tpmList) {
      partIdList.add(tpm.getPartId());
    }
    criteria.or().andPartIdIn(partIdList);
    return partNoMapper.selectByExample(criteria);
  }

  @Override
  public String exportPartNoByClass(HttpServletRequest request) {
    String partClassId = request.getParameter("partClassId");
    String exportType = request.getParameter("type");
    // key:partId; value:partNoIdList
    Map<String, List<String>> map = new HashMap<>();
    List<PartNoExt> pnList = partNoExtMapper.selectPartNoListByPartId(partClassId);
    // partClassId为level3的Id
    if (!pnList.isEmpty()) {
      List<String> pnIds = new ArrayList<>();
      for (int i = 0; i < pnList.size(); i++) {
        pnIds.add(pnList.get(i).getId());
      }
      if (!pnIds.isEmpty()) {
        map.put(partClassId, pnIds);
      }
    } else {
      List<PartClass> level2 = partClassExtMapper.getByParentId(partClassId);
      // level 1
      if (!level2.isEmpty()) {
        for (int i = 0; i < level2.size(); i++) {
          map.putAll(getPartNoMapByLevel2(level2.get(i).getId()));
        }
        // level 2
      } else {
        map.putAll(getPartNoMapByLevel2(partClassId));
      }
    }
    List<String> partIdList = new ArrayList<>();
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
      Entry entry = (java.util.Map.Entry)it.next();
      partIdList.add((String)entry.getKey());
    }
    Workbook wb;
    if ("template".equals(exportType)) {
      List<SpareExcelVbo> list = partNoExtMapper.selectExportByPartIdList(partIdList);
      wb = exportBrandSpecExcel(list);
    } else {
      wb = exportPartNoInfo(map);
    }
    return generateTempExcel(wb, request);
  }

  @Override
  public String exportPartNoByGroup(HttpServletRequest request) {
    try {
      String partNo = request.getParameter("partNo");
      String partName = request.getParameter("partName");
      // url传参中文字符解码
      if (StringUtils.hasText(partName)) {
        partName = URLDecoder.decode(partName, "utf-8");
      }
      String ownerName = request.getParameter("ownerName");
      if (StringUtils.hasText(ownerName)) {
        ownerName = URLDecoder.decode(ownerName, "utf-8");
      }
      String beginDate = request.getParameter("beginDate");
      String endDate = request.getParameter("endDate");
      String department = request.getParameter("department");
      if (StringUtils.hasText(department)) {
        department = URLDecoder.decode(department, "utf-8");
      }
      if (StringUtils.hasText(partName) || StringUtils.hasText(ownerName)
              || StringUtils.hasText(partNo) || StringUtils.hasText(beginDate)
              || StringUtils.hasText(endDate) || StringUtils.hasText(department)) {
        PartNoCriteria criteria = new PartNoCriteria();
        searchPartNoInfoByGroup(criteria, partNo, ownerName, partName, beginDate, endDate, department);
        List<PartNo> partNoList = partNoMapper.selectByExample(criteria);
        if (partNoList.isEmpty()) {
          return "false";
        } else {
          String partNoIds = "";
          for (PartNo pn : partNoList) {
            partNoIds += pn.getId() + ",";
          }
          return exportPartNoById(request, partNoIds);
        }

      } else {
        return export6171(request);
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return "";
  }

  @Override
  public String exportPartNoByProperty(HttpServletRequest request) {
    try {
      String brand = request.getParameter("brand");
      String spec = request.getParameter("spec");
      if (StringUtils.hasText(brand)) {
        brand = URLDecoder.decode(brand, "utf-8");
      }
      if (StringUtils.hasText(spec)) {
        spec = URLDecoder.decode(spec, "utf-8");
      }
      if (StringUtils.hasText(brand) || StringUtils.hasText(spec)) {
        PartNoCriteria criteria = new PartNoCriteria();
        // criteriaByPropertyValue(criteria, brand, spec);
        searchPartNoByBrandAndSpec(criteria, brand, spec);
        List<PartNo> pnList = partNoMapper.selectByExample(criteria);
        if (pnList.isEmpty()) {
          return "false";
        } else {
          String partNoIds = "";
          for (PartNo pn : pnList) {
            partNoIds += pn.getId() + ",";
          }
          return exportPartNoById(request, partNoIds);
        }
      } else {
        return export6171(request);
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    return "";
  }

  @Override
  public String exportPartNoByAnySearch(HttpServletRequest request) {
    String partNos = request.getParameter("partNos");
    if (StringUtils.hasText(partNos)) {
      PartNoCriteria criteria = new PartNoCriteria();
      criteriaByAnyPartNo(criteria, partNos);
      List<PartNo> partNoList = partNoMapper.selectByExample(criteria);
      if (partNoList.isEmpty()) {
        return "false";
      } else {
        String partNoIds = "";
        for (PartNo pn : partNoList) {
          partNoIds += pn.getId() + ",";
        }
        return exportPartNoById(request, partNoIds);
      }
    } else {
      return export6171(request);
    }
  }

  public String generateTempExcel(Workbook wb, HttpServletRequest request) {
    String fileName = UUID.randomUUID().toString().replace("-", "") + ".xls";
    String path = request.getSession().getServletContext().getRealPath("/");
    path = path.replace("\\\\", "/");
    path += "excelTemplate/" + fileName;
    FileOutputStream os = null;
    try {
      os = new FileOutputStream(new File(path));
    } catch (FileNotFoundException e) {
      logger.error(e.getMessage());
    }
    try {
      wb.write(os);
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
    return path;
  }

  /**
   * 用户查询界面获取非BOM材料号信息
   */
  @Override
  public MiniRtn2Grid<PartNo> getUserDataGrid(MiniGridPageSort pageSort, String searchKey,
      String partId, String partClassId, String brandValue, String specValue, String ownerName,
      String partType, String partName, String beginDate, String endDate, String partNos,
      String department) {

    MiniRtn2Grid<PartNo> grid = new MiniRtn2Grid<PartNo>();
    PartNoCriteria criteria = new PartNoCriteria();

    // 根据物料类型查询(C4_SparePart,C4_Consumptive,C4_WXLH)
    criteriaByPartType(criteria, partType);

    // 根据料号,物料名称,创建人姓名及部门组合查询
    searchPartNoInfoByGroup(criteria, searchKey, ownerName, partName, beginDate, endDate,
        department);

    // 根据物料分类查询
    criteriaByClass(criteria, partId, partClassId);

    // 根据多料号精确查询
    criteriaByAnyPartNo(criteria, partNos);

    // 根据品牌规格组合模糊查询
    searchPartNoByBrandAndSpec(criteria, brandValue, specValue);

    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartNoColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partNoMapper.selectByExample(criteria));
    grid.setTotal(partNoMapper.countByExample(criteria));
    return grid;
  }

  /**
   * 用戶查詢界面组合查询非BOM材料号信息
   * 
   * @param criteria
   * @param searchKey
   * @param ownerName
   * @param partName
   * @param beginDate
   * @param endDate
   * @param department
   */
  private void searchPartNoInfoByGroup(PartNoCriteria criteria, String searchKey, String ownerName,
      String partName, String beginDate, String endDate, String department) {
    if (!StringUtils.hasText(ownerName) && !StringUtils.hasText(searchKey)
        && !StringUtils.hasText(partName) && !StringUtils.hasText(beginDate)
        && !StringUtils.hasText(endDate) && !StringUtils.hasText(department)) {
      return;
    } else {
      PartNoCriteria.Criteria criter = criteria.or();
      // 获取非BOM材料号 partIds
      List<String> partTypeIdList = Lists.newArrayList();
      // ID为("6789"、"2345"、"wxlh"及"otherhis")分别表示备品、耗材、维修料号及非设备备品耗材类
      // updateby xyc20170929用户按时间导出历史料号
      partTypeIdList.add("2342");
      partTypeIdList.add("5464");

      partTypeIdList.add("6789");
      partTypeIdList.add("2345");
      partTypeIdList.add("wxlh");
      partTypeIdList.add("otherhis");
      List<String> partIds = partNoExtMapper.selectNotBomMaterailPartIds(partTypeIdList);
      criter.andPartIdIn(partIds);

      if (StringUtils.hasText(ownerName)) {
        criter.andCreateNameLikeInsensitive("%" + ownerName + "%");
      }

      if (StringUtils.hasText(searchKey)) {
        criter.andPartNoLikeInsensitive("%" + searchKey + "%");
      }

      if (StringUtils.hasText(partName)) {
        criter.andPartNameLikeInsensitive("%" + partName + "%");
      }

      if (StringUtils.hasText(department)) {
        criter.andDepartmentLikeInsensitive("%" + department + "%");
      }

      if (StringUtils.hasText(beginDate)) {
        try {
          criter.andCreateTimeGreaterThanOrEqualTo(format.parse(beginDate));
        } catch (ParseException e) {
          e.printStackTrace();
        }
      }
      if (StringUtils.hasText(endDate)) {
        try {
          // 因为搜索的是日期，时间默认是00:00：00，所以结束日期+1day
          Date date = format.parse(endDate);
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(date);
          calendar.add(Calendar.DAY_OF_MONTH, +1);// 加1之后的日期
          criter.andCreateTimeLessThanOrEqualTo(calendar.getTime());
        } catch (ParseException e) {
          logger.error(e.getMessage());
        }
      }
    }
  }

  @Override
  public List<SpareExcelVbo> getListByBrandSpec(String brand, String spec) {
    List<SpareExcelVbo> list = new ArrayList<SpareExcelVbo>();
    if (StringUtils.hasText(brand) || StringUtils.hasText(spec)) {
      PartNoCriteria criteria = new PartNoCriteria();
      searchPartNoByBrandAndSpec(criteria, brand, spec);
      List<PartNo> partNoList = partNoMapper.selectByExample(criteria);
      if (!partNoList.isEmpty())
        list = translate2SpareExcelVboList(partNoList);
    }
    return list;
  }

  public List<SpareExcelVbo> translate2SpareExcelVboList(List<PartNo> list) {
    List<SpareExcelVbo> rtList = new ArrayList<SpareExcelVbo>();
    for (PartNo pn : list) {
      SpareExcelVbo vb = new SpareExcelVbo();
      vb.setPartNo(pn.getPartNo());
      vb.setPartName(pn.getPartName());
      vb.setPartLevel(getLevelByPartNoId(pn.getId()));
      vb.setDepartment(pn.getDepartment());
      vb.setCreateName(pn.getCreateName());
      vb.setCreateCode(pn.getCreateCode());
      vb.setCreateTime(pn.getCreateTime());
      List<PropertyValueExt> deviceClassList =
          propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(pn.getId(),
              PropertyName.SC_DEVICE_CLASS);
      List<PropertyValueExt> devicePlantList =
          propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(pn.getId(),
              PropertyName.SC_DEVICE_PLANT);
      List<PropertyValueExt> deviceBrandList =
          propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(pn.getId(),
              PropertyName.SC_BRAND);
      List<PropertyValueExt> deviceSpecList =
          propertyValueExtMapper.selectPropertyValueByPartNoIdAndPropertyName(pn.getId(),
              PropertyName.SC_SPEC);
      if (!deviceClassList.isEmpty()) {
        vb.setDeviceClass(deviceClassList.get(0).getPropertyValue());
      }
      if (!devicePlantList.isEmpty()) {
        vb.setDevicePlant(devicePlantList.get(0).getPropertyValue());
      }
      if (!deviceBrandList.isEmpty()) {
        vb.setBrand(deviceBrandList.get(0).getPropertyValue());
      }
      if (!deviceSpecList.isEmpty()) {
        vb.setSpec(deviceSpecList.get(0).getPropertyValue());
      }
      rtList.add(vb);
    }
    return rtList;
  }

  @Override
  public Workbook exportBrandSpecExcel(List<SpareExcelVbo> list) {
    ExcelTemplateProvider classpathExcelTemplateProvider =
        ClasspathExcelTemplateProvider.newInstance("excelTemplate/SpareExportTemplate.xls", 0);

    ExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
        ClasspathXmlExcelDataMappingResolver.newInstance("excelTemplate/SpareExportTemplate.xml");

    return excelExportManager.exportExcel(list, null, classpathExcelTemplateProvider,
        classpathXmlExcelDataMappingResolver);
  }

  @Override
  public List<PartNo> getPartNoListByIdArray(String[] partNoIdArr) {
    List<String> list = Arrays.asList(partNoIdArr);
    PartNoCriteria partNoCriteria = new PartNoCriteria();
    for (int i=0; i < list.size(); i++) {
      partNoCriteria.or().andIdEqualTo(list.get(i));
    }
    // partNoCriteria.or().andIdIn(list);  // 大于1000条不可用IN
    return partNoMapper.selectByExample(partNoCriteria);
  }
}