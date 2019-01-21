package com.yatop.lambda.workflow.core.framework.module;

import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.TreeMap;

/*

CharTypeClazz，负责特征值事件处理，包括特征值发生创建（对象创建）、删除（对象删除）、查询（对象展开）、更新（对象更新）时的自定义处理，以及特征值正确性和合法性的常规校验
ModuleClazz，负责节点事件处理，包括节点的参数逻辑校验、节点输出资源[探测、准备、完成、清理]、本地运行、节点输出端口schema分析

*/

//Module类不捕获执行调优参数事件，仅CharType类捕获执行调优参数事件

public interface IModuleClazz extends InitializingBean {
    //方法失败或异常抛出Exception，Module类实现该接口，适当封装一些中间abstract组件类以便复用

    //校验参数处理，例如：数据表读取组件需要校验对应的数据表是否正常
    //key:charId, warningMessage
    TreeMap<String, String> checkParameter(WorkflowContext workflowContext, Node node);

/*
    //是否支持生成摘要
    //返回false，否
    //返回true，是
    boolean supportGenerateSummary();

    //生成摘要内容
    String generateSummary(Node node);
*/

    //////////////////////////////////////////////////////

    //探测任务运行输出，查询相关输出资源
    void exploreOutputResource(WorkflowContext workflowContext, ExecutionTask task);

    //准备任务运行输出，创建相关输出资源
    void prepareOutputResource(WorkflowContext workflowContext, ExecutionTask task);

    //完成任务运行输出，更新相关输出资源
    void completeOutputResource(WorkflowContext workflowContext, ExecutionTask task);

    //清理任务运行输出，删除相关输出资源
    void clearOutputResource(WorkflowContext workflowContext, ExecutionTask task);

    //////////////////////////////////////////////////////

    //本地运行，组件无需提交集群时，引擎将调用该方法，例如：算法组件的输出内容由本地进行计算
    void execute(ExecutionTaskContext context);

    //////////////////////////////////////////////////////

    //是否支持动态分析数据输出端口schema
    //返回false，不支持
    //返回true，支持
    boolean supportAnalyzeSchema();

    //影响重新分析schema的参数集合
    //返回特征代码集合
    HashSet<String> reanalyzeSchemaParameterSet();
    /* {
        static final HashSet<String> parameterSet = new HashSet<String>() {{
            add("xxx");
            add("yyy");
        }};
        return parameterSet;
    };*/

    //分析数据输出端口schema
    //key:charId, NodeSchema
    TreeMap<String, NodeSchema> analyzeSchema(WorkflowContext workflowContext, Node node);
}
