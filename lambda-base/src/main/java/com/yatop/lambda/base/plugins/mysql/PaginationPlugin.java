package com.yatop.lambda.base.plugins.mysql;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

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
    final XmlElement paginationElement = new XmlElement("sql");
    paginationElement.addAttribute(new Attribute("id", "MysqlSuffix"));
    final XmlElement pageEnd = new XmlElement("if");
    pageEnd.addAttribute(new Attribute("test", "page != null"));
    pageEnd.addElement(new TextElement("<![CDATA[ limit #{page.begin} , #{page.length} ]]>"));
    paginationElement.addElement(pageEnd);
    parentElement.addElement(paginationElement);
    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  @Override
  public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(final XmlElement element,
      final IntrospectedTable introspectedTable) {
    final XmlElement isNotNullElement = new XmlElement("include");
    isNotNullElement.addAttribute(new Attribute("refid", "MysqlSuffix"));
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
  //通过跑分页直接生成pojo,xml
  public static void generate() {
    String config = PaginationPlugin.class.getClassLoader().getResource(
            "generator/mysql/generatorConfig.xml").getFile();
    String[] arg = { "-configfile", config, "-overwrite" };
    ShellRunner.main(arg);
  }
  public static void main(String[] args) {
    generate();
  }

}
