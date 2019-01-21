package com.yatop.lambda.workflow.core.mgr.workflow;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.WorkflowMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeDelete;
import com.yatop.lambda.workflow.core.mgr.workflow.node.link.LinkDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowDelete {

    @Autowired
    WorkflowMgr workflowMgr;

    @Autowired
    NodeDelete nodeDelete;

    @Autowired
    LinkDelete linkDelete;

    public void deleteWorkflow(WorkflowContext workflowContext) {

        if(workflowContext.isLazyLoadMode())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete workflow error -- workflow context work in lazy-load-mode.", "系统内部错误，请联系管理员");
        if(workflowContext.isLoadNodeParameter())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete workflow error -- workflow context work in not load-node-parameter mode.", "系统内部错误，请联系管理员");
        if(workflowContext.isLoadNodeParameter())
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete workflow error -- workflow context work in not load-data-port-schema mode.", "系统内部错误，请联系管理员");

        //TODO 暂不进行 delete snapshot, job<task, task output>

        nodeDelete.deleteAllNodes(workflowContext);
        linkDelete.deleteAllLinks(workflowContext);
        WorkflowHelper.deleteAccumulates(workflowContext.getWorkflow(), workflowContext.getOperId());
        workflowMgr.deleteWorkflow(workflowContext.getWorkflow().data().getFlowId(), workflowContext.getOperId());
        workflowContext.getWorkflow().markDeleted();
    }
}
