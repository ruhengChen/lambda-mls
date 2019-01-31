package com.yatop.lambda.workflow.core.mgr.workflow.node;

import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.mgr.workflow.module.AnalyzeNodeStateHelper;
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

    private Node createNode(WorkflowContext workflowContext, Module module, Node otherNode, Long x, Long y, boolean copyOtherName) {

        Workflow workflow = workflowContext.getWorkflow();
        Long flowMaxNodes = SystemParameterUtil.find4Long(SystemParameterEnum.WK_FLOW_MAX_NODES);
        if(workflow.data().getNodeCount() + 1 > flowMaxNodes) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create node failed -- number of nodes can't exceed more then WK_FLOW_MAX_NODES.", "画布节点数量不能超过" + flowMaxNodes, workflow);
        }

        WfFlowNode node = new WfFlowNode();
        node.setOwnerProjectId(workflow.data().getOwnerProjectId());
        node.setOwnerFlowId(workflow.data().getFlowId());
        node.setRefModuleId(module.data().getModuleId());
        node.setPositionX(x);
        node.setPositionY(y);
        if(!copyOtherName) {
            Long sequence = workflow.nextModuleSequence(module, workflowContext.getOperId());
            node.setNodeName(String.format("%s-%d", module.data().getModuleName(), sequence));
            node.setSequence(sequence);
        } else {
            workflow.setModuleSequence(module, otherNode.data().getSequence(), workflowContext.getOperId());
            node.setNodeName(otherNode.data().getNodeName());
            node.setSequence(otherNode.data().getSequence());
        }

        node = nodeMgr.insertNode(node, workflowContext.getOperId());
        //node.copyProperties(nodeMgr.queryNode(node.getNodeId()));

        Node richNode = new Node(node, module);
        workflow.increaseNodeCount();

        nodePortCreate.createNodePorts(workflowContext, richNode);
        if(DataUtil.isNull(otherNode)) {
            parameterCreate.createParameters(workflowContext, richNode);
        } else {
            parameterCreate.createParameters(workflowContext, richNode, otherNode);
        }

        workflowContext.doneCreateNode(richNode);
        return richNode;
    }

    public Node createNode(WorkflowContext workflowContext, Module module, Long x, Long y) {
        return createNode(workflowContext, module, null, x, y, false);
    }

    public Node copyNode4SameWorkflow(WorkflowContext workflowContext, Node otherNode, Long x, Long y) {
        return createNode(workflowContext, otherNode.getModule(), otherNode, x, y, false);
    }

    public Node copyNode4DiffWorkflow(WorkflowContext workflowContext, Node otherNode) {
        return createNode(workflowContext, otherNode.getModule(), otherNode, otherNode.data().getPositionX(), otherNode.data().getPositionY(), true);
    }
}
