package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONArray;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SchemaStateEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.richmodel.data.table.field.FieldAttribute;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeSchema extends WfFlowNodeSchema implements IRichModel {

    private JsonObject jsonObject;  //关联JSON对象
    private List<FieldAttribute> fieldAttributes;
    private boolean dirtyFieldAttributes;

    public NodeSchema(WfFlowNodeSchema data) {
        this(data, null);
    }

    public NodeSchema(WfFlowNodeSchema data, JsonObject jsonObject) {
        super.copyProperties(data);
        this.jsonObject = jsonObject;
        this.fieldAttributes = null;
        this.dirtyFieldAttributes = false;
        this.clearColoured();
    }

    @Override
    public void clear() {
        DataUtil.clear(jsonObject);
        jsonObject = null;
        CollectionUtil.clear(fieldAttributes);
        fieldAttributes = null;
        super.clear();
    }

    private JsonObject getJsonObject() {
        if(DataUtil.isNull(jsonObject)) {
            jsonObject = SchemaHelper.queryFieldAttributes(this.getObjectId());
            if(DataUtil.isNull(jsonObject)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- json object data missing.", "节点数据输出端口schema信息错误", this);
            }
        }
        return jsonObject;
    }

    public List<FieldAttribute> getFieldAttributes() {
        if(this.getSchemaState() != SchemaStateEnum.NORMAL.getState()) {
            return null;
        }

        if(DataUtil.isEmpty(fieldAttributes)) {
            if (getJsonObject().getObjectState() == JsonObjectStateEnum.NORMAL.getState()) {
                fieldAttributes = JSONArray.parseArray(getJsonObject().getObjectData(), FieldAttribute.class);
            }
            if(DataUtil.isEmpty(fieldAttributes)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- get empty field attribute list.", "节点数据输出端口schema信息错误", this);
            }
        }
        return fieldAttributes;
    }

    public void clearFieldAttributes(SchemaStateEnum schemaStateEnum) {
        if(this.isNormalSchemaState()) {
            CollectionUtil.clear(this.fieldAttributes);
            this.fieldAttributes = null;
            this.dirtyFieldAttributes = false;  //schema非normal状态不更新JsonObject，仅更新schema状态
        }
        this.changeSchemaState(schemaStateEnum);
    }

    public void setFieldAttributes(List<FieldAttribute> fieldAttributes) {

        if(DataUtil.isEmpty(fieldAttributes)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- input empty field attribute list.", "节点数据输出端口schema信息错误");
        }

        if(this.isNormalSchemaState()) {
            if(!CollectionUtil.equals(this.getFieldAttributes(), fieldAttributes)) {
                CollectionUtil.clear(this.fieldAttributes);
                this.fieldAttributes = fieldAttributes;
                this.dirtyFieldAttributes = true;
            }
        } else {
            this.fieldAttributes = fieldAttributes;
            this.dirtyFieldAttributes = true;
            this.changeSchemaState(SchemaStateEnum.NORMAL);
        }
    }

    public boolean isEmptySchemaState() {
        return this.getSchemaState() == SchemaStateEnum.EMPTY.getState();
    }

    public boolean isNormalSchemaState() {
        return this.getSchemaState() == SchemaStateEnum.NORMAL.getState();
    }

    public boolean isNotSupportSchemaState() {
        return this.getSchemaState() == SchemaStateEnum.NOT_SUPPORT.getState();
    }

    public boolean isOverloadInterruptSchemaState() {
        return this.getSchemaState() == SchemaStateEnum.OVERLOAD_INTERRUPT.getState();
    }

    public void changeSchemaState(SchemaStateEnum stateEnum) {
        if(this.getSchemaState() == stateEnum.getState())
            return;

        this.setSchemaState(stateEnum.getState());
    }

    public void flush(String operId) {
        if(dirtyFieldAttributes) {
            getJsonObject().setObjectData(DataUtil.isNotEmpty(fieldAttributes) ? JSONArray.toJSONString(fieldAttributes) : null);
            SchemaHelper.updateFieldAttributes(getJsonObject(), operId);
            dirtyFieldAttributes = false;
        }

        if(this.isColoured()) {
            SchemaHelper.updateNodeSchema(this, operId);
        }
    }

    public void deleteFieldAttributes(String operId) {
        SchemaHelper.deleteFieldAttributes(this.getObjectId(), operId);
    }

    public void recoverFieldAttributes(String operId) {
        SchemaHelper.recoverFieldAttributes(this.getObjectId(), operId);
    }
}
