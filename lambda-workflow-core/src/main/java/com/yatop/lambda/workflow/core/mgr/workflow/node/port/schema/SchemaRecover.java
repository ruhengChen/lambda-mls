package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemaRecover {

    @Autowired
    private NodeSchemaMgr nodeSchemaMgr;

    public void recoverSchemas(WorkflowContext workflowContext, Node node) {

        if(!node.isTailNode()) {
            int counter = 0;
            for (NodePortOutput port : node.getOutputNodePorts()) {
                if (port.isDataTablePort()) {
                    counter++;
                }
            }

            if (counter > 0) {
                nodeSchemaMgr.recoverSchema(node.data().getNodeId(), workflowContext.getOperId());
                List<WfFlowNodeSchema> schemaList = nodeSchemaMgr.querySchemaByNodeId(node.data().getNodeId());

                if (DataUtil.isEmpty(schemaList) || counter != schemaList.size()) {
                    throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Recover data node output port schema failed -- schema list size inconsistent.", "节点数据输出端口schema缺失", node);
                }
                for (WfFlowNodeSchema schema : schemaList) {
                    NodePortOutput outputNodePort = node.getOutputNodePort(schema.getNodePortId());

                    if (DataUtil.isNull(outputNodePort)) {
                        throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query data node output port schema failed -- output node port not found.", "节点数据输出端口信息缺失", schema);
                    }
                    outputNodePort.setSchema(new NodeSchema(schema, outputNodePort.getCmptChar()));
                    outputNodePort.getSchema().recoverFieldAttributes(workflowContext.getOperId());
                }
            }
        }
    }
}
