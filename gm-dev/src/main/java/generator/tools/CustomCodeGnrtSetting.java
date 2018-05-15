package generator.tools;

import java.util.List;
import java.util.Map;

import generator.pojo.DatabaseType;

/**
 * 保存用户定义的生成代码的设置
 * 
 * @author luojunfeng
 */
public class CustomCodeGnrtSetting {

  public static final String UUID = "uuid";

  public static final String SEQUENCE = "sequence";

  public static final String COLUMN = "Column";

  public static final String JDBC_TYPE = "JDBC Type";

  public static final String JAVA_PROPERTY = "Java Property";

  public static final String JAVA_TYPE = "Java Type";

  /**
   * 包名
   */
  private String baseModulePackageStr;

  /**
   * 表名
   */
  private String tableNameStr;

  /**
   * 子模块名
   */
  private String subModulePackageStr;

  /**
   * 类名
   */
  private String objectNameStr;

  /**
   * 数据库类型
   */
  private DatabaseType databaseType;

  /**
   * 生成模式，初次生成还是再次生成
   */
  private boolean firstGeneration;

  /**
   * 主键生成策略
   */
  private String keyStrategy;

  /**
   * 主键列名
   */
  private String keyColumnName;

  /**
   * 序列名
   */
  private String sequenceName;

  /**
   * 属性生成是否trim
   */
  private boolean trimString;

  /**
   * 是否生成service
   */
  private boolean serviceGenerated;

  /**
   * 是否生成controller
   */
  private boolean controllerGenerated;

  /**
   * 自定义列转换设置
   */
  private List<Map<String, String>> customColumnList;

  /**
   * @return 包名
   */
  public String getBaseModulePackageStr() {
    return baseModulePackageStr;
  }

  /**
   * @param baseModulePackageStr 包名
   */
  public void setBaseModulePackageStr(String baseModulePackageStr) {
    this.baseModulePackageStr = baseModulePackageStr;
  }

  /**
   * @return 表名
   */
  public String getTableNameStr() {
    return tableNameStr;
  }

  /**
   * @param tableNameStr 表名
   */
  public void setTableNameStr(String tableNameStr) {
    this.tableNameStr = tableNameStr;
  }

  /**
   * @return 子模块名
   */
  public String getSubModulePackageStr() {
    return subModulePackageStr;
  }

  /**
   * @param subModulePackageStr 子模块名
   */
  public void setSubModulePackageStr(String subModulePackageStr) {
    this.subModulePackageStr = subModulePackageStr;
  }

  /**
   * @return 类名
   */
  public String getObjectNameStr() {
    return objectNameStr;
  }

  /**
   * @param objectNameStr 类名
   */
  public void setObjectNameStr(String objectNameStr) {
    this.objectNameStr = objectNameStr;
  }

  /**
   * @return 数据库类型
   */
  public DatabaseType getDatabaseType() {
    return databaseType;
  }

  /**
   * @param databaseType 数据库类型
   */
  public void setDatabaseType(DatabaseType databaseType) {
    this.databaseType = databaseType;
  }

  /**
   * @return 生成模式，是否初次生成
   */
  public boolean isFirstGeneration() {
    return firstGeneration;
  }

  /**
   * @param firstGeneration 生成模式，是否初次生成
   */
  public void setFirstGeneration(boolean firstGeneration) {
    this.firstGeneration = firstGeneration;
  }

  /**
   * @return 主键生成策略
   */
  public String getKeyStrategy() {
    return keyStrategy;
  }

  /**
   * @param keyStrategy 主键生成策略
   */
  public void setKeyStrategy(String keyStrategy) {
    this.keyStrategy = keyStrategy;
  }

  /**
   * @return 主键列名
   */
  public String getKeyColumnName() {
    return keyColumnName;
  }

  /**
   * @param keyColumnName 主键列名
   */
  public void setKeyColumnName(String keyColumnName) {
    this.keyColumnName = keyColumnName;
  }

  /**
   * @return 序列名
   */
  public String getSequenceName() {
    return sequenceName;
  }

  /**
   * @param sequenceName 序列名
   */
  public void setSequenceName(String sequenceName) {
    this.sequenceName = sequenceName;
  }

  /**
   * @return 生成属性是否trim
   */
  public boolean isTrimString() {
    return trimString;
  }

  /**
   * @param trimString 生成属性是否trim
   */
  public void setTrimString(boolean trimString) {
    this.trimString = trimString;
  }

  /**
   * @return 是否生成service
   */
  public boolean isServiceGenerated() {
    return serviceGenerated;
  }

  /**
   * @param serviceGenerated 是否生成service
   */
  public void setServiceGenerated(boolean serviceGenerated) {
    this.serviceGenerated = serviceGenerated;
  }

  /**
   * @return 是否生成controller
   */
  public boolean isControllerGenerated() {
    return controllerGenerated;
  }

  /**
   * @param controllerGenerated 是否生成controller
   */
  public void setControllerGenerated(boolean controllerGenerated) {
    this.controllerGenerated = controllerGenerated;
  }

  /**
   * @return 自定义列转换设置
   */
  public List<Map<String, String>> getCustomColumnList() {
    return customColumnList;
  }

  /**
   * @param customColumnList 自定义列转换设置
   */
  public void setCustomColumnList(List<Map<String, String>> customColumnList) {
    this.customColumnList = customColumnList;
  }

}
