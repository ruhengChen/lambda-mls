package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.base.model.WfFlowNodeDeleteQueue;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeDeleteQueueMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.config.ModuleConfig;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.module.AnalyzeNodeStateHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterRecover;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.NodePortRecover;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeRecover {

    @Autowired
    NodeMgr nodeMgr;

    @Autowired
    NodeDeleteQueueMgr nodeDeleteQueueMgr;

    @Autowired
    NodePortRecover nodePortRecover;

    @Autowired
    ParameterRecover parameterRecover;

    @Autowired
    ModuleConfig moduleConfig;

    private void recoverNode(WorkflowContext workflowContext, Long nodeId) {

        nodeMgr.recoverNode(nodeId, workflowContext.getOperId());
        WfFlowNode node = nodeMgr.queryNode(nodeId);
        if(DataUtil.isNull(node)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, String.format("Recover node failed -- node not found, node-id:%d.", nodeId), "节点信息缺失");
        }

        Module module = moduleConfig.getModule(node.getRefModuleId());
        if(DataUtil.isNull(module)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node failed -- module not found.", "节点信息错误", node);
        }

        Node richNode = new Node(node, module);
        nodePortRecover.recoverNodePorts(workflowContext, richNode);
        parameterRecover.recoverParameters(workflowContext, richNode);
        workflowContext.doneRecoverNode(richNode);
    }

    public void recoverNodes(WorkflowContext workflowContext) {

        Workflow workflow = workflowContext.getWorkflow();
        List<WfFlowNodeDeleteQueue> deleteQueues = nodeDeleteQueueMgr.queryNodeDelete(workflow.data().getFlowId(), workflow.previousDeleteSequence());
        if(DataUtil.isEmpty(deleteQueues)) {
            //TODO Nothing
            return;
        }

        Long flowMaxNodes = SystemParameterUtil.find4Long(SystemParameterEnum.WK_FLOW_MAX_NODES);
        if(workflow.data().getNodeCount() + deleteQueues.size() > flowMaxNodes) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover node failed -- number of nodes can't exceed more then WK_FLOW_MAX_NODES.", "画布节点数量不能超过" + flowMaxNodes, workflow);
        }

        nodeDeleteQueueMgr.removeNodeDelete(workflow.data().getFlowId(), workflow.previousDeleteSequence());

        for (WfFlowNodeDeleteQueue deleteQueue : deleteQueues) {
            recoverNode(workflowContext, deleteQueue.getNodeId());
        }
        workflow.doneRecoverNodes(deleteQueues.size() + 0L);
    }
}
