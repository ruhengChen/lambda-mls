package com.yatop.lambda.workflow.core.mgr.workflow.execution.task;

import com.yatop.lambda.base.model.WfExecutionTask;
import com.yatop.lambda.core.mgr.workflow.execution.ExecutionTaskMgr;
import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionJob;
import com.yatop.lambda.workflow.core.richmodel.workflow.execution.ExecutionTask;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskCreate {

    @Autowired
    private ExecutionTaskMgr executionTaskMgr;

    public ExecutionTaskContext createTask(WorkflowContext workflowContext, Node node) {

        ExecutionJob job = workflowContext.getCurrentJob();
        WfExecutionTask task = new WfExecutionTask();
        task.setTaskName(String.format("%s - %d", node.data().getNodeName(), job.data().getJobId()));
        task.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        task.setOwnerJobId(job.data().getJobId());
        task.setSequence(job.data().getNextTaskSequence());
        task.setRelNodeId(node.data().getNodeId());
        task = executionTaskMgr.insertTask(task, workflowContext.getOperId());

        ExecutionTask richTask = new ExecutionTask(task, node);
        workflowContext.putExecutionTask(richTask);

        return  null;
    }
}
