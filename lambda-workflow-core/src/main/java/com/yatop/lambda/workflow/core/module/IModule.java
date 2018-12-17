package com.yatop.lambda.workflow.core.module;

import com.yatop.lambda.workflow.core.context.TaskExecutionContext;
import com.yatop.lambda.workflow.core.context.WorkflowNodeContext;
import com.yatop.lambda.workflow.core.context.WorkflowSchemaContext;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;

/*

CharType类，负责特征值事件捕获，包括特征值发生创建（对象创建）、删除（对象删除）、查询（对象展开）、更新（对象更新）时的自定义处理，以及特征值正确性和合法性的常规校验
Module类，负责工作流节点事件捕获，包括节点的参数逻辑校验、任务执行自定义处理、节点输出端口schema分析

*/

//Module类不捕获执行调优参数事件，仅CharType类捕获执行调优参数事件

public interface IModule extends InitializingBean {
    //方法失败或异常抛出Exception，Module类实现该接口，适当封装一些中间abstract组件类以便复用

    //是否捕获参数校验事件
    //返回false，否
    //返回true，是
    boolean catchCheckParameter();

    //校验参数处理，例如：数据表读取组件需要校验对应的数据表是否正常
    void onCheckParameter(WorkflowNodeContext context);


    //是否捕获任务执行事件
    //返回false，否
    //返回true，是
    boolean catchTaskExecution();

    //任务执行事件处理，例如：读数据表将输出内容"OUT@DataTable-t1<M>"特征值置为"CCP@TableName"特征值对应数据表的ID值
    void onTaskExecution(TaskExecutionContext context);


    //是否支持动态分析数据输出端口schema
    //返回false，不支持
    //返回true，支持
    boolean supportAnalyzeSchema();

    //影响重新分析schema的参数集合
    //返回特征代码集合
    HashSet<String> reanlyzeSchemaParameterSet();
    /* {
        static final HashSet<String> parameterSet = new HashSet<String>() {{
            add("xxx");
            add("yyy");
        }};
        return parameterSet;
    };*/

    //分析数据输出端口schema
    void analyzeSchema(WorkflowSchemaContext context);
}
