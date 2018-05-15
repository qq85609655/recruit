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
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmberBeanControllerPlugin extends PluginAdapter {

  private static final Logger logger = LoggerFactory.getLogger(AmberBeanControllerPlugin.class);

  private static final String CONTROLLER_NAME_SUFFIX = "Controller";
  private static final String SERVICE_NAME_SUFFIX = "Service";
  
  private static final String RETURN_NEW_MODELANDVIEW_PREFIX_CODE = "return new ModelAndView(\"";
  private static final String REQUEST_PARAM_NAME = "request";
  private static final String RESPONSE_BODY_ANNOTATION = "@ResponseBody";
  private static final String PATH_VARIABLE_ANNOTATION = "@PathVariable";
  private static final String TRY_CODE_START = "try {";
  private static final String CATCH_DATA_ACCESS_EX_CODE = "} catch (DataAccessException e) {";
  private static final String LOGGER_ERROR_MSG_CODE = "logger.error(e.getMessage(), e);";

  private FullyQualifiedJavaType slf4jLoggerType;
  private FullyQualifiedJavaType slf4jLoggerFactoryType;
  private FullyQualifiedJavaType httpServletRequestType;

  private FullyQualifiedJavaType dataAccessExceptionType;
  private FullyQualifiedJavaType stringUtilsType;
  private FullyQualifiedJavaType modelAndViewType;

  private FullyQualifiedJavaType ajaxRtnJsonType;
  private FullyQualifiedJavaType miniGridPageSortType;
  private FullyQualifiedJavaType miniRtn2GridType;

  private FullyQualifiedJavaType resourceAnnoType;
  private FullyQualifiedJavaType controllerAnnoType;
  private FullyQualifiedJavaType pathVariableAnnoType;
  private FullyQualifiedJavaType requestMappingAnnoType;
  private FullyQualifiedJavaType responseBodyAnnoType;

  private FullyQualifiedJavaType modelType;
  private FullyQualifiedJavaType serviceType;
  private FullyQualifiedJavaType controllerType;

  private String modelPack;
  private String targetPackage;
  private String targetProjectPath;

  private String primaryKey;
  private FullyQualifiedJavaType primaryKeyType;
  
  /** recordName用来保存单纯的subPackage加ModelName，例如xxx.ModelName，也就是不包含"original."或"extension." */
  private String recordName;
  private String jspUrl;

  /**
   * 默认构造方法，初始化成员变量.
   */
  public AmberBeanControllerPlugin() {
    super();
    slf4jLoggerType = new FullyQualifiedJavaType("org.slf4j.Logger");
    slf4jLoggerFactoryType = new FullyQualifiedJavaType("org.slf4j.LoggerFactory");
    httpServletRequestType = new FullyQualifiedJavaType("javax.servlet.http.HttpServletRequest");
    dataAccessExceptionType = new FullyQualifiedJavaType("org.springframework.dao.DataAccessException");
    stringUtilsType = new FullyQualifiedJavaType("org.springframework.util.StringUtils");
    modelAndViewType = new FullyQualifiedJavaType("org.springframework.web.servlet.ModelAndView");
    ajaxRtnJsonType = new FullyQualifiedJavaType("org.amberframework.core.common.model.AjaxRtnJson");
    miniGridPageSortType = new FullyQualifiedJavaType("org.amberframework.web.miniui.pojo.MiniGridPageSort");
    miniRtn2GridType = new FullyQualifiedJavaType("org.amberframework.web.miniui.pojo.MiniRtn2Grid");
    resourceAnnoType = new FullyQualifiedJavaType("javax.annotation.Resource");
    controllerAnnoType = new FullyQualifiedJavaType("org.springframework.stereotype.Controller");
    pathVariableAnnoType = new FullyQualifiedJavaType("org.springframework.web.bind.annotation.PathVariable");
    requestMappingAnnoType =
        new FullyQualifiedJavaType("org.springframework.web.bind.annotation.RequestMapping");
    responseBodyAnnoType = new FullyQualifiedJavaType("org.springframework.web.bind.annotation.ResponseBody");
  }

  @Override
  public boolean validate(List<String> warnings) {
    this.modelPack = context.getJavaModelGeneratorConfiguration().getTargetPackage();

    this.targetPackage = properties.getProperty("targetPackage");
    this.targetProjectPath = properties.getProperty("targetProjectPath");
    return true;
  }

  @Override
  public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
    List<GeneratedJavaFile> files = new ArrayList<GeneratedJavaFile>();

    // 获取和设置controller和service的Type（package含全路径），还设置了如this.jspUrl和this.recordName，所以要放在前面
    setControllerAndServiceType(introspectedTable);

    this.modelType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());

    // 设置泛型
    this.miniRtn2GridType.addTypeArgument(modelType);

    // 设置主键的Java字段及类型
    List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
    if (!primaryKeyColumns.isEmpty()) {
      this.primaryKey = primaryKeyColumns.get(0).getJavaProperty();
      this.primaryKeyType = primaryKeyColumns.get(0).getFullyQualifiedJavaType();
    }

    TopLevelClass topLevelClass = new TopLevelClass(this.controllerType);
    topLevelClass.setVisibility(JavaVisibility.PUBLIC);
    topLevelClass.addAnnotation("@Controller");
    // 生成的RequestMapping格式为 SubPackage/ModelName
    topLevelClass.addAnnotation("@RequestMapping(\""
        + this.recordName.replace('.', '/').replace(this.modelType.getShortName(),
            setInitToLowerCase(this.modelType.getShortName())) + "\")");

    // 添加import
    addImports(topLevelClass);
    // 添加成员变量声明
    addFields(topLevelClass);
    // 添加成员方法声明
    addMethods(topLevelClass);

    // 生成文件
    GeneratedJavaFile controllerFile =
        new GeneratedJavaFile(topLevelClass, this.targetProjectPath, new DefaultJavaFormatter());
    files.add(controllerFile);

    logger.info("Create " + this.controllerType.getFullyQualifiedName() + " success");
    return files;
  }

  protected void setControllerAndServiceType(IntrospectedTable introspectedTable) {
    String record = introspectedTable.getBaseRecordType();
    if (this.modelPack != null && this.modelPack.length() > 0) {
      record = record.replace(this.modelPack + ".", "");
    }
    // 还要去掉剩下路径中的“original.”或“extension.”部分，得到单纯的subPackage，例如xxx.ModelName
    if (record.startsWith(AmberCodeGeneratorTool.GeneratorMode.ORIGINAL.getPack())) {
      record = record.replaceFirst(AmberCodeGeneratorTool.GeneratorMode.ORIGINAL.getPack() + ".", "");
    } else if (record.startsWith(AmberCodeGeneratorTool.GeneratorMode.EXTENSION.getPack())) {
      record =
          record.replaceFirst(AmberCodeGeneratorTool.GeneratorMode.EXTENSION.getPack() + ".", "");
    }

    if (this.targetPackage != null && this.targetPackage.length() > 0) {
      String servicePack = this.targetPackage;
      if (this.targetPackage.startsWith("controller")) {
        servicePack = this.targetPackage.replace("controller", "service");
      } else {
        servicePack = this.targetPackage.replace(".controller", ".service");
      }
      this.serviceType = new FullyQualifiedJavaType(servicePack + "." + record + SERVICE_NAME_SUFFIX);
      this.controllerType =
          new FullyQualifiedJavaType(this.targetPackage + "." + record + CONTROLLER_NAME_SUFFIX);
    } else {
      this.serviceType = new FullyQualifiedJavaType(record + SERVICE_NAME_SUFFIX);
      this.controllerType = new FullyQualifiedJavaType(record + CONTROLLER_NAME_SUFFIX);
    }
    this.recordName = record;

    // 生成JSP文件路径
    String jspUrlPack = new String(this.controllerType.getPackageName());
    if (jspUrlPack.startsWith("controller.")) {
      this.jspUrl = jspUrlPack.replaceFirst("controller.", "").replace('.', '/');
    } else {
      this.jspUrl = jspUrlPack.replaceFirst(".controller", "").replace('.', '/');
    }
  }

  protected void addImports(TopLevelClass topLevelClass) {
    topLevelClass.addImportedType(modelType);
    topLevelClass.addImportedType(serviceType);
    topLevelClass.addImportedType(resourceAnnoType);
    topLevelClass.addImportedType(httpServletRequestType);
    topLevelClass.addImportedType(ajaxRtnJsonType);
    topLevelClass.addImportedType(miniGridPageSortType);
    topLevelClass.addImportedType(miniRtn2GridType);
    topLevelClass.addImportedType(slf4jLoggerType);
    topLevelClass.addImportedType(slf4jLoggerFactoryType);
    topLevelClass.addImportedType(dataAccessExceptionType);
    topLevelClass.addImportedType(controllerAnnoType);
    topLevelClass.addImportedType(stringUtilsType);
    topLevelClass.addImportedType(pathVariableAnnoType);
    topLevelClass.addImportedType(requestMappingAnnoType);
    topLevelClass.addImportedType(responseBodyAnnoType);
    topLevelClass.addImportedType(modelAndViewType);
  }

  protected void addFields(TopLevelClass topLevelClass) {
    addLoggerField(topLevelClass);
    addServiceField(topLevelClass);
  }
  
  private void addLoggerField(TopLevelClass topLevelClass) {
    Field loggerField = new Field("logger", this.slf4jLoggerType);
    loggerField.setVisibility(JavaVisibility.PRIVATE);
    loggerField.setStatic(true);
    loggerField.setFinal(true);
    loggerField.setInitializationString("LoggerFactory.getLogger(" + this.controllerType.getShortName()
        + ".class)");
    topLevelClass.addField(loggerField);
  }
  
  private void addServiceField(TopLevelClass topLevelClass) {
    Field serviceField = new Field(setInitToLowerCase(this.serviceType.getShortName()), this.serviceType);
    serviceField.setVisibility(JavaVisibility.PRIVATE);
    serviceField.setStatic(false);
    serviceField.addAnnotation("@Resource");
    topLevelClass.addField(serviceField);
  }

  protected void addMethods(TopLevelClass topLevelClass) {
    String serviceName = setInitToLowerCase(this.serviceType.getShortName());
    String jspFullyName =
        new StringBuilder(60).append(this.jspUrl).append("/")
            .append(setInitToLowerCase(this.modelType.getShortName())).toString();

    addListMethod(topLevelClass, jspFullyName);
    addDatagridMethod(topLevelClass, serviceName);
    addCreateMethod(topLevelClass, jspFullyName);
    addModifyMethod(topLevelClass, serviceName, jspFullyName);
    addViewMethod(topLevelClass, serviceName, jspFullyName);
    addRemoveMethod(topLevelClass, serviceName);
    addSaveMethod(topLevelClass, serviceName);
  }

  protected void addListMethod(TopLevelClass topLevelClass, String jspFullyName) {
    Method listMethod = new Method("list");
    listMethod.setVisibility(JavaVisibility.PUBLIC);
    listMethod.setReturnType(this.modelAndViewType);
    listMethod.addAnnotation("@RequestMapping(\"list\")");

    listMethod.addJavaDocLine("/**");
    listMethod.addJavaDocLine(" * Forward to list page.");
    listMethod.addJavaDocLine(" */");

    StringBuilder rtnLineStrBldr =
        new StringBuilder(80).append(RETURN_NEW_MODELANDVIEW_PREFIX_CODE)
        .append(jspFullyName).append("List\");");
    listMethod.addBodyLine(rtnLineStrBldr.toString());
    topLevelClass.addMethod(listMethod);
  }

  protected void addDatagridMethod(TopLevelClass topLevelClass, String serviceName) {
    Method datagridMethod = new Method("datagrid");
    datagridMethod.setVisibility(JavaVisibility.PUBLIC);
    datagridMethod.setReturnType(this.miniRtn2GridType);
    datagridMethod.addParameter(new Parameter(this.miniGridPageSortType, "pageSort"));
    datagridMethod.addParameter(new Parameter(this.httpServletRequestType, REQUEST_PARAM_NAME));
    datagridMethod.addAnnotation("@RequestMapping(\"datagrid\")");
    datagridMethod.addAnnotation(RESPONSE_BODY_ANNOTATION);

    datagridMethod.addJavaDocLine("/**");
    datagridMethod.addJavaDocLine(" * Get datagrid.");
    datagridMethod.addJavaDocLine(" */");

    datagridMethod.addBodyLine("String searchKey = request.getParameter(\"searchKey\");");
    StringBuilder rtnLineStrBldr =
        new StringBuilder(80).append("return ").append(serviceName).append(".getGrid(pageSort, searchKey);");
    datagridMethod.addBodyLine(rtnLineStrBldr.toString());
    topLevelClass.addMethod(datagridMethod);
  }

  protected void addCreateMethod(TopLevelClass topLevelClass, String jspFullyName) {
    Method createMethod = new Method("create");
    createMethod.setVisibility(JavaVisibility.PUBLIC);
    createMethod.setReturnType(this.modelAndViewType);
    createMethod.addAnnotation("@RequestMapping(\"create\")");

    createMethod.addJavaDocLine("/**");
    createMethod.addJavaDocLine(" * Forward to create page.");
    createMethod.addJavaDocLine(" */");

    StringBuilder rtnLineStrBldr =
        new StringBuilder(80).append(RETURN_NEW_MODELANDVIEW_PREFIX_CODE)
        .append(jspFullyName).append("Edit\");");
    createMethod.addBodyLine(rtnLineStrBldr.toString());
    topLevelClass.addMethod(createMethod);
  }

  protected void addModifyMethod(TopLevelClass topLevelClass, String serviceName, String jspFullyName) {
    Method modifyMethod = new Method("modify");
    modifyMethod.setVisibility(JavaVisibility.PUBLIC);
    modifyMethod.setReturnType(this.modelAndViewType);
    modifyMethod.addAnnotation("@RequestMapping(\"modify/{id}\")");
    Parameter idParam = new Parameter(FullyQualifiedJavaType.getStringInstance(), "id");
    idParam.addAnnotation(PATH_VARIABLE_ANNOTATION);
    modifyMethod.addParameter(idParam);
    modifyMethod.addParameter(new Parameter(this.httpServletRequestType, REQUEST_PARAM_NAME));

    modifyMethod.addJavaDocLine("/**");
    modifyMethod.addJavaDocLine(" * Forward to modify page.");
    modifyMethod.addJavaDocLine(" */");

    String shortModelName = this.modelType.getShortName();
    String lowerShortModelName = setInitToLowerCase(shortModelName);
    StringBuilder getModelLineStrBldr =
        new StringBuilder(100).append(shortModelName).append(" ").append(lowerShortModelName).append(" = ")
            .append(serviceName).append(".getByPrimaryKey(id);");
    modifyMethod.addBodyLine(getModelLineStrBldr.toString());
    StringBuilder setRequestLineStrBldr =
        new StringBuilder(100).append("request.setAttribute(\"").append(lowerShortModelName).append("\", ")
            .append(lowerShortModelName).append(");");
    modifyMethod.addBodyLine(setRequestLineStrBldr.toString());
    StringBuilder rtnlineStrBldr =
        new StringBuilder(100).append(RETURN_NEW_MODELANDVIEW_PREFIX_CODE)
        .append(jspFullyName).append("Edit\");");
    modifyMethod.addBodyLine(rtnlineStrBldr.toString());

    topLevelClass.addMethod(modifyMethod);
  }

  protected void addViewMethod(TopLevelClass topLevelClass, String serviceName, String jspFullyName) {
    Method viewMethod = new Method("view");
    viewMethod.setVisibility(JavaVisibility.PUBLIC);
    viewMethod.setReturnType(this.modelAndViewType);
    viewMethod.addAnnotation("@RequestMapping(\"view/{id}\")");
    Parameter idParam = new Parameter(FullyQualifiedJavaType.getStringInstance(), "id");
    idParam.addAnnotation(PATH_VARIABLE_ANNOTATION);
    viewMethod.addParameter(idParam);
    viewMethod.addParameter(new Parameter(this.httpServletRequestType, REQUEST_PARAM_NAME));

    viewMethod.addJavaDocLine("/**");
    viewMethod.addJavaDocLine(" * Forward to view page.");
    viewMethod.addJavaDocLine(" */");

    String shortModelName = this.modelType.getShortName();
    String lowerShortModelName = setInitToLowerCase(shortModelName);
    StringBuilder getModelLineStrBldr =
        new StringBuilder(100).append(shortModelName).append(" ").append(lowerShortModelName).append(" = ")
            .append(serviceName).append(".getByPrimaryKey(id);");
    viewMethod.addBodyLine(getModelLineStrBldr.toString());
    StringBuilder setRequestLineStrBldr =
        new StringBuilder(100).append("request.setAttribute(\"").append(lowerShortModelName).append("\", ")
            .append(lowerShortModelName).append(");");
    viewMethod.addBodyLine(setRequestLineStrBldr.toString());
    StringBuilder rtnlineStrBldr =
        new StringBuilder(100).append(RETURN_NEW_MODELANDVIEW_PREFIX_CODE)
        .append(jspFullyName).append("View\");");
    viewMethod.addBodyLine(rtnlineStrBldr.toString());

    topLevelClass.addMethod(viewMethod);
  }

  protected void addRemoveMethod(TopLevelClass topLevelClass, String serviceName) {
    Method removeMethod = new Method("remove");
    removeMethod.setVisibility(JavaVisibility.PUBLIC);
    removeMethod.setReturnType(this.ajaxRtnJsonType);
    removeMethod.addAnnotation("@RequestMapping(\"remove/{id}\")");
    removeMethod.addAnnotation(RESPONSE_BODY_ANNOTATION);
    Parameter idParam = new Parameter(FullyQualifiedJavaType.getStringInstance(), "id");
    idParam.addAnnotation(PATH_VARIABLE_ANNOTATION);
    removeMethod.addParameter(idParam);

    removeMethod.addJavaDocLine("/**");
    removeMethod.addJavaDocLine(" * remove object by id.");
    removeMethod.addJavaDocLine(" */");

    removeMethod.addBodyLine(TRY_CODE_START);
    removeMethod.addBodyLine(serviceName + ".remove(id);");
    removeMethod.addBodyLine("return new AjaxRtnJson(true, \"删除成功\");");
    removeMethod.addBodyLine(CATCH_DATA_ACCESS_EX_CODE);
    removeMethod.addBodyLine(LOGGER_ERROR_MSG_CODE);
    removeMethod.addBodyLine("return new AjaxRtnJson(false, \"删除失败: \" + e.getMessage());");
    removeMethod.addBodyLine("}");

    topLevelClass.addMethod(removeMethod);
  }

  protected void addSaveMethod(TopLevelClass topLevelClass, String serviceName) {
    String shortModelName = this.modelType.getShortName();
    String lowerShortModelName = setInitToLowerCase(shortModelName);

    Method saveMethod = new Method("save");
    saveMethod.setVisibility(JavaVisibility.PUBLIC);
    saveMethod.setReturnType(this.ajaxRtnJsonType);
    saveMethod.addAnnotation("@RequestMapping(\"save\")");
    saveMethod.addAnnotation(RESPONSE_BODY_ANNOTATION);
    saveMethod.addParameter(new Parameter(this.modelType, lowerShortModelName));

    saveMethod.addJavaDocLine("/**");
    saveMethod.addJavaDocLine(" * Save object: create or update");
    saveMethod.addJavaDocLine(" */");

    if (null == this.primaryKeyType || null == this.primaryKey) {
      saveMethod.addBodyLine("// 未找到主键，请自行编写新建和更新的保存代码");
      saveMethod.addBodyLine("return null;");
    } else {
      if (this.primaryKeyType.equals(FullyQualifiedJavaType.getStringInstance())) {
        StringBuilder lineStringBuilder = new StringBuilder(100);
        lineStringBuilder.append("if (StringUtils.isEmpty(").append(lowerShortModelName).append(".get")
            .append(setInitToUpperCase(this.primaryKey)).append("())) {");
        saveMethod.addBodyLine(lineStringBuilder.toString());
      } else {
        StringBuilder lineStringBuilder = new StringBuilder(100);
        lineStringBuilder.append("if (null == ").append(lowerShortModelName).append(".get")
            .append(setInitToUpperCase(this.primaryKey)).append("()) {");
        saveMethod.addBodyLine(lineStringBuilder.toString());
      }

      saveMethod.addBodyLine(TRY_CODE_START);
      saveMethod.addBodyLine(serviceName + ".create(" + lowerShortModelName + ");");
      saveMethod.addBodyLine("return new AjaxRtnJson(true, \"新建成功\");");
      saveMethod.addBodyLine(CATCH_DATA_ACCESS_EX_CODE);
      saveMethod.addBodyLine(LOGGER_ERROR_MSG_CODE);
      saveMethod.addBodyLine("return new AjaxRtnJson(false, \"新建失败: \" + e.getMessage());");
      saveMethod.addBodyLine("}");

      saveMethod.addBodyLine("} else {");

      saveMethod.addBodyLine(TRY_CODE_START);
      saveMethod.addBodyLine(serviceName + ".updateSelective(" + lowerShortModelName + ");");
      saveMethod.addBodyLine("return new AjaxRtnJson(true, \"修改成功\");");
      saveMethod.addBodyLine(CATCH_DATA_ACCESS_EX_CODE);
      saveMethod.addBodyLine(LOGGER_ERROR_MSG_CODE);
      saveMethod.addBodyLine("return new AjaxRtnJson(false, \"修改失败: \" + e.getMessage());");
      saveMethod.addBodyLine("}");

      saveMethod.addBodyLine("}");
    }
    topLevelClass.addMethod(saveMethod);
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
}
