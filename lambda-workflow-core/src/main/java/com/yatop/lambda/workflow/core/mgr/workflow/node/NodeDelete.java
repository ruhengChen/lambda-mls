package com.yatop.lambda.workflow.core.mgr.workflow.node;


import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeDeleteQueueMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterDelete;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.NodePortDelete;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeDelete {

    @Autowired
    NodeMgr nodeMgr;

    @Autowired
    NodeDeleteQueueMgr nodeDeleteQueueMgr;

    @Autowired
    NodePortDelete nodePortDelete;

    @Autowired
    ParameterDelete parameterDelete;

    public void deleteNodes(WorkflowContext workflowContext, List<Node> nodes) {

        if(DataUtil.isNotEmpty(nodes)) {
            for (Node node : nodes) {
                if(DataUtil.isNull(workflowContext.getWorkflow().getFlowId() != node.getOwnerFlowId())) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Delete node failed -- flow-id vs owner-flow-id inconsistent.", "节点信息错误", workflowContext.getWorkflow(), node);
                }
                nodePortDelete.deleteNodePorts(workflowContext, node);
                parameterDelete.deleteParameters(workflowContext, node);
                nodeMgr.deleteNode(node.getNodeId(), workflowContext.getOperId());
                workflowContext.markDeleted4Node(node);
            }


            Workflow workflow = workflowContext.getWorkflow();
            if(nodeDeleteQueueMgr.existsNodeDeleteSequence(workflow.getFlowId(), workflow.getNextDeleteSequence()))
                nodeDeleteQueueMgr.removeNodeDelete(workflow.getFlowId(), workflow.getNextDeleteSequence());

            for (Node node : nodes) {
                WfFlowNodeDeleteQueue deleteQueue = new WfFlowNodeDeleteQueue();
                deleteQueue.setFlowId(node.getOwnerFlowId());
                deleteQueue.setNodeId(node.getNodeId());
                deleteQueue.setSequence(workflow.getNextDeleteSequence());
                nodeDeleteQueueMgr.insertNodeDelete(deleteQueue, workflowContext.getOperId());
            }

            workflow.doneDeleteNodes(nodes.size() + 0L);
            workflowContext.getWorkflow().changeWorkflowState2Draft();
        }
    }
}
