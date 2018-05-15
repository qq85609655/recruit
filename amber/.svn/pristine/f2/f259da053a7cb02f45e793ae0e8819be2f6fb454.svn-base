package generator.tools;

import generator.pojo.DatabaseType;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.ColumnOverride;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.NullProgressCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class AmberCodeGeneratorTool {

  private static final Logger logger = LoggerFactory.getLogger(AmberCodeGeneratorTool.class);

  private static final String JAVA_MODEL_TARGET_PACKAGE = "model";
  private static final String SQL_MAP_TARGET_PACKAGE = "mapper";
  private static final String JAVA_CLIENT_TARGET_PACKAGE = "dao";
  private static final String JAVA_SERVICE_TARGET_PACKAGE = "service";
  private static final String JAVA_CONTROLLER_TARGET_PACKAGE = "controller";

  private static final String TARGET_PROJECT_SRC = "/src/main/java";
  private static final String THIS_CLASS_SUB_PATH = "/target/classes/";
  private static final String SUFFIX_EXTENSION_MAPPER = "Ext";

  private static final String TARGET_PACKAGE_PROP_NAME = "targetPackage";
  private static final String TARGET_PROJECT_PATH_PROP_NAME = "targetProjectPath";
  private static final String KEY_STRATEGY_PROP_NAME = "keyStrategy";
  private static final String ENABLE_SUBPACKAGES_PROP_NAME = "enableSubPackages";
  private static final String TRIM_STRINGS_PROP_NAME = "trimStrings";
  private static final String ROOT_INTERFACE_PROP_NAME = "rootInterface";
  private static final String BOOLEAN_TRUE_STR = "true";
  private static final String BOOLEAN_FALSE_STR = "false";

  private String baseModulePackage = "";
  private String tableName = "";
  private String subModulePackage = "";
  private String objectName = "";
  private DatabaseType databaseType = DatabaseType.GENERAL;
  // generatorMode拼接package路径是在tableConfig的domainObjectName中，不在basePackage中
  private GeneratorMode generatorMode = GeneratorMode.ORIGINAL;
  private boolean isServiceGenerated = true;
  private boolean isControllerGenerated = true;
  private boolean javaModelTrimString = false;
  private List<ColumnOverride> columnOverrideList;
  private String generatedKeyStrategy = "";
  private String generatedKeyColumn = "";
  private String generatedKeySqlStatement = "";

  /**
   * 根据用户配置生成代码
   * 
   * @param customCodeGnrtSetting 用户配置
   * @return 生成代码是否成功
   */
  public static boolean generatorCode(CustomCodeGnrtSetting customCodeGnrtSetting) {
    boolean success = true;

    try {
      List<ColumnOverride> columnList = new ArrayList<ColumnOverride>();
      boolean trimString = customCodeGnrtSetting.isTrimString();
      boolean firstGeneration = customCodeGnrtSetting.isFirstGeneration();
      String keyStrategy = customCodeGnrtSetting.getKeyStrategy();
      String keyColumn = customCodeGnrtSetting.getKeyColumnName();
      String sequenceName = customCodeGnrtSetting.getSequenceName();
      String keySqlStatement =
          new StringBuffer().append("select ").append(sequenceName).append(".NEXTVAL from dual").toString();


      String baseModulePackageStr = customCodeGnrtSetting.getBaseModulePackageStr();
      String tableNameStr = customCodeGnrtSetting.getTableNameStr();
      String subModulePackageStr = customCodeGnrtSetting.getSubModulePackageStr();
      String objectNameStr = customCodeGnrtSetting.getObjectNameStr();

      DatabaseType databaseType = customCodeGnrtSetting.getDatabaseType();
      boolean serviceGenerated = customCodeGnrtSetting.isServiceGenerated();
      boolean controllerGenerated = customCodeGnrtSetting.isControllerGenerated();

      // 获取用户输入的自定义列转换设置
      List<Map<String, String>> customColumnList = customCodeGnrtSetting.getCustomColumnList();
      for (Map<String, String> customColumnListItem : customColumnList) {
        String columnName = customColumnListItem.get(CustomCodeGnrtSetting.COLUMN).toUpperCase();
        String jdbcTypeStr = customColumnListItem.get(CustomCodeGnrtSetting.JDBC_TYPE);
        String javaPropertyStr = customColumnListItem.get(CustomCodeGnrtSetting.JAVA_PROPERTY);
        String javaTypeStr = customColumnListItem.get(CustomCodeGnrtSetting.JAVA_TYPE);
        if (!StringUtils.isEmpty(columnName)
            && (!StringUtils.isEmpty(jdbcTypeStr) || !StringUtils.isEmpty(javaPropertyStr) || !StringUtils
                .isEmpty(javaTypeStr))) {
          ColumnOverride columnOverride = new ColumnOverride(columnName);
          if (!StringUtils.isEmpty(jdbcTypeStr)) {
            columnOverride.setJdbcType(jdbcTypeStr);
          }
          if (!StringUtils.isEmpty(javaPropertyStr)) {
            columnOverride.setJavaProperty(javaPropertyStr);
          }
          if (!StringUtils.isEmpty(javaTypeStr)) {
            columnOverride.setJavaType(javaTypeStr);
          }
          columnList.add(columnOverride);
        }
      }

      // 生成Original MyBatis代码，同时生成默认的Service和Controller代码
      AmberCodeGeneratorTool originalGeneratorTool = new AmberCodeGeneratorTool();
      originalGeneratorTool.setDatabaseType(databaseType);
      originalGeneratorTool.setBaseModulePackage(baseModulePackageStr);
      originalGeneratorTool.setTableName(tableNameStr);
      originalGeneratorTool.setSubModulePackage(subModulePackageStr);
      originalGeneratorTool.setObjectName(objectNameStr);
      originalGeneratorTool.setServiceGenerated(serviceGenerated);
      originalGeneratorTool.setControllerGenerated(controllerGenerated);
      originalGeneratorTool.setColumnOverrideList(columnList);
      originalGeneratorTool.setJavaModelTrimString(trimString);
      originalGeneratorTool.setGeneratedKeyStrategy(keyStrategy);
      originalGeneratorTool.setGeneratedKeyColumn(keyColumn);
      originalGeneratorTool.setGeneratedKeySqlStatement(keySqlStatement);

      originalGeneratorTool.generator();

      // 生成Extension MyBatis代码，不生成Service和Controller代码
      if (firstGeneration) {
        AmberCodeGeneratorTool customGeneratorTool = new AmberCodeGeneratorTool();
        customGeneratorTool.setDatabaseType(databaseType);
        customGeneratorTool.setBaseModulePackage(baseModulePackageStr);
        customGeneratorTool.setTableName(tableNameStr);
        customGeneratorTool.setSubModulePackage(subModulePackageStr);
        customGeneratorTool.setObjectName(objectNameStr);
        customGeneratorTool.setGeneratorMode(GeneratorMode.EXTENSION);
        customGeneratorTool.setServiceGenerated(false);
        customGeneratorTool.setControllerGenerated(false);
        customGeneratorTool.setColumnOverrideList(columnList);
        customGeneratorTool.setJavaModelTrimString(trimString);
        customGeneratorTool.setGeneratedKeyStrategy(keyStrategy);
        customGeneratorTool.setGeneratedKeyColumn(keyColumn);
        customGeneratorTool.setGeneratedKeySqlStatement(keySqlStatement);

        customGeneratorTool.generator();
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      success = false;
    }

    return success;
  }

  /**
   * 已经有GUI，这个方法暂时不用了 本来是main方法，前面加了aaA是为了防止运行工程（Run project）时一不小心执行这里 要用的时候将前面的aaA去掉，用完后再加回去 ^_^
   */
  public static void aaAmain(String[] args) {
    List<ColumnOverride> columnList = new ArrayList<ColumnOverride>();
    boolean trimString = false;
    String keyStrategy = "";
    String keyColumn = "";
    String keySqlStatement = "";

    // 以下为代码生成配置项，根据表和生成规则，修改以下内容

    // String baseModulePackageStr = "org.amberframework.web.system.auth";
    String baseModulePackageStr = "haha.test2";
    String tableNameStr = "T_TEST_USER";
    String subModulePackageStr = "user";
    String objectNameStr = "TestUser";

    DatabaseType databaseType = DatabaseType.ORACLE;
    boolean serviceGenerated = true;
    boolean controllerGenerated = true;

    // 以下为可选配置 --------------------
    // 生成的model属性值是否自动去掉不必要的空格，建议如果table中有字段设置为CHAR类型时配置为true
    // trimString = true;

    // 如果主键要求使用sequence生成，可以配置以下两个属性（都要配置）
    // keyStrategy = "sequence";
    // keyColumn = "ID"; // 需要使用sequence生成的列名
    // keySqlStatement = "select SEQ_SYS_RESOURCE_PERMISSION_ID.NEXTVAL from dual"; //
    // 需要使用的sequence，请参照例子中的写法获取，修改sequenceName

    // 对部分列进行特定配置
    // {
    // ColumnOverride birthday = new ColumnOverride("BIRTHDAY");
    // birthday.setJdbcType(JdbcType.TIMESTAMP.name());
    // columnList.add(birthday);
    // }
    // {
    // ColumnOverride deployTime = new ColumnOverride("DEPLOY_TIME");
    // deployTime.setJdbcType(JdbcType.TIMESTAMP.name());
    // columnList.add(deployTime);
    // }
    // 可选配置结束 --------------------

    // String baseModulePackageStr = "test.testcase";
    // String tableNameStr = "T_SYS_USER";
    // String subModulePackageStr = "base";
    // String objectNameStr = "LoginUser";

    // ！！！重新生成时需要注意，要注释掉下面Extension部分，并删除mapper下面的XML文件再生成，因为.java是覆盖，.xml是追加！！！

    try { // 生成Original MyBatis代码，同时生成默认的Service和Controller代码
      AmberCodeGeneratorTool originalGeneratorTool = new AmberCodeGeneratorTool();
      originalGeneratorTool.setDatabaseType(databaseType);
      originalGeneratorTool.setBaseModulePackage(baseModulePackageStr);
      originalGeneratorTool.setTableName(tableNameStr);
      originalGeneratorTool.setSubModulePackage(subModulePackageStr);
      originalGeneratorTool.setObjectName(objectNameStr);
      originalGeneratorTool.setServiceGenerated(serviceGenerated);
      originalGeneratorTool.setControllerGenerated(controllerGenerated);
      originalGeneratorTool.setColumnOverrideList(columnList);
      originalGeneratorTool.setJavaModelTrimString(trimString);
      originalGeneratorTool.setGeneratedKeyStrategy(keyStrategy);
      originalGeneratorTool.setGeneratedKeyColumn(keyColumn);
      originalGeneratorTool.setGeneratedKeySqlStatement(keySqlStatement);

      originalGeneratorTool.generator();
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    }

    try { // 生成Extension MyBatis代码，不生成Service和Controller代码
      AmberCodeGeneratorTool customGeneratorTool = new AmberCodeGeneratorTool();
      customGeneratorTool.setDatabaseType(databaseType);
      customGeneratorTool.setBaseModulePackage(baseModulePackageStr);
      customGeneratorTool.setTableName(tableNameStr);
      customGeneratorTool.setSubModulePackage(subModulePackageStr);
      customGeneratorTool.setObjectName(objectNameStr);
      customGeneratorTool.setGeneratorMode(GeneratorMode.EXTENSION);
      customGeneratorTool.setServiceGenerated(false);
      customGeneratorTool.setControllerGenerated(false);
      customGeneratorTool.setColumnOverrideList(columnList);
      customGeneratorTool.setJavaModelTrimString(trimString);
      customGeneratorTool.setGeneratedKeyStrategy(keyStrategy);
      customGeneratorTool.setGeneratedKeyColumn(keyColumn);
      customGeneratorTool.setGeneratedKeySqlStatement(keySqlStatement);

      customGeneratorTool.generator();
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    }

  }

  void generator() {
    List<String> warnings = new ArrayList<String>();
    boolean overwrite = true;
    String genCfgPath = "/generator/generatorConfig.xml";
    File configFile = new File(AmberCodeGeneratorTool.class.getResource(genCfgPath).getFile());
    ConfigurationParser cp = new ConfigurationParser(warnings);
    Configuration config = null;
    try {
      config = cp.parseConfiguration(configFile);
      this.appendConfig(config);
    } catch (IOException | XMLParserException ex) {
      logger.error(ex.getMessage(), ex);
    }
    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    MyBatisGenerator myBatisGenerator = null;
    try {
      myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
    } catch (InvalidConfigurationException ex) {
      logger.error(ex.getMessage(), ex);
    }
    try {
      ProgressCallback progressCallback = new NullProgressCallback();
      if (null != progressCallback) {
        myBatisGenerator.generate(progressCallback);
      }
    } catch (SQLException | IOException | InterruptedException ex) {
      logger.error(ex.getMessage(), ex);
    }
    logger.info("Generate " + generatorMode.getPack() + ": " + this.objectName + " success!");

  }

  private void appendConfig(Configuration config) {
    // 获取工程根目录，作为导出代码的targetProject目录
    String projectPath = this.getClass().getResource("/").getPath();
    logger.debug(projectPath);
    int pathEndIndex = projectPath.indexOf(THIS_CLASS_SUB_PATH);
    StringBuilder targetProjectStrBuilder = new StringBuilder(projectPath.substring(0, pathEndIndex));
    targetProjectStrBuilder.append(TARGET_PROJECT_SRC);
    String targetProjectPath = targetProjectStrBuilder.toString();

    // 获取XML中的配置
    Context context = config.getContext("GeneratorContext");
    if (null == context) {
      context = new Context(ModelType.CONDITIONAL);
      config.addContext(context);
    }

    // 设置插件
    this.appendPlugins(context, targetProjectPath);

    // 获取Java model config，设置targetPackage和targetProject
    this.setJavaModelGeneratorConfig(context, targetProjectPath);

    // 获取Java sql map config，设置targetPackage和targetProject
    this.setSqlMapGeneratorConfig(context, targetProjectPath);

    // 获取Java mapper client config，设置targetPackage和targetProject
    this.setJavaClientGeneratorConfig(context, targetProjectPath);

    this.appendTables(context);
  }

  private void appendPlugins(Context context, String targetProjectPath) {
    try { // 生成Oracle分页的plugin
      PluginConfiguration oraclePaginationPlugin = new PluginConfiguration();
      oraclePaginationPlugin.setConfigurationType("generator.plugins.paging.OraclePaginationPlugin");
      context.addPluginConfiguration(oraclePaginationPlugin);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    }

    try { // 生成Bean property 对应column的plugin
      PluginConfiguration beanColumnsPlugin = new PluginConfiguration();
      beanColumnsPlugin.setConfigurationType("generator.plugins.BeanColumnsPlugin");
      // Columns - Bean放在model目录下
      StringBuilder packageStrBuilder = new StringBuilder(this.baseModulePackage);
      if (packageStrBuilder.length() > 0) {
        packageStrBuilder.append(".");
      }
      packageStrBuilder.append(JAVA_MODEL_TARGET_PACKAGE);
      beanColumnsPlugin.addProperty(TARGET_PACKAGE_PROP_NAME, packageStrBuilder.toString());
      beanColumnsPlugin.addProperty(TARGET_PROJECT_PATH_PROP_NAME, targetProjectPath);
      context.addPluginConfiguration(beanColumnsPlugin);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    }

    // Extension不生成Service，Controller，JSP
    if (!this.getGeneratorMode().equals(GeneratorMode.EXTENSION)) {
      if (this.isServiceGenerated) { // 生成Service代码的plugin
        PluginConfiguration beanServicePlugin = new PluginConfiguration();
        beanServicePlugin.setConfigurationType("generator.plugins.AmberBeanServicePlugin");
        // Service放在service目录下
        StringBuilder packageStrBuilder = new StringBuilder(this.baseModulePackage);
        if (packageStrBuilder.length() > 0) {
          packageStrBuilder.append(".");
        }
        packageStrBuilder.append(JAVA_SERVICE_TARGET_PACKAGE);
        beanServicePlugin.addProperty(TARGET_PACKAGE_PROP_NAME, packageStrBuilder.toString());
        beanServicePlugin.addProperty(TARGET_PROJECT_PATH_PROP_NAME, targetProjectPath);
        beanServicePlugin.addProperty(KEY_STRATEGY_PROP_NAME, this.generatedKeyStrategy);
        context.addPluginConfiguration(beanServicePlugin);
      }
      if (this.isControllerGenerated) { // 生成Controller代码的plugin
        PluginConfiguration beanControllerPlugin = new PluginConfiguration();
        beanControllerPlugin.setConfigurationType("generator.plugins.AmberBeanControllerPlugin");
        // Controller放在controller目录下
        StringBuilder packageStrBuilder = new StringBuilder(this.baseModulePackage);
        if (packageStrBuilder.length() > 0) {
          packageStrBuilder.append(".");
        }
        packageStrBuilder.append(JAVA_CONTROLLER_TARGET_PACKAGE);
        beanControllerPlugin.addProperty(TARGET_PACKAGE_PROP_NAME, packageStrBuilder.toString());
        beanControllerPlugin.addProperty(TARGET_PROJECT_PATH_PROP_NAME, targetProjectPath);
        context.addPluginConfiguration(beanControllerPlugin);
      }
    }
  }

  private void setJavaModelGeneratorConfig(Context context, String targetProjectPath) {
    JavaModelGeneratorConfiguration javaModelConfig = context.getJavaModelGeneratorConfiguration();
    if (null == javaModelConfig) {
      javaModelConfig = new JavaModelGeneratorConfiguration();
    }
    javaModelConfig.addProperty(ENABLE_SUBPACKAGES_PROP_NAME, BOOLEAN_FALSE_STR);
    if (this.javaModelTrimString) {
      javaModelConfig.addProperty(TRIM_STRINGS_PROP_NAME, BOOLEAN_TRUE_STR);
    } else {
      javaModelConfig.addProperty(TRIM_STRINGS_PROP_NAME, BOOLEAN_FALSE_STR);
    }
    context.setJavaModelGeneratorConfiguration(javaModelConfig);

    StringBuilder modelPackageStrBuilder = new StringBuilder(this.baseModulePackage);
    if (modelPackageStrBuilder.length() > 0) {
      modelPackageStrBuilder.append(".");
    }
    modelPackageStrBuilder.append(JAVA_MODEL_TARGET_PACKAGE);
    javaModelConfig.setTargetPackage(modelPackageStrBuilder.toString());
    javaModelConfig.setTargetProject(targetProjectPath);
  }

  private void setSqlMapGeneratorConfig(Context context, String targetProjectPath) {
    SqlMapGeneratorConfiguration sqlMapConfig = context.getSqlMapGeneratorConfiguration();
    if (null == sqlMapConfig) {
      sqlMapConfig = new SqlMapGeneratorConfiguration();
      sqlMapConfig.addProperty(ENABLE_SUBPACKAGES_PROP_NAME, BOOLEAN_FALSE_STR);
      context.setSqlMapGeneratorConfiguration(sqlMapConfig);
    }
    StringBuilder sqlMapPackageStrBuilder = new StringBuilder(this.baseModulePackage);
    if (sqlMapPackageStrBuilder.length() > 0) {
      sqlMapPackageStrBuilder.append(".");
    }
    sqlMapPackageStrBuilder.append(SQL_MAP_TARGET_PACKAGE);
    // 如果数据库配置了特定的，则生成的mapper XML添加包名，xxx.mapper."dbtype"。主要是分页会用到
    if (!databaseType.equals(DatabaseType.GENERAL)) {
      sqlMapPackageStrBuilder.append(".").append(databaseType.getPack());
    }
    sqlMapConfig.setTargetPackage(sqlMapPackageStrBuilder.toString());
    sqlMapConfig.setTargetProject(targetProjectPath);
  }

  private void setJavaClientGeneratorConfig(Context context, String targetProjectPath) {
    JavaClientGeneratorConfiguration javaClientConfig = context.getJavaClientGeneratorConfiguration();
    if (null == javaClientConfig) {
      javaClientConfig = new JavaClientGeneratorConfiguration();
      javaClientConfig.setConfigurationType("XMLMAPPER");
      javaClientConfig.addProperty(ENABLE_SUBPACKAGES_PROP_NAME, BOOLEAN_FALSE_STR);
      javaClientConfig.addProperty(ROOT_INTERFACE_PROP_NAME,
          "org.amberframework.core.mybatis.dao.MyBatisBaseMapper");
      context.setJavaClientGeneratorConfiguration(javaClientConfig);
    }
    StringBuilder javaClientPackageStrBuilder = new StringBuilder(this.baseModulePackage);
    if (javaClientPackageStrBuilder.length() > 0) {
      javaClientPackageStrBuilder.append(".");
    }
    javaClientPackageStrBuilder.append(JAVA_CLIENT_TARGET_PACKAGE);
    javaClientConfig.setTargetPackage(javaClientPackageStrBuilder.toString());
    javaClientConfig.setTargetProject(targetProjectPath);
  }

  private void appendTables(Context context) {
    // 将xml配置文件中的table信息清空，使用传入的table配置
    List<TableConfiguration> tableList = context.getTableConfigurations();
    tableList.clear();

    // 添加table的示例配置
    TableConfiguration tableConfig = new TableConfiguration(context);
    tableConfig.setTableName(this.getTableName());
    // 用GeneratorMode + subModulePackage + objectName拼接真正的domainObjectName
    StringBuilder domainObjectNameStrBuilder = new StringBuilder(this.generatorMode.getPack());
    if (domainObjectNameStrBuilder.length() > 0) {
      domainObjectNameStrBuilder.append(".");
    }
    if (StringUtils.hasText(this.subModulePackage)) {
      domainObjectNameStrBuilder.append(this.subModulePackage);
      domainObjectNameStrBuilder.append(".");
    }
    domainObjectNameStrBuilder.append(this.objectName);
    if (this.generatorMode.equals(GeneratorMode.EXTENSION) && StringUtils.hasText(this.objectName)) {
      domainObjectNameStrBuilder.append(SUFFIX_EXTENSION_MAPPER);
    }
    tableConfig.setDomainObjectName(domainObjectNameStrBuilder.toString());

    // 如果需要通过Sequence生成主键值，则需要配置generatedKey
    if ("sequence".equals(this.generatedKeyStrategy) && StringUtils.hasText(this.getGeneratedKeyColumn())
        && StringUtils.hasText(this.getGeneratedKeySqlStatement())) {
      appendTableGeneratedKey(tableConfig);
    }

    // 将特殊列配置放入table中
    if (this.columnOverrideList != null) {
      for (ColumnOverride column : columnOverrideList) {
        tableConfig.addColumnOverride(column);
      }
    }

    // Extension只生成Count示例
    if (this.generatorMode.equals(GeneratorMode.EXTENSION)) {
      tableConfig.setInsertStatementEnabled(false);
      tableConfig.setSelectByExampleStatementEnabled(false);
      tableConfig.setSelectByPrimaryKeyStatementEnabled(false);
      tableConfig.setUpdateByExampleStatementEnabled(false);
      tableConfig.setUpdateByPrimaryKeyStatementEnabled(false);
      tableConfig.setDeleteByExampleStatementEnabled(false);
      tableConfig.setDeleteByPrimaryKeyStatementEnabled(false);
    }

    context.addTableConfiguration(tableConfig);
    // TableConfiguration tableConifg2 = new TableConfiguration(context);
    // tableConifg2.setTableName("T_PM_MODELNAME");
    // tableConifg2.setDomainObjectName("project.Modelname");
    // context.addTableConfiguration(tableConifg2);
  }

  void appendTableGeneratedKey(TableConfiguration tableConfig) {
    GeneratedKey generatedKey =
        new GeneratedKey(this.generatedKeyColumn, this.generatedKeySqlStatement, false, "pre");
    tableConfig.setGeneratedKey(generatedKey);
  }

  public String getBaseModulePackage() {
    return baseModulePackage;
  }

  public void setBaseModulePackage(String baseModulePackage) {
    this.baseModulePackage = baseModulePackage;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public GeneratorMode getGeneratorMode() {
    return generatorMode;
  }

  public void setGeneratorMode(GeneratorMode generatorMode) {
    this.generatorMode = generatorMode;
  }

  public boolean isServiceGenerated() {
    return isServiceGenerated;
  }

  public void setServiceGenerated(boolean isServiceGenerated) {
    this.isServiceGenerated = isServiceGenerated;
  }

  public boolean isControllerGenerated() {
    return isControllerGenerated;
  }

  public void setControllerGenerated(boolean isControllerGenerated) {
    this.isControllerGenerated = isControllerGenerated;
  }

  public String getSubModulePackage() {
    return subModulePackage;
  }

  public void setSubModulePackage(String subModulePackage) {
    this.subModulePackage = subModulePackage;
  }

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public List<ColumnOverride> getColumnOverrideList() {
    return columnOverrideList;
  }

  public void setColumnOverrideList(List<ColumnOverride> columnOverrideList) {
    this.columnOverrideList = columnOverrideList;
  }

  public boolean isJavaModelTrimString() {
    return javaModelTrimString;
  }

  public void setJavaModelTrimString(boolean javaModelTrimString) {
    this.javaModelTrimString = javaModelTrimString;
  }

  public DatabaseType getDatabaseType() {
    return databaseType;
  }

  public void setDatabaseType(DatabaseType databaseType) {
    this.databaseType = databaseType;
  }

  public String getGeneratedKeyColumn() {
    return generatedKeyColumn;
  }

  public void setGeneratedKeyColumn(String generatedKeyColumn) {
    this.generatedKeyColumn = generatedKeyColumn;
  }

  public String getGeneratedKeySqlStatement() {
    return generatedKeySqlStatement;
  }

  public void setGeneratedKeySqlStatement(String generatedKeySqlStatement) {
    this.generatedKeySqlStatement = generatedKeySqlStatement;
  }

  public String getGeneratedKeyStrategy() {
    return generatedKeyStrategy;
  }

  public void setGeneratedKeyStrategy(String generatedKeyStrategy) {
    this.generatedKeyStrategy = generatedKeyStrategy;
  }

  public enum GeneratorMode {
    ORIGINAL("original", 1), EXTENSION("extension", 2), SIMPLE("", 3);

    private String pack;
    private int index;

    private GeneratorMode(String name, int index) {
      this.pack = name;
      this.index = index;
    }

    /**
     * 根据传入的索引值，返回生成模式.
     * 
     * @param index 索引值
     * @return 生成模式
     */
    public static String getNameByIndex(int index) {
      for (GeneratorMode gm : GeneratorMode.values()) {
        if (gm.index == index) {
          return gm.pack;
        }
      }
      return null;
    }

    public String getPack() {
      return pack;
    }

    public int getIndex() {
      return index;
    }
  }

}
