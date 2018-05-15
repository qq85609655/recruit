package org.amberframework.core.excel.poi.mapping;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.amberframework.core.excel.poi.param.ExcelExportParamCollection;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Throwables;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ClasspathXmlExcelDataMappingResolver implements ExcelDataMappingResolver {

  public static final String FILE_SEPARATOR = "/";
  public static final String CLASS_RELATIVE_PATH_STR = "WEB-INF/classes/";
  public static final String FILE_PATH_PREFIX_STR = "file:/";

  protected String fileName;
  protected String relativePath;

  protected ClasspathXmlExcelDataMappingResolver() {

  }

  /**
   * 通过静态工厂获取对象实例.在webapp目录下的文件.
   * 
   * <p>
   * 涉及路径分割请使用"/"符号，或{@link #FILE_SEPARATOR}常量.
   * 
   * @param fileName 文件名称，包含后缀
   * @return ClasspathXmlExcelDataMappingResolver对象
   */
  public static ClasspathXmlExcelDataMappingResolver newInstance(String fileName) {
    ClasspathXmlExcelDataMappingResolver resolver = new ClasspathXmlExcelDataMappingResolver();
    resolver.fileName = fileName;
    resolver.relativePath = "";
    return resolver;
  }

  /**
   * 通过静态工厂获取对象实例.在webapp目录下的包含文件夹路径和文件.
   * 
   * <p>
   * 涉及路径分割请使用"/"符号，或{@link #FILE_SEPARATOR}常量.
   * 
   * @param fileName 文件名称，包含后缀
   * @param relativePath 从classpath开始的文件夹相对路径
   * @return ClasspathXmlExcelDataMappingResolver对象
   */
  public static ClasspathXmlExcelDataMappingResolver
      newInstanceWithPath(String fileName, String relativePath) {
    ClasspathXmlExcelDataMappingResolver resolver = new ClasspathXmlExcelDataMappingResolver();
    resolver.fileName = fileName;
    resolver.relativePath = null == relativePath ? "" : relativePath;
    return resolver;
  }

  @Override
  public ExcelExportParamCollection doGetExcelDataMapping() {
    XStream xstream = new XStream(new DomDriver());
    xstream.processAnnotations(ExcelExportParamCollection.class);
    InputStream is = null;
    ExcelExportParamCollection collection = null;
    try {
      String fullPathFileName =
          (StringUtils.isEmpty(relativePath) ? "" : relativePath + FILE_SEPARATOR) + fileName;
      String contextPath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
      String filePath =
          contextPath.replace(CLASS_RELATIVE_PATH_STR, "").replace(FILE_PATH_PREFIX_STR, "")
              + fullPathFileName;
      is = new FileInputStream(filePath);
      collection = (ExcelExportParamCollection) xstream.fromXML(is);
    } catch (IOException | URISyntaxException ex) {
      Throwables.propagate(ex);
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException ex2) {
          Throwables.propagate(ex2);
        }
        is = null;
      }
    }
    return collection;
  }

}
