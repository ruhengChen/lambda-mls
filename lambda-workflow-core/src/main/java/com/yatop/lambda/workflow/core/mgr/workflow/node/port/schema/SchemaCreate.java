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

    public void createSchema(WorkflowContext workflowContext, Node node, NodePortOutput outputPort) {

        WfJsonObject object = new WfJsonObject();
        object.setObjectName(String.format("output_port_schema_%s_%s", node.getNodeId(), outputPort.getModulePort().getCmptChar().getCharId()));
        object.setObjectType(JsonObjectTypeEnum.OUTPUT_PORT_SCHEMA.getType());
        object.setObjectSrc(JsonObjectSourceEnum.EDITOR.getSource());
        object.setOwnerProjectId(workflowContext.getProject().getProjectId());
        object.setRelFlowId(workflowContext.getWorkflow().getFlowId());
        object.setRelSnapshotVersion(workflowContext.getWorkflow().getNextSnapshotVersion());
        object.setRelNodeId(node.getNodeId());
        object.setRelCharId(outputPort.getModulePort().getCmptChar().getCharId());
        object.setRelTaskId(-1L);
        object.setStorageLocation(StorageLocationEnum.TABLE_FIELD.getLocation());
        object.setObjectState(JsonObjectStateEnum.EMPTY.getState());
        object = jsonObjectMgr.insertJsonObject(object, workflowContext.getOperId());
        //object.copyProperties(jsonObjectMgr.queryFieldAttributes(object.getObjectId()));
        JsonObject richObject = new JsonObject(object);

        WfFlowNodeSchema schema = new WfFlowNodeSchema();
        schema.setNodePortId(outputPort.getNodePortId());
        schema.setSchemaName(outputPort.getNodePortName());
        schema.setOwnerNodeId(node.getNodeId());
        schema.setObjectId(richObject.getObjectId());
        schema.setSchemaState(SchemaStateEnum.EMPTY.getState());
        schema = nodeSchemaMgr.insertSchema(schema, workflowContext.getOperId());
        //schema.copyProperties(nodeSchemaMgr.querySchema(schema.getNodePortId()));
        NodeSchema richSchema = new NodeSchema(schema, richObject);
        outputPort.setSchema(richSchema);
    }
}
