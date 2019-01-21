package com.yatop.lambda.workflow.core.mgr.workflow.node.port;

import com.yatop.lambda.core.mgr.workflow.node.NodePortMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodePortDelete {

    @Autowired
    private NodePortMgr nodePortMgr;

    @Autowired
    private SchemaDelete schemaDelete;

    public void deleteNodePorts(WorkflowContext workflowContext, Node node) {

        if(!node.isHeadNode() || !node.isTailNode())
            if(node.haveOutputDataTablePort()) {
                schemaDelete.deleteSchemas(workflowContext, node);
            }
            nodePortMgr.deleteNodePort(node.data().getNodeId(), workflowContext.getOperId());
    }
}
