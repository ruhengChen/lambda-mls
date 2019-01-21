package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodePortOutput;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemaCreate {

    @Autowired
    NodeSchemaMgr nodeSchemaMgr;

    @Autowired
    JsonObjectMgr jsonObjectMgr;

    private JsonObject createObject(WorkflowContext workflowContext, Node node, NodePortOutput outputPort) {

        WfJsonObject object = new WfJsonObject();
        object.setObjectName(String.format("output_port_schema_%s_%s", node.data().getNodeId(), outputPort.getCmptChar().data().getCharId()));
        object.setObjectType(JsonObjectTypeEnum.OUTPUT_PORT_SCHEMA.getType());
        object.setObjectSrc(JsonObjectSourceEnum.EDITOR.getSource());
        object.setOwnerProjectId(workflowContext.getProject().data().getProjectId());
        object.setRelFlowId(workflowContext.getWorkflow().data().getFlowId());
        object.setRelSnapshotVersion(workflowContext.getWorkflow().data().getNextSnapshotVersion());
        object.setRelNodeId(node.data().getNodeId());
        object.setRelCharId(outputPort.getCmptChar().data().getCharId());
        object.setRelTaskId(-1L);
        object.setStorageLocation(StorageLocationEnum.TABLE_FIELD.getLocation());
        object.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        object = jsonObjectMgr.insertJsonObject(object, workflowContext.getOperId());
        //object.copyProperties(jsonObjectMgr.queryFieldAttributes(object.data().getObjectId()));
        return new JsonObject(object);
    }

    public void createSchema(WorkflowContext workflowContext, Node node, NodePortOutput outputPort) {

        JsonObject jsonObject = createObject(workflowContext, node, outputPort);
        WfFlowNodeSchema schema = new WfFlowNodeSchema();
        schema.setNodePortId(outputPort.data().getNodePortId());
        schema.setSchemaName(outputPort.data().getNodePortName());
        schema.setOwnerNodeId(node.data().getNodeId());
        schema.setObjectId(jsonObject.data().getObjectId());
        schema.setSchemaState(node.isSupportAnalyze() ? SchemaStateEnum.EMPTY.getState() : SchemaStateEnum.NOT_SUPPORT.getState());
        schema = nodeSchemaMgr.insertSchema(schema, workflowContext.getOperId());
        //schema.copyProperties(nodeSchemaMgr.querySchema(schema.data().getNodePortId()));
        NodeSchema richSchema = new NodeSchema(schema, outputPort.getCmptChar(), jsonObject);
        outputPort.setSchema(richSchema);
    }
}
