package com.csot.gm.rawMaterial.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.extension.part.PartExtMapper;
import com.csot.gm.materialManage.dao.extension.partClass.PartClassExtMapper;
import com.csot.gm.materialManage.dao.extension.partType.PartTypeExtMapper;
import com.csot.gm.materialManage.dao.extension.typePartM.TypePartMExtMapper;
import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.dao.original.partClass.PartClassMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.dao.original.partType.PartTypeMapper;
import com.csot.gm.materialManage.model.extension.partType.PartTypeExt;
import com.csot.gm.materialManage.model.extension.typePartM.TypePartMExt;
import com.csot.gm.materialManage.model.original.enumValue.EnumValue;
import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.materialManage.model.original.partClass.PartClass;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.model.original.partNo.PartNoCriteria;
import com.csot.gm.materialManage.model.original.partType.PartType;
import com.csot.gm.materialManage.service.enumValue.EnumValueService;
import com.csot.gm.rawMaterial.model.PartClassTree;
import com.csot.gm.rawMaterial.model.PieChartObj;
import com.csot.gm.rawMaterial.model.PropertyCombo;
import com.csot.gm.rawMaterial.service.DataShowService;

@Service("DataShowService")
public class DataShowServiceImpl implements DataShowService {

  private static final String PROPERTY_PAGE_URL = "rawMaterial/propertyInfo";
  private static final String SPARE_PART = "C4_SparePart";
  private static final String CONSUMPTIVE = "C4_Consumptive";
  private static final String WXLH = "C4_WXLH";
  private static final Logger logger = LoggerFactory.getLogger(DataShowServiceImpl.class);

  @Resource
  private PartMapper partMapper;
  @Resource
  private PartExtMapper partExtMapper;
  @Resource
  private PartClassMapper partClassMapper;
  @Resource
  private PartClassExtMapper partClassExtMapper;
  @Resource
  private PartTypeMapper partTypeMapper;
  @Resource
  private PartTypeExtMapper partTypeExtMapper;
  @Resource
  private TypePartMExtMapper typePartMExtMapper;
  @Resource
  private EnumValueService enumValueService;
  @Resource
  private PartNoMapper partNoMapper;

  /**
   * 获取物料分类数据
   */
  @Override
  public List<PartClassTree> getPartClassData(String partType) {

    logger.info("partType:" + partType);

    if (partType == null || "".equals(partType) || "C4".equals(partType)) {
      List<Part> partList = partExtMapper.getAllPart();
      List<PartClass> classList = partClassExtMapper.getAllPartClass();
      return partClass2Tree(partList, classList);
    } else if (SPARE_PART.equals(partType) || CONSUMPTIVE.equals(partType)) {
      List<PartClassTree> list = new ArrayList<PartClassTree>();
      list.addAll(getPartTreeByPartRealName(SPARE_PART));
      list.addAll(getPartTreeByPartRealName(CONSUMPTIVE));
      list.addAll(getPartTreeByPartRealName(WXLH));
      return list;
    } else {
      return getPartTreeByPartRealName(partType);
    }
  }

  /**
   * 获取属性对应的下拉值
   */
  @Override
  public List<PropertyCombo> getComboData(String enumTypeId) {
    List<PropertyCombo> list = new ArrayList<PropertyCombo>(); // 属性值下拉List

    // 根据属性Id获取属性对应的下拉属性值列表
    List<EnumValue> eveList = enumValueService.getByEnumTypeId(enumTypeId);
    if (!eveList.isEmpty()) {
      for (int i = 0; i < eveList.size(); i++) {
        PropertyCombo pc = new PropertyCombo();
        pc.setId(eveList.get(i).getId());
        pc.setText(eveList.get(i).getEnumText());
        list.add(pc);
      }
    }
    return list;
  }

  public List<PartClassTree> partClass2Tree(List<Part> partList, List<PartClass> classList) {
    List<PartClassTree> list = new ArrayList<PartClassTree>();
    if (!partList.isEmpty()) {
      System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
      // 排序
      Collections.sort(partList, new Comparator<Part>() {
        @Override
        public int compare(Part o1, Part o2) {
          if (o1 == null && o2 == null) {
            return 0;
          }
          if (o1 == null) {
            return -1;
          }
          if (o2 == null) {
            return 1;
          }
          if (o1.getSortId() == null && o2.getSortId() == null) {
            return 0;
          }
          if (o1.getSortId() == null) {
            return -1;
          }
          if (o2.getSortId() == null) {
            return 1;
          }
          if (null != o1.getSortId() && null != o2.getSortId()) {
            int numerA = Integer.parseInt(o1.getSortId());
            int numberB = Integer.parseInt(o2.getSortId());
            if (numerA > numberB) {
              return 1;
            }
            if (numerA == numberB) {
              return 0;
            }
          }
          return -1;
        }
      });
      for (int i = 0; i < partList.size(); i++) {
        PartClassTree tree = new PartClassTree();
        tree.setId(partList.get(i).getId());
        tree.setName(partList.get(i).getPartDesc());
        tree.setParentId(partList.get(i).getParentId());
        tree.setUrl(PROPERTY_PAGE_URL);
        list.add(tree);
      }
    }
    if (!classList.isEmpty()) {
      System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
      // 排序
      Collections.sort(classList, new Comparator<PartClass>() {
        @Override
        public int compare(PartClass o1, PartClass o2) {
          if (o1 == null && o2 == null) {
            return 0;
          }
          if (o1 == null) {
            return -1;
          }
          if (o2 == null) {
            return 1;
          }
          if (o1.getSortId() == null && o2.getSortId() == null) {
            return 0;
          }
          if (o1.getSortId() == null) {
            return -1;
          }
          if (o2.getSortId() == null) {
            return 1;
          }
          if (null != o1.getSortId() && null != o2.getSortId()) {
            int numerA = Integer.parseInt(o1.getSortId());
            int numberB = Integer.parseInt(o2.getSortId());
            if (numerA > numberB) {
              return 1;
            }
            if (numerA == numberB) {
              return 0;
            }
          }
          return -1;
        }
      });
      for (int j = 0; j < classList.size(); j++) {
        PartClassTree tree = new PartClassTree();
        tree.setId(classList.get(j).getId());
        tree.setName(classList.get(j).getClassDesc());
        tree.setParentId(classList.get(j).getParentId());
        list.add(tree);
      }
    }
    return list;
  }

  /**
   * 通过物料类型的真实名称获取分类树
   * 
   * @param partRealName
   * @return
   */
  public List<PartClassTree> getPartTreeByPartRealName(String partRealName) {

    // 物料类型对应的小分类即唯一性物料列表
    List<Part> partList = new ArrayList<Part>();
    // 小分类对应的父类的分类列表
    List<PartClass> classList = new ArrayList<PartClass>();

    Map<String, PartClass> classMap = new HashMap<String, PartClass>();
    List<PartTypeExt> partTypeList = partTypeExtMapper.getPartTypeByRealName(partRealName);
    if (!partTypeList.isEmpty()) {
      String partTypeId = partTypeList.get(0).getId();
      // 根据物料类型Id找出对应的小分类IdList
      List<TypePartMExt> typePartMList = typePartMExtMapper.getByPartTypeId(partTypeId);
      if (!typePartMList.isEmpty()) {
        for (int j = 0; j < typePartMList.size(); j++) {
          String partId = typePartMList.get(j).getPartId();
          Part part = partMapper.selectByPrimaryKey(partId);
          partList.add(part);
          String partParentId = part.getParentId();
          putPartClassMapById(classMap, partParentId);
        }
        Iterator<String> it = classMap.keySet().iterator();
        while (it.hasNext()) {
          String key = it.next();
          classList.add(classMap.get(key));
        }
      }
    }
    return partClass2Tree(partList, classList);
  }

  /**
   * 检查classMap中是否存在class，不存在则插入
   * 
   * @param map
   * @param partClassId
   */
  public void putPartClassMapById(Map<String, PartClass> map, String partClassId) {
    if (!map.containsKey(partClassId)) {
      PartClass partClass2 = partClassMapper.selectByPrimaryKey(partClassId);
      if (null != partClass2) {
        map.put(partClassId, partClass2);
        String partPpId = partClass2.getParentId();
        if (!map.containsKey(partPpId)) {
          PartClass partClass3 = partClassMapper.selectByPrimaryKey(partPpId);
          if (null != partClass3) {
            map.put(partPpId, partClass3);
          }
        }
      }
    }
  }

  /**
   * 获取物料分类数据
   */
  @Override
  public List<PartClassTree> getSpareConsumTree() {
    List<PartClassTree> list = new ArrayList<PartClassTree>();
    list.addAll(getPartTreeByPartRealName(SPARE_PART));
    list.addAll(getPartTreeByPartRealName(CONSUMPTIVE));

    return list;
  }
  
  /**
   * 更新料号信息
   */
  @Override
  public int updatePartNoInfo(String partNoId,String partId){
    PartNo partNo = new PartNo();
    partNo.setPartId(partId);
    partNo.setId(partNoId);
    int recordNum = partNoMapper.updateByPrimaryKeySelective(partNo);
    return recordNum;    
  }

  @Override
  public List<PieChartObj> getPieChartsData4PartNo() {
    List<PieChartObj> list = new ArrayList<PieChartObj>();
    List<PartType> partTypeList = partTypeMapper.selectByExample(null);
    int partNoCountSum = partNoMapper.countByExample(null);
    if (!partTypeList.isEmpty()) {
      for (PartType pt : partTypeList) {
        String partTypeId = pt.getId();
        String partTypeDisName = pt.getPartTypeDisName();
        PieChartObj pco = new PieChartObj();
        pco.setName(partTypeDisName);
        List<TypePartMExt> tpmList = typePartMExtMapper.getByPartTypeId(partTypeId);
        List<String> partIdList = new ArrayList<String>();
        for (TypePartMExt tpm : tpmList) {
          partIdList.add(tpm.getPartId());
        }
        PartNoCriteria criter = new PartNoCriteria();
        criter.or().andPartIdIn(partIdList);
        int count = partNoMapper.countByExample(criter);
        double percent =  100*(double)count / (double)partNoCountSum;
        pco.setY(percent);
        list.add(pco);
      }
    }
    return list;
  }

}
