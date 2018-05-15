package generator.plugins;

import generator.tools.AmberCodeGeneratorTool;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class AmberBeanServicePlugin extends PluginAdapter {

  private static final Logger logger = LoggerFactory.getLogger(AmberBeanServicePlugin.class);

  private static final String SERVICE_NAME_SUFFIX = "Service";
  private static final String SERVICE_IMPL_NAME_SUFFIX = "ServiceImpl";
  private static final String EXAMPLE_CLASS_NAME_SUFFIX = "Criteria";
  private static final String BEAN_NAME_SUFFIX = "Columns";
  
  private static final String PRIMARY_KEY_CODE = "primaryKey";
  private static final String OVERRIDE_ANNOTATION = "@Override";
  private static final String NO_PRIMARY_KEY_GENERATE_COMMENTS =
      "// 如果没有主键，mybatis不会自动生成PrimaryKey相关方法，此处可能报错，需要自行根据业务逻辑处理";

  private FullyQualifiedJavaType slf4jLoggerType;
  private FullyQualifiedJavaType slf4jLoggerFactoryType;
  private FullyQualifiedJavaType uuidClassType;
  private FullyQualifiedJavaType miniGridPageSortType;
  private FullyQualifiedJavaType miniRtn2GridType;
  private FullyQualifiedJavaType resourceAnnoType;
  private FullyQualifiedJavaType serviceAnnoType;
  private FullyQualifiedJavaType pageType;
  private FullyQualifiedJavaType stringUtilsType;
  private FullyQualifiedJavaType bigDecimalType;

  private FullyQualifiedJavaType serviceType;
  private FullyQualifiedJavaType serviceImplType;
  private FullyQualifiedJavaType daoType;
  private FullyQualifiedJavaType modelType;
  private FullyQualifiedJavaType modelCriteriaType;
  private FullyQualifiedJavaType modelColumnsType;

  private String modelPack;

  private String targetPackage;
  private String targetProjectPath;
  private String keyStrategy;

  private String primaryKey;
  private FullyQualifiedJavaType primaryKeyType;
  private String searchStrKey;

  /**
   * 默认构造方法，初始化成员变量.
   */
  public AmberBeanServicePlugin() {
    super();
    slf4jLoggerType = new FullyQualifiedJavaType("org.slf4j.Logger");
    slf4jLoggerFactoryType = new FullyQualifiedJavaType("org.slf4j.LoggerFactory");
    uuidClassType = new FullyQualifiedJavaType("java.util.UUID");
    miniGridPageSortType = new FullyQualifiedJavaType("org.amberframework.web.miniui.pojo.MiniGridPageSort");
    miniRtn2GridType = new FullyQualifiedJavaType("org.amberframework.web.miniui.pojo.MiniRtn2Grid");
    resourceAnnoType = new FullyQualifiedJavaType("javax.annotation.Resource");
    serviceAnnoType = new FullyQualifiedJavaType("org.springframework.stereotype.Service");
    pageType = new FullyQualifiedJavaType("org.amberframework.core.mybatis.pojo.Page");
    stringUtilsType = new FullyQualifiedJavaType("org.springframework.util.StringUtils");
    bigDecimalType = new FullyQualifiedJavaType("java.math.BigDecimal");

  }

  @Override
  public boolean validate(List<String> arg0) {
    this.modelPack = context.getJavaModelGeneratorConfiguration().getTargetPackage();

    this.targetPackage = properties.getProperty("targetPackage");
    this.targetProjectPath = properties.getProperty("targetProjectPath");
    this.keyStrategy = properties.getProperty("keyStrategy");
    return true;
  }

  @Override
  public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
    List<GeneratedJavaFile> files = new ArrayList<GeneratedJavaFile>();

    // 获取和设置service和implement的Type（package含全路径）
    setServiceAndImplType(introspectedTable);

    this.modelType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
    this.daoType = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
    this.modelCriteriaType =
        new FullyQualifiedJavaType(introspectedTable.getBaseRecordType() + EXAMPLE_CLASS_NAME_SUFFIX);
    this.modelColumnsType =
        new FullyQualifiedJavaType(introspectedTable.getBaseRecordType() + BEAN_NAME_SUFFIX);

    // 设置泛型
    this.miniRtn2GridType.addTypeArgument(modelType);

    // 设置主键的Java字段及类型
    List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
    if (!primaryKeyColumns.isEmpty()) {
      this.primaryKey = primaryKeyColumns.get(0).getJavaProperty();
      this.primaryKeyType = primaryKeyColumns.get(0).getFullyQualifiedJavaType();
    }

    // 设置搜索用字段Key字段, 找String类型的，先从主键中找，在从所有列中找
    if (StringUtils.hasText(this.primaryKey) && this.primaryKeyType != null
        && "String".equals(this.primaryKeyType.getShortName())) {
      this.searchStrKey = this.primaryKey;
    } else {
      List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
      for (IntrospectedColumn introColumn : allColumns) {
        if ("String".equals(introColumn.getFullyQualifiedJavaType().getShortName())) {
          this.searchStrKey = introColumn.getJavaProperty();
          break;
        }
      }
    }

    // 添加Service类和文件
    files.add(this.createInterfaceClass());

    // 添加Service实现类和文件
    files.add(this.createImplementClass());

    logger.info("Create " + this.serviceType.getFullyQualifiedName() + " success");
    logger.info("Create " + this.serviceImplType.getFullyQualifiedName() + " success");
    return files;
  }

  private GeneratedJavaFile createInterfaceClass() {
    Interface serviceInterface = new Interface(this.serviceType);
    serviceInterface.setVisibility(JavaVisibility.PUBLIC);

    // 添加import
    addServiceImport(serviceInterface);
    // 添加成员方法声明
    addServiceMethod(serviceInterface);

    // 返回生成的文件
    return new GeneratedJavaFile(serviceInterface, this.targetProjectPath, new DefaultJavaFormatter());
  }

  private GeneratedJavaFile createImplementClass() {
    TopLevelClass serviceImplClass = new TopLevelClass(serviceImplType);
    serviceImplClass.setVisibility(JavaVisibility.PUBLIC);
    serviceImplClass.addAnnotation("@Service(\"" + setInitToLowerCase(this.serviceType.getShortName())
        + "\")");
    serviceImplClass.addSuperInterface(this.serviceType);

    // 添加import
    addImplementImport(serviceImplClass);
    // 添加成员变量声明
    addImplementField(serviceImplClass);
    // 添加成员方法声明
    addImplementMethod(serviceImplClass);

    // 生成文件
    return new GeneratedJavaFile(serviceImplClass, this.targetProjectPath, new DefaultJavaFormatter());
  }

  protected void setServiceAndImplType(IntrospectedTable introspectedTable) {
    String record = introspectedTable.getBaseRecordType();
    String recordName = record;
    if (this.modelPack != null && this.modelPack.length() > 0) {
      recordName = record.replace(this.modelPack + ".", "");
    }
    // 还要去掉剩下路径中的“original.”或“extension.”部分，得到单纯的subPackage，例如xxx.ModelName
    if (recordName.startsWith(AmberCodeGeneratorTool.GeneratorMode.ORIGINAL.getPack())) {
      recordName = recordName.replaceFirst(AmberCodeGeneratorTool.GeneratorMode.ORIGINAL.getPack() + ".", "");
    } else if (recordName.startsWith(AmberCodeGeneratorTool.GeneratorMode.EXTENSION.getPack())) {
      recordName =
          recordName.replaceFirst(AmberCodeGeneratorTool.GeneratorMode.EXTENSION.getPack() + ".", "");
    }

    if (this.targetPackage != null && this.targetPackage.length() > 0) {
      this.serviceType =
          new FullyQualifiedJavaType(this.targetPackage + "." + recordName + SERVICE_NAME_SUFFIX);
      this.serviceImplType =
          new FullyQualifiedJavaType(this.targetPackage + ".impl." + recordName + SERVICE_IMPL_NAME_SUFFIX);
    } else {
      this.serviceType = new FullyQualifiedJavaType(recordName + SERVICE_NAME_SUFFIX);
      this.serviceImplType = new FullyQualifiedJavaType("impl." + recordName + SERVICE_IMPL_NAME_SUFFIX);
    }
  }

  protected void addServiceImport(Interface serviceInterface) {
    serviceInterface.addImportedType(this.modelType);
    serviceInterface.addImportedType(this.miniGridPageSortType);
    serviceInterface.addImportedType(this.miniRtn2GridType);
  }

  protected void addServiceMethod(Interface serviceInterface) {
    Method getGridMethod = new Method("getGrid");
    getGridMethod.setVisibility(JavaVisibility.PUBLIC);
    getGridMethod.setReturnType(miniRtn2GridType);
    getGridMethod.addParameter(new Parameter(miniGridPageSortType, "pageSort"));
    getGridMethod.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "searchKey"));
    serviceInterface.addMethod(getGridMethod);

    Method getByPrimaryKeyMethod = new Method("getByPrimaryKey");
    getByPrimaryKeyMethod.setVisibility(JavaVisibility.PUBLIC);
    getByPrimaryKeyMethod.setReturnType(modelType);
    getByPrimaryKeyMethod
        .addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), PRIMARY_KEY_CODE));
    serviceInterface.addMethod(getByPrimaryKeyMethod);

    Method createMethod = new Method("create");
    createMethod.setVisibility(JavaVisibility.PUBLIC);
    createMethod.addParameter(new Parameter(modelType, setInitToLowerCase(modelType.getShortName())));
    serviceInterface.addMethod(createMethod);

    Method updateSelectiveMethod = new Method("updateSelective");
    updateSelectiveMethod.setVisibility(JavaVisibility.PUBLIC);
    updateSelectiveMethod
        .addParameter(new Parameter(modelType, setInitToLowerCase(modelType.getShortName())));
    serviceInterface.addMethod(updateSelectiveMethod);

    Method removeMethod = new Method("remove");
    removeMethod.setVisibility(JavaVisibility.PUBLIC);
    removeMethod.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), PRIMARY_KEY_CODE));
    serviceInterface.addMethod(removeMethod);
  }

  protected void addImplementImport(TopLevelClass topLevelClass) {
    if (null != this.primaryKeyType && this.primaryKeyType.equals(this.bigDecimalType)) {
      topLevelClass.addImportedType(bigDecimalType);
    }
    topLevelClass.addImportedType(daoType);
    topLevelClass.addImportedType(modelType);
    topLevelClass.addImportedType(modelColumnsType);
    topLevelClass.addImportedType(modelCriteriaType);
    topLevelClass.addImportedType(serviceType);
    topLevelClass.addImportedType(uuidClassType);
    topLevelClass.addImportedType(resourceAnnoType);
    topLevelClass.addImportedType(pageType);
    topLevelClass.addImportedType(miniGridPageSortType);
    topLevelClass.addImportedType(miniRtn2GridType);
    topLevelClass.addImportedType(slf4jLoggerType);
    topLevelClass.addImportedType(slf4jLoggerFactoryType);
    topLevelClass.addImportedType(serviceAnnoType);
    topLevelClass.addImportedType(stringUtilsType);
  }

  protected void addImplementField(TopLevelClass topLevelClass) {
    // 添加loggerField
    Field loggerField = new Field("logger", this.slf4jLoggerType);
    loggerField.setVisibility(JavaVisibility.PRIVATE);
    loggerField.setStatic(true);
    loggerField.setFinal(true);
    loggerField.setInitializationString("LoggerFactory.getLogger(" + this.serviceImplType.getShortName()
        + ".class)");
    topLevelClass.addField(loggerField);

    // 添加mapperField
    Field mapperField = new Field(setInitToLowerCase(this.daoType.getShortName()), this.daoType);
    mapperField.setVisibility(JavaVisibility.PRIVATE);
    mapperField.setStatic(false);
    mapperField.addAnnotation("@Resource");
    topLevelClass.addField(mapperField);
  }

  protected void addImplementMethod(TopLevelClass topLevelClass) {
    String mapperName = setInitToLowerCase(this.daoType.getShortName());
    addGetGridMethod(topLevelClass, mapperName);
    addGetByPrimaryKeyMethod(topLevelClass, mapperName);
    addCreateMethod(topLevelClass, mapperName);
    addUpdateSelectiveMethod(topLevelClass, mapperName);
    addRemoveMethod(topLevelClass, mapperName);
  }

  protected void addGetGridMethod(TopLevelClass topLevelClass, String mapperName) {
    Method getGridMethod = new Method("getGrid");
    getGridMethod.setVisibility(JavaVisibility.PUBLIC);
    getGridMethod.setReturnType(this.miniRtn2GridType);
    getGridMethod.addParameter(new Parameter(this.miniGridPageSortType, "pageSort"));
    getGridMethod.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "searchKey"));
    getGridMethod.addAnnotation(OVERRIDE_ANNOTATION);

    // 设置BodyLines
    StringBuilder sb1 = new StringBuilder(122);
    sb1.append(this.miniRtn2GridType.getShortName()).append(" grid = new ")
        .append(this.miniRtn2GridType.getShortName()).append("();");
    getGridMethod.addBodyLine(sb1.toString());
    StringBuilder sb2 = new StringBuilder(122);
    sb2.append(this.modelCriteriaType.getShortName()).append(" criteria = new ")
        .append(this.modelCriteriaType.getShortName()).append("();");
    getGridMethod.addBodyLine(sb2.toString());
    getGridMethod.addBodyLine("// 查询条件");
    getGridMethod.addBodyLine("if (StringUtils.hasText(searchKey)) {");
    if (StringUtils.hasText(this.searchStrKey)) {
      getGridMethod.addBodyLine("criteria.or().and" + setInitToUpperCase(this.searchStrKey)
          + "EqualTo(searchKey);");
    } else {
      getGridMethod.addBodyLine("// 生成代码时未找到合适的搜索字段");
    }
    getGridMethod.addBodyLine("}");
    getGridMethod.addBodyLine("// 分页和排序");
    getGridMethod.addBodyLine("if (pageSort.isShowPager()) {");
    getGridMethod.addBodyLine("Page page = Page.newInstanceWithPageIndex"
        + "(pageSort.getPageIndex(), pageSort.getPageSize());");
    getGridMethod.addBodyLine("criteria.setPage(page);");
    getGridMethod.addBodyLine("}");
    getGridMethod.addBodyLine("String sortColumn = " + this.modelColumnsType.getShortName()
        + ".getColumn(pageSort.getSortField());");
    getGridMethod.addBodyLine("if (StringUtils.hasText(sortColumn)) {");
    getGridMethod.addBodyLine("StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(\" \")"
        + ".append(pageSort.getSortOrder());");
    getGridMethod.addBodyLine("criteria.setOrderByClause(sortStrBldr.toString());");
    getGridMethod.addBodyLine("}");
    getGridMethod.addBodyLine("grid.setData(" + mapperName + ".selectByExample(criteria));");
    getGridMethod.addBodyLine("grid.setTotal(" + mapperName + ".countByExample(criteria));");
    getGridMethod.addBodyLine("return grid;");

    topLevelClass.addMethod(getGridMethod);
  }

  protected void addGetByPrimaryKeyMethod(TopLevelClass topLevelClass, String mapperName) {
    Method getByPrimaryKeyMethod = new Method("getByPrimaryKey");
    getByPrimaryKeyMethod.setVisibility(JavaVisibility.PUBLIC);
    getByPrimaryKeyMethod.setReturnType(this.modelType);
    getByPrimaryKeyMethod
        .addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), PRIMARY_KEY_CODE));
    getByPrimaryKeyMethod.addAnnotation(OVERRIDE_ANNOTATION);

    // 设置BodyLines
    // 判断主键类型，进行转换
    if (null != this.primaryKeyType 
        && this.primaryKeyType.equals(FullyQualifiedJavaType.getStringInstance())) {
      getByPrimaryKeyMethod.addBodyLine("return " + mapperName + ".selectByPrimaryKey(primaryKey);");
    } else {
      String translateLine = getPrimaryKeyTranslateBodyLine(PRIMARY_KEY_CODE);
      getByPrimaryKeyMethod.addBodyLine(translateLine);
      if (null == this.primaryKeyType) {
        getByPrimaryKeyMethod.addBodyLine(NO_PRIMARY_KEY_GENERATE_COMMENTS);
      }
      getByPrimaryKeyMethod.addBodyLine("return " + mapperName + ".selectByPrimaryKey(pk);");
    }

    topLevelClass.addMethod(getByPrimaryKeyMethod);
  }

  protected void addCreateMethod(TopLevelClass topLevelClass, String mapperName) {
    String modelVarStr = setInitToLowerCase(this.modelType.getShortName());
    Method createMethod = new Method("create");
    createMethod.setVisibility(JavaVisibility.PUBLIC);
    createMethod.addParameter(new Parameter(this.modelType, modelVarStr));
    createMethod.addAnnotation(OVERRIDE_ANNOTATION);

    // 设置BodyLines
    // 如果设置主键生成策略为uuid则，create时候设置主键为uuid
    if (this.keyStrategy != null && "uuid".equals(this.keyStrategy) && null != this.primaryKeyType
        && this.primaryKeyType.equals(FullyQualifiedJavaType.getStringInstance())) {
      StringBuilder idLineStrbldr = new StringBuilder(120);
      idLineStrbldr.append(modelVarStr).append(".set").append(setInitToUpperCase(this.primaryKey))
          .append("(UUID.randomUUID().toString().replace(\"-\", \"\"));");
      createMethod.addBodyLine(idLineStrbldr.toString());
    }
    createMethod.addBodyLine(mapperName + ".insert(" + modelVarStr + ");");

    topLevelClass.addMethod(createMethod);
  }

  protected void addUpdateSelectiveMethod(TopLevelClass topLevelClass, String mapperName) {
    String modelVarStr = setInitToLowerCase(this.modelType.getShortName());
    Method updateSelectiveMethod = new Method("updateSelective");
    updateSelectiveMethod.setVisibility(JavaVisibility.PUBLIC);
    updateSelectiveMethod.addParameter(new Parameter(modelType, modelVarStr));
    updateSelectiveMethod.addAnnotation(OVERRIDE_ANNOTATION);

    // 设置BodyLines
    if (null == this.primaryKeyType) {
      updateSelectiveMethod.addBodyLine(NO_PRIMARY_KEY_GENERATE_COMMENTS);
    }
    updateSelectiveMethod.addBodyLine(mapperName + ".updateByPrimaryKeySelective(" + modelVarStr + ");");

    topLevelClass.addMethod(updateSelectiveMethod);
  }

  protected void addRemoveMethod(TopLevelClass topLevelClass, String mapperName) {
    Method removeMethod = new Method("remove");
    removeMethod.setVisibility(JavaVisibility.PUBLIC);
    removeMethod.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), PRIMARY_KEY_CODE));
    removeMethod.addAnnotation(OVERRIDE_ANNOTATION);

    // 设置BodyLines
    // 判断主键类型，进行转换
    if (null != this.primaryKeyType 
        && this.primaryKeyType.equals(FullyQualifiedJavaType.getStringInstance())) {
      removeMethod.addBodyLine(mapperName + ".deleteByPrimaryKey(primaryKey);");
    } else {
      String translateLine = getPrimaryKeyTranslateBodyLine(PRIMARY_KEY_CODE);
      removeMethod.addBodyLine(translateLine);
      if (null == this.primaryKeyType) {
        removeMethod.addBodyLine(NO_PRIMARY_KEY_GENERATE_COMMENTS);
      }
      removeMethod.addBodyLine(mapperName + ".deleteByPrimaryKey(pk);");
    }

    topLevelClass.addMethod(removeMethod);
  }

  /**
   * 根据主键类型，将String类型转换为对应类型，转换后的变量名字为pk，返回转换语句.
   * <p>
   * 目前支持String转一下类型：<br>
   * BigDecimal，Long，Integer，Short.<br>
   * 如果不是这几种类型，则pk还是String类型.
   * </p>
   * 
   * @param primaryKeyStr 主键传入变量的名字，也就是转换的输入变量名
   * @return 转换语句
   */
  protected String getPrimaryKeyTranslateBodyLine(String primaryKeyStr) {
    if (isJavaTypeShortNameEqualsStr(this.primaryKeyType, "BigDecimal")) {
      return "BigDecimal pk = new BigDecimal(" + primaryKeyStr + ");";
    } else if (isJavaTypeShortNameEqualsStr(this.primaryKeyType, "Long")) {
      return "Long pk = Long.parseLong(" + primaryKeyStr + ");";
    } else if (isJavaTypeShortNameEqualsStr(this.primaryKeyType, "Integer")) {
      return "Integer pk = Integer.parseInt(" + primaryKeyStr + ");";
    } else if (isJavaTypeShortNameEqualsStr(this.primaryKeyType, "Short")) {
      return "Short pk = Short.parseShort(" + primaryKeyStr + ");";
    }
    return "String pk = " + primaryKeyStr + ";";
  }

  /**
   * 将字符串首字母改为小写
   * 
   * @param str 要转换的字符串
   * @return 首字母改为小写后的字符串
   */
  protected String setInitToLowerCase(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
    return sb.toString();
  }

  /**
   * 将字符串首字母改为大写
   * 
   * @param str 要转换的字符串
   * @return 首字母改为大写后的字符串
   */
  protected String setInitToUpperCase(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
    return sb.toString();
  }
  
  /**
   * 判断传进来的JavaType短名称，和传进来的字符串相对等.
   */
  private static boolean isJavaTypeShortNameEqualsStr(FullyQualifiedJavaType javaType, String shortName) {
    if (null == shortName || null == javaType) {
      return false;
    }
    return shortName.equals(javaType.getShortName());
  }
}
