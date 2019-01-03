package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.node.parameter.ParameterCreate;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.NodePortCreate;
import com.yatop.lambda.workflow.core.richmodel.workflow.Workflow;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.Module;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeCreate {

    @Autowired
    private NodeMgr nodeMgr;

    @Autowired
    private ParameterCreate parameterCreate;

    @Autowired
    private NodePortCreate nodePortCreate;

    @Autowired
    private NodeParameterCheck nodeParameterCheck;

    private Node createNode(WorkflowContext workflowContext, Module module, Node otherNode, Long x, Long y, boolean copyOtherName) {

        Workflow workflow = workflowContext.getWorkflow();
        Long flowMaxNodes = SystemParameterUtil.find4Long(SystemParameterEnum.WK_FLOW_MAX_NODES);
        if(workflow.getNodeCount() + 1 > flowMaxNodes) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create node failed -- number of nodes can't exceed more then WK_FLOW_MAX_NODES.", "画布节点数量不能超过" + flowMaxNodes, workflow);
        }

        WfFlowNode node = new WfFlowNode();
        node.setOwnerProjectId(workflow.getOwnerProjectId());
        node.setOwnerFlowId(workflow.getFlowId());
        node.setRefModuleId(module.getModuleId());
        node.setPositionX(x);
        node.setPositionY(y);
        if(!copyOtherName) {
            Long sequence = workflow.nextModuleSequence(module, workflowContext.getOperId());
            node.setNodeName(String.format("%s-%d", module.getModuleName(), sequence));
            node.setSequence(sequence);
        } else {
            workflow.setModuleSequence(module, otherNode.getSequence(), workflowContext.getOperId());
            node.setNodeName(otherNode.getNodeName());
            node.setSequence(otherNode.getSequence());
        }

        node = nodeMgr.insertNode(node, workflowContext.getOperId());
        //node.copyProperties(nodeMgr.queryNode(node.getNodeId()));

        Node richNode = new Node(node, module);
        workflowContext.putNode(richNode);
        workflow.increaseNodeCount();

        if(DataUtil.isNull(otherNode)) {
            parameterCreate.createParameters(workflowContext, richNode);
        } else {
            parameterCreate.createParameters(workflowContext, richNode, otherNode);
        }
        nodePortCreate.createNodePorts(workflowContext, richNode);
        nodeParameterCheck.checkParameter(workflowContext, richNode);
        workflowContext.getWorkflow().changeWorkflowState2Draft();
        richNode.downgradeNodeState2Ready();
        return richNode;
    }

    public Node createNode(WorkflowContext workflowContext, Module module, Long x, Long y) {
        return createNode(workflowContext, module, null, x, y, false);
    }

    public Node copyNode4SameWorkflow(WorkflowContext workflowContext, Node otherNode, Long x, Long y) {
        return createNode(workflowContext, otherNode.getModule(), otherNode, x, y, false);
    }

    public Node copyNode4DiffWorkflow(WorkflowContext workflowContext, Node otherNode, Long x, Long y) {
        return createNode(workflowContext, otherNode.getModule(), otherNode, x, y, true);
    }
}
