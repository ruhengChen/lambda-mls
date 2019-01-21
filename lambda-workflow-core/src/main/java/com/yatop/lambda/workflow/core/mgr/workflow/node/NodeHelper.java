package com.yatop.lambda.workflow.core.mgr.workflow.node;


import com.yatop.lambda.base.model.WfFlowNode;
import com.yatop.lambda.core.mgr.workflow.node.NodeMgr;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NodeHelper {

    private static NodeMgr NODE_MGR;

    @Autowired
    public void setNodeParameterMgr(NodeMgr nodeMgr) {
        NODE_MGR = nodeMgr;
    }

    //最后任务ID、警告消息、节点状态、概要
    public static void updateNode(Node node, String operId) {
        NODE_MGR.updateNode(node.data(), operId);
        node.clearColoured();
    }

    public static WfFlowNode updateNodeName(Long nodeId, String name, String operId) {
        WfFlowNode node = NODE_MGR.queryNode(nodeId);
        node.clearColoured();
        node.setNodeName(name);
        NODE_MGR.updateNode(node, operId);
        return node;
    }

    public static WfFlowNode updateNodePosition(Long nodeId, Long x, Long y, String operId) {
        WfFlowNode node = NODE_MGR.queryNode(nodeId);
        node.clearColoured();
        node.setPositionX(x);
        node.setPositionY(y);
        NODE_MGR.updateNode(node, operId);
        return node;
    }

    public static WfFlowNode updateNodeComment(Long nodeId, String comment, String operId) {
        WfFlowNode node = NODE_MGR.queryNode(nodeId);
        node.clearColoured();
        node.setComment(comment);
        NODE_MGR.updateNode(node, operId);
        return node;
    }

    public static WfFlowNode updateNodeDescription(Long nodeId, String description, String operId) {
        WfFlowNode node = NODE_MGR.queryNode(nodeId);
        node.clearColoured();
        node.setDescription(description);
        NODE_MGR.updateNode(node, operId);
        return node;
    }
}
