package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodePort;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.framework.chartype.ICharTypeClazz;
import com.yatop.lambda.workflow.core.richmodel.RichModel;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharType;
import com.yatop.lambda.workflow.core.richmodel.workflow.module.ModulePort;

public class NodePortOutput extends RichModel<WfFlowNodePort> {

    private ModulePort modulePort;
    private NodeSchema schema;
    private boolean analyzed;

    public NodePortOutput(WfFlowNodePort data, ModulePort modulePort) {
        super(data);
        this.modulePort = modulePort;
        this.analyzed = false;
    }

    @Override
    public void clear() {
        modulePort = null;
        DataUtil.clear(schema);
        schema = null;
        super.clear();
    }

    protected void flush(String operId) {
        if (this.isDataTablePort() && DataUtil.isNotNull(schema)) {
            schema.flush(operId);
        }
    }

    public ModulePort getModulePort() {
        return modulePort;
    }

    public CmptChar getCmptChar() {
        return modulePort.getCmptChar();
    }

    public boolean isDataTablePort() {
        return modulePort.isDataTablePort();
    }

    public NodeSchema getSchema() {
        return schema;
    }

    public void setSchema(NodeSchema schema) {
        this.schema = schema;
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    protected void markAnalyzed() {
        this.analyzed = true;
    }

    public CmptCharType getType() {
        return this.getCmptChar().getType();
    }

    public boolean matchTargetInputPort(NodePortInput dstNodePort) {
        return this.getType().matchTargetType(dstNodePort.getType());
    }

    public boolean isSchemaChanged() {
        return isDataTablePort() && getSchema().isSchemaChanged();
    }

    public ICharTypeClazz getCharTypeClazzBean() {
        return this.getCmptChar().getCharTypeClazzBean();
    }
}
