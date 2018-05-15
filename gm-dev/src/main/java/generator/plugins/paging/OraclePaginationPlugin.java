package generator.plugins.paging;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;

/**
 * MyBatis的Oracle分页插件.
 * 
 * @author WangYu
 *
 */
public class OraclePaginationPlugin extends PluginAdapter {

  private static final String PAGE_VARIABLE_NAME = "page";
  private static final String PAGE_PREFIX_ID = "Oracle_Dialect_Pagination_Prefix";
  private static final String PAGE_SUFFIX_ID = "Oracle_Dialect_Pagination_Suffix";

  private static final String INCLUDE_XML_ELEMENT_NAME = "include";
  private static final String REFID_XML_ATTRIBUTE_NAME = "refid";
  private static final String MYBATIS_PAGE_CLASS_FULL_TYPE = "org.amberframework.core.mybatis.pojo.Page";

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  @Override
  public boolean modelExampleClassGenerated(
      TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    addPage(topLevelClass, introspectedTable);
    return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
  }

  @Override
  public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
    final String pageVarName = OraclePaginationPlugin.PAGE_VARIABLE_NAME;
    XmlElement parentElement = document.getRootElement();

    // 分页语句前半部分SQL标签
    XmlElement paginationPrefixElement = new XmlElement("sql");
    paginationPrefixElement.addAttribute(new Attribute("id", PAGE_PREFIX_ID));
    // 为分页语句前半部分SQL标签添加NEW_ELEMENT_TAG备注
    addComment(paginationPrefixElement);
    XmlElement pageStartIf = new XmlElement("if");
    pageStartIf.addAttribute(new Attribute("test", pageVarName + " != null"));
    pageStartIf.addElement(new TextElement("select * from ( select row_.*, rownum rownum_ from ( "));
    paginationPrefixElement.addElement(pageStartIf);
    parentElement.addElement(paginationPrefixElement);

    // 分页语句后半部分SQL标签
    XmlElement paginationSuffixElement = new XmlElement("sql");
    paginationSuffixElement.addAttribute(new Attribute("id", PAGE_SUFFIX_ID));
    // 为分页语句后半部分SQL标签添加NEW_ELEMENT_TAG备注
    addComment(paginationSuffixElement);
    XmlElement pageEndIf = new XmlElement("if");
    pageEndIf.addAttribute(new Attribute("test", pageVarName + " != null"));
    pageEndIf.addElement(new TextElement(
        "<![CDATA[ ) row_ ) where rownum_ > #{page.begin} and rownum_ <= #{page.end} ]]>"));
    paginationSuffixElement.addElement(pageEndIf);
    parentElement.addElement(paginationSuffixElement);

    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  @Override
  public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
      IntrospectedTable introspectedTable) {
    XmlElement pageStart = new XmlElement(INCLUDE_XML_ELEMENT_NAME);
    pageStart.addAttribute(new Attribute(REFID_XML_ATTRIBUTE_NAME, PAGE_PREFIX_ID));
    // 在select之前，注释之后插入分页前缀
    int insertLocation = findSelectWordLocation(element);
    element.addElement(insertLocation, pageStart);

    XmlElement pageEnd = new XmlElement(INCLUDE_XML_ELEMENT_NAME);
    pageEnd.addAttribute(new Attribute(REFID_XML_ATTRIBUTE_NAME, PAGE_SUFFIX_ID));
    element.addElement(pageEnd);

    return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
  }

  @Override
  public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element,
      IntrospectedTable introspectedTable) {
    XmlElement pageStart = new XmlElement(INCLUDE_XML_ELEMENT_NAME);
    pageStart.addAttribute(new Attribute(REFID_XML_ATTRIBUTE_NAME, PAGE_PREFIX_ID));
    // 在select之前，注释之后插入分页前缀
    int insertLocation = findSelectWordLocation(element);
    element.addElement(insertLocation, pageStart);

    XmlElement pageEnd = new XmlElement(INCLUDE_XML_ELEMENT_NAME);
    pageEnd.addAttribute(new Attribute(REFID_XML_ATTRIBUTE_NAME, PAGE_SUFFIX_ID));
    element.addElement(pageEnd);

    return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
  }

  private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    final String pageVarName = OraclePaginationPlugin.PAGE_VARIABLE_NAME;
    topLevelClass.addImportedType(new FullyQualifiedJavaType(MYBATIS_PAGE_CLASS_FULL_TYPE));
    CommentGenerator commentGenerator = context.getCommentGenerator();

    // 添加page属性字段
    Field field = new Field();
    field.setVisibility(JavaVisibility.PROTECTED);
    field.setType(new FullyQualifiedJavaType(MYBATIS_PAGE_CLASS_FULL_TYPE));
    field.setName(pageVarName);
    commentGenerator.addFieldComment(field, introspectedTable);
    topLevelClass.addField(field);

    // 添加page set方法
    String upperCamelName = upperInitialChar(pageVarName);
    Method methodSet = new Method();
    methodSet.setVisibility(JavaVisibility.PUBLIC);
    methodSet.setName("set" + upperCamelName);
    methodSet.addParameter(new Parameter(new FullyQualifiedJavaType(
        MYBATIS_PAGE_CLASS_FULL_TYPE), pageVarName));
    StringBuilder methodSetBodyLine = new StringBuilder(20);
    methodSetBodyLine.append("this.").append(pageVarName).append(" = ").append(pageVarName).append(";");
    methodSet.addBodyLine(methodSetBodyLine.toString());
    commentGenerator.addGeneralMethodComment(methodSet, introspectedTable);
    topLevelClass.addMethod(methodSet);

    // 添加page get方法
    Method methodGet = new Method();
    methodGet.setVisibility(JavaVisibility.PUBLIC);
    methodGet.setName("get" + upperCamelName);
    methodGet.setReturnType(new FullyQualifiedJavaType(MYBATIS_PAGE_CLASS_FULL_TYPE));
    StringBuilder methodGetBodyLine = new StringBuilder(20);
    methodGetBodyLine.append("return this.").append(pageVarName).append(";");
    methodGet.addBodyLine(methodGetBodyLine.toString());
    commentGenerator.addGeneralMethodComment(methodGet, introspectedTable);
    topLevelClass.addMethod(methodGet);
  }

  private static void addComment(XmlElement xmlElement) {
    xmlElement.addElement(new TextElement("<!--")); //$NON-NLS-1$

    StringBuilder sb = new StringBuilder();
    sb.append("  WARNING - "); //$NON-NLS-1$
    sb.append(MergeConstants.NEW_ELEMENT_TAG);
    xmlElement.addElement(new TextElement(sb.toString()));

    xmlElement.addElement(new TextElement(
        "  This element is automatically generated by MyBatis Generator, do not modify.")); //$NON-NLS-1$

    xmlElement.addElement(new TextElement("-->")); //$NON-NLS-1$
  }

  private static String upperInitialChar(String name) {
    if (null != name) {
      char initial = name.charAt(0);
      return Character.toUpperCase(initial) + name.substring(1);
    } else {
      return name;
    }
  }

  private static int findSelectWordLocation(XmlElement element) {
    Element childElement = null;
    for (int i = 0; i < element.getElements().size(); i++) {
      childElement = element.getElements().get(i);
      if (childElement instanceof TextElement && "select".equals(((TextElement) childElement).getContent())) {
        return i;
      }
    }
    return 0;
  }
}
