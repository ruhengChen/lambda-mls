package com.yatop.lambda.workflow.core.mgr.workflow.execution.job.analyzer;

import com.yatop.lambda.core.enums.JobTypeEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowContextHelper;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import java.util.TreeSet;

public class JobContentAnalyzer {

    public static TreeSet<Node>[] analyzeJobContent(WorkflowContext workflowContext, JobTypeEnum jobType, Node relatedNode) {

        if(WorkflowContextHelper.existDirectedCyclicGraph(workflowContext)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- exists directed cyclic graph.", "存在循环图");
        }

        switch (jobType) {
            case RUN_ALL:
                return JobContentAnalyzer4RunAll.analyzeJobContent(workflowContext);
            case RUN_START_HERE:
                return JobContentAnalyzer4RunStartHere.analyzeJobContent(workflowContext, relatedNode);
            case RUN_END_HERE:
                return JobContentAnalyzer4RunEndHere.analyzeJobContent(workflowContext, relatedNode);
            case RUN_THIS_NODE:
                return JobContentAnalyzer4RunThisNode.analyzeJobContent(workflowContext, relatedNode);
            case RUN_OFFLINE_SCHEDULE:
            case RUN_ONLINE_SCHEDULE:
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- not supported job-type[" + jobType.name() + "].", "运行作业类型暂不支持");
            case RUN_DATAFILE_IMPORT:
                return JobContentAnalyzer4RunAll.analyzeJobContent(workflowContext);
            default:
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Analyze job content failed -- unknown job-type[" + jobType.name() + "].", "未知运行作业类型");
        }
    }
}
