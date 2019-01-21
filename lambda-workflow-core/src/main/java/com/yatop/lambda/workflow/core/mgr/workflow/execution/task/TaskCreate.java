package com.yatop.lambda.workflow.core.mgr.workflow.execution.task;

import com.yatop.lambda.core.mgr.workflow.execution.ExecutionTaskMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskCreate {

    @Autowired
    private ExecutionTaskMgr executionTaskMgr;

    public ExecutionTask createTask(WorkflowContext workflowContext, Node node) {
        return  null;
    }
}
