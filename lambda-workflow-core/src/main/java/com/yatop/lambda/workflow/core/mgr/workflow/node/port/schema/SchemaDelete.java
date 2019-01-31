package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemaDelete {

    @Autowired
    private NodeSchemaMgr nodeSchemaMgr;

    public void deleteSchemas(WorkflowContext workflowContext, Node node) {

        if(!node.isTailNode()) {
            int counter = 0;
            for (NodePortOutput port : node.getOutputNodePorts()) {
                if (port.isDataTablePort()) {
                    NodeSchema schema = port.getSchema();
                    schema.deleteFieldAttributes(workflowContext.getOperId());
                    counter++;
                }
            }

            if(counter > 0)
                nodeSchemaMgr.deleteSchema(node.data().getNodeId(), workflowContext.getOperId());
        }
    }
}
