package com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema;

import com.yatop.lambda.base.model.WfJsonObject;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.workflow.unstructured.JsonObjectMgr;
import com.yatop.lambda.core.mgr.workflow.node.NodeSchemaMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchemaHelper {

    private static JsonObjectMgr JSON_OBJECT_MGR;

    private static NodeSchemaMgr NODE_SCHEMA_MGR;

    @Autowired
    public void setJsonObjectMgr(JsonObjectMgr josnObjectMgr) {
        SchemaHelper.JSON_OBJECT_MGR = josnObjectMgr;
    }

    @Autowired
    public void setNodeSchemaMgr(NodeSchemaMgr nodeSchemaMgr) {
        SchemaHelper.NODE_SCHEMA_MGR = nodeSchemaMgr;
    }

    public static JsonObject queryFieldAttributes(Long objectId) {
        WfJsonObject jsonObject = JSON_OBJECT_MGR.queryJsonObject(objectId);
        if(DataUtil.isNull(jsonObject)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Query data output port schema info failed -- json object data missing.", "节点数据输出端口schema信息丢失，请联系管理员");
        }
        return new JsonObject(jsonObject);
    }

    public static void updateFieldAttributes(JsonObject jsonObject, String operId) {
        if(DataUtil.isNotEmpty(jsonObject.data().getObjectContent())) {
            jsonObject.data().setObjectState(JsonObjectStateEnum.NORMAL.getState());
        } else {
            jsonObject.data().setObjectState(JsonObjectStateEnum.EMPTY.getState());
        }
        JSON_OBJECT_MGR.updateJsonObject(jsonObject.data(), operId);
        jsonObject.clearColoured();
    }

    public static void deleteFieldAttributes(Long jsonObjectId, String operId) {
        JSON_OBJECT_MGR.deleteJsonObject(jsonObjectId, true, operId);
    }

    public static void recoverFieldAttributes(Long jsonObjectId, String operId) {
        JSON_OBJECT_MGR.recoverJsonObject(jsonObjectId, operId);
    }

    public static void updateNodeSchema(NodeSchema schema, String operId) {
        NODE_SCHEMA_MGR.updateSchema(schema.data(), operId);
        schema.clearColoured();
    }
}
