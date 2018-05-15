package org.amberframework.core.excel.poi.template;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.base.Throwables;

public class ClasspathExcelTemplateProvider implements ExcelTemplateProvider {

  public static final String FILE_SEPARATOR = "/";
  public static final String CLASS_RELATIVE_PATH_STR = "WEB-INF/classes/";
  public static final String FILE_PATH_PREFIX_STR = "file:/";

  protected String fileName;
  protected int sheetIndex;
  protected String relativePath;

  protected ClasspathExcelTemplateProvider() {

  }

  /**
   * 构建从webapp目录算起的不带文件夹路径ClasspathExcelTemplateProvider对象.
   * 
   * <p>
   * Excel不能放在classpath中主要是因为编译打包war的时候，Excel模板会被修改，导致文件损坏。
   * 涉及路径分割请使用"/"符号，或{@link #FILE_SEPARATOR}常量.
   * 
   * @param fileName 文件名
   * @param sheetIndex 需要用到的模板文件中的sheet序号，从0开始算
   * @return ClasspathExcelTemplateProvider对象
   */
  public static ClasspathExcelTemplateProvider newInstance(String fileName, int sheetIndex) {
    ClasspathExcelTemplateProvider provider = new ClasspathExcelTemplateProvider();
    provider.fileName = fileName;
    provider.sheetIndex = sheetIndex < 0 ? 0 : sheetIndex;
    provider.relativePath = "";
    return provider;
  }

  /**
   * 构建从webapp目录算起的带有文件夹路径ClasspathExcelTemplateProvider对象.
   * 
   * <p>
   * Excel不能放在classpath中主要是因为编译打包war的时候，Excel模板会被修改，导致文件损坏。
   * 涉及路径分割请使用"/"符号，或{@link #FILE_SEPARATOR}常量.
   * 
   * @param fileName 文件名
   * @param sheetIndex 需要用到的模板文件中的sheet序号，从0开始算
   * @param relativePath 文件所在的文件夹路径
   * @return ClasspathExcelTemplateProvider对象
   */
  public static ClasspathExcelTemplateProvider newInstanceWithPath(String fileName, int sheetIndex,
      String relativePath) {
    ClasspathExcelTemplateProvider provider = new ClasspathExcelTemplateProvider();
    provider.fileName = fileName;
    provider.sheetIndex = sheetIndex < 0 ? 0 : sheetIndex;
    provider.relativePath = null == relativePath ? "" : relativePath;
    return provider;
  }

  @Override
  public Workbook doGetExcelTemplateClone() {
    // 拷贝Excel导出模板源文件
    Workbook workbook = null;
    try {
      if (StringUtils.isEmpty(relativePath)) {
        workbook = cloneTemplateWorkbook(fileName);
      } else {
        workbook = cloneTemplateWorkbook(relativePath + FILE_SEPARATOR + fileName);
      }
    } catch (IOException ioe) {
      Throwables.propagate(ioe);
    }

    // 移除不需要的sheet
    removeOtherSheet(workbook, sheetIndex);
    return workbook;
  }

  /**
   * 复制Excel模板，使Excel导出不会修改到模板源文件.
   * 
   * @param fullPathFileName 包含全路径的文件名，要带后缀
   * @return POI Workbook对象
   * @throws IOException 关闭文件时的IO异常
   */
  private static Workbook cloneTemplateWorkbook(String fullPathFileName) throws IOException {
    Workbook workbook = null;
    InputStream is = null;
    try {
      String contextPath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
      String filePath =
          contextPath.replace(CLASS_RELATIVE_PATH_STR, "").replace(FILE_PATH_PREFIX_STR, "")
              + fullPathFileName;
      is = new FileInputStream(filePath);
      workbook = WorkbookFactory.create(is);
    } catch (EncryptedDocumentException | IOException | URISyntaxException | InvalidFormatException ex) {
      throw Throwables.propagate(ex);
    } finally {
      if (null != is) {
        is.close();
      }
    }
    return workbook;
  }

  /**
   * 将除了指定Index以外的其他Sheet移除.
   * 
   * @param workbook 要删除Sheet的Workbook
   * @param sheetIndex 需要保留的Sheet的index号，从0开始算
   */
  private static void removeOtherSheet(Workbook workbook, int sheetIndex) {
    for (int i = workbook.getNumberOfSheets() - 1; i >= 0; i--) {
      if (i != sheetIndex) {
        workbook.removeSheetAt(i);
      }
    }
  }
}
