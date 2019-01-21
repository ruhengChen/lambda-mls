package com.yatop.lambda.workflow.core.framework.module;

import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import com.yatop.lambda.workflow.core.richmodel.workflow.value.CharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public abstract class ModuleClazzClazzBase implements IModuleClazz {

    //<class-path, bean-object>
    private static final HashMap<String, IModuleClazz> CLAZZ_BEANS = new HashMap<String, IModuleClazz>();

    public static IModuleClazz getClazzBean(String clazzPath) {
        return CollectionUtil.get(CLAZZ_BEANS, clazzPath);
    }

    private static void putClazzBean(String clazzPath, IModuleClazz moduleBean) {
        CollectionUtil.put(CLAZZ_BEANS, clazzPath, moduleBean);
    }

    public ModuleClazzClazzBase() {
        ModuleClazzClazzBase.putClazzBean(this.getClass().getName(), this);
    }

    //
    //接口方法默认实现
    //

    @Override
    public TreeMap<String, String> checkParameter(WorkflowContext workflowContext, Node node) {
        return null;
    }

    @Override
    public void exploreOutputResource(WorkflowContext workflowContext, ExecutionTask task) {
        //TODO query task output resource
        return;
    }

    @Override
    public void prepareOutputResource(WorkflowContext workflowContext, ExecutionTask task) {
        //TODO prepare task output resource
        return;
    }

    @Override
    public void completeOutputResource(WorkflowContext workflowContext, ExecutionTask task) {
        //TODO complete task output resource
        return;
    }

    @Override
    public void clearOutputResource(WorkflowContext workflowContext, ExecutionTask task) {
        //TODO clear task output resource
        return;
    }

    @Override
    public void execute(ExecutionTaskContext context) {
        //TODO if needn't submit compute-cluster, compute output content here
        return;
    }

    @Override
    public boolean supportAnalyzeSchema() {
        return false;
    }

    @Override
    public HashSet<String> reanalyzeSchemaParameterSet() {
        return null;
    }

    @Override
    public TreeMap<String, NodeSchema> analyzeSchema(WorkflowContext workflowContext, Node node) {
        return null;
    }
}
