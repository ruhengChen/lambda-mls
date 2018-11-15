package com.yatop.lambda.base.plugins.oracle;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class OracleInsertPlugin extends PluginAdapter {

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  @Override
  public boolean sqlMapInsertElementGenerated(XmlElement element,
      IntrospectedTable introspectedTable) {
    Attribute attr = new Attribute("keyColumn", "ID");
    element.addAttribute(attr);
    return super.sqlMapInsertElementGenerated(element, introspectedTable);
  }

  @Override
  public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element,
      IntrospectedTable introspectedTable) {
    Attribute attr = new Attribute("keyColumn", "ID");
    element.addAttribute(attr);
    return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
  }

}
