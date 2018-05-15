package com.csot.gm.rawMaterial.service.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csot.gm.materialManage.dao.extension.clean.CleanExtMapper;
import com.csot.gm.materialManage.dao.extension.enumType.EnumTypeExtMapper;
import com.csot.gm.materialManage.dao.extension.enumValue.EnumValueExtMapper;
import com.csot.gm.materialManage.dao.extension.part.PartExtMapper;
import com.csot.gm.materialManage.dao.extension.partClass.PartClassExtMapper;
import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.dao.extension.wxmap.WXMapExtMapper;
import com.csot.gm.materialManage.dao.original.clean.CleanMapper;
import com.csot.gm.materialManage.dao.original.enumType.EnumTypeMapper;
import com.csot.gm.materialManage.dao.original.enumValue.EnumValueMapper;
import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.dao.original.partClass.PartClassMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.dao.original.properties.PartPropertiesMapper;
import com.csot.gm.materialManage.dao.original.propertyValue.PropertyValueMapper;
import com.csot.gm.materialManage.dao.original.typePartM.TypePartMMapper;
import com.csot.gm.materialManage.model.extension.clean.CleanExt;
import com.csot.gm.materialManage.model.extension.enumType.EnumTypeExt;
import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExt;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.wxmap.WXMapExt;
import com.csot.gm.materialManage.model.original.clean.Clean;
import com.csot.gm.materialManage.model.original.enumType.EnumType;
import com.csot.gm.materialManage.model.original.enumValue.EnumValue;
import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.materialManage.model.original.partClass.PartClass;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.model.original.properties.PartProperties;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.materialManage.model.original.typePartM.TypePartM;
import com.csot.gm.materialManage.model.original.wxmap.WXMap;
import com.csot.gm.materialManage.service.clean.CleanService;
import com.csot.gm.materialManage.service.enumValue.EnumValueService;
import com.csot.gm.materialManage.service.gmlog.LogService;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.materialManage.service.wxmap.WXMapService;
import com.csot.gm.rawMaterial.model.EnumImport;
import com.csot.gm.rawMaterial.model.EnumImportList;
import com.csot.gm.rawMaterial.model.PartAndType;
import com.csot.gm.rawMaterial.service.ImportAndExportService;
import com.csot.gm.util.PropertyName;
import com.csot.gm.util.Status;

@Service("ImportAndExportService")
public class ImportAndExportServiceImpl implements ImportAndExportService {

  public static final String FILE_SEPARATOR = "/";
  public static final String CLASS_RELATIVE_PATH_STR = "WEB-INF/classes/";
  public static final String FILE_PATH_PREFIX_STR = "file:/";
  public static final String TEMPLATE_ADDRESS_LEVEL_2 = "excelTemplate/importPartLevel2.xls";
  public static final String TEMPLATE_ADDRESS_LEVEL_3 = "excelTemplate/importPartLevel3.xls";
  public static final String EXCEL_OUTPUT_MOBEL = "excelTemplate/excelOutput.xls";
  public static final String WIN_UPLOAD_PATH = "doc.winpath";
  public static final String LINUX_UPLOAD_PATH = "doc.linuxpath";
  public static final String EXCEL_SUFFIX_MATCH = "^.*\\.(?:xl.{1,2})$";
  public static final String WXLH_TYPE = "C4_WXLH";
  public static final String WXLH_PART_ID = "ac291dce75684bf1862rtttc151b93ce";

  private static final Logger logger = LoggerFactory.getLogger(ImportAndExportServiceImpl.class);

  @Resource
  private PartClassMapper partClassMapper;
  @Resource
  private PartClassExtMapper partClassExtMapper;
  @Resource
  private PartMapper partMapper;
  @Resource
  private PartExtMapper partExtMapper;
  @Resource
  private EnumTypeMapper enumTypeMapper;
  @Resource
  private EnumTypeExtMapper enumTypeExtMapper;
  @Resource
  private EnumValueMapper enumValueMapper;
  @Resource
  private EnumValueExtMapper enumValueExtMapper;
  @Resource
  private TypePartMMapper typePartMMapper;
  @Resource
  private PartPropertiesMapper partPropertiesMapper;
  @Resource
  private PartNoMapper partNoMapper;
  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PropertyValueMapper propertyValueMapper;
  @Resource
  private PropertyValueExtMapper propertyValueExtMapper;
  @Resource
  private CleanMapper cleanMapper;
  @Resource
  private CleanExtMapper cleanExtMapper;
  @Resource
  private WXMapExtMapper wXMapExtMapper;

  @Resource
  private EnumValueService enumValueService;
  @Resource
  private WXMapService wxMapService;
  @Resource
  private PartNoService partNoService;
  @Resource
  private CleanService cleanService;
  @Resource
  private LogService logService;

  @Override
  public String getImportPartTemp(HttpServletResponse response, String level) {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("multipart/form-data");
    try {
      response.setHeader("Content-Disposition",
          "attachment;fileName=" + new String("物料导出模版.xls".getBytes("gbk"), "iso-8859-1"));
    } catch (UnsupportedEncodingException e1) {
      logger.error("download file UnsupportedEncodingException", e1);
    }
    try {
      String filePath = getFilePath(level);
      InputStream inputStream = new FileInputStream(new File(filePath));
      OutputStream os = response.getOutputStream();
      byte[] byt = new byte[2024];
      int length;
      while ((length = inputStream.read(byt)) > 0) {
        os.write(byt, 0, length);
      }
      // 这里注意关闭。
      os.close();
      inputStream.close();
    } catch (FileNotFoundException e) {
      logger.error("download file FileNotFoundException:", e);
    } catch (IOException e) {
      logger.error("download file IOException:", e);
    }
    return null;

  }

  @Override
  public String downloadExcel(HttpServletResponse response) {
    try {
      response.setHeader("Content-disposition", "attachment; filename="
          + new String("excelModel.xls".getBytes("gbk"), "iso-8859-1"));
      response.setContentType("multipart/form-data");
    } catch (UnsupportedEncodingException e) {
      logger.error("download file IOException:", e);
    }

    try {

      String filepath = getPath();
      InputStream inputStream = new FileInputStream(new File(filepath));
      OutputStream output = response.getOutputStream();
      byte[] bt = new byte[1024];
      int length = inputStream.read(bt);
      while (length > 0) {
        output.write(bt, 0, length);
      }
      output.close();
      inputStream.close();
    } catch (FileNotFoundException ex) {
      logger.error("file FileNotFoundException:", ex);
    } catch (Exception ex) {
      logger.error("file IOException:", ex);
    }
    return null;
  }


  /**
   * 获取文件路劲
   * 
   * @return 路劲
   * @throws URISyntaxException
   */
  public String getPath() throws URISyntaxException {
    String filePath = null;
    String currentPath =
        Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
    filePath =
        currentPath.replace(CLASS_RELATIVE_PATH_STR, "").replace(FILE_PATH_PREFIX_STR, "")
            + EXCEL_OUTPUT_MOBEL;
    return filePath;
  }

  /**
   * 获取不同level下的文件路劲
   * 
   * @param level
   * @return 路劲
   */
  public String getFilePath(String level) {
    String filePath = null;
    try {
      String contextPath =
          Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
      // 选择level物料导入模版下载
      if ("2".equals(level)) {
        filePath =
            contextPath.replace(CLASS_RELATIVE_PATH_STR, "").replace(FILE_PATH_PREFIX_STR, "")
                + EXCEL_OUTPUT_MOBEL;
      } else if ("3".equals(level)) {
        filePath =
            contextPath.replace(CLASS_RELATIVE_PATH_STR, "").replace(FILE_PATH_PREFIX_STR, "")
                + TEMPLATE_ADDRESS_LEVEL_3;
      }
    } catch (URISyntaxException e) {
      logger.error(e.getMessage(), e);
    }
    return filePath;
  }


  @Override
  public String uploadExcel(MultipartFile multipartFile, String level, SysUser sysUser) {
    String info = "0"; // 初始化
    // 原始文件名
    String sourceName = multipartFile.getOriginalFilename();
    String fileType = sourceName.substring(sourceName.lastIndexOf("."));
    // 匹配是否上传的文件为excel的后缀
    if (fileType.matches(EXCEL_SUFFIX_MATCH)) {
      try {
        // 获得文件：
        String base = getSysUploadPath(File.separator + "uploadedExcel");
        File file = new File(base);
        if (!file.exists()) {
          file.mkdirs();
        }
        String path = base + File.separator + sourceName;
        multipartFile.transferTo(new File(path));
        // 上传成功后读取Excel表格里面的数据
        info = uploadByType(level, path, sysUser);
      } catch (Exception e) {
        logger.error("read excel error:", e);
      }
    } else {
      logger.error("上传文件格式有误！");
    }
    return info;
  }

  /**
   * 根据不同的参数，上传不同文件
   * 
   * @param level
   * @param path
   * @param sysUser
   */
  public String uploadByType(String level, String path, SysUser sysUser) {
    String info = "0";
    // level2导入
    if ("2".equals(level)) {
      List<PartClass> list = readPartClassExcelFile(path);
      if (!list.isEmpty()) {
        for (int i = 0; i < list.size(); i++) {
          partClassMapper.insert(list.get(i));
        }
        logger.info("上传成功！");
        info = "1";
      } else {
        logger.error("数据有问题，上传失败！");
      }
    }
    // level3导入
    else if ("3".equals(level)) {
      List<PartAndType> list = readPartExcelFile(path);
      if (!list.isEmpty()) {
        for (int i = 0; i < list.size(); i++) {
          partMapper.insert(list.get(i).getPart());
        }
        for (int j = 0; j < list.size(); j++) {
          typePartMMapper.insert(list.get(j).getTpm());
        }
        logger.info("上传成功！");
        info = "1";
      } else {
        logger.error("数据有问题，上传失败！");
      }
    }
    // 枚举值导入
    else if ("enum".equals(level)) {
      EnumImportList ei = readEnumExcelFile(path);
      List<EnumType> etList = ei.getEtList();
      List<EnumValue> evList = ei.getEvList();
      // 过滤属性值
      EnumImportList eiNew = enumFilter(etList, evList);
      List<EnumType> etListNew = eiNew.getEtList();
      List<EnumValue> evListNew = eiNew.getEvList();
      // 上传枚举类
      if (!etListNew.isEmpty()) {
        for (int i = 0; i < etListNew.size(); i++) {
          enumTypeMapper.insert(etListNew.get(i));
          logService.logEnumType(sysUser, etListNew.get(i), "新建");
        }
        logger.info("上传成功！");
        info = "1";
      } else {
        logger.error("无可上传枚举类！");
      }
      // 上传枚举值
      if (!evListNew.isEmpty()) {
        int count = 0;
        boolean isEnumTextExist = false;
        for (int j = 0; j < evListNew.size(); j++) {
          EnumValue ev = evListNew.get(j);          
          isEnumTextExist = enumValueService.isEnumTextExist(ev);
          if (!isEnumTextExist) {
            if (ev.getEnumText().length() <= 30) {
              enumValueMapper.insert(ev);
              logService.logEnumValue(sysUser, ev, "新建");
              count++;
            } else {
              logService.logUploadEnum(ev, sysUser, "新增");
            }
          } else {
            logger.info("enumTypeId:" + ev.getEnumTypeId() + "enumValueText:" + ev.getEnumText() + "已存在，上传失败");
            logService.logUploadEnum(ev, sysUser, "提示");
          }
        }
        if (count == evListNew.size() && (!isEnumTextExist)) {
          logger.info("上传成功！");
          info = "1";
        } else {
          logger.error("上传失败！");
          info = "2";
        }
      } else {
        logger.error("无可上传枚举值！");
      }
    }
    // 属性导入
    else if ("property".equals(level)) {
      List<PartProperties> propList = readPropertiesExcelFile(path);
      if (!propList.isEmpty()) {
        for (int i = 0; i < propList.size(); i++) {
          partPropertiesMapper.insert(propList.get(i));
        }
        logger.info("上传成功！");
        info = "1";
      } else {
        logger.error("数据有问题，上传失败！");
      }
    }
    // 料号导入
    else if ("partNo".equals(level)) {
      List<PartNo> partNoList = readPartNoExcelFile(path);
      if (!partNoList.isEmpty()) {
        for (int i = 0; i < partNoList.size(); i++) {
          partNoMapper.insert(partNoList.get(i));
        }
        logger.info("上传成功！");
        info = "1";
      } else {
        logger.error("数据有问题，上传失败！");
      }
    }
    // 料号属性值导入
    else if ("partProValue".equals(level)) {
      List<PropertyValue> partProVList = readPartProVExcelFile(path);
      if (!partProVList.isEmpty()) {
        for (int i = 0; i < partProVList.size(); i++) {
          propertyValueMapper.insert(partProVList.get(i));
        }
        logger.info("上传成功！");
        info = "1";
      } else {
        logger.error("数据有问题，上传失败！");
      }
    } else if ("spec".equals(level) || "brandSpec".equals(level)) {
      readCleanExcelFile(path, level);
      info = "1";
    } else if ("wxNo".equals(level)) {
      readWxCodeExcelFile(path);
      info = "1";
    } else if ("massRemove".equals(level)) {
      readMassRemoveExcelFile(path);
      info = "1";
    }

    return info;
  }

  /**
   * 过滤要导入的枚举值
   * 
   * @param etList
   * @param evList
   */
  public EnumImportList enumFilter(List<EnumType> etList, List<EnumValue> evList) {

    EnumImportList eiNew = new EnumImportList();

    List<EnumType> etListNew = new ArrayList<EnumType>();
    List<EnumValue> evListNew = new ArrayList<EnumValue>();

    if (!etList.isEmpty()) {
      for (int i = 0; i < etList.size(); i++) {
        String enumTypeName = etList.get(i).getEnumName();
        List<EnumTypeExt> list = enumTypeExtMapper.selectByDesc(enumTypeName);
        // 如果该枚举类已存在
        if (!list.isEmpty()) {
          String enumTypeIdNew = etList.get(i).getId(); // 待插入的枚举类ID
          EnumTypeExt et = list.get(0);
          String enumTypeIdOld = et.getId(); // 数据库中已存在的相同枚举类的ID
          List<EnumValueExt> enumValuelistOld =
              enumValueExtMapper.getEnumValueByType(enumTypeIdOld);
          Map<String, EnumValueExt> map = new HashMap<String, EnumValueExt>(); // 转为map，好做下拉值重复检查
          for (int k = 0; k < enumValuelistOld.size(); k++) {
            map.put(enumValuelistOld.get(k).getEnumText(), enumValuelistOld.get(k));
          }
          // 遍历待插入的枚举值，查重，更换enumTypeId
          for (int j = 0; j < evList.size(); j++) {
            EnumValue enumValue = evList.get(j);
            if (enumValue.getEnumTypeId().equals(enumTypeIdNew)
            /* && (!map.containsKey(enumValue.getEnumText())) */) {
              enumValue.setEnumTypeId(enumTypeIdOld);
              evListNew.add(enumValue);
            }
          }

        } else {
          // 如果枚举类数据库不存在，则直接插入
          etListNew.add(etList.get(i));
          for (int m = 0; m < evList.size(); m++) {
            if (etList.get(i).getId().equals(evList.get(m).getEnumTypeId())) {
              evListNew.add(evList.get(m));
            }
          }
        }
      }

      // 将过滤后的List赋值给原来的List
      eiNew.setEtList(etListNew);
      eiNew.setEvList(evListNew);
    }

    return eiNew;
  }

  @SuppressWarnings("resource")
  private List<PartClass> readPartClassExcelFile(String fileName) {

    List<PartClass> partClassList = new ArrayList<PartClass>();

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          PartClass pc = readPartClassRowExcel(row);
          if (null != pc) {
            partClassList.add(pc);
          }
        }
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
    return partClassList;
  }

  @SuppressWarnings("resource")
  private List<PartAndType> readPartExcelFile(String fileName) {

    List<PartAndType> patList = new ArrayList<PartAndType>();

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          PartAndType pat = readPartRowExcel(row);
          if (null != pat) {
            patList.add(pat);
          }
        }
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
    return patList;
  }

  @SuppressWarnings("resource")
  private EnumImportList readEnumExcelFile(String fileName) {

    EnumImportList eiList = new EnumImportList();
    List<EnumType> etList = new ArrayList<EnumType>();
    List<EnumValue> evList = new ArrayList<EnumValue>();

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        // Map<枚举类名，枚举值List>
        Map<String, List<EnumValue>> map = new HashMap<String, List<EnumValue>>();
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          EnumImport ei = readEnumRowExcel(row);
          EnumValue ev = new EnumValue();
          if (null == ei) continue;
          ev.setEnumText(ei.getEnumValueText());
          ev.setEnumValue(ei.getEnumValueValue());
          ev.setId(UUID.randomUUID().toString().replace("-", ""));
          if (map.containsKey(ei.getEnumTypeName())) {
            map.get(ei.getEnumTypeName()).add(ev);
          } else {
            List<EnumValue> list = new ArrayList<EnumValue>();
            list.add(ev);
            map.put(ei.getEnumTypeName(), list);
          }
        }

        for (Map.Entry<String, List<EnumValue>> entry : map.entrySet()) {
          String enumTypeId = UUID.randomUUID().toString().replace("-", "");
          EnumType et = new EnumType();
          et.setId(enumTypeId);
          et.setEnumName(entry.getKey());
          etList.add(et);
          for (int j = 0; j < entry.getValue().size(); j++) {
            entry.getValue().get(j).setEnumTypeId(enumTypeId);
          }
          evList.addAll(entry.getValue());
        }
        eiList.setEtList(etList);
        eiList.setEvList(evList);
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
    return eiList;
  }

  @SuppressWarnings("resource")
  private List<PartProperties> readPropertiesExcelFile(String fileName) {

    List<PartProperties> proList = new ArrayList<PartProperties>();

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          PartProperties prop = readPropertiesRowExcel(row);
          if (null != prop) {
            proList.add(prop);
          }
        }
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
    return proList;

  }

  @SuppressWarnings("resource")
  private List<PartNo> readPartNoExcelFile(String fileName) {

    List<PartNo> partNoList = new ArrayList<PartNo>();

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          PartNo partNo = readPartNoRowExcel(row);
          if (null != partNo) {
            partNoList.add(partNo);
          }
        }
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
    return partNoList;
  }

  @SuppressWarnings("resource")
  private List<PropertyValue> readPartProVExcelFile(String fileName) {

    List<PropertyValue> partProVList = new ArrayList<PropertyValue>();

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          PropertyValue partProV = readPartProVRowExcel(row);
          if (null != partProV) {
            partProVList.add(partProV);
          }
        }
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
    return partProVList;
  }

  @SuppressWarnings("resource")
  private void readWxCodeExcelFile(String fileName) {

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        if (IsCreateWx(sheet, rowNum)) {
          for (int i = 2; i <= rowNum; i++) {
            Row row = sheet.getRow(i);
            readAndInsertWxCodeRowExcel(row);
          }
        } else {
          logger.info("维修料号导入失败！");
        }
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
  }

  private boolean IsCreateWx(Sheet sheet, int rowNum) {
    for (int i = 2; i <= rowNum; i++) {
      Row row = sheet.getRow(i);
      String wxCode = getValue(row.getCell(0)).trim();
      String oldCode = getValue(row.getCell(1)).trim();
      List<PartNoExt> pnList = partNoExtMapper.selectPartNoListByPartNo(oldCode);
      List<WXMapExt> wxList = wXMapExtMapper.selectByWXCode(wxCode);
      if (pnList.isEmpty() || !wxList.isEmpty()) {
        logger.info("oldCode:" + oldCode + ",wxCode:" + wxCode + "原料号不存在或者维修料号已存在！");
        return false;
      }
    }
    return true;
  }

  private void readAndInsertWxCodeRowExcel(Row row) {

    String wxCode = getValue(row.getCell(0)).trim();
    String oldCode = getValue(row.getCell(1)).trim();
    String partName = getValue(row.getCell(2)).trim();
    String plant = getValue(row.getCell(4)).trim();
    String department = getValue(row.getCell(5)).trim();
    String userCode = getValue(row.getCell(6)).trim();
    String userName = getValue(row.getCell(7)).trim();

    // 存入备品维修表
    WXMap wxMap = new WXMap();
    wxMap.setSpareCode(oldCode);
    wxMap.setWxCode(wxCode);
    wxMapService.create(wxMap);
    // 存入料号总表
    PartNo partNo = new PartNo();
    partNo.setPartNo(wxCode);
    partNo.setPartName(partName);
    partNo.setPartType(WXLH_TYPE);
    partNo.setCreateCode(userCode);
    partNo.setPartNoStatus(Status.IS_PART_RELEASE);
    partNo.setPartId(WXLH_PART_ID);
    partNo.setHashCode(partNoExtMapper.selectPartNoListByPartNo(oldCode).get(0).getHashCode());
    partNo.setPartNoUid("历史数据批量导入");
    partNo.setCreateName(userName);
    partNo.setDepartment(plant + "/" + department);
    partNoService.create(partNo);

  }

  @SuppressWarnings("resource")
  private void readCleanExcelFile(String fileName, String type) {

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          Clean clean = readBrandSpecCleanRowExcel(row, type);
          cleanMapper.insert(clean);
        }
      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
  }

  @SuppressWarnings("resource")
  private void readMassRemoveExcelFile(String fileName) {

    // 创建对Excel工作薄文件的引用
    try {
      FileInputStream in = new FileInputStream(fileName);
      Workbook wb = null;
      if (fileName.endsWith(".xls")) { // Excel2003
        wb = new HSSFWorkbook(in);
      } else { // Excel 2007
        wb = new XSSFWorkbook(in);
      }
      // 创建对工作表的引用
      Sheet sheet = wb.getSheetAt(0);
      // 遍历所有单元格，读取单元格
      int rowNum = sheet.getLastRowNum();
      // 数据为空
      if (rowNum < 2) {
        logger.error("上传文件为空！");
      } else {
        for (int i = 2; i <= rowNum; i++) {
          Row row = sheet.getRow(i);
          removePartNoRowExcel(row);
        }

      }
    } catch (Exception e) {
      logger.error("read excel error:", e);
    }
  }

  // 同时在料号清洗表里面删除和料号表里面删除
  private void removePartNoRowExcel(Row row) {
    String partNo = getValue(row.getCell(0)).trim();
    List<CleanExt> cleanList = cleanExtMapper.selectByPartNo(partNo);
    if (!cleanList.isEmpty()) {
      for (CleanExt clean : cleanList) {
        cleanService.remove(clean.getId());
      }
    }

    List<PartNoExt> pnList = partNoExtMapper.selectPartNoListByPartNo(partNo);
    if (!pnList.isEmpty()) {
      // SysUser sysUser = new SysUser();
      // sysUser.setAccount("批量删除");
      for (PartNoExt pn : pnList) {
        partNoService.remove(pn.getId(), "批量删除");
      }
    }
  }

  private Clean readBrandSpecCleanRowExcel(Row row, String type) {

    String status = "S";
    String info = "";
//    String info = checkLevelName(row);
//    if (!"".equals(info)) {
//      status = "F";
//    }
    System.out.print(row.getCell(4));
    String partNo = getValue(row.getCell(4)).trim();
    String brand = getValue(row.getCell(10)).trim();
    String spec = getValue(row.getCell(11)).trim();
    if ("spec".equals(type)) {
      List<CleanExt> list = cleanExtMapper.selectBySpec(spec);
      if (!list.isEmpty()) {
        status = "F";
        info = info + "/" + "规格已存在，对应料号为：" + list.get(0).getPartNo();
      }

    } else {
      // 检查品牌是否在下拉“61备品&71耗材-品牌”中
//      if (enumValueExtMapper.getByTypeIdAndEnumValue("226bdb3d64054a7ab9fdb22f5483a621", brand)
//          .isEmpty()) {
//        status = "F";
//        info = info + "/品牌值不在标准品牌值“61备品&71耗材-品牌”下拉中";
//      } else {
        List<CleanExt> list = cleanExtMapper.selectByBrandSpec(spec, brand);
        if (!list.isEmpty()) {
          status = "F";
          String partNoOld = list.get(0).getPartNo();
//          List<PartNoExt> partNoList = partNoExtMapper.selectPartNoListByPartNo(partNoOld);
          info = info + "/规格品牌已存在，对应料号为：" + partNoOld;
//          if (!partNoList.isEmpty()) {
//            String partName = partNoList.get(0).getPartName();
//            String department = partNoList.get(0).getDepartment();
//            String createCode = partNoList.get(0).getCreateCode();
//            String createName = partNoList.get(0).getCreateName();
//            String brandOld =
//                propertyValueExtMapper
//                    .selectPropertyValueByPartNoIdAndPropertyName(partNoList.get(0).getId(),
//                        PropertyName.SC_BRAND).get(0).getPropertyValue();
//            String specOld =
//                propertyValueExtMapper
//                    .selectPropertyValueByPartNoIdAndPropertyName(partNoList.get(0).getId(),
//                        PropertyName.SC_SPEC).get(0).getPropertyValue();
//            info =
//                info + "/创建人信息为[" + department + ":" + createCode + createName + "]/名称[" + partName
//                    + "]/品牌[" + brandOld + "]/规格[" + specOld + "]";
//          }
        }
      //}
    }

    Clean clean = new Clean();
    clean.setId(UUID.randomUUID().toString().replace("-", ""));
    clean.setPartNo(partNo);
    clean.setBrand(brand);
    clean.setSpec(spec);
    clean.setStatus(status);
    clean.setInfo(info);

    return clean;
  }

  public String checkLevelName(Row row) {
    String info = "";
    String level1Name = getValue(row.getCell(0)).trim();
    String level2Name = getValue(row.getCell(1)).trim();
    String level3Name = getValue(row.getCell(2)).trim();

    List<PartClass> level1L = partClassExtMapper.getByClassDesc(level1Name);
    if (!level1L.isEmpty()) {
      List<PartClass> level2L =
          partClassExtMapper.getByClassDescAndParentId(level2Name, level1L.get(0).getId());
      if (!level2L.isEmpty()) {
        List<Part> level3L =
            partExtMapper.getByPartNameAndParentId(level3Name, level2L.get(0).getId());
        if (level3L.isEmpty()) {
          info = "level3名称有误";
        }
      } else {
        info = "level2名称有误";
      }
    } else {
      info = "level1名称有误";
    }
    return info;
  }


  private PartClass readPartClassRowExcel(Row row) {

    PartClass partClass = null;
    String parentName = getValue(row.getCell(0)).trim();
    String classDesc = getValue(row.getCell(1)).trim();
    List<PartClass> list = partClassExtMapper.getByClassDesc(parentName);
    if (list != null && list.size() == 1) {
      partClass = new PartClass();
      partClass.setParentId(list.get(0).getId());
      partClass.setId(UUID.randomUUID().toString().replace("-", ""));
      partClass.setClassDesc(classDesc);
    } else {
      logger.error(parentName + "物料不存在");
    }

    return partClass;
  }

  private PartAndType readPartRowExcel(Row row) {

    PartAndType pat = null;
    Part part = null;
    TypePartM tpm = null;
    String level1Id = getValue(row.getCell(1)).trim();
    String level2Name = getValue(row.getCell(2)).trim();
    String partName = getValue(row.getCell(3)).trim();
    String partCode = getValue(row.getCell(4)).trim();
    String partPageUrl = getValue(row.getCell(5)).trim();
    String partTypeId = getValue(row.getCell(6)).trim();
    List<PartClass> class2list = partClassExtMapper.getByClassDescAndParentId(level2Name, level1Id);
    if (null != class2list && class2list.size() == 1) {
      pat = new PartAndType();
      part = new Part();
      tpm = new TypePartM();
      String partId = UUID.randomUUID().toString().replace("-", "");
      part.setId(partId);
      part.setPartPrefixCode(partCode);
      part.setPartDesc(partName);
      part.setParentId(class2list.get(0).getId());
      part.setPartUrl(partPageUrl);
      tpm.setId(UUID.randomUUID().toString().replace("-", ""));
      tpm.setPartId(partId);
      tpm.setPartTypeId(partTypeId);
      pat.setPart(part);
      pat.setTpm(tpm);
    } else {
      logger.error(partName + "的父类物料有问题");
    }

    return pat;
  }

  private EnumImport readEnumRowExcel(Row row) {

    EnumImport ei = new EnumImport();
    String enumTypeName = getValue(row.getCell(0)).trim();
    String enumValueText = getValue(row.getCell(1)).trim();
    String enumValueValue = getValue(row.getCell(2)).trim();
    List<EnumTypeExt> list = enumTypeExtMapper.selectByDesc(enumTypeName);
    
    // 需求新增bywangqing20170411:导入下拉类不存在，不允许导入下拉值
    if (list.isEmpty()) {
      return null;
    }
    ei.setEnumTypeName(enumTypeName);
    ei.setEnumValueText(enumValueText);
    ei.setEnumValueValue(enumValueValue);
    return ei;
  }

  private PartProperties readPropertiesRowExcel(Row row) {

    PartProperties prop = null;
    String level1Id = getValue(row.getCell(1)).trim();
    String level2Name = getValue(row.getCell(2)).trim();
    String partName = getValue(row.getCell(3)).trim();
    String propertyRealName = getValue(row.getCell(5)).trim();
    String propertyDisName = getValue(row.getCell(6)).trim();
    String isEnum = getValue(row.getCell(7));
    String isUnique = getValue(row.getCell(8));

    List<PartClass> class2list = partClassExtMapper.getByClassDescAndParentId(level2Name, level1Id);
    if (null != class2list && class2list.size() == 1) {
      List<Part> partList =
          partExtMapper.getByPartNameAndParentId(partName, class2list.get(0).getId());
      if (null != partList && partList.size() == 1) {
        prop = new PartProperties();
        prop.setId(UUID.randomUUID().toString().replace("-", ""));
        prop.setIsEnum(isEnum);
        prop.setIsUnique(isUnique);
        prop.setPartId(partList.get(0).getId());
        prop.setPropertyDisName(propertyDisName);
        prop.setPropertyName(propertyRealName);
      }
    } else {
      logger.error(partName + "的父类物料有问题");
    }

    return prop;
  }

  private PartNo readPartNoRowExcel(Row row) {

    PartNo pn = new PartNo();
    String level1Name = getValue(row.getCell(0)).trim();
    String level2Name = getValue(row.getCell(1)).trim();
    String level3Name = getValue(row.getCell(2)).trim();
    String partNo = getValue(row.getCell(3)).trim();
    String partName = getValue(row.getCell(4)).trim();
    String department = getValue(row.getCell(5)).trim();
    String createCode = getValue(row.getCell(6)).trim();
    String createName = getValue(row.getCell(7)).trim();
    String partNoId = getValue(row.getCell(8)).trim();
    String hashCode = getValue(row.getCell(9)).trim();

    String level1Id = partClassExtMapper.getByClassDesc(level1Name).get(0).getId();
    String level2Id =
        partClassExtMapper.getByClassDescAndParentId(level2Name, level1Id).get(0).getId();
    String level3Id = partExtMapper.getByPartNameAndParentId(level3Name, level2Id).get(0).getId();

    pn.setId(partNoId);
    pn.setPartNo(partNo);
    pn.setPartName(partName);
    pn.setDepartment(department);
    pn.setCreateCode(createCode);
    pn.setPartNoStatus("2");
    pn.setPartId(level3Id);
    pn.setHashCode(hashCode);
    pn.setCreateName(createName);

    return pn;

  }

  private PropertyValue readPartProVRowExcel(Row row) {

    PropertyValue pv = new PropertyValue();
    String partNoId = getValue(row.getCell(0)).trim();
    String propertyName = getValue(row.getCell(1)).trim();
    String propertyValue = getValue(row.getCell(2)).trim();

    pv.setId(UUID.randomUUID().toString().replace("-", ""));
    pv.setPartNoId(partNoId);
    pv.setPropertyName(propertyName);
    pv.setPropertyValue(propertyValue);
    pv.setPropertyType("Y");

    return pv;

  }

  /**
   * . 获取单元格的值.
   * 
   * @Description: getValue方法.
   * @return String
   */
  @SuppressWarnings("static-access")
  public String getValue(Cell cell) {
    if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
      return String.valueOf(cell.getBooleanCellValue());
    } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
      return String.valueOf(cell.getNumericCellValue());
    } else {
      return String.valueOf(cell.getStringCellValue());
    }
  }


  /**
   * 获取可配置的文档上传的路径.
   * 
   * @Description: getSysUploadPath方法.
   * @return String
   */
  public static String getSysUploadPath(String logoPathDir) {
    String os = System.getProperty("os.name");
    // 获得类加载器，然后把文件作为一个流获取
    InputStream in =
        ImportAndExportServiceImpl.class.getClassLoader().getResourceAsStream(
            "sys-docupload.properties");
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
