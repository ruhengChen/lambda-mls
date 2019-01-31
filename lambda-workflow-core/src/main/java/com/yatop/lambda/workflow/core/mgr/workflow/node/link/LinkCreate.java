package com.yatop.lambda.workflow.core.mgr.workflow.node.link;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.core.enums.IsWebLinkEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeLinkMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.context.WorkflowContextHelper;
import com.yatop.lambda.workflow.core.mgr.workflow.node.NodeQuery;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeLink;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortInput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkCreate {

    @Autowired
    NodeLinkMgr nodeLinkMgr;

    @Autowired
    LinkValidate linkValidate;

    public NodeLink createLink(WorkflowContext workflowContext, Node srcNode, Node dstNode, NodePortOutput srcNodePort, NodePortInput dstNodePort) {

        if(!linkValidate.validateLink(workflowContext, srcNode, dstNode, srcNodePort, dstNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create node link failed -- validation failed for establishing link.", "输出端口和输入端口间链接建立验证失败", srcNodePort, dstNodePort);
        }

        WfFlowNodeLink nodeLink = new WfFlowNodeLink();
        nodeLink.setLinkName(String.format("From %d.%d to %d.%d", srcNode.data().getNodeId(),
                                                                  srcNodePort.data().getNodePortId(),
                                                                  dstNode.data().getNodeId(),
                                                                  dstNodePort.data().getNodePortId()));
        nodeLink.setOwnerFlowId(workflowContext.getWorkflow().data().getFlowId());
        nodeLink.setIsWebLink(srcNode.isWebNode() ? IsWebLinkEnum.YES.getMark() : IsWebLinkEnum.NO.getMark());
        nodeLink.setSrcNodeId(srcNode.data().getNodeId());
        nodeLink.setSrcPortId(srcNodePort.data().getNodePortId());
        nodeLink.setDstNodeId(dstNode.data().getNodeId());
        nodeLink.setDstPortId(dstNodePort.data().getNodePortId());
        nodeLink = nodeLinkMgr.insertLink(nodeLink, workflowContext.getOperId());
        //nodeLink.copyProperties(nodeLinkMgr.queryLink(nodeLink.getLinkId()));
        NodeLink richNodeLink = new NodeLink(nodeLink);
        workflowContext.doneCreateLink(richNodeLink);

        if(WorkflowContextHelper.existDirectedCyclicGraph(workflowContext)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create node link failed -- Create link will make workflow exists directed cyclic graph..", "新建链接将产生有向循环图", srcNodePort, dstNodePort);
        }
        return richNodeLink;
    }

    public NodeLink createLink(WorkflowContext workflowContext, Long srcNodeId, Long dstNodeId, Long srcNodePortId, Long dstNodePortId) {
        Node srcNode = workflowContext.fetchNode(srcNodeId);
        Node dstNode = workflowContext.fetchNode(dstNodeId);

        NodePortOutput srcNodePort = srcNode.getOutputNodePort(srcNodePortId);
        if(DataUtil.isNull(srcNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create node link failed -- source node port info missing.", "输出端口信息缺失", srcNode);
        }

        NodePortInput dstNodePort = srcNode.getInputNodePort(dstNodePortId);
        if(DataUtil.isNull(dstNodePort)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Create node link failed -- destination node port info missing.", "输入端口信息缺失", dstNode);
        }

        return createLink(workflowContext, srcNode, dstNode, srcNodePort, dstNodePort);
    }
}
