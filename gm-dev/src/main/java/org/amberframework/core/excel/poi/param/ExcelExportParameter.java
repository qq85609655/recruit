package org.amberframework.core.excel.poi.param;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("excelColumn")
public class ExcelExportParameter {
  
  /** 从属性中取值转化为文本(0) */
  public static final int EXPORT_TYPE_PROPERTY_TEXT = 0;
  /** 配置的常量值转化为文本(1) */
  public static final int EXPORT_TYPE_CONSTANT_TEXT = 1;
  /** 图片(2) */
  public static final int EXPORT_TYPE_PICTORY = 2;
  /** 动态扩展列(3)，此模式下，name属性所指向的属性必须为Collection类型，建议使用有序的Collection */
  public static final int EXPORT_TYPE_DYNAMIC_EXT_COLUMN = 3;

  /**
   * 对应export的属性Name
   */
  @XStreamAsAttribute()
  @XStreamAlias("name")
  protected String name;
  
  /**
   * 单元格位置序号
   */
  @XStreamAsAttribute()
  @XStreamAlias("cellIndex")
  protected int cellIndex;
  
  /**
   * 单元格填充的常量值
   */
  @XStreamAsAttribute()
  @XStreamAlias("constantValue")
  protected String constantValue;
  
  /**
   * 单元格宽度
   */
  @XStreamAsAttribute()
  @XStreamAlias("width")
  protected int width;
  
  /**
   * 单元格高度
   */
  @XStreamAsAttribute()
  @XStreamAlias("height")
  protected int height;
  
  /**
   * 对应exportType，0为属性获取文本，1为配置常量，2为图片
   */
  @XStreamAsAttribute()
  @XStreamAlias("type")
  protected int type;
  
  /**
   * 图片的类型,1是文件,2是数据库
   */
  @XStreamAsAttribute()
  @XStreamAlias("exportImageType")
  protected int  exportImageType;
  
  /**
   * 来源的日期格式
   */
  @XStreamAsAttribute()
  @XStreamAlias("sourceDateFormat")
  protected String sourceDateFormat;
  
  /**
   * 导出的日期格式
   */
  @XStreamAsAttribute()
  @XStreamAlias("exportDateFormat")
  protected String exportDateFormat;
  
  /**
   * cell 函数
   */
  @XStreamAsAttribute()
  @XStreamAlias("cellFormula")
  protected String cellFormula;
  
  /**
   * 子行集合
   */
  @XStreamAlias("children")
  protected List<ExcelExportParameter> list;
  
  /**
   * 是否需要合并，配合子行使用
   */
  @XStreamAsAttribute()
  @XStreamAlias("needMerge")
  protected boolean  needMerge;

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getExportImageType() {
    return exportImageType;
  }

  public void setExportImageType(int exportImageType) {
    this.exportImageType = exportImageType;
  }

  public String getSourceDateFormat() {
    return sourceDateFormat;
  }

  public void setSourceDateFormat(String sourceDateFormat) {
    this.sourceDateFormat = sourceDateFormat;
  }

  public String getExportDateFormat() {
    return exportDateFormat;
  }

  public void setExportDateFormat(String exportDateFormat) {
    this.exportDateFormat = exportDateFormat;
  }

  public String getCellFormula() {
    return cellFormula;
  }

  public void setCellFormula(String cellFormula) {
    this.cellFormula = cellFormula;
  }

  public List<ExcelExportParameter> getList() {
    return list;
  }

  public void setList(List<ExcelExportParameter> list) {
    this.list = list;
  }

  public boolean isNeedMerge() {
    return needMerge;
  }

  public void setNeedMerge(boolean needMerge) {
    this.needMerge = needMerge;
  }

  public int getCellIndex() {
    return cellIndex;
  }

  public void setCellIndex(int cellIndex) {
    this.cellIndex = cellIndex;
  }

  public String getConstantValue() {
    return constantValue;
  }

  public void setConstantValue(String constantValue) {
    this.constantValue = constantValue;
  }
}
