package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.alibaba.fastjson.JSONArray;
import com.yatop.lambda.base.model.WfFlowNodeSchema;
import com.yatop.lambda.core.enums.JsonObjectStateEnum;
import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.enums.SchemaStateEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemParameterUtil;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.data.table.field.FieldAttribute;
import com.yatop.lambda.workflow.core.richmodel.data.unstructured.JsonObject;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import com.yatop.lambda.workflow.core.mgr.workflow.node.port.schema.SchemaHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeSchema extends RichModel<WfFlowNodeSchema> {

    private CmptChar cmptChar;
    private JsonObject jsonObject;  //关联JSON对象
    private List<FieldAttribute> fieldAttributes;
    private boolean dirtyFieldAttributes;
    private boolean isSchemaChanged;

    public NodeSchema(WfFlowNodeSchema data, CmptChar cmptChar) {
        this(data, cmptChar, null);
    }

    public NodeSchema(WfFlowNodeSchema data, CmptChar cmptChar, JsonObject jsonObject) {
        super(data);
        this.cmptChar = cmptChar;
        this.jsonObject = jsonObject;
        this.fieldAttributes = null;
        this.dirtyFieldAttributes = false;
        this.isSchemaChanged = false;   //用于标记Schema字段属性信息变化
    }

    @Override
    public void clear() {
        DataUtil.clear(jsonObject);
        jsonObject = null;
        CollectionUtil.enhancedClear(fieldAttributes);
        fieldAttributes = null;
        super.clear();
    }

    public CmptChar getCmptChar() {
        return cmptChar;
    }

    private JsonObject getJsonObject() {
        if(DataUtil.isNull(jsonObject)) {
            jsonObject = SchemaHelper.queryFieldAttributes(this.data().getObjectId());
            if(DataUtil.isNull(jsonObject)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- json object data missing.", "节点数据输出端口schema信息错误", this);
            }
        }
        return jsonObject;
    }

    public List<FieldAttribute> getFieldAttributes() {
        if(this.data().getSchemaState() != SchemaStateEnum.NORMAL.getState()) {
            return null;
        }

        if(DataUtil.isEmpty(fieldAttributes)) {
            if (getJsonObject().data().getObjectState() == JsonObjectStateEnum.NORMAL.getState()) {
                fieldAttributes = JSONArray.parseArray(getJsonObject().data().getObjectContent(), FieldAttribute.class);
            }
            if(DataUtil.isEmpty(fieldAttributes)){
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- get empty field attribute list.", "节点数据输出端口schema信息错误", this);
            }
        }
        return fieldAttributes;
    }

    private void clearFieldAttributes(SchemaStateEnum schemaStateEnum) {
        if(this.isStateNormal()) {
            CollectionUtil.enhancedClear(this.fieldAttributes);
            this.fieldAttributes = null;
            this.isSchemaChanged = true;
            this.dirtyFieldAttributes = false;  //schema非normal状态不更新JsonObject，仅更新schema状态
        }
        this.changeSchemaState(schemaStateEnum);
    }

    public void setFieldAttributes(List<FieldAttribute> fieldAttributes) {

        if(DataUtil.isEmpty(fieldAttributes)) {
            throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Data output port schema info error -- input empty field attribute list.", "节点数据输出端口schema信息错误");
        }

        if(this.isStateNormal()) {
            if(fieldAttributes.size() > SystemParameterUtil.find4Integer(SystemParameterEnum.WK_FLOW_SCHEMA_MAX_FIELDS, 512)) {
                this.changeState2OverloadInterrupt();
                this.fieldAttributes = null;
                this.isSchemaChanged = true;
                this.dirtyFieldAttributes = false;  //schema非normal状态不更新JsonObject，仅更新schema状态
            }
            else if(!CollectionUtil.equals(this.getFieldAttributes(), fieldAttributes)) {
                CollectionUtil.enhancedClear(this.fieldAttributes);
                this.fieldAttributes = fieldAttributes;
                this.isSchemaChanged = true;
                this.dirtyFieldAttributes = true;
            }
        } else {
            if(fieldAttributes.size() > SystemParameterUtil.find4Integer(SystemParameterEnum.WK_FLOW_SCHEMA_MAX_FIELDS, 512)) {
                this.changeState2OverloadInterrupt();
                return;
            }
            this.fieldAttributes = fieldAttributes;
            this.isSchemaChanged = true;
            this.dirtyFieldAttributes = true;
            this.changeSchemaState(SchemaStateEnum.NORMAL);
        }
    }

    public boolean isStateEmpty() {
        return this.data().getSchemaState() == SchemaStateEnum.EMPTY.getState();
    }

    public boolean isStateNormal() {
        return this.data().getSchemaState() == SchemaStateEnum.NORMAL.getState();
    }

    public boolean isStateNotSupport() {
        return this.data().getSchemaState() == SchemaStateEnum.NOT_SUPPORT.getState();
    }

    public boolean isStateOverloadInterrupt() {
        return this.data().getSchemaState() == SchemaStateEnum.OVERLOAD_INTERRUPT.getState();
    }

    public boolean isSchemaChanged() {
        return isSchemaChanged;
    }

    public void changeState2Empty() {
        this.clearFieldAttributes(SchemaStateEnum.EMPTY);
    }

    public void changeState2NotSupport() {
        this.clearFieldAttributes(SchemaStateEnum.NOT_SUPPORT);
    }

    private void changeState2OverloadInterrupt() {
        this.clearFieldAttributes(SchemaStateEnum.OVERLOAD_INTERRUPT);
    }

    private void changeSchemaState(SchemaStateEnum stateEnum) {
        if(this.data().getSchemaState() == stateEnum.getState())
            return;

        if(this.data().getSchemaState() == SchemaStateEnum.NOT_SUPPORT.getState() && stateEnum == SchemaStateEnum.EMPTY)
            return;

        this.data().setSchemaState(stateEnum.getState());
    }

    protected void flush(String operId) {
        if(dirtyFieldAttributes) {
            getJsonObject().data().setObjectContent(DataUtil.isNotEmpty(fieldAttributes) ? JSONArray.toJSONString(fieldAttributes) : null);
            SchemaHelper.updateFieldAttributes(getJsonObject(), operId);
            dirtyFieldAttributes = false;
        }

        if(this.isColoured()) {
            SchemaHelper.updateNodeSchema(this, operId);
        }
    }

    public void deleteFieldAttributes(String operId) {
        SchemaHelper.deleteFieldAttributes(this.data().getObjectId(), operId);
    }

    public void recoverFieldAttributes(String operId) {
        SchemaHelper.recoverFieldAttributes(this.data().getObjectId(), operId);
    }
}
