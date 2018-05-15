package org.amberframework.core.mybatis.plugins;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InitializationBlock;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author WangYu
 *
 */
public class BeanColumnsPlugin extends PluginAdapter {

  private static final Logger logger = LoggerFactory.getLogger(BeanColumnsPlugin.class);
  
  private static final String BEAN_NAME_SUFFIX = "Columns";

  private FullyQualifiedJavaType mapType;
  private FullyQualifiedJavaType hashMapType;
  private FullyQualifiedJavaType listType;
  private FullyQualifiedJavaType arrayListType;
  private FullyQualifiedJavaType beanColumnsType;


  private String modelPackage;
  private String targetPackage;
  private String targetProjectPath;

  private List<Method> methods;

  public BeanColumnsPlugin() {
    super();
    // 声明
    mapType = FullyQualifiedJavaType.getNewMapInstance();
    hashMapType = FullyQualifiedJavaType.getNewHashMapInstance();
    listType = FullyQualifiedJavaType.getNewListInstance();
    arrayListType = FullyQualifiedJavaType.getNewArrayListInstance();

    methods = new ArrayList<Method>();
  }

  @Override
  public boolean validate(List<String> warnings) {
    // init
    this.modelPackage = context.getJavaModelGeneratorConfiguration().getTargetPackage();

    this.targetPackage = properties.getProperty("targetPackage");
    this.targetProjectPath = properties.getProperty("targetProjectPath");

    return true;
  }

  @Override
  public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(
      IntrospectedTable introspectedTable) {
    List<GeneratedJavaFile> files = new ArrayList<GeneratedJavaFile>();
    String record = introspectedTable.getBaseRecordType();
    String recordName = record;
    if (this.modelPackage != null && this.modelPackage.length() > 0) {
      recordName = record.replace(this.modelPackage + ".", "");
    }

    if (this.targetPackage != null && this.targetPackage.length() > 0) {
      beanColumnsType =
          new FullyQualifiedJavaType(this.targetPackage + "." + recordName + BEAN_NAME_SUFFIX);
    } else {
      beanColumnsType = new FullyQualifiedJavaType(recordName + BEAN_NAME_SUFFIX);
    }

    TopLevelClass topLevelClass = new TopLevelClass(beanColumnsType);
    topLevelClass.setVisibility(JavaVisibility.PUBLIC);

    // 添加import
    this.addImport(topLevelClass);
    // 添加静态成员变量
    this.addStaticMapField(topLevelClass);
    // 添加静态初始化语句块
    this.addStaticInitBlock(topLevelClass, introspectedTable);
    // 添加静态成员方法
    this.addMethod(topLevelClass);

    // 生成文件
    GeneratedJavaFile file =
        new GeneratedJavaFile(topLevelClass, this.targetProjectPath, new DefaultJavaFormatter());
    files.add(file);

    logger.debug("Create " + recordName + "Columns bean");
    return files;
  }

  protected void addImport(TopLevelClass topLevelClass) {
    topLevelClass.addImportedType(this.arrayListType);
    topLevelClass.addImportedType(this.hashMapType);
    topLevelClass.addImportedType(this.listType);
    topLevelClass.addImportedType(this.mapType);
  }

  protected void addStaticMapField(TopLevelClass topLevelClass) {
    Field staticMap = new Field();
    staticMap.setName("columnMap");
    FullyQualifiedJavaType staticMapDeclareType = FullyQualifiedJavaType.getNewMapInstance();
    // 此处是加泛型
    staticMapDeclareType.addTypeArgument(FullyQualifiedJavaType.getStringInstance());
    staticMapDeclareType.addTypeArgument(FullyQualifiedJavaType.getStringInstance());

    staticMap.setVisibility(JavaVisibility.PRIVATE);
    staticMap.setStatic(true);
    staticMap.setFinal(true);
    staticMap.setType(staticMapDeclareType);
    staticMap.setInitializationString("new HashMap<String, String>()");
    
    topLevelClass.addField(staticMap);
  }

  protected void addStaticInitBlock(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
    // 静态初始化，添加static
    InitializationBlock initializationBlock = new InitializationBlock(true);
    // 将所有javaProperty和Column的映射存入Map中
    for (IntrospectedColumn column : columnList) {
      StringBuilder sb =
          new StringBuilder(100).append("columnMap.put(\"").append(column.getJavaProperty())
              .append("\", \"").append(column.getActualColumnName()).append("\");");
      initializationBlock.addBodyLine(sb.toString());
    }
    topLevelClass.addInitializationBlock(initializationBlock);
  }

  protected void addMethod(TopLevelClass topLevelClass) {
    { // getColumn Method
      Method getColumnMethod = new Method("getColumn");
      getColumnMethod.setVisibility(JavaVisibility.PUBLIC);
      getColumnMethod.setStatic(true);
      getColumnMethod.setReturnType(FullyQualifiedJavaType.getStringInstance());
      Parameter parameter =
          new Parameter(FullyQualifiedJavaType.getStringInstance(), "propertyName");
      getColumnMethod.addParameter(parameter);
      getColumnMethod.addBodyLine("return columnMap.get(propertyName);");
      topLevelClass.addMethod(getColumnMethod);
    }

    { // getAllColumns Method
      Method getAllColumnsMethod = new Method("getAllColumns");
      getAllColumnsMethod.setVisibility(JavaVisibility.PUBLIC);
      getAllColumnsMethod.setStatic(true);
      FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
      returnType.addTypeArgument(FullyQualifiedJavaType.getStringInstance());
      getAllColumnsMethod.setReturnType(returnType);
      getAllColumnsMethod.addBodyLine("return new ArrayList<String>(columnMap.values());");
      topLevelClass.addMethod(getAllColumnsMethod);
    }
  }

}
