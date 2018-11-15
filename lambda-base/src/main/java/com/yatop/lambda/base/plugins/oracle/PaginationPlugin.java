package com.yatop.lambda.base.plugins.oracle;


import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * Oracle MyBatis分页插件
 * 
 * @author hjp
 * 
 * @since 1.0.0
 *
 */
public class PaginationPlugin extends PluginAdapter {

  private final static FullyQualifiedJavaType TYPE =
      new FullyQualifiedJavaType("com.yatop.lambda.base.utils.Page");

  @Override
  public boolean modelExampleClassGenerated(final TopLevelClass topLevelClass,
      final IntrospectedTable introspectedTable) {
    addPage(topLevelClass, introspectedTable, "page");
    return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
  }

  @Override
  public boolean sqlMapDocumentGenerated(final Document document,
      final IntrospectedTable introspectedTable) {
    final XmlElement parentElement = document.getRootElement();
    final XmlElement prefixElement = new XmlElement("sql");
    prefixElement.addAttribute(new Attribute("id", "OracleDialectPrefix"));
    final XmlElement pageStart = new XmlElement("if");
    pageStart.addAttribute(new Attribute("test", "page != null"));
    pageStart.addElement(new TextElement("select * from ( select row_.*, rownum rownum_ from ( "));
    prefixElement.addElement(pageStart);
    parentElement.addElement(prefixElement);
    final XmlElement suffixElement = new XmlElement("sql");
    suffixElement.addAttribute(new Attribute("id", "OracleDialectSuffix"));
    final XmlElement pageEnd = new XmlElement("if");
    pageEnd.addAttribute(new Attribute("test", "page != null"));
    pageEnd.addElement(new TextElement(
        "<![CDATA[ ) row_ ) where rownum_ > #{page.begin} and rownum_ <= #{page.end} ]]>"));
    suffixElement.addElement(pageEnd);
    parentElement.addElement(suffixElement);
    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  @Override
  public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(final XmlElement element,
      final IntrospectedTable introspectedTable) {
    final XmlElement pageStart = new XmlElement("include");
    pageStart.addAttribute(new Attribute("refid", "OracleDialectPrefix"));
    element.getElements().add(0, pageStart);
    final XmlElement isNotNullElement = new XmlElement("include");
    isNotNullElement.addAttribute(new Attribute("refid", "OracleDialectSuffix"));
    element.getElements().add(isNotNullElement);
    return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
  }

  public boolean validate(final List<String> warnings) {
    return true;
  }

  private void addPage(final TopLevelClass topLevelClass, final IntrospectedTable introspectedTable,
      final String name) {
    topLevelClass.addImportedType(TYPE);
    final CommentGenerator commentGenerator = context.getCommentGenerator();
    final Field field = new Field();
    field.setVisibility(JavaVisibility.PROTECTED);
    field.setType(TYPE);
    field.setName(name);
    commentGenerator.addFieldComment(field, introspectedTable);
    topLevelClass.addField(field);
    final char nameChar = name.charAt(0);
    final String camel = Character.toUpperCase(nameChar) + name.substring(1);
    Method method = new Method();
    method.setVisibility(JavaVisibility.PUBLIC);
    method.setName("set" + camel);
    method.addParameter(new Parameter(TYPE, name));
    method.addBodyLine("this." + name + "=" + name + ";");
    commentGenerator.addGeneralMethodComment(method, introspectedTable);
    topLevelClass.addMethod(method);
    method = new Method();
    method.setVisibility(JavaVisibility.PUBLIC);
    method.setReturnType(TYPE);
    method.setName("get" + camel);
    method.addBodyLine("return " + name + ";");
    commentGenerator.addGeneralMethodComment(method, introspectedTable);
    topLevelClass.addMethod(method);
  }

}
