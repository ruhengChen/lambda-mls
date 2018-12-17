/**
 *    Copyright 2006-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.model;

import static org.mybatis.generator.internal.util.JavaBeansUtil.getJavaBeansField;
import static org.mybatis.generator.internal.util.JavaBeansUtil.getJavaBeansGetter;
import static org.mybatis.generator.internal.util.JavaBeansUtil.getJavaBeansSetter;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.RootClassInfo;
import org.mybatis.generator.config.PropertyRegistry;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class RecordWithBLOBsGenerator extends AbstractJavaGenerator {

    public RecordWithBLOBsGenerator() {
        super();
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString(
                "Progress.9", table.toString())); //$NON-NLS-1$
        Plugin plugins = context.getPlugins();
        CommentGenerator commentGenerator = context.getCommentGenerator();

        TopLevelClass topLevelClass = new TopLevelClass(introspectedTable
                .getRecordWithBLOBsType());
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(topLevelClass);

        String rootClass = getRootClass();
        if (introspectedTable.getRules().generateBaseRecordClass()) {
            topLevelClass.setSuperClass(introspectedTable.getBaseRecordType());
        } else {
            topLevelClass.setSuperClass(introspectedTable.getPrimaryKeyType());
        }
        commentGenerator.addModelClassComment(topLevelClass, introspectedTable);

        if (introspectedTable.isConstructorBased()) {
            addParameterizedConstructor(topLevelClass);
            
            if (!introspectedTable.isImmutable()) {
                addDefaultConstructor(topLevelClass);
            }
        }
        
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getBLOBColumns()) {
            if (RootClassInfo.getInstance(rootClass, warnings)
                    .containsProperty(introspectedColumn)) {
                continue;
            }

            //add for column colour, by lidd 20181203 start
            IntrospectedColumn introspectedColumnColour = new IntrospectedColumn();
            try {
                PropertyUtils.copyProperties(introspectedColumnColour, introspectedColumn);
                introspectedColumnColour.setActualColumnName(introspectedColumnColour.getActualColumnName() + ":Coloured");
                introspectedColumnColour.setFullyQualifiedJavaType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
                introspectedColumnColour.setIdentity(false);
                introspectedColumnColour.setJavaProperty(introspectedColumnColour.getJavaProperty() + "Coloured");
                introspectedColumnColour.setProperties(new Properties());
                for(Iterator<Object> iterator = introspectedColumn.getProperties().keySet().iterator(); iterator.hasNext();){
                    Object key = iterator.next();
                    introspectedColumnColour.getProperties().put(key, introspectedColumn.getProperties().get(key));
                }
                introspectedColumnColour.getProperties().put(PropertyRegistry.MODEL_GENERATOR_TRIM_STRINGS, "false");

            } catch (Throwable e) {
                System.err.println("PropertyUtils.copyProperties Exception!!!");
                System.exit(-1);
            }
            //add for column colour, by lidd 20181203 end

            Field field = getJavaBeansField(introspectedColumn, context, introspectedTable);
            Field fieldColour = getJavaBeansField(introspectedColumnColour, context, introspectedTable);    //add for column colour, by lidd 20181203
            if (plugins.modelFieldGenerated(field, topLevelClass,
                    introspectedColumn, introspectedTable,
                    Plugin.ModelClassType.RECORD_WITH_BLOBS)) {
                topLevelClass.addField(field);
                topLevelClass.addImportedType(field.getType());

                //add for column colour, by lidd 20181203
                topLevelClass.addField(fieldColour);
                topLevelClass.addImportedType(fieldColour.getType());
            }

            Method method = getJavaBeansGetter(introspectedColumn, context, introspectedTable);
            Method methodColour = getJavaBeansGetter(introspectedColumnColour, context, introspectedTable);     //add for column colour, by lidd 20181203
            Method methodNotColour = getJavaBeansGetter(introspectedColumnColour, context, introspectedTable);
            if (plugins.modelGetterMethodGenerated(method, topLevelClass,
                    introspectedColumn, introspectedTable,
                    Plugin.ModelClassType.RECORD_WITH_BLOBS)) {
                topLevelClass.addMethod(method);

                //add for column colour, by lidd 20181203
                topLevelClass.addMethod(methodColour);

                methodNotColour.setName(methodColour.getName().substring(0, methodColour.getName().length() - "Coloured".length()) + "NotColoured");
                StringBuilder sb = new StringBuilder();
                sb.append("return !"); //$NON-NLS-1$
                sb.append(introspectedColumnColour.getJavaProperty());
                sb.append(';');
                List<String> bodylines = methodNotColour.getBodyLines();
                bodylines.clear();
                bodylines.add(sb.toString());
                topLevelClass.addMethod(methodNotColour);
            }

            if (!introspectedTable.isImmutable()) {
                method = getJavaBeansSetter(introspectedColumn, context, introspectedTable);
                methodColour = getJavaBeansSetter(introspectedColumnColour, context, introspectedTable);     //add for column colour, by lidd 20181203
                if (plugins.modelSetterMethodGenerated(method, topLevelClass,
                        introspectedColumn, introspectedTable,
                        Plugin.ModelClassType.RECORD_WITH_BLOBS)) {
                    topLevelClass.addMethod(method);

                    method.addBodyLine("this." + introspectedColumnColour.getJavaProperty() + " = true;");  //add for column colour, by lidd 20181203
                    topLevelClass.addMethod(method);

                    //add for column colour, by lidd 20181203
                    topLevelClass.addMethod(methodColour);
                }
            }
        }

        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (context.getPlugins().modelRecordWithBLOBsClassGenerated(
                topLevelClass, introspectedTable)) {
            answer.add(topLevelClass);
        }
        return answer;
    }
    
    private void addParameterizedConstructor(TopLevelClass topLevelClass) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setConstructor(true);
        method.setName(topLevelClass.getType().getShortName());
        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getAllColumns()) {
            method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(),
                    introspectedColumn.getJavaProperty()));
            topLevelClass.addImportedType(introspectedColumn.getFullyQualifiedJavaType());
        }
        
        boolean comma = false;
        StringBuilder sb = new StringBuilder();
        sb.append("super("); //$NON-NLS-1$
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getNonBLOBColumns()) {
            if (comma) {
                sb.append(", "); //$NON-NLS-1$
            } else {
                comma = true;
            }
            sb.append(introspectedColumn.getJavaProperty());
        }
        sb.append(");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getBLOBColumns()) {
            sb.setLength(0);
            sb.append("this."); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" = "); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(';');
            method.addBodyLine(sb.toString());
        }

        topLevelClass.addMethod(method);
    }
}
