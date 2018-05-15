package com.csot.gm.rawMaterial.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.extension.enumValue.EnumValueExtMapper;
import com.csot.gm.materialManage.dao.extension.part.PartExtMapper;
import com.csot.gm.materialManage.dao.extension.partClass.PartClassExtMapper;
import com.csot.gm.materialManage.dao.extension.properties.PartPropertiesExtMapper;
import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExt;
import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.partClass.PartClass;
import com.csot.gm.rawMaterial.model.MassCreateResult;
import com.csot.gm.rawMaterial.service.CheckProAndCreateService;
import com.csot.gm.rawMaterial.service.PartNoAddService;
import com.csot.gm.util.ModelSequence;
import com.csot.gm.util.PropertyName;

@Service("PartNunberAddService")
public class PartNoAddServiceImpl implements PartNoAddService {

  private static final Logger logger = LoggerFactory.getLogger(ImportAndExportServiceImpl.class);

  public static final String CLASS_RELATIVE_PATH_STR = "WEB-INF/classes/";
  public static final String FILE_PATH_PREFIX_STR = "file:/";
  public static final String EXCEL_OUTPUT_MOBEL = "excelTemplate/MassCreationPartNoModel.xls";

  public static final String EXCEL_TYPE = "^.*\\.(?:xl.{1,2})$";
  public static final String WIN_UPLOAD_PATH = "doc.winpath";
  public static final String LINUX_UPLOAD_PATH = "doc.linuxpath";

  public static final List<String> STORE_CONDITION = Arrays.asList(new String[] {"常温常压",
      "冷藏（0-10度）", "冷冻（0度以下）", "干燥（相对湿度低于50%）", "防爆", "防尘"});
  public static final List<String> PURE_UNIT = Arrays.asList(new String[] {"BAG", "BOT", "CAN",
      "CAR", "DR", "EA", "G", "KAN", "KAR", "KG", "L", "M", "M3", "ML", "NL", "NM3", "PAA", "PAC",
      "PKK", "PCS", "ROA", "ROL", "SET", "SHE", "TON"});

  @Resource
  private PartPropertiesExtMapper partPropertiesExtMapper;
  @Resource
  private CheckProAndCreateService checkProAndCreateService;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private EnumValueExtMapper enumValueExtMapper;
  @Resource
  PartClassExtMapper partClassExtMapper;
  @Resource
  PartExtMapper partExtMapper;

  /**
   * 导出工程中已有的批量新增料号信息模板
   */
  @Override
  public void exportTemplate(HttpServletResponse response) {
    try {
      // 获取文件所在路径
      String filePath = getFilePath();
      InputStream inputStream = new FileInputStream(new File(filePath));
      OutputStream os = response.getOutputStream();
      byte[] byt = new byte[2024];
      int length;
      while ((length = inputStream.read(byt)) > 0) {
        os.write(byt, 0, length);
      }
      os.close();
      inputStream.close();
    } catch (IOException | URISyntaxException ex) {
      logger.error("下载的模板不存在！", ex);
      ex.printStackTrace();
    }
  }


  @SuppressWarnings("resource")
  @Override
  public void checkMess(String path) {
    Sheet sheet = null;
    try {
      FileInputStream inputStream = new FileInputStream(path);
      Workbook wb = null;
      if (path.endsWith(".xls")) {
        wb = new HSSFWorkbook(inputStream);
      } else {
        wb = new XSSFWorkbook(inputStream);
      }
      // 获取新增料号模板表
      sheet = wb.getSheetAt(0);
      // 数据有问题的cell填充颜色为黄色
      CellStyle style = wb.createCellStyle();
      style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
      style.setFillPattern(CellStyle.SOLID_FOREGROUND);
      CellStyle style2 = wb.createCellStyle();
      style2.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
      // 设置错误提示信息字体格式为粗体红色
      Font font = wb.createFont();
      font.setColor(IndexedColors.RED.getIndex());
      font.setBoldweight(Font.BOLDWEIGHT_BOLD);
      CellStyle style3 = wb.createCellStyle();
      style3.setFont(font);

      Map<String, CellStyle> styleMap = new HashMap<String, CellStyle>();
      styleMap.put("yellowCell", style);
      styleMap.put("whiteCell", style2);
      styleMap.put("redFont", style3);
      // 调用检验并生成料号的方法
      checkMassCreate(sheet, styleMap);
      FileOutputStream os = new FileOutputStream(path);
      wb.write(os);
      os.flush();
      os.close();

    } catch (IOException e) {
      logger.error("上传失败.", e);
    }

  }

  /**
   * 获取模板中的数据到对象中，且调用校验方法检验属性
   * 
   * @param sheet
   * @param style
   * @param style2
   * @return
   */
  public MassCreateResult checkMassCreate(Sheet sheet, Map<String, CellStyle> map) {

    MassCreateResult massCreateResult = new MassCreateResult();

    // 调用校验必填属性方法，若为空，则在相应的单元格中做标记
    massCreateResult = checkIsRequirement(sheet, map);

    // 如果必填属性校验通过 ，则检验下拉属性是否在下拉中，如果不在则在相应的单元格做出错误标记
    if (massCreateResult.isSuccess()) {
      massCreateResult = checkIsEnum(sheet, map);
    }

    // 如果下拉值校验通过，自比较表格中的品牌/规格，如果存在相同的品牌/规格，则在相应的单元格做出错误标记
    if (massCreateResult.isSuccess()) {
      massCreateResult = compareUnique(sheet, map);
    }
    // 如果下拉值检验通过，则进入创建料号方法
    if (massCreateResult.isSuccess()) {
      checkProAndCreateService.checkMassAndSingle(massCreateResult, null, null);
    }

    return massCreateResult;
  }

  /**
   * 通过获取模板表中的level1 ID、level 2、 level 3获取partId
   * 
   * @param level1Id、level2Name、 level3Name
   * @return partId
   */
  @Override
  public String getPartId(Row row) {
    String partId = "";
    String level2Id = "";
    // 从模板表获取level1 Id、level 2、 level 3
    String level1Id = row.getCell(ModelSequence.LEVEL1_ID).toString().trim();
    String level2Name = row.getCell(ModelSequence.LEVEL2_NAME).toString().trim();
    String level3Name = row.getCell(ModelSequence.LEVEL3_NAME).toString().trim();
    // 通过level2Name和level1Id查询level2Id
    List<PartClass> list = partClassExtMapper.getByClassDescAndParentId(level2Name, level1Id);
    if (!list.isEmpty()) {
      level2Id = partClassExtMapper.getByClassDescAndParentId(level2Name, level1Id).get(0).getId();
    }
    // 通过level3Name和level2Id查询level3Id即partId
    if (!(partExtMapper.getByPartNameAndParentId(level3Name, level2Id).isEmpty())) {
      partId = partExtMapper.getByPartNameAndParentId(level3Name, level2Id).get(0).getId();
    }
    return partId;
  }


  /**
   * 通过patId、property_name获取相应的下拉值并校验模板中填写的值是否在下拉属性值内
   * 
   * @param partId、propName、enumValue模板中对应的属性值
   * @return boolean 是否验证通过
   */
  public boolean checkPropertyEnumValue(String partId, String propName, String enumValue) {
    // 通过partId 和 属性名 获取id列表
    List<PartPropertiesExt> idList =
        partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, propName);
    String id = "";
    if (!idList.isEmpty()) {
      id = idList.get(0).getId();
    }
    // 通过id获取Enmu_id
    List<PropertiesMExt> enmuIdList = propertiesMExtMapper.getEnumIdByPropertyId(id);
    String typeId = "";
    if (!enmuIdList.isEmpty()) {
      typeId = enmuIdList.get(0).getEnumId();
    }
    // 根据Enmu_id获取enumText下拉值
    List<EnumValueExt> enumTextL = enumValueExtMapper.getEnumValueByType(typeId);
    for (EnumValueExt enumValueExt : enumTextL) {
      if (enumValueExt.getEnumText().equals(enumValue)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 通过比较所填的propName属性值与PURE_UNIT列表，判断其是否在下拉中
   * 
   * @param propName模板中所填属性值
   * @return boolean 是否验证通过
   */
  public boolean isPureUnit(String propName, List<String> enumList) {
    boolean isExist = false;
    for (String pureUnitT : enumList) {
      if (propName.equals(pureUnitT)) {
        isExist = true;
        break;
      } 
    }
    return isExist;
  }

  /**
   * 判断必填属性是否填写，如必填属性没有填写，则在相应的单元格做出错误标志
   */
  public MassCreateResult checkIsRequirement(Sheet sheet, Map<String, CellStyle> map) {
    MassCreateResult massCr = new MassCreateResult();
    CellStyle style = null;
    CellStyle style2 = null;
    if (map.size() > 0) {
      style = map.get("yellowCell");
      style2 = map.get("whiteCell");
    }
    boolean hasValue = true;
    for (int i = 5; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);
      String partId = getPartId(row);
      if ("".equals(partId)) {
        row.getCell(ModelSequence.LEVEL1_NAME).setCellStyle(style);
        hasValue = false;
        continue;
      } else {
        row.getCell(ModelSequence.LEVEL1_NAME).setCellStyle(style2);
      }

      // 固定属性的必填检查
      hasValue = checkFixedRequired(row, style, style2, hasValue);

      // 变量属性的必填属性
      List<PartPropertiesExt> propList = partPropertiesExtMapper.getPropertiesByPartId(partId);
      Row propRow = sheet.getRow(4);
      for (PartPropertiesExt propTempListExt : propList) {
        String propName = propTempListExt.getPropertyName();
        for (int j = ModelSequence.PROPERTY_START; j <= ModelSequence.PROPERTY_END; j++) {
          // 如果存在该必填属性且对应的属性值为空，则标志该单元格
          if (propName.equals(propRow.getCell(j).toString())) {
            if ("".equals(row.getCell(j).toString())) {
              hasValue = false;
              row.getCell(j).setCellStyle(style);
            } else {
              row.getCell(j).setCellStyle(style2);
            }
          }
        }
      }
    }

    massCr.setSuccess(hasValue);
    return massCr;
  }

  /**
   * 固定属性的必填检查
   * 
   * @param row
   * @param style
   * @param style2
   * @param hasValue
   */
  public boolean checkFixedRequired(Row row, CellStyle style, CellStyle style2, boolean oldValue) {
    boolean hasValue = oldValue; // 初始化
    if ("".equals(row.getCell(ModelSequence.PART_NO_NAME).toString())) {
      row.getCell(ModelSequence.PART_NO_NAME).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.PART_NO_NAME).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.CN_DESC).toString())) {
      row.getCell(ModelSequence.CN_DESC).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.CN_DESC).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.EN_DESC).toString())) {
      row.getCell(ModelSequence.EN_DESC).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.EN_DESC).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.USER_CODE).toString())) {
      row.getCell(ModelSequence.USER_CODE).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.USER_CODE).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.USER_NAME).toString())) {
      row.getCell(ModelSequence.USER_NAME).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.USER_NAME).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.USER_TELE).toString())) {
      row.getCell(ModelSequence.USER_TELE).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.USER_TELE).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.PLANT).toString())) {
      row.getCell(ModelSequence.PLANT).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.PLANT).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.DEPARTMENT).toString())) {
      row.getCell(ModelSequence.DEPARTMENT).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.DEPARTMENT).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.SPEC).toString())) {
      row.getCell(ModelSequence.SPEC).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.SPEC).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.BRAND).toString())) {
      row.getCell(ModelSequence.BRAND).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.BRAND).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.IS_DANGEROUS).toString())) {
      row.getCell(ModelSequence.IS_DANGEROUS).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.IS_DANGEROUS).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.STORE_CONDITION).toString())) {
      row.getCell(ModelSequence.STORE_CONDITION).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.STORE_CONDITION).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.PUR_UNIT).toString())) {
      row.getCell(ModelSequence.PUR_UNIT).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.PUR_UNIT).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.LEVEL1_NAME).toString())) {
      row.getCell(ModelSequence.LEVEL1_NAME).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.LEVEL1_NAME).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.LEVEL1_ID).toString())) {
      row.getCell(ModelSequence.LEVEL1_ID).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.LEVEL1_ID).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.LEVEL2_NAME).toString())) {
      row.getCell(ModelSequence.LEVEL2_NAME).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.LEVEL2_NAME).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.LEVEL3_NAME).toString())) {
      row.getCell(ModelSequence.LEVEL3_NAME).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.LEVEL3_NAME).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.DEVICE_CLASS).toString())) {
      row.getCell(ModelSequence.DEVICE_CLASS).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.DEVICE_CLASS).setCellStyle(style2);
    }
    if ("".equals(row.getCell(ModelSequence.DEVICE_PLANT).toString())) {
      row.getCell(ModelSequence.DEVICE_PLANT).setCellStyle(style);
      hasValue = false;
    } else {
      row.getCell(ModelSequence.DEVICE_PLANT).setCellStyle(style2);
    }

    return hasValue;
  }

  /**
   * 判断下拉值是否在下拉中
   * 
   * @param sheet
   * @param map
   * @return
   */
  public MassCreateResult checkIsEnum(Sheet sheet, Map<String, CellStyle> map) {

    MassCreateResult mcEnumResult = new MassCreateResult();
    CellStyle style = null;
    CellStyle style2 = null;
    if (map.size() > 0) {
      style = map.get("yellowCell");
      style2 = map.get("whiteCell");
    }
    boolean isEnum = true;

    for (int i = 5; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);
      String partId = getPartId(row);
      if ("".equals(partId)) {
        row.getCell(ModelSequence.LEVEL1_NAME).setCellStyle(style);
        isEnum = false;
        continue;
      } else {
        row.getCell(ModelSequence.LEVEL1_NAME).setCellStyle(style2);
      }
      // 模板中用户填写的品牌/规格对应的值
      String brandValue = row.getCell(ModelSequence.BRAND).toString();
      String specValue = row.getCell(ModelSequence.SPEC).toString();
      // 模板中设备类别/产商的表头
      String dcValue = sheet.getRow(4).getCell(ModelSequence.DEVICE_CLASS).toString();
      String dpValue = sheet.getRow(4).getCell(ModelSequence.DEVICE_PLANT).toString();
      // 模板中用户填写的设备类别/产商对应的值
      String deviceClass = row.getCell(ModelSequence.DEVICE_CLASS).toString();
      String devicePlant = row.getCell(ModelSequence.DEVICE_PLANT).toString();
      boolean specIsExist = checkPropertyEnumValue(partId, PropertyName.SC_SPEC, specValue);
      boolean brandIsExist = checkPropertyEnumValue(partId, PropertyName.SC_BRAND, brandValue);
      boolean dcIsExist = checkPropertyEnumValue(partId, dcValue, deviceClass);

      if (specIsExist) {
        row.getCell(ModelSequence.SPEC).setCellStyle(style2);
      } else {
        // 若下拉值校验不通过，则将此单元格标志为黄色
        row.getCell(ModelSequence.SPEC).setCellStyle(style);
        isEnum = false;
      }
      // 批量创建料号不考虑品牌为NA不限和NA未知的情况
      if (brandIsExist && !("NA不限".equals(brandValue)) && !("NA未知".equals(brandValue))) {
        row.getCell(ModelSequence.BRAND).setCellStyle(style2);
      } else {
        // 若下拉值校验不通过，则将此单元格标志为黄色
        row.getCell(ModelSequence.BRAND).setCellStyle(style);
        isEnum = false;
      }
      if (dcIsExist) {
        row.getCell(ModelSequence.DEVICE_CLASS).setCellStyle(style2);
      } else {
        // 若下拉值校验不通过，则将此单元格标志为黄色
        row.getCell(ModelSequence.DEVICE_CLASS).setCellStyle(style);
        isEnum = false;
      }
      boolean dpIsExist = checkPropertyEnumValue(partId, dpValue, devicePlant);
      if (dpIsExist) {
        row.getCell(ModelSequence.DEVICE_PLANT).setCellStyle(style2);
      } else {
        // 若下拉值校验不通过，则将此单元格标志为黄色
        row.getCell(ModelSequence.DEVICE_PLANT).setCellStyle(style);
        isEnum = false;
      }
      // 判断填入是否危废品属性值是否在下拉值
      if ("Y".equals(row.getCell(ModelSequence.IS_DANGEROUS).toString())
          || "N".equals(row.getCell(ModelSequence.IS_DANGEROUS).toString())) {
        row.getCell(ModelSequence.IS_DANGEROUS).setCellStyle(style2);
      } else {
        row.getCell(ModelSequence.IS_DANGEROUS).setCellStyle(style);
        isEnum = false;
      }
      // 判断填入的单位属性值是否在下拉值
      if (isPureUnit(row.getCell(ModelSequence.PUR_UNIT).toString(), PURE_UNIT)) {
        row.getCell(ModelSequence.PUR_UNIT).setCellStyle(style2);
      } else {
        row.getCell(ModelSequence.PUR_UNIT).setCellStyle(style);
        isEnum = false;
      }
      // 判断填入的存储条件属性值是否在下拉值
      if (isPureUnit(row.getCell(ModelSequence.STORE_CONDITION).toString(), STORE_CONDITION)) {
        row.getCell(ModelSequence.STORE_CONDITION).setCellStyle(style2);
      } else {
        row.getCell(ModelSequence.STORE_CONDITION).setCellStyle(style);
        isEnum = false;
      }
      // 对比变量属性
      List<PartPropertiesExt> propList = partPropertiesExtMapper.getPropertiesByPartId(partId);
      for (int num = ModelSequence.PROPERTY_START; num < ModelSequence.PROPERTY_END; num++) {
        // 获取模板表中的真实名
        String propName = sheet.getRow(4).getCell(num).toString();
        for (int k = 0; k < propList.size(); k++) {
          PartPropertiesExt ppExt = propList.get(k);
          if (propName.equals(ppExt.getPropertyName())) {
            String enumV = ppExt.getIsEnum();
            String propValue = row.getCell(num).toString();
            boolean isExist = checkPropertyEnumValue(partId, propName, propValue);
            if ("Y".equals(enumV) && !isExist) {
              // 若下拉值校验不通过，则将此单元格标志为黄色
              row.getCell(num).setCellStyle(style);
              isEnum = false;
            } else {
              row.getCell(num).setCellStyle(style2);
            }
          }
        }
      }
    }

    mcEnumResult.setSheet(sheet);
    mcEnumResult.setSuccess(isEnum);
    return mcEnumResult;
  }


  /**
   * 比较模板表中是否存在相同的品牌和规格，若存在相同品牌和规格则在料号对应的单元格做标志
   * 
   * @param sheet
   * @param style
   * @return
   */
  public MassCreateResult compareUnique(Sheet sheet, Map<String, CellStyle> map) {
    MassCreateResult mcResult = new MassCreateResult();
    CellStyle style = null;
    if (map.size() > 0) {
      style = map.get("redFont");
    }
    boolean isUnique = true;

    for (int i = 5; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);
      String brand = row.getCell(ModelSequence.BRAND).toString();
      String spec = row.getCell(ModelSequence.SPEC).toString();
      for (int j = i + 1; j <= sheet.getLastRowNum(); j++) {
        Row nextRow = sheet.getRow(j);
        // 如果存在相同的品牌\规格，则将料号对应单元格设为黄色
        if (brand.equals(nextRow.getCell(ModelSequence.BRAND).toString())
            && spec.equals(nextRow.getCell(ModelSequence.SPEC).toString())) {
          Cell brandCell = nextRow.getCell(ModelSequence.PART_NO);
          String infoM = "此表格中已存在相同品牌规格的物料";
          brandCell.setCellValue(infoM);
          brandCell.setCellStyle(style);
          isUnique = false;
        }
      }
    }
    mcResult.setSuccess(isUnique);
    mcResult.setSheet(sheet);
    return mcResult;
  }

  /**
   * 获取当前文件所在路径
   * 
   * @return
   * @throws URISyntaxException
   */
  public String getFilePath() throws URISyntaxException {
    String filePath = null;
    String currentPath =
        Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
    filePath =
        currentPath.replace(CLASS_RELATIVE_PATH_STR, "").replace(FILE_PATH_PREFIX_STR, "")
            + EXCEL_OUTPUT_MOBEL;
    return filePath;
  }

  /**
   * 获取可配置的文档上传的路径.
   * 
   * @Description: getSysUploadPath方法.
   * @return String
   */
  public String getSysUploadPath(String logoPathDir) {
    String os = System.getProperty("os.name");
    // 获得类加载器，然后把文件作为一个流获取
    InputStream in =
        PartNoAddServiceImpl.class.getClassLoader().getResourceAsStream("sys-docupload.properties");
    // 创建Properties实例
    Properties prop = new Properties();
    // 将Properties和流关联
    String docPathString = "";
    try {
      prop.load(in);
      Enumeration<?> allName = prop.propertyNames();
      // 遍历
      if (os.toLowerCase().startsWith("win")) {
        while (allName.hasMoreElements()) {
          // 获得每一个名称
          String name = (String) allName.nextElement();
          if (name.equals(WIN_UPLOAD_PATH)) {
            String value = (String) prop.get(name);
            docPathString = value + logoPathDir;
            break;
          }
        }
      } else {
        while (allName.hasMoreElements()) {
          String name = (String) allName.nextElement();
          if (name.equals(LINUX_UPLOAD_PATH)) {
            String value = (String) prop.get(name);
            docPathString = value + logoPathDir;
            break;
          }
        }
      }
      // 关闭资源
      in.close();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
    return docPathString;
  }

}
