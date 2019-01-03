package com.yatop.lambda.workflow.core.mgr.workflow.node;


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

    //名称、X坐标、Y坐标、最后任务ID、警告消息、节点状态、注释、概要、描述
    public static void updateNode(Node node, String operId) {
        NODE_MGR.updateNode(node, operId);
        node.clearColoured();
    }
}
